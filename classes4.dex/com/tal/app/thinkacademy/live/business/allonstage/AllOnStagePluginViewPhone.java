package com.tal.app.thinkacademy.live.business.allonstage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.allonstage.adapter.AllOnStagePhoneAdapter;
import com.tal.app.thinkacademy.live.business.allonstage.view.AllOnStageControlPopup;
import com.tal.app.thinkacademy.live.business.allonstage.view.AllOnStageMicHitPopup;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePhoneBinding;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.widget.EmojiOnStageListView;
import com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPrivateRemindView;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherOnStageMsg;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u001e\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0014J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\u001e\u0010%\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0014H\u0016J\u0016\u0010)\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0014H\u0016J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0014H\u0016J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u000fH\u0016J\u001e\u00106\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2\f\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u000108H\u0016J\b\u00109\u001a\u00020\u000fH\u0002J\b\u0010:\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginViewPhone;", "Lcom/tal/app/thinkacademy/live/business/allonstage/BaseAllOnStagePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutAllOnStagePhoneBinding;", "context", "Landroid/content/Context;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mEmojiView", "Lcom/tal/app/thinkacademy/live/business/emoji/widget/EmojiOnStageListView;", "mEnableLocalAudio", "", "mStudentAdapter", "Lcom/tal/app/thinkacademy/live/business/allonstage/adapter/AllOnStagePhoneAdapter;", "addStudent", "", "list", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "position", "", "changeAudio", "enable", "changeStudent", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "destroy", "disMiss", "enableLocalCamera", "isOn", "enableLocalMic", "initData", "initViews", "removeStudent", "setHearEachOther", "setNetWorkQuality", "picResId", "setRoomStudents", "setStudentSize", "size", "setStudentVolume", "uid", "", "volume", "setTeachInfo", "info", "Lcom/tal/app/thinkacademy/live/business/liveplay/bean/TeacherOnStageMsg;", "setTeacherVolume", "showAllowMicControlView", "showCameraControlView", "showEmoji", "emoji", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "showEmojiView", "showMicControlView", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginViewPhone.kt */
public final class AllOnStagePluginViewPhone extends BaseAllOnStagePluginView<LiveBusinessLayoutAllOnStagePhoneBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "AllOnStagePluginViewPhone";
    private EmojiOnStageListView mEmojiView;
    /* access modifiers changed from: private */
    public boolean mEnableLocalAudio = true;
    private AllOnStagePhoneAdapter mStudentAdapter = new AllOnStagePhoneAdapter();

    public void enableLocalCamera(boolean z) {
    }

    public void setHearEachOther(boolean z) {
    }

    public void showCameraControlView() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllOnStagePluginViewPhone(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginViewPhone$Companion;", "", "()V", "TAG", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnStagePluginViewPhone.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public LiveBusinessLayoutAllOnStagePhoneBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessLayoutAllOnStagePhoneBinding inflate = LiveBusinessLayoutAllOnStagePhoneBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public void initViews() {
        super.initViews();
        this.mBinding.btnBack.setOnClickListener(new AllOnStagePluginViewPhone$$ExternalSyntheticLambda1(this));
        this.mBinding.btnEmoji.setOnClickListener(new AllOnStagePluginViewPhone$$ExternalSyntheticLambda0(this));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = this.mBinding.btnAudioMute;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.btnAudioMute");
        rxUnDoubleUtil.setOnUnDoubleClickListener(textView, 500, new AllOnStagePluginViewPhone$initViews$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-0  reason: not valid java name */
    public static final void m174initViews$lambda0(AllOnStagePluginViewPhone allOnStagePluginViewPhone, View view) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPhone, "this$0");
        XesLog.a(Tag.ALLONSTAGE, "标题栏返回键点击");
        AllOnStageViewModel mViewModel = allOnStagePluginViewPhone.getMViewModel();
        if (mViewModel != null) {
            mViewModel.exit();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-1  reason: not valid java name */
    public static final void m175initViews$lambda1(AllOnStagePluginViewPhone allOnStagePluginViewPhone, View view) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPhone, "this$0");
        allOnStagePluginViewPhone.showEmojiView();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void initData() {
        super.initData();
        RtcViewModel mRtcViewModel = getMRtcViewModel();
        changeAudio(mRtcViewModel == null ? true : mRtcViewModel.getMLocalAudioEnable());
        RtcViewModel mRtcViewModel2 = getMRtcViewModel();
        if (mRtcViewModel2 != null) {
            mRtcViewModel2.enableLocalVideo(false);
        }
        TextView textView = this.mBinding.tvTitle;
        AllOnStageViewModel mViewModel = getMViewModel();
        textView.setText(mViewModel == null ? null : mViewModel.getCourseName());
    }

    private final void changeAudio(boolean z) {
        this.mEnableLocalAudio = z;
        this.mBinding.btnAudioMute.setText(getResources().getString(z ? R.string.mute : R.string.unmute));
        this.mBinding.ivAudioMute.setSelected(!z);
    }

    private final void showEmojiView() {
        if (this.mEmojiView == null) {
            AllOnStagePluginViewPhone allOnStagePluginViewPhone = this;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            EmojiOnStageListView emojiOnStageListView = new EmojiOnStageListView(context, 4);
            this.mEmojiView = emojiOnStageListView;
            emojiOnStageListView.onEmojiSelected(new AllOnStagePluginViewPhone$showEmojiView$1$1(this));
            this.mBinding.allStageFrameFunction.addView(emojiOnStageListView, new FrameLayout.LayoutParams(-1, -1));
        }
        EmojiOnStageListView emojiOnStageListView2 = this.mEmojiView;
        if (emojiOnStageListView2 != null) {
            if (emojiOnStageListView2.isShowing()) {
                emojiOnStageListView2 = null;
            }
            if (emojiOnStageListView2 != null) {
                emojiOnStageListView2.show();
            }
        }
    }

    public void destroy() {
        EmojiOnStageListView emojiOnStageListView = this.mEmojiView;
        if (emojiOnStageListView != null) {
            emojiOnStageListView.destroy();
        }
        this.mEmojiView = null;
    }

    public void disMiss() {
        super.disMiss();
        this.mBinding.allStageTeacherRoot.enableCorner(false);
    }

    public void setStudentSize(int i) {
        this.mBinding.allStageStudentRecyclerview.setLayoutManager(new GridLayoutManager(this.mContext, i > 9 ? 4 : 3, 1, false));
        this.mBinding.allStageStudentRecyclerview.addItemDecoration(new ScrollBarDecor());
        this.mBinding.allStageStudentRecyclerview.setAdapter(this.mStudentAdapter);
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
            XesLog.dt(TAG, Intrinsics.stringPlus("showEmoji = ", Long.valueOf(j)));
            this.mStudentAdapter.showEmoji(j, emojiBean);
        }
    }

    public void setStudentVolume(long j, int i) {
        this.mStudentAdapter.updateMic(j, i);
        if (0 == j && !this.mBinding.ivAudioMute.isSelected()) {
            this.mBinding.ivAudioMute.getDrawable().setLevel((i * 10000) / 255);
        }
    }

    public void setRoomStudents(List<? extends StudentVideoBean.ListBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        XesLog.dt(TAG, Intrinsics.stringPlus("setRoomStudents : ", GsonUtils.toJson(list)));
        this.mStudentAdapter.setNewInstance(CollectionsKt.toMutableList(list));
    }

    public void addStudent(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) CollectionsKt.getOrNull(list, i);
        if (listBean != null) {
            this.mStudentAdapter.addData(listBean);
        }
    }

    public void removeStudent(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mStudentAdapter.removeAt(i);
    }

    public void changeStudent(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) CollectionsKt.getOrNull(list, i);
        if (listBean != null) {
            this.mStudentAdapter.setData(i, listBean);
        }
    }

    public void enableLocalMic(boolean z) {
        changeAudio(z);
        this.mStudentAdapter.controlMicState(z);
    }

    public void setNetWorkQuality(int i) {
        this.mBinding.ivWifi.setImageResource(i);
    }

    public void showMicControlView() {
        if (getMMicControlPopup() == null) {
            AllOnStagePluginViewPhone allOnStagePluginViewPhone = this;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setMMicControlPopup(new AllOnStageControlPopup(context, Type.RECORD));
            AllOnStageControlPopup mMicControlPopup = getMMicControlPopup();
            if (mMicControlPopup != null) {
                mMicControlPopup.setOnAgreeClick(new AllOnStagePluginViewPhone$showMicControlView$1$1(this));
            }
            AllOnStageControlPopup mMicControlPopup2 = getMMicControlPopup();
            if (mMicControlPopup2 != null) {
                AllOnStageControlPopup allOnStageControlPopup = (AllOnStageControlPopup) mMicControlPopup2.setOnDismissListener(new AllOnStagePluginViewPhone$$ExternalSyntheticLambda3(this));
            }
        }
        AllOnStageControlPopup mMicControlPopup3 = getMMicControlPopup();
        if (mMicControlPopup3 != null && !mMicControlPopup3.isShowing()) {
            mMicControlPopup3.showAtLocation((View) this, 17, 0, 0);
            if (getMMicControlRunnable() == null) {
                setMMicControlRunnable(new AllOnStagePluginViewPhone$$ExternalSyntheticLambda5(this));
            }
            Runnable mMicControlRunnable = getMMicControlRunnable();
            if (mMicControlRunnable != null) {
                getMPopHandler().postDelayed(mMicControlRunnable, LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showMicControlView$lambda-9$lambda-8  reason: not valid java name */
    public static final void m179showMicControlView$lambda9$lambda8(AllOnStagePluginViewPhone allOnStagePluginViewPhone) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPhone, "this$0");
        Runnable mMicControlRunnable = allOnStagePluginViewPhone.getMMicControlRunnable();
        if (mMicControlRunnable != null) {
            allOnStagePluginViewPhone.getMPopHandler().removeCallbacks(mMicControlRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showMicControlView$lambda-13$lambda-11$lambda-10  reason: not valid java name */
    public static final void m178showMicControlView$lambda13$lambda11$lambda10(AllOnStagePluginViewPhone allOnStagePluginViewPhone) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPhone, "this$0");
        AllOnStageControlPopup mMicControlPopup = allOnStagePluginViewPhone.getMMicControlPopup();
        if (mMicControlPopup != null) {
            mMicControlPopup.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void showAllowMicControlView() {
        if (getMMicNotAllowPopup() == null) {
            AllOnStagePluginViewPhone allOnStagePluginViewPhone = this;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setMMicNotAllowPopup(new AllOnStageMicHitPopup(context));
            AllOnStageMicHitPopup mMicNotAllowPopup = getMMicNotAllowPopup();
            if (mMicNotAllowPopup != null) {
                AllOnStageMicHitPopup allOnStageMicHitPopup = (AllOnStageMicHitPopup) mMicNotAllowPopup.setOnDismissListener(new AllOnStagePluginViewPhone$$ExternalSyntheticLambda2(this));
            }
        }
        AllOnStageMicHitPopup mMicNotAllowPopup2 = getMMicNotAllowPopup();
        if (mMicNotAllowPopup2 != null && !mMicNotAllowPopup2.isShowing()) {
            mMicNotAllowPopup2.showAtLocation((View) this, 17, 0, 0);
            if (getMMicNotAllowRunnable() == null) {
                setMMicNotAllowRunnable(new AllOnStagePluginViewPhone$$ExternalSyntheticLambda4(this));
            }
            Runnable mMicNotAllowRunnable = getMMicNotAllowRunnable();
            if (mMicNotAllowRunnable != null) {
                getMPopHandler().postDelayed(mMicNotAllowRunnable, 5000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAllowMicControlView$lambda-16$lambda-15  reason: not valid java name */
    public static final void m176showAllowMicControlView$lambda16$lambda15(AllOnStagePluginViewPhone allOnStagePluginViewPhone) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPhone, "this$0");
        Runnable mMicNotAllowRunnable = allOnStagePluginViewPhone.getMMicNotAllowRunnable();
        if (mMicNotAllowRunnable != null) {
            allOnStagePluginViewPhone.getMPopHandler().removeCallbacks(mMicNotAllowRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAllowMicControlView$lambda-20$lambda-18$lambda-17  reason: not valid java name */
    public static final void m177showAllowMicControlView$lambda20$lambda18$lambda17(AllOnStagePluginViewPhone allOnStagePluginViewPhone) {
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPhone, "this$0");
        AllOnStageMicHitPopup mMicNotAllowPopup = allOnStagePluginViewPhone.getMMicNotAllowPopup();
        if (mMicNotAllowPopup != null) {
            mMicNotAllowPopup.dismiss();
        }
    }
}
