package com.didi.hummer.devtools.invoker;

import com.didi.hummer.adapter.http.HttpResponse;
import com.didi.hummer.component.input.NJReturnKeyType;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.napi.NAPIValue;
import com.didi.hummer.devtools.manager.HummerNetManager;
import com.didi.hummer.module.Request;
import com.didi.hummer.module.Request$$Invoker;

public class RequestInvokerWrapper extends Request$$Invoker {
    /* access modifiers changed from: private */
    public HummerNetManager manager;

    public RequestInvokerWrapper(HummerNetManager hummerNetManager) {
        this.manager = hummerNetManager;
    }

    /* access modifiers changed from: protected */
    public Object invoke(Request request, String str, Object[] objArr) {
        str.hashCode();
        if (!str.equals(NJReturnKeyType.SEND)) {
            return super.invoke(request, str, objArr);
        }
        request.send(new JSCallbackWrapper(request.url, (objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]));
        return null;
    }

    class JSCallbackWrapper extends NAPIValue implements JSCallback {
        private JSCallback callback;
        private String url;

        protected JSCallbackWrapper(String str, JSCallback jSCallback) {
            super(0, 0);
            this.url = str;
            this.callback = jSCallback;
        }

        public Object call(Object... objArr) {
            HttpResponse httpResponse = (objArr.length <= 0 || objArr[0] == null) ? null : objArr[0];
            if (httpResponse != null) {
                RequestInvokerWrapper.this.manager.addData(this.url, httpResponse.data, httpResponse.error);
            }
            return this.callback.call(objArr);
        }

        public void release() {
            this.callback.release();
        }
    }
}
