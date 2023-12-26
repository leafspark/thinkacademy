package com.tal.app.thinkacademy.lib.network.trace;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001c\u0010\"\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001c\u0010%\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001c\u0010(\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R&\u00106\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR\u001c\u00109\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000e¨\u0006="}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/trace/NetworkTraceBean;", "Ljava/io/Serializable;", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "ip", "getIp", "setIp", "method", "getMethod", "setMethod", "networkEventsMap", "Ljava/util/HashMap;", "", "getNetworkEventsMap", "()Ljava/util/HashMap;", "setNetworkEventsMap", "(Ljava/util/HashMap;)V", "params", "getParams", "setParams", "path", "getPath", "setPath", "port", "getPort", "setPort", "protocol", "getProtocol", "setProtocol", "requestId", "getRequestId", "setRequestId", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "time", "getTime", "()J", "setTime", "(J)V", "traceItemList", "getTraceItemList", "setTraceItemList", "url", "getUrl", "setUrl", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkTraceBean.kt */
public final class NetworkTraceBean implements Serializable {
    public static String CALL_END = "callEnd";
    public static String CALL_START = "callStart";
    public static String CONNECT_END = "connectEnd";
    public static String CONNECT_START = "connectStart";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static String DNS_END = "dnsEnd";
    public static String DNS_START = "dnsStart";
    public static String REQUEST_BODY_END = "requestBodyEnd";
    public static String REQUEST_BODY_START = "requestBodyStart";
    public static String REQUEST_HEADERS_END = "requestHeadersEnd";
    public static String REQUEST_HEADERS_START = "requestHeadersStart";
    public static String RESPONSE_BODY_END = "responseBodyEnd";
    public static String RESPONSE_BODY_START = "responseBodyStart";
    public static String RESPONSE_HEADERS_END = "responseHeadersEnd";
    public static String RESPONSE_HEADERS_START = "responseHeadersStart";
    public static String SECURE_CONNECT_END = "secureConnectEnd";
    public static String SECURE_CONNECT_START = "secureConnectStart";
    public static String TRACE_NAME_CODE = "hw_net_http_code";
    public static String TRACE_NAME_CONNECT = "hw_net_tcp_value";
    public static String TRACE_NAME_DNS = "hw_net_dns_value";
    public static String TRACE_NAME_HOST_IP = "hw_net_ip";
    public static String TRACE_NAME_METHOD = "hw_net_request_method";
    public static String TRACE_NAME_PARAM = "hw_net_param";
    public static String TRACE_NAME_PATH = "hw_net_path";
    public static String TRACE_NAME_PORT = "hw_net_port";
    public static String TRACE_NAME_PROTOCOL = "hw_net_protocol";
    public static String TRACE_NAME_REQUEST_BODY = "Request Body";
    public static String TRACE_NAME_REQUEST_HEADERS = "Request Headers";
    public static String TRACE_NAME_REQUEST_TIME = "hw_net_request_value";
    public static String TRACE_NAME_RESPONSE_BODY = "Response Body";
    public static String TRACE_NAME_RESPONSE_HEADERS = "Response Headers";
    public static String TRACE_NAME_RESPONSE_TIME = "hw_net_response_value";
    public static String TRACE_NAME_RESULT = "hw_net_success";
    public static String TRACE_NAME_SECURE_CONNECT = "hw_net_tls_value";
    public static String TRACE_NAME_SERVICE_TIME = "hw_net_service_value";
    public static String TRACE_NAME_TOTAL = "hw_net_sum_value";
    public static String TRACE_NAME_URL = "hw_net_request_url";
    public static String TRACE_REQUEST_ID = "x-tal-trace-id";
    private int code;
    private String id = "";
    private String ip = "";
    private String method = "";
    private HashMap<String, Long> networkEventsMap = new HashMap<>();
    private String params = "";
    private String path = "";
    private String port = "";
    private String protocol = "";
    private String requestId = "";
    private boolean success;
    private long time;
    private HashMap<String, Long> traceItemList = new HashMap<>();
    private String url = "";

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    public final String getIp() {
        return this.ip;
    }

    public final void setIp(String str) {
        this.ip = str;
    }

    public final String getPort() {
        return this.port;
    }

    public final void setPort(String str) {
        this.port = str;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(String str) {
        this.protocol = str;
    }

    public final String getParams() {
        return this.params;
    }

    public final void setParams(String str) {
        this.params = str;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final HashMap<String, Long> getNetworkEventsMap() {
        return this.networkEventsMap;
    }

    public final void setNetworkEventsMap(HashMap<String, Long> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.networkEventsMap = hashMap;
    }

    public final HashMap<String, Long> getTraceItemList() {
        return this.traceItemList;
    }

    public final void setTraceItemList(HashMap<String, Long> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.traceItemList = hashMap;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b%\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/trace/NetworkTraceBean$Companion;", "", "()V", "CALL_END", "", "CALL_START", "CONNECT_END", "CONNECT_START", "DNS_END", "DNS_START", "REQUEST_BODY_END", "REQUEST_BODY_START", "REQUEST_HEADERS_END", "REQUEST_HEADERS_START", "RESPONSE_BODY_END", "RESPONSE_BODY_START", "RESPONSE_HEADERS_END", "RESPONSE_HEADERS_START", "SECURE_CONNECT_END", "SECURE_CONNECT_START", "TRACE_NAME_CODE", "TRACE_NAME_CONNECT", "TRACE_NAME_DNS", "TRACE_NAME_HOST_IP", "TRACE_NAME_METHOD", "TRACE_NAME_PARAM", "TRACE_NAME_PATH", "TRACE_NAME_PORT", "TRACE_NAME_PROTOCOL", "TRACE_NAME_REQUEST_BODY", "TRACE_NAME_REQUEST_HEADERS", "TRACE_NAME_REQUEST_TIME", "TRACE_NAME_RESPONSE_BODY", "TRACE_NAME_RESPONSE_HEADERS", "TRACE_NAME_RESPONSE_TIME", "TRACE_NAME_RESULT", "TRACE_NAME_SECURE_CONNECT", "TRACE_NAME_SERVICE_TIME", "TRACE_NAME_TOTAL", "TRACE_NAME_URL", "TRACE_REQUEST_ID", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetworkTraceBean.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
