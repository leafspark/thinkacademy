package com.tal.app.thinkacademy.common.appmonitor;

import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b7\u0018\u0000 S2\u00020\u0001:\u0002STB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\u0006J\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tJf\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aJ6\u0010&\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001aJ\u000e\u0010)\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tJ\u001e\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u001eJ\u0016\u0010.\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001aJ\u0016\u00100\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001aJ\u001e\u00101\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\u001aJ\u000e\u00104\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\tJ\u0016\u00105\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u0016\u00106\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u00107\u001a\u00020\tJ\u0016\u00108\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001aJ\u0016\u00109\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001aJ\u001e\u0010:\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ-\u0010<\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010?J\u000e\u0010@\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010A\u001a\u00020\u0006J\u000e\u0010B\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tJ&\u0010C\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tJ\u0006\u0010G\u001a\u00020\u0006J\u000e\u0010H\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010I\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tJ\u001e\u0010J\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aJ\u000e\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\tJ\u0016\u0010M\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u001eJ\u000e\u0010O\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\tJ\u000e\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0004J\u000e\u0010R\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/tal/app/thinkacademy/common/appmonitor/HWEventTracking;", "", "()V", "mCourseData", "Lcom/tal/app/thinkacademy/common/appmonitor/HWEventTracking$CourseData;", "clearCourse", "", "commonTrack", "eventName", "", "jsonObject", "Lorg/json/JSONObject;", "ostaAppBackground", "action", "ostaAppNotFocused", "ostaCbInputCooling", "ostaCbSendMsg", "msgType", "contentType", "content", "ostaClassReport", "planId", "ostaDoHomework", "ostaDoPreTest", "ostaEnterClassroom", "timeOffset", "", "classType", "classId", "isParentAudit", "", "isCameraOk", "isMicOk", "networkQuality", "coursewareLocalcacheExit", "coursewareDownloadSize", "coursewareDownloadTime", "startDifference", "ostaEnterPlayback", "endDifference", "ostaExitClassroom", "ostaGroupVideoChange", "ostaIaBaseInteractionSubmit", "interId", "questionType", "isCorrectAnswer", "ostaIaCoins", "coinsCount", "ostaIaCoinshower", "ostaIaGifts", "giftName", "giftCost", "ostaIaGraffitiboardSubmit", "ostaIaOnStage", "ostaIaPhotowallSubmit", "photoUrl", "ostaIaPraise", "ostaIaRedpacket", "ostaIaVideoLink", "from", "ostaIaVoteSubmit", "voteType", "studentAnswer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "ostaLeraningMaterial", "ostaLogin", "ostaNpsExposed", "ostaNpsSubmit", "npsScore", "npsTagIdList", "npsOtherReasonContent", "ostaRaiseHand", "ostaRtcAudioChange", "ostaRtcVidioChange", "ostaSignIn", "ostaUpdateInstall", "newVersion", "ostaUpdateNewVersion", "isForceUpdate", "ostaUpdateSkip", "setCourseProperty", "data", "setGlobalProperties", "Companion", "CourseData", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HWEventTracking.kt */
public final class HWEventTracking {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<HWEventTracking> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, HWEventTracking$Companion$instance$2.INSTANCE);
    private CourseData mCourseData;

    public /* synthetic */ HWEventTracking(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final HWEventTracking get() {
        return Companion.get();
    }

    private HWEventTracking() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/appmonitor/HWEventTracking$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/common/appmonitor/HWEventTracking;", "getInstance", "()Lcom/tal/app/thinkacademy/common/appmonitor/HWEventTracking;", "instance$delegate", "Lkotlin/Lazy;", "get", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HWEventTracking.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final HWEventTracking getInstance() {
            return (HWEventTracking) HWEventTracking.instance$delegate.getValue();
        }

        @JvmStatic
        public final HWEventTracking get() {
            return getInstance();
        }
    }

    public final void ostaLogin() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("description", "用户登录, 登录成功后上报此事件");
            commonTrack("osta_login", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_login 异常:", e.getMessage()));
        }
    }

    public final void ostaUpdateNewVersion(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "newVersion");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("new_version", str);
            jSONObject.put("is_force_update", z);
            jSONObject.put("description", "检查到新版本, 在应用启动后检查到新版本（包含手动更新检查，但不包含不弹窗的静默更新）");
            commonTrack("osta_update_new_version", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_update_new_version 异常:", e.getMessage()));
        }
    }

    public final void ostaUpdateSkip(String str) {
        Intrinsics.checkNotNullParameter(str, "newVersion");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("new_version", str);
            jSONObject.put("description", "跳过新版本, 用户选择跳过新版本");
            commonTrack("osta_update_skip", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_update_skip 异常:", e.getMessage()));
        }
    }

    public final void ostaUpdateInstall(String str) {
        Intrinsics.checkNotNullParameter(str, "newVersion");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("new_version", str);
            jSONObject.put("description", "安装新版本, 用户选择安装新版本");
            commonTrack("osta_update_install", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_update_install 异常:", e.getMessage()));
        }
    }

    public final void ostaDoPreTest(String str) {
        Intrinsics.checkNotNullParameter(str, "planId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            jSONObject.put("description", "打开课前测, 学员打开某一课次的课前测");
            commonTrack("osta_do_pre_test", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_do_pre_test 异常:", e.getMessage()));
        }
    }

    public final void ostaDoHomework(String str) {
        Intrinsics.checkNotNullParameter(str, "planId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            jSONObject.put("description", "打开作业, 学员打开某一课次的作业");
            commonTrack("osta_do_homework", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_do_homework 异常:", e.getMessage()));
        }
    }

    public final void ostaClassReport(String str) {
        Intrinsics.checkNotNullParameter(str, "planId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            jSONObject.put("description", "打开课堂报告, 学员打开某一课次的课后报告");
            commonTrack("osta_class_report", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_class_report 异常:", e.getMessage()));
        }
    }

    public final void ostaLeraningMaterial(String str) {
        Intrinsics.checkNotNullParameter(str, "planId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            jSONObject.put("description", "打开学习资料列表, 学员打开某一课次的学习资料列表");
            commonTrack("osta_leraning_material", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_leraning_material 异常:", e.getMessage()));
        }
    }

    public final void ostaSignIn(String str, Number number, Number number2) {
        Intrinsics.checkNotNullParameter(str, "planId");
        Intrinsics.checkNotNullParameter(number, "coinsCount");
        Intrinsics.checkNotNullParameter(number2, "startDifference");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            jSONObject.put("coins_count", number);
            jSONObject.put("start_difference", number2);
            jSONObject.put("description", "学员签到, 学员点击签到弹窗进行签到时");
            commonTrack("osta_sign_in", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_sign_in 异常:", e.getMessage()));
        }
    }

    public final void ostaEnterClassroom(Number number, String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4, boolean z4, Number number2, Number number3, Number number4) {
        Intrinsics.checkNotNullParameter(number, "timeOffset");
        Intrinsics.checkNotNullParameter(str, "planId");
        Intrinsics.checkNotNullParameter(str2, "classType");
        Intrinsics.checkNotNullParameter(str3, "classId");
        Intrinsics.checkNotNullParameter(str4, "networkQuality");
        Intrinsics.checkNotNullParameter(number2, "coursewareDownloadSize");
        Intrinsics.checkNotNullParameter(number3, "coursewareDownloadTime");
        Intrinsics.checkNotNullParameter(number4, "startDifference");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time_offset", number);
            jSONObject.put("plan_id", str);
            jSONObject.put("class_type", str2);
            jSONObject.put(LeanplumUtil.classId, str3);
            jSONObject.put("is_parent_audit", z);
            jSONObject.put("is_camera_ok", z2);
            jSONObject.put("is_mic_ok", z3);
            jSONObject.put("network_quality", str4);
            jSONObject.put("courseware_localcache_exit", z4);
            jSONObject.put("courseware_download_size", number2);
            jSONObject.put("courseware_download_time", number3);
            jSONObject.put("start_difference", number4);
            jSONObject.put("description", "进入教室, None");
            commonTrack("osta_enter_classroom", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_enter_classroom 异常:", e.getMessage()));
        }
    }

    public final void ostaEnterPlayback(String str, String str2, boolean z, Number number, Number number2, Number number3) {
        Intrinsics.checkNotNullParameter(str, "planId");
        Intrinsics.checkNotNullParameter(str2, "classId");
        Intrinsics.checkNotNullParameter(number, "coursewareDownloadSize");
        Intrinsics.checkNotNullParameter(number2, "coursewareDownloadTime");
        Intrinsics.checkNotNullParameter(number3, "endDifference");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            jSONObject.put(LeanplumUtil.classId, str2);
            jSONObject.put("courseware_localcache_exit", z);
            jSONObject.put("courseware_download_size", number);
            jSONObject.put("courseware_download_time", number2);
            jSONObject.put("end_difference", number3);
            jSONObject.put("description", "进入回放, 下载完课件后进入回放播放器时");
            commonTrack("osta_enter_playback", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_enter_playback 异常:", e.getMessage()));
        }
    }

    public final void ostaRtcAudioChange(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str);
            jSONObject.put("description", "学员音频状态变更, 学员开启或者关闭自己麦克风时");
            commonTrack("osta_rtc_audio_change", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_rtc_audio_change 异常:", e.getMessage()));
        }
    }

    public final void ostaRtcVidioChange(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str);
            jSONObject.put("description", "学员视频状态变更, 学员开启或者关闭自己摄像头时");
            commonTrack("osta_rtc_vidio_change", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_rtc_vidio_change 异常:", e.getMessage()));
        }
    }

    public final void ostaGroupVideoChange(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str);
            jSONObject.put("description", "大班课堂小组视频开关, None");
            commonTrack("osta_group_video_change", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_group_video_change 异常:", e.getMessage()));
        }
    }

    public final void ostaIaVideoLink(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(str2, "from");
        Intrinsics.checkNotNullParameter(str3, "action");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("from", str2);
            jSONObject.put("action", str3);
            jSONObject.put("description", "当前学员被视频连麦（大班）, 当前学员被邀请连麦和结束连麦时");
            commonTrack("osta_ia_video_link", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_video_link 异常:", e.getMessage()));
        }
    }

    public final void ostaIaOnStage(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(str2, "action");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("action", str2);
            jSONObject.put("description", "当前学员被上台, 学员端被邀请上台、下台时（包括老师直接邀请、随机点名、抢答引起的上台三种情况）");
            commonTrack("osta_ia_on_stage", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_on_stage 异常:", e.getMessage()));
        }
    }

    public final void ostaIaVoteSubmit(String str, String str2, String str3, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(str2, "voteType");
        Intrinsics.checkNotNullParameter(str3, "studentAnswer");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("vote_type", str2);
            jSONObject.put("student_answer", str3);
            if (bool != null) {
                jSONObject.put("is_correct_answer", bool.booleanValue());
            }
            jSONObject.put("description", "投票互动-提交答案, 学员点击选择、判断、懂不懂、填空题的答题板的【submit】按钮或者到了限制时间自动提交时。");
            commonTrack("osta_ia_vote_submit", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_vote_submit 异常:", e.getMessage()));
        }
    }

    public final void ostaIaPhotowallSubmit(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(str2, "photoUrl");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("photo_url", str2);
            jSONObject.put("description", "拍照上墙-提交答案, 学员提交照片时");
            commonTrack("osta_ia_photowall_submit", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_photowall_submit 异常:", e.getMessage()));
        }
    }

    public final void ostaIaGraffitiboardSubmit(String str) {
        Intrinsics.checkNotNullParameter(str, "interId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("description", "涂鸦画板-提交答案, 学员在涂鸦画板页面点击【submit】按钮时");
            commonTrack("osta_ia_graffitiboard_submit", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_graffitiboard_submit 异常:", e.getMessage()));
        }
    }

    public final void ostaIaRedpacket(String str, Number number) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(number, "coinsCount");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("coins_count", number);
            jSONObject.put("description", "打开普通红包, 打开普通红包时");
            commonTrack("osta_ia_redpacket", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_redpacket 异常:", e.getMessage()));
        }
    }

    public final void ostaIaCoinshower(String str, Number number) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(number, "coinsCount");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("coins_count", number);
            jSONObject.put("description", "红包雨获取金币, 红包雨结束获得金币时");
            commonTrack("osta_ia_coinshower", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_coinshower 异常:", e.getMessage()));
        }
    }

    public final void ostaIaCoins(String str, Number number) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(number, "coinsCount");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("coins_count", number);
            jSONObject.put("description", "收到金币奖励（定向金币）, 收到发给自己的金币奖励（定向金币）时，如果老师发的定向金币不包含自己，则不上报此事件");
            commonTrack("osta_ia_coins", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_coins 异常:", e.getMessage()));
        }
    }

    public final void ostaIaPraise(String str, Number number) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(number, "coinsCount");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("coins_count", number);
            jSONObject.put("description", "打开完课宝箱, 打开完课宝箱时");
            commonTrack("osta_ia_praise", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_praise 异常:", e.getMessage()));
        }
    }

    public final void ostaIaGifts(String str, String str2, Number number) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(str2, "giftName");
        Intrinsics.checkNotNullParameter(number, "giftCost");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("gift_name", str2);
            jSONObject.put("gift_cost", number);
            jSONObject.put("description", "送礼物互动-赠送老师礼物, 老师发布送礼物互动后赠送老师礼物时（每赠送一个礼物记录一次埋点）");
            commonTrack("osta_ia_gifts", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_gifts 异常:", e.getMessage()));
        }
    }

    public final void ostaIaBaseInteractionSubmit(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "interId");
        Intrinsics.checkNotNullParameter(str2, "questionType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("inter_id", str);
            jSONObject.put("question_type", str2);
            jSONObject.put("is_correct_answer", z);
            jSONObject.put("description", "预置互动题-提交, 提交预置互动题答案后，特殊的，对于填空题和游戏题，是H5回调APP用户作答正确或者错误后");
            commonTrack("osta_ia_base_interaction_submit", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_ia_base_interaction_submit 异常:", e.getMessage()));
        }
    }

    public final void ostaRaiseHand() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("description", "学员举手, 学员举手时");
            commonTrack("osta_raise_hand", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_raise_hand 异常:", e.getMessage()));
        }
    }

    public final void ostaCbSendMsg(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "msgType");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(str3, "content");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg_type", str);
            jSONObject.put("content_type", str2);
            jSONObject.put("content", str3);
            jSONObject.put("description", "Chatbox发送消息, 学员通过chatbox发送聊天消息时");
            commonTrack("osta_cb_send_msg", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_cb_send_msg 异常:", e.getMessage()));
        }
    }

    public final void ostaCbInputCooling() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("description", "Chatbox学员发言冷却, 学员发送消息后触发冷却状态时");
            commonTrack("osta_cb_input_cooling", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_cb_input_cooling 异常:", e.getMessage()));
        }
    }

    public final void ostaAppBackground(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str);
            jSONObject.put("description", "应用进入后台（iOS、Android学员端）, iOS、Android学员端应用在直播教室中时进入后台或者进入前台时");
            commonTrack("osta_app_background", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_app_background 异常:", e.getMessage()));
        }
    }

    public final void ostaAppNotFocused(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str);
            jSONObject.put("description", "窗口失去焦点（PC学员端）, PC学员端应用窗口在直播教室中时失去焦点或者获取焦点时（对应开小差状态）");
            commonTrack("osta_app_not_focused", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_app_not_focused 异常:", e.getMessage()));
        }
    }

    public final void ostaExitClassroom(Number number) {
        Intrinsics.checkNotNullParameter(number, "endDifference");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("end_difference", number);
            jSONObject.put("description", "学员离开直播教室, 学员退出直播教室时");
            commonTrack("osta_exit_classroom", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_exit_classroom 异常:", e.getMessage()));
        }
    }

    public final void ostaNpsExposed(String str) {
        Intrinsics.checkNotNullParameter(str, "planId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            jSONObject.put("description", "NPS弹窗曝光, nps弹窗弹出后上报此事件");
            commonTrack("osta_nps_exposed", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_nps_exposed 异常:", e.getMessage()));
        }
    }

    public final void ostaNpsSubmit(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "planId");
        Intrinsics.checkNotNullParameter(str2, "npsScore");
        Intrinsics.checkNotNullParameter(str3, "npsTagIdList");
        Intrinsics.checkNotNullParameter(str4, "npsOtherReasonContent");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            jSONObject.put("nps_score", str2);
            jSONObject.put("nps_tag_id_list", str3);
            jSONObject.put("nps_other_reason_content", str4);
            jSONObject.put("description", "NPS提交, 用户填写nps弹窗后上报此事件");
            commonTrack("osta_nps_submit", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.et("课堂教学全埋点", Intrinsics.stringPlus("事件 osta_nps_submit 异常:", e.getMessage()));
        }
    }

    public final void setCourseProperty(CourseData courseData) {
        CourseData courseData2;
        CourseData courseData3;
        CourseData courseData4;
        Intrinsics.checkNotNullParameter(courseData, "data");
        if (this.mCourseData == null) {
            this.mCourseData = courseData;
            return;
        }
        HWEventTracking hWEventTracking = this;
        CharSequence planId = courseData.getPlanId();
        boolean z = false;
        HWEventTracking hWEventTracking2 = null;
        if (!(((planId == null || planId.length() == 0) ^ true ? this : null) == null || (courseData4 = this.mCourseData) == null)) {
            courseData4.setPlanId(courseData.getPlanId());
        }
        CharSequence classId = courseData.getClassId();
        if (!(((classId == null || classId.length() == 0) ^ true ? this : null) == null || (courseData3 = this.mCourseData) == null)) {
            courseData3.setClassId(courseData.getClassId());
        }
        CharSequence classType = courseData.getClassType();
        if (classType == null || classType.length() == 0) {
            z = true;
        }
        if (!z) {
            hWEventTracking2 = this;
        }
        if (!(hWEventTracking2 == null || (courseData2 = this.mCourseData) == null)) {
            courseData2.setClassType(courseData.getClassType());
        }
        CourseData courseData5 = this.mCourseData;
        if (courseData5 != null) {
            courseData5.setTimeOffset(courseData.getTimeOffset());
        }
    }

    public final void clearCourse() {
        this.mCourseData = null;
    }

    public final void setGlobalProperties(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        CourseData courseData = this.mCourseData;
        if (courseData != null) {
            CharSequence planId = courseData.getPlanId();
            boolean z = false;
            CourseData courseData2 = null;
            if (((planId == null || planId.length() == 0) ^ true ? courseData : null) != null) {
                jSONObject.put("plan_id", courseData.getPlanId());
            }
            CharSequence classId = courseData.getClassId();
            if (((classId == null || classId.length() == 0) ^ true ? courseData : null) != null) {
                jSONObject.put(LeanplumUtil.classId, courseData.getClassId());
            }
            CharSequence classType = courseData.getClassType();
            if (classType == null || classType.length() == 0) {
                z = true;
            }
            if (!z) {
                courseData2 = courseData;
            }
            if (courseData2 != null) {
                jSONObject.put("class_type", courseData.getClassType());
            }
            Long timeOffset = courseData.getTimeOffset();
            if (timeOffset != null) {
                jSONObject.put("time_offset", timeOffset.longValue());
            }
        }
    }

    private final void commonTrack(String str, JSONObject jSONObject) {
        HwTrackUtil.INSTANCE.track(str, jSONObject);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/appmonitor/HWEventTracking$CourseData;", "", "()V", "classId", "", "getClassId", "()Ljava/lang/String;", "setClassId", "(Ljava/lang/String;)V", "classType", "getClassType", "setClassType", "planId", "getPlanId", "setPlanId", "timeOffset", "", "getTimeOffset", "()Ljava/lang/Long;", "setTimeOffset", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HWEventTracking.kt */
    public static final class CourseData {
        private String classId = "";
        private String classType = "";
        private String planId = "";
        private Long timeOffset;

        public final String getPlanId() {
            return this.planId;
        }

        public final void setPlanId(String str) {
            this.planId = str;
        }

        public final String getClassId() {
            return this.classId;
        }

        public final void setClassId(String str) {
            this.classId = str;
        }

        public final String getClassType() {
            return this.classType;
        }

        public final void setClassType(String str) {
            this.classType = str;
        }

        public final Long getTimeOffset() {
            return this.timeOffset;
        }

        public final void setTimeOffset(Long l) {
            this.timeOffset = l;
        }
    }
}
