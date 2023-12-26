package com.tal.app.thinkacademy.live.business.canvastriplescreen.http;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.CoursePreloadRequest;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface CanvasApi {
    public static final String preloadUrl = (LiveUrls.HTTP_LIVE_BASE + "v1/student/courseware/preload");

    @POST
    Call<HiResponse<JSONObject>> getCoursePreload(@Url String str, @Body CoursePreloadRequest coursePreloadRequest);
}
