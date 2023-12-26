package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JD\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordResource;", "", "duration", "", "id", "", "type", "urls", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordUrl;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getDuration", "()Ljava/lang/String;", "setDuration", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getType", "setType", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/study/study/entity/RecordResource;", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarListEntity.kt */
public final class RecordResource {
    private String duration;
    private Integer id;
    private Integer type;
    private List<RecordUrl> urls;

    public static /* synthetic */ RecordResource copy$default(RecordResource recordResource, String str, Integer num, Integer num2, List<RecordUrl> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordResource.duration;
        }
        if ((i & 2) != 0) {
            num = recordResource.id;
        }
        if ((i & 4) != 0) {
            num2 = recordResource.type;
        }
        if ((i & 8) != 0) {
            list = recordResource.urls;
        }
        return recordResource.copy(str, num, num2, list);
    }

    public final String component1() {
        return this.duration;
    }

    public final Integer component2() {
        return this.id;
    }

    public final Integer component3() {
        return this.type;
    }

    public final List<RecordUrl> component4() {
        return this.urls;
    }

    public final RecordResource copy(String str, Integer num, Integer num2, List<RecordUrl> list) {
        return new RecordResource(str, num, num2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordResource)) {
            return false;
        }
        RecordResource recordResource = (RecordResource) obj;
        return Intrinsics.areEqual((Object) this.duration, (Object) recordResource.duration) && Intrinsics.areEqual((Object) this.id, (Object) recordResource.id) && Intrinsics.areEqual((Object) this.type, (Object) recordResource.type) && Intrinsics.areEqual((Object) this.urls, (Object) recordResource.urls);
    }

    public int hashCode() {
        String str = this.duration;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.id;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.type;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<RecordUrl> list = this.urls;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "RecordResource(duration=" + this.duration + ", id=" + this.id + ", type=" + this.type + ", urls=" + this.urls + ')';
    }

    public RecordResource(String str, Integer num, Integer num2, List<RecordUrl> list) {
        this.duration = str;
        this.id = num;
        this.type = num2;
        this.urls = list;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final List<RecordUrl> getUrls() {
        return this.urls;
    }

    public final void setUrls(List<RecordUrl> list) {
        this.urls = list;
    }
}
