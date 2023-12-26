package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class CardPaymentMethod extends PaymentMethodDetails {
    private static final String BRAND = "brand";
    public static final ModelObject.Creator<CardPaymentMethod> CREATOR = new ModelObject.Creator<>(CardPaymentMethod.class);
    private static final String ENCRYPTED_CARD_NUMBER = "encryptedCardNumber";
    private static final String ENCRYPTED_EXPIRY_MONTH = "encryptedExpiryMonth";
    private static final String ENCRYPTED_EXPIRY_YEAR = "encryptedExpiryYear";
    private static final String ENCRYPTED_PASSWORD = "encryptedPassword";
    private static final String ENCRYPTED_SECURITY_CODE = "encryptedSecurityCode";
    private static final String FUNDING_SOURCE = "fundingSource";
    private static final String HOLDER_NAME = "holderName";
    public static final String PAYMENT_METHOD_TYPE = "scheme";
    public static final ModelObject.Serializer<CardPaymentMethod> SERIALIZER = new ModelObject.Serializer<CardPaymentMethod>() {
        public JSONObject serialize(CardPaymentMethod cardPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", cardPaymentMethod.getType());
                jSONObject.putOpt(CardPaymentMethod.ENCRYPTED_CARD_NUMBER, cardPaymentMethod.getEncryptedCardNumber());
                jSONObject.putOpt(CardPaymentMethod.ENCRYPTED_EXPIRY_MONTH, cardPaymentMethod.getEncryptedExpiryMonth());
                jSONObject.putOpt(CardPaymentMethod.ENCRYPTED_EXPIRY_YEAR, cardPaymentMethod.getEncryptedExpiryYear());
                jSONObject.putOpt(CardPaymentMethod.ENCRYPTED_SECURITY_CODE, cardPaymentMethod.getEncryptedSecurityCode());
                jSONObject.putOpt(CardPaymentMethod.STORED_PAYMENT_METHOD_ID, cardPaymentMethod.getStoredPaymentMethodId());
                jSONObject.putOpt(CardPaymentMethod.HOLDER_NAME, cardPaymentMethod.getHolderName());
                jSONObject.putOpt(CardPaymentMethod.ENCRYPTED_PASSWORD, cardPaymentMethod.getEncryptedPassword());
                jSONObject.putOpt(CardPaymentMethod.TAX_NUMBER, cardPaymentMethod.getTaxNumber());
                jSONObject.putOpt(CardPaymentMethod.BRAND, cardPaymentMethod.getBrand());
                jSONObject.putOpt(CardPaymentMethod.THREEDS2_SDK_VERSION, cardPaymentMethod.getThreeDS2SdkVersion());
                jSONObject.putOpt(CardPaymentMethod.FUNDING_SOURCE, cardPaymentMethod.getFundingSource());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(CardPaymentMethod.class, e);
            }
        }

        public CardPaymentMethod deserialize(JSONObject jSONObject) {
            CardPaymentMethod cardPaymentMethod = new CardPaymentMethod();
            cardPaymentMethod.setType(jSONObject.optString("type", (String) null));
            cardPaymentMethod.setEncryptedCardNumber(jSONObject.optString(CardPaymentMethod.ENCRYPTED_CARD_NUMBER, (String) null));
            cardPaymentMethod.setEncryptedExpiryMonth(jSONObject.optString(CardPaymentMethod.ENCRYPTED_EXPIRY_MONTH, (String) null));
            cardPaymentMethod.setEncryptedExpiryYear(jSONObject.optString(CardPaymentMethod.ENCRYPTED_EXPIRY_YEAR, (String) null));
            cardPaymentMethod.setStoredPaymentMethodId(jSONObject.optString(CardPaymentMethod.STORED_PAYMENT_METHOD_ID));
            cardPaymentMethod.setEncryptedSecurityCode(jSONObject.optString(CardPaymentMethod.ENCRYPTED_SECURITY_CODE, (String) null));
            cardPaymentMethod.setHolderName(jSONObject.optString(CardPaymentMethod.HOLDER_NAME, (String) null));
            cardPaymentMethod.setEncryptedPassword(jSONObject.optString(CardPaymentMethod.ENCRYPTED_PASSWORD, (String) null));
            cardPaymentMethod.setTaxNumber(jSONObject.optString(CardPaymentMethod.TAX_NUMBER));
            cardPaymentMethod.setBrand(jSONObject.optString(CardPaymentMethod.BRAND));
            cardPaymentMethod.setThreeDS2SdkVersion(jSONObject.optString(CardPaymentMethod.THREEDS2_SDK_VERSION, (String) null));
            cardPaymentMethod.setFundingSource(jSONObject.optString(CardPaymentMethod.FUNDING_SOURCE, (String) null));
            return cardPaymentMethod;
        }
    };
    private static final String STORED_PAYMENT_METHOD_ID = "storedPaymentMethodId";
    private static final String TAX_NUMBER = "taxNumber";
    private static final String THREEDS2_SDK_VERSION = "threeDS2SdkVersion";
    private String brand;
    private String encryptedCardNumber;
    private String encryptedExpiryMonth;
    private String encryptedExpiryYear;
    private String encryptedPassword;
    private String encryptedSecurityCode;
    private String fundingSource;
    private String holderName;
    private String storedPaymentMethodId;
    private String taxNumber;
    private String threeDS2SdkVersion;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getEncryptedCardNumber() {
        return this.encryptedCardNumber;
    }

    public void setEncryptedCardNumber(String str) {
        this.encryptedCardNumber = str;
    }

    public String getEncryptedExpiryMonth() {
        return this.encryptedExpiryMonth;
    }

    public void setEncryptedExpiryMonth(String str) {
        this.encryptedExpiryMonth = str;
    }

    public String getEncryptedExpiryYear() {
        return this.encryptedExpiryYear;
    }

    public void setEncryptedExpiryYear(String str) {
        this.encryptedExpiryYear = str;
    }

    public String getEncryptedSecurityCode() {
        return this.encryptedSecurityCode;
    }

    public void setEncryptedSecurityCode(String str) {
        this.encryptedSecurityCode = str;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public void setEncryptedPassword(String str) {
        this.encryptedPassword = str;
    }

    public String getTaxNumber() {
        return this.taxNumber;
    }

    public void setTaxNumber(String str) {
        this.taxNumber = str;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public void setHolderName(String str) {
        this.holderName = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setStoredPaymentMethodId(String str) {
        this.storedPaymentMethodId = str;
    }

    public String getStoredPaymentMethodId() {
        return this.storedPaymentMethodId;
    }

    public String getThreeDS2SdkVersion() {
        return this.threeDS2SdkVersion;
    }

    public void setThreeDS2SdkVersion(String str) {
        this.threeDS2SdkVersion = str;
    }

    public String getFundingSource() {
        return this.fundingSource;
    }

    public void setFundingSource(String str) {
        this.fundingSource = str;
    }
}
