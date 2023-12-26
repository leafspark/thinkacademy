package com.adyen.checkout.components.model.connection;

import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/components/model/connection/OrderStatusResponse$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/components/model/connection/OrderStatusResponse;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderStatusResponse.kt */
public final class OrderStatusResponse$Companion$SERIALIZER$1 implements ModelObject.Serializer<OrderStatusResponse> {
    OrderStatusResponse$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(OrderStatusResponse orderStatusResponse) {
        Intrinsics.checkNotNullParameter(orderStatusResponse, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("paymentMethods", ModelUtils.serializeOptList(orderStatusResponse.getPaymentMethods(), OrderPaymentMethod.Companion.getSERIALIZER()));
            jSONObject.putOpt("remainingAmount", orderStatusResponse.getRemainingAmount());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(OrderStatusResponse.class, e);
        }
    }

    public OrderStatusResponse deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            List<OrderPaymentMethod> deserializeOptList = ModelUtils.deserializeOptList(jSONObject.optJSONArray("paymentMethods"), OrderPaymentMethod.Companion.getSERIALIZER());
            if (deserializeOptList == null) {
                deserializeOptList = CollectionsKt.emptyList();
            }
            Amount amount = (Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject("remainingAmount"), Amount.SERIALIZER);
            if (amount == null) {
                amount = Amount.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(amount, "ModelUtils.deserializeOpt(\n                            jsonObject.optJSONObject(REMAINING_AMOUNT),\n                            Amount.SERIALIZER\n                        ) ?: Amount.EMPTY");
            return new OrderStatusResponse(deserializeOptList, amount);
        } catch (JSONException e) {
            throw new ModelSerializationException(OrderStatusResponse.class, e);
        }
    }
}
