package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/TreeLesson;", "", "date", "", "list", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/business/study/study/entity/Lesson;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getDate", "()Ljava/lang/String;", "getList", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyPlanListEntity.kt */
public final class TreeLesson {
    private final String date;
    private final ArrayList<Lesson> list;

    public static /* synthetic */ TreeLesson copy$default(TreeLesson treeLesson, String str, ArrayList<Lesson> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = treeLesson.date;
        }
        if ((i & 2) != 0) {
            arrayList = treeLesson.list;
        }
        return treeLesson.copy(str, arrayList);
    }

    public final String component1() {
        return this.date;
    }

    public final ArrayList<Lesson> component2() {
        return this.list;
    }

    public final TreeLesson copy(String str, ArrayList<Lesson> arrayList) {
        return new TreeLesson(str, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TreeLesson)) {
            return false;
        }
        TreeLesson treeLesson = (TreeLesson) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) treeLesson.date) && Intrinsics.areEqual((Object) this.list, (Object) treeLesson.list);
    }

    public int hashCode() {
        String str = this.date;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ArrayList<Lesson> arrayList = this.list;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "TreeLesson(date=" + this.date + ", list=" + this.list + ')';
    }

    public TreeLesson(String str, ArrayList<Lesson> arrayList) {
        this.date = str;
        this.list = arrayList;
    }

    public final String getDate() {
        return this.date;
    }

    public final ArrayList<Lesson> getList() {
        return this.list;
    }
}
