package com.didi.hummer.module;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;

public class Storage$$Invoker extends BaseInvoker<Storage> {
    public String getName() {
        return "Storage";
    }

    /* access modifiers changed from: protected */
    public Storage createInstance(JSValue jSValue, Object[] objArr) {
        return new Storage();
    }

    /* access modifiers changed from: protected */
    public Object invoke(Storage storage, String str, Object[] objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249367445:
                if (str.equals("getAll")) {
                    c = 0;
                    break;
                }
                break;
            case -934610812:
                if (str.equals("remove")) {
                    c = 1;
                    break;
                }
                break;
            case -912432331:
                if (str.equals("allKeys")) {
                    c = 2;
                    break;
                }
                break;
            case 102230:
                if (str.equals("get")) {
                    c = 3;
                    break;
                }
                break;
            case 113762:
                if (str.equals("set")) {
                    c = 4;
                    break;
                }
                break;
            case 96955127:
                if (str.equals("exist")) {
                    c = 5;
                    break;
                }
                break;
            case 1282345597:
                if (str.equals("removeAll")) {
                    c = 6;
                    break;
                }
                break;
        }
        String str2 = null;
        switch (c) {
            case 0:
                return Storage.getAll(this.mHummerContext);
            case 1:
                Storage.remove(this.mHummerContext, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                return null;
            case 2:
                return Storage.allKeys(this.mHummerContext);
            case 3:
                if (objArr.length > 0 && objArr[0] != null) {
                    str2 = String.valueOf(objArr[0]);
                }
                return Storage.get(this.mHummerContext, str2);
            case 4:
                Storage.set(this.mHummerContext, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]), (objArr.length <= 1 || objArr[1] == null) ? null : String.valueOf(objArr[1]));
                return null;
            case 5:
                if (objArr.length > 0 && objArr[0] != null) {
                    str2 = String.valueOf(objArr[0]);
                }
                return Boolean.valueOf(Storage.exist(this.mHummerContext, str2));
            case 6:
                Storage.removeAll(this.mHummerContext);
                return null;
            default:
                return null;
        }
    }
}
