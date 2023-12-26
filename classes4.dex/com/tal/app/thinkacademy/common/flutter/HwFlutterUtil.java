package com.tal.app.thinkacademy.common.flutter;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import com.tal.app.thinkacademy.common.ApiUrl;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.constants.TabConstants;
import com.tal.app.thinkacademy.common.entity.TimeZoneInfo;
import com.tal.app.thinkacademy.common.flutter.event.FlutterEventDispatcher;
import com.tal.app.thinkacademy.common.flutter.event.FlutterEventDispatcherKt;
import com.tal.app.thinkacademy.common.imconfig.HostUrlsInfo;
import com.tal.app.thinkacademy.common.imconfig.HwNetProbe;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl;
import com.tal.app.thinkacademy.common.network.BaseUrlEx;
import com.tal.app.thinkacademy.common.network.CommonHeader;
import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.track.CommonTrack;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.HwLanguageUtil;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.FlutterToModuleService;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\bH\u0002J$\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002J8\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2(\b\u0002\u0010%\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0019J\u000e\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$J\u0006\u0010'\u001a\u00020\u000fJ\u0006\u0010(\u001a\u00020\u000fJ\u0006\u0010)\u001a\u00020\u000fJ*\u0010*\u001a\u00020\u000f2\"\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\u0019JL\u0010,\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020\b2(\b\u0002\u0010%\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00192\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/HwFlutterUtil;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "mMethodChannel", "Lio/flutter/plugin/common/MethodChannel;", "assertEventName", "", "eventName", "assertProperties", "Lorg/json/JSONObject;", "map", "", "flutterBoostInit", "", "context", "Landroid/app/Application;", "getEnvToFlutter", "getHwFlutterFragment", "Lcom/tal/app/thinkacademy/common/flutter/HwFlutterFragment;", "url", "getLanguage", "getNetConfig", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "goToNativePage", "options", "Lcom/idlefish/flutterboost/FlutterBoostRouteOptions;", "initFlutterEvent", "initFlutterLog", "initHwChanelMethod", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "sendEventToFlutter", "event", "Lcom/tal/app/thinkacademy/common/flutter/EventToFlutter;", "args", "sendEventToFlutterLogin", "sendEventToFlutterLogout", "sendEventToFlutterNetProbe", "sendEventToFlutterSwitchTimeZone", "setupJumpParams", "params", "startFlutterActivity", "Landroid/content/Context;", "uniqueId", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwFlutterUtil.kt */
public final class HwFlutterUtil {
    public static final HwFlutterUtil INSTANCE = new HwFlutterUtil();
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.FLUTTER;
    private static MethodChannel mMethodChannel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwFlutterUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ENVIRONMENTAL.values().length];
            iArr[ENVIRONMENTAL.DEVELOP.ordinal()] = 1;
            iArr[ENVIRONMENTAL.TEST.ordinal()] = 2;
            iArr[ENVIRONMENTAL.ALPHA.ordinal()] = 3;
            iArr[ENVIRONMENTAL.PRE.ordinal()] = 4;
            iArr[ENVIRONMENTAL.ONLINE.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HwLanguageUtil.HwLanguageInfo.values().length];
            iArr2[HwLanguageUtil.HwLanguageInfo.CHINESE.ordinal()] = 1;
            iArr2[HwLanguageUtil.HwLanguageInfo.ENGLISH.ordinal()] = 2;
            iArr2[HwLanguageUtil.HwLanguageInfo.CHINESE_HK.ordinal()] = 3;
            iArr2[HwLanguageUtil.HwLanguageInfo.ENGLISH_UK.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private HwFlutterUtil() {
    }

    public final HwFlutterFragment getHwFlutterFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        HwFlutterFragment build = new FlutterBoostFragment.CachedEngineFragmentBuilder(HwFlutterFragment.class).url(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "CachedEngineFragmentBuil…url)\n            .build()");
        return build;
    }

    public static /* synthetic */ void startFlutterActivity$default(HwFlutterUtil hwFlutterUtil, Context context, String str, HashMap hashMap, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            hashMap = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        hwFlutterUtil.startFlutterActivity(context, str, hashMap, str2);
    }

    public final void startFlutterActivity(Context context, String str, HashMap<String, Object> hashMap, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        setupJumpParams(hashMap);
        FlutterBoostActivity.CachedEngineIntentBuilder url = new FlutterBoostActivity.CachedEngineIntentBuilder(HwFlutterActivity.class).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.opaque).destroyEngineWithActivity(false).url(str);
        if (str2 != null) {
            url.uniqueId(str2);
        }
        Intent build = url.urlParams(hashMap).build(context);
        Intrinsics.checkNotNullExpressionValue(build, "CachedEngineIntentBuilde…          .build(context)");
        context.startActivity(build);
    }

    public final void setupJumpParams(HashMap<String, Object> hashMap) {
        String str;
        String uid;
        Intrinsics.checkNotNullParameter(hashMap, "params");
        Map map = hashMap;
        map.put("isPad", Boolean.valueOf(PadUtils.isPad(Utils.getApp())));
        String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…EDATA_NOT_CLEAR\n        )");
        map.put("schoolCode", string);
        String appVersionName = AppUtils.getAppVersionName();
        Intrinsics.checkNotNullExpressionValue(appVersionName, "getAppVersionName()");
        map.put("appVersion", appVersionName);
        map.put(LeanplumUtil.platform, "android");
        String model = DeviceUtils.getModel();
        Intrinsics.checkNotNullExpressionValue(model, "getModel()");
        map.put("deviceName", model);
        map.put("systemVersion", String.valueOf(DeviceUtils.getSDKVersionCode()));
        String uniqueDeviceId = DeviceUtils.getUniqueDeviceId();
        Intrinsics.checkNotNullExpressionValue(uniqueDeviceId, "getUniqueDeviceId()");
        map.put("deviceId", uniqueDeviceId);
        map.put("clientType", CommonHeader.INSTANCE.clientType());
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        String str2 = "";
        if (userInfoEntity == null || (str = userInfoEntity.getUnifiedAccessToken()) == null) {
            str = str2;
        }
        map.put("isLogin", Boolean.valueOf(str.length() > 0));
        map.put("token", str);
        map.put("language", getLanguage());
        map.put("timeZone", TimeZoneUtil.INSTANCE.getTimeZone());
        if (!(userInfoEntity == null || (uid = userInfoEntity.getUid()) == null)) {
            str2 = uid;
        }
        map.put(LeanplumUtil.uid, str2);
        map.put("netConfig", getNetConfig());
        map.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
    }

    private final String getEnvToFlutter() {
        int i = WhenMappings.$EnumSwitchMapping$0[BaseUrlEx.Companion.getEnvironment().ordinal()];
        if (i == 1) {
            return "dev";
        }
        if (i == 2) {
            return "test";
        }
        if (i == 3) {
            return "alpha";
        }
        if (i == 4) {
            return "pre";
        }
        if (i == 5) {
            return "pro";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String getLanguage() {
        int i = WhenMappings.$EnumSwitchMapping$1[HwLanguageUtil.INSTANCE.getCurrentLanguage().ordinal()];
        if (i == 1) {
            return LanguageUtil.ZH;
        }
        if (i == 2) {
            return LanguageUtil.EN;
        }
        if (i != 3) {
            return i != 4 ? LanguageUtil.EN : "enGB";
        }
        return "zhHK";
    }

    /* access modifiers changed from: private */
    public final void goToNativePage(FlutterBoostRouteOptions flutterBoostRouteOptions) {
        boolean z;
        boolean z2;
        Object obj;
        String obj2;
        String pageName = flutterBoostRouteOptions.pageName();
        if (Intrinsics.areEqual(pageName, PageToNative.loginPage.name())) {
            XesLog.i(TAG, "收到flutter跳转 登录");
            Bundle bundle = new Bundle();
            bundle.putString("login_page_path", "learning_portal");
            bundle.putString("login_source", "我的课程");
            XesRoute.getInstance().navigation(RouteMap.ROUTE_LOGIN_ACTIVITY, bundle);
            return;
        }
        if (Intrinsics.areEqual(pageName, PageToNative.lessionReport.name())) {
            z = true;
        } else {
            z = Intrinsics.areEqual(pageName, PageToNative.recordExamReport.name());
        }
        if (z) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual(pageName, PageToNative.examReport.name());
        }
        if (z2) {
            Map arguments = flutterBoostRouteOptions.arguments();
            String str = "";
            if (!(arguments == null || (obj = arguments.get("routeUrl")) == null || (obj2 = obj.toString()) == null)) {
                str = obj2;
            }
            XesLog.i(TAG, Intrinsics.stringPlus("收到flutter跳转 考试报告，url=", str));
            Bundle bundle2 = new Bundle();
            bundle2.putString("jump_key", str);
            bundle2.putSerializable("agent_config", new AgentConfig.Builder().setShowProgressBar(true).build());
            XesRoute.getInstance().navigation(RouteMap.ROUTE_BROWSER_ACTIVITY, bundle2);
            return;
        }
        Object obj3 = null;
        if (Intrinsics.areEqual(pageName, PageToNative.examAfterClass.name())) {
            XesLog.i(TAG, "收到flutter跳转 课中考试课后作答");
            Map arguments2 = flutterBoostRouteOptions.arguments();
            if (arguments2 != null) {
                obj3 = arguments2.get("params");
            }
            FlutterToModuleService flutterToModuleService = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService != null) {
                flutterToModuleService.onRoute(PageToNative.examAfterClass.name(), obj3);
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.stageExam.name())) {
            XesLog.i(TAG, "收到flutter跳转 阶段考试");
            Map arguments3 = flutterBoostRouteOptions.arguments();
            if (arguments3 != null) {
                obj3 = arguments3.get("params");
            }
            FlutterToModuleService flutterToModuleService2 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService2 != null) {
                flutterToModuleService2.onRoute(PageToNative.stageExam.name(), obj3);
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.liveRoom.name())) {
            FlutterToModuleService flutterToModuleService3 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService3 != null) {
                flutterToModuleService3.onRoute(PageToNative.liveRoom.name(), flutterBoostRouteOptions.arguments());
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.parentsAttend.name())) {
            FlutterToModuleService flutterToModuleService4 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService4 != null) {
                flutterToModuleService4.onRoute(PageToNative.parentsAttend.name(), flutterBoostRouteOptions.arguments());
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.playBack.name())) {
            FlutterToModuleService flutterToModuleService5 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService5 != null) {
                flutterToModuleService5.onRoute(PageToNative.playBack.name(), flutterBoostRouteOptions.arguments());
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.learnMaterial.name())) {
            FlutterToModuleService flutterToModuleService6 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService6 != null) {
                flutterToModuleService6.onRoute(PageToNative.learnMaterial.name(), flutterBoostRouteOptions.arguments());
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.previewQuestion.name())) {
            FlutterToModuleService flutterToModuleService7 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService7 != null) {
                flutterToModuleService7.onRoute(PageToNative.previewQuestion.name(), flutterBoostRouteOptions.arguments());
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.assignment.name())) {
            FlutterToModuleService flutterToModuleService8 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService8 != null) {
                flutterToModuleService8.onRoute(PageToNative.assignment.name(), flutterBoostRouteOptions.arguments());
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.gotoSelectCourse.name())) {
            XesDataBus.with(DataBusKey.MAIN_TAB_SWITCH).postStickyData(TabConstants.TAB_SHOP);
        } else if (Intrinsics.areEqual(pageName, PageToNative.teacherContactWay.name())) {
            FlutterToModuleService flutterToModuleService9 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService9 != null) {
                flutterToModuleService9.onRoute(PageToNative.teacherContactWay.name(), flutterBoostRouteOptions.arguments());
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.recordStageExam.name())) {
            XesLog.i(TAG, Intrinsics.stringPlus("收到flutter跳转 录播阶段考试 ", flutterBoostRouteOptions.arguments()));
            FlutterToModuleService flutterToModuleService10 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService10 != null) {
                flutterToModuleService10.onRoute(PageToNative.recordStageExam.name(), flutterBoostRouteOptions.arguments());
            }
        } else if (Intrinsics.areEqual(pageName, PageToNative.recordRoom.name())) {
            XesLog.i(TAG, Intrinsics.stringPlus("收到flutter跳转 进入录播课播放页 ", flutterBoostRouteOptions.arguments()));
            FlutterToModuleService flutterToModuleService11 = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
            if (flutterToModuleService11 != null) {
                flutterToModuleService11.onRoute(PageToNative.recordRoom.name(), flutterBoostRouteOptions.arguments());
            }
        }
    }

    public final void flutterBoostInit(Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        long currentTimeMillis = System.currentTimeMillis();
        XesLog.i(TAG, Intrinsics.stringPlus("引擎初始化，android boost 开始执行 time= ", Long.valueOf(currentTimeMillis)));
        FlutterBoost.instance().setup(application, new HwFlutterUtil$flutterBoostInit$1(), new HwFlutterUtil$$ExternalSyntheticLambda2(currentTimeMillis));
        initFlutterLog();
        initFlutterEvent();
    }

    /* access modifiers changed from: private */
    /* renamed from: flutterBoostInit$lambda-2  reason: not valid java name */
    public static final void m49flutterBoostInit$lambda2(long j, FlutterEngine flutterEngine) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - j;
        XesLog.i(TAG, "引擎初始化，android boost 创建引擎成功 time= " + currentTimeMillis + ",耗时=" + j2);
        CommonTrack.INSTANCE.hw_flutter_engine_init(j2);
        HwFlutterUtil hwFlutterUtil = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(flutterEngine, "engine");
        hwFlutterUtil.initHwChanelMethod(flutterEngine);
    }

    private final String assertEventName(String str) {
        if (TextUtils.isEmpty(str)) {
            XesLog.i(TAG, "事件名为空，请检查代码");
        }
        return str;
    }

    private final JSONObject assertProperties(Map<?, ?> map) {
        if (map != null) {
            return new JSONObject(map);
        }
        XesLog.i(TAG, "传入的属性为空");
        return null;
    }

    private final void initHwChanelMethod(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "hw_flutter_method_channel");
        mMethodChannel = methodChannel;
        methodChannel.setMethodCallHandler(HwFlutterUtil$$ExternalSyntheticLambda3.INSTANCE);
        XesLog.i(TAG, Intrinsics.stringPlus("引擎初始化，android method channel 创建成功 time= ", Long.valueOf(System.currentTimeMillis())));
    }

    /* access modifiers changed from: private */
    /* renamed from: initHwChanelMethod$lambda-3  reason: not valid java name */
    public static final void m52initHwChanelMethod$lambda3(MethodCall methodCall, MethodChannel.Result result) {
        boolean timeZoneEqualsBranchSchool;
        String str;
        String str2 = "";
        Intrinsics.checkNotNullParameter(methodCall, "methodCall");
        Intrinsics.checkNotNullParameter(result, "result");
        String str3 = methodCall.method;
        if (str3 != null) {
            boolean z = false;
            switch (str3.hashCode()) {
                case -1991565194:
                    if (str3.equals("getHwEnvInfo")) {
                        HashMap hashMap = new HashMap();
                        INSTANCE.setupJumpParams(hashMap);
                        result.success(hashMap);
                        return;
                    }
                    break;
                case -1369144336:
                    if (str3.equals("getZoneInfo")) {
                        XesLog.i(TAG, "获取时区信息");
                        if (TimeZoneUtil.INSTANCE.isShowTimeZoneBranchSchool()) {
                            if (StringsKt.isBlank(TimeZoneUtil.INSTANCE.getAppTimeZone())) {
                                timeZoneEqualsBranchSchool = TimeZoneUtil.INSTANCE.setTimeZoneEqualsBranchSchool();
                            } else if (TimeZoneUtil.INSTANCE.appTimeZoneEqualsSetting()) {
                                timeZoneEqualsBranchSchool = TimeZoneUtil.INSTANCE.setTimeZoneEqualsBranchSchool();
                            } else {
                                z = true;
                            }
                            z = !timeZoneEqualsBranchSchool;
                        }
                        result.success(GsonUtils.toJson(new TimeZoneInfo(TimeZoneUtil.INSTANCE.getTimeZone(), z)));
                        return;
                    }
                    break;
                case -436075059:
                    if (str3.equals("getCloudInfo")) {
                        try {
                            Object obj = methodCall.arguments;
                            if (obj != null) {
                                str = (String) obj;
                                String cloudKeyValue = HwCloudControlHelper.Companion.get().getCloudKeyValue(str);
                                if (cloudKeyValue != null) {
                                    str2 = cloudKeyValue;
                                }
                                result.success(str2);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        } catch (Exception unused) {
                            str = str2;
                        }
                    }
                    break;
                case 110621003:
                    if (str3.equals("track")) {
                        try {
                            Object obj2 = methodCall.arguments;
                            if (obj2 != null) {
                                List list = (List) obj2;
                                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                                HwFlutterUtil hwFlutterUtil = INSTANCE;
                                hwTrackUtil.track(hwFlutterUtil.assertEventName((String) list.get(0)), hwFlutterUtil.assertProperties((Map) list.get(1)));
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                        } catch (Exception e) {
                            XesLog.e(TAG, Intrinsics.stringPlus("flutter神策埋点失败,错误=", e));
                            return;
                        }
                    }
                    break;
                case 1812050031:
                    if (str3.equals("getUserinfo")) {
                        XesLog.i(TAG, "获取用户信息");
                        result.success(GsonUtils.toJson(UserInfoBll.Companion.getInstance().getUserInfoEntity()));
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    /* access modifiers changed from: private */
    /* renamed from: initFlutterLog$lambda-4  reason: not valid java name */
    public static final void m51initFlutterLog$lambda4(String str, Map map) {
        if (Intrinsics.areEqual("FlutterToNativeLog", str)) {
            Object obj = map.get("level");
            if (Intrinsics.areEqual(obj, "debug")) {
                Object obj2 = map.get("msg");
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.String");
                XesLog.i(TAG, (String) obj2);
            } else if (Intrinsics.areEqual(obj, "error")) {
                Object obj3 = map.get("msg");
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.String");
                XesLog.e(TAG, (String) obj3);
            }
        } else {
            XesLog.e(TAG, "收到flutterLog，key = " + str + ",arg=" + map);
        }
    }

    private final void initFlutterLog() {
        FlutterBoost.instance().addEventListener("FlutterToNativeLog", HwFlutterUtil$$ExternalSyntheticLambda0.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: initFlutterEvent$lambda-5  reason: not valid java name */
    public static final void m50initFlutterEvent$lambda5(String str, Map map) {
        if (Intrinsics.areEqual("hw_event_from_flutter", str)) {
            FlutterEventDispatcher flutterEventDispatcher = FlutterEventDispatcher.Companion.get();
            Object obj = map.get("eventName");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            if (!flutterEventDispatcher.dispatch((String) obj, map.get("eventArgs"))) {
                XesLog.e(TAG, "收到flutterEvent，事件分发失败！！！ key = " + str + ",arg=" + map);
            }
        }
        XesLog.i(TAG, "收到flutterEvent，key = " + str + ",arg=" + map);
    }

    private final void initFlutterEvent() {
        FlutterBoost.instance().addEventListener("hw_event_from_flutter", HwFlutterUtil$$ExternalSyntheticLambda1.INSTANCE);
        FlutterEventDispatcherKt.init(FlutterEventDispatcher.Companion);
    }

    public static /* synthetic */ void sendEventToFlutter$default(HwFlutterUtil hwFlutterUtil, EventToFlutter eventToFlutter, HashMap hashMap, int i, Object obj) {
        if ((i & 2) != 0) {
            hashMap = null;
        }
        hwFlutterUtil.sendEventToFlutter(eventToFlutter, hashMap);
    }

    public final void sendEventToFlutter(EventToFlutter eventToFlutter, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(eventToFlutter, "event");
        HashMap hashMap2 = new HashMap();
        Map map = hashMap2;
        map.put("eventName", eventToFlutter.name());
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        map.put("eventArgs", hashMap);
        if (PadAutoUtil.isCloseScreenLandscape()) {
            XesLog.i(TAG, Intrinsics.stringPlus("横屏项目关闭，flutter事件不处理通知 事件属性：", hashMap2));
            return;
        }
        try {
            FlutterBoost.instance().sendEventToFlutter("hw_event_from_native", hashMap2);
        } catch (Exception unused) {
            XesLog.e(TAG, "sendEventToFlutter 事件发送失败！！！ key = " + eventToFlutter.name() + ',');
        }
    }

    private final HashMap<String, Object> getNetConfig() {
        Pair[] pairArr = new Pair[3];
        HwFlutterUtil hwFlutterUtil = this;
        String[] overseaHostArray = HwNetProbe.Companion.get().overseaHostArray();
        String[] strArr = null;
        if (!(!(overseaHostArray.length == 0))) {
            HostUrlsInfo hostUrls = ImConfig.INSTANCE.getHostUrls();
            overseaHostArray = hostUrls == null ? null : hostUrls.getOverseaApiHost();
            if (overseaHostArray == null) {
                overseaHostArray = new String[]{ServerConfigUrl.INSTANCE.getBASE_URL()};
            }
        }
        pairArr[0] = TuplesKt.to("oversea", ArraysKt.toList((Object[]) overseaHostArray));
        String[] oneHostArray = HwNetProbe.Companion.get().oneHostArray();
        if (!(!(oneHostArray.length == 0))) {
            HostUrlsInfo hostUrls2 = ImConfig.INSTANCE.getHostUrls();
            if (hostUrls2 != null) {
                strArr = hostUrls2.getOneHost();
            }
            oneHostArray = strArr == null ? new String[]{ApiUrl.INSTANCE.getBASE_URL()} : strArr;
        }
        pairArr[1] = TuplesKt.to("one", ArraysKt.toList((Object[]) oneHostArray));
        pairArr[2] = TuplesKt.to("env", getEnvToFlutter());
        return MapsKt.hashMapOf(pairArr);
    }

    public final void sendEventToFlutterNetProbe() {
        sendEventToFlutter(EventToFlutter.netConfig, getNetConfig());
    }

    public final void sendEventToFlutterLogin(EventToFlutter eventToFlutter) {
        String str;
        String uid;
        Intrinsics.checkNotNullParameter(eventToFlutter, "event");
        HashMap hashMap = new HashMap();
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        String str2 = "";
        if (userInfoEntity == null || (str = userInfoEntity.getUnifiedAccessToken()) == null) {
            str = str2;
        }
        Map map = hashMap;
        map.put("isLogin", Boolean.valueOf(str.length() > 0));
        map.put("token", str);
        String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…EDATA_NOT_CLEAR\n        )");
        map.put("schoolCode", string);
        if (!(userInfoEntity == null || (uid = userInfoEntity.getUid()) == null)) {
            str2 = uid;
        }
        map.put(LeanplumUtil.uid, str2);
        map.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        sendEventToFlutter(eventToFlutter, hashMap);
    }

    public final void sendEventToFlutterLogout() {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("isLogin", false);
        map.put("token", "");
        String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…EDATA_NOT_CLEAR\n        )");
        map.put("schoolCode", string);
        map.put(LeanplumUtil.uid, "");
        map.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        sendEventToFlutter(EventToFlutter.LOGIN_OUT_SUCCESS, hashMap);
    }

    public final void sendEventToFlutterSwitchTimeZone() {
        HashMap hashMap = new HashMap();
        hashMap.put("timeZone", TimeZoneUtil.INSTANCE.getTimeZone());
        sendEventToFlutter(EventToFlutter.TIMEZONE_SWITCH_SUCCESS, hashMap);
    }
}
