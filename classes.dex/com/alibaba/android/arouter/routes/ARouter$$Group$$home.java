package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.business.home.main.DataStationFragment;
import com.tal.app.thinkacademy.business.home.main.HomePageFragment;
import com.tal.app.thinkacademy.business.home.main.LaunchActivity;
import com.tal.app.thinkacademy.business.home.main.MainActivity;
import com.tal.app.thinkacademy.business.home.main.StorePageFragment;
import java.util.Map;

public class ARouter$$Group$$home implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/home/data_fragment", RouteMeta.build(RouteType.FRAGMENT, DataStationFragment.class, "/home/data_fragment", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/home/home_fragment", RouteMeta.build(RouteType.FRAGMENT, HomePageFragment.class, "/home/home_fragment", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/home/launch_activity", RouteMeta.build(RouteType.ACTIVITY, LaunchActivity.class, "/home/launch_activity", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/home/main_activity", RouteMeta.build(RouteType.ACTIVITY, MainActivity.class, "/home/main_activity", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/home/shop_fragment", RouteMeta.build(RouteType.FRAGMENT, StorePageFragment.class, "/home/shop_fragment", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
