package com.didi.hummer.context.napi;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.base.ICallback;
import com.didi.hummer.core.engine.base.IRecycler;
import com.didi.hummer.core.engine.napi.NAPIContext;
import com.didi.hummer.core.engine.napi.jni.JSException;
import com.didi.hummer.core.exception.ExceptionCallback;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.core.util.ExceptionUtil;
import com.didi.hummer.core.util.HMLog;
import com.didi.hummer.debug.InvokerAnalyzer;
import com.didi.hummer.lifecycle.ILifeCycle;
import com.didi.hummer.render.component.view.Invoker;
import com.didi.hummer.render.style.HummerLayout;
import java.util.Arrays;

public class NAPIHummerContext extends HummerContext {
    private ExceptionCallback exceptionCallback;
    private ICallback invoker;
    private IRecycler recycler;

    public /* synthetic */ Object lambda$new$0$NAPIHummerContext(Object[] objArr) {
        Object obj = null;
        if (objArr == null || objArr.length < 3) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        long longValue = objArr[1].longValue();
        String valueOf2 = String.valueOf(objArr[2]);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, 3, objArr.length);
        if (DebugUtil.isDebuggable()) {
            HMLog.d("HummerNative", String.format("[Java invoked][objectID=%d][className=%s][method=%s][params=%s]", new Object[]{Long.valueOf(longValue), valueOf, valueOf2, Arrays.toString(copyOfRange)}));
        }
        Invoker invoker2 = getInvoker(valueOf);
        if (invoker2 == null) {
            HMLog.w("HummerNative", String.format("Invoker error: can't find this class [%s]", new Object[]{valueOf}));
            return null;
        }
        try {
            InvokerAnalyzer.startTrack(this.invokerAnalyzer, valueOf, longValue, valueOf2, objArr);
            obj = invoker2.onInvoke(this, longValue, valueOf2, copyOfRange);
            InvokerAnalyzer.stopTrack(this.invokerAnalyzer);
            return obj;
        } catch (Exception e) {
            String jSErrorStack = ExceptionUtil.getJSErrorStack(this.mJsContext);
            ExceptionUtil.addStackTrace(e, new StackTraceElement("<<JS_Stack>>", "", "\n" + jSErrorStack, -1));
            JSException.nativeException(this.mJsContext, e);
            return obj;
        }
    }

    public /* synthetic */ void lambda$new$1$NAPIHummerContext(long j) {
        HMLog.v("HummerNative", "** onRecycle, objId = " + j);
        Object remove = getObjectPool().remove(j);
        if (remove instanceof ILifeCycle) {
            ((ILifeCycle) remove).onDestroy();
        }
    }

    public /* synthetic */ void lambda$new$2$NAPIHummerContext(Exception exc) {
        ExceptionUtil.addStackTrace(exc, new StackTraceElement("<<Bundle>>", "", this.jsSourcePath, -1));
        HummerSDK.getException(this.namespace).onException(exc);
        if (DebugUtil.isDebuggable()) {
            JSContext jSContext = this.mJsContext;
            jSContext.evaluateJavaScript("console.error(`" + Log.getStackTraceString(exc) + "`)");
            Toast.makeText(HummerSDK.appContext, exc.getMessage(), 0).show();
        }
    }

    public NAPIHummerContext(Context context) {
        super(context);
        this.invoker = new NAPIHummerContext$$ExternalSyntheticLambda0(this);
        this.recycler = new NAPIHummerContext$$ExternalSyntheticLambda1(this);
        this.exceptionCallback = new NAPIHummerContext$$ExternalSyntheticLambda2(this);
        this.mJsContext = NAPIContext.create();
        JSException.addJSContextExceptionCallback(this.mJsContext, new NAPIHummerContext$$ExternalSyntheticLambda3(this));
    }

    public /* synthetic */ void lambda$new$3$NAPIHummerContext(Exception exc) {
        HummerSDK.getException(this.namespace).onException(exc);
        if (DebugUtil.isDebuggable()) {
            JSContext jSContext = this.mJsContext;
            jSContext.evaluateJavaScript("console.error(`" + Log.getStackTraceString(exc) + "`)");
        }
    }

    public NAPIHummerContext(HummerLayout hummerLayout) {
        this(hummerLayout, (String) null);
    }

    public NAPIHummerContext(HummerLayout hummerLayout, String str) {
        super(hummerLayout, str);
        this.invoker = new NAPIHummerContext$$ExternalSyntheticLambda0(this);
        this.recycler = new NAPIHummerContext$$ExternalSyntheticLambda1(this);
        this.exceptionCallback = new NAPIHummerContext$$ExternalSyntheticLambda2(this);
        this.mJsContext = NAPIContext.create();
        this.mJsContext.set("invoke", (Object) this.invoker);
        this.mJsContext.setRecycler(this.recycler);
        JSException.addJSContextExceptionCallback(this.mJsContext, this.exceptionCallback);
        onCreate();
    }

    public void releaseJSContext() {
        JSException.removeJSContextExceptionCallback(this.mJsContext);
        super.releaseJSContext();
    }
}
