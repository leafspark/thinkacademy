package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHtml;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "description", "", "title", "mLocalComponentType", "mLocalComponentID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "childNode", "", "getChildNode", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getMLocalComponentID", "setMLocalComponentID", "(Ljava/lang/String;)V", "getMLocalComponentType", "setMLocalComponentType", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateDetailInfo.kt */
public final class GradeAggregateHtml extends BaseNode {
    private final String description;
    private String mLocalComponentID;
    private String mLocalComponentType;
    private final String title;

    public GradeAggregateHtml() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GradeAggregateHtml copy$default(GradeAggregateHtml gradeAggregateHtml, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gradeAggregateHtml.description;
        }
        if ((i & 2) != 0) {
            str2 = gradeAggregateHtml.title;
        }
        if ((i & 4) != 0) {
            str3 = gradeAggregateHtml.mLocalComponentType;
        }
        if ((i & 8) != 0) {
            str4 = gradeAggregateHtml.mLocalComponentID;
        }
        return gradeAggregateHtml.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.description;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.mLocalComponentType;
    }

    public final String component4() {
        return this.mLocalComponentID;
    }

    public final GradeAggregateHtml copy(String str, String str2, String str3, String str4) {
        return new GradeAggregateHtml(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateHtml)) {
            return false;
        }
        GradeAggregateHtml gradeAggregateHtml = (GradeAggregateHtml) obj;
        return Intrinsics.areEqual((Object) this.description, (Object) gradeAggregateHtml.description) && Intrinsics.areEqual((Object) this.title, (Object) gradeAggregateHtml.title) && Intrinsics.areEqual((Object) this.mLocalComponentType, (Object) gradeAggregateHtml.mLocalComponentType) && Intrinsics.areEqual((Object) this.mLocalComponentID, (Object) gradeAggregateHtml.mLocalComponentID);
    }

    public List<BaseNode> getChildNode() {
        return null;
    }

    public int hashCode() {
        String str = this.description;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mLocalComponentType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mLocalComponentID;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GradeAggregateHtml(description=" + this.description + ", title=" + this.title + ", mLocalComponentType=" + this.mLocalComponentType + ", mLocalComponentID=" + this.mLocalComponentID + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GradeAggregateHtml(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMLocalComponentType() {
        return this.mLocalComponentType;
    }

    public final void setMLocalComponentType(String str) {
        this.mLocalComponentType = str;
    }

    public final String getMLocalComponentID() {
        return this.mLocalComponentID;
    }

    public final void setMLocalComponentID(String str) {
        this.mLocalComponentID = str;
    }

    public GradeAggregateHtml(String str, String str2, String str3, String str4) {
        this.description = str;
        this.title = str2;
        this.mLocalComponentType = str3;
        this.mLocalComponentID = str4;
    }
}
