package com.tal.thinkacademy.networkprobe.cache;

import com.tal.thinkacademy.networkprobe.data.NetProbeData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 I2\u00020\u0001:\u0001IB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020\u0003J\u0006\u0010H\u001a\u00020\u001dR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0004R6\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d`\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0004R\u001c\u0010&\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0004R\u001c\u0010)\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0004R\u001c\u0010/\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0004R\u001a\u00102\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R6\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d`\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010 \"\u0004\b?\u0010\"R\u001c\u0010@\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0013\"\u0004\bB\u0010\u0004¨\u0006J"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/cache/NetworkTraceCache;", "", "id", "", "(Ljava/lang/String;)V", "code", "", "getCode", "()I", "setCode", "(I)V", "dns", "", "getDns", "()[Ljava/lang/String;", "setDns", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "ip", "getIp", "setIp", "method", "getMethod", "setMethod", "networkEventsMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getNetworkEventsMap", "()Ljava/util/HashMap;", "setNetworkEventsMap", "(Ljava/util/HashMap;)V", "params", "getParams", "setParams", "path", "getPath", "setPath", "port", "getPort", "setPort", "protocol", "getProtocol", "setProtocol", "requestId", "getRequestId", "setRequestId", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "time", "getTime", "()J", "setTime", "(J)V", "traceItemList", "getTraceItemList", "setTraceItemList", "url", "getUrl", "setUrl", "createData", "Lcom/tal/thinkacademy/networkprobe/data/NetProbeData;", "generateTraceData", "", "makeJson", "totalTime", "Companion", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkTraceCache.kt */
public final class NetworkTraceCache {
    public static final String CALL_END = "callEnd";
    public static final String CALL_START = "callStart";
    public static final String CONNECT_END = "connectEnd";
    public static final String CONNECT_START = "connectStart";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DNS_END = "dnsEnd";
    public static final String DNS_START = "dnsStart";
    public static final String REQUEST_BODY_END = "requestBodyEnd";
    public static final String REQUEST_BODY_START = "requestBodyStart";
    public static final String REQUEST_HEADERS_END = "requestHeadersEnd";
    public static final String REQUEST_HEADERS_START = "requestHeadersStart";
    public static final String RESPONSE_BODY_END = "responseBodyEnd";
    public static final String RESPONSE_BODY_START = "responseBodyStart";
    public static final String RESPONSE_HEADERS_END = "responseHeadersEnd";
    public static final String RESPONSE_HEADERS_START = "responseHeadersStart";
    public static final String SECURE_CONNECT_END = "secureConnectEnd";
    public static final String SECURE_CONNECT_START = "secureConnectStart";
    public static final String TRACE_NAME_CODE = "hw_net_http_code";
    public static final String TRACE_NAME_CONNECT = "hw_net_tcp_value";
    public static final String TRACE_NAME_DNS = "hw_net_dns_value";
    public static final String TRACE_NAME_DNS_URL = "hw_net_dns";
    public static final String TRACE_NAME_HOST_IP = "hw_net_ip";
    public static final String TRACE_NAME_METHOD = "hw_net_request_method";
    public static final String TRACE_NAME_PARAM = "hw_net_param";
    public static final String TRACE_NAME_PATH = "hw_net_path";
    public static final String TRACE_NAME_PORT = "hw_net_port";
    public static final String TRACE_NAME_PROTOCOL = "hw_net_protocol";
    public static final String TRACE_NAME_REQUEST_BODY = "Request Body";
    public static final String TRACE_NAME_REQUEST_HEADERS = "Request Headers";
    public static final String TRACE_NAME_REQUEST_TIME = "hw_net_request_value";
    public static final String TRACE_NAME_RESPONSE_BODY = "Response Body";
    public static final String TRACE_NAME_RESPONSE_HEADERS = "Response Headers";
    public static final String TRACE_NAME_RESPONSE_TIME = "hw_net_response_value";
    public static final String TRACE_NAME_RESULT = "hw_net_success";
    public static final String TRACE_NAME_SECURE_CONNECT = "hw_net_tls_value";
    public static final String TRACE_NAME_SERVICE_TIME = "hw_net_service_value";
    public static final String TRACE_NAME_TOTAL = "hw_net_sum_value";
    public static final String TRACE_NAME_URL = "hw_net_request_url";
    public static final String TRACE_REQUEST_ID = "x-tal-trace-id";
    private int code;
    private String[] dns;
    private String id;
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

    public NetworkTraceCache(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String[] getDns() {
        return this.dns;
    }

    public final void setDns(String[] strArr) {
        this.dns = strArr;
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/cache/NetworkTraceCache$Companion;", "", "()V", "CALL_END", "", "CALL_START", "CONNECT_END", "CONNECT_START", "DNS_END", "DNS_START", "REQUEST_BODY_END", "REQUEST_BODY_START", "REQUEST_HEADERS_END", "REQUEST_HEADERS_START", "RESPONSE_BODY_END", "RESPONSE_BODY_START", "RESPONSE_HEADERS_END", "RESPONSE_HEADERS_START", "SECURE_CONNECT_END", "SECURE_CONNECT_START", "TRACE_NAME_CODE", "TRACE_NAME_CONNECT", "TRACE_NAME_DNS", "TRACE_NAME_DNS_URL", "TRACE_NAME_HOST_IP", "TRACE_NAME_METHOD", "TRACE_NAME_PARAM", "TRACE_NAME_PATH", "TRACE_NAME_PORT", "TRACE_NAME_PROTOCOL", "TRACE_NAME_REQUEST_BODY", "TRACE_NAME_REQUEST_HEADERS", "TRACE_NAME_REQUEST_TIME", "TRACE_NAME_RESPONSE_BODY", "TRACE_NAME_RESPONSE_HEADERS", "TRACE_NAME_RESPONSE_TIME", "TRACE_NAME_RESULT", "TRACE_NAME_SECURE_CONNECT", "TRACE_NAME_SERVICE_TIME", "TRACE_NAME_TOTAL", "TRACE_NAME_URL", "TRACE_REQUEST_ID", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetworkTraceCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void generateTraceData() {
        this.traceItemList.put(TRACE_NAME_TOTAL, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, CALL_START, CALL_END)));
        this.traceItemList.put(TRACE_NAME_DNS, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, DNS_START, DNS_END)));
        this.traceItemList.put(TRACE_NAME_SECURE_CONNECT, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, SECURE_CONNECT_START, SECURE_CONNECT_END)));
        this.traceItemList.put(TRACE_NAME_CONNECT, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, CONNECT_START, CONNECT_END)));
        this.traceItemList.put(TRACE_NAME_SERVICE_TIME, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, REQUEST_HEADERS_START, RESPONSE_BODY_END)));
        this.traceItemList.put(TRACE_NAME_REQUEST_HEADERS, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, REQUEST_HEADERS_START, REQUEST_HEADERS_END)));
        this.traceItemList.put(TRACE_NAME_REQUEST_BODY, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, REQUEST_BODY_START, REQUEST_BODY_END)));
        this.traceItemList.put(TRACE_NAME_RESPONSE_HEADERS, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, RESPONSE_HEADERS_START, RESPONSE_HEADERS_END)));
        this.traceItemList.put(TRACE_NAME_RESPONSE_BODY, Long.valueOf(NetworkTraceCacheKt.getEventCostTime(this.networkEventsMap, RESPONSE_BODY_START, RESPONSE_BODY_END)));
    }

    public final long totalTime() {
        Long l = this.traceItemList.get(TRACE_NAME_TOTAL);
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public final String makeJson() {
        String obj;
        Long l = this.traceItemList.get(TRACE_NAME_REQUEST_HEADERS);
        long j = 0L;
        if (l == null) {
            l = 0L;
        }
        long longValue = l.longValue();
        Long l2 = this.traceItemList.get(TRACE_NAME_REQUEST_BODY);
        if (l2 == null) {
            l2 = 0L;
        }
        long longValue2 = longValue + l2.longValue();
        Long l3 = this.traceItemList.get(TRACE_NAME_RESPONSE_HEADERS);
        if (l3 == null) {
            l3 = 0L;
        }
        long longValue3 = l3.longValue();
        Long l4 = this.traceItemList.get(TRACE_NAME_RESPONSE_BODY);
        if (l4 != null) {
            j = l4;
        }
        long longValue4 = longValue3 + j.longValue();
        StringBuilder sb = new StringBuilder();
        sb.append("{ \n \"callId\" : \"");
        sb.append(this.id);
        sb.append("\", \n \"hw_net_request_url\" : \"");
        sb.append(this.url);
        sb.append("\", \n \"hw_net_path\" : \"");
        sb.append(this.path);
        sb.append("\", \n \"hw_net_request_method\" : \"");
        sb.append(this.method);
        sb.append("\",\n \"hw_net_ip\" : \"");
        sb.append(this.ip);
        sb.append("\", \n \"hw_net_success\" : \"");
        sb.append(this.success);
        sb.append("\",\n \"hw_net_http_code\" : \"");
        sb.append(this.code);
        sb.append("\",\n \"hw_net_sum_value\" : ");
        sb.append(this.traceItemList.get(TRACE_NAME_TOTAL));
        sb.append(",\n \"hw_net_request_value\" : ");
        sb.append(longValue2);
        sb.append(",\n \"hw_net_tls_value\" : ");
        sb.append(this.traceItemList.get(TRACE_NAME_SECURE_CONNECT));
        sb.append(",\n \"hw_net_dns\" : ");
        String[] strArr = this.dns;
        String str = "";
        if (!(strArr == null || (obj = strArr.toString()) == null)) {
            str = obj;
        }
        sb.append(str);
        sb.append(",\n \"hw_net_dns_value\" : ");
        sb.append(this.traceItemList.get(TRACE_NAME_DNS));
        sb.append(",\n \"hw_net_tcp_value\" : ");
        sb.append(this.traceItemList.get(TRACE_NAME_CONNECT));
        sb.append(",\n \"hw_net_param\" : ");
        sb.append(this.params);
        sb.append(",\n \"hw_net_service_value\" : ");
        sb.append(this.traceItemList.get(TRACE_NAME_SERVICE_TIME));
        sb.append(",\n \"hw_net_response_value\" : ");
        sb.append(longValue4);
        sb.append(",\n \"hw_net_port\" : \"");
        sb.append(this.port);
        sb.append("\",\n \"x-tal-trace-id\" : \"");
        sb.append(this.requestId);
        sb.append("\",\n \"hw_net_protocol\" : \"");
        sb.append(this.protocol);
        sb.append("\"\n }");
        return sb.toString();
    }

    public final NetProbeData createData() {
        String str = this.url;
        String str2 = this.protocol;
        String str3 = this.method;
        String[] strArr = this.dns;
        Long l = this.traceItemList.get(TRACE_NAME_DNS);
        Long l2 = this.traceItemList.get(TRACE_NAME_CONNECT);
        Long l3 = this.traceItemList.get(TRACE_NAME_SECURE_CONNECT);
        Long l4 = this.traceItemList.get(TRACE_NAME_REQUEST_HEADERS);
        long j = 0L;
        if (l4 == null) {
            l4 = 0L;
        }
        long longValue = l4.longValue();
        Long l5 = this.traceItemList.get(TRACE_NAME_REQUEST_BODY);
        if (l5 == null) {
            l5 = 0L;
        }
        Long valueOf = Long.valueOf(longValue + l5.longValue());
        Long l6 = this.traceItemList.get(TRACE_NAME_SERVICE_TIME);
        Long l7 = this.traceItemList.get(TRACE_NAME_RESPONSE_HEADERS);
        if (l7 == null) {
            l7 = 0L;
        }
        long longValue2 = l7.longValue();
        Long l8 = this.traceItemList.get(TRACE_NAME_RESPONSE_BODY);
        if (l8 != null) {
            j = l8;
        }
        return new NetProbeData(str, str2, str3, strArr, l, l2, l3, valueOf, l6, Long.valueOf(longValue2 + j.longValue()), this.traceItemList.get(TRACE_NAME_TOTAL), Boolean.valueOf(this.success), Integer.valueOf(this.code), (String) null, Marshallable.PROTO_PACKET_SIZE, (DefaultConstructorMarker) null);
    }
}
