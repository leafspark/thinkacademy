package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import java.util.concurrent.Future;

public class PersistentRemoteSDKConfig extends PersistentIdentity<String> {
    public PersistentRemoteSDKConfig(Future<SharedPreferences> future) {
        super(future, PersistentLoader.PersistentName.REMOTE_CONFIG, new PersistentIdentity.PersistentSerializer<String>() {
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
