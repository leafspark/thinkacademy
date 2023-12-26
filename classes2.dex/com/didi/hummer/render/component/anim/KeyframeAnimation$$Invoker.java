package com.didi.hummer.render.component.anim;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.anim.KeyframeAnimation;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class KeyframeAnimation$$Invoker extends BaseInvoker<KeyframeAnimation> {
    public String getName() {
        return "KeyframeAnimation";
    }

    /* access modifiers changed from: protected */
    public KeyframeAnimation createInstance(JSValue jSValue, Object[] objArr) {
        return new KeyframeAnimation((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(KeyframeAnimation keyframeAnimation, String str, Object[] objArr) {
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
            case 92721539:
                if (str.equals("setKeyframes")) {
                    c = 3;
                    break;
                }
                break;
            case 171086893:
                if (str.equals("setEasing")) {
                    c = 4;
                    break;
                }
                break;
            case 1390180929:
                if (str.equals("setDelay")) {
                    c = 5;
                    break;
                }
                break;
            case 1406685743:
                if (str.equals("setValue")) {
                    c = 6;
                    break;
                }
                break;
            case 1635752928:
                if (str.equals("setRepeatMode")) {
                    c = 7;
                    break;
                }
                break;
            case 1984579372:
                if (str.equals("setFrom")) {
                    c = 8;
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
                keyframeAnimation.repeatCount = i;
                break;
            case 1:
                if (objArr.length > 0 && objArr[0] != null) {
                    f = objArr[0].floatValue();
                }
                keyframeAnimation.duration = f;
                break;
            case 2:
                keyframeAnimation.on((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]), (objArr.length <= 1 || objArr[1] == null) ? null : objArr[1]);
                break;
            case 3:
                keyframeAnimation.setKeyframes((objArr.length <= 0 || objArr[0] == null) ? null : (List) HMGsonUtil.fromJson(objArr[0], new TypeToken<List<KeyframeAnimation.KeyFrame>>() {
                }.getType()));
                break;
            case 4:
                keyframeAnimation.easing = (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]);
                break;
            case 5:
                if (objArr.length > 0 && objArr[0] != null) {
                    f = objArr[0].floatValue();
                }
                keyframeAnimation.delay = f;
                break;
            case 6:
                keyframeAnimation.value = objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null;
                break;
            case 7:
                keyframeAnimation.repeatMode = (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]);
                break;
            case 8:
                keyframeAnimation.from = objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null;
                break;
        }
        return null;
    }
}
