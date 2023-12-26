package com.yanzhenjie.andserver.framework;

import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public interface MessageConverter {
    ResponseBody convert(Object obj, MediaType mediaType);

    <T> T convert(InputStream inputStream, MediaType mediaType, Type type) throws IOException;
}
