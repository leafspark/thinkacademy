package com.tal.app.thinkacademy.live.business.groupvideocall.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/GroupStudentInfoList;", "", "list", "", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/GroupStudentInfo;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupStudentInfoList.kt */
public final class GroupStudentInfoList {
    private List<GroupStudentInfo> list;

    public static /* synthetic */ GroupStudentInfoList copy$default(GroupStudentInfoList groupStudentInfoList, List<GroupStudentInfo> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list2 = groupStudentInfoList.list;
        }
        return groupStudentInfoList.copy(list2);
    }

    public final List<GroupStudentInfo> component1() {
        return this.list;
    }

    public final GroupStudentInfoList copy(List<GroupStudentInfo> list2) {
        return new GroupStudentInfoList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GroupStudentInfoList) && Intrinsics.areEqual(this.list, ((GroupStudentInfoList) obj).list);
    }

    public int hashCode() {
        List<GroupStudentInfo> list2 = this.list;
        if (list2 == null) {
            return 0;
        }
        return list2.hashCode();
    }

    public String toString() {
        return "GroupStudentInfoList(list=" + this.list + ')';
    }

    public GroupStudentInfoList(List<GroupStudentInfo> list2) {
        this.list = list2;
    }

    public final List<GroupStudentInfo> getList() {
        return this.list;
    }

    public final void setList(List<GroupStudentInfo> list2) {
        this.list = list2;
    }
}