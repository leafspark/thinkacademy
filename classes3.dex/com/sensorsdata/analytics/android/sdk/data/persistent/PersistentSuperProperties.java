package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistentSuperProperties extends PersistentIdentity<JSONObject> {
    public PersistentSuperProperties(Future<SharedPreferences> future) {
        super(future, PersistentLoader.PersistentName.SUPER_PROPERTIES, new PersistentIdentity.PersistentSerializer<JSONObject>() {
            public JSONObject load(String str) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e) {
                    SALog.d("Persistent", "failed to load SuperProperties from SharedPreferences.", e);
                    return new JSONObject();
                }
            }

            public String save(JSONObject jSONObject) {
                if (jSONObject == null) {
                    jSONObject = create();
                }
                return jSONObject.toString();
            }

            public JSONObject create() {
                return new JSONObject();
            }
        });
    }
}
