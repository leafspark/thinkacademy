package com.tal.app.thinkacademy.live.abilitypack.coincenter.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinReqBody;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/api/CoinCenterApi;", "", "studentCoinAndMedal", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinData;", "url", "", "planId", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinReqBody;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinReqBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinCenterApi.kt */
public interface CoinCenterApi {
    @POST
    Object studentCoinAndMedal(@Url String str, @Body CoinReqBody coinReqBody, Continuation<? super HiResponse<CoinData>> continuation);
}
