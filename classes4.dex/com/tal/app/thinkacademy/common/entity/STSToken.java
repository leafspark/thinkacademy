package com.tal.app.thinkacademy.common.entity;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¤\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0007HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$¨\u00069"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/STSToken;", "", "accessKey", "", "accessSecret", "sessionToken", "expireSecond", "", "region", "bucketName", "appUrl", "endPoint", "target", "filePaths", "", "finalScene", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAccessKey", "()Ljava/lang/String;", "getAccessSecret", "getAppUrl", "getBucketName", "getEndPoint", "getExpireSecond", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFilePaths", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getFinalScene", "getRegion", "getSessionToken", "getTarget", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/tal/app/thinkacademy/common/entity/STSToken;", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: STSToken.kt */
public final class STSToken {
    private final String accessKey;
    private final String accessSecret;
    private final String appUrl;
    private final String bucketName;
    private final String endPoint;
    private final Integer expireSecond;
    private final String[] filePaths;
    private final String finalScene;
    private final String region;
    private final String sessionToken;
    private final String target;
    private final Long timestamp;

    public static /* synthetic */ STSToken copy$default(STSToken sTSToken, String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String[] strArr, String str9, Long l, int i, Object obj) {
        STSToken sTSToken2 = sTSToken;
        int i2 = i;
        return sTSToken.copy((i2 & 1) != 0 ? sTSToken2.accessKey : str, (i2 & 2) != 0 ? sTSToken2.accessSecret : str2, (i2 & 4) != 0 ? sTSToken2.sessionToken : str3, (i2 & 8) != 0 ? sTSToken2.expireSecond : num, (i2 & 16) != 0 ? sTSToken2.region : str4, (i2 & 32) != 0 ? sTSToken2.bucketName : str5, (i2 & 64) != 0 ? sTSToken2.appUrl : str6, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? sTSToken2.endPoint : str7, (i2 & 256) != 0 ? sTSToken2.target : str8, (i2 & 512) != 0 ? sTSToken2.filePaths : strArr, (i2 & 1024) != 0 ? sTSToken2.finalScene : str9, (i2 & 2048) != 0 ? sTSToken2.timestamp : l);
    }

    public final String component1() {
        return this.accessKey;
    }

    public final String[] component10() {
        return this.filePaths;
    }

    public final String component11() {
        return this.finalScene;
    }

    public final Long component12() {
        return this.timestamp;
    }

    public final String component2() {
        return this.accessSecret;
    }

    public final String component3() {
        return this.sessionToken;
    }

    public final Integer component4() {
        return this.expireSecond;
    }

    public final String component5() {
        return this.region;
    }

    public final String component6() {
        return this.bucketName;
    }

    public final String component7() {
        return this.appUrl;
    }

    public final String component8() {
        return this.endPoint;
    }

    public final String component9() {
        return this.target;
    }

    public final STSToken copy(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String[] strArr, String str9, Long l) {
        String[] strArr2 = strArr;
        Intrinsics.checkNotNullParameter(strArr2, "filePaths");
        return new STSToken(str, str2, str3, num, str4, str5, str6, str7, str8, strArr2, str9, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof STSToken)) {
            return false;
        }
        STSToken sTSToken = (STSToken) obj;
        return Intrinsics.areEqual(this.accessKey, sTSToken.accessKey) && Intrinsics.areEqual(this.accessSecret, sTSToken.accessSecret) && Intrinsics.areEqual(this.sessionToken, sTSToken.sessionToken) && Intrinsics.areEqual(this.expireSecond, sTSToken.expireSecond) && Intrinsics.areEqual(this.region, sTSToken.region) && Intrinsics.areEqual(this.bucketName, sTSToken.bucketName) && Intrinsics.areEqual(this.appUrl, sTSToken.appUrl) && Intrinsics.areEqual(this.endPoint, sTSToken.endPoint) && Intrinsics.areEqual(this.target, sTSToken.target) && Intrinsics.areEqual(this.filePaths, sTSToken.filePaths) && Intrinsics.areEqual(this.finalScene, sTSToken.finalScene) && Intrinsics.areEqual(this.timestamp, sTSToken.timestamp);
    }

    public int hashCode() {
        String str = this.accessKey;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.accessSecret;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionToken;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.expireSecond;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.region;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.bucketName;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.appUrl;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.endPoint;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.target;
        int hashCode9 = (((hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31) + Arrays.hashCode(this.filePaths)) * 31;
        String str9 = this.finalScene;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l = this.timestamp;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "STSToken(accessKey=" + this.accessKey + ", accessSecret=" + this.accessSecret + ", sessionToken=" + this.sessionToken + ", expireSecond=" + this.expireSecond + ", region=" + this.region + ", bucketName=" + this.bucketName + ", appUrl=" + this.appUrl + ", endPoint=" + this.endPoint + ", target=" + this.target + ", filePaths=" + Arrays.toString(this.filePaths) + ", finalScene=" + this.finalScene + ", timestamp=" + this.timestamp + ')';
    }

    public STSToken(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String[] strArr, String str9, Long l) {
        Intrinsics.checkNotNullParameter(strArr, "filePaths");
        this.accessKey = str;
        this.accessSecret = str2;
        this.sessionToken = str3;
        this.expireSecond = num;
        this.region = str4;
        this.bucketName = str5;
        this.appUrl = str6;
        this.endPoint = str7;
        this.target = str8;
        this.filePaths = strArr;
        this.finalScene = str9;
        this.timestamp = l;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getAccessSecret() {
        return this.accessSecret;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }

    public final Integer getExpireSecond() {
        return this.expireSecond;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public final String getAppUrl() {
        return this.appUrl;
    }

    public final String getEndPoint() {
        return this.endPoint;
    }

    public final String getTarget() {
        return this.target;
    }

    public final String[] getFilePaths() {
        return this.filePaths;
    }

    public final String getFinalScene() {
        return this.finalScene;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }
}
