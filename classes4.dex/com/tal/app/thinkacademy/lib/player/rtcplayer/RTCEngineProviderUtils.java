package com.tal.app.thinkacademy.lib.player.rtcplayer;

import java.util.HashMap;

public class RTCEngineProviderUtils {
    public static final String RtcProviderLiveKey = "Live";
    private static volatile RTCEngineProviderUtils utils;
    private HashMap<String, RTCEngineProvider> map = new HashMap<>();

    private RTCEngineProviderUtils() {
    }

    public static RTCEngineProviderUtils getInstance() {
        if (utils == null) {
            synchronized (RTCEngineProviderUtils.class) {
                if (utils == null) {
                    utils = new RTCEngineProviderUtils();
                }
            }
        }
        return utils;
    }

    public void put(String str, RTCEngineProvider rTCEngineProvider) {
        HashMap<String, RTCEngineProvider> hashMap = this.map;
        if (hashMap != null) {
            hashMap.put(str, rTCEngineProvider);
            return;
        }
        throw new RuntimeException("put RTCEngineProviderUtils map is null");
    }

    public RTCEngineProvider get(String str) {
        HashMap<String, RTCEngineProvider> hashMap = this.map;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        throw new RuntimeException("get RTCEngineProviderUtils map is null");
    }

    public void clear() {
        this.map.clear();
    }
}
