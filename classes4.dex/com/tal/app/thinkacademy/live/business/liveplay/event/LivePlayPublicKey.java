package com.tal.app.thinkacademy.live.business.liveplay.event;

public interface LivePlayPublicKey {
    public static final String LIVEVIDEO_EVENT = "live_player";
    public static final String VIDEO_BITMAP_EVENT_KEY = "video_bitmap";
    public static final String VIDEO_SHOT_EVENT_KEY = "video_shot";

    public interface VIDEO_BITMAP {
        public static final String VIDEO_BITMAP_OPERATION_KEY = "video_bitmap_operation";
    }

    public interface VIDEO_SHOT {
        public static final String VIDEO_SHOT_OPERATION_KEY = "video_shot_operation";
    }
}
