package com.tal.app.thinkacademy.live.business.sign.entity;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.sign.entity.body.SignBody;
import com.tal.app.thinkacademy.live.business.sign.entity.body.SignInBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface BusinessApi {
    @POST
    Call<HiResponse<SignBean>> getSign(@Url String str, @Body SignBody signBody);

    @POST
    Call<HiResponse<SignInExecuteEntity>> signIn(@Url String str, @Body SignInBody signInBody);
}
