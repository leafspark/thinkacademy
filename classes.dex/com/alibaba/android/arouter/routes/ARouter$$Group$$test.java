package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.DemoActivity;
import java.util.Map;

public class ARouter$$Group$$test implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/test/test", RouteMeta.build(RouteType.ACTIVITY, DemoActivity.class, "/test/test", "test", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
