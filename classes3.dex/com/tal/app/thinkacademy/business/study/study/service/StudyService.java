package com.tal.app.thinkacademy.business.study.study.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.SwitchType;
import com.tal.app.thinkacademy.business.study.study.Tag;
import com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi;
import com.tal.app.thinkacademy.business.study.study.dialog.AssignmentDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.ClassinDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.EnterTipsDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.OfflineClassFaceRoomDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.OfflineClassRoomDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.ThinkLiveDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.ThinkhubDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.ZoomDialog;
import com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity;
import com.tal.app.thinkacademy.business.study.study.entity.CalendarItem;
import com.tal.app.thinkacademy.business.study.study.entity.ClassIn;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.LessonDetails;
import com.tal.app.thinkacademy.business.study.study.entity.MaterialEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Offline;
import com.tal.app.thinkacademy.business.study.study.entity.RecordHomework;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.business.study.study.entity.TeachMethodEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Teacher;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.business.study.study.entity.ThinkHub;
import com.tal.app.thinkacademy.business.study.study.entity.ThinkLive;
import com.tal.app.thinkacademy.business.study.study.entity.Zoom;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivity;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBackActivity;
import com.tal.app.thinkacademy.business.study.study.ready.BeforeClassLiveActivity;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.business.study.study.speaker.ContactInformationActivity;
import com.tal.app.thinkacademy.business.study.study.speaker.OutsideOfClassType;
import com.tal.app.thinkacademy.business.study.study.speaker.PreviewQuestionActivity;
import com.tal.app.thinkacademy.business.study.study.vodplayer.VodPlayerDataHolder;
import com.tal.app.thinkacademy.business.studycenter.databinding.DialogNotifacationTipBinding;
import com.tal.app.thinkacademy.common.ApiUrl;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.view.BrowserActivity;
import com.tal.app.thinkacademy.common.entity.Header;
import com.tal.app.thinkacademy.common.entity.SwitchData;
import com.tal.app.thinkacademy.common.entity.SwitchLogin;
import com.tal.app.thinkacademy.common.flutter.PageToNative;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.ChooseSchoolUtil;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.route.FlutterToModuleService;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.IntentUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\rH\u0002J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0016H\u0002J,\u0010\"\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J\u001a\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\b\u0010\u0015\u001a\u0004\u0018\u00010+H\u0002J\u001c\u0010,\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010-2\b\u0010\u0015\u001a\u0004\u0018\u00010+H\u0002¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/service/StudyService;", "Lcom/tal/app/thinkacademy/lib/route/FlutterToModuleService;", "()V", "enterLiveRoom", "", "item", "Lcom/tal/app/thinkacademy/business/study/study/entity/CalendarItem;", "isParentAudit", "", "enterPlaybackRoom", "goToLearnMaterial", "gotoAssignment", "map", "", "gotoExamNoteActivity", "jumpParamsEntity", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "gotoPreviewQuestion", "gotoSwitch", "switchType", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "data", "", "init", "context", "Landroid/content/Context;", "jumpHomework", "onEvent", "eventKey", "", "onRoute", "routeKey", "showClassType", "msg", "showDialog", "list", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "hasCourse", "currentTab", "showNotificationDialog", "switchAccount", "currentActivity", "Lcom/tal/app/thinkacademy/common/base/XesBaseActivity;", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsEntity;", "switchSchool", "Landroid/app/Activity;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyService.kt */
public final class StudyService implements FlutterToModuleService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudyService.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SwitchType.values().length];
            iArr[SwitchType.Account.ordinal()] = 1;
            iArr[SwitchType.School.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void init(Context context) {
        Class<?> cls;
        XesLogTag xesLogTag = Tag.StudyPageFragment;
        Object[] objArr = new Object[1];
        String str = null;
        if (!(context == null || (cls = context.getClass()) == null)) {
            str = cls.getName();
        }
        objArr[0] = Intrinsics.stringPlus("SwitchDialogService init ", str);
        XesLog.i(xesLogTag, objArr);
    }

    public void onEvent(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "eventKey");
        switch (str.hashCode()) {
            case -1203680369:
                if (str.equals("openPushNotification")) {
                    showNotificationDialog();
                    return;
                }
                return;
            case -657805327:
                if (str.equals("dialogSwitchAccount")) {
                    gotoSwitch(SwitchType.Account, obj);
                    return;
                }
                return;
            case -651001259:
                if (str.equals("showClassType")) {
                    showClassType(obj);
                    return;
                }
                return;
            case 2018274608:
                if (str.equals("dialogSwitchSchool")) {
                    gotoSwitch(SwitchType.School, obj);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void showNotificationDialog() {
        TextView textView;
        TextView textView2;
        BaseDialog dimAmount;
        BaseDialog offset;
        BaseDialog layoutParams;
        Activity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
        if (currentActivity instanceof BrowserActivity) {
            currentActivity = XesActivityManager.Companion.getInstance().getSecondTopActivity();
        }
        if (currentActivity != null) {
            int i = ShareDataManager.getInstance().getInt("version_code", 0, ShareDataManager.SHAREDATA_NOT_CLEAR);
            int appVersionCode = AppUtils.getAppVersionCode();
            boolean areNotificationsEnabled = NotificationManagerCompat.from(currentActivity).areNotificationsEnabled();
            if (appVersionCode > i && !areNotificationsEnabled) {
                StudyService$showNotificationDialog$1$mNotificationDialog$1 studyService$showNotificationDialog$1$mNotificationDialog$1 = new StudyService$showNotificationDialog$1$mNotificationDialog$1(currentActivity);
                BaseDialog gravity = studyService$showNotificationDialog$1$mNotificationDialog$1.gravity(80);
                if (!(gravity == null || (dimAmount = gravity.dimAmount(0.2f)) == null || (offset = dimAmount.offset(0, SizeUtils.dp2px(40.0f))) == null || (layoutParams = offset.layoutParams(new LinearLayout.LayoutParams(-1, -2))) == null)) {
                    layoutParams.canceledOnTouchOutside(true);
                }
                DialogNotifacationTipBinding dialogNotifacationTipBinding = studyService$showNotificationDialog$1$mNotificationDialog$1.binding;
                if (!(dialogNotifacationTipBinding == null || (textView2 = dialogNotifacationTipBinding.tvCancel) == null)) {
                    textView2.setOnClickListener(new StudyService$$ExternalSyntheticLambda1(studyService$showNotificationDialog$1$mNotificationDialog$1));
                }
                DialogNotifacationTipBinding dialogNotifacationTipBinding2 = studyService$showNotificationDialog$1$mNotificationDialog$1.binding;
                if (!(dialogNotifacationTipBinding2 == null || (textView = dialogNotifacationTipBinding2.tvConfirm) == null)) {
                    textView.setOnClickListener(new StudyService$$ExternalSyntheticLambda0(currentActivity, studyService$showNotificationDialog$1$mNotificationDialog$1));
                }
                studyService$showNotificationDialog$1$mNotificationDialog$1.show();
                ShareDataManager.getInstance().put("version_code", appVersionCode, ShareDataManager.SHAREDATA_NOT_CLEAR);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotificationDialog$lambda-2$lambda-0  reason: not valid java name */
    public static final void m457showNotificationDialog$lambda2$lambda0(StudyService$showNotificationDialog$1$mNotificationDialog$1 studyService$showNotificationDialog$1$mNotificationDialog$1, View view) {
        Intrinsics.checkNotNullParameter(studyService$showNotificationDialog$1$mNotificationDialog$1, "$mNotificationDialog");
        studyService$showNotificationDialog$1$mNotificationDialog$1.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotificationDialog$lambda-2$lambda-1  reason: not valid java name */
    public static final void m458showNotificationDialog$lambda2$lambda1(Activity activity, StudyService$showNotificationDialog$1$mNotificationDialog$1 studyService$showNotificationDialog$1$mNotificationDialog$1, View view) {
        Intrinsics.checkNotNullParameter(activity, "$this_run");
        Intrinsics.checkNotNullParameter(studyService$showNotificationDialog$1$mNotificationDialog$1, "$mNotificationDialog");
        IntentUtils.startAppSettings(activity);
        studyService$showNotificationDialog$1$mNotificationDialog$1.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onRoute(String str, Object obj) {
        boolean z;
        Object obj2;
        RecordedCalendarListEntity recordedCalendarListEntity;
        Object obj3;
        RecordHomework recordHomework;
        JumpParamsEntity jumpParamsEntity;
        Intrinsics.checkNotNullParameter(str, "routeKey");
        if (Intrinsics.areEqual((Object) str, (Object) PageToNative.examAfterClass.name())) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) str, (Object) PageToNative.stageExam.name());
        }
        Integer num = null;
        if (z) {
            if (obj != null) {
                try {
                    jumpParamsEntity = (JumpParamsEntity) GsonUtil.getInstance().fromJson(GsonUtil.getInstance().objToJson(obj), JumpParamsEntity.class);
                } catch (Exception unused) {
                    jumpParamsEntity = null;
                }
                if (jumpParamsEntity != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ClassParamsKt.JUMP_PARAMS, jumpParamsEntity);
                    XesRoute.getInstance().navigation("/study/exam_note", bundle);
                }
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) PageToNative.recordStageExam.name())) {
            Map map = obj instanceof Map ? (Map) obj : null;
            if (map != null && (obj3 = map.get(ClassParamsKt.JUMP_PARAMS)) != null) {
                try {
                    recordHomework = (RecordHomework) GsonUtil.getInstance().fromJson(GsonUtil.getInstance().objToJson(obj3), RecordHomework.class);
                } catch (Exception unused2) {
                    recordHomework = null;
                }
                Bundle bundle2 = new Bundle();
                Object obj4 = map.get(ClassParamsKt.EXPIRATION_TIME);
                if (obj4 != null) {
                    bundle2.putString(ClassParamsKt.EXPIRATION_TIME, obj4.toString());
                }
                if (recordHomework != null) {
                    bundle2.putSerializable(ClassParamsKt.JUMP_PARAMS, recordHomework);
                    XesRoute.getInstance().navigation("/study/record_exam_note", bundle2);
                }
            }
        } else {
            int i = 0;
            if (Intrinsics.areEqual((Object) str, (Object) PageToNative.recordRoom.name())) {
                Map map2 = obj instanceof Map ? (Map) obj : null;
                if (map2 != null && (obj2 = map2.get(ClassParamsKt.JUMP_PARAMS)) != null) {
                    try {
                        recordedCalendarListEntity = (RecordedCalendarListEntity) GsonUtil.getInstance().fromJson(obj2.toString(), RecordedCalendarListEntity.class);
                    } catch (Exception unused3) {
                        recordedCalendarListEntity = null;
                    }
                    Bundle bundle3 = new Bundle();
                    Object obj5 = map2.get("resourceIndex");
                    if (obj5 != null) {
                        if (obj5 instanceof Integer) {
                            num = (Integer) obj5;
                        }
                        if (num != null) {
                            i = num.intValue();
                        }
                        bundle3.putInt("resourceIndex", i);
                    }
                    VodPlayerDataHolder.Companion.getInstance().setVodPlayerData(recordedCalendarListEntity);
                    XesRoute.getInstance().navigation("/study/vod_class_player_activity", bundle3);
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) PageToNative.liveRoom.name())) {
                try {
                    if (obj instanceof Map) {
                        String valueOf = String.valueOf(((Map) obj).get("schduleItem"));
                        String valueOf2 = String.valueOf(((Map) obj).get("inClass"));
                        CalendarItem calendarItem = (CalendarItem) GsonUtil.getInstance().fromJson(valueOf, CalendarItem.class);
                        if (Intrinsics.areEqual((Object) valueOf2, (Object) DbParams.GZIP_DATA_EVENT)) {
                            ToastUtils.showShort("您已在该课堂中", new Object[0]);
                            new EnterTipsDialog(XesActivityManager.Companion.getInstance().getCurrentActivity(), new StudyService$onRoute$dialog$1(this, calendarItem)).show();
                            return;
                        }
                        enterLiveRoom$default(this, calendarItem, false, 2, (Object) null);
                    }
                } catch (Exception e) {
                    XesLog.it("", new Object[]{Intrinsics.stringPlus("跳转直播页面失败 = ", e)});
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) PageToNative.playBack.name())) {
                try {
                    if (obj instanceof Map) {
                        enterPlaybackRoom((CalendarItem) GsonUtil.getInstance().fromJson(String.valueOf(((Map) obj).get("schduleItem")), CalendarItem.class));
                    }
                } catch (Exception e2) {
                    XesLog.it("", new Object[]{Intrinsics.stringPlus("跳转回放页面失败 = ", e2)});
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) PageToNative.learnMaterial.name())) {
                try {
                    if (obj instanceof Map) {
                        goToLearnMaterial((CalendarItem) GsonUtil.getInstance().fromJson(String.valueOf(((Map) obj).get("schduleItem")), CalendarItem.class));
                    }
                } catch (Exception e3) {
                    XesLog.it("", new Object[]{Intrinsics.stringPlus("跳转学习资料页面失败 = ", e3)});
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) PageToNative.previewQuestion.name())) {
                try {
                    if (obj instanceof Map) {
                        gotoPreviewQuestion((CalendarItem) GsonUtil.getInstance().fromJson(String.valueOf(((Map) obj).get("schduleItem")), CalendarItem.class));
                    }
                } catch (Exception e4) {
                    XesLog.it("", new Object[]{Intrinsics.stringPlus("跳转学习资料页面失败 = ", e4)});
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) PageToNative.assignment.name())) {
                try {
                    if (obj instanceof Map) {
                        gotoAssignment((Map) obj);
                    }
                } catch (Exception e5) {
                    XesLog.it("", new Object[]{Intrinsics.stringPlus("跳转学习资料页面失败 = ", e5)});
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) PageToNative.teacherContactWay.name())) {
                try {
                    if (obj instanceof Map) {
                        Teacher teacher = (Teacher) GsonUtil.getInstance().fromJson(String.valueOf(((Map) obj).get("teacherItem")), Teacher.class);
                        Activity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
                        if (currentActivity != null) {
                            ContactInformationActivity.Companion.startActivity(currentActivity, teacher);
                        }
                    }
                } catch (Exception e6) {
                    XesLog.it("", new Object[]{Intrinsics.stringPlus("跳转学习资料页面失败 = ", e6)});
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) PageToNative.parentsAttend.name())) {
                try {
                    if (obj instanceof Map) {
                        enterLiveRoom((CalendarItem) GsonUtil.getInstance().fromJson(String.valueOf(((Map) obj).get("schduleItem")), CalendarItem.class), true);
                    }
                } catch (Exception e7) {
                    XesLog.it("", new Object[]{Intrinsics.stringPlus("跳转直播页面失败 = ", e7)});
                }
            }
        }
    }

    private final void gotoExamNoteActivity(JumpParamsEntity jumpParamsEntity) {
        if (jumpParamsEntity != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(ClassParamsKt.JUMP_PARAMS, jumpParamsEntity);
            XesRoute.getInstance().navigation("/study/exam_note", bundle);
        }
    }

    private final void gotoPreviewQuestion(CalendarItem calendarItem) {
        LessonDetails lessonDetails;
        Activity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
        if (calendarItem != null && (lessonDetails = calendarItem.getLessonDetails()) != null) {
            AssignmentEntity previewQuestion = lessonDetails.getPreviewQuestion();
            if ((previewQuestion == null ? null : previewQuestion.getJumpParams()) != null) {
                Integer status = lessonDetails.getPreviewQuestion().getStatus();
                boolean z = false;
                if ((((status != null && status.intValue() == 3) || (status != null && status.intValue() == 4)) || (status != null && status.intValue() == 5)) || (status != null && status.intValue() == 6)) {
                    z = true;
                }
                if (z) {
                    PreviewQuestionActivity.Companion.startActivityWithStatus(currentActivity, lessonDetails.getPreviewQuestion().getJumpParams(), lessonDetails.getPreviewQuestion().getStatus());
                }
            }
        }
    }

    private final void goToLearnMaterial(CalendarItem calendarItem) {
        LessonDetails lessonDetails;
        Integer count;
        Activity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
        if (currentActivity != null && calendarItem != null && (lessonDetails = calendarItem.getLessonDetails()) != null) {
            LearnMaterialsListActivity.Companion companion = LearnMaterialsListActivity.Companion;
            Context context = currentActivity;
            String valueOf = String.valueOf(lessonDetails.getPlanId());
            String valueOf2 = String.valueOf(lessonDetails.getClassId());
            MaterialEntity material = lessonDetails.getMaterial();
            String str = null;
            if (!(material == null || (count = material.getCount()) == null)) {
                str = count.toString();
            }
            companion.startActivity(context, valueOf, valueOf2, str);
        }
    }

    static /* synthetic */ void enterLiveRoom$default(StudyService studyService, CalendarItem calendarItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        studyService.enterLiveRoom(calendarItem, z);
    }

    private final void enterLiveRoom(CalendarItem calendarItem, boolean z) {
        LessonDetails lessonDetails;
        Activity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
        if (calendarItem != null) {
            if (!(!calendarItem.isHeader())) {
                calendarItem = null;
            }
            if (calendarItem != null && (lessonDetails = calendarItem.getLessonDetails()) != null) {
                Map hashMap = new HashMap();
                hashMap.put("lesson_id", lessonDetails.getPlanId());
                hashMap.put("class_attend_type", lessonDetails.getPlatformType());
                CharSequence overseaApi = ImConfig.INSTANCE.getOverseaApi();
                if (!(overseaApi == null || StringsKt.isBlank(overseaApi))) {
                    XesLog.i(Tag.ClassCalendarActivity, new Object[]{"直播跳转下载页"});
                    if (currentActivity != null) {
                        Intent intent = new Intent(currentActivity, BeforeClassLiveActivity.class);
                        intent.putExtra("bizId", lessonDetails.getBizId());
                        intent.putExtra(LearnMaterialsListActivityKt.PLANID, lessonDetails.getPlanId());
                        intent.putExtra("courseId", lessonDetails.getClassId());
                        intent.putExtra("editSuccess", "0");
                        intent.putExtra("subPlatformType", lessonDetails.getSubPlatformType());
                        intent.putExtra("isParentAudit", z);
                        intent.putExtra("lessonType", lessonDetails.getLessonType());
                        intent.putExtra("previousSource", "学习中心二级页");
                        intent.putExtra("isAuditor", lessonDetails.isAudition());
                        intent.putExtra("packageId", "");
                        currentActivity.startActivity(intent);
                        return;
                    }
                    return;
                }
                ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
            }
        }
    }

    private final void enterPlaybackRoom(CalendarItem calendarItem) {
        LessonDetails lessonDetails;
        Activity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
        if (calendarItem != null) {
            if (!(!calendarItem.isHeader())) {
                calendarItem = null;
            }
            if (calendarItem != null && (lessonDetails = calendarItem.getLessonDetails()) != null) {
                Map hashMap = new HashMap();
                hashMap.put("lesson_id", lessonDetails.getPlanId());
                hashMap.put("class_attend_type", lessonDetails.getPlatformType());
                CharSequence overseaApi = ImConfig.INSTANCE.getOverseaApi();
                if (!(overseaApi == null || StringsKt.isBlank(overseaApi))) {
                    XesLog.i(Tag.ClassCalendarActivity, new Object[]{"回放跳转下载页"});
                    if (currentActivity != null) {
                        Intent intent = new Intent(currentActivity, BeforeClassBackActivity.class);
                        intent.putExtra("bizId", lessonDetails.getBizId());
                        intent.putExtra(LearnMaterialsListActivityKt.PLANID, lessonDetails.getPlanId());
                        intent.putExtra("courseId", lessonDetails.getClassId());
                        intent.putExtra("editSuccess", "0");
                        intent.putExtra("isLive", false);
                        intent.putExtra("subPlatformType", lessonDetails.getSubPlatformType());
                        intent.putExtra("lessonType", lessonDetails.getLessonType());
                        intent.putExtra("previousSource", "学习中心二级页");
                        intent.putExtra("packageId", "");
                        currentActivity.startActivity(intent);
                        return;
                    }
                    return;
                }
                ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
            }
        }
    }

    private final void gotoAssignment(Map<?, ?> map) {
        Activity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
        if (!Intrinsics.areEqual((Object) String.valueOf(map.get("expired")), (Object) DbParams.GZIP_DATA_EVENT) || currentActivity == null) {
            jumpHomework(map);
        } else {
            new AssignmentDialog(currentActivity, new StudyService$gotoAssignment$1(this, map)).show();
        }
    }

    /* access modifiers changed from: private */
    public final void jumpHomework(Map<?, ?> map) {
        Bundle bundle = new Bundle();
        bundle.putString("jump_key", String.valueOf(map.get("url")));
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLandscape(PadUtils.isPad(Utils.getApp())).build());
        bundle.putString("homework_id", String.valueOf(map.get("homeworkId")));
        bundle.putString(ClassParamsKt.CLASS_ID, String.valueOf(map.get(LearnMaterialsListActivityKt.CLASSID)));
        bundle.putInt("plan_id", Integer.parseInt(String.valueOf(map.get(LearnMaterialsListActivityKt.PLANID))));
        bundle.putInt("homework_type", Integer.parseInt(String.valueOf(map.get("homework_type"))));
        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
    }

    private final void gotoSwitch(SwitchType switchType, Object obj) {
        Object obj2;
        Object obj3;
        try {
            String str = null;
            Map map = obj instanceof Map ? (Map) obj : null;
            SwitchOptionsList switchOptionsList = (SwitchOptionsList) GsonUtil.getInstance().fromJson(GsonUtil.getInstance().objToJson(map == null ? null : map.get("list")), SwitchOptionsList.class);
            if (map == null) {
                obj2 = null;
            } else {
                obj2 = map.get("hasCourse");
            }
            Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (map == null) {
                obj3 = null;
            } else {
                obj3 = map.get("currentTab");
            }
            if (obj3 instanceof String) {
                str = (String) obj3;
            }
            if (str == null) {
                str = "";
            }
            showDialog(switchType, switchOptionsList, booleanValue, str);
        } catch (Exception e) {
            XesLog.e(Tag.StudyPageFragment, new Object[]{Intrinsics.stringPlus("切换弹窗异常：", e.getMessage())});
        }
    }

    static /* synthetic */ void showDialog$default(StudyService studyService, SwitchType switchType, SwitchOptionsList switchOptionsList, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        studyService.showDialog(switchType, switchOptionsList, z, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        r0 = r19.getAccountList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showDialog(com.tal.app.thinkacademy.business.study.study.SwitchType r18, com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r19, boolean r20, java.lang.String r21) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            com.tal.app.thinkacademy.lib.utils.XesActivityManager$Companion r0 = com.tal.app.thinkacademy.lib.utils.XesActivityManager.Companion
            com.tal.app.thinkacademy.lib.utils.XesActivityManager r0 = r0.getInstance()
            android.app.Activity r0 = r0.getCurrentActivity()
            if (r0 == 0) goto L_0x0118
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r2 = "activity::class.java.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "MainActivity"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r12 = 2
            r13 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default(r1, r2, r3, r12, r13)
            if (r1 == 0) goto L_0x0118
            boolean r1 = r0.isFinishing()
            if (r1 != 0) goto L_0x0118
            boolean r1 = r0.isDestroyed()
            if (r1 == 0) goto L_0x0040
            goto L_0x0118
        L_0x0040:
            r6 = r0
            com.tal.app.thinkacademy.common.base.XesBaseActivity r6 = (com.tal.app.thinkacademy.common.base.XesBaseActivity) r6
            int[] r0 = com.tal.app.thinkacademy.business.study.study.service.StudyService.WhenMappings.$EnumSwitchMapping$0
            int r1 = r18.ordinal()
            r0 = r0[r1]
            r14 = 1
            if (r0 == r14) goto L_0x0079
            if (r0 == r12) goto L_0x0051
            goto L_0x009f
        L_0x0051:
            if (r9 != 0) goto L_0x0055
        L_0x0053:
            r0 = r3
            goto L_0x0060
        L_0x0055:
            java.util.List r0 = r19.getSchoolList()
            if (r0 != 0) goto L_0x005c
            goto L_0x0053
        L_0x005c:
            int r0 = r0.size()
        L_0x0060:
            if (r0 != r14) goto L_0x009f
            android.app.Activity r6 = (android.app.Activity) r6
            if (r9 != 0) goto L_0x0067
            goto L_0x0075
        L_0x0067:
            java.util.List r0 = r19.getSchoolList()
            if (r0 != 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            java.lang.Object r0 = r0.get(r3)
            r13 = r0
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity r13 = (com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity) r13
        L_0x0075:
            r7.switchSchool(r6, r13)
            return
        L_0x0079:
            if (r9 != 0) goto L_0x007d
        L_0x007b:
            r0 = r3
            goto L_0x0088
        L_0x007d:
            java.util.List r0 = r19.getAccountList()
            if (r0 != 0) goto L_0x0084
            goto L_0x007b
        L_0x0084:
            int r0 = r0.size()
        L_0x0088:
            if (r0 != r14) goto L_0x009f
            if (r9 != 0) goto L_0x008d
            goto L_0x009b
        L_0x008d:
            java.util.List r0 = r19.getAccountList()
            if (r0 != 0) goto L_0x0094
            goto L_0x009b
        L_0x0094:
            java.lang.Object r0 = r0.get(r3)
            r13 = r0
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity r13 = (com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity) r13
        L_0x009b:
            r7.switchAccount(r6, r13)
            return
        L_0x009f:
            com.tal.app.thinkacademy.business.study.study.dialog.SwitchDialog r15 = new com.tal.app.thinkacademy.business.study.study.dialog.SwitchDialog
            r5 = r6
            android.content.Context r5 = (android.content.Context) r5
            com.tal.app.thinkacademy.business.study.study.service.StudyService$showDialog$mSwitchDialog$1 r16 = new com.tal.app.thinkacademy.business.study.study.service.StudyService$showDialog$mSwitchDialog$1
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r12 = r5
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.<init>(r12, r13, r8, r0)
            com.tal.app.thinkacademy.business.study.study.service.StudyService$$ExternalSyntheticLambda2 r0 = new com.tal.app.thinkacademy.business.study.study.service.StudyService$$ExternalSyntheticLambda2
            r0.<init>(r8, r9, r10, r11)
            r15.setDismissListener(r0)
            r15.setSwitchOptionsList(r9, r8)
            r15.show()
            com.tal.app.thinkacademy.business.study.study.StudyTrack r0 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            java.lang.String r1 = r18.getAliasName()
            int[] r2 = com.tal.app.thinkacademy.business.study.study.service.StudyService.WhenMappings.$EnumSwitchMapping$0
            int r3 = r18.ordinal()
            r2 = r2[r3]
            if (r2 == r14) goto L_0x00f3
            r3 = 2
            if (r2 != r3) goto L_0x00ed
            if (r9 != 0) goto L_0x00e1
            goto L_0x0101
        L_0x00e1:
            java.util.List r2 = r19.getSchoolList()
            if (r2 != 0) goto L_0x00e8
            goto L_0x0101
        L_0x00e8:
            int r14 = r2.size()
            goto L_0x0101
        L_0x00ed:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00f3:
            if (r9 != 0) goto L_0x00f6
            goto L_0x0101
        L_0x00f6:
            java.util.List r2 = r19.getAccountList()
            if (r2 != 0) goto L_0x00fd
            goto L_0x0101
        L_0x00fd:
            int r14 = r2.size()
        L_0x0101:
            if (r10 == 0) goto L_0x0106
            java.lang.String r2 = "有班级"
            goto L_0x0108
        L_0x0106:
            java.lang.String r2 = "无班级"
        L_0x0108:
            java.lang.String r3 = "live"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0113
            java.lang.String r3 = "直播课"
            goto L_0x0115
        L_0x0113:
            java.lang.String r3 = "录播课"
        L_0x0115:
            r0.hw_user_switcher_pop_show(r1, r14, r2, r3)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.service.StudyService.showDialog(com.tal.app.thinkacademy.business.study.study.SwitchType, com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList, boolean, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-23  reason: not valid java name */
    public static final void m456showDialog$lambda23(SwitchType switchType, SwitchOptionsList switchOptionsList, boolean z, String str) {
        List<SwitchOptionsEntity> accountList;
        List<SwitchOptionsEntity> schoolList;
        Intrinsics.checkNotNullParameter(switchType, "$switchType");
        Intrinsics.checkNotNullParameter(str, "$currentTab");
        StudyTrack studyTrack = StudyTrack.INSTANCE;
        String aliasName = switchType.getAliasName();
        int i = WhenMappings.$EnumSwitchMapping$0[switchType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            if (i != 2) {
                i2 = 0;
            } else if (!(switchOptionsList == null || (schoolList = switchOptionsList.getSchoolList()) == null)) {
                i2 = schoolList.size();
            }
        } else if (!(switchOptionsList == null || (accountList = switchOptionsList.getAccountList()) == null)) {
            i2 = accountList.size();
        }
        studyTrack.hw_user_switcher_pop_close_click(aliasName, i2, z ? "有班级" : "无班级", Intrinsics.areEqual((Object) str, (Object) "live") ? "直播课" : "录播课");
    }

    /* access modifiers changed from: private */
    public final void switchAccount(XesBaseActivity xesBaseActivity, SwitchOptionsEntity switchOptionsEntity) {
        if (!UserInfoBll.Companion.getInstance().isGuest() && switchOptionsEntity != null) {
            XesLog.i(Tag.StudyPageFragment, new Object[]{Intrinsics.stringPlus("切换账号--", switchOptionsEntity.getUid())});
            xesBaseActivity.showLoading();
            Call<HiResponse<UserBean>> switchLoginApi = ((StudyCenterApi) Api.create(ApiUrl.INSTANCE.getBASE_URL(), StudyCenterApi.class)).switchLoginApi(new SwitchLogin(new Header(ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR)), new SwitchData(switchOptionsEntity.getUid())));
            Callback studyService$switchAccount$1$1 = new StudyService$switchAccount$1$1(xesBaseActivity, new StudyService$switchAccount$1$2(xesBaseActivity));
            if (!(switchLoginApi instanceof Call)) {
                switchLoginApi.enqueue(studyService$switchAccount$1$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) switchLoginApi, studyService$switchAccount$1$1);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void switchSchool(Activity activity, SwitchOptionsEntity switchOptionsEntity) {
        if (switchOptionsEntity != null) {
            XesLog.i(Tag.StudyPageFragment, new Object[]{Intrinsics.stringPlus("准备切换分校--", switchOptionsEntity.getUid())});
            ShareDataManager instance = ShareDataManager.getInstance();
            int i = ShareDataManager.SHAREDATA_NOT_CLEAR;
            String str = LiveUrls.SCHOOL_CODE_US;
            if (!Intrinsics.areEqual((Object) instance.getString("school_code", str, i), (Object) switchOptionsEntity.getCode())) {
                XesLog.i(Tag.StudyPageFragment, new Object[]{Intrinsics.stringPlus("开始切换分校--", switchOptionsEntity.getCode())});
                ChooseSchoolUtil chooseSchoolUtil = ChooseSchoolUtil.INSTANCE;
                String code = switchOptionsEntity.getCode();
                if (code == null) {
                    code = str;
                }
                chooseSchoolUtil.updateSchoolInfo(Integer.parseInt(code));
                ChooseSchoolUtil chooseSchoolUtil2 = ChooseSchoolUtil.INSTANCE;
                String code2 = switchOptionsEntity.getCode();
                if (code2 != null) {
                    str = code2;
                }
                chooseSchoolUtil2.changeSchool(Integer.parseInt(str), activity);
            }
        }
    }

    private final void showClassType(Object obj) {
        Object obj2 = obj;
        try {
            if (obj2 instanceof Map) {
                String valueOf = String.valueOf(((Map) obj2).get("teachMethod"));
                Activity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
                TeachMethodEntity teachMethodEntity = (TeachMethodEntity) GsonUtil.getInstance().fromJson(valueOf, TeachMethodEntity.class);
                if (teachMethodEntity != null) {
                    String platformType = teachMethodEntity.getPlatformType();
                    String str = null;
                    if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.ONLINE.getAliasName())) {
                        Context context = currentActivity;
                        ThinkHub thinkHub = teachMethodEntity.getThinkHub();
                        if (thinkHub != null) {
                            str = thinkHub.getPhone();
                        }
                        String str2 = str;
                        TheOutsideEntity theOutsideEntity = r5;
                        TheOutsideEntity theOutsideEntity2 = new TheOutsideEntity((String) null, (String) null, (String) null, (String) null, (String) null, str2, (String) null, (String) null, 223, (DefaultConstructorMarker) null);
                        new ThinkhubDialog(context, theOutsideEntity, new StudyService$showClassType$1$1(currentActivity)).show();
                    } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.OFFLINE.getAliasName())) {
                        Context context2 = currentActivity;
                        Offline offline = teachMethodEntity.getOffline();
                        String venueAddress = offline == null ? null : offline.getVenueAddress();
                        Offline offline2 = teachMethodEntity.getOffline();
                        if (offline2 != null) {
                            str = offline2.getVenuePhone();
                        }
                        new OfflineClassFaceRoomDialog(context2, new TheOutsideEntity((String) null, (String) null, (String) null, (String) null, (String) null, str, venueAddress, (String) null, 159, (DefaultConstructorMarker) null)).show();
                    } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.ZOOM.getAliasName())) {
                        Context context3 = currentActivity;
                        Zoom zoom = teachMethodEntity.getZoom();
                        String id = zoom == null ? null : zoom.getId();
                        Zoom zoom2 = teachMethodEntity.getZoom();
                        String password = zoom2 == null ? null : zoom2.getPassword();
                        Zoom zoom3 = teachMethodEntity.getZoom();
                        if (zoom3 != null) {
                            str = zoom3.getDownloadHref();
                        }
                        String str3 = str;
                        TheOutsideEntity theOutsideEntity3 = r5;
                        TheOutsideEntity theOutsideEntity4 = new TheOutsideEntity(id, password, str3, (String) null, (String) null, (String) null, (String) null, (String) null, 248, (DefaultConstructorMarker) null);
                        new ZoomDialog(context3, theOutsideEntity3, new StudyService$showClassType$1$2(currentActivity)).show();
                    } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.CLASS_IN.getAliasName())) {
                        Context context4 = currentActivity;
                        ClassIn classIn = teachMethodEntity.getClassIn();
                        String downloadHref = classIn == null ? null : classIn.getDownloadHref();
                        ClassIn classIn2 = teachMethodEntity.getClassIn();
                        if (classIn2 != null) {
                            str = classIn2.getHref();
                        }
                        String str4 = str;
                        TheOutsideEntity theOutsideEntity5 = r5;
                        TheOutsideEntity theOutsideEntity6 = new TheOutsideEntity((String) null, (String) null, downloadHref, str4, (String) null, (String) null, (String) null, (String) null, 243, (DefaultConstructorMarker) null);
                        new ClassinDialog(context4, theOutsideEntity5, new StudyService$showClassType$1$3(currentActivity)).show();
                    } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.THINK_LIVE.getAliasName())) {
                        Context context5 = currentActivity;
                        ThinkLive thinkLive = teachMethodEntity.getThinkLive();
                        if (thinkLive != null) {
                            str = thinkLive.getClassroomLink();
                        }
                        new ThinkLiveDialog(context5, new TheOutsideEntity((String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, (String) null, 239, (DefaultConstructorMarker) null), (Function2) null, 4, (DefaultConstructorMarker) null).show();
                    } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.DUAL.getAliasName())) {
                        Context context6 = currentActivity;
                        Offline offline3 = teachMethodEntity.getOffline();
                        String classRoomName = offline3 == null ? null : offline3.getClassRoomName();
                        Offline offline4 = teachMethodEntity.getOffline();
                        if (offline4 != null) {
                            str = offline4.getClassCenterName();
                        }
                        new OfflineClassRoomDialog(context6, new TheOutsideEntity((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, classRoomName, str, 63, (DefaultConstructorMarker) null)).show();
                    }
                }
            }
        } catch (Exception e) {
            XesLog.e(Tag.StudyPageFragment, new Object[]{Intrinsics.stringPlus("进课按钮处理异常 = ", e)});
        }
    }
}
