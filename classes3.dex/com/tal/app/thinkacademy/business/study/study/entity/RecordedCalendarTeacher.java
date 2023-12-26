package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarTeacher;", "", "avatar", "", "id", "", "identityName", "name", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getIdentityName", "setIdentityName", "getName", "setName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarListEntity.kt */
public final class RecordedCalendarTeacher {
    private String avatar;
    private int id;
    private String identityName;
    private String name;

    public static /* synthetic */ RecordedCalendarTeacher copy$default(RecordedCalendarTeacher recordedCalendarTeacher, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = recordedCalendarTeacher.avatar;
        }
        if ((i2 & 2) != 0) {
            i = recordedCalendarTeacher.id;
        }
        if ((i2 & 4) != 0) {
            str2 = recordedCalendarTeacher.identityName;
        }
        if ((i2 & 8) != 0) {
            str3 = recordedCalendarTeacher.name;
        }
        return recordedCalendarTeacher.copy(str, i, str2, str3);
    }

    public final String component1() {
        return this.avatar;
    }

    public final int component2() {
        return this.id;
    }

    public final String component3() {
        return this.identityName;
    }

    public final String component4() {
        return this.name;
    }

    public final RecordedCalendarTeacher copy(String str, int i, String str2, String str3) {
        return new RecordedCalendarTeacher(str, i, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedCalendarTeacher)) {
            return false;
        }
        RecordedCalendarTeacher recordedCalendarTeacher = (RecordedCalendarTeacher) obj;
        return Intrinsics.areEqual((Object) this.avatar, (Object) recordedCalendarTeacher.avatar) && this.id == recordedCalendarTeacher.id && Intrinsics.areEqual((Object) this.identityName, (Object) recordedCalendarTeacher.identityName) && Intrinsics.areEqual((Object) this.name, (Object) recordedCalendarTeacher.name);
    }

    public int hashCode() {
        String str = this.avatar;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.id) * 31;
        String str2 = this.identityName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RecordedCalendarTeacher(avatar=" + this.avatar + ", id=" + this.id + ", identityName=" + this.identityName + ", name=" + this.name + ')';
    }

    public RecordedCalendarTeacher(String str, int i, String str2, String str3) {
        this.avatar = str;
        this.id = i;
        this.identityName = str2;
        this.name = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordedCalendarTeacher(String str, int i, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, str2, str3);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getIdentityName() {
        return this.identityName;
    }

    public final void setIdentityName(String str) {
        this.identityName = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }
}
