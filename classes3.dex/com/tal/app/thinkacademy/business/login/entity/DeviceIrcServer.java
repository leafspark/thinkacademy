package com.tal.app.thinkacademy.business.login.entity;

import com.tal.app.thinkacademy.lib.irc.DeviceIrcConfServer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/DeviceIrcServer;", "", "confServiceV3", "Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;", "logService", "locationV3", "", "(Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;Ljava/lang/String;)V", "getConfServiceV3", "()Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;", "getLocationV3", "()Ljava/lang/String;", "getLogService", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceConfig.kt */
public final class DeviceIrcServer {
    private final DeviceIrcConfServer confServiceV3;
    private final String locationV3;
    private final DeviceIrcConfServer logService;

    public DeviceIrcServer() {
        this((DeviceIrcConfServer) null, (DeviceIrcConfServer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceIrcServer copy$default(DeviceIrcServer deviceIrcServer, DeviceIrcConfServer deviceIrcConfServer, DeviceIrcConfServer deviceIrcConfServer2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceIrcConfServer = deviceIrcServer.confServiceV3;
        }
        if ((i & 2) != 0) {
            deviceIrcConfServer2 = deviceIrcServer.logService;
        }
        if ((i & 4) != 0) {
            str = deviceIrcServer.locationV3;
        }
        return deviceIrcServer.copy(deviceIrcConfServer, deviceIrcConfServer2, str);
    }

    public final DeviceIrcConfServer component1() {
        return this.confServiceV3;
    }

    public final DeviceIrcConfServer component2() {
        return this.logService;
    }

    public final String component3() {
        return this.locationV3;
    }

    public final DeviceIrcServer copy(DeviceIrcConfServer deviceIrcConfServer, DeviceIrcConfServer deviceIrcConfServer2, String str) {
        return new DeviceIrcServer(deviceIrcConfServer, deviceIrcConfServer2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceIrcServer)) {
            return false;
        }
        DeviceIrcServer deviceIrcServer = (DeviceIrcServer) obj;
        return Intrinsics.areEqual((Object) this.confServiceV3, (Object) deviceIrcServer.confServiceV3) && Intrinsics.areEqual((Object) this.logService, (Object) deviceIrcServer.logService) && Intrinsics.areEqual((Object) this.locationV3, (Object) deviceIrcServer.locationV3);
    }

    public int hashCode() {
        DeviceIrcConfServer deviceIrcConfServer = this.confServiceV3;
        int i = 0;
        int hashCode = (deviceIrcConfServer == null ? 0 : deviceIrcConfServer.hashCode()) * 31;
        DeviceIrcConfServer deviceIrcConfServer2 = this.logService;
        int hashCode2 = (hashCode + (deviceIrcConfServer2 == null ? 0 : deviceIrcConfServer2.hashCode())) * 31;
        String str = this.locationV3;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DeviceIrcServer(confServiceV3=" + this.confServiceV3 + ", logService=" + this.logService + ", locationV3=" + this.locationV3 + ')';
    }

    public DeviceIrcServer(DeviceIrcConfServer deviceIrcConfServer, DeviceIrcConfServer deviceIrcConfServer2, String str) {
        this.confServiceV3 = deviceIrcConfServer;
        this.logService = deviceIrcConfServer2;
        this.locationV3 = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceIrcServer(DeviceIrcConfServer deviceIrcConfServer, DeviceIrcConfServer deviceIrcConfServer2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : deviceIrcConfServer, (i & 2) != 0 ? null : deviceIrcConfServer2, (i & 4) != 0 ? null : str);
    }

    public final DeviceIrcConfServer getConfServiceV3() {
        return this.confServiceV3;
    }

    public final DeviceIrcConfServer getLogService() {
        return this.logService;
    }

    public final String getLocationV3() {
        return this.locationV3;
    }
}
