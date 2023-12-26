package com.tal.app.thinkacademy.live.core.interfaces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public interface ILiveActivityProvider extends ILifecycle {
    void addView(BaseLivePluginView baseLivePluginView, int i, ViewGroup.LayoutParams layoutParams);

    void finishActivity();

    Context getContext();

    void otherReasonActivity(ExitLiveRoom exitLiveRoom);

    void removeView(View view);

    void showActivityLoading(boolean z);
}
