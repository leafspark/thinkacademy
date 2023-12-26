package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VoucherAction extends Action {
    public static final String ACTION_TYPE = "voucher";
    private static final String ALTERNATIVE_REFERENCE = "alternativeReference";
    public static final ModelObject.Creator<VoucherAction> CREATOR = new ModelObject.Creator<>(VoucherAction.class);
    private static final String EXPIRES_AT = "expiresAt";
    private static final String INITIAL_AMOUNT = "initialAmount";
    private static final String ISSUER = "issuer";
    private static final String MERCHANT_NAME = "merchantName";
    private static final String REFERENCE = "reference";
    public static final ModelObject.Serializer<VoucherAction> SERIALIZER = new ModelObject.Serializer<VoucherAction>() {
        public JSONObject serialize(VoucherAction voucherAction) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", voucherAction.getType());
                jSONObject.putOpt("paymentData", voucherAction.getPaymentData());
                jSONObject.putOpt(Action.PAYMENT_METHOD_TYPE, voucherAction.getPaymentMethodType());
                jSONObject.putOpt(VoucherAction.SURCHARGE, ModelUtils.serializeOpt(voucherAction.getSurcharge(), Amount.SERIALIZER));
                jSONObject.putOpt(VoucherAction.INITIAL_AMOUNT, ModelUtils.serializeOpt(voucherAction.getInitialAmount(), Amount.SERIALIZER));
                jSONObject.putOpt(VoucherAction.TOTAL_AMOUNT, ModelUtils.serializeOpt(voucherAction.getTotalAmount(), Amount.SERIALIZER));
                jSONObject.putOpt(VoucherAction.ISSUER, voucherAction.getIssuer());
                jSONObject.putOpt(VoucherAction.EXPIRES_AT, voucherAction.getExpiresAt());
                jSONObject.putOpt(VoucherAction.REFERENCE, voucherAction.getReference());
                jSONObject.putOpt(VoucherAction.ALTERNATIVE_REFERENCE, voucherAction.getAlternativeReference());
                jSONObject.putOpt(VoucherAction.MERCHANT_NAME, voucherAction.getMerchantName());
                jSONObject.putOpt("url", voucherAction.getUrl());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(VoucherAction.class, e);
            }
        }

        public VoucherAction deserialize(JSONObject jSONObject) {
            VoucherAction voucherAction = new VoucherAction();
            voucherAction.setType(jSONObject.optString("type", (String) null));
            voucherAction.setPaymentData(jSONObject.optString("paymentData", (String) null));
            voucherAction.setPaymentMethodType(jSONObject.optString(Action.PAYMENT_METHOD_TYPE, (String) null));
            voucherAction.setSurcharge((Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject(VoucherAction.SURCHARGE), Amount.SERIALIZER));
            voucherAction.setInitialAmount((Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject(VoucherAction.INITIAL_AMOUNT), Amount.SERIALIZER));
            voucherAction.setTotalAmount((Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject(VoucherAction.TOTAL_AMOUNT), Amount.SERIALIZER));
            voucherAction.setIssuer(jSONObject.optString(VoucherAction.ISSUER));
            voucherAction.setExpiresAt(jSONObject.optString(VoucherAction.EXPIRES_AT));
            voucherAction.setReference(jSONObject.optString(VoucherAction.REFERENCE));
            voucherAction.setAlternativeReference(jSONObject.optString(VoucherAction.ALTERNATIVE_REFERENCE));
            voucherAction.setMerchantName(jSONObject.optString(VoucherAction.MERCHANT_NAME));
            voucherAction.setUrl(jSONObject.optString("url"));
            return voucherAction;
        }
    };
    private static final String SURCHARGE = "surcharge";
    private static final String TOTAL_AMOUNT = "totalAmount";
    private static final String URL = "url";
    private String alternativeReference;
    private String expiresAt;
    private Amount initialAmount;
    private String issuer;
    private String merchantName;
    private String reference;
    private Amount surcharge;
    private Amount totalAmount;
    private String url;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public Amount getSurcharge() {
        return this.surcharge;
    }

    public void setSurcharge(Amount amount) {
        this.surcharge = amount;
    }

    public Amount getInitialAmount() {
        return this.initialAmount;
    }

    public void setInitialAmount(Amount amount) {
        this.initialAmount = amount;
    }

    public Amount getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Amount amount) {
        this.totalAmount = amount;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }

    public String getExpiresAt() {
        return this.expiresAt;
    }

    public void setExpiresAt(String str) {
        this.expiresAt = str;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public String getAlternativeReference() {
        return this.alternativeReference;
    }

    public void setAlternativeReference(String str) {
        this.alternativeReference = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
