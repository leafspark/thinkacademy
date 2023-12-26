package com.didi.hummer.component.dialog;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.didi.hummer.render.component.view.HMBase;

public class Dialog$$Invoker extends BaseInvoker<Dialog> {
    public String getName() {
        return "Dialog";
    }

    /* access modifiers changed from: protected */
    public Dialog createInstance(JSValue jSValue, Object[] objArr) {
        return new Dialog(this.mHummerContext.getContext());
    }

    /* access modifiers changed from: protected */
    public Object invoke(Dialog dialog, String str, Object[] objArr) {
        str.hashCode();
        boolean z = false;
        char c = 65535;
        switch (str.hashCode()) {
            case -1929577258:
                if (str.equals("setCancelable")) {
                    c = 0;
                    break;
                }
                break;
            case -1349088399:
                if (str.equals("custom")) {
                    c = 1;
                    break;
                }
                break;
            case 92899676:
                if (str.equals("alert")) {
                    c = 2;
                    break;
                }
                break;
            case 148034783:
                if (str.equals("setLowLayer")) {
                    c = 3;
                    break;
                }
                break;
            case 336650556:
                if (str.equals("loading")) {
                    c = 4;
                    break;
                }
                break;
            case 951117504:
                if (str.equals("confirm")) {
                    c = 5;
                    break;
                }
                break;
            case 1671672458:
                if (str.equals("dismiss")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (objArr.length > 0 && objArr[0] != null) {
                    z = objArr[0].booleanValue();
                }
                dialog.cancelable = z;
                break;
            case 1:
                dialog.custom((HMBase) this.mInstanceManager.get((objArr.length <= 0 || objArr[0] == null) ? 0 : objArr[0].longValue()));
                break;
            case 2:
                dialog.alert((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]), (objArr.length <= 1 || objArr[1] == null) ? null : String.valueOf(objArr[1]), (objArr.length <= 2 || objArr[2] == null) ? null : objArr[2]);
                break;
            case 3:
                if (objArr.length > 0 && objArr[0] != null) {
                    z = objArr[0].booleanValue();
                }
                dialog.lowLayer = z;
                break;
            case 4:
                dialog.loading((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                break;
            case 5:
                dialog.confirm((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]), (objArr.length <= 1 || objArr[1] == null) ? null : String.valueOf(objArr[1]), (objArr.length <= 2 || objArr[2] == null) ? null : String.valueOf(objArr[2]), (objArr.length <= 3 || objArr[3] == null) ? null : String.valueOf(objArr[3]), (objArr.length <= 4 || objArr[4] == null) ? null : objArr[4], (objArr.length <= 5 || objArr[5] == null) ? null : objArr[5]);
                break;
            case 6:
                dialog.dismiss();
                break;
        }
        return null;
    }
}
