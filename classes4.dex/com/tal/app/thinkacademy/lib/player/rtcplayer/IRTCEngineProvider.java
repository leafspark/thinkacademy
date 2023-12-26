package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;

public interface IRTCEngineProvider {

    public interface RTCEngineCallback {
        public static final int ERROR_CODE_INIT = 3;
        public static final int ERROR_CODE_JOIN_ROOM = 4;
        public static final int ERROR_CODE_NETWORK = 1;
        public static final int ERROR_CODE_SERVER = 2;

        void onGetRTCEngine(RTCEngine rTCEngine, RTCChannel rTCChannel);

        void onGetRTCEngineFail(int i, int i2);
    }

    void addEtcEngineEventListener(String str, RtcPlayerEngineEventListener rtcPlayerEngineEventListener);

    int getLinkType();

    int getOnceLastMileQuality();

    void provide(String str, RTCEngineCallback rTCEngineCallback);

    void release();

    void removeRtcEngineEventListener(String str);
}
