package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/adyen/checkout/components/model/payments/response/BalanceResult;", "Lcom/adyen/checkout/core/model/ModelObject;", "balance", "Lcom/adyen/checkout/components/model/payments/Amount;", "transactionLimit", "(Lcom/adyen/checkout/components/model/payments/Amount;Lcom/adyen/checkout/components/model/payments/Amount;)V", "getBalance", "()Lcom/adyen/checkout/components/model/payments/Amount;", "getTransactionLimit", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BalanceResult.kt */
public final class BalanceResult extends ModelObject {
    private static final String BALANCE = "balance";
    public static final ModelObject.Creator<BalanceResult> CREATOR = new ModelObject.Creator<>(BalanceResult.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ModelObject.Serializer<BalanceResult> SERIALIZER = new BalanceResult$Companion$SERIALIZER$1();
    private static final String TRANSACTION_LIMIT = "transactionLimit";
    private final Amount balance;
    private final Amount transactionLimit;

    public static /* synthetic */ BalanceResult copy$default(BalanceResult balanceResult, Amount amount, Amount amount2, int i, Object obj) {
        if ((i & 1) != 0) {
            amount = balanceResult.balance;
        }
        if ((i & 2) != 0) {
            amount2 = balanceResult.transactionLimit;
        }
        return balanceResult.copy(amount, amount2);
    }

    public final Amount component1() {
        return this.balance;
    }

    public final Amount component2() {
        return this.transactionLimit;
    }

    public final BalanceResult copy(Amount amount, Amount amount2) {
        Intrinsics.checkNotNullParameter(amount, BALANCE);
        return new BalanceResult(amount, amount2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BalanceResult)) {
            return false;
        }
        BalanceResult balanceResult = (BalanceResult) obj;
        return Intrinsics.areEqual(this.balance, balanceResult.balance) && Intrinsics.areEqual(this.transactionLimit, balanceResult.transactionLimit);
    }

    public int hashCode() {
        int hashCode = this.balance.hashCode() * 31;
        Amount amount = this.transactionLimit;
        return hashCode + (amount == null ? 0 : amount.hashCode());
    }

    public String toString() {
        return "BalanceResult(balance=" + this.balance + ", transactionLimit=" + this.transactionLimit + ')';
    }

    public final Amount getBalance() {
        return this.balance;
    }

    public final Amount getTransactionLimit() {
        return this.transactionLimit;
    }

    public BalanceResult(Amount amount, Amount amount2) {
        Intrinsics.checkNotNullParameter(amount, BALANCE);
        this.balance = amount;
        this.transactionLimit = amount2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/adyen/checkout/components/model/payments/response/BalanceResult$Companion;", "", "()V", "BALANCE", "", "CREATOR", "Lcom/adyen/checkout/core/model/ModelObject$Creator;", "Lcom/adyen/checkout/components/model/payments/response/BalanceResult;", "kotlin.jvm.PlatformType", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "TRANSACTION_LIMIT", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BalanceResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
