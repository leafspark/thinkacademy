package com.adyen.checkout.components.model.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/adyen/checkout/components/model/connection/OrderStatusRequest;", "Lcom/adyen/checkout/core/model/ModelObject;", "orderData", "", "(Ljava/lang/String;)V", "getOrderData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderStatusRequest.kt */
public final class OrderStatusRequest extends ModelObject {
    public static final Parcelable.Creator<OrderStatusRequest> CREATOR = new ModelObject.Creator(OrderStatusRequest.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ORDER_DATA = "orderData";
    /* access modifiers changed from: private */
    public static final ModelObject.Serializer<OrderStatusRequest> SERIALIZER = new OrderStatusRequest$Companion$SERIALIZER$1();
    private final String orderData;

    public static /* synthetic */ OrderStatusRequest copy$default(OrderStatusRequest orderStatusRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderStatusRequest.orderData;
        }
        return orderStatusRequest.copy(str);
    }

    public static final ModelObject.Serializer<OrderStatusRequest> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final String component1() {
        return this.orderData;
    }

    public final OrderStatusRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, ORDER_DATA);
        return new OrderStatusRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OrderStatusRequest) && Intrinsics.areEqual(this.orderData, ((OrderStatusRequest) obj).orderData);
    }

    public int hashCode() {
        return this.orderData.hashCode();
    }

    public String toString() {
        return "OrderStatusRequest(orderData=" + this.orderData + ')';
    }

    public OrderStatusRequest(String str) {
        Intrinsics.checkNotNullParameter(str, ORDER_DATA);
        this.orderData = str;
    }

    public final String getOrderData() {
        return this.orderData;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/adyen/checkout/components/model/connection/OrderStatusRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/components/model/connection/OrderStatusRequest;", "ORDER_DATA", "", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: OrderStatusRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<OrderStatusRequest> getSERIALIZER() {
            return OrderStatusRequest.SERIALIZER;
        }
    }
}
