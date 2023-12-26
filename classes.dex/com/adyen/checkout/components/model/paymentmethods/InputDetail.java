package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class InputDetail extends ModelObject {
    public static final ModelObject.Creator<InputDetail> CREATOR = new ModelObject.Creator<>(InputDetail.class);
    private static final String ITEMS = "items";
    public static final ModelObject.Serializer<InputDetail> SERIALIZER = new ModelObject.Serializer<InputDetail>() {
        public JSONObject serialize(InputDetail inputDetail) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(InputDetail.ITEMS, ModelUtils.serializeOptList(inputDetail.getItems(), Item.SERIALIZER));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(InputDetail.class, e);
            }
        }

        public InputDetail deserialize(JSONObject jSONObject) {
            InputDetail inputDetail = new InputDetail();
            inputDetail.setItems(ModelUtils.deserializeOptList(jSONObject.optJSONArray(InputDetail.ITEMS), Item.SERIALIZER));
            return inputDetail;
        }
    };
    private List<Item> items;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> list) {
        this.items = list;
    }
}
