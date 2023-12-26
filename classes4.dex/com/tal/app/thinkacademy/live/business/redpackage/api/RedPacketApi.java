package com.tal.app.thinkacademy.live.business.redpackage.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.redpackage.bean.RedPacketBean;
import com.tal.app.thinkacademy.live.business.redpackage.bean.RedPacketRankBean;
import com.tal.app.thinkacademy.live.business.redpackage.bean.RedPacketStatusBean;
import com.tal.app.thinkacademy.live.business.redpackage.bean.body.GrabRedPacketBody;
import com.tal.app.thinkacademy.live.business.redpackage.bean.body.RedPacketDetailBody;
import com.tal.app.thinkacademy.live.business.redpackage.bean.body.RedPacketStatusBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface RedPacketApi {
    @POST
    Call<HiResponse<RedPacketStatusBean>> getRedPacketStatus(@Url String str, @Body RedPacketStatusBody redPacketStatusBody);

    @POST
    Call<HiResponse<RedPacketBean>> grabRedPacket(@Url String str, @Body GrabRedPacketBody grabRedPacketBody);

    @POST
    Call<HiResponse<RedPacketRankBean>> viewDetails(@Url String str, @Body RedPacketDetailBody redPacketDetailBody);
}
