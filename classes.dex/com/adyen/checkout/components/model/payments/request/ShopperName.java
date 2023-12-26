package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class ShopperName extends ModelObject {
    public static final ModelObject.Creator<ShopperName> CREATOR = new ModelObject.Creator<>(ShopperName.class);
    private static final String FIRST_NAME = "firstName";
    private static final String GENDER = "gender";
    private static final String INFIX = "infix";
    private static final String LAST_NAME = "lastName";
    public static final ModelObject.Serializer<ShopperName> SERIALIZER = new ModelObject.Serializer<ShopperName>() {
        public JSONObject serialize(ShopperName shopperName) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(ShopperName.FIRST_NAME, shopperName.getFirstName());
                jSONObject.putOpt(ShopperName.INFIX, shopperName.getInfix());
                jSONObject.putOpt(ShopperName.LAST_NAME, shopperName.getLastName());
                jSONObject.putOpt(ShopperName.GENDER, shopperName.getGender());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(ShopperName.class, e);
            }
        }

        public ShopperName deserialize(JSONObject jSONObject) {
            ShopperName shopperName = new ShopperName();
            shopperName.setFirstName(jSONObject.optString(ShopperName.FIRST_NAME, (String) null));
            shopperName.setInfix(jSONObject.optString(ShopperName.INFIX, (String) null));
            shopperName.setLastName(jSONObject.optString(ShopperName.LAST_NAME, (String) null));
            shopperName.setGender(jSONObject.optString(ShopperName.GENDER, (String) null));
            return shopperName;
        }
    };
    private String firstName;
    private String gender;
    private String infix;
    private String lastName;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getInfix() {
        return this.infix;
    }

    public void setInfix(String str) {
        this.infix = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }
}
