package com.didi.hummer.render.component.anim;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;

public class BasicAnimation$$Invoker extends BaseInvoker<BasicAnimation> {
    public String getName() {
        return "BasicAnimation";
    }

    /* access modifiers changed from: protected */
    public BasicAnimation createInstance(JSValue jSValue, Object[] objArr) {
        return new BasicAnimation((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(BasicAnimation basicAnimation, String str, Object[] objArr) {
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -840485262:
                if (str.equals("setRepeatCount")) {
                    c = 0;
                    break;
                }
                break;
            case -2692074:
                if (str.equals("setDuration")) {
                    c = 1;
                    break;
                }
                break;
            case 3551:
                if (str.equals("on")) {
                    c = 2;
                    break;
                }
                break;
            case 171086893:
                if (str.equals("setEasing")) {
                    c = 3;
                    break;
                }
                break;
            case 1390180929:
                if (str.equals("setDelay")) {
                    c = 4;
                    break;
                }
                break;
            case 1406685743:
                if (str.equals("setValue")) {
                    c = 5;
                    break;
                }
                break;
            case 1635752928:
                if (str.equals("setRepeatMode")) {
                    c = 6;
                    break;
                }
                break;
            case 1984579372:
                if (str.equals("setFrom")) {
                    c = 7;
                    break;
                }
                break;
        }
        float f = 0.0f;
        switch (c) {
            case 0:
                if (objArr.length > 0 && objArr[0] != null) {
                    i = objArr[0].intValue();
                }
                basicAnimation.repeatCount = i;
                break;
            case 1:
                if (objArr.length > 0 && objArr[0] != null) {
                    f = objArr[0].floatValue();
                }
                basicAnimation.duration = f;
                break;
            case 2:
                basicAnimation.on((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]), (objArr.length <= 1 || objArr[1] == null) ? null : objArr[1]);
                break;
            case 3:
                basicAnimation.easing = (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]);
                break;
            case 4:
                if (objArr.length > 0 && objArr[0] != null) {
                    f = objArr[0].floatValue();
                }
                basicAnimation.delay = f;
                break;
            case 5:
                basicAnimation.value = objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null;
                break;
            case 6:
                basicAnimation.repeatMode = (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]);
                break;
            case 7:
                basicAnimation.from = objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null;
                break;
        }
        return null;
    }
}
