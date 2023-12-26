package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class OpenBankingPaymentMethod extends IssuerListPaymentMethod {
    public static final ModelObject.Creator<OpenBankingPaymentMethod> CREATOR = new ModelObject.Creator<>(OpenBankingPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "openbanking_UK";
    public static final ModelObject.Serializer<OpenBankingPaymentMethod> SERIALIZER = new ModelObject.Serializer<OpenBankingPaymentMethod>() {
        public JSONObject serialize(OpenBankingPaymentMethod openBankingPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", openBankingPaymentMethod.getType());
                jSONObject.putOpt("issuer", openBankingPaymentMethod.getIssuer());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(OpenBankingPaymentMethod.class, e);
            }
        }

        public OpenBankingPaymentMethod deserialize(JSONObject jSONObject) {
            OpenBankingPaymentMethod openBankingPaymentMethod = new OpenBankingPaymentMethod();
            openBankingPaymentMethod.setType(jSONObject.optString("type", (String) null));
            openBankingPaymentMethod.setIssuer(jSONObject.optString("issuer", (String) null));
            return openBankingPaymentMethod;
        }
    };

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }
}
