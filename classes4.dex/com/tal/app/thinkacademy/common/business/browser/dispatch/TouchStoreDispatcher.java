package com.tal.app.thinkacademy.common.business.browser.dispatch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.helper.PayHelp;
import com.tal.app.thinkacademy.common.constants.ClassTabConstants;
import com.tal.app.thinkacademy.common.constants.TabConstants;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.lang.ref.WeakReference;
import java.util.Map;

public class TouchStoreDispatcher implements IDispatcher {
    private WeakReference<FragmentActivity> mActivityWef;
    private boolean mIsCourseCached = false;

    public TouchStoreDispatcher(FragmentActivity fragmentActivity) {
        this.mActivityWef = new WeakReference<>(fragmentActivity);
    }

    public void dispatch(JsInjection jsInjection, String str, Map<String, Object> map) {
        Object obj;
        Object obj2;
        Object obj3;
        XesLog.dt("==store js bridge==", str, map);
        if (TextUtils.equals(str, "openURL")) {
            if (map != null) {
                Bundle bundle = new Bundle();
                Object obj4 = map.get("url");
                Object obj5 = map.get("title");
                Object obj6 = map.get("closeEnabled");
                Object obj7 = map.get("showTitle");
                if (obj4 != null) {
                    bundle.putString("jump_key", obj4.toString());
                    bundle.putSerializable("agent_config", new AgentConfig.Builder().setShowProgressBar(true).build());
                    if (obj7 != null) {
                        try {
                            bundle.putBoolean("showTitle", ((Boolean) obj7).booleanValue());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (obj5 != null) {
                            bundle.putString("title", obj5.toString());
                        }
                    }
                    if (obj6 != null) {
                        try {
                            bundle.putBoolean("closeEnabled", ((Boolean) obj6).booleanValue());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    XesRoute.getInstance().navigation("/login/coins_activity", bundle);
                }
            }
        } else if (TextUtils.equals(str, "close")) {
            FragmentActivity fragmentActivity = (FragmentActivity) this.mActivityWef.get();
            if (fragmentActivity != null) {
                fragmentActivity.finish();
            }
        } else if (TextUtils.equals(str, "jumpCourseList")) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("tabName", TabConstants.TAB_STUDY);
            bundle2.putString("courseType", (map == null || map.get("courseType") == null || TextUtils.isEmpty(map.get("courseType").toString())) ? ClassTabConstants.Live : map.get("courseType").toString());
            XesRoute.getInstance().navigation(RouteMap.ROUTE_MAIN_ACTIVITY, bundle2);
        } else if (TextUtils.equals(str, "jumpFamilyAccount")) {
            XesRoute.getInstance().navigation(RouteMap.ROUTE_MY_ACCOUNT_ACTIVITY);
        } else if (TextUtils.equals(str, "makeCall")) {
            FragmentActivity fragmentActivity2 = (FragmentActivity) this.mActivityWef.get();
            if (fragmentActivity2 != null && (obj3 = map.get("phone")) != null) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + obj3));
                fragmentActivity2.startActivity(intent);
            }
        } else if (TextUtils.equals(str, "shareContent")) {
            if (map != null) {
                String str2 = (String) map.get("shareContent");
                FragmentActivity fragmentActivity3 = (FragmentActivity) this.mActivityWef.get();
                if (str2 != null && fragmentActivity3 != null) {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.TEXT", str2);
                    fragmentActivity3.startActivity(Intent.createChooser(intent2, fragmentActivity3.getTitle()));
                }
            }
        } else if (TextUtils.equals(str, "login")) {
            Bundle bundle3 = new Bundle();
            if (map != null) {
                Object obj8 = map.get("source");
                bundle3.putString("login_source", "课程详情页-" + obj8);
            }
            XesRoute.getInstance().navigation(RouteMap.ROUTE_LOGIN_ACTIVITY, bundle3);
        } else if (TextUtils.equals(str, "jumpStore")) {
            Bundle bundle4 = new Bundle();
            bundle4.putString("tabName", TabConstants.TAB_SHOP);
            XesRoute.getInstance().navigation(RouteMap.ROUTE_MAIN_ACTIVITY, bundle4);
        } else if (TextUtils.equals(str, "jumpMyOrder")) {
            XesDataBus.with(DataBusKey.STORE_JS_JUMP_MY_ORDERS).postStickyData("order");
        } else if (TextUtils.equals(str, "switchAccount")) {
            if (map != null) {
                XesDataBus.with(DataBusKey.STORE_JS_SWITCH_ACCOUNT).postStickyData(GsonUtils.toJson(map));
            }
        } else if (TextUtils.equals(str, "pageLoadComplete")) {
            if (map != null && (obj2 = map.get("pageType")) != null && (obj2 instanceof String) && "courses".equals(obj2)) {
                this.mIsCourseCached = true;
            }
        } else if (TextUtils.equals(str, "orderPay")) {
            if (map != null && (obj = map.get("orderid")) != null) {
                try {
                    long longValue = Double.valueOf(obj.toString()).longValue();
                    FragmentActivity fragmentActivity4 = (FragmentActivity) this.mActivityWef.get();
                    if (fragmentActivity4 != null) {
                        new PayHelp(fragmentActivity4).startRequestOrder(longValue);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    XesLog.dt("Pay_error", "error = " + e3.toString());
                }
            }
        } else if (TextUtils.equals(str, "jumpCoursesDetail") && map != null) {
            Object obj9 = map.get("skuNo");
            if (obj9 instanceof String) {
                Bundle bundle5 = new Bundle();
                bundle5.putString("skuId", (String) obj9);
                XesRoute.getInstance().navigation(RouteMap.ROUTE_SHOP_CLASS_DETAIL_ACTIVITY, bundle5);
            }
        }
    }

    public boolean isCourseCached() {
        return this.mIsCourseCached;
    }

    public void setCourseCached(boolean z) {
        this.mIsCourseCached = z;
    }

    public void setActivityWef(WeakReference<FragmentActivity> weakReference) {
        this.mActivityWef = weakReference;
    }
}
