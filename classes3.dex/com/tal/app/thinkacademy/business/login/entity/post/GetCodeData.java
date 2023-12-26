package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/GetCodeData;", "", "contactInfo", "", "countryCallingCode", "type", "", "scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getContactInfo", "()Ljava/lang/String;", "getCountryCallingCode", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/login/entity/post/GetCodeData;", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetCode.kt */
public final class GetCodeData {
    private final String contactInfo;
    private final String countryCallingCode;
    private final Integer scene;
    private final Integer type;

    public static /* synthetic */ GetCodeData copy$default(GetCodeData getCodeData, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getCodeData.contactInfo;
        }
        if ((i & 2) != 0) {
            str2 = getCodeData.countryCallingCode;
        }
        if ((i & 4) != 0) {
            num = getCodeData.type;
        }
        if ((i & 8) != 0) {
            num2 = getCodeData.scene;
        }
        return getCodeData.copy(str, str2, num, num2);
    }

    public final String component1() {
        return this.contactInfo;
    }

    public final String component2() {
        return this.countryCallingCode;
    }

    public final Integer component3() {
        return this.type;
    }

    public final Integer component4() {
        return this.scene;
    }

    public final GetCodeData copy(String str, String str2, Integer num, Integer num2) {
        return new GetCodeData(str, str2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetCodeData)) {
            return false;
        }
        GetCodeData getCodeData = (GetCodeData) obj;
        return Intrinsics.areEqual((Object) this.contactInfo, (Object) getCodeData.contactInfo) && Intrinsics.areEqual((Object) this.countryCallingCode, (Object) getCodeData.countryCallingCode) && Intrinsics.areEqual((Object) this.type, (Object) getCodeData.type) && Intrinsics.areEqual((Object) this.scene, (Object) getCodeData.scene);
    }

    public int hashCode() {
        String str = this.contactInfo;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.countryCallingCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.scene;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GetCodeData(contactInfo=" + this.contactInfo + ", countryCallingCode=" + this.countryCallingCode + ", type=" + this.type + ", scene=" + this.scene + ')';
    }

    public GetCodeData(String str, String str2, Integer num, Integer num2) {
        this.contactInfo = str;
        this.countryCallingCode = str2;
        this.type = num;
        this.scene = num2;
    }

    public final String getContactInfo() {
        return this.contactInfo;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCodeData(String str, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 1 : num, (i & 8) != 0 ? 1 : num2);
    }

    public final Integer getType() {
        return this.type;
    }

    public final Integer getScene() {
        return this.scene;
    }
}
