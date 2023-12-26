package com.tal.app.thinkacademy.common.business.browser.server;

import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import java.lang.reflect.Type;

public class JsonUtils {
    public static String successfulJson(Object obj) {
        ReturnData returnData = new ReturnData();
        returnData.setSuccess(true);
        returnData.setErrorCode(AppNetWorkConfigRemoteInfo.MAX_TIME_OUT);
        returnData.setData(obj);
        return GsonUtils.toJson(returnData);
    }

    public static String failedJson(int i, String str) {
        ReturnData returnData = new ReturnData();
        returnData.setSuccess(false);
        returnData.setErrorCode(i);
        returnData.setErrorMsg(str);
        return GsonUtils.toJson(returnData);
    }

    public static String toJsonString(Object obj) {
        return GsonUtils.toJson(obj);
    }

    public static <T> T parseJson(String str, Type type) {
        return GsonUtils.fromJson(str, type);
    }
}
