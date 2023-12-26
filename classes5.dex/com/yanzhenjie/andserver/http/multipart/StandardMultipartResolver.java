package com.yanzhenjie.andserver.http.multipart;

import android.util.Log;
import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.error.MaxUploadSizeExceededException;
import com.yanzhenjie.andserver.error.MultipartException;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.RequestBody;
import com.yanzhenjie.andserver.util.Assert;
import com.yanzhenjie.andserver.util.LinkedMultiValueMap;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.MultiValueMap;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.Charsets;

public class StandardMultipartResolver implements MultipartResolver {
    private DiskFileItemFactory mFileItemFactory = new DiskFileItemFactory();
    private FileUpload mFileUpload = new FileUpload(this.mFileItemFactory);

    public void setAllFileMaxSize(long j) {
        this.mFileUpload.setSizeMax(j);
    }

    public void setFileMaxSize(long j) {
        this.mFileUpload.setFileSizeMax(j);
    }

    public void setMaxInMemorySize(int i) {
        this.mFileItemFactory.setSizeThreshold(i);
    }

    public void setUploadTempDir(File file) {
        if (file.exists() || file.mkdirs()) {
            this.mFileItemFactory.setRepository(file);
            return;
        }
        throw new IllegalArgumentException("Given uploadTempDir [" + file + "] could not be created.");
    }

    public boolean isMultipart(HttpRequest httpRequest) {
        RequestBody body;
        if (httpRequest.getMethod().allowBody() && (body = httpRequest.getBody()) != null && FileUploadBase.isMultipartContent(new BodyContext(body))) {
            return true;
        }
        return false;
    }

    public MultipartRequest resolveMultipart(HttpRequest httpRequest) throws MultipartException {
        if (httpRequest instanceof MultipartRequest) {
            return (MultipartRequest) httpRequest;
        }
        MultipartParsingResult parseRequest = parseRequest(httpRequest);
        return new StandardMultipartRequest(httpRequest, parseRequest.getMultipartFiles(), parseRequest.getMultipartParameters(), parseRequest.getMultipartContentTypes());
    }

    public void cleanupMultipart(MultipartRequest multipartRequest) {
        if (multipartRequest != null) {
            try {
                for (List<MultipartFile> it : multipartRequest.getMultiFileMap().values()) {
                    for (MultipartFile multipartFile : it) {
                        if (multipartFile instanceof StandardMultipartFile) {
                            ((StandardMultipartFile) multipartFile).getFileItem().delete();
                        }
                    }
                }
            } catch (Throwable unused) {
                Log.w(AndServer.TAG, "Failed to perform multipart cleanup for servlet request.");
            }
        }
    }

    private MultipartParsingResult parseRequest(HttpRequest httpRequest) throws MultipartException {
        String determineEncoding = determineEncoding(httpRequest);
        FileUpload prepareFileUpload = prepareFileUpload(determineEncoding);
        try {
            RequestBody body = httpRequest.getBody();
            Assert.notNull(body, "The body cannot be null.");
            return parseFileItems(prepareFileUpload.parseRequest(new BodyContext(body)), determineEncoding);
        } catch (FileUploadBase.SizeLimitExceededException e) {
            throw new MaxUploadSizeExceededException(prepareFileUpload.getSizeMax(), e);
        } catch (FileUploadBase.FileSizeLimitExceededException e2) {
            throw new MaxUploadSizeExceededException(prepareFileUpload.getFileSizeMax(), e2);
        } catch (FileUploadException e3) {
            throw new MultipartException("Failed to parse multipart servlet request.", e3);
        }
    }

    private String determineEncoding(HttpRequest httpRequest) {
        MediaType contentType = httpRequest.getContentType();
        if (contentType == null) {
            return Charsets.UTF_8.name();
        }
        Charset charset = contentType.getCharset();
        if (charset == null) {
            charset = Charsets.UTF_8;
        }
        return charset.name();
    }

    private FileUpload prepareFileUpload(String str) {
        FileUpload fileUpload = this.mFileUpload;
        if (str.equalsIgnoreCase(fileUpload.getHeaderEncoding())) {
            return fileUpload;
        }
        FileUpload fileUpload2 = new FileUpload(this.mFileItemFactory);
        fileUpload2.setSizeMax(this.mFileUpload.getSizeMax());
        fileUpload2.setFileSizeMax(this.mFileUpload.getFileSizeMax());
        fileUpload2.setHeaderEncoding(str);
        return fileUpload2;
    }

    /* access modifiers changed from: protected */
    public MultipartParsingResult parseFileItems(List<FileItem> list, String str) {
        String str2;
        LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
        LinkedMultiValueMap linkedMultiValueMap2 = new LinkedMultiValueMap();
        HashMap hashMap = new HashMap();
        for (FileItem next : list) {
            if (next.isFormField()) {
                String determineEncoding = determineEncoding(next.getContentType(), str);
                if (determineEncoding != null) {
                    try {
                        str2 = next.getString(determineEncoding);
                    } catch (UnsupportedEncodingException unused) {
                        str2 = next.getString();
                    }
                } else {
                    str2 = next.getString();
                }
                List list2 = (List) linkedMultiValueMap2.get(next.getFieldName());
                if (list2 == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(str2);
                    linkedMultiValueMap2.put(next.getFieldName(), linkedList);
                } else {
                    list2.add(str2);
                }
                hashMap.put(next.getFieldName(), next.getContentType());
            } else {
                StandardMultipartFile createMultipartFile = createMultipartFile(next);
                linkedMultiValueMap.add(createMultipartFile.getName(), createMultipartFile);
            }
        }
        return new MultipartParsingResult(linkedMultiValueMap, linkedMultiValueMap2, hashMap);
    }

    /* access modifiers changed from: protected */
    public StandardMultipartFile createMultipartFile(FileItem fileItem) {
        return new StandardMultipartFile(fileItem);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r2 = com.yanzhenjie.andserver.util.MediaType.parseMediaType(r2).getCharset();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String determineEncoding(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            boolean r0 = com.yanzhenjie.andserver.util.StringUtils.hasText((java.lang.String) r2)
            if (r0 != 0) goto L_0x0007
            return r3
        L_0x0007:
            com.yanzhenjie.andserver.util.MediaType r2 = com.yanzhenjie.andserver.util.MediaType.parseMediaType(r2)
            java.nio.charset.Charset r2 = r2.getCharset()
            if (r2 == 0) goto L_0x0015
            java.lang.String r3 = r2.name()
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.andserver.http.multipart.StandardMultipartResolver.determineEncoding(java.lang.String, java.lang.String):java.lang.String");
    }

    protected static class MultipartParsingResult {
        private final Map<String, String> multipartContentTypes;
        private final MultiValueMap<String, MultipartFile> multipartFiles;
        private final MultiValueMap<String, String> multipartParameters;

        public MultipartParsingResult(MultiValueMap<String, MultipartFile> multiValueMap, MultiValueMap<String, String> multiValueMap2, Map<String, String> map) {
            this.multipartFiles = multiValueMap;
            this.multipartParameters = multiValueMap2;
            this.multipartContentTypes = map;
        }

        public MultiValueMap<String, MultipartFile> getMultipartFiles() {
            return this.multipartFiles;
        }

        public MultiValueMap<String, String> getMultipartParameters() {
            return this.multipartParameters;
        }

        public Map<String, String> getMultipartContentTypes() {
            return this.multipartContentTypes;
        }
    }
}
