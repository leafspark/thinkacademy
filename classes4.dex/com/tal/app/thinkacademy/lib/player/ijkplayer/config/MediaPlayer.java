package com.tal.app.thinkacademy.lib.player.ijkplayer.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/config/MediaPlayer;", "", "()V", "DISPATCH_BASICS_TIME", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "UPPER_LIMIT_TIME", "dispatchMultiple", "", "dispatchNeddedTime", "lastDispatchTime", "getDispatchTime", "handleDispatchTime", "time", "setLastDispatchTimeBlanking", "", "setNextDispatchTime", "Companion", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MediaPlayer.kt */
public final class MediaPlayer {
    public static final int BID_ATTAINMENT_VOD = 10;
    public static final int BID_COACH_LIVE = 1;
    public static final int BID_COURSE_LIVE = 3;
    public static final int BID_COURSE_VOD = 7;
    public static final int BID_EXCELLENT_LIVE = 4;
    public static final int BID_EXCELLENT_VOD = 9;
    public static final int BID_LECTURE_LIVE = 2;
    public static final int BID_LECTURE_VOD = 8;
    public static final int BID_OLD = 1000;
    public static final int BID_ONEVONE_LIVE = 5;
    public static final int BID_UNKNOWN = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long DEFAULT_BUF_SIZE = 524288;
    /* access modifiers changed from: private */
    public static final int PS_CONTENT_MODE_RESIZE_ASPECT_FILL = 2;
    /* access modifiers changed from: private */
    public static final int PS_CONTENT_MODE_RESIZE_ASPECT_FIT = 1;
    /* access modifiers changed from: private */
    public static final int PS_CONTENT_MODE_RESIZE_TO_FILL = 0;
    /* access modifiers changed from: private */
    public static final int STATE_NEED_RESUME = 1;
    /* access modifiers changed from: private */
    public static final int STATE_PLAYING = 0;
    /* access modifiers changed from: private */
    public static final int STATE_PREPARED = -1;
    /* access modifiers changed from: private */
    public static final int STATE_RINGING = 3;
    /* access modifiers changed from: private */
    public static final int STATE_STOPPED = 2;
    /* access modifiers changed from: private */
    public static final int VIDEO_BOTTOM_CONTROL_CODE_TEACHER = 1001;
    /* access modifiers changed from: private */
    public static final int VIDEO_PLAY_LOCAL = 0;
    /* access modifiers changed from: private */
    public static final int VIDEO_PROTOCOL_FLV = 2;
    /* access modifiers changed from: private */
    public static final int VIDEO_PROTOCOL_HLS = 4;
    /* access modifiers changed from: private */
    public static final int VIDEO_PROTOCOL_M3U8 = 6;
    /* access modifiers changed from: private */
    public static final int VIDEO_PROTOCOL_MP4 = 5;
    /* access modifiers changed from: private */
    public static final int VIDEO_PROTOCOL_NO_PROTOL = -1;
    /* access modifiers changed from: private */
    public static final int VIDEO_PROTOCOL_RTMP = 1;
    /* access modifiers changed from: private */
    public static final int VIDEO_TEACHER_HIDE = 0;
    /* access modifiers changed from: private */
    public static final int VIDEO_TEACHER_MAIN = 1;
    /* access modifiers changed from: private */
    public static final int VIDEO_TEACHER_ONLY_MAIN = 3;
    /* access modifiers changed from: private */
    public static final int VIDEO_TEACHER_ONLY_TUTOR = 4;
    /* access modifiers changed from: private */
    public static final int VIDEO_TEACHER_TUTOR = 2;
    /* access modifiers changed from: private */
    public static final int VIDEO_TEACHER_TUTOR_AFTER_CLASS = 6;
    /* access modifiers changed from: private */
    public static final int VIDEO_TEACHER_TUTOR_BEFORE_CLASS = 5;
    private final long DISPATCH_BASICS_TIME = 500;
    private final String TAG = "MediaPlayer";
    private final long UPPER_LIMIT_TIME = 5000;
    private final int dispatchMultiple = 2;
    private long dispatchNeddedTime = 500;
    private long lastDispatchTime = -1;

    public final String getTAG() {
        return this.TAG;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b2\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0014\u0010$\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0014\u0010&\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0015R\u0014\u0010(\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0015R\u0014\u0010*\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u0014\u0010,\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0015R\u0014\u0010.\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0015R\u0014\u00100\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0015R\u0014\u00102\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0015R\u0014\u00104\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0015R\u0014\u00106\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0015R\u0014\u00108\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0015R\u0014\u0010:\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0015R\u0014\u0010<\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0015R\u0014\u0010>\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0015R\u0014\u0010@\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0015¨\u0006B"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/config/MediaPlayer$Companion;", "", "()V", "BID_ATTAINMENT_VOD", "", "BID_COACH_LIVE", "BID_COURSE_LIVE", "BID_COURSE_VOD", "BID_EXCELLENT_LIVE", "BID_EXCELLENT_VOD", "BID_LECTURE_LIVE", "BID_LECTURE_VOD", "BID_OLD", "BID_ONEVONE_LIVE", "BID_UNKNOWN", "DEFAULT_BUF_SIZE", "", "getDEFAULT_BUF_SIZE", "()J", "PS_CONTENT_MODE_RESIZE_ASPECT_FILL", "getPS_CONTENT_MODE_RESIZE_ASPECT_FILL", "()I", "PS_CONTENT_MODE_RESIZE_ASPECT_FIT", "getPS_CONTENT_MODE_RESIZE_ASPECT_FIT", "PS_CONTENT_MODE_RESIZE_TO_FILL", "getPS_CONTENT_MODE_RESIZE_TO_FILL", "STATE_NEED_RESUME", "getSTATE_NEED_RESUME", "STATE_PLAYING", "getSTATE_PLAYING", "STATE_PREPARED", "getSTATE_PREPARED", "STATE_RINGING", "getSTATE_RINGING", "STATE_STOPPED", "getSTATE_STOPPED", "VIDEO_BOTTOM_CONTROL_CODE_TEACHER", "getVIDEO_BOTTOM_CONTROL_CODE_TEACHER", "VIDEO_PLAY_LOCAL", "getVIDEO_PLAY_LOCAL", "VIDEO_PROTOCOL_FLV", "getVIDEO_PROTOCOL_FLV", "VIDEO_PROTOCOL_HLS", "getVIDEO_PROTOCOL_HLS", "VIDEO_PROTOCOL_M3U8", "getVIDEO_PROTOCOL_M3U8", "VIDEO_PROTOCOL_MP4", "getVIDEO_PROTOCOL_MP4", "VIDEO_PROTOCOL_NO_PROTOL", "getVIDEO_PROTOCOL_NO_PROTOL", "VIDEO_PROTOCOL_RTMP", "getVIDEO_PROTOCOL_RTMP", "VIDEO_TEACHER_HIDE", "getVIDEO_TEACHER_HIDE", "VIDEO_TEACHER_MAIN", "getVIDEO_TEACHER_MAIN", "VIDEO_TEACHER_ONLY_MAIN", "getVIDEO_TEACHER_ONLY_MAIN", "VIDEO_TEACHER_ONLY_TUTOR", "getVIDEO_TEACHER_ONLY_TUTOR", "VIDEO_TEACHER_TUTOR", "getVIDEO_TEACHER_TUTOR", "VIDEO_TEACHER_TUTOR_AFTER_CLASS", "getVIDEO_TEACHER_TUTOR_AFTER_CLASS", "VIDEO_TEACHER_TUTOR_BEFORE_CLASS", "getVIDEO_TEACHER_TUTOR_BEFORE_CLASS", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MediaPlayer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getVIDEO_PROTOCOL_NO_PROTOL() {
            return MediaPlayer.VIDEO_PROTOCOL_NO_PROTOL;
        }

        public final int getVIDEO_PLAY_LOCAL() {
            return MediaPlayer.VIDEO_PLAY_LOCAL;
        }

        public final int getVIDEO_PROTOCOL_RTMP() {
            return MediaPlayer.VIDEO_PROTOCOL_RTMP;
        }

        public final int getVIDEO_PROTOCOL_FLV() {
            return MediaPlayer.VIDEO_PROTOCOL_FLV;
        }

        public final int getVIDEO_PROTOCOL_HLS() {
            return MediaPlayer.VIDEO_PROTOCOL_HLS;
        }

        public final int getVIDEO_PROTOCOL_MP4() {
            return MediaPlayer.VIDEO_PROTOCOL_MP4;
        }

        public final int getVIDEO_PROTOCOL_M3U8() {
            return MediaPlayer.VIDEO_PROTOCOL_M3U8;
        }

        public final int getSTATE_PREPARED() {
            return MediaPlayer.STATE_PREPARED;
        }

        public final int getSTATE_PLAYING() {
            return MediaPlayer.STATE_PLAYING;
        }

        public final int getSTATE_NEED_RESUME() {
            return MediaPlayer.STATE_NEED_RESUME;
        }

        public final int getSTATE_STOPPED() {
            return MediaPlayer.STATE_STOPPED;
        }

        public final int getSTATE_RINGING() {
            return MediaPlayer.STATE_RINGING;
        }

        public final long getDEFAULT_BUF_SIZE() {
            return MediaPlayer.DEFAULT_BUF_SIZE;
        }

        public final int getVIDEO_BOTTOM_CONTROL_CODE_TEACHER() {
            return MediaPlayer.VIDEO_BOTTOM_CONTROL_CODE_TEACHER;
        }

        public final int getVIDEO_TEACHER_HIDE() {
            return MediaPlayer.VIDEO_TEACHER_HIDE;
        }

        public final int getVIDEO_TEACHER_MAIN() {
            return MediaPlayer.VIDEO_TEACHER_MAIN;
        }

        public final int getVIDEO_TEACHER_TUTOR() {
            return MediaPlayer.VIDEO_TEACHER_TUTOR;
        }

        public final int getVIDEO_TEACHER_ONLY_MAIN() {
            return MediaPlayer.VIDEO_TEACHER_ONLY_MAIN;
        }

        public final int getVIDEO_TEACHER_ONLY_TUTOR() {
            return MediaPlayer.VIDEO_TEACHER_ONLY_TUTOR;
        }

        public final int getVIDEO_TEACHER_TUTOR_BEFORE_CLASS() {
            return MediaPlayer.VIDEO_TEACHER_TUTOR_BEFORE_CLASS;
        }

        public final int getVIDEO_TEACHER_TUTOR_AFTER_CLASS() {
            return MediaPlayer.VIDEO_TEACHER_TUTOR_AFTER_CLASS;
        }

        public final int getPS_CONTENT_MODE_RESIZE_TO_FILL() {
            return MediaPlayer.PS_CONTENT_MODE_RESIZE_TO_FILL;
        }

        public final int getPS_CONTENT_MODE_RESIZE_ASPECT_FIT() {
            return MediaPlayer.PS_CONTENT_MODE_RESIZE_ASPECT_FIT;
        }

        public final int getPS_CONTENT_MODE_RESIZE_ASPECT_FILL() {
            return MediaPlayer.PS_CONTENT_MODE_RESIZE_ASPECT_FILL;
        }
    }

    public final long getDispatchTime() {
        long currentTimeMillis = System.currentTimeMillis() - this.lastDispatchTime;
        long j = this.dispatchNeddedTime;
        if (currentTimeMillis >= j) {
            return 0;
        }
        return j - currentTimeMillis;
    }

    public final void setNextDispatchTime() {
        this.lastDispatchTime = System.currentTimeMillis();
        this.dispatchNeddedTime = handleDispatchTime(this.dispatchNeddedTime * ((long) this.dispatchMultiple));
    }

    public final void setLastDispatchTimeBlanking() {
        this.dispatchNeddedTime = this.DISPATCH_BASICS_TIME;
    }

    private final long handleDispatchTime(long j) {
        long j2 = this.UPPER_LIMIT_TIME;
        return j > j2 ? j2 : j;
    }
}
