package com.tal.app.thinkacademy.live.core.live.constant;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;

public class LiveUrls {
    public static String HTTP_LIVE_BASE = null;
    public static final String LIVE_ENTER = (ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/classroom/student/basic");
    public static final String PLAY_BACK_ENTER = (ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/playback/student/initEntry");
    public static final String PLAY_HEART_BEAT = (ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/duration/student/push");
    public static final String SCHOOL_CODE_SG = "6501";
    public static final String SCHOOL_CODE_UK = "4401";
    public static final String SCHOOL_CODE_US = "415";

    public static class DEFAULT {
        public static final String LIVE_DEFAULT_INIT_MODULE = (LiveUrls.HTTP_LIVE_BASE + "v1/student/classroom/initModule");
    }

    static {
        String str = ImConfig.INSTANCE.getLiveClass() + "/";
        HTTP_LIVE_BASE = str;
        if ("".equals(str)) {
            String string = ShareDataManager.getInstance().getString("school_code", SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
            string.hashCode();
            char c = 65535;
            switch (string.hashCode()) {
                case 51544:
                    if (string.equals(SCHOOL_CODE_US)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1600641:
                    if (string.equals(SCHOOL_CODE_UK)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1661184:
                    if (string.equals(SCHOOL_CODE_SG)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (!AppConfig.DEBUG) {
                        HTTP_LIVE_BASE = "https://us-api.thethinkacademy.com/";
                        break;
                    } else {
                        HTTP_LIVE_BASE = "https://us-api-beta.thethinkacademy.com/";
                        break;
                    }
                case 1:
                    if (!AppConfig.DEBUG) {
                        HTTP_LIVE_BASE = "https://uk-api.thethinkacademy.com/";
                        break;
                    } else {
                        HTTP_LIVE_BASE = "https://uk-api-beta.thethinkacademy.com/";
                        break;
                    }
                case 2:
                    if (!AppConfig.DEBUG) {
                        HTTP_LIVE_BASE = "https://sg-api.thethinkacademy.com/";
                        break;
                    } else {
                        HTTP_LIVE_BASE = "https://sg-api-beta.thethinkacademy.com/";
                        break;
                    }
            }
        }
    }
}
