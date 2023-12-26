package com.tal.app.thinkacademy.common.sensors;

import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/common/sensors/SensorInit$init$1", "Lcom/tal/app/thinkacademy/common/sensors/SAEventListenerAdapter;", "trackEvent", "", "eventObj", "Lorg/json/JSONObject;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SensorInit.kt */
public final class SensorInit$init$1 extends SAEventListenerAdapter {
    SensorInit$init$1() {
    }

    public void trackEvent(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            if (!Intrinsics.areEqual(jSONObject.optString("event"), "$AppClick")) {
                jSONObject = null;
            }
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("properties")) != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("$element_id", optJSONObject.optString("$element_id"));
                jSONObject2.put("$element_type", optJSONObject.optString("$element_type"));
                jSONObject2.put("$screen_name", optJSONObject.optString("$screen_name"));
                jSONObject2.put("按钮名称-$element_content", optJSONObject.optString("$element_content"));
                Object[] objArr = new Object[1];
                objArr[0] = !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
                XesLog.it("神策点击事件", objArr);
            }
        }
    }
}
