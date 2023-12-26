package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b$\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJI\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0012JH\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bJ\u001a\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006J\u0010\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u0004J\u0010\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u000bJ\u001e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bJ\u0006\u00101\u001a\u00020\u0004J0\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u000bJ\u001e\u00108\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bJH\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u0002042\u0006\u0010;\u001a\u0002042\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u000b2\u0006\u00105\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010>\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bJ0\u0010?\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u000b2\u0006\u0010@\u001a\u00020\u0006J8\u0010A\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u000bJ@\u0010B\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u000b2\u0006\u0010C\u001a\u00020\u000bJ\u0006\u0010D\u001a\u00020\u0004J&\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bJ&\u0010I\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bJ&\u0010J\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bJ&\u0010K\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bJ&\u0010L\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bJ\u0010\u0010M\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010N\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ3\u0010O\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010P\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010Q\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010RJQ\u0010S\u001a\u00020\u00042\b\u0010P\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u00105\u001a\u0004\u0018\u00010\u00062\b\u0010T\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010Q\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010UJ\u0018\u0010V\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010W\u001a\u00020\u000b¨\u0006X"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/StudyTrack;", "", "()V", "PreparePageDetecting", "", "micDetecting", "", "camDetecting", "netDetecting", "classReportClick", "plan_id", "", "classroomCheckin", "event", "lesson_type", "class_id", "pop_type", "click_button", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "coursewareDownload", "planId", "plan_mode", "downloadStartSize", "", "downloadDuration", "coursewareZipSize", "zipUrl", "error", "hw_buy_class_click", "class_type", "hw_buy_class_show", "hw_class_card_click", "class_card_state", "hw_class_detail_pv", "courseType", "hw_class_pv", "hw_contact_teacher_icon_click", "teacher_category", "hw_contact_teacher_icon_show", "hw_contact_teacher_pv", "hw_device_test_click", "hw_device_test_close_click", "hw_device_test_show", "hw_my_courses_pv", "pageSource", "hw_my_courses_recorded_card_click", "recordedClassState", "goodsId", "goodsName", "hw_my_courses_recorded_tab_click", "hw_recorded_course", "isOnClass", "", "course_id", "content_teacher_id", "content_teacher", "hw_recorded_course_detail_pv", "hw_recorded_course_duration", "isComplete", "isPause", "duration", "currentPosition", "hw_recorded_course_enter_click", "hw_recorded_course_heat_map", "content_heat_map", "hw_recorded_course_screenshot", "hw_recorded_course_speed", "speed_value", "hw_time_zone_show", "hw_user_switcher_pop_click", "switcher_tips_type", "account_school_number", "current_class_card_state", "hw_user_switcher_pop_close_click", "hw_user_switcher_pop_show", "hw_user_switcher_tips_click", "hw_user_switcher_tips_show", "learningMaterialClick", "learningMaterialPageShow", "parentClassEnterClick", "package_id", "subPlatformType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "stuClassListClick", "previous_source", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "useCoursewareType", "coursewareType", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyTrack.kt */
public final class StudyTrack {
    public static final StudyTrack INSTANCE = new StudyTrack();

    private StudyTrack() {
    }

    public final void PreparePageDetecting(int i, int i2, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("micDetecting", i);
            jSONObject.put("camDetecting", i2);
            jSONObject.put("netDetecting", i3);
            HwTrackUtil.INSTANCE.track("Stu_PreparePageDetecting", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void coursewareDownload$default(StudyTrack studyTrack, String str, String str2, long j, long j2, long j3, String str3, String str4, int i, Object obj) {
        studyTrack.coursewareDownload(str, str2, j, j2, j3, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4);
    }

    public final void coursewareDownload(String str, String str2, long j, long j2, long j3, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str2, "plan_mode");
        try {
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                jSONObject.put("plan_id", str);
            }
            if (str4 != null) {
                jSONObject.put("error", str4);
            }
            jSONObject.put("plan_mode", str2);
            jSONObject.put("downloadStartSize", j);
            jSONObject.put("downloadDuration", j2);
            jSONObject.put("coursewareZipSize", j3);
            if (str3 != null) {
                jSONObject.put("zipUrl", str3);
            }
            HwTrackUtil.INSTANCE.track("coursewareDownload", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void useCoursewareType(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "coursewareType");
        try {
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                jSONObject.put(LearnMaterialsListActivityKt.PLANID, str);
            }
            jSONObject.put("coursewareType", str2);
            HwTrackUtil.INSTANCE.track("useCoursewareType", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void classroomCheckin$default(StudyTrack studyTrack, String str, Integer num, String str2, String str3, String str4, Integer num2, int i, Object obj) {
        studyTrack.classroomCheckin(str, num, str2, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2);
    }

    public final void classroomCheckin(String str, Integer num, String str2, String str3, String str4, Integer num2) {
        String str5;
        Intrinsics.checkNotNullParameter(str, "event");
        JSONObject jSONObject = new JSONObject();
        if (str4 != null) {
            jSONObject.put("pop_type", str4);
        }
        if (num2 != null) {
            jSONObject.put("click_button", num2.intValue());
        }
        if (str2 != null) {
            jSONObject.put(ClassParamsKt.CLASS_ID, ParseUtils.tryParseInt(str2, 0));
        }
        if (str3 != null) {
            jSONObject.put("plan_id", str3);
        }
        if (num != null && num.intValue() == 0) {
            str5 = "大班";
        } else if (num != null && num.intValue() == 1) {
            str5 = "伪小班";
        } else {
            str5 = (num != null && num.intValue() == 2) ? "真小班" : "";
        }
        jSONObject.put("lesson_type", str5);
        HwTrackUtil.INSTANCE.track(str, jSONObject);
    }

    public final void parentClassEnterClick(String str, Integer num, String str2, Integer num2) {
        Integer num3;
        String str3;
        try {
            JSONObject jSONObject = new JSONObject();
            Integer num4 = null;
            if (str == null) {
                num3 = null;
            } else {
                num3 = StringsKt.toIntOrNull(str);
            }
            jSONObject.put("plan_id", num3);
            jSONObject.put("package_id", num);
            if (str2 != null) {
                num4 = StringsKt.toIntOrNull(str2);
            }
            jSONObject.put(ClassParamsKt.CLASS_ID, num4);
            if (num2 != null) {
                if (num2.intValue() == 1) {
                    str3 = "伪小班";
                    jSONObject.put("lesson_type", str3);
                    HwTrackUtil.INSTANCE.track("hw_parent_class_enter_click", jSONObject);
                }
            }
            if (num2 != null) {
                if (num2.intValue() == 2) {
                    str3 = "小班";
                    jSONObject.put("lesson_type", str3);
                    HwTrackUtil.INSTANCE.track("hw_parent_class_enter_click", jSONObject);
                }
            }
            str3 = "大班";
            jSONObject.put("lesson_type", str3);
            HwTrackUtil.INSTANCE.track("hw_parent_class_enter_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void stuClassListClick(Integer num, Integer num2, Integer num3, String str, Integer num4, String str2, Integer num5) {
        String str3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_id", num);
            jSONObject.put(ClassParamsKt.CLASS_ID, num2);
            jSONObject.put("course_id", num3);
            jSONObject.put("previous_source", str);
            jSONObject.put("plan_id", num4);
            jSONObject.put("plan_mode", str2);
            if (num5 != null) {
                if (num5.intValue() == 1) {
                    str3 = "伪小班";
                    jSONObject.put("lesson_type", str3);
                    HwTrackUtil.INSTANCE.track("hw_stu_class_list_click", jSONObject);
                }
            }
            if (num5 != null) {
                if (num5.intValue() == 2) {
                    str3 = "小班";
                    jSONObject.put("lesson_type", str3);
                    HwTrackUtil.INSTANCE.track("hw_stu_class_list_click", jSONObject);
                }
            }
            str3 = "大班";
            jSONObject.put("lesson_type", str3);
            HwTrackUtil.INSTANCE.track("hw_stu_class_list_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_time_zone_show() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("school_code", ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR));
            jSONObject.put("app_time_zone", TimeZoneUtil.INSTANCE.getAppTimeZone());
            jSONObject.put("device_time_zone", TimeZone.getDefault().getID());
            HwTrackUtil.INSTANCE.track("hw_time_zone_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void hw_my_courses_pv$default(StudyTrack studyTrack, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "无";
        }
        studyTrack.hw_my_courses_pv(str);
    }

    public final void hw_my_courses_pv(String str) {
        Intrinsics.checkNotNullParameter(str, "pageSource");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("page_source", str);
            HwTrackUtil.INSTANCE.track("hw_my_courses_pv", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_my_courses_recorded_tab_click() {
        try {
            HwTrackUtil.INSTANCE.track("hw_my_courses_recorded_tab_click", new JSONObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_my_courses_recorded_card_click(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "goodsId");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("recorded_class_state", i);
            jSONObject.put("goods_id", str);
            jSONObject.put("goods_name", str2);
            HwTrackUtil.INSTANCE.track("hw_my_courses_recorded_card_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_recorded_course_detail_pv(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "goodsId");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("recorded_class_state", i);
            jSONObject.put("goods_id", str);
            jSONObject.put("goods_name", str2);
            HwTrackUtil.INSTANCE.track("hw_recorded_course_detail_pv", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_recorded_course_enter_click(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "goodsId");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("goods_id", str);
            jSONObject.put("goods_name", str2);
            HwTrackUtil.INSTANCE.track("hw_recorded_course_enter_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_recorded_course_duration(boolean z, boolean z2, long j, long j2, int i, String str, int i2, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i4 = 100;
            int i5 = 0;
            int i6 = j > 0 ? (int) ((((long) 100) * j2) / j) : 0;
            if (!z) {
                i4 = i6;
            }
            if (!z2) {
                i5 = 1;
            }
            int i7 = i;
            jSONObject.put("content_teacher_id", i);
            String str2 = str;
            jSONObject.put("content_teacher", str);
            int i8 = i2;
            jSONObject.put("course_id", i2);
            jSONObject.put("plan_id", i3);
            jSONObject.put("rightnow_play_status", i5);
            jSONObject.put("rightnow_play_progress", i4);
            HwTrackUtil.INSTANCE.track("hw_recorded_course_duration", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_recorded_course_heat_map(int i, int i2, int i3, String str, int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("course_id", i);
            jSONObject.put("plan_id", i2);
            jSONObject.put("content_teacher_id", i3);
            jSONObject.put("content_teacher", str);
            jSONObject.put("content_heat_map", i4);
            HwTrackUtil.INSTANCE.track("hw_recorded_course_heat_map", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_recorded_course(boolean z, int i, int i2, int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i4 = z ? 1 : 0;
            jSONObject.put("course_id", i);
            jSONObject.put("plan_id", i2);
            jSONObject.put("content_teacher_id", i3);
            jSONObject.put("content_teacher", str);
            jSONObject.put("play_status", i4);
            HwTrackUtil.INSTANCE.track("hw_recorded_course", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_recorded_course_screenshot(long j, long j2, int i, int i2, int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i4 = 0;
            if (j > 0) {
                i4 = (int) ((j2 * ((long) 100)) / j);
            }
            jSONObject.put("content_teacher_id", i3);
            jSONObject.put("content_teacher", str);
            jSONObject.put("course_id", i);
            jSONObject.put("plan_id", i2);
            jSONObject.put("rightnow_play_progress", i4);
            HwTrackUtil.INSTANCE.track("hw_recorded_course_screenshot", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_recorded_course_speed(long j, long j2, int i, int i2, int i3, String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "speed_value");
        try {
            JSONObject jSONObject = new JSONObject();
            int i4 = 0;
            if (j > 0) {
                i4 = (int) ((j2 * ((long) 100)) / j);
            }
            jSONObject.put("content_teacher_id", i3);
            jSONObject.put("content_teacher", str);
            jSONObject.put("course_id", i);
            jSONObject.put("plan_id", i2);
            jSONObject.put("rightnow_play_progress", i4);
            jSONObject.put("speed_value", str2);
            HwTrackUtil.INSTANCE.track("hw_recorded_course_speed", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void classReportClick(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("plan_id", str);
            } catch (Exception unused) {
            }
        }
        HwTrackUtil.INSTANCE.track("class_report_click", jSONObject);
    }

    public final void learningMaterialClick(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("plan_id", str);
            } catch (Exception unused) {
            }
        }
        HwTrackUtil.INSTANCE.track("learning_material_enter_click", jSONObject);
    }

    public final void learningMaterialPageShow(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("plan_id", str);
            } catch (Exception unused) {
            }
        }
        HwTrackUtil.INSTANCE.track("learning_material_pv", jSONObject);
    }

    public final void hw_device_test_show() {
        try {
            HwTrackUtil.INSTANCE.track("hw_device_test_show", new JSONObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_device_test_close_click() {
        try {
            HwTrackUtil.INSTANCE.track("hw_device_test_close_click", new JSONObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_device_test_click() {
        try {
            HwTrackUtil.INSTANCE.track("hw_device_test_click", new JSONObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_user_switcher_tips_show(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "switcher_tips_type");
        Intrinsics.checkNotNullParameter(str2, "current_class_card_state");
        Intrinsics.checkNotNullParameter(str3, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switcher_tips_type", str);
            jSONObject.put("account_school_number", i);
            jSONObject.put("current_class_card_state", str2);
            jSONObject.put("class_type", str3);
            HwTrackUtil.INSTANCE.track("hw_user_switcher_tips_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_user_switcher_tips_click(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "switcher_tips_type");
        Intrinsics.checkNotNullParameter(str2, "current_class_card_state");
        Intrinsics.checkNotNullParameter(str3, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switcher_tips_type", str);
            jSONObject.put("account_school_number", i);
            jSONObject.put("current_class_card_state", str2);
            jSONObject.put("class_type", str3);
            HwTrackUtil.INSTANCE.track("hw_user_switcher_tips_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_user_switcher_pop_show(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "switcher_tips_type");
        Intrinsics.checkNotNullParameter(str2, "current_class_card_state");
        Intrinsics.checkNotNullParameter(str3, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switcher_tips_type", str);
            jSONObject.put("account_school_number", i);
            jSONObject.put("current_class_card_state", str2);
            jSONObject.put("class_type", str3);
            HwTrackUtil.INSTANCE.track("hw_user_switcher_pop_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_user_switcher_pop_click(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "switcher_tips_type");
        Intrinsics.checkNotNullParameter(str2, "current_class_card_state");
        Intrinsics.checkNotNullParameter(str3, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switcher_tips_type", str);
            jSONObject.put("account_school_number", i);
            jSONObject.put("current_class_card_state", str2);
            jSONObject.put("class_type", str3);
            HwTrackUtil.INSTANCE.track("hw_user_switcher_pop_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_user_switcher_pop_close_click(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "switcher_tips_type");
        Intrinsics.checkNotNullParameter(str2, "current_class_card_state");
        Intrinsics.checkNotNullParameter(str3, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switcher_tips_type", str);
            jSONObject.put("account_school_number", i);
            jSONObject.put("current_class_card_state", str2);
            jSONObject.put("class_type", str3);
            HwTrackUtil.INSTANCE.track("hw_user_switcher_pop_close_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_buy_class_show(String str) {
        Intrinsics.checkNotNullParameter(str, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("class_type", str);
            HwTrackUtil.INSTANCE.track("hw_buy_class_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_buy_class_click(String str) {
        Intrinsics.checkNotNullParameter(str, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("class_type", str);
            HwTrackUtil.INSTANCE.track("hw_buy_class_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void hw_class_pv$default(StudyTrack studyTrack, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "直播课";
        }
        studyTrack.hw_class_pv(str);
    }

    public final void hw_class_pv(String str) {
        Intrinsics.checkNotNullParameter(str, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("class_type", str);
            HwTrackUtil.INSTANCE.track("hw_class_pv", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void hw_class_card_click$default(StudyTrack studyTrack, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "直播课";
        }
        studyTrack.hw_class_card_click(str, str2);
    }

    public final void hw_class_card_click(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "class_card_state");
        Intrinsics.checkNotNullParameter(str2, "class_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("class_card_state", str);
            jSONObject.put("class_type", str2);
            HwTrackUtil.INSTANCE.track("hw_class_card_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_class_detail_pv(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("course_category", i);
            HwTrackUtil.INSTANCE.track("hw_class_detail_pv", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_contact_teacher_icon_show(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("teacher_category", i);
            HwTrackUtil.INSTANCE.track("hw_contact_teacher_icon_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_contact_teacher_icon_click(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("teacher_category", i);
            HwTrackUtil.INSTANCE.track("hw_contact_teacher_icon_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_contact_teacher_pv(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("teacher_category", i);
            HwTrackUtil.INSTANCE.track("hw_contact_teacher_pv", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
