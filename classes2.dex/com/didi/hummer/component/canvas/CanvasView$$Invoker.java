package com.didi.hummer.component.canvas;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.google.gson.reflect.TypeToken;

public class CanvasView$$Invoker extends BaseInvoker<CanvasView> {
    public String getName() {
        return "CanvasView";
    }

    /* access modifiers changed from: protected */
    public CanvasView createInstance(JSValue jSValue, Object[] objArr) {
        return new CanvasView(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(CanvasView canvasView, String str, Object[] objArr) {
        Object obj;
        Object obj2;
        Object[] objArr2;
        CanvasView canvasView2 = canvasView;
        String str2 = str;
        Object[] objArr3 = objArr;
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -1822070833:
                if (str.equals("lineColor")) {
                    c = 0;
                    break;
                }
                break;
            case -1803786702:
                if (str.equals("lineWidth")) {
                    c = 1;
                    break;
                }
                break;
            case -1656480802:
                if (str.equals("ellipse")) {
                    c = 2;
                    break;
                }
                break;
            case -1141881952:
                if (str.equals("fillColor")) {
                    c = 3;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    c = 4;
                    break;
                }
                break;
            case -1055681240:
                if (str.equals("strokeCircle")) {
                    c = 5;
                    break;
                }
                break;
            case -1043976141:
                if (str.equals("fillCircle")) {
                    c = 6;
                    break;
                }
                break;
            case -827125928:
                if (str.equals("drawLine")) {
                    c = 7;
                    break;
                }
                break;
            case -729134585:
                if (str.equals("fillRect")) {
                    c = 8;
                    break;
                }
                break;
            case -729074352:
                if (str.equals("fillText")) {
                    c = 9;
                    break;
                }
                break;
            case -630822852:
                if (str.equals("strokeRect")) {
                    c = 10;
                    break;
                }
                break;
            case -442952485:
                if (str.equals("fillEllipse")) {
                    c = 11;
                    break;
                }
                break;
            case -327229055:
                if (str.equals("getCanvasContext")) {
                    c = 12;
                    break;
                }
                break;
            case 96850:
                if (str.equals("arc")) {
                    c = 13;
                    break;
                }
                break;
            case 126236279:
                if (str.equals("drawImage")) {
                    c = 14;
                    break;
                }
                break;
            case 128900123:
                if (str.equals("drawLines")) {
                    c = 15;
                    break;
                }
                break;
            case 176874302:
                if (str.equals("lineCap")) {
                    c = 16;
                    break;
                }
                break;
            case 365601008:
                if (str.equals(HummerStyleUtils.Hummer.FONT_SIZE)) {
                    c = 17;
                    break;
                }
                break;
            case 1188357950:
                if (str.equals("lineJoin")) {
                    c = 18;
                    break;
                }
                break;
        }
        float f = 0.0f;
        switch (c) {
            case 0:
                canvasView.lineColor((objArr3.length <= 0 || objArr3[0] == null) ? null : String.valueOf(objArr3[0]));
                return null;
            case 1:
                if (objArr3.length > 0 && objArr3[0] != null) {
                    f = ((Number) objArr3[0]).floatValue();
                }
                canvasView.lineWidth(f);
                return null;
            case 2:
                canvasView.ellipse(objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 3 ? (!(objArr3[3] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[3]) && !HMGsonUtil.isJsonArray((String) objArr3[3]))) ? objArr3[3] : HMGsonUtil.fromJson((String) objArr3[3], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 3:
                canvasView.fillColor((objArr3.length <= 0 || objArr3[0] == null) ? null : String.valueOf(objArr3[0]));
                return null;
            case 4:
                canvasView.textColor((objArr3.length <= 0 || objArr3[0] == null) ? null : String.valueOf(objArr3[0]));
                return null;
            case 5:
                canvasView.strokeCircle(objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 6:
                canvasView.fillCircle(objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 7:
                canvasView.drawLine(objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 3 ? (!(objArr3[3] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[3]) && !HMGsonUtil.isJsonArray((String) objArr3[3]))) ? objArr3[3] : HMGsonUtil.fromJson((String) objArr3[3], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 8:
                canvasView.fillRect(objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 3 ? (!(objArr3[3] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[3]) && !HMGsonUtil.isJsonArray((String) objArr3[3]))) ? objArr3[3] : HMGsonUtil.fromJson((String) objArr3[3], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 9:
                canvasView.fillText((objArr3.length <= 0 || objArr3[0] == null) ? null : String.valueOf(objArr3[0]), objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 3 ? (!(objArr3[3] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[3]) && !HMGsonUtil.isJsonArray((String) objArr3[3]))) ? objArr3[3] : HMGsonUtil.fromJson((String) objArr3[3], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 10:
                canvasView.strokeRect(objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 3 ? (!(objArr3[3] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[3]) && !HMGsonUtil.isJsonArray((String) objArr3[3]))) ? objArr3[3] : HMGsonUtil.fromJson((String) objArr3[3], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 11:
                canvasView.fillEllipse(objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null, objArr3.length > 3 ? (!(objArr3[3] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[3]) && !HMGsonUtil.isJsonArray((String) objArr3[3]))) ? objArr3[3] : HMGsonUtil.fromJson((String) objArr3[3], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 12:
                return canvasView.getCanvasContext();
            case 13:
                Object fromJson = objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null;
                Object fromJson2 = objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null;
                Object fromJson3 = objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null;
                Object fromJson4 = objArr3.length > 3 ? (!(objArr3[3] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[3]) && !HMGsonUtil.isJsonArray((String) objArr3[3]))) ? objArr3[3] : HMGsonUtil.fromJson((String) objArr3[3], new TypeToken<Object>() {
                }.getType()) : null;
                Object fromJson5 = objArr3.length > 4 ? (!(objArr3[4] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[4]) && !HMGsonUtil.isJsonArray((String) objArr3[4]))) ? objArr3[4] : HMGsonUtil.fromJson((String) objArr3[4], new TypeToken<Object>() {
                }.getType()) : null;
                if (objArr3.length > 5) {
                    obj = (!(objArr3[5] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[5]) && !HMGsonUtil.isJsonArray((String) objArr3[5]))) ? objArr3[5] : HMGsonUtil.fromJson((String) objArr3[5], new TypeToken<Object>() {
                    }.getType());
                } else {
                    obj = null;
                }
                canvasView.arc(fromJson, fromJson2, fromJson3, fromJson4, fromJson5, obj);
                return null;
            case 14:
                Object fromJson6 = objArr3.length > 0 ? (!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object>() {
                }.getType()) : null;
                Object fromJson7 = objArr3.length > 1 ? (!(objArr3[1] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[1]) && !HMGsonUtil.isJsonArray((String) objArr3[1]))) ? objArr3[1] : HMGsonUtil.fromJson((String) objArr3[1], new TypeToken<Object>() {
                }.getType()) : null;
                Object fromJson8 = objArr3.length > 2 ? (!(objArr3[2] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[2]) && !HMGsonUtil.isJsonArray((String) objArr3[2]))) ? objArr3[2] : HMGsonUtil.fromJson((String) objArr3[2], new TypeToken<Object>() {
                }.getType()) : null;
                Object fromJson9 = objArr3.length > 3 ? (!(objArr3[3] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[3]) && !HMGsonUtil.isJsonArray((String) objArr3[3]))) ? objArr3[3] : HMGsonUtil.fromJson((String) objArr3[3], new TypeToken<Object>() {
                }.getType()) : null;
                if (objArr3.length > 4) {
                    obj2 = (!(objArr3[4] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[4]) && !HMGsonUtil.isJsonArray((String) objArr3[4]))) ? objArr3[4] : HMGsonUtil.fromJson((String) objArr3[4], new TypeToken<Object>() {
                    }.getType());
                } else {
                    obj2 = null;
                }
                canvasView.drawImage(fromJson6, fromJson7, fromJson8, fromJson9, obj2);
                return null;
            case 15:
                if (objArr3.length > 0) {
                    objArr2 = (Object[]) ((!(objArr3[0] instanceof String) || (!HMGsonUtil.isJsonObject((String) objArr3[0]) && !HMGsonUtil.isJsonArray((String) objArr3[0]))) ? (Object[]) objArr3[0] : HMGsonUtil.fromJson((String) objArr3[0], new TypeToken<Object[]>() {
                    }.getType()));
                } else {
                    objArr2 = null;
                }
                canvasView.drawLines(objArr2);
                return null;
            case 16:
                if (objArr3.length > 0 && objArr3[0] != null) {
                    i = ((Number) objArr3[0]).intValue();
                }
                canvasView.lineCap(i);
                return null;
            case 17:
                if (objArr3.length > 0 && objArr3[0] != null) {
                    f = ((Number) objArr3[0]).floatValue();
                }
                canvasView.fontSize(f);
                return null;
            case 18:
                if (objArr3.length > 0 && objArr3[0] != null) {
                    i = ((Number) objArr3[0]).intValue();
                }
                canvasView.lineJoin(i);
                return null;
            default:
                return null;
        }
    }
}
