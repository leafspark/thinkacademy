package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "", "latestCoin", "", "showCoinMall", "url", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getLatestCoin", "()Ljava/lang/Integer;", "setLatestCoin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShowCoinMall", "setShowCoinMall", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InitEntryInfoBean.kt */
public final class InitEntryInfoBean {
    private Integer latestCoin;
    private Integer showCoinMall;
    private String url;

    public InitEntryInfoBean() {
        this((Integer) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InitEntryInfoBean copy$default(InitEntryInfoBean initEntryInfoBean, Integer num, Integer num2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = initEntryInfoBean.latestCoin;
        }
        if ((i & 2) != 0) {
            num2 = initEntryInfoBean.showCoinMall;
        }
        if ((i & 4) != 0) {
            str = initEntryInfoBean.url;
        }
        return initEntryInfoBean.copy(num, num2, str);
    }

    public final Integer component1() {
        return this.latestCoin;
    }

    public final Integer component2() {
        return this.showCoinMall;
    }

    public final String component3() {
        return this.url;
    }

    public final InitEntryInfoBean copy(Integer num, Integer num2, String str) {
        return new InitEntryInfoBean(num, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitEntryInfoBean)) {
            return false;
        }
        InitEntryInfoBean initEntryInfoBean = (InitEntryInfoBean) obj;
        return Intrinsics.areEqual(this.latestCoin, initEntryInfoBean.latestCoin) && Intrinsics.areEqual(this.showCoinMall, initEntryInfoBean.showCoinMall) && Intrinsics.areEqual(this.url, initEntryInfoBean.url);
    }

    public int hashCode() {
        Integer num = this.latestCoin;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.showCoinMall;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.url;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "InitEntryInfoBean(latestCoin=" + this.latestCoin + ", showCoinMall=" + this.showCoinMall + ", url=" + this.url + ')';
    }

    public InitEntryInfoBean(Integer num, Integer num2, String str) {
        this.latestCoin = num;
        this.showCoinMall = num2;
        this.url = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InitEntryInfoBean(Integer num, Integer num2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 2 : num2, (i & 4) != 0 ? "" : str);
    }

    public final Integer getLatestCoin() {
        return this.latestCoin;
    }

    public final void setLatestCoin(Integer num) {
        this.latestCoin = num;
    }

    public final Integer getShowCoinMall() {
        return this.showCoinMall;
    }

    public final void setShowCoinMall(Integer num) {
        this.showCoinMall = num;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
