package com.tal.app.thinkacademy.lib.restful;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 %*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "T", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "errorData", "", "", "getErrorData", "()Ljava/util/Map;", "setErrorData", "(Ljava/util/Map;)V", "msg", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "rawData", "getRawData", "setRawData", "stat", "getStat", "setStat", "error", "", "successful", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HiResponse.kt */
public class HiResponse<T> {
    public static final String BAD_NETWORK_MSG = "网络问题";
    public static final int CODE_BAD_NETWORK = -8;
    public static final int CODE_EMPTY_MESSAGE = -1;
    public static final int CODE_ERROR_MSG = -9;
    public static final int CODE_LOGIN_EXPIRE = 9;
    public static final int CODE_NEED_UPDATE = 10;
    public static final int CODE_NET_BUSY = 8;
    public static final int CODE_OTHER_ERROR = -2;
    public static final int CODE_PARSE_ERROR = -7;
    public static final int CODE_SSL_ERROR = -11;
    public static final int CODE_TIME_OUT = -10;
    public static final String CONNECT_ERROR_MSG = "连接错误";
    public static final String CONNECT_TIMEOUT_MSG = "连接超时";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MESSAGE_EMPTY_ERROR = "空报文";
    public static final int NOT_ERROR = 0;
    public static final String OTHER_MSG = "未知错误";
    public static final String PARSE_ERROR_MSG = "解析数据失败";
    public static final String SSL_ERROR_MSG = "证书异常";
    public static final int SUCCESS = 1;
    private int code;
    private T data;
    private Map<String, String> errorData;
    private String msg;
    private String rawData;
    private int stat;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/lib/restful/HiResponse$Companion;", "", "()V", "BAD_NETWORK_MSG", "", "CODE_BAD_NETWORK", "", "CODE_EMPTY_MESSAGE", "CODE_ERROR_MSG", "CODE_LOGIN_EXPIRE", "CODE_NEED_UPDATE", "CODE_NET_BUSY", "CODE_OTHER_ERROR", "CODE_PARSE_ERROR", "CODE_SSL_ERROR", "CODE_TIME_OUT", "CONNECT_ERROR_MSG", "CONNECT_TIMEOUT_MSG", "MESSAGE_EMPTY_ERROR", "NOT_ERROR", "OTHER_MSG", "PARSE_ERROR_MSG", "SSL_ERROR_MSG", "SUCCESS", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HiResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final void setRawData(String str) {
        this.rawData = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final int getStat() {
        return this.stat;
    }

    public final void setStat(int i) {
        this.stat = i;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public final Map<String, String> getErrorData() {
        return this.errorData;
    }

    public final void setErrorData(Map<String, String> map) {
        this.errorData = map;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final boolean error() {
        return this.code != 0;
    }

    public final boolean successful() {
        return this.stat == 1 || error();
    }
}
