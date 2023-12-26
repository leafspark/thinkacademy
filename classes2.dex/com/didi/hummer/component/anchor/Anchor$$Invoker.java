package com.didi.hummer.component.anchor;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.didi.hummer.render.component.view.HMBase;

public class Anchor$$Invoker extends BaseInvoker<Anchor> {
    public String getName() {
        return "Anchor";
    }

    /* access modifiers changed from: protected */
    public Anchor createInstance(JSValue jSValue, Object[] objArr) {
        return new Anchor(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(Anchor anchor, String str, Object[] objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1912367582:
                if (str.equals("appendChild")) {
                    c = 0;
                    break;
                }
                break;
            case -1109722326:
                if (str.equals("layout")) {
                    c = 1;
                    break;
                }
                break;
            case -319766792:
                if (str.equals("removeChild")) {
                    c = 2;
                    break;
                }
                break;
            case 33118136:
                if (str.equals("getElementById")) {
                    c = 3;
                    break;
                }
                break;
            case 96634189:
                if (str.equals("empty")) {
                    c = 4;
                    break;
                }
                break;
            case 253181848:
                if (str.equals("insertBefore")) {
                    c = 5;
                    break;
                }
                break;
            case 434889416:
                if (str.equals("replaceChild")) {
                    c = 6;
                    break;
                }
                break;
            case 1282345597:
                if (str.equals("removeAll")) {
                    c = 7;
                    break;
                }
                break;
        }
        String str2 = null;
        long j = 0;
        switch (c) {
            case 0:
                if (objArr.length > 0 && objArr[0] != null) {
                    j = objArr[0].longValue();
                }
                anchor.appendChild((HMBase) this.mInstanceManager.get(j));
                return null;
            case 1:
                anchor.layout();
                return null;
            case 2:
                if (objArr.length > 0 && objArr[0] != null) {
                    j = objArr[0].longValue();
                }
                anchor.removeChild((HMBase) this.mInstanceManager.get(j));
                return null;
            case 3:
                if (objArr.length > 0 && objArr[0] != null) {
                    str2 = String.valueOf(objArr[0]);
                }
                return anchor.getElementById(str2).getJSValue();
            case 4:
                anchor.empty();
                return null;
            case 5:
                HMBase hMBase = (HMBase) this.mInstanceManager.get((objArr.length <= 0 || objArr[0] == null) ? 0 : objArr[0].longValue());
                if (objArr.length > 1 && objArr[1] != null) {
                    j = objArr[1].longValue();
                }
                anchor.insertBefore(hMBase, (HMBase) this.mInstanceManager.get(j));
                return null;
            case 6:
                HMBase hMBase2 = (HMBase) this.mInstanceManager.get((objArr.length <= 0 || objArr[0] == null) ? 0 : objArr[0].longValue());
                if (objArr.length > 1 && objArr[1] != null) {
                    j = objArr[1].longValue();
                }
                anchor.replaceChild(hMBase2, (HMBase) this.mInstanceManager.get(j));
                return null;
            case 7:
                anchor.removeAll();
                return null;
            default:
                return null;
        }
    }
}
