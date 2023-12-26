package com.yanzhenjie.andserver.http.multipart;

import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.RequestWrapper;
import com.yanzhenjie.andserver.util.LinkedMultiValueMap;
import com.yanzhenjie.andserver.util.MultiValueMap;
import com.yanzhenjie.andserver.util.StringUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StandardMultipartRequest extends RequestWrapper implements MultipartRequest {
    private Map<String, String> mMultipartContentTypes;
    private MultiValueMap<String, MultipartFile> mMultipartFiles;
    private MultiValueMap<String, String> mMultipartParameters;
    private HttpRequest mRequest;

    public StandardMultipartRequest(HttpRequest httpRequest, MultiValueMap<String, MultipartFile> multiValueMap, MultiValueMap<String, String> multiValueMap2, Map<String, String> map) {
        super(httpRequest);
        this.mRequest = httpRequest;
        this.mMultipartFiles = new LinkedMultiValueMap(Collections.unmodifiableMap(multiValueMap));
        this.mMultipartParameters = new LinkedMultiValueMap(Collections.unmodifiableMap(multiValueMap2));
        this.mMultipartContentTypes = Collections.unmodifiableMap(map);
    }

    public Iterator<String> getFileNames() {
        return this.mMultipartFiles.keySet().iterator();
    }

    public MultipartFile getFile(String str) {
        return this.mMultipartFiles.getFirst(str);
    }

    public List<MultipartFile> getFiles(String str) {
        List<MultipartFile> list = (List) this.mMultipartFiles.get(str);
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public Map<String, MultipartFile> getFileMap() {
        return this.mMultipartFiles.toSingleValueMap();
    }

    public MultiValueMap<String, MultipartFile> getMultiFileMap() {
        return this.mMultipartFiles;
    }

    public String getMultipartContentType(String str) {
        MultipartFile file = getFile(str);
        return file == null ? this.mMultipartContentTypes.get(str) : file.getContentType().getType();
    }

    public List<String> getParameterNames() {
        if (this.mMultipartParameters.isEmpty()) {
            return this.mRequest.getParameterNames();
        }
        LinkedList linkedList = new LinkedList();
        List<String> parameterNames = this.mRequest.getParameterNames();
        if (!parameterNames.isEmpty()) {
            linkedList.addAll(parameterNames);
        }
        linkedList.addAll(this.mMultipartParameters.keySet());
        return linkedList;
    }

    public String getParameter(String str) {
        String first = this.mMultipartParameters.getFirst(str);
        return StringUtils.isEmpty(first) ? this.mRequest.getParameter(str) : first;
    }

    public List<String> getParameters(String str) {
        List<String> list = (List) this.mMultipartParameters.get(str);
        return list == null ? this.mRequest.getParameters(str) : list;
    }

    public MultiValueMap<String, String> getParameter() {
        return this.mMultipartParameters.isEmpty() ? this.mRequest.getParameter() : this.mMultipartParameters;
    }
}
