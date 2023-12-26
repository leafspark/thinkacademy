package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/ContactVerifyRequest;", "", "contactInfo", "", "countryCallingCode", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getContactInfo", "()Ljava/lang/String;", "setContactInfo", "(Ljava/lang/String;)V", "getCountryCallingCode", "setCountryCallingCode", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactVerifyRequest.kt */
public final class ContactVerifyRequest {
    private String contactInfo;
    private String countryCallingCode;
    private int type;

    public ContactVerifyRequest() {
        this((String) null, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ContactVerifyRequest copy$default(ContactVerifyRequest contactVerifyRequest, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = contactVerifyRequest.contactInfo;
        }
        if ((i2 & 2) != 0) {
            str2 = contactVerifyRequest.countryCallingCode;
        }
        if ((i2 & 4) != 0) {
            i = contactVerifyRequest.type;
        }
        return contactVerifyRequest.copy(str, str2, i);
    }

    public final String component1() {
        return this.contactInfo;
    }

    public final String component2() {
        return this.countryCallingCode;
    }

    public final int component3() {
        return this.type;
    }

    public final ContactVerifyRequest copy(String str, String str2, int i) {
        return new ContactVerifyRequest(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactVerifyRequest)) {
            return false;
        }
        ContactVerifyRequest contactVerifyRequest = (ContactVerifyRequest) obj;
        return Intrinsics.areEqual((Object) this.contactInfo, (Object) contactVerifyRequest.contactInfo) && Intrinsics.areEqual((Object) this.countryCallingCode, (Object) contactVerifyRequest.countryCallingCode) && this.type == contactVerifyRequest.type;
    }

    public int hashCode() {
        String str = this.contactInfo;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.countryCallingCode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.type;
    }

    public String toString() {
        return "ContactVerifyRequest(contactInfo=" + this.contactInfo + ", countryCallingCode=" + this.countryCallingCode + ", type=" + this.type + ')';
    }

    public ContactVerifyRequest(String str, String str2, int i) {
        this.contactInfo = str;
        this.countryCallingCode = str2;
        this.type = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContactVerifyRequest(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i);
    }

    public final String getContactInfo() {
        return this.contactInfo;
    }

    public final void setContactInfo(String str) {
        this.contactInfo = str;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final void setCountryCallingCode(String str) {
        this.countryCallingCode = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
