package com.tal.app.thinkacademy.common.andserver.processor.generator;

import android.content.Context;
import com.tal.app.thinkacademy.common.business.browser.server.AppConfig;
import com.yanzhenjie.andserver.framework.config.Delegate;
import com.yanzhenjie.andserver.framework.config.WebConfig;
import com.yanzhenjie.andserver.framework.website.Website;
import com.yanzhenjie.andserver.register.OnRegister;
import com.yanzhenjie.andserver.register.Register;
import com.yanzhenjie.andserver.util.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ConfigRegister implements OnRegister {
    private Map<String, WebConfig> mMap;

    public ConfigRegister() {
        HashMap hashMap = new HashMap();
        this.mMap = hashMap;
        hashMap.put("default", new AppConfig());
    }

    public void onRegister(Context context, String str, Register register) {
        WebConfig webConfig = this.mMap.get(str);
        if (webConfig != null) {
            Delegate newInstance = Delegate.newInstance();
            webConfig.onConfig(context, newInstance);
            List<Website> websites = newInstance.getWebsites();
            if (!CollectionUtils.isEmpty(websites)) {
                for (Website addAdapter : websites) {
                    register.addAdapter(addAdapter);
                }
            }
            register.setMultipart(newInstance.getMultipart());
        }
    }
}
