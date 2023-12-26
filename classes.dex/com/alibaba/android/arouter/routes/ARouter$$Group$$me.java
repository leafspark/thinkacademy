package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.business.login.view.MePageFragment;
import java.util.Map;

public class ARouter$$Group$$me implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/me/me_fragment", RouteMeta.build(RouteType.FRAGMENT, MePageFragment.class, "/me/me_fragment", "me", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
