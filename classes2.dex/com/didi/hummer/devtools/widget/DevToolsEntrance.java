package com.didi.hummer.devtools.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.devtools.HummerDevTools;
import com.didi.hummer.devtools.R;
import com.didi.hummer.devtools.manager.HummerLogManager;
import com.didi.hummer.devtools.manager.HummerNetManager;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerLayout;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaPositionType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public class DevToolsEntrance {
    private HMBase mConsoleView;
    private HummerLayout mContainer = this.mHummerContext.getContainer();
    private HummerContext mHummerContext;
    private boolean mIsShown;
    private JSContext mJsContext;
    private View mLayoutDevtools;
    private HummerLogManager mLogManager;
    private HummerNetManager mNetManager;
    private HummerDevTools.IParameterInjector mParameterInjector;

    public DevToolsEntrance(HummerContext hummerContext) {
        this.mHummerContext = hummerContext;
        this.mJsContext = hummerContext.getJsContext();
        initView(hummerContext);
    }

    private void initView(Context context) {
        final FloatLayout floatLayout = new FloatLayout(context);
        ViewCompat.setElevation(floatLayout, 10000.0f);
        floatLayout.setOnClickListener(new DevToolsEntrance$$ExternalSyntheticLambda0(this));
        View inflate = XMLParseInstrumentation.inflate(context, R.layout.layout_devtools_btn, (ViewGroup) floatLayout);
        this.mLayoutDevtools = inflate;
        inflate.setFocusableInTouchMode(true);
        this.mLayoutDevtools.setOnKeyListener(new DevToolsEntrance$$ExternalSyntheticLambda1(this));
        ((TextView) this.mLayoutDevtools.findViewById(R.id.tv_js_engine)).setText(getJsEngineString());
        AnonymousClass1 r0 = new HMBase<FloatLayout>(this.mHummerContext, (JSValue) null, (String) null) {
            /* access modifiers changed from: protected */
            public FloatLayout createViewInstance(Context context) {
                return floatLayout;
            }
        };
        r0.getYogaNode().setPositionType(YogaPositionType.ABSOLUTE);
        r0.getYogaNode().setPosition(YogaEdge.END, 0.0f);
        r0.getYogaNode().setPositionPercent(YogaEdge.BOTTOM, 20.0f);
        this.mContainer.addView(r0);
    }

    public /* synthetic */ void lambda$initView$0$DevToolsEntrance(View view) {
        if (!this.mIsShown) {
            openConsoleView();
        } else {
            closeConsoleView();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ boolean lambda$initView$1$DevToolsEntrance(View view, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1 || !this.mIsShown) {
            return false;
        }
        closeConsoleView();
        return true;
    }

    public void setParameterInjector(HummerDevTools.IParameterInjector iParameterInjector) {
        this.mParameterInjector = iParameterInjector;
    }

    public void setLogManager(HummerLogManager hummerLogManager) {
        this.mLogManager = hummerLogManager;
    }

    public void setNetManager(HummerNetManager hummerNetManager) {
        this.mNetManager = hummerNetManager;
    }

    public String getJsEngineString() {
        String simpleName = this.mHummerContext.getClass().getSimpleName();
        simpleName.hashCode();
        char c = 65535;
        switch (simpleName.hashCode()) {
            case -1249906711:
                if (simpleName.equals("NAPIHummerContext")) {
                    c = 0;
                    break;
                }
                break;
            case -767648389:
                if (simpleName.equals("JSCHummerContext")) {
                    c = 1;
                    break;
                }
                break;
            case -148959245:
                if (simpleName.equals("V8HummerContext")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                int jsEngine = HummerSDK.getJsEngine();
                if (jsEngine == 5) {
                    return "NAPI - QuickJS";
                }
                if (jsEngine != 6) {
                    return "Unknown";
                }
                return "NAPI - Hermes";
            case 1:
                int jsEngine2 = HummerSDK.getJsEngine();
                if (jsEngine2 == 1) {
                    return "JSC";
                }
                if (jsEngine2 == 2) {
                    return "QuickJS";
                }
                if (jsEngine2 != 4) {
                    return "Unknown";
                }
                return "Hermes";
            case 2:
                return "V8";
            default:
                return "Unknown";
        }
    }

    private void openConsoleView() {
        this.mIsShown = true;
        if (this.mConsoleView == null) {
            initConsoleView();
        }
        this.mContainer.addView(this.mConsoleView);
        this.mLayoutDevtools.requestFocus();
    }

    private void closeConsoleView() {
        this.mIsShown = false;
        this.mContainer.removeView(this.mConsoleView);
    }

    private void initConsoleView() {
        final ConsoleView consoleView = new ConsoleView(this.mHummerContext);
        consoleView.bindHummerContext(this.mHummerContext);
        consoleView.bindParameterInjector(this.mParameterInjector);
        consoleView.bindLog(this.mLogManager);
        consoleView.bindNet(this.mNetManager);
        ViewCompat.setElevation(consoleView, 9999.0f);
        AnonymousClass2 r0 = new HMBase<ConsoleView>(this.mHummerContext, (JSValue) null, (String) null) {
            /* access modifiers changed from: protected */
            public ConsoleView createViewInstance(Context context) {
                return consoleView;
            }
        };
        this.mConsoleView = r0;
        r0.getYogaNode().setPositionType(YogaPositionType.ABSOLUTE);
        this.mConsoleView.getYogaNode().setWidthPercent(100.0f);
        this.mConsoleView.getYogaNode().setHeightPercent(100.0f);
    }
}
