package com.tal.app.thinkacademy.common.oom;

import android.app.Application;
import android.os.Build;
import com.kwai.koom.base.CommonConfig;
import com.kwai.koom.base.InitTask;
import com.kwai.koom.base.MonitorManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/oom/HwOomInitTask;", "Lcom/kwai/koom/base/InitTask;", "()V", "init", "", "application", "Landroid/app/Application;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwOomInitTask.kt */
public final class HwOomInitTask implements InitTask {
    public static final HwOomInitTask INSTANCE = new HwOomInitTask();

    private HwOomInitTask() {
    }

    public void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        boolean z = false;
        CommonConfig.Builder versionNameInvoker = new CommonConfig.Builder().setApplication(application).setDebugMode(false).setVersionNameInvoker(HwOomInitTask$init$config$1.INSTANCE);
        if (Build.VERSION.SDK_INT <= 31) {
            z = true;
        }
        MonitorManager.initCommonConfig(versionNameInvoker.setSdkVersionMatch(z).build());
        MonitorManager.onApplicationCreate();
    }
}
