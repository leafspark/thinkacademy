package com.tal.app.thinkacademy.live.business.schulte;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.schulte.SchulteTableViewModel;
import com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep;
import com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PluginAnnotation(desc = "舒尔特方格游戏插件", ircType = {"schulte_table"}, launchType = "delay", moduleId = "3013")
@ViewLevels({@ViewLevel(level = 30, name = "SchulteTableGamePluginView")})
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u001c\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/SchulteTablePluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mContext", "Landroid/content/Context;", "mPlanId", "", "Ljava/lang/Integer;", "mPluginView", "Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTablePluginView;", "mStep", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStep;", "mSubmitTimes", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/SchulteTableViewModel;", "loadBaseView", "", "observeListener", "onDestroy", "onMessage", "ircTypeKey", "", "message", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTablePluginDriver.kt */
public final class SchulteTablePluginDriver extends BaseLivePluginDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUB_TAG = "插件";
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.SCHULTE_TABLE;
    public static final String TARGET = "SchulteTablePluginDriver.Observer";
    private Context mContext;
    /* access modifiers changed from: private */
    public Integer mPlanId;
    private SchulteTablePluginView mPluginView;
    private SchulteTableStep mStep = SchulteTableStep.UNLOAD;
    /* access modifiers changed from: private */
    public int mSubmitTimes = 1;
    /* access modifiers changed from: private */
    public SchulteTableViewModel mViewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SchulteTablePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        CourseInfoProxy courseInfo;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        XesLog.i(TAG, SUB_TAG, "舒特尔方格插件激活");
        this.mContext = (Context) this.mLiveRoomProvider.getWeakRefContext().get();
        this.mViewModel = AbilityPackKt.getAbilityPack().getViewModel(SchulteTableViewModel.class);
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        Integer num = null;
        if (!(dataStorage == null || (courseInfo = dataStorage.getCourseInfo()) == null)) {
            num = Integer.valueOf(courseInfo.getPlanId());
        }
        this.mPlanId = num;
        this.mStep = SchulteTableStep.UNLOAD;
        observeListener();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/SchulteTablePluginDriver$Companion;", "", "()V", "SUB_TAG", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTablePluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void loadBaseView() {
        Context context = this.mContext;
        if (context != null && this.mPluginView == null) {
            XesLog.i(TAG, SUB_TAG, "加载插件根视图");
            this.mPluginView = new SchulteTablePluginView(context);
            FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new SchulteTablePluginDriver$$ExternalSyntheticLambda1(this, newLp));
            SchulteTablePluginView schulteTablePluginView = this.mPluginView;
            if (schulteTablePluginView != null) {
                schulteTablePluginView.refreshLayout(newLp.height);
            }
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mPluginView, "SchulteTableGamePluginView", newLp);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadBaseView$lambda-1$lambda-0  reason: not valid java name */
    public static final void m421loadBaseView$lambda1$lambda0(SchulteTablePluginDriver schulteTablePluginDriver, FrameLayout.LayoutParams layoutParams, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(schulteTablePluginDriver, "this$0");
        Intrinsics.checkNotNullParameter(liveAreaContext, "liveAreaContext");
        SchulteTablePluginView schulteTablePluginView = schulteTablePluginDriver.mPluginView;
        ViewGroup.LayoutParams layoutParams2 = schulteTablePluginView == null ? null : schulteTablePluginView.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        liveAreaContext.getPptLp().mergeLp(layoutParams3);
        SchulteTablePluginView schulteTablePluginView2 = schulteTablePluginDriver.mPluginView;
        if (schulteTablePluginView2 != null) {
            schulteTablePluginView2.setLayoutParams(layoutParams3);
        }
        SchulteTablePluginView schulteTablePluginView3 = schulteTablePluginDriver.mPluginView;
        if (schulteTablePluginView3 != null) {
            schulteTablePluginView3.refreshLayout(layoutParams.height);
        }
    }

    private final void observeListener() {
        ListenerData<SchulteTableListenerBody> mListenerBody;
        SchulteTableViewModel schulteTableViewModel = this.mViewModel;
        if (schulteTableViewModel != null && (mListenerBody = schulteTableViewModel.getMListenerBody()) != null) {
            mListenerBody.observeForever((LifecycleOwner) this, false, new SchulteTablePluginDriver$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0076, code lost:
        r6 = kotlin.text.StringsKt.toIntOrNull(r6);
     */
    /* renamed from: observeListener$lambda-8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m422observeListener$lambda8(com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver r11, com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody r12) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.Load
            java.lang.String r1 = "插件"
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0031
            com.tal.app.thinkacademy.live.Tag r0 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r1
            java.lang.String r1 = "准备加载插件视图"
            r2[r3] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            r11.loadBaseView()
            com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView r11 = r11.mPluginView
            if (r11 != 0) goto L_0x0026
            goto L_0x024e
        L_0x0026:
            com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody$Load r12 = (com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.Load) r12
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStartBean r12 = r12.getGameBean()
            r11.setBaseView(r12)
            goto L_0x024e
        L_0x0031:
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.GameStart
            r5 = 3
            java.lang.String r6 = "互动已经开始，当前环节是："
            r7 = 0
            if (r0 == 0) goto L_0x00d5
            com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody$GameStart r12 = (com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.GameStart) r12
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStartBean r12 = r12.getGameBean()
            com.tal.app.thinkacademy.live.Tag r0 = TAG
            r8 = r0
            com.tal.app.thinkacademy.lib.logger.XesLogTag r8 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r8
            java.lang.Object[] r9 = new java.lang.Object[r2]
            r9[r4] = r1
            java.lang.String r10 = "准备加载游戏，参数是 "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r12)
            r9[r3] = r10
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r8, r9)
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r8 = r11.mStep
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r9 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.UNLOAD
            if (r8 == r9) goto L_0x006b
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r12[r4] = r1
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r11 = r11.mStep
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r11)
            r12[r3] = r11
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r12)
            return
        L_0x006b:
            if (r12 != 0) goto L_0x006e
            goto L_0x00c4
        L_0x006e:
            java.lang.String r6 = r12.getLevel()
            if (r6 != 0) goto L_0x0076
        L_0x0074:
            r6 = r4
            goto L_0x0081
        L_0x0076:
            java.lang.Integer r6 = kotlin.text.StringsKt.toIntOrNull(r6)
            if (r6 != 0) goto L_0x007d
            goto L_0x0074
        L_0x007d:
            int r6 = r6.intValue()
        L_0x0081:
            java.lang.Boolean r8 = r12.getRandom()
            if (r8 != 0) goto L_0x0089
            r8 = r4
            goto L_0x008d
        L_0x0089:
            boolean r8 = r8.booleanValue()
        L_0x008d:
            if (r5 > r6) goto L_0x0094
            r5 = 6
            if (r6 >= r5) goto L_0x0094
            r5 = r3
            goto L_0x0095
        L_0x0094:
            r5 = r4
        L_0x0095:
            if (r5 == 0) goto L_0x00b3
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r5 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.PLAYING
            r11.mStep = r5
            r11.mSubmitTimes = r3
            com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView r5 = r11.mPluginView
            if (r5 != 0) goto L_0x00a2
            goto L_0x00c4
        L_0x00a2:
            java.lang.String r7 = r12.getCategory()
            com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver$observeListener$1$1$1 r9 = new com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver$observeListener$1$1$1
            r9.<init>(r11, r12)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r5.loadGameView(r6, r7, r8, r9)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            goto L_0x00c3
        L_0x00b3:
            r11 = r0
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r12[r4] = r1
            java.lang.String r5 = "加载游戏视图异常，level不合法，必须为3，4，5"
            r12[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r11, r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
        L_0x00c3:
            r7 = r11
        L_0x00c4:
            if (r7 != 0) goto L_0x024e
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r11 = new java.lang.Object[r2]
            r11[r4] = r1
            java.lang.String r12 = "准备调起游戏视图，但数据为空"
            r11[r3] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r11)
            goto L_0x024e
        L_0x00d5:
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.GameSubmitError
            if (r0 == 0) goto L_0x0154
            com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody$GameSubmitError r12 = (com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.GameSubmitError) r12
            java.lang.String r0 = r12.getInteractId()
            float r12 = r12.getDuration()
            com.tal.app.thinkacademy.live.Tag r1 = TAG
            r2 = r1
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r2
            java.lang.Object[] r6 = new java.lang.Object[r3]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "游戏结果提交异常 互动id:"
            r7.append(r8)
            r7.append(r0)
            java.lang.String r8 = "，成绩:"
            r7.append(r8)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            r6[r4] = r7
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r2, r6)
            com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView r2 = r11.mPluginView
            if (r2 != 0) goto L_0x010d
            return
        L_0x010d:
            com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver$observeListener$1$submit$1 r2 = new com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver$observeListener$1$submit$1
            r2.<init>(r11, r0, r12)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            int r6 = r11.mSubmitTimes
            if (r6 < r5) goto L_0x014d
            com.tal.app.thinkacademy.lib.logger.XesLogTag r1 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "自动提交游戏结果重试次数已达上限，弹窗提示用户提交失败-> 重试次数:"
            r5.append(r6)
            int r6 = r11.mSubmitTimes
            r5.append(r6)
            java.lang.String r6 = "，互动id:"
            r5.append(r6)
            r5.append(r0)
            r5.append(r8)
            r5.append(r12)
            java.lang.String r12 = r5.toString()
            r3[r4] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.a(r1, r3)
            com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView r11 = r11.mPluginView
            if (r11 != 0) goto L_0x0148
            goto L_0x024e
        L_0x0148:
            r11.showSubmitError(r2)
            goto L_0x024e
        L_0x014d:
            java.lang.String r11 = "自动"
            r2.invoke(r11)
            goto L_0x024e
        L_0x0154:
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.GameOver
            if (r0 == 0) goto L_0x01bb
            com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody$GameOver r12 = (com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.GameOver) r12
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean r12 = r12.getResultBean()
            com.tal.app.thinkacademy.live.Tag r0 = TAG
            r5 = r0
            com.tal.app.thinkacademy.lib.logger.XesLogTag r5 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r5
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r4] = r1
            java.lang.String r9 = "准备加载结果页，参数是 "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r12)
            r8[r3] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r5, r8)
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r5 = r11.mStep
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r8 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.UNLOAD
            if (r5 == r8) goto L_0x0190
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r5 = r11.mStep
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r8 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.PLAYING
            if (r5 == r8) goto L_0x0190
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r12[r4] = r1
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r11 = r11.mStep
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r11)
            r12[r3] = r11
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r12)
            return
        L_0x0190:
            com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView r5 = r11.mPluginView
            if (r5 != 0) goto L_0x0195
            goto L_0x0198
        L_0x0195:
            r5.hideSubmitError()
        L_0x0198:
            if (r12 != 0) goto L_0x019b
            goto L_0x01aa
        L_0x019b:
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r5 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.RESULT
            r11.mStep = r5
            com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView r11 = r11.mPluginView
            if (r11 != 0) goto L_0x01a4
            goto L_0x01aa
        L_0x01a4:
            r11.loadResultView(r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            r7 = r11
        L_0x01aa:
            if (r7 != 0) goto L_0x024e
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r11 = new java.lang.Object[r2]
            r11[r4] = r1
            java.lang.String r12 = "准备调起载结果展示视图，但数据为空"
            r11[r3] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r11)
            goto L_0x024e
        L_0x01bb:
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.RankList
            if (r0 == 0) goto L_0x0234
            com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody$RankList r12 = (com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.RankList) r12
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableShowRankListBean r12 = r12.getRankListBean()
            com.tal.app.thinkacademy.live.Tag r0 = TAG
            r5 = r0
            com.tal.app.thinkacademy.lib.logger.XesLogTag r5 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r5
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r4] = r1
            java.lang.String r9 = "准备加载排行榜，参数是 "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r12)
            r8[r3] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r5, r8)
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r5 = r11.mStep
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r8 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.RANK
            if (r5 != r8) goto L_0x01f1
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r12[r4] = r1
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r11 = r11.mStep
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r11)
            r12[r3] = r11
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r12)
            return
        L_0x01f1:
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r5 = r11.mStep
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r6 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.PLAYING
            if (r5 != r6) goto L_0x020a
            r5 = r0
            com.tal.app.thinkacademy.lib.logger.XesLogTag r5 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r5
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r4] = r1
            java.lang.String r8 = "当前在游戏中，收到排行榜信令，即将关闭游戏页面"
            r6[r3] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r5, r6)
            int r5 = com.tal.app.thinkacademy.live.business.R.string.schulte_table_time_is_up
            com.tal.app.thinkacademy.lib.util.ToastUtils.showShort((int) r5)
        L_0x020a:
            com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView r5 = r11.mPluginView
            if (r5 != 0) goto L_0x020f
            goto L_0x0212
        L_0x020f:
            r5.hideSubmitError()
        L_0x0212:
            if (r12 != 0) goto L_0x0215
            goto L_0x0224
        L_0x0215:
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r5 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.RANK
            r11.mStep = r5
            com.tal.app.thinkacademy.live.business.schulte.view.SchulteTablePluginView r11 = r11.mPluginView
            if (r11 != 0) goto L_0x021e
            goto L_0x0224
        L_0x021e:
            r11.loadRankView(r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            r7 = r11
        L_0x0224:
            if (r7 != 0) goto L_0x024e
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r11 = new java.lang.Object[r2]
            r11[r4] = r1
            java.lang.String r12 = "准备调起排行榜，但数据为空"
            r11[r3] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r11)
            goto L_0x024e
        L_0x0234:
            boolean r12 = r12 instanceof com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody.UnLoad
            if (r12 == 0) goto L_0x024e
            com.tal.app.thinkacademy.live.Tag r12 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r12 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r12
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r4] = r1
            java.lang.String r1 = "准备关闭互动"
            r0[r3] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r12, r0)
            com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep r12 = com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStep.UNLOAD
            r11.mStep = r12
            r11.onDestroy()
        L_0x024e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver.m422observeListener$lambda8(com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver, com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody):void");
    }

    public void onMessage(String str, String str2) {
        SchulteTableViewModel schulteTableViewModel;
        if (Intrinsics.areEqual(str, "schulte_table") && (schulteTableViewModel = this.mViewModel) != null) {
            schulteTableViewModel.onReceiveMessage(str2);
        }
    }

    public void onDestroy() {
        XesLog.i(TAG, SUB_TAG, "舒特尔方格插件销毁");
        LiveAreaContext.get().layoutObserver.removeObservers((LifecycleOwner) this);
        SchulteTablePluginView schulteTablePluginView = this.mPluginView;
        if (schulteTablePluginView != null) {
            schulteTablePluginView.destroyView();
            this.mLiveRoomProvider.removeView((View) schulteTablePluginView);
        }
        this.mPluginView = null;
        this.mSubmitTimes = 1;
    }
}
