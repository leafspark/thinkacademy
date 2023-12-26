package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class WeChatPaySdkData extends SdkData {
    private static final String APP_ID = "appid";
    public static final ModelObject.Creator<WeChatPaySdkData> CREATOR = new ModelObject.Creator<>(WeChatPaySdkData.class);
    private static final String NONCE_STR = "noncestr";
    private static final String PACKAGE_VALUE = "packageValue";
    private static final String PARTNER_ID = "partnerid";
    private static final String PREPAY_ID = "prepayid";
    public static final ModelObject.Serializer<WeChatPaySdkData> SERIALIZER = new ModelObject.Serializer<WeChatPaySdkData>() {
        public JSONObject serialize(WeChatPaySdkData weChatPaySdkData) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(WeChatPaySdkData.APP_ID, weChatPaySdkData.getAppid());
                jSONObject.putOpt(WeChatPaySdkData.NONCE_STR, weChatPaySdkData.getNoncestr());
                jSONObject.putOpt(WeChatPaySdkData.PACKAGE_VALUE, weChatPaySdkData.getPackageValue());
                jSONObject.putOpt(WeChatPaySdkData.PARTNER_ID, weChatPaySdkData.getPartnerid());
                jSONObject.putOpt(WeChatPaySdkData.PREPAY_ID, weChatPaySdkData.getPrepayid());
                jSONObject.putOpt(WeChatPaySdkData.SIGN, weChatPaySdkData.getSign());
                jSONObject.putOpt(WeChatPaySdkData.TIMESTAMP, weChatPaySdkData.getTimestamp());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(WeChatPaySdkData.class, e);
            }
        }

        public WeChatPaySdkData deserialize(JSONObject jSONObject) {
            WeChatPaySdkData weChatPaySdkData = new WeChatPaySdkData();
            weChatPaySdkData.setAppid(jSONObject.optString(WeChatPaySdkData.APP_ID, (String) null));
            weChatPaySdkData.setNoncestr(jSONObject.optString(WeChatPaySdkData.NONCE_STR, (String) null));
            weChatPaySdkData.setPackageValue(jSONObject.optString(WeChatPaySdkData.PACKAGE_VALUE, (String) null));
            weChatPaySdkData.setPartnerid(jSONObject.optString(WeChatPaySdkData.PARTNER_ID, (String) null));
            weChatPaySdkData.setPrepayid(jSONObject.optString(WeChatPaySdkData.PREPAY_ID, (String) null));
            weChatPaySdkData.setSign(jSONObject.optString(WeChatPaySdkData.SIGN, (String) null));
            weChatPaySdkData.setTimestamp(jSONObject.optString(WeChatPaySdkData.TIMESTAMP, (String) null));
            return weChatPaySdkData;
        }
    };
    private static final String SIGN = "sign";
    private static final String TIMESTAMP = "timestamp";
    private String appid;
    private String noncestr;
    private String packageValue;
    private String partnerid;
    private String prepayid;
    private String sign;
    private String timestamp;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public String getNoncestr() {
        return this.noncestr;
    }

    public void setNoncestr(String str) {
        this.noncestr = str;
    }

    public String getPackageValue() {
        return this.packageValue;
    }

    public void setPackageValue(String str) {
        this.packageValue = str;
    }

    public String getPartnerid() {
        return this.partnerid;
    }

    public void setPartnerid(String str) {
        this.partnerid = str;
    }

    public String getPrepayid() {
        return this.prepayid;
    }

    public void setPrepayid(String str) {
        this.prepayid = str;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }
}
