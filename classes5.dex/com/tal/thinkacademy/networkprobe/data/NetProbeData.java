package com.tal.thinkacademy.networkprobe.data;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.agora.rtc.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b0\b\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u00103\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u00107\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ¼\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010A\u001a\u00020\u0013H\u0016J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u001aR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b'\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b(\u0010\u001aR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b,\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b-\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!¨\u0006C"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/data/NetProbeData;", "", "url", "", "protocol", "method", "dnsServer", "", "dnsDuration", "", "tcpDuration", "tlsDuration", "requestDuration", "serviceDuration", "responseDuration", "duration", "success", "", "code", "", "errorMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDnsDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDnsServer", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getDuration", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getMethod", "getProtocol", "getRequestDuration", "getResponseDuration", "getServiceDuration", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTcpDuration", "getTlsDuration", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/thinkacademy/networkprobe/data/NetProbeData;", "equals", "other", "hashCode", "toString", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetProbeData.kt */
public final class NetProbeData {
    private final Integer code;
    private final Long dnsDuration;
    private final String[] dnsServer;
    private final Long duration;
    private String errorMsg;
    private final String method;
    private final String protocol;
    private final Long requestDuration;
    private final Long responseDuration;
    private final Long serviceDuration;
    private final Boolean success;
    private final Long tcpDuration;
    private final Long tlsDuration;
    private final String url;

    public NetProbeData() {
        this((String) null, (String) null, (String) null, (String[]) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (Boolean) null, (Integer) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NetProbeData copy$default(NetProbeData netProbeData, String str, String str2, String str3, String[] strArr, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Boolean bool, Integer num, String str4, int i, Object obj) {
        NetProbeData netProbeData2 = netProbeData;
        int i2 = i;
        return netProbeData.copy((i2 & 1) != 0 ? netProbeData2.url : str, (i2 & 2) != 0 ? netProbeData2.protocol : str2, (i2 & 4) != 0 ? netProbeData2.method : str3, (i2 & 8) != 0 ? netProbeData2.dnsServer : strArr, (i2 & 16) != 0 ? netProbeData2.dnsDuration : l, (i2 & 32) != 0 ? netProbeData2.tcpDuration : l2, (i2 & 64) != 0 ? netProbeData2.tlsDuration : l3, (i2 & Constants.ERR_WATERMARK_ARGB) != 0 ? netProbeData2.requestDuration : l4, (i2 & 256) != 0 ? netProbeData2.serviceDuration : l5, (i2 & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0 ? netProbeData2.responseDuration : l6, (i2 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? netProbeData2.duration : l7, (i2 & 2048) != 0 ? netProbeData2.success : bool, (i2 & 4096) != 0 ? netProbeData2.code : num, (i2 & Marshallable.PROTO_PACKET_SIZE) != 0 ? netProbeData2.errorMsg : str4);
    }

    public final String component1() {
        return this.url;
    }

    public final Long component10() {
        return this.responseDuration;
    }

    public final Long component11() {
        return this.duration;
    }

    public final Boolean component12() {
        return this.success;
    }

    public final Integer component13() {
        return this.code;
    }

    public final String component14() {
        return this.errorMsg;
    }

    public final String component2() {
        return this.protocol;
    }

    public final String component3() {
        return this.method;
    }

    public final String[] component4() {
        return this.dnsServer;
    }

    public final Long component5() {
        return this.dnsDuration;
    }

    public final Long component6() {
        return this.tcpDuration;
    }

    public final Long component7() {
        return this.tlsDuration;
    }

    public final Long component8() {
        return this.requestDuration;
    }

    public final Long component9() {
        return this.serviceDuration;
    }

    public final NetProbeData copy(String str, String str2, String str3, String[] strArr, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Boolean bool, Integer num, String str4) {
        return new NetProbeData(str, str2, str3, strArr, l, l2, l3, l4, l5, l6, l7, bool, num, str4);
    }

    public String toString() {
        return "NetProbeData(url=" + this.url + ", protocol=" + this.protocol + ", method=" + this.method + ", dnsServer=" + Arrays.toString(this.dnsServer) + ", dnsDuration=" + this.dnsDuration + ", tcpDuration=" + this.tcpDuration + ", tlsDuration=" + this.tlsDuration + ", requestDuration=" + this.requestDuration + ", serviceDuration=" + this.serviceDuration + ", responseDuration=" + this.responseDuration + ", duration=" + this.duration + ", success=" + this.success + ", code=" + this.code + ", errorMsg=" + this.errorMsg + ')';
    }

    public NetProbeData(String str, String str2, String str3, String[] strArr, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Boolean bool, Integer num, String str4) {
        this.url = str;
        this.protocol = str2;
        this.method = str3;
        this.dnsServer = strArr;
        this.dnsDuration = l;
        this.tcpDuration = l2;
        this.tlsDuration = l3;
        this.requestDuration = l4;
        this.serviceDuration = l5;
        this.responseDuration = l6;
        this.duration = l7;
        this.success = bool;
        this.code = num;
        this.errorMsg = str4;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String[] getDnsServer() {
        return this.dnsServer;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NetProbeData(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String[] r20, java.lang.Long r21, java.lang.Long r22, java.lang.Long r23, java.lang.Long r24, java.lang.Long r25, java.lang.Long r26, java.lang.Long r27, java.lang.Boolean r28, java.lang.Integer r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r16 = this;
            r0 = r31
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r17
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r18
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r19
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r20
        L_0x0024:
            r6 = r0 & 16
            r7 = 0
            if (r6 == 0) goto L_0x002f
            java.lang.Long r6 = java.lang.Long.valueOf(r7)
            goto L_0x0031
        L_0x002f:
            r6 = r21
        L_0x0031:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            java.lang.Long r9 = java.lang.Long.valueOf(r7)
            goto L_0x003c
        L_0x003a:
            r9 = r22
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0045
            java.lang.Long r10 = java.lang.Long.valueOf(r7)
            goto L_0x0047
        L_0x0045:
            r10 = r23
        L_0x0047:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0050
            java.lang.Long r11 = java.lang.Long.valueOf(r7)
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x005b
            java.lang.Long r12 = java.lang.Long.valueOf(r7)
            goto L_0x005d
        L_0x005b:
            r12 = r25
        L_0x005d:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0066
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            goto L_0x0068
        L_0x0066:
            r13 = r26
        L_0x0068:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0071
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            goto L_0x0073
        L_0x0071:
            r7 = r27
        L_0x0073:
            r8 = r0 & 2048(0x800, float:2.87E-42)
            r14 = 0
            if (r8 == 0) goto L_0x007d
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r14)
            goto L_0x007f
        L_0x007d:
            r8 = r28
        L_0x007f:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0088
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x008a
        L_0x0088:
            r14 = r29
        L_0x008a:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r2 = r30
        L_0x0091:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r7
            r29 = r8
            r30 = r14
            r31 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.data.NetProbeData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String[], java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Boolean, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getDnsDuration() {
        return this.dnsDuration;
    }

    public final Long getTcpDuration() {
        return this.tcpDuration;
    }

    public final Long getTlsDuration() {
        return this.tlsDuration;
    }

    public final Long getRequestDuration() {
        return this.requestDuration;
    }

    public final Long getServiceDuration() {
        return this.serviceDuration;
    }

    public final Long getResponseDuration() {
        return this.responseDuration;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        NetProbeData netProbeData = (NetProbeData) obj;
        if (!Intrinsics.areEqual(this.url, netProbeData.url) || !Intrinsics.areEqual(this.protocol, netProbeData.protocol) || !Intrinsics.areEqual(this.method, netProbeData.method)) {
            return false;
        }
        String[] strArr = this.dnsServer;
        if (strArr != null) {
            String[] strArr2 = netProbeData.dnsServer;
            if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                return false;
            }
        } else if (netProbeData.dnsServer != null) {
            return false;
        }
        return Intrinsics.areEqual(this.dnsDuration, netProbeData.dnsDuration) && Intrinsics.areEqual(this.tcpDuration, netProbeData.tcpDuration) && Intrinsics.areEqual(this.tlsDuration, netProbeData.tlsDuration) && Intrinsics.areEqual(this.requestDuration, netProbeData.requestDuration) && Intrinsics.areEqual(this.serviceDuration, netProbeData.serviceDuration) && Intrinsics.areEqual(this.responseDuration, netProbeData.responseDuration) && Intrinsics.areEqual(this.duration, netProbeData.duration) && Intrinsics.areEqual(this.success, netProbeData.success) && Intrinsics.areEqual(this.code, netProbeData.code) && Intrinsics.areEqual(this.errorMsg, netProbeData.errorMsg);
    }

    public int hashCode() {
        String str = this.url;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.protocol;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.method;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String[] strArr = this.dnsServer;
        int hashCode4 = (hashCode3 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        Long l = this.dnsDuration;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.tcpDuration;
        int hashCode6 = (hashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.tlsDuration;
        int hashCode7 = (hashCode6 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.requestDuration;
        int hashCode8 = (hashCode7 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.serviceDuration;
        int hashCode9 = (hashCode8 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l6 = this.responseDuration;
        int hashCode10 = (hashCode9 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.duration;
        int hashCode11 = (hashCode10 + (l7 == null ? 0 : l7.hashCode())) * 31;
        Boolean bool = this.success;
        int hashCode12 = (hashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.code;
        int hashCode13 = (hashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.errorMsg;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode13 + i;
    }
}
