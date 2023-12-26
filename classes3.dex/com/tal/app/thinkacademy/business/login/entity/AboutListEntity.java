package com.tal.app.thinkacademy.business.login.entity;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/AboutListEntity;", "", "list", "", "Lcom/tal/app/thinkacademy/business/login/entity/AboutBean;", "total", "", "(Ljava/util/List;J)V", "getList", "()Ljava/util/List;", "getTotal", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AboutListEntity.kt */
public final class AboutListEntity {
    private final List<AboutBean> list;
    private final long total;

    public static /* synthetic */ AboutListEntity copy$default(AboutListEntity aboutListEntity, List<AboutBean> list2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list2 = aboutListEntity.list;
        }
        if ((i & 2) != 0) {
            j = aboutListEntity.total;
        }
        return aboutListEntity.copy(list2, j);
    }

    public final List<AboutBean> component1() {
        return this.list;
    }

    public final long component2() {
        return this.total;
    }

    public final AboutListEntity copy(List<AboutBean> list2, long j) {
        Intrinsics.checkNotNullParameter(list2, "list");
        return new AboutListEntity(list2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AboutListEntity)) {
            return false;
        }
        AboutListEntity aboutListEntity = (AboutListEntity) obj;
        return Intrinsics.areEqual((Object) this.list, (Object) aboutListEntity.list) && this.total == aboutListEntity.total;
    }

    public int hashCode() {
        return (this.list.hashCode() * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.total);
    }

    public String toString() {
        return "AboutListEntity(list=" + this.list + ", total=" + this.total + ')';
    }

    public AboutListEntity(List<AboutBean> list2, long j) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
        this.total = j;
    }

    public final List<AboutBean> getList() {
        return this.list;
    }

    public final long getTotal() {
        return this.total;
    }
}
