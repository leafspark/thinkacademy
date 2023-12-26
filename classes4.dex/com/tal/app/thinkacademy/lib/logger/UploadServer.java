package com.tal.app.thinkacademy.lib.logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

interface UploadServer {
    @POST
    Call<ResponseBody> uploadLog(@Url String str, @Body XesLogJsonObjectBean xesLogJsonObjectBean);
}
