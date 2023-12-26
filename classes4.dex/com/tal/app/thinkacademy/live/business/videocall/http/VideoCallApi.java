package com.tal.app.thinkacademy.live.business.videocall.http;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.videocall.entity.LinkMicResponseBean;
import com.tal.app.thinkacademy.live.business.videocall.entity.body.LinkMicBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface VideoCallApi {
    @POST
    Call<HiResponse<LinkMicResponseBean>> linkMicRequest(@Url String str, @Body LinkMicBody linkMicBody);
}
