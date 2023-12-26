package com.tal.app.thinkacademy.live.business.redpackagerain.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "", "onlinePath", "", "offlineZipPath", "offlineZipSize", "", "offlineZipMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getOfflineZipMd5", "()Ljava/lang/String;", "getOfflineZipPath", "getOfflineZipSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOnlinePath", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainResBean.kt */
public final class RedPackageRainResBean {
    private final String offlineZipMd5;
    private final String offlineZipPath;
    private final Long offlineZipSize;
    private final String onlinePath;

    public static /* synthetic */ RedPackageRainResBean copy$default(RedPackageRainResBean redPackageRainResBean, String str, String str2, Long l, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = redPackageRainResBean.onlinePath;
        }
        if ((i & 2) != 0) {
            str2 = redPackageRainResBean.offlineZipPath;
        }
        if ((i & 4) != 0) {
            l = redPackageRainResBean.offlineZipSize;
        }
        if ((i & 8) != 0) {
            str3 = redPackageRainResBean.offlineZipMd5;
        }
        return redPackageRainResBean.copy(str, str2, l, str3);
    }

    public final String component1() {
        return this.onlinePath;
    }

    public final String component2() {
        return this.offlineZipPath;
    }

    public final Long component3() {
        return this.offlineZipSize;
    }

    public final String component4() {
        return this.offlineZipMd5;
    }

    public final RedPackageRainResBean copy(String str, String str2, Long l, String str3) {
        return new RedPackageRainResBean(str, str2, l, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedPackageRainResBean)) {
            return false;
        }
        RedPackageRainResBean redPackageRainResBean = (RedPackageRainResBean) obj;
        return Intrinsics.areEqual(this.onlinePath, redPackageRainResBean.onlinePath) && Intrinsics.areEqual(this.offlineZipPath, redPackageRainResBean.offlineZipPath) && Intrinsics.areEqual(this.offlineZipSize, redPackageRainResBean.offlineZipSize) && Intrinsics.areEqual(this.offlineZipMd5, redPackageRainResBean.offlineZipMd5);
    }

    public int hashCode() {
        String str = this.onlinePath;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.offlineZipPath;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.offlineZipSize;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.offlineZipMd5;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "RedPackageRainResBean(onlinePath=" + this.onlinePath + ", offlineZipPath=" + this.offlineZipPath + ", offlineZipSize=" + this.offlineZipSize + ", offlineZipMd5=" + this.offlineZipMd5 + ')';
    }

    public RedPackageRainResBean(String str, String str2, Long l, String str3) {
        this.onlinePath = str;
        this.offlineZipPath = str2;
        this.offlineZipSize = l;
        this.offlineZipMd5 = str3;
    }

    public final String getOnlinePath() {
        return this.onlinePath;
    }

    public final String getOfflineZipPath() {
        return this.offlineZipPath;
    }

    public final Long getOfflineZipSize() {
        return this.offlineZipSize;
    }

    public final String getOfflineZipMd5() {
        return this.offlineZipMd5;
    }
}
