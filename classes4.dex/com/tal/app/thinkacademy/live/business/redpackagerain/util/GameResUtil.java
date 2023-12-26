package com.tal.app.thinkacademy.live.business.redpackagerain.util;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.network.EmptyPostBean;
import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.model.OnlineResFile;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.redpackagerain.api.GameResApi;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.GameResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.GameResRequestListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/util/GameResUtil;", "", "()V", "checkGameResIsDownLoad", "", "name", "", "downGamePackageRes", "", "gameRes", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/GameResBean;", "getGamePackagePath", "getGamePackageUnPath", "getRedPackageRainRes", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "isDownloadFinish", "md5", "requestGamePackage", "listener", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/GameResRequestListener;", "saveGamePackageData", "saveGamePackageDownloadFinish", "Companion", "DownloadImpl", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameResUtil.kt */
public final class GameResUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String GAME_UNZIP = "course_unzip";
    private static final String GAME_ZIP = "course_zip";
    /* access modifiers changed from: private */
    public static final Lazy<GameResUtil> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GameResUtil$Companion$INSTANCE$2.INSTANCE);
    private static final String RED_PACKAGE_RAIN_RES_KEY = "redbagrainPackage";
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.RED_PACKAGE_RAIN;
    private static DownloadImpl mDownloadListener;

    public /* synthetic */ GameResUtil(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final GameResUtil get() {
        return Companion.get();
    }

    private GameResUtil() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/util/GameResUtil$Companion;", "", "()V", "GAME_UNZIP", "", "GAME_ZIP", "INSTANCE", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/util/GameResUtil;", "getINSTANCE", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/util/GameResUtil;", "INSTANCE$delegate", "Lkotlin/Lazy;", "RED_PACKAGE_RAIN_RES_KEY", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "mDownloadListener", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/util/GameResUtil$DownloadImpl;", "get", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameResUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final GameResUtil getINSTANCE() {
            return (GameResUtil) GameResUtil.INSTANCE$delegate.getValue();
        }

        @JvmStatic
        public final GameResUtil get() {
            return getINSTANCE();
        }
    }

    public final RedPackageRainResBean getRedPackageRainRes(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        String string = ShareDataManager.getInstance().getString(str, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (!TextUtils.isEmpty(string)) {
            try {
                return (RedPackageRainResBean) GsonUtil.getInstance().fromJson(string, RedPackageRainResBean.class);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public final void requestGamePackage(GameResRequestListener gameResRequestListener) {
        Call gamePackage$default = GameResApi.DefaultImpls.getGamePackage$default((GameResApi) Api.create(GameResApi.class), Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/api/redbagrain/student/getGamePackage"), (EmptyPostBean) null, 2, (Object) null);
        Callback gameResUtil$requestGamePackage$1 = new GameResUtil$requestGamePackage$1(this, gameResRequestListener, new GameResUtil$requestGamePackage$2());
        if (!(gamePackage$default instanceof Call)) {
            gamePackage$default.enqueue(gameResUtil$requestGamePackage$1);
        } else {
            Retrofit2Instrumentation.enqueue(gamePackage$default, gameResUtil$requestGamePackage$1);
        }
    }

    /* access modifiers changed from: private */
    public final void saveGamePackageData(GameResBean gameResBean) {
        RedPackageRainResBean redbagrainPackage;
        if (gameResBean != null && (redbagrainPackage = gameResBean.getRedbagrainPackage()) != null) {
            String objToJson = GsonUtil.getInstance().objToJson(redbagrainPackage);
            Intrinsics.checkNotNullExpressionValue(objToJson, "getInstance().objToJson(redPackageRainResBean)");
            XesLog.i(TAG, Intrinsics.stringPlus("红包雨游戏资源包json =", objToJson));
            ShareDataManager.getInstance().put(RED_PACKAGE_RAIN_RES_KEY, objToJson, ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    /* access modifiers changed from: private */
    public final void downGamePackageRes(GameResBean gameResBean) {
        RedPackageRainResBean redbagrainPackage;
        String offlineZipPath;
        if (gameResBean != null && (redbagrainPackage = gameResBean.getRedbagrainPackage()) != null && !isDownloadFinish(redbagrainPackage.getOfflineZipMd5()) && (offlineZipPath = redbagrainPackage.getOfflineZipPath()) != null) {
            CharSequence charSequence = offlineZipPath;
            if (!TextUtils.isEmpty(charSequence)) {
                OnlineResFile.ResourceData resourceData = new OnlineResFile.ResourceData();
                List<String> arrayList = new ArrayList<>();
                arrayList.add(offlineZipPath);
                resourceData.url = arrayList;
                resourceData.resBusinessType = ResourceBusinessType.TYPE_GAME_PACKAGE.name();
                resourceData.filePath = getGamePackagePath();
                resourceData.unZipPath = getGamePackageUnPath();
                int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, "/", 0, false, 6, (Object) null) + 1;
                if (lastIndexOf$default <= offlineZipPath.length() - 1) {
                    String substring = offlineZipPath.substring(lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    resourceData.fileName = Intrinsics.stringPlus(substring, "1");
                    String substring2 = offlineZipPath.substring(lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    resourceData.realFileName = substring2;
                }
                resourceData.md5 = redbagrainPackage.getOfflineZipMd5();
                resourceData.isIgnoreSRAVerify = true;
                resourceData.isDiff = false;
                resourceData.isHighPriorityRes = true;
                List arrayList2 = new ArrayList();
                arrayList2.add(resourceData);
                OnlineResFile onlineResFile = new OnlineResFile();
                onlineResFile.setHighPriorityRes(arrayList2);
                if (mDownloadListener == null) {
                    mDownloadListener = new DownloadImpl(this);
                }
                DownloadEngine.getInstance().addDownloadQueue(onlineResFile, mDownloadListener);
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J0\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/util/GameResUtil$DownloadImpl;", "Lcom/tal/app/thinkacademy/lib/download/listener/SimpleDownloadListener;", "(Lcom/tal/app/thinkacademy/live/business/redpackagerain/util/GameResUtil;)V", "onBlockComplete", "", "point", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "onCancel", "mPoint", "onFailed", "code", "", "message", "", "progress", "errorInfo", "onFinished", "onPause", "onProgress", "soFarBytes", "", "totalBytes", "onStart", "onUnZipResult", "state", "onVerifyResult", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameResUtil.kt */
    public final class DownloadImpl extends SimpleDownloadListener {
        final /* synthetic */ GameResUtil this$0;

        public DownloadImpl(GameResUtil gameResUtil) {
            Intrinsics.checkNotNullParameter(gameResUtil, "this$0");
            this.this$0 = gameResUtil;
        }

        public void onStart(FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            XesLog.i(GameResUtil.TAG, Intrinsics.stringPlus("onStart>>>", filePoint));
        }

        public void onFinished(FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            XesLog.i(GameResUtil.TAG, Intrinsics.stringPlus("onFinished>>>", filePoint));
            this.this$0.saveGamePackageDownloadFinish(filePoint.getMd5());
        }

        public void onProgress(long j, long j2, FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            XesLog.i(GameResUtil.TAG, Intrinsics.stringPlus("onProgress>>>", Integer.valueOf((int) (((((float) j) * 1.0f) * ((float) 100)) / ((float) j2)))));
        }

        public void onPause(FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            XesLog.i(GameResUtil.TAG, Intrinsics.stringPlus("onPause>>>", filePoint));
        }

        public void onCancel(FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            XesLog.i(GameResUtil.TAG, Intrinsics.stringPlus("onCancel>>>", filePoint));
        }

        public void onFailed(FilePoint filePoint, int i, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(str2, "progress");
            Intrinsics.checkNotNullParameter(str3, "errorInfo");
            XesLog.i(GameResUtil.TAG, "onFailed>>>code=" + i + "，message=" + str + "，progress=" + str2 + ",errorInfo=" + str3 + ',' + filePoint);
        }

        public void onBlockComplete(FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "point");
            XesLog.i(GameResUtil.TAG, Intrinsics.stringPlus("onBlockComplete>>>", filePoint));
        }

        public void onVerifyResult(FilePoint filePoint, int i) {
            Intrinsics.checkNotNullParameter(filePoint, "point");
            super.onVerifyResult(filePoint, i);
            XesLog.i(GameResUtil.TAG, "onVerifyResult>>>state=" + i + ',' + filePoint);
        }

        public void onUnZipResult(FilePoint filePoint, int i) {
            Intrinsics.checkNotNullParameter(filePoint, "point");
            super.onUnZipResult(filePoint, i);
            XesLog.i(GameResUtil.TAG, "onUnZipResult>>>state=" + i + ',' + filePoint);
        }
    }

    private final String getGamePackagePath() {
        return Intrinsics.stringPlus(AppUtil.getApplication().getFilesDir().getAbsolutePath(), "/course_zip/");
    }

    private final String getGamePackageUnPath() {
        return Intrinsics.stringPlus(AppUtil.getApplication().getFilesDir().getAbsolutePath(), "/course_unzip/");
    }

    /* access modifiers changed from: private */
    public final void saveGamePackageDownloadFinish(String str) {
        if (str != null) {
            ShareDataManager.getInstance().initCanClearSP();
            ShareDataManager instance = ShareDataManager.getInstance();
            instance.put("game_res_" + str + "_is_download", true, ShareDataManager.SHAREDATA_CAN_CLEAR);
        }
    }

    private final boolean isDownloadFinish(String str) {
        if (str == null) {
            return false;
        }
        ShareDataManager.getInstance().initCanClearSP();
        ShareDataManager instance = ShareDataManager.getInstance();
        return instance.getBoolean("game_res_" + str + "_is_download", false, ShareDataManager.SHAREDATA_CAN_CLEAR);
    }

    public final boolean checkGameResIsDownLoad(String str) {
        if (str == null) {
            return false;
        }
        return new File(getGamePackageUnPath() + str + "/index.html").exists();
    }
}
