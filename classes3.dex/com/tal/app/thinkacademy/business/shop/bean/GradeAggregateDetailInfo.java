package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u0018Jz\u0010-\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u001eR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u00064"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateDetailInfo;", "", "mLocalNodeList", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "content", "", "filters", "", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateFilter;", "moduleContents", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateFilterModuleContent;", "mLocalContent", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHead;", "mLocalClassList", "Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateTitleNode;", "havaClassItem", "", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHead;Ljava/util/List;Ljava/lang/Boolean;)V", "getContent", "()Ljava/lang/String;", "getFilters", "()Ljava/util/List;", "getHavaClassItem", "()Ljava/lang/Boolean;", "setHavaClassItem", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMLocalClassList", "setMLocalClassList", "(Ljava/util/List;)V", "getMLocalContent", "()Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHead;", "setMLocalContent", "(Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHead;)V", "getMLocalNodeList", "setMLocalNodeList", "getModuleContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHead;Ljava/util/List;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateDetailInfo;", "equals", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateDetailInfo.kt */
public final class GradeAggregateDetailInfo {
    private final String content;
    private final List<GradeAggregateFilter> filters;
    private Boolean havaClassItem;
    private List<GradeAggregateTitleNode> mLocalClassList;
    private GradeAggregateHead mLocalContent;
    private List<BaseNode> mLocalNodeList;
    private final List<GradeAggregateFilterModuleContent> moduleContents;

    public GradeAggregateDetailInfo() {
        this((List) null, (String) null, (List) null, (List) null, (GradeAggregateHead) null, (List) null, (Boolean) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GradeAggregateDetailInfo copy$default(GradeAggregateDetailInfo gradeAggregateDetailInfo, List<BaseNode> list, String str, List<GradeAggregateFilter> list2, List<GradeAggregateFilterModuleContent> list3, GradeAggregateHead gradeAggregateHead, List<GradeAggregateTitleNode> list4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gradeAggregateDetailInfo.mLocalNodeList;
        }
        if ((i & 2) != 0) {
            str = gradeAggregateDetailInfo.content;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list2 = gradeAggregateDetailInfo.filters;
        }
        List<GradeAggregateFilter> list5 = list2;
        if ((i & 8) != 0) {
            list3 = gradeAggregateDetailInfo.moduleContents;
        }
        List<GradeAggregateFilterModuleContent> list6 = list3;
        if ((i & 16) != 0) {
            gradeAggregateHead = gradeAggregateDetailInfo.mLocalContent;
        }
        GradeAggregateHead gradeAggregateHead2 = gradeAggregateHead;
        if ((i & 32) != 0) {
            list4 = gradeAggregateDetailInfo.mLocalClassList;
        }
        List<GradeAggregateTitleNode> list7 = list4;
        if ((i & 64) != 0) {
            bool = gradeAggregateDetailInfo.havaClassItem;
        }
        return gradeAggregateDetailInfo.copy(list, str2, list5, list6, gradeAggregateHead2, list7, bool);
    }

    public final List<BaseNode> component1() {
        return this.mLocalNodeList;
    }

    public final String component2() {
        return this.content;
    }

    public final List<GradeAggregateFilter> component3() {
        return this.filters;
    }

    public final List<GradeAggregateFilterModuleContent> component4() {
        return this.moduleContents;
    }

    public final GradeAggregateHead component5() {
        return this.mLocalContent;
    }

    public final List<GradeAggregateTitleNode> component6() {
        return this.mLocalClassList;
    }

    public final Boolean component7() {
        return this.havaClassItem;
    }

    public final GradeAggregateDetailInfo copy(List<BaseNode> list, String str, List<GradeAggregateFilter> list2, List<GradeAggregateFilterModuleContent> list3, GradeAggregateHead gradeAggregateHead, List<GradeAggregateTitleNode> list4, Boolean bool) {
        return new GradeAggregateDetailInfo(list, str, list2, list3, gradeAggregateHead, list4, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateDetailInfo)) {
            return false;
        }
        GradeAggregateDetailInfo gradeAggregateDetailInfo = (GradeAggregateDetailInfo) obj;
        return Intrinsics.areEqual((Object) this.mLocalNodeList, (Object) gradeAggregateDetailInfo.mLocalNodeList) && Intrinsics.areEqual((Object) this.content, (Object) gradeAggregateDetailInfo.content) && Intrinsics.areEqual((Object) this.filters, (Object) gradeAggregateDetailInfo.filters) && Intrinsics.areEqual((Object) this.moduleContents, (Object) gradeAggregateDetailInfo.moduleContents) && Intrinsics.areEqual((Object) this.mLocalContent, (Object) gradeAggregateDetailInfo.mLocalContent) && Intrinsics.areEqual((Object) this.mLocalClassList, (Object) gradeAggregateDetailInfo.mLocalClassList) && Intrinsics.areEqual((Object) this.havaClassItem, (Object) gradeAggregateDetailInfo.havaClassItem);
    }

    public int hashCode() {
        List<BaseNode> list = this.mLocalNodeList;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.content;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<GradeAggregateFilter> list2 = this.filters;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<GradeAggregateFilterModuleContent> list3 = this.moduleContents;
        int hashCode4 = (hashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
        GradeAggregateHead gradeAggregateHead = this.mLocalContent;
        int hashCode5 = (hashCode4 + (gradeAggregateHead == null ? 0 : gradeAggregateHead.hashCode())) * 31;
        List<GradeAggregateTitleNode> list4 = this.mLocalClassList;
        int hashCode6 = (hashCode5 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Boolean bool = this.havaClassItem;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "GradeAggregateDetailInfo(mLocalNodeList=" + this.mLocalNodeList + ", content=" + this.content + ", filters=" + this.filters + ", moduleContents=" + this.moduleContents + ", mLocalContent=" + this.mLocalContent + ", mLocalClassList=" + this.mLocalClassList + ", havaClassItem=" + this.havaClassItem + ')';
    }

    public GradeAggregateDetailInfo(List<BaseNode> list, String str, List<GradeAggregateFilter> list2, List<GradeAggregateFilterModuleContent> list3, GradeAggregateHead gradeAggregateHead, List<GradeAggregateTitleNode> list4, Boolean bool) {
        this.mLocalNodeList = list;
        this.content = str;
        this.filters = list2;
        this.moduleContents = list3;
        this.mLocalContent = gradeAggregateHead;
        this.mLocalClassList = list4;
        this.havaClassItem = bool;
    }

    public final List<BaseNode> getMLocalNodeList() {
        return this.mLocalNodeList;
    }

    public final void setMLocalNodeList(List<BaseNode> list) {
        this.mLocalNodeList = list;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<GradeAggregateFilter> getFilters() {
        return this.filters;
    }

    public final List<GradeAggregateFilterModuleContent> getModuleContents() {
        return this.moduleContents;
    }

    public final GradeAggregateHead getMLocalContent() {
        return this.mLocalContent;
    }

    public final void setMLocalContent(GradeAggregateHead gradeAggregateHead) {
        this.mLocalContent = gradeAggregateHead;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GradeAggregateDetailInfo(java.util.List r6, java.lang.String r7, java.util.List r8, java.util.List r9, com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead r10, java.util.List r11, java.lang.Boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0007
            r14 = r0
            goto L_0x0008
        L_0x0007:
            r14 = r6
        L_0x0008:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r13 & 16
            if (r6 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r0 = r10
        L_0x0023:
            r6 = r13 & 32
            if (r6 == 0) goto L_0x002f
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r11 = r6
            java.util.List r11 = (java.util.List) r11
        L_0x002f:
            r4 = r11
            r6 = r13 & 64
            if (r6 == 0) goto L_0x0039
            r6 = 0
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)
        L_0x0039:
            r13 = r12
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r0
            r12 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo.<init>(java.util.List, java.lang.String, java.util.List, java.util.List, com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead, java.util.List, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<GradeAggregateTitleNode> getMLocalClassList() {
        return this.mLocalClassList;
    }

    public final void setMLocalClassList(List<GradeAggregateTitleNode> list) {
        this.mLocalClassList = list;
    }

    public final Boolean getHavaClassItem() {
        return this.havaClassItem;
    }

    public final void setHavaClassItem(Boolean bool) {
        this.havaClassItem = bool;
    }
}
