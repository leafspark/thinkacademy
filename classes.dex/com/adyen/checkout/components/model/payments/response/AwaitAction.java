package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class AwaitAction extends Action {
    public static final String ACTION_TYPE = "await";
    public static final ModelObject.Creator<AwaitAction> CREATOR = new ModelObject.Creator<>(AwaitAction.class);
    public static final ModelObject.Serializer<AwaitAction> SERIALIZER = new ModelObject.Serializer<AwaitAction>() {
        public JSONObject serialize(AwaitAction awaitAction) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", awaitAction.getType());
                jSONObject.putOpt("paymentData", awaitAction.getPaymentData());
                jSONObject.putOpt(Action.PAYMENT_METHOD_TYPE, awaitAction.getPaymentMethodType());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(RedirectAction.class, e);
            }
        }

        public AwaitAction deserialize(JSONObject jSONObject) {
            AwaitAction awaitAction = new AwaitAction();
            awaitAction.setType(jSONObject.optString("type", (String) null));
            awaitAction.setPaymentData(jSONObject.optString("paymentData", (String) null));
            awaitAction.setPaymentMethodType(jSONObject.optString(Action.PAYMENT_METHOD_TYPE, (String) null));
            return awaitAction;
        }
    };

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }
}
