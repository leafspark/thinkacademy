package com.eaydu.omni.log;

import org.json.JSONObject;

public abstract class LogReportBase {

    public interface LogSendListener<T> {
        void onNeedlogUpload(T t, boolean z);
    }

    public abstract void addDeviceInfo(String str, String str2, String str3);

    public abstract void addImportantEvents(String str, String str2, String str3);

    public abstract void addImportantEvents(String str, String str2, String str3, long j);

    /* access modifiers changed from: protected */
    public abstract void addToBlockingQueue(JSONObject jSONObject);

    public abstract void joinRoom(int i, long j, int i2, String str, int i3);

    public abstract void leaveRoom(String str, long j, int i, String str2, long j2);

    public void pushRtmpState(String str, String str2, String str3) {
    }

    public abstract void roomDisconnect(String str, long j, int i, String str2);

    public abstract void roomReconnect(String str, long j, int i, long j2, long j3, int i2);

    public abstract void scheduler(String str, long j, int i, String str2, int i2, String str3);

    public void sendCommonError(String str, String str2, String str3, String str4) {
    }
}
