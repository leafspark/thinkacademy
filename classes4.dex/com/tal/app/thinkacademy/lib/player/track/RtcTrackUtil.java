package com.tal.app.thinkacademy.lib.player.track;

import android.os.SystemClock;
import com.tal.app.thinkacademy.lib.track.HwTrackLibUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/track/RtcTrackUtil;", "", "()V", "mIsFirst", "", "Ljava/lang/Boolean;", "mStartTime", "", "Ljava/lang/Long;", "trackFailEvent", "", "errorType", "Lcom/tal/app/thinkacademy/lib/player/track/RtcFailEventType;", "errorMsg", "", "trackReStartEvent", "trackStartEvent", "trackSuccessEvent", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcTrackUtil.kt */
public final class RtcTrackUtil {
    public static final RtcTrackUtil INSTANCE = new RtcTrackUtil();
    private static Boolean mIsFirst;
    private static Long mStartTime;

    private RtcTrackUtil() {
    }

    public final void trackStartEvent() {
        mStartTime = Long.valueOf(SystemClock.elapsedRealtime());
        mIsFirst = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "start");
            jSONObject.put("is_first", "是");
            HwTrackLibUtil.INSTANCE.track("hw_rtc_join_room", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackReStartEvent() {
        mStartTime = Long.valueOf(SystemClock.elapsedRealtime());
        mIsFirst = false;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "start");
            jSONObject.put("is_first", "否");
            HwTrackLibUtil.INSTANCE.track("hw_rtc_join_room", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackFailEvent(RtcFailEventType rtcFailEventType, String str) {
        Intrinsics.checkNotNullParameter(rtcFailEventType, "errorType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "fail");
            Boolean bool = mIsFirst;
            if (bool != null) {
                if (bool.booleanValue()) {
                    jSONObject.put("is_first", "是");
                } else {
                    jSONObject.put("is_first", "否");
                }
            }
            jSONObject.put("error_type", rtcFailEventType.getValue());
            if (str != null) {
                jSONObject.put("error_msg", str);
            }
            HwTrackLibUtil.INSTANCE.track("hw_rtc_join_room", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackSuccessEvent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "success");
            Boolean bool = mIsFirst;
            if (bool != null) {
                if (bool.booleanValue()) {
                    jSONObject.put("is_first", "是");
                } else {
                    jSONObject.put("is_first", "否");
                }
            }
            Long l = mStartTime;
            if (l != null) {
                jSONObject.put("rtc_join_room_duration", SystemClock.elapsedRealtime() - l.longValue());
            }
            HwTrackLibUtil.INSTANCE.track("hw_rtc_join_room", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
