package com.didi.hummer.core.engine.napi;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.base.IRecycler;
import com.didi.hummer.core.engine.napi.jni.JSEngine;
import com.didi.hummer.core.util.BytecodeCacheUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NAPIContext extends NAPIValue implements JSContext {
    private ExecutorService jsExecutor;
    private Handler mainHandler;

    public static NAPIContext create() {
        return wrapper(JSEngine.createJSContext());
    }

    public static NAPIContext wrapper(long j) {
        return new NAPIContext(j);
    }

    private NAPIContext(long j) {
        super(j, -1);
    }

    public Object evaluateJavaScript(String str) {
        return evaluateJavaScript(str, "");
    }

    public Object evaluateJavaScript(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return JSEngine.evaluateJavaScript(this.context, str, str2);
        }
        byte[] bytecode = BytecodeCacheUtil.getBytecode(str2);
        if (bytecode == null || bytecode.length <= 0) {
            bytecode = JSEngine.compileJavaScript(this.context, str, str2);
        }
        if (bytecode == null || bytecode.length <= 0) {
            return JSEngine.evaluateJavaScript(this.context, str, str2);
        }
        BytecodeCacheUtil.putBytecode(str2, bytecode);
        return JSEngine.evaluateBytecode(this.context, bytecode);
    }

    public Object evaluateJavaScriptOnly(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        return JSEngine.evaluateJavaScript(this.context, str, str2);
    }

    public void evaluateJavaScriptAsync(String str, String str2, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        byte[] bytecode = BytecodeCacheUtil.getBytecode(str2);
        if (bytecode == null || bytecode.length <= 0) {
            if (this.jsExecutor == null) {
                this.jsExecutor = Executors.newSingleThreadExecutor();
            }
            this.jsExecutor.submit(new NAPIContext$$ExternalSyntheticLambda0(this, str, str2, jSEvaluateCallback));
            return;
        }
        Object evaluateBytecode = JSEngine.evaluateBytecode(this.context, bytecode);
        if (jSEvaluateCallback != null) {
            jSEvaluateCallback.onJSEvaluated(evaluateBytecode);
        }
    }

    public /* synthetic */ void lambda$evaluateJavaScriptAsync$1$NAPIContext(String str, String str2, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        NAPIContext create = create();
        byte[] compileJavaScript = JSEngine.compileJavaScript(create.context, str, str2);
        BytecodeCacheUtil.putBytecode(str2, compileJavaScript);
        create.release();
        if (this.mainHandler == null) {
            this.mainHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.mainHandler;
        NAPIContext$$ExternalSyntheticLambda1 nAPIContext$$ExternalSyntheticLambda1 = new NAPIContext$$ExternalSyntheticLambda1(this, compileJavaScript, jSEvaluateCallback);
        if (!(handler instanceof Handler)) {
            handler.post(nAPIContext$$ExternalSyntheticLambda1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, nAPIContext$$ExternalSyntheticLambda1);
        }
    }

    public /* synthetic */ void lambda$evaluateJavaScriptAsync$0$NAPIContext(byte[] bArr, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        Object evaluateBytecode = JSEngine.evaluateBytecode(this.context, bArr);
        if (jSEvaluateCallback != null) {
            jSEvaluateCallback.onJSEvaluated(evaluateBytecode);
        }
    }

    public Object evaluateBytecode(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return JSEngine.evaluateBytecode(this.context, bArr);
    }

    public void setRecycler(IRecycler iRecycler) {
        JSEngine.registerJSRecycler(this.context, iRecycler);
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
        JSEngine.unregisterJSCallback(this.context);
        JSEngine.unregisterJSRecycler(this.context);
        JSEngine.destroyJSContext(this.context);
    }

    public boolean isValid() {
        return JSEngine.isJSContextValid(this.context);
    }
}
