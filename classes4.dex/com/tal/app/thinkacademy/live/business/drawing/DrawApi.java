package com.tal.app.thinkacademy.live.business.drawing;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosOnTheWallState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ/\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/drawing/DrawApi;", "", "drawSubmit", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoSubmitResult;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/drawing/ParamsBean;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/drawing/ParamsBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handsup", "requestOpenStatus", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosOnTheWallState;", "Lcom/tal/app/thinkacademy/live/business/drawing/StatusBean;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/drawing/StatusBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawApi.kt */
public interface DrawApi {
    @POST
    Object drawSubmit(@Url String str, @Body ParamsBean paramsBean, Continuation<? super HiResponse<PhotoSubmitResult>> continuation);

    @POST
    Object handsup(@Url String str, @Body ParamsBean paramsBean, Continuation<? super HiResponse<PhotoSubmitResult>> continuation);

    @POST
    Object requestOpenStatus(@Url String str, @Body StatusBean statusBean, Continuation<? super HiResponse<PhotosOnTheWallState>> continuation);
}
