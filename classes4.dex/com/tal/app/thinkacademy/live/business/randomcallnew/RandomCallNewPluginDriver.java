package com.tal.app.thinkacademy.live.business.randomcallnew;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.RandomCallViewModel;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.listenbody.RandomCallListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.listener.RandomCallLotteryListener;
import com.tal.app.thinkacademy.live.business.randomcallnew.listener.RandomCallPhotoWallListener;
import com.tal.app.thinkacademy.live.business.randomcallnew.view.BaseRandomCallPhotoWallPluginView;
import com.tal.app.thinkacademy.live.business.randomcallnew.view.RandomCallLotteryPluginView;
import com.tal.app.thinkacademy.live.business.randomcallnew.view.RandomCallPhotoWallPluginViewPad;
import com.tal.app.thinkacademy.live.business.randomcallnew.view.RandomCallPhotoWallPluginViewPhone;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PluginAnnotation(classType = 1, desc = "随机点名插件", ircType = {"small_random_call"}, moduleId = "3010")
@ViewLevels({@ViewLevel(level = 41, name = "RandomCallLotteryPluginView"), @ViewLevel(level = 41, name = "RandomCallPhotoWallPluginView")})
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001*B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J2\u0010\u001a\u001a\u00020\u00162\u001e\u0010\u001b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u0001`\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0002J2\u0010 \u001a\u00020\u00162\u001e\u0010\u001b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u0001`\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\u001c\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\u00122\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010)\u001a\u00020\u0016H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/RandomCallNewPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/listener/RandomCallPhotoWallListener;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/listener/RandomCallLotteryListener;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mContext", "Landroid/content/Context;", "mLotteryPluginView", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/RandomCallLotteryPluginView;", "mPhotoWallPluginView", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/BaseRandomCallPhotoWallPluginView;", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mUserId", "", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/RandomCallViewModel;", "destroyLotteryPluginView", "", "destroyRandomCallPhotoWallView", "isStopSelectedStudent", "", "loadLotteryPluginView", "students", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;", "Lkotlin/collections/ArrayList;", "selected", "loadRandomCallPhotoWallView", "observeListener", "observeRtcPlayerListener", "onClickCloseBtn", "onClickCloseLotteryBtn", "onDestroy", "onMessage", "ircTypeKey", "message", "startRandomSelect", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallNewPluginDriver.kt */
public final class RandomCallNewPluginDriver extends BaseLivePluginDriver implements RandomCallPhotoWallListener, RandomCallLotteryListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.RANDOM_CALL_NEW;
    public static final String TARGET = "RandomCallNewPluginDriver.Observer";
    private Context mContext = ((Context) this.mLiveRoomProvider.getWeakRefContext().get());
    private RandomCallLotteryPluginView mLotteryPluginView;
    /* access modifiers changed from: private */
    public BaseRandomCallPhotoWallPluginView mPhotoWallPluginView;
    /* access modifiers changed from: private */
    public RtcViewModel mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
    private String mUserId;
    /* access modifiers changed from: private */
    public RandomCallViewModel mViewModel = AbilityPackKt.getAbilityPack().getViewModel(RandomCallViewModel.class);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RandomCallNewPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        DataStorage dataStorage;
        UserInfoProxy userInfo;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        XesLog.i(TAG, "随机点名插件激活");
        ILiveRoomProvider iLiveRoomProvider2 = this.mLiveRoomProvider;
        String str = null;
        if (!(iLiveRoomProvider2 == null || (dataStorage = iLiveRoomProvider2.getDataStorage()) == null || (userInfo = dataStorage.getUserInfo()) == null)) {
            str = userInfo.getId();
        }
        this.mUserId = str;
        observeListener();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/RandomCallNewPluginDriver$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RandomCallNewPluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void observeListener() {
        ListenerData<RandomCallListenerBody> mListenerBody;
        RandomCallViewModel randomCallViewModel = this.mViewModel;
        if (randomCallViewModel != null && (mListenerBody = randomCallViewModel.getMListenerBody()) != null) {
            mListenerBody.observeListener((LifecycleOwner) this, false, TARGET, new RandomCallNewPluginDriver$observeListener$1(this));
        }
    }

    private final void observeRtcPlayerListener() {
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (rtcViewModel != null && (mRtcPlayerListener = rtcViewModel.getMRtcPlayerListener()) != null) {
            mRtcPlayerListener.observeListener((LifecycleOwner) this, false, TARGET, new RandomCallNewPluginDriver$observeRtcPlayerListener$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void loadRandomCallPhotoWallView(ArrayList<RandomCallUserBean> arrayList, RandomCallUserBean randomCallUserBean) {
        Context context;
        BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView;
        if (arrayList != null && randomCallUserBean != null && arrayList.size() > 0 && (context = this.mContext) != null) {
            RandomCallViewModel randomCallViewModel = this.mViewModel;
            if (randomCallViewModel != null && randomCallViewModel.isOpenStream()) {
                observeRtcPlayerListener();
            }
            XesLog.i(TAG, "加载照片墙View");
            if (PadUtils.isPad(context)) {
                baseRandomCallPhotoWallPluginView = new RandomCallPhotoWallPluginViewPad(context, arrayList, randomCallUserBean);
            } else {
                baseRandomCallPhotoWallPluginView = new RandomCallPhotoWallPluginViewPhone(context, arrayList, randomCallUserBean);
            }
            this.mPhotoWallPluginView = baseRandomCallPhotoWallPluginView;
            baseRandomCallPhotoWallPluginView.setRandomCallPhotoWallListener(this);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mPhotoWallPluginView, this.mPluginConfData.getViewLevel("RandomCallPhotoWallPluginView"), LiveAreaContext.get().getPptLp().newLp());
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new RandomCallNewPluginDriver$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadRandomCallPhotoWallView$lambda-4$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m396loadRandomCallPhotoWallView$lambda4$lambda3$lambda2$lambda1(RandomCallNewPluginDriver randomCallNewPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(randomCallNewPluginDriver, "this$0");
        BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView = randomCallNewPluginDriver.mPhotoWallPluginView;
        FrameLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = baseRandomCallPhotoWallPluginView == null ? null : baseRandomCallPhotoWallPluginView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        }
        if (layoutParams != null) {
            liveAreaContext.getPptLp().mergeLp(layoutParams);
            BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView2 = randomCallNewPluginDriver.mPhotoWallPluginView;
            if (baseRandomCallPhotoWallPluginView2 != null) {
                baseRandomCallPhotoWallPluginView2.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void destroyRandomCallPhotoWallView(boolean z) {
        RtcViewModel rtcViewModel;
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView = this.mPhotoWallPluginView;
        boolean z2 = false;
        if (baseRandomCallPhotoWallPluginView != null) {
            XesLog.i(TAG, "销毁照片墙View");
            baseRandomCallPhotoWallPluginView.destroy(z);
            this.mLiveRoomProvider.removeView((View) baseRandomCallPhotoWallPluginView);
        }
        this.mPhotoWallPluginView = null;
        RandomCallViewModel randomCallViewModel = this.mViewModel;
        if (randomCallViewModel != null && randomCallViewModel.isOpenStream()) {
            z2 = true;
        }
        if (z2 && (rtcViewModel = this.mRtcViewModel) != null && (mRtcPlayerListener = rtcViewModel.getMRtcPlayerListener()) != null) {
            mRtcPlayerListener.removeListener(TARGET);
        }
    }

    public void onMessage(String str, String str2) {
        RandomCallViewModel randomCallViewModel;
        if (Intrinsics.areEqual(str, "small_random_call") && (randomCallViewModel = this.mViewModel) != null) {
            randomCallViewModel.onReceiveRandomCallMessage(str2);
        }
    }

    public void onDestroy() {
        ListenerData<RandomCallListenerBody> mListenerBody;
        destroyRandomCallPhotoWallView(true);
        destroyLotteryPluginView();
        RandomCallViewModel randomCallViewModel = this.mViewModel;
        if (!(randomCallViewModel == null || (mListenerBody = randomCallViewModel.getMListenerBody()) == null)) {
            mListenerBody.removeListener(TARGET);
        }
        LiveAreaContext.get().layoutObserver.removeObservers((LifecycleOwner) this);
        XesLog.i(TAG, "随机点名插件销毁");
    }

    public void onClickCloseBtn() {
        boolean z = true;
        XesLog.i(TAG, "点击照片墙关闭按钮");
        destroyRandomCallPhotoWallView(true);
        RandomCallViewModel randomCallViewModel = this.mViewModel;
        if (randomCallViewModel == null || !randomCallViewModel.isOpenStream()) {
            z = false;
        }
        if (z) {
            PluginEventBus.onEvent(DataBusKey.RANDOM_CALL_KEY, new PluginEventData(RandomCallNewPluginDriver.class, DataBusKey.RANDOM_CALL_KEY, "2"));
        }
    }

    /* access modifiers changed from: private */
    public final void loadLotteryPluginView(ArrayList<RandomCallUserBean> arrayList, RandomCallUserBean randomCallUserBean) {
        Context context;
        if (arrayList != null && randomCallUserBean != null && (context = this.mContext) != null) {
            arrayList.add(randomCallUserBean);
            XesLog.i(TAG, "加载摇奖机View");
            RandomCallLotteryPluginView randomCallLotteryPluginView = new RandomCallLotteryPluginView(context);
            this.mLotteryPluginView = randomCallLotteryPluginView;
            randomCallLotteryPluginView.setListener(this);
            RandomCallLotteryPluginView randomCallLotteryPluginView2 = this.mLotteryPluginView;
            if (randomCallLotteryPluginView2 != null) {
                randomCallLotteryPluginView2.setUserId(this.mUserId);
            }
            RandomCallLotteryPluginView randomCallLotteryPluginView3 = this.mLotteryPluginView;
            if (randomCallLotteryPluginView3 != null) {
                randomCallLotteryPluginView3.setStudents(arrayList);
            }
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mLotteryPluginView, this.mPluginConfData.getViewLevel("RandomCallLotteryPluginView"), LiveAreaContext.get().getPptLp().newLp());
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new RandomCallNewPluginDriver$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadLotteryPluginView$lambda-10$lambda-9$lambda-8$lambda-7  reason: not valid java name */
    public static final void m395loadLotteryPluginView$lambda10$lambda9$lambda8$lambda7(RandomCallNewPluginDriver randomCallNewPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(randomCallNewPluginDriver, "this$0");
        RandomCallLotteryPluginView randomCallLotteryPluginView = randomCallNewPluginDriver.mLotteryPluginView;
        FrameLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = randomCallLotteryPluginView == null ? null : randomCallLotteryPluginView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        }
        if (layoutParams != null) {
            liveAreaContext.getPptLp().mergeLp(layoutParams);
            RandomCallLotteryPluginView randomCallLotteryPluginView2 = randomCallNewPluginDriver.mLotteryPluginView;
            if (randomCallLotteryPluginView2 != null) {
                randomCallLotteryPluginView2.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void startRandomSelect() {
        XesLog.i(TAG, "开始摇奖机动画");
        RandomCallLotteryPluginView randomCallLotteryPluginView = this.mLotteryPluginView;
        if (randomCallLotteryPluginView != null) {
            randomCallLotteryPluginView.startRandomSelect();
        }
    }

    /* access modifiers changed from: private */
    public final void destroyLotteryPluginView() {
        RandomCallLotteryPluginView randomCallLotteryPluginView = this.mLotteryPluginView;
        if (randomCallLotteryPluginView != null) {
            XesLog.i(TAG, "销毁摇奖机View");
            this.mLiveRoomProvider.removeView((View) randomCallLotteryPluginView);
        }
        this.mLotteryPluginView = null;
    }

    public void onClickCloseLotteryBtn() {
        XesLog.i(TAG, "摇奖机点击关闭按钮");
        destroyLotteryPluginView();
    }
}
