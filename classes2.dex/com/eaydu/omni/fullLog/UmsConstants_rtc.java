package com.eaydu.omni.fullLog;

import com.eaydu.omni.fullLog.UmsAgent_rtc;
import com.luck.picture.lib.config.PictureConfig;

public class UmsConstants_rtc {
    public static long MaxSizeOfCache = PictureConfig.MB;
    public static long MaxSizeOfGzips = 10485760;
    public static String TINKER_ID = "";
    public static String UMSAGENT_CLIENT_LOG_POST_URL = "https://moblielog.xesv5.com/api/v1/message_android";
    public static UmsAgent_rtc.SendPolicy mReportPolicy = UmsAgent_rtc.SendPolicy.REALTIME;
}
