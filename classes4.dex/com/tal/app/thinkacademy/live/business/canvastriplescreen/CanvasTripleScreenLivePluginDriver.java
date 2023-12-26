package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.irc.IrcKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenPagerPluginView;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiCallback;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiLiveAgent;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteNoticeCode;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.utils.IrcDomain;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "涂鸦插件", ircType = {"canvas_switch_courseware", "canvas_switch_courseware_f", "local_joinRoom", "local_netDisconnect", "local_netConnected", "mode"}, launchType = "initmodule", moduleId = "1012")
@ViewLevels({@ViewLevel(level = 1, name = "tripleScreenLayout"), @ViewLevel(level = 3, name = "graffitiLayout"), @ViewLevel(level = 41, name = "graffitiTools")})
public class CanvasTripleScreenLivePluginDriver extends BaseLivePluginDriver implements GraffitiCallback {
    private static final XesLogTag TAG = Tag.TRIPLE_SCREEN;
    /* access modifiers changed from: private */
    public CanvasTripleScreenPagerPluginView canvasTripleScreenPager;
    private CourseWareBean currentCourseWareBean;
    private boolean isBindCourseware = true;
    private Context mContext;
    private CoursewareBgPluginView mCoursewareBgPluginView;
    /* access modifiers changed from: private */
    public GraffitiLiveAgent mGraffitiAgent;
    public Observer<PluginEventData> observerAuthGraffiti = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (TextUtils.equals(pluginEventData.getData(), "1")) {
                if (CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent != null && !CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.isAuthTouch()) {
                    CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.openAuth();
                }
            } else if (CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent != null && CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.isAuthTouch()) {
                CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.closeAuth("取消授权");
            }
        }
    };
    public Observer<PluginEventData> observerCourseRefresh = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            CanvasTripleScreenLivePluginDriver.this.canvasTripleScreenPager.refresh();
        }
    };
    public Observer<PluginEventData> observerGrouoVideoCallEnd = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (TextUtils.equals(pluginEventData.getData(), UserInfoBll.getInstance().getUserInfoEntity().getUid()) && CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent != null && CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.isAuthTouch()) {
                CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.closeAuth("自己下台");
            }
        }
    };
    private PlanInfoProxy planInfo;

    public void onDestroy() {
    }

    public CanvasTripleScreenLivePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.isBindCourseware = iLiveRoomProvider.isBindCourseware();
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        RoomData roomData = dataStorage.getRoomData();
        CanvasTripleScreenPagerPluginView canvasTripleScreenPagerPluginView = new CanvasTripleScreenPagerPluginView(this.mContext);
        this.canvasTripleScreenPager = canvasTripleScreenPagerPluginView;
        canvasTripleScreenPagerPluginView.setLiveRoomProvider(iLiveRoomProvider);
        this.canvasTripleScreenPager.isBindCourseware(this.isBindCourseware);
        GraffitiLiveAgent graffitiLiveAgent = new GraffitiLiveAgent(this.mContext, this, iLiveRoomProvider);
        this.mGraffitiAgent = graffitiLiveAgent;
        graffitiLiveAgent.setGraffitiCallback(this);
        this.planInfo = dataStorage.getPlanInfo();
        onLiveInit(this.planInfo, dataStorage.getCourseInfo(), dataStorage.getTeacherInfo(), roomData);
        PluginEventBus.register(this, DataBusKey.CLASS_REFRESH_KEY, this.observerCourseRefresh);
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGrouoVideoCallEnd);
        PluginEventBus.register(this, DataBusKey.GTRAFFITI_AUTH_KEY, this.observerAuthGraffiti);
    }

    public void onLiveInit(PlanInfoProxy planInfoProxy, CourseInfoProxy courseInfoProxy, TeacherInfo teacherInfo, RoomData roomData) {
        initTripleScreenLayout(roomData);
        GraffitiLiveAgent graffitiLiveAgent = this.mGraffitiAgent;
        if (graffitiLiveAgent != null) {
            graffitiLiveAgent.initGraffiti(courseInfoProxy.getBizId() + "_" + planInfoProxy.getId() + "_" + teacherInfo.getId());
        }
        setListener();
        try {
            String optString = new JSONObject(this.mInitModuleJsonStr).optString("remindDuration");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    int parseInt = Integer.parseInt(optString);
                    if (parseInt > 0) {
                        this.canvasTripleScreenPager.setRemindDuration(parseInt);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if ("in-training".equals(this.mLiveRoomProvider.getDataStorage().getRoomData().getMode())) {
            this.canvasTripleScreenPager.showStartStudy();
        }
    }

    private void initTripleScreenLayout(RoomData roomData) {
        if (LiveAreaCompat.isSmallPad()) {
            this.mCoursewareBgPluginView = new CoursewareBgPluginView(this.mContext);
            this.mLiveRoomProvider.addView(this, this.mCoursewareBgPluginView, "tripleScreenLayout", LiveAreaContext.get().getPptLp().newLp());
        }
        this.canvasTripleScreenPager.initData(false);
        FrameLayout.LayoutParams newLp = LiveAreaCompat.pptCenterLp(roomData.getCourseRate()).newLp();
        if (LiveAreaCompat.isSmallPhone() && roomData.getCourseRate() == LiveAreaCompat.CourseRate.RATE_16_9) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "initTripleScreenLayout，小班手机在16:9课件下，三分屏布局需要按照16:9居中展示");
            int i = (int) ((((float) newLp.width) * 9.0f) / 16.0f);
            newLp.topMargin += (newLp.height - i) / 2;
            newLp.height = i;
            XesLog.i(xesLogTag, "initTripleScreenLayout: layoutParams = " + CommonKtxKt.format(newLp));
        }
        this.mLiveRoomProvider.addView(this, this.canvasTripleScreenPager, "tripleScreenLayout", newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new CanvasTripleScreenLivePluginDriver$$ExternalSyntheticLambda0(this, roomData));
    }

    public /* synthetic */ void lambda$initTripleScreenLayout$0$CanvasTripleScreenLivePluginDriver(RoomData roomData, LiveAreaContext liveAreaContext) {
        FrameLayout.LayoutParams layoutParams;
        if (this.canvasTripleScreenPager != null) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "课件直播>>>videoSizeChange");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.canvasTripleScreenPager.getLayoutParams();
            LiveAreaCompat.pptCenterLp(roomData.getCourseRate()).mergeLp(layoutParams2);
            if (LiveAreaCompat.isSmallPhone() && roomData.getCourseRate() == LiveAreaCompat.CourseRate.RATE_16_9) {
                XesLog.i(xesLogTag, "initTripleScreenLayout，布局变化监听，小班手机在16:9课件下，三分屏布局需要按照16:9居中展示");
                int i = (int) ((((float) layoutParams2.width) * 9.0f) / 16.0f);
                layoutParams2.topMargin += (layoutParams2.height - i) / 2;
                layoutParams2.height = i;
            }
            XesLog.i(xesLogTag, "initTripleScreenLayout: 布局变化监听, layoutParams = " + CommonKtxKt.format(layoutParams2));
            this.canvasTripleScreenPager.setLayoutParams(layoutParams2);
            CoursewareBgPluginView coursewareBgPluginView = this.mCoursewareBgPluginView;
            if (coursewareBgPluginView != null && (layoutParams = (FrameLayout.LayoutParams) coursewareBgPluginView.getLayoutParams()) != null) {
                liveAreaContext.getPptLp().mergeLp(layoutParams);
                this.mCoursewareBgPluginView.setLayoutParams(layoutParams);
            }
        }
    }

    private void setListener() {
        this.canvasTripleScreenPager.setCallBack(new CanvasTripleScreenPagerPluginView.CallBack() {
            public void onTouchAreaUpdate(RectF rectF) {
            }

            public void onCourseWareSwitchResult(int i, CourseWareBean courseWareBean) {
                CanvasTripleScreenLivePluginDriver.this.canvasTripleScreenPager.scrollToTop();
                if ((i == 2) && courseWareBean != null && CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent != null) {
                    CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.setCourseId(courseWareBean.courseWareId);
                    CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.setPageId(courseWareBean.pageId);
                    CanvasTripleScreenLivePluginDriver.this.mGraffitiAgent.turnPageTo(courseWareBean.getKey(), 2);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        CanvasTripleScreenLivePluginDriver.super.onLifecycleDestroy(lifecycleOwner);
        GraffitiLiveAgent graffitiLiveAgent = this.mGraffitiAgent;
        if (graffitiLiveAgent != null) {
            graffitiLiveAgent.destroy();
            this.mGraffitiAgent = null;
        }
        CanvasTripleScreenPagerPluginView canvasTripleScreenPagerPluginView = this.canvasTripleScreenPager;
        if (canvasTripleScreenPagerPluginView != null) {
            canvasTripleScreenPagerPluginView.onDestroy();
        }
        PluginEventBus.unregister(DataBusKey.CLASS_REFRESH_KEY, this.observerCourseRefresh);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGrouoVideoCallEnd);
        PluginEventBus.unregister(DataBusKey.GTRAFFITI_AUTH_KEY, this.observerAuthGraffiti);
    }

    public void onMessage(String str, String str2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2122121021:
                if (str.equals("canvas_switch_courseware_f")) {
                    c = 0;
                    break;
                }
                break;
            case -1003324452:
                if (str.equals("canvas_switch_courseware")) {
                    c = 1;
                    break;
                }
                break;
            case -644962439:
                if (str.equals(IrcKey.LOCAL_JOIN_ROOM)) {
                    c = 2;
                    break;
                }
                break;
            case -160819131:
                if (str.equals("local_netDisconnect")) {
                    c = 3;
                    break;
                }
                break;
            case 3357091:
                if (str.equals("mode")) {
                    c = 4;
                    break;
                }
                break;
            case 229775936:
                if (str.equals("local_netConnected")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                onCourseWare(str, str2);
                return;
            case 2:
                XesLog.s(TAG, "irc链接成功");
                GraffitiLiveAgent graffitiLiveAgent = this.mGraffitiAgent;
                if (graffitiLiveAgent != null) {
                    graffitiLiveAgent.joinRoom();
                    CourseWareBean courseWareBean = this.currentCourseWareBean;
                    if (courseWareBean != null) {
                        this.mGraffitiAgent.setCourseId(courseWareBean.courseWareId);
                        this.mGraffitiAgent.turnPageTo(this.currentCourseWareBean.getKey(), 2);
                        this.mGraffitiAgent.setPageId(this.currentCourseWareBean.pageId);
                    }
                }
                LiveTrackData.mIrcState = "加入成功";
                return;
            case 3:
                IrcDomain ircDomain = null;
                try {
                    int optInt = new JSONObject(str2).optJSONObject("local_netDisconnect").optInt("status");
                    if (optInt == 0) {
                        ircDomain = IrcDomain.IrcUnKnow;
                    } else if (optInt == 1) {
                        ircDomain = IrcDomain.IrcUnavailable;
                    } else if (optInt == 2) {
                        ircDomain = IrcDomain.IrcFailed;
                    } else if (optInt == 5) {
                        ircDomain = IrcDomain.IrcDisConnected;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LiveTrackData.mIrcState = "未加入";
                if (ircDomain != null) {
                    LiveTrack.courseLoadError(ircDomain);
                    return;
                }
                return;
            case 4:
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("sendTime");
                    String optString2 = jSONObject.optString("mode");
                    if (!optString2.equals(this.mLiveRoomProvider.getDataStorage().getRoomData().getMode()) && "in-training".equals(optString2)) {
                        XesLog.i(TAG, "切到辅导流  " + optString);
                        this.canvasTripleScreenPager.showStartStudy();
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
            case 5:
                LiveTrackData.mIrcState = "加入成功";
                return;
            default:
                return;
        }
    }

    public void onCourseWare(String str, String str2) {
        boolean z = true;
        XesLog.i(TAG, "课件翻页" + str2);
        if ("canvas_switch_courseware_f".equals(str) && VoteNoticeCode.MODE_CLASS.equals(this.mLiveRoomProvider.getDataStorage().getRoomData().getMode())) {
            return;
        }
        if (!"canvas_switch_courseware".equals(str) || !"in-training".equals(this.mLiveRoomProvider.getDataStorage().getRoomData().getMode())) {
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("currentCourseWare");
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("shareInfo");
                    if (optJSONObject2 != null) {
                        if (this.currentCourseWareBean != null) {
                            z = false;
                        }
                        CourseWareBean courseWareBean = (CourseWareBean) GsonUtils.fromJson(!(optJSONObject2 instanceof JSONObject) ? optJSONObject2.toString() : JSONObjectInstrumentation.toString(optJSONObject2), CourseWareBean.class);
                        this.currentCourseWareBean = courseWareBean;
                        courseWareBean.planId = ParseUtils.tryParseInt(this.planInfo.getId(), 0);
                        if (optJSONObject3 != null) {
                            this.currentCourseWareBean.shareInfoUid = ParseUtils.tryParseLong(optJSONObject3.optString(LeanplumUtil.uid), -9);
                        }
                        this.canvasTripleScreenPager.switchCourseWare(this.currentCourseWareBean, z);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void onUnSupportActionList(List<WXWBAction> list, boolean z) {
        this.canvasTripleScreenPager.onUnSupportActionList(list);
    }
}
