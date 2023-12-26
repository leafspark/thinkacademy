package com.amazonaws.cognito.clientcontext.data;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.amazonaws.cognito.clientcontext.datacollection.ContextDataAggregator;
import com.amazonaws.cognito.clientcontext.util.SignatureGenerator;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UserContextDataProvider {
    private static final String TAG = "UserContextDataProvider";
    public static final String VERSION = "ANDROID20171114";
    private ContextDataAggregator aggregator;
    private SignatureGenerator signatureGenerator;

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final UserContextDataProvider INSTANCE = new UserContextDataProvider();

        private InstanceHolder() {
        }
    }

    private UserContextDataProvider() {
        this(ContextDataAggregator.getInstance(), new SignatureGenerator());
    }

    protected UserContextDataProvider(ContextDataAggregator contextDataAggregator, SignatureGenerator signatureGenerator2) {
        this.aggregator = contextDataAggregator;
        this.signatureGenerator = signatureGenerator2;
    }

    public static UserContextDataProvider getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public String getEncodedContextData(Context context, String str, String str2, String str3) {
        new JSONObject();
        try {
            JSONObject jsonPayload = getJsonPayload(this.aggregator.getAggregatedData(context), str, str2);
            String jSONObject = !(jsonPayload instanceof JSONObject) ? jsonPayload.toString() : JSONObjectInstrumentation.toString(jsonPayload);
            return getEncodedResponse(getJsonResponse(jSONObject, this.signatureGenerator.getSignature(jSONObject, str3, VERSION)));
        } catch (Exception unused) {
            Log.e(TAG, "Exception in creating JSON from context data");
            return null;
        }
    }

    private JSONObject getJsonPayload(Map<String, String> map, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("contextData", new JSONObject(map));
        jSONObject.put("username", str);
        jSONObject.put("userPoolId", str2);
        jSONObject.put("timestamp", getTimestamp());
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public String getTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    private JSONObject getJsonResponse(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(StatusResponse.PAYLOAD, str);
        jSONObject.put("signature", str2);
        jSONObject.put("version", VERSION);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public String getEncodedResponse(JSONObject jSONObject) {
        return Base64.encodeToString((!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).getBytes(ConfigurationConstant.DEFAULT_CHARSET), 0);
    }

    private class ContextDataJsonKeys {
        private static final String CONTEXT_DATA = "contextData";
        private static final String DATA_PAYLOAD = "payload";
        private static final String SIGNATURE = "signature";
        private static final String TIMESTAMP_MILLI_SEC = "timestamp";
        private static final String USERNAME = "username";
        private static final String USER_POOL_ID = "userPoolId";
        private static final String VERSION = "version";

        private ContextDataJsonKeys() {
        }
    }
}
