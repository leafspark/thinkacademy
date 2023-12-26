package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordUrl;", "", "routeName", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getRouteName", "()Ljava/lang/String;", "setRouteName", "(Ljava/lang/String;)V", "getUrl", "setUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarListEntity.kt */
public final class RecordUrl {
    private String routeName;
    private String url;

    public static /* synthetic */ RecordUrl copy$default(RecordUrl recordUrl, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordUrl.routeName;
        }
        if ((i & 2) != 0) {
            str2 = recordUrl.url;
        }
        return recordUrl.copy(str, str2);
    }

    public final String component1() {
        return this.routeName;
    }

    public final String component2() {
        return this.url;
    }

    public final RecordUrl copy(String str, String str2) {
        return new RecordUrl(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordUrl)) {
            return false;
        }
        RecordUrl recordUrl = (RecordUrl) obj;
        return Intrinsics.areEqual((Object) this.routeName, (Object) recordUrl.routeName) && Intrinsics.areEqual((Object) this.url, (Object) recordUrl.url);
    }

    public int hashCode() {
        String str = this.routeName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RecordUrl(routeName=" + this.routeName + ", url=" + this.url + ')';
    }

    public RecordUrl(String str, String str2) {
        this.routeName = str;
        this.url = str2;
    }

    public final String getRouteName() {
        return this.routeName;
    }

    public final void setRouteName(String str) {
        this.routeName = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
