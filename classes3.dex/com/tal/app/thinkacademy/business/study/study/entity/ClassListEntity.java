package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/ClassListEntity;", "", "classGroups", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassGroups;", "classList", "Lcom/tal/app/thinkacademy/business/study/study/entity/Record;", "(Ljava/util/List;Ljava/util/List;)V", "getClassGroups", "()Ljava/util/List;", "getClassList", "setClassList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassListEntity.kt */
public final class ClassListEntity {
    private final List<ClassGroups> classGroups;
    private List<Record> classList;

    public ClassListEntity() {
        this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ClassListEntity copy$default(ClassListEntity classListEntity, List<ClassGroups> list, List<Record> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = classListEntity.classGroups;
        }
        if ((i & 2) != 0) {
            list2 = classListEntity.classList;
        }
        return classListEntity.copy(list, list2);
    }

    public final List<ClassGroups> component1() {
        return this.classGroups;
    }

    public final List<Record> component2() {
        return this.classList;
    }

    public final ClassListEntity copy(List<ClassGroups> list, List<Record> list2) {
        Intrinsics.checkNotNullParameter(list2, "classList");
        return new ClassListEntity(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassListEntity)) {
            return false;
        }
        ClassListEntity classListEntity = (ClassListEntity) obj;
        return Intrinsics.areEqual((Object) this.classGroups, (Object) classListEntity.classGroups) && Intrinsics.areEqual((Object) this.classList, (Object) classListEntity.classList);
    }

    public int hashCode() {
        List<ClassGroups> list = this.classGroups;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.classList.hashCode();
    }

    public String toString() {
        return "ClassListEntity(classGroups=" + this.classGroups + ", classList=" + this.classList + ')';
    }

    public ClassListEntity(List<ClassGroups> list, List<Record> list2) {
        Intrinsics.checkNotNullParameter(list2, "classList");
        this.classGroups = list;
        this.classList = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassListEntity(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new ArrayList() : list2);
    }

    public final List<ClassGroups> getClassGroups() {
        return this.classGroups;
    }

    public final List<Record> getClassList() {
        return this.classList;
    }

    public final void setClassList(List<Record> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.classList = list;
    }
}
