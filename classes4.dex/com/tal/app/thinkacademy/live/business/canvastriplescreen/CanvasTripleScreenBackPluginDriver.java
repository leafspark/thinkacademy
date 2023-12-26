package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel;
import com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModelKt;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenPagerPluginView;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.ThreadWorker;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiCallback;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "涂鸦插件", launchType = "initmodule", liveType = 1, metaDataKey = {"canvas_switch_courseware"}, moduleId = "1012", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 1, name = "tripleScreenLayout"), @ViewLevel(level = 3, name = "graffitiLayout")})
public class CanvasTripleScreenBackPluginDriver extends BaseLivePluginDriver implements PlayerTimeCallBack, Observer<PluginEventData>, GraffitiCallback {
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.TRIPLE_SCREEN;
    /* access modifiers changed from: private */
    public CanvasTripleScreenPagerPluginView canvasTripleScreenPager;
    long currentSeiTimestamp = 0;
    private long dbLastMsgId;
    private boolean isBindCourseware = true;
    /* access modifiers changed from: private */
    public long lastSEITimeStamp;
    private Context mContext;
    /* access modifiers changed from: private */
    public GraffitiBackAgent mGraffitiAgent;
    /* access modifiers changed from: private */
    public final PlaybackViewModel mPlaybackViewModel;
    public Observer<PluginEventData> observerCourseRefresh = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            CanvasTripleScreenBackPluginDriver.this.canvasTripleScreenPager.refresh();
            if (CanvasTripleScreenBackPluginDriver.this.mPlaybackViewModel != null) {
                CanvasTripleScreenBackPluginDriver.this.mPlaybackViewModel.refresh();
            }
        }
    };
    private PlanInfoProxy planInfo;
    private boolean resumedReady = false;
    private ThreadWorker threadWorker;
    private boolean videoReady = false;

    public CanvasTripleScreenBackPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.isBindCourseware = iLiveRoomProvider.isBindCourseware();
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        iLiveRoomProvider.registerPlayerTimeCallback(this);
        CanvasTripleScreenPagerPluginView canvasTripleScreenPagerPluginView = new CanvasTripleScreenPagerPluginView(this.mContext);
        this.canvasTripleScreenPager = canvasTripleScreenPagerPluginView;
        canvasTripleScreenPagerPluginView.setLiveRoomProvider(iLiveRoomProvider);
        this.canvasTripleScreenPager.isBindCourseware(this.isBindCourseware);
        GraffitiBackAgent graffitiBackAgent = new GraffitiBackAgent(this.mContext, this, iLiveRoomProvider);
        this.mGraffitiAgent = graffitiBackAgent;
        graffitiBackAgent.setGraffitiCallback(this);
        this.threadWorker = new ThreadWorker("CanvasTripleScreenLiveBackDriverThread", 66);
        this.mPlaybackViewModel = PlaybackViewModelKt.getPlaybackViewModel(AbilityPack.get());
        this.planInfo = dataStorage.getPlanInfo();
        CourseInfoProxy courseInfo = dataStorage.getCourseInfo();
        PluginEventBus.register(this, "player_status", this);
        init(this.planInfo, courseInfo, dataStorage.getTeacherInfo(), dataStorage.getRoomData());
        PluginEventBus.register(this, DataBusKey.CLASS_REFRESH_KEY, this.observerCourseRefresh);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(1:4)|5|6|7|(1:9)|10|11|(3:13|14|(2:16|25)(1:24))(1:23)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0058 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005e A[SYNTHETIC, Splitter:B:13:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy r4, com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r5, com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo r6, com.tal.app.thinkacademy.live.core.live.datastorage.RoomData r7) {
        /*
            r3 = this;
            java.lang.String r0 = "_"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            java.lang.String r2 = r3.mInitModuleJsonStr     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r3.initTripleScreenLayout(r7)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r7 = r3.mGraffitiAgent     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            if (r7 == 0) goto L_0x0037
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r2.<init>()     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            int r5 = r5.getBizId()     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r2.append(r5)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r2.append(r0)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            java.lang.String r4 = r4.getId()     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r2.append(r4)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r2.append(r0)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            java.lang.String r4 = r6.getId()     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r2.append(r4)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            java.lang.String r4 = r2.toString()     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r7.initGraffiti(r4)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
        L_0x0037:
            r3.initWorkThread()     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r3.setListener()     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            r4 = 1
            r3.setResumedReady(r4)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            java.lang.String r4 = "remindDuration"
            java.lang.String r4 = r1.optString(r4)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            java.lang.String r5 = "perPageSize"
            java.lang.String r5 = r1.optString(r5)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ all -> 0x0058 }
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r6 = r3.mGraffitiAgent     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x0058
            r6.setPageSize(r5)     // Catch:{ all -> 0x0058 }
        L_0x0058:
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            if (r5 != 0) goto L_0x0075
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x006a }
            if (r4 <= 0) goto L_0x0075
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenPagerPluginView r5 = r3.canvasTripleScreenPager     // Catch:{ Exception -> 0x006a }
            r5.setRemindDuration(r4)     // Catch:{ Exception -> 0x006a }
            goto L_0x0075
        L_0x006a:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ JSONException -> 0x0071, NullPointerException -> 0x006f }
            goto L_0x0075
        L_0x006f:
            r4 = move-exception
            goto L_0x0072
        L_0x0071:
            r4 = move-exception
        L_0x0072:
            r4.printStackTrace()
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenBackPluginDriver.init(com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy, com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy, com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo, com.tal.app.thinkacademy.live.core.live.datastorage.RoomData):void");
    }

    private void setListener() {
        this.canvasTripleScreenPager.setCallBack(new CanvasTripleScreenPagerPluginView.CallBack() {
            public void onTouchAreaUpdate(RectF rectF) {
            }

            public void onCourseWareSwitchResult(int i, CourseWareBean courseWareBean) {
                CanvasTripleScreenBackPluginDriver.this.canvasTripleScreenPager.scrollToTop();
                boolean z = i == 2;
                XesLogTag access$200 = CanvasTripleScreenBackPluginDriver.TAG;
                XesLog.s(access$200, "-------翻页是否成功的回调succeed： " + i);
                if (z && courseWareBean != null && CanvasTripleScreenBackPluginDriver.this.mGraffitiAgent != null) {
                    XesLogTag access$2002 = CanvasTripleScreenBackPluginDriver.TAG;
                    XesLog.s(access$2002, "++++++翻页成功的回调succeed： " + GsonUtils.toJson(courseWareBean));
                    CanvasTripleScreenBackPluginDriver.this.mGraffitiAgent.turnPageTo(courseWareBean.getKey(), 2);
                }
            }
        });
    }

    private void initTripleScreenLayout(RoomData roomData) {
        this.canvasTripleScreenPager.initData(true);
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
        if (this.mLiveRoomProvider.isSmallClass() && roomData.getCourseRate() == LiveAreaCompat.CourseRate.RATE_16_9) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "initTripleScreenLayout，小班回放在16:9课件下，三分屏布局需要按照16:9居中展示");
            int i = (int) ((((float) newLp.width) * 9.0f) / 16.0f);
            newLp.topMargin += (newLp.height - i) / 2;
            newLp.height = i;
            XesLog.i(xesLogTag, "initTripleScreenLayout: layoutParams = " + CommonKtxKt.format(newLp));
        }
        this.mLiveRoomProvider.addView(this, this.canvasTripleScreenPager, "tripleScreenLayout", newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new CanvasTripleScreenBackPluginDriver$$ExternalSyntheticLambda0(this, roomData));
    }

    public /* synthetic */ void lambda$initTripleScreenLayout$0$CanvasTripleScreenBackPluginDriver(RoomData roomData, LiveAreaContext liveAreaContext) {
        if (this.canvasTripleScreenPager != null) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "课件回放>>>videoSizeChange");
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.canvasTripleScreenPager.getLayoutParams();
            liveAreaContext.getPptLp().mergeLp(layoutParams);
            if (this.mLiveRoomProvider.isSmallClass() && roomData.getCourseRate() == LiveAreaCompat.CourseRate.RATE_16_9) {
                XesLog.i(xesLogTag, "initTripleScreenLayout，布局变化监听，小班回放在16:9课件下，三分屏布局需要按照16:9居中展示");
                int i = (int) ((((float) layoutParams.width) * 9.0f) / 16.0f);
                layoutParams.topMargin += (layoutParams.height - i) / 2;
                layoutParams.height = i;
            }
            XesLog.i(xesLogTag, "initTripleScreenLayout: 布局变化监听, layoutParams = " + CommonKtxKt.format(layoutParams));
            this.canvasTripleScreenPager.setLayoutParams(layoutParams);
        }
    }

    private void setEnableGetTime(boolean z) {
        ThreadWorker threadWorker2 = this.threadWorker;
        if (threadWorker2 != null) {
            if (z) {
                threadWorker2.startPoll();
            } else {
                threadWorker2.pausePoll();
            }
        }
    }

    private void setVideoReady(boolean z) {
        this.videoReady = z;
        setEnableGetTime(z && this.resumedReady);
    }

    private void setResumedReady(boolean z) {
        this.resumedReady = z;
        setEnableGetTime(this.videoReady && z);
    }

    private void initWorkThread() {
        this.threadWorker.setUpdateListener(new ThreadWorker.UpdateListener() {
            public void onUpdate() {
                long access$400 = CanvasTripleScreenBackPluginDriver.this.currentSeiTimestamp - CanvasTripleScreenBackPluginDriver.this.lastSEITimeStamp;
                if (access$400 >= 0 || Math.abs(access$400) >= 900) {
                    if (CanvasTripleScreenBackPluginDriver.this.currentSeiTimestamp > 0) {
                        if (CanvasTripleScreenBackPluginDriver.this.mPlaybackViewModel != null) {
                            CanvasTripleScreenBackPluginDriver.this.mPlaybackViewModel.checkCoursewareState(CanvasTripleScreenBackPluginDriver.this.currentSeiTimestamp);
                            CanvasTripleScreenBackPluginDriver.this.mPlaybackViewModel.dispatchMetaInfoWithSei(CanvasTripleScreenBackPluginDriver.this.currentSeiTimestamp);
                        }
                        if (CanvasTripleScreenBackPluginDriver.this.mGraffitiAgent != null) {
                            try {
                                CanvasTripleScreenBackPluginDriver.this.mGraffitiAgent.beginDrawWithTimestamp(CanvasTripleScreenBackPluginDriver.this.currentSeiTimestamp - ParseUtils.tryParseLong(new JSONObject(CanvasTripleScreenBackPluginDriver.this.mLiveRoomProvider.getInitModuleMap().get("1012")).optString("canvasTimeStampOffset"), 0));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        CanvasTripleScreenBackPluginDriver.this.canvasTripleScreenPager.alignTimeStamp(CanvasTripleScreenBackPluginDriver.this.currentSeiTimestamp);
                    }
                    CanvasTripleScreenBackPluginDriver canvasTripleScreenBackPluginDriver = CanvasTripleScreenBackPluginDriver.this;
                    long unused = canvasTripleScreenBackPluginDriver.lastSEITimeStamp = canvasTripleScreenBackPluginDriver.currentSeiTimestamp;
                }
            }
        });
    }

    public void onChanged(PluginEventData pluginEventData) {
        String operation = pluginEventData.getOperation();
        operation.hashCode();
        char c = 65535;
        switch (operation.hashCode()) {
            case -249804029:
                if (operation.equals("player_status_play")) {
                    c = 0;
                    break;
                }
                break;
            case -249706543:
                if (operation.equals("player_status_stop")) {
                    c = 1;
                    break;
                }
                break;
            case 845701127:
                if (operation.equals("player_status_pause")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setResumedReady(true);
                return;
            case 1:
            case 2:
                setResumedReady(false);
                return;
            default:
                return;
        }
    }

    public void onDestroy() {
        GraffitiBackAgent graffitiBackAgent = this.mGraffitiAgent;
        if (graffitiBackAgent != null) {
            graffitiBackAgent.destroy();
            this.mGraffitiAgent = null;
        }
        CanvasTripleScreenPagerPluginView canvasTripleScreenPagerPluginView = this.canvasTripleScreenPager;
        if (canvasTripleScreenPagerPluginView != null) {
            canvasTripleScreenPagerPluginView.onDestroy();
        }
        ThreadWorker threadWorker2 = this.threadWorker;
        if (threadWorker2 != null) {
            threadWorker2.destroy();
        }
        PluginEventBus.unregister(DataBusKey.CLASS_REFRESH_KEY, this.observerCourseRefresh);
    }

    public void onMessage(String str, String str2) {
        if ("canvas_switch_courseware".equals(str) && this.canvasTripleScreenPager != null) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "回放", "收到课件翻页信令:" + str2);
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str).optJSONObject("currentCourseWare");
                CourseWareBean courseWareBean = (CourseWareBean) GsonUtils.fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), CourseWareBean.class);
                courseWareBean.planId = ParseUtils.tryParseInt(this.planInfo.getId(), 0);
                if (courseWareBean.timestamp <= this.currentSeiTimestamp) {
                    this.canvasTripleScreenPager.switchCourseWare(courseWareBean, false);
                    return;
                }
                XesLog.i(xesLogTag, "回放", "强制加载课件");
                this.canvasTripleScreenPager.switchCourseWare(courseWareBean, true);
            } catch (JSONException e) {
                e.printStackTrace();
                XesLogTag xesLogTag2 = TAG;
                XesLog.e(xesLogTag2, "回放-课件翻页信令解析失败:" + e.getMessage());
            }
        }
    }

    public void onPlaying(long j, long j2) {
        setVideoReady(true);
    }

    public void onSeiCurrent(long j) {
        long j2 = this.currentSeiTimestamp;
        if (j > j2 || j < j2 - 2000) {
            this.currentSeiTimestamp = j;
        }
    }

    public void onUnSupportActionList(List<WXWBAction> list, boolean z) {
        this.canvasTripleScreenPager.onUnSupportActionList(list);
    }
}
