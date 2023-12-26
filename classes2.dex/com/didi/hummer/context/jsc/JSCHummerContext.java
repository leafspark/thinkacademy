package com.didi.hummer.context.jsc;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.jsc.JSCContext;
import com.didi.hummer.core.engine.jsc.jni.HummerBridge;
import com.didi.hummer.core.engine.jsc.jni.HummerException;
import com.didi.hummer.core.engine.jsc.jni.HummerRecycler;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.core.util.ExceptionUtil;
import com.didi.hummer.core.util.HMLog;
import com.didi.hummer.debug.InvokerAnalyzer;
import com.didi.hummer.lifecycle.ILifeCycle;
import com.didi.hummer.render.component.view.Invoker;
import com.didi.hummer.render.style.HummerLayout;

public class JSCHummerContext extends HummerContext implements HummerBridge.InvokeCallback, HummerRecycler.RecycleCallback {
    private HummerBridge bridge;
    private HummerRecycler recycler;

    public JSCHummerContext(Context context) {
        super(context);
        this.mJsContext = JSCContext.create();
        HummerException.addJSContextExceptionCallback(this.mJsContext, new JSCHummerContext$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$new$0$JSCHummerContext(Exception exc) {
        HummerSDK.getException(this.namespace).onException(exc);
        if (DebugUtil.isDebuggable()) {
            JSContext jSContext = this.mJsContext;
            jSContext.evaluateJavaScript("console.error(`" + Log.getStackTraceString(exc) + "`)");
        }
    }

    public JSCHummerContext(HummerLayout hummerLayout) {
        this(hummerLayout, (String) null);
    }

    public JSCHummerContext(HummerLayout hummerLayout, String str) {
        super(hummerLayout, str);
        this.mJsContext = JSCContext.create();
        this.bridge = new HummerBridge(this.mJsContext.getIdentify(), this);
        this.recycler = new HummerRecycler(this.mJsContext.getIdentify(), this);
        HummerException.addJSContextExceptionCallback(this.mJsContext, new JSCHummerContext$$ExternalSyntheticLambda1(this, str));
        onCreate();
    }

    public /* synthetic */ void lambda$new$1$JSCHummerContext(String str, Exception exc) {
        ExceptionUtil.addStackTrace(exc, new StackTraceElement("<<Bundle>>", "", this.jsSourcePath, -1));
        HummerSDK.getException(str).onException(exc);
        if (DebugUtil.isDebuggable()) {
            JSContext jSContext = this.mJsContext;
            jSContext.evaluateJavaScript("console.error(`" + Log.getStackTraceString(exc) + "`)");
            Toast.makeText(HummerSDK.appContext, exc.getMessage(), 0).show();
        }
    }

    public void releaseJSContext() {
        HummerException.removeJSContextExceptionCallback(this.mJsContext);
        HummerBridge hummerBridge = this.bridge;
        if (hummerBridge != null) {
            hummerBridge.onDestroy();
        }
        HummerRecycler hummerRecycler = this.recycler;
        if (hummerRecycler != null) {
            hummerRecycler.onDestroy();
        }
        super.releaseJSContext();
    }

    public Object onInvoke(String str, long j, String str2, Object... objArr) {
        InvokerAnalyzer.startTrack(this.invokerAnalyzer, str, j, str2, objArr);
        Invoker invoker = (Invoker) this.mRegistry.get(str);
        if (invoker == null) {
            HMLog.w("HummerNative", String.format("Invoker error: can't find this class [%s]", new Object[]{str}));
            return null;
        }
        Object onInvoke = invoker.onInvoke(this, j, str2, objArr);
        InvokerAnalyzer.stopTrack(this.invokerAnalyzer);
        return onInvoke;
    }

    public void onRecycle(long j) {
        HMLog.v("HummerNative", "** onRecycle, objId = " + j);
        Object remove = getObjectPool().remove(j);
        if (remove instanceof ILifeCycle) {
            ((ILifeCycle) remove).onDestroy();
        }
    }
}
