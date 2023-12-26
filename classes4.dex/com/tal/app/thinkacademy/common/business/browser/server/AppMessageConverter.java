package com.tal.app.thinkacademy.common.business.browser.server;

import com.yanzhenjie.andserver.framework.MessageConverter;
import com.yanzhenjie.andserver.framework.body.JsonBody;
import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.IOUtils;
import com.yanzhenjie.andserver.util.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class AppMessageConverter implements MessageConverter {
    public ResponseBody convert(Object obj, MediaType mediaType) {
        return new JsonBody(JsonUtils.successfulJson(obj));
    }

    public <T> T convert(InputStream inputStream, MediaType mediaType, Type type) throws IOException {
        Charset charset = mediaType == null ? null : mediaType.getCharset();
        if (charset == null) {
            return JsonUtils.parseJson(IOUtils.toString(inputStream), type);
        }
        return JsonUtils.parseJson(IOUtils.toString(inputStream, charset), type);
    }
}
