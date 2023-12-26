package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class IdealPaymentMethod extends IssuerListPaymentMethod {
    public static final ModelObject.Creator<IdealPaymentMethod> CREATOR = new ModelObject.Creator<>(IdealPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "ideal";
    public static final ModelObject.Serializer<IdealPaymentMethod> SERIALIZER = new ModelObject.Serializer<IdealPaymentMethod>() {
        public JSONObject serialize(IdealPaymentMethod idealPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", idealPaymentMethod.getType());
                jSONObject.putOpt("issuer", idealPaymentMethod.getIssuer());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(IdealPaymentMethod.class, e);
            }
        }

        public IdealPaymentMethod deserialize(JSONObject jSONObject) {
            IdealPaymentMethod idealPaymentMethod = new IdealPaymentMethod();
            idealPaymentMethod.setType(jSONObject.optString("type", (String) null));
            idealPaymentMethod.setIssuer(jSONObject.optString("issuer", (String) null));
            return idealPaymentMethod;
        }
    };

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }
}
