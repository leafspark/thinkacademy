package com.adyen.checkout.components.model.payments.response;

import android.text.TextUtils;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONObject;

public abstract class Action extends ModelObject {
    public static final String PAYMENT_DATA = "paymentData";
    public static final String PAYMENT_METHOD_TYPE = "paymentMethodType";
    public static final ModelObject.Serializer<Action> SERIALIZER = new ModelObject.Serializer<Action>() {
        public JSONObject serialize(Action action) {
            String type = action.getType();
            if (!TextUtils.isEmpty(type)) {
                return Action.getChildSerializer(type).serialize(action);
            }
            throw new CheckoutException("Action type not found");
        }

        public Action deserialize(JSONObject jSONObject) {
            String optString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString)) {
                return (Action) Action.getChildSerializer(optString).deserialize(jSONObject);
            }
            throw new CheckoutException("Action type not found");
        }
    };
    public static final String TYPE = "type";
    private String paymentData;
    private String paymentMethodType;
    private String type;

    static ModelObject.Serializer<? extends Action> getChildSerializer(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -952485970:
                if (str.equals("qrCode")) {
                    c = 0;
                    break;
                }
                break;
            case -776144932:
                if (str.equals("redirect")) {
                    c = 1;
                    break;
                }
                break;
            case 113722:
                if (str.equals("sdk")) {
                    c = 2;
                    break;
                }
                break;
            case 93223254:
                if (str.equals("await")) {
                    c = 3;
                    break;
                }
                break;
            case 640192174:
                if (str.equals("voucher")) {
                    c = 4;
                    break;
                }
                break;
            case 1021099710:
                if (str.equals("threeDS2Challenge")) {
                    c = 5;
                    break;
                }
                break;
            case 1337458815:
                if (str.equals("threeDS2Fingerprint")) {
                    c = 6;
                    break;
                }
                break;
            case 1473713957:
                if (str.equals("threeDS2")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return QrCodeAction.SERIALIZER;
            case 1:
                return RedirectAction.SERIALIZER;
            case 2:
                return SdkAction.SERIALIZER;
            case 3:
                return AwaitAction.SERIALIZER;
            case 4:
                return VoucherAction.SERIALIZER;
            case 5:
                return Threeds2ChallengeAction.SERIALIZER;
            case 6:
                return Threeds2FingerprintAction.SERIALIZER;
            case 7:
                return Threeds2Action.SERIALIZER;
            default:
                throw new CheckoutException("Action type not found - " + str);
        }
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getPaymentData() {
        return this.paymentData;
    }

    public void setPaymentData(String str) {
        this.paymentData = str;
    }

    public String getPaymentMethodType() {
        return this.paymentMethodType;
    }

    public void setPaymentMethodType(String str) {
        this.paymentMethodType = str;
    }
}
