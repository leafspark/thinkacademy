package com.tal.app.thinkacademy.business.study.study.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordHomework;", "Ljava/io/Serializable;", "displayStatus", "", "title", "url", "entityId", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDisplayStatus", "()Ljava/lang/String;", "setDisplayStatus", "(Ljava/lang/String;)V", "getEntityId", "setEntityId", "getTitle", "setTitle", "getType", "()I", "setType", "(I)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarListEntity.kt */
public final class RecordHomework implements Serializable {
    private String displayStatus;
    private String entityId;
    private String title;
    private int type;
    private String url;

    public static /* synthetic */ RecordHomework copy$default(RecordHomework recordHomework, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = recordHomework.displayStatus;
        }
        if ((i2 & 2) != 0) {
            str2 = recordHomework.title;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = recordHomework.url;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = recordHomework.entityId;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = recordHomework.type;
        }
        return recordHomework.copy(str, str5, str6, str7, i);
    }

    public final String component1() {
        return this.displayStatus;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.entityId;
    }

    public final int component5() {
        return this.type;
    }

    public final RecordHomework copy(String str, String str2, String str3, String str4, int i) {
        return new RecordHomework(str, str2, str3, str4, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordHomework)) {
            return false;
        }
        RecordHomework recordHomework = (RecordHomework) obj;
        return Intrinsics.areEqual((Object) this.displayStatus, (Object) recordHomework.displayStatus) && Intrinsics.areEqual((Object) this.title, (Object) recordHomework.title) && Intrinsics.areEqual((Object) this.url, (Object) recordHomework.url) && Intrinsics.areEqual((Object) this.entityId, (Object) recordHomework.entityId) && this.type == recordHomework.type;
    }

    public int hashCode() {
        String str = this.displayStatus;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.entityId;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.type;
    }

    public String toString() {
        return "RecordHomework(displayStatus=" + this.displayStatus + ", title=" + this.title + ", url=" + this.url + ", entityId=" + this.entityId + ", type=" + this.type + ')';
    }

    public RecordHomework(String str, String str2, String str3, String str4, int i) {
        this.displayStatus = str;
        this.title = str2;
        this.url = str3;
        this.entityId = str4;
        this.type = i;
    }

    public final String getDisplayStatus() {
        return this.displayStatus;
    }

    public final void setDisplayStatus(String str) {
        this.displayStatus = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final void setEntityId(String str) {
        this.entityId = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
