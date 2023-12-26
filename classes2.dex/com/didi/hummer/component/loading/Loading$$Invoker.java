package com.didi.hummer.component.loading;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;

public class Loading$$Invoker extends BaseInvoker<Loading> {
    public String getName() {
        return "Loading";
    }

    /* access modifiers changed from: protected */
    public Loading createInstance(JSValue jSValue, Object[] objArr) {
        return new Loading(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(Loading loading, String str, Object[] objArr) {
        str.getClass();
        return null;
    }
}
