package com.adyen.checkout.components.model.payments.response;

import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/components/model/payments/response/OrderResponse$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/components/model/payments/response/OrderResponse;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderResponse.kt */
public final class OrderResponse$Companion$SERIALIZER$1 implements ModelObject.Serializer<OrderResponse> {
    OrderResponse$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(OrderResponse orderResponse) {
        Intrinsics.checkNotNullParameter(orderResponse, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pspReference", orderResponse.getPspReference());
            jSONObject.putOpt("orderData", orderResponse.getOrderData());
            jSONObject.putOpt("reference", orderResponse.getReference());
            jSONObject.putOpt("amount", ModelUtils.serializeOpt(orderResponse.getAmount(), Amount.SERIALIZER));
            jSONObject.putOpt("remainingAmount", ModelUtils.serializeOpt(orderResponse.getRemainingAmount(), Amount.SERIALIZER));
            jSONObject.putOpt("expiresAt", orderResponse.getExpiresAt());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(OrderResponse.class, e);
        }
    }

    public OrderResponse deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        String optString = jSONObject.optString("pspReference", "");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(PSP_REFERENCE, \"\")");
        String optString2 = jSONObject.optString("orderData", "");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(ORDER_DATA, \"\")");
        return new OrderResponse(optString, optString2, jSONObject.optString("reference", ""), (Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject("amount"), Amount.SERIALIZER), (Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject("remainingAmount"), Amount.SERIALIZER), jSONObject.optString("expiresAt", ""));
    }
}
