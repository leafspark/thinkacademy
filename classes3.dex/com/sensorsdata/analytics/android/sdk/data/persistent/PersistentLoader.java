package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.Future;

public class PersistentLoader {
    private static Context context;
    private static volatile PersistentLoader instance;
    private static Future<SharedPreferences> storedPreferences;

    public interface PersistentName {
        public static final String APP_END_DATA = "app_end_data";
        public static final String APP_PAUSED_TIME = "app_end_time";
        public static final String APP_START_TIME = "app_start_time";
        public static final String DISTINCT_ID = "events_distinct_id";
        public static final String FIRST_DAY = "first_day";
        public static final String FIRST_INSTALL = "first_track_installation";
        public static final String FIRST_INSTALL_CALLBACK = "first_track_installation_with_callback";
        public static final String FIRST_START = "first_start";
        public static final String LOGIN_ID = "events_login_id";
        public static final String REMOTE_CONFIG = "sensorsdata_sdk_configuration";
        public static final String SUB_PROCESS_FLUSH_DATA = "sub_process_flush_data";
        public static final String SUPER_PROPERTIES = "super_properties";
        public static final String VISUAL_PROPERTIES = "visual_properties";
    }

    private PersistentLoader(Context context2) {
        context = context2.getApplicationContext();
        storedPreferences = new SharedPreferencesLoader().loadPreferences(context2, "com.sensorsdata.analytics.android.sdk.SensorsDataAPI");
    }

    public static PersistentLoader initLoader(Context context2) {
        if (instance == null) {
            instance = new PersistentLoader(context2);
        }
        return instance;
    }

    public static PersistentIdentity loadPersistent(String str) {
        if (instance == null) {
            throw new RuntimeException("you should call 'PersistentLoader.initLoader(Context)' first");
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1436067305:
                    if (str.equals("events_login_id")) {
                        c = 0;
                        break;
                    }
                    break;
                case -951089033:
                    if (str.equals(PersistentName.SUPER_PROPERTIES)) {
                        c = 1;
                        break;
                    }
                    break;
                case -854148740:
                    if (str.equals(PersistentName.FIRST_INSTALL_CALLBACK)) {
                        c = 2;
                        break;
                    }
                    break;
                case -690407917:
                    if (str.equals(PersistentName.FIRST_START)) {
                        c = 3;
                        break;
                    }
                    break;
                case -212773998:
                    if (str.equals(PersistentName.VISUAL_PROPERTIES)) {
                        c = 4;
                        break;
                    }
                    break;
                case 133344653:
                    if (str.equals(PersistentName.FIRST_DAY)) {
                        c = 5;
                        break;
                    }
                    break;
                case 721318680:
                    if (str.equals(PersistentName.DISTINCT_ID)) {
                        c = 6;
                        break;
                    }
                    break;
                case 791585128:
                    if (str.equals("app_start_time")) {
                        c = 7;
                        break;
                    }
                    break;
                case 947194773:
                    if (str.equals(PersistentName.REMOTE_CONFIG)) {
                        c = 8;
                        break;
                    }
                    break;
                case 1214783133:
                    if (str.equals(PersistentName.FIRST_INSTALL)) {
                        c = 9;
                        break;
                    }
                    break;
                case 1521941740:
                    if (str.equals("app_end_data")) {
                        c = 10;
                        break;
                    }
                    break;
                case 1522425871:
                    if (str.equals("app_end_time")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1964784692:
                    if (str.equals("sub_process_flush_data")) {
                        c = 12;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new PersistentLoginId(storedPreferences);
                case 1:
                    return new PersistentSuperProperties(storedPreferences);
                case 2:
                    return new PersistentFirstTrackInstallationWithCallback(storedPreferences);
                case 3:
                    return new PersistentFirstStart(storedPreferences);
                case 4:
                    return new PersistentVisualConfig(storedPreferences);
                case 5:
                    return new PersistentFirstDay(storedPreferences);
                case 6:
                    return new PersistentDistinctId(storedPreferences, context);
                case 7:
                    return new PersistentAppStartTime(storedPreferences);
                case 8:
                    return new PersistentRemoteSDKConfig(storedPreferences);
                case 9:
                    return new PersistentFirstTrackInstallation(storedPreferences);
                case 10:
                    return new PersistentAppEndData(storedPreferences);
                case 11:
                    return new PersistentAppPaused(storedPreferences);
                case 12:
                    return new PersistentFlushDataState(storedPreferences);
                default:
                    return null;
            }
        }
    }
}
