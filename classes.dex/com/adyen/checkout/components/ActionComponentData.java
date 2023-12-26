package com.adyen.checkout.components;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionComponentData extends ModelObject {
    public static final ModelObject.Creator<ActionComponentData> CREATOR = new ModelObject.Creator<>(ActionComponentData.class);
    private static final String DETAILS = "details";
    private static final String PAYMENT_DATA = "paymentData";
    public static final ModelObject.Serializer<ActionComponentData> SERIALIZER = new ModelObject.Serializer<ActionComponentData>() {
        public JSONObject serialize(ActionComponentData actionComponentData) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("paymentData", actionComponentData.getPaymentData());
                jSONObject.putOpt(ActionComponentData.DETAILS, actionComponentData.getDetails());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(ActionComponentData.class, e);
            }
        }

        public ActionComponentData deserialize(JSONObject jSONObject) {
            ActionComponentData actionComponentData = new ActionComponentData();
            actionComponentData.setPaymentData(jSONObject.optString("paymentData"));
            actionComponentData.setDetails(jSONObject.optJSONObject(ActionComponentData.DETAILS));
            return actionComponentData;
        }
    };
    private JSONObject details;
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

    public JSONObject getDetails() {
        return this.details;
    }

    public void setDetails(JSONObject jSONObject) {
        this.details = jSONObject;
    }
}
