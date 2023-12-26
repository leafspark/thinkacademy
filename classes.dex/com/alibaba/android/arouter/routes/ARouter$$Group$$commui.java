package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.common.business.browser.view.BrowserActivity;
import java.util.Map;

public class ARouter$$Group$$commui implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/commui/browser_activity", RouteMeta.build(RouteType.ACTIVITY, BrowserActivity.class, "/commui/browser_activity", "commui", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
