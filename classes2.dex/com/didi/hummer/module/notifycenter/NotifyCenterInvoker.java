package com.didi.hummer.module.notifycenter;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.didi.hummer.render.component.view.HMBase;
import com.google.gson.reflect.TypeToken;

public class NotifyCenterInvoker extends BaseInvoker<HMBase> {
    /* access modifiers changed from: protected */
    public HMBase createInstance(JSValue jSValue, Object... objArr) {
        return null;
    }

    public String getName() {
        return "NotifyCenter";
    }

    /* access modifiers changed from: protected */
    public JSValue invoke(HMBase hMBase, String str, Object... objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -625809843:
                if (str.equals("addEventListener")) {
                    c = 0;
                    break;
                }
                break;
            case -541487286:
                if (str.equals("removeEventListener")) {
                    c = 1;
                    break;
                }
                break;
            case 351862722:
                if (str.equals("triggerEvent")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                NotifyCenter.addEventListener(String.valueOf(objArr[0]), objArr[1]);
                break;
            case 1:
                NotifyCenter.removeEventListener(this.mHummerContext, String.valueOf(objArr[0]), objArr.length > 1 ? objArr[1] : null);
                break;
            case 2:
                NotifyCenter.triggerEvent(String.valueOf(objArr[0]), objArr.length > 1 ? (!(objArr[1] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[1]) && !HMGsonUtil.isJsonArray(objArr[1]))) ? objArr[1] : HMGsonUtil.fromJson(objArr[1], new TypeToken<Object>() {
                }.getType()) : null);
                break;
        }
        return null;
    }
}
