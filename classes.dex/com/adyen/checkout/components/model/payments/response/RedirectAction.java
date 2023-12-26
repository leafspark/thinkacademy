package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class RedirectAction extends Action {
    public static final String ACTION_TYPE = "redirect";
    public static final ModelObject.Creator<RedirectAction> CREATOR = new ModelObject.Creator<>(RedirectAction.class);
    private static final String METHOD = "method";
    public static final ModelObject.Serializer<RedirectAction> SERIALIZER = new ModelObject.Serializer<RedirectAction>() {
        public JSONObject serialize(RedirectAction redirectAction) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", redirectAction.getType());
                jSONObject.putOpt("paymentData", redirectAction.getPaymentData());
                jSONObject.putOpt(Action.PAYMENT_METHOD_TYPE, redirectAction.getPaymentMethodType());
                jSONObject.putOpt(RedirectAction.METHOD, redirectAction.getMethod());
                jSONObject.putOpt("url", redirectAction.getUrl());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(RedirectAction.class, e);
            }
        }

        public RedirectAction deserialize(JSONObject jSONObject) {
            RedirectAction redirectAction = new RedirectAction();
            redirectAction.setType(jSONObject.optString("type", (String) null));
            redirectAction.setPaymentData(jSONObject.optString("paymentData", (String) null));
            redirectAction.setPaymentMethodType(jSONObject.optString(Action.PAYMENT_METHOD_TYPE, (String) null));
            redirectAction.setMethod(jSONObject.optString(RedirectAction.METHOD, (String) null));
            redirectAction.setUrl(jSONObject.optString("url", (String) null));
            return redirectAction;
        }
    };
    private static final String URL = "url";
    private String method;
    private String url;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
