package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedTeacher;", "", "avatar", "", "id", "", "identityName", "name", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getIdentityName", "setIdentityName", "getName", "setName", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedTeacher;", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedClassList.kt */
public final class RecordedTeacher {
    private String avatar;
    private Long id;
    private String identityName;
    private String name;

    public RecordedTeacher() {
        this((String) null, (Long) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordedTeacher copy$default(RecordedTeacher recordedTeacher, String str, Long l, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordedTeacher.avatar;
        }
        if ((i & 2) != 0) {
            l = recordedTeacher.id;
        }
        if ((i & 4) != 0) {
            str2 = recordedTeacher.identityName;
        }
        if ((i & 8) != 0) {
            str3 = recordedTeacher.name;
        }
        return recordedTeacher.copy(str, l, str2, str3);
    }

    public final String component1() {
        return this.avatar;
    }

    public final Long component2() {
        return this.id;
    }

    public final String component3() {
        return this.identityName;
    }

    public final String component4() {
        return this.name;
    }

    public final RecordedTeacher copy(String str, Long l, String str2, String str3) {
        return new RecordedTeacher(str, l, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedTeacher)) {
            return false;
        }
        RecordedTeacher recordedTeacher = (RecordedTeacher) obj;
        return Intrinsics.areEqual((Object) this.avatar, (Object) recordedTeacher.avatar) && Intrinsics.areEqual((Object) this.id, (Object) recordedTeacher.id) && Intrinsics.areEqual((Object) this.identityName, (Object) recordedTeacher.identityName) && Intrinsics.areEqual((Object) this.name, (Object) recordedTeacher.name);
    }

    public int hashCode() {
        String str = this.avatar;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.id;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.identityName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "RecordedTeacher(avatar=" + this.avatar + ", id=" + this.id + ", identityName=" + this.identityName + ", name=" + this.name + ')';
    }

    public RecordedTeacher(String str, Long l, String str2, String str3) {
        this.avatar = str;
        this.id = l;
        this.identityName = str2;
        this.name = str3;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordedTeacher(String str, Long l, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : l, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long l) {
        this.id = l;
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
