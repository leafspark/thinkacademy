package com.tal.app.thinkacademy.lib.utils;

import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.topic.config.TopicConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0007J\u001c\u0010%\u001a\u00020$2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR0\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R$\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0002\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/HeartBeatUtil;", "", "()V", "defaultMap", "Ljava/util/HashMap;", "", "", "getDefaultMap", "()Ljava/util/HashMap;", "ircCodeCount", "getIrcCodeCount$annotations", "getIrcCodeCount", "setIrcCodeCount", "(Ljava/util/HashMap;)V", "ircCurrentCode", "getIrcCurrentCode$annotations", "getIrcCurrentCode", "()I", "setIrcCurrentCode", "(I)V", "kejianStatus", "getKejianStatus$annotations", "getKejianStatus", "setKejianStatus", "rtcDownlinkPacketLossRate", "", "getRtcDownlinkPacketLossRate$annotations", "getRtcDownlinkPacketLossRate", "()F", "setRtcDownlinkPacketLossRate", "(F)V", "rtcRoundTripDelayed", "getRtcRoundTripDelayed$annotations", "getRtcRoundTripDelayed", "setRtcRoundTripDelayed", "clearData", "", "resetMap", "map", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HeartBeatUtil.kt */
public final class HeartBeatUtil {
    public static final HeartBeatUtil INSTANCE;
    private static HashMap<String, Integer> ircCodeCount;
    private static int ircCurrentCode;
    private static int kejianStatus;
    private static float rtcDownlinkPacketLossRate;
    private static int rtcRoundTripDelayed = -1;

    @JvmStatic
    public static /* synthetic */ void getIrcCodeCount$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getIrcCurrentCode$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getKejianStatus$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getRtcDownlinkPacketLossRate$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getRtcRoundTripDelayed$annotations() {
    }

    private HeartBeatUtil() {
    }

    public static final int getKejianStatus() {
        return kejianStatus;
    }

    public static final void setKejianStatus(int i) {
        kejianStatus = i;
    }

    static {
        HeartBeatUtil heartBeatUtil = new HeartBeatUtil();
        INSTANCE = heartBeatUtil;
        ircCodeCount = heartBeatUtil.getDefaultMap();
    }

    public static final HashMap<String, Integer> getIrcCodeCount() {
        return ircCodeCount;
    }

    public static final void setIrcCodeCount(HashMap<String, Integer> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        ircCodeCount = hashMap;
    }

    public static final int getIrcCurrentCode() {
        return ircCurrentCode;
    }

    public static final void setIrcCurrentCode(int i) {
        ircCurrentCode = i;
    }

    public static final int getRtcRoundTripDelayed() {
        return rtcRoundTripDelayed;
    }

    public static final void setRtcRoundTripDelayed(int i) {
        rtcRoundTripDelayed = i;
    }

    public static final float getRtcDownlinkPacketLossRate() {
        return rtcDownlinkPacketLossRate;
    }

    public static final void setRtcDownlinkPacketLossRate(float f) {
        rtcDownlinkPacketLossRate = f;
    }

    private final HashMap<String, Integer> getDefaultMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        resetMap(hashMap);
        return hashMap;
    }

    private final void resetMap(HashMap<String, Integer> hashMap) {
        Map map = hashMap;
        map.put(EnterRoomMuteData.STATUS_UN_MUTE, 0);
        map.put("1", 0);
        map.put("2", 0);
        map.put("3", 0);
        map.put("4", 0);
        map.put(TopicConfig.OPTIONS_TRUEFALSE_TYPE, 0);
    }

    @JvmStatic
    public static final void clearData() {
        INSTANCE.resetMap(ircCodeCount);
        rtcDownlinkPacketLossRate = 0.0f;
    }
}
