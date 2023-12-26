package com.tal.app.thinkacademy.live.business.vote.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteBean;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteStatusBean;
import com.tal.app.thinkacademy.live.business.vote.entity.body.InteractVoteStatusBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface VoteApi {
    @POST
    Call<HiResponse<VoteStatusBean>> interactVoteStatus(@Url String str, @Body InteractVoteStatusBody interactVoteStatusBody);

    @POST
    Call<HiResponse<Object>> noAnswerCommit(@Url String str, @Body RequestBody requestBody);

    @POST
    Call<HiResponse<VoteBean>> submitVote(@Url String str, @Body RequestBody requestBody);
}
