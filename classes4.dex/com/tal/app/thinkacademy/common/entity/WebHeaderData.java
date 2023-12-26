package com.tal.app.thinkacademy.common.entity;

import com.google.gson.annotations.SerializedName;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u000fB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/WebHeaderData;", "", "type", "", "data", "Lcom/tal/app/thinkacademy/common/entity/WebHeaderData$HeadersParams;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/common/entity/WebHeaderData$HeadersParams;)V", "getData", "()Lcom/tal/app/thinkacademy/common/entity/WebHeaderData$HeadersParams;", "setData", "(Lcom/tal/app/thinkacademy/common/entity/WebHeaderData$HeadersParams;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "HeadersParams", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebHeaderData.kt */
public final class WebHeaderData {
    private HeadersParams data;
    private String type;

    public WebHeaderData() {
        this((String) null, (HeadersParams) null, 3, (DefaultConstructorMarker) null);
    }

    public WebHeaderData(String str, HeadersParams headersParams) {
        this.type = str;
        this.data = headersParams;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public /* synthetic */ WebHeaderData(String str, HeadersParams headersParams, int i, DefaultConstructorMarker defaultConstructorMarker) {
        WebHeaderData webHeaderData;
        HeadersParams headersParams2;
        String str2 = (i & 1) != 0 ? WebHeaderDataKt.reward : str;
        if ((i & 2) != 0) {
            headersParams2 = new HeadersParams((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
            webHeaderData = this;
        } else {
            webHeaderData = this;
            headersParams2 = headersParams;
        }
        new WebHeaderData(str2, headersParams2);
    }

    public final HeadersParams getData() {
        return this.data;
    }

    public final void setData(HeadersParams headersParams) {
        this.data = headersParams;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006="}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/WebHeaderData$HeadersParams;", "", "schoolCode", "", "clientType", "Authorization", "xToken", "appVersion", "appName", "platform", "deviceName", "uid", "ua", "shareCode", "timezone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorization", "()Ljava/lang/String;", "setAuthorization", "(Ljava/lang/String;)V", "getAppName", "setAppName", "getAppVersion", "setAppVersion", "getClientType", "setClientType", "getDeviceName", "setDeviceName", "getPlatform", "setPlatform", "getSchoolCode", "setSchoolCode", "getShareCode", "setShareCode", "getTimezone", "setTimezone", "getUa", "setUa", "getUid", "setUid", "getXToken", "setXToken", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebHeaderData.kt */
    public static final class HeadersParams {
        private String Authorization;
        private String appName;
        private String appVersion;
        private String clientType;
        private String deviceName;
        private String platform;
        private String schoolCode;
        private String shareCode;
        private String timezone;
        private String ua;
        private String uid;
        @SerializedName("x-token")
        private String xToken;

        public HeadersParams() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ HeadersParams copy$default(HeadersParams headersParams, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, Object obj) {
            HeadersParams headersParams2 = headersParams;
            int i2 = i;
            return headersParams.copy((i2 & 1) != 0 ? headersParams2.schoolCode : str, (i2 & 2) != 0 ? headersParams2.clientType : str2, (i2 & 4) != 0 ? headersParams2.Authorization : str3, (i2 & 8) != 0 ? headersParams2.xToken : str4, (i2 & 16) != 0 ? headersParams2.appVersion : str5, (i2 & 32) != 0 ? headersParams2.appName : str6, (i2 & 64) != 0 ? headersParams2.platform : str7, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? headersParams2.deviceName : str8, (i2 & 256) != 0 ? headersParams2.uid : str9, (i2 & 512) != 0 ? headersParams2.ua : str10, (i2 & 1024) != 0 ? headersParams2.shareCode : str11, (i2 & 2048) != 0 ? headersParams2.timezone : str12);
        }

        public final String component1() {
            return this.schoolCode;
        }

        public final String component10() {
            return this.ua;
        }

        public final String component11() {
            return this.shareCode;
        }

        public final String component12() {
            return this.timezone;
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
            return this.uid;
        }

        public final HeadersParams copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
            return new HeadersParams(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HeadersParams)) {
                return false;
            }
            HeadersParams headersParams = (HeadersParams) obj;
            return Intrinsics.areEqual(this.schoolCode, headersParams.schoolCode) && Intrinsics.areEqual(this.clientType, headersParams.clientType) && Intrinsics.areEqual(this.Authorization, headersParams.Authorization) && Intrinsics.areEqual(this.xToken, headersParams.xToken) && Intrinsics.areEqual(this.appVersion, headersParams.appVersion) && Intrinsics.areEqual(this.appName, headersParams.appName) && Intrinsics.areEqual(this.platform, headersParams.platform) && Intrinsics.areEqual(this.deviceName, headersParams.deviceName) && Intrinsics.areEqual(this.uid, headersParams.uid) && Intrinsics.areEqual(this.ua, headersParams.ua) && Intrinsics.areEqual(this.shareCode, headersParams.shareCode) && Intrinsics.areEqual(this.timezone, headersParams.timezone);
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
            String str9 = this.uid;
            int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.ua;
            int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.shareCode;
            int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.timezone;
            if (str12 != null) {
                i = str12.hashCode();
            }
            return hashCode11 + i;
        }

        public String toString() {
            return "HeadersParams(schoolCode=" + this.schoolCode + ", clientType=" + this.clientType + ", Authorization=" + this.Authorization + ", xToken=" + this.xToken + ", appVersion=" + this.appVersion + ", appName=" + this.appName + ", platform=" + this.platform + ", deviceName=" + this.deviceName + ", uid=" + this.uid + ", ua=" + this.ua + ", shareCode=" + this.shareCode + ", timezone=" + this.timezone + ')';
        }

        public HeadersParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
            this.schoolCode = str;
            this.clientType = str2;
            this.Authorization = str3;
            this.xToken = str4;
            this.appVersion = str5;
            this.appName = str6;
            this.platform = str7;
            this.deviceName = str8;
            this.uid = str9;
            this.ua = str10;
            this.shareCode = str11;
            this.timezone = str12;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ HeadersParams(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
            /*
                r13 = this;
                r0 = r26
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0015
                com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
                int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
                java.lang.String r3 = "school_code"
                java.lang.String r4 = "415"
                java.lang.String r1 = r1.getString(r3, r4, r2)
                goto L_0x0016
            L_0x0015:
                r1 = r14
            L_0x0016:
                r2 = r0 & 2
                if (r2 == 0) goto L_0x0021
                com.tal.app.thinkacademy.common.network.CommonHeader r2 = com.tal.app.thinkacademy.common.network.CommonHeader.INSTANCE
                java.lang.String r2 = r2.clientType()
                goto L_0x0022
            L_0x0021:
                r2 = r15
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
                goto L_0x003f
            L_0x0036:
                java.lang.String r3 = r3.getUnifiedAccessToken()
                if (r3 != 0) goto L_0x003f
                goto L_0x0034
            L_0x003d:
                r3 = r16
            L_0x003f:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x0058
                com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r5 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
                com.tal.app.thinkacademy.common.user.UserInfoBll r5 = r5.getInstance()
                com.tal.app.thinkacademy.common.user.UserInfo r5 = r5.getUserInfoEntity()
                if (r5 != 0) goto L_0x0051
            L_0x004f:
                r5 = r4
                goto L_0x005a
            L_0x0051:
                java.lang.String r5 = r5.getUnifiedAccessToken()
                if (r5 != 0) goto L_0x005a
                goto L_0x004f
            L_0x0058:
                r5 = r17
            L_0x005a:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0063
                java.lang.String r6 = com.tal.app.thinkacademy.lib.util.AppUtils.getAppVersionName()
                goto L_0x0065
            L_0x0063:
                r6 = r18
            L_0x0065:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x006c
                java.lang.String r7 = "Think Collage"
                goto L_0x006e
            L_0x006c:
                r7 = r19
            L_0x006e:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0075
                java.lang.String r8 = "android"
                goto L_0x0077
            L_0x0075:
                r8 = r20
            L_0x0077:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x0080
                java.lang.String r9 = com.tal.app.thinkacademy.lib.util.DeviceUtils.getModel()
                goto L_0x0082
            L_0x0080:
                r9 = r21
            L_0x0082:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x0099
                com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r10 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
                com.tal.app.thinkacademy.common.user.UserInfoBll r10 = r10.getInstance()
                com.tal.app.thinkacademy.common.user.UserInfo r10 = r10.getUserInfoEntity()
                if (r10 != 0) goto L_0x0094
                r10 = 0
                goto L_0x009b
            L_0x0094:
                java.lang.String r10 = r10.getUid()
                goto L_0x009b
            L_0x0099:
                r10 = r22
            L_0x009b:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x00a2
                java.lang.String r11 = "ThinkAcademy"
                goto L_0x00a4
            L_0x00a2:
                r11 = r23
            L_0x00a4:
                r12 = r0 & 1024(0x400, float:1.435E-42)
                if (r12 == 0) goto L_0x00a9
                goto L_0x00ab
            L_0x00a9:
                r4 = r24
            L_0x00ab:
                r0 = r0 & 2048(0x800, float:2.87E-42)
                if (r0 == 0) goto L_0x00b6
                com.tal.app.thinkacademy.common.utils.TimeZoneUtil r0 = com.tal.app.thinkacademy.common.utils.TimeZoneUtil.INSTANCE
                java.lang.String r0 = r0.getTimeZone()
                goto L_0x00b8
            L_0x00b6:
                r0 = r25
            L_0x00b8:
                r14 = r13
                r15 = r1
                r16 = r2
                r17 = r3
                r18 = r5
                r19 = r6
                r20 = r7
                r21 = r8
                r22 = r9
                r23 = r10
                r24 = r11
                r25 = r4
                r26 = r0
                r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.entity.WebHeaderData.HeadersParams.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

        public final String getUid() {
            return this.uid;
        }

        public final void setUid(String str) {
            this.uid = str;
        }

        public final String getUa() {
            return this.ua;
        }

        public final void setUa(String str) {
            this.ua = str;
        }

        public final String getShareCode() {
            return this.shareCode;
        }

        public final void setShareCode(String str) {
            this.shareCode = str;
        }

        public final String getTimezone() {
            return this.timezone;
        }

        public final void setTimezone(String str) {
            this.timezone = str;
        }
    }
}
