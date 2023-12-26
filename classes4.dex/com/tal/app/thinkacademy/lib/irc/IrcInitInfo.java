package com.tal.app.thinkacademy.lib.irc;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0001\u0010:\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015¨\u0006@"}, d2 = {"Lcom/tal/app/thinkacademy/lib/irc/IrcInitInfo;", "", "roomIds", "", "", "uid", "isCallAllUser", "", "nickname", "liveId", "businessId", "subBusinessId", "classId", "locationV3", "confServiceV3", "Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;", "logService", "(Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;)V", "getBusinessId", "()Ljava/lang/String;", "setBusinessId", "(Ljava/lang/String;)V", "getClassId", "setClassId", "getConfServiceV3", "()Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;", "setConfServiceV3", "(Lcom/tal/app/thinkacademy/lib/irc/DeviceIrcConfServer;)V", "()Z", "setCallAllUser", "(Z)V", "getLiveId", "setLiveId", "getLocationV3", "setLocationV3", "getLogService", "setLogService", "getNickname", "setNickname", "getRoomIds", "()Ljava/util/List;", "setRoomIds", "(Ljava/util/List;)V", "getSubBusinessId", "setSubBusinessId", "getUid", "setUid", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrcInitInfo.kt */
public final class IrcInitInfo {
    private String businessId;
    private String classId;
    private DeviceIrcConfServer confServiceV3;
    private boolean isCallAllUser;
    private String liveId;
    private String locationV3;
    private DeviceIrcConfServer logService;
    private String nickname;
    private List<String> roomIds;
    private String subBusinessId;
    private String uid;

    public IrcInitInfo() {
        this((List) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (DeviceIrcConfServer) null, (DeviceIrcConfServer) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IrcInitInfo copy$default(IrcInitInfo ircInitInfo, List list, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, DeviceIrcConfServer deviceIrcConfServer, DeviceIrcConfServer deviceIrcConfServer2, int i, Object obj) {
        IrcInitInfo ircInitInfo2 = ircInitInfo;
        int i2 = i;
        return ircInitInfo.copy((i2 & 1) != 0 ? ircInitInfo2.roomIds : list, (i2 & 2) != 0 ? ircInitInfo2.uid : str, (i2 & 4) != 0 ? ircInitInfo2.isCallAllUser : z, (i2 & 8) != 0 ? ircInitInfo2.nickname : str2, (i2 & 16) != 0 ? ircInitInfo2.liveId : str3, (i2 & 32) != 0 ? ircInitInfo2.businessId : str4, (i2 & 64) != 0 ? ircInitInfo2.subBusinessId : str5, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? ircInitInfo2.classId : str6, (i2 & 256) != 0 ? ircInitInfo2.locationV3 : str7, (i2 & 512) != 0 ? ircInitInfo2.confServiceV3 : deviceIrcConfServer, (i2 & 1024) != 0 ? ircInitInfo2.logService : deviceIrcConfServer2);
    }

    public final List<String> component1() {
        return this.roomIds;
    }

    public final DeviceIrcConfServer component10() {
        return this.confServiceV3;
    }

    public final DeviceIrcConfServer component11() {
        return this.logService;
    }

    public final String component2() {
        return this.uid;
    }

    public final boolean component3() {
        return this.isCallAllUser;
    }

    public final String component4() {
        return this.nickname;
    }

    public final String component5() {
        return this.liveId;
    }

    public final String component6() {
        return this.businessId;
    }

    public final String component7() {
        return this.subBusinessId;
    }

    public final String component8() {
        return this.classId;
    }

    public final String component9() {
        return this.locationV3;
    }

    public final IrcInitInfo copy(List<String> list, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, DeviceIrcConfServer deviceIrcConfServer, DeviceIrcConfServer deviceIrcConfServer2) {
        return new IrcInitInfo(list, str, z, str2, str3, str4, str5, str6, str7, deviceIrcConfServer, deviceIrcConfServer2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IrcInitInfo)) {
            return false;
        }
        IrcInitInfo ircInitInfo = (IrcInitInfo) obj;
        return Intrinsics.areEqual(this.roomIds, ircInitInfo.roomIds) && Intrinsics.areEqual(this.uid, ircInitInfo.uid) && this.isCallAllUser == ircInitInfo.isCallAllUser && Intrinsics.areEqual(this.nickname, ircInitInfo.nickname) && Intrinsics.areEqual(this.liveId, ircInitInfo.liveId) && Intrinsics.areEqual(this.businessId, ircInitInfo.businessId) && Intrinsics.areEqual(this.subBusinessId, ircInitInfo.subBusinessId) && Intrinsics.areEqual(this.classId, ircInitInfo.classId) && Intrinsics.areEqual(this.locationV3, ircInitInfo.locationV3) && Intrinsics.areEqual(this.confServiceV3, ircInitInfo.confServiceV3) && Intrinsics.areEqual(this.logService, ircInitInfo.logService);
    }

    public int hashCode() {
        List<String> list = this.roomIds;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.uid;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.isCallAllUser;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str2 = this.nickname;
        int hashCode3 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.liveId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.businessId;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subBusinessId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.classId;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.locationV3;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        DeviceIrcConfServer deviceIrcConfServer = this.confServiceV3;
        int hashCode9 = (hashCode8 + (deviceIrcConfServer == null ? 0 : deviceIrcConfServer.hashCode())) * 31;
        DeviceIrcConfServer deviceIrcConfServer2 = this.logService;
        if (deviceIrcConfServer2 != null) {
            i = deviceIrcConfServer2.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "IrcInitInfo(roomIds=" + this.roomIds + ", uid=" + this.uid + ", isCallAllUser=" + this.isCallAllUser + ", nickname=" + this.nickname + ", liveId=" + this.liveId + ", businessId=" + this.businessId + ", subBusinessId=" + this.subBusinessId + ", classId=" + this.classId + ", locationV3=" + this.locationV3 + ", confServiceV3=" + this.confServiceV3 + ", logService=" + this.logService + ')';
    }

    public IrcInitInfo(List<String> list, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, DeviceIrcConfServer deviceIrcConfServer, DeviceIrcConfServer deviceIrcConfServer2) {
        this.roomIds = list;
        this.uid = str;
        this.isCallAllUser = z;
        this.nickname = str2;
        this.liveId = str3;
        this.businessId = str4;
        this.subBusinessId = str5;
        this.classId = str6;
        this.locationV3 = str7;
        this.confServiceV3 = deviceIrcConfServer;
        this.logService = deviceIrcConfServer2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ IrcInitInfo(java.util.List r13, java.lang.String r14, boolean r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.tal.app.thinkacademy.lib.irc.DeviceIrcConfServer r22, com.tal.app.thinkacademy.lib.irc.DeviceIrcConfServer r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0013
        L_0x0012:
            r3 = r14
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = 0
            goto L_0x001a
        L_0x0019:
            r5 = r15
        L_0x001a:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0020
            r6 = r4
            goto L_0x0022
        L_0x0020:
            r6 = r16
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = r4
            goto L_0x002a
        L_0x0028:
            r7 = r17
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = r4
            goto L_0x0032
        L_0x0030:
            r8 = r18
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = r4
            goto L_0x003a
        L_0x0038:
            r9 = r19
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = r4
            goto L_0x0042
        L_0x0040:
            r10 = r20
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r4 = r21
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r22
        L_0x0051:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r2 = r23
        L_0x0058:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r4
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.irc.IrcInitInfo.<init>(java.util.List, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tal.app.thinkacademy.lib.irc.DeviceIrcConfServer, com.tal.app.thinkacademy.lib.irc.DeviceIrcConfServer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<String> getRoomIds() {
        return this.roomIds;
    }

    public final void setRoomIds(List<String> list) {
        this.roomIds = list;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final boolean isCallAllUser() {
        return this.isCallAllUser;
    }

    public final void setCallAllUser(boolean z) {
        this.isCallAllUser = z;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final String getLiveId() {
        return this.liveId;
    }

    public final void setLiveId(String str) {
        this.liveId = str;
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final void setBusinessId(String str) {
        this.businessId = str;
    }

    public final String getSubBusinessId() {
        return this.subBusinessId;
    }

    public final void setSubBusinessId(String str) {
        this.subBusinessId = str;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final void setClassId(String str) {
        this.classId = str;
    }

    public final String getLocationV3() {
        return this.locationV3;
    }

    public final void setLocationV3(String str) {
        this.locationV3 = str;
    }

    public final DeviceIrcConfServer getConfServiceV3() {
        return this.confServiceV3;
    }

    public final void setConfServiceV3(DeviceIrcConfServer deviceIrcConfServer) {
        this.confServiceV3 = deviceIrcConfServer;
    }

    public final DeviceIrcConfServer getLogService() {
        return this.logService;
    }

    public final void setLogService(DeviceIrcConfServer deviceIrcConfServer) {
        this.logService = deviceIrcConfServer;
    }
}
