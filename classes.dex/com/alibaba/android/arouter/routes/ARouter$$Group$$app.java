package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.NotificationActivity;
import java.util.Map;

public class ARouter$$Group$$app implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/app/notification_activity", RouteMeta.build(RouteType.ACTIVITY, NotificationActivity.class, "/app/notification_activity", "app", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
