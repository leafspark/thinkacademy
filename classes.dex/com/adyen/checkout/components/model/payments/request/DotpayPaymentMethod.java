package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class DotpayPaymentMethod extends IssuerListPaymentMethod {
    public static final ModelObject.Creator<DotpayPaymentMethod> CREATOR = new ModelObject.Creator<>(DotpayPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "dotpay";
    public static final ModelObject.Serializer<DotpayPaymentMethod> SERIALIZER = new ModelObject.Serializer<DotpayPaymentMethod>() {
        public JSONObject serialize(DotpayPaymentMethod dotpayPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", dotpayPaymentMethod.getType());
                jSONObject.putOpt("issuer", dotpayPaymentMethod.getIssuer());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(DotpayPaymentMethod.class, e);
            }
        }

        public DotpayPaymentMethod deserialize(JSONObject jSONObject) {
            DotpayPaymentMethod dotpayPaymentMethod = new DotpayPaymentMethod();
            dotpayPaymentMethod.setType(jSONObject.optString("type", (String) null));
            dotpayPaymentMethod.setIssuer(jSONObject.optString("issuer", (String) null));
            return dotpayPaymentMethod;
        }
    };

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }
}
