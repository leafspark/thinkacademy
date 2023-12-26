package com.tal.app.thinkacademy.live.business.livemessage.http;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveBackMsgBean;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessagePrivateEntity;
import com.tal.app.thinkacademy.live.business.livemessage.entity.PlayBackMsgBean;
import com.tal.app.thinkacademy.live.business.livemessage.entity.body.LiveBackMsgBody;
import com.tal.app.thinkacademy.live.business.livemessage.entity.body.LivePrivateMsgBody;
import com.tal.app.thinkacademy.live.business.livemessage.entity.body.PlayBackMsgBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LiveMsgApi {
    @POST
    Call<HiResponse<LiveBackMsgBean>> getLiveBackMsg(@Url String str, @Body LiveBackMsgBody liveBackMsgBody);

    @POST
    Call<HiResponse<LiveMessagePrivateEntity>> getLivePrivateMsg(@Url String str, @Body LivePrivateMsgBody livePrivateMsgBody);

    @POST
    Call<HiResponse<PlayBackMsgBean>> getPlayBackMsg(@Url String str, @Body PlayBackMsgBody playBackMsgBody);
}
