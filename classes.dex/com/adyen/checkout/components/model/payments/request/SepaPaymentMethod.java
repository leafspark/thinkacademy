package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class SepaPaymentMethod extends PaymentMethodDetails {
    public static final ModelObject.Creator<SepaPaymentMethod> CREATOR = new ModelObject.Creator<>(SepaPaymentMethod.class);
    private static final String IBAN = "iban";
    private static final String OWNER_NAME = "ownerName";
    public static final String PAYMENT_METHOD_TYPE = "sepadirectdebit";
    public static final ModelObject.Serializer<SepaPaymentMethod> SERIALIZER = new ModelObject.Serializer<SepaPaymentMethod>() {
        public JSONObject serialize(SepaPaymentMethod sepaPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", sepaPaymentMethod.getType());
                jSONObject.putOpt(SepaPaymentMethod.OWNER_NAME, sepaPaymentMethod.getOwnerName());
                jSONObject.putOpt(SepaPaymentMethod.IBAN, sepaPaymentMethod.getIban());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(SepaPaymentMethod.class, e);
            }
        }

        public SepaPaymentMethod deserialize(JSONObject jSONObject) {
            SepaPaymentMethod sepaPaymentMethod = new SepaPaymentMethod();
            sepaPaymentMethod.setType(jSONObject.optString("type", (String) null));
            sepaPaymentMethod.setOwnerName(jSONObject.optString(SepaPaymentMethod.OWNER_NAME, (String) null));
            sepaPaymentMethod.setIban(jSONObject.optString(SepaPaymentMethod.IBAN, (String) null));
            return sepaPaymentMethod;
        }
    };
    private String iban;
    private String ownerName;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String str) {
        this.ownerName = str;
    }

    public String getIban() {
        return this.iban;
    }

    public void setIban(String str) {
        this.iban = str;
    }
}
