package com.didi.hummer.core.engine.jsc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.base.IRecycler;
import com.didi.hummer.core.engine.jsc.jni.JavaScriptRuntime;
import com.didi.hummer.core.engine.jsc.jni.TypeConvertor;
import com.didi.hummer.core.util.BytecodeCacheUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JSCContext extends JSCValue implements JSContext {
    private ExecutorService jsExecutor;
    private Handler mainHandler;

    public void setRecycler(IRecycler iRecycler) {
    }

    public static JSCContext create() {
        return wrapper(JavaScriptRuntime.createJSContext());
    }

    public static JSCContext wrapper(long j) {
        return new JSCContext(j);
    }

    private JSCContext(long j) {
        super(j, -1);
    }

    public Object evaluateJavaScript(String str) {
        return evaluateJavaScript(str, "");
    }

    public Object evaluateJavaScript(String str, String str2) {
        long j;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            j = JavaScriptRuntime.evaluateJavaScript(this.context, str, str2);
        } else {
            byte[] bytecode = BytecodeCacheUtil.getBytecode(str2);
            if (bytecode == null || bytecode.length <= 0) {
                bytecode = JavaScriptRuntime.compileJavaScript(this.context, str, str2);
            }
            if (bytecode == null || bytecode.length <= 0) {
                j = JavaScriptRuntime.evaluateJavaScript(this.context, str, str2);
            } else {
                BytecodeCacheUtil.putBytecode(str2, bytecode);
                j = JavaScriptRuntime.evaluateBytecode(this.context, bytecode);
            }
        }
        return JSCUtils.jsValueToObject(this.context, j);
    }

    public Object evaluateJavaScriptOnly(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        return JSCUtils.jsValueToObject(this.context, JavaScriptRuntime.evaluateJavaScript(this.context, str, str2));
    }

    public void evaluateJavaScriptAsync(String str, String str2, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        byte[] bytecode = BytecodeCacheUtil.getBytecode(str2);
        if (bytecode == null || bytecode.length <= 0) {
            if (this.jsExecutor == null) {
                this.jsExecutor = Executors.newSingleThreadExecutor();
            }
            this.jsExecutor.submit(new JSCContext$$ExternalSyntheticLambda0(this, str, str2, jSEvaluateCallback));
            return;
        }
        Object jsValueToObject = JSCUtils.jsValueToObject(this.context, JavaScriptRuntime.evaluateBytecode(this.context, bytecode));
        if (jSEvaluateCallback != null) {
            jSEvaluateCallback.onJSEvaluated(jsValueToObject);
        }
    }

    public /* synthetic */ void lambda$evaluateJavaScriptAsync$1$JSCContext(String str, String str2, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        JSCContext create = create();
        byte[] compileJavaScript = JavaScriptRuntime.compileJavaScript(create.context, str, str2);
        BytecodeCacheUtil.putBytecode(str2, compileJavaScript);
        create.release();
        if (this.mainHandler == null) {
            this.mainHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.mainHandler;
        JSCContext$$ExternalSyntheticLambda1 jSCContext$$ExternalSyntheticLambda1 = new JSCContext$$ExternalSyntheticLambda1(this, compileJavaScript, jSEvaluateCallback);
        if (!(handler instanceof Handler)) {
            handler.post(jSCContext$$ExternalSyntheticLambda1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, jSCContext$$ExternalSyntheticLambda1);
        }
    }

    public /* synthetic */ void lambda$evaluateJavaScriptAsync$0$JSCContext(byte[] bArr, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        Object jsValueToObject = JSCUtils.jsValueToObject(this.context, JavaScriptRuntime.evaluateBytecode(this.context, bArr));
        if (jSEvaluateCallback != null) {
            jSEvaluateCallback.onJSEvaluated(jsValueToObject);
        }
    }

    public Object evaluateBytecode(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return JSCUtils.jsValueToObject(this.context, JavaScriptRuntime.evaluateBytecode(this.context, bArr));
    }

    public long getIdentify() {
        return this.context;
    }

    public void release() {
        ExecutorService executorService = this.jsExecutor;
        if (executorService != null) {
            executorService.shutdown();
        }
        Handler handler = this.mainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        JavaScriptRuntime.destroyJSContext(this.context);
    }

    public boolean isValid() {
        return TypeConvertor.isJSContextValid(this.context);
    }
}
