package com.tal.app.thinkacademy.live.business.photosonthewall.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoOnTheWallBody;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosOnTheWallState;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\tH'J,\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/api/PhotosOnTheWallApi;", "", "photoSubmit", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoSubmitResult;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoOnTheWallBody;", "requestOpenStatus", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosOnTheWallState;", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/OpenStatusBody;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotosOnTheWallApi.kt */
public interface PhotosOnTheWallApi {
    @POST
    Call<HiResponse<PhotoSubmitResult>> photoSubmit(@Url String str, @Body PhotoOnTheWallBody photoOnTheWallBody);

    @POST
    Call<HiResponse<PhotosOnTheWallState>> requestOpenStatus(@Url String str, @Body OpenStatusBody openStatusBody);
}
