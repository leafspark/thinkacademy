package com.tal.app.thinkacademy.lib.player.rtcplayer;

import java.util.HashMap;

public class RtcPlayerUtil {
    public static final String RtcPlayerLiveKey = "Live";
    private static volatile RtcPlayerUtil utils;
    private HashMap<String, RtcPlayer> map = new HashMap<>();

    private RtcPlayerUtil() {
    }

    public static RtcPlayerUtil getInstance() {
        if (utils == null) {
            synchronized (RtcPlayerUtil.class) {
                if (utils == null) {
                    utils = new RtcPlayerUtil();
                }
            }
        }
        return utils;
    }

    public void put(String str, RtcPlayer rtcPlayer) {
        this.map.put(str, rtcPlayer);
    }

    public RtcPlayer get(String str) {
        return this.map.get(str);
    }

    public void clear() {
        this.map.clear();
    }
}
