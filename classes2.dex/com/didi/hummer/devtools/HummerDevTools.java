package com.didi.hummer.devtools;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.devtools.invoker.HummerInvokerWrapper;
import com.didi.hummer.devtools.invoker.RequestInvokerWrapper;
import com.didi.hummer.devtools.manager.HummerLogManager;
import com.didi.hummer.devtools.manager.HummerNetManager;
import com.didi.hummer.devtools.widget.DevToolsEntrance;
import com.didi.hummer.devtools.widget.FloatLayout;
import com.didi.hummer.devtools.ws.WebSocketManager;
import com.didi.hummer.render.component.view.HMBase;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaPositionType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class HummerDevTools {
    private DevToolsEntrance entrance;
    private HummerContext hmContext;
    private HummerLogManager logManager;
    private HummerNetManager netManager;
    private WebSocketManager wsManager;

    public interface IHotReloadCallback {
        void onHotReload();
    }

    public interface IParameterInjector {
        void injectParameter(StringBuilder sb);
    }

    @Deprecated
    public static void init(HummerContext hummerContext) {
    }

    @Deprecated
    public static void init(HummerContext hummerContext, IParameterInjector iParameterInjector) {
    }

    public HummerDevTools(HummerContext hummerContext) {
        this(hummerContext, (DevToolsConfig) null);
    }

    public HummerDevTools(HummerContext hummerContext, DevToolsConfig devToolsConfig) {
        this.hmContext = hummerContext;
        this.entrance = new DevToolsEntrance(hummerContext);
        this.wsManager = WebSocketManager.getInstance();
        this.logManager = new HummerLogManager();
        this.hmContext.registerInvoker(new HummerInvokerWrapper(this.logManager));
        this.entrance.setLogManager(this.logManager);
        this.netManager = new HummerNetManager();
        this.hmContext.registerInvoker(new RequestInvokerWrapper(this.netManager));
        this.entrance.setNetManager(this.netManager);
        if (devToolsConfig != null && devToolsConfig.getInjector() != null) {
            this.entrance.setParameterInjector(devToolsConfig.getInjector());
        }
    }

    public void release(HummerContext hummerContext) {
        this.wsManager.release(hummerContext.getPageUrl());
    }

    public void initConnection(HummerContext hummerContext, String str, IHotReloadCallback iHotReloadCallback) {
        connectWebSocket(str, iHotReloadCallback);
        initRefreshView(hummerContext, iHotReloadCallback);
    }

    private void connectWebSocket(String str, IHotReloadCallback iHotReloadCallback) {
        this.wsManager.connect(str, new HummerDevTools$$ExternalSyntheticLambda1(str, iHotReloadCallback));
    }

    static /* synthetic */ void lambda$connectWebSocket$0(String str, IHotReloadCallback iHotReloadCallback, String str2) {
        String urlFromWS = getUrlFromWS(str2);
        if (str != null && str.equalsIgnoreCase(urlFromWS) && iHotReloadCallback != null) {
            iHotReloadCallback.onHotReload();
        }
    }

    private void initRefreshView(HummerContext hummerContext, IHotReloadCallback iHotReloadCallback) {
        final FloatLayout floatLayout = new FloatLayout(hummerContext);
        floatLayout.setOnClickListener(new HummerDevTools$$ExternalSyntheticLambda0(iHotReloadCallback));
        ViewCompat.setElevation(floatLayout, 9000.0f);
        XMLParseInstrumentation.inflate((Context) hummerContext, R.layout.layout_refresh_btn, (ViewGroup) floatLayout);
        AnonymousClass1 r0 = new HMBase<FloatLayout>(hummerContext, (JSValue) null, (String) null) {
            /* access modifiers changed from: protected */
            public FloatLayout createViewInstance(Context context) {
                return floatLayout;
            }
        };
        r0.getYogaNode().setPositionType(YogaPositionType.ABSOLUTE);
        r0.getYogaNode().setPosition(YogaEdge.END, 0.0f);
        r0.getYogaNode().setPositionPercent(YogaEdge.BOTTOM, 50.0f);
        hummerContext.getContainer().addView(r0);
    }

    static /* synthetic */ void lambda$initRefreshView$1(IHotReloadCallback iHotReloadCallback, View view) {
        if (iHotReloadCallback != null) {
            iHotReloadCallback.onHotReload();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private static String getUrlFromWS(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = new JSONObject(str).getJSONObject("params").getString("url");
        } catch (JSONException e) {
            e.printStackTrace();
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2.contains("?") ? str2.substring(0, str2.indexOf("?")) : str2;
    }
}
