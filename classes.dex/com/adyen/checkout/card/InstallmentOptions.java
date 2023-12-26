package com.adyen.checkout.card;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.core.util.ParcelUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00122\u00020\u0001:\u0003\u0011\u0012\u0013B\u001d\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/adyen/checkout/card/InstallmentOptions;", "Landroid/os/Parcelable;", "values", "", "", "includeRevolving", "", "(Ljava/util/List;Z)V", "getIncludeRevolving", "()Z", "getValues", "()Ljava/util/List;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CardBasedInstallmentOptions", "Companion", "DefaultInstallmentOptions", "Lcom/adyen/checkout/card/InstallmentOptions$CardBasedInstallmentOptions;", "Lcom/adyen/checkout/card/InstallmentOptions$DefaultInstallmentOptions;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallmentConfiguration.kt */
public abstract class InstallmentOptions implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int STARTING_INSTALLMENT_VALUE = 2;
    private final boolean includeRevolving;
    private final List<Integer> values;

    public /* synthetic */ InstallmentOptions(List list, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z);
    }

    private InstallmentOptions(List<Integer> list, boolean z) {
        this.values = list;
        this.includeRevolving = z;
    }

    public List<Integer> getValues() {
        return this.values;
    }

    public boolean getIncludeRevolving() {
        return this.includeRevolving;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adyen/checkout/card/InstallmentOptions$Companion;", "", "()V", "STARTING_INSTALLMENT_VALUE", "", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstallmentConfiguration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0012\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB#\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/adyen/checkout/card/InstallmentOptions$CardBasedInstallmentOptions;", "Lcom/adyen/checkout/card/InstallmentOptions;", "maxInstallments", "", "includeRevolving", "", "cardType", "Lcom/adyen/checkout/card/data/CardType;", "(IZLcom/adyen/checkout/card/data/CardType;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "values", "", "(Ljava/util/List;ZLcom/adyen/checkout/card/data/CardType;)V", "getCardType", "()Lcom/adyen/checkout/card/data/CardType;", "getIncludeRevolving", "()Z", "getValues", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "flags", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstallmentConfiguration.kt */
    public static final class CardBasedInstallmentOptions extends InstallmentOptions {
        public static final Parcelable.Creator<CardBasedInstallmentOptions> CREATOR = new InstallmentOptions$CardBasedInstallmentOptions$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final CardType cardType;
        private final boolean includeRevolving;
        private final List<Integer> values;

        public /* synthetic */ CardBasedInstallmentOptions(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public static /* synthetic */ CardBasedInstallmentOptions copy$default(CardBasedInstallmentOptions cardBasedInstallmentOptions, List<Integer> list, boolean z, CardType cardType2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = cardBasedInstallmentOptions.getValues();
            }
            if ((i & 2) != 0) {
                z = cardBasedInstallmentOptions.getIncludeRevolving();
            }
            if ((i & 4) != 0) {
                cardType2 = cardBasedInstallmentOptions.cardType;
            }
            return cardBasedInstallmentOptions.copy(list, z, cardType2);
        }

        public final List<Integer> component1() {
            return getValues();
        }

        public final boolean component2() {
            return getIncludeRevolving();
        }

        public final CardType component3() {
            return this.cardType;
        }

        public final CardBasedInstallmentOptions copy(List<Integer> list, boolean z, CardType cardType2) {
            Intrinsics.checkNotNullParameter(list, "values");
            Intrinsics.checkNotNullParameter(cardType2, "cardType");
            return new CardBasedInstallmentOptions(list, z, cardType2);
        }

        public int describeContents() {
            return 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CardBasedInstallmentOptions)) {
                return false;
            }
            CardBasedInstallmentOptions cardBasedInstallmentOptions = (CardBasedInstallmentOptions) obj;
            return Intrinsics.areEqual(getValues(), cardBasedInstallmentOptions.getValues()) && getIncludeRevolving() == cardBasedInstallmentOptions.getIncludeRevolving() && this.cardType == cardBasedInstallmentOptions.cardType;
        }

        public int hashCode() {
            int hashCode = getValues().hashCode() * 31;
            boolean includeRevolving2 = getIncludeRevolving();
            if (includeRevolving2) {
                includeRevolving2 = true;
            }
            return ((hashCode + (includeRevolving2 ? 1 : 0)) * 31) + this.cardType.hashCode();
        }

        public String toString() {
            return "CardBasedInstallmentOptions(values=" + getValues() + ", includeRevolving=" + getIncludeRevolving() + ", cardType=" + this.cardType + ')';
        }

        public List<Integer> getValues() {
            return this.values;
        }

        public boolean getIncludeRevolving() {
            return this.includeRevolving;
        }

        public final CardType getCardType() {
            return this.cardType;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CardBasedInstallmentOptions(List<Integer> list, boolean z, CardType cardType2) {
            super(list, z, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "values");
            Intrinsics.checkNotNullParameter(cardType2, "cardType");
            this.values = list;
            this.includeRevolving = z;
            this.cardType = cardType2;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/adyen/checkout/card/InstallmentOptions$CardBasedInstallmentOptions$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/card/InstallmentOptions$CardBasedInstallmentOptions;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: InstallmentConfiguration.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public CardBasedInstallmentOptions(int i, boolean z, CardType cardType2) {
            this((List<Integer>) CollectionsKt.toList(new IntRange(2, i)), z, cardType2);
            Intrinsics.checkNotNullParameter(cardType2, "cardType");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private CardBasedInstallmentOptions(android.os.Parcel r4) {
            /*
                r3 = this;
                java.lang.Class r0 = java.lang.Integer.TYPE
                java.lang.ClassLoader r0 = r0.getClassLoader()
                java.util.ArrayList r0 = r4.readArrayList(r0)
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>"
                java.util.Objects.requireNonNull(r0, r1)
                java.util.List r0 = (java.util.List) r0
                boolean r1 = com.adyen.checkout.core.util.ParcelUtils.readBoolean(r4)
                java.io.Serializable r4 = r4.readSerializable()
                java.lang.String r2 = "null cannot be cast to non-null type com.adyen.checkout.card.data.CardType"
                java.util.Objects.requireNonNull(r4, r2)
                com.adyen.checkout.card.data.CardType r4 = (com.adyen.checkout.card.data.CardType) r4
                r3.<init>((java.util.List<java.lang.Integer>) r0, (boolean) r1, (com.adyen.checkout.card.data.CardType) r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.InstallmentOptions.CardBasedInstallmentOptions.<init>(android.os.Parcel):void");
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            InstallmentOptions.super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.cardType);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/adyen/checkout/card/InstallmentOptions$DefaultInstallmentOptions;", "Lcom/adyen/checkout/card/InstallmentOptions;", "maxInstallments", "", "includeRevolving", "", "(IZ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "values", "", "(Ljava/util/List;Z)V", "getIncludeRevolving", "()Z", "getValues", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "flags", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstallmentConfiguration.kt */
    public static final class DefaultInstallmentOptions extends InstallmentOptions {
        public static final Parcelable.Creator<DefaultInstallmentOptions> CREATOR = new InstallmentOptions$DefaultInstallmentOptions$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean includeRevolving;
        private final List<Integer> values;

        public /* synthetic */ DefaultInstallmentOptions(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public static /* synthetic */ DefaultInstallmentOptions copy$default(DefaultInstallmentOptions defaultInstallmentOptions, List<Integer> list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = defaultInstallmentOptions.getValues();
            }
            if ((i & 2) != 0) {
                z = defaultInstallmentOptions.getIncludeRevolving();
            }
            return defaultInstallmentOptions.copy(list, z);
        }

        public final List<Integer> component1() {
            return getValues();
        }

        public final boolean component2() {
            return getIncludeRevolving();
        }

        public final DefaultInstallmentOptions copy(List<Integer> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "values");
            return new DefaultInstallmentOptions(list, z);
        }

        public int describeContents() {
            return 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DefaultInstallmentOptions)) {
                return false;
            }
            DefaultInstallmentOptions defaultInstallmentOptions = (DefaultInstallmentOptions) obj;
            return Intrinsics.areEqual(getValues(), defaultInstallmentOptions.getValues()) && getIncludeRevolving() == defaultInstallmentOptions.getIncludeRevolving();
        }

        public int hashCode() {
            int hashCode = getValues().hashCode() * 31;
            boolean includeRevolving2 = getIncludeRevolving();
            if (includeRevolving2) {
                includeRevolving2 = true;
            }
            return hashCode + (includeRevolving2 ? 1 : 0);
        }

        public String toString() {
            return "DefaultInstallmentOptions(values=" + getValues() + ", includeRevolving=" + getIncludeRevolving() + ')';
        }

        public List<Integer> getValues() {
            return this.values;
        }

        public boolean getIncludeRevolving() {
            return this.includeRevolving;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DefaultInstallmentOptions(List<Integer> list, boolean z) {
            super(list, z, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "values");
            this.values = list;
            this.includeRevolving = z;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/adyen/checkout/card/InstallmentOptions$DefaultInstallmentOptions$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/card/InstallmentOptions$DefaultInstallmentOptions;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: InstallmentConfiguration.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public DefaultInstallmentOptions(int i, boolean z) {
            this((List<Integer>) CollectionsKt.toList(new IntRange(2, i)), z);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private DefaultInstallmentOptions(android.os.Parcel r3) {
            /*
                r2 = this;
                java.lang.Class r0 = java.lang.Integer.TYPE
                java.lang.ClassLoader r0 = r0.getClassLoader()
                java.util.ArrayList r0 = r3.readArrayList(r0)
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>"
                java.util.Objects.requireNonNull(r0, r1)
                java.util.List r0 = (java.util.List) r0
                boolean r3 = com.adyen.checkout.core.util.ParcelUtils.readBoolean(r3)
                r2.<init>((java.util.List<java.lang.Integer>) r0, (boolean) r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.InstallmentOptions.DefaultInstallmentOptions.<init>(android.os.Parcel):void");
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            InstallmentOptions.super.writeToParcel(parcel, i);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeList(getValues());
        ParcelUtils.writeBoolean(parcel, getIncludeRevolving());
    }
}
