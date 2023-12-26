package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class Item extends ModelObject {
    public static final ModelObject.Creator<Item> CREATOR = new ModelObject.Creator<>(Item.class);
    private static final String ID = "id";
    private static final String NAME = "name";
    public static final ModelObject.Serializer<Item> SERIALIZER = new ModelObject.Serializer<Item>() {
        public JSONObject serialize(Item item) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(Item.ID, item.getId());
                jSONObject.putOpt(Item.NAME, item.getName());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(Item.class, e);
            }
        }

        public Item deserialize(JSONObject jSONObject) {
            Item item = new Item();
            item.setId(jSONObject.optString(Item.ID, (String) null));
            item.setName(jSONObject.optString(Item.NAME, (String) null));
            return item;
        }
    };
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

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
