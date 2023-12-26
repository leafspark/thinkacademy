package com.tal.app.thinkacademy.business.study.study.entity;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J~\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006<"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarCourse;", "", "sessionId", "", "expirationTime", "", "expired", "", "id", "skuId", "name", "permanent", "subjectTag", "teachers", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "(JLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "getExpirationTime", "()Ljava/lang/String;", "setExpirationTime", "(Ljava/lang/String;)V", "getExpired", "()Ljava/lang/Boolean;", "setExpired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getId", "setId", "getName", "setName", "getPermanent", "setPermanent", "getSessionId", "()J", "setSessionId", "(J)V", "getSkuId", "setSkuId", "getSubjectTag", "setSubjectTag", "getTeachers", "()Ljava/util/List;", "setTeachers", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarCourse;", "equals", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarListEntity.kt */
public final class RecordedCalendarCourse {
    private String expirationTime;
    private Boolean expired;
    private String id;
    private String name;
    private Boolean permanent;
    private long sessionId;
    private String skuId;
    private String subjectTag;
    private List<Teacher> teachers;

    public static /* synthetic */ RecordedCalendarCourse copy$default(RecordedCalendarCourse recordedCalendarCourse, long j, String str, Boolean bool, String str2, String str3, String str4, Boolean bool2, String str5, List list, int i, Object obj) {
        RecordedCalendarCourse recordedCalendarCourse2 = recordedCalendarCourse;
        int i2 = i;
        return recordedCalendarCourse.copy((i2 & 1) != 0 ? recordedCalendarCourse2.sessionId : j, (i2 & 2) != 0 ? recordedCalendarCourse2.expirationTime : str, (i2 & 4) != 0 ? recordedCalendarCourse2.expired : bool, (i2 & 8) != 0 ? recordedCalendarCourse2.id : str2, (i2 & 16) != 0 ? recordedCalendarCourse2.skuId : str3, (i2 & 32) != 0 ? recordedCalendarCourse2.name : str4, (i2 & 64) != 0 ? recordedCalendarCourse2.permanent : bool2, (i2 & 128) != 0 ? recordedCalendarCourse2.subjectTag : str5, (i2 & 256) != 0 ? recordedCalendarCourse2.teachers : list);
    }

    public final long component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.expirationTime;
    }

    public final Boolean component3() {
        return this.expired;
    }

    public final String component4() {
        return this.id;
    }

    public final String component5() {
        return this.skuId;
    }

    public final String component6() {
        return this.name;
    }

    public final Boolean component7() {
        return this.permanent;
    }

    public final String component8() {
        return this.subjectTag;
    }

    public final List<Teacher> component9() {
        return this.teachers;
    }

    public final RecordedCalendarCourse copy(long j, String str, Boolean bool, String str2, String str3, String str4, Boolean bool2, String str5, List<Teacher> list) {
        return new RecordedCalendarCourse(j, str, bool, str2, str3, str4, bool2, str5, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedCalendarCourse)) {
            return false;
        }
        RecordedCalendarCourse recordedCalendarCourse = (RecordedCalendarCourse) obj;
        return this.sessionId == recordedCalendarCourse.sessionId && Intrinsics.areEqual((Object) this.expirationTime, (Object) recordedCalendarCourse.expirationTime) && Intrinsics.areEqual((Object) this.expired, (Object) recordedCalendarCourse.expired) && Intrinsics.areEqual((Object) this.id, (Object) recordedCalendarCourse.id) && Intrinsics.areEqual((Object) this.skuId, (Object) recordedCalendarCourse.skuId) && Intrinsics.areEqual((Object) this.name, (Object) recordedCalendarCourse.name) && Intrinsics.areEqual((Object) this.permanent, (Object) recordedCalendarCourse.permanent) && Intrinsics.areEqual((Object) this.subjectTag, (Object) recordedCalendarCourse.subjectTag) && Intrinsics.areEqual((Object) this.teachers, (Object) recordedCalendarCourse.teachers);
    }

    public int hashCode() {
        int m = SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.sessionId) * 31;
        String str = this.expirationTime;
        int i = 0;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.expired;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.id;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.skuId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool2 = this.permanent;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str5 = this.subjectTag;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<Teacher> list = this.teachers;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "RecordedCalendarCourse(sessionId=" + this.sessionId + ", expirationTime=" + this.expirationTime + ", expired=" + this.expired + ", id=" + this.id + ", skuId=" + this.skuId + ", name=" + this.name + ", permanent=" + this.permanent + ", subjectTag=" + this.subjectTag + ", teachers=" + this.teachers + ')';
    }

    public RecordedCalendarCourse(long j, String str, Boolean bool, String str2, String str3, String str4, Boolean bool2, String str5, List<Teacher> list) {
        this.sessionId = j;
        this.expirationTime = str;
        this.expired = bool;
        this.id = str2;
        this.skuId = str3;
        this.name = str4;
        this.permanent = bool2;
        this.subjectTag = str5;
        this.teachers = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordedCalendarCourse(long j, String str, Boolean bool, String str2, String str3, String str4, Boolean bool2, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : j, str, bool, str2, str3, str4, bool2, str5, list);
    }

    public final long getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(long j) {
        this.sessionId = j;
    }

    public final String getExpirationTime() {
        return this.expirationTime;
    }

    public final void setExpirationTime(String str) {
        this.expirationTime = str;
    }

    public final Boolean getExpired() {
        return this.expired;
    }

    public final void setExpired(Boolean bool) {
        this.expired = bool;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final void setSkuId(String str) {
        this.skuId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Boolean getPermanent() {
        return this.permanent;
    }

    public final void setPermanent(Boolean bool) {
        this.permanent = bool;
    }

    public final String getSubjectTag() {
        return this.subjectTag;
    }

    public final void setSubjectTag(String str) {
        this.subjectTag = str;
    }

    public final List<Teacher> getTeachers() {
        return this.teachers;
    }

    public final void setTeachers(List<Teacher> list) {
        this.teachers = list;
    }
}
