package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import java.util.concurrent.Future;

public class PersistentFirstTrackInstallation extends PersistentIdentity<Boolean> {
    public PersistentFirstTrackInstallation(Future<SharedPreferences> future) {
        super(future, PersistentLoader.PersistentName.FIRST_INSTALL, new PersistentIdentity.PersistentSerializer<Boolean>() {
            public Boolean load(String str) {
                return Boolean.valueOf(str);
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
