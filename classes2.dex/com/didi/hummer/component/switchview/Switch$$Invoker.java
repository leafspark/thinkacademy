package com.didi.hummer.component.switchview;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;

public class Switch$$Invoker extends BaseInvoker<Switch> {
    public String getName() {
        return "Switch";
    }

    /* access modifiers changed from: protected */
    public Switch createInstance(JSValue jSValue, Object[] objArr) {
        return new Switch(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(Switch switchR, String str, Object[] objArr) {
        str.hashCode();
        if (!str.equals("setChecked")) {
            return null;
        }
        boolean z = false;
        if (objArr.length > 0 && objArr[0] != null) {
            z = objArr[0].booleanValue();
        }
        switchR.setChecked(z);
        return null;
    }
}
