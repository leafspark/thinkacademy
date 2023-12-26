package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class EntercashPaymentMethod extends IssuerListPaymentMethod {
    public static final ModelObject.Creator<EntercashPaymentMethod> CREATOR = new ModelObject.Creator<>(EntercashPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "entercash";
    public static final ModelObject.Serializer<EntercashPaymentMethod> SERIALIZER = new ModelObject.Serializer<EntercashPaymentMethod>() {
        public JSONObject serialize(EntercashPaymentMethod entercashPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", entercashPaymentMethod.getType());
                jSONObject.putOpt("issuer", entercashPaymentMethod.getIssuer());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(EntercashPaymentMethod.class, e);
            }
        }

        public EntercashPaymentMethod deserialize(JSONObject jSONObject) {
            EntercashPaymentMethod entercashPaymentMethod = new EntercashPaymentMethod();
            entercashPaymentMethod.setType(jSONObject.optString("type", (String) null));
            entercashPaymentMethod.setIssuer(jSONObject.optString("issuer", (String) null));
            return entercashPaymentMethod;
        }
    };

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }
}
