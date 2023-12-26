package com.tal.app.thinkacademy.common.imconfig;

import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ComonPackageInfo;", "Ljava/io/Serializable;", "entries", "Lcom/tal/app/thinkacademy/common/imconfig/ComonPackageInfo$CommonInfo;", "(Lcom/tal/app/thinkacademy/common/imconfig/ComonPackageInfo$CommonInfo;)V", "getEntries", "()Lcom/tal/app/thinkacademy/common/imconfig/ComonPackageInfo$CommonInfo;", "setEntries", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "CommonInfo", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComonPackageInfo.kt */
public final class ComonPackageInfo implements Serializable {
    private CommonInfo entries;

    public static /* synthetic */ ComonPackageInfo copy$default(ComonPackageInfo comonPackageInfo, CommonInfo commonInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            commonInfo = comonPackageInfo.entries;
        }
        return comonPackageInfo.copy(commonInfo);
    }

    public final CommonInfo component1() {
        return this.entries;
    }

    public final ComonPackageInfo copy(CommonInfo commonInfo) {
        Intrinsics.checkNotNullParameter(commonInfo, "entries");
        return new ComonPackageInfo(commonInfo);
    }

    public ComonPackageInfo(CommonInfo commonInfo) {
        Intrinsics.checkNotNullParameter(commonInfo, "entries");
        this.entries = commonInfo;
    }

    public final CommonInfo getEntries() {
        return this.entries;
    }

    public final void setEntries(CommonInfo commonInfo) {
        Intrinsics.checkNotNullParameter(commonInfo, "<set-?>");
        this.entries = commonInfo;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ComonPackageInfo$CommonInfo;", "Ljava/io/Serializable;", "commonWebUrl", "", "commonWebZipMd5", "distUrl", "distZipMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCommonWebUrl", "()Ljava/lang/String;", "setCommonWebUrl", "(Ljava/lang/String;)V", "getCommonWebZipMd5", "setCommonWebZipMd5", "getDistUrl", "setDistUrl", "getDistZipMd5", "setDistZipMd5", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ComonPackageInfo.kt */
    public static final class CommonInfo implements Serializable {
        private String commonWebUrl;
        private String commonWebZipMd5;
        private String distUrl;
        private String distZipMd5;

        public static /* synthetic */ CommonInfo copy$default(CommonInfo commonInfo, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = commonInfo.commonWebUrl;
            }
            if ((i & 2) != 0) {
                str2 = commonInfo.commonWebZipMd5;
            }
            if ((i & 4) != 0) {
                str3 = commonInfo.distUrl;
            }
            if ((i & 8) != 0) {
                str4 = commonInfo.distZipMd5;
            }
            return commonInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.commonWebUrl;
        }

        public final String component2() {
            return this.commonWebZipMd5;
        }

        public final String component3() {
            return this.distUrl;
        }

        public final String component4() {
            return this.distZipMd5;
        }

        public final CommonInfo copy(String str, String str2, String str3, String str4) {
            return new CommonInfo(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CommonInfo)) {
                return false;
            }
            CommonInfo commonInfo = (CommonInfo) obj;
            return Intrinsics.areEqual(this.commonWebUrl, commonInfo.commonWebUrl) && Intrinsics.areEqual(this.commonWebZipMd5, commonInfo.commonWebZipMd5) && Intrinsics.areEqual(this.distUrl, commonInfo.distUrl) && Intrinsics.areEqual(this.distZipMd5, commonInfo.distZipMd5);
        }

        public int hashCode() {
            String str = this.commonWebUrl;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.commonWebZipMd5;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.distUrl;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.distZipMd5;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "CommonInfo(commonWebUrl=" + this.commonWebUrl + ", commonWebZipMd5=" + this.commonWebZipMd5 + ", distUrl=" + this.distUrl + ", distZipMd5=" + this.distZipMd5 + ')';
        }

        public CommonInfo(String str, String str2, String str3, String str4) {
            this.commonWebUrl = str;
            this.commonWebZipMd5 = str2;
            this.distUrl = str3;
            this.distZipMd5 = str4;
        }

        public final String getCommonWebUrl() {
            return this.commonWebUrl;
        }

        public final void setCommonWebUrl(String str) {
            this.commonWebUrl = str;
        }

        public final String getCommonWebZipMd5() {
            return this.commonWebZipMd5;
        }

        public final void setCommonWebZipMd5(String str) {
            this.commonWebZipMd5 = str;
        }

        public final String getDistUrl() {
            return this.distUrl;
        }

        public final void setDistUrl(String str) {
            this.distUrl = str;
        }

        public final String getDistZipMd5() {
            return this.distZipMd5;
        }

        public final void setDistZipMd5(String str) {
            this.distZipMd5 = str;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.tal.app.thinkacademy.common.imconfig.ComonPackageInfo");
        return this.entries.equals(((ComonPackageInfo) obj).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return super.toString();
    }
}
