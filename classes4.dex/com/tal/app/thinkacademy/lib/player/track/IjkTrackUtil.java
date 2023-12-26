package com.tal.app.thinkacademy.lib.player.track;

import android.net.Uri;
import com.tal.app.thinkacademy.lib.track.HwTrackLibUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J^\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011J[\u0010\u0017\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0002\u0010\u0019JJ\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011JL\u0010 \u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/track/IjkTrackUtil;", "", "()V", "trackLoginFailEvent", "", "errorMsg", "", "trackLoginSuccessEvent", "trackPlayFailEvent", "playerScene", "Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "url", "errorType", "Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayFailType;", "videoActionType", "Lcom/tal/app/thinkacademy/lib/player/track/VideoActionType;", "enableCache", "", "startPos", "", "cacheDuration", "isStartPlayHitCache", "isOtherLine", "trackPlaySuccessEvent", "duration", "(Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;Ljava/lang/String;Ljava/lang/Long;Lcom/tal/app/thinkacademy/lib/player/track/VideoActionType;ZJJZZ)V", "trackPlayerLookCostTime", "loadingTime", "lookTotalTime", "loadingCount", "", "startHitCache", "trackStartPlayEvent", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IjkTrackUtil.kt */
public final class IjkTrackUtil {
    public static final IjkTrackUtil INSTANCE = new IjkTrackUtil();

    private IjkTrackUtil() {
    }

    public final void trackLoginSuccessEvent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "success");
            HwTrackLibUtil.INSTANCE.track("hw_video_player_init", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackLoginFailEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "fail");
            if (str != null) {
                jSONObject.put("error_msg", str);
            }
            HwTrackLibUtil.INSTANCE.track("hw_video_player_init", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackStartPlayEvent(VideoPlayerSceneType videoPlayerSceneType, String str, VideoActionType videoActionType, boolean z, long j, long j2, boolean z2, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "start");
            if (videoPlayerSceneType != null) {
                jSONObject.put("video_player_scene", videoPlayerSceneType.getValue());
            }
            if (videoActionType != null) {
                jSONObject.put("type", videoActionType.getValue());
            }
            if (str != null) {
                jSONObject.put("video_player_url", str);
            }
            jSONObject.put("video_player_enable_cache", z);
            jSONObject.put("video_player_start_position", j);
            jSONObject.put("video_player_start_cache_duration", j2);
            jSONObject.put("video_player_start_is_hit_cache", z2);
            jSONObject.put("video_is_other_line", z3);
            HwTrackLibUtil.INSTANCE.track("hw_video_player", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackPlaySuccessEvent(VideoPlayerSceneType videoPlayerSceneType, String str, Long l, VideoActionType videoActionType, boolean z, long j, long j2, boolean z2, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "success");
            if (videoPlayerSceneType != null) {
                jSONObject.put("video_player_scene", videoPlayerSceneType.getValue());
            }
            if (str != null) {
                jSONObject.put("video_player_url", str);
            }
            if (l != null) {
                jSONObject.put("video_player_duration", l.longValue());
            }
            if (videoActionType != null) {
                jSONObject.put("type", videoActionType.getValue());
            }
            jSONObject.put("video_player_enable_cache", z);
            jSONObject.put("video_player_start_position", j);
            jSONObject.put("video_player_start_cache_duration", j2);
            jSONObject.put("video_player_start_is_hit_cache", z2);
            jSONObject.put("video_is_other_line", z3);
            HwTrackLibUtil.INSTANCE.track("hw_video_player", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackPlayFailEvent(VideoPlayerSceneType videoPlayerSceneType, String str, VideoPlayFailType videoPlayFailType, String str2, VideoActionType videoActionType, boolean z, long j, long j2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(videoPlayFailType, "errorType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "fail");
            if (videoPlayerSceneType != null) {
                jSONObject.put("video_player_scene", videoPlayerSceneType.getValue());
            }
            if (str != null) {
                jSONObject.put("video_player_url", str);
            }
            if (videoActionType != null) {
                jSONObject.put("type", videoActionType.getValue());
            }
            jSONObject.put("error_type", videoPlayFailType.getValue());
            if (str2 != null) {
                jSONObject.put("error_msg", str2);
            }
            jSONObject.put("video_player_enable_cache", z);
            jSONObject.put("video_player_start_position", j);
            jSONObject.put("video_player_start_cache_duration", j2);
            jSONObject.put("video_player_start_is_hit_cache", z2);
            jSONObject.put("video_is_other_line", z3);
            HwTrackLibUtil.INSTANCE.track("hw_video_player", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackPlayerLookCostTime(long j, long j2, int i, String str, VideoPlayerSceneType videoPlayerSceneType, boolean z, boolean z2, boolean z3) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            String str3 = null;
            try {
                str2 = Uri.parse(str).getHost();
            } catch (Exception unused) {
                str2 = null;
            }
            jSONObject.put("video_player_loading_count", i);
            jSONObject.put("video_player_loading_time", j);
            jSONObject.put("video_player_look_total_time", j2);
            if (videoPlayerSceneType != null) {
                str3 = videoPlayerSceneType.getValue();
            }
            jSONObject.put("video_player_scene", str3);
            jSONObject.put("video_player_url", str);
            jSONObject.put("video_player_url_host", str2);
            jSONObject.put("video_player_enable_cache", z);
            jSONObject.put("video_player_start_is_hit_cache", z2);
            jSONObject.put("video_is_other_line", z3);
            HwTrackLibUtil.INSTANCE.track("hw_video_player_loading_duration", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
