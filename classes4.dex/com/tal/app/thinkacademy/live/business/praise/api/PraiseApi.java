package com.tal.app.thinkacademy.live.business.praise.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.praise.bean.CoinEntity;
import com.tal.app.thinkacademy.live.business.praise.bean.RewardBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface PraiseApi {
    @POST
    Call<HiResponse<CoinEntity>> submitPraise(@Url String str, @Body RewardBody rewardBody);
}
