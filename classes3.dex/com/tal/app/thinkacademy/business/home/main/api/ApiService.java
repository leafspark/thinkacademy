package com.tal.app.thinkacademy.business.home.main.api;

import com.tal.app.thinkacademy.business.home.main.bean.CountryCode;
import com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData;
import com.tal.app.thinkacademy.business.home.main.bean.LessonReminderRequest;
import com.tal.app.thinkacademy.business.home.main.bean.RedDotPostBody;
import com.tal.app.thinkacademy.business.home.main.bean.SchoolCode;
import com.tal.app.thinkacademy.business.home.main.bean.UnPayNum;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/api/ApiService;", "", "getLessonReminder", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderData;", "body", "Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderRequest;", "(Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchoolCode", "Lcom/tal/app/thinkacademy/business/home/main/bean/SchoolCode;", "Lcom/tal/app/thinkacademy/business/home/main/bean/CountryCode;", "(Lcom/tal/app/thinkacademy/business/home/main/bean/CountryCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "redDot", "Lcom/tal/app/thinkacademy/business/home/main/bean/UnPayNum;", "Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostBody;", "(Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApiService.kt */
public interface ApiService {
    @POST("/v1/studyCenter/common/getReminder")
    Object getLessonReminder(@Body LessonReminderRequest lessonReminderRequest, Continuation<? super HiResponse<LessonReminderData>> continuation);

    @POST("/classroom-hub/raw/classroom/geo/schoolcode")
    Object getSchoolCode(@Body CountryCode countryCode, Continuation<? super HiResponse<SchoolCode>> continuation);

    @POST("/v1/shop/goods/stu/guide-redDot")
    Object redDot(@Body RedDotPostBody redDotPostBody, Continuation<? super HiResponse<UnPayNum>> continuation);
}
