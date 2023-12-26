package com.tal.app.thinkacademy.live.business.redpackage.driver;

import android.content.Context;
import android.os.Bundle;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.LiveStabilityUtils;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.redpackage.IActionListener;
import com.tal.app.thinkacademy.live.business.redpackage.api.RedPacketApi;
import com.tal.app.thinkacademy.live.business.redpackage.bean.RedPacketBean;
import com.tal.app.thinkacademy.live.business.redpackage.bean.RedPacketStatusBean;
import com.tal.app.thinkacademy.live.business.redpackage.bean.body.GrabRedPacketBody;
import com.tal.app.thinkacademy.live.business.redpackage.bean.body.RedPacketStatusBody;
import com.tal.app.thinkacademy.live.business.redpackage.config.RedPacketConfig;
import com.tal.app.thinkacademy.live.business.redpackage.view.RedPacketPluginView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import java.util.HashMap;
import retrofit2.Call;

public abstract class BaseRedPacketPluginDriver extends BaseLivePluginDriver implements IActionListener {
    protected static Tag TAG = Tag.RED_PACKAGE;
    protected int classId = this.mCourseInfo.getClassId();
    protected String interactId;
    protected Context mContext;
    protected CourseInfoProxy mCourseInfo;
    protected RedPacketPluginView mRedPackagePluginView;
    protected int planId;
    protected boolean pub;
    protected RedPacketBean redPacketBean;
    protected UserInfoProxy userInfoProxy;

    /* access modifiers changed from: protected */
    public abstract IActionListener initIActionListener();

    public BaseRedPacketPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.userInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        CourseInfoProxy courseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.mCourseInfo = courseInfo;
        this.planId = courseInfo.getPlanId();
    }

    /* access modifiers changed from: protected */
    public void loadPlugin() {
        XesLog.i(TAG, "加载红包插件");
        if (this.mRedPackagePluginView != null) {
            RedPacketBean redPacketBean2 = this.redPacketBean;
            if (redPacketBean2 != null) {
                updateUserCoins(redPacketBean2.getCoin());
            }
            removeView();
        }
        RedPacketPluginView redPacketPluginView = new RedPacketPluginView(this.mContext);
        this.mRedPackagePluginView = redPacketPluginView;
        redPacketPluginView.setDriver(this);
        this.mRedPackagePluginView.setActionListener(initIActionListener());
        this.mRedPackagePluginView.layoutView(LiveAreaContext.get());
        this.mLiveRoomProvider.addView(this, this.mRedPackagePluginView, this.mPluginConfData.getViewLevel(RedPacketConfig.REDPACKAGE), LiveAreaContext.get().getScreenLp().newLp());
        LiveAreaContext.get().layoutObserver.observe(this, new BaseRedPacketPluginDriver$$ExternalSyntheticLambda0(this));
        InteractLogReport.uploadLog(this.interactId, this.planId, this.classId);
        SoundPoolUtils.play(this.mContext, R.raw.live_business_redpacket_show, 0);
    }

    public /* synthetic */ void lambda$loadPlugin$0$BaseRedPacketPluginDriver(LiveAreaContext liveAreaContext) {
        if (this.mRedPackagePluginView != null) {
            XesLog.i(TAG, "红包>>>videoSizeChange");
            this.mRedPackagePluginView.layoutView(liveAreaContext);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [com.tal.app.thinkacademy.live.business.redpackage.view.RedPacketPluginView, android.view.View] */
    /* access modifiers changed from: protected */
    public void removeView() {
        XesLog.i(TAG, "移除红包视图");
        RedPacketPluginView redPacketPluginView = this.mRedPackagePluginView;
        if (redPacketPluginView != null) {
            redPacketPluginView.destroy();
            this.mLiveRoomProvider.removeView(this.mRedPackagePluginView);
            this.mRedPackagePluginView = null;
        }
    }

    public void onDestroy() {
        XesLog.i(TAG, "红包插件销毁");
        this.redPacketBean = null;
        removeView();
    }

    /* access modifiers changed from: protected */
    public void getRedPacketStatus() {
        Tag tag = TAG;
        XesLog.i(tag, "获取红包状态 interactId:" + this.interactId);
        Call<HiResponse<RedPacketStatusBean>> redPacketStatus = ((RedPacketApi) Api.create(RedPacketApi.class)).getRedPacketStatus(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/redbag/student/status", new RedPacketStatusBody(this.planId, this.interactId));
        AnonymousClass2 r1 = new OmyCallback<HiResponse<RedPacketStatusBean>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<RedPacketStatusBean> hiResponse) {
                RedPacketStatusBean data = hiResponse.getData();
                if (data == null || data.isIsAttend()) {
                    XesLog.i(BaseRedPacketPluginDriver.TAG, "获取红包状态，学员已参加过红包互动");
                    return;
                }
                BaseRedPacketPluginDriver.this.loadPlugin();
            }
        };
        if (!(redPacketStatus instanceof Call)) {
            redPacketStatus.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) redPacketStatus, r1);
        }
    }

    public void openIt() {
        Call<HiResponse<RedPacketBean>> grabRedPacket = ((RedPacketApi) Api.create(RedPacketApi.class)).grabRedPacket(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/redbag/student/grab", new GrabRedPacketBody(this.planId, this.interactId, this.classId));
        AnonymousClass4 r1 = new OmyCallback<HiResponse<RedPacketBean>>(new IError() {
            public void onFail(int i, String str) {
                ToastUtils.showShort(R.string.net_fail);
                LiveStabilityUtils.live_stability_track("Redbag", BaseRedPacketPluginDriver.this.interactId, "submit", 0, str);
            }

            public void onError(int i, String str) {
                if (i == 41001) {
                    XesLog.e(BaseRedPacketPluginDriver.TAG, "已参与过红包");
                    if (BaseRedPacketPluginDriver.this.mRedPackagePluginView != null) {
                        BaseRedPacketPluginDriver.this.mRedPackagePluginView.ooPs();
                    }
                }
                LiveStabilityUtils.live_stability_track("Redbag", BaseRedPacketPluginDriver.this.interactId, "submit", 0, str);
            }
        }) {
            public void onSuccess(HiResponse<RedPacketBean> hiResponse) {
                if (hiResponse.getCode() == 0) {
                    XesLog.s(BaseRedPacketPluginDriver.TAG, "成功抢到红包");
                    BaseRedPacketPluginDriver.this.redPacketBean = hiResponse.getData();
                    if (BaseRedPacketPluginDriver.this.mRedPackagePluginView != null) {
                        BaseRedPacketPluginDriver.this.mRedPackagePluginView.receiveIt(BaseRedPacketPluginDriver.this.redPacketBean);
                    }
                    SoundPoolUtils.play(BaseRedPacketPluginDriver.this.mContext, R.raw.live_business_get_coins, 0);
                    BaseRedPacketPluginDriver.this.track_receive_redPacket();
                    HWEventTracking.get().ostaIaRedpacket(BaseRedPacketPluginDriver.this.interactId, Integer.valueOf(BaseRedPacketPluginDriver.this.redPacketBean.getCoin()));
                    LiveStabilityUtils.live_stability_track("Redbag", BaseRedPacketPluginDriver.this.interactId, "submit", 1, "");
                }
            }
        };
        if (!(grabRedPacket instanceof Call)) {
            grabRedPacket.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) grabRedPacket, r1);
        }
    }

    public void updateUserCoins(int i) {
        int goldNum = this.mLiveRoomProvider.getDataStorage().getUserInfo().getGoldNum() + i;
        this.mLiveRoomProvider.getDataStorage().getUserInfo().setGoldNum(goldNum);
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(BaseRedPacketPluginDriver.class, DataBusKey.USERCOINS_KEY, goldNum + "", new CoinEventData(GoldSource.RED_PACKAGE_GOLD, i, true, true)));
    }

    public void onFlyFinish() {
        RedPacketBean redPacketBean2 = this.redPacketBean;
        updateUserCoins(redPacketBean2 != null ? redPacketBean2.getCoin() : 0);
    }

    public void closePlugin() {
        LiveStabilityUtils.live_stability_track("Redbag", this.interactId, "end", 1, "");
        destroy();
    }

    public void track_start_redPacket() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.start_redPacket, trackMap);
    }

    public void track_show_redPacket() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.show_redPacket, trackMap);
    }

    public void track_click_redPacket(int i) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.click_redPacket, trackMap);
        DriverTrack.INSTANCE.classroomInteractRedPacketClick(i, this.interactId);
    }

    public void track_receive_redPacket() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.receive_redPacket, trackMap);
    }

    public void track_click_close_redPacket() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.click_close_redPacket, trackMap);
    }
}
