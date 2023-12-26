package com.tal.app.thinkacademy.business.study.study.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;", "Ljava/io/Serializable;", "count", "", "url", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;", "equals", "", "other", "", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class MaterialEntity implements Serializable {
    private final Integer count;
    private final String url;

    public static /* synthetic */ MaterialEntity copy$default(MaterialEntity materialEntity, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = materialEntity.count;
        }
        if ((i & 2) != 0) {
            str = materialEntity.url;
        }
        return materialEntity.copy(num, str);
    }

    public final Integer component1() {
        return this.count;
    }

    public final String component2() {
        return this.url;
    }

    public final MaterialEntity copy(Integer num, String str) {
        return new MaterialEntity(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaterialEntity)) {
            return false;
        }
        MaterialEntity materialEntity = (MaterialEntity) obj;
        return Intrinsics.areEqual((Object) this.count, (Object) materialEntity.count) && Intrinsics.areEqual((Object) this.url, (Object) materialEntity.url);
    }

    public int hashCode() {
        Integer num = this.count;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.url;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MaterialEntity(count=" + this.count + ", url=" + this.url + ')';
    }

    public MaterialEntity(Integer num, String str) {
        this.count = num;
        this.url = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaterialEntity(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, str);
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getUrl() {
        return this.url;
    }
}
