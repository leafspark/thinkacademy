package com.tal.app.thinkacademy.live.core.backplay.http.apis;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.request.EnterRequest;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.request.InitModuleRequest;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.request.MetaDataRequest;
import com.tal.app.thinkacademy.live.core.backplay.http.response.MetaDataEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.ClassroomDataEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.InitModuleEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.KeyEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LiveBackCoreApi {
    @POST("/api/classroom/v1/getClassroomData")
    Call<HiResponse<ClassroomDataEntity>> requestClassroomData(@Body KeyEntity keyEntity);

    @POST
    Call<HiResponse<EnterEntity>> requestEnter(@Url String str, @Body EnterRequest enterRequest);

    @POST
    Call<HiResponse<InitModuleEntity>> requestInitModule(@Url String str, @Header("tal_use_cache") boolean z, @Body InitModuleRequest initModuleRequest);

    @POST
    Call<HiResponse<MetaDataEntity>> requestMetaData(@Url String str, @Body MetaDataRequest metaDataRequest);

    @POST
    Call<HiResponse<EnterEntity>> requestPlaybackEnter(@Url String str, @Header("tal_use_cache") boolean z, @Body EnterRequest enterRequest);
}
