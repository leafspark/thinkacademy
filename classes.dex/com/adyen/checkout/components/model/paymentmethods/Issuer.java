package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class Issuer extends ModelObject {
    public static final ModelObject.Creator<Issuer> CREATOR = new ModelObject.Creator<>(Issuer.class);
    private static final String DISABLED = "disabled";
    private static final String ID = "id";
    private static final String NAME = "name";
    public static final ModelObject.Serializer<Issuer> SERIALIZER = new ModelObject.Serializer<Issuer>() {
        public JSONObject serialize(Issuer issuer) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(Issuer.ID, issuer.getId());
                jSONObject.putOpt(Issuer.NAME, issuer.getName());
                jSONObject.putOpt(Issuer.DISABLED, Boolean.valueOf(issuer.isDisabled()));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(PaymentMethod.class, e);
            }
        }

        public Issuer deserialize(JSONObject jSONObject) {
            Issuer issuer = new Issuer();
            issuer.setId(jSONObject.optString(Issuer.ID, (String) null));
            issuer.setName(jSONObject.optString(Issuer.NAME, (String) null));
            issuer.setDisabled(jSONObject.optBoolean(Issuer.DISABLED, false));
            return issuer;
        }
    };
    private boolean disabled;
    private String id;
    private String name;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setDisabled(boolean z) {
        this.disabled = z;
    }
}
