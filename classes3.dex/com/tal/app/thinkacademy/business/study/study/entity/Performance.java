package com.tal.app.thinkacademy.business.study.study.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;", "Ljava/io/Serializable;", "available", "", "url", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;", "equals", "other", "", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class Performance implements Serializable {
    private final Boolean available;
    private final String url;

    public static /* synthetic */ Performance copy$default(Performance performance, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = performance.available;
        }
        if ((i & 2) != 0) {
            str = performance.url;
        }
        return performance.copy(bool, str);
    }

    public final Boolean component1() {
        return this.available;
    }

    public final String component2() {
        return this.url;
    }

    public final Performance copy(Boolean bool, String str) {
        return new Performance(bool, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Performance)) {
            return false;
        }
        Performance performance = (Performance) obj;
        return Intrinsics.areEqual((Object) this.available, (Object) performance.available) && Intrinsics.areEqual((Object) this.url, (Object) performance.url);
    }

    public int hashCode() {
        Boolean bool = this.available;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.url;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Performance(available=" + this.available + ", url=" + this.url + ')';
    }

    public Performance(Boolean bool, String str) {
        this.available = bool;
        this.url = str;
    }

    public final Boolean getAvailable() {
        return this.available;
    }

    public final String getUrl() {
        return this.url;
    }
}
