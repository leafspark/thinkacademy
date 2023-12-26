package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class GooglePayPaymentMethod extends PaymentMethodDetails {
    public static final ModelObject.Creator<GooglePayPaymentMethod> CREATOR = new ModelObject.Creator<>(GooglePayPaymentMethod.class);
    private static final String GOOGLE_PAY_CARD_NETWORK = "googlePayCardNetwork";
    private static final String GOOGLE_PAY_TOKEN = "googlePayToken";
    public static final ModelObject.Serializer<GooglePayPaymentMethod> SERIALIZER = new ModelObject.Serializer<GooglePayPaymentMethod>() {
        public JSONObject serialize(GooglePayPaymentMethod googlePayPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", googlePayPaymentMethod.getType());
                jSONObject.putOpt(GooglePayPaymentMethod.GOOGLE_PAY_TOKEN, googlePayPaymentMethod.getGooglePayToken());
                jSONObject.putOpt(GooglePayPaymentMethod.GOOGLE_PAY_CARD_NETWORK, googlePayPaymentMethod.getGooglePayCardNetwork());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(GooglePayPaymentMethod.class, e);
            }
        }

        public GooglePayPaymentMethod deserialize(JSONObject jSONObject) {
            GooglePayPaymentMethod googlePayPaymentMethod = new GooglePayPaymentMethod();
            googlePayPaymentMethod.setType(jSONObject.optString("type", (String) null));
            googlePayPaymentMethod.setGooglePayToken(jSONObject.optString(GooglePayPaymentMethod.GOOGLE_PAY_TOKEN, (String) null));
            googlePayPaymentMethod.setGooglePayCardNetwork(jSONObject.optString(GooglePayPaymentMethod.GOOGLE_PAY_CARD_NETWORK, (String) null));
            return googlePayPaymentMethod;
        }
    };
    private String googlePayCardNetwork;
    private String googlePayToken;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getGooglePayToken() {
        return this.googlePayToken;
    }

    public void setGooglePayToken(String str) {
        this.googlePayToken = str;
    }

    public String getGooglePayCardNetwork() {
        return this.googlePayCardNetwork;
    }

    public void setGooglePayCardNetwork(String str) {
        this.googlePayCardNetwork = str;
    }
}
