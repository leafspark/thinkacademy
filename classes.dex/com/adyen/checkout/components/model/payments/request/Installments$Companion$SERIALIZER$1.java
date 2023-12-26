package com.adyen.checkout.components.model.payments.request;

import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/adyen/checkout/components/model/payments/request/Installments$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/components/model/payments/request/Installments;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Installments.kt */
public final class Installments$Companion$SERIALIZER$1 implements ModelObject.Serializer<Installments> {
    Installments$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(Installments installments) {
        Intrinsics.checkNotNullParameter(installments, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("plan", installments.getPlan());
            jSONObject.putOpt("value", installments.getValue());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(Installments.class, e);
        }
    }

    public Installments deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            return new Installments(jSONObject.getString("plan"), Integer.valueOf(jSONObject.optInt("value", 1)));
        } catch (JSONException e) {
            throw new ModelSerializationException(Installments.class, e);
        }
    }
}
