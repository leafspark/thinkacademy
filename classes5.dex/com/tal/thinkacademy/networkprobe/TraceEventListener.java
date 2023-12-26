package com.tal.thinkacademy.networkprobe;

import android.os.SystemClock;
import com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 F2\u00020\u0001:\u0001FB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001b\u0010/\u001a\u00020\u00062\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c01H\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u001cH\u0002J\"\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u0002082\b\u0010\u0013\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u001cH\u0002J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u000208H\u0002J \u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001cH\u0002J\u001a\u0010B\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010E\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/TraceEventListener;", "Lokhttp3/EventListener;", "traceCache", "Lcom/tal/thinkacademy/networkprobe/cache/NetworkTraceCache;", "(Lcom/tal/thinkacademy/networkprobe/cache/NetworkTraceCache;)V", "callEnd", "", "call", "Lokhttp3/Call;", "callFailed", "ioe", "Ljava/io/IOException;", "callStart", "canceled", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", "protocol", "Lokhttp3/Protocol;", "connectStart", "connectionAcquired", "connection", "Lokhttp3/Connection;", "connectionReleased", "dnsEnd", "domainName", "", "inetAddressList", "", "Ljava/net/InetAddress;", "dnsStart", "requestBodyEnd", "byteCount", "", "requestBodyStart", "requestHeadersEnd", "request", "Lokhttp3/Request;", "requestHeadersStart", "responseBodyEnd", "responseBodyStart", "responseHeadersEnd", "response", "Lokhttp3/Response;", "responseHeadersStart", "saveDnsAddressList", "list", "", "([Ljava/lang/String;)V", "saveEvent", "eventName", "saveHost", "ip", "port", "", "saveParams", "params", "requestId", "saveStatus", "code", "saveUrl", "url", "method", "path", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "Factory", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TraceEventListener.kt */
public final class TraceEventListener extends EventListener {
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AtomicLong nextCallId = new AtomicLong(1);
    private final NetworkTraceCache traceCache;

    public TraceEventListener(NetworkTraceCache networkTraceCache) {
        Intrinsics.checkNotNullParameter(networkTraceCache, "traceCache");
        this.traceCache = networkTraceCache;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/TraceEventListener$Factory;", "Lokhttp3/EventListener$Factory;", "()V", "nextCallId", "Ljava/util/concurrent/atomic/AtomicLong;", "create", "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TraceEventListener.kt */
    public static final class Factory implements EventListener.Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public EventListener create(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            String queryParameter = call.request().url().queryParameter(NetworkTraceCache.TRACE_REQUEST_ID);
            if (queryParameter == null) {
                queryParameter = String.valueOf(TraceEventListener.nextCallId.getAndIncrement());
            }
            NetworkTraceCache networkTraceCache = new NetworkTraceCache(queryParameter);
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new TraceEventListener$Factory$create$1(queryParameter, networkTraceCache, (Continuation<? super TraceEventListener$Factory$create$1>) null), 1, (Object) null);
            return new TraceEventListener(networkTraceCache);
        }
    }

    public void callStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Request request = call.request();
        saveUrl(request.url().toString(), request.method(), request.url().encodedPath());
        saveEvent(NetworkTraceCache.CALL_START);
    }

    public void dnsStart(Call call, String str) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(str, "domainName");
        saveEvent(NetworkTraceCache.DNS_START);
    }

    public void dnsEnd(Call call, String str, List<? extends InetAddress> list) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(str, "domainName");
        Intrinsics.checkNotNullParameter(list, "inetAddressList");
        Collection arrayList = new ArrayList();
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String hostAddress = ((InetAddress) next).getHostAddress();
            if (hostAddress != null) {
                arrayList.add(hostAddress);
            }
            i = i2;
        }
        Object[] array = ((List) arrayList).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        saveDnsAddressList((String[]) array);
        saveEvent(NetworkTraceCache.DNS_END);
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        TraceEventListener.super.connectionReleased(call, connection);
    }

    public void connectionAcquired(Call call, Connection connection) {
        String hostAddress;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        TraceEventListener.super.connectionAcquired(call, connection);
        InetAddress inetAddress = connection.socket().getInetAddress();
        String str = "";
        if (!(inetAddress == null || (hostAddress = inetAddress.getHostAddress()) == null)) {
            str = hostAddress;
        }
        InetSocketAddress socketAddress = connection.route().socketAddress();
        saveHost(str, socketAddress == null ? 0 : socketAddress.getPort(), connection.protocol().toString());
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        saveEvent(NetworkTraceCache.CONNECT_START);
    }

    public void secureConnectStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.SECURE_CONNECT_START);
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.SECURE_CONNECT_END);
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        saveEvent(NetworkTraceCache.CONNECT_END);
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.REQUEST_HEADERS_START);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0088, code lost:
        if (r7 != null) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void requestHeadersEnd(okhttp3.Call r7, okhttp3.Request r8) {
        /*
            r6 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r7 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            java.lang.String r7 = "requestHeadersEnd"
            r6.saveEvent(r7)
            okhttp3.RequestBody r7 = r8.body()
            java.lang.String r0 = ""
            if (r7 != 0) goto L_0x001a
        L_0x0017:
            r7 = r0
            goto L_0x008b
        L_0x001a:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            r2 = r1
            okio.BufferedSink r2 = (okio.BufferedSink) r2
            r7.writeTo(r2)
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)
            okhttp3.MediaType r7 = r7.contentType()
            if (r7 != 0) goto L_0x0032
            goto L_0x003a
        L_0x0032:
            java.nio.charset.Charset r7 = r7.charset(r2)
            if (r7 != 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r2 = r7
        L_0x003a:
            boolean r7 = com.tal.thinkacademy.networkprobe.TraceEventListenerKt.isPlaintext(r1)
            if (r7 == 0) goto L_0x0087
            java.lang.String r7 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.String r7 = r1.readString(r2)
            java.lang.String r1 = "{"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r7, r1, r4, r3, r2)     // Catch:{ Exception -> 0x0088 }
            r5 = 4
            if (r1 == 0) goto L_0x006a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0088 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0088 }
            boolean r2 = r1 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x0088 }
            if (r2 != 0) goto L_0x0063
            java.lang.String r7 = r1.toString(r5)     // Catch:{ Exception -> 0x0088 }
            goto L_0x0088
        L_0x0063:
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ Exception -> 0x0088 }
            java.lang.String r7 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r1, r5)     // Catch:{ Exception -> 0x0088 }
            goto L_0x0088
        L_0x006a:
            java.lang.String r1 = "["
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r7, r1, r4, r3, r2)     // Catch:{ Exception -> 0x0088 }
            if (r1 == 0) goto L_0x0088
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x0088 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0088 }
            boolean r2 = r1 instanceof org.json.JSONArray     // Catch:{ Exception -> 0x0088 }
            if (r2 != 0) goto L_0x0080
            java.lang.String r7 = r1.toString(r5)     // Catch:{ Exception -> 0x0088 }
            goto L_0x0088
        L_0x0080:
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch:{ Exception -> 0x0088 }
            java.lang.String r7 = com.bonree.sdk.agent.engine.external.JSONArrayInstrumentation.toString(r1, r5)     // Catch:{ Exception -> 0x0088 }
            goto L_0x0088
        L_0x0087:
            r7 = r0
        L_0x0088:
            if (r7 != 0) goto L_0x008b
            goto L_0x0017
        L_0x008b:
            java.lang.String r1 = "x-tal-trace-id"
            java.lang.String r8 = r8.header(r1)
            if (r8 != 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r0 = r8
        L_0x0095:
            r6.saveParams(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.TraceEventListener.requestHeadersEnd(okhttp3.Call, okhttp3.Request):void");
    }

    public void requestBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.REQUEST_BODY_START);
    }

    public void requestBodyEnd(Call call, long j) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.REQUEST_BODY_END);
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.RESPONSE_HEADERS_START);
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        saveEvent(NetworkTraceCache.RESPONSE_HEADERS_END);
        saveStatus(response.code());
    }

    public void responseBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.RESPONSE_BODY_START);
    }

    public void responseBodyEnd(Call call, long j) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.RESPONSE_BODY_END);
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "ioe");
        TraceEventListener.super.callFailed(call, iOException);
        call.request().url().toString();
        iOException.getMessage();
    }

    public void canceled(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        TraceEventListener.super.canceled(call);
        call.request().url().toString();
    }

    public void callEnd(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        saveEvent(NetworkTraceCache.CALL_END);
        this.traceCache.generateTraceData();
    }

    private final void saveEvent(String str) {
        this.traceCache.getNetworkEventsMap().put(str, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    private final void saveUrl(String str, String str2, String str3) {
        this.traceCache.setUrl(str);
        this.traceCache.setPath(str3);
        this.traceCache.setMethod(str2);
    }

    private final void saveDnsAddressList(String[] strArr) {
        this.traceCache.setDns(strArr);
    }

    private final void saveParams(String str, String str2) {
        this.traceCache.setParams(str);
        this.traceCache.setRequestId(str2);
    }

    private final void saveHost(String str, int i, String str2) {
        this.traceCache.setIp(str);
        this.traceCache.setPort(String.valueOf(i));
        this.traceCache.setProtocol(str2);
    }

    private final void saveStatus(int i) {
        this.traceCache.setSuccess(i == 200);
        this.traceCache.setCode(i);
    }
}
