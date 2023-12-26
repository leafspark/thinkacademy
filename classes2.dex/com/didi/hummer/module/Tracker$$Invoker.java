package com.didi.hummer.module;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.module.Tracker;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;

public class Tracker$$Invoker extends BaseInvoker<Tracker> {
    public String getName() {
        return "Tracker";
    }

    /* access modifiers changed from: protected */
    public Tracker createInstance(JSValue jSValue, Object[] objArr) {
        return new Tracker();
    }

    /* access modifiers changed from: protected */
    public Object invoke(Tracker tracker, String str, Object[] objArr) {
        Tracker.JSErrorInfo jSErrorInfo;
        Tracker.JSPerfCustomInfo jSPerfCustomInfo;
        str.hashCode();
        if (str.equals("trackException")) {
            if (objArr.length > 0) {
                jSErrorInfo = (Tracker.JSErrorInfo) ((!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Tracker.JSErrorInfo>() {
                }.getType()));
            } else {
                jSErrorInfo = null;
            }
            Tracker.trackException(this.mHummerContext, jSErrorInfo);
        } else if (str.equals("trackPerformance")) {
            if (objArr.length > 0) {
                jSPerfCustomInfo = (Tracker.JSPerfCustomInfo) ((!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Tracker.JSPerfCustomInfo>() {
                }.getType()));
            } else {
                jSPerfCustomInfo = null;
            }
            Tracker.trackPerformance(this.mHummerContext, jSPerfCustomInfo);
        }
        return null;
    }
}
