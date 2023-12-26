package com.tal.app.thinkacademy.common.business.http;

import com.tal.app.thinkacademy.common.entity.UpdateVersionEntity;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/http/UpdateApi;", "", "newCheckUpdate", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/entity/UpdateVersionEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateApi.kt */
public interface UpdateApi {
    @POST("app-upgrade/check")
    Object newCheckUpdate(Continuation<? super HiResponse<UpdateVersionEntity>> continuation);
}
