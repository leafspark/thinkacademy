package com.tal.app.thinkacademy.live.business.allonstage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.viewbinding.ViewBinding;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.business.allonstage.view.AllOnStageControlPopup;
import com.tal.app.thinkacademy.live.business.allonstage.view.AllOnStageMicHitPopup;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020HH\u0016J\u0010\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020\u000fH\u0016J\u0010\u0010L\u001a\u00020H2\u0006\u0010M\u001a\u00020!H\u0016J\b\u0010N\u001a\u00020HH&J\b\u0010O\u001a\u00020HH&J\u0010\u0010P\u001a\u00020H2\u0006\u0010Q\u001a\u00020RH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006S"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/BaseAllOnStagePluginView;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStageInterface;", "context", "Landroid/content/Context;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "getLiveRoomProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "setLiveRoomProvider", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mAllowOpenMic", "", "getMAllowOpenMic", "()Z", "setMAllowOpenMic", "(Z)V", "mCameraControlPopup", "Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageControlPopup;", "getMCameraControlPopup", "()Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageControlPopup;", "setMCameraControlPopup", "(Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageControlPopup;)V", "mCameraControlRunnable", "Ljava/lang/Runnable;", "getMCameraControlRunnable", "()Ljava/lang/Runnable;", "setMCameraControlRunnable", "(Ljava/lang/Runnable;)V", "mDriver", "Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginDriver;", "getMDriver", "()Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginDriver;", "setMDriver", "(Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginDriver;)V", "mMicControlPopup", "getMMicControlPopup", "setMMicControlPopup", "mMicControlRunnable", "getMMicControlRunnable", "setMMicControlRunnable", "mMicNotAllowPopup", "Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageMicHitPopup;", "getMMicNotAllowPopup", "()Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageMicHitPopup;", "setMMicNotAllowPopup", "(Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageMicHitPopup;)V", "mMicNotAllowRunnable", "getMMicNotAllowRunnable", "setMMicNotAllowRunnable", "mPopHandler", "Landroid/os/Handler;", "getMPopHandler", "()Landroid/os/Handler;", "setMPopHandler", "(Landroid/os/Handler;)V", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "getMRtcViewModel", "()Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "setMRtcViewModel", "(Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;)V", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/AllOnStageViewModel;", "getMViewModel", "()Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/AllOnStageViewModel;", "setMViewModel", "(Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/AllOnStageViewModel;)V", "disMiss", "", "initData", "setAllowOpenMic", "allow", "setDriver", "driver", "showCameraControlView", "showMicControlView", "showOpenPermissionControl", "type", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseAllOnStagePluginView.kt */
public abstract class BaseAllOnStagePluginView<VB extends ViewBinding> extends BaseVBLivePluginView<VB> implements AllOnStageInterface {
    private ILiveRoomProvider liveRoomProvider;
    private boolean mAllowOpenMic = true;
    private AllOnStageControlPopup mCameraControlPopup;
    private Runnable mCameraControlRunnable;
    private AllOnStagePluginDriver mDriver;
    private AllOnStageControlPopup mMicControlPopup;
    private Runnable mMicControlRunnable;
    private AllOnStageMicHitPopup mMicNotAllowPopup;
    private Runnable mMicNotAllowRunnable;
    private Handler mPopHandler;
    private RtcViewModel mRtcViewModel;
    private AllOnStageViewModel mViewModel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BaseAllOnStagePluginView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            iArr[Type.CAMERA.ordinal()] = 1;
            iArr[Type.RECORD.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract void showCameraControlView();

    public abstract void showMicControlView();

    /* access modifiers changed from: protected */
    public final ILiveRoomProvider getLiveRoomProvider() {
        return this.liveRoomProvider;
    }

    /* access modifiers changed from: protected */
    public final void setLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "<set-?>");
        this.liveRoomProvider = iLiveRoomProvider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseAllOnStagePluginView(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
        this.liveRoomProvider = iLiveRoomProvider;
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mPopHandler = new Handler(myLooper);
    }

    /* access modifiers changed from: protected */
    public final AllOnStageViewModel getMViewModel() {
        return this.mViewModel;
    }

    /* access modifiers changed from: protected */
    public final void setMViewModel(AllOnStageViewModel allOnStageViewModel) {
        this.mViewModel = allOnStageViewModel;
    }

    /* access modifiers changed from: protected */
    public final RtcViewModel getMRtcViewModel() {
        return this.mRtcViewModel;
    }

    /* access modifiers changed from: protected */
    public final void setMRtcViewModel(RtcViewModel rtcViewModel) {
        this.mRtcViewModel = rtcViewModel;
    }

    /* access modifiers changed from: protected */
    public final boolean getMAllowOpenMic() {
        return this.mAllowOpenMic;
    }

    /* access modifiers changed from: protected */
    public final void setMAllowOpenMic(boolean z) {
        this.mAllowOpenMic = z;
    }

    /* access modifiers changed from: protected */
    public final AllOnStageControlPopup getMMicControlPopup() {
        return this.mMicControlPopup;
    }

    /* access modifiers changed from: protected */
    public final void setMMicControlPopup(AllOnStageControlPopup allOnStageControlPopup) {
        this.mMicControlPopup = allOnStageControlPopup;
    }

    /* access modifiers changed from: protected */
    public final AllOnStageControlPopup getMCameraControlPopup() {
        return this.mCameraControlPopup;
    }

    /* access modifiers changed from: protected */
    public final void setMCameraControlPopup(AllOnStageControlPopup allOnStageControlPopup) {
        this.mCameraControlPopup = allOnStageControlPopup;
    }

    /* access modifiers changed from: protected */
    public final AllOnStageMicHitPopup getMMicNotAllowPopup() {
        return this.mMicNotAllowPopup;
    }

    /* access modifiers changed from: protected */
    public final void setMMicNotAllowPopup(AllOnStageMicHitPopup allOnStageMicHitPopup) {
        this.mMicNotAllowPopup = allOnStageMicHitPopup;
    }

    /* access modifiers changed from: protected */
    public final Handler getMPopHandler() {
        return this.mPopHandler;
    }

    /* access modifiers changed from: protected */
    public final void setMPopHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.mPopHandler = handler;
    }

    /* access modifiers changed from: protected */
    public final Runnable getMMicControlRunnable() {
        return this.mMicControlRunnable;
    }

    /* access modifiers changed from: protected */
    public final void setMMicControlRunnable(Runnable runnable) {
        this.mMicControlRunnable = runnable;
    }

    /* access modifiers changed from: protected */
    public final Runnable getMCameraControlRunnable() {
        return this.mCameraControlRunnable;
    }

    /* access modifiers changed from: protected */
    public final void setMCameraControlRunnable(Runnable runnable) {
        this.mCameraControlRunnable = runnable;
    }

    /* access modifiers changed from: protected */
    public final Runnable getMMicNotAllowRunnable() {
        return this.mMicNotAllowRunnable;
    }

    /* access modifiers changed from: protected */
    public final void setMMicNotAllowRunnable(Runnable runnable) {
        this.mMicNotAllowRunnable = runnable;
    }

    /* access modifiers changed from: protected */
    public final AllOnStagePluginDriver getMDriver() {
        return this.mDriver;
    }

    /* access modifiers changed from: protected */
    public final void setMDriver(AllOnStagePluginDriver allOnStagePluginDriver) {
        this.mDriver = allOnStagePluginDriver;
    }

    public void initData() {
        BaseAllOnStagePluginView.super.initData();
        this.mViewModel = AbilityPackKt.getAbilityPack().getViewModel(AllOnStageViewModel.class);
        this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
    }

    public void setDriver(AllOnStagePluginDriver allOnStagePluginDriver) {
        Intrinsics.checkNotNullParameter(allOnStagePluginDriver, "driver");
        this.mDriver = allOnStagePluginDriver;
    }

    public void setAllowOpenMic(boolean z) {
        this.mAllowOpenMic = z;
    }

    public void showOpenPermissionControl(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            showCameraControlView();
        } else if (i == 2) {
            if (!PermissionUtils.isGranted("android.permission.RECORD_AUDIO")) {
                AllOnStagePluginDriver allOnStagePluginDriver = this.mDriver;
                if (allOnStagePluginDriver != null) {
                    allOnStagePluginDriver.showPermissionWindow(Type.RECORD);
                    return;
                }
                return;
            }
            RtcViewModel rtcViewModel = this.mRtcViewModel;
            if (rtcViewModel != null) {
                rtcViewModel.enableLocalAudio(true);
            }
        }
    }

    public void disMiss() {
        AllOnStageControlPopup allOnStageControlPopup = this.mMicControlPopup;
        if (allOnStageControlPopup != null) {
            if (!allOnStageControlPopup.isShowing()) {
                allOnStageControlPopup = null;
            }
            if (allOnStageControlPopup != null) {
                allOnStageControlPopup.dismiss();
            }
        }
        AllOnStageControlPopup allOnStageControlPopup2 = this.mCameraControlPopup;
        if (allOnStageControlPopup2 != null) {
            if (!allOnStageControlPopup2.isShowing()) {
                allOnStageControlPopup2 = null;
            }
            if (allOnStageControlPopup2 != null) {
                allOnStageControlPopup2.dismiss();
            }
        }
        AllOnStageMicHitPopup allOnStageMicHitPopup = this.mMicNotAllowPopup;
        if (allOnStageMicHitPopup != null) {
            if (!allOnStageMicHitPopup.isShowing()) {
                allOnStageMicHitPopup = null;
            }
            if (allOnStageMicHitPopup != null) {
                allOnStageMicHitPopup.dismiss();
            }
        }
        this.mPopHandler.removeCallbacksAndMessages((Object) null);
    }
}
