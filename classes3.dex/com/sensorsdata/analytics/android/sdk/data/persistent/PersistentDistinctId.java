package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.UUID;
import java.util.concurrent.Future;

public class PersistentDistinctId extends PersistentIdentity<String> {
    public PersistentDistinctId(Future<SharedPreferences> future, final Context context) {
        super(future, PersistentLoader.PersistentName.DISTINCT_ID, new PersistentIdentity.PersistentSerializer<String>() {
            public String load(String str) {
                return str;
            }

            public String save(String str) {
                return str == null ? create() : str;
            }

            public String create() {
                String androidID = SensorsDataUtils.getAndroidID(context);
                if (SensorsDataUtils.isValidAndroidId(androidID)) {
                    return androidID;
                }
                return UUID.randomUUID().toString();
            }
        });
    }
}
