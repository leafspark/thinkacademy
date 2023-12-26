package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import java.util.concurrent.Future;

public class PersistentAppPaused extends PersistentIdentity<Long> {
    public PersistentAppPaused(Future<SharedPreferences> future) {
        super(future, "app_end_time", new PersistentIdentity.PersistentSerializer<Long>() {
            public Long load(String str) {
                return Long.valueOf(str);
            }

            public String save(Long l) {
                return l == null ? create().toString() : String.valueOf(l);
            }

            public Long create() {
                return 0L;
            }
        });
    }
}
