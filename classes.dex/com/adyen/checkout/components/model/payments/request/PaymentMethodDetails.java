package com.adyen.checkout.components.model.payments.request;

import android.text.TextUtils;
import com.adyen.checkout.components.util.PaymentMethodTypes;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONObject;

public abstract class PaymentMethodDetails extends ModelObject {
    public static final ModelObject.Serializer<PaymentMethodDetails> SERIALIZER = new ModelObject.Serializer<PaymentMethodDetails>() {
        public JSONObject serialize(PaymentMethodDetails paymentMethodDetails) {
            String type = paymentMethodDetails.getType();
            if (!TextUtils.isEmpty(type)) {
                return PaymentMethodDetails.getChildSerializer(type).serialize(paymentMethodDetails);
            }
            throw new CheckoutException("PaymentMethod type not found");
        }

        public PaymentMethodDetails deserialize(JSONObject jSONObject) {
            String optString = jSONObject.optString("type", (String) null);
            if (!TextUtils.isEmpty(optString)) {
                return (PaymentMethodDetails) PaymentMethodDetails.getChildSerializer(optString).deserialize(jSONObject);
            }
            throw new CheckoutException("PaymentMethod type not found");
        }
    };
    public static final String TYPE = "type";
    private String type;

    static ModelObject.Serializer<? extends PaymentMethodDetails> getChildSerializer(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1647305830:
                if (str.equals(PaymentMethodTypes.MOLPAY_MALAYSIA)) {
                    c = 0;
                    break;
                }
                break;
            case -1325974849:
                if (str.equals("dotpay")) {
                    c = 1;
                    break;
                }
                break;
            case -907987547:
                if (str.equals("scheme")) {
                    c = 2;
                    break;
                }
                break;
            case -857582069:
                if (str.equals("entercash")) {
                    c = 3;
                    break;
                }
                break;
            case 100648:
                if (str.equals("eps")) {
                    c = 4;
                    break;
                }
                break;
            case 3026668:
                if (str.equals("blik")) {
                    c = 5;
                    break;
                }
                break;
            case 19088375:
                if (str.equals("directdebit_GB")) {
                    c = 6;
                    break;
                }
                break;
            case 100048981:
                if (str.equals("ideal")) {
                    c = 7;
                    break;
                }
                break;
            case 103700794:
                if (str.equals("mbway")) {
                    c = 8;
                    break;
                }
                break;
            case 849792064:
                if (str.equals("giftcard")) {
                    c = 9;
                    break;
                }
                break;
            case 970824177:
                if (str.equals(PaymentMethodTypes.MOLPAY_THAILAND)) {
                    c = 10;
                    break;
                }
                break;
            case 970824245:
                if (str.equals(PaymentMethodTypes.MOLPAY_VIETNAM)) {
                    c = 11;
                    break;
                }
                break;
            case 1200873767:
                if (str.equals(PaymentMethodTypes.GOOGLE_PAY_LEGACY)) {
                    c = 12;
                    break;
                }
                break;
            case 1474526159:
                if (str.equals(PaymentMethodTypes.GOOGLE_PAY)) {
                    c = 13;
                    break;
                }
                break;
            case 1545915136:
                if (str.equals("sepadirectdebit")) {
                    c = 14;
                    break;
                }
                break;
            case 1984622361:
                if (str.equals("openbanking_UK")) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 10:
            case 11:
                return MolpayPaymentMethod.SERIALIZER;
            case 1:
                return DotpayPaymentMethod.SERIALIZER;
            case 2:
                return CardPaymentMethod.SERIALIZER;
            case 3:
                return EntercashPaymentMethod.SERIALIZER;
            case 4:
                return EPSPaymentMethod.SERIALIZER;
            case 5:
                return BlikPaymentMethod.SERIALIZER;
            case 6:
                return BacsDirectDebitPaymentMethod.SERIALIZER;
            case 7:
                return IdealPaymentMethod.SERIALIZER;
            case 8:
                return MBWayPaymentMethod.SERIALIZER;
            case 9:
                return GiftCardPaymentMethod.SERIALIZER;
            case 12:
            case 13:
                return GooglePayPaymentMethod.SERIALIZER;
            case 14:
                return SepaPaymentMethod.SERIALIZER;
            case 15:
                return OpenBankingPaymentMethod.SERIALIZER;
            default:
                return GenericPaymentMethod.SERIALIZER;
        }
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
