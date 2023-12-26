package com.tal.app.thinkacademy.live.business.interactivegames.activity;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.internal.LinkedTreeMap;
import com.gyf.immersionbar.ImmersionBar;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.widget.pad.NotPadAutoScreen;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.databinding.ActivityGameBinding;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody;
import com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall;
import com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.core.utils.GameLoadStep;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014H\u0014J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u0019H\u0016J\u0012\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\u0019H\u0014J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0014H\u0016J\u0018\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\u001a\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u000bH\u0002J\b\u00109\u001a\u00020\u0019H\u0002J\u0012\u0010:\u001a\u00020\u00192\b\u0010;\u001a\u0004\u0018\u00010\u0010H\u0002J/\u0010<\u001a\u00020\u00192\b\u0010;\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020BH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/activity/GameActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/activity/GameViewModel;", "Lcom/tal/app/thinkacademy/live/business/databinding/ActivityGameBinding;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/callback/OnGameLifecycleCall;", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "mAudioManager", "Landroid/media/AudioManager;", "mClassId", "", "mExerciseViewCoins", "Landroidx/lifecycle/Observer;", "", "mGameChannelBean", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;", "mGameStatus", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameStatus;", "mGameToClose", "", "mInteractId", "", "mMaxMusicVolume", "changeMediaVolume", "", "isUp", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "gameToClose", "delay", "", "getMediaVolume", "init", "bean", "initMediaVolume", "initObserver", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGameExit", "msg", "onGameFail", "isLocal", "onGameLoaded", "duration", "onGameReload", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "setMediaVolume", "volume", "submitData", "submitGameClose", "gameChannelBean", "submitGameData", "rightRate", "isAnswer", "(Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;Ljava/lang/Integer;Ljava/lang/Long;)V", "uploadPic", "data", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsSubmitData;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NotPadAutoScreen
/* compiled from: GameActivity.kt */
public final class GameActivity extends BaseVmActivity<GameViewModel, ActivityGameBinding> implements OnGameLifecycleCall {
    private final Tag TAG = Tag.GamePluginDriver;
    private AudioManager mAudioManager;
    private int mClassId;
    private final Observer<Object> mExerciseViewCoins = new GameActivity$$ExternalSyntheticLambda4(this);
    private GameChannelBean mGameChannelBean;
    private GameStatus mGameStatus;
    private final Observer<Boolean> mGameToClose = new GameActivity$$ExternalSyntheticLambda2(this);
    private String mInteractId = "";
    private int mMaxMusicVolume;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            iArr[StateData.DataStatus.ERROR.ordinal()] = 2;
            iArr[StateData.DataStatus.FAILURE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mExerciseViewCoins$lambda-0  reason: not valid java name */
    public static final void m279mExerciseViewCoins$lambda0(GameActivity gameActivity, Object obj) {
        Intrinsics.checkNotNullParameter(gameActivity, "this$0");
        GameStatus gameStatus = gameActivity.mGameStatus;
        if (gameStatus != null) {
            gameStatus.setAnswer("1");
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<*, *>");
        JSONObject jSONObject = new JSONObject((LinkedTreeMap) obj);
        GameJsSubmitData gameJsSubmitData = (GameJsSubmitData) GsonUtils.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), GameJsSubmitData.class);
        LiveTrack.gameLoadStep$default(GameLoadStep.Submit, (Map) null, 2, (Object) null);
        GamePluginView gamePluginView = gameActivity.getBinding().gamePluginView;
        Integer rightRate = gameJsSubmitData.getRightRate();
        gamePluginView.setRight((rightRate != null && rightRate.intValue() == 100) ? 1 : 2);
        XesLog.i(gameActivity.TAG, "收到游戏答题结果数据");
        gameActivity.submitGameData(gameActivity.mGameChannelBean, gameJsSubmitData.getRightRate(), Long.valueOf(Long.parseLong("1")));
        Intrinsics.checkNotNullExpressionValue(gameJsSubmitData, "data");
        gameActivity.uploadPic(gameJsSubmitData);
    }

    /* access modifiers changed from: private */
    /* renamed from: mGameToClose$lambda-1  reason: not valid java name */
    public static final void m280mGameToClose$lambda1(GameActivity gameActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(gameActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            gameActivity.submitData();
            gameActivity.gameToClose(5000);
            return;
        }
        gameActivity.gameToClose(0);
    }

    /* access modifiers changed from: protected */
    public ActivityGameBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityGameBinding inflate = ActivityGameBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().getDecorView().setSystemUiVisibility(2052);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP);
        ImmersionBar.with((Activity) this).keyboardEnable(false).init();
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 2;
            getWindow().setAttributes(attributes);
        }
        super.onCreate(bundle);
        Serializable serializableExtra = getIntent().getSerializableExtra("bean");
        String str = null;
        this.mGameChannelBean = serializableExtra instanceof GameChannelBean ? (GameChannelBean) serializableExtra : null;
        this.mClassId = getIntent().getIntExtra("classId", 0);
        Serializable serializableExtra2 = getIntent().getSerializableExtra("data");
        this.mGameStatus = serializableExtra2 instanceof GameStatus ? (GameStatus) serializableExtra2 : null;
        GameChannelBean gameChannelBean = this.mGameChannelBean;
        if (gameChannelBean != null) {
            str = gameChannelBean.getInteractId();
        }
        this.mInteractId = str;
        GameChannelBean gameChannelBean2 = this.mGameChannelBean;
        if (gameChannelBean2 == null) {
            XesLog.e(this.TAG, "游戏Activity,游戏信令数据为空，异常退出");
            finish();
            return;
        }
        Intrinsics.checkNotNull(gameChannelBean2);
        init(gameChannelBean2);
        initObserver();
        initMediaVolume();
    }

    private final void init(GameChannelBean gameChannelBean) {
        XesLog.i(this.TAG, "初始化游戏Activity");
        String str = this.mInteractId;
        String planId = gameChannelBean.getPlanId();
        InteractLogReport.uploadLog(str, planId == null ? 0 : Integer.parseInt(planId), this.mClassId);
        getBinding().gamePluginView.setGameLifecycleCall(this);
        getBinding().gamePluginView.initHost(gameChannelBean, this.mGameStatus, String.valueOf(this.mClassId));
        XesLog.s(this.TAG, "loadPlugin --> 游戏Activity加载成功");
    }

    private final void initObserver() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.EXERCISE_VIEW_COINS).observe(lifecycleOwner, this.mExerciseViewCoins);
        XesDataBus.with(DataBusKey.GAME_TO_CLOSE).observe(lifecycleOwner, this.mGameToClose);
        ((GameViewModel) getMViewModel()).getMGameSubmitState().observe(lifecycleOwner, new GameActivity$$ExternalSyntheticLambda1(this));
        ((GameViewModel) getMViewModel()).getMGameCloseState().observe(lifecycleOwner, new GameActivity$$ExternalSyntheticLambda0(this));
        ((GameViewModel) getMViewModel()).getMDelayData().observe(lifecycleOwner, new GameActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initObserver$lambda-3  reason: not valid java name */
    public static final void m276initObserver$lambda3(GameActivity gameActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(gameActivity, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        if (i == 1) {
            XesLogTag xesLogTag = gameActivity.TAG;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("游戏数据提交成功：rightCoin = ");
            AnswerBean answerBean = (AnswerBean) stateData.getData();
            Integer num = null;
            sb.append(answerBean == null ? null : Integer.valueOf(answerBean.getRightCoin()));
            sb.append(" --- userLatestCoin = ");
            AnswerBean answerBean2 = (AnswerBean) stateData.getData();
            if (answerBean2 != null) {
                num = Integer.valueOf(answerBean2.getUserLatestCoin());
            }
            sb.append(num);
            objArr[0] = sb.toString();
            XesLog.s(xesLogTag, objArr);
            AnswerBean answerBean3 = (AnswerBean) stateData.getData();
            if (answerBean3 != null) {
                XesDataBus.with(DataBusKey.GAME_NOTIFY_USERINFO).postStickyData(answerBean3);
                InteractReportKt.XesLogReport$default("submit", "Game", gameActivity.mInteractId, 1, (String) null, 16, (Object) null);
                gameActivity.getBinding().gamePluginView.drawResultView(answerBean3);
            }
        } else if (i == 2) {
            XesLog.e(gameActivity.TAG, "提交游戏数据失败onError, code:" + stateData.getCode() + ", msg:" + stateData.getMsg());
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(stateData.getMsg(), new Object[0]);
            InteractReportKt.XesLogReport$default("submit", "Game", gameActivity.mInteractId, 0, (String) null, 16, (Object) null);
        } else if (i == 3) {
            XesLog.e(gameActivity.TAG, "提交游戏数据失败onFail, code:" + stateData.getCode() + ", msg:" + stateData.getMsg());
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(stateData.getMsg(), new Object[0]);
            InteractReportKt.XesLogReport$default("submit", "Game", gameActivity.mInteractId, 0, (String) null, 16, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initObserver$lambda-4  reason: not valid java name */
    public static final void m277initObserver$lambda4(GameActivity gameActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(gameActivity, "this$0");
        if (stateData.getStatus() == StateData.DataStatus.SUCCESS) {
            XesLog.s(gameActivity.TAG, "通知服务器游戏关闭 成功");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initObserver$lambda-5  reason: not valid java name */
    public static final void m278initObserver$lambda5(GameActivity gameActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(gameActivity, "this$0");
        XesLog.i(gameActivity.TAG, "游戏Activity销毁");
        gameActivity.finish();
    }

    private final void submitData() {
        GameStatus gameStatus = this.mGameStatus;
        if (gameStatus != null && !Intrinsics.areEqual(gameStatus.isAnswer(), "1") && !Intrinsics.areEqual(gameStatus.getStudentInteractStatus(), "2")) {
            getBinding().gamePluginView.setRight(3);
            submitGameData$default(this, this.mGameChannelBean, (Integer) null, (Long) null, 6, (Object) null);
        }
    }

    private final void gameToClose(long j) {
        submitGameClose(this.mGameChannelBean);
        LiveTrack.gameLoadStep(GameLoadStep.Exit, MapsKt.mapOf(new Pair("msg", "教师关闭")));
        ((GameViewModel) getMViewModel()).delayDone(j);
    }

    public void onBackPressed() {
        getBinding().gamePluginView.showQuitOutDialog();
    }

    public void onGameExit(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "msg");
        String valueOf = String.valueOf(this.mClassId);
        GameChannelBean gameChannelBean = this.mGameChannelBean;
        LeanplumUtil.longTrack$default(LeanplumUtil.click_exit_game_interact, valueOf, gameChannelBean == null ? null : gameChannelBean.getPlanId(), (String) null, (String) null, (String) null, (String) null, this.mInteractId, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16248, (Object) null);
        LiveTrack.gameLoadStep(GameLoadStep.Exit, MapsKt.mapOf(new Pair("msg", str2)));
        DriverTrack driverTrack = DriverTrack.INSTANCE;
        String str3 = this.mInteractId;
        if (str3 == null) {
            str3 = "";
        }
        driverTrack.classRoomInteractGameQuit(str3);
        submitData();
        gameToClose(0);
        XesDataBus.with(DataBusKey.GAME_NOTIFY_CLOSED).postStickyData(Unit.INSTANCE);
    }

    public void onGameLoaded(long j, boolean z) {
        LeanplumUtil.javaTrack(LeanplumUtil.show_game_interact, Intrinsics.stringPlus("class_id=$", Integer.valueOf(this.mClassId)), Intrinsics.stringPlus("interaction_id=", this.mInteractId), Intrinsics.stringPlus("time=", Long.valueOf(System.currentTimeMillis())));
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("load_duration", Long.valueOf(j));
        linkedHashMap.put("is_local", Boolean.valueOf(z));
        LiveTrack.gameLoadStep(GameLoadStep.LoadSuccess, linkedHashMap);
    }

    public void onGameReload() {
        LeanplumUtil.javaTrack(LeanplumUtil.click_refresh_game_interact, Intrinsics.stringPlus("class_id=", Integer.valueOf(this.mClassId)), Intrinsics.stringPlus("interaction_id=", this.mInteractId));
        LiveTrack.gameLoadStep$default(GameLoadStep.Reload, (Map) null, 2, (Object) null);
    }

    public void onGameFail(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "msg");
        LiveTrack.gameLoadStep(GameLoadStep.LoadFail, MapsKt.mapOf(new Pair[]{new Pair("msg", str), new Pair("is_local", Boolean.valueOf(z))}));
    }

    private final void uploadPic(GameJsSubmitData gameJsSubmitData) {
        ((GameViewModel) getMViewModel()).uploadPic((Context) this, true, gameJsSubmitData, this.mGameChannelBean, this.mClassId);
    }

    static /* synthetic */ void submitGameData$default(GameActivity gameActivity, GameChannelBean gameChannelBean, Integer num, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            num = 0;
        }
        if ((i & 4) != 0) {
            l = Long.valueOf(Long.parseLong("2"));
        }
        gameActivity.submitGameData(gameChannelBean, num, l);
    }

    private final void submitGameData(GameChannelBean gameChannelBean, Integer num, Long l) {
        String interactId;
        Integer isRight = getBinding().gamePluginView.isRight();
        boolean z = isRight != null && isRight.intValue() == 1;
        HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
        String str = "";
        if (!(gameChannelBean == null || (interactId = gameChannelBean.getInteractId()) == null)) {
            str = interactId;
        }
        hWEventTracking.ostaIaBaseInteractionSubmit(str, "game", z);
        XesLog.i(this.TAG, "提交游戏数据");
        if (gameChannelBean != null) {
            GameViewModel gameViewModel = (GameViewModel) getMViewModel();
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/game/submit");
            String planId = gameChannelBean.getPlanId();
            Long l2 = null;
            Long valueOf = planId == null ? null : Long.valueOf(Long.parseLong(planId));
            String interactId2 = gameChannelBean.getInteractId();
            int i = this.mClassId;
            if (num != null) {
                l2 = Long.valueOf((long) num.intValue());
            }
            gameViewModel.submitGameData(stringPlus, new SubmitGameDataBody(valueOf, interactId2, l2, l, Integer.valueOf(i)));
        }
    }

    private final void submitGameClose(GameChannelBean gameChannelBean) {
        XesLog.i(this.TAG, "通知服务器游戏关闭");
        if (gameChannelBean != null) {
            GameViewModel gameViewModel = (GameViewModel) getMViewModel();
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/game/close");
            String planId = gameChannelBean.getPlanId();
            gameViewModel.submitGameClose(stringPlus, new OpenStatusBody(planId == null ? null : Long.valueOf(Long.parseLong(planId)), gameChannelBean.getInteractId()));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            changeMediaVolume(true);
        } else if (i == 25) {
            changeMediaVolume(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private final void changeMediaVolume(boolean z) {
        if (this.mAudioManager != null && this.mMaxMusicVolume > 0) {
            int mediaVolume = getMediaVolume();
            int i = 0;
            XesLog.i(this.TAG, Intrinsics.stringPlus("changeMediaVolume current= ", Integer.valueOf(mediaVolume)));
            int i2 = z ? mediaVolume + 1 : mediaVolume - 1;
            int i3 = this.mMaxMusicVolume;
            if (i2 > i3) {
                i = i3;
            } else if (i2 >= 0) {
                i = i2;
            }
            setMediaVolume(i);
        }
    }

    private final int getMediaVolume() {
        try {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager == null) {
                return 0;
            }
            return audioManager.getStreamVolume(3);
        } catch (Exception e) {
            XesLog.e(this.TAG, Intrinsics.stringPlus("getMediaVolume出错=", e));
            return 0;
        }
    }

    private final void setMediaVolume(int i) {
        try {
            XesLog.i(this.TAG, Intrinsics.stringPlus("setMediaVolume,设置音量为", Integer.valueOf(i)));
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                audioManager.setStreamVolume(3, i, 0);
            }
        } catch (Exception e) {
            XesLog.e(this.TAG, Intrinsics.stringPlus("setMediaVolume出错=", e));
        }
    }

    private final void initMediaVolume() {
        int i;
        Object systemService = getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        this.mAudioManager = audioManager;
        if (audioManager == null) {
            i = 0;
        } else {
            try {
                i = audioManager.getStreamMaxVolume(3);
            } catch (Exception e) {
                XesLog.e(this.TAG, Intrinsics.stringPlus("initMediaVolume,获取最大媒体音量出错=", e));
                return;
            }
        }
        this.mMaxMusicVolume = i;
        XesLog.i(this.TAG, Intrinsics.stringPlus("initMediaVolume,获取最大媒体音量", Integer.valueOf(i)));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        XesDataBus.with(DataBusKey.EXERCISE_VIEW_COINS).removeObserver(this.mExerciseViewCoins);
        XesDataBus.with(DataBusKey.GAME_TO_CLOSE).removeObserver(this.mGameToClose);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        ((GameViewModel) getMViewModel()).getMGameSubmitState().removeObservers(lifecycleOwner);
        ((GameViewModel) getMViewModel()).getMGameCloseState().removeObservers(lifecycleOwner);
    }
}
