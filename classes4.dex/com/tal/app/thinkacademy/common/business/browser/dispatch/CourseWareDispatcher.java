package com.tal.app.thinkacademy.common.business.browser.dispatch;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.entity.CourseLoadResult;
import com.tal.app.thinkacademy.common.entity.RedPackageRainGameLoadResult;
import com.tal.app.thinkacademy.common.entity.RedPackageRainGameRewardCoin;
import com.tal.app.thinkacademy.common.entity.SubmitHeaderData;
import com.tal.app.thinkacademy.common.entity.SubmitHeaderDataKt;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public class CourseWareDispatcher implements IDispatcher {
    private static final String TAG = "课件问题-js通信";
    private final String STATUS = "status";
    private final String TYPE = "type";
    private WeakReference<FragmentActivity> mActivityWef;

    public CourseWareDispatcher(FragmentActivity fragmentActivity) {
        this.mActivityWef = new WeakReference<>(fragmentActivity);
    }

    public void dispatch(JsInjection jsInjection, String str, Map<String, Object> map) {
        XesLog.it(TAG, str, map);
        if (TextUtils.equals(str, "coursewareStatus")) {
            if (map != null) {
                if (map.get("status").equals("loading")) {
                    XesDataBus.with(DataBusKey.JS_COURSE_WARE_STATUS).postStickyData(new CourseLoadResult("loading", false, "", map.get("loaded").toString()));
                } else if (map.get("status").equals("loaded")) {
                    XesDataBus.with(DataBusKey.JS_COURSE_WARE_STATUS).postStickyData(new CourseLoadResult("loaded", ((Boolean) map.get("isLocal")).booleanValue(), map.get("url").toString(), ""));
                } else if (map.get("status").equals("error")) {
                    XesDataBus.with(DataBusKey.JS_COURSE_WARE_STATUS).postStickyData(new CourseLoadResult("error", ((Boolean) map.get("isLocal")).booleanValue(), map.get("url").toString(), map.get("errMsg").toString()));
                }
            }
        } else if (TextUtils.equals(str, "jsCallNativeCommon") && map != null) {
            if (SubmitHeaderDataKt.Headers.equals(map.get("type"))) {
                XesDataBus.with(DataBusKey.HEADERS_DATA).postStickyData(GsonUtils.toJson(new SubmitHeaderData()));
            } else if ("exit".equals(map.get("type"))) {
                XesDataBus.with(DataBusKey.GAME_VIEW_REMOVE).postStickyData(DataBusKey.GAME_VIEW_REMOVE);
            } else if (!"coinChange".equals(map.get("type"))) {
                if ("copyContent".equals(map.get("type"))) {
                    XesDataBus.with(DataBusKey.COPY_CLIP_BOARD).postStickyData(map.get("content"));
                } else if ("loaded".equals(map.get("type"))) {
                    XesDataBus.with(DataBusKey.GAME_VIEW_LOADED).postStickyData(DataBusKey.GAME_VIEW_LOADED);
                } else if ("fail".equals(map.get("type"))) {
                    XesDataBus.with(DataBusKey.GAME_VIEW_FAIL).postStickyData(DataBusKey.GAME_VIEW_FAIL);
                } else if ("reload".equals(map.get("type"))) {
                    XesDataBus.with(DataBusKey.GAME_VIEW_RELOAD).postStickyData(DataBusKey.GAME_VIEW_RELOAD);
                } else if ("submitData".equals(map.get("type"))) {
                    XesDataBus.with(DataBusKey.EXERCISE_VIEW_COINS).postStickyData(map.get("data"));
                } else if ("interactionData".equals(map.get("type"))) {
                    XesDataBus.with(DataBusKey.EXERCISE_VIEW_CONTENT).postStickyData(DataBusKey.EXERCISE_VIEW_CONTENT);
                } else if ("redpackage_rain".equals(map.get("type"))) {
                    String objToJson = GsonUtil.getInstance().objToJson(map.get("data"));
                    if (!TextUtils.isEmpty(objToJson)) {
                        try {
                            JSONObject jSONObject = new JSONObject(objToJson);
                            String optString = jSONObject.optString("type");
                            if ("load".equals(optString)) {
                                RedPackageRainGameLoadResult redPackageRainGameLoadResult = (RedPackageRainGameLoadResult) GsonUtil.getInstance().fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), RedPackageRainGameLoadResult.class);
                                if (redPackageRainGameLoadResult != null) {
                                    XesDataBus.with(DataBusKey.RED_PACKAGE_RAIN_GAME_LOAD_RESULT).postStickyData(redPackageRainGameLoadResult);
                                }
                            } else if ("submitData".equals(optString)) {
                                RedPackageRainGameRewardCoin redPackageRainGameRewardCoin = (RedPackageRainGameRewardCoin) GsonUtil.getInstance().fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), RedPackageRainGameRewardCoin.class);
                                if (redPackageRainGameRewardCoin != null) {
                                    XesDataBus.with(DataBusKey.RED_PACKAGE_RAIN_GAME_REWARD_COIN).postStickyData(redPackageRainGameRewardCoin);
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                } else if ("log".equals(map.get("type"))) {
                    String objToJson2 = GsonUtil.getInstance().objToJson(map.get("data"));
                    if (!TextUtils.isEmpty(objToJson2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(objToJson2);
                            String optString2 = jSONObject2.optString("tag");
                            String optString3 = jSONObject2.optString("loginfo");
                            if ("redpackage_rain".equals(optString2)) {
                                Tag tag = Tag.RED_PACKAGE_RAIN;
                                XesLog.i(tag, "游戏日志：" + optString3);
                                return;
                            }
                            XesLog.it(optString2, optString3);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void setActivityWef(WeakReference<FragmentActivity> weakReference) {
        this.mActivityWef = weakReference;
    }
}
