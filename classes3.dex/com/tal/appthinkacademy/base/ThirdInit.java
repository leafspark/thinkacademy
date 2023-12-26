package com.tal.appthinkacademy.base;

import android.app.Application;
import android.text.TextUtils;
import com.tal.app.thinkacademy.BuildConfig;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.bonree.BonreeInit;
import com.tal.app.thinkacademy.common.sensors.SensorInit;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/appthinkacademy/base/ThirdInit;", "", "()V", "BONREE_APP_KEY", "", "SENSOR_URL", "TAG", "init", "", "application", "Landroid/app/Application;", "initBonree", "initConfigInfo", "initSensor", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThirdInit.kt */
public final class ThirdInit {
    private static String BONREE_APP_KEY = null;
    public static final ThirdInit INSTANCE = new ThirdInit();
    private static String SENSOR_URL = null;
    private static final String TAG = "ThirdInit";

    private ThirdInit() {
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        initConfigInfo();
        initBonree(application);
        initSensor(application);
    }

    private final void initConfigInfo() {
        try {
            if (Intrinsics.areEqual((Object) ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), (Object) "8601")) {
                SENSOR_URL = BuildConfig.SENSOR_TEST_URL;
                BONREE_APP_KEY = BuildConfig.BONREE_TEST_APP_KEY;
            } else {
                SENSOR_URL = BuildConfig.SENSOR_URL;
                BONREE_APP_KEY = BuildConfig.BONREE_APP_KEY;
            }
            XesLog.it(TAG, new Object[]{"神策数据接收地址=" + SENSOR_URL + ",博睿AppKey=" + BONREE_APP_KEY});
        } catch (Exception e) {
            XesLog.it(TAG, new Object[]{"初始化三方工具配置异常"});
            e.printStackTrace();
        }
    }

    private final void initSensor(Application application) {
        if (!TextUtils.isEmpty(SENSOR_URL)) {
            SensorInit.INSTANCE.init(application, SENSOR_URL);
            return;
        }
        XesLog.it(TAG, new Object[]{"intSensor error,serverUrl is null"});
    }

    private final void initBonree(Application application) {
        if (!TextUtils.isEmpty(BONREE_APP_KEY)) {
            BonreeInit.INSTANCE.init(application, BONREE_APP_KEY);
            return;
        }
        XesLog.it(TAG, new Object[]{"initBonree error,bonreeAppKey is null"});
    }
}
