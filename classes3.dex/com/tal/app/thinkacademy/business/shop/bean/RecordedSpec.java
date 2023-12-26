package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/RecordedSpec;", "", "subject", "", "lessonCount", "", "teacherList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/RecordedTeacherItem;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getLessonCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubject", "()Ljava/lang/String;", "getTeacherList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/shop/bean/RecordedSpec;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopRecordedItemData.kt */
public final class RecordedSpec {
    private final Integer lessonCount;
    private final String subject;
    private final List<RecordedTeacherItem> teacherList;

    public RecordedSpec() {
        this((String) null, (Integer) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordedSpec copy$default(RecordedSpec recordedSpec, String str, Integer num, List<RecordedTeacherItem> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordedSpec.subject;
        }
        if ((i & 2) != 0) {
            num = recordedSpec.lessonCount;
        }
        if ((i & 4) != 0) {
            list = recordedSpec.teacherList;
        }
        return recordedSpec.copy(str, num, list);
    }

    public final String component1() {
        return this.subject;
    }

    public final Integer component2() {
        return this.lessonCount;
    }

    public final List<RecordedTeacherItem> component3() {
        return this.teacherList;
    }

    public final RecordedSpec copy(String str, Integer num, List<RecordedTeacherItem> list) {
        return new RecordedSpec(str, num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedSpec)) {
            return false;
        }
        RecordedSpec recordedSpec = (RecordedSpec) obj;
        return Intrinsics.areEqual((Object) this.subject, (Object) recordedSpec.subject) && Intrinsics.areEqual((Object) this.lessonCount, (Object) recordedSpec.lessonCount) && Intrinsics.areEqual((Object) this.teacherList, (Object) recordedSpec.teacherList);
    }

    public int hashCode() {
        String str = this.subject;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.lessonCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<RecordedTeacherItem> list = this.teacherList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RecordedSpec(subject=" + this.subject + ", lessonCount=" + this.lessonCount + ", teacherList=" + this.teacherList + ')';
    }

    public RecordedSpec(String str, Integer num, List<RecordedTeacherItem> list) {
        this.subject = str;
        this.lessonCount = num;
        this.teacherList = list;
    }

    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordedSpec(String str, Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Integer getLessonCount() {
        return this.lessonCount;
    }

    public final List<RecordedTeacherItem> getTeacherList() {
        return this.teacherList;
    }
}
