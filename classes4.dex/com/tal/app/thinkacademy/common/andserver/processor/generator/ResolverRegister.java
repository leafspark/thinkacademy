package com.tal.app.thinkacademy.common.andserver.processor.generator;

import android.content.Context;
import com.tal.app.thinkacademy.common.business.browser.server.AppExceptionResolver;
import com.yanzhenjie.andserver.framework.ExceptionResolver;
import com.yanzhenjie.andserver.register.OnRegister;
import com.yanzhenjie.andserver.register.Register;
import java.util.HashMap;
import java.util.Map;

public final class ResolverRegister implements OnRegister {
    private Map<String, ExceptionResolver> mMap;

    public ResolverRegister() {
        HashMap hashMap = new HashMap();
        this.mMap = hashMap;
        hashMap.put("default", new AppExceptionResolver());
    }

    public void onRegister(Context context, String str, Register register) {
        ExceptionResolver exceptionResolver = this.mMap.get(str);
        if (exceptionResolver != null) {
            register.setResolver(exceptionResolver);
        }
    }
}
