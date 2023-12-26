package com.tal.app.thinkacademy.live.business.interactivegames.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.server.ServerManager;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover;
import com.tal.app.thinkacademy.common.dialog.CommonDialog;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.AssetsFileUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.EncodeUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.ResultFactory;
import com.tal.app.thinkacademy.live.business.continuous.window.IWindowManager;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessInteractiveGameBinding;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsDataBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus;
import com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.core.layout.LayoutLiveData;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010*\u0001N\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\\B%\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u00109\u001a\u00020:H\u0016J\"\u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020AH\u0014J\u0012\u0010B\u001a\u0004\u0018\u00010,2\u0006\u0010C\u001a\u00020DH\u0002J\u000e\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020GJ\u0018\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020!H\u0002J\u000e\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MH\u0002J\"\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010Q\u001a\u0004\u0018\u00010!J\b\u0010R\u001a\u00020:H\u0002J\b\u0010S\u001a\u00020:H\u0002J*\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020A2\u0006\u0010P\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010W\u001a\u00020:J\u0010\u0010X\u001a\u00020:2\b\u0010Y\u001a\u0004\u0018\u00010!J\b\u0010Z\u001a\u00020:H\u0002J\u0006\u0010[\u001a\u00020:R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006]"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/view/GamePluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessInteractiveGameBinding;", "Lcom/tal/app/thinkacademy/live/business/continuous/window/IWindowManager;", "cxt", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bean", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;", "closeHandler", "Landroid/os/Handler;", "getCloseHandler", "()Landroid/os/Handler;", "setCloseHandler", "(Landroid/os/Handler;)V", "gameLifecycleCall", "Lcom/tal/app/thinkacademy/live/business/interactivegames/callback/OnGameLifecycleCall;", "getGameLifecycleCall", "()Lcom/tal/app/thinkacademy/live/business/interactivegames/callback/OnGameLifecycleCall;", "setGameLifecycleCall", "(Lcom/tal/app/thinkacademy/live/business/interactivegames/callback/OnGameLifecycleCall;)V", "gameStatus", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameStatus;", "isRight", "()Ljava/lang/Integer;", "setRight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mClassId", "", "mErrorDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "mHandler", "mLayoutObserver", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaContext;", "mQuitOutDialog", "mStartLoadTime", "", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "window", "Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultView;", "getWindow", "()Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultView;", "setWindow", "(Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultView;)V", "close", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "createWebAgent", "params", "Landroid/widget/FrameLayout$LayoutParams;", "drawResultView", "answerBean", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "getDistalHost", "recover", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfoRecover;", "catalog", "getLifeHandlers", "", "com/tal/app/thinkacademy/live/business/interactivegames/view/GamePluginView$getLifeHandlers$1", "initHost", "gameChannelBean", "classId", "loadGame", "loadJs", "loadUrl", "host", "isServerRun", "onDestroy", "showCoinsView", "userCoins", "showErrorDialog", "showQuitOutDialog", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GamePluginView.kt */
public final class GamePluginView extends BaseVBLivePluginView<LiveBusinessInteractiveGameBinding> implements IWindowManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long LOAD_TIMEOUT = 10000;
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.GamePluginDriver;
    private GameChannelBean bean;
    private Handler closeHandler;
    private OnGameLifecycleCall gameLifecycleCall;
    private GameStatus gameStatus;
    private Integer isRight;
    private String mClassId;
    private BaseDialog mErrorDialog;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private final Observer<LiveAreaContext> mLayoutObserver;
    private BaseDialog mQuitOutDialog;
    /* access modifiers changed from: private */
    public long mStartLoadTime;
    private WebAgent mWebAgent;
    private Runnable runnable;
    private SubmitResultView window;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GamePluginView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GamePluginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/view/GamePluginView$Companion;", "", "()V", "LOAD_TIMEOUT", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GamePluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Integer isRight() {
        return this.isRight;
    }

    public final void setRight(Integer num) {
        this.isRight = num;
    }

    public final OnGameLifecycleCall getGameLifecycleCall() {
        return this.gameLifecycleCall;
    }

    public final void setGameLifecycleCall(OnGameLifecycleCall onGameLifecycleCall) {
        this.gameLifecycleCall = onGameLifecycleCall;
    }

    public final SubmitResultView getWindow() {
        return this.window;
    }

    public final void setWindow(SubmitResultView submitResultView) {
        this.window = submitResultView;
    }

    public final Handler getCloseHandler() {
        return this.closeHandler;
    }

    public final void setCloseHandler(Handler handler) {
        this.closeHandler = handler;
    }

    public final Runnable getRunnable() {
        return this.runnable;
    }

    public final void setRunnable(Runnable runnable2) {
        this.runnable = runnable2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GamePluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "cxt");
        this.mClassId = "";
        this.isRight = 0;
        this.mHandler = new Handler(Looper.getMainLooper());
        GamePluginView$$ExternalSyntheticLambda4 gamePluginView$$ExternalSyntheticLambda4 = new GamePluginView$$ExternalSyntheticLambda4(this);
        this.mLayoutObserver = gamePluginView$$ExternalSyntheticLambda4;
        XesLog.a(TAG, "视图初始化");
        this.mBinding.btnGameBack.setOnClickListener(new GamePluginView$$ExternalSyntheticLambda1(this));
        this.mBinding.btnGameRefresh.setOnClickListener(new GamePluginView$$ExternalSyntheticLambda0(this));
        loadGame();
        LayoutLiveData layoutLiveData = LiveAreaContext.get().layoutObserver;
        LifecycleOwner context2 = getContext();
        Objects.requireNonNull(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        layoutLiveData.observe((FragmentActivity) context2, gamePluginView$$ExternalSyntheticLambda4);
        StickyLiveData with = XesDataBus.with(DataBusKey.HEADERS_DATA);
        LifecycleOwner context3 = getContext();
        Objects.requireNonNull(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        with.observe((FragmentActivity) context3, new GamePluginView$$ExternalSyntheticLambda5(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GamePluginView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public LiveBusinessInteractiveGameBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessInteractiveGameBinding inflate = LiveBusinessInteractiveGameBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: mLayoutObserver$lambda-0  reason: not valid java name */
    public static final void m299mLayoutObserver$lambda0(GamePluginView gamePluginView, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(gamePluginView, "this$0");
        XesLog.a(TAG, "布局变化，重新加载");
        gamePluginView.loadGame();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m294_init_$lambda1(GamePluginView gamePluginView, View view) {
        Intrinsics.checkNotNullParameter(gamePluginView, "this$0");
        gamePluginView.showQuitOutDialog();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m295_init_$lambda2(GamePluginView gamePluginView, View view) {
        Intrinsics.checkNotNullParameter(gamePluginView, "this$0");
        XesLog.a(TAG, "用户主动刷新游戏");
        OnGameLifecycleCall onGameLifecycleCall = gamePluginView.gameLifecycleCall;
        if (onGameLifecycleCall != null) {
            onGameLifecycleCall.onGameReload();
        }
        gamePluginView.loadGame();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m296_init_$lambda3(GamePluginView gamePluginView, String str) {
        Intrinsics.checkNotNullParameter(gamePluginView, "this$0");
        WebAgent webAgent = gamePluginView.mWebAgent;
        if (webAgent != null) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.String");
            webAgent.jsCallBack("window.clientMessageHandlers", str);
        }
        XesLog.i(TAG, str);
    }

    private final void loadGame() {
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = createWebAgent(new FrameLayout.LayoutParams(-1, -1));
        GameChannelBean gameChannelBean = this.bean;
        if (gameChannelBean != null) {
            initHost(gameChannelBean, this.gameStatus, this.mClassId);
        }
    }

    private final WebAgent createWebAgent(FrameLayout.LayoutParams layoutParams) {
        FragmentActivity context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        WebAgent applyLifeHandler = new WebAgent(context).applyLifeHandler(getLifeHandlers());
        AgentConfig.Builder builder = new AgentConfig.Builder();
        builder.setShowProgressBar(false);
        builder.setShowTitle(false);
        WebAgent applyConfig = applyLifeHandler.applyConfig(builder.build());
        if (applyConfig == null) {
            return null;
        }
        return applyConfig.setWebAgentParent(this.mBinding.layoutWebContainer, layoutParams);
    }

    public final void initHost(GameChannelBean gameChannelBean, GameStatus gameStatus2, String str) {
        String onlineUrl;
        Intrinsics.checkNotNullParameter(gameChannelBean, "gameChannelBean");
        this.mClassId = str;
        LeanplumUtil.javaTrack(LeanplumUtil.start_load_game_interact, Intrinsics.stringPlus("class_id=", str), Intrinsics.stringPlus("interaction_id=", gameChannelBean.getInteractId()), Intrinsics.stringPlus("time=", Long.valueOf(System.currentTimeMillis())));
        this.mStartLoadTime = System.currentTimeMillis();
        this.mBinding.bgLoading.setVisibility(0);
        this.bean = gameChannelBean;
        this.gameStatus = gameStatus2;
        if (!ServerManager.getInstance().isServerRunning() || ImConfig.INSTANCE.isUpDataCommonPackage()) {
            XesLogTag xesLogTag = TAG;
            Object[] objArr = new Object[1];
            ConfigInfo.CourseWares commonDistInfo = ImConfig.INSTANCE.getCommonDistInfo();
            objArr[0] = Intrinsics.stringPlus("加载互动游戏课件--->服务器未启动，onLocalSHost: 远端地址 = ", commonDistInfo == null ? null : commonDistInfo.getOnlineUrl());
            XesLog.i(xesLogTag, objArr);
            ConfigInfo.CourseWares commonDistInfo2 = ImConfig.INSTANCE.getCommonDistInfo();
            String str2 = "https://sszt-mgr.oss-cn-beijing.aliyuncs.com/courseware/";
            if (!(commonDistInfo2 == null || (onlineUrl = commonDistInfo2.getOnlineUrl()) == null)) {
                str2 = onlineUrl;
            }
            loadUrl(str2, false, gameChannelBean, gameStatus2);
            return;
        }
        XesLog.i(TAG, "加载互动游戏课件--->服务器启动正常并且基础包加载正常");
        loadUrl("http://localhost:8080/", true, gameChannelBean, gameStatus2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void loadUrl(java.lang.String r16, boolean r17, com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean r18, com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus r19) {
        /*
            r15 = this;
            r0 = r15
            r1 = r17
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.Class<com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover> r3 = com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover.class
            java.lang.String r4 = r18.getPlanId()
            int r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.Object r2 = r2.getCacheEntity(r3, r4, r5)
            com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover r2 = (com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover) r2
            java.lang.String r3 = " -- 游戏课件加载线上资源地址: "
            java.lang.String r4 = "mCourseWareInfoRecover"
            java.lang.String r5 = "游戏加载---> isServerRun="
            r6 = 1
            r7 = 47
            r8 = 0
            if (r1 == 0) goto L_0x00c4
            com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils r9 = com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils.INSTANCE
            java.lang.String r10 = r18.getPlanId()
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            boolean r9 = com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils.isCourseFinished$default(r9, r10, r11, r12, r13, r14)
            if (r9 != 0) goto L_0x0081
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r4 = r2.getCatalog()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r4 = r15.getDistalHost(r2, r4)
            r9.append(r4)
            r9.append(r7)
            java.lang.String r2 = r2.getCatalog()
            r9.append(r2)
            r9.append(r7)
            java.lang.String r2 = r18.getInteractiveTemplatePath()
            r9.append(r2)
            java.lang.String r2 = r9.toString()
            com.tal.app.thinkacademy.live.Tag r4 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r4 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r4
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            r9.append(r1)
            r9.append(r3)
            r9.append(r2)
            java.lang.String r1 = r9.toString()
            r7[r8] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r4, r7)
            goto L_0x0112
        L_0x0081:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r16
            r3.append(r4)
            java.lang.String r2 = r2.getCatalog()
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = r18.getInteractiveTemplatePath()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.tal.app.thinkacademy.live.Tag r3 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r3 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r3
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            r7.append(r1)
            java.lang.String r1 = " -- 游戏课件加载线下本地资源: "
            r7.append(r1)
            r7.append(r2)
            java.lang.String r1 = r7.toString()
            r4[r8] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r3, r4)
            r1 = r6
            goto L_0x0113
        L_0x00c4:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r4 = r2.getCatalog()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r4 = r15.getDistalHost(r2, r4)
            r9.append(r4)
            r9.append(r7)
            java.lang.String r2 = r2.getCatalog()
            r9.append(r2)
            r9.append(r7)
            java.lang.String r2 = r18.getInteractiveTemplatePath()
            r9.append(r2)
            java.lang.String r2 = r9.toString()
            com.tal.app.thinkacademy.live.Tag r4 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r4 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r4
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            r9.append(r1)
            r9.append(r3)
            r9.append(r2)
            java.lang.String r1 = r9.toString()
            r7[r8] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r4, r7)
        L_0x0112:
            r1 = r8
        L_0x0113:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = "?role=student&planId="
            r3.append(r2)
            java.lang.String r2 = r18.getPlanId()
            r3.append(r2)
            java.lang.String r2 = "&interactId="
            r3.append(r2)
            java.lang.String r2 = r18.getInteractId()
            r3.append(r2)
            java.lang.String r2 = "&classId="
            r3.append(r2)
            java.lang.String r2 = r0.mClassId
            r3.append(r2)
            java.lang.String r2 = "&nickName="
            r3.append(r2)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r2 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r2 = r2.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r2 = r2.getUserInfoEntity()
            r4 = 0
            if (r2 != 0) goto L_0x0151
            r2 = r4
            goto L_0x0155
        L_0x0151:
            java.lang.String r2 = r2.getNickName()
        L_0x0155:
            java.lang.String r2 = com.tal.app.thinkacademy.lib.util.EncodeUtils.urlEncode(r2)
            r3.append(r2)
            java.lang.String r2 = "&platform=android&requestUrl="
            r3.append(r2)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r2 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r2 = r2.getOverseaApi()
            r3.append(r2)
            java.lang.String r2 = "&isAnswer="
            r3.append(r2)
            java.lang.String r2 = "2"
            if (r19 != 0) goto L_0x0174
            goto L_0x017c
        L_0x0174:
            java.lang.String r5 = r19.isAnswer()
            if (r5 != 0) goto L_0x017b
            goto L_0x017c
        L_0x017b:
            r2 = r5
        L_0x017c:
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.tal.app.thinkacademy.live.core.utils.GameLoadStep r3 = com.tal.app.thinkacademy.live.core.utils.GameLoadStep.StartLoad
            kotlin.Pair r5 = new kotlin.Pair
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)
            java.lang.String r9 = "is_local"
            r5.<init>(r9, r7)
            java.util.Map r5 = kotlin.collections.MapsKt.mapOf(r5)
            com.tal.app.thinkacademy.live.core.utils.LiveTrack.gameLoadStep(r3, r5)
            com.tal.app.thinkacademy.live.Tag r3 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r3 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r3
            java.lang.Object[] r5 = new java.lang.Object[r6]
            java.lang.String r6 = "游戏加载---> finalUrl:"
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r2)
            r5[r8] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.s(r3, r5)
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r3 = r0.mWebAgent
            if (r3 != 0) goto L_0x01ad
            goto L_0x01b0
        L_0x01ad:
            r3.loadUrl(r2)
        L_0x01b0:
            android.os.Handler r2 = r0.mHandler
            r2.removeCallbacksAndMessages(r4)
            android.os.Handler r2 = r0.mHandler
            com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView$$ExternalSyntheticLambda7 r3 = new com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView$$ExternalSyntheticLambda7
            r3.<init>(r15, r1)
            r4 = 10000(0x2710, double:4.9407E-320)
            r2.postDelayed(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView.loadUrl(java.lang.String, boolean, com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean, com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: loadUrl$lambda-6  reason: not valid java name */
    public static final void m298loadUrl$lambda6(GamePluginView gamePluginView, boolean z) {
        Intrinsics.checkNotNullParameter(gamePluginView, "this$0");
        XesLog.e(TAG, "游戏失败 : 超时");
        OnGameLifecycleCall onGameLifecycleCall = gamePluginView.gameLifecycleCall;
        if (onGameLifecycleCall != null) {
            onGameLifecycleCall.onGameFail("加载超时", z);
        }
        gamePluginView.showErrorDialog();
    }

    private final String getDistalHost(CouseWareInfoRecover couseWareInfoRecover, String str) {
        try {
            String compressIndexUrl = couseWareInfoRecover.getCompressIndexUrl();
            if (compressIndexUrl == null) {
                return "";
            }
            String substring = compressIndexUrl.substring(0, StringsKt.indexOf$default(compressIndexUrl, str, 0, false, 6, (Object) null) - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            if (substring == null) {
                return "";
            }
            return substring;
        } catch (Exception e) {
            XesLog.e(TAG, Intrinsics.stringPlus("获取游戏在线地址失败 ", e.getMessage()));
            return "";
        }
    }

    public final void showQuitOutDialog() {
        if (this.mQuitOutDialog == null) {
            GamePluginView gamePluginView = this;
            this.mQuitOutDialog = new CommonDialog(getContext()).setTitleText(R.string.leave_game_title).setMsgText(R.string.leave_game).setConfirmClick(R.string.tv_exit, new GamePluginView$showQuitOutDialog$1$quitDialog$1(this)).layoutParams(new ViewGroup.LayoutParams(SizeUtils.dp2px(343.0f), -2)).gravity(17).canceledOnTouchOutside(true);
        }
        BaseDialog baseDialog = this.mQuitOutDialog;
        if (baseDialog != null) {
            baseDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public final void showErrorDialog() {
        if (this.mErrorDialog == null) {
            GamePluginView gamePluginView = this;
            BaseDialog canceledOnTouchOutside = new BaseDialog(getContext()).contentView(R.layout.dialog_quit).layoutParams(new ViewGroup.LayoutParams(SizeUtils.dp2px(343.0f), -2)).gravity(17).canceledOnTouchOutside(true);
            TextView textView = (TextView) canceledOnTouchOutside.findViewById(R.id.tv_cancel);
            TextView textView2 = (TextView) canceledOnTouchOutside.findViewById(R.id.tv_confirm);
            ((TextView) canceledOnTouchOutside.findViewById(R.id.tv_dialog_title)).setText(R.string.game_load_error);
            textView2.setText(R.string.tv_reload);
            textView.setText(R.string.tv_exit);
            textView2.setOnClickListener(new GamePluginView$$ExternalSyntheticLambda3(this, canceledOnTouchOutside));
            textView.setOnClickListener(new GamePluginView$$ExternalSyntheticLambda2(this, canceledOnTouchOutside));
            this.mErrorDialog = canceledOnTouchOutside;
        }
        try {
            BaseDialog baseDialog = this.mErrorDialog;
            if (baseDialog != null) {
                baseDialog.show();
            }
        } catch (Exception e) {
            XesLog.e(TAG, Intrinsics.stringPlus("捕获异常：showErrorDialog error : ", e.getMessage()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showErrorDialog$lambda-11$lambda-9  reason: not valid java name */
    public static final void m301showErrorDialog$lambda11$lambda9(GamePluginView gamePluginView, BaseDialog baseDialog, View view) {
        Intrinsics.checkNotNullParameter(gamePluginView, "this$0");
        XesLog.a(TAG, "游戏加载异常，重新加载");
        OnGameLifecycleCall onGameLifecycleCall = gamePluginView.gameLifecycleCall;
        if (onGameLifecycleCall != null) {
            onGameLifecycleCall.onGameReload();
        }
        gamePluginView.loadGame();
        baseDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showErrorDialog$lambda-11$lambda-10  reason: not valid java name */
    public static final void m300showErrorDialog$lambda11$lambda10(GamePluginView gamePluginView, BaseDialog baseDialog, View view) {
        Intrinsics.checkNotNullParameter(gamePluginView, "this$0");
        XesLog.a(TAG, "游戏加载异常，用户退出");
        OnGameLifecycleCall onGameLifecycleCall = gamePluginView.gameLifecycleCall;
        if (onGameLifecycleCall != null) {
            onGameLifecycleCall.onGameExit("游戏异常");
        }
        baseDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final List<GamePluginView$getLifeHandlers$1> getLifeHandlers() {
        return CollectionsKt.listOf(new GamePluginView$getLifeHandlers$1(this));
    }

    /* access modifiers changed from: private */
    public final void loadJs() {
        String loadAssetsString = AssetsFileUtils.loadAssetsString(getContext(), "gameInsert.js");
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.loadUrl(Intrinsics.stringPlus("javascript:", loadAssetsString));
        }
        XesLog.i(TAG, "游戏js注入");
    }

    public final void showCoinsView(String str) {
        WebAgent webAgent;
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && (webAgent = this.mWebAgent) != null) {
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            webAgent.jsCallBack("window.clientMessageHandlers", GsonUtils.toJson(new GameJsBean("showCoin", new GameJsDataBean(str, EncodeUtils.urlEncode(userInfoEntity == null ? null : userInfoEntity.getNickName())))));
        }
    }

    public final void drawResultView(AnswerBean answerBean) {
        Intrinsics.checkNotNullParameter(answerBean, "answerBean");
        Integer num = this.isRight;
        if (num != null) {
            int intValue = num.intValue();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setWindow(ResultFactory.createWindow(intValue, context, answerBean, this));
            if (getWindow() != null) {
                addView((View) getWindow(), new FrameLayout.LayoutParams(-1, -1));
                SubmitResultView window2 = getWindow();
                if (window2 != null) {
                    SubmitResultView.show$default(window2, (Function0) null, 1, (Object) null);
                }
                if (getCloseHandler() == null) {
                    GamePluginView gamePluginView = this;
                    setCloseHandler(new Handler(Looper.getMainLooper()));
                }
                if (getRunnable() == null) {
                    GamePluginView gamePluginView2 = this;
                    setRunnable(new GamePluginView$$ExternalSyntheticLambda6(this));
                }
                Handler closeHandler2 = getCloseHandler();
                if (closeHandler2 != null) {
                    Runnable runnable2 = getRunnable();
                    Intrinsics.checkNotNull(runnable2);
                    closeHandler2.postDelayed(runnable2, 5000);
                    return;
                }
                return;
            }
            close();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawResultView$lambda-15$lambda-14$lambda-13  reason: not valid java name */
    public static final void m297drawResultView$lambda15$lambda14$lambda13(GamePluginView gamePluginView) {
        Intrinsics.checkNotNullParameter(gamePluginView, "this$0");
        gamePluginView.close();
    }

    public void close() {
        Handler handler = this.closeHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        removeView((View) this.window);
    }

    public final void onDestroy() {
        LiveAreaContext.get().layoutObserver.removeObserver(this.mLayoutObserver);
        this.mHandler.removeCallbacksAndMessages((Object) null);
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = null;
        BaseDialog baseDialog = this.mQuitOutDialog;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
        this.mQuitOutDialog = null;
        BaseDialog baseDialog2 = this.mErrorDialog;
        if (baseDialog2 != null) {
            baseDialog2.dismiss();
        }
        this.mErrorDialog = null;
    }
}
