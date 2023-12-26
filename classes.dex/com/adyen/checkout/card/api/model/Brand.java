package com.adyen.checkout.card.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0002$%BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001dH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006&"}, d2 = {"Lcom/adyen/checkout/card/api/model/Brand;", "Lcom/adyen/checkout/core/model/ModelObject;", "brand", "", "enableLuhnCheck", "", "supported", "cvcPolicy", "expiryDatePolicy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getCvcPolicy", "getEnableLuhnCheck", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExpiryDatePolicy", "getSupported", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/adyen/checkout/card/api/model/Brand;", "equals", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "FieldPolicy", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Brand.kt */
public final class Brand extends ModelObject {
    private static final String BRAND = "brand";
    public static final Parcelable.Creator<Brand> CREATOR = new ModelObject.Creator(Brand.class);
    private static final String CVC_POLICY = "cvcPolicy";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ENABLE_LUHN_CHECK = "enableLuhnCheck";
    private static final String EXPIRY_DATE_POLICY = "expiryDatePolicy";
    /* access modifiers changed from: private */
    public static final ModelObject.Serializer<Brand> SERIALIZER = new Brand$Companion$SERIALIZER$1();
    private static final String SUPPORTED = "supported";
    private final String brand;
    private final String cvcPolicy;
    private final Boolean enableLuhnCheck;
    private final String expiryDatePolicy;
    private final Boolean supported;

    public Brand() {
        this((String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Brand copy$default(Brand brand2, String str, Boolean bool, Boolean bool2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brand2.brand;
        }
        if ((i & 2) != 0) {
            bool = brand2.enableLuhnCheck;
        }
        Boolean bool3 = bool;
        if ((i & 4) != 0) {
            bool2 = brand2.supported;
        }
        Boolean bool4 = bool2;
        if ((i & 8) != 0) {
            str2 = brand2.cvcPolicy;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = brand2.expiryDatePolicy;
        }
        return brand2.copy(str, bool3, bool4, str4, str3);
    }

    public static final ModelObject.Serializer<Brand> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final String component1() {
        return this.brand;
    }

    public final Boolean component2() {
        return this.enableLuhnCheck;
    }

    public final Boolean component3() {
        return this.supported;
    }

    public final String component4() {
        return this.cvcPolicy;
    }

    public final String component5() {
        return this.expiryDatePolicy;
    }

    public final Brand copy(String str, Boolean bool, Boolean bool2, String str2, String str3) {
        return new Brand(str, bool, bool2, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Brand)) {
            return false;
        }
        Brand brand2 = (Brand) obj;
        return Intrinsics.areEqual(this.brand, brand2.brand) && Intrinsics.areEqual(this.enableLuhnCheck, brand2.enableLuhnCheck) && Intrinsics.areEqual(this.supported, brand2.supported) && Intrinsics.areEqual(this.cvcPolicy, brand2.cvcPolicy) && Intrinsics.areEqual(this.expiryDatePolicy, brand2.expiryDatePolicy);
    }

    public int hashCode() {
        String str = this.brand;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.enableLuhnCheck;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.supported;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.cvcPolicy;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expiryDatePolicy;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "Brand(brand=" + this.brand + ", enableLuhnCheck=" + this.enableLuhnCheck + ", supported=" + this.supported + ", cvcPolicy=" + this.cvcPolicy + ", expiryDatePolicy=" + this.expiryDatePolicy + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Brand(java.lang.String r5, java.lang.Boolean r6, java.lang.Boolean r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.api.model.Brand.<init>(java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getBrand() {
        return this.brand;
    }

    public final Boolean getEnableLuhnCheck() {
        return this.enableLuhnCheck;
    }

    public final Boolean getSupported() {
        return this.supported;
    }

    public final String getCvcPolicy() {
        return this.cvcPolicy;
    }

    public final String getExpiryDatePolicy() {
        return this.expiryDatePolicy;
    }

    public Brand(String str, Boolean bool, Boolean bool2, String str2, String str3) {
        this.brand = str;
        this.enableLuhnCheck = bool;
        this.supported = bool2;
        this.cvcPolicy = str2;
        this.expiryDatePolicy = str3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/adyen/checkout/card/api/model/Brand$Companion;", "", "()V", "BRAND", "", "getBRAND$annotations", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/card/api/model/Brand;", "CVC_POLICY", "ENABLE_LUHN_CHECK", "EXPIRY_DATE_POLICY", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "SUPPORTED", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Brand.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getBRAND$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<Brand> getSERIALIZER() {
            return Brand.SERIALIZER;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REQUIRED", "OPTIONAL", "HIDDEN", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Brand.kt */
    public enum FieldPolicy {
        REQUIRED("required"),
        OPTIONAL("optional"),
        HIDDEN("hidden");
        
        public static final Companion Companion = null;
        private final String value;

        @JvmStatic
        public static final FieldPolicy parse(String str) {
            return Companion.parse(str);
        }

        private FieldPolicy(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy$Companion;", "", "()V", "parse", "Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;", "value", "", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: Brand.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final FieldPolicy parse(String str) {
                Intrinsics.checkNotNullParameter(str, "value");
                if (Intrinsics.areEqual(str, FieldPolicy.REQUIRED.getValue())) {
                    return FieldPolicy.REQUIRED;
                }
                if (Intrinsics.areEqual(str, FieldPolicy.OPTIONAL.getValue())) {
                    return FieldPolicy.OPTIONAL;
                }
                if (Intrinsics.areEqual(str, FieldPolicy.HIDDEN.getValue())) {
                    return FieldPolicy.HIDDEN;
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus("No CvcPolicy matches the value of: ", str));
            }
        }
    }
}
