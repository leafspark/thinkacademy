package com.tal.app.thinkacademy.live.business.allonstage;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.ShapeUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.allonstage.adapter.AllOnstagePadAdapter;
import com.tal.app.thinkacademy.live.business.allonstage.view.AllOnStageControlPopup;
import com.tal.app.thinkacademy.live.business.allonstage.view.AllOnStageMicHitPopup;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadBinding;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.widget.EmojiViewPopupWindow;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPrivateRemindView;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherOnStageMsg;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001NB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001e\u0010\u001a\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J \u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0014J\b\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000bH\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010\u00172\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0012H\u0002J\b\u0010.\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J(\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019H\u0014J\u001e\u00105\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u00106\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u0019H\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0010\u00108\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0010\u00109\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0019H\u0016J\u0016\u0010<\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0019H\u0016J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u0019H\u0016J\u0010\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u0019H\u0016J\b\u0010E\u001a\u00020\u0014H\u0002J\b\u0010F\u001a\u00020\u0014H\u0016J\b\u0010G\u001a\u00020\u0014H\u0002J$\u0010G\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00122\n\u0010H\u001a\u0006\u0012\u0002\b\u00030I2\u0006\u0010J\u001a\u00020\u000bH\u0002J\u001e\u0010G\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00122\f\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010IH\u0016J\u0016\u0010L\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u000bJ\b\u0010M\u001a\u00020\u0014H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginViewPad;", "Lcom/tal/app/thinkacademy/live/business/allonstage/BaseAllOnStagePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutAllOnStagePadBinding;", "context", "Landroid/content/Context;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mAdapter", "Lcom/tal/app/thinkacademy/live/business/allonstage/adapter/AllOnstagePadAdapter;", "mCameraState", "", "mEmojiPopWindow", "Lcom/tal/app/thinkacademy/live/business/emoji/widget/EmojiViewPopupWindow;", "mHandler", "Landroid/os/Handler;", "mMicState", "mUserId", "", "addStudent", "", "list", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "position", "", "changeStudent", "createEmojiPopWindow", "entity", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailEntity;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "destroy", "disMiss", "enableLocalCamera", "isOn", "enableLocalMic", "getHideObj", "uid", "getPopWindowOffsetX", "px", "hideForbidUserView", "initData", "initViews", "onSizeChanged", "w", "h", "oldw", "oldh", "removeStudent", "resizeChild", "setBtnCameraState", "setBtnMicState", "setHearEachOther", "setNetWorkQuality", "picResId", "setRoomStudents", "setStudentSize", "size", "setStudentVolume", "volume", "setTeachInfo", "info", "Lcom/tal/app/thinkacademy/live/business/liveplay/bean/TeacherOnStageMsg;", "setTeacherVolume", "showAllowMicControlView", "showCameraControlView", "showEmoji", "emojiBean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "isShow", "emoji", "showForbidUserView", "showMicControlView", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginViewPad.kt */
public final class AllOnStagePluginViewPad extends BaseAllOnStagePluginView<LiveBusinessLayoutAllOnStagePadBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long EMOJI_DELAY_TIME = 3000;
    private static final String TAG = "AllOnStagePluginViewPad";
    public static final int WHAT_EMOJI_HIDE = 10001;
    public static final int WHAT_HIDE_FORBID_USER_VIEW = 10002;
    public static final int WHAT_HIDE_HIGHLIGHT = 10003;
    /* access modifiers changed from: private */
    public AllOnstagePadAdapter mAdapter;
    /* access modifiers changed from: private */
    public boolean mCameraState = true;
    private EmojiViewPopupWindow mEmojiPopWindow;
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public boolean mMicState = true;
    /* access modifiers changed from: private */
    public long mUserId = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllOnStagePluginViewPad(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
        AllOnStageViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            long mUid = mViewModel.getMUid();
            this.mUserId = mUid;
            AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
            if (allOnstagePadAdapter != null) {
                allOnstagePadAdapter.setMUid(mUid);
            }
        }
        this.mHandler = new AllOnStagePluginViewPad$mHandler$1(this, Looper.getMainLooper());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginViewPad$Companion;", "", "()V", "EMOJI_DELAY_TIME", "", "TAG", "", "WHAT_EMOJI_HIDE", "", "WHAT_HIDE_FORBID_USER_VIEW", "WHAT_HIDE_HIGHLIGHT", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnStagePluginViewPad.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public LiveBusinessLayoutAllOnStagePadBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessLayoutAllOnStagePadBinding inflate = LiveBusinessLayoutAllOnStagePadBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        resizeChild(i2);
    }

    public void initViews() {
        super.initViews();
        this.mBinding.btnBack.setOnClickListener(new AllOnStagePluginViewPad$$ExternalSyntheticLambda1(this));
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this.mContext, 4);
        gridLayoutManager.setOrientation(1);
        this.mBinding.allStageStudentRecyclerview.setLayoutManager(gridLayoutManager);
        this.mAdapter = new AllOnstagePadAdapter(this);
        this.mBinding.allStageStudentRecyclerview.setAdapter(this.mAdapter);
        this.mBinding.allStageStudentRecyclerview.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.mBinding.bottomEmojiBtn.setOnClickListener(new AllOnStagePluginViewPad$$ExternalSyntheticLambda0(this));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        LinearLayout linearLayout = this.mBinding.bottomCameraBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.bottomCameraBtn");
        rxUnDoubleUtil.setOnUnDoubleClickListener(linearLayout, 500, new AllOnStagePluginViewPad$initViews$3(this));
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        LinearLayout linearLayout2 = this.mBinding.bottomMicBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "mBinding.bottomMicBtn");
        rxUnDoubleUtil2.setOnUnDoubleClickListener(linearLayout2, 500, new AllOnStagePluginViewPad$initViews$4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-1  reason: not valid java name */
    public static final void m165initViews$lambda1(AllOnStagePluginViewPad allOnStagePluginViewPad, View view) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        XesLog.a(Tag.ALLONSTAGE, "标题栏返回键点击");
        AllOnStageViewModel mViewModel = allOnStagePluginViewPad.getMViewModel();
        if (mViewModel != null) {
            mViewModel.exit();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-2  reason: not valid java name */
    public static final void m166initViews$lambda2(AllOnStagePluginViewPad allOnStagePluginViewPad, View view) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        allOnStagePluginViewPad.showEmoji();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void hideForbidUserView(long j) {
        int findStudentInfo;
        AllOnStagePluginDriver mDriver = getMDriver();
        if (mDriver != null && (findStudentInfo = mDriver.findStudentInfo(j)) > -1) {
            mDriver.getMOnlineStudentList().get(findStudentInfo).setShowForbidUserView(false);
            mDriver.updateStudentsInfo(findStudentInfo);
        }
    }

    public void initData() {
        super.initData();
        RtcViewModel mRtcViewModel = getMRtcViewModel();
        boolean z = true;
        setBtnMicState(mRtcViewModel == null ? true : mRtcViewModel.getMLocalAudioEnable());
        RtcViewModel mRtcViewModel2 = getMRtcViewModel();
        if (mRtcViewModel2 != null) {
            z = mRtcViewModel2.getMLocalVideoEnable();
        }
        setBtnCameraState(z);
        TextView textView = this.mBinding.tvTitle;
        AllOnStageViewModel mViewModel = getMViewModel();
        textView.setText(mViewModel == null ? null : mViewModel.getCourseName());
    }

    public final void showForbidUserView(long j, boolean z) {
        StudentVideoBean.ListBean hideObj = getHideObj(j);
        if (hideObj != null) {
            if (z) {
                this.mHandler.removeMessages(10002, hideObj);
                Message obtain = Message.obtain();
                obtain.what = 10002;
                obtain.obj = hideObj;
                this.mHandler.sendMessageDelayed(obtain, EMOJI_DELAY_TIME);
                return;
            }
            this.mHandler.removeMessages(10002, hideObj);
        }
    }

    public void showMicControlView() {
        if (getMMicControlPopup() == null) {
            AllOnStagePluginViewPad allOnStagePluginViewPad = this;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setMMicControlPopup(new AllOnStageControlPopup(context, Type.RECORD));
            AllOnStageControlPopup mMicControlPopup = getMMicControlPopup();
            if (mMicControlPopup != null) {
                mMicControlPopup.setOnAgreeClick(new AllOnStagePluginViewPad$showMicControlView$1$1(this));
            }
            AllOnStageControlPopup mMicControlPopup2 = getMMicControlPopup();
            if (mMicControlPopup2 != null) {
                AllOnStageControlPopup allOnStageControlPopup = (AllOnStageControlPopup) mMicControlPopup2.setOnDismissListener(new AllOnStagePluginViewPad$$ExternalSyntheticLambda3(this));
            }
        }
        AllOnStageControlPopup mMicControlPopup3 = getMMicControlPopup();
        if (mMicControlPopup3 != null && !mMicControlPopup3.isShowing()) {
            mMicControlPopup3.showAsDropDown(this.mBinding.bottomCameraBtn, getPopWindowOffsetX(getResources().getDimensionPixelOffset(R.dimen.size_300dp)), 0, 8388611);
            if (getMMicControlRunnable() == null) {
                setMMicControlRunnable(new AllOnStagePluginViewPad$$ExternalSyntheticLambda6(this));
            }
            Runnable mMicControlRunnable = getMMicControlRunnable();
            if (mMicControlRunnable != null) {
                getMPopHandler().postDelayed(mMicControlRunnable, LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showMicControlView$lambda-6$lambda-5  reason: not valid java name */
    public static final void m172showMicControlView$lambda6$lambda5(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        Runnable mMicControlRunnable = allOnStagePluginViewPad.getMMicControlRunnable();
        if (mMicControlRunnable != null) {
            allOnStagePluginViewPad.getMPopHandler().removeCallbacks(mMicControlRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showMicControlView$lambda-10$lambda-8$lambda-7  reason: not valid java name */
    public static final void m171showMicControlView$lambda10$lambda8$lambda7(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        AllOnStageControlPopup mMicControlPopup = allOnStagePluginViewPad.getMMicControlPopup();
        if (mMicControlPopup != null) {
            mMicControlPopup.dismiss();
        }
    }

    public void showCameraControlView() {
        if (getMCameraControlPopup() == null) {
            AllOnStagePluginViewPad allOnStagePluginViewPad = this;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setMCameraControlPopup(new AllOnStageControlPopup(context, Type.CAMERA));
            AllOnStageControlPopup mCameraControlPopup = getMCameraControlPopup();
            if (mCameraControlPopup != null) {
                mCameraControlPopup.setOnAgreeClick(new AllOnStagePluginViewPad$showCameraControlView$1$1(this));
            }
            AllOnStageControlPopup mCameraControlPopup2 = getMCameraControlPopup();
            if (mCameraControlPopup2 != null) {
                AllOnStageControlPopup allOnStageControlPopup = (AllOnStageControlPopup) mCameraControlPopup2.setOnDismissListener(new AllOnStagePluginViewPad$$ExternalSyntheticLambda2(this));
            }
        }
        AllOnStageControlPopup mCameraControlPopup3 = getMCameraControlPopup();
        if (mCameraControlPopup3 != null && !mCameraControlPopup3.isShowing()) {
            mCameraControlPopup3.showAsDropDown(this.mBinding.bottomCameraBtn, getPopWindowOffsetX(getResources().getDimensionPixelOffset(R.dimen.size_450dp)), 0, 8388611);
            if (getMCameraControlRunnable() == null) {
                setMCameraControlRunnable(new AllOnStagePluginViewPad$$ExternalSyntheticLambda8(this));
            }
            Runnable mCameraControlRunnable = getMCameraControlRunnable();
            if (mCameraControlRunnable != null) {
                getMPopHandler().postDelayed(mCameraControlRunnable, 5000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCameraControlView$lambda-13$lambda-12  reason: not valid java name */
    public static final void m169showCameraControlView$lambda13$lambda12(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        Runnable mCameraControlRunnable = allOnStagePluginViewPad.getMCameraControlRunnable();
        if (mCameraControlRunnable != null) {
            allOnStagePluginViewPad.getMPopHandler().removeCallbacks(mCameraControlRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCameraControlView$lambda-17$lambda-15$lambda-14  reason: not valid java name */
    public static final void m170showCameraControlView$lambda17$lambda15$lambda14(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        AllOnStageControlPopup mCameraControlPopup = allOnStagePluginViewPad.getMCameraControlPopup();
        if (mCameraControlPopup != null) {
            mCameraControlPopup.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void showAllowMicControlView() {
        if (getMMicNotAllowPopup() == null) {
            AllOnStagePluginViewPad allOnStagePluginViewPad = this;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setMMicNotAllowPopup(new AllOnStageMicHitPopup(context));
            AllOnStageMicHitPopup mMicNotAllowPopup = getMMicNotAllowPopup();
            if (mMicNotAllowPopup != null) {
                AllOnStageMicHitPopup allOnStageMicHitPopup = (AllOnStageMicHitPopup) mMicNotAllowPopup.setOnDismissListener(new AllOnStagePluginViewPad$$ExternalSyntheticLambda4(this));
            }
        }
        AllOnStageMicHitPopup mMicNotAllowPopup2 = getMMicNotAllowPopup();
        if (mMicNotAllowPopup2 != null && !mMicNotAllowPopup2.isShowing()) {
            mMicNotAllowPopup2.showAsDropDown(this.mBinding.bottomCameraBtn, getPopWindowOffsetX(getResources().getDimensionPixelOffset(R.dimen.size_450dp)), 0, 8388611);
            if (getMMicNotAllowRunnable() == null) {
                setMMicNotAllowRunnable(new AllOnStagePluginViewPad$$ExternalSyntheticLambda7(this));
            }
            Runnable mMicNotAllowRunnable = getMMicNotAllowRunnable();
            if (mMicNotAllowRunnable != null) {
                getMPopHandler().postDelayed(mMicNotAllowRunnable, 5000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAllowMicControlView$lambda-20$lambda-19  reason: not valid java name */
    public static final void m167showAllowMicControlView$lambda20$lambda19(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        Runnable mMicNotAllowRunnable = allOnStagePluginViewPad.getMMicNotAllowRunnable();
        if (mMicNotAllowRunnable != null) {
            allOnStagePluginViewPad.getMPopHandler().removeCallbacks(mMicNotAllowRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAllowMicControlView$lambda-24$lambda-22$lambda-21  reason: not valid java name */
    public static final void m168showAllowMicControlView$lambda24$lambda22$lambda21(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        AllOnStageMicHitPopup mMicNotAllowPopup = allOnStagePluginViewPad.getMMicNotAllowPopup();
        if (mMicNotAllowPopup != null) {
            mMicNotAllowPopup.dismiss();
        }
    }

    private final void setBtnMicState(boolean z) {
        this.mMicState = z;
        if (z) {
            this.mBinding.micImage.setImageResource(R.drawable.bg_live_business_allonstage_icon_mic_bg);
            this.mBinding.micText.setText(getResources().getText(R.string.mute));
            return;
        }
        this.mBinding.micImage.setImageResource(R.drawable.bg_live_business_allonstage_icon_mic_close);
        this.mBinding.micText.setText(getResources().getText(R.string.unmute));
    }

    private final void setBtnCameraState(boolean z) {
        this.mCameraState = z;
        if (z) {
            this.mBinding.cameraImage.setImageResource(R.drawable.bg_live_business_allonstage_icon_camera);
        } else {
            this.mBinding.cameraImage.setImageResource(R.drawable.bg_live_business_allonstage_icon_camera_close);
        }
    }

    private final void showEmoji() {
        String str;
        PlanInfoProxy planInfo;
        CourseInfoProxy courseInfo;
        CourseInfoProxy courseInfo2;
        this.mBinding.emojiImage.setImageResource(R.drawable.bg_live_business_allonstage_icon_emoji_open);
        DataStorage dataStorage = getLiveRoomProvider().getDataStorage();
        String str2 = null;
        EmojiDetailEntity emojiDetailEntity = dataStorage == null ? null : dataStorage.getEmojiDetailEntity();
        if (emojiDetailEntity != null) {
            if (this.mEmojiPopWindow == null || Intrinsics.areEqual(emojiDetailEntity.isUpdate(), true)) {
                createEmojiPopWindow(emojiDetailEntity);
            }
            EmojiViewPopupWindow emojiViewPopupWindow = this.mEmojiPopWindow;
            if (emojiViewPopupWindow != null && !emojiViewPopupWindow.isShowing()) {
                emojiViewPopupWindow.initWindow();
                emojiViewPopupWindow.showAsDropDown(this.mBinding.bottomCameraBtn, getPopWindowOffsetX(emojiViewPopupWindow.getWidth()), 0, 8388611);
                DriverTrack driverTrack = DriverTrack.INSTANCE;
                DataStorage dataStorage2 = getLiveRoomProvider().getDataStorage();
                String num = (dataStorage2 == null || (courseInfo2 = dataStorage2.getCourseInfo()) == null) ? null : Integer.valueOf(courseInfo2.getPlanId()).toString();
                DataStorage dataStorage3 = getLiveRoomProvider().getDataStorage();
                String num2 = (dataStorage3 == null || (courseInfo = dataStorage3.getCourseInfo()) == null) ? null : Integer.valueOf(courseInfo.getClassId()).toString();
                String classType = getLiveRoomProvider().getClassType();
                if (Intrinsics.areEqual(classType, EnterRoomMuteData.STATUS_UN_MUTE)) {
                    str = "大班";
                } else {
                    str = Intrinsics.areEqual(classType, "1") ? "伪小班" : "小班";
                }
                String str3 = str;
                DataStorage dataStorage4 = getLiveRoomProvider().getDataStorage();
                if (!(dataStorage4 == null || (planInfo = dataStorage4.getPlanInfo()) == null)) {
                    str2 = Long.valueOf(planInfo.getPackageId()).toString();
                }
                DriverTrack.emojiRelated$default(driverTrack, "hw_classroom_emoji_icon_click", num, num2, str3, (Boolean) null, "全员上台", (String) null, (String) null, (Boolean) null, (String) null, (String) null, str2, 2000, (Object) null);
            }
        }
    }

    private final void createEmojiPopWindow(EmojiDetailEntity emojiDetailEntity) {
        EmojiDetailEntity emojiDetailEntity2 = null;
        this.mEmojiPopWindow = null;
        DataStorage dataStorage = getLiveRoomProvider().getDataStorage();
        if (dataStorage != null) {
            emojiDetailEntity2 = dataStorage.getEmojiDetailEntity();
        }
        boolean z = false;
        if (emojiDetailEntity2 != null) {
            emojiDetailEntity2.setUpdate(false);
        }
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        EmojiViewPopupWindow emojiViewPopupWindow = new EmojiViewPopupWindow(context, emojiDetailEntity, this.mBinding.listParent.getWidth(), (Integer) null, (Integer) null, (Integer) null, new AllOnStagePluginViewPad$createEmojiPopWindow$window$1(this), 56, (DefaultConstructorMarker) null);
        this.mEmojiPopWindow = emojiViewPopupWindow;
        EmojiViewPopupWindow emojiViewPopupWindow2 = (EmojiViewPopupWindow) emojiViewPopupWindow.setOnDismissListener(new AllOnStagePluginViewPad$$ExternalSyntheticLambda5(this));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        if (Intrinsics.areEqual(emojiDetailEntity.isReportedOverdue(), false)) {
            ArrayList<EmojiDetailPackage> list = emojiDetailEntity.getList();
            if (list != null) {
                for (EmojiDetailPackage emojiDetailPackage : list) {
                    if (Intrinsics.areEqual(emojiDetailPackage.isOver(), true)) {
                        ArrayList arrayList = (ArrayList) objectRef.element;
                        String orderId = emojiDetailPackage.getOrderId();
                        if (orderId == null) {
                            orderId = EnterRoomMuteData.STATUS_UN_MUTE;
                        }
                        arrayList.add(Integer.valueOf(Integer.parseInt(orderId)));
                    }
                }
            }
            Collection collection = (Collection) objectRef.element;
            if (collection == null || collection.isEmpty()) {
                z = true;
            }
            if (!z) {
                InteractReportKt.updateEmojiOverHide((ArrayList) objectRef.element, new AllOnStagePluginViewPad$createEmojiPopWindow$3(objectRef, this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createEmojiPopWindow$lambda-27  reason: not valid java name */
    public static final void m164createEmojiPopWindow$lambda27(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "this$0");
        allOnStagePluginViewPad.mBinding.emojiImage.setImageResource(R.drawable.bg_live_business_allonstage_icon_emoji);
    }

    private final int getPopWindowOffsetX(int i) {
        int width = this.mBinding.bottomCameraBtn.getWidth();
        if (width <= 0) {
            return 0;
        }
        if (i > width) {
            return ((i - width) * -1) / 2;
        }
        return (width - i) / 2;
    }

    public void destroy() {
        EmojiViewPopupWindow emojiViewPopupWindow = this.mEmojiPopWindow;
        if (emojiViewPopupWindow != null) {
            emojiViewPopupWindow.dismiss();
        }
        this.mEmojiPopWindow = null;
    }

    public void disMiss() {
        super.disMiss();
        AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
        if (allOnstagePadAdapter != null) {
            allOnstagePadAdapter.setMIsOnstage(false);
        }
        this.mBinding.allStageTeacherRoot.enableCorner(false);
        EmojiViewPopupWindow emojiViewPopupWindow = this.mEmojiPopWindow;
        if (emojiViewPopupWindow != null) {
            if (!emojiViewPopupWindow.isShowing()) {
                emojiViewPopupWindow = null;
            }
            if (emojiViewPopupWindow != null) {
                emojiViewPopupWindow.dismiss();
            }
        }
    }

    public void setStudentSize(int i) {
        if (i <= 9) {
            this.mBinding.allStageStudentRecyclerview.setLayoutManager(new GridLayoutManager(this.mContext, 3));
            AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
            if (allOnstagePadAdapter != null) {
                allOnstagePadAdapter.setSpanSize(3);
                return;
            }
            return;
        }
        AllOnstagePadAdapter allOnstagePadAdapter2 = this.mAdapter;
        if (allOnstagePadAdapter2 != null) {
            allOnstagePadAdapter2.setSpanSize(4);
        }
    }

    public void setTeachInfo(TeacherOnStageMsg teacherOnStageMsg) {
        Intrinsics.checkNotNullParameter(teacherOnStageMsg, "info");
        this.mBinding.allStageTeacherRoot.setTeacherInfo(teacherOnStageMsg);
    }

    public void setTeacherVolume(int i) {
        this.mBinding.allStageTeacherRoot.setTeacherVolume(i);
    }

    public void showEmoji(long j, EmojiBean<?> emojiBean) {
        if (emojiBean != null) {
            showEmoji(j, emojiBean, true);
        }
    }

    public void setStudentVolume(long j, int i) {
        StudentVideoBean.ListBean listBean;
        if (this.mMicState && j == 0) {
            this.mBinding.micImage.getDrawable().setLevel((i * 10000) / 255);
        }
        AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
        if (allOnstagePadAdapter != null) {
            allOnstagePadAdapter.updateMic(j, i);
        }
        if (i > 100) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 == 0) {
                listBean = getHideObj(this.mUserId);
            } else {
                listBean = getHideObj(j);
            }
            if (listBean != null) {
                this.mHandler.removeMessages(10003, listBean);
                if (i2 == 0) {
                    AllOnstagePadAdapter allOnstagePadAdapter2 = this.mAdapter;
                    if (allOnstagePadAdapter2 != null) {
                        allOnstagePadAdapter2.showHighLight(this.mUserId, true);
                    }
                } else {
                    AllOnstagePadAdapter allOnstagePadAdapter3 = this.mAdapter;
                    if (allOnstagePadAdapter3 != null) {
                        allOnstagePadAdapter3.showHighLight(j, true);
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = 10003;
                obtain.obj = listBean;
                this.mHandler.sendMessageDelayed(obtain, 1000);
            }
        }
    }

    public void setRoomStudents(List<? extends StudentVideoBean.ListBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
        if (allOnstagePadAdapter != null) {
            allOnstagePadAdapter.setData(list);
        }
    }

    public void addStudent(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
        if (allOnstagePadAdapter != null) {
            allOnstagePadAdapter.insertData(list);
        }
    }

    public void removeStudent(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
        if (allOnstagePadAdapter != null) {
            allOnstagePadAdapter.removeData(list, i);
        }
    }

    public void changeStudent(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
        if (allOnstagePadAdapter != null) {
            allOnstagePadAdapter.changeData(list, i);
        }
    }

    public void setHearEachOther(boolean z) {
        AllOnstagePadAdapter allOnstagePadAdapter = this.mAdapter;
        if (allOnstagePadAdapter != null) {
            allOnstagePadAdapter.setMIsHearEachOther(z);
        }
    }

    public void enableLocalMic(boolean z) {
        setBtnMicState(z);
    }

    public void enableLocalCamera(boolean z) {
        setBtnCameraState(z);
    }

    public void setNetWorkQuality(int i) {
        this.mBinding.btnNetWorkQuality.setImageResource(i);
    }

    /* access modifiers changed from: private */
    public final void showEmoji(long j, EmojiBean<?> emojiBean, boolean z) {
        int findStudentInfo;
        int type = emojiBean.getType();
        boolean z2 = type != 1 && (type == 2 || (type != 3 && type == 4));
        XesLog.dt(TAG, "showEmoji = " + j + ",isShow = " + z + ",isLottie = " + z2);
        StringBuilder sb = new StringBuilder();
        sb.append("showEmoji = ");
        sb.append(j);
        sb.append(",isShow = ");
        sb.append(z);
        XesLog.dt(TAG, sb.toString());
        StudentVideoBean.ListBean hideObj = getHideObj(j);
        if (hideObj != null) {
            if (z) {
                this.mHandler.removeMessages(10001, hideObj);
            }
            AllOnStagePluginDriver mDriver = getMDriver();
            if (mDriver != null && (findStudentInfo = mDriver.findStudentInfo(j)) > -1) {
                mDriver.getMOnlineStudentList().get(findStudentInfo).setShowEmoji(z);
                mDriver.getMOnlineStudentList().get(findStudentInfo).setEmojiBean(emojiBean);
                mDriver.updateStudentsInfo(findStudentInfo);
            }
            if (z && !z2) {
                Message obtain = Message.obtain();
                obtain.what = 10001;
                obtain.obj = hideObj;
                this.mHandler.sendMessageDelayed(obtain, EMOJI_DELAY_TIME);
            }
        }
    }

    private final StudentVideoBean.ListBean getHideObj(long j) {
        AllOnStagePluginDriver mDriver = getMDriver();
        if (mDriver == null) {
            return null;
        }
        return mDriver.getStudentObj(j);
    }

    private final void resizeChild(int i) {
        int i2 = i;
        ViewGroup.LayoutParams layoutParams = this.mBinding.btnBack.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int i3 = (i2 * 24) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams2.width = i3;
        layoutParams2.height = i3;
        int i4 = (i2 * 12) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams2.leftMargin = i4;
        int i5 = (i2 * 5) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams2.topMargin = i5;
        ViewGroup.LayoutParams layoutParams3 = this.mBinding.btnNetWorkQuality.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.width = i3;
        layoutParams4.height = i3;
        layoutParams4.rightMargin = i4;
        layoutParams4.topMargin = i5;
        ViewGroup.LayoutParams layoutParams5 = this.mBinding.allStageTeacherRoot.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        int i6 = (i2 * 220) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams6.width = i6;
        layoutParams6.height = (i2 * 165) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        int i7 = (i2 * 10) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams6.leftMargin = i7;
        int i8 = (i2 * 39) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams6.topMargin = i8;
        ViewGroup.LayoutParams layoutParams7 = this.mBinding.allStageChatBoxRoot.getLayoutParams();
        Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
        layoutParams8.width = i6;
        layoutParams8.leftMargin = i7;
        ViewGroup.LayoutParams layoutParams9 = this.mBinding.listParent.getLayoutParams();
        Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
        layoutParams10.height = (i2 * 313) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams10.topMargin = i8;
        int i9 = (i2 * 1) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams10.leftMargin = i9;
        layoutParams10.rightMargin = i7;
        float f = (float) i2;
        float f2 = (float) AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        float f3 = (8.0f * f) / f2;
        this.mBinding.listParent.setBackground(ShapeUtil.createRounderDrawable(Color.parseColor("#FFE7B8"), new float[]{f3, f3, 0.0f, 0.0f}));
        ViewGroup.LayoutParams layoutParams11 = this.mBinding.allStageStudentRecyclerview.getLayoutParams();
        Objects.requireNonNull(layoutParams11, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams12 = (FrameLayout.LayoutParams) layoutParams11;
        int i10 = (i2 * 2) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams12.leftMargin = i10;
        layoutParams12.rightMargin = i10;
        layoutParams12.topMargin = i5;
        layoutParams12.bottomMargin = i5;
        ViewGroup.LayoutParams layoutParams13 = this.mBinding.bottomBtnLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams13, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) layoutParams13;
        layoutParams14.height = (i2 * 43) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams14.leftMargin = i9;
        layoutParams14.topMargin = i9;
        layoutParams14.rightMargin = i7;
        this.mBinding.bottomBtnLayout.setBackground(ShapeUtil.createRounderDrawable(Color.parseColor("#FFE7B8"), new float[]{0.0f, 0.0f, f3, f3}));
        ViewGroup.LayoutParams layoutParams15 = this.mBinding.micImage.getLayoutParams();
        Objects.requireNonNull(layoutParams15, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) layoutParams15;
        int i11 = (i2 * 32) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        layoutParams16.width = i11;
        layoutParams16.height = i11;
        float f4 = (6.0f * f) / f2;
        this.mBinding.micImage.setBackground(ShapeUtil.createRounderDrawable(Color.parseColor("#FFFFF3DC"), f4));
        ImageView imageView = this.mBinding.micImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.micImage");
        int i12 = (i2 * 4) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        imageView.setPadding(i12, i12, i12, i12);
        ViewGroup.LayoutParams layoutParams17 = this.mBinding.micText.getLayoutParams();
        Objects.requireNonNull(layoutParams17, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams17).leftMargin = i5;
        ViewGroup.LayoutParams layoutParams18 = this.mBinding.cameraImage.getLayoutParams();
        Objects.requireNonNull(layoutParams18, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) layoutParams18;
        layoutParams19.width = i11;
        layoutParams19.height = i11;
        this.mBinding.cameraImage.setBackground(ShapeUtil.createRounderDrawable(Color.parseColor("#FFFFF3DC"), f4));
        ImageView imageView2 = this.mBinding.cameraImage;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.cameraImage");
        imageView2.setPadding(i12, i12, i12, i12);
        ViewGroup.LayoutParams layoutParams20 = this.mBinding.cameraText.getLayoutParams();
        Objects.requireNonNull(layoutParams20, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams20).leftMargin = i5;
        ViewGroup.LayoutParams layoutParams21 = this.mBinding.emojiImage.getLayoutParams();
        Objects.requireNonNull(layoutParams21, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) layoutParams21;
        layoutParams22.width = i11;
        layoutParams22.height = i11;
        this.mBinding.emojiImage.setBackground(ShapeUtil.createRounderDrawable(Color.parseColor("#FFFFF3DC"), f4));
        ImageView imageView3 = this.mBinding.emojiImage;
        Intrinsics.checkNotNullExpressionValue(imageView3, "mBinding.emojiImage");
        imageView3.setPadding(i12, i12, i12, i12);
        ViewGroup.LayoutParams layoutParams23 = this.mBinding.emojiText.getLayoutParams();
        Objects.requireNonNull(layoutParams23, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams23).leftMargin = i5;
        float f5 = (f * 12.0f) / f2;
        this.mBinding.emojiText.setTextSize(0, f5);
        this.mBinding.cameraText.setTextSize(0, f5);
        this.mBinding.micText.setTextSize(0, f5);
        ViewGroup.LayoutParams layoutParams24 = this.mBinding.bottomDivider1.getLayoutParams();
        Objects.requireNonNull(layoutParams24, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        int i13 = (i2 * 14) / AppConfig.SCREEN_RESOLUTION_PORTRAIT;
        ((LinearLayout.LayoutParams) layoutParams24).height = i13;
        ViewGroup.LayoutParams layoutParams25 = this.mBinding.bottomDivider2.getLayoutParams();
        Objects.requireNonNull(layoutParams25, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams25).height = i13;
    }
}
