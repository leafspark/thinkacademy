package com.xueersi.lib.graffiti.view;

import android.content.Context;

public class GraffitiViewFactory {
    public static BaseAsyncGraffitiView create(Context context, boolean z) {
        if (z) {
            return new AsyncGraffitiTextureView(context);
        }
        return new AsyncGraffitiNormalView(context);
    }
}
