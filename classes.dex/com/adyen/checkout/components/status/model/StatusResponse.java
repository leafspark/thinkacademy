package com.adyen.checkout.components.status.model;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.request.Address;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class StatusResponse extends ModelObject {
    public static final ModelObject.Creator<StatusResponse> CREATOR = new ModelObject.Creator<>(StatusResponse.class);
    public static final String PAYLOAD = "payload";
    public static final String RESULT_CODE = "resultCode";
    public static final ModelObject.Serializer<StatusResponse> SERIALIZER = new ModelObject.Serializer<StatusResponse>() {
        public JSONObject serialize(StatusResponse statusResponse) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", statusResponse.getType());
                jSONObject.putOpt(StatusResponse.PAYLOAD, statusResponse.getPayload());
                jSONObject.putOpt(StatusResponse.RESULT_CODE, statusResponse.getResultCode());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(Address.class, e);
            }
        }

        public StatusResponse deserialize(JSONObject jSONObject) {
            StatusResponse statusResponse = new StatusResponse();
            statusResponse.setType(jSONObject.optString("type", (String) null));
            statusResponse.setPayload(jSONObject.optString(StatusResponse.PAYLOAD, (String) null));
            statusResponse.setResultCode(jSONObject.optString(StatusResponse.RESULT_CODE, (String) null));
            return statusResponse;
        }
    };
    public static final String TYPE = "type";
    private String payload;
    private String resultCode;
    private String type;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getPayload() {
        return this.payload;
    }

    public void setPayload(String str) {
        this.payload = str;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }
}
