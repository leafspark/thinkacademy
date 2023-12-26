package com.didi.hummer.component.toast;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.didi.hummer.render.component.view.HMBase;

public class Toast$$Invoker extends BaseInvoker<Toast> {
    public String getName() {
        return "Toast";
    }

    /* access modifiers changed from: protected */
    public Toast createInstance(JSValue jSValue, Object[] objArr) {
        return new Toast();
    }

    /* access modifiers changed from: protected */
    public Object invoke(Toast toast, String str, Object[] objArr) {
        str.hashCode();
        int i = 0;
        if (str.equals("custom")) {
            HMBase hMBase = (HMBase) this.mInstanceManager.get((objArr.length <= 0 || objArr[0] == null) ? 0 : objArr[0].longValue());
            if (objArr.length > 1 && objArr[1] != null) {
                i = objArr[1].intValue();
            }
            Toast.custom(hMBase, i);
        } else if (str.equals("show")) {
            String valueOf = (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]);
            if (objArr.length > 1 && objArr[1] != null) {
                i = objArr[1].intValue();
            }
            Toast.show(valueOf, i);
        }
        return null;
    }
}
