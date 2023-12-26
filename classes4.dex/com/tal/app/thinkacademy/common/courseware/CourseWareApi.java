package com.tal.app.thinkacademy.common.courseware;

import com.tal.app.thinkacademy.common.courseware.body.PlanIdBody;
import com.tal.app.thinkacademy.common.network.EmptyPostBean;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH'J(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/CourseWareApi;", "", "getCourseWareContent", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo;", "url", "", "body", "Lcom/tal/app/thinkacademy/common/courseware/body/PlanIdBody;", "getCourseWarePreList", "Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList;", "Lcom/tal/app/thinkacademy/common/network/EmptyPostBean;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CourseWareApi.kt */
public interface CourseWareApi {
    @POST
    Call<HiResponse<CouseWareInfo>> getCourseWareContent(@Url String str, @Body PlanIdBody planIdBody);

    @POST
    Call<HiResponse<CouseWarePreList>> getCourseWarePreList(@Url String str, @Body EmptyPostBean emptyPostBean);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CourseWareApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call getCourseWarePreList$default(CourseWareApi courseWareApi, String str, EmptyPostBean emptyPostBean, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    emptyPostBean = new EmptyPostBean();
                }
                return courseWareApi.getCourseWarePreList(str, emptyPostBean);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCourseWarePreList");
        }
    }
}
