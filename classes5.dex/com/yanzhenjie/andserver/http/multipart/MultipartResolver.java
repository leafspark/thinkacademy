package com.yanzhenjie.andserver.http.multipart;

import com.yanzhenjie.andserver.error.MultipartException;
import com.yanzhenjie.andserver.http.HttpRequest;
import java.io.File;

public interface MultipartResolver {
    void cleanupMultipart(MultipartRequest multipartRequest);

    boolean isMultipart(HttpRequest httpRequest);

    MultipartRequest resolveMultipart(HttpRequest httpRequest) throws MultipartException;

    void setAllFileMaxSize(long j);

    void setFileMaxSize(long j);

    void setMaxInMemorySize(int i);

    void setUploadTempDir(File file);
}
