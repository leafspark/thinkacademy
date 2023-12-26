package com.adyen.checkout.card;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J.\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/adyen/checkout/card/InstallmentModel;", "", "textResId", "", "value", "option", "Lcom/adyen/checkout/card/InstallmentOption;", "(ILjava/lang/Integer;Lcom/adyen/checkout/card/InstallmentOption;)V", "getOption", "()Lcom/adyen/checkout/card/InstallmentOption;", "getTextResId", "()I", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;Lcom/adyen/checkout/card/InstallmentOption;)Lcom/adyen/checkout/card/InstallmentModel;", "equals", "", "other", "hashCode", "toString", "", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallmentListAdapter.kt */
public final class InstallmentModel {
    private final InstallmentOption option;
    private final int textResId;
    private final Integer value;

    public static /* synthetic */ InstallmentModel copy$default(InstallmentModel installmentModel, int i, Integer num, InstallmentOption installmentOption, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = installmentModel.textResId;
        }
        if ((i2 & 2) != 0) {
            num = installmentModel.value;
        }
        if ((i2 & 4) != 0) {
            installmentOption = installmentModel.option;
        }
        return installmentModel.copy(i, num, installmentOption);
    }

    public final int component1() {
        return this.textResId;
    }

    public final Integer component2() {
        return this.value;
    }

    public final InstallmentOption component3() {
        return this.option;
    }

    public final InstallmentModel copy(int i, Integer num, InstallmentOption installmentOption) {
        Intrinsics.checkNotNullParameter(installmentOption, "option");
        return new InstallmentModel(i, num, installmentOption);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstallmentModel)) {
            return false;
        }
        InstallmentModel installmentModel = (InstallmentModel) obj;
        return this.textResId == installmentModel.textResId && Intrinsics.areEqual(this.value, installmentModel.value) && this.option == installmentModel.option;
    }

    public int hashCode() {
        int i = this.textResId * 31;
        Integer num = this.value;
        return ((i + (num == null ? 0 : num.hashCode())) * 31) + this.option.hashCode();
    }

    public String toString() {
        return "InstallmentModel(textResId=" + this.textResId + ", value=" + this.value + ", option=" + this.option + ')';
    }

    public InstallmentModel(int i, Integer num, InstallmentOption installmentOption) {
        Intrinsics.checkNotNullParameter(installmentOption, "option");
        this.textResId = i;
        this.value = num;
        this.option = installmentOption;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public final Integer getValue() {
        return this.value;
    }

    public final InstallmentOption getOption() {
        return this.option;
    }
}
