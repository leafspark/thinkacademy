package com.didi.hummer.module;

import com.didi.hummer.component.input.NJReturnKeyType;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class Request$$Invoker extends BaseInvoker<Request> {
    public String getName() {
        return "Request";
    }

    /* access modifiers changed from: protected */
    public Request createInstance(JSValue jSValue, Object[] objArr) {
        return new Request(this.mHummerContext, jSValue);
    }

    /* access modifiers changed from: protected */
    public Object invoke(Request request, String str, Object[] objArr) {
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -905798227:
                if (str.equals("setUrl")) {
                    c = 0;
                    break;
                }
                break;
            case 3526536:
                if (str.equals(NJReturnKeyType.SEND)) {
                    c = 1;
                    break;
                }
                break;
            case 260127119:
                if (str.equals("setHeader")) {
                    c = 2;
                    break;
                }
                break;
            case 403843043:
                if (str.equals("setMethod")) {
                    c = 3;
                    break;
                }
                break;
            case 1401149771:
                if (str.equals("setParam")) {
                    c = 4;
                    break;
                }
                break;
            case 1659754143:
                if (str.equals("setTimeout")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                request.setUrl((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                break;
            case 1:
                request.send((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                break;
            case 2:
                request.header = (objArr.length <= 0 || objArr[0] == null) ? null : (Map) HMGsonUtil.fromJson(objArr[0], new TypeToken<Map<String, Object>>() {
                }.getType());
                break;
            case 3:
                request.setMethod((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                break;
            case 4:
                request.param = (objArr.length <= 0 || objArr[0] == null) ? null : (Map) HMGsonUtil.fromJson(objArr[0], new TypeToken<Map<String, Object>>() {
                }.getType());
                break;
            case 5:
                if (objArr.length > 0 && objArr[0] != null) {
                    i = objArr[0].intValue();
                }
                request.timeout = i;
                break;
        }
        return null;
    }
}
