package com.tal.app.thinkacademy.common.andserver.processor.generator;

import android.content.Context;
import com.tal.app.thinkacademy.common.business.browser.server.LoggerInterceptor;
import com.tal.app.thinkacademy.common.business.browser.server.PartialContentInterceptor;
import com.yanzhenjie.andserver.framework.HandlerInterceptor;
import com.yanzhenjie.andserver.register.OnRegister;
import com.yanzhenjie.andserver.register.Register;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InterceptorRegister implements OnRegister {
    private Map<String, List<HandlerInterceptor>> mMap = new HashMap();

    public InterceptorRegister() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LoggerInterceptor());
        arrayList.add(new PartialContentInterceptor());
        this.mMap.put("default", arrayList);
    }

    public void onRegister(Context context, String str, Register register) {
        List<HandlerInterceptor> list = this.mMap.get(str);
        if (list != null && !list.isEmpty()) {
            for (HandlerInterceptor addInterceptor : list) {
                register.addInterceptor(addInterceptor);
            }
        }
    }
}
