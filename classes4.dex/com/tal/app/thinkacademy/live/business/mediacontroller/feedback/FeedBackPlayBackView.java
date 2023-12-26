package com.tal.app.thinkacademy.live.business.mediacontroller.feedback;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.common.logan.LoganFileParser;
import com.tal.app.thinkacademy.common.logan.LoganHelper;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFeedbackPlaybackBinding;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.IFeedbackAction;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r*\u0001\u0015\u0018\u0000 &2\u00020\u0001:\u0001&B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\fJ\u0010\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u0012J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/feedback/FeedBackPlayBackView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessFeedbackPlaybackBinding;", "mFeedbackAction", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/live/IFeedbackAction;", "mHandler", "Landroid/os/Handler;", "mIsAllow", "", "mPicPath", "", "mQuestionDesc", "mRunnable", "com/tal/app/thinkacademy/live/business/mediacontroller/feedback/FeedBackPlayBackView$mRunnable$1", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/feedback/FeedBackPlayBackView$mRunnable$1;", "hideLoading", "", "postFeedbackSever", "", "screenUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFeedbackInfo", "sendServer", "setIAction", "action", "setScreenshot", "path", "showLoading", "uploadLog", "uploadScreenshot", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBackPlayBackView.kt */
public final class FeedBackPlayBackView extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.PLAYBACK_FEEDBACK;
    private LiveBusinessFeedbackPlaybackBinding mBinding;
    /* access modifiers changed from: private */
    public IFeedbackAction mFeedbackAction;
    private Handler mHandler;
    private boolean mIsAllow;
    private String mPicPath;
    private String mQuestionDesc;
    private final FeedBackPlayBackView$mRunnable$1 mRunnable;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedBackPlayBackView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedBackPlayBackView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedBackPlayBackView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackPlayBackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsAllow = true;
        this.mPicPath = "";
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRunnable = new FeedBackPlayBackView$mRunnable$1(this);
        LiveBusinessFeedbackPlaybackBinding inflate = LiveBusinessFeedbackPlaybackBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context),this,true)");
        this.mBinding = inflate;
        inflate.feedbackAllow.setOnClickListener(new FeedBackPlayBackView$$ExternalSyntheticLambda1(this));
        this.mBinding.btnCancel.setOnClickListener(new FeedBackPlayBackView$$ExternalSyntheticLambda0(this));
        this.mBinding.btnSend.setOnClickListener(new FeedBackPlayBackView$$ExternalSyntheticLambda2(this));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/feedback/FeedBackPlayBackView$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedBackPlayBackView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m332_init_$lambda0(FeedBackPlayBackView feedBackPlayBackView, View view) {
        Intrinsics.checkNotNullParameter(feedBackPlayBackView, "this$0");
        boolean z = !feedBackPlayBackView.mIsAllow;
        feedBackPlayBackView.mIsAllow = z;
        int i = 0;
        XesLog.i(TAG, Intrinsics.stringPlus("点击是否允许截图 = ", Boolean.valueOf(z)));
        ImageView imageView = feedBackPlayBackView.mBinding.feedbackAllow;
        if (feedBackPlayBackView.mIsAllow) {
            i = R.drawable.icon_live_business_selected_allow;
        }
        imageView.setImageResource(i);
        feedBackPlayBackView.mBinding.btnSend.setEnabled(feedBackPlayBackView.mIsAllow);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m333_init_$lambda1(FeedBackPlayBackView feedBackPlayBackView, View view) {
        Intrinsics.checkNotNullParameter(feedBackPlayBackView, "this$0");
        XesLog.i(TAG, Intrinsics.stringPlus("点击取消 mIsAllow= ", Boolean.valueOf(feedBackPlayBackView.mIsAllow)));
        IFeedbackAction iFeedbackAction = feedBackPlayBackView.mFeedbackAction;
        if (iFeedbackAction != null) {
            iFeedbackAction.dismissPopup();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m334_init_$lambda2(FeedBackPlayBackView feedBackPlayBackView, View view) {
        Intrinsics.checkNotNullParameter(feedBackPlayBackView, "this$0");
        XesLog.i(TAG, Intrinsics.stringPlus("点击发送 mIsAllow = ", Boolean.valueOf(feedBackPlayBackView.mIsAllow)));
        feedBackPlayBackView.sendFeedbackInfo();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setIAction(IFeedbackAction iFeedbackAction) {
        Intrinsics.checkNotNullParameter(iFeedbackAction, "action");
        this.mFeedbackAction = iFeedbackAction;
    }

    public final void setScreenshot(String str) {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (str == null) {
            str = "";
        }
        this.mPicPath = str;
        uploadScreenshot();
    }

    private final void uploadScreenshot() {
        XesLog.i(TAG, Intrinsics.stringPlus("开始上传图片 = ", Boolean.valueOf(this.mIsAllow)));
        StringBuilder sb = new StringBuilder();
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        sb.append(userInfoEntity == null ? null : userInfoEntity.getUid());
        sb.append('_');
        sb.append(System.currentTimeMillis());
        sb.append(".jpg");
        String sb2 = sb.toString();
        AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
        Context applicationContext = getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        awsS3Util.uploadFile(applicationContext, AwsS3Util.scene_class_feedback, sb2, this.mPicPath, (AwsS3Util.SingleTransferListener) new FeedBackPlayBackView$uploadScreenshot$1(this));
    }

    private final void sendFeedbackInfo() {
        showLoading();
        this.mQuestionDesc = this.mBinding.questionDesc.getText().toString();
        if (this.mIsAllow) {
            this.mHandler.postDelayed(this.mRunnable, 5000);
            IFeedbackAction iFeedbackAction = this.mFeedbackAction;
            if (iFeedbackAction != null) {
                iFeedbackAction.feedbackScreenshot();
            }
        } else {
            sendServer((String) null);
        }
        uploadLog();
    }

    private final void uploadLog() {
        String str;
        String str2 = null;
        if (LiveTrackData.mLiveRoomData != null) {
            LiveRoomData liveRoomData = LiveTrackData.mLiveRoomData;
            String planId = liveRoomData == null ? null : liveRoomData.getPlanId();
            LiveRoomData liveRoomData2 = LiveTrackData.mLiveRoomData;
            String subPlatformType = liveRoomData2 == null ? null : liveRoomData2.getSubPlatformType();
            if (subPlatformType != null) {
                switch (subPlatformType.hashCode()) {
                    case 48:
                        if (subPlatformType.equals(EnterRoomMuteData.STATUS_UN_MUTE)) {
                            str2 = "大班";
                            break;
                        }
                        break;
                    case 49:
                        if (subPlatformType.equals("1")) {
                            str2 = "伪小班";
                            break;
                        }
                        break;
                    case 50:
                        if (subPlatformType.equals("2")) {
                            str2 = "小班";
                            break;
                        }
                        break;
                }
            }
            String str3 = str2;
            str2 = planId;
            str = str3;
        } else {
            str = null;
        }
        Application app = Utils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "getApp()");
        LoganHelper.newFileWithUpload(app, LoganFileParser.generateExtra(str2, LiveTrackData.mPlanMode, str));
    }

    /* access modifiers changed from: private */
    public final void sendServer(String str) {
        if (getContext() instanceof FragmentActivity) {
            LifecycleOwner context = getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((FragmentActivity) context), new HandlerException(new FeedBackPlayBackView$sendServer$1(this)), (CoroutineStart) null, new FeedBackPlayBackView$sendServer$2(this, str, (Continuation<? super FeedBackPlayBackView$sendServer$2>) null), 2, (Object) null);
            return;
        }
        XesLog.e(TAG, "反馈失败，不是 FragmentActivity");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8 A[PHI: r1 
      PHI: (r1v2 java.lang.Object) = (r1v5 java.lang.Object), (r1v1 java.lang.Object) binds: [B:33:0x00b5, B:10:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object postFeedbackSever(java.lang.String r19, kotlin.coroutines.Continuation<java.lang.Object> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView$postFeedbackSever$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView$postFeedbackSever$1 r2 = (com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView$postFeedbackSever$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView$postFeedbackSever$1 r2 = new com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView$postFeedbackSever$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x0044
            if (r4 == r7) goto L_0x003b
            if (r4 != r6) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00b8
        L_0x0033:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003b:
            java.lang.Object r4 = r2.L$0
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00ab
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.Integer r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mClassId
            if (r1 != 0) goto L_0x004d
            r1 = 0
            goto L_0x0051
        L_0x004d:
            int r1 = r1.intValue()
        L_0x0051:
            long r13 = (long) r1
            com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mLiveRoomData
            if (r1 != 0) goto L_0x0058
            r1 = r5
            goto L_0x005c
        L_0x0058:
            java.lang.String r1 = r1.getPlanId()
        L_0x005c:
            r8 = 0
            long r11 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseLong(r1, r8)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r1 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r1 = r1.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r1 = r1.getUserInfoEntity()
            java.lang.String r4 = ""
            if (r1 != 0) goto L_0x0073
        L_0x0070:
            r16 = r4
            goto L_0x007c
        L_0x0073:
            java.lang.String r1 = r1.getNickName()
            if (r1 != 0) goto L_0x007a
            goto L_0x0070
        L_0x007a:
            r16 = r1
        L_0x007c:
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r1 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r1 = r1.getBASE_URL()
            java.lang.String r4 = "api/playback/feedback"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r4)
            com.tal.app.thinkacademy.live.business.mediacontroller.bean.FeedBackPlaybackBody r4 = new com.tal.app.thinkacademy.live.business.mediacontroller.bean.FeedBackPlaybackBody
            r9 = 0
            java.lang.String r15 = r0.mQuestionDesc
            r17 = 0
            r8 = r4
            r10 = r19
            r8.<init>(r9, r10, r11, r13, r15, r16, r17)
            com.tal.app.thinkacademy.common.network.NetData r8 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.mediacontroller.api.MediaControlApi> r9 = com.tal.app.thinkacademy.live.business.mediacontroller.api.MediaControlApi.class
            java.lang.Object r9 = com.tal.app.thinkacademy.lib.network.Api.create(r9)
            com.tal.app.thinkacademy.live.business.mediacontroller.api.MediaControlApi r9 = (com.tal.app.thinkacademy.live.business.mediacontroller.api.MediaControlApi) r9
            r2.L$0 = r8
            r2.label = r7
            java.lang.Object r1 = r9.postPlaybackFeedBack(r1, r4, r2)
            if (r1 != r3) goto L_0x00aa
            return r3
        L_0x00aa:
            r4 = r8
        L_0x00ab:
            com.tal.app.thinkacademy.lib.restful.HiResponse r1 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r1
            r2.L$0 = r5
            r2.label = r6
            java.lang.Object r1 = r4.transform(r1, r2)
            if (r1 != r3) goto L_0x00b8
            return r3
        L_0x00b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView.postFeedbackSever(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object postFeedbackSever$default(FeedBackPlayBackView feedBackPlayBackView, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return feedBackPlayBackView.postFeedbackSever(str, continuation);
    }

    private final void showLoading() {
        try {
            if (getContext() instanceof XesBaseActivity) {
                Context context = getContext();
                if (context != null) {
                    ((XesBaseActivity) context).showLoading();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tal.app.thinkacademy.common.base.XesBaseActivity");
            }
        } catch (Exception e) {
            XesLog.e(TAG, Intrinsics.stringPlus("showLoading 失败=", e));
        }
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        try {
            if (getContext() instanceof XesBaseActivity) {
                Context context = getContext();
                if (context != null) {
                    ((XesBaseActivity) context).hideLoading();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tal.app.thinkacademy.common.base.XesBaseActivity");
            }
        } catch (Exception e) {
            XesLog.e(TAG, Intrinsics.stringPlus("hideLoading 失败=", e));
        }
    }
}
