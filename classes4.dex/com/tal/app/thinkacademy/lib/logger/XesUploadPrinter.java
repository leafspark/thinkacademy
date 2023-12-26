package com.tal.app.thinkacademy.lib.logger;

import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class XesUploadPrinter implements XesLogPrinter {
    private static final String DEBUG_URL = "https://oversea-api-beta.thethinkacademy.com/app-log/push";
    private static final String RELEASE_URL = "https://oversea-api.thethinkacademy.com/app-log/push";
    private static XesUploadPrinter instance;
    private String logPath;
    private String mSchoolCode = "";
    private String mToken = "";
    private String mUid = "";

    public void print(XesLogConfig xesLogConfig, int i, String str, String str2) {
    }

    public XesUploadPrinter(String str) {
        this.logPath = str;
    }

    public static XesUploadPrinter getInstance(String str) {
        if (instance == null) {
            instance = new XesUploadPrinter(str);
        }
        return instance;
    }

    public void setUserInfo(String str, String str2, String str3) {
        this.mUid = str;
        this.mSchoolCode = str2;
        this.mToken = str3;
    }

    public void printServerJsonObject(int i, String str, JsonObject jsonObject) {
        XesLogExtraBean instance2 = XesLogExtraBean.getInstance();
        try {
            instance2.setUserId(Integer.valueOf(this.mUid).intValue());
        } catch (NumberFormatException unused) {
        }
        instance2.setSchoolCode(this.mSchoolCode);
        doSendLogToServerJsonObject(new XesLogJsonObjectBean(str, i + "", jsonObject, instance2));
    }

    private void doSendLogToServerJsonObject(XesLogJsonObjectBean xesLogJsonObjectBean) {
        postRequestServer(RELEASE_URL, xesLogJsonObjectBean);
    }

    private void postRequestServer(String str, XesLogJsonObjectBean xesLogJsonObjectBean) {
        Call<ResponseBody> uploadLog = ((UploadServer) Api.create(UploadServer.class)).uploadLog(str, xesLogJsonObjectBean);
        AnonymousClass2 r3 = new OmyCallback<ResponseBody>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
                XesLog.et("postRequestServer_error", str);
            }
        }) {
            public void onSuccess(ResponseBody responseBody) {
            }
        };
        if (!(uploadLog instanceof Call)) {
            uploadLog.enqueue(r3);
        } else {
            Retrofit2Instrumentation.enqueue((Call) uploadLog, r3);
        }
    }
}
