package com.tal.app.thinkacademy.live.business.interactivegames.api;

import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.RandomSpeechStudent;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.SubmitAsyncGameRequest;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitStartSpeechBody;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.WhoCanSpeakBody;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH'J.\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\fH'J.\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH'J1\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0012H'J/\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J.\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0016H'J,\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0019H'\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/api/GameApi;", "", "requestGameStatus", "Lretrofit2/Call;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameStatus;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/OpenStatusBody;", "submitAsyncGameData", "Lcom/tal/app/thinkacademy/common/entity/EmptyBean;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/SubmitAsyncGameRequest;", "submitGameClose", "submitGameCloseNew", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/OpenStatusBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitGameData", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitGameDataBody;", "submitGameDataNew", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitGameDataBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitStartSpeech", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitStartSpeechBody;", "whoCanSpeak", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/RandomSpeechStudent;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/WhoCanSpeakBody;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameApi.kt */
public interface GameApi {
    @POST
    Call<HiResponse<GameStatus>> requestGameStatus(@Url String str, @Body OpenStatusBody openStatusBody);

    @POST
    Call<HiResponse<EmptyBean>> submitAsyncGameData(@Url String str, @Body SubmitAsyncGameRequest submitAsyncGameRequest);

    @POST
    Call<HiResponse<EmptyBean>> submitGameClose(@Url String str, @Body OpenStatusBody openStatusBody);

    @POST
    Object submitGameCloseNew(@Url String str, @Body OpenStatusBody openStatusBody, Continuation<? super HiResponse<EmptyBean>> continuation);

    @POST
    Call<HiResponse<AnswerBean>> submitGameData(@Url String str, @Body SubmitGameDataBody submitGameDataBody);

    @POST
    Object submitGameDataNew(@Url String str, @Body SubmitGameDataBody submitGameDataBody, Continuation<? super HiResponse<AnswerBean>> continuation);

    @POST
    Call<HiResponse<EmptyBean>> submitStartSpeech(@Url String str, @Body SubmitStartSpeechBody submitStartSpeechBody);

    @POST
    Call<HiResponse<RandomSpeechStudent>> whoCanSpeak(@Url String str, @Body WhoCanSpeakBody whoCanSpeakBody);
}
