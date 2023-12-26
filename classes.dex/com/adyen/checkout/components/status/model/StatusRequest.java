package com.adyen.checkout.components.status.model;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.request.Address;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class StatusRequest extends ModelObject {
    public static final ModelObject.Creator<StatusRequest> CREATOR = new ModelObject.Creator<>(StatusRequest.class);
    public static final String PAYMENT_DATA = "paymentData";
    public static final ModelObject.Serializer<StatusRequest> SERIALIZER = new ModelObject.Serializer<StatusRequest>() {
        public JSONObject serialize(StatusRequest statusRequest) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("paymentData", statusRequest.getPaymentData());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(Address.class, e);
            }
        }

        public StatusRequest deserialize(JSONObject jSONObject) {
            StatusRequest statusRequest = new StatusRequest();
            statusRequest.setPaymentData(jSONObject.optString("paymentData", (String) null));
            return statusRequest;
        }
    };
    private String paymentData;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getPaymentData() {
        return this.paymentData;
    }

    public void setPaymentData(String str) {
        this.paymentData = str;
    }
}
