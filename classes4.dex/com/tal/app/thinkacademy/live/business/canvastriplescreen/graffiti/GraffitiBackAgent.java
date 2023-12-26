package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.content.Context;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import com.tal.app.thinkacademy.live.business.mediacontroller.constants.MediaControlConstants;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\nH\u0016J'\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00182\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00182\u0006\u0010\"\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001dH\u0002J\u0012\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020\u001bH\u0002J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u000eR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiBackAgent;", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiBaseAgent;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mHistoryMsgPageSize", "", "mIsOffline", "", "getMIsOffline", "()Z", "setMIsOffline", "(Z)V", "mLoadedPageSet", "", "mPageKeyList", "", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/StuGraffitiPage;", "beginDrawWithTimestamp", "", "timestamp", "", "initGraffiti", "specifKey", "loadHistoryMsg", "Lcom/xueersi/lib/graffiti/WXWBAction;", "dbkey", "lastMsgId", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHistoryMsgFromLocal", "startMsgId", "onHistoryLoaded", "pageKey", "onTurnPage", "style", "setListener", "setPageSize", "pageSize", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiBackAgent.kt */
public final class GraffitiBackAgent extends GraffitiBaseAgent {
    private final String TAG = "回放";
    private int mHistoryMsgPageSize;
    private boolean mIsOffline;
    /* access modifiers changed from: private */
    public final Set<String> mLoadedPageSet;
    /* access modifiers changed from: private */
    public List<StuGraffitiPage> mPageKeyList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraffitiBackAgent(Context context, BaseLivePluginDriver baseLivePluginDriver, ILiveRoomProvider iLiveRoomProvider) {
        super(context, baseLivePluginDriver, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseLivePluginDriver, "driver");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.mHistoryMsgPageSize = AppConfig.DEBUG ? MediaControlConstants.DURATION_MEDIA_CONTROL_ANIM : AppConfig.SCREEN_RESOLUTION_LANDSCAPE_MAX_PAD;
        DataStorage dataStorage = getMLiveRoomProvider().getDataStorage();
        this.mPageKeyList = dataStorage == null ? null : dataStorage.getPageKeyList();
        this.mLoadedPageSet = new LinkedHashSet();
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.TAG;
    }

    /* access modifiers changed from: protected */
    public boolean getMIsOffline() {
        return this.mIsOffline;
    }

    /* access modifiers changed from: protected */
    public void setMIsOffline(boolean z) {
        this.mIsOffline = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initGraffiti(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "specifKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            super.initGraffiti(r5)
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r5 = r4.getMGraffitiEngine()
            r0 = 1
            if (r5 != 0) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r5.useTimeStampAlign(r0)
        L_0x0013:
            java.io.File r5 = new java.io.File
            java.lang.String r1 = r4.getMPlanId()
            java.lang.String r1 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineGraffitiPath(r1)
            r5.<init>(r1)
            boolean r1 = r5.exists()
            r2 = 0
            if (r1 == 0) goto L_0x0034
            java.lang.String[] r1 = r5.list()
            if (r1 != 0) goto L_0x002f
            r1 = r2
            goto L_0x0030
        L_0x002f:
            int r1 = r1.length
        L_0x0030:
            if (r1 <= 0) goto L_0x0034
            r1 = r0
            goto L_0x0035
        L_0x0034:
            r1 = r2
        L_0x0035:
            r3 = 0
            if (r1 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r5 = r3
        L_0x003a:
            if (r5 != 0) goto L_0x003d
            goto L_0x004b
        L_0x003d:
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r1 = "本地涂鸦数据存在，使用<<离线模式>>"
            r5[r2] = r1
            r4.log(r5)
            r4.setMIsOffline(r0)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x004b:
            if (r3 != 0) goto L_0x005c
            r5 = r4
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r5 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent) r5
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r0 = "本地涂鸦数据不存在，使用<<在线模式>>"
            r5[r2] = r0
            r4.log(r5)
            r4.setMIsOffline(r2)
        L_0x005c:
            r4.setListener()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent.initGraffiti(java.lang.String):void");
    }

    public void onTurnPage(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "pageKey");
        WXTGraffitiEngineImpl mGraffitiEngine = getMGraffitiEngine();
        if (mGraffitiEngine != null) {
            mGraffitiEngine.turnPageTo(str, i);
        }
    }

    private final void setListener() {
        setBaseListener(new GraffitiBackAgent$setListener$1(this));
    }

    public Object loadHistoryMsg(String str, long j, Continuation<? super List<? extends WXWBAction>> continuation) {
        if (getMIsOffline()) {
            return loadHistoryMsgFromLocal(str, j);
        }
        return loadHistoryMsgFromNet(str, j + 1, 1, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.xueersi.lib.graffiti.WXWBAction> loadHistoryMsgFromLocal(java.lang.String r19, long r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = 1
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "开始获取本地文件 dbkey = "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = ",startMsgId "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            r7 = 0
            r0[r7] = r6
            r1.log(r0)
            long r8 = android.os.SystemClock.elapsedRealtime()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6 = r0
            java.util.List r6 = (java.util.List) r6
            java.lang.String r0 = r18.getMPlanId()
            java.lang.String r0 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineGraffitiPath(r0)
            java.io.File r10 = new java.io.File
            java.lang.String r11 = ".json"
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r11)
            r10.<init>(r0, r12)
            boolean r12 = r10.exists()
            r12 = r12 ^ r5
            if (r12 == 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r10 = 0
        L_0x0050:
            if (r10 != 0) goto L_0x0053
            goto L_0x0092
        L_0x0053:
            java.lang.Object[] r12 = new java.lang.Object[r5]
            java.lang.String r10 = r10.getName()
            java.lang.String r14 = "json文件未找到，需要解压 "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r10)
            r12[r7] = r10
            r1.log(r12)
            java.io.File r10 = new java.io.File
            java.lang.String r12 = ".zip"
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r12)
            r10.<init>(r0, r12)
            boolean r12 = r10.exists()
            if (r12 == 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r10 = 0
        L_0x0077:
            if (r10 != 0) goto L_0x007a
            goto L_0x0092
        L_0x007a:
            java.lang.Object[] r12 = new java.lang.Object[r5]
            java.lang.String r14 = r10.getName()
            java.lang.String r15 = "zip文件存在，准备解压 "
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r15, r14)
            r12[r7] = r14
            r1.log(r12)
            java.lang.String r10 = r10.getAbsolutePath()
            com.tal.app.thinkacademy.lib.download.util.ZipUtils.decompressFile(r10, r0)
        L_0x0092:
            java.io.File r10 = new java.io.File
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r11)
            r10.<init>(r0, r11)
            boolean r0 = r10.exists()
            if (r0 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r10 = 0
        L_0x00a3:
            if (r10 != 0) goto L_0x00a9
            r3 = r5
            r13 = 0
            goto L_0x01d5
        L_0x00a9:
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r11 = r10.getName()
            java.lang.String r12 = "json文件存在,准备读取本地涂鸦数据 "
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r11)
            r0[r7] = r11
            r1.log(r0)
            java.lang.String r0 = r10.getAbsolutePath()
            java.util.List r0 = com.tal.app.thinkacademy.lib.util.FileIOUtils.readFile2List((java.lang.String) r0)
            if (r0 != 0) goto L_0x00c7
        L_0x00c4:
            r13 = 0
            goto L_0x01c3
        L_0x00c7:
            java.lang.Object r10 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x00d1
            r10 = 0
            goto L_0x00e5
        L_0x00d1:
            com.tal.app.thinkacademy.lib.util.GsonUtil r11 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()
            java.lang.Class<com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryEntity> r12 = com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryEntity.class
            java.lang.Object r10 = r11.fromJson((java.lang.String) r10, r12)
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryEntity r10 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryEntity) r10
            long r10 = r10.getMsgId()
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
        L_0x00e5:
            r11 = -1
            if (r10 != 0) goto L_0x00ee
            r10 = r1
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r10 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent) r10
            r14 = r11
            goto L_0x00f2
        L_0x00ee:
            long r14 = r10.longValue()
        L_0x00f2:
            java.lang.Object[] r10 = new java.lang.Object[r5]
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r5 = "读取本地json文件，共"
            r13.append(r5)
            int r5 = r0.size()
            r13.append(r5)
            java.lang.String r5 = "条，解析出最后一条msgId:"
            r13.append(r5)
            r13.append(r14)
            java.lang.String r5 = "，耗时:"
            r13.append(r5)
            long r16 = android.os.SystemClock.elapsedRealtime()
            long r8 = r16 - r8
            r13.append(r8)
            java.lang.String r5 = "ms，dbkey = "
            r13.append(r5)
            r13.append(r2)
            java.lang.String r8 = r13.toString()
            r10[r7] = r8
            r1.log(r10)
            long r8 = android.os.SystemClock.elapsedRealtime()
            int r3 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0136
            r3 = 1
            goto L_0x0137
        L_0x0136:
            r3 = r7
        L_0x0137:
            if (r3 == 0) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r0 = 0
        L_0x013b:
            if (r0 != 0) goto L_0x013e
            goto L_0x00c4
        L_0x013e:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r3 = r0.iterator()
        L_0x0144:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0191
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            com.tal.app.thinkacademy.lib.util.GsonUtil r4 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()     // Catch:{ Exception -> 0x017e }
            java.lang.Class<com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryEntity> r10 = com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryEntity.class
            java.lang.Object r0 = r4.fromJson((java.lang.String) r0, r10)     // Catch:{ Exception -> 0x017e }
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryEntity r0 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryEntity) r0     // Catch:{ Exception -> 0x017e }
            long r13 = r0.getMsgId()     // Catch:{ Exception -> 0x017e }
            int r4 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x017c
            java.lang.String r0 = r0.getContent()     // Catch:{ Exception -> 0x017e }
            byte[] r0 = android.util.Base64.decode(r0, r7)     // Catch:{ Exception -> 0x017e }
            java.lang.String r4 = r18.getPageKeyByDBKey(r19)     // Catch:{ Exception -> 0x017e }
            com.xueersi.lib.graffiti.WXWBAction r0 = com.xueersi.lib.graffiti.WXWBAction.Factory.actionForData(r0, r4)     // Catch:{ Exception -> 0x017e }
            java.lang.String r4 = "packageData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ Exception -> 0x017e }
            r6.add(r0)     // Catch:{ Exception -> 0x017e }
        L_0x017c:
            r4 = 1
            goto L_0x0144
        L_0x017e:
            r0 = move-exception
            r4 = 1
            java.lang.Object[] r10 = new java.lang.Object[r4]
            java.lang.String r13 = "本地数据解析异常 "
            java.lang.String r13 = kotlin.jvm.internal.Intrinsics.stringPlus(r13, r2)
            r10[r7] = r13
            r1.log(r10)
            r0.printStackTrace()
            goto L_0x0144
        L_0x0191:
            r4 = 1
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "解析本地数据，当前dbkey共"
            r3.append(r4)
            int r4 = r6.size()
            r3.append(r4)
            java.lang.String r4 = "条有效数据，耗时：: "
            r3.append(r4)
            long r10 = android.os.SystemClock.elapsedRealtime()
            long r10 = r10 - r8
            r3.append(r10)
            r3.append(r5)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0[r7] = r3
            r1.log(r0)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
        L_0x01c3:
            r3 = 1
            if (r13 != 0) goto L_0x01d3
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r4 = "本地json和DB中最后一条msgId相同，视为DB中为最新涂鸦数据 "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r2)
            r0[r7] = r4
            r1.log(r0)
        L_0x01d3:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
        L_0x01d5:
            if (r13 != 0) goto L_0x01e4
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r3 = "本地json文件不存在，涂鸦可能不显示或当前dbkey本无数据 "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
            r0[r7] = r2
            r1.log(r0)
        L_0x01e4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent.loadHistoryMsgFromLocal(java.lang.String, long):java.util.List");
    }

    public final void setPageSize(int i) {
        this.mHistoryMsgPageSize = -1;
    }

    public final void beginDrawWithTimestamp(long j) {
        WXTGraffitiEngineImpl mGraffitiEngine = getMGraffitiEngine();
        if (mGraffitiEngine != null) {
            mGraffitiEngine.beginDrawWithTimestamp(j);
        }
    }

    public void onHistoryLoaded(String str) {
        if (str != null) {
            this.mLoadedPageSet.add(str);
        }
    }
}
