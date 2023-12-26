package com.tal.app.thinkacademy.business.home.main;

import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J'\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0002\u0010\u0012J'\u0010\u0013\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000b¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/LaunchTrack;", "", "()V", "appLaunch", "", "duration", "", "clickDialog", "mode", "", "button", "", "getTime", "", "hw_class_reminder_close_click", "lessonId", "lessonType", "popPosition", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "hw_class_reminder_enter_click", "hw_class_reminder_show", "(Ljava/lang/Integer;Ljava/lang/String;)V", "lesson_report_tips_click", "planId", "lesson_report_tips_show", "showDialog", "tabClick", "name", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LaunchTrack.kt */
public final class LaunchTrack {
    public static final LaunchTrack INSTANCE = new LaunchTrack();

    private LaunchTrack() {
    }

    public final void appLaunch(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_launch_duration", getTime(j));
            HwTrackUtil.INSTANCE.track("hw_app_start", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final double getTime(long j) {
        try {
            BigDecimal divide = BigDecimal.valueOf(j).divide(BigDecimal.valueOf(1000), 3, 4);
            if (divide.doubleValue() <= 0.0d) {
                divide = BigDecimal.ZERO;
            }
            return divide.doubleValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return -1.0d;
        }
    }

    public final void showDialog(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("notice_content", i);
            HwTrackUtil.INSTANCE.track("notice_pop_pv", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void clickDialog(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "button");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("notice_content", i);
            jSONObject.put("button_name", str);
            HwTrackUtil.INSTANCE.track("notice_pop_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void tabClick(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tab_name", str);
            HwTrackUtil.INSTANCE.track("hw_tab_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_class_reminder_show(Integer num, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lesson_id", num);
            jSONObject.put("lesson_type", str);
            HwTrackUtil.INSTANCE.track("hw_class_reminder_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_class_reminder_close_click(Integer num, String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "popPosition");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lesson_id", num);
            jSONObject.put("lesson_type", str);
            jSONObject.put("pop_position_name", str2);
            HwTrackUtil.INSTANCE.track("hw_class_reminder_close_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_class_reminder_enter_click(Integer num, String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "popPosition");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lesson_id", num);
            jSONObject.put("lesson_type", str);
            jSONObject.put("pop_position_name", str2);
            HwTrackUtil.INSTANCE.track("hw_class_reminder_enter_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void lesson_report_tips_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.PLANID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            HwTrackUtil.INSTANCE.track("lesson_report_tips_show", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void lesson_report_tips_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.PLANID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plan_id", str);
            HwTrackUtil.INSTANCE.track("lesson_report_tips_click", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
