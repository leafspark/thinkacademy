package com.tal.appthinkacademy.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.webkit.WebView;
import androidx.multidex.MultiDex;
import com.bonree.sdk.agent.engine.external.AppStateInfo;
import com.dianping.logan.Logan;
import com.dianping.logan.LoganConfig;
import com.didi.hummer.Hummer;
import com.didi.hummer.HummerConfig;
import com.didi.hummer.adapter.http.impl.DefaultHttpAdapter;
import com.didi.hummer.adapter.imageloader.impl.DefaultImageLoaderAdapter;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import com.didi.hummer.adapter.storage.impl.DefaultStorageAdapter;
import com.igexin.sdk.PushManager;
import com.tal.app.thinkacademy.BuildConfig;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.server.ServerManager;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.DataFilePoint;
import com.tal.app.thinkacademy.common.entity.ScreenInfo;
import com.tal.app.thinkacademy.common.flutter.HwFlutterUtil;
import com.tal.app.thinkacademy.common.network.BaseUrlEx;
import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import com.tal.app.thinkacademy.common.network.config.HWNetConfig;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.HwLanguageUtil;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.commui.refresh.RefreshLayoutManager;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.commui.widget.bar.style.TitleBarLightStyle;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.logger.XesConsolePrinter;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogConfig;
import com.tal.app.thinkacademy.lib.logger.XesLogManager;
import com.tal.app.thinkacademy.lib.logger.XesLogPrinter;
import com.tal.app.thinkacademy.lib.network.NetworkManager;
import com.tal.app.thinkacademy.lib.pay.PayManager;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.track.HwTrackLibUtil;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import com.tal.app.thinkacademy.lib.utils.LaunchUtil;
import com.tal.app.thinkacademy.lib.utils.ProcessUtils;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import com.tal.app.thinkacademy.lib.utils.XesSpManager;
import com.tal.app.thinkacademy.live.util.PluginCollector;
import com.tal.appthinkacademy.Tag;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.io.FileWalkDirection;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tal/appthinkacademy/base/TalHwApplication;", "Landroid/app/Application;", "()V", "TAG", "Lcom/tal/appthinkacademy/Tag;", "attachBaseContext", "", "base", "Landroid/content/Context;", "collectScreenInch", "initActivityManager", "application", "initAppLanguage", "initHummer", "initLog", "initLogan", "initPush", "initRefresh", "initRoute", "debug", "", "initSP", "initSchoolInfo", "initTrackPlayerUtil", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "registerLifecycle", "setupLandscapeConfig", "syncCloud", "uploadAgoraLog", "uploadLoganFiles", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalHwApplication.kt */
public final class TalHwApplication extends Application {
    private final Tag TAG = Tag.APPLICATION;

    public TalHwApplication() {
        AppConfig.DEBUG = false;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        AppStateInfo.attachBaseContextBegin(this, context);
        super.attachBaseContext(context);
        MultiDex.install(this);
        AppStateInfo.attachBaseContextEnd();
    }

    public void onCreate() {
        AppStateInfo.onCreateAppBegin(getClass().getName());
        super.onCreate();
        Context context = this;
        PadUtils.setup(context);
        Application application = this;
        Utils.init(application);
        LaunchUtil.init(application);
        initSP(application);
        if (ProcessUtils.isMainProcess(context)) {
            initLogan();
        }
        NetworkManager.INSTANCE.init(context, new HWNetConfig());
        initLog(application);
        initActivityManager(application);
        initRoute(application, false);
        initRefresh();
        ThirdInit.INSTANCE.init(application);
        if (ProcessUtils.isMainProcess(context)) {
            initTrackPlayerUtil();
            initAppLanguage();
        }
        TitleBar.initStyle(new TitleBarLightStyle(context));
        DownloadEngine.getInstance().init(application, "");
        DownloadEngine.getInstance().setProvider(TalHwApplication$$ExternalSyntheticLambda1.INSTANCE);
        if (ProcessUtils.isMainProcess(context)) {
            ServerManager.getInstance().init(2, Intrinsics.stringPlus(getFilesDir().getAbsoluteFile().toString(), "/course_unzip"), 2131166992, "", "");
            initPush();
        }
        String string = ShareDataManager.getInstance().getString("debug_tool_env", BuildConfig.ENV, ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (Intrinsics.areEqual((Object) string, (Object) ENVIRONMENTAL.ALPHA.getEnvName())) {
            BaseUrlEx.Companion.updateEnv(ENVIRONMENTAL.ALPHA);
        } else if (Intrinsics.areEqual((Object) string, (Object) ENVIRONMENTAL.DEVELOP.getEnvName())) {
            BaseUrlEx.Companion.updateEnv(ENVIRONMENTAL.DEVELOP);
        } else if (Intrinsics.areEqual((Object) string, (Object) ENVIRONMENTAL.TEST.getEnvName())) {
            BaseUrlEx.Companion.updateEnv(ENVIRONMENTAL.TEST);
        } else if (Intrinsics.areEqual((Object) string, (Object) ENVIRONMENTAL.PRE.getEnvName())) {
            BaseUrlEx.Companion.updateEnv(ENVIRONMENTAL.PRE);
        } else if (Intrinsics.areEqual((Object) string, (Object) ENVIRONMENTAL.ONLINE.getEnvName())) {
            BaseUrlEx.Companion.updateEnv(ENVIRONMENTAL.ONLINE);
        }
        if (Build.VERSION.SDK_INT >= 28 && ProcessUtils.isMainProcess(context) && !Intrinsics.areEqual((Object) "release", (Object) "release")) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        uploadAgoraLog();
        registerLifecycle();
        PluginCollector.init();
        syncCloud();
        if (ProcessUtils.isMainProcess(context)) {
            PayManager.INSTANCE.paySdkInit(application, (BaseUrlEx.Companion.getEnvironment() == ENVIRONMENTAL.ONLINE || BaseUrlEx.Companion.getEnvironment() == ENVIRONMENTAL.PRE) ? false : true, HwLanguageUtil.INSTANCE.getCurrentLanguage().getLanguage(), HwLanguageUtil.INSTANCE.getCurrentLanguage().getCountry());
            initHummer();
            initSchoolInfo();
            setupLandscapeConfig();
            if (!PadAutoUtil.isCloseScreenLandscape()) {
                HwFlutterUtil.INSTANCE.flutterBoostInit(application);
            }
        }
        collectScreenInch();
        XesLog.i(this.TAG, new Object[]{"Application初始化完成，品牌：" + Build.BRAND + "，型号：" + Build.MODEL + "，Android " + Build.VERSION.RELEASE + "，应用版本：2.19.1"});
        AppStateInfo.onCreateAppEnd(getClass().getName());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final FilePoint m523onCreate$lambda0() {
        return new DataFilePoint();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        if (r0 != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setupLandscapeConfig() {
        /*
            r7 = this;
            com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper$Companion r0 = com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper.Companion
            com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper r0 = r0.get()
            java.lang.String r1 = "hw_flutter_landscape_config"
            java.lang.String r0 = r0.getCloudKeyValue(r1)
            com.tal.appthinkacademy.Tag r1 = r7.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "横屏改造配置: "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r0)
            r5 = 0
            r3[r5] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r1, r3)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = "{}"
        L_0x0025:
            r1.<init>(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "close"
            boolean r0 = r1.optBoolean(r0, r5)     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x0055
            java.lang.String r0 = "blackList"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x003a
        L_0x0038:
            r0 = r5
            goto L_0x0053
        L_0x003a:
            int r1 = r0.length()     // Catch:{ Exception -> 0x0057 }
            r3 = r5
        L_0x003f:
            if (r3 >= r1) goto L_0x0038
            int r4 = r3 + 1
            java.lang.String r3 = r0.optString(r3)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0057 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)     // Catch:{ Exception -> 0x0057 }
            if (r3 == 0) goto L_0x0051
            r0 = r2
            goto L_0x0053
        L_0x0051:
            r3 = r4
            goto L_0x003f
        L_0x0053:
            if (r0 == 0) goto L_0x006d
        L_0x0055:
            r0 = r2
            goto L_0x006e
        L_0x0057:
            r0 = move-exception
            com.tal.appthinkacademy.Tag r1 = r7.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r0 = r0.getMessage()
            java.lang.String r4 = "横屏改造数据处理失败: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r0)
            r3[r5] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r1, r3)
        L_0x006d:
            r0 = r5
        L_0x006e:
            com.tal.appthinkacademy.Tag r1 = r7.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r0 ^ 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = "横屏改造是否开启: "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r3)
            r2[r5] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r1, r2)
            com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil r1 = com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil.INSTANCE
            r1.setupCloseScreenLandscape(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.appthinkacademy.base.TalHwApplication.setupLandscapeConfig():void");
    }

    private final void syncCloud() {
        HwCloudControlHelper.Companion.get().syncCloud();
    }

    private final void initPush() {
        Context context = this;
        PushManager.getInstance().setDebugLogger(context, TalHwApplication$$ExternalSyntheticLambda0.INSTANCE);
        PushManager.getInstance().initialize(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: initPush$lambda-3  reason: not valid java name */
    public static final void m522initPush$lambda3(String str) {
        XesLog.i(Tag.PUSH, new Object[]{str});
    }

    private final void initLogan() {
        LoganConfig.Builder cachePath = new LoganConfig.Builder().setCachePath(getFilesDir().getAbsolutePath());
        StringBuilder sb = new StringBuilder();
        String str = null;
        File externalFilesDir = getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        }
        sb.append(str);
        sb.append(File.separator);
        sb.append("logan");
        LoganConfig.Builder path = cachePath.setPath(sb.toString());
        byte[] bytes = "RsJ03oBUJ6Z2jd9W".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        LoganConfig.Builder encryptKey16 = path.setEncryptKey16(bytes);
        byte[] bytes2 = "eDc1cPUwISX1Bwxb".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        Logan.init(encryptKey16.setEncryptIV16(bytes2).setDay(30).setMaxFile(200).setMinSDCard(524288000).build());
        Logan.setDebug(false);
    }

    private final void initTrackPlayerUtil() {
        HwTrackLibUtil.INSTANCE.setListener(new TalHwApplication$initTrackPlayerUtil$1());
    }

    private final void initLog(Application application) {
        XesLogConfig.Build enableLog2File = XesLogConfig.Build.newBuild().enable(false).enableLog2File(true);
        StringBuilder sb = new StringBuilder();
        File externalCacheDir = application.getExternalCacheDir();
        sb.append(externalCacheDir == null ? null : externalCacheDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append("/xeslog/");
        XesLogManager.init(enableLog2File.logpatch(sb.toString()).retentionTime(0).build(), new XesLogPrinter[]{(XesLogPrinter) new XesConsolePrinter()});
    }

    private final void registerLifecycle() {
        if (ProcessUtils.isMainProcess(this)) {
            registerActivityLifecycleCallbacks(new TalHwApplication$registerLifecycle$1());
        }
    }

    private final void initActivityManager(Application application) {
        XesActivityManager.Companion.getInstance().init(application);
    }

    private final void initRoute(Application application, boolean z) {
        XesRoute.getInstance().init(application, z);
    }

    private final void initRefresh() {
        RefreshLayoutManager.confRefreshLayout();
    }

    private final void initSP(Application application) {
        XesSpManager.INSTANCE.init(application);
    }

    private final void uploadLoganFiles() {
        String uid;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        if (userInfoEntity != null && (uid = userInfoEntity.getUid()) != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList<File> arrayList2 = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            File externalFilesDir = getExternalFilesDir((String) null);
            sb.append(externalFilesDir == null ? null : externalFilesDir.getAbsolutePath());
            sb.append(File.separator);
            sb.append("logan");
            for (File add : SequencesKt.filter(FilesKt.walk$default(new File(sb.toString()), (FileWalkDirection) null, 1, (Object) null).maxDepth(1), TalHwApplication$uploadLoganFiles$1$1.INSTANCE)) {
                arrayList2.add(add);
            }
            for (File name : arrayList2) {
                Date date = new Date();
                String name2 = name.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                date.setTime(Long.parseLong(name2));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
                arrayList.add(uid + '/' + simpleDateFormat.format(date));
            }
            AwsS3Util.INSTANCE.uploadFiles(this, "logan/*", arrayList, arrayList2, new TalHwApplication$uploadLoganFiles$1$4(arrayList2));
        }
    }

    private final void uploadAgoraLog() {
        String uid;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        if (userInfoEntity != null && (uid = userInfoEntity.getUid()) != null) {
            File externalFilesDir = getExternalFilesDir((String) null);
            for (File file : SequencesKt.filter(FilesKt.walk$default(new File(Intrinsics.stringPlus(externalFilesDir == null ? null : externalFilesDir.getAbsolutePath(), File.separator)), (FileWalkDirection) null, 1, (Object) null).maxDepth(1), TalHwApplication$uploadAgoraLog$1$1.INSTANCE)) {
                if (Intrinsics.areEqual((Object) file.getName(), (Object) "agorasdk.log")) {
                    AwsS3Util.INSTANCE.uploadFile(this, "agoralog/*", uid + '/' + file.getName(), file);
                }
            }
        }
    }

    private final void collectScreenInch() {
        if (ProcessUtils.isMainProcess(this)) {
            try {
                ScreenInfo screenInch = PadUtils.getScreenInch(this);
                boolean isPad = PadUtils.isPad(this);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("screen_inch", screenInch.getInch());
                jSONObject.put("screen_width", screenInch.getWidth());
                jSONObject.put("screen_height", screenInch.getHeight());
                jSONObject.put("screen_xdpi", Float.valueOf(screenInch.getXdpi()));
                jSONObject.put("screen_ydpi", Float.valueOf(screenInch.getYdpi()));
                jSONObject.put("orientation", screenInch.getOrientation());
                jSONObject.put("is_pad", isPad);
                jSONObject.put("from", "AppStart");
                HwTrackUtil.INSTANCE.track("hw_screen_data", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final void initAppLanguage() {
        HwLanguageUtil.INSTANCE.initAppLanguage(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        XesLog.i(this.TAG, new Object[]{"onConfigurationChanged 系统设置改变"});
        XesLog.i(this.TAG, new Object[]{"系统设置改变，重新初始化多语言"});
        HwLanguageUtil.INSTANCE.updateConfig(this);
    }

    private final void initHummer() {
        Hummer.init(this, new HummerConfig.Builder().setHttpAdapter(new DefaultHttpAdapter()).setStorageAdapter(new DefaultStorageAdapter()).setImageLoaderAdapter(new DefaultImageLoaderAdapter()).setNavigatorAdapter(new DefaultNavigatorAdapter(new TalHwApplication$initHummer$config$1())).builder());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initSchoolInfo() {
        /*
            r8 = this;
            java.lang.String r0 = "SchoolConstants分校信息"
            r1 = 0
            r2 = 1
            r3 = 0
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r4 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()     // Catch:{ Exception -> 0x003a }
            java.lang.String r5 = "launch_school_list_key"
            java.lang.String r6 = ""
            int r7 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR     // Catch:{ Exception -> 0x003a }
            java.lang.String r4 = r4.getString(r5, r6, r7)     // Catch:{ Exception -> 0x003a }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x003a }
            java.lang.String r6 = "当前分校列表数据为="
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r4)     // Catch:{ Exception -> 0x003a }
            r5[r3] = r6     // Catch:{ Exception -> 0x003a }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r5)     // Catch:{ Exception -> 0x003a }
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x003a }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x003a }
            if (r5 != 0) goto L_0x0036
            com.tal.app.thinkacademy.lib.util.GsonUtil r5 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()     // Catch:{ Exception -> 0x003a }
            java.lang.Class<com.tal.app.thinkacademy.common.imconfig.SchoolListInfo> r6 = com.tal.app.thinkacademy.common.imconfig.SchoolListInfo.class
            java.lang.Object r4 = r5.fromJson(r4, r6)     // Catch:{ Exception -> 0x003a }
            com.tal.app.thinkacademy.common.imconfig.SchoolListInfo r4 = (com.tal.app.thinkacademy.common.imconfig.SchoolListInfo) r4     // Catch:{ Exception -> 0x003a }
            goto L_0x0046
        L_0x0036:
            r4 = r1
            com.tal.app.thinkacademy.common.imconfig.SchoolListInfo r4 = (com.tal.app.thinkacademy.common.imconfig.SchoolListInfo) r4     // Catch:{ Exception -> 0x003a }
            goto L_0x0046
        L_0x003a:
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "获取持久化的分校信息数据失败"
            r4[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r4)
            r4 = r1
            com.tal.app.thinkacademy.common.imconfig.SchoolListInfo r4 = (com.tal.app.thinkacademy.common.imconfig.SchoolListInfo) r4
        L_0x0046:
            com.tal.app.thinkacademy.common.constants.SchoolConstants r5 = com.tal.app.thinkacademy.common.constants.SchoolConstants.INSTANCE
            boolean r5 = r5.checkSchoolInfoError(r4)
            if (r5 == 0) goto L_0x0058
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "检测到了分校信息异常,直接清空本地数据，走重新获取分校数据的逻辑！！！"
            r4[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r4)
            goto L_0x0059
        L_0x0058:
            r1 = r4
        L_0x0059:
            if (r1 == 0) goto L_0x006b
            java.util.List r4 = r1.getList()
            if (r4 != 0) goto L_0x0063
            r4 = r3
            goto L_0x0067
        L_0x0063:
            int r4 = r4.size()
        L_0x0067:
            if (r4 <= 0) goto L_0x006b
            r4 = r2
            goto L_0x006c
        L_0x006b:
            r4 = r3
        L_0x006c:
            if (r4 == 0) goto L_0x007c
            com.tal.app.thinkacademy.common.constants.SchoolConstants r4 = com.tal.app.thinkacademy.common.constants.SchoolConstants.INSTANCE
            r4.schoolInfoInitNew(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = "本地已经存储了分校的数据,不需要重新请求."
            r1[r3] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r1)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.appthinkacademy.base.TalHwApplication.initSchoolInfo():void");
    }
}
