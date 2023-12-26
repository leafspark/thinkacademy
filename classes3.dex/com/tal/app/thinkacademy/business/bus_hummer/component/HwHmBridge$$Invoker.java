package com.tal.app.thinkacademy.business.bus_hummer.component;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class HwHmBridge$$Invoker extends BaseInvoker<HwHmBridge> {
    public String getName() {
        return "HwHmBridge";
    }

    /* access modifiers changed from: protected */
    public HwHmBridge createInstance(JSValue jSValue, Object[] objArr) {
        return new HwHmBridge();
    }

    /* access modifiers changed from: protected */
    public Object invoke(HwHmBridge hwHmBridge, String str, Object[] objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -912076826:
                if (str.equals("copyString")) {
                    c = 0;
                    break;
                }
                break;
            case 110621003:
                if (str.equals("track")) {
                    c = 1;
                    break;
                }
                break;
            case 448806416:
                if (str.equals("openWechat")) {
                    c = 2;
                    break;
                }
                break;
            case 1279853752:
                if (str.equals("setTopBarTitle")) {
                    c = 3;
                    break;
                }
                break;
        }
        String str2 = null;
        switch (c) {
            case 0:
                if (objArr.length > 0 && objArr[0] != null) {
                    str2 = String.valueOf(objArr[0]);
                }
                return Boolean.valueOf(hwHmBridge.copyString(this.mHummerContext, str2));
            case 1:
                hwHmBridge.track(this.mHummerContext, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]), (objArr.length <= 1 || objArr[1] == null) ? null : (Map) HMGsonUtil.fromJson(objArr[1], new TypeToken<Map<String, Object>>() {
                }.getType()));
                return null;
            case 2:
                return Boolean.valueOf(hwHmBridge.openWechat(this.mHummerContext));
            case 3:
                hwHmBridge.setTopBarTitle(this.mHummerContext, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]), (objArr.length <= 1 || objArr[1] == null) ? null : String.valueOf(objArr[1]));
                return null;
            default:
                return null;
        }
    }
}
