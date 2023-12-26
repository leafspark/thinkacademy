package com.xueersi.tborad.extensions.rule;

import com.xueersi.lib.graffiti.core.Extension;
import com.xueersi.lib.graffiti.core.ExtensionFactory;
import com.xueersi.tborad.extensions.compasses.CompassesProtoBean;

public class CompassesExtension extends BaseRulerExtension<CompassesProtoBean.CompassesConfig> {
    public static float CENTER_HANDLER_HEIGHT = 0.268f;
    public static float CENTER_WIDTH = 0.258f;
    public static boolean DEBUG = false;
    public static final ExtensionFactory FACTORY13 = new ExtensionFactory() {
        public int[] businessTypes() {
            return new int[]{13};
        }

        public int messageType() {
            return 1000;
        }

        public Extension create() {
            return new CompassesExtension();
        }
    };
    public static float LEFT_LEG_WIDTH = 0.07f;
    public static float RIGHT_LEG_WIDTH = 0.1838f;
    public CompassesDrawable compassesDrawable = new CompassesDrawable();

    /* access modifiers changed from: protected */
    public void onSyncRender(final CompassesProtoBean.CompassesConfig compassesConfig) {
        super.onSyncRender(compassesConfig);
        if (compassesConfig == null) {
            return;
        }
        if (!compassesConfig.getEnable()) {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    RulerAndCompassesView renderViewNoCreate = CompassesExtension.this.getRenderViewNoCreate();
                    if (renderViewNoCreate != null) {
                        renderViewNoCreate.removeDrawable(CompassesExtension.this.compassesDrawable);
                    }
                }
            });
        } else {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    RulerAndCompassesView renderView = CompassesExtension.this.getRenderView();
                    CompassesExtension.this.compassesDrawable.updateConfig(compassesConfig, renderView.getContext());
                    if (renderView != null) {
                        renderView.updateDrawable(CompassesExtension.this.compassesDrawable);
                    }
                }
            });
        }
    }
}
