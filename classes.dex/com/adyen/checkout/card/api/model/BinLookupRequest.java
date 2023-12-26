package com.adyen.checkout.card.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/adyen/checkout/card/api/model/BinLookupRequest;", "Lcom/adyen/checkout/core/model/ModelObject;", "encryptedBin", "", "requestId", "supportedBrands", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEncryptedBin", "()Ljava/lang/String;", "getRequestId", "getSupportedBrands", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BinLookupRequest.kt */
public final class BinLookupRequest extends ModelObject {
    public static final Parcelable.Creator<BinLookupRequest> CREATOR = new ModelObject.Creator(BinLookupRequest.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ENCRYPTED_BIN = "encryptedBin";
    private static final String REQUEST_ID = "requestId";
    /* access modifiers changed from: private */
    public static final ModelObject.Serializer<BinLookupRequest> SERIALIZER = new BinLookupRequest$Companion$SERIALIZER$1();
    private static final String SUPPORTED_BRANDS = "supportedBrands";
    private final String encryptedBin;
    private final String requestId;
    private final List<String> supportedBrands;

    public BinLookupRequest() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BinLookupRequest copy$default(BinLookupRequest binLookupRequest, String str, String str2, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = binLookupRequest.encryptedBin;
        }
        if ((i & 2) != 0) {
            str2 = binLookupRequest.requestId;
        }
        if ((i & 4) != 0) {
            list = binLookupRequest.supportedBrands;
        }
        return binLookupRequest.copy(str, str2, list);
    }

    public static final ModelObject.Serializer<BinLookupRequest> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final String component1() {
        return this.encryptedBin;
    }

    public final String component2() {
        return this.requestId;
    }

    public final List<String> component3() {
        return this.supportedBrands;
    }

    public final BinLookupRequest copy(String str, String str2, List<String> list) {
        return new BinLookupRequest(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinLookupRequest)) {
            return false;
        }
        BinLookupRequest binLookupRequest = (BinLookupRequest) obj;
        return Intrinsics.areEqual(this.encryptedBin, binLookupRequest.encryptedBin) && Intrinsics.areEqual(this.requestId, binLookupRequest.requestId) && Intrinsics.areEqual(this.supportedBrands, binLookupRequest.supportedBrands);
    }

    public int hashCode() {
        String str = this.encryptedBin;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.requestId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.supportedBrands;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BinLookupRequest(encryptedBin=" + this.encryptedBin + ", requestId=" + this.requestId + ", supportedBrands=" + this.supportedBrands + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BinLookupRequest(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    public final String getEncryptedBin() {
        return this.encryptedBin;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final List<String> getSupportedBrands() {
        return this.supportedBrands;
    }

    public BinLookupRequest(String str, String str2, List<String> list) {
        this.encryptedBin = str;
        this.requestId = str2;
        this.supportedBrands = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/adyen/checkout/card/api/model/BinLookupRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/card/api/model/BinLookupRequest;", "ENCRYPTED_BIN", "", "REQUEST_ID", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "SUPPORTED_BRANDS", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BinLookupRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<BinLookupRequest> getSERIALIZER() {
            return BinLookupRequest.SERIALIZER;
        }
    }
}
