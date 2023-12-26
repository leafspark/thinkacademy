package com.tal.app.thinkacademy.business.home.main.shop.bean;

import com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopRecordedClassData;", "", "title", "", "content", "recordedCourseList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRecordedItemData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getRecordedCourseList", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopRecordedClassData.kt */
public final class ShopRecordedClassData {
    private final String content;
    private final List<ShopRecordedItemData> recordedCourseList;
    private final String title;

    public ShopRecordedClassData() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopRecordedClassData copy$default(ShopRecordedClassData shopRecordedClassData, String str, String str2, List<ShopRecordedItemData> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopRecordedClassData.title;
        }
        if ((i & 2) != 0) {
            str2 = shopRecordedClassData.content;
        }
        if ((i & 4) != 0) {
            list = shopRecordedClassData.recordedCourseList;
        }
        return shopRecordedClassData.copy(str, str2, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final List<ShopRecordedItemData> component3() {
        return this.recordedCourseList;
    }

    public final ShopRecordedClassData copy(String str, String str2, List<ShopRecordedItemData> list) {
        return new ShopRecordedClassData(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopRecordedClassData)) {
            return false;
        }
        ShopRecordedClassData shopRecordedClassData = (ShopRecordedClassData) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) shopRecordedClassData.title) && Intrinsics.areEqual((Object) this.content, (Object) shopRecordedClassData.content) && Intrinsics.areEqual((Object) this.recordedCourseList, (Object) shopRecordedClassData.recordedCourseList);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ShopRecordedItemData> list = this.recordedCourseList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ShopRecordedClassData(title=" + this.title + ", content=" + this.content + ", recordedCourseList=" + this.recordedCourseList + ')';
    }

    public ShopRecordedClassData(String str, String str2, List<ShopRecordedItemData> list) {
        this.title = str;
        this.content = str2;
        this.recordedCourseList = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopRecordedClassData(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<ShopRecordedItemData> getRecordedCourseList() {
        return this.recordedCourseList;
    }
}
