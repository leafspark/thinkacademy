package com.tal.app.thinkacademy.common.sensors;

import android.app.Application;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/sensors/SensorInit;", "", "()V", "init", "", "application", "Landroid/app/Application;", "SENSOR_URL", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SensorInit.kt */
public final class SensorInit {
    public static final SensorInit INSTANCE = new SensorInit();

    private SensorInit() {
    }

    public final void init(Application application, String str) {
        Intrinsics.checkNotNullParameter(application, "application");
        SAConfigOptions sAConfigOptions = new SAConfigOptions(str);
        sAConfigOptions.setAutoTrackEventType(15).enableLog(false).enableTrackAppCrash().enableJavaScriptBridge(true);
        SensorsDataAPI.startWithConfigOptions(application, sAConfigOptions);
        SensorsDataAPI.sharedInstance().trackFragmentAppViewScreen();
        SensorsProperty.Companion.getInstance().profileSetOnce();
        SensorsProperty.Companion.getInstance().superProperties();
        SensorsProperty.Companion.getInstance().dynamicSuperProperties();
        SensorsProperty.Companion.getInstance().trackAppInstall();
        SensorsDataAPI.sharedInstance().addEventListener(new SensorInit$init$1());
    }
}
