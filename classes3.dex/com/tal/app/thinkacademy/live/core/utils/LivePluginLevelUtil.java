package com.tal.app.thinkacademy.live.core.utils;

import android.view.ViewGroup;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public class LivePluginLevelUtil {
    public static int getLevel(ViewGroup viewGroup, int i, BaseLivePluginView baseLivePluginView) {
        baseLivePluginView.viewLevelTag = i;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            if (i >= ((BaseLivePluginView) viewGroup.getChildAt(childCount)).viewLevelTag) {
                return childCount + 1;
            }
        }
        return 0;
    }
}
