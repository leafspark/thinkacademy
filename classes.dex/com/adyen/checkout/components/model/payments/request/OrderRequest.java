package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/adyen/checkout/components/model/payments/request/OrderRequest;", "Lcom/adyen/checkout/core/model/ModelObject;", "pspReference", "", "orderData", "(Ljava/lang/String;Ljava/lang/String;)V", "getOrderData", "()Ljava/lang/String;", "getPspReference", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderRequest.kt */
public final class OrderRequest extends ModelObject {
    public static final ModelObject.Creator<OrderRequest> CREATOR = new ModelObject.Creator<>(OrderRequest.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ORDER_DATA = "orderData";
    private static final String PSP_REFERENCE = "pspReference";
    public static final ModelObject.Serializer<OrderRequest> SERIALIZER = new OrderRequest$Companion$SERIALIZER$1();
    private final String orderData;
    private final String pspReference;

    public static /* synthetic */ OrderRequest copy$default(OrderRequest orderRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderRequest.pspReference;
        }
        if ((i & 2) != 0) {
            str2 = orderRequest.orderData;
        }
        return orderRequest.copy(str, str2);
    }

    public final String component1() {
        return this.pspReference;
    }

    public final String component2() {
        return this.orderData;
    }

    public final OrderRequest copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, PSP_REFERENCE);
        Intrinsics.checkNotNullParameter(str2, ORDER_DATA);
        return new OrderRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderRequest)) {
            return false;
        }
        OrderRequest orderRequest = (OrderRequest) obj;
        return Intrinsics.areEqual(this.pspReference, orderRequest.pspReference) && Intrinsics.areEqual(this.orderData, orderRequest.orderData);
    }

    public int hashCode() {
        return (this.pspReference.hashCode() * 31) + this.orderData.hashCode();
    }

    public String toString() {
        return "OrderRequest(pspReference=" + this.pspReference + ", orderData=" + this.orderData + ')';
    }

    public final String getPspReference() {
        return this.pspReference;
    }

    public final String getOrderData() {
        return this.orderData;
    }

    public OrderRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, PSP_REFERENCE);
        Intrinsics.checkNotNullParameter(str2, ORDER_DATA);
        this.pspReference = str;
        this.orderData = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/adyen/checkout/components/model/payments/request/OrderRequest$Companion;", "", "()V", "CREATOR", "Lcom/adyen/checkout/core/model/ModelObject$Creator;", "Lcom/adyen/checkout/components/model/payments/request/OrderRequest;", "kotlin.jvm.PlatformType", "ORDER_DATA", "", "PSP_REFERENCE", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: OrderRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
