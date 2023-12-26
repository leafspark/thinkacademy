package com.bonree.sdk.agent.engine.external;

import android.app.Application;
import android.content.Context;
import com.bonree.sdk.aq.h;
import com.bonree.sdk.bs.q;
import ohos.aafwk.ability.AbilityPackage;

public class AppStateInfo {
    public static final String ATTACH_BASE_CONTEXT = "attachBaseContext";
    public static final String ON_INITIALIZE = "onInitialize";
    public static final String RECORD_CUSTOM_LAUNCH_END = "recordCustomLaunchEnd";
    public static final String RECORD_LAUNCH_TIME = "recordLaunchTime";
    public static final String RECORD_LAUNCH_TIME_OHOS = "recordLaunchTimeOhos";

    public static void attachBaseContextBegin(Application application, Context context) {
        h.a().a(application, ATTACH_BASE_CONTEXT, context);
    }

    public static void attachBaseContextEnd() {
        h.a().d();
    }

    public static void onCreateAppBegin(String str) {
        h.a().b(str);
    }

    public static void onCreateAppEnd(String str) {
        h.a().e();
    }

    public static void recordLaunchTime(Application application) {
        h.a().a(application, RECORD_LAUNCH_TIME, (Context) null);
    }

    public static void recordLaunchTime(Application application, Context context) {
        h.a().a(application, RECORD_LAUNCH_TIME, context);
    }

    public static void recordCustomLaunchEnd() {
        h.a().h();
    }

    public static void recordLaunchTime(AbilityPackage abilityPackage) {
        q.a(abilityPackage);
        h.a().a(abilityPackage, RECORD_LAUNCH_TIME_OHOS, (ohos.app.Context) null);
    }

    public static void recordLaunchTime(AbilityPackage abilityPackage, ohos.app.Context context) {
        h.a().a(abilityPackage, RECORD_LAUNCH_TIME_OHOS, context);
    }

    public static void attachBaseContextBeginOhos(AbilityPackage abilityPackage, ohos.app.Context context) {
        q.a(abilityPackage);
        h.a().a(abilityPackage, ATTACH_BASE_CONTEXT, context);
    }

    public static void attachBaseContextEndOhos() {
        h.a().d();
    }

    public static void initializeContextBeginOhos(ohos.app.Context context) {
        q.a(context);
        h.a().c(context.getClass().getName());
    }

    public static void initializeContextEndOhos() {
        h.a().g();
    }

    public static void recordCustomLaunchEndOhos() {
        h.a().h();
    }
}
