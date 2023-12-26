package com.didi.hummer.component.canvas;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;

public class CanvasPath$$Invoker extends BaseInvoker<CanvasPath> {
    public String getName() {
        return "CanvasPath";
    }

    /* access modifiers changed from: protected */
    public CanvasPath createInstance(JSValue jSValue, Object[] objArr) {
        return new CanvasPath(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(CanvasPath canvasPath, String str, Object[] objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1102672497:
                if (str.equals("lineTo")) {
                    c = 0;
                    break;
                }
                break;
            case -1068263892:
                if (str.equals("moveTo")) {
                    c = 1;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                canvasPath.lineTo(objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null, objArr.length > 1 ? (!(objArr[1] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[1]) && !HMGsonUtil.isJsonArray(objArr[1]))) ? objArr[1] : HMGsonUtil.fromJson(objArr[1], new TypeToken<Object>() {
                }.getType()) : null);
                break;
            case 1:
                canvasPath.moveTo(objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null, objArr.length > 1 ? (!(objArr[1] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[1]) && !HMGsonUtil.isJsonArray(objArr[1]))) ? objArr[1] : HMGsonUtil.fromJson(objArr[1], new TypeToken<Object>() {
                }.getType()) : null);
                break;
            case 2:
                canvasPath.close();
                break;
        }
        return null;
    }
}
