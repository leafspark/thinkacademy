package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.business.bus_hummer.HwHummerActivity;
import java.util.Map;

public class ARouter$$Group$$hummer implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/hummer/hw_hummer_activity", RouteMeta.build(RouteType.ACTIVITY, HwHummerActivity.class, "/hummer/hw_hummer_activity", "hummer", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
