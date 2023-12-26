package com.adyen.checkout.components.status.api;

import com.adyen.checkout.components.status.model.StatusRequest;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.adyen.checkout.core.api.Connection;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

class StatusConnection extends Connection<StatusResponse> {
    private static final String TAG = LogUtil.getTag();
    private final StatusRequest mStatusRequest;

    StatusConnection(String str, StatusRequest statusRequest) {
        super(str);
        this.mStatusRequest = statusRequest;
    }

    public StatusResponse call() throws IOException, JSONException {
        String str = TAG;
        Logger.v(str, "call - " + getUrl());
        JSONObject serialize = StatusRequest.SERIALIZER.serialize(this.mStatusRequest);
        return StatusResponse.SERIALIZER.deserialize(new JSONObject(new String(post(CONTENT_TYPE_JSON_HEADER, (!(serialize instanceof JSONObject) ? serialize.toString() : JSONObjectInstrumentation.toString(serialize)).getBytes(Charset.defaultCharset())), Charset.defaultCharset())));
    }
}
