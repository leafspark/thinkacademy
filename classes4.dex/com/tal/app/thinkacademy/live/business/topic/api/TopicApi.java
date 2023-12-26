package com.tal.app.thinkacademy.live.business.topic.api;

import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractStateBean;
import com.tal.app.thinkacademy.live.business.topic.bean.request.InteractStatusRequest;
import com.tal.app.thinkacademy.live.business.topic.bean.request.SubmitAnswerRequest;
import com.tal.app.thinkacademy.live.business.topic.bean.request.UploadLogRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface TopicApi {
    @POST
    Call<HiResponse<InteractStateBean>> interactStatus(@Url String str, @Body InteractStatusRequest interactStatusRequest);

    @POST
    Call<HiResponse<AnswerBean>> submitAnswer(@Url String str, @Body SubmitAnswerRequest submitAnswerRequest);

    @POST
    Call<HiResponse<EmptyBean>> uploadLog(@Url String str, @Body UploadLogRequest uploadLogRequest);
}
