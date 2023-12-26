package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.live.core.backplay.PlayBackActivity;
import com.tal.app.thinkacademy.live.core.backplay.PlayBackTestActivity;
import com.tal.app.thinkacademy.live.core.live.LiveActivity;
import com.tal.app.thinkacademy.live.core.live.LiveTestActivity;
import java.util.Map;

public class ARouter$$Group$$live implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/live/live_player", RouteMeta.build(RouteType.ACTIVITY, LiveActivity.class, "/live/live_player", "live", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/live/live_player/test", RouteMeta.build(RouteType.ACTIVITY, LiveTestActivity.class, "/live/live_player/test", "live", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/live/player_back", RouteMeta.build(RouteType.ACTIVITY, PlayBackActivity.class, "/live/player_back", "live", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/live/player_back_test", RouteMeta.build(RouteType.ACTIVITY, PlayBackTestActivity.class, "/live/player_back_test", "live", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
