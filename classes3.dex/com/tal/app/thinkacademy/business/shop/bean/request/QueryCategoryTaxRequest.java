package com.tal.app.thinkacademy.business.shop.bean.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/QueryCategoryTaxRequest;", "", "categorys", "", "Lcom/tal/app/thinkacademy/business/shop/bean/request/TaxCategoryBean;", "countryId", "", "platformType", "", "(Ljava/util/List;ILjava/lang/String;)V", "getCategorys", "()Ljava/util/List;", "setCategorys", "(Ljava/util/List;)V", "getCountryId", "()I", "setCountryId", "(I)V", "getPlatformType", "()Ljava/lang/String;", "setPlatformType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QueryCategoryTaxRequest.kt */
public final class QueryCategoryTaxRequest {
    private List<TaxCategoryBean> categorys;
    private int countryId;
    private String platformType;

    public QueryCategoryTaxRequest() {
        this((List) null, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QueryCategoryTaxRequest copy$default(QueryCategoryTaxRequest queryCategoryTaxRequest, List<TaxCategoryBean> list, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = queryCategoryTaxRequest.categorys;
        }
        if ((i2 & 2) != 0) {
            i = queryCategoryTaxRequest.countryId;
        }
        if ((i2 & 4) != 0) {
            str = queryCategoryTaxRequest.platformType;
        }
        return queryCategoryTaxRequest.copy(list, i, str);
    }

    public final List<TaxCategoryBean> component1() {
        return this.categorys;
    }

    public final int component2() {
        return this.countryId;
    }

    public final String component3() {
        return this.platformType;
    }

    public final QueryCategoryTaxRequest copy(List<TaxCategoryBean> list, int i, String str) {
        return new QueryCategoryTaxRequest(list, i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryCategoryTaxRequest)) {
            return false;
        }
        QueryCategoryTaxRequest queryCategoryTaxRequest = (QueryCategoryTaxRequest) obj;
        return Intrinsics.areEqual((Object) this.categorys, (Object) queryCategoryTaxRequest.categorys) && this.countryId == queryCategoryTaxRequest.countryId && Intrinsics.areEqual((Object) this.platformType, (Object) queryCategoryTaxRequest.platformType);
    }

    public int hashCode() {
        List<TaxCategoryBean> list = this.categorys;
        int i = 0;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.countryId) * 31;
        String str = this.platformType;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "QueryCategoryTaxRequest(categorys=" + this.categorys + ", countryId=" + this.countryId + ", platformType=" + this.platformType + ')';
    }

    public QueryCategoryTaxRequest(List<TaxCategoryBean> list, int i, String str) {
        this.categorys = list;
        this.countryId = i;
        this.platformType = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryCategoryTaxRequest(List list, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str);
    }

    public final List<TaxCategoryBean> getCategorys() {
        return this.categorys;
    }

    public final void setCategorys(List<TaxCategoryBean> list) {
        this.categorys = list;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    public final void setCountryId(int i) {
        this.countryId = i;
    }

    public final String getPlatformType() {
        return this.platformType;
    }

    public final void setPlatformType(String str) {
        this.platformType = str;
    }
}
