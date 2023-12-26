package com.dianping.logan;

public interface LoganProtocolHandler {
    String getCurrentFileName();

    void logan_debug(boolean z);

    void logan_flush();

    void logan_init(String str, String str2, int i, String str3, String str4);

    void logan_open(String str);

    void logan_write(int i, String str, long j, String str2, String str3, String str4, String str5, int i2, long j2, boolean z);

    void setOnLoganProtocolStatus(OnLoganProtocolStatus onLoganProtocolStatus);
}
