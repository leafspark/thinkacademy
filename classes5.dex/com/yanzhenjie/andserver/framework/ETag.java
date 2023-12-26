package com.yanzhenjie.andserver.framework;

import com.yanzhenjie.andserver.http.HttpRequest;

public interface ETag {
    String getETag(HttpRequest httpRequest) throws Throwable;
}
