package com.tal.app.thinkacademy.live.business.interactivegames.driver;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.internal.LinkedTreeMap;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall;
import com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.utils.GameLoadStep;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u001c\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u00192\b\u0010(\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010)\u001a\u00020\u001cR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/driver/GameBackPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/callback/OnGameLifecycleCall;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isOnDestroy", "", "mClassId", "", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mExerciseViewCoins", "Landroidx/lifecycle/Observer;", "", "mGameChannelBean", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;", "mGamePluginView", "Lcom/tal/app/thinkacademy/live/business/interactivegames/view/GamePluginView;", "mInteractId", "", "mSubTag", "loadPlugin", "", "onDestroy", "onGameExit", "msg", "onGameFail", "isLocal", "onGameLoaded", "duration", "", "onGameReload", "onMessage", "ircTypeKey", "message", "removePlugin", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "回放互动游戏课件插件", liveType = 1, metaDataKey = {"game_interact"}, moduleId = "215")
@ViewLevels({@ViewLevel(level = 140, name = "game_interact")})
/* compiled from: GameBackPluginDriver.kt */
public final class GameBackPluginDriver extends BaseLivePluginDriver implements OnGameLifecycleCall {
    private final Tag TAG;
    private boolean isOnDestroy;
    private Integer mClassId = 0;
    private Context mContext;
    private final Observer<Object> mExerciseViewCoins;
    private GameChannelBean mGameChannelBean;
    private GamePluginView mGamePluginView;
    private String mInteractId = "";
    private String mSubTag = "回放";

    public void onGameFail(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "msg");
    }

    public void onGameLoaded(long j, boolean z) {
    }

    public void onGameReload() {
    }

    public GameBackPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        DataStorage dataStorage;
        CourseInfoProxy courseInfo;
        Tag tag = Tag.GamePluginDriver;
        this.TAG = tag;
        GameBackPluginDriver$$ExternalSyntheticLambda0 gameBackPluginDriver$$ExternalSyntheticLambda0 = new GameBackPluginDriver$$ExternalSyntheticLambda0(this);
        this.mExerciseViewCoins = gameBackPluginDriver$$ExternalSyntheticLambda0;
        XesLog.i(tag, this.mSubTag, "初始化插件");
        Integer num = null;
        if (iLiveRoomProvider != null) {
            WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
            this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        }
        if (!(iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null || (courseInfo = dataStorage.getCourseInfo()) == null)) {
            num = Integer.valueOf(courseInfo.getClassId());
        }
        this.mClassId = num;
        XesDataBus.with(DataBusKey.EXERCISE_VIEW_COINS).observe((LifecycleOwner) this, gameBackPluginDriver$$ExternalSyntheticLambda0);
    }

    /* access modifiers changed from: private */
    /* renamed from: mExerciseViewCoins$lambda-0  reason: not valid java name */
    public static final void m285mExerciseViewCoins$lambda0(GameBackPluginDriver gameBackPluginDriver, Object obj) {
        Intrinsics.checkNotNullParameter(gameBackPluginDriver, "this$0");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<*, *>");
        JSONObject jSONObject = new JSONObject((LinkedTreeMap) obj);
        GameJsSubmitData gameJsSubmitData = (GameJsSubmitData) GsonUtils.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), GameJsSubmitData.class);
        LiveTrack.gameLoadStep$default(GameLoadStep.Submit, (Map) null, 2, (Object) null);
        GamePluginView gamePluginView = gameBackPluginDriver.mGamePluginView;
        if (gamePluginView != null) {
            Integer rightRate = gameJsSubmitData.getRightRate();
            gamePluginView.setRight((rightRate != null && rightRate.intValue() == 100) ? 1 : 2);
        }
        XesLog.i(gameBackPluginDriver.TAG, gameBackPluginDriver.mSubTag, Intrinsics.stringPlus("收到游戏答题结果数据", obj));
    }

    public void onMessage(String str, String str2) {
        boolean z;
        if (!this.isOnDestroy) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) && Intrinsics.areEqual(GamePluginDriverKt.GamePluginKey, str)) {
                XesLog.i(this.TAG, this.mSubTag, Intrinsics.stringPlus("ircTypeKey --> ", str2));
                try {
                    Intrinsics.checkNotNull(str2);
                    JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                    if (optJSONObject != null) {
                        GameChannelBean gameChannelBean = (GameChannelBean) GsonUtils.fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), GameChannelBean.class);
                        this.mGameChannelBean = gameChannelBean;
                        if (gameChannelBean != null) {
                            if (gameChannelBean == null) {
                                z = false;
                            } else {
                                z = Intrinsics.areEqual(gameChannelBean.getPub(), true);
                            }
                            if (z) {
                                GameChannelBean gameChannelBean2 = this.mGameChannelBean;
                                String valueOf = String.valueOf(gameChannelBean2 == null ? null : gameChannelBean2.getInteractId());
                                this.mInteractId = valueOf;
                                InteractReportKt.XesLogReport$default("start", "Game", valueOf, (Integer) null, (String) null, 24, (Object) null);
                                XesLog.i(this.TAG, this.mSubTag, "教师端 开启 游戏");
                                loadPlugin();
                                return;
                            }
                            InteractReportKt.XesLogReport$default("end", "Game", this.mInteractId, (Integer) null, (String) null, 24, (Object) null);
                            XesLog.i(this.TAG, this.mSubTag, "教师端 关闭 游戏");
                            removePlugin();
                        }
                    }
                } catch (Exception e) {
                    XesLog.e(this.TAG, this.mSubTag, Intrinsics.stringPlus("e --> ", e.getMessage()));
                    removePlugin();
                }
            }
        }
    }

    public void onGameExit(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        if (!this.isOnDestroy) {
            removePlugin();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        r3 = (r3 = r3.getDataStorage()).getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void loadPlugin() {
        /*
            r25 = this;
            r0 = r25
            com.tal.app.thinkacademy.live.Tag r1 = r0.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r0.mSubTag
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "开始加载游戏插件"
            r6 = 1
            r3[r6] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r1, r3)
            com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean r1 = r0.mGameChannelBean
            if (r1 != 0) goto L_0x001c
            goto L_0x010e
        L_0x001c:
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r3 = r0.mGamePluginView
            if (r3 != 0) goto L_0x010e
            android.content.Context r8 = r0.mContext
            if (r8 != 0) goto L_0x0026
            goto L_0x010e
        L_0x0026:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3 = r0.mLiveRoomProvider
            r4 = 0
            if (r3 != 0) goto L_0x002d
        L_0x002b:
            r3 = r4
            goto L_0x0043
        L_0x002d:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            if (r3 != 0) goto L_0x0034
            goto L_0x002b
        L_0x0034:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r3 = r3.getCourseInfo()
            if (r3 != 0) goto L_0x003b
            goto L_0x002b
        L_0x003b:
            int r3 = r3.getClassId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0043:
            java.lang.String r10 = java.lang.String.valueOf(r3)
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3 = r0.mLiveRoomProvider
            if (r3 != 0) goto L_0x004d
        L_0x004b:
            r3 = r4
            goto L_0x0063
        L_0x004d:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            if (r3 != 0) goto L_0x0054
            goto L_0x004b
        L_0x0054:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r3 = r3.getCourseInfo()
            if (r3 != 0) goto L_0x005b
            goto L_0x004b
        L_0x005b:
            int r3 = r3.getPlanId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0063:
            java.lang.String r11 = java.lang.String.valueOf(r3)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r16 = r1.getInteractId()
            long r17 = java.lang.System.currentTimeMillis()
            java.lang.String r17 = java.lang.String.valueOf(r17)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 15992(0x3e78, float:2.241E-41)
            r24 = 0
            java.lang.String r9 = "start_game_interact"
            com.tal.app.thinkacademy.common.utils.LeanplumUtil.longTrack$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            java.lang.String r3 = r1.getInteractId()
            java.lang.String r7 = r1.getPlanId()
            if (r7 != 0) goto L_0x0096
            r7 = r5
            goto L_0x009a
        L_0x0096:
            int r7 = java.lang.Integer.parseInt(r7)
        L_0x009a:
            java.lang.Integer r9 = r0.mClassId
            if (r9 != 0) goto L_0x00a0
            r9 = r5
            goto L_0x00a4
        L_0x00a0:
            int r9 = r9.intValue()
        L_0x00a4:
            com.tal.app.thinkacademy.live.util.InteractLogReport.uploadLog(r3, r7, r9)
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r3 = new com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r3
            r7.<init>(r8, r9, r10, r11, r12)
            r0.mGamePluginView = r3
            r7 = r0
            com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall r7 = (com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall) r7
            r3.setGameLifecycleCall(r7)
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r3 = r0.mGamePluginView
            if (r3 != 0) goto L_0x00be
            goto L_0x00e1
        L_0x00be:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r7 = r0.mLiveRoomProvider
            if (r7 != 0) goto L_0x00c4
        L_0x00c2:
            r7 = r4
            goto L_0x00da
        L_0x00c4:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r7 = r7.getDataStorage()
            if (r7 != 0) goto L_0x00cb
            goto L_0x00c2
        L_0x00cb:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r7 = r7.getCourseInfo()
            if (r7 != 0) goto L_0x00d2
            goto L_0x00c2
        L_0x00d2:
            int r7 = r7.getClassId()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
        L_0x00da:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3.initHost(r1, r4, r7)
        L_0x00e1:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r0.mLiveRoomProvider
            r3 = r0
            com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver r3 = (com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver) r3
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r4 = r0.mGamePluginView
            com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView r4 = (com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView) r4
            com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData r7 = r0.mPluginConfData
            java.lang.String r8 = "game_interact"
            java.lang.String r7 = r7.getViewLevel(r8)
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams
            r9 = -1
            r8.<init>(r9, r9)
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r1.addView(r3, r4, r7, r8)
            com.tal.app.thinkacademy.live.Tag r1 = r0.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r0.mSubTag
            r2[r5] = r3
            java.lang.String r3 = "loadPlugin --> 加载成功"
            r2[r6] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.s(r1, r2)
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.driver.GameBackPluginDriver.loadPlugin():void");
    }

    public final void removePlugin() {
        XesLog.i(this.TAG, this.mSubTag, "removePlugin");
        this.mGameChannelBean = null;
        XesLog.s(this.TAG, this.mSubTag, "成功移除游戏View");
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mGamePluginView);
        }
        GamePluginView gamePluginView = this.mGamePluginView;
        if (gamePluginView != null) {
            gamePluginView.onDestroy();
        }
        this.mGamePluginView = null;
        destroy();
    }

    public void onDestroy() {
        XesLog.i(this.TAG, this.mSubTag, "插件销毁");
        this.isOnDestroy = true;
        this.mGameChannelBean = null;
        GamePluginView gamePluginView = this.mGamePluginView;
        if (gamePluginView != null) {
            gamePluginView.onDestroy();
        }
        XesDataBus.with(DataBusKey.EXERCISE_VIEW_COINS).removeObserver(this.mExerciseViewCoins);
        this.mContext = null;
    }
}
