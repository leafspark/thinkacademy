package com.tal.app.thinkacademy.live.business.heartbeat;

import android.os.Bundle;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.heartbeat.api.UserHeartBeatApi;
import com.tal.app.thinkacademy.live.business.heartbeat.entity.request.HeartBeatPlaybackBody;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveBackMsgBean;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import retrofit2.Call;

@PluginAnnotation(desc = "用户在线时长，心跳", launchType = "initmodule", liveType = 1, moduleId = "11")
public class UserHeartbeatBackDriver extends BaseHeartbeatDriver implements PlayerTimeCallBack {
    long currentPosition;
    boolean isFirstRequest = true;

    public void onSeiCurrent(long j) {
    }

    public UserHeartbeatBackDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        iLiveRoomProvider.registerPlayerTimeCallback(this);
    }

    public void heartBeatRequest(String str, int i, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mLiveRoomProvider == null || this.mLiveRoomProvider.getDataStorage() == null || this.mLiveRoomProvider.getDataStorage().getPlanInfo() == null || this.mLiveRoomProvider.getDataStorage().getCourseInfo() == null || this.mLiveRoomProvider.getDataStorage().getRoomData() == null) {
                XesLog.dt("heartBeat request fail, base info error", new Object[0]);
            } else {
                PlanInfoProxy planInfo = this.mLiveRoomProvider.getDataStorage().getPlanInfo();
                CourseInfoProxy courseInfo = this.mLiveRoomProvider.getDataStorage().getCourseInfo();
                RoomData roomData = this.mLiveRoomProvider.getDataStorage().getRoomData();
                String valueOf = String.valueOf(roomData.getServeNowTime());
                String valueOf2 = String.valueOf(courseInfo.getClassId());
                String id = planInfo.getId();
                int bizId = courseInfo.getBizId();
                int streamMode = roomData.getStreamMode();
                if (!this.isFirstRequest) {
                    Call<HiResponse<LiveBackMsgBean>> heartBeatPlayback = ((UserHeartBeatApi) Api.create(UserHeartBeatApi.class)).heartBeatPlayback(str, new HeartBeatPlaybackBody(valueOf2, bizId, id, streamMode, false, 4, valueOf, String.valueOf(this.currentPosition), i, EnterRoomMuteData.STATUS_UN_MUTE));
                    AnonymousClass2 r3 = new OmyCallback<HiResponse<LiveBackMsgBean>>(new IError() {
                        public void onError(int i, String str) {
                        }

                        public void onFail(int i, String str) {
                        }
                    }) {
                        public void onSuccess(HiResponse<LiveBackMsgBean> hiResponse) {
                        }
                    };
                    if (!(heartBeatPlayback instanceof Call)) {
                        heartBeatPlayback.enqueue(r3);
                    } else {
                        Retrofit2Instrumentation.enqueue((Call) heartBeatPlayback, r3);
                    }
                }
            }
            this.isFirstRequest = false;
            postRequestDelayed((long) (i * 1000));
        }
    }

    public void onPlaying(long j, long j2) {
        this.currentPosition = j;
    }
}
