package com.xueersi.tborad.extensions.rule;

import android.graphics.Color;
import android.graphics.Typeface;
import com.xueersi.lib.graffiti.core.Extension;
import com.xueersi.lib.graffiti.core.ExtensionFactory;
import com.xueersi.tborad.extensions.rule.TriangularRulerProtoBean;

public class TriangularRulerExtension extends BaseRulerExtension<TriangularRulerProtoBean.TriangularRulerConfig> {
    public static int BG_FILL_COLOR = Color.parseColor("#405B4837");
    public static int CENTER_COLOR = Color.parseColor("#40ffffff");
    public static boolean CENTER_COLOR_OVERLAY = false;
    public static boolean DEBUG = false;
    public static final ExtensionFactory FACTORY12 = new ExtensionFactory() {
        public int[] businessTypes() {
            return new int[]{12};
        }

        public int messageType() {
            return 1000;
        }

        public Extension create() {
            return new TriangularRulerExtension();
        }
    };
    public static final ExtensionFactory FACTORY14 = new ExtensionFactory() {
        public int[] businessTypes() {
            return new int[]{14};
        }

        public int messageType() {
            return 1000;
        }

        public Extension create() {
            return new TriangularRulerExtension();
        }
    };
    public static Typeface FILL_TEXT_TYPEFACE = Typeface.create(Typeface.DEFAULT, 1);
    public static float RULER_BASE_HEIGHT = 0.01f;
    public static int RULER_COLOR = Color.parseColor("#7f000000");
    public static float[] RULER_HEIGHT_LIST = {3.0f * 0.01f, 0.01f, 0.01f, 0.01f, 0.01f, 2.0f * 0.01f, 0.01f, 0.01f, 0.01f, 0.01f};
    public static float RULER_INTERVAL = 0.005f;
    public static float RULER_LINE_WIDTH = 0.005f;
    public static float RULER_PADDING_LEFT = 0.03f;
    public static float RULER_STORE_WIDTH = 0.001f;
    public static int RULER_TEXT_COLOR = -16777216;
    public static float SIDES_WIDTH = 0.05f;
    public static float TEXT_MARGIN_BOTTOM = 0.01f;
    public static float TEXT_MARGIN_LEFT = 0.01f;
    public static float TEXT_SIZE = 0.04f;
    public TriangularRulerDrawable triangularRulerDrawable = new TriangularRulerDrawable();

    /* access modifiers changed from: protected */
    public void onSyncRender(final TriangularRulerProtoBean.TriangularRulerConfig triangularRulerConfig) {
        super.onSyncRender(triangularRulerConfig);
        if (triangularRulerConfig == null) {
            return;
        }
        if (!triangularRulerConfig.getEnable()) {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    RulerAndCompassesView renderViewNoCreate = TriangularRulerExtension.this.getRenderViewNoCreate();
                    if (renderViewNoCreate != null) {
                        renderViewNoCreate.removeDrawable(TriangularRulerExtension.this.triangularRulerDrawable);
                    }
                }
            });
        } else {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    TriangularRulerExtension.this.triangularRulerDrawable.updateConfig(triangularRulerConfig);
                    RulerAndCompassesView renderView = TriangularRulerExtension.this.getRenderView();
                    if (renderView != null) {
                        renderView.updateDrawable(TriangularRulerExtension.this.triangularRulerDrawable);
                    }
                }
            });
        }
    }
}
