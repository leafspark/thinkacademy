package com.tal.app.thinkacademy.live.business.mediacontroller.event;

public interface MediaControllerPrivateKeys {
    public static final String REGISTER_PLAYER_STATUS = "player_status";
    public static final String SEND_EVENT_PLAYER = "media_player";

    public interface PLAYER_STATUS {
        public static final String ON_COMPLETE = "player_status_complete";
        public static final String ON_ERROR = "player_status_error";
        public static final String ON_PAUSE = "player_status_pause";
        public static final String ON_PLAY = "player_status_play";
        public static final String ON_START_TO_PLAY = "player_status_start_to_play";
        public static final String ON_STOP = "player_status_stop";
    }
}
