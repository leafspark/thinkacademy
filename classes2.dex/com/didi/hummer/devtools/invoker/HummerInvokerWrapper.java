package com.didi.hummer.devtools.invoker;

import com.didi.hummer.context.HummerInvoker;
import com.didi.hummer.devtools.manager.HummerLogManager;
import com.didi.hummer.render.component.view.HMBase;

public class HummerInvokerWrapper extends HummerInvoker {
    private HummerLogManager mLogManager;

    public HummerInvokerWrapper(HummerLogManager hummerLogManager) {
        this.mLogManager = hummerLogManager;
    }

    /* access modifiers changed from: protected */
    public Object invoke(HMBase hMBase, String str, Object... objArr) {
        str.hashCode();
        int i = 4;
        char c = 65535;
        switch (str.hashCode()) {
            case -1919095251:
                if (str.equals("console.log")) {
                    c = 0;
                    break;
                }
                break;
            case -1717253380:
                if (str.equals("console.debug")) {
                    c = 1;
                    break;
                }
                break;
            case -1715927375:
                if (str.equals("console.error")) {
                    c = 2;
                    break;
                }
                break;
            case 637499109:
                if (str.equals("console.info")) {
                    c = 3;
                    break;
                }
                break;
            case 637904061:
                if (str.equals("console.warn")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            case 2:
                i = 5;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                break;
            default:
                i = 0;
                break;
        }
        if (i > 0) {
            this.mLogManager.addLog(i, String.valueOf(objArr[0]));
        }
        return super.invoke(hMBase, str, objArr);
    }
}
