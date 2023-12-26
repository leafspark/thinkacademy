package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentMethod extends ModelObject {
    private static final String BRAND = "brand";
    private static final String BRANDS = "brands";
    private static final String CONFIGURATION = "configuration";
    public static final ModelObject.Creator<PaymentMethod> CREATOR = new ModelObject.Creator<>(PaymentMethod.class);
    private static final String DETAILS = "details";
    private static final String FUNDING_SOURCE = "fundingSource";
    private static final String ISSUERS = "issuers";
    private static final String NAME = "name";
    public static final ModelObject.Serializer<PaymentMethod> SERIALIZER = new ModelObject.Serializer<PaymentMethod>() {
        public JSONObject serialize(PaymentMethod paymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", paymentMethod.getType());
                jSONObject.putOpt(PaymentMethod.NAME, paymentMethod.getName());
                jSONObject.putOpt(PaymentMethod.BRANDS, JsonUtils.serializeOptStringList(paymentMethod.getBrands()));
                jSONObject.putOpt(PaymentMethod.BRAND, paymentMethod.getBrand());
                jSONObject.putOpt(PaymentMethod.FUNDING_SOURCE, paymentMethod.getFundingSource());
                jSONObject.putOpt(PaymentMethod.ISSUERS, ModelUtils.serializeOptList(paymentMethod.getIssuers(), Issuer.SERIALIZER));
                jSONObject.putOpt(PaymentMethod.CONFIGURATION, ModelUtils.serializeOpt(paymentMethod.getConfiguration(), Configuration.SERIALIZER));
                jSONObject.putOpt(PaymentMethod.DETAILS, ModelUtils.serializeOptList(paymentMethod.getDetails(), InputDetail.SERIALIZER));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(PaymentMethod.class, e);
            }
        }

        public PaymentMethod deserialize(JSONObject jSONObject) {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setType(jSONObject.optString("type", (String) null));
            paymentMethod.setName(jSONObject.optString(PaymentMethod.NAME, (String) null));
            paymentMethod.setBrands(JsonUtils.parseOptStringList(jSONObject.optJSONArray(PaymentMethod.BRANDS)));
            paymentMethod.setBrand(jSONObject.optString(PaymentMethod.BRAND, (String) null));
            paymentMethod.setFundingSource(jSONObject.optString(PaymentMethod.FUNDING_SOURCE, (String) null));
            paymentMethod.setIssuers(ModelUtils.deserializeOptList(jSONObject.optJSONArray(PaymentMethod.ISSUERS), Issuer.SERIALIZER));
            paymentMethod.setConfiguration((Configuration) ModelUtils.deserializeOpt(jSONObject.optJSONObject(PaymentMethod.CONFIGURATION), Configuration.SERIALIZER));
            paymentMethod.setDetails(ModelUtils.deserializeOptList(jSONObject.optJSONArray(PaymentMethod.DETAILS), InputDetail.SERIALIZER));
            return paymentMethod;
        }
    };
    private static final String TYPE = "type";
    private String brand;
    private List<String> brands;
    private Configuration configuration;
    private List<InputDetail> details;
    private String fundingSource;
    private List<Issuer> issuers;
    private String name;
    private String type;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getBrands() {
        return this.brands;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getFundingSource() {
        return this.fundingSource;
    }

    public List<Issuer> getIssuers() {
        return this.issuers;
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public List<InputDetail> getDetails() {
        return this.details;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setBrands(List<String> list) {
        this.brands = list;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setFundingSource(String str) {
        this.fundingSource = str;
    }

    public void setIssuers(List<Issuer> list) {
        this.issuers = list;
    }

    public void setConfiguration(Configuration configuration2) {
        this.configuration = configuration2;
    }

    public void setDetails(List<InputDetail> list) {
        this.details = list;
    }
}
