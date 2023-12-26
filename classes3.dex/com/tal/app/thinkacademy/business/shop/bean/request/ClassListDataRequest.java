package com.tal.app.thinkacademy.business.shop.bean.request;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0003JV\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00062\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/ClassListDataRequest;", "", "moduleType", "", "courseIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "specValues", "(Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getCourseIdList", "()Ljava/util/ArrayList;", "setCourseIdList", "(Ljava/util/ArrayList;)V", "getModuleType", "()Ljava/lang/Integer;", "setModuleType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSpecValues", "setSpecValues", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;)Lcom/tal/app/thinkacademy/business/shop/bean/request/ClassListDataRequest;", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassListDataRequest.kt */
public final class ClassListDataRequest {
    private ArrayList<Integer> courseIdList;
    private Integer moduleType;
    private ArrayList<Integer> specValues;

    public ClassListDataRequest() {
        this((Integer) null, (ArrayList) null, (ArrayList) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ClassListDataRequest copy$default(ClassListDataRequest classListDataRequest, Integer num, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = classListDataRequest.moduleType;
        }
        if ((i & 2) != 0) {
            arrayList = classListDataRequest.courseIdList;
        }
        if ((i & 4) != 0) {
            arrayList2 = classListDataRequest.specValues;
        }
        return classListDataRequest.copy(num, arrayList, arrayList2);
    }

    public final Integer component1() {
        return this.moduleType;
    }

    public final ArrayList<Integer> component2() {
        return this.courseIdList;
    }

    public final ArrayList<Integer> component3() {
        return this.specValues;
    }

    public final ClassListDataRequest copy(Integer num, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        return new ClassListDataRequest(num, arrayList, arrayList2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassListDataRequest)) {
            return false;
        }
        ClassListDataRequest classListDataRequest = (ClassListDataRequest) obj;
        return Intrinsics.areEqual((Object) this.moduleType, (Object) classListDataRequest.moduleType) && Intrinsics.areEqual((Object) this.courseIdList, (Object) classListDataRequest.courseIdList) && Intrinsics.areEqual((Object) this.specValues, (Object) classListDataRequest.specValues);
    }

    public int hashCode() {
        Integer num = this.moduleType;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        ArrayList<Integer> arrayList = this.courseIdList;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<Integer> arrayList2 = this.specValues;
        if (arrayList2 != null) {
            i = arrayList2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ClassListDataRequest(moduleType=" + this.moduleType + ", courseIdList=" + this.courseIdList + ", specValues=" + this.specValues + ')';
    }

    public ClassListDataRequest(Integer num, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        this.moduleType = num;
        this.courseIdList = arrayList;
        this.specValues = arrayList2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassListDataRequest(Integer num, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 11 : num, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? new ArrayList() : arrayList2);
    }

    public final Integer getModuleType() {
        return this.moduleType;
    }

    public final void setModuleType(Integer num) {
        this.moduleType = num;
    }

    public final ArrayList<Integer> getCourseIdList() {
        return this.courseIdList;
    }

    public final void setCourseIdList(ArrayList<Integer> arrayList) {
        this.courseIdList = arrayList;
    }

    public final ArrayList<Integer> getSpecValues() {
        return this.specValues;
    }

    public final void setSpecValues(ArrayList<Integer> arrayList) {
        this.specValues = arrayList;
    }
}
