package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.business.shop.ShopClassListActivity;
import com.tal.app.thinkacademy.business.shop.ShopHomeNativeFragment;
import com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity;
import com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailActivity;
import com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity;
import java.util.Map;

public class ARouter$$Group$$shop implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/shop/class_detail_activity", RouteMeta.build(RouteType.ACTIVITY, ShopClassDetailActivity.class, "/shop/class_detail_activity", "shop", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/shop/class_list_activity", RouteMeta.build(RouteType.ACTIVITY, ShopClassListActivity.class, "/shop/class_list_activity", "shop", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/shop/grade_aggregate_activity", RouteMeta.build(RouteType.ACTIVITY, GradeAggregateActivity.class, "/shop/grade_aggregate_activity", "shop", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/shop/shop_home_native_fragment", RouteMeta.build(RouteType.FRAGMENT, ShopHomeNativeFragment.class, "/shop/shop_home_native_fragment", "shop", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/shop/teacher_details_activity", RouteMeta.build(RouteType.ACTIVITY, TeacherDetailsActivity.class, "/shop/teacher_details_activity", "shop", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
