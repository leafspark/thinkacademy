package com.didi.hummer;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Toast;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.didi.hummer.adapter.http.HttpResponse;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.engine.base.ICallback;
import com.didi.hummer.core.engine.jsc.jni.HummerException;
import com.didi.hummer.core.engine.napi.jni.JSException;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.devtools.DevToolsConfig;
import com.didi.hummer.devtools.HummerDevTools;
import com.didi.hummer.render.style.HummerLayout;
import com.didi.hummer.utils.AssetsUtil;
import com.didi.hummer.utils.FileUtil;
import com.didi.hummer.utils.JsSourceUtil;
import com.didi.hummer.utils.NetworkUtil;
import com.didi.hummer.utils.UIThreadUtil;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class HummerRender {
    private HummerDevTools devTools;
    private HummerContext hmContext;
    private AtomicBoolean isDestroyed;
    private HummerRenderCallback renderCallback;
    private HummerPageTracker tracker;

    public interface HummerRenderCallback {
        void onFailed(Exception exc);

        void onSucceed(HummerContext hummerContext, JSValue jSValue);
    }

    public HummerRender(HummerLayout hummerLayout) {
        this(hummerLayout, (String) null);
    }

    public HummerRender(HummerLayout hummerLayout, String str) {
        this(hummerLayout, str, (DevToolsConfig) null);
    }

    public HummerRender(HummerLayout hummerLayout, String str, DevToolsConfig devToolsConfig) {
        this.isDestroyed = new AtomicBoolean(false);
        HummerPageTracker hummerPageTracker = new HummerPageTracker(str);
        this.tracker = hummerPageTracker;
        hummerPageTracker.trackContextInitStart();
        this.hmContext = Hummer.createContext(hummerLayout, str);
        this.tracker.trackContextInitEnd();
        if (DebugUtil.isDebuggable()) {
            this.devTools = new HummerDevTools(this.hmContext, devToolsConfig);
        }
        HummerRender$$ExternalSyntheticLambda3 hummerRender$$ExternalSyntheticLambda3 = new HummerRender$$ExternalSyntheticLambda3(this);
        if (HummerSDK.getJsEngine() == 5 || HummerSDK.getJsEngine() == 6) {
            JSException.addJSContextExceptionCallback(this.hmContext.getJsContext(), hummerRender$$ExternalSyntheticLambda3);
        } else {
            HummerException.addJSContextExceptionCallback(this.hmContext.getJsContext(), hummerRender$$ExternalSyntheticLambda3);
        }
        this.hmContext.setRenderListener(new HummerRender$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$new$0$HummerRender(Exception exc) {
        HummerContext hummerContext;
        HummerPageTracker hummerPageTracker = this.tracker;
        if (hummerPageTracker != null && (hummerContext = this.hmContext) != null) {
            hummerPageTracker.trackException(hummerContext.getPageUrl(), exc);
        }
    }

    public /* synthetic */ void lambda$new$1$HummerRender(boolean z) {
        if (isSplitChunksMode()) {
            onRenderFinish(z);
        }
    }

    public HummerContext getHummerContext() {
        return this.hmContext;
    }

    public void onStart() {
        this.hmContext.onStart();
    }

    public void onResume() {
        this.hmContext.onResume();
    }

    public void onPause() {
        this.hmContext.onPause();
    }

    public void onStop() {
        this.hmContext.onStop();
    }

    public void onDestroy() {
        this.isDestroyed.set(true);
        this.hmContext.onDestroy();
        this.tracker.trackContextDestroy();
        if (DebugUtil.isDebuggable()) {
            HummerDebugger.release(this.hmContext);
            HummerDevTools hummerDevTools = this.devTools;
            if (hummerDevTools != null) {
                hummerDevTools.release(this.hmContext);
            }
        }
    }

    public boolean onBack() {
        return this.hmContext.onBack();
    }

    public void render(String str) {
        lambda$null$7$HummerRender(str, this.hmContext.getJsSourcePath());
    }

    /* renamed from: render */
    public void lambda$null$7$HummerRender(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !this.isDestroyed.get()) {
            this.tracker.trackRenderStart(this.hmContext.getPageUrl());
            this.hmContext.setJsSourcePath(str2);
            this.tracker.trackJSEvalStart((long) str.length(), str2);
            if (HummerSDK.isSupportBytecode(this.hmContext.getNamespace())) {
                this.hmContext.evaluateJavaScriptAsync(str, str2, new HummerRender$$ExternalSyntheticLambda2(this));
                return;
            }
            this.hmContext.evaluateJavaScript(str, str2);
            processRenderFinish();
        }
    }

    public /* synthetic */ void lambda$render$2$HummerRender(Object obj) {
        processRenderFinish();
    }

    public void render(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0 && !this.isDestroyed.get()) {
            this.tracker.trackRenderStart(this.hmContext.getPageUrl());
            this.hmContext.setJsSourcePath(str);
            this.tracker.trackJSEvalStart((long) bArr.length, str);
            this.hmContext.evaluateBytecode(bArr);
            processRenderFinish();
        }
    }

    private void processRenderFinish() {
        HummerPageTracker hummerPageTracker = this.tracker;
        if (hummerPageTracker != null) {
            hummerPageTracker.trackJSEvalFinish();
        }
        if (!isSplitChunksMode()) {
            onRenderFinish(this.hmContext.getJsPage() != null);
        }
    }

    private void onRenderFinish(boolean z) {
        HummerRenderCallback hummerRenderCallback = this.renderCallback;
        if (hummerRenderCallback != null) {
            if (z) {
                hummerRenderCallback.onSucceed(this.hmContext, getHummerContext().getJsPage());
            } else {
                hummerRenderCallback.onFailed(new RuntimeException("Page is empty!"));
            }
        }
        HummerPageTracker hummerPageTracker = this.tracker;
        if (hummerPageTracker != null) {
            hummerPageTracker.trackRenderFinish(z);
        }
    }

    private boolean isSplitChunksMode() {
        JSValue jSValue = this.hmContext.getJsContext().getJSValue("Hummer");
        return jSValue != null && jSValue.getBoolean("isSplitChunksMode");
    }

    public void renderWithUrl(String str) {
        if (!TextUtils.isEmpty(str) && !this.isDestroyed.get()) {
            if (DebugUtil.isDebuggable()) {
                HummerDebugger.init(this.hmContext, str);
                HummerDevTools hummerDevTools = this.devTools;
                if (hummerDevTools != null) {
                    hummerDevTools.initConnection(this.hmContext, str, new HummerRender$$ExternalSyntheticLambda4(this, str));
                }
            }
            requestJsBundle(str, false);
        }
    }

    public /* synthetic */ void lambda$renderWithUrl$3$HummerRender(String str) {
        requestJsBundle(str, true);
    }

    private void requestJsBundle(String str, boolean z) {
        this.tracker.trackJSFetchStart();
        NetworkUtil.httpGet(str, new HummerRender$$ExternalSyntheticLambda0(this, z, str));
    }

    public /* synthetic */ void lambda$requestJsBundle$4$HummerRender(boolean z, String str, HttpResponse httpResponse) {
        if (this.isDestroyed.get()) {
            HummerRenderCallback hummerRenderCallback = this.renderCallback;
            if (hummerRenderCallback != null) {
                hummerRenderCallback.onFailed(new RuntimeException("Page is destroyed!"));
            }
        } else if (httpResponse == null) {
            HummerRenderCallback hummerRenderCallback2 = this.renderCallback;
            if (hummerRenderCallback2 != null) {
                hummerRenderCallback2.onFailed(new RuntimeException("Http response is empty!"));
            }
        } else if (httpResponse.error.code != 0) {
            HummerRenderCallback hummerRenderCallback3 = this.renderCallback;
            if (hummerRenderCallback3 != null) {
                hummerRenderCallback3.onFailed(new RuntimeException(String.format("Http response error: %d, %s", new Object[]{Integer.valueOf(httpResponse.error.code), httpResponse.error.msg})));
            }
        } else {
            HummerPageTracker hummerPageTracker = this.tracker;
            if (hummerPageTracker != null) {
                hummerPageTracker.trackJSFetchFinish();
            }
            if (DebugUtil.isDebuggable() && z) {
                this.hmContext.onHotReload(str);
            }
            lambda$null$7$HummerRender((String) httpResponse.data, str);
            if (DebugUtil.isDebuggable() && z) {
                Toast.makeText(this.hmContext, "页面已刷新", 0).show();
            }
        }
    }

    public void renderWithAssets(String str) {
        if (this.isDestroyed.get()) {
            HummerRenderCallback hummerRenderCallback = this.renderCallback;
            if (hummerRenderCallback != null) {
                hummerRenderCallback.onFailed(new RuntimeException("Page is destroyed!"));
            }
        } else if (TextUtils.isEmpty(str)) {
            HummerRenderCallback hummerRenderCallback2 = this.renderCallback;
            if (hummerRenderCallback2 != null) {
                hummerRenderCallback2.onFailed(new RuntimeException("assetsPath is empty!"));
            }
        } else {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            Thread thread = new Thread(new HummerRender$$ExternalSyntheticLambda5(this, str));
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        }
    }

    public /* synthetic */ void lambda$renderWithAssets$6$HummerRender(String str) {
        String readFile = AssetsUtil.readFile(str);
        UIThreadUtil.runOnUiThread(new HummerRender$$ExternalSyntheticLambda7(this, readFile, JsSourceUtil.JS_SOURCE_PREFIX_ASSETS + str));
    }

    public void renderWithFile(String str) {
        if (this.isDestroyed.get()) {
            HummerRenderCallback hummerRenderCallback = this.renderCallback;
            if (hummerRenderCallback != null) {
                hummerRenderCallback.onFailed(new RuntimeException("Page is destroyed!"));
            }
        } else if (TextUtils.isEmpty(str)) {
            HummerRenderCallback hummerRenderCallback2 = this.renderCallback;
            if (hummerRenderCallback2 != null) {
                hummerRenderCallback2.onFailed(new RuntimeException("js file path is empty!"));
            }
        } else {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            Thread thread = new Thread(new HummerRender$$ExternalSyntheticLambda6(this, str));
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        }
    }

    public /* synthetic */ void lambda$renderWithFile$8$HummerRender(String str) {
        String readFile = FileUtil.readFile(str);
        UIThreadUtil.runOnUiThread(new HummerRender$$ExternalSyntheticLambda8(this, readFile, JsSourceUtil.JS_SOURCE_PREFIX_FILE + str));
    }

    public void renderWithFile(File file) {
        if (file == null || !file.exists()) {
            HummerRenderCallback hummerRenderCallback = this.renderCallback;
            if (hummerRenderCallback != null) {
                hummerRenderCallback.onFailed(new RuntimeException("js file is not exists!"));
                return;
            }
            return;
        }
        renderWithFile(file.getAbsolutePath());
    }

    public void setRenderCallback(HummerRenderCallback hummerRenderCallback) {
        this.renderCallback = hummerRenderCallback;
    }

    public void setNativeDataToHummer(String str, Map<String, Object> map) {
        if (!this.isDestroyed.get()) {
            this.hmContext.getJsContext().getJSValue("Hummer").set(str, (Object) map);
        }
    }

    public void setJsPageInfo(NavPage navPage) {
        if (!this.isDestroyed.get()) {
            JSValue jSValue = this.hmContext.getJsContext().getJSValue("Hummer");
            if (jSValue != null) {
                jSValue.set("pageInfo", (Object) navPage);
            }
            this.hmContext.setPageUrl(navPage.url);
            this.hmContext.setJsSourcePath(navPage.sourcePath);
            this.tracker.trackPageView(navPage.url);
        }
    }

    public Map<String, Object> getJsPageResult() {
        if (this.isDestroyed.get()) {
            return null;
        }
        Object evaluateJavaScript = this.hmContext.getJsContext().evaluateJavaScript("JSON.stringify(Hummer.pageResult)");
        if (evaluateJavaScript instanceof String) {
            return (Map) HMGsonUtil.fromJson((String) evaluateJavaScript, new TypeToken<Map<String, Object>>() {
            }.getType());
        }
        return null;
    }

    public Intent getJsPageResultIntent() {
        Map<String, Object> jsPageResult = getJsPageResult();
        if (jsPageResult == null) {
            return null;
        }
        Intent intent = new Intent();
        for (String next : jsPageResult.keySet()) {
            Object obj = jsPageResult.get(next);
            if (obj instanceof Serializable) {
                intent.putExtra(next, (Serializable) obj);
            } else if (obj instanceof Parcelable) {
                intent.putExtra(next, (Parcelable) obj);
            }
        }
        return intent;
    }

    public void registerJsPageFunction(String str, ICallback iCallback) {
        if (!this.isDestroyed.get()) {
            HummerContext hummerContext = this.hmContext;
            hummerContext.registerJSFunction(hummerContext.getJsPage(), str, iCallback);
        }
    }
}
