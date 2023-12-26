package com.xueersi.lib.graffiti.core;

import android.view.View;

public interface RenderServer {

    public enum Level {
        ABOVE_GRAFFITI,
        ABOVE_SHAPE,
        ABOVE_REALTIME,
        LOWEST
    }

    void addView(Level level, View view);

    <T extends View> T findViewById(int i);

    void removeView(View view);
}
