package com.tal.app.thinkacademy.live.business.redpackagerain.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainReportCoinBody;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainStatusBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainStatusBody;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\tH'J*\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/api/RedPackageRainApi;", "", "getRedPackageRainStatus", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainStatusBean;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainStatusBody;", "reportRedPackageRainCoin", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainReportCoinBody;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainApi.kt */
public interface RedPackageRainApi {
    @POST
    Call<HiResponse<RedPackageRainStatusBean>> getRedPackageRainStatus(@Url String str, @Body RedPackageRainStatusBody redPackageRainStatusBody);

    @POST
    Call<HiResponse<Object>> reportRedPackageRainCoin(@Url String str, @Body RedPackageRainReportCoinBody redPackageRainReportCoinBody);
}
