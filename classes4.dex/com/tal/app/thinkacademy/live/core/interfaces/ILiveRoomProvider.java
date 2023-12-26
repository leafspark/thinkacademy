package com.tal.app.thinkacademy.live.core.interfaces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.live.core.callback.FrameworkRequestCallback;
import com.tal.app.thinkacademy.live.core.callback.LiveActivityCallback;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.lang.ref.WeakReference;
import java.util.Map;

public interface ILiveRoomProvider extends ILifecycle {
    void addActivityCallback(LiveActivityCallback liveActivityCallback);

    void addFrameworkRequestCallBack(FrameworkRequestCallback frameworkRequestCallback);

    void addView(BaseLivePluginDriver baseLivePluginDriver, BaseLivePluginView baseLivePluginView, String str, ViewGroup.LayoutParams layoutParams);

    void backLiveRoom(ExitLiveRoom exitLiveRoom);

    void destroyPlugin(BaseLivePluginDriver baseLivePluginDriver);

    void doPlaying(long j, long j2);

    void doSeiCurrent(long j);

    String getClassType();

    DataStorage getDataStorage();

    Map<String, String> getInitModuleMap();

    IircControllerProvider getIrcControllerProvider();

    WeakReference<Context> getWeakRefContext();

    boolean isBindCourseware();

    boolean isLive();

    boolean isSmallClass();

    void registerPlayerTimeCallback(PlayerTimeCallBack playerTimeCallBack);

    void removeView(View view);

    void showActivityLoading(boolean z);

    void unregisterPlayerTimeCallback(PlayerTimeCallBack playerTimeCallBack);
}
