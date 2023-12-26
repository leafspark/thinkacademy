package com.yanzhenjie.andserver.framework.handler;

import com.yanzhenjie.andserver.framework.mapping.Addition;
import com.yanzhenjie.andserver.framework.mapping.Mapping;

public interface MethodHandler extends RequestHandler {
    Addition getAddition();

    Mapping getMapping();

    boolean isRest();
}
