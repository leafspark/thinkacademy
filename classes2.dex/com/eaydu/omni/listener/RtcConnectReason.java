package com.eaydu.omni.listener;

import com.eaydu.omni.RTCEngine;

public class RtcConnectReason {
    public static String getReason(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedUnknown : RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedLeaveChannel : RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedJoinFailed : RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedBannedByServer : RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedInterrupted : RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedJoinSuccess : RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedConnecting;
    }
}
