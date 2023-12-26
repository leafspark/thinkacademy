package com.didi.hummer.module;

import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.google.gson.reflect.TypeToken;

public class Navigator$$Invoker extends BaseInvoker<Navigator> {
    public String getName() {
        return "Navigator";
    }

    /* access modifiers changed from: protected */
    public Navigator createInstance(JSValue jSValue, Object[] objArr) {
        return new Navigator();
    }

    /* access modifiers changed from: protected */
    public Object invoke(Navigator navigator, String str, Object[] objArr) {
        NavPage navPage;
        NavPage navPage2;
        NavPage navPage3;
        NavPage navPage4;
        NavPage navPage5;
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -1561981605:
                if (str.equals("popToPage")) {
                    c = 0;
                    break;
                }
                break;
            case -504772615:
                if (str.equals("openPage")) {
                    c = 1;
                    break;
                }
                break;
            case -395470120:
                if (str.equals("popBack")) {
                    c = 2;
                    break;
                }
                break;
            case -395052928:
                if (str.equals("popPage")) {
                    c = 3;
                    break;
                }
                break;
            case 1058241373:
                if (str.equals("popToRootPage")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (objArr.length > 0) {
                    navPage = (NavPage) ((!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<NavPage>() {
                    }.getType()));
                } else {
                    navPage = null;
                }
                Navigator.popToPage(this.mHummerContext, navPage);
                break;
            case 1:
                if (objArr.length > 0) {
                    navPage2 = (NavPage) ((!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<NavPage>() {
                    }.getType()));
                } else {
                    navPage2 = null;
                }
                Navigator.openPage(this.mHummerContext, navPage2, (objArr.length <= 1 || objArr[1] == null) ? null : objArr[1]);
                break;
            case 2:
                if (objArr.length > 0 && objArr[0] != null) {
                    i = objArr[0].intValue();
                }
                if (objArr.length > 1) {
                    navPage3 = (NavPage) ((!(objArr[1] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[1]) && !HMGsonUtil.isJsonArray(objArr[1]))) ? objArr[1] : HMGsonUtil.fromJson(objArr[1], new TypeToken<NavPage>() {
                    }.getType()));
                } else {
                    navPage3 = null;
                }
                Navigator.popBack(this.mHummerContext, i, navPage3);
                break;
            case 3:
                if (objArr.length > 0) {
                    navPage4 = (NavPage) ((!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<NavPage>() {
                    }.getType()));
                } else {
                    navPage4 = null;
                }
                Navigator.popPage(this.mHummerContext, navPage4);
                break;
            case 4:
                if (objArr.length > 0) {
                    navPage5 = (NavPage) ((!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<NavPage>() {
                    }.getType()));
                } else {
                    navPage5 = null;
                }
                Navigator.popToRootPage(this.mHummerContext, navPage5);
                break;
        }
        return null;
    }
}
