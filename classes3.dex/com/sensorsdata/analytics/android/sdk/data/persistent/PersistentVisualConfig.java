package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import java.util.concurrent.Future;

public class PersistentVisualConfig extends PersistentIdentity<String> {
    public PersistentVisualConfig(Future<SharedPreferences> future) {
        super(future, PersistentLoader.PersistentName.VISUAL_PROPERTIES, new PersistentIdentity.PersistentSerializer<String>() {
            public String create() {
                return null;
            }

            public String load(String str) {
                return str;
            }

            public String save(String str) {
                return str;
            }
        });
    }
}
