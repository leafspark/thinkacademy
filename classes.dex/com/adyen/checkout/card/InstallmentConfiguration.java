package com.adyen.checkout.card;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.card.InstallmentOptions;
import com.adyen.checkout.core.exception.CheckoutException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0013H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/adyen/checkout/card/InstallmentConfiguration;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "defaultOptions", "Lcom/adyen/checkout/card/InstallmentOptions$DefaultInstallmentOptions;", "cardBasedOptions", "", "Lcom/adyen/checkout/card/InstallmentOptions$CardBasedInstallmentOptions;", "(Lcom/adyen/checkout/card/InstallmentOptions$DefaultInstallmentOptions;Ljava/util/List;)V", "getCardBasedOptions", "()Ljava/util/List;", "getDefaultOptions", "()Lcom/adyen/checkout/card/InstallmentOptions$DefaultInstallmentOptions;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "flags", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallmentConfiguration.kt */
public final class InstallmentConfiguration implements Parcelable {
    public static final Parcelable.Creator<InstallmentConfiguration> CREATOR = new InstallmentConfiguration$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<InstallmentOptions.CardBasedInstallmentOptions> cardBasedOptions;
    private final InstallmentOptions.DefaultInstallmentOptions defaultOptions;

    public InstallmentConfiguration() {
        this((InstallmentOptions.DefaultInstallmentOptions) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ InstallmentConfiguration(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public static /* synthetic */ InstallmentConfiguration copy$default(InstallmentConfiguration installmentConfiguration, InstallmentOptions.DefaultInstallmentOptions defaultInstallmentOptions, List<InstallmentOptions.CardBasedInstallmentOptions> list, int i, Object obj) {
        if ((i & 1) != 0) {
            defaultInstallmentOptions = installmentConfiguration.defaultOptions;
        }
        if ((i & 2) != 0) {
            list = installmentConfiguration.cardBasedOptions;
        }
        return installmentConfiguration.copy(defaultInstallmentOptions, list);
    }

    public final InstallmentOptions.DefaultInstallmentOptions component1() {
        return this.defaultOptions;
    }

    public final List<InstallmentOptions.CardBasedInstallmentOptions> component2() {
        return this.cardBasedOptions;
    }

    public final InstallmentConfiguration copy(InstallmentOptions.DefaultInstallmentOptions defaultInstallmentOptions, List<InstallmentOptions.CardBasedInstallmentOptions> list) {
        Intrinsics.checkNotNullParameter(list, "cardBasedOptions");
        return new InstallmentConfiguration(defaultInstallmentOptions, list);
    }

    public int describeContents() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstallmentConfiguration)) {
            return false;
        }
        InstallmentConfiguration installmentConfiguration = (InstallmentConfiguration) obj;
        return Intrinsics.areEqual(this.defaultOptions, installmentConfiguration.defaultOptions) && Intrinsics.areEqual(this.cardBasedOptions, installmentConfiguration.cardBasedOptions);
    }

    public int hashCode() {
        InstallmentOptions.DefaultInstallmentOptions defaultInstallmentOptions = this.defaultOptions;
        return ((defaultInstallmentOptions == null ? 0 : defaultInstallmentOptions.hashCode()) * 31) + this.cardBasedOptions.hashCode();
    }

    public String toString() {
        return "InstallmentConfiguration(defaultOptions=" + this.defaultOptions + ", cardBasedOptions=" + this.cardBasedOptions + ')';
    }

    public InstallmentConfiguration(InstallmentOptions.DefaultInstallmentOptions defaultInstallmentOptions, List<InstallmentOptions.CardBasedInstallmentOptions> list) {
        Intrinsics.checkNotNullParameter(list, "cardBasedOptions");
        this.defaultOptions = defaultInstallmentOptions;
        this.cardBasedOptions = list;
        if (!InstallmentUtils.INSTANCE.isCardBasedOptionsValid(list)) {
            throw new CheckoutException("Installment Configuration has multiple rules for same card type.");
        } else if (!InstallmentUtils.INSTANCE.areInstallmentValuesValid(this)) {
            throw new CheckoutException("Installment Configuration contains invalid values for options. Values must be greater than 1.");
        }
    }

    public final InstallmentOptions.DefaultInstallmentOptions getDefaultOptions() {
        return this.defaultOptions;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InstallmentConfiguration(InstallmentOptions.DefaultInstallmentOptions defaultInstallmentOptions, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : defaultInstallmentOptions, (List<InstallmentOptions.CardBasedInstallmentOptions>) (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<InstallmentOptions.CardBasedInstallmentOptions> getCardBasedOptions() {
        return this.cardBasedOptions;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private InstallmentConfiguration(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.Class<com.adyen.checkout.card.InstallmentOptions$DefaultInstallmentOptions> r0 = com.adyen.checkout.card.InstallmentOptions.DefaultInstallmentOptions.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r3.readParcelable(r0)
            com.adyen.checkout.card.InstallmentOptions$DefaultInstallmentOptions r0 = (com.adyen.checkout.card.InstallmentOptions.DefaultInstallmentOptions) r0
            java.lang.Class<com.adyen.checkout.card.InstallmentOptions$CardBasedInstallmentOptions> r1 = com.adyen.checkout.card.InstallmentOptions.CardBasedInstallmentOptions.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.util.ArrayList r3 = r3.readArrayList(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.List<com.adyen.checkout.card.InstallmentOptions.CardBasedInstallmentOptions>"
            java.util.Objects.requireNonNull(r3, r1)
            java.util.List r3 = (java.util.List) r3
            r2.<init>((com.adyen.checkout.card.InstallmentOptions.DefaultInstallmentOptions) r0, (java.util.List<com.adyen.checkout.card.InstallmentOptions.CardBasedInstallmentOptions>) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.InstallmentConfiguration.<init>(android.os.Parcel):void");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/adyen/checkout/card/InstallmentConfiguration$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/card/InstallmentConfiguration;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstallmentConfiguration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.defaultOptions, i);
        parcel.writeList(this.cardBasedOptions);
    }
}
