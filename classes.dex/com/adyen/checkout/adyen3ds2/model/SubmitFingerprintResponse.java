package com.adyen.checkout.adyen3ds2.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintResponse;", "Lcom/adyen/checkout/core/model/ModelObject;", "action", "Lcom/adyen/checkout/components/model/payments/response/Action;", "type", "", "details", "(Lcom/adyen/checkout/components/model/payments/response/Action;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Lcom/adyen/checkout/components/model/payments/response/Action;", "getDetails", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SubmitFingerprintResponse.kt */
public final class SubmitFingerprintResponse extends ModelObject {
    private static final String ACTION = "action";
    public static final Parcelable.Creator<SubmitFingerprintResponse> CREATOR = new ModelObject.Creator(SubmitFingerprintResponse.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DETAILS = "details";
    /* access modifiers changed from: private */
    public static final ModelObject.Serializer<SubmitFingerprintResponse> SERIALIZER = new SubmitFingerprintResponse$Companion$SERIALIZER$1();
    private static final String TYPE = "type";
    private final Action action;
    private final String details;
    private final String type;

    public static /* synthetic */ SubmitFingerprintResponse copy$default(SubmitFingerprintResponse submitFingerprintResponse, Action action2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            action2 = submitFingerprintResponse.action;
        }
        if ((i & 2) != 0) {
            str = submitFingerprintResponse.type;
        }
        if ((i & 4) != 0) {
            str2 = submitFingerprintResponse.details;
        }
        return submitFingerprintResponse.copy(action2, str, str2);
    }

    public static final ModelObject.Serializer<SubmitFingerprintResponse> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final Action component1() {
        return this.action;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.details;
    }

    public final SubmitFingerprintResponse copy(Action action2, String str, String str2) {
        return new SubmitFingerprintResponse(action2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitFingerprintResponse)) {
            return false;
        }
        SubmitFingerprintResponse submitFingerprintResponse = (SubmitFingerprintResponse) obj;
        return Intrinsics.areEqual(this.action, submitFingerprintResponse.action) && Intrinsics.areEqual(this.type, submitFingerprintResponse.type) && Intrinsics.areEqual(this.details, submitFingerprintResponse.details);
    }

    public int hashCode() {
        Action action2 = this.action;
        int i = 0;
        int hashCode = (action2 == null ? 0 : action2.hashCode()) * 31;
        String str = this.type;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.details;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SubmitFingerprintResponse(action=" + this.action + ", type=" + this.type + ", details=" + this.details + ')';
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDetails() {
        return this.details;
    }

    public SubmitFingerprintResponse(Action action2, String str, String str2) {
        this.action = action2;
        this.type = str;
        this.details = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintResponse$Companion;", "", "()V", "ACTION", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintResponse;", "DETAILS", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "TYPE", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SubmitFingerprintResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<SubmitFingerprintResponse> getSERIALIZER() {
            return SubmitFingerprintResponse.SERIALIZER;
        }
    }
}
