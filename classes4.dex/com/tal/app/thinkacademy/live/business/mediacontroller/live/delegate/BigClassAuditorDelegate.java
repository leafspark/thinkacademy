package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import android.content.Context;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlAuditorBigLiveView;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;

public class BigClassAuditorDelegate extends BaseClassRoomTitleBarDelegate {
    private MediaControlAuditorBigLiveView mediaView;

    public void onMessage(String str, String str2) {
    }

    public BaseMediaControlView getMediaView() {
        if (this.mediaView == null) {
            MediaControlAuditorBigLiveView mediaControlAuditorBigLiveView = new MediaControlAuditorBigLiveView(this.mContext, this.mDataStorage);
            this.mediaView = mediaControlAuditorBigLiveView;
            mediaControlAuditorBigLiveView.setDriver(this.mDriver);
        }
        return this.mediaView;
    }

    public void init(Context context, MediaControlLiveDriver mediaControlLiveDriver, DataStorage dataStorage, boolean z) {
        super.init(context, mediaControlLiveDriver, dataStorage, z);
        PluginEventBus.register(this, DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.mDriver.observerScreenShot);
    }

    public void onDestroy() {
        super.onDestroy();
        PluginEventBus.unregister(DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.mDriver.observerScreenShot);
    }
}
