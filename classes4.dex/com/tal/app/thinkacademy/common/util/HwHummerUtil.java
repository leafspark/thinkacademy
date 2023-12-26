package com.tal.app.thinkacademy.common.util;

import com.didi.hummer.adapter.navigator.NavPage;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import java.util.HashMap;

public class HwHummerUtil {
    public static void startHwHummerActivity(String str, String str2) {
        NavPage navPage = new NavPage(str);
        navPage.params = new HashMap();
        navPage.params.put("hwData", str2);
        XesRoute.getInstance().getRouter().build(RouteMap.ROUTE_HW_HUMMER_ACTIVITY).withString("PAGE_ID", navPage.id).withSerializable("PAGE_MODEL", navPage).navigation();
    }

    public static boolean isHummerPageEnable() {
        boolean equals = "1".equals(HwCloudControlHelper.get().getCloudKeyValue("hummer_page_enable"));
        XesLog.dt("Hummer页面", "Hummer页面开关是否打开=" + equals);
        return equals;
    }
}
