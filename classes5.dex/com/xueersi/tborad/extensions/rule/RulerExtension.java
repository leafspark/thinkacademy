package com.xueersi.tborad.extensions.rule;

import android.graphics.Color;
import android.graphics.Typeface;
import com.xueersi.lib.graffiti.core.Extension;
import com.xueersi.lib.graffiti.core.ExtensionFactory;
import com.xueersi.tborad.extensions.rule.RulerProtoBean;

public class RulerExtension extends BaseRulerExtension<RulerProtoBean.RulerConfig> {
    public static int BG_FILL_COLOR = Color.parseColor("#7ff00000");
    public static float BG_HEIGHT = 0.08f;
    public static int BG_RULER_MARK_COLOR = Color.parseColor("#7f0000ff");
    public static boolean DEBUG = false;
    public static final ExtensionFactory FACTORY = new ExtensionFactory() {
        public int[] businessTypes() {
            return new int[]{11};
        }

        public int messageType() {
            return 1000;
        }

        public Extension create() {
            return new RulerExtension();
        }
    };
    public static float FILL_TEXT_PADDING_BOTTOM = 0.01f;
    public static float FILL_TEXT_SIZE = 0.04f;
    public static Typeface FILL_TEXT_TYPEFACE = Typeface.create(Typeface.DEFAULT, 1);
    public static float RULER_BASE_HEIGHT = 0.005f;
    public static int RULER_COLOR = Color.parseColor("#7f000000");
    public static float[] RULER_HEIGHT_LIST = {3.0f * 0.005f, 0.005f, 0.005f, 0.005f, 0.005f, 2.0f * 0.005f, 0.005f, 0.005f, 0.005f, 0.005f};
    public static float RULER_INTERVAL = 0.005f;
    public static float RULER_LINE_WIDTH = 0.005f;
    public static float RULER_MARK_BG_HEIGHT = 0.02f;
    public static boolean RULER_MARK_COLOR_OVERLAY = false;
    public static float RULER_PADDING_LEFT = 0.03f;
    public static float RULER_STORE_WIDTH = 0.01f;
    public static float RULER_TEXT_SIZE = 0.03f;
    public static Typeface RULER_TEXT_TYPEFACE = Typeface.create(Typeface.DEFAULT, 1);
    public RulerDrawable rulerDrawable = new RulerDrawable();

    /* access modifiers changed from: protected */
    public void onSyncRender(final RulerProtoBean.RulerConfig rulerConfig) {
        super.onSyncRender(rulerConfig);
        if (rulerConfig == null) {
            return;
        }
        if (!rulerConfig.getEnable()) {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    RulerAndCompassesView renderViewNoCreate = RulerExtension.this.getRenderViewNoCreate();
                    if (renderViewNoCreate != null) {
                        renderViewNoCreate.removeDrawable(RulerExtension.this.rulerDrawable);
                    }
                }
            });
        } else {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    RulerExtension.this.rulerDrawable.updateConfig(rulerConfig);
                    RulerAndCompassesView renderView = RulerExtension.this.getRenderView();
                    if (renderView != null) {
                        renderView.updateDrawable(RulerExtension.this.rulerDrawable);
                    }
                }
            });
        }
    }
}
