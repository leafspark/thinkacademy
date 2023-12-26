package com.tal.app.thinkacademy.common.network;

import com.tal.app.thinkacademy.business.study.study.entity.request.TimeZoneCheckRequest;
import com.tal.app.thinkacademy.common.entity.OrderPayRequestBean;
import com.tal.app.thinkacademy.common.entity.OrderPlayResponseBean;
import com.tal.app.thinkacademy.common.entity.PushRequestBean;
import com.tal.app.thinkacademy.common.entity.SubmitHomeworkData;
import com.tal.app.thinkacademy.common.entity.SubmitHomeworkResult;
import com.tal.app.thinkacademy.common.entity.TimeZoneCheckEntity;
import com.tal.app.thinkacademy.common.entity.VideoPreloadListBean;
import com.tal.app.thinkacademy.common.entity.VodPlayerReportBody;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0006H'J!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u0013H'J.\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00030\u000b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0016H'J#\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/CommonApi;", "", "gePayInfo", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/entity/OrderPlayResponseBean;", "schoolCode", "", "body", "Lcom/tal/app/thinkacademy/common/entity/OrderPayRequestBean;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/common/entity/OrderPayRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVodPlayerPreloadData", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/common/entity/VideoPreloadListBean;", "url", "pushClientLogin", "data", "Lcom/tal/app/thinkacademy/common/entity/PushRequestBean;", "(Lcom/tal/app/thinkacademy/common/entity/PushRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportVodPlayerData", "Lcom/tal/app/thinkacademy/common/entity/VodPlayerReportBody;", "submitHomework", "Lcom/tal/app/thinkacademy/common/entity/SubmitHomeworkResult;", "Lcom/tal/app/thinkacademy/common/entity/SubmitHomeworkData;", "timeZoneCheck", "Lcom/tal/app/thinkacademy/common/entity/TimeZoneCheckEntity;", "Body", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/TimeZoneCheckRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/TimeZoneCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonApi.kt */
public interface CommonApi {
    @POST("v1/shop/order/payInfo")
    Object gePayInfo(@Header("schoolCode") String str, @Body OrderPayRequestBean orderPayRequestBean, Continuation<? super HiResponse<OrderPlayResponseBean>> continuation);

    @POST
    Call<HiResponse<VideoPreloadListBean>> getVodPlayerPreloadData(@Url String str);

    @POST("v1/message/app/clientLogin")
    Object pushClientLogin(@Body PushRequestBean pushRequestBean, Continuation<? super HiResponse<Object>> continuation);

    @POST("api/beibo/student/watch")
    Call<HiResponse<Object>> reportVodPlayerData(@Body VodPlayerReportBody vodPlayerReportBody);

    @POST
    Call<HiResponse<SubmitHomeworkResult>> submitHomework(@Url String str, @Body SubmitHomeworkData submitHomeworkData);

    @POST("v1/i18n/api/time/get/check")
    Object timeZoneCheck(@Body TimeZoneCheckRequest timeZoneCheckRequest, Continuation<? super HiResponse<TimeZoneCheckEntity>> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommonApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object gePayInfo$default(CommonApi commonApi, String str, OrderPayRequestBean orderPayRequestBean, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return commonApi.gePayInfo(str, orderPayRequestBean, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gePayInfo");
        }
    }
}
