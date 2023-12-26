package com.xueersi.tborad.extensions.rule;

import com.google.protobuf.MessageLite;
import com.xueersi.lib.graffiti.core.BusinessExtension;
import com.xueersi.lib.graffiti.core.RenderServer;
import java.lang.ref.WeakReference;

public abstract class BaseRulerExtension<T extends MessageLite> extends BusinessExtension<T> {
    private WeakReference<RulerAndCompassesView> renderViewRef;

    /* access modifiers changed from: protected */
    public void onTruePage() {
        super.onTruePage();
        this.mainHandler.post(new Runnable() {
            public void run() {
                RulerAndCompassesView renderViewNoCreate = BaseRulerExtension.this.getRenderViewNoCreate();
                if (renderViewNoCreate != null) {
                    renderViewNoCreate.clear();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public RulerAndCompassesView getRenderView() {
        if (this.renderServer == null) {
            return null;
        }
        WeakReference<RulerAndCompassesView> weakReference = this.renderViewRef;
        if (weakReference != null && weakReference.get() != null) {
            return (RulerAndCompassesView) this.renderViewRef.get();
        }
        RulerAndCompassesView rulerAndCompassesView = (RulerAndCompassesView) this.renderServer.findViewById(RulerAndCompassesView.ID);
        if (rulerAndCompassesView != null || getContext() == null) {
            return rulerAndCompassesView;
        }
        RulerAndCompassesView rulerAndCompassesView2 = new RulerAndCompassesView(getContext());
        this.renderServer.addView(RenderServer.Level.ABOVE_REALTIME, rulerAndCompassesView2);
        rulerAndCompassesView2.bringToFront();
        this.renderViewRef = new WeakReference<>(rulerAndCompassesView2);
        return rulerAndCompassesView2;
    }

    /* access modifiers changed from: protected */
    public RulerAndCompassesView getRenderViewNoCreate() {
        if (this.renderServer == null) {
            return null;
        }
        WeakReference<RulerAndCompassesView> weakReference = this.renderViewRef;
        if (weakReference == null || weakReference.get() == null) {
            return (RulerAndCompassesView) this.renderServer.findViewById(RulerAndCompassesView.ID);
        }
        return (RulerAndCompassesView) this.renderViewRef.get();
    }
}
