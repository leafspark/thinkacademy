package com.tal.app.thinkacademy.lib.irc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;", "", "protocol", "", "hostname", "backupIp", "url", "port", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBackupIp", "()Ljava/lang/String;", "getHostname", "getPort", "()I", "getProtocol", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrcInitInfo.kt */
public final class DeviceIrcConfServer {
    private final String backupIp;
    private final String hostname;
    private final int port;
    private final String protocol;
    private final String url;

    public DeviceIrcConfServer() {
        this((String) null, (String) null, (String) null, (String) null, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceIrcConfServer copy$default(DeviceIrcConfServer deviceIrcConfServer, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deviceIrcConfServer.protocol;
        }
        if ((i2 & 2) != 0) {
            str2 = deviceIrcConfServer.hostname;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = deviceIrcConfServer.backupIp;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = deviceIrcConfServer.url;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = deviceIrcConfServer.port;
        }
        return deviceIrcConfServer.copy(str, str5, str6, str7, i);
    }

    public final String component1() {
        return this.protocol;
    }

    public final String component2() {
        return this.hostname;
    }

    public final String component3() {
        return this.backupIp;
    }

    public final String component4() {
        return this.url;
    }

    public final int component5() {
        return this.port;
    }

    public final DeviceIrcConfServer copy(String str, String str2, String str3, String str4, int i) {
        return new DeviceIrcConfServer(str, str2, str3, str4, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceIrcConfServer)) {
            return false;
        }
        DeviceIrcConfServer deviceIrcConfServer = (DeviceIrcConfServer) obj;
        return Intrinsics.areEqual(this.protocol, deviceIrcConfServer.protocol) && Intrinsics.areEqual(this.hostname, deviceIrcConfServer.hostname) && Intrinsics.areEqual(this.backupIp, deviceIrcConfServer.backupIp) && Intrinsics.areEqual(this.url, deviceIrcConfServer.url) && this.port == deviceIrcConfServer.port;
    }

    public int hashCode() {
        String str = this.protocol;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hostname;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backupIp;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.url;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.port;
    }

    public String toString() {
        return "DeviceIrcConfServer(protocol=" + this.protocol + ", hostname=" + this.hostname + ", backupIp=" + this.backupIp + ", url=" + this.url + ", port=" + this.port + ')';
    }

    public DeviceIrcConfServer(String str, String str2, String str3, String str4, int i) {
        this.protocol = str;
        this.hostname = str2;
        this.backupIp = str3;
        this.url = str4;
        this.port = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceIrcConfServer(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r6
        L_0x0016:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0021
            r8 = 0
        L_0x0021:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.irc.DeviceIrcConfServer.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final String getHostname() {
        return this.hostname;
    }

    public final String getBackupIp() {
        return this.backupIp;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getPort() {
        return this.port;
    }
}
