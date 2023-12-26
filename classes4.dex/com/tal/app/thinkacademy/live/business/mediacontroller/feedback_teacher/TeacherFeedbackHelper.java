package com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.logan.LoganFileParser;
import com.tal.app.thinkacademy.common.logan.LoganHelper;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/feedback_teacher/TeacherFeedbackHelper;", "", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/live/MediaControlLiveDriver;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/mediacontroller/live/MediaControlLiveDriver;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isDoFeedback", "", "mFeedbackId", "", "mHandler", "Landroid/os/Handler;", "mRunnable", "Ljava/lang/Runnable;", "mSelfUid", "destroy", "", "feedbackUpdate", "result", "postFeedbackSever", "screenUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveIrcMessage", "message", "receiveScreenshotFilePath", "path", "token", "Lcom/tal/app/thinkacademy/live/business/screenshot/ScreenShotToken;", "screenShot", "uploadLog", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherFeedbackHelper.kt */
public final class TeacherFeedbackHelper {
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.FEEDBACK_SCREENSHOT;
    private final Context context;
    private final MediaControlLiveDriver driver;
    /* access modifiers changed from: private */
    public boolean isDoFeedback;
    /* access modifiers changed from: private */
    public String mFeedbackId = "";
    private final Handler mHandler;
    private final Runnable mRunnable;
    private final String mSelfUid;

    public TeacherFeedbackHelper(Context context2, MediaControlLiveDriver mediaControlLiveDriver) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(mediaControlLiveDriver, "driver");
        this.context = context2;
        this.driver = mediaControlLiveDriver;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        this.mSelfUid = userInfoEntity == null ? null : userInfoEntity.getUid();
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mHandler = new Handler(myLooper);
        this.mRunnable = new TeacherFeedbackHelper$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: mRunnable$lambda-0  reason: not valid java name */
    public static final void m335mRunnable$lambda0(TeacherFeedbackHelper teacherFeedbackHelper) {
        Intrinsics.checkNotNullParameter(teacherFeedbackHelper, "this$0");
        XesLog.e(teacherFeedbackHelper.TAG, "截屏超时，重置反馈状态");
        teacherFeedbackHelper.isDoFeedback = false;
        teacherFeedbackHelper.mFeedbackId = "";
    }

    public final void receiveIrcMessage(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "message");
        XesLog.i(this.TAG, Intrinsics.stringPlus("收到信令:", str));
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("studentIds");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = false;
                            break;
                        }
                        int i2 = i + 1;
                        if (Intrinsics.areEqual(optJSONArray.get(i).toString(), this.mSelfUid)) {
                            z = true;
                            break;
                        }
                        i = i2;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    if (!valueOf.booleanValue()) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        valueOf.booleanValue();
                        XesLog.i(this.TAG, "配合教师端反馈内容");
                        if (this.isDoFeedback) {
                            XesLog.e(this.TAG, "当前问题反馈未结束");
                            return;
                        }
                        this.isDoFeedback = true;
                        String optString = optJSONObject.optString("feedbackId");
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"feedbackId\")");
                        this.mFeedbackId = optString;
                        uploadLog();
                        screenShot();
                    }
                }
            }
        } catch (Exception e) {
            this.isDoFeedback = false;
            XesLog.e(this.TAG, Intrinsics.stringPlus("信令解析异常:", e.getMessage()));
        }
    }

    public final void receiveScreenshotFilePath(String str, ScreenShotToken screenShotToken) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(screenShotToken, "token");
        XesLog.i(this.TAG, Intrinsics.stringPlus("收到截屏回调:", str));
        if ((this.mFeedbackId.length() == 0) || !Intrinsics.areEqual(screenShotToken.getExtra(), this.mFeedbackId)) {
            XesLog.e(this.TAG, Intrinsics.stringPlus("截屏超时,feedbackId:", screenShotToken.getExtra()));
            return;
        }
        this.mHandler.removeCallbacks(this.mRunnable);
        AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        awsS3Util.uploadFile(applicationContext, AwsS3Util.scene_class_feedback, this.mSelfUid + '_' + System.currentTimeMillis() + ".jpg", str, (AwsS3Util.SingleTransferListener) new TeacherFeedbackHelper$receiveScreenshotFilePath$1(this));
    }

    /* access modifiers changed from: private */
    public final void feedbackUpdate(String str) {
        if (str.length() == 0) {
            this.isDoFeedback = false;
            return;
        }
        LifecycleOwner lifecycleOwner = this.context;
        if (lifecycleOwner instanceof FragmentActivity) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((FragmentActivity) lifecycleOwner), new HandlerException(new TeacherFeedbackHelper$feedbackUpdate$1(this)), (CoroutineStart) null, new TeacherFeedbackHelper$feedbackUpdate$2(this, str, (Continuation<? super TeacherFeedbackHelper$feedbackUpdate$2>) null), 2, (Object) null);
        } else {
            XesLog.e(this.TAG, "反馈失败，不是 FragmentActivity");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:22:0x007d, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object postFeedbackSever(java.lang.String r9, kotlin.coroutines.Continuation<java.lang.Object> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper$postFeedbackSever$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper$postFeedbackSever$1 r0 = (com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper$postFeedbackSever$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper$postFeedbackSever$1 r0 = new com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper$postFeedbackSever$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0080
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0073
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData r10 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mLiveRoomData
            if (r10 != 0) goto L_0x0047
            r10 = r3
            goto L_0x004b
        L_0x0047:
            java.lang.String r10 = r10.getPlanId()
        L_0x004b:
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.String r6 = "api/classroom/v1/teacher/feedbackUpdate"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r6)
            com.tal.app.thinkacademy.live.business.mediacontroller.bean.ScreenshotFeedbackBody r6 = new com.tal.app.thinkacademy.live.business.mediacontroller.bean.ScreenshotFeedbackBody
            java.lang.String r7 = r8.mFeedbackId
            r6.<init>(r10, r7, r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.mediacontroller.api.MediaControlApi> r10 = com.tal.app.thinkacademy.live.business.mediacontroller.api.MediaControlApi.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.network.Api.create(r10)
            com.tal.app.thinkacademy.live.business.mediacontroller.api.MediaControlApi r10 = (com.tal.app.thinkacademy.live.business.mediacontroller.api.MediaControlApi) r10
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r10.pcScreenshotFeedBack(r2, r6, r0)
            if (r10 != r1) goto L_0x0073
            return r1
        L_0x0073:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x0080
            return r1
        L_0x0080:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper.postFeedbackSever(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void screenShot() {
        this.driver.screenShot(ScreenShotToken.TEACH_FEEDBACK.extra(this.mFeedbackId));
        this.mHandler.postDelayed(this.mRunnable, 3000);
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

    public final void destroy() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }
}
