package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class EPSPaymentMethod extends IssuerListPaymentMethod {
    public static final ModelObject.Creator<EPSPaymentMethod> CREATOR = new ModelObject.Creator<>(EPSPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "eps";
    public static final ModelObject.Serializer<EPSPaymentMethod> SERIALIZER = new ModelObject.Serializer<EPSPaymentMethod>() {
        public JSONObject serialize(EPSPaymentMethod ePSPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", ePSPaymentMethod.getType());
                jSONObject.putOpt("issuer", ePSPaymentMethod.getIssuer());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(EPSPaymentMethod.class, e);
            }
        }

        public EPSPaymentMethod deserialize(JSONObject jSONObject) {
            EPSPaymentMethod ePSPaymentMethod = new EPSPaymentMethod();
            ePSPaymentMethod.setType(jSONObject.optString("type", (String) null));
            ePSPaymentMethod.setIssuer(jSONObject.optString("issuer", (String) null));
            return ePSPaymentMethod;
        }
    };

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }
}
