package com.yanzhenjie.andserver.framework.body;

import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.yanzhenjie.andserver.util.MediaType;
import org.json.JSONObject;

public class JsonBody extends StringBody {
    public JsonBody(String str) {
        super(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonBody(JSONObject jSONObject) {
        super(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
    }

    public MediaType contentType() {
        return MediaType.APPLICATION_JSON_UTF8;
    }
}
