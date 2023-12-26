package com.adyen.checkout.components.model.payments.response;

import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtilsKt;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/components/model/payments/response/Threeds2FingerprintAction$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/components/model/payments/response/Threeds2FingerprintAction;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Threeds2FingerprintAction.kt */
public final class Threeds2FingerprintAction$Companion$SERIALIZER$1 implements ModelObject.Serializer<Threeds2FingerprintAction> {
    Threeds2FingerprintAction$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(Threeds2FingerprintAction threeds2FingerprintAction) {
        Intrinsics.checkNotNullParameter(threeds2FingerprintAction, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", threeds2FingerprintAction.getType());
            jSONObject.putOpt("paymentData", threeds2FingerprintAction.getPaymentData());
            jSONObject.putOpt(Action.PAYMENT_METHOD_TYPE, threeds2FingerprintAction.getPaymentMethodType());
            jSONObject.putOpt("token", threeds2FingerprintAction.getToken());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(Threeds2FingerprintAction.class, e);
        }
    }

    public Threeds2FingerprintAction deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            Threeds2FingerprintAction threeds2FingerprintAction = new Threeds2FingerprintAction(JsonUtilsKt.getStringOrNull(jSONObject, "token"));
            threeds2FingerprintAction.setType(JsonUtilsKt.getStringOrNull(jSONObject, "type"));
            threeds2FingerprintAction.setPaymentData(JsonUtilsKt.getStringOrNull(jSONObject, "paymentData"));
            threeds2FingerprintAction.setPaymentMethodType(JsonUtilsKt.getStringOrNull(jSONObject, Action.PAYMENT_METHOD_TYPE));
            return threeds2FingerprintAction;
        } catch (JSONException e) {
            throw new ModelSerializationException(Threeds2Action.class, e);
        }
    }
}
