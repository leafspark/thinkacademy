package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/adyen/checkout/components/model/payments/request/Installments;", "Lcom/adyen/checkout/core/model/ModelObject;", "plan", "", "value", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getPlan", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/adyen/checkout/components/model/payments/request/Installments;", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Installments.kt */
public final class Installments extends ModelObject {
    public static final Parcelable.Creator<Installments> CREATOR = new ModelObject.Creator(Installments.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PLAN = "plan";
    public static final ModelObject.Serializer<Installments> SERIALIZER = new Installments$Companion$SERIALIZER$1();
    private static final String VALUE = "value";
    private final String plan;
    private final Integer value;

    public static /* synthetic */ Installments copy$default(Installments installments, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = installments.plan;
        }
        if ((i & 2) != 0) {
            num = installments.value;
        }
        return installments.copy(str, num);
    }

    public final String component1() {
        return this.plan;
    }

    public final Integer component2() {
        return this.value;
    }

    public final Installments copy(String str, Integer num) {
        return new Installments(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Installments)) {
            return false;
        }
        Installments installments = (Installments) obj;
        return Intrinsics.areEqual(this.plan, installments.plan) && Intrinsics.areEqual(this.value, installments.value);
    }

    public int hashCode() {
        String str = this.plan;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.value;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Installments(plan=" + this.plan + ", value=" + this.value + ')';
    }

    public final String getPlan() {
        return this.plan;
    }

    public final Integer getValue() {
        return this.value;
    }

    public Installments(String str, Integer num) {
        this.plan = str;
        this.value = num;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/adyen/checkout/components/model/payments/request/Installments$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/components/model/payments/request/Installments;", "PLAN", "", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "VALUE", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Installments.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
