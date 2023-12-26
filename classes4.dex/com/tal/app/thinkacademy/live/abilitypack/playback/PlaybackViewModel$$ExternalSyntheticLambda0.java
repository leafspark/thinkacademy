package com.tal.app.thinkacademy.live.abilitypack.playback;

import com.tal.app.thinkacademy.live.core.callback.FrameworkRequestCallback;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;

public final /* synthetic */ class PlaybackViewModel$$ExternalSyntheticLambda0 implements FrameworkRequestCallback {
    public final /* synthetic */ ILiveRoomProvider f$0;
    public final /* synthetic */ PlaybackViewModel f$1;

    public /* synthetic */ PlaybackViewModel$$ExternalSyntheticLambda0(ILiveRoomProvider iLiveRoomProvider, PlaybackViewModel playbackViewModel) {
        this.f$0 = iLiveRoomProvider;
        this.f$1 = playbackViewModel;
    }

    public final void onMetaDataRequestSuccess() {
        PlaybackViewModel.m140_init_$lambda1(this.f$0, this.f$1);
    }
}
