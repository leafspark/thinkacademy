package com.tal.app.thinkacademy.live.business.groupvideocall.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/GroupStudentInfo;", "", "userId", "", "micIsPermission", "cameraIsPermission", "micIsOpen", "cameraIsOpen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCameraIsOpen", "()Ljava/lang/String;", "setCameraIsOpen", "(Ljava/lang/String;)V", "getCameraIsPermission", "setCameraIsPermission", "getMicIsOpen", "setMicIsOpen", "getMicIsPermission", "setMicIsPermission", "getUserId", "setUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupStudentInfoList.kt */
public final class GroupStudentInfo {
    private String cameraIsOpen;
    private String cameraIsPermission;
    private String micIsOpen;
    private String micIsPermission;
    private String userId;

    public static /* synthetic */ GroupStudentInfo copy$default(GroupStudentInfo groupStudentInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupStudentInfo.userId;
        }
        if ((i & 2) != 0) {
            str2 = groupStudentInfo.micIsPermission;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = groupStudentInfo.cameraIsPermission;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = groupStudentInfo.micIsOpen;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = groupStudentInfo.cameraIsOpen;
        }
        return groupStudentInfo.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.micIsPermission;
    }

    public final String component3() {
        return this.cameraIsPermission;
    }

    public final String component4() {
        return this.micIsOpen;
    }

    public final String component5() {
        return this.cameraIsOpen;
    }

    public final GroupStudentInfo copy(String str, String str2, String str3, String str4, String str5) {
        return new GroupStudentInfo(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupStudentInfo)) {
            return false;
        }
        GroupStudentInfo groupStudentInfo = (GroupStudentInfo) obj;
        return Intrinsics.areEqual(this.userId, groupStudentInfo.userId) && Intrinsics.areEqual(this.micIsPermission, groupStudentInfo.micIsPermission) && Intrinsics.areEqual(this.cameraIsPermission, groupStudentInfo.cameraIsPermission) && Intrinsics.areEqual(this.micIsOpen, groupStudentInfo.micIsOpen) && Intrinsics.areEqual(this.cameraIsOpen, groupStudentInfo.cameraIsOpen);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.micIsPermission;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cameraIsPermission;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.micIsOpen;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cameraIsOpen;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "GroupStudentInfo(userId=" + this.userId + ", micIsPermission=" + this.micIsPermission + ", cameraIsPermission=" + this.cameraIsPermission + ", micIsOpen=" + this.micIsOpen + ", cameraIsOpen=" + this.cameraIsOpen + ')';
    }

    public GroupStudentInfo(String str, String str2, String str3, String str4, String str5) {
        this.userId = str;
        this.micIsPermission = str2;
        this.cameraIsPermission = str3;
        this.micIsOpen = str4;
        this.cameraIsOpen = str5;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getMicIsPermission() {
        return this.micIsPermission;
    }

    public final void setMicIsPermission(String str) {
        this.micIsPermission = str;
    }

    public final String getCameraIsPermission() {
        return this.cameraIsPermission;
    }

    public final void setCameraIsPermission(String str) {
        this.cameraIsPermission = str;
    }

    public final String getMicIsOpen() {
        return this.micIsOpen;
    }

    public final void setMicIsOpen(String str) {
        this.micIsOpen = str;
    }

    public final String getCameraIsOpen() {
        return this.cameraIsOpen;
    }

    public final void setCameraIsOpen(String str) {
        this.cameraIsOpen = str;
    }
}
