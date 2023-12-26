package com.tal.app.thinkacademy.common.business;

import android.content.Context;
import android.content.Intent;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.DownloadManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppVersionBll.kt */
final class AppVersionBll$checkOrDownload$1$1 extends Lambda implements Function1<DownloadManager.ListenerHolder, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $downLoadError;
    final /* synthetic */ Function1<Integer, Unit> $downLoadProgress;
    final /* synthetic */ Function0<Unit> $downLoadSuccess;
    final /* synthetic */ NotificationHelper $notificationHelper;
    final /* synthetic */ File $targetFile;
    final /* synthetic */ DownloadManager.Task $this_apply;
    final /* synthetic */ AppVersionBll this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppVersionBll$checkOrDownload$1$1(AppVersionBll appVersionBll, NotificationHelper notificationHelper, Context context, Function1<? super Integer, Unit> function1, Function0<Unit> function0, File file, DownloadManager.Task task, Function0<Unit> function02) {
        super(1);
        this.this$0 = appVersionBll;
        this.$notificationHelper = notificationHelper;
        this.$context = context;
        this.$downLoadProgress = function1;
        this.$downLoadSuccess = function0;
        this.$targetFile = file;
        this.$this_apply = task;
        this.$downLoadError = function02;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DownloadManager.ListenerHolder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DownloadManager.ListenerHolder listenerHolder) {
        Intrinsics.checkNotNullParameter(listenerHolder, "$this$setCallback");
        final AppVersionBll appVersionBll = this.this$0;
        final NotificationHelper notificationHelper = this.$notificationHelper;
        final Context context = this.$context;
        final Function1<Integer, Unit> function1 = this.$downLoadProgress;
        listenerHolder.onProgress(new Function2<String, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String str, int i) {
                Intrinsics.checkNotNullParameter(str, "$noName_0");
                XesLog.i(appVersionBll.tag, "App安装包 下载进度 " + i + " %");
                if (appVersionBll.mAutoInstallApp) {
                    NotificationHelper notificationHelper = notificationHelper;
                    Context context = context;
                    Intent intent = new Intent();
                    String string = context.getString(R.string.app_thinkacademy_name);
                    notificationHelper.appUpdateDownloadNotificationDisplay(context, intent, string, context.getString(R.string.downloading) + 65292 + i + '%', false);
                } else {
                    notificationHelper.appUpdateDownloadNotificationCancel();
                }
                Function1<Integer, Unit> function1 = function1;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(i));
                }
            }
        });
        final AppVersionBll appVersionBll2 = this.this$0;
        final Function0<Unit> function0 = this.$downLoadSuccess;
        final File file = this.$targetFile;
        final NotificationHelper notificationHelper2 = this.$notificationHelper;
        listenerHolder.onSuccess(new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                XesLog.s(appVersionBll2.tag, "App安装包 下载成功");
                Function0<Unit> function0 = function0;
                if (function0 != null) {
                    function0.invoke();
                }
                if (appVersionBll2.mAutoInstallApp) {
                    AppVersionBll appVersionBll = appVersionBll2;
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "targetFile.absolutePath");
                    appVersionBll.installApk(absolutePath);
                }
                notificationHelper2.appUpdateDownloadNotificationCancel();
                appVersionBll2.mDownloadUrl = "";
                appVersionBll2.mApkMd5 = "";
            }
        });
        final AppVersionBll appVersionBll3 = this.this$0;
        final DownloadManager.Task task = this.$this_apply;
        final NotificationHelper notificationHelper3 = this.$notificationHelper;
        listenerHolder.onCancel(new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                XesLog.s(appVersionBll3.tag, "App安装包 暂停下载 " + task.progress() + '%');
                notificationHelper3.appUpdateDownloadNotificationCancel();
            }
        });
        final AppVersionBll appVersionBll4 = this.this$0;
        final Function0<Unit> function02 = this.$downLoadError;
        final NotificationHelper notificationHelper4 = this.$notificationHelper;
        final Context context2 = this.$context;
        listenerHolder.onError(new Function2<String, Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (Throwable) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, Throwable th) {
                Intrinsics.checkNotNullParameter(str, "$noName_0");
                Intrinsics.checkNotNullParameter(th, "e");
                XesLog.e(appVersionBll4.tag, Intrinsics.stringPlus("App安装包 下载失败 ", th));
                Function0<Unit> function0 = function02;
                if (function0 != null) {
                    function0.invoke();
                }
                if (appVersionBll4.mAutoInstallApp) {
                    notificationHelper4.appUpdateDownloadNotificationDisplay(context2, new Intent(), context2.getString(R.string.app_thinkacademy_name), context2.getString(R.string.fail_to_download), true);
                }
            }
        });
    }
}
