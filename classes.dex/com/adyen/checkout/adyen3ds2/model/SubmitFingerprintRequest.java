package com.adyen.checkout.adyen3ds2.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintRequest;", "Lcom/adyen/checkout/core/model/ModelObject;", "encodedFingerprint", "", "paymentData", "(Ljava/lang/String;Ljava/lang/String;)V", "getEncodedFingerprint", "()Ljava/lang/String;", "getPaymentData", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SubmitFingerprintRequest.kt */
public final class SubmitFingerprintRequest extends ModelObject {
    public static final Parcelable.Creator<SubmitFingerprintRequest> CREATOR = new ModelObject.Creator(SubmitFingerprintRequest.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FINGERPRINT = "fingerprintResult";
    private static final String PAYMENT_DATA = "paymentData";
    /* access modifiers changed from: private */
    public static final ModelObject.Serializer<SubmitFingerprintRequest> SERIALIZER = new SubmitFingerprintRequest$Companion$SERIALIZER$1();
    private final String encodedFingerprint;
    private final String paymentData;

    public static /* synthetic */ SubmitFingerprintRequest copy$default(SubmitFingerprintRequest submitFingerprintRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitFingerprintRequest.encodedFingerprint;
        }
        if ((i & 2) != 0) {
            str2 = submitFingerprintRequest.paymentData;
        }
        return submitFingerprintRequest.copy(str, str2);
    }

    public static final ModelObject.Serializer<SubmitFingerprintRequest> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final String component1() {
        return this.encodedFingerprint;
    }

    public final String component2() {
        return this.paymentData;
    }

    public final SubmitFingerprintRequest copy(String str, String str2) {
        return new SubmitFingerprintRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitFingerprintRequest)) {
            return false;
        }
        SubmitFingerprintRequest submitFingerprintRequest = (SubmitFingerprintRequest) obj;
        return Intrinsics.areEqual(this.encodedFingerprint, submitFingerprintRequest.encodedFingerprint) && Intrinsics.areEqual(this.paymentData, submitFingerprintRequest.paymentData);
    }

    public int hashCode() {
        String str = this.encodedFingerprint;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.paymentData;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SubmitFingerprintRequest(encodedFingerprint=" + this.encodedFingerprint + ", paymentData=" + this.paymentData + ')';
    }

    public final String getEncodedFingerprint() {
        return this.encodedFingerprint;
    }

    public final String getPaymentData() {
        return this.paymentData;
    }

    public SubmitFingerprintRequest(String str, String str2) {
        this.encodedFingerprint = str;
        this.paymentData = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintRequest;", "FINGERPRINT", "", "PAYMENT_DATA", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SubmitFingerprintRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<SubmitFingerprintRequest> getSERIALIZER() {
            return SubmitFingerprintRequest.SERIALIZER;
        }
    }
}
