package com.adyen.checkout.components.model.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/adyen/checkout/components/model/connection/OrderStatusResponse;", "Lcom/adyen/checkout/core/model/ModelObject;", "paymentMethods", "", "Lcom/adyen/checkout/components/model/connection/OrderPaymentMethod;", "remainingAmount", "Lcom/adyen/checkout/components/model/payments/Amount;", "(Ljava/util/List;Lcom/adyen/checkout/components/model/payments/Amount;)V", "getPaymentMethods", "()Ljava/util/List;", "getRemainingAmount", "()Lcom/adyen/checkout/components/model/payments/Amount;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderStatusResponse.kt */
public final class OrderStatusResponse extends ModelObject {
    public static final Parcelable.Creator<OrderStatusResponse> CREATOR = new ModelObject.Creator(OrderStatusResponse.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PAYMENT_METHODS = "paymentMethods";
    private static final String REMAINING_AMOUNT = "remainingAmount";
    /* access modifiers changed from: private */
    public static final ModelObject.Serializer<OrderStatusResponse> SERIALIZER = new OrderStatusResponse$Companion$SERIALIZER$1();
    private final List<OrderPaymentMethod> paymentMethods;
    private final Amount remainingAmount;

    public static /* synthetic */ OrderStatusResponse copy$default(OrderStatusResponse orderStatusResponse, List<OrderPaymentMethod> list, Amount amount, int i, Object obj) {
        if ((i & 1) != 0) {
            list = orderStatusResponse.paymentMethods;
        }
        if ((i & 2) != 0) {
            amount = orderStatusResponse.remainingAmount;
        }
        return orderStatusResponse.copy(list, amount);
    }

    public static final ModelObject.Serializer<OrderStatusResponse> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final List<OrderPaymentMethod> component1() {
        return this.paymentMethods;
    }

    public final Amount component2() {
        return this.remainingAmount;
    }

    public final OrderStatusResponse copy(List<OrderPaymentMethod> list, Amount amount) {
        Intrinsics.checkNotNullParameter(list, PAYMENT_METHODS);
        Intrinsics.checkNotNullParameter(amount, REMAINING_AMOUNT);
        return new OrderStatusResponse(list, amount);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderStatusResponse)) {
            return false;
        }
        OrderStatusResponse orderStatusResponse = (OrderStatusResponse) obj;
        return Intrinsics.areEqual(this.paymentMethods, orderStatusResponse.paymentMethods) && Intrinsics.areEqual(this.remainingAmount, orderStatusResponse.remainingAmount);
    }

    public int hashCode() {
        return (this.paymentMethods.hashCode() * 31) + this.remainingAmount.hashCode();
    }

    public String toString() {
        return "OrderStatusResponse(paymentMethods=" + this.paymentMethods + ", remainingAmount=" + this.remainingAmount + ')';
    }

    public final List<OrderPaymentMethod> getPaymentMethods() {
        return this.paymentMethods;
    }

    public final Amount getRemainingAmount() {
        return this.remainingAmount;
    }

    public OrderStatusResponse(List<OrderPaymentMethod> list, Amount amount) {
        Intrinsics.checkNotNullParameter(list, PAYMENT_METHODS);
        Intrinsics.checkNotNullParameter(amount, REMAINING_AMOUNT);
        this.paymentMethods = list;
        this.remainingAmount = amount;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/adyen/checkout/components/model/connection/OrderStatusResponse$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/components/model/connection/OrderStatusResponse;", "PAYMENT_METHODS", "", "REMAINING_AMOUNT", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: OrderStatusResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<OrderStatusResponse> getSERIALIZER() {
            return OrderStatusResponse.SERIALIZER;
        }
    }
}
