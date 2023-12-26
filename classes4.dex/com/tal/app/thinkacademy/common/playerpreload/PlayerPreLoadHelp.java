package com.tal.app.thinkacademy.common.playerpreload;

import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.VideoPreloadListBean;
import com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl;
import com.tal.app.thinkacademy.common.network.CommonApi;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ!\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/common/playerpreload/PlayerPreLoadHelp;", "", "()V", "mIsLogin", "", "clearCacheData", "", "getInitData", "isEnableHlsCache", "isEnablePreLoad", "isStartPlaybackHlsCache", "isStartPlaybackPreload", "login", "startPlaybackPreload", "url", "", "startPreLoad", "item", "", "Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer$CacheItem;", "mode", "", "([Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer$CacheItem;I)V", "startPreLoadCommon", "stopPreLoad", "Companion", "InstanceHelper", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerPreLoadHelp.kt */
public final class PlayerPreLoadHelp {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.VOD_PLAYER_PLAY;
    private boolean mIsLogin;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/playerpreload/PlayerPreLoadHelp$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "getInstance", "Lcom/tal/app/thinkacademy/common/playerpreload/PlayerPreLoadHelp;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlayerPreLoadHelp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlayerPreLoadHelp getInstance() {
            return InstanceHelper.INSTANCE.getSSingle();
        }
    }

    public PlayerPreLoadHelp() {
        login();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/playerpreload/PlayerPreLoadHelp$InstanceHelper;", "", "()V", "sSingle", "Lcom/tal/app/thinkacademy/common/playerpreload/PlayerPreLoadHelp;", "getSSingle", "()Lcom/tal/app/thinkacademy/common/playerpreload/PlayerPreLoadHelp;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlayerPreLoadHelp.kt */
    public static final class InstanceHelper {
        public static final InstanceHelper INSTANCE = new InstanceHelper();
        private static final PlayerPreLoadHelp sSingle = new PlayerPreLoadHelp();

        private InstanceHelper() {
        }

        public final PlayerPreLoadHelp getSSingle() {
            return sSingle;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r0 = r0.getUid();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void login() {
        /*
            r8 = this;
            boolean r0 = r8.mIsLogin
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r0 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r0 = r0.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r0 = r0.getUserInfoEntity()
            java.lang.String r1 = "visitor"
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r6 = r1
            goto L_0x001d
        L_0x0015:
            java.lang.String r0 = r0.getUid()
            if (r0 != 0) goto L_0x001c
            goto L_0x0013
        L_0x001c:
            r6 = r0
        L_0x001d:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r2 = "school_code"
            java.lang.String r3 = "415"
            java.lang.String r7 = r0.getString(r2, r3, r1)
            java.lang.String r0 = "getInstance().getString(…ager.SHAREDATA_NOT_CLEAR)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer$Companion r2 = com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer.Companion
            java.lang.String r3 = "hw20001"
            java.lang.String r4 = ""
            r5 = r6
            r2.login(r3, r4, r5, r6, r7)
            java.io.File r0 = new java.io.File
            java.lang.String r1 = com.tal.app.thinkacademy.lib.util.PathUtils.getInternalAppFilesPath()
            java.lang.String r2 = "HwVideoCache"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x004e
            r0.mkdirs()
        L_0x004e:
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer$Companion r1 = com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer.Companion
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r2 = "workSpaceDir.absolutePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r2 = 10240(0x2800, float:1.4349E-41)
            r1.setCachePath(r0, r2)
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer$Companion r0 = com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer.Companion
            com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp$login$1 r1 = new com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp$login$1
            r1.<init>()
            tv.danmaku.ijk.media.psplayer.PSMediaPlayer$PreloadListener r1 = (tv.danmaku.ijk.media.psplayer.PSMediaPlayer.PreloadListener) r1
            r0.setPreListen(r1)
            r0 = 1
            r8.mIsLogin = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp.login():void");
    }

    public final boolean isEnablePreLoad() {
        return !Intrinsics.areEqual(EnterRoomMuteData.STATUS_UN_MUTE, HwCloudControlHelper.Companion.get().getCloudKeyValue("video_pre_cache_enable"));
    }

    public final boolean isEnableHlsCache() {
        return !Intrinsics.areEqual(EnterRoomMuteData.STATUS_UN_MUTE, HwCloudControlHelper.Companion.get().getCloudKeyValue("video_hls_cache_enable"));
    }

    public final boolean isStartPlaybackHlsCache() {
        boolean areEqual = Intrinsics.areEqual("1", HwCloudControlHelper.Companion.get().getCloudKeyValue("playback_hls_cache_enable"));
        XesLog.i(TAG, Intrinsics.stringPlus("是否启动回放边下边播=", Boolean.valueOf(areEqual)));
        return areEqual;
    }

    private final boolean isStartPlaybackPreload() {
        boolean areEqual = Intrinsics.areEqual("1", HwCloudControlHelper.Companion.get().getCloudKeyValue("playback_pre_cache_enable"));
        XesLog.i(TAG, Intrinsics.stringPlus("是否启动回放边下边播=", Boolean.valueOf(areEqual)));
        return areEqual;
    }

    public final void startPlaybackPreload(String str) {
        if (!isStartPlaybackPreload()) {
            XesLog.i(TAG, Intrinsics.stringPlus("启动回放预加载失败，云控不允许，url=", str));
            return;
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            XesLog.i(TAG, Intrinsics.stringPlus("启动回放预加载，url=", str));
            PSMediaPlayer.CacheItem cacheItem = new PSMediaPlayer.CacheItem();
            cacheItem.pos = 0;
            cacheItem.duration = 10000;
            cacheItem.url = str;
            startPreLoadCommon(cacheItem, 1);
            return;
        }
        XesLog.i(TAG, Intrinsics.stringPlus("启动回放预加载失败，url=", str));
    }

    public final void startPreLoadCommon(PSMediaPlayer.CacheItem cacheItem, int i) {
        Intrinsics.checkNotNullParameter(cacheItem, "item");
        login();
        IJKPlayer.Companion.startPreload(cacheItem, i);
    }

    public final void startPreLoad(PSMediaPlayer.CacheItem cacheItem, int i) {
        Intrinsics.checkNotNullParameter(cacheItem, "item");
        if (!isEnablePreLoad()) {
            XesLog.i(TAG, "startPreLoad，未开启预缓存");
            return;
        }
        login();
        IJKPlayer.Companion.startPreload(cacheItem, i);
    }

    public final void startPreLoad(PSMediaPlayer.CacheItem[] cacheItemArr, int i) {
        Intrinsics.checkNotNullParameter(cacheItemArr, "item");
        if (!isEnablePreLoad()) {
            XesLog.i(TAG, "startPreLoad l，未开启预缓存");
            return;
        }
        login();
        IJKPlayer.Companion.startPreload(cacheItemArr, i);
    }

    public final void stopPreLoad() {
        login();
        IJKPlayer.Companion.stopPreload();
    }

    public final void clearCacheData() {
        stopPreLoad();
        File file = new File(PathUtils.getInternalAppFilesPath(), "HwVideoCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        IJKPlayer.Companion companion = IJKPlayer.Companion;
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "workSpaceDir.absolutePath");
        companion.cleanCacheData(absolutePath);
    }

    public final void getInitData() {
        if (!isEnablePreLoad()) {
            XesLog.i(TAG, "getInitData，未开启预缓存");
        } else if (UserInfoBll.Companion.getInstance().isGuest()) {
            XesLog.i(TAG, "获取录播课，预加载数据,未登录，不获取！！！");
        } else {
            Call<HiResponse<VideoPreloadListBean>> vodPlayerPreloadData = ((CommonApi) Api.create(CommonApi.class)).getVodPlayerPreloadData(Intrinsics.stringPlus(ServerConfigUrl.INSTANCE.getBASE_URL(), "api/beibo/student/init"));
            Callback playerPreLoadHelp$getInitData$1 = new PlayerPreLoadHelp$getInitData$1(this, new PlayerPreLoadHelp$getInitData$2());
            if (!(vodPlayerPreloadData instanceof Call)) {
                vodPlayerPreloadData.enqueue(playerPreLoadHelp$getInitData$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) vodPlayerPreloadData, playerPreLoadHelp$getInitData$1);
            }
        }
    }
}
