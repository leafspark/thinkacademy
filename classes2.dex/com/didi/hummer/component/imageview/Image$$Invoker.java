package com.didi.hummer.component.imageview;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;

public class Image$$Invoker extends BaseInvoker<Image> {
    public String getName() {
        return "Image";
    }

    /* access modifiers changed from: protected */
    public Image createInstance(JSValue jSValue, Object[] objArr) {
        return new Image(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(Image image, String str, Object[] objArr) {
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -905800158:
                if (str.equals("setSrc")) {
                    c = 0;
                    break;
                }
                break;
            case 3327206:
                if (str.equals("load")) {
                    c = 1;
                    break;
                }
                break;
            case 235325058:
                if (str.equals("setGifSrc")) {
                    c = 2;
                    break;
                }
                break;
            case 1013253842:
                if (str.equals("setGifRepeatCount")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                image.setSrc((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                break;
            case 1:
                image.load(objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null, (objArr.length <= 1 || objArr[1] == null) ? null : objArr[1]);
                break;
            case 2:
                image.setGifSrc((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                break;
            case 3:
                if (objArr.length > 0 && objArr[0] != null) {
                    i = objArr[0].intValue();
                }
                image.setGifRepeatCount(i);
                break;
        }
        return null;
    }
}
