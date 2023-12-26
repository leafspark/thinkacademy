package com.tal.app.thinkacademy.common.imconfig;

import com.tal.app.thinkacademy.common.entity.GetSchoolListRequest;
import com.tal.app.thinkacademy.common.entity.S3Body;
import com.tal.app.thinkacademy.common.entity.STSToken;
import com.tal.app.thinkacademy.common.network.EmptyPostBean;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tH'J(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tH'J!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0001\u0010\b\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0012H'\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ImConfigApi;", "", "getConfig", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo;", "url", "", "body", "Lcom/tal/app/thinkacademy/common/network/EmptyPostBean;", "getHostConfig", "Lcom/tal/app/thinkacademy/common/imconfig/HostUrlsInfo;", "getSTSToken", "Lcom/tal/app/thinkacademy/common/entity/STSToken;", "Lcom/tal/app/thinkacademy/common/entity/S3Body;", "(Lcom/tal/app/thinkacademy/common/entity/S3Body;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchoolList", "Lcom/tal/app/thinkacademy/common/imconfig/SchoolListInfo;", "Lcom/tal/app/thinkacademy/common/entity/GetSchoolListRequest;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImConfigApi.kt */
public interface ImConfigApi {
    @POST
    Call<HiResponse<ConfigInfo>> getConfig(@Url String str, @Body EmptyPostBean emptyPostBean);

    @POST
    Call<HiResponse<HostUrlsInfo>> getHostConfig(@Url String str, @Body EmptyPostBean emptyPostBean);

    @POST("classroom-hub/classroom/aws/getSTSToken")
    Object getSTSToken(@Body S3Body s3Body, Continuation<? super HiResponse<STSToken>> continuation);

    @POST
    Call<HiResponse<SchoolListInfo>> getSchoolList(@Url String str, @Body GetSchoolListRequest getSchoolListRequest);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImConfigApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call getConfig$default(ImConfigApi imConfigApi, String str, EmptyPostBean emptyPostBean, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    emptyPostBean = new EmptyPostBean();
                }
                return imConfigApi.getConfig(str, emptyPostBean);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConfig");
        }

        public static /* synthetic */ Call getHostConfig$default(ImConfigApi imConfigApi, String str, EmptyPostBean emptyPostBean, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    emptyPostBean = new EmptyPostBean();
                }
                return imConfigApi.getHostConfig(str, emptyPostBean);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHostConfig");
        }
    }
}
