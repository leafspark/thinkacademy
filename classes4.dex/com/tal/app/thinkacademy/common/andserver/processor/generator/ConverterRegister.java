package com.tal.app.thinkacademy.common.andserver.processor.generator;

import android.content.Context;
import com.tal.app.thinkacademy.common.business.browser.server.AppMessageConverter;
import com.yanzhenjie.andserver.framework.MessageConverter;
import com.yanzhenjie.andserver.register.OnRegister;
import com.yanzhenjie.andserver.register.Register;
import java.util.HashMap;
import java.util.Map;

public final class ConverterRegister implements OnRegister {
    private Map<String, MessageConverter> mMap;

    public ConverterRegister() {
        HashMap hashMap = new HashMap();
        this.mMap = hashMap;
        hashMap.put("default", new AppMessageConverter());
    }

    public void onRegister(Context context, String str, Register register) {
        MessageConverter messageConverter = this.mMap.get(str);
        if (messageConverter != null) {
            register.setConverter(messageConverter);
        }
    }
}
