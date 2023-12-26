package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003JU\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHead;", "", "description", "", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHeadDescription;", "detailTitle", "", "img", "pageTitle", "selected", "", "video", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getDescription", "()Ljava/util/List;", "getDetailTitle", "()Ljava/lang/String;", "getImg", "getPageTitle", "getSelected", "()Z", "getVideo", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateDetailInfo.kt */
public final class GradeAggregateHead {
    private final List<GradeAggregateHeadDescription> description;
    private final String detailTitle;
    private final String img;
    private final String pageTitle;
    private final boolean selected;
    private final String video;

    public GradeAggregateHead() {
        this((List) null, (String) null, (String) null, (String) null, false, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GradeAggregateHead copy$default(GradeAggregateHead gradeAggregateHead, List<GradeAggregateHeadDescription> list, String str, String str2, String str3, boolean z, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gradeAggregateHead.description;
        }
        if ((i & 2) != 0) {
            str = gradeAggregateHead.detailTitle;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = gradeAggregateHead.img;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = gradeAggregateHead.pageTitle;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            z = gradeAggregateHead.selected;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str4 = gradeAggregateHead.video;
        }
        return gradeAggregateHead.copy(list, str5, str6, str7, z2, str4);
    }

    public final List<GradeAggregateHeadDescription> component1() {
        return this.description;
    }

    public final String component2() {
        return this.detailTitle;
    }

    public final String component3() {
        return this.img;
    }

    public final String component4() {
        return this.pageTitle;
    }

    public final boolean component5() {
        return this.selected;
    }

    public final String component6() {
        return this.video;
    }

    public final GradeAggregateHead copy(List<GradeAggregateHeadDescription> list, String str, String str2, String str3, boolean z, String str4) {
        return new GradeAggregateHead(list, str, str2, str3, z, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateHead)) {
            return false;
        }
        GradeAggregateHead gradeAggregateHead = (GradeAggregateHead) obj;
        return Intrinsics.areEqual((Object) this.description, (Object) gradeAggregateHead.description) && Intrinsics.areEqual((Object) this.detailTitle, (Object) gradeAggregateHead.detailTitle) && Intrinsics.areEqual((Object) this.img, (Object) gradeAggregateHead.img) && Intrinsics.areEqual((Object) this.pageTitle, (Object) gradeAggregateHead.pageTitle) && this.selected == gradeAggregateHead.selected && Intrinsics.areEqual((Object) this.video, (Object) gradeAggregateHead.video);
    }

    public int hashCode() {
        List<GradeAggregateHeadDescription> list = this.description;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.detailTitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.img;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.pageTitle;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z = this.selected;
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        String str4 = this.video;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "GradeAggregateHead(description=" + this.description + ", detailTitle=" + this.detailTitle + ", img=" + this.img + ", pageTitle=" + this.pageTitle + ", selected=" + this.selected + ", video=" + this.video + ')';
    }

    public GradeAggregateHead(List<GradeAggregateHeadDescription> list, String str, String str2, String str3, boolean z, String str4) {
        this.description = list;
        this.detailTitle = str;
        this.img = str2;
        this.pageTitle = str3;
        this.selected = z;
        this.video = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GradeAggregateHead(java.util.List r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0022
            r10 = 0
        L_0x0022:
            r4 = r10
            r6 = r12 & 32
            if (r6 == 0) goto L_0x0029
            r12 = r0
            goto L_0x002a
        L_0x0029:
            r12 = r11
        L_0x002a:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead.<init>(java.util.List, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<GradeAggregateHeadDescription> getDescription() {
        return this.description;
    }

    public final String getDetailTitle() {
        return this.detailTitle;
    }

    public final String getImg() {
        return this.img;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final String getVideo() {
        return this.video;
    }
}
