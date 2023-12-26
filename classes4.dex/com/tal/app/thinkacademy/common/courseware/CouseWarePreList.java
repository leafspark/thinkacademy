package com.tal.app.thinkacademy.common.courseware;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J \u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R$\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList;", "Ljava/io/Serializable;", "list", "", "Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;", "([Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;)V", "getList", "()[Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;", "setList", "[Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;", "component1", "copy", "([Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;)Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList;", "equals", "", "other", "", "hashCode", "", "toString", "", "CourseInfoPreList", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouseWarePreList.kt */
public final class CouseWarePreList implements Serializable {
    private CourseInfoPreList[] list;

    public static /* synthetic */ CouseWarePreList copy$default(CouseWarePreList couseWarePreList, CourseInfoPreList[] courseInfoPreListArr, int i, Object obj) {
        if ((i & 1) != 0) {
            courseInfoPreListArr = couseWarePreList.list;
        }
        return couseWarePreList.copy(courseInfoPreListArr);
    }

    public final CourseInfoPreList[] component1() {
        return this.list;
    }

    public final CouseWarePreList copy(CourseInfoPreList[] courseInfoPreListArr) {
        return new CouseWarePreList(courseInfoPreListArr);
    }

    public String toString() {
        return "CouseWarePreList(list=" + Arrays.toString(this.list) + ')';
    }

    public CouseWarePreList(CourseInfoPreList[] courseInfoPreListArr) {
        this.list = courseInfoPreListArr;
    }

    public final CourseInfoPreList[] getList() {
        return this.list;
    }

    public final void setList(CourseInfoPreList[] courseInfoPreListArr) {
        this.list = courseInfoPreListArr;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;", "Ljava/io/Serializable;", "planId", "", "startTime", "", "endTime", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getPlanId", "()Ljava/lang/Integer;", "setPlanId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStartTime", "setStartTime", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;", "equals", "", "other", "", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CouseWarePreList.kt */
    public static final class CourseInfoPreList implements Serializable {
        private String endTime;
        private Integer planId;
        private String startTime;

        public static /* synthetic */ CourseInfoPreList copy$default(CourseInfoPreList courseInfoPreList, Integer num, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = courseInfoPreList.planId;
            }
            if ((i & 2) != 0) {
                str = courseInfoPreList.startTime;
            }
            if ((i & 4) != 0) {
                str2 = courseInfoPreList.endTime;
            }
            return courseInfoPreList.copy(num, str, str2);
        }

        public final Integer component1() {
            return this.planId;
        }

        public final String component2() {
            return this.startTime;
        }

        public final String component3() {
            return this.endTime;
        }

        public final CourseInfoPreList copy(Integer num, String str, String str2) {
            return new CourseInfoPreList(num, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CourseInfoPreList)) {
                return false;
            }
            CourseInfoPreList courseInfoPreList = (CourseInfoPreList) obj;
            return Intrinsics.areEqual(this.planId, courseInfoPreList.planId) && Intrinsics.areEqual(this.startTime, courseInfoPreList.startTime) && Intrinsics.areEqual(this.endTime, courseInfoPreList.endTime);
        }

        public int hashCode() {
            Integer num = this.planId;
            int i = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.startTime;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.endTime;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "CourseInfoPreList(planId=" + this.planId + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
        }

        public CourseInfoPreList(Integer num, String str, String str2) {
            this.planId = num;
            this.startTime = str;
            this.endTime = str2;
        }

        public final Integer getPlanId() {
            return this.planId;
        }

        public final void setPlanId(Integer num) {
            this.planId = num;
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final void setStartTime(String str) {
            this.startTime = str;
        }

        public final String getEndTime() {
            return this.endTime;
        }

        public final void setEndTime(String str) {
            this.endTime = str;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.tal.app.thinkacademy.common.courseware.CouseWarePreList");
        CouseWarePreList couseWarePreList = (CouseWarePreList) obj;
        CourseInfoPreList[] courseInfoPreListArr = this.list;
        if (courseInfoPreListArr != null) {
            Intrinsics.checkNotNull(courseInfoPreListArr);
            CourseInfoPreList[] courseInfoPreListArr2 = couseWarePreList.list;
            Intrinsics.checkNotNull(courseInfoPreListArr2);
            return Arrays.equals(courseInfoPreListArr, courseInfoPreListArr2);
        }
    }

    public int hashCode() {
        CourseInfoPreList[] courseInfoPreListArr = this.list;
        if (courseInfoPreListArr == null) {
            return -1;
        }
        Intrinsics.checkNotNull(courseInfoPreListArr);
        return Arrays.hashCode(courseInfoPreListArr);
    }
}
