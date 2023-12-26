package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class MBWayPaymentMethod extends PaymentMethodDetails {
    public static final ModelObject.Creator<MBWayPaymentMethod> CREATOR = new ModelObject.Creator<>(MBWayPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "mbway";
    public static final ModelObject.Serializer<MBWayPaymentMethod> SERIALIZER = new ModelObject.Serializer<MBWayPaymentMethod>() {
        public JSONObject serialize(MBWayPaymentMethod mBWayPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", mBWayPaymentMethod.getType());
                jSONObject.putOpt(MBWayPaymentMethod.TELEPHONE_NUMBER, mBWayPaymentMethod.getTelephoneNumber());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(GooglePayPaymentMethod.class, e);
            }
        }

        public MBWayPaymentMethod deserialize(JSONObject jSONObject) {
            MBWayPaymentMethod mBWayPaymentMethod = new MBWayPaymentMethod();
            mBWayPaymentMethod.setType(jSONObject.optString("type", (String) null));
            mBWayPaymentMethod.setTelephoneNumber(jSONObject.optString(MBWayPaymentMethod.TELEPHONE_NUMBER, (String) null));
            return mBWayPaymentMethod;
        }
    };
    private static final String TELEPHONE_NUMBER = "telephoneNumber";
    private String telephoneNumber;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public void setTelephoneNumber(String str) {
        this.telephoneNumber = str;
    }
}
