package com.tal.app.thinkacademy.live.business.interactivegames.driver;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.internal.LinkedTreeMap;
import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.PermissionHelper;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.SubmitAsyncGameRequest;
import com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall;
import com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody;
import com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.utils.GameLoadStep;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010%H\u0002J\b\u0010-\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020'H\u0016J\u0018\u00100\u001a\u00020+2\u0006\u0010/\u001a\u00020'2\u0006\u00101\u001a\u00020\rH\u0016J\u0018\u00102\u001a\u00020+2\u0006\u00103\u001a\u0002042\u0006\u00101\u001a\u00020\rH\u0016J\b\u00105\u001a\u00020+H\u0016J\u001c\u00106\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u00010'2\b\u00108\u001a\u0004\u0018\u00010'H\u0016J\u0010\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020;H\u0002J\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u000204J\u0012\u0010>\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010!H\u0002J2\u0010@\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010!2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010B2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010BH\u0002J\u0012\u0010D\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010!H\u0002J/\u0010E\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010G\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020+2\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u000fJ\u000e\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020\u000fJ\u0012\u0010N\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/driver/GamePluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/callback/OnGameLifecycleCall;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "handler", "Landroid/os/Handler;", "isOnDestroy", "", "mClassId", "", "getMClassId", "()Ljava/lang/Integer;", "setMClassId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mCourseInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "getMCourseInfo", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "setMCourseInfo", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;)V", "mExerciseViewCoins", "Landroidx/lifecycle/Observer;", "", "mGameChannelBean", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;", "mGamePluginView", "Lcom/tal/app/thinkacademy/live/business/interactivegames/view/GamePluginView;", "mGameStatus", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameStatus;", "mInteractId", "", "runnable", "Ljava/lang/Runnable;", "loadPlugin", "", "gameStatus", "onDestroy", "onGameExit", "msg", "onGameFail", "isLocal", "onGameLoaded", "duration", "", "onGameReload", "onMessage", "ircTypeKey", "message", "packSubmitAsyncGameData", "data", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsSubmitData;", "removePlugin", "delayMillis", "requestGameStatus", "gameChannelBean", "submitAsyncGameData", "gameImages", "", "userAnswerResult", "submitGameClose", "submitGameData", "rightRate", "isAnswer", "(Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;Ljava/lang/Integer;Ljava/lang/Long;)V", "updateUserCoins", "userCoins", "addCoins", "updateUserLevel", "level", "uploadPic", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "淘汰")
/* compiled from: GamePluginDriver.kt */
public final class GamePluginDriver extends BaseLivePluginDriver implements OnGameLifecycleCall {
    /* access modifiers changed from: private */
    public final Tag TAG;
    private Handler handler;
    /* access modifiers changed from: private */
    public boolean isOnDestroy;
    private Integer mClassId = 0;
    private Context mContext;
    private CourseInfoProxy mCourseInfo;
    private final Observer<Object> mExerciseViewCoins;
    /* access modifiers changed from: private */
    public GameChannelBean mGameChannelBean;
    /* access modifiers changed from: private */
    public GamePluginView mGamePluginView;
    /* access modifiers changed from: private */
    public GameStatus mGameStatus;
    /* access modifiers changed from: private */
    public String mInteractId = "";
    private Runnable runnable;

    public GamePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        CourseInfoProxy courseInfoProxy;
        DataStorage dataStorage;
        Tag tag = Tag.GamePluginDriver;
        this.TAG = tag;
        GamePluginDriver$$ExternalSyntheticLambda0 gamePluginDriver$$ExternalSyntheticLambda0 = new GamePluginDriver$$ExternalSyntheticLambda0(this);
        this.mExerciseViewCoins = gamePluginDriver$$ExternalSyntheticLambda0;
        XesLog.i(tag, "初始化插件");
        Integer num = null;
        if (iLiveRoomProvider != null) {
            WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
            this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        }
        if (iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null) {
            courseInfoProxy = null;
        } else {
            courseInfoProxy = dataStorage.getCourseInfo();
        }
        this.mCourseInfo = courseInfoProxy;
        this.mClassId = courseInfoProxy != null ? Integer.valueOf(courseInfoProxy.getClassId()) : num;
        XesDataBus.with(DataBusKey.EXERCISE_VIEW_COINS).observe((LifecycleOwner) this, gamePluginDriver$$ExternalSyntheticLambda0);
    }

    /* access modifiers changed from: protected */
    public final CourseInfoProxy getMCourseInfo() {
        return this.mCourseInfo;
    }

    /* access modifiers changed from: protected */
    public final void setMCourseInfo(CourseInfoProxy courseInfoProxy) {
        this.mCourseInfo = courseInfoProxy;
    }

    /* access modifiers changed from: protected */
    public final Integer getMClassId() {
        return this.mClassId;
    }

    /* access modifiers changed from: protected */
    public final void setMClassId(Integer num) {
        this.mClassId = num;
    }

    /* access modifiers changed from: private */
    /* renamed from: mExerciseViewCoins$lambda-0  reason: not valid java name */
    public static final void m287mExerciseViewCoins$lambda0(GamePluginDriver gamePluginDriver, Object obj) {
        Intrinsics.checkNotNullParameter(gamePluginDriver, "this$0");
        GameStatus gameStatus = gamePluginDriver.mGameStatus;
        if (gameStatus != null) {
            gameStatus.setAnswer("1");
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<*, *>");
        JSONObject jSONObject = new JSONObject((LinkedTreeMap) obj);
        GameJsSubmitData gameJsSubmitData = (GameJsSubmitData) GsonUtils.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), GameJsSubmitData.class);
        LiveTrack.gameLoadStep$default(GameLoadStep.Submit, (Map) null, 2, (Object) null);
        GamePluginView gamePluginView = gamePluginDriver.mGamePluginView;
        if (gamePluginView != null) {
            Integer rightRate = gameJsSubmitData.getRightRate();
            gamePluginView.setRight((rightRate != null && rightRate.intValue() == 100) ? 1 : 2);
        }
        XesLog.i(gamePluginDriver.TAG, "收到游戏答题结果数据");
        gamePluginDriver.submitGameData(gamePluginDriver.mGameChannelBean, gameJsSubmitData.getRightRate(), Long.valueOf(Long.parseLong("1")));
        gamePluginDriver.uploadPic(gameJsSubmitData);
    }

    public void onMessage(String str, String str2) {
        boolean z;
        if (!this.isOnDestroy) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) && Intrinsics.areEqual(GamePluginDriverKt.GamePluginKey, str)) {
                XesLog.i(this.TAG, Intrinsics.stringPlus("ircTypeKey --> ", str2));
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
                                XesLog.i(this.TAG, "教师端 开启 游戏");
                                GameChannelBean gameChannelBean3 = this.mGameChannelBean;
                                Intrinsics.checkNotNull(gameChannelBean3);
                                requestGameStatus(gameChannelBean3);
                                return;
                            }
                            InteractReportKt.XesLogReport$default("end", "Game", this.mInteractId, (Integer) null, (String) null, 24, (Object) null);
                            XesLog.i(this.TAG, "教师端 关闭 游戏");
                            GameStatus gameStatus = this.mGameStatus;
                            if (gameStatus != null) {
                                if (!Intrinsics.areEqual(gameStatus.isAnswer(), "1") && !Intrinsics.areEqual(gameStatus.getStudentInteractStatus(), "2")) {
                                    GamePluginView gamePluginView = this.mGamePluginView;
                                    if (gamePluginView != null) {
                                        gamePluginView.setRight(3);
                                    }
                                    submitGameData$default(this, this.mGameChannelBean, (Integer) null, (Long) null, 6, (Object) null);
                                }
                                submitGameClose(this.mGameChannelBean);
                                LiveTrack.gameLoadStep(GameLoadStep.Exit, MapsKt.mapOf(new Pair("msg", "教师关闭")));
                                removePlugin(5000);
                            }
                        }
                    }
                } catch (Exception e) {
                    XesLog.e(this.TAG, Intrinsics.stringPlus("e --> ", e.getMessage()));
                    removePlugin(0);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        r2 = (r2 = r2.getDataStorage()).getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGameExit(java.lang.String r24) {
        /*
            r23 = this;
            r6 = r23
            r0 = r24
            java.lang.String r1 = "msg"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            boolean r2 = r6.isOnDestroy
            if (r2 != 0) goto L_0x00a2
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r6.mLiveRoomProvider
            r3 = 0
            if (r2 != 0) goto L_0x0014
        L_0x0012:
            r2 = r3
            goto L_0x002a
        L_0x0014:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x001b
            goto L_0x0012
        L_0x001b:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r2 = r2.getCourseInfo()
            if (r2 != 0) goto L_0x0022
            goto L_0x0012
        L_0x0022:
            int r2 = r2.getClassId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x002a:
            java.lang.String r8 = java.lang.String.valueOf(r2)
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r6.mLiveRoomProvider
            if (r2 != 0) goto L_0x0033
            goto L_0x0049
        L_0x0033:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x003a
            goto L_0x0049
        L_0x003a:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r2 = r2.getCourseInfo()
            if (r2 != 0) goto L_0x0041
            goto L_0x0049
        L_0x0041:
            int r2 = r2.getPlanId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
        L_0x0049:
            java.lang.String r9 = java.lang.String.valueOf(r3)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            java.lang.String r14 = r6.mInteractId
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 16248(0x3f78, float:2.2768E-41)
            r22 = 0
            java.lang.String r7 = "click_exit_game_interact"
            com.tal.app.thinkacademy.common.utils.LeanplumUtil.longTrack$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            com.tal.app.thinkacademy.live.core.utils.GameLoadStep r2 = com.tal.app.thinkacademy.live.core.utils.GameLoadStep.Exit
            kotlin.Pair r3 = new kotlin.Pair
            r3.<init>(r1, r0)
            java.util.Map r0 = kotlin.collections.MapsKt.mapOf(r3)
            com.tal.app.thinkacademy.live.core.utils.LiveTrack.gameLoadStep(r2, r0)
            com.tal.app.thinkacademy.live.util.DriverTrack r0 = com.tal.app.thinkacademy.live.util.DriverTrack.INSTANCE
            java.lang.String r1 = r6.mInteractId
            r0.classRoomInteractGameQuit(r1)
            com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus r0 = r6.mGameStatus
            if (r0 != 0) goto L_0x0081
            goto L_0x009d
        L_0x0081:
            java.lang.String r0 = r0.isAnswer()
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L_0x0098
            com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean r1 = r6.mGameChannelBean
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r23
            submitGameData$default(r0, r1, r2, r3, r4, r5)
        L_0x0098:
            com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean r0 = r6.mGameChannelBean
            r6.submitGameClose(r0)
        L_0x009d:
            r0 = 0
            r6.removePlugin(r0)
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver.onGameExit(java.lang.String):void");
    }

    public void onGameLoaded(long j, boolean z) {
        DataStorage dataStorage;
        CourseInfoProxy courseInfo;
        if (!this.isOnDestroy) {
            String[] strArr = new String[3];
            ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
            Integer num = null;
            if (!(iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null || (courseInfo = dataStorage.getCourseInfo()) == null)) {
                num = Integer.valueOf(courseInfo.getClassId());
            }
            strArr[0] = Intrinsics.stringPlus("class_id=$", num);
            strArr[1] = Intrinsics.stringPlus("interaction_id=", this.mInteractId);
            strArr[2] = Intrinsics.stringPlus("time=", Long.valueOf(System.currentTimeMillis()));
            LeanplumUtil.javaTrack(LeanplumUtil.show_game_interact, strArr);
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("load_duration", Long.valueOf(j));
            linkedHashMap.put("is_local", Boolean.valueOf(z));
            LiveTrack.gameLoadStep(GameLoadStep.LoadSuccess, linkedHashMap);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r3 = (r3 = r3.getDataStorage()).getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGameReload() {
        /*
            r6 = this;
            boolean r0 = r6.isOnDestroy
            if (r0 != 0) goto L_0x0042
            r0 = 2
            java.lang.String[] r1 = new java.lang.String[r0]
            r2 = 0
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3 = r6.mLiveRoomProvider
            r4 = 0
            if (r3 != 0) goto L_0x000f
        L_0x000d:
            r3 = r4
            goto L_0x0025
        L_0x000f:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            if (r3 != 0) goto L_0x0016
            goto L_0x000d
        L_0x0016:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r3 = r3.getCourseInfo()
            if (r3 != 0) goto L_0x001d
            goto L_0x000d
        L_0x001d:
            int r3 = r3.getClassId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0025:
            java.lang.String r5 = "class_id="
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r3)
            r1[r2] = r3
            r2 = 1
            java.lang.String r3 = r6.mInteractId
            java.lang.String r5 = "interaction_id="
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r3)
            r1[r2] = r3
            java.lang.String r2 = "click_refresh_game_interact"
            com.tal.app.thinkacademy.common.utils.LeanplumUtil.javaTrack(r2, r1)
            com.tal.app.thinkacademy.live.core.utils.GameLoadStep r1 = com.tal.app.thinkacademy.live.core.utils.GameLoadStep.Reload
            com.tal.app.thinkacademy.live.core.utils.LiveTrack.gameLoadStep$default(r1, r4, r0, r4)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver.onGameReload():void");
    }

    public void onGameFail(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "msg");
        if (!this.isOnDestroy) {
            LiveTrack.gameLoadStep(GameLoadStep.LoadFail, MapsKt.mapOf(new Pair[]{new Pair("msg", str), new Pair("is_local", Boolean.valueOf(z))}));
        }
    }

    private final void requestGameStatus(GameChannelBean gameChannelBean) {
        XesLog.i(this.TAG, "获取学生答题状态");
        if (gameChannelBean != null) {
            GameApi gameApi = (GameApi) Api.create(GameApi.class);
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/game/status");
            String planId = gameChannelBean.getPlanId();
            Call<HiResponse<GameStatus>> requestGameStatus = gameApi.requestGameStatus(stringPlus, new OpenStatusBody(planId == null ? null : Long.valueOf(Long.parseLong(planId)), gameChannelBean.getInteractId()));
            Callback gamePluginDriver$requestGameStatus$1 = new GamePluginDriver$requestGameStatus$1(this, new GamePluginDriver$requestGameStatus$2(this));
            if (!(requestGameStatus instanceof Call)) {
                requestGameStatus.enqueue(gamePluginDriver$requestGameStatus$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) requestGameStatus, gamePluginDriver$requestGameStatus$1);
            }
        }
    }

    private final void submitGameClose(GameChannelBean gameChannelBean) {
        XesLog.i(this.TAG, "通知服务器游戏关闭");
        if (gameChannelBean != null) {
            GameApi gameApi = (GameApi) Api.create(GameApi.class);
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/game/close");
            String planId = gameChannelBean.getPlanId();
            Call<HiResponse<EmptyBean>> submitGameClose = gameApi.submitGameClose(stringPlus, new OpenStatusBody(planId == null ? null : Long.valueOf(Long.parseLong(planId)), gameChannelBean.getInteractId()));
            Callback gamePluginDriver$submitGameClose$1 = new GamePluginDriver$submitGameClose$1(this);
            if (!(submitGameClose instanceof Call)) {
                submitGameClose.enqueue(gamePluginDriver$submitGameClose$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) submitGameClose, gamePluginDriver$submitGameClose$1);
            }
        }
    }

    static /* synthetic */ void submitGameData$default(GamePluginDriver gamePluginDriver, GameChannelBean gameChannelBean, Integer num, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            num = 0;
        }
        if ((i & 4) != 0) {
            l = Long.valueOf(Long.parseLong("2"));
        }
        gamePluginDriver.submitGameData(gameChannelBean, num, l);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r0.isRight();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void submitGameData(com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean r11, java.lang.Integer r12, java.lang.Long r13) {
        /*
            r10 = this;
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r0 = r10.mGamePluginView
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0008
        L_0x0006:
            r0 = r1
            goto L_0x0016
        L_0x0008:
            java.lang.Integer r0 = r0.isRight()
            if (r0 != 0) goto L_0x000f
            goto L_0x0006
        L_0x000f:
            int r0 = r0.intValue()
            if (r0 != r2) goto L_0x0006
            r0 = r2
        L_0x0016:
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking$Companion r3 = com.tal.app.thinkacademy.common.appmonitor.HWEventTracking.Companion
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking r3 = r3.get()
            java.lang.String r4 = r10.mInteractId
            java.lang.String r5 = "game"
            r3.ostaIaBaseInteractionSubmit(r4, r5, r0)
            com.tal.app.thinkacademy.live.Tag r0 = r10.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "提交游戏数据"
            r2[r1] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            if (r11 == 0) goto L_0x00aa
            java.lang.Class<com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi> r0 = com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.network.Api.create(r0)
            com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi r0 = (com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi) r0
            com.tal.app.thinkacademy.common.imconfig.ImConfig r1 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r1 = r1.getOverseaApi()
            java.lang.String r2 = "/classroom-hub/question/student/game/submit"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            java.lang.String r2 = r11.getPlanId()
            r3 = 0
            if (r2 != 0) goto L_0x004f
            r5 = r3
            goto L_0x0058
        L_0x004f:
            long r4 = java.lang.Long.parseLong(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r5 = r2
        L_0x0058:
            java.lang.String r6 = r11.getInteractId()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r11 = r10.mLiveRoomProvider
            if (r11 != 0) goto L_0x0062
        L_0x0060:
            r9 = r3
            goto L_0x0079
        L_0x0062:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r11 = r11.getDataStorage()
            if (r11 != 0) goto L_0x0069
            goto L_0x0060
        L_0x0069:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r11 = r11.getCourseInfo()
            if (r11 != 0) goto L_0x0070
            goto L_0x0060
        L_0x0070:
            int r11 = r11.getClassId()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r9 = r11
        L_0x0079:
            if (r12 != 0) goto L_0x007c
            goto L_0x0085
        L_0x007c:
            int r11 = r12.intValue()
            long r11 = (long) r11
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
        L_0x0085:
            r7 = r3
            com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody r11 = new com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody
            r4 = r11
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            retrofit2.Call r11 = r0.submitGameData(r1, r11)
            com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver$submitGameData$2 r12 = new com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver$submitGameData$2
            r12.<init>(r10)
            com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver$submitGameData$1 r13 = new com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver$submitGameData$1
            r13.<init>(r10, r12)
            retrofit2.Callback r13 = (retrofit2.Callback) r13
            boolean r12 = r11 instanceof retrofit2.Call
            if (r12 != 0) goto L_0x00a5
            r11.enqueue(r13)
            goto L_0x00aa
        L_0x00a5:
            retrofit2.Call r11 = (retrofit2.Call) r11
            com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation.enqueue(r11, r13)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver.submitGameData(com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean, java.lang.Integer, java.lang.Long):void");
    }

    private final void uploadPic(GameJsSubmitData gameJsSubmitData) {
        FragmentActivity fragmentActivity = this.mContext;
        if (fragmentActivity != null && gameJsSubmitData != null) {
            PermissionHelper.INSTANCE.request(fragmentActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new GamePluginDriver$uploadPic$1$1$1(gameJsSubmitData, this, gameJsSubmitData, fragmentActivity));
        }
    }

    /* access modifiers changed from: private */
    public final void packSubmitAsyncGameData(GameJsSubmitData gameJsSubmitData) {
        ArrayList arrayList = new ArrayList();
        List<Integer> userAnswerResult = gameJsSubmitData.getUserAnswerResult();
        if (userAnswerResult != null) {
            int i = 0;
            for (Object next : userAnswerResult) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ((Number) next).intValue();
                arrayList.add("");
                i = i2;
            }
        }
        submitAsyncGameData(this.mGameChannelBean, arrayList, gameJsSubmitData.getUserAnswerResult());
    }

    /* access modifiers changed from: private */
    public final void submitAsyncGameData(GameChannelBean gameChannelBean, List<String> list, List<Integer> list2) {
        DataStorage dataStorage;
        CourseInfoProxy courseInfo;
        XesLog.i(this.TAG, "提交游戏图片");
        if (gameChannelBean != null) {
            GameApi gameApi = (GameApi) Api.create(GameApi.class);
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/game/submitAsync");
            String planId = gameChannelBean.getPlanId();
            Long valueOf = planId == null ? null : Long.valueOf(Long.parseLong(planId));
            String interactId = gameChannelBean.getInteractId();
            ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
            Call<HiResponse<EmptyBean>> submitAsyncGameData = gameApi.submitAsyncGameData(stringPlus, new SubmitAsyncGameRequest(valueOf, interactId, (iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null || (courseInfo = dataStorage.getCourseInfo()) == null) ? null : Integer.valueOf(courseInfo.getClassId()), list, list2));
            Callback gamePluginDriver$submitAsyncGameData$1 = new GamePluginDriver$submitAsyncGameData$1(this, new GamePluginDriver$submitAsyncGameData$2(this));
            if (!(submitAsyncGameData instanceof Call)) {
                submitAsyncGameData.enqueue(gamePluginDriver$submitAsyncGameData$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) submitAsyncGameData, gamePluginDriver$submitAsyncGameData$1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r3 = (r3 = r3.getDataStorage()).getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadPlugin(com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus r25) {
        /*
            r24 = this;
            r0 = r24
            com.tal.app.thinkacademy.live.Tag r1 = r0.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "开始加载游戏插件"
            r5 = 0
            r3[r5] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r1, r3)
            com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean r1 = r0.mGameChannelBean
            if (r1 != 0) goto L_0x0017
            goto L_0x0108
        L_0x0017:
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r3 = r0.mGamePluginView
            if (r3 != 0) goto L_0x0108
            android.content.Context r7 = r0.mContext
            if (r7 != 0) goto L_0x0021
            goto L_0x0108
        L_0x0021:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3 = r0.mLiveRoomProvider
            r4 = 0
            if (r3 != 0) goto L_0x0028
        L_0x0026:
            r3 = r4
            goto L_0x003e
        L_0x0028:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            if (r3 != 0) goto L_0x002f
            goto L_0x0026
        L_0x002f:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r3 = r3.getCourseInfo()
            if (r3 != 0) goto L_0x0036
            goto L_0x0026
        L_0x0036:
            int r3 = r3.getClassId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x003e:
            java.lang.String r9 = java.lang.String.valueOf(r3)
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3 = r0.mLiveRoomProvider
            if (r3 != 0) goto L_0x0048
        L_0x0046:
            r3 = r4
            goto L_0x005e
        L_0x0048:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            if (r3 != 0) goto L_0x004f
            goto L_0x0046
        L_0x004f:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r3 = r3.getCourseInfo()
            if (r3 != 0) goto L_0x0056
            goto L_0x0046
        L_0x0056:
            int r3 = r3.getPlanId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x005e:
            java.lang.String r10 = java.lang.String.valueOf(r3)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            java.lang.String r15 = r1.getInteractId()
            long r16 = java.lang.System.currentTimeMillis()
            java.lang.String r16 = java.lang.String.valueOf(r16)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 15992(0x3e78, float:2.241E-41)
            r23 = 0
            java.lang.String r8 = "start_game_interact"
            com.tal.app.thinkacademy.common.utils.LeanplumUtil.longTrack$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            java.lang.String r3 = r1.getInteractId()
            java.lang.String r6 = r1.getPlanId()
            if (r6 != 0) goto L_0x0091
            r6 = r5
            goto L_0x0095
        L_0x0091:
            int r6 = java.lang.Integer.parseInt(r6)
        L_0x0095:
            java.lang.Integer r8 = r24.getMClassId()
            if (r8 != 0) goto L_0x009d
            r8 = r5
            goto L_0x00a1
        L_0x009d:
            int r8 = r8.intValue()
        L_0x00a1:
            com.tal.app.thinkacademy.live.util.InteractLogReport.uploadLog(r3, r6, r8)
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r3 = new com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r3
            r6.<init>(r7, r8, r9, r10, r11)
            r0.mGamePluginView = r3
            r6 = r0
            com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall r6 = (com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall) r6
            r3.setGameLifecycleCall(r6)
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r3 = r0.mGamePluginView
            if (r3 != 0) goto L_0x00bb
            goto L_0x00df
        L_0x00bb:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r6 = r0.mLiveRoomProvider
            if (r6 != 0) goto L_0x00c0
            goto L_0x00d6
        L_0x00c0:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r6 = r6.getDataStorage()
            if (r6 != 0) goto L_0x00c7
            goto L_0x00d6
        L_0x00c7:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r6 = r6.getCourseInfo()
            if (r6 != 0) goto L_0x00ce
            goto L_0x00d6
        L_0x00ce:
            int r4 = r6.getClassId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x00d6:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6 = r25
            r3.initHost(r1, r6, r4)
        L_0x00df:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r0.mLiveRoomProvider
            r3 = r0
            com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver r3 = (com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver) r3
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView r4 = r0.mGamePluginView
            com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView r4 = (com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView) r4
            com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData r6 = r0.mPluginConfData
            java.lang.String r7 = "game_interact"
            java.lang.String r6 = r6.getViewLevel(r7)
            android.widget.FrameLayout$LayoutParams r7 = new android.widget.FrameLayout$LayoutParams
            r8 = -1
            r7.<init>(r8, r8)
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r1.addView(r3, r4, r6, r7)
            com.tal.app.thinkacademy.live.Tag r1 = r0.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "loadPlugin --> 加载成功"
            r2[r5] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.s(r1, r2)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver.loadPlugin(com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus):void");
    }

    public final void removePlugin(long j) {
        XesLog.i(this.TAG, Intrinsics.stringPlus("removePlugin --> ", Long.valueOf(j)));
        this.mGameChannelBean = null;
        this.mGameStatus = null;
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        if (this.runnable == null) {
            this.runnable = new GamePluginDriver$$ExternalSyntheticLambda1(this);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            Runnable runnable2 = this.runnable;
            Intrinsics.checkNotNull(runnable2);
            handler2.postDelayed(runnable2, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: removePlugin$lambda-10  reason: not valid java name */
    public static final void m288removePlugin$lambda10(GamePluginDriver gamePluginDriver) {
        Intrinsics.checkNotNullParameter(gamePluginDriver, "this$0");
        GamePluginView gamePluginView = gamePluginDriver.mGamePluginView;
        if (gamePluginView != null) {
            gamePluginView.onDestroy();
        }
        XesLog.s(gamePluginDriver.TAG, "成功移除游戏View");
        ILiveRoomProvider iLiveRoomProvider = gamePluginDriver.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) gamePluginDriver.mGamePluginView);
        }
        gamePluginDriver.mGamePluginView = null;
        gamePluginDriver.onDestroy();
    }

    public final void updateUserCoins(int i, int i2) {
        DataStorage dataStorage;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        UserInfoProxy userInfoProxy = null;
        if (!(iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null)) {
            userInfoProxy = dataStorage.getUserInfo();
        }
        if (userInfoProxy != null) {
            userInfoProxy.setGoldNum(i);
        }
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(GamePluginDriver.class, DataBusKey.USERCOINS_KEY, String.valueOf(i), new CoinEventData(GoldSource.GAME_GOLD, i2, false, false, 12, (DefaultConstructorMarker) null)));
    }

    public final void updateUserLevel(int i) {
        PluginEventBus.onEvent(DataBusKey.LEVEL_KEY, new PluginEventData(TopicPluginLiveDriver.class, DataBusKey.LEVEL_KEY, String.valueOf(i)));
    }

    public void onDestroy() {
        XesLog.i(this.TAG, "插件销毁");
        this.isOnDestroy = true;
        this.mGameChannelBean = null;
        GamePluginView gamePluginView = this.mGamePluginView;
        if (gamePluginView != null) {
            gamePluginView.onDestroy();
        }
        XesDataBus.with(DataBusKey.EXERCISE_VIEW_COINS).removeObserver(this.mExerciseViewCoins);
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.destroyPlugin((BaseLivePluginDriver) this);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            Runnable runnable2 = this.runnable;
            if (runnable2 != null) {
                if (handler2 != null) {
                    Intrinsics.checkNotNull(runnable2);
                    handler2.removeCallbacks(runnable2);
                }
                this.runnable = null;
            }
            this.handler = null;
        }
        this.mContext = null;
    }
}
