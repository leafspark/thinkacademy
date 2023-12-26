package com.tal.app.thinkacademy.business.study.study.entity.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ,\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/AllSchoolsRequest;", "", "categories", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/Category;", "excludeCurrentSchool", "", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getCategories", "()Ljava/util/List;", "setCategories", "(Ljava/util/List;)V", "getExcludeCurrentSchool", "()Ljava/lang/Boolean;", "setExcludeCurrentSchool", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/business/study/study/entity/request/AllSchoolsRequest;", "equals", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllSchoolsRequest.kt */
public final class AllSchoolsRequest {
    private List<Category> categories;
    private Boolean excludeCurrentSchool;

    public AllSchoolsRequest() {
        this((List) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AllSchoolsRequest copy$default(AllSchoolsRequest allSchoolsRequest, List<Category> list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            list = allSchoolsRequest.categories;
        }
        if ((i & 2) != 0) {
            bool = allSchoolsRequest.excludeCurrentSchool;
        }
        return allSchoolsRequest.copy(list, bool);
    }

    public final List<Category> component1() {
        return this.categories;
    }

    public final Boolean component2() {
        return this.excludeCurrentSchool;
    }

    public final AllSchoolsRequest copy(List<Category> list, Boolean bool) {
        return new AllSchoolsRequest(list, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AllSchoolsRequest)) {
            return false;
        }
        AllSchoolsRequest allSchoolsRequest = (AllSchoolsRequest) obj;
        return Intrinsics.areEqual((Object) this.categories, (Object) allSchoolsRequest.categories) && Intrinsics.areEqual((Object) this.excludeCurrentSchool, (Object) allSchoolsRequest.excludeCurrentSchool);
    }

    public int hashCode() {
        List<Category> list = this.categories;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Boolean bool = this.excludeCurrentSchool;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AllSchoolsRequest(categories=" + this.categories + ", excludeCurrentSchool=" + this.excludeCurrentSchool + ')';
    }

    public AllSchoolsRequest(List<Category> list, Boolean bool) {
        this.categories = list;
        this.excludeCurrentSchool = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AllSchoolsRequest(java.util.List r5, java.lang.Boolean r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r4 = this;
            r8 = r7 & 1
            r0 = 1
            if (r8 == 0) goto L_0x0017
            com.tal.app.thinkacademy.business.study.study.entity.request.Category[] r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.Category[r0]
            r8 = 0
            com.tal.app.thinkacademy.business.study.study.entity.request.Category r1 = new com.tal.app.thinkacademy.business.study.study.entity.request.Category
            r2 = 3
            r3 = 0
            r1.<init>(r3, r3, r2, r3)
            r5[r8] = r1
            java.util.ArrayList r5 = kotlin.collections.CollectionsKt.arrayListOf(r5)
            java.util.List r5 = (java.util.List) r5
        L_0x0017:
            r7 = r7 & 2
            if (r7 == 0) goto L_0x001f
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
        L_0x001f:
            r4.<init>(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.request.AllSchoolsRequest.<init>(java.util.List, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<Category> getCategories() {
        return this.categories;
    }

    public final void setCategories(List<Category> list) {
        this.categories = list;
    }

    public final Boolean getExcludeCurrentSchool() {
        return this.excludeCurrentSchool;
    }

    public final void setExcludeCurrentSchool(Boolean bool) {
        this.excludeCurrentSchool = bool;
    }
}
