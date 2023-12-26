package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class QrCodeAction extends Action {
    public static final String ACTION_TYPE = "qrCode";
    public static final ModelObject.Creator<QrCodeAction> CREATOR = new ModelObject.Creator<>(QrCodeAction.class);
    private static final String QR_CODE_DATA = "qrCodeData";
    public static final ModelObject.Serializer<QrCodeAction> SERIALIZER = new ModelObject.Serializer<QrCodeAction>() {
        public JSONObject serialize(QrCodeAction qrCodeAction) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", qrCodeAction.getType());
                jSONObject.putOpt("paymentData", qrCodeAction.getPaymentData());
                jSONObject.putOpt(Action.PAYMENT_METHOD_TYPE, qrCodeAction.getPaymentMethodType());
                jSONObject.putOpt(QrCodeAction.QR_CODE_DATA, qrCodeAction.getQrCodeData());
                jSONObject.putOpt("url", qrCodeAction.getUrl());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(QrCodeAction.class, e);
            }
        }

        public QrCodeAction deserialize(JSONObject jSONObject) {
            QrCodeAction qrCodeAction = new QrCodeAction();
            qrCodeAction.setType(jSONObject.optString("type", (String) null));
            qrCodeAction.setPaymentData(jSONObject.optString("paymentData", (String) null));
            qrCodeAction.setPaymentMethodType(jSONObject.optString(Action.PAYMENT_METHOD_TYPE, (String) null));
            qrCodeAction.setQrCodeData(jSONObject.optString(QrCodeAction.QR_CODE_DATA));
            qrCodeAction.setUrl(jSONObject.optString("url"));
            return qrCodeAction;
        }
    };
    private static final String URL = "url";
    private String qrCodeData;
    private String url;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getQrCodeData() {
        return this.qrCodeData;
    }

    public void setQrCodeData(String str) {
        this.qrCodeData = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
