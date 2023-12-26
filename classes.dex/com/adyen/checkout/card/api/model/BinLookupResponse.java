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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/adyen/checkout/card/api/model/BinLookupResponse;", "Lcom/adyen/checkout/core/model/ModelObject;", "brands", "", "Lcom/adyen/checkout/card/api/model/Brand;", "issuingCountryCode", "", "requestId", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getBrands", "()Ljava/util/List;", "getIssuingCountryCode", "()Ljava/lang/String;", "getRequestId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BinLookupResponse.kt */
public final class BinLookupResponse extends ModelObject {
    private static final String BRANDS = "brands";
    public static final Parcelable.Creator<BinLookupResponse> CREATOR = new ModelObject.Creator(BinLookupResponse.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ISSUING_COUNTRY_CODE = "issuingCountryCode";
    private static final String REQUEST_ID = "requestId";
    /* access modifiers changed from: private */
    public static final ModelObject.Serializer<BinLookupResponse> SERIALIZER = new BinLookupResponse$Companion$SERIALIZER$1();
    private final List<Brand> brands;
    private final String issuingCountryCode;
    private final String requestId;

    public BinLookupResponse() {
        this((List) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BinLookupResponse copy$default(BinLookupResponse binLookupResponse, List<Brand> list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = binLookupResponse.brands;
        }
        if ((i & 2) != 0) {
            str = binLookupResponse.issuingCountryCode;
        }
        if ((i & 4) != 0) {
            str2 = binLookupResponse.requestId;
        }
        return binLookupResponse.copy(list, str, str2);
    }

    public static final ModelObject.Serializer<BinLookupResponse> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final List<Brand> component1() {
        return this.brands;
    }

    public final String component2() {
        return this.issuingCountryCode;
    }

    public final String component3() {
        return this.requestId;
    }

    public final BinLookupResponse copy(List<Brand> list, String str, String str2) {
        return new BinLookupResponse(list, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinLookupResponse)) {
            return false;
        }
        BinLookupResponse binLookupResponse = (BinLookupResponse) obj;
        return Intrinsics.areEqual(this.brands, binLookupResponse.brands) && Intrinsics.areEqual(this.issuingCountryCode, binLookupResponse.issuingCountryCode) && Intrinsics.areEqual(this.requestId, binLookupResponse.requestId);
    }

    public int hashCode() {
        List<Brand> list = this.brands;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.issuingCountryCode;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.requestId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BinLookupResponse(brands=" + this.brands + ", issuingCountryCode=" + this.issuingCountryCode + ", requestId=" + this.requestId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BinLookupResponse(List list, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final List<Brand> getBrands() {
        return this.brands;
    }

    public final String getIssuingCountryCode() {
        return this.issuingCountryCode;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public BinLookupResponse(List<Brand> list, String str, String str2) {
        this.brands = list;
        this.issuingCountryCode = str;
        this.requestId = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/adyen/checkout/card/api/model/BinLookupResponse$Companion;", "", "()V", "BRANDS", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/card/api/model/BinLookupResponse;", "ISSUING_COUNTRY_CODE", "REQUEST_ID", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BinLookupResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<BinLookupResponse> getSERIALIZER() {
            return BinLookupResponse.SERIALIZER;
        }
    }
}
