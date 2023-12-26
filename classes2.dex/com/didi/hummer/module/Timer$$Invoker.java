package com.didi.hummer.module;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;

public class Timer$$Invoker extends BaseInvoker<Timer> {
    public String getName() {
        return "Timer";
    }

    /* access modifiers changed from: protected */
    public Timer createInstance(JSValue jSValue, Object[] objArr) {
        return new Timer(jSValue);
    }

    /* access modifiers changed from: protected */
    public Object invoke(Timer timer, String str, Object[] objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1735228601:
                if (str.equals("setInterval")) {
                    c = 0;
                    break;
                }
                break;
            case -1337725356:
                if (str.equals("clearTimeout")) {
                    c = 1;
                    break;
                }
                break;
            case -167812558:
                if (str.equals("clearInterval")) {
                    c = 2;
                    break;
                }
                break;
            case 1659754143:
                if (str.equals("setTimeout")) {
                    c = 3;
                    break;
                }
                break;
        }
        long j = 0;
        switch (c) {
            case 0:
                JSCallback jSCallback = (objArr.length <= 0 || objArr[0] == null) ? null : objArr[0];
                if (objArr.length > 1 && objArr[1] != null) {
                    j = objArr[1].longValue();
                }
                timer.setInterval(jSCallback, j);
                break;
            case 1:
                timer.clearTimeout();
                break;
            case 2:
                timer.clearInterval();
                break;
            case 3:
                JSCallback jSCallback2 = (objArr.length <= 0 || objArr[0] == null) ? null : objArr[0];
                if (objArr.length > 1 && objArr[1] != null) {
                    j = objArr[1].longValue();
                }
                timer.setTimeout(jSCallback2, j);
                break;
        }
        return null;
    }
}
