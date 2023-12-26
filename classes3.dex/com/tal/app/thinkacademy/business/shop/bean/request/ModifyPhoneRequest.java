package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/ModifyPhoneRequest;", "", "phone", "", "countryCallingCode", "verificationCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCallingCode", "()Ljava/lang/String;", "getPhone", "getVerificationCode", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifyPhoneRequest.kt */
public final class ModifyPhoneRequest {
    private final String countryCallingCode;
    private final String phone;
    private final String verificationCode;

    public ModifyPhoneRequest() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public ModifyPhoneRequest(String str, String str2, String str3) {
        this.phone = str;
        this.countryCallingCode = str2;
        this.verificationCode = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModifyPhoneRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final String getVerificationCode() {
        return this.verificationCode;
    }
}
