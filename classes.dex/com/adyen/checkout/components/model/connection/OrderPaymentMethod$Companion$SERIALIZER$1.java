package com.adyen.checkout.components.model.connection;

import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/components/model/connection/OrderPaymentMethod$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/components/model/connection/OrderPaymentMethod;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OrderPaymentMethod.kt */
public final class OrderPaymentMethod$Companion$SERIALIZER$1 implements ModelObject.Serializer<OrderPaymentMethod> {
    OrderPaymentMethod$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(OrderPaymentMethod orderPaymentMethod) {
        Intrinsics.checkNotNullParameter(orderPaymentMethod, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", orderPaymentMethod.getType());
            jSONObject.putOpt("lastFour", orderPaymentMethod.getLastFour());
            jSONObject.putOpt("amount", ModelUtils.serializeOpt(orderPaymentMethod.getAmount(), Amount.SERIALIZER));
            jSONObject.putOpt("transactionLimit", ModelUtils.serializeOpt(orderPaymentMethod.getTransactionLimit(), Amount.SERIALIZER));
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(OrderPaymentMethod.class, e);
        }
    }

    public OrderPaymentMethod deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            String string = jSONObject.getString("type");
            String string2 = jSONObject.getString("lastFour");
            Amount amount = (Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject("amount"), Amount.SERIALIZER);
            if (amount == null) {
                amount = Amount.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(string, "getString(TYPE)");
            Intrinsics.checkNotNullExpressionValue(amount, "ModelUtils.deserializeOpt(jsonObject.optJSONObject(AMOUNT), Amount.SERIALIZER) ?: Amount.EMPTY");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(LAST_FOUR)");
            return new OrderPaymentMethod(string, amount, string2, (Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject("transactionLimit"), Amount.SERIALIZER));
        } catch (JSONException e) {
            throw new ModelSerializationException(OrderPaymentMethod.class, e);
        }
    }
}
