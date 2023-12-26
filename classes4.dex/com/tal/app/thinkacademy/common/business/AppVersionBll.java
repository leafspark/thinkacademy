package com.tal.app.thinkacademy.common.business;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.http.UpdateRepository;
import com.tal.app.thinkacademy.common.dialog.UpdateVersionDialog;
import com.tal.app.thinkacademy.common.entity.UpdateVersionEntity;
import com.tal.app.thinkacademy.common.util.AndroidFileUtils;
import com.tal.app.thinkacademy.common.util.LoadFileUtils;
import com.tal.app.thinkacademy.common.utils.ChannelUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.NetworkUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.AppGlobals;
import com.tal.app.thinkacademy.lib.utils.DownloadManager;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0013Jf\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001e2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010!2\b\b\u0002\u0010#\u001a\u00020\bH\u0002J.\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010&\u001a\u00020\bH\u0002J\u0013\u0010'\u001a\u0004\u0018\u00010\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010(J*\u0010'\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130!H\u0007J\"\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u0004\u0018\u00010\u0004J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010/\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002JN\u00100\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00130\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130!R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/AppVersionBll;", "", "()V", "appFile", "Ljava/io/File;", "mApkMd5", "", "mAutoInstallApp", "", "mDownloadManager", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager;", "mDownloadUrl", "repository", "Lcom/tal/app/thinkacademy/common/business/http/UpdateRepository;", "tag", "Lcom/tal/app/thinkacademy/common/Tag;", "updateVersionDialog", "Lcom/tal/app/thinkacademy/common/dialog/UpdateVersionDialog;", "appUpdateCheck", "", "context", "Landroid/content/Context;", "updateVersionEntity", "Lcom/tal/app/thinkacademy/common/entity/UpdateVersionEntity;", "isAutoCheck", "cancelUpdate", "checkOrDownload", "downLoadUrl", "md5", "downLoadProgress", "Lkotlin/Function1;", "", "downLoadSuccess", "Lkotlin/Function0;", "downLoadError", "checkInstall", "checkSilenceDownload", "url", "showDialog", "checkUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downLoadResult", "getApkFile", "getAppVersionFile", "installApk", "apkPath", "restartUpdate", "showUpdateDialog", "startUpdateApp", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppVersionBll.kt */
public final class AppVersionBll {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<AppVersionBll> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AppVersionBll$Companion$instance$2.INSTANCE);
    private File appFile;
    /* access modifiers changed from: private */
    public String mApkMd5;
    /* access modifiers changed from: private */
    public boolean mAutoInstallApp;
    private final DownloadManager mDownloadManager = DownloadManager.Companion.get();
    /* access modifiers changed from: private */
    public String mDownloadUrl;
    /* access modifiers changed from: private */
    public final UpdateRepository repository = new UpdateRepository();
    /* access modifiers changed from: private */
    public final Tag tag = Tag.APP_UPGRADE;
    private UpdateVersionDialog updateVersionDialog;

    public final void checkUpdate(Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "downLoadResult");
        checkUpdate$default(this, context, false, function0, 2, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/AppVersionBll$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/common/business/AppVersionBll;", "getInstance", "()Lcom/tal/app/thinkacademy/common/business/AppVersionBll;", "instance$delegate", "Lkotlin/Lazy;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AppVersionBll.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppVersionBll getInstance() {
            return (AppVersionBll) AppVersionBll.instance$delegate.getValue();
        }
    }

    public final File getAppVersionFile() {
        return this.appFile;
    }

    private final File getApkFile(Context context, String str, String str2) {
        Object[] array = StringsKt.split$default(str, new String[]{"/"}, false, 0, 6, (Object) null).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        String str3 = strArr[strArr.length - 1];
        String string = ShareDataManager.getInstance().getString(Intrinsics.stringPlus("appFile-", str3), "", ShareDataManager.SHAREDATA_CAN_CLEAR);
        File geCacheFile = LoadFileUtils.geCacheFile(context, "apk");
        if (geCacheFile == null) {
            ToastUtils.showShort(context.getString(R.string.storage_card_not_detect), new Object[0]);
            XesLog.e(this.tag, "apk存储目录丢失");
            return null;
        }
        String str4 = geCacheFile.getAbsolutePath() + File.separator + str3;
        if ((str2.length() == 0) || !Intrinsics.areEqual(string, str2)) {
            XesLog.e(this.tag, "md5校验失败，删除文件 newMd5:" + str2 + ", localMd5:" + string);
            try {
                FileUtils.deleteAllInDir(geCacheFile);
            } catch (Exception e) {
                XesLog.e(this.tag, Intrinsics.stringPlus("md5校验失败，删除文件失败 ", e.getMessage()));
            }
        }
        return new File(str4);
    }

    public static /* synthetic */ void checkUpdate$default(AppVersionBll appVersionBll, Context context, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        appVersionBll.checkUpdate(context, z, function0);
    }

    public final void checkUpdate(Context context, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "downLoadResult");
        BuildersKt.launch$default(GlobalScope.INSTANCE, new HandlerException(new AppVersionBll$checkUpdate$1(function0, this)), (CoroutineStart) null, new AppVersionBll$checkUpdate$2(this, function0, context, z, (Continuation<? super AppVersionBll$checkUpdate$2>) null), 2, (Object) null);
    }

    public final Object checkUpdate(Continuation<? super UpdateVersionEntity> continuation) {
        return this.repository.newCheckUpdate(continuation);
    }

    public final void cancelUpdate() {
        XesLog.i(this.tag, "App升级 取消 " + this.mDownloadUrl + " , " + this.mApkMd5);
        this.mDownloadManager.cancelAll();
    }

    public final void restartUpdate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        XesLog.i(this.tag, "App升级 恢复下载 " + this.mDownloadUrl + " , " + this.mApkMd5);
        checkSilenceDownload$default(this, context, this.mDownloadUrl, this.mApkMd5, false, 8, (Object) null);
    }

    public final void appUpdateCheck(Context context, UpdateVersionEntity updateVersionEntity, boolean z) {
        XesLog.i(this.tag, Intrinsics.stringPlus("appUpdateCheck ", updateVersionEntity));
        if (context != null) {
            Activity activity = (Activity) context;
            activity.runOnUiThread(new AppVersionBll$$ExternalSyntheticLambda1(updateVersionEntity, z, this, activity, context, context));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: appUpdateCheck$lambda-2$lambda-1  reason: not valid java name */
    public static final void m6appUpdateCheck$lambda2$lambda1(UpdateVersionEntity updateVersionEntity, boolean z, AppVersionBll appVersionBll, Activity activity, Context context, Context context2) {
        Intrinsics.checkNotNullParameter(appVersionBll, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(context, "$it");
        if (updateVersionEntity != null) {
            boolean z2 = false;
            if (updateVersionEntity.getNeedUpgrade() == 1) {
                if (z) {
                    int needPopUpWindow = updateVersionEntity.getNeedPopUpWindow();
                    if (needPopUpWindow != 1) {
                        if (needPopUpWindow == 2) {
                            updateVersionEntity.setLocalForceUpgrade(true);
                        }
                        appVersionBll.checkSilenceDownload(activity, updateVersionEntity.getPackageUrl(), updateVersionEntity.getPackageMd5(), z2);
                        if (z2 && !activity.isFinishing() && !activity.isDestroyed()) {
                            HWEventTracking.Companion.get().ostaUpdateNewVersion(updateVersionEntity.getNewVersion(), updateVersionEntity.getLocalForceUpgrade());
                            appVersionBll.showUpdateDialog(context, updateVersionEntity);
                        }
                        z2 = true;
                    } else {
                        updateVersionEntity.setLocalForceUpgrade(false);
                    }
                } else {
                    updateVersionEntity.setLocalForceUpgrade(false);
                }
                z2 = true;
                appVersionBll.checkSilenceDownload(activity, updateVersionEntity.getPackageUrl(), updateVersionEntity.getPackageMd5(), z2);
                HWEventTracking.Companion.get().ostaUpdateNewVersion(updateVersionEntity.getNewVersion(), updateVersionEntity.getLocalForceUpgrade());
                appVersionBll.showUpdateDialog(context, updateVersionEntity);
                z2 = true;
            } else if (!z) {
                ToastUtils.showShort(context2.getString(R.string.highest_version), new Object[0]);
            }
            ShareDataManager.getInstance().put(ShareDataKey.IS_NEW_VERSION, z2, ShareDataManager.SHAREDATA_NOT_CLEAR);
            XesDataBus.with(DataBusKey.USER_CENTER_APP_VERSION_REFRESH).setStickyData("");
        }
    }

    static /* synthetic */ void checkSilenceDownload$default(AppVersionBll appVersionBll, Context context, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        appVersionBll.checkSilenceDownload(context, str, str2, z);
    }

    private final void checkSilenceDownload(Context context, String str, String str2, boolean z) {
        if (ChannelUtil.INSTANCE.isGoogleChannel()) {
            XesLog.e(this.tag, "google渠道，禁用静默下载");
            return;
        }
        this.appFile = null;
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = str2;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                this.appFile = getApkFile(context, str, str2);
                if (z) {
                    XesLog.i(this.tag, "弹窗更新，不启动静默下载");
                    return;
                } else if (!NetworkUtils.isWifiConnected()) {
                    XesLog.i(this.tag, "非WIFI环境，不启动静默下载");
                    return;
                } else {
                    checkOrDownload$default(this, context, str, str2, (Function1) null, (Function0) null, (Function0) null, false, 56, (Object) null);
                    return;
                }
            }
        }
        XesLog.i(this.tag, "下载地址异常或md5为空，不启动静默下载");
    }

    private final void showUpdateDialog(Context context, UpdateVersionEntity updateVersionEntity) {
        if (this.updateVersionDialog == null) {
            this.mAutoInstallApp = true;
            UpdateVersionDialog updateVersionDialog2 = new UpdateVersionDialog(context);
            this.updateVersionDialog = updateVersionDialog2;
            updateVersionDialog2.initData(updateVersionEntity);
            UpdateVersionDialog updateVersionDialog3 = this.updateVersionDialog;
            if (updateVersionDialog3 != null) {
                updateVersionDialog3.setOnDismissListener(new AppVersionBll$$ExternalSyntheticLambda0(this));
            }
            XesLog.i(this.tag, "App升级 显示升级弹窗");
            UpdateVersionDialog updateVersionDialog4 = this.updateVersionDialog;
            if (updateVersionDialog4 != null) {
                updateVersionDialog4.show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showUpdateDialog$lambda-3  reason: not valid java name */
    public static final void m7showUpdateDialog$lambda3(AppVersionBll appVersionBll, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(appVersionBll, "this$0");
        XesLog.i(appVersionBll.tag, "升级弹窗关闭，关闭下载完自动安装");
        appVersionBll.mAutoInstallApp = false;
        appVersionBll.updateVersionDialog = null;
    }

    public final void startUpdateApp(Context context, String str, String str2, Function1<? super Integer, Unit> function1, Function0<Unit> function0, Function0<Unit> function02) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        String str3 = str;
        Intrinsics.checkNotNullParameter(str, "downLoadUrl");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str2, "md5");
        Function1<? super Integer, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function1, "downLoadProgress");
        Intrinsics.checkNotNullParameter(function0, "downLoadSuccess");
        Intrinsics.checkNotNullParameter(function02, "downLoadError");
        File apkFile = getApkFile(context, str, str2);
        this.appFile = apkFile;
        if (apkFile != null && !apkFile.exists()) {
            ToastUtils.showShort(context.getString(R.string.start_download), new Object[0]);
        }
        checkOrDownload$default(this, context, str, str2, function1, function0, function02, false, 64, (Object) null);
    }

    static /* synthetic */ void checkOrDownload$default(AppVersionBll appVersionBll, Context context, String str, String str2, Function1 function1, Function0 function0, Function0 function02, boolean z, int i, Object obj) {
        appVersionBll.checkOrDownload(context, str, str2, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : function0, (i & 32) != 0 ? null : function02, (i & 64) != 0 ? true : z);
    }

    private final void checkOrDownload(Context context, String str, String str2, Function1<? super Integer, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, boolean z) {
        String str3 = str;
        String str4 = str2;
        File file = this.appFile;
        Context context2 = context;
        NotificationHelper notificationHelper = new NotificationHelper(context);
        if (file != null && file.exists()) {
            XesLog.s(this.tag, "已下载完成，不启动静默下载");
            if (z) {
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "targetFile.absolutePath");
                installApk(absolutePath);
            }
            notificationHelper.appUpdateDownloadNotificationCancel();
        } else if (file == null) {
            XesLog.e(this.tag, "App安装包 内存无法访问，终止下载");
        } else {
            ShareDataManager.getInstance().put(Intrinsics.stringPlus("appFile-", file.getName()), str4, ShareDataManager.SHAREDATA_CAN_CLEAR);
            XesLog.i(this.tag, "启动静默下载");
            this.mDownloadUrl = str3;
            this.mApkMd5 = str4;
            DownloadManager.Task safeCreateTask = this.mDownloadManager.safeCreateTask(str);
            safeCreateTask.setCallback(new AppVersionBll$checkOrDownload$1$1(this, notificationHelper, context, function1, function0, file, safeCreateTask, function02));
            safeCreateTask.download(file);
        }
    }

    public final void installApk(String str) {
        Intrinsics.checkNotNullParameter(str, "apkPath");
        XesLog.i(this.tag, "安装App");
        AndroidFileUtils.openFile(AppGlobals.INSTANCE.get(), str);
    }
}
