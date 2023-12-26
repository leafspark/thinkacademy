package com.xueersi.tborad.extensions.rule;

import android.graphics.Color;
import com.xueersi.lib.graffiti.core.Extension;
import com.xueersi.lib.graffiti.core.ExtensionFactory;
import com.xueersi.tborad.extensions.protractor.ProtractorProtoBean;

public class ProtractorRulerExtension extends BaseRulerExtension<ProtractorProtoBean.ProtractorConfig> {
    public static int BG_FILL_COLOR = Color.parseColor("#E6FFFFFF");
    public static float CENTER_TEXT_SIZE = 0.05f;
    public static boolean DEBUG = false;
    public static final ExtensionFactory FACTORY15 = new ExtensionFactory() {
        public int[] businessTypes() {
            return new int[]{15};
        }

        public int messageType() {
            return 1000;
        }

        public Extension create() {
            return new ProtractorRulerExtension();
        }
    };
    public static float PROTRACTOR_ANGLE_LINE_LENGTH = 1.12f;
    public static int PROTRACTOR_ANGLE_MARK_COLOR = Color.parseColor("#99FFBE28");
    public static float PROTRACTOR_ARC_BG_HEIGHT = 0.1f;
    public static float PROTRACTOR_ARC_CENTER_HEIGHT = 0.1f;
    public static int PROTRACTOR_ARC_COLOR = Color.parseColor("#0D000000");
    public static float PROTRACTOR_ARC_HEIGHT = 0.08f;
    public static int PROTRACTOR_MARK_COLOR = Color.parseColor("#33979797");
    public static int PROTRACTOR_OUT_MARK_COLOR = Color.parseColor("#979797");
    public static float PROTRACTOR_STORE_WIDTH = 0.005f;
    public static int PROTRACTOR_TEXT_COLOR = Color.parseColor("#666666");
    public static float TEXT_SIZE = 0.04f;
    public ProtractorRulerDrawable protractorRulerDrawable = new ProtractorRulerDrawable();

    /* access modifiers changed from: protected */
    public void onSyncRender(final ProtractorProtoBean.ProtractorConfig protractorConfig) {
        super.onSyncRender(protractorConfig);
        if (protractorConfig == null) {
            return;
        }
        if (!protractorConfig.getEnable()) {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    RulerAndCompassesView renderViewNoCreate = ProtractorRulerExtension.this.getRenderViewNoCreate();
                    if (renderViewNoCreate != null) {
                        renderViewNoCreate.removeDrawable(ProtractorRulerExtension.this.protractorRulerDrawable);
                    }
                }
            });
        } else {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    ProtractorRulerExtension.this.protractorRulerDrawable.updateConfig(protractorConfig);
                    RulerAndCompassesView renderView = ProtractorRulerExtension.this.getRenderView();
                    if (renderView != null) {
                        renderView.updateDrawable(ProtractorRulerExtension.this.protractorRulerDrawable);
                    }
                }
            });
        }
    }
}
