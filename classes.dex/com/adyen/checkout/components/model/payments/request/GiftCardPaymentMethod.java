package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftCardPaymentMethod extends PaymentMethodDetails {
    private static final String BRAND = "brand";
    public static final ModelObject.Creator<GiftCardPaymentMethod> CREATOR = new ModelObject.Creator<>(GiftCardPaymentMethod.class);
    private static final String ENCRYPTED_CARD_NUMBER = "encryptedCardNumber";
    private static final String ENCRYPTED_SECURITY_CODE = "encryptedSecurityCode";
    public static final String PAYMENT_METHOD_TYPE = "giftcard";
    public static final ModelObject.Serializer<GiftCardPaymentMethod> SERIALIZER = new ModelObject.Serializer<GiftCardPaymentMethod>() {
        public JSONObject serialize(GiftCardPaymentMethod giftCardPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", giftCardPaymentMethod.getType());
                jSONObject.putOpt(GiftCardPaymentMethod.ENCRYPTED_CARD_NUMBER, giftCardPaymentMethod.getEncryptedCardNumber());
                jSONObject.putOpt(GiftCardPaymentMethod.ENCRYPTED_SECURITY_CODE, giftCardPaymentMethod.getEncryptedSecurityCode());
                jSONObject.putOpt(GiftCardPaymentMethod.BRAND, giftCardPaymentMethod.getBrand());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(GooglePayPaymentMethod.class, e);
            }
        }

        public GiftCardPaymentMethod deserialize(JSONObject jSONObject) {
            GiftCardPaymentMethod giftCardPaymentMethod = new GiftCardPaymentMethod();
            giftCardPaymentMethod.setType(jSONObject.optString("type", (String) null));
            giftCardPaymentMethod.setEncryptedCardNumber(jSONObject.optString(GiftCardPaymentMethod.ENCRYPTED_CARD_NUMBER, (String) null));
            giftCardPaymentMethod.setEncryptedSecurityCode(jSONObject.optString(GiftCardPaymentMethod.ENCRYPTED_SECURITY_CODE, (String) null));
            giftCardPaymentMethod.setBrand(jSONObject.optString(GiftCardPaymentMethod.BRAND));
            return giftCardPaymentMethod;
        }
    };
    private String brand;
    private String encryptedCardNumber;
    private String encryptedSecurityCode;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getEncryptedCardNumber() {
        return this.encryptedCardNumber;
    }

    public void setEncryptedCardNumber(String str) {
        this.encryptedCardNumber = str;
    }

    public String getEncryptedSecurityCode() {
        return this.encryptedSecurityCode;
    }

    public void setEncryptedSecurityCode(String str) {
        this.encryptedSecurityCode = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }
}
