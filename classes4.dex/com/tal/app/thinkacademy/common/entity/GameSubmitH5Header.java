package com.tal.app.thinkacademy.common.entity;

import com.google.gson.annotations.SerializedName;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010¨\u00061"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/GameSubmitH5Header;", "", "schoolCode", "", "clientType", "Authorization", "xToken", "appVersion", "appName", "platform", "deviceName", "timezone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorization", "()Ljava/lang/String;", "setAuthorization", "(Ljava/lang/String;)V", "getAppName", "setAppName", "getAppVersion", "setAppVersion", "getClientType", "setClientType", "getDeviceName", "setDeviceName", "getPlatform", "setPlatform", "getSchoolCode", "setSchoolCode", "getTimezone", "setTimezone", "getXToken", "setXToken", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitHeaderData.kt */
public final class GameSubmitH5Header {
    private String Authorization;
    private String appName;
    private String appVersion;
    private String clientType;
    private String deviceName;
    private String platform;
    private String schoolCode;
    private String timezone;
    @SerializedName("x-token")
    private String xToken;

    public GameSubmitH5Header() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GameSubmitH5Header copy$default(GameSubmitH5Header gameSubmitH5Header, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        GameSubmitH5Header gameSubmitH5Header2 = gameSubmitH5Header;
        int i2 = i;
        return gameSubmitH5Header.copy((i2 & 1) != 0 ? gameSubmitH5Header2.schoolCode : str, (i2 & 2) != 0 ? gameSubmitH5Header2.clientType : str2, (i2 & 4) != 0 ? gameSubmitH5Header2.Authorization : str3, (i2 & 8) != 0 ? gameSubmitH5Header2.xToken : str4, (i2 & 16) != 0 ? gameSubmitH5Header2.appVersion : str5, (i2 & 32) != 0 ? gameSubmitH5Header2.appName : str6, (i2 & 64) != 0 ? gameSubmitH5Header2.platform : str7, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? gameSubmitH5Header2.deviceName : str8, (i2 & 256) != 0 ? gameSubmitH5Header2.timezone : str9);
    }

    public final String component1() {
        return this.schoolCode;
    }

    public final String component2() {
        return this.clientType;
    }

    public final String component3() {
        return this.Authorization;
    }

    public final String component4() {
        return this.xToken;
    }

    public final String component5() {
        return this.appVersion;
    }

    public final String component6() {
        return this.appName;
    }

    public final String component7() {
        return this.platform;
    }

    public final String component8() {
        return this.deviceName;
    }

    public final String component9() {
        return this.timezone;
    }

    public final GameSubmitH5Header copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new GameSubmitH5Header(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameSubmitH5Header)) {
            return false;
        }
        GameSubmitH5Header gameSubmitH5Header = (GameSubmitH5Header) obj;
        return Intrinsics.areEqual(this.schoolCode, gameSubmitH5Header.schoolCode) && Intrinsics.areEqual(this.clientType, gameSubmitH5Header.clientType) && Intrinsics.areEqual(this.Authorization, gameSubmitH5Header.Authorization) && Intrinsics.areEqual(this.xToken, gameSubmitH5Header.xToken) && Intrinsics.areEqual(this.appVersion, gameSubmitH5Header.appVersion) && Intrinsics.areEqual(this.appName, gameSubmitH5Header.appName) && Intrinsics.areEqual(this.platform, gameSubmitH5Header.platform) && Intrinsics.areEqual(this.deviceName, gameSubmitH5Header.deviceName) && Intrinsics.areEqual(this.timezone, gameSubmitH5Header.timezone);
    }

    public int hashCode() {
        String str = this.schoolCode;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.clientType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.Authorization;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.xToken;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.appVersion;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.appName;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.platform;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.deviceName;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.timezone;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "GameSubmitH5Header(schoolCode=" + this.schoolCode + ", clientType=" + this.clientType + ", Authorization=" + this.Authorization + ", xToken=" + this.xToken + ", appVersion=" + this.appVersion + ", appName=" + this.appName + ", platform=" + this.platform + ", deviceName=" + this.deviceName + ", timezone=" + this.timezone + ')';
    }

    public GameSubmitH5Header(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.schoolCode = str;
        this.clientType = str2;
        this.Authorization = str3;
        this.xToken = str4;
        this.appVersion = str5;
        this.appName = str6;
        this.platform = str7;
        this.deviceName = str8;
        this.timezone = str9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GameSubmitH5Header(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0015
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r3 = "school_code"
            java.lang.String r4 = "415"
            java.lang.String r1 = r1.getString(r3, r4, r2)
            goto L_0x0016
        L_0x0015:
            r1 = r10
        L_0x0016:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0021
            com.tal.app.thinkacademy.common.network.CommonHeader r2 = com.tal.app.thinkacademy.common.network.CommonHeader.INSTANCE
            java.lang.String r2 = r2.clientType()
            goto L_0x0022
        L_0x0021:
            r2 = r11
        L_0x0022:
            r3 = r0 & 4
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x003d
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r3 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r3 = r3.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r3 = r3.getUserInfoEntity()
            if (r3 != 0) goto L_0x0036
        L_0x0034:
            r3 = r4
            goto L_0x003e
        L_0x0036:
            java.lang.String r3 = r3.getUnifiedAccessToken()
            if (r3 != 0) goto L_0x003e
            goto L_0x0034
        L_0x003d:
            r3 = r12
        L_0x003e:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0058
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r5 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r5 = r5.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r5 = r5.getUserInfoEntity()
            if (r5 != 0) goto L_0x004f
            goto L_0x0059
        L_0x004f:
            java.lang.String r5 = r5.getUnifiedAccessToken()
            if (r5 != 0) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            r4 = r5
            goto L_0x0059
        L_0x0058:
            r4 = r13
        L_0x0059:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0062
            java.lang.String r5 = com.tal.app.thinkacademy.lib.util.AppUtils.getAppVersionName()
            goto L_0x0063
        L_0x0062:
            r5 = r14
        L_0x0063:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x006a
            java.lang.String r6 = "Think Collage"
            goto L_0x006b
        L_0x006a:
            r6 = r15
        L_0x006b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0072
            java.lang.String r7 = "android"
            goto L_0x0074
        L_0x0072:
            r7 = r16
        L_0x0074:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x007d
            java.lang.String r8 = com.tal.app.thinkacademy.lib.util.DeviceUtils.getModel()
            goto L_0x007f
        L_0x007d:
            r8 = r17
        L_0x007f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x008a
            com.tal.app.thinkacademy.common.utils.TimeZoneUtil r0 = com.tal.app.thinkacademy.common.utils.TimeZoneUtil.INSTANCE
            java.lang.String r0 = r0.getTimeZone()
            goto L_0x008c
        L_0x008a:
            r0 = r18
        L_0x008c:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.entity.GameSubmitH5Header.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(String str) {
        this.schoolCode = str;
    }

    public final String getClientType() {
        return this.clientType;
    }

    public final void setClientType(String str) {
        this.clientType = str;
    }

    public final String getAuthorization() {
        return this.Authorization;
    }

    public final void setAuthorization(String str) {
        this.Authorization = str;
    }

    public final String getXToken() {
        return this.xToken;
    }

    public final void setXToken(String str) {
        this.xToken = str;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        this.appVersion = str;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final void setPlatform(String str) {
        this.platform = str;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final void setTimezone(String str) {
        this.timezone = str;
    }
}
