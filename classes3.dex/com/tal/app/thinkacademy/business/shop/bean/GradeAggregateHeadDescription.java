package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHeadDescription;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "mainTitle", "", "subTitle", "mLocalIsLast", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "childNode", "", "getChildNode", "()Ljava/util/List;", "getMLocalIsLast", "()Z", "setMLocalIsLast", "(Z)V", "getMainTitle", "()Ljava/lang/String;", "getSubTitle", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateDetailInfo.kt */
public final class GradeAggregateHeadDescription extends BaseNode {
    private boolean mLocalIsLast;
    private final String mainTitle;
    private final String subTitle;

    public GradeAggregateHeadDescription() {
        this((String) null, (String) null, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GradeAggregateHeadDescription copy$default(GradeAggregateHeadDescription gradeAggregateHeadDescription, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gradeAggregateHeadDescription.mainTitle;
        }
        if ((i & 2) != 0) {
            str2 = gradeAggregateHeadDescription.subTitle;
        }
        if ((i & 4) != 0) {
            z = gradeAggregateHeadDescription.mLocalIsLast;
        }
        return gradeAggregateHeadDescription.copy(str, str2, z);
    }

    public final String component1() {
        return this.mainTitle;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final boolean component3() {
        return this.mLocalIsLast;
    }

    public final GradeAggregateHeadDescription copy(String str, String str2, boolean z) {
        return new GradeAggregateHeadDescription(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateHeadDescription)) {
            return false;
        }
        GradeAggregateHeadDescription gradeAggregateHeadDescription = (GradeAggregateHeadDescription) obj;
        return Intrinsics.areEqual((Object) this.mainTitle, (Object) gradeAggregateHeadDescription.mainTitle) && Intrinsics.areEqual((Object) this.subTitle, (Object) gradeAggregateHeadDescription.subTitle) && this.mLocalIsLast == gradeAggregateHeadDescription.mLocalIsLast;
    }

    public List<BaseNode> getChildNode() {
        return null;
    }

    public int hashCode() {
        String str = this.mainTitle;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.mLocalIsLast;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "GradeAggregateHeadDescription(mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ", mLocalIsLast=" + this.mLocalIsLast + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GradeAggregateHeadDescription(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
    }

    public final String getMainTitle() {
        return this.mainTitle;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final boolean getMLocalIsLast() {
        return this.mLocalIsLast;
    }

    public final void setMLocalIsLast(boolean z) {
        this.mLocalIsLast = z;
    }

    public GradeAggregateHeadDescription(String str, String str2, boolean z) {
        this.mainTitle = str;
        this.subTitle = str2;
        this.mLocalIsLast = z;
    }
}
