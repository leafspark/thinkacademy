package com.wushuangtech.handler;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.view.Display;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;

public class AVRouterHandler {
    private static final String TAG = "AVRouterHandler";
    private boolean mAudioUpstream;
    private final Object mLock = new Object();
    private boolean mScreenCastEnabled;

    public void updateRouter(Context context) {
        MediaRouter mediaRouter = (MediaRouter) context.getSystemService("media_router");
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (mediaRouter != null && displayManager != null) {
            Display[] displays = displayManager.getDisplays();
            MediaRouter.RouteInfo selectedRoute = mediaRouter.getSelectedRoute(2);
            if (selectedRoute != null) {
                MediaRouter.RouteInfo defaultRoute = mediaRouter.getDefaultRoute();
                boolean equals = defaultRoute.getName().equals(selectedRoute.getName().toString());
                boolean z = true;
                if (equals && displays.length <= 1) {
                    z = false;
                }
                if (this.mScreenCastEnabled != z) {
                    synchronized (this.mLock) {
                        this.mScreenCastEnabled = z;
                        GlobalConfig.mScreenCastEnabled = z;
                        updateAudioStream();
                    }
                }
            }
        }
    }

    public void updateAVUpstreamStatus(boolean z) {
        if (z != this.mAudioUpstream) {
            synchronized (this.mLock) {
                this.mAudioUpstream = z;
                updateAudioStream();
            }
        }
    }

    private void updateAudioStream() {
        boolean z = !GlobalConfig.mScreenCastEnabled || this.mAudioUpstream;
        OmniLog.i(TAG, "ScreenCastEnabled : " + GlobalConfig.mScreenCastEnabled + " | AudioUpstream : " + this.mAudioUpstream + " | useVoip : " + z);
    }
}
