package com.tal.app.thinkacademy.business.login.business;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001e\u001a\u00020\u0004¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/business/LoginTrack;", "", "()V", "addStudentPageShow", "", "addStudentResult", "is_success", "", "new_stu_id", "", "changeStudentAccountClick", "clickBanner", "id", "", "hw_delete_account_click", "hw_time_zone_list_click", "hw_time_zone_search_click", "hw_time_zone_search_result_click", "hw_time_zone_switch_click", "personalInfoPageShow", "registerPupPv", "source", "savePersonalInfoResult", "showBanner", "signInClick", "accountType", "registerType", "sign_status", "switchSchoolPopClick", "school", "switchSchoolPopShow", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoginTrack.kt */
public final class LoginTrack {
    public static final LoginTrack INSTANCE = new LoginTrack();

    private LoginTrack() {
    }

    public final void registerPupPv(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("previous_source", str);
        } catch (Exception unused) {
        }
        HwTrackUtil.INSTANCE.track("register_pup_pv", jSONObject);
    }

    public final void signInClick(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "accountType");
        Intrinsics.checkNotNullParameter(str2, "registerType");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account_type", str);
            jSONObject.put("previous_source", "弹窗");
            jSONObject.put("register_type", str2);
            jSONObject.put("sign_status", i);
        } catch (Exception unused) {
        }
        HwTrackUtil.INSTANCE.track("sign_in_click", jSONObject);
    }

    public final void showBanner(long j) {
        try {
            HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad_name", "个人中心-老带新");
            jSONObject.put("channel_id", "");
            jSONObject.put("ad_id", j);
            Unit unit = Unit.INSTANCE;
            hwTrackUtil.track("ad_show", jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void clickBanner(long j) {
        try {
            HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad_name", "个人中心资源位");
            jSONObject.put("channel_id", "");
            jSONObject.put("ad_id", j);
            Unit unit = Unit.INSTANCE;
            hwTrackUtil.track("ad_click", jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void switchSchoolPopShow() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("previous_source", "个人中心设置页");
            HwTrackUtil.INSTANCE.track("hw_switch_school_pop_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void switchSchoolPopClick(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
                str = "";
            }
            jSONObject.put("switch_content", str);
            jSONObject.put("previous_source", "个人中心设置页");
            HwTrackUtil.INSTANCE.track("hw_switch_school_pop_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_time_zone_switch_click() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("school_code", ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR));
            jSONObject.put("app_time_zone", TimeZoneUtil.INSTANCE.getAppTimeZone());
            jSONObject.put("device_time_zone", TimeZone.getDefault().getID());
            HwTrackUtil.INSTANCE.track("hw_time_zone_switch_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_time_zone_search_click() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("school_code", ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR));
            jSONObject.put("app_time_zone", TimeZoneUtil.INSTANCE.getAppTimeZone());
            jSONObject.put("device_time_zone", TimeZone.getDefault().getID());
            HwTrackUtil.INSTANCE.track("hw_time_zone_search_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_time_zone_search_result_click() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("school_code", ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR));
            jSONObject.put("app_time_zone", TimeZoneUtil.INSTANCE.getAppTimeZone());
            jSONObject.put("device_time_zone", TimeZone.getDefault().getID());
            HwTrackUtil.INSTANCE.track("hw_time_zone_search_result_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_time_zone_list_click() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("school_code", ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR));
            jSONObject.put("app_time_zone", TimeZoneUtil.INSTANCE.getAppTimeZone());
            jSONObject.put("device_time_zone", TimeZone.getDefault().getID());
            HwTrackUtil.INSTANCE.track("hw_time_zone_list_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_delete_account_click() {
        try {
            HwTrackUtil.INSTANCE.track("hw_delete_account_click", new JSONObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void personalInfoPageShow() {
        HwTrackUtil.INSTANCE.track("modify_personal_info_page_pv");
    }

    public final void savePersonalInfoResult(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_success", i);
        } catch (Exception unused) {
        }
        HwTrackUtil.INSTANCE.track("modify_personal_info_click", jSONObject);
    }

    public final void addStudentPageShow() {
        HwTrackUtil.INSTANCE.track("add_student_page_pv");
    }

    public final void addStudentResult(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_success", i);
            if (str != null) {
                jSONObject.put("new_stu_id", str);
            }
        } catch (Exception unused) {
        }
        HwTrackUtil.INSTANCE.track("add_student_click", jSONObject);
    }

    public final void changeStudentAccountClick(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("new_stu_id", str);
            } catch (Exception unused) {
            }
        }
        HwTrackUtil.INSTANCE.track("change_student_account_click", jSONObject);
    }
}
