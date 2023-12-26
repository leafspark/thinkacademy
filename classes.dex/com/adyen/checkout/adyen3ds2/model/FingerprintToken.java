package com.adyen.checkout.adyen3ds2.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/model/FingerprintToken;", "Lcom/adyen/checkout/core/model/ModelObject;", "directoryServerId", "", "directoryServerPublicKey", "threeDSServerTransID", "threeDSMessageVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDirectoryServerId", "()Ljava/lang/String;", "getDirectoryServerPublicKey", "getThreeDSMessageVersion", "getThreeDSServerTransID", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FingerprintToken.kt */
public final class FingerprintToken extends ModelObject {
    public static final Parcelable.Creator<FingerprintToken> CREATOR = new ModelObject.Creator(FingerprintToken.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DIRECTORY_SERVER_ID = "directoryServerId";
    private static final String DIRECTORY_SERVER_PUBLIC_KEY = "directoryServerPublicKey";
    public static final ModelObject.Serializer<FingerprintToken> SERIALIZER = new FingerprintToken$Companion$SERIALIZER$1();
    private static final String THREEDS_MESSAGE_VERSION = "threeDSMessageVersion";
    private static final String THREEDS_SERVER_TRANS_ID = "threeDSServerTransID";
    private final String directoryServerId;
    private final String directoryServerPublicKey;
    private final String threeDSMessageVersion;
    private final String threeDSServerTransID;

    public FingerprintToken() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FingerprintToken copy$default(FingerprintToken fingerprintToken, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fingerprintToken.directoryServerId;
        }
        if ((i & 2) != 0) {
            str2 = fingerprintToken.directoryServerPublicKey;
        }
        if ((i & 4) != 0) {
            str3 = fingerprintToken.threeDSServerTransID;
        }
        if ((i & 8) != 0) {
            str4 = fingerprintToken.threeDSMessageVersion;
        }
        return fingerprintToken.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.directoryServerId;
    }

    public final String component2() {
        return this.directoryServerPublicKey;
    }

    public final String component3() {
        return this.threeDSServerTransID;
    }

    public final String component4() {
        return this.threeDSMessageVersion;
    }

    public final FingerprintToken copy(String str, String str2, String str3, String str4) {
        return new FingerprintToken(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FingerprintToken)) {
            return false;
        }
        FingerprintToken fingerprintToken = (FingerprintToken) obj;
        return Intrinsics.areEqual(this.directoryServerId, fingerprintToken.directoryServerId) && Intrinsics.areEqual(this.directoryServerPublicKey, fingerprintToken.directoryServerPublicKey) && Intrinsics.areEqual(this.threeDSServerTransID, fingerprintToken.threeDSServerTransID) && Intrinsics.areEqual(this.threeDSMessageVersion, fingerprintToken.threeDSMessageVersion);
    }

    public int hashCode() {
        String str = this.directoryServerId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.directoryServerPublicKey;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.threeDSServerTransID;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.threeDSMessageVersion;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "FingerprintToken(directoryServerId=" + this.directoryServerId + ", directoryServerPublicKey=" + this.directoryServerPublicKey + ", threeDSServerTransID=" + this.threeDSServerTransID + ", threeDSMessageVersion=" + this.threeDSMessageVersion + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FingerprintToken(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getDirectoryServerId() {
        return this.directoryServerId;
    }

    public final String getDirectoryServerPublicKey() {
        return this.directoryServerPublicKey;
    }

    public final String getThreeDSServerTransID() {
        return this.threeDSServerTransID;
    }

    public final String getThreeDSMessageVersion() {
        return this.threeDSMessageVersion;
    }

    public FingerprintToken(String str, String str2, String str3, String str4) {
        this.directoryServerId = str;
        this.directoryServerPublicKey = str2;
        this.threeDSServerTransID = str3;
        this.threeDSMessageVersion = str4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/model/FingerprintToken$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/adyen3ds2/model/FingerprintToken;", "DIRECTORY_SERVER_ID", "", "DIRECTORY_SERVER_PUBLIC_KEY", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "THREEDS_MESSAGE_VERSION", "THREEDS_SERVER_TRANS_ID", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FingerprintToken.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
