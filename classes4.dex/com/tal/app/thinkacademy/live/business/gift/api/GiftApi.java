package com.tal.app.thinkacademy.live.business.gift.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftBean;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftSendBean;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftStatusBean;
import com.tal.app.thinkacademy.live.business.gift.bean.request.GiftListRequest;
import com.tal.app.thinkacademy.live.business.gift.bean.request.GiftStatusRequest;
import com.tal.app.thinkacademy.live.business.gift.bean.request.SendGiftRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface GiftApi {
    @POST
    Call<HiResponse<GiftBean>> requestGiftList(@Url String str, @Body GiftListRequest giftListRequest);

    @POST
    Call<HiResponse<GiftStatusBean>> requestGiftStatus(@Url String str, @Body GiftStatusRequest giftStatusRequest);

    @POST
    Call<HiResponse<GiftSendBean>> sendGift(@Url String str, @Body SendGiftRequest sendGiftRequest);
}
