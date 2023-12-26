package com.tal.app.thinkacademy.live.core.irc;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/irc/IrcFailEventType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INIT_FAIL", "SET_LIVE_INFO_FAIL", "SET_SDK_PROPERTIES_FAIL", "CALL_LOGIN_METHOD_FAIL", "SDK_PROVISION_FAIL", "CONNECT_FAIL", "LOGIN_FAIL", "CALL_JOIN_ROOM_METHOD_FAIL", "JOIN_ROOM_FAIL", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrcFailEventType.kt */
public enum IrcFailEventType {
    INIT_FAIL("初始化失败"),
    SET_LIVE_INFO_FAIL("设置直播信息失败"),
    SET_SDK_PROPERTIES_FAIL("设置配置信息失败"),
    CALL_LOGIN_METHOD_FAIL("调用登录接口失败"),
    SDK_PROVISION_FAIL("调度失败"),
    CONNECT_FAIL("连接失败"),
    LOGIN_FAIL("登录失败"),
    CALL_JOIN_ROOM_METHOD_FAIL("调用加入房间接口失败"),
    JOIN_ROOM_FAIL("加入房间失败");
    
    private final String value;

    private IrcFailEventType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
