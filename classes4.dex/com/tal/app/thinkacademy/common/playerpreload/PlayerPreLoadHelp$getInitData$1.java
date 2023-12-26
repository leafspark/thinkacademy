package com.tal.app.thinkacademy.common.playerpreload;

import com.tal.app.thinkacademy.common.entity.VideoPreloadListBean;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/playerpreload/PlayerPreLoadHelp$getInitData$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/entity/VideoPreloadListBean;", "onSuccess", "", "t", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerPreLoadHelp.kt */
public final class PlayerPreLoadHelp$getInitData$1 extends OmyCallback<HiResponse<VideoPreloadListBean>> {
    final /* synthetic */ PlayerPreLoadHelp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerPreLoadHelp$getInitData$1(PlayerPreLoadHelp playerPreLoadHelp, PlayerPreLoadHelp$getInitData$2 playerPreLoadHelp$getInitData$2) {
        super(playerPreLoadHelp$getInitData$2);
        this.this$0 = playerPreLoadHelp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = r0.getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.tal.app.thinkacademy.lib.restful.HiResponse<com.tal.app.thinkacademy.common.entity.VideoPreloadListBean> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "t"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Object r0 = r8.getData()
            com.tal.app.thinkacademy.common.entity.VideoPreloadListBean r0 = (com.tal.app.thinkacademy.common.entity.VideoPreloadListBean) r0
            r1 = 0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = r1
            goto L_0x001b
        L_0x0010:
            java.util.List r0 = r0.getCourseInfo()
            if (r0 != 0) goto L_0x0017
            goto L_0x000e
        L_0x0017:
            int r0 = r0.size()
        L_0x001b:
            com.tal.app.thinkacademy.common.Tag r2 = com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r2
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r5 = "获取录播课，视频预加载数据成功:size="
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r0)
            r4[r1] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r2, r4)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r8 = r8.getData()
            com.tal.app.thinkacademy.common.entity.VideoPreloadListBean r8 = (com.tal.app.thinkacademy.common.entity.VideoPreloadListBean) r8
            if (r8 != 0) goto L_0x0043
            goto L_0x0098
        L_0x0043:
            java.util.List r8 = r8.getCourseInfo()
            if (r8 != 0) goto L_0x004a
            goto L_0x0098
        L_0x004a:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
            r2 = r1
        L_0x0051:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0098
            java.lang.Object r4 = r8.next()
            int r5 = r2 + 1
            if (r2 >= 0) goto L_0x0062
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0062:
            com.tal.app.thinkacademy.common.entity.VideoPreloadCourseInfo r4 = (com.tal.app.thinkacademy.common.entity.VideoPreloadCourseInfo) r4
            r2 = 0
            if (r4 != 0) goto L_0x0068
            goto L_0x0075
        L_0x0068:
            java.util.List r4 = r4.getUrls()
            if (r4 != 0) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r4)
            java.lang.String r2 = (java.lang.String) r2
        L_0x0075:
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0083
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            r4 = r1
            goto L_0x0084
        L_0x0083:
            r4 = r3
        L_0x0084:
            if (r4 != 0) goto L_0x0096
            tv.danmaku.ijk.media.psplayer.PSMediaPlayer$CacheItem r4 = new tv.danmaku.ijk.media.psplayer.PSMediaPlayer$CacheItem
            r4.<init>()
            r4.pos = r1
            r6 = 10000(0x2710, float:1.4013E-41)
            r4.duration = r6
            r4.url = r2
            r0.add(r4)
        L_0x0096:
            r2 = r5
            goto L_0x0051
        L_0x0098:
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x00eb
            java.util.Collection r0 = (java.util.Collection) r0
            tv.danmaku.ijk.media.psplayer.PSMediaPlayer$CacheItem[] r8 = new tv.danmaku.ijk.media.psplayer.PSMediaPlayer.CacheItem[r1]
            java.lang.Object[] r8 = r0.toArray(r8)
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r0)
            tv.danmaku.ijk.media.psplayer.PSMediaPlayer$CacheItem[] r8 = (tv.danmaku.ijk.media.psplayer.PSMediaPlayer.CacheItem[]) r8
            com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp r0 = r7.this$0
            boolean r0 = r0.isEnablePreLoad()
            if (r0 == 0) goto L_0x00d3
            com.tal.app.thinkacademy.common.Tag r0 = com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r2 = new java.lang.Object[r3]
            int r3 = r8.length
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "获取录播课，开始启动预加载:size="
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r3)
            r2[r1] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp r0 = r7.this$0
            r0.startPreLoad((tv.danmaku.ijk.media.psplayer.PSMediaPlayer.CacheItem[]) r8, (int) r1)
            goto L_0x00eb
        L_0x00d3:
            com.tal.app.thinkacademy.common.Tag r0 = com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r2 = new java.lang.Object[r3]
            int r8 = r8.length
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r3 = "获取录播课，预下载被屏蔽，不启动:size="
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r8)
            r2[r1] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp$getInitData$1.onSuccess(com.tal.app.thinkacademy.lib.restful.HiResponse):void");
    }
}
