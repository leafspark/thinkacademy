package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import java.util.concurrent.Future;

public class PersistentAppStartTime extends PersistentIdentity<Long> {
    public PersistentAppStartTime(Future<SharedPreferences> future) {
        super(future, "app_start_time", new PersistentIdentity.PersistentSerializer<Long>() {
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
