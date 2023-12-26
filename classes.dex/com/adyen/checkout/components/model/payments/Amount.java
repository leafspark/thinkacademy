package com.adyen.checkout.components.model.payments;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class Amount extends ModelObject {
    public static final ModelObject.Creator<Amount> CREATOR = new ModelObject.Creator<>(Amount.class);
    private static final String CURRENCY = "currency";
    public static final Amount EMPTY;
    private static final String EMPTY_CURRENCY = "NONE";
    private static final int EMPTY_VALUE = -1;
    public static final ModelObject.Serializer<Amount> SERIALIZER = new ModelObject.Serializer<Amount>() {
        public JSONObject serialize(Amount amount) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(Amount.CURRENCY, amount.getCurrency());
                jSONObject.putOpt(Amount.VALUE, Integer.valueOf(amount.getValue()));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(Amount.class, e);
            }
        }

        public Amount deserialize(JSONObject jSONObject) {
            Amount amount = new Amount();
            amount.setCurrency(jSONObject.optString(Amount.CURRENCY, (String) null));
            amount.setValue(jSONObject.optInt(Amount.VALUE, -1));
            return amount;
        }
    };
    private static final String VALUE = "value";
    private String currency;
    private int value;

    static {
        Amount amount = new Amount();
        EMPTY = amount;
        amount.setCurrency(EMPTY_CURRENCY);
        amount.setValue(-1);
    }

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public boolean isEmpty() {
        return EMPTY_CURRENCY.equals(this.currency) || this.value == -1;
    }

    public String toString() {
        return "Amount(" + this.currency + ", " + this.value + ")";
    }
}
