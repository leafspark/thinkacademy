package com.adyen.checkout.components.model.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006!"}, d2 = {"Lcom/adyen/checkout/components/model/connection/OrderPaymentMethod;", "Lcom/adyen/checkout/core/model/ModelObject;", "type", "", "amount", "Lcom/adyen/checkout/components/model/payments/Amount;", "lastFour", "transactionLimit", "(Ljava/lang/String;Lcom/adyen/checkout/components/model/payments/Amount;Ljava/lang/String;Lcom/adyen/checkout/components/model/payments/Amount;)V", "getAmount", "()Lcom/adyen/checkout/components/model/payments/Amount;", "getLastFour", "()Ljava/lang/String;", "getTransactionLimit", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderPaymentMethod.kt */
public final class OrderPaymentMethod extends ModelObject {
    private static final String AMOUNT = "amount";
    public static final Parcelable.Creator<OrderPaymentMethod> CREATOR = new ModelObject.Creator(OrderPaymentMethod.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LAST_FOUR = "lastFour";
    /* access modifiers changed from: private */
    public static final ModelObject.Serializer<OrderPaymentMethod> SERIALIZER = new OrderPaymentMethod$Companion$SERIALIZER$1();
    private static final String TRANSACTION_LIMIT = "transactionLimit";
    private static final String TYPE = "type";
    private final Amount amount;
    private final String lastFour;
    private final Amount transactionLimit;
    private final String type;

    public static /* synthetic */ OrderPaymentMethod copy$default(OrderPaymentMethod orderPaymentMethod, String str, Amount amount2, String str2, Amount amount3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderPaymentMethod.type;
        }
        if ((i & 2) != 0) {
            amount2 = orderPaymentMethod.amount;
        }
        if ((i & 4) != 0) {
            str2 = orderPaymentMethod.lastFour;
        }
        if ((i & 8) != 0) {
            amount3 = orderPaymentMethod.transactionLimit;
        }
        return orderPaymentMethod.copy(str, amount2, str2, amount3);
    }

    public static final ModelObject.Serializer<OrderPaymentMethod> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final String component1() {
        return this.type;
    }

    public final Amount component2() {
        return this.amount;
    }

    public final String component3() {
        return this.lastFour;
    }

    public final Amount component4() {
        return this.transactionLimit;
    }

    public final OrderPaymentMethod copy(String str, Amount amount2, String str2, Amount amount3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(amount2, AMOUNT);
        Intrinsics.checkNotNullParameter(str2, LAST_FOUR);
        return new OrderPaymentMethod(str, amount2, str2, amount3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderPaymentMethod)) {
            return false;
        }
        OrderPaymentMethod orderPaymentMethod = (OrderPaymentMethod) obj;
        return Intrinsics.areEqual(this.type, orderPaymentMethod.type) && Intrinsics.areEqual(this.amount, orderPaymentMethod.amount) && Intrinsics.areEqual(this.lastFour, orderPaymentMethod.lastFour) && Intrinsics.areEqual(this.transactionLimit, orderPaymentMethod.transactionLimit);
    }

    public int hashCode() {
        int hashCode = ((((this.type.hashCode() * 31) + this.amount.hashCode()) * 31) + this.lastFour.hashCode()) * 31;
        Amount amount2 = this.transactionLimit;
        return hashCode + (amount2 == null ? 0 : amount2.hashCode());
    }

    public String toString() {
        return "OrderPaymentMethod(type=" + this.type + ", amount=" + this.amount + ", lastFour=" + this.lastFour + ", transactionLimit=" + this.transactionLimit + ')';
    }

    public final String getType() {
        return this.type;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final String getLastFour() {
        return this.lastFour;
    }

    public final Amount getTransactionLimit() {
        return this.transactionLimit;
    }

    public OrderPaymentMethod(String str, Amount amount2, String str2, Amount amount3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(amount2, AMOUNT);
        Intrinsics.checkNotNullParameter(str2, LAST_FOUR);
        this.type = str;
        this.amount = amount2;
        this.lastFour = str2;
        this.transactionLimit = amount3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/adyen/checkout/components/model/connection/OrderPaymentMethod$Companion;", "", "()V", "AMOUNT", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/components/model/connection/OrderPaymentMethod;", "LAST_FOUR", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "TRANSACTION_LIMIT", "TYPE", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: OrderPaymentMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<OrderPaymentMethod> getSERIALIZER() {
            return OrderPaymentMethod.SERIALIZER;
        }
    }
}
