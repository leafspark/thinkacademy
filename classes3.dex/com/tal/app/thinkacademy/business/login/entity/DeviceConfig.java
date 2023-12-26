package com.tal.app.thinkacademy.business.login.entity;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010$\u001a\u00020\u0010HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001b\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/DeviceConfig;", "", "rtcToken", "", "ircAppId", "ircAppKey", "ircNickName", "ircRooms", "", "coursewareZipUrl", "healthCheckMethod", "healthCheckUrl", "testPlanId", "ircServer", "Lcom/tal/app/thinkacademy/business/login/entity/DeviceIrcServer;", "studentId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/login/entity/DeviceIrcServer;J)V", "getCoursewareZipUrl", "()Ljava/lang/String;", "getHealthCheckMethod", "getHealthCheckUrl", "getIrcAppId", "getIrcAppKey", "getIrcNickName", "getIrcRooms", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getIrcServer", "()Lcom/tal/app/thinkacademy/business/login/entity/DeviceIrcServer;", "getRtcToken", "getStudentId", "()J", "getTestPlanId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/login/entity/DeviceIrcServer;J)Lcom/tal/app/thinkacademy/business/login/entity/DeviceConfig;", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceConfig.kt */
public final class DeviceConfig {
    private final String coursewareZipUrl;
    private final String healthCheckMethod;
    private final String healthCheckUrl;
    private final String ircAppId;
    private final String ircAppKey;
    private final String ircNickName;
    private final String[] ircRooms;
    private final DeviceIrcServer ircServer;
    private final String rtcToken;
    private final long studentId;
    private final String testPlanId;

    public DeviceConfig() {
        this((String) null, (String) null, (String) null, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null, (DeviceIrcServer) null, 0, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceConfig copy$default(DeviceConfig deviceConfig, String str, String str2, String str3, String str4, String[] strArr, String str5, String str6, String str7, String str8, DeviceIrcServer deviceIrcServer, long j, int i, Object obj) {
        DeviceConfig deviceConfig2 = deviceConfig;
        int i2 = i;
        return deviceConfig.copy((i2 & 1) != 0 ? deviceConfig2.rtcToken : str, (i2 & 2) != 0 ? deviceConfig2.ircAppId : str2, (i2 & 4) != 0 ? deviceConfig2.ircAppKey : str3, (i2 & 8) != 0 ? deviceConfig2.ircNickName : str4, (i2 & 16) != 0 ? deviceConfig2.ircRooms : strArr, (i2 & 32) != 0 ? deviceConfig2.coursewareZipUrl : str5, (i2 & 64) != 0 ? deviceConfig2.healthCheckMethod : str6, (i2 & 128) != 0 ? deviceConfig2.healthCheckUrl : str7, (i2 & 256) != 0 ? deviceConfig2.testPlanId : str8, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? deviceConfig2.ircServer : deviceIrcServer, (i2 & 1024) != 0 ? deviceConfig2.studentId : j);
    }

    public final String component1() {
        return this.rtcToken;
    }

    public final DeviceIrcServer component10() {
        return this.ircServer;
    }

    public final long component11() {
        return this.studentId;
    }

    public final String component2() {
        return this.ircAppId;
    }

    public final String component3() {
        return this.ircAppKey;
    }

    public final String component4() {
        return this.ircNickName;
    }

    public final String[] component5() {
        return this.ircRooms;
    }

    public final String component6() {
        return this.coursewareZipUrl;
    }

    public final String component7() {
        return this.healthCheckMethod;
    }

    public final String component8() {
        return this.healthCheckUrl;
    }

    public final String component9() {
        return this.testPlanId;
    }

    public final DeviceConfig copy(String str, String str2, String str3, String str4, String[] strArr, String str5, String str6, String str7, String str8, DeviceIrcServer deviceIrcServer, long j) {
        return new DeviceConfig(str, str2, str3, str4, strArr, str5, str6, str7, str8, deviceIrcServer, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceConfig)) {
            return false;
        }
        DeviceConfig deviceConfig = (DeviceConfig) obj;
        return Intrinsics.areEqual((Object) this.rtcToken, (Object) deviceConfig.rtcToken) && Intrinsics.areEqual((Object) this.ircAppId, (Object) deviceConfig.ircAppId) && Intrinsics.areEqual((Object) this.ircAppKey, (Object) deviceConfig.ircAppKey) && Intrinsics.areEqual((Object) this.ircNickName, (Object) deviceConfig.ircNickName) && Intrinsics.areEqual((Object) this.ircRooms, (Object) deviceConfig.ircRooms) && Intrinsics.areEqual((Object) this.coursewareZipUrl, (Object) deviceConfig.coursewareZipUrl) && Intrinsics.areEqual((Object) this.healthCheckMethod, (Object) deviceConfig.healthCheckMethod) && Intrinsics.areEqual((Object) this.healthCheckUrl, (Object) deviceConfig.healthCheckUrl) && Intrinsics.areEqual((Object) this.testPlanId, (Object) deviceConfig.testPlanId) && Intrinsics.areEqual((Object) this.ircServer, (Object) deviceConfig.ircServer) && this.studentId == deviceConfig.studentId;
    }

    public int hashCode() {
        String str = this.rtcToken;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ircAppId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ircAppKey;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.ircNickName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String[] strArr = this.ircRooms;
        int hashCode5 = (hashCode4 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String str5 = this.coursewareZipUrl;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.healthCheckMethod;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.healthCheckUrl;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.testPlanId;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        DeviceIrcServer deviceIrcServer = this.ircServer;
        if (deviceIrcServer != null) {
            i = deviceIrcServer.hashCode();
        }
        return ((hashCode9 + i) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.studentId);
    }

    public String toString() {
        return "DeviceConfig(rtcToken=" + this.rtcToken + ", ircAppId=" + this.ircAppId + ", ircAppKey=" + this.ircAppKey + ", ircNickName=" + this.ircNickName + ", ircRooms=" + Arrays.toString(this.ircRooms) + ", coursewareZipUrl=" + this.coursewareZipUrl + ", healthCheckMethod=" + this.healthCheckMethod + ", healthCheckUrl=" + this.healthCheckUrl + ", testPlanId=" + this.testPlanId + ", ircServer=" + this.ircServer + ", studentId=" + this.studentId + ')';
    }

    public DeviceConfig(String str, String str2, String str3, String str4, String[] strArr, String str5, String str6, String str7, String str8, DeviceIrcServer deviceIrcServer, long j) {
        this.rtcToken = str;
        this.ircAppId = str2;
        this.ircAppKey = str3;
        this.ircNickName = str4;
        this.ircRooms = strArr;
        this.coursewareZipUrl = str5;
        this.healthCheckMethod = str6;
        this.healthCheckUrl = str7;
        this.testPlanId = str8;
        this.ircServer = deviceIrcServer;
        this.studentId = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceConfig(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.tal.app.thinkacademy.business.login.entity.DeviceIrcServer r23, long r24, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r2 = r23
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0057
            r11 = 0
            goto L_0x0059
        L_0x0057:
            r11 = r24
        L_0x0059:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r2
            r25 = r11
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.entity.DeviceConfig.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tal.app.thinkacademy.business.login.entity.DeviceIrcServer, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getRtcToken() {
        return this.rtcToken;
    }

    public final String getIrcAppId() {
        return this.ircAppId;
    }

    public final String getIrcAppKey() {
        return this.ircAppKey;
    }

    public final String getIrcNickName() {
        return this.ircNickName;
    }

    public final String[] getIrcRooms() {
        return this.ircRooms;
    }

    public final String getCoursewareZipUrl() {
        return this.coursewareZipUrl;
    }

    public final String getHealthCheckMethod() {
        return this.healthCheckMethod;
    }

    public final String getHealthCheckUrl() {
        return this.healthCheckUrl;
    }

    public final String getTestPlanId() {
        return this.testPlanId;
    }

    public final DeviceIrcServer getIrcServer() {
        return this.ircServer;
    }

    public final long getStudentId() {
        return this.studentId;
    }
}
