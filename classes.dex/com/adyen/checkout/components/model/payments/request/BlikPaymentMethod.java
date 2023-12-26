package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class BlikPaymentMethod extends PaymentMethodDetails {
    private static final String BLIK_CODE = "blikCode";
    public static final ModelObject.Creator<BlikPaymentMethod> CREATOR = new ModelObject.Creator<>(BlikPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "blik";
    public static final ModelObject.Serializer<BlikPaymentMethod> SERIALIZER = new ModelObject.Serializer<BlikPaymentMethod>() {
        public JSONObject serialize(BlikPaymentMethod blikPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", blikPaymentMethod.getType());
                jSONObject.putOpt(BlikPaymentMethod.BLIK_CODE, blikPaymentMethod.getBlikCode());
                jSONObject.putOpt(BlikPaymentMethod.STORED_PAYMENT_METHOD_ID, blikPaymentMethod.getStoredPaymentMethodId());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(BlikPaymentMethod.class, e);
            }
        }

        public BlikPaymentMethod deserialize(JSONObject jSONObject) {
            BlikPaymentMethod blikPaymentMethod = new BlikPaymentMethod();
            blikPaymentMethod.setType(jSONObject.optString("type", (String) null));
            blikPaymentMethod.setBlikCode(jSONObject.optString(BlikPaymentMethod.BLIK_CODE, (String) null));
            blikPaymentMethod.setStoredPaymentMethodId(jSONObject.optString(BlikPaymentMethod.STORED_PAYMENT_METHOD_ID, (String) null));
            return blikPaymentMethod;
        }
    };
    private static final String STORED_PAYMENT_METHOD_ID = "storedPaymentMethodId";
    private String blikCode;
    private String storedPaymentMethodId;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getBlikCode() {
        return this.blikCode;
    }

    public String getStoredPaymentMethodId() {
        return this.storedPaymentMethodId;
    }

    public void setBlikCode(String str) {
        this.blikCode = str;
    }

    public void setStoredPaymentMethodId(String str) {
        this.storedPaymentMethodId = str;
    }
}
