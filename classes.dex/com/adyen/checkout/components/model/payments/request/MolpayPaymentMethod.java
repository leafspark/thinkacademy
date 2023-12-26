package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class MolpayPaymentMethod extends IssuerListPaymentMethod {
    public static final ModelObject.Creator<MolpayPaymentMethod> CREATOR = new ModelObject.Creator<>(MolpayPaymentMethod.class);
    public static final ModelObject.Serializer<MolpayPaymentMethod> SERIALIZER = new ModelObject.Serializer<MolpayPaymentMethod>() {
        public JSONObject serialize(MolpayPaymentMethod molpayPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", molpayPaymentMethod.getType());
                jSONObject.putOpt("issuer", molpayPaymentMethod.getIssuer());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(MolpayPaymentMethod.class, e);
            }
        }

        public MolpayPaymentMethod deserialize(JSONObject jSONObject) {
            MolpayPaymentMethod molpayPaymentMethod = new MolpayPaymentMethod();
            molpayPaymentMethod.setType(jSONObject.optString("type", (String) null));
            molpayPaymentMethod.setIssuer(jSONObject.optString("issuer", (String) null));
            return molpayPaymentMethod;
        }
    };

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }
}
