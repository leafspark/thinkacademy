package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import java.util.concurrent.Future;

public class PersistentAppEndData extends PersistentIdentity<String> {
    public PersistentAppEndData(Future<SharedPreferences> future) {
        super(future, "app_end_data", new PersistentIdentity.PersistentSerializer<String>() {
            public String create() {
                return "";
            }

            public String load(String str) {
                return str;
            }

            public String save(String str) {
                return str == null ? create() : str;
            }
        });
    }
}
