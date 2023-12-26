package com.tal.app.thinkacademy.live.business.mediacontroller.event;

public interface MediaControllerPublicKeys {
    public static final String KEY_ABILITY = "media_controller_ability";
    public static final String KEY_NOTICE = "media_controller_notice";

    public interface NOTICE {
        public static final String ON_HIDE = "media_controller_on_hide";
        public static final String ON_SHOW = "media_controller_on_show";
    }

    public interface RECEIVE {
        public static final String DATA_BUS_HIDE = "media_animOut";
        public static final String DATA_BUS_INTERCEPT = "media_intercept";
        public static final String DATA_BUS_INTERCEPT_CANCEL = "media_intercept_cancel";
        public static final String DATA_BUS_SHOW = "media_animIn";
        public static final String DATA_BUS_UI_PAUSE = "media_pause";
        public static final String DATA_BUS_UI_PLAY = "media_play";
    }
}
