package com.tal.app.thinkacademy.live.core.live.http.apis;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.core.live.bean.ReportDeviceBody;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LiveCoreApi {
    @POST("/api/emoji/v1/student/detail")
    Call<HiResponse<EmojiDetailEntity>> getEmojiDetail();

    @POST("/api/classroom/v1/student/reportDeviceInfo")
    Call<HiResponse<Object>> reportDeviceInfo(@Body ReportDeviceBody reportDeviceBody);
}
