package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import java.util.concurrent.Future;

public class PersistentFlushDataState extends PersistentIdentity<Boolean> {
    public PersistentFlushDataState(Future<SharedPreferences> future) {
        super(future, "sub_process_flush_data", new PersistentIdentity.PersistentSerializer<Boolean>() {
            public Boolean load(String str) {
                return Boolean.valueOf("true".equals(str));
            }

            public String save(Boolean bool) {
                return bool == null ? create().toString() : String.valueOf(bool);
            }

            public Boolean create() {
                return true;
            }
        });
    }
}
