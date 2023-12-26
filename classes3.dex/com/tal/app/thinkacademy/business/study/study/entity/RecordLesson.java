package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b+\b\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0015Jf\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\b\u001a\u00020\u0007J\t\u00108\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00069"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordLesson;", "", "lessonId", "", "homework", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordHomework;", "lessonName", "", "orderNum", "resourceList", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordResource;", "displayStatus", "expand", "", "(ILcom/tal/app/thinkacademy/business/study/study/entity/RecordHomework;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "getDisplayStatus", "()Ljava/lang/String;", "setDisplayStatus", "(Ljava/lang/String;)V", "getExpand", "()Ljava/lang/Boolean;", "setExpand", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHomework", "()Lcom/tal/app/thinkacademy/business/study/study/entity/RecordHomework;", "setHomework", "(Lcom/tal/app/thinkacademy/business/study/study/entity/RecordHomework;)V", "getLessonId", "()I", "setLessonId", "(I)V", "getLessonName", "setLessonName", "getOrderNum", "()Ljava/lang/Integer;", "setOrderNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getResourceList", "()Ljava/util/List;", "setResourceList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILcom/tal/app/thinkacademy/business/study/study/entity/RecordHomework;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/business/study/study/entity/RecordLesson;", "equals", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarListEntity.kt */
public final class RecordLesson {
    private String displayStatus;
    private Boolean expand;
    private RecordHomework homework;
    private int lessonId;
    private String lessonName;
    private Integer orderNum;
    private List<RecordResource> resourceList;

    public static /* synthetic */ RecordLesson copy$default(RecordLesson recordLesson, int i, RecordHomework recordHomework, String str, Integer num, List<RecordResource> list, String str2, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = recordLesson.lessonId;
        }
        if ((i2 & 2) != 0) {
            recordHomework = recordLesson.homework;
        }
        RecordHomework recordHomework2 = recordHomework;
        if ((i2 & 4) != 0) {
            str = recordLesson.lessonName;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            num = recordLesson.orderNum;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            list = recordLesson.resourceList;
        }
        List<RecordResource> list2 = list;
        if ((i2 & 32) != 0) {
            str2 = recordLesson.displayStatus;
        }
        String str4 = str2;
        if ((i2 & 64) != 0) {
            bool = recordLesson.expand;
        }
        return recordLesson.copy(i, recordHomework2, str3, num2, list2, str4, bool);
    }

    public final int component1() {
        return this.lessonId;
    }

    public final RecordHomework component2() {
        return this.homework;
    }

    public final String component3() {
        return this.lessonName;
    }

    public final Integer component4() {
        return this.orderNum;
    }

    public final List<RecordResource> component5() {
        return this.resourceList;
    }

    public final String component6() {
        return this.displayStatus;
    }

    public final Boolean component7() {
        return this.expand;
    }

    public final RecordLesson copy(int i, RecordHomework recordHomework, String str, Integer num, List<RecordResource> list, String str2, Boolean bool) {
        return new RecordLesson(i, recordHomework, str, num, list, str2, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordLesson)) {
            return false;
        }
        RecordLesson recordLesson = (RecordLesson) obj;
        return this.lessonId == recordLesson.lessonId && Intrinsics.areEqual((Object) this.homework, (Object) recordLesson.homework) && Intrinsics.areEqual((Object) this.lessonName, (Object) recordLesson.lessonName) && Intrinsics.areEqual((Object) this.orderNum, (Object) recordLesson.orderNum) && Intrinsics.areEqual((Object) this.resourceList, (Object) recordLesson.resourceList) && Intrinsics.areEqual((Object) this.displayStatus, (Object) recordLesson.displayStatus) && Intrinsics.areEqual((Object) this.expand, (Object) recordLesson.expand);
    }

    public int hashCode() {
        int i = this.lessonId * 31;
        RecordHomework recordHomework = this.homework;
        int i2 = 0;
        int hashCode = (i + (recordHomework == null ? 0 : recordHomework.hashCode())) * 31;
        String str = this.lessonName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.orderNum;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<RecordResource> list = this.resourceList;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.displayStatus;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.expand;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "RecordLesson(lessonId=" + this.lessonId + ", homework=" + this.homework + ", lessonName=" + this.lessonName + ", orderNum=" + this.orderNum + ", resourceList=" + this.resourceList + ", displayStatus=" + this.displayStatus + ", expand=" + this.expand + ')';
    }

    public RecordLesson(int i, RecordHomework recordHomework, String str, Integer num, List<RecordResource> list, String str2, Boolean bool) {
        this.lessonId = i;
        this.homework = recordHomework;
        this.lessonName = str;
        this.orderNum = num;
        this.resourceList = list;
        this.displayStatus = str2;
        this.expand = bool;
    }

    public final int getLessonId() {
        return this.lessonId;
    }

    public final void setLessonId(int i) {
        this.lessonId = i;
    }

    public final RecordHomework getHomework() {
        return this.homework;
    }

    public final void setHomework(RecordHomework recordHomework) {
        this.homework = recordHomework;
    }

    public final String getLessonName() {
        return this.lessonName;
    }

    public final void setLessonName(String str) {
        this.lessonName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordLesson(int i, RecordHomework recordHomework, String str, Integer num, List list, String str2, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, recordHomework, str, (i2 & 8) != 0 ? 1 : num, list, str2, (i2 & 64) != 0 ? false : bool);
    }

    public final Integer getOrderNum() {
        return this.orderNum;
    }

    public final void setOrderNum(Integer num) {
        this.orderNum = num;
    }

    public final List<RecordResource> getResourceList() {
        return this.resourceList;
    }

    public final void setResourceList(List<RecordResource> list) {
        this.resourceList = list;
    }

    public final String getDisplayStatus() {
        return this.displayStatus;
    }

    public final void setDisplayStatus(String str) {
        this.displayStatus = str;
    }

    public final Boolean getExpand() {
        return this.expand;
    }

    public final void setExpand(Boolean bool) {
        this.expand = bool;
    }

    public final String orderNum() {
        Integer num = this.orderNum;
        return (num == null ? 1 : num.intValue()) < 10 ? Intrinsics.stringPlus("0", this.orderNum) : String.valueOf(this.orderNum);
    }
}
