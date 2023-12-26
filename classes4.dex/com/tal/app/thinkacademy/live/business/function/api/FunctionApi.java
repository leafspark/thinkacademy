package com.tal.app.thinkacademy.live.business.function.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfo;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfoBody;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.function.bean.FunctionBody;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxEntity;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/api/FunctionApi;", "", "getEnterRoomMuteData", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/function/bean/EnterRoomMuteData;", "url", "", "planId", "Lcom/tal/app/thinkacademy/live/business/function/bean/FunctionBody;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/function/bean/FunctionBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExamInfo", "Lcom/tal/app/thinkacademy/live/business/exam/bean/ExamInfo;", "body", "Lcom/tal/app/thinkacademy/live/business/exam/bean/ExamInfoBody;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/exam/bean/ExamInfoBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewMessage", "Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxMessage;", "getPhotoBox", "Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxEntity;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionApi.kt */
public interface FunctionApi {
    @POST
    Object getEnterRoomMuteData(@Url String str, @Body FunctionBody functionBody, Continuation<? super HiResponse<EnterRoomMuteData>> continuation);

    @POST
    Object getExamInfo(@Url String str, @Body ExamInfoBody examInfoBody, Continuation<? super HiResponse<ExamInfo>> continuation);

    @POST
    Object getNewMessage(@Url String str, @Body FunctionBody functionBody, Continuation<? super HiResponse<PhotoBoxMessage>> continuation);

    @POST
    Object getPhotoBox(@Url String str, @Body FunctionBody functionBody, Continuation<? super HiResponse<PhotoBoxEntity>> continuation);
}
