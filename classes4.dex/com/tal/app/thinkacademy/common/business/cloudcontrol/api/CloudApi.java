package com.tal.app.thinkacademy.common.business.cloudcontrol.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudApi;", "", "syncCloudData", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudData;", "body", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudBody;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloudApi.kt */
public interface CloudApi {
    @POST("/api/smartline/v1/getCloudConfigs")
    Call<HiResponse<CloudData>> syncCloudData(@Body CloudBody cloudBody);
}
