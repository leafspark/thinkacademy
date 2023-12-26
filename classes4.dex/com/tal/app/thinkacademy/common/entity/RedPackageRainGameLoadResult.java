package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/RedPackageRainGameLoadResult;", "", "status", "", "errorinfo", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getErrorinfo", "()Ljava/lang/String;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/entity/RedPackageRainGameLoadResult;", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainGameLoadResult.kt */
public final class RedPackageRainGameLoadResult {
    private final String errorinfo;
    private final Integer status;

    public static /* synthetic */ RedPackageRainGameLoadResult copy$default(RedPackageRainGameLoadResult redPackageRainGameLoadResult, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = redPackageRainGameLoadResult.status;
        }
        if ((i & 2) != 0) {
            str = redPackageRainGameLoadResult.errorinfo;
        }
        return redPackageRainGameLoadResult.copy(num, str);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.errorinfo;
    }

    public final RedPackageRainGameLoadResult copy(Integer num, String str) {
        return new RedPackageRainGameLoadResult(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedPackageRainGameLoadResult)) {
            return false;
        }
        RedPackageRainGameLoadResult redPackageRainGameLoadResult = (RedPackageRainGameLoadResult) obj;
        return Intrinsics.areEqual(this.status, redPackageRainGameLoadResult.status) && Intrinsics.areEqual(this.errorinfo, redPackageRainGameLoadResult.errorinfo);
    }

    public int hashCode() {
        Integer num = this.status;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.errorinfo;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RedPackageRainGameLoadResult(status=" + this.status + ", errorinfo=" + this.errorinfo + ')';
    }

    public RedPackageRainGameLoadResult(Integer num, String str) {
        this.status = num;
        this.errorinfo = str;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getErrorinfo() {
        return this.errorinfo;
    }
}
