package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity;
import com.tal.app.thinkacademy.business.login.view.MyAccountListActivity;
import com.tal.app.thinkacademy.business.login.view.OtpLoginActivity;
import com.tal.app.thinkacademy.business.login.view.SearchTimeZoneActivity;
import com.tal.app.thinkacademy.business.login.view.SelectGradeActivity;
import com.tal.app.thinkacademy.business.login.view.SelectSchoolActivity;
import com.tal.app.thinkacademy.business.login.view.StoreWebActivity;
import com.tal.app.thinkacademy.business.login.view.TempCodeActivity;
import com.tal.app.thinkacademy.business.login.view.devicetest.DeviceTestActivity;
import java.util.Map;

public class ARouter$$Group$$login implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/login/choose_time_zone", RouteMeta.build(RouteType.ACTIVITY, ChooseTimeZoneActivity.class, "/login/choose_time_zone", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/coins_activity", RouteMeta.build(RouteType.ACTIVITY, StoreWebActivity.class, "/login/coins_activity", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/device_test_activity", RouteMeta.build(RouteType.ACTIVITY, DeviceTestActivity.class, "/login/device_test_activity", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/login_activity", RouteMeta.build(RouteType.ACTIVITY, OtpLoginActivity.class, "/login/login_activity", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/my_account_activity", RouteMeta.build(RouteType.ACTIVITY, MyAccountListActivity.class, "/login/my_account_activity", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/search_time_zone", RouteMeta.build(RouteType.ACTIVITY, SearchTimeZoneActivity.class, "/login/search_time_zone", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/select_grade_activity", RouteMeta.build(RouteType.ACTIVITY, SelectGradeActivity.class, "/login/select_grade_activity", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/select_school_activity", RouteMeta.build(RouteType.ACTIVITY, SelectSchoolActivity.class, "/login/select_school_activity", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/temp_register_activity", RouteMeta.build(RouteType.ACTIVITY, TempCodeActivity.class, "/login/temp_register_activity", "login", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
