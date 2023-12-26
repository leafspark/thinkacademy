package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001fH\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006'"}, d2 = {"Lcom/adyen/checkout/components/model/payments/response/OrderResponse;", "Lcom/adyen/checkout/core/model/ModelObject;", "pspReference", "", "orderData", "reference", "amount", "Lcom/adyen/checkout/components/model/payments/Amount;", "remainingAmount", "expiresAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adyen/checkout/components/model/payments/Amount;Lcom/adyen/checkout/components/model/payments/Amount;Ljava/lang/String;)V", "getAmount", "()Lcom/adyen/checkout/components/model/payments/Amount;", "getExpiresAt", "()Ljava/lang/String;", "getOrderData", "getPspReference", "getReference", "getRemainingAmount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderResponse.kt */
public final class OrderResponse extends ModelObject {
    private static final String AMOUNT = "amount";
    public static final ModelObject.Creator<OrderResponse> CREATOR = new ModelObject.Creator<>(OrderResponse.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXPIRES_AT = "expiresAt";
    private static final String ORDER_DATA = "orderData";
    private static final String PSP_REFERENCE = "pspReference";
    private static final String REFERENCE = "reference";
    private static final String REMAINING_AMOUNT = "remainingAmount";
    public static final ModelObject.Serializer<OrderResponse> SERIALIZER = new OrderResponse$Companion$SERIALIZER$1();
    private final Amount amount;
    private final String expiresAt;
    private final String orderData;
    private final String pspReference;
    private final String reference;
    private final Amount remainingAmount;

    public static /* synthetic */ OrderResponse copy$default(OrderResponse orderResponse, String str, String str2, String str3, Amount amount2, Amount amount3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderResponse.pspReference;
        }
        if ((i & 2) != 0) {
            str2 = orderResponse.orderData;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = orderResponse.reference;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            amount2 = orderResponse.amount;
        }
        Amount amount4 = amount2;
        if ((i & 16) != 0) {
            amount3 = orderResponse.remainingAmount;
        }
        Amount amount5 = amount3;
        if ((i & 32) != 0) {
            str4 = orderResponse.expiresAt;
        }
        return orderResponse.copy(str, str5, str6, amount4, amount5, str4);
    }

    public final String component1() {
        return this.pspReference;
    }

    public final String component2() {
        return this.orderData;
    }

    public final String component3() {
        return this.reference;
    }

    public final Amount component4() {
        return this.amount;
    }

    public final Amount component5() {
        return this.remainingAmount;
    }

    public final String component6() {
        return this.expiresAt;
    }

    public final OrderResponse copy(String str, String str2, String str3, Amount amount2, Amount amount3, String str4) {
        Intrinsics.checkNotNullParameter(str, PSP_REFERENCE);
        Intrinsics.checkNotNullParameter(str2, ORDER_DATA);
        return new OrderResponse(str, str2, str3, amount2, amount3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderResponse)) {
            return false;
        }
        OrderResponse orderResponse = (OrderResponse) obj;
        return Intrinsics.areEqual(this.pspReference, orderResponse.pspReference) && Intrinsics.areEqual(this.orderData, orderResponse.orderData) && Intrinsics.areEqual(this.reference, orderResponse.reference) && Intrinsics.areEqual(this.amount, orderResponse.amount) && Intrinsics.areEqual(this.remainingAmount, orderResponse.remainingAmount) && Intrinsics.areEqual(this.expiresAt, orderResponse.expiresAt);
    }

    public int hashCode() {
        int hashCode = ((this.pspReference.hashCode() * 31) + this.orderData.hashCode()) * 31;
        String str = this.reference;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Amount amount2 = this.amount;
        int hashCode3 = (hashCode2 + (amount2 == null ? 0 : amount2.hashCode())) * 31;
        Amount amount3 = this.remainingAmount;
        int hashCode4 = (hashCode3 + (amount3 == null ? 0 : amount3.hashCode())) * 31;
        String str2 = this.expiresAt;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "OrderResponse(pspReference=" + this.pspReference + ", orderData=" + this.orderData + ", reference=" + this.reference + ", amount=" + this.amount + ", remainingAmount=" + this.remainingAmount + ", expiresAt=" + this.expiresAt + ')';
    }

    public final String getPspReference() {
        return this.pspReference;
    }

    public final String getOrderData() {
        return this.orderData;
    }

    public final String getReference() {
        return this.reference;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final Amount getRemainingAmount() {
        return this.remainingAmount;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public OrderResponse(String str, String str2, String str3, Amount amount2, Amount amount3, String str4) {
        Intrinsics.checkNotNullParameter(str, PSP_REFERENCE);
        Intrinsics.checkNotNullParameter(str2, ORDER_DATA);
        this.pspReference = str;
        this.orderData = str2;
        this.reference = str3;
        this.amount = amount2;
        this.remainingAmount = amount3;
        this.expiresAt = str4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/adyen/checkout/components/model/payments/response/OrderResponse$Companion;", "", "()V", "AMOUNT", "", "CREATOR", "Lcom/adyen/checkout/core/model/ModelObject$Creator;", "Lcom/adyen/checkout/components/model/payments/response/OrderResponse;", "kotlin.jvm.PlatformType", "EXPIRES_AT", "ORDER_DATA", "PSP_REFERENCE", "REFERENCE", "REMAINING_AMOUNT", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: OrderResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
