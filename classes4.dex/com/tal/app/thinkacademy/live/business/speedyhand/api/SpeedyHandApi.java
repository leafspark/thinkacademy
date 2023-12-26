package com.tal.app.thinkacademy.live.business.speedyhand.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandApiResult;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH'¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/speedyhand/api/SpeedyHandApi;", "", "answerRob", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/SpeedyHandApiResult;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/speedyhand/api/SpeedyHandBody;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandApi.kt */
public interface SpeedyHandApi {
    @POST
    Call<HiResponse<SpeedyHandApiResult>> answerRob(@Url String str, @Body SpeedyHandBody speedyHandBody);
}
