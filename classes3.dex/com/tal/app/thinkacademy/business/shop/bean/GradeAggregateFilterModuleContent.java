package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateFilterModuleContent;", "", "content", "", "id", "", "shortName", "type", "(Ljava/lang/String;ILjava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getId", "()I", "getShortName", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateDetailInfo.kt */
public final class GradeAggregateFilterModuleContent {
    private final String content;
    private final int id;
    private final String shortName;
    private final int type;

    public GradeAggregateFilterModuleContent() {
        this((String) null, 0, (String) null, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GradeAggregateFilterModuleContent copy$default(GradeAggregateFilterModuleContent gradeAggregateFilterModuleContent, String str, int i, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = gradeAggregateFilterModuleContent.content;
        }
        if ((i3 & 2) != 0) {
            i = gradeAggregateFilterModuleContent.id;
        }
        if ((i3 & 4) != 0) {
            str2 = gradeAggregateFilterModuleContent.shortName;
        }
        if ((i3 & 8) != 0) {
            i2 = gradeAggregateFilterModuleContent.type;
        }
        return gradeAggregateFilterModuleContent.copy(str, i, str2, i2);
    }

    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.id;
    }

    public final String component3() {
        return this.shortName;
    }

    public final int component4() {
        return this.type;
    }

    public final GradeAggregateFilterModuleContent copy(String str, int i, String str2, int i2) {
        return new GradeAggregateFilterModuleContent(str, i, str2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateFilterModuleContent)) {
            return false;
        }
        GradeAggregateFilterModuleContent gradeAggregateFilterModuleContent = (GradeAggregateFilterModuleContent) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) gradeAggregateFilterModuleContent.content) && this.id == gradeAggregateFilterModuleContent.id && Intrinsics.areEqual((Object) this.shortName, (Object) gradeAggregateFilterModuleContent.shortName) && this.type == gradeAggregateFilterModuleContent.type;
    }

    public int hashCode() {
        String str = this.content;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.id) * 31;
        String str2 = this.shortName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.type;
    }

    public String toString() {
        return "GradeAggregateFilterModuleContent(content=" + this.content + ", id=" + this.id + ", shortName=" + this.shortName + ", type=" + this.type + ')';
    }

    public GradeAggregateFilterModuleContent(String str, int i, String str2, int i2) {
        this.content = str;
        this.id = i;
        this.shortName = str2;
        this.type = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GradeAggregateFilterModuleContent(String str, int i, String str2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? 0 : i2);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getId() {
        return this.id;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public final int getType() {
        return this.type;
    }
}
