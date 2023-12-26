package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JP\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType1;", "", "content", "", "courseList", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType1Course;", "showCount", "", "showMore", "", "title", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getCourseList", "()Ljava/util/List;", "getShowCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType1;", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeDataType1.kt */
public final class ShopHomeDataType1 {
    private final String content;
    private final List<ShopHomeDataType1Course> courseList;
    private final Integer showCount;
    private final Boolean showMore;
    private final String title;

    public ShopHomeDataType1() {
        this((String) null, (List) null, (Integer) null, (Boolean) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopHomeDataType1 copy$default(ShopHomeDataType1 shopHomeDataType1, String str, List<ShopHomeDataType1Course> list, Integer num, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopHomeDataType1.content;
        }
        if ((i & 2) != 0) {
            list = shopHomeDataType1.courseList;
        }
        List<ShopHomeDataType1Course> list2 = list;
        if ((i & 4) != 0) {
            num = shopHomeDataType1.showCount;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            bool = shopHomeDataType1.showMore;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            str2 = shopHomeDataType1.title;
        }
        return shopHomeDataType1.copy(str, list2, num2, bool2, str2);
    }

    public final String component1() {
        return this.content;
    }

    public final List<ShopHomeDataType1Course> component2() {
        return this.courseList;
    }

    public final Integer component3() {
        return this.showCount;
    }

    public final Boolean component4() {
        return this.showMore;
    }

    public final String component5() {
        return this.title;
    }

    public final ShopHomeDataType1 copy(String str, List<ShopHomeDataType1Course> list, Integer num, Boolean bool, String str2) {
        return new ShopHomeDataType1(str, list, num, bool, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeDataType1)) {
            return false;
        }
        ShopHomeDataType1 shopHomeDataType1 = (ShopHomeDataType1) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) shopHomeDataType1.content) && Intrinsics.areEqual((Object) this.courseList, (Object) shopHomeDataType1.courseList) && Intrinsics.areEqual((Object) this.showCount, (Object) shopHomeDataType1.showCount) && Intrinsics.areEqual((Object) this.showMore, (Object) shopHomeDataType1.showMore) && Intrinsics.areEqual((Object) this.title, (Object) shopHomeDataType1.title);
    }

    public int hashCode() {
        String str = this.content;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ShopHomeDataType1Course> list = this.courseList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.showCount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.showMore;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ShopHomeDataType1(content=" + this.content + ", courseList=" + this.courseList + ", showCount=" + this.showCount + ", showMore=" + this.showMore + ", title=" + this.title + ')';
    }

    public ShopHomeDataType1(String str, List<ShopHomeDataType1Course> list, Integer num, Boolean bool, String str2) {
        this.content = str;
        this.courseList = list;
        this.showCount = num;
        this.showMore = bool;
        this.title = str2;
    }

    public final String getContent() {
        return this.content;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopHomeDataType1(java.lang.String r5, java.util.List r6, java.lang.Integer r7, java.lang.Boolean r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0008
            r11 = r0
            goto L_0x0009
        L_0x0008:
            r11 = r5
        L_0x0009:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x0011
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0011:
            r1 = r6
            r5 = r10 & 4
            r6 = 0
            if (r5 == 0) goto L_0x001b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
        L_0x001b:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0024
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r6)
        L_0x0024:
            r3 = r8
            r5 = r10 & 16
            if (r5 == 0) goto L_0x002b
            r10 = r0
            goto L_0x002c
        L_0x002b:
            r10 = r9
        L_0x002c:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1.<init>(java.lang.String, java.util.List, java.lang.Integer, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<ShopHomeDataType1Course> getCourseList() {
        return this.courseList;
    }

    public final Integer getShowCount() {
        return this.showCount;
    }

    public final Boolean getShowMore() {
        return this.showMore;
    }

    public final String getTitle() {
        return this.title;
    }
}
