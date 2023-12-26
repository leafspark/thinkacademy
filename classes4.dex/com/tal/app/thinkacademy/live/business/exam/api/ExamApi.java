package com.tal.app.thinkacademy.live.business.exam.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfo;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfoBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ExamApi {
    @POST
    Call<HiResponse<ExamInfo>> getExamInfo(@Url String str, @Body ExamInfoBody examInfoBody);
}
