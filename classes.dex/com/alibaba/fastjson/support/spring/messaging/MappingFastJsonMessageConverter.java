package com.alibaba.fastjson.support.spring.messaging;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.amazonaws.services.s3.internal.Constants;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;

public class MappingFastJsonMessageConverter extends AbstractMessageConverter {
    private FastJsonConfig fastJsonConfig = new FastJsonConfig();

    /* access modifiers changed from: protected */
    public boolean supports(Class<?> cls) {
        return true;
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig2) {
        this.fastJsonConfig = fastJsonConfig2;
    }

    public MappingFastJsonMessageConverter() {
        super(new MimeType("application", "json", Charset.forName(Constants.DEFAULT_ENCODING)));
    }

    /* access modifiers changed from: protected */
    public boolean canConvertFrom(Message<?> message, Class<?> cls) {
        return supports(cls);
    }

    /* access modifiers changed from: protected */
    public boolean canConvertTo(Object obj, MessageHeaders messageHeaders) {
        return supports(obj.getClass());
    }

    /* access modifiers changed from: protected */
    public Object convertFromInternal(Message<?> message, Class<?> cls, Object obj) {
        Object payload = message.getPayload();
        if (payload instanceof byte[]) {
            return JSON.parseObject((byte[]) payload, this.fastJsonConfig.getCharset(), (Type) cls, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        } else if (!(payload instanceof String)) {
            return null;
        } else {
            return JSON.parseObject((String) payload, (Type) cls, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        }
    }

    /* access modifiers changed from: protected */
    public Object convertToInternal(Object obj, MessageHeaders messageHeaders, Object obj2) {
        if (byte[].class == getSerializedPayloadClass()) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (JSON.isValid(str)) {
                    return str.getBytes(this.fastJsonConfig.getCharset());
                }
            }
            return JSON.toJSONBytes(this.fastJsonConfig.getCharset(), obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
        } else if ((obj instanceof String) && JSON.isValid((String) obj)) {
            return obj;
        } else {
            return JSON.toJSONString(obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
        }
    }
}
