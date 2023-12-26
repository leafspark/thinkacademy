package com.tal.app.thinkacademy.business.study.study.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/ContactInfoDetail;", "Ljava/io/Serializable;", "account", "", "qrCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccount", "()Ljava/lang/String;", "getQrCode", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class ContactInfoDetail implements Serializable {
    private final String account;
    private final String qrCode;

    public static /* synthetic */ ContactInfoDetail copy$default(ContactInfoDetail contactInfoDetail, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactInfoDetail.account;
        }
        if ((i & 2) != 0) {
            str2 = contactInfoDetail.qrCode;
        }
        return contactInfoDetail.copy(str, str2);
    }

    public final String component1() {
        return this.account;
    }

    public final String component2() {
        return this.qrCode;
    }

    public final ContactInfoDetail copy(String str, String str2) {
        return new ContactInfoDetail(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactInfoDetail)) {
            return false;
        }
        ContactInfoDetail contactInfoDetail = (ContactInfoDetail) obj;
        return Intrinsics.areEqual((Object) this.account, (Object) contactInfoDetail.account) && Intrinsics.areEqual((Object) this.qrCode, (Object) contactInfoDetail.qrCode);
    }

    public int hashCode() {
        String str = this.account;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.qrCode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ContactInfoDetail(account=" + this.account + ", qrCode=" + this.qrCode + ')';
    }

    public ContactInfoDetail(String str, String str2) {
        this.account = str;
        this.qrCode = str2;
    }

    public final String getAccount() {
        return this.account;
    }

    public final String getQrCode() {
        return this.qrCode;
    }
}
