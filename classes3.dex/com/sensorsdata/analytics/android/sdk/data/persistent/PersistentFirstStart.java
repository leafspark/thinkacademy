package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import java.util.concurrent.Future;

public class PersistentFirstStart extends PersistentIdentity<Boolean> {
    public PersistentFirstStart(Future<SharedPreferences> future) {
        super(future, PersistentLoader.PersistentName.FIRST_START, new PersistentIdentity.PersistentSerializer<Boolean>() {
            public Boolean load(String str) {
                return false;
            }

            public String save(Boolean bool) {
                return bool == null ? create().toString() : String.valueOf(true);
            }

            public Boolean create() {
                return true;
            }
        });
    }
}
