package com.tal.app.thinkacademy.business.study.study.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/ContactInfo;", "Ljava/io/Serializable;", "type", "", "value", "Lcom/tal/app/thinkacademy/business/study/study/entity/ContactInfoDetail;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/ContactInfoDetail;)V", "getType", "()Ljava/lang/String;", "getValue", "()Lcom/tal/app/thinkacademy/business/study/study/entity/ContactInfoDetail;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class ContactInfo implements Serializable {
    private final String type;
    private final ContactInfoDetail value;

    public static /* synthetic */ ContactInfo copy$default(ContactInfo contactInfo, String str, ContactInfoDetail contactInfoDetail, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactInfo.type;
        }
        if ((i & 2) != 0) {
            contactInfoDetail = contactInfo.value;
        }
        return contactInfo.copy(str, contactInfoDetail);
    }

    public final String component1() {
        return this.type;
    }

    public final ContactInfoDetail component2() {
        return this.value;
    }

    public final ContactInfo copy(String str, ContactInfoDetail contactInfoDetail) {
        return new ContactInfo(str, contactInfoDetail);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactInfo)) {
            return false;
        }
        ContactInfo contactInfo = (ContactInfo) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) contactInfo.type) && Intrinsics.areEqual((Object) this.value, (Object) contactInfo.value);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ContactInfoDetail contactInfoDetail = this.value;
        if (contactInfoDetail != null) {
            i = contactInfoDetail.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ContactInfo(type=" + this.type + ", value=" + this.value + ')';
    }

    public ContactInfo(String str, ContactInfoDetail contactInfoDetail) {
        this.type = str;
        this.value = contactInfoDetail;
    }

    public final String getType() {
        return this.type;
    }

    public final ContactInfoDetail getValue() {
        return this.value;
    }
}
