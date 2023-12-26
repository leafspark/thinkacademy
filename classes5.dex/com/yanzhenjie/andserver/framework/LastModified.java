package com.yanzhenjie.andserver.framework;

import com.yanzhenjie.andserver.http.HttpRequest;

public interface LastModified {
    long getLastModified(HttpRequest httpRequest) throws Throwable;
}
