package com.tal.app.thinkacademy.live.business.barrage;

import android.os.Bundle;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;

public final class BarrageDriver extends BaseLivePluginDriver {
    public void onDestroy() {
    }

    public void onMessage(String str, String str2) {
    }

    public BarrageDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
    }
}
