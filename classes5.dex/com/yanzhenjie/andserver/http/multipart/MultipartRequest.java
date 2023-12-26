package com.yanzhenjie.andserver.http.multipart;

import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.util.MultiValueMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface MultipartRequest extends HttpRequest {
    MultipartFile getFile(String str);

    Map<String, MultipartFile> getFileMap();

    Iterator<String> getFileNames();

    List<MultipartFile> getFiles(String str);

    MultiValueMap<String, MultipartFile> getMultiFileMap();

    String getMultipartContentType(String str);
}
