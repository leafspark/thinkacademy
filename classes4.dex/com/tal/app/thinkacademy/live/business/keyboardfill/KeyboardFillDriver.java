package com.tal.app.thinkacademy.live.business.keyboardfill;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModel;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.listenbody.KeyboardFillListenerBody;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.keyboardfill.view.KeyboardFillCoinToast;
import com.tal.app.thinkacademy.live.business.keyboardfill.view.KeyboardFillResultToast;
import com.tal.app.thinkacademy.live.business.keyboardfill.view.KeyboardFillView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PluginAnnotation(classType = 1, desc = "填一填", ircType = {"nonpreset_fill_blank", "fill_blank_mark_correct"}, launchType = "delay", moduleId = "254")
@ViewLevels({@ViewLevel(level = 10, name = "keyboardFill")})
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0016J\u001c\u0010-\u001a\u00020\"2\b\u0010.\u001a\u0004\u0018\u00010\u00152\b\u0010/\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\b\u00101\u001a\u00020\"H\u0002J\u0018\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bH\u0002J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\bH\u0002J\u0018\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/KeyboardFillDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mClassId", "", "mCoinResultToast", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/view/KeyboardFillCoinToast;", "mContext", "Landroid/content/Context;", "mDestroyRunnable", "Ljava/lang/Runnable;", "mGotCoins", "", "mHandler", "Landroid/os/Handler;", "mHideKeyboardRunnable", "mInteractId", "", "mKeyboardFillViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/KeyboardFillViewModel;", "mKeyboardView", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/view/KeyboardFillView;", "mLayoutObserver", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaContext;", "mPlanId", "mSubmit", "mToastView", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/view/KeyboardFillResultToast;", "checkResult", "", "commitResult", "content", "scene", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/CommitScene;", "hideKeyboard", "delayMillis", "", "initAndLoadView", "initObserver", "onDestroy", "onMessage", "ircTypeKey", "message", "removePlugin", "removeView", "showCoinsToast", "addCoin", "userTotalGold", "showToastView", "resId", "updateUserCoins", "userCoins", "addCoins", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillDriver.kt */
public final class KeyboardFillDriver extends BaseLivePluginDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long SHOW_TIME = 4000;
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.KEYBOARD_FILL;
    private static final String TARGET = "KeyboardFillDriver.Observer";
    /* access modifiers changed from: private */
    public int mClassId = this.mLiveRoomProvider.getDataStorage().getCourseInfo().getClassId();
    private KeyboardFillCoinToast mCoinResultToast;
    private Context mContext = ((Context) this.mLiveRoomProvider.getWeakRefContext().get());
    private Runnable mDestroyRunnable;
    /* access modifiers changed from: private */
    public boolean mGotCoins;
    private Handler mHandler;
    private Runnable mHideKeyboardRunnable;
    /* access modifiers changed from: private */
    public String mInteractId;
    /* access modifiers changed from: private */
    public KeyboardFillViewModel mKeyboardFillViewModel;
    /* access modifiers changed from: private */
    public KeyboardFillView mKeyboardView;
    private final Observer<LiveAreaContext> mLayoutObserver = new KeyboardFillDriver$$ExternalSyntheticLambda0(this);
    /* access modifiers changed from: private */
    public int mPlanId = ParseUtils.tryParseInt(this.mLiveRoomProvider.getDataStorage().getPlanInfo().getId(), 0);
    /* access modifiers changed from: private */
    public boolean mSubmit;
    private KeyboardFillResultToast mToastView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KeyboardFillDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        XesLog.i(TAG, "插件初始化");
        this.mKeyboardFillViewModel = KeyboardFillViewModelKt.getKeyboardFillViewModel(AbilityPackKt.getAbilityPack());
        initObserver();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/KeyboardFillDriver$Companion;", "", "()V", "SHOW_TIME", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KeyboardFillDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mLayoutObserver$lambda-1  reason: not valid java name */
    public static final void m304mLayoutObserver$lambda1(KeyboardFillDriver keyboardFillDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(keyboardFillDriver, "this$0");
        XesLog.a(TAG, "区域变化，重新计算");
        KeyboardFillView keyboardFillView = keyboardFillDriver.mKeyboardView;
        FrameLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = keyboardFillView == null ? null : keyboardFillView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        }
        if (layoutParams != null) {
            LiveAreaLayoutParams pptLp = liveAreaContext.getPptLp();
            if (pptLp != null) {
                pptLp.mergeLp(layoutParams);
            }
            KeyboardFillView keyboardFillView2 = keyboardFillDriver.mKeyboardView;
            if (keyboardFillView2 != null) {
                keyboardFillView2.setLayoutParams(layoutParams);
            }
            KeyboardFillView keyboardFillView3 = keyboardFillDriver.mKeyboardView;
            if (keyboardFillView3 != null) {
                keyboardFillView3.refreshLayout(layoutParams.height);
            }
        }
    }

    private final void initObserver() {
        ListenerData<KeyboardFillListenerBody> mListenerData;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveAreaContext.get().layoutObserver.observe(lifecycleOwner, this.mLayoutObserver);
        KeyboardFillViewModel keyboardFillViewModel = this.mKeyboardFillViewModel;
        if (keyboardFillViewModel != null && (mListenerData = keyboardFillViewModel.getMListenerData()) != null) {
            mListenerData.observeListener(lifecycleOwner, false, TARGET, new KeyboardFillDriver$initObserver$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void showCoinsToast(int i, int i2) {
        KeyboardFillView keyboardFillView = this.mKeyboardView;
        if (keyboardFillView != null) {
            keyboardFillView.showSubmitResultView(i, i2);
        }
    }

    /* access modifiers changed from: private */
    public final void showToastView(int i) {
        Context context;
        if (this.mToastView == null && (context = this.mContext) != null) {
            this.mToastView = new KeyboardFillResultToast(context);
        }
        KeyboardFillResultToast keyboardFillResultToast = this.mToastView;
        if (keyboardFillResultToast != null) {
            keyboardFillResultToast.setText(i);
        }
        KeyboardFillResultToast keyboardFillResultToast2 = this.mToastView;
        if (keyboardFillResultToast2 != null) {
            keyboardFillResultToast2.showToast();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d9 A[Catch:{ Exception -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00da A[Catch:{ Exception -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0164 A[Catch:{ Exception -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0165 A[Catch:{ Exception -> 0x01b0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "nonpreset_fill_blank"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x01c3
            r9 = r10
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0018
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r9 = r2
            goto L_0x0019
        L_0x0018:
            r9 = r3
        L_0x0019:
            if (r9 == 0) goto L_0x0029
            com.tal.app.thinkacademy.live.Tag r9 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r9
            java.lang.Object[] r10 = new java.lang.Object[r3]
            java.lang.String r0 = "信令消息为空"
            r10[r2] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r9, r10)
            return
        L_0x0029:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x01b0 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01b0 }
            org.json.JSONObject r9 = r9.optJSONObject(r0)     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x0036
            goto L_0x020b
        L_0x0036:
            java.lang.String r10 = "pub"
            boolean r10 = r9.optBoolean(r10)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = "数据提交中 ："
            r1 = 0
            java.lang.String r4 = "interactId"
            if (r10 == 0) goto L_0x0130
            java.lang.String r10 = r8.mInteractId     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r4 = r9.optString(r4)     // Catch:{ Exception -> 0x01b0 }
            r8.mInteractId = r4     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r4 = "isStop"
            boolean r9 = r9.optBoolean(r4)     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x009c
            java.lang.String r9 = r8.mInteractId     // Catch:{ Exception -> 0x01b0 }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r9)     // Catch:{ Exception -> 0x01b0 }
            if (r9 == 0) goto L_0x0070
            com.tal.app.thinkacademy.live.Tag r9 = TAG     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r9     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = "互动重复开启，不处理 interactId:"
            java.lang.String r1 = r8.mInteractId     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)     // Catch:{ Exception -> 0x01b0 }
            r10[r2] = r0     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r9, r10)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x020b
        L_0x0070:
            com.tal.app.thinkacademy.live.Tag r9 = TAG     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r9     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = "开启互动 interactId:"
            java.lang.String r1 = r8.mInteractId     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)     // Catch:{ Exception -> 0x01b0 }
            r10[r2] = r0     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r9, r10)     // Catch:{ Exception -> 0x01b0 }
            r8.checkResult()     // Catch:{ Exception -> 0x01b0 }
            r8.initAndLoadView()     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModel r9 = r8.mKeyboardFillViewModel     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x008f
            goto L_0x020b
        L_0x008f:
            int r10 = r8.mPlanId     // Catch:{ Exception -> 0x01b0 }
            int r0 = r8.mClassId     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r1 = r8.mInteractId     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene r4 = com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene.FirstLoad     // Catch:{ Exception -> 0x01b0 }
            r9.check(r10, r0, r1, r4)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x020b
        L_0x009c:
            com.tal.app.thinkacademy.live.Tag r9 = TAG     // Catch:{ Exception -> 0x01b0 }
            r10 = r9
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r5 = "停止作答 interactId:"
            java.lang.String r6 = r8.mInteractId     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r6)     // Catch:{ Exception -> 0x01b0 }
            r4[r2] = r5     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r4)     // Catch:{ Exception -> 0x01b0 }
            r8.initAndLoadView()     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.live.business.keyboardfill.view.KeyboardFillView r10 = r8.mKeyboardView     // Catch:{ Exception -> 0x01b0 }
            if (r10 != 0) goto L_0x00b8
            goto L_0x00bb
        L_0x00b8:
            r10.hide()     // Catch:{ Exception -> 0x01b0 }
        L_0x00bb:
            com.tal.app.thinkacademy.live.business.keyboardfill.view.KeyboardFillView r10 = r8.mKeyboardView     // Catch:{ Exception -> 0x01b0 }
            if (r10 != 0) goto L_0x00c0
            goto L_0x00c4
        L_0x00c0:
            java.lang.String r1 = r10.getContent()     // Catch:{ Exception -> 0x01b0 }
        L_0x00c4:
            boolean r10 = r8.mSubmit     // Catch:{ Exception -> 0x01b0 }
            if (r10 != 0) goto L_0x010e
            r10 = r1
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x01b0 }
            if (r10 == 0) goto L_0x00d6
            int r10 = r10.length()     // Catch:{ Exception -> 0x01b0 }
            if (r10 != 0) goto L_0x00d4
            goto L_0x00d6
        L_0x00d4:
            r10 = r2
            goto L_0x00d7
        L_0x00d6:
            r10 = r3
        L_0x00d7:
            if (r10 == 0) goto L_0x00da
            goto L_0x010e
        L_0x00da:
            r10 = r9
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r5 = "停止作答 自动提交 "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r1)     // Catch:{ Exception -> 0x01b0 }
            r4[r2] = r5     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r4)     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModel r10 = r8.mKeyboardFillViewModel     // Catch:{ Exception -> 0x01b0 }
            if (r10 != 0) goto L_0x00f0
        L_0x00ee:
            r10 = r2
            goto L_0x00f7
        L_0x00f0:
            boolean r10 = r10.isSubmitPosting()     // Catch:{ Exception -> 0x01b0 }
            if (r10 != r3) goto L_0x00ee
            r10 = r3
        L_0x00f7:
            if (r10 == 0) goto L_0x0107
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r9     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)     // Catch:{ Exception -> 0x01b0 }
            r10[r2] = r0     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.a(r9, r10)     // Catch:{ Exception -> 0x01b0 }
            return
        L_0x0107:
            com.tal.app.thinkacademy.live.business.keyboardfill.CommitScene r9 = com.tal.app.thinkacademy.live.business.keyboardfill.CommitScene.StopCommit     // Catch:{ Exception -> 0x01b0 }
            r8.commitResult(r1, r9)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x020b
        L_0x010e:
            boolean r10 = r8.mGotCoins     // Catch:{ Exception -> 0x01b0 }
            if (r10 != 0) goto L_0x020b
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r9     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = "停止作答 课件恢复，check接口"
            r10[r2] = r0     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r9, r10)     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModel r9 = r8.mKeyboardFillViewModel     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x0123
            goto L_0x020b
        L_0x0123:
            int r10 = r8.mPlanId     // Catch:{ Exception -> 0x01b0 }
            int r0 = r8.mClassId     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r1 = r8.mInteractId     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene r4 = com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene.StopCommit     // Catch:{ Exception -> 0x01b0 }
            r9.check(r10, r0, r1, r4)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x020b
        L_0x0130:
            com.tal.app.thinkacademy.live.Tag r10 = TAG     // Catch:{ Exception -> 0x01b0 }
            r5 = r10
            com.tal.app.thinkacademy.lib.logger.XesLogTag r5 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r5     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r7 = "结束互动 interactId:"
            java.lang.String r9 = r9.optString(r4)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r9)     // Catch:{ Exception -> 0x01b0 }
            r6[r2] = r9     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r5, r6)     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.live.business.keyboardfill.view.KeyboardFillView r9 = r8.mKeyboardView     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x014b
            goto L_0x014f
        L_0x014b:
            java.lang.String r1 = r9.getContent()     // Catch:{ Exception -> 0x01b0 }
        L_0x014f:
            boolean r9 = r8.mSubmit     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x01a0
            r9 = r1
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x01b0 }
            if (r9 == 0) goto L_0x0161
            int r9 = r9.length()     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x015f
            goto L_0x0161
        L_0x015f:
            r9 = r2
            goto L_0x0162
        L_0x0161:
            r9 = r3
        L_0x0162:
            if (r9 == 0) goto L_0x0165
            goto L_0x01a0
        L_0x0165:
            r9 = r10
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r9     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r5 = "自动提交答案："
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r1)     // Catch:{ Exception -> 0x01b0 }
            r4[r2] = r5     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r9, r4)     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.live.business.keyboardfill.view.KeyboardFillView r9 = r8.mKeyboardView     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x017a
            goto L_0x017d
        L_0x017a:
            r9.hide()     // Catch:{ Exception -> 0x01b0 }
        L_0x017d:
            com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModel r9 = r8.mKeyboardFillViewModel     // Catch:{ Exception -> 0x01b0 }
            if (r9 != 0) goto L_0x0183
        L_0x0181:
            r9 = r2
            goto L_0x018a
        L_0x0183:
            boolean r9 = r9.isSubmitPosting()     // Catch:{ Exception -> 0x01b0 }
            if (r9 != r3) goto L_0x0181
            r9 = r3
        L_0x018a:
            if (r9 == 0) goto L_0x019a
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)     // Catch:{ Exception -> 0x01b0 }
            r9[r2] = r0     // Catch:{ Exception -> 0x01b0 }
            com.tal.app.thinkacademy.lib.logger.XesLog.a(r10, r9)     // Catch:{ Exception -> 0x01b0 }
            return
        L_0x019a:
            com.tal.app.thinkacademy.live.business.keyboardfill.CommitScene r9 = com.tal.app.thinkacademy.live.business.keyboardfill.CommitScene.CloseCommit     // Catch:{ Exception -> 0x01b0 }
            r8.commitResult(r1, r9)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x020b
        L_0x01a0:
            boolean r9 = r8.mGotCoins     // Catch:{ Exception -> 0x01b0 }
            if (r9 == 0) goto L_0x01aa
            r9 = 4000(0xfa0, double:1.9763E-320)
            r8.removePlugin(r9)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x020b
        L_0x01aa:
            r9 = 0
            r8.removePlugin(r9)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x020b
        L_0x01b0:
            r9 = move-exception
            com.tal.app.thinkacademy.live.Tag r10 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "信令处理错误："
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r9)
            r0[r2] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r10, r0)
            goto L_0x020b
        L_0x01c3:
            java.lang.String r10 = "fill_blank_mark_correct"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r9 == 0) goto L_0x020b
            com.tal.app.thinkacademy.live.Tag r9 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r9
            java.lang.Object[] r10 = new java.lang.Object[r3]
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "教师标记正确信令 submit="
            r0.append(r1)
            boolean r1 = r8.mSubmit
            r0.append(r1)
            java.lang.String r1 = " gotCoins="
            r0.append(r1)
            boolean r1 = r8.mGotCoins
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10[r2] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r9, r10)
            boolean r9 = r8.mSubmit
            if (r9 == 0) goto L_0x020b
            boolean r9 = r8.mGotCoins
            if (r9 != 0) goto L_0x020b
            com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModel r9 = r8.mKeyboardFillViewModel
            if (r9 != 0) goto L_0x0200
            goto L_0x020b
        L_0x0200:
            int r10 = r8.mPlanId
            int r0 = r8.mClassId
            java.lang.String r1 = r8.mInteractId
            com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene r2 = com.tal.app.thinkacademy.live.business.keyboardfill.CheckScene.MarkCorrectly
            r9.check(r10, r0, r1, r2)
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.keyboardfill.KeyboardFillDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    private final void checkResult() {
        Handler handler;
        if (!(this.mDestroyRunnable == null || (handler = this.mHandler) == null)) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mDestroyRunnable = null;
        this.mHideKeyboardRunnable = null;
        this.mSubmit = false;
        this.mGotCoins = false;
        removeView();
    }

    private final void initAndLoadView() {
        Context context;
        if (this.mKeyboardView == null && (context = this.mContext) != null) {
            XesLog.i(TAG, "初始化视图");
            BaseLivePluginView keyboardFillView = new KeyboardFillView(context);
            this.mKeyboardView = keyboardFillView;
            keyboardFillView.onSubmitCallback(new KeyboardFillDriver$initAndLoadView$2$1(this));
            FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, keyboardFillView, "keyboardFill", newLp);
            keyboardFillView.refreshLayout(newLp.height);
        }
    }

    /* access modifiers changed from: private */
    public final void commitResult(String str, CommitScene commitScene) {
        HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
        String str2 = this.mInteractId;
        if (str2 == null) {
            str2 = "";
        }
        hWEventTracking.ostaIaVoteSubmit(str2, "fill_blank", str, (Boolean) null);
        KeyboardFillViewModel keyboardFillViewModel = this.mKeyboardFillViewModel;
        if (keyboardFillViewModel != null) {
            keyboardFillViewModel.commit(this.mPlanId, this.mClassId, this.mInteractId, str, commitScene);
        }
    }

    /* access modifiers changed from: private */
    public final void removePlugin(long j) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mDestroyRunnable == null) {
            this.mDestroyRunnable = new KeyboardFillDriver$$ExternalSyntheticLambda2(this);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            Runnable runnable = this.mDestroyRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: removePlugin$lambda-7  reason: not valid java name */
    public static final void m305removePlugin$lambda7(KeyboardFillDriver keyboardFillDriver) {
        Intrinsics.checkNotNullParameter(keyboardFillDriver, "this$0");
        keyboardFillDriver.removeView();
        keyboardFillDriver.destroy();
    }

    /* access modifiers changed from: private */
    public final void hideKeyboard(long j) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mHideKeyboardRunnable == null) {
            this.mHideKeyboardRunnable = new KeyboardFillDriver$$ExternalSyntheticLambda1(this);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            Runnable runnable = this.mHideKeyboardRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hideKeyboard$lambda-8  reason: not valid java name */
    public static final void m303hideKeyboard$lambda8(KeyboardFillDriver keyboardFillDriver) {
        Intrinsics.checkNotNullParameter(keyboardFillDriver, "this$0");
        KeyboardFillView keyboardFillView = keyboardFillDriver.mKeyboardView;
        if (keyboardFillView != null) {
            keyboardFillView.hide();
        }
    }

    private final void updateUserCoins(int i, int i2) {
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(KeyboardFillDriver.class, DataBusKey.USERCOINS_KEY, String.valueOf(i), new CoinEventData(GoldSource.KEYBOARD_FILL_RAIN, i2, false, false, 12, (DefaultConstructorMarker) null)));
    }

    private final void removeView() {
        KeyboardFillView keyboardFillView = this.mKeyboardView;
        if (keyboardFillView != null) {
            XesLog.i(TAG, "移除键盘视图");
            this.mLiveRoomProvider.removeView((View) keyboardFillView);
            keyboardFillView.destroy();
        }
        this.mKeyboardView = null;
    }

    public void onDestroy() {
        ListenerData<KeyboardFillListenerBody> mListenerData;
        XesLog.i(TAG, "插件销毁");
        LiveAreaContext.get().layoutObserver.removeObserver(this.mLayoutObserver);
        KeyboardFillView keyboardFillView = this.mKeyboardView;
        if (keyboardFillView != null) {
            keyboardFillView.destroy();
        }
        this.mToastView = null;
        this.mCoinResultToast = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
        this.mDestroyRunnable = null;
        this.mHideKeyboardRunnable = null;
        KeyboardFillViewModel keyboardFillViewModel = this.mKeyboardFillViewModel;
        if (!(keyboardFillViewModel == null || (mListenerData = keyboardFillViewModel.getMListenerData()) == null)) {
            mListenerData.removeListener(TARGET);
        }
        this.mKeyboardFillViewModel = null;
    }
}
