package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import java.util.concurrent.Future;

public class PersistentFirstTrackInstallationWithCallback extends PersistentIdentity<Boolean> {
    public PersistentFirstTrackInstallationWithCallback(Future<SharedPreferences> future) {
        super(future, PersistentLoader.PersistentName.FIRST_INSTALL_CALLBACK, new PersistentIdentity.PersistentSerializer<Boolean>() {
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
