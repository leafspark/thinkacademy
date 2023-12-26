package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/AllSchoolsList;", "", "live", "Lcom/tal/app/thinkacademy/business/study/study/entity/Live;", "record", "Lcom/tal/app/thinkacademy/business/study/study/entity/Recorded;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/Live;Lcom/tal/app/thinkacademy/business/study/study/entity/Recorded;)V", "getLive", "()Lcom/tal/app/thinkacademy/business/study/study/entity/Live;", "setLive", "(Lcom/tal/app/thinkacademy/business/study/study/entity/Live;)V", "getRecord", "()Lcom/tal/app/thinkacademy/business/study/study/entity/Recorded;", "setRecord", "(Lcom/tal/app/thinkacademy/business/study/study/entity/Recorded;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllSchoolsList.kt */
public final class AllSchoolsList {
    private Live live;
    private Recorded record;

    public static /* synthetic */ AllSchoolsList copy$default(AllSchoolsList allSchoolsList, Live live2, Recorded recorded, int i, Object obj) {
        if ((i & 1) != 0) {
            live2 = allSchoolsList.live;
        }
        if ((i & 2) != 0) {
            recorded = allSchoolsList.record;
        }
        return allSchoolsList.copy(live2, recorded);
    }

    public final Live component1() {
        return this.live;
    }

    public final Recorded component2() {
        return this.record;
    }

    public final AllSchoolsList copy(Live live2, Recorded recorded) {
        return new AllSchoolsList(live2, recorded);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AllSchoolsList)) {
            return false;
        }
        AllSchoolsList allSchoolsList = (AllSchoolsList) obj;
        return Intrinsics.areEqual((Object) this.live, (Object) allSchoolsList.live) && Intrinsics.areEqual((Object) this.record, (Object) allSchoolsList.record);
    }

    public int hashCode() {
        Live live2 = this.live;
        int i = 0;
        int hashCode = (live2 == null ? 0 : live2.hashCode()) * 31;
        Recorded recorded = this.record;
        if (recorded != null) {
            i = recorded.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AllSchoolsList(live=" + this.live + ", record=" + this.record + ')';
    }

    public AllSchoolsList(Live live2, Recorded recorded) {
        this.live = live2;
        this.record = recorded;
    }

    public final Live getLive() {
        return this.live;
    }

    public final void setLive(Live live2) {
        this.live = live2;
    }

    public final Recorded getRecord() {
        return this.record;
    }

    public final void setRecord(Recorded recorded) {
        this.record = recorded;
    }
}
