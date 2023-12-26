package com.tal.app.thinkacademy.live.business.heartbeat.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.heartbeat.entity.request.HeartBeatBody;
import com.tal.app.thinkacademy.live.business.heartbeat.entity.request.HeartBeatPlaybackBody;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveBackMsgBean;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface UserHeartBeatApi {
    @POST
    Call<HiResponse<LiveBackMsgBean>> heartBeat(@Url String str, @Body HeartBeatBody heartBeatBody);

    @POST
    Call<HiResponse<LiveBackMsgBean>> heartBeatPlayback(@Url String str, @Body HeartBeatPlaybackBody heartBeatPlaybackBody);
}
