package com.adyen.checkout.components.model.payments.response;

import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/components/model/payments/response/BalanceResult$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/components/model/payments/response/BalanceResult;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BalanceResult.kt */
public final class BalanceResult$Companion$SERIALIZER$1 implements ModelObject.Serializer<BalanceResult> {
    BalanceResult$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(BalanceResult balanceResult) {
        Intrinsics.checkNotNullParameter(balanceResult, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("balance", ModelUtils.serializeOpt(balanceResult.getBalance(), Amount.SERIALIZER));
            jSONObject.putOpt("transactionLimit", ModelUtils.serializeOpt(balanceResult.getTransactionLimit(), Amount.SERIALIZER));
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(BalanceResult.class, e);
        }
    }

    public BalanceResult deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Amount amount = (Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject("balance"), Amount.SERIALIZER);
        if (amount != null) {
            return new BalanceResult(amount, (Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject("transactionLimit"), Amount.SERIALIZER));
        }
        throw new CheckoutException("Balance not found");
    }
}
