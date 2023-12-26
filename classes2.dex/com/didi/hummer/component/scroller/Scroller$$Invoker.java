package com.didi.hummer.component.scroller;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.didi.hummer.render.component.view.HMBase;
import com.google.gson.reflect.TypeToken;

public class Scroller$$Invoker extends BaseInvoker<Scroller> {
    public String getName() {
        return "Scroller";
    }

    /* access modifiers changed from: protected */
    public Scroller createInstance(JSValue jSValue, Object[] objArr) {
        return new Scroller(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(Scroller scroller, String str, Object[] objArr) {
        str.hashCode();
        boolean z = false;
        char c = 65535;
        switch (str.hashCode()) {
            case -1912367582:
                if (str.equals("appendChild")) {
                    c = 0;
                    break;
                }
                break;
            case -1528894575:
                if (str.equals("updateContentSize")) {
                    c = 1;
                    break;
                }
                break;
            case -1352024204:
                if (str.equals("stopPullRefresh")) {
                    c = 2;
                    break;
                }
                break;
            case -1250991063:
                if (str.equals("setBounces")) {
                    c = 3;
                    break;
                }
                break;
            case -1109722326:
                if (str.equals("layout")) {
                    c = 4;
                    break;
                }
                break;
            case -1079012472:
                if (str.equals("setOnScrollToBottomListener")) {
                    c = 5;
                    break;
                }
                break;
            case -938100109:
                if (str.equals("scrollToBottom")) {
                    c = 6;
                    break;
                }
                break;
            case -830663505:
                if (str.equals("getSubview")) {
                    c = 7;
                    break;
                }
                break;
            case -692803550:
                if (str.equals("setLoadMoreView")) {
                    c = 8;
                    break;
                }
                break;
            case -402165756:
                if (str.equals("scrollBy")) {
                    c = 9;
                    break;
                }
                break;
            case -402165208:
                if (str.equals("scrollTo")) {
                    c = 10;
                    break;
                }
                break;
            case -333855302:
                if (str.equals("setOnRefresh")) {
                    c = 11;
                    break;
                }
                break;
            case -319766792:
                if (str.equals("removeChild")) {
                    c = 12;
                    break;
                }
                break;
            case 171470400:
                if (str.equals("setOnScrollToTopListener")) {
                    c = 13;
                    break;
                }
                break;
            case 253181848:
                if (str.equals("insertBefore")) {
                    c = 14;
                    break;
                }
                break;
            case 434889416:
                if (str.equals("replaceChild")) {
                    c = 15;
                    break;
                }
                break;
            case 495720030:
                if (str.equals("setRefreshView")) {
                    c = 16;
                    break;
                }
                break;
            case 672127869:
                if (str.equals("stopLoadMore")) {
                    c = 17;
                    break;
                }
                break;
            case 796768860:
                if (str.equals("setOnLoadMore")) {
                    c = 18;
                    break;
                }
                break;
            case 1122173511:
                if (str.equals("setShowScrollBar")) {
                    c = 19;
                    break;
                }
                break;
            case 1282345597:
                if (str.equals("removeAll")) {
                    c = 20;
                    break;
                }
                break;
            case 2055128589:
                if (str.equals("scrollToTop")) {
                    c = 21;
                    break;
                }
                break;
        }
        long j = 0;
        String str2 = null;
        switch (c) {
            case 0:
                if (objArr.length > 0 && objArr[0] != null) {
                    j = objArr[0].longValue();
                }
                scroller.appendChild((HMBase) this.mInstanceManager.get(j));
                return null;
            case 1:
                scroller.updateContentSize();
                return null;
            case 2:
                scroller.stopPullRefresh();
                return null;
            case 3:
                if (objArr.length > 0 && objArr[0] != null) {
                    z = objArr[0].booleanValue();
                }
                scroller.setBounces(z);
                return null;
            case 4:
                scroller.layout();
                return null;
            case 5:
                scroller.setOnScrollToBottomListener((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                return null;
            case 6:
                scroller.scrollToBottom();
                return null;
            case 7:
                if (objArr.length > 0 && objArr[0] != null) {
                    str2 = String.valueOf(objArr[0]);
                }
                return scroller.getSubview(str2).getJSValue();
            case 8:
                if (objArr.length > 0 && objArr[0] != null) {
                    j = objArr[0].longValue();
                }
                scroller.setLoadMoreView((HMBase) this.mInstanceManager.get(j));
                return null;
            case 9:
                scroller.scrollBy(objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null, objArr.length > 1 ? (!(objArr[1] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[1]) && !HMGsonUtil.isJsonArray(objArr[1]))) ? objArr[1] : HMGsonUtil.fromJson(objArr[1], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 10:
                scroller.scrollTo(objArr.length > 0 ? (!(objArr[0] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[0]) && !HMGsonUtil.isJsonArray(objArr[0]))) ? objArr[0] : HMGsonUtil.fromJson(objArr[0], new TypeToken<Object>() {
                }.getType()) : null, objArr.length > 1 ? (!(objArr[1] instanceof String) || (!HMGsonUtil.isJsonObject(objArr[1]) && !HMGsonUtil.isJsonArray(objArr[1]))) ? objArr[1] : HMGsonUtil.fromJson(objArr[1], new TypeToken<Object>() {
                }.getType()) : null);
                return null;
            case 11:
                scroller.setOnRefresh((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                return null;
            case 12:
                if (objArr.length > 0 && objArr[0] != null) {
                    j = objArr[0].longValue();
                }
                scroller.removeChild((HMBase) this.mInstanceManager.get(j));
                return null;
            case 13:
                scroller.setOnScrollToTopListener((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                return null;
            case 14:
                HMBase hMBase = (HMBase) this.mInstanceManager.get((objArr.length <= 0 || objArr[0] == null) ? 0 : objArr[0].longValue());
                if (objArr.length > 1 && objArr[1] != null) {
                    j = objArr[1].longValue();
                }
                scroller.insertBefore(hMBase, (HMBase) this.mInstanceManager.get(j));
                return null;
            case 15:
                HMBase hMBase2 = (HMBase) this.mInstanceManager.get((objArr.length <= 0 || objArr[0] == null) ? 0 : objArr[0].longValue());
                if (objArr.length > 1 && objArr[1] != null) {
                    j = objArr[1].longValue();
                }
                scroller.replaceChild(hMBase2, (HMBase) this.mInstanceManager.get(j));
                return null;
            case 16:
                if (objArr.length > 0 && objArr[0] != null) {
                    j = objArr[0].longValue();
                }
                scroller.setRefreshView((HMBase) this.mInstanceManager.get(j));
                return null;
            case 17:
                if (objArr.length > 0 && objArr[0] != null) {
                    z = objArr[0].booleanValue();
                }
                scroller.stopLoadMore(z);
                return null;
            case 18:
                scroller.setOnLoadMore((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                return null;
            case 19:
                if (objArr.length > 0 && objArr[0] != null) {
                    z = objArr[0].booleanValue();
                }
                scroller.setShowScrollBar(z);
                return null;
            case 20:
                scroller.removeAll();
                return null;
            case 21:
                scroller.scrollToTop();
                return null;
            default:
                return null;
        }
    }
}
