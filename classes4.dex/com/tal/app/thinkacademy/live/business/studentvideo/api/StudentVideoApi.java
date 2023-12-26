package com.tal.app.thinkacademy.live.business.studentvideo.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.body.StudentListBody;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.body.StudentVideoUidBody;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface StudentVideoApi {
    @POST
    Call<HiResponse<List<StudentVideoBean.ListBean>>> getSmallClassStudentList(@Url String str, @Body StudentListBody studentListBody);

    @POST
    Call<HiResponse<StudentVideoBean>> getStudentVideoUid(@Url String str, @Body StudentVideoUidBody studentVideoUidBody);
}
