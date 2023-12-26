package com.didi.hummer.context;

import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.engine.base.ICallback;
import com.didi.hummer.core.util.BytecodeCacheUtil;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.core.util.HMLog;
import com.didi.hummer.debug.InvokerAnalyzer;
import com.didi.hummer.module.notifycenter.NotifyCenter;
import com.didi.hummer.module.notifycenter.NotifyCenterInvoker;
import com.didi.hummer.pool.ComponentPool;
import com.didi.hummer.pool.ObjectPool;
import com.didi.hummer.register.HummerRegister$$hummer_sdk;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.component.view.Invoker;
import com.didi.hummer.render.style.HummerLayout;
import com.didi.hummer.utils.EnvUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class HummerContext extends ContextWrapper {
    private static final String HUMMER_ARRAY_PREFIX = "-_-_-_hummer-array_-_-_-";
    private static final String HUMMER_OBJECT_PREFIX = "-_-_-_hummer-object_-_-_-";
    private static final Map<String, String> globalBabelTransScriptMap = new HashMap();
    protected Pattern blankCharPattern;
    protected InvokerAnalyzer invokerAnalyzer;
    protected boolean isJsCreated;
    protected boolean isResumed;
    protected boolean isStarted;
    protected String jsSourcePath;
    protected ComponentPool mComponentPool;
    protected HummerLayout mContainer;
    protected HummerLayout mContent;
    protected HMBase mJSRootView;
    protected JSContext mJsContext;
    protected JSValue mJsPage;
    protected HashMap<String, ICallback> mNativeCallbacks;
    protected HashMap<String, Invoker> mRegistry;
    protected String namespace;
    protected String pageUrl;
    private OnRenderListener renderListener;

    public interface OnRenderListener {
        void onRenderFinished(boolean z);
    }

    protected HummerContext(Context context) {
        super(context);
        this.mComponentPool = new ComponentPool();
        this.jsSourcePath = "";
        this.pageUrl = "";
        this.mRegistry = new HashMap<>();
        this.mNativeCallbacks = new HashMap<>();
        this.blankCharPattern = Pattern.compile("\\s");
    }

    protected HummerContext(HummerLayout hummerLayout) {
        this(hummerLayout, (String) null);
    }

    protected HummerContext(HummerLayout hummerLayout, String str) {
        super(hummerLayout.getContext());
        this.mComponentPool = new ComponentPool();
        this.jsSourcePath = "";
        this.pageUrl = "";
        this.mRegistry = new HashMap<>();
        this.mNativeCallbacks = new HashMap<>();
        this.blankCharPattern = Pattern.compile("\\s");
        HMLog.d("HummerNative", "HummerContext.new");
        this.namespace = str;
        this.mContainer = hummerLayout;
        HummerLayout hummerLayout2 = new HummerLayout(this);
        this.mContent = hummerLayout2;
        hummerLayout2.getYogaNode().setWidthPercent(100.0f);
        this.mContent.getYogaNode().setHeightPercent(100.0f);
        this.mContainer.addView(this.mContent);
        this.invokerAnalyzer = InvokerAnalyzer.init();
    }

    public String getNamespace() {
        return this.namespace;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        HMLog.d("HummerNative", "HummerContext.onCreate");
        registerInvoker(new HummerInvoker());
        registerInvoker(new NotifyCenterInvoker());
        if (HummerSDK.getJsEngine() == 4 || HummerSDK.getJsEngine() == 6) {
            if (HummerSDK.getJsEngine() == 4) {
                this.mJsContext.evaluateJavaScript("function Recycler() {}");
            }
            this.mJsContext.evaluateJavaScript("var Babel = {}");
            this.mJsContext.evaluateJavaScript(HummerDefinition.BABEL, "babel.js");
            this.mJsContext.evaluateJavaScript(HummerDefinition.ES5_CORE, "HummerDefinition_es5.js");
        } else if (HummerSDK.isSupportBytecode(this.namespace)) {
            this.mJsContext.evaluateJavaScript(HummerDefinition.CORE, "HummerDefinition.js");
        } else {
            this.mJsContext.evaluateJavaScriptOnly(HummerDefinition.CORE, "HummerDefinition.js");
        }
        this.mJsContext.set("__IS_DEBUG__", DebugUtil.isDebuggable());
        initEnv(EnvUtil.getHummerEnv(this, this.namespace));
        HummerRegister$$hummer_sdk.init(this);
    }

    public void onStart() {
        HMLog.d("HummerNative", "HummerContext.onStart");
        this.isStarted = true;
        startIfNeed();
    }

    public void onResume() {
        HMLog.d("HummerNative", "HummerContext.onResume");
        this.isResumed = true;
        resumeIfNeed();
    }

    public void onPause() {
        HMLog.d("HummerNative", "HummerContext.onPause");
        this.isResumed = false;
        pause();
    }

    public void onStop() {
        HMLog.d("HummerNative", "HummerContext.onStop");
        this.isStarted = false;
        stop();
    }

    public void onDestroy() {
        HMLog.d("HummerNative", "HummerContext.onDestroy");
        InvokerAnalyzer.release(this.invokerAnalyzer);
        destroy();
        NotifyCenter.release(getContext());
        NotifyCenter.release(this.mJsContext);
        releaseJSContext();
    }

    public boolean onBack() {
        return back();
    }

    public void onHotReload(String str) {
        stop();
        pause();
        destroy();
        NotifyCenter.release(getContext());
        NotifyCenter.release(this.mJsContext);
        BytecodeCacheUtil.removeBytecode(str);
    }

    /* access modifiers changed from: protected */
    public void releaseJSContext() {
        HMLog.d("HummerNative", "HummerContext.releaseJSContext");
        this.mJsContext.release();
    }

    public void render(HMBase hMBase) {
        if (hMBase != null) {
            this.mJSRootView = hMBase;
            JSValue jSValue = hMBase.getJSValue();
            this.mJsPage = jSValue;
            jSValue.protect();
            create();
            HummerLayout hummerLayout = this.mContent;
            if (hummerLayout != null) {
                hummerLayout.removeAllViews();
                this.mContent.addView(hMBase);
            }
            startIfNeed();
            resumeIfNeed();
        }
    }

    public void setRenderListener(OnRenderListener onRenderListener) {
        this.renderListener = onRenderListener;
    }

    public void onRenderFinished(boolean z) {
        OnRenderListener onRenderListener = this.renderListener;
        if (onRenderListener != null) {
            onRenderListener.onRenderFinished(z);
        }
    }

    public HummerLayout getContainer() {
        return this.mContainer;
    }

    public HMBase getJSRootView() {
        return this.mJSRootView;
    }

    public JSValue getJsPage() {
        return this.mJsPage;
    }

    public InvokerAnalyzer getInvokerAnalyzer() {
        return this.invokerAnalyzer;
    }

    public Context getContext() {
        return getBaseContext();
    }

    public JSContext getJsContext() {
        return this.mJsContext;
    }

    public ObjectPool getObjectPool() {
        return this.mComponentPool;
    }

    public String getJsSourcePath() {
        return this.jsSourcePath;
    }

    public void setJsSourcePath(String str) {
        this.jsSourcePath = str;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }

    public void setPageUrl(String str) {
        this.pageUrl = str;
    }

    private void create() {
        this.isJsCreated = true;
        JSValue jSValue = this.mJsPage;
        if (jSValue != null) {
            jSValue.callFunction("onCreate", new Object[0]);
        }
    }

    private void startIfNeed() {
        if (this.isJsCreated && this.isStarted && this.mJsPage != null) {
            this.mComponentPool.onStart();
        }
    }

    private void resumeIfNeed() {
        if (this.isJsCreated && this.isResumed && this.mJsPage != null) {
            this.mComponentPool.onResume();
            this.mJsPage.callFunction("onAppear", new Object[0]);
        }
    }

    private void pause() {
        JSValue jSValue = this.mJsPage;
        if (jSValue != null) {
            jSValue.callFunction("onDisappear", new Object[0]);
        }
        this.mComponentPool.onPause();
    }

    private void stop() {
        this.mComponentPool.onStop();
    }

    private void destroy() {
        JSValue jSValue = this.mJsPage;
        if (jSValue != null) {
            jSValue.callFunction("onDestroy", new Object[0]);
        }
        this.mComponentPool.onDestroy();
    }

    private boolean back() {
        JSValue jSValue = this.mJsPage;
        if (jSValue != null) {
            Object callFunction = jSValue.callFunction("onBack", new Object[0]);
            if (callFunction instanceof Boolean) {
                return ((Boolean) callFunction).booleanValue();
            }
        }
        return false;
    }

    public Object evaluateJavaScript(String str) {
        return evaluateJavaScript(str, "");
    }

    public Object evaluateJavaScript(String str, String str2) {
        if (HummerSDK.getJsEngine() == 4 || HummerSDK.getJsEngine() == 6) {
            str = babelTransformCode(str, str2);
        }
        if (HummerSDK.isSupportBytecode(this.namespace)) {
            return this.mJsContext.evaluateJavaScript(str, str2);
        }
        return this.mJsContext.evaluateJavaScriptOnly(str, str2);
    }

    public void evaluateJavaScriptAsync(String str, String str2, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        if (HummerSDK.getJsEngine() == 4 || HummerSDK.getJsEngine() == 6) {
            str = babelTransformCode(str, str2);
        }
        this.mJsContext.evaluateJavaScriptAsync(str, str2, jSEvaluateCallback);
    }

    public Object evaluateBytecode(byte[] bArr) {
        return this.mJsContext.evaluateBytecode(bArr);
    }

    private String babelTransformCode(String str, String str2) {
        if (str == null || str.contains("__esModule")) {
            return str;
        }
        Map<String, String> map = globalBabelTransScriptMap;
        if (map.containsKey(str2)) {
            return map.get(str2);
        }
        if ("hummer_sdk.js".equals(str2)) {
            return HummerDefinition.ES5_SDK;
        }
        if ("hummer_component.js".equals(str2)) {
            return HummerDefinition.ES5_COMP;
        }
        Object evaluateJavaScript = this.mJsContext.evaluateJavaScript(String.format("Babel.transformCode(`%s`);", new Object[]{(this.blankCharPattern.matcher(str).find() ? str.replace("\\r", "\\\\r").replace("\\n", "\\\\n").replace("\\t", "\\\\t") : str).replace("\\\"", "\\\\\"")}));
        if (!(evaluateJavaScript instanceof String)) {
            return str;
        }
        String str3 = (String) evaluateJavaScript;
        map.put(str2, str3);
        return str3;
    }

    public void registerInvoker(Invoker invoker) {
        if (invoker != null) {
            this.mRegistry.put(invoker.getName(), invoker);
        }
    }

    public Invoker getInvoker(String str) {
        return this.mRegistry.get(str);
    }

    public void registerJSFunction(String str, ICallback iCallback) {
        if (!TextUtils.isEmpty(str) && iCallback != null) {
            makeSureJSFunctionValid(str);
            this.mNativeCallbacks.put(str, iCallback);
        }
    }

    public void registerJSFunction(JSValue jSValue, String str, ICallback iCallback) {
        if (jSValue != null && !TextUtils.isEmpty(str) && iCallback != null) {
            String str2 = str + jSValue.getIdentify();
            this.mNativeCallbacks.put(str2, iCallback);
            jSValue.set(str, (JSCallback) this.mJsContext.evaluateJavaScript(makeJSFunction(str2)));
        }
    }

    private void makeSureJSFunctionValid(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                String str2 = split[i];
                if (i > 0) {
                    sb.append(".");
                }
                sb.append(str2);
                if (i < split.length - 1) {
                    this.mJsContext.evaluateJavaScript(String.format("if (typeof(%s) == 'undefined') %s = {}", new Object[]{sb, sb}));
                } else if (str.equals(sb.toString())) {
                    this.mJsContext.evaluateJavaScript(sb + " = " + makeJSFunction(sb.toString()));
                }
            }
        }
    }

    private String makeJSFunction(String str) {
        return String.format("(...args) => { \nargs = transArgsWithPrefix(...args);\nreturn invoke('Hummer', 0, '%s', ...args); };", new Object[]{str});
    }

    public Object onJsFunctionCall(String str, Object... objArr) {
        if (!this.mNativeCallbacks.containsKey(str)) {
            HMLog.w("HummerNative", String.format("callFromJS: didn't register this function! [%s]", new Object[]{str}));
            return null;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] instanceof String) {
                String str2 = objArr[i];
                if (str2.startsWith(HUMMER_OBJECT_PREFIX)) {
                    objArr[i] = HMGsonUtil.fromJson(str2.replace(HUMMER_OBJECT_PREFIX, ""), Map.class);
                } else if (str2.startsWith(HUMMER_ARRAY_PREFIX)) {
                    objArr[i] = HMGsonUtil.fromJson(str2.replace(HUMMER_ARRAY_PREFIX, ""), List.class);
                }
            }
        }
        HMLog.d("HummerNative", String.format("onJsFunctionCall: <%s> %s", new Object[]{str, Arrays.toString(objArr)}));
        return this.mNativeCallbacks.get(str).call(objArr);
    }

    private void initEnv(Map<String, Object> map) {
        JSValue jSValue;
        this.mJsContext.evaluateJavaScript("Hummer.env = {}");
        JSValue jSValue2 = this.mJsContext.getJSValue("Hummer");
        if (jSValue2 != null && (jSValue = jSValue2.getJSValue("env")) != null) {
            for (String next : map.keySet()) {
                jSValue.set(next, map.get(next));
            }
        }
    }

    public void updateEnv(String str, String str2) {
        JSValue jSValue;
        JSValue jSValue2 = this.mJsContext.getJSValue("Hummer");
        if (jSValue2 != null && (jSValue = jSValue2.getJSValue("env")) != null) {
            jSValue.set(str, str2);
        }
    }
}
