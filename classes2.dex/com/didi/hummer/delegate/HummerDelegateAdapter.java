package com.didi.hummer.delegate;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.hummer.HummerConfig;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.component.input.FocusUtil;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.devtools.DevToolsConfig;
import com.didi.hummer.meta.ComponentInvokerIndex;
import com.didi.hummer.meta.ComponentJsCodeInfo;
import com.didi.hummer.render.component.view.Invoker;
import com.didi.hummer.render.style.HummerLayout;
import java.util.Set;

public class HummerDelegateAdapter extends AbsHummerDelegate {
    protected HummerLayout hmContainer;

    /* access modifiers changed from: protected */
    public DevToolsConfig getDevToolsConfig() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getNamespace() {
        return HummerSDK.NAMESPACE_DEFAULT;
    }

    /* access modifiers changed from: protected */
    public void onPageRenderFailed(Exception exc) {
    }

    /* access modifiers changed from: protected */
    public void onPageRenderSucceed(HummerContext hummerContext, JSValue jSValue) {
    }

    public HummerDelegateAdapter(FragmentActivity fragmentActivity, NavPage navPage) {
        super(fragmentActivity, navPage);
    }

    public HummerDelegateAdapter(Fragment fragment, NavPage navPage) {
        super(fragment, navPage);
    }

    /* access modifiers changed from: protected */
    public View initView() {
        HummerLayout hummerLayout = new HummerLayout(this.context);
        this.hmContainer = hummerLayout;
        hummerLayout.setOnTouchListener(new HummerDelegateAdapter$$ExternalSyntheticLambda0(this));
        return this.hmContainer;
    }

    public /* synthetic */ boolean lambda$initView$0$HummerDelegateAdapter(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        FocusUtil.clearFocus(this.context);
        return false;
    }

    /* access modifiers changed from: protected */
    public HummerLayout getHummerLayout() {
        return this.hmContainer;
    }

    /* access modifiers changed from: protected */
    public void initHummerRegister(HummerContext hummerContext) {
        HummerConfig hummerConfig = HummerSDK.getHummerConfig(getNamespace());
        if (hummerConfig != null && hummerConfig.getComponentInvokerIndexes() != null) {
            for (ComponentInvokerIndex next : hummerConfig.getComponentInvokerIndexes()) {
                Set<Invoker> invokerSet = next.getInvokerSet();
                if (invokerSet != null && !invokerSet.isEmpty()) {
                    for (Invoker registerInvoker : invokerSet) {
                        hummerContext.registerInvoker(registerInvoker);
                    }
                }
                ComponentJsCodeInfo jsCodeInfo = next.getJsCodeInfo();
                if (jsCodeInfo != null && !jsCodeInfo.isEmpty()) {
                    hummerContext.evaluateJavaScript(jsCodeInfo.getScript(), jsCodeInfo.getScriptId());
                }
            }
        }
    }
}
