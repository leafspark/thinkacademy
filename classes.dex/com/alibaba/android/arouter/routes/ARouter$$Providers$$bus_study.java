package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.tal.app.thinkacademy.business.study.study.service.StudyService;
import java.util.Map;

public class ARouter$$Providers$$bus_study implements IProviderGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.tal.app.thinkacademy.lib.route.FlutterToModuleService", RouteMeta.build(RouteType.PROVIDER, StudyService.class, "/study/routeService", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
