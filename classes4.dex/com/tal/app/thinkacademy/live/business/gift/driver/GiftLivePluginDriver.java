package com.tal.app.thinkacademy.live.business.gift.driver;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
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
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.gift.IActionListener;
import com.tal.app.thinkacademy.live.business.gift.api.GiftApi;
import com.tal.app.thinkacademy.live.business.gift.bean.BarrageBean;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftBean;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftSendBean;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftStatusBean;
import com.tal.app.thinkacademy.live.business.gift.bean.request.GiftListRequest;
import com.tal.app.thinkacademy.live.business.gift.bean.request.GiftStatusRequest;
import com.tal.app.thinkacademy.live.business.gift.bean.request.SendGiftRequest;
import com.tal.app.thinkacademy.live.business.gift.config.GiftConfig;
import com.tal.app.thinkacademy.live.business.gift.view.BarrageLiveView;
import com.tal.app.thinkacademy.live.business.gift.view.GiftLivePluginView;
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
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

@PluginAnnotation(desc = "礼物插件", ircType = {"openGift", "sendGiftBarrage", "mode"}, moduleId = "6")
@ViewLevels({@ViewLevel(level = 20, name = "openGift"), @ViewLevel(level = 30, name = "sendGiftBarrage")})
public class GiftLivePluginDriver extends BaseLivePluginDriver implements IActionListener {
    private static final String TAG = "GiftLivePluginDriver";
    /* access modifiers changed from: private */
    public BarrageLiveView barrageLiveView;
    /* access modifiers changed from: private */
    public int classId;
    /* access modifiers changed from: private */
    public GiftLivePluginView giftLivePluginView;
    private String gradeId;
    private String icon_mobile;
    /* access modifiers changed from: private */
    public String interactId;
    /* access modifiers changed from: private */
    public Context mContext;
    private CourseInfoProxy mCourseInfo;
    /* access modifiers changed from: private */
    public String mUserId;
    private String message;
    private String nickName;
    private boolean open;
    /* access modifiers changed from: private */
    public int planId = this.mCourseInfo.getPlanId();
    private long userId;
    /* access modifiers changed from: private */
    public UserInfoProxy userInfoProxy;

    public void onDestroy() {
    }

    public GiftLivePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.mCourseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.userInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        this.gradeId = iLiveRoomProvider.getDataStorage().getPlanInfo().getGradeIds();
        this.classId = this.mCourseInfo.getClassId();
        this.mUserId = this.userInfoProxy.getId();
    }

    public void onMessage(String str, String str2) {
        BarrageLiveView barrageLiveView2;
        if (GiftConfig.GIFT.equalsIgnoreCase(str)) {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(str, str2);
                XesLog.ut(TAG, jsonObject);
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(GiftConfig.GIFT);
                if (optJSONObject != null) {
                    this.interactId = optJSONObject.optString("interactId", "");
                    this.open = optJSONObject.optBoolean("open");
                }
                if (this.open) {
                    track_start_openGift();
                    requestGiftStatus();
                    LiveStabilityUtils.live_stability_track("Gift", this.interactId, "start", 1, "");
                    loadBarrage();
                    return;
                }
                removePlugin();
                LiveStabilityUtils.live_stability_track("Gift", this.interactId, "end", 1, "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (GiftConfig.BARRAGE.equalsIgnoreCase(str) && this.open) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty(str, str2);
                XesLog.ut(TAG, jsonObject2);
                JSONObject optJSONObject2 = new JSONObject(str2).optJSONObject(GiftConfig.BARRAGE);
                if (optJSONObject2 != null) {
                    String optString = optJSONObject2.optString("message");
                    this.nickName = optJSONObject2.optString("nickName");
                    this.userId = optJSONObject2.optLong("userId");
                    this.icon_mobile = optJSONObject2.optString("icon_mobile");
                    BarrageBean barrageBean = new BarrageBean(optString, this.nickName, this.userId, this.icon_mobile);
                    String str3 = this.mUserId;
                    if (!str3.equals(this.userId + "") && (barrageLiveView2 = this.barrageLiveView) != null) {
                        barrageLiveView2.produceBarrage(barrageBean);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void loadGift(GiftStatusBean giftStatusBean) {
        if (this.giftLivePluginView == null) {
            GiftLivePluginView giftLivePluginView2 = new GiftLivePluginView(this.mContext);
            this.giftLivePluginView = giftLivePluginView2;
            giftLivePluginView2.setDriver(this);
            this.giftLivePluginView.setGiftStatusBean(giftStatusBean);
            this.giftLivePluginView.setIActionListener(this);
            this.giftLivePluginView.layoutView();
            this.mLiveRoomProvider.addView(this, this.giftLivePluginView, this.mPluginConfData.getViewLevel(GiftConfig.GIFT), LiveAreaContext.get().getPptLp().newLp());
            LiveAreaContext.get().layoutObserver.observe(this, new GiftLivePluginDriver$$ExternalSyntheticLambda1(this));
        }
    }

    public /* synthetic */ void lambda$loadGift$0$GiftLivePluginDriver(LiveAreaContext liveAreaContext) {
        GiftLivePluginView giftLivePluginView2 = this.giftLivePluginView;
        if (giftLivePluginView2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) giftLivePluginView2.getLayoutParams();
            LiveAreaContext.get().getPptLp().mergeLp(layoutParams);
            this.giftLivePluginView.setLayoutParams(layoutParams);
            this.giftLivePluginView.layoutView();
        }
    }

    private void loadBarrage() {
        if (this.barrageLiveView == null) {
            this.barrageLiveView = new BarrageLiveView(this.mContext);
            this.mLiveRoomProvider.addView(this, this.barrageLiveView, this.mPluginConfData.getViewLevel(GiftConfig.BARRAGE), LiveAreaContext.get().getPptLp().newLp());
            LiveAreaContext.get().layoutObserver.observe(this, new GiftLivePluginDriver$$ExternalSyntheticLambda0(this));
        }
    }

    public /* synthetic */ void lambda$loadBarrage$1$GiftLivePluginDriver(LiveAreaContext liveAreaContext) {
        BarrageLiveView barrageLiveView2 = this.barrageLiveView;
        if (barrageLiveView2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) barrageLiveView2.getLayoutParams();
            LiveAreaContext.get().getPptLp().mergeLp(layoutParams);
            this.barrageLiveView.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.tal.app.thinkacademy.live.business.gift.view.BarrageLiveView, android.view.View] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.view.View, com.tal.app.thinkacademy.live.business.gift.view.GiftLivePluginView] */
    private void removePlugin() {
        if (this.giftLivePluginView != null) {
            this.mLiveRoomProvider.removeView(this.giftLivePluginView);
            this.giftLivePluginView = null;
        }
        if (this.barrageLiveView != null) {
            this.mLiveRoomProvider.removeView(this.barrageLiveView);
            this.barrageLiveView = null;
        }
    }

    public void requestGiftStatus() {
        Call<HiResponse<GiftStatusBean>> requestGiftStatus = ((GiftApi) Api.create(GiftApi.class)).requestGiftStatus(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/gift/student/status", new GiftStatusRequest(this.planId, this.interactId));
        AnonymousClass2 r1 = new OmyCallback<HiResponse<GiftStatusBean>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<GiftStatusBean> hiResponse) {
                SoundPoolUtils.play(GiftLivePluginDriver.this.mContext, R.raw.live_business_gift_persent, 0);
                GiftLivePluginDriver.this.loadGift(hiResponse.getData());
                InteractLogReport.uploadLog(GiftLivePluginDriver.this.interactId, GiftLivePluginDriver.this.planId, GiftLivePluginDriver.this.classId);
            }
        };
        if (!(requestGiftStatus instanceof Call)) {
            requestGiftStatus.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) requestGiftStatus, r1);
        }
    }

    public void initGiftList() {
        Call<HiResponse<GiftBean>> requestGiftList = ((GiftApi) Api.create(GiftApi.class)).requestGiftList(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/gift/v2/detail", new GiftListRequest(this.gradeId, this.planId));
        AnonymousClass4 r1 = new OmyCallback<HiResponse<GiftBean>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<GiftBean> hiResponse) {
                GiftBean data = hiResponse.getData();
                if (GiftLivePluginDriver.this.giftLivePluginView != null) {
                    GiftLivePluginDriver.this.giftLivePluginView.setGiftBean(data, GiftLivePluginDriver.this.userInfoProxy);
                }
            }
        };
        if (!(requestGiftList instanceof Call)) {
            requestGiftList.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) requestGiftList, r1);
        }
    }

    public void sendGift(final GiftBean.GiftListBean giftListBean) {
        HWEventTracking.get().ostaIaGifts(this.interactId, giftListBean.getGiftName(), Integer.valueOf(giftListBean.getCoin()));
        SoundPoolUtils.play(this.mContext, R.raw.live_business_gift_send, 0);
        Call<HiResponse<GiftSendBean>> sendGift = ((GiftApi) Api.create(GiftApi.class)).sendGift(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/gift/student/v2/send", new SendGiftRequest(this.planId, this.interactId, giftListBean.getGiftId(), this.classId));
        AnonymousClass6 r1 = new OmyCallback<HiResponse<GiftSendBean>>(new IError() {
            public void onFail(int i, String str) {
                LiveStabilityUtils.live_stability_track("Gift", GiftLivePluginDriver.this.interactId, "submit", 0, str);
            }

            public void onError(int i, String str) {
                LiveStabilityUtils.live_stability_track("Gift", GiftLivePluginDriver.this.interactId, "submit", 0, str);
            }
        }) {
            public void onSuccess(HiResponse<GiftSendBean> hiResponse) {
                GiftSendBean data = hiResponse.getData();
                if (GiftLivePluginDriver.this.giftLivePluginView != null) {
                    GiftLivePluginDriver.this.giftLivePluginView.setGiftSendBean(data);
                }
                GiftLivePluginDriver.this.updateUserCoins(data.getUserLatestCoin());
                if (GiftLivePluginDriver.this.barrageLiveView != null) {
                    GiftLivePluginDriver.this.barrageLiveView.produceBarrage(new BarrageBean(giftListBean.getText().replace("#name#", GiftLivePluginDriver.this.mContext.getString(R.string.i)), "I", Long.parseLong(GiftLivePluginDriver.this.mUserId), giftListBean.getIconApp()));
                }
                LiveStabilityUtils.live_stability_track("Gift", GiftLivePluginDriver.this.interactId, "submit", 1, "");
            }
        };
        if (!(sendGift instanceof Call)) {
            sendGift.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) sendGift, r1);
        }
    }

    public void updateUserCoins(int i) {
        this.mLiveRoomProvider.getDataStorage().getUserInfo().setGoldNum(i);
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(GiftLivePluginDriver.class, DataBusKey.USERCOINS_KEY, i + "", new CoinEventData(GoldSource.GIFT_GOLD, -1, false, false)));
    }

    public void track_start_openGift() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.start_openGift, trackMap);
    }

    public void track_show_openGift() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.show_openGift, trackMap);
    }

    public void track_click_openGift() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.click_openGift, trackMap);
    }

    public void track_show_send_limit_openGif() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.show_send_limit_openGif, trackMap);
    }

    public void trackClickOpenGift() {
        DriverTrack.INSTANCE.classroomInteractGiftIcon(this.interactId);
    }

    public void trackClickSendGift(GiftBean.GiftListBean giftListBean, int i) {
        if (giftListBean != null) {
            DriverTrack.INSTANCE.classroomInteractGift(giftListBean.getGiftId(), giftListBean.getCoin(), i, this.interactId);
        } else {
            DriverTrack.INSTANCE.classroomInteractGift(-1, -1, i, this.interactId);
        }
    }
}
