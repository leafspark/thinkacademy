package com.tal.app.thinkacademy.live.business.liveplay.liveplayer;

import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.liveplay.bean.EmojiOverHideRequest;
import com.tal.app.thinkacademy.live.business.liveplay.bean.RtcStatusRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface RtcReportApi {
    @POST
    Call<HiResponse<EmptyBean>> rtcStatus(@Url String str, @Body RtcStatusRequest rtcStatusRequest);

    @POST("/api/emoji/v1/student/setOverHide")
    Call<HiResponse<EmptyBean>> updateEmojiOverHide(@Body EmojiOverHideRequest emojiOverHideRequest);
}
