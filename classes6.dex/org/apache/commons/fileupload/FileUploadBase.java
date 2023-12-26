package org.apache.commons.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.MultipartStream;
import org.apache.commons.fileupload.util.Closeable;
import org.apache.commons.fileupload.util.FileItemHeadersImpl;
import org.apache.commons.fileupload.util.Streams;

public abstract class FileUploadBase {
    public static final String ATTACHMENT = "attachment";
    public static final String CONTENT_DISPOSITION = "Content-disposition";
    public static final String CONTENT_LENGTH = "Content-length";
    public static final String CONTENT_TYPE = "Content-type";
    public static final String FORM_DATA = "form-data";
    @Deprecated
    public static final int MAX_HEADER_SIZE = 1024;
    public static final String MULTIPART = "multipart/";
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    public static final String MULTIPART_MIXED = "multipart/mixed";
    /* access modifiers changed from: private */
    public long fileSizeMax = -1;
    /* access modifiers changed from: private */
    public String headerEncoding;
    /* access modifiers changed from: private */
    public ProgressListener listener;
    /* access modifiers changed from: private */
    public long sizeMax = -1;

    public abstract FileItemFactory getFileItemFactory();

    public abstract void setFileItemFactory(FileItemFactory fileItemFactory);

    public static final boolean isMultipartContent(RequestContext requestContext) {
        String contentType = requestContext.getContentType();
        if (contentType != null && contentType.toLowerCase(Locale.ENGLISH).startsWith(MULTIPART)) {
            return true;
        }
        return false;
    }

    public long getSizeMax() {
        return this.sizeMax;
    }

    public void setSizeMax(long j) {
        this.sizeMax = j;
    }

    public long getFileSizeMax() {
        return this.fileSizeMax;
    }

    public void setFileSizeMax(long j) {
        this.fileSizeMax = j;
    }

    public String getHeaderEncoding() {
        return this.headerEncoding;
    }

    public void setHeaderEncoding(String str) {
        this.headerEncoding = str;
    }

    public FileItemIterator getItemIterator(RequestContext requestContext) throws FileUploadException, IOException {
        try {
            return new FileItemIteratorImpl(this, requestContext);
        } catch (FileUploadIOException e) {
            throw ((FileUploadException) e.getCause());
        }
    }

    public List<FileItem> parseRequest(RequestContext requestContext) throws FileUploadException {
        ArrayList<FileItem> arrayList = new ArrayList<>();
        try {
            FileItemIterator itemIterator = getItemIterator(requestContext);
            FileItemFactory fileItemFactory = getFileItemFactory();
            if (fileItemFactory != null) {
                while (itemIterator.hasNext()) {
                    FileItemStream next = itemIterator.next();
                    FileItem createItem = fileItemFactory.createItem(next.getFieldName(), next.getContentType(), next.isFormField(), ((FileItemIteratorImpl.FileItemStreamImpl) next).name);
                    arrayList.add(createItem);
                    Streams.copy(next.openStream(), createItem.getOutputStream(), true);
                    createItem.setHeaders(next.getHeaders());
                }
                return arrayList;
            }
            throw new NullPointerException("No FileItemFactory has been set.");
        } catch (FileUploadIOException e) {
            throw ((FileUploadException) e.getCause());
        } catch (IOException e2) {
            throw new IOFileUploadException(String.format("Processing of %s request failed. %s", new Object[]{MULTIPART_FORM_DATA, e2.getMessage()}), e2);
        } catch (FileUploadIOException e3) {
            throw ((FileUploadException) e3.getCause());
        } catch (IOException e4) {
            try {
                throw new FileUploadException(e4.getMessage(), e4);
            } catch (Throwable th) {
                for (FileItem delete : arrayList) {
                    try {
                        delete.delete();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        }
    }

    public Map<String, List<FileItem>> parseParameterMap(RequestContext requestContext) throws FileUploadException {
        List<FileItem> parseRequest = parseRequest(requestContext);
        HashMap hashMap = new HashMap(parseRequest.size());
        for (FileItem next : parseRequest) {
            String fieldName = next.getFieldName();
            List list = (List) hashMap.get(fieldName);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(fieldName, list);
            }
            list.add(next);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public byte[] getBoundary(String str) {
        ParameterParser parameterParser = new ParameterParser();
        parameterParser.setLowerCaseNames(true);
        String str2 = parameterParser.parse(str, new char[]{';', ','}).get("boundary");
        if (str2 == null) {
            return null;
        }
        try {
            return str2.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return str2.getBytes();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String getFileName(Map<String, String> map) {
        return getFileName(getHeader(map, CONTENT_DISPOSITION));
    }

    /* access modifiers changed from: protected */
    public String getFileName(FileItemHeaders fileItemHeaders) {
        return getFileName(fileItemHeaders.getHeader(CONTENT_DISPOSITION));
    }

    private String getFileName(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (lowerCase.startsWith(FORM_DATA) || lowerCase.startsWith(ATTACHMENT)) {
                ParameterParser parameterParser = new ParameterParser();
                parameterParser.setLowerCaseNames(true);
                Map<String, String> parse = parameterParser.parse(str, ';');
                if (parse.containsKey("filename")) {
                    String str2 = parse.get("filename");
                    return str2 != null ? str2.trim() : "";
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String getFieldName(FileItemHeaders fileItemHeaders) {
        return getFieldName(fileItemHeaders.getHeader(CONTENT_DISPOSITION));
    }

    private String getFieldName(String str) {
        if (str == null || !str.toLowerCase(Locale.ENGLISH).startsWith(FORM_DATA)) {
            return null;
        }
        ParameterParser parameterParser = new ParameterParser();
        parameterParser.setLowerCaseNames(true);
        String str2 = parameterParser.parse(str, ';').get("name");
        return str2 != null ? str2.trim() : str2;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String getFieldName(Map<String, String> map) {
        return getFieldName(getHeader(map, CONTENT_DISPOSITION));
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public FileItem createItem(Map<String, String> map, boolean z) throws FileUploadException {
        return getFileItemFactory().createItem(getFieldName(map), getHeader(map, CONTENT_TYPE), z, getFileName(map));
    }

    /* access modifiers changed from: protected */
    public FileItemHeaders getParsedHeaders(String str) {
        int length = str.length();
        FileItemHeadersImpl newFileItemHeaders = newFileItemHeaders();
        int i = 0;
        while (true) {
            int parseEndOfLine = parseEndOfLine(str, i);
            if (i == parseEndOfLine) {
                return newFileItemHeaders;
            }
            StringBuilder sb = new StringBuilder(str.substring(i, parseEndOfLine));
            i = parseEndOfLine + 2;
            while (i < length) {
                int i2 = i;
                while (i2 < length) {
                    char charAt = str.charAt(i2);
                    if (charAt != ' ' && charAt != 9) {
                        break;
                    }
                    i2++;
                }
                if (i2 == i) {
                    break;
                }
                int parseEndOfLine2 = parseEndOfLine(str, i2);
                sb.append(" ");
                sb.append(str.substring(i2, parseEndOfLine2));
                i = parseEndOfLine2 + 2;
            }
            parseHeaderLine(newFileItemHeaders, sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public FileItemHeadersImpl newFileItemHeaders() {
        return new FileItemHeadersImpl();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Map<String, String> parseHeaders(String str) {
        FileItemHeaders parsedHeaders = getParsedHeaders(str);
        HashMap hashMap = new HashMap();
        Iterator<String> headerNames = parsedHeaders.getHeaderNames();
        while (headerNames.hasNext()) {
            String next = headerNames.next();
            Iterator<String> headers = parsedHeaders.getHeaders(next);
            StringBuilder sb = new StringBuilder(headers.next());
            while (headers.hasNext()) {
                sb.append(",");
                sb.append(headers.next());
            }
            hashMap.put(next, sb.toString());
        }
        return hashMap;
    }

    private int parseEndOfLine(String str, int i) {
        int i2;
        while (true) {
            int indexOf = str.indexOf(13, i);
            if (indexOf != -1 && (i2 = indexOf + 1) < str.length()) {
                if (str.charAt(i2) == 10) {
                    return indexOf;
                }
                i = i2;
            }
        }
        throw new IllegalStateException("Expected headers to be terminated by an empty line.");
    }

    private void parseHeaderLine(FileItemHeadersImpl fileItemHeadersImpl, String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            fileItemHeadersImpl.addHeader(str.substring(0, indexOf).trim(), str.substring(str.indexOf(58) + 1).trim());
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public final String getHeader(Map<String, String> map, String str) {
        return map.get(str.toLowerCase(Locale.ENGLISH));
    }

    private class FileItemIteratorImpl implements FileItemIterator {
        private final byte[] boundary;
        private String currentFieldName;
        private FileItemStreamImpl currentItem;
        private boolean eof;
        private boolean itemValid;
        /* access modifiers changed from: private */
        public final MultipartStream multi;
        private final MultipartStream.ProgressNotifier notifier;
        private boolean skipPreamble;
        final /* synthetic */ FileUploadBase this$0;

        class FileItemStreamImpl implements FileItemStream {
            private final String contentType;
            /* access modifiers changed from: private */
            public final String fieldName;
            private final boolean formField;
            private FileItemHeaders headers;
            /* access modifiers changed from: private */
            public final String name;
            private boolean opened;
            private final InputStream stream;
            final /* synthetic */ FileItemIteratorImpl this$1;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: org.apache.commons.fileupload.MultipartStream$ItemInputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: org.apache.commons.fileupload.MultipartStream$ItemInputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$FileItemStreamImpl$1} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: org.apache.commons.fileupload.MultipartStream$ItemInputStream} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            FileItemStreamImpl(org.apache.commons.fileupload.FileUploadBase.FileItemIteratorImpl r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, boolean r19, long r20) throws java.io.IOException {
                /*
                    r14 = this;
                    r7 = r14
                    r5 = r15
                    r0 = r16
                    r1 = r17
                    r7.this$1 = r5
                    r14.<init>()
                    r7.name = r0
                    r7.fieldName = r1
                    r2 = r18
                    r7.contentType = r2
                    r2 = r19
                    r7.formField = r2
                    org.apache.commons.fileupload.FileUploadBase r2 = r5.this$0
                    long r2 = r2.fileSizeMax
                    r8 = -1
                    int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                    if (r2 == 0) goto L_0x0065
                    int r2 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
                    if (r2 == 0) goto L_0x0065
                    org.apache.commons.fileupload.FileUploadBase r2 = r5.this$0
                    long r2 = r2.fileSizeMax
                    int r2 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
                    if (r2 > 0) goto L_0x0032
                    goto L_0x0065
                L_0x0032:
                    org.apache.commons.fileupload.FileUploadBase$FileSizeLimitExceededException r2 = new org.apache.commons.fileupload.FileUploadBase$FileSizeLimitExceededException
                    r3 = 2
                    java.lang.Object[] r3 = new java.lang.Object[r3]
                    r4 = 0
                    r3[r4] = r1
                    r4 = 1
                    org.apache.commons.fileupload.FileUploadBase r6 = r5.this$0
                    long r8 = r6.fileSizeMax
                    java.lang.Long r6 = java.lang.Long.valueOf(r8)
                    r3[r4] = r6
                    java.lang.String r4 = "The field %s exceeds its maximum permitted size of %s bytes."
                    java.lang.String r9 = java.lang.String.format(r4, r3)
                    org.apache.commons.fileupload.FileUploadBase r3 = r5.this$0
                    long r12 = r3.fileSizeMax
                    r8 = r2
                    r10 = r20
                    r8.<init>(r9, r10, r12)
                    r2.setFileName(r0)
                    r2.setFieldName(r1)
                    org.apache.commons.fileupload.FileUploadBase$FileUploadIOException r0 = new org.apache.commons.fileupload.FileUploadBase$FileUploadIOException
                    r0.<init>(r2)
                    throw r0
                L_0x0065:
                    org.apache.commons.fileupload.MultipartStream r0 = r15.multi
                    org.apache.commons.fileupload.MultipartStream$ItemInputStream r6 = r0.newInputStream()
                    org.apache.commons.fileupload.FileUploadBase r0 = r5.this$0
                    long r0 = r0.fileSizeMax
                    int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                    if (r0 == 0) goto L_0x0087
                    org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$FileItemStreamImpl$1 r8 = new org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$FileItemStreamImpl$1
                    org.apache.commons.fileupload.FileUploadBase r0 = r5.this$0
                    long r3 = r0.fileSizeMax
                    r0 = r8
                    r1 = r14
                    r2 = r6
                    r5 = r15
                    r0.<init>(r2, r3, r5, r6)
                    r6 = r8
                L_0x0087:
                    r7.stream = r6
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.fileupload.FileUploadBase.FileItemIteratorImpl.FileItemStreamImpl.<init>(org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl, java.lang.String, java.lang.String, java.lang.String, boolean, long):void");
            }

            public String getContentType() {
                return this.contentType;
            }

            public String getFieldName() {
                return this.fieldName;
            }

            public String getName() {
                return Streams.checkFileName(this.name);
            }

            public boolean isFormField() {
                return this.formField;
            }

            public InputStream openStream() throws IOException {
                if (this.opened) {
                    throw new IllegalStateException("The stream was already opened.");
                } else if (!((Closeable) this.stream).isClosed()) {
                    return this.stream;
                } else {
                    throw new FileItemStream.ItemSkippedException();
                }
            }

            /* access modifiers changed from: package-private */
            public void close() throws IOException {
                this.stream.close();
            }

            public FileItemHeaders getHeaders() {
                return this.headers;
            }

            public void setHeaders(FileItemHeaders fileItemHeaders) {
                this.headers = fileItemHeaders;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$1} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$1} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$1} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        FileItemIteratorImpl(org.apache.commons.fileupload.FileUploadBase r19, org.apache.commons.fileupload.RequestContext r20) throws org.apache.commons.fileupload.FileUploadException, java.io.IOException {
            /*
                r18 = this;
                r7 = r18
                r0 = r19
                r8 = r20
                r7.this$0 = r0
                r18.<init>()
                java.lang.String r1 = "ctx parameter"
                java.util.Objects.requireNonNull(r8, r1)
                java.lang.String r9 = r20.getContentType()
                r1 = 2
                r10 = 0
                r11 = 1
                if (r9 == 0) goto L_0x00e2
                java.util.Locale r2 = java.util.Locale.ENGLISH
                java.lang.String r2 = r9.toLowerCase(r2)
                java.lang.String r3 = "multipart/"
                boolean r2 = r2.startsWith(r3)
                if (r2 == 0) goto L_0x00e2
                int r2 = r20.getContentLength()
                java.lang.Class<org.apache.commons.fileupload.UploadContext> r3 = org.apache.commons.fileupload.UploadContext.class
                java.lang.Class r4 = r20.getClass()
                boolean r3 = r3.isAssignableFrom(r4)
                if (r3 == 0) goto L_0x003f
                r2 = r8
                org.apache.commons.fileupload.UploadContext r2 = (org.apache.commons.fileupload.UploadContext) r2
                long r2 = r2.contentLength()
                goto L_0x0040
            L_0x003f:
                long r2 = (long) r2
            L_0x0040:
                r14 = r2
                long r2 = r19.sizeMax
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x0090
                r2 = -1
                int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
                if (r2 == 0) goto L_0x007d
                long r2 = r19.sizeMax
                int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
                if (r2 > 0) goto L_0x005a
                goto L_0x007d
            L_0x005a:
                org.apache.commons.fileupload.FileUploadBase$SizeLimitExceededException r2 = new org.apache.commons.fileupload.FileUploadBase$SizeLimitExceededException
                java.lang.Object[] r1 = new java.lang.Object[r1]
                java.lang.Long r3 = java.lang.Long.valueOf(r14)
                r1[r10] = r3
                long r3 = r19.sizeMax
                java.lang.Long r3 = java.lang.Long.valueOf(r3)
                r1[r11] = r3
                java.lang.String r3 = "the request was rejected because its size (%s) exceeds the configured maximum (%s)"
                java.lang.String r13 = java.lang.String.format(r3, r1)
                long r16 = r19.sizeMax
                r12 = r2
                r12.<init>(r13, r14, r16)
                throw r2
            L_0x007d:
                org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$1 r12 = new org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$1
                java.io.InputStream r3 = r20.getInputStream()
                long r4 = r19.sizeMax
                r1 = r12
                r2 = r18
                r6 = r19
                r1.<init>(r3, r4, r6)
                goto L_0x0094
            L_0x0090:
                java.io.InputStream r12 = r20.getInputStream()
            L_0x0094:
                java.lang.String r1 = r19.headerEncoding
                if (r1 != 0) goto L_0x009e
                java.lang.String r1 = r20.getCharacterEncoding()
            L_0x009e:
                byte[] r2 = r0.getBoundary(r9)
                r7.boundary = r2
                if (r2 == 0) goto L_0x00d7
                org.apache.commons.fileupload.MultipartStream$ProgressNotifier r3 = new org.apache.commons.fileupload.MultipartStream$ProgressNotifier
                org.apache.commons.fileupload.ProgressListener r0 = r19.listener
                r3.<init>(r0, r14)
                r7.notifier = r3
                org.apache.commons.fileupload.MultipartStream r0 = new org.apache.commons.fileupload.MultipartStream     // Catch:{ IllegalArgumentException -> 0x00c1 }
                r0.<init>((java.io.InputStream) r12, (byte[]) r2, (org.apache.commons.fileupload.MultipartStream.ProgressNotifier) r3)     // Catch:{ IllegalArgumentException -> 0x00c1 }
                r7.multi = r0     // Catch:{ IllegalArgumentException -> 0x00c1 }
                r0.setHeaderEncoding(r1)
                r7.skipPreamble = r11
                r18.findNextItem()
                return
            L_0x00c1:
                r0 = move-exception
                org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r12)
                org.apache.commons.fileupload.FileUploadBase$InvalidContentTypeException r1 = new org.apache.commons.fileupload.FileUploadBase$InvalidContentTypeException
                java.lang.Object[] r2 = new java.lang.Object[r11]
                java.lang.String r3 = "Content-type"
                r2[r10] = r3
                java.lang.String r3 = "The boundary specified in the %s header is too long"
                java.lang.String r2 = java.lang.String.format(r3, r2)
                r1.<init>(r2, r0)
                throw r1
            L_0x00d7:
                org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r12)
                org.apache.commons.fileupload.FileUploadException r0 = new org.apache.commons.fileupload.FileUploadException
                java.lang.String r1 = "the request was rejected because no multipart boundary was found"
                r0.<init>(r1)
                throw r0
            L_0x00e2:
                org.apache.commons.fileupload.FileUploadBase$InvalidContentTypeException r0 = new org.apache.commons.fileupload.FileUploadBase$InvalidContentTypeException
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r3 = "multipart/form-data"
                r2[r10] = r3
                java.lang.String r3 = "multipart/mixed"
                r2[r11] = r3
                r2[r1] = r9
                java.lang.String r1 = "the request doesn't contain a %s or %s stream, content type header is %s"
                java.lang.String r1 = java.lang.String.format(r1, r2)
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.fileupload.FileUploadBase.FileItemIteratorImpl.<init>(org.apache.commons.fileupload.FileUploadBase, org.apache.commons.fileupload.RequestContext):void");
        }

        private boolean findNextItem() throws IOException {
            boolean z;
            FileItemHeaders parsedHeaders;
            String fieldName;
            if (this.eof) {
                return false;
            }
            FileItemStreamImpl fileItemStreamImpl = this.currentItem;
            if (fileItemStreamImpl != null) {
                fileItemStreamImpl.close();
                this.currentItem = null;
            }
            while (true) {
                if (this.skipPreamble) {
                    z = this.multi.skipPreamble();
                } else {
                    z = this.multi.readBoundary();
                }
                if (z) {
                    parsedHeaders = this.this$0.getParsedHeaders(this.multi.readHeaders());
                    if (this.currentFieldName == null) {
                        fieldName = this.this$0.getFieldName(parsedHeaders);
                        if (fieldName != null) {
                            String header = parsedHeaders.getHeader(FileUploadBase.CONTENT_TYPE);
                            if (header == null || !header.toLowerCase(Locale.ENGLISH).startsWith(FileUploadBase.MULTIPART_MIXED)) {
                                String fileName = this.this$0.getFileName(parsedHeaders);
                            } else {
                                this.currentFieldName = fieldName;
                                this.multi.setBoundary(this.this$0.getBoundary(header));
                                this.skipPreamble = true;
                            }
                        }
                    } else {
                        String fileName2 = this.this$0.getFileName(parsedHeaders);
                        if (fileName2 != null) {
                            FileItemStreamImpl fileItemStreamImpl2 = new FileItemStreamImpl(this, fileName2, this.currentFieldName, parsedHeaders.getHeader(FileUploadBase.CONTENT_TYPE), false, getContentLength(parsedHeaders));
                            this.currentItem = fileItemStreamImpl2;
                            fileItemStreamImpl2.setHeaders(parsedHeaders);
                            this.notifier.noteItem();
                            this.itemValid = true;
                            return true;
                        }
                    }
                    this.multi.discardBodyData();
                } else if (this.currentFieldName == null) {
                    this.eof = true;
                    return false;
                } else {
                    this.multi.setBoundary(this.boundary);
                    this.currentFieldName = null;
                }
            }
            String fileName3 = this.this$0.getFileName(parsedHeaders);
            FileItemStreamImpl fileItemStreamImpl3 = new FileItemStreamImpl(this, fileName3, fieldName, parsedHeaders.getHeader(FileUploadBase.CONTENT_TYPE), fileName3 == null, getContentLength(parsedHeaders));
            this.currentItem = fileItemStreamImpl3;
            fileItemStreamImpl3.setHeaders(parsedHeaders);
            this.notifier.noteItem();
            this.itemValid = true;
            return true;
        }

        private long getContentLength(FileItemHeaders fileItemHeaders) {
            try {
                return Long.parseLong(fileItemHeaders.getHeader(FileUploadBase.CONTENT_LENGTH));
            } catch (Exception unused) {
                return -1;
            }
        }

        public boolean hasNext() throws FileUploadException, IOException {
            if (this.eof) {
                return false;
            }
            if (this.itemValid) {
                return true;
            }
            try {
                return findNextItem();
            } catch (FileUploadIOException e) {
                throw ((FileUploadException) e.getCause());
            }
        }

        public FileItemStream next() throws FileUploadException, IOException {
            if (this.eof || (!this.itemValid && !hasNext())) {
                throw new NoSuchElementException();
            }
            this.itemValid = false;
            return this.currentItem;
        }
    }

    public static class FileUploadIOException extends IOException {
        private static final long serialVersionUID = -7047616958165584154L;
        private final FileUploadException cause;

        public FileUploadIOException(FileUploadException fileUploadException) {
            this.cause = fileUploadException;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    public static class InvalidContentTypeException extends FileUploadException {
        private static final long serialVersionUID = -9073026332015646668L;

        public InvalidContentTypeException() {
        }

        public InvalidContentTypeException(String str) {
            super(str);
        }

        public InvalidContentTypeException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class IOFileUploadException extends FileUploadException {
        private static final long serialVersionUID = 1749796615868477269L;
        private final IOException cause;

        public IOFileUploadException(String str, IOException iOException) {
            super(str);
            this.cause = iOException;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    protected static abstract class SizeException extends FileUploadException {
        private static final long serialVersionUID = -8776225574705254126L;
        private final long actual;
        private final long permitted;

        protected SizeException(String str, long j, long j2) {
            super(str);
            this.actual = j;
            this.permitted = j2;
        }

        public long getActualSize() {
            return this.actual;
        }

        public long getPermittedSize() {
            return this.permitted;
        }
    }

    @Deprecated
    public static class UnknownSizeException extends FileUploadException {
        private static final long serialVersionUID = 7062279004812015273L;

        public UnknownSizeException() {
        }

        public UnknownSizeException(String str) {
            super(str);
        }
    }

    public static class SizeLimitExceededException extends SizeException {
        private static final long serialVersionUID = -2474893167098052828L;

        public /* bridge */ /* synthetic */ long getActualSize() {
            return super.getActualSize();
        }

        public /* bridge */ /* synthetic */ long getPermittedSize() {
            return super.getPermittedSize();
        }

        @Deprecated
        public SizeLimitExceededException() {
            this((String) null, 0, 0);
        }

        @Deprecated
        public SizeLimitExceededException(String str) {
            this(str, 0, 0);
        }

        public SizeLimitExceededException(String str, long j, long j2) {
            super(str, j, j2);
        }
    }

    public static class FileSizeLimitExceededException extends SizeException {
        private static final long serialVersionUID = 8150776562029630058L;
        private String fieldName;
        private String fileName;

        public /* bridge */ /* synthetic */ long getActualSize() {
            return super.getActualSize();
        }

        public /* bridge */ /* synthetic */ long getPermittedSize() {
            return super.getPermittedSize();
        }

        public FileSizeLimitExceededException(String str, long j, long j2) {
            super(str, j, j2);
        }

        public String getFileName() {
            return this.fileName;
        }

        public void setFileName(String str) {
            this.fileName = str;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public void setFieldName(String str) {
            this.fieldName = str;
        }
    }

    public ProgressListener getProgressListener() {
        return this.listener;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.listener = progressListener;
    }
}
