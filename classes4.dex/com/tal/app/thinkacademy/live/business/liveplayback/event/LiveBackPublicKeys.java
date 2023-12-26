package com.tal.app.thinkacademy.live.business.liveplayback.event;

public interface LiveBackPublicKeys {
    public static final String PLAYER_EVENT_KEY = "media_player";
    public static final String PLAYER_STATUS_EVENT_KEY = "player_status";
    public static final String VIDEO_BITMAP_EVENT_KEY = "video_bitmap";
    public static final String VIDEO_SHOT_EVENT_KEY = "video_shot";

    public interface PLAYER_ACTION {
        public static final String PLAYER_OPERATION_CHANGE_MODE = "player_change_mode";
        public static final String PLAYER_OPERATION_CHANGE_SPEED = "player_change_speed";
        public static final String PLAYER_OPERATION_PAUSE = "player_pause";
        public static final String PLAYER_OPERATION_PLAY = "player_play";
        public static final String PLAYER_OPERATION_SEEK_TO = "player_change_progress";
        public static final String PLAYER_OPERATION_STOP = "player_stop";
        public static final String PLAYER_OPERATION_TOGGLE = "player_toggle";
    }

    public interface PLAYER_STATUS {
        public static final String PLAYER_STATUS_OPERATION_COMPLETE = "player_status_complete";
        public static final String PLAYER_STATUS_OPERATION_PAUSE = "player_status_pause";
        public static final String PLAYER_STATUS_OPERATION_PLAY = "player_status_play";
        public static final String PLAYER_STATUS_OPERATION_STOP = "player_status_stop";
    }

    public interface VIDEO_BITMAP {
        public static final String VIDEO_BITMAP_OPERATION_KEY = "video_bitmap_operation";
    }

    public interface VIDEO_SHOT {
        public static final String VIDEO_SHOT_OPERATION_KEY = "video_shot_operation";
    }
}
