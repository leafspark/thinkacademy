package com.tal.app.thinkacademy.live.business.homework.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxEntity;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxMessage;
import com.tal.app.thinkacademy.live.business.homework.entity.body.PlanIdBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface HomeworkApi {
    @POST
    Call<HiResponse<PhotoBoxMessage>> getNewMessage(@Url String str, @Body PlanIdBody planIdBody);

    @POST
    Call<HiResponse<PhotoBoxEntity>> getPhotoBox(@Url String str, @Body PlanIdBody planIdBody);
}
