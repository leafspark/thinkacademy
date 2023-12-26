package com.tal.app.thinkacademy.live.business.nps;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.nps.bean.NpsSaveRequest;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J \u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/NpsApi;", "", "getNpsState", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/nps/NpsBean;", "body", "Lcom/tal/app/thinkacademy/live/business/nps/NpsBody;", "saveNps", "Lcom/tal/app/thinkacademy/live/business/nps/bean/NpsSaveRequest;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsApi.kt */
public interface NpsApi {
    @POST("api/classroom/nps/getNPSStatus")
    Call<HiResponse<NpsBean>> getNpsState(@Body NpsBody npsBody);

    @POST("api/classroom/nps/saveNPS")
    Call<HiResponse<Object>> saveNps(@Body NpsSaveRequest npsSaveRequest);
}
