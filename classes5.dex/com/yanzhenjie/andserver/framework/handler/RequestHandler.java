package com.yanzhenjie.andserver.framework.handler;

import com.yanzhenjie.andserver.framework.ETag;
import com.yanzhenjie.andserver.framework.LastModified;
import com.yanzhenjie.andserver.framework.view.View;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

public interface RequestHandler extends ETag, LastModified {
    View handle(HttpRequest httpRequest, HttpResponse httpResponse) throws Throwable;
}
