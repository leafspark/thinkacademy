package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "", "accountList", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsEntity;", "schoolList", "(Ljava/util/List;Ljava/util/List;)V", "getAccountList", "()Ljava/util/List;", "setAccountList", "(Ljava/util/List;)V", "getSchoolList", "setSchoolList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwitchOptionsList.kt */
public final class SwitchOptionsList {
    private List<SwitchOptionsEntity> accountList;
    private List<SwitchOptionsEntity> schoolList;

    public SwitchOptionsList() {
        this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SwitchOptionsList copy$default(SwitchOptionsList switchOptionsList, List<SwitchOptionsEntity> list, List<SwitchOptionsEntity> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = switchOptionsList.accountList;
        }
        if ((i & 2) != 0) {
            list2 = switchOptionsList.schoolList;
        }
        return switchOptionsList.copy(list, list2);
    }

    public final List<SwitchOptionsEntity> component1() {
        return this.accountList;
    }

    public final List<SwitchOptionsEntity> component2() {
        return this.schoolList;
    }

    public final SwitchOptionsList copy(List<SwitchOptionsEntity> list, List<SwitchOptionsEntity> list2) {
        return new SwitchOptionsList(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitchOptionsList)) {
            return false;
        }
        SwitchOptionsList switchOptionsList = (SwitchOptionsList) obj;
        return Intrinsics.areEqual((Object) this.accountList, (Object) switchOptionsList.accountList) && Intrinsics.areEqual((Object) this.schoolList, (Object) switchOptionsList.schoolList);
    }

    public int hashCode() {
        List<SwitchOptionsEntity> list = this.accountList;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<SwitchOptionsEntity> list2 = this.schoolList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SwitchOptionsList(accountList=" + this.accountList + ", schoolList=" + this.schoolList + ')';
    }

    public SwitchOptionsList(List<SwitchOptionsEntity> list, List<SwitchOptionsEntity> list2) {
        this.accountList = list;
        this.schoolList = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwitchOptionsList(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new ArrayList() : list2);
    }

    public final List<SwitchOptionsEntity> getAccountList() {
        return this.accountList;
    }

    public final void setAccountList(List<SwitchOptionsEntity> list) {
        this.accountList = list;
    }

    public final List<SwitchOptionsEntity> getSchoolList() {
        return this.schoolList;
    }

    public final void setSchoolList(List<SwitchOptionsEntity> list) {
        this.schoolList = list;
    }
}
