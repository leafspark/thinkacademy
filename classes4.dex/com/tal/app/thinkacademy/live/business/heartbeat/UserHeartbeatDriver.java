package com.tal.app.thinkacademy.live.business.heartbeat;

import android.os.Bundle;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.utils.HeartBeatUtil;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.heartbeat.api.UserHeartBeatApi;
import com.tal.app.thinkacademy.live.business.heartbeat.entity.request.HeartBeatBody;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveBackMsgBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import retrofit2.Call;

@PluginAnnotation(desc = "用户在线时长，心跳", launchType = "initmodule", moduleId = "11")
public class UserHeartbeatDriver extends BaseHeartbeatDriver {
    boolean isFirstRequest = true;
    boolean isParentAuditor = false;
    private RtcViewModel mRtcViewModel;

    public UserHeartbeatDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        if (!(iLiveRoomProvider == null || iLiveRoomProvider.getDataStorage() == null || iLiveRoomProvider.getDataStorage().getCourseInfo() == null)) {
            this.isParentAuditor = iLiveRoomProvider.getDataStorage().getCourseInfo().getIsParentAuditLocal();
        }
        this.mRtcViewModel = AbilityPack.get().getViewModel(RtcViewModel.class);
    }

    public void heartBeatRequest(String str, int i, boolean z) {
        if (this.mLiveRoomProvider == null || this.mLiveRoomProvider.getDataStorage() == null || this.mLiveRoomProvider.getDataStorage().getPlanInfo() == null || this.mLiveRoomProvider.getDataStorage().getCourseInfo() == null || this.mLiveRoomProvider.getDataStorage().getRoomData() == null) {
            XesLog.dt("heartBeat request fail, base info error", new Object[0]);
            return;
        }
        try {
            PlanInfoProxy planInfo = this.mLiveRoomProvider.getDataStorage().getPlanInfo();
            CourseInfoProxy courseInfo = this.mLiveRoomProvider.getDataStorage().getCourseInfo();
            RoomData roomData = this.mLiveRoomProvider.getDataStorage().getRoomData();
            String valueOf = String.valueOf(roomData.getServeNowTime());
            String valueOf2 = String.valueOf(courseInfo.getClassId());
            int bizId = courseInfo.getBizId();
            String id = planInfo.getId();
            int streamMode = roomData.getStreamMode();
            HeartBeatBody heartBeatBody = new HeartBeatBody();
            heartBeatBody.setClassId(valueOf2);
            heartBeatBody.setBizId(bizId);
            heartBeatBody.setPlanId(id);
            heartBeatBody.setPlanStatus(streamMode);
            heartBeatBody.setLive(true);
            heartBeatBody.setFromType(4);
            heartBeatBody.setDottingTime(valueOf);
            heartBeatBody.setDuration(i);
            heartBeatBody.setSuspend(z);
            heartBeatBody.setStuCouId(EnterRoomMuteData.STATUS_UN_MUTE);
            heartBeatBody.setKejianStatus(HeartBeatUtil.getKejianStatus());
            heartBeatBody.setIrcCodeCount(HeartBeatUtil.getIrcCodeCount());
            heartBeatBody.setIrcCurrentCode(HeartBeatUtil.getIrcCurrentCode());
            heartBeatBody.setRtcRoundTripDelayed(HeartBeatUtil.getRtcRoundTripDelayed());
            heartBeatBody.setRtcDownlinkPacketLossRate((double) HeartBeatUtil.getRtcDownlinkPacketLossRate());
            RtcViewModel rtcViewModel = this.mRtcViewModel;
            if (rtcViewModel == null || !rtcViewModel.getMLocalVideoEnable()) {
                heartBeatBody.setCameraState(2);
            } else {
                heartBeatBody.setCameraState(1);
            }
            if (this.isParentAuditor) {
                heartBeatBody.setIsParentAudition(1);
            } else {
                heartBeatBody.setIsParentAudition(0);
            }
            if (!this.isFirstRequest) {
                XesLog.dt("心跳", "camera state(1打开，2关闭) = " + heartBeatBody.getCameraState());
                Call<HiResponse<LiveBackMsgBean>> heartBeat = ((UserHeartBeatApi) Api.create(UserHeartBeatApi.class)).heartBeat(LiveUrls.PLAY_HEART_BEAT, heartBeatBody);
                AnonymousClass2 r9 = new OmyCallback<HiResponse<LiveBackMsgBean>>(new IError() {
                    public void onFail(int i, String str) {
                        HeartBeatUtil.clearData();
                    }

                    public void onError(int i, String str) {
                        HeartBeatUtil.clearData();
                    }
                }) {
                    public void onSuccess(HiResponse<LiveBackMsgBean> hiResponse) {
                        HeartBeatUtil.clearData();
                    }
                };
                if (!(heartBeat instanceof Call)) {
                    heartBeat.enqueue(r9);
                } else {
                    Retrofit2Instrumentation.enqueue((Call) heartBeat, r9);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isFirstRequest = false;
        postRequestDelayed((long) (i * 1000));
    }
}
