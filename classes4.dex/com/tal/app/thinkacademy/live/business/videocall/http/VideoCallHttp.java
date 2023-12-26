package com.tal.app.thinkacademy.live.business.videocall.http;

import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;

public class VideoCallHttp {
    private final ILiveRoomProvider mLiveRoomProvider;

    public VideoCallHttp(ILiveRoomProvider iLiveRoomProvider) {
        this.mLiveRoomProvider = iLiveRoomProvider;
    }
}
