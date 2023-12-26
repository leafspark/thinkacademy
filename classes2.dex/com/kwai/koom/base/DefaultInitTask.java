package com.kwai.koom.base;

import android.app.Application;
import android.os.Build;
import com.kwai.koom.base.CommonConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/kwai/koom/base/DefaultInitTask;", "Lcom/kwai/koom/base/InitTask;", "()V", "init", "", "application", "Landroid/app/Application;", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: DefaultInitTask.kt */
public final class DefaultInitTask implements InitTask {
    public static final DefaultInitTask INSTANCE = new DefaultInitTask();

    private DefaultInitTask() {
    }

    public void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        MonitorManager.initCommonConfig(new CommonConfig.Builder().setApplication(application).setVersionNameInvoker(DefaultInitTask$init$config$1.INSTANCE).setSdkVersionMatch(Build.VERSION.SDK_INT <= 31 && Build.VERSION.SDK_INT >= 21).build());
        MonitorManager.onApplicationCreate();
    }
}
