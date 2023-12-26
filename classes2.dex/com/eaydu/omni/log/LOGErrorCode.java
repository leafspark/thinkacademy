package com.eaydu.omni.log;

import com.igexin.push.fcm.BuildConfig;

public enum LOGErrorCode {
    LOG_Success(0),
    LOG_Fail(1),
    LOG_Connect_timeout(15),
    LOG_Connect_refused(322),
    LOG_Lo_error(17),
    LOG_Server_error(20),
    LOG_Client_error(21),
    LOG_Cameral_error(50),
    LOG_Mic_error(51),
    LOG_Speaker_error(52),
    LOG_Audio_config_error(53),
    LOG_Invalid_token(300),
    LOG_Token_expired(301),
    LOG_Version_error(302),
    LOG_Already_logined(303),
    LOG_Publish_local_error(306),
    LOG_Room_error(BuildConfig.VERSION_CODE),
    LOG_Room_limited(312),
    LOG_Kicked_out(320),
    LOG_Disconnected(321);
    
    public final int value;

    private LOGErrorCode(int i) {
        this.value = i;
    }
}
