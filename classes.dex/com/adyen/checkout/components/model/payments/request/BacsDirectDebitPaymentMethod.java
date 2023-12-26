package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/adyen/checkout/components/model/payments/request/BacsDirectDebitPaymentMethod;", "Lcom/adyen/checkout/components/model/payments/request/PaymentMethodDetails;", "()V", "bankAccountNumber", "", "getBankAccountNumber", "()Ljava/lang/String;", "setBankAccountNumber", "(Ljava/lang/String;)V", "bankLocationId", "getBankLocationId", "setBankLocationId", "holderName", "getHolderName", "setHolderName", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BacsDirectDebitPaymentMethod.kt */
public final class BacsDirectDebitPaymentMethod extends PaymentMethodDetails {
    private static final String BANK_ACCOUNT_NUMBER = "bankAccountNumber";
    private static final String BANK_LOCATION_ID = "bankLocationId";
    public static final Parcelable.Creator<BacsDirectDebitPaymentMethod> CREATOR = new ModelObject.Creator(BacsDirectDebitPaymentMethod.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HOLDER_NAME = "holderName";
    public static final String PAYMENT_METHOD_TYPE = "directdebit_GB";
    public static final ModelObject.Serializer<BacsDirectDebitPaymentMethod> SERIALIZER = new BacsDirectDebitPaymentMethod$Companion$SERIALIZER$1();
    private String bankAccountNumber;
    private String bankLocationId;
    private String holderName;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adyen/checkout/components/model/payments/request/BacsDirectDebitPaymentMethod$Companion;", "", "()V", "BANK_ACCOUNT_NUMBER", "", "BANK_LOCATION_ID", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/components/model/payments/request/BacsDirectDebitPaymentMethod;", "HOLDER_NAME", "PAYMENT_METHOD_TYPE", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BacsDirectDebitPaymentMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public final String getHolderName() {
        return this.holderName;
    }

    public final void setHolderName(String str) {
        this.holderName = str;
    }

    public final String getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public final void setBankAccountNumber(String str) {
        this.bankAccountNumber = str;
    }

    public final String getBankLocationId() {
        return this.bankLocationId;
    }

    public final void setBankLocationId(String str) {
        this.bankLocationId = str;
    }
}
