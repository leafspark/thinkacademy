package com.tal.app.thinkacademy.live.business.photosonthewall.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\f¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoOnTheWallBody;", "", "planId", "", "classId", "tutorId", "interactId", "", "photoPath", "teacherId", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getClassId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInteractId", "()Ljava/lang/String;", "getPhotoPath", "getPlanId", "getTeacherId", "getTutorId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoOnTheWallBody;", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoOnTheWallBody.kt */
public final class PhotoOnTheWallBody {
    private final Long classId;
    private final String interactId;
    private final String photoPath;
    private final Long planId;
    private final Long teacherId;
    private final Long tutorId;

    public static /* synthetic */ PhotoOnTheWallBody copy$default(PhotoOnTheWallBody photoOnTheWallBody, Long l, Long l2, Long l3, String str, String str2, Long l4, int i, Object obj) {
        if ((i & 1) != 0) {
            l = photoOnTheWallBody.planId;
        }
        if ((i & 2) != 0) {
            l2 = photoOnTheWallBody.classId;
        }
        Long l5 = l2;
        if ((i & 4) != 0) {
            l3 = photoOnTheWallBody.tutorId;
        }
        Long l6 = l3;
        if ((i & 8) != 0) {
            str = photoOnTheWallBody.interactId;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            str2 = photoOnTheWallBody.photoPath;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            l4 = photoOnTheWallBody.teacherId;
        }
        return photoOnTheWallBody.copy(l, l5, l6, str3, str4, l4);
    }

    public final Long component1() {
        return this.planId;
    }

    public final Long component2() {
        return this.classId;
    }

    public final Long component3() {
        return this.tutorId;
    }

    public final String component4() {
        return this.interactId;
    }

    public final String component5() {
        return this.photoPath;
    }

    public final Long component6() {
        return this.teacherId;
    }

    public final PhotoOnTheWallBody copy(Long l, Long l2, Long l3, String str, String str2, Long l4) {
        return new PhotoOnTheWallBody(l, l2, l3, str, str2, l4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoOnTheWallBody)) {
            return false;
        }
        PhotoOnTheWallBody photoOnTheWallBody = (PhotoOnTheWallBody) obj;
        return Intrinsics.areEqual(this.planId, photoOnTheWallBody.planId) && Intrinsics.areEqual(this.classId, photoOnTheWallBody.classId) && Intrinsics.areEqual(this.tutorId, photoOnTheWallBody.tutorId) && Intrinsics.areEqual(this.interactId, photoOnTheWallBody.interactId) && Intrinsics.areEqual(this.photoPath, photoOnTheWallBody.photoPath) && Intrinsics.areEqual(this.teacherId, photoOnTheWallBody.teacherId);
    }

    public int hashCode() {
        Long l = this.planId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.classId;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.tutorId;
        int hashCode3 = (hashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str = this.interactId;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.photoPath;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l4 = this.teacherId;
        if (l4 != null) {
            i = l4.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "PhotoOnTheWallBody(planId=" + this.planId + ", classId=" + this.classId + ", tutorId=" + this.tutorId + ", interactId=" + this.interactId + ", photoPath=" + this.photoPath + ", teacherId=" + this.teacherId + ')';
    }

    public PhotoOnTheWallBody(Long l, Long l2, Long l3, String str, String str2, Long l4) {
        this.planId = l;
        this.classId = l2;
        this.tutorId = l3;
        this.interactId = str;
        this.photoPath = str2;
        this.teacherId = l4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoOnTheWallBody(Long l, Long l2, Long l3, String str, String str2, Long l4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? 0L : l2, (i & 4) != 0 ? 0L : l3, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, l4);
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final Long getClassId() {
        return this.classId;
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final String getPhotoPath() {
        return this.photoPath;
    }

    public final Long getTeacherId() {
        return this.teacherId;
    }
}
