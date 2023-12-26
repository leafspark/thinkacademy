package com.didi.hummer.context;

import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.engine.jsc.JSCValue;
import com.didi.hummer.core.engine.jsc.jni.HummerException;
import com.didi.hummer.core.engine.jsc.jni.TypeConvertor;
import com.didi.hummer.core.exception.JSException;
import com.didi.hummer.core.util.HMJsonUtil;
import com.didi.hummer.render.component.view.BaseInvoker;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.utility.RemUtil;
import com.didi.hummer.tools.JSLogger;
import com.didi.hummer.utils.JsSourceUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

public class HummerInvoker extends BaseInvoker<HMBase> {
    /* access modifiers changed from: protected */
    public HMBase createInstance(JSValue jSValue, Object... objArr) {
        return null;
    }

    public String getName() {
        return "Hummer";
    }

    /* access modifiers changed from: protected */
    public Object invoke(HMBase hMBase, String str, Object... objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1919095251:
                if (str.equals("console.log")) {
                    c = 0;
                    break;
                }
                break;
            case -1899295688:
                if (str.equals("loadScriptWithUrl")) {
                    c = 1;
                    break;
                }
                break;
            case -1743513625:
                if (str.equals("onRenderFinished")) {
                    c = 2;
                    break;
                }
                break;
            case -1717253380:
                if (str.equals("console.debug")) {
                    c = 3;
                    break;
                }
                break;
            case -1715927375:
                if (str.equals("console.error")) {
                    c = 4;
                    break;
                }
                break;
            case -934592106:
                if (str.equals("render")) {
                    c = 5;
                    break;
                }
                break;
            case -655303622:
                if (str.equals("setBasicWidth")) {
                    c = 6;
                    break;
                }
                break;
            case -231490223:
                if (str.equals("loadScript")) {
                    c = 7;
                    break;
                }
                break;
            case 320801679:
                if (str.equals("postException")) {
                    c = 8;
                    break;
                }
                break;
            case 637499109:
                if (str.equals("console.info")) {
                    c = 9;
                    break;
                }
                break;
            case 637904061:
                if (str.equals("console.warn")) {
                    c = 10;
                    break;
                }
                break;
            case 1911106589:
                if (str.equals("getRootView")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                JSLogger.log(this.mHummerContext.getNamespace(), String.valueOf(objArr[0]));
                return null;
            case 1:
                String relativePath2AbsolutePath = JsSourceUtil.relativePath2AbsolutePath(String.valueOf(objArr[0]), this.mHummerContext.getPageUrl());
                HummerAdapter.getScriptLoaderAdapter(this.mHummerContext.getNamespace()).loadScriptWithUrl(relativePath2AbsolutePath, new HummerInvoker$$ExternalSyntheticLambda0(this, objArr.length > 1 ? objArr[1] : null, relativePath2AbsolutePath));
                return null;
            case 2:
                this.mHummerContext.onRenderFinished(objArr[0].booleanValue());
                return null;
            case 3:
                JSLogger.debug(this.mHummerContext.getNamespace(), String.valueOf(objArr[0]));
                return null;
            case 4:
                JSLogger.error(this.mHummerContext.getNamespace(), String.valueOf(objArr[0]));
                return null;
            case 5:
                this.mHummerContext.render((HMBase) this.mInstanceManager.get(objArr[0].longValue()));
                return null;
            case 6:
                RemUtil.BASE_WIDTH = objArr[0].floatValue();
                return null;
            case 7:
                return makeHummerError(this.mHummerContext.evaluateJavaScript(String.valueOf(objArr[0]), "loadScript"));
            case 8:
                Map<String, Object> map = HMJsonUtil.toMap(String.valueOf(objArr[0]));
                HummerException.nativeException(this.mHummerContext.mJsContext, (Exception) new JSException(map.get(AppMeasurementSdk.ConditionalUserProperty.NAME) + ": " + map.get("message") + "\n" + map.get("stack")));
                return null;
            case 9:
                JSLogger.info(this.mHummerContext.getNamespace(), String.valueOf(objArr[0]));
                return null;
            case 10:
                JSLogger.warn(this.mHummerContext.getNamespace(), String.valueOf(objArr[0]));
                return null;
            case 11:
                JSValue jsPage = this.mHummerContext.getJsPage();
                if (HummerSDK.getJsEngine() != 2 || !(jsPage instanceof JSCValue)) {
                    return jsPage;
                }
                JSCValue jSCValue = (JSCValue) jsPage;
                TypeConvertor.JSValueProtect(jSCValue.context, jSCValue.value);
                return jsPage;
            default:
                return this.mHummerContext.onJsFunctionCall(str, objArr);
        }
    }

    public /* synthetic */ void lambda$invoke$1$HummerInvoker(JSCallback jSCallback, String str, String str2, int i, String str3) {
        if (str2 == null) {
            HummerError hummerError = new HummerError(i, str3);
            if (jSCallback != null) {
                jSCallback.call(hummerError);
            }
        } else if (HummerSDK.isSupportBytecode(this.mHummerContext.getNamespace())) {
            this.mHummerContext.evaluateJavaScriptAsync(str2, str, new HummerInvoker$$ExternalSyntheticLambda1(this, jSCallback));
        } else {
            HummerError makeHummerError = makeHummerError(this.mHummerContext.evaluateJavaScript(str2, str));
            if (jSCallback != null) {
                jSCallback.call(makeHummerError);
            }
        }
    }

    public /* synthetic */ void lambda$null$0$HummerInvoker(JSCallback jSCallback, Object obj) {
        HummerError makeHummerError = makeHummerError(obj);
        if (jSCallback != null) {
            jSCallback.call(makeHummerError);
        }
    }

    private HummerError makeHummerError(Object obj) {
        if (HummerSDK.getJsEngine() == 5 || HummerSDK.getJsEngine() == 6) {
            if (obj instanceof JSException) {
                return new HummerError(-1, ((JSException) obj).getMessage());
            }
        } else if ((obj instanceof JSValue) && ((JSValue) obj).stringValue() == null) {
            return new HummerError(-1, "JavaScript evaluate exception");
        }
        return null;
    }
}
