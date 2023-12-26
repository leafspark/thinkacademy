package com.didi.hummer.component.button;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class Button$$Invoker extends BaseInvoker<Button> {
    public String getName() {
        return "Button";
    }

    /* access modifiers changed from: protected */
    public Button createInstance(JSValue jSValue, Object[] objArr) {
        return new Button(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(Button button, String str, Object[] objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2034706178:
                if (str.equals("setDisabled")) {
                    c = 0;
                    break;
                }
                break;
            case -1639565984:
                if (str.equals("setPressed")) {
                    c = 1;
                    break;
                }
                break;
            case 1984984239:
                if (str.equals("setText")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                button.setDisabled((objArr.length <= 0 || objArr[0] == null) ? null : (Map) HMGsonUtil.fromJson(objArr[0], new TypeToken<Map<String, Object>>() {
                }.getType()));
                break;
            case 1:
                button.setPressed((objArr.length <= 0 || objArr[0] == null) ? null : (Map) HMGsonUtil.fromJson(objArr[0], new TypeToken<Map<String, Object>>() {
                }.getType()));
                break;
            case 2:
                button.setText((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                break;
        }
        return null;
    }
}
