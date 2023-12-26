package com.didi.hummer.component.text;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;

public class Text$$Invoker extends BaseInvoker<Text> {
    public String getName() {
        return "Text";
    }

    /* access modifiers changed from: protected */
    public Text createInstance(JSValue jSValue, Object[] objArr) {
        return new Text(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(Text text, String str, Object[] objArr) {
        str.hashCode();
        boolean z = false;
        char c = 65535;
        switch (str.hashCode()) {
            case -371601721:
                if (str.equals("setFormattedText")) {
                    c = 0;
                    break;
                }
                break;
            case 437777067:
                if (str.equals("setRichText")) {
                    c = 1;
                    break;
                }
                break;
            case 1675237223:
                if (str.equals("setTextCopyEnable")) {
                    c = 2;
                    break;
                }
                break;
            case 1984984239:
                if (str.equals("setText")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                text.setFormattedText((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                break;
            case 1:
                text.setRichText(objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null);
                break;
            case 2:
                if (objArr.length > 0 && objArr[0] != null) {
                    z = objArr[0].booleanValue();
                }
                text.setTextCopyEnable(z);
                break;
            case 3:
                text.setText((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                break;
        }
        return null;
    }
}
