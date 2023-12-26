package com.tal.app.thinkacademy.live.business.mediacontroller.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.mediacontroller.bean.FeedBackPlaybackBody;
import com.tal.app.thinkacademy.live.business.mediacontroller.bean.ScreenshotFeedbackBody;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/api/MediaControlApi;", "", "pcScreenshotFeedBack", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "url", "", "feedbackBody", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/bean/ScreenshotFeedbackBody;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/mediacontroller/bean/ScreenshotFeedbackBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postPlaybackFeedBack", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/bean/FeedBackPlaybackBody;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/mediacontroller/bean/FeedBackPlaybackBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MediaControlApi.kt */
public interface MediaControlApi {
    @POST
    Object pcScreenshotFeedBack(@Url String str, @Body ScreenshotFeedbackBody screenshotFeedbackBody, Continuation<? super HiResponse<Object>> continuation);

    @POST
    Object postPlaybackFeedBack(@Url String str, @Body FeedBackPlaybackBody feedBackPlaybackBody, Continuation<? super HiResponse<Object>> continuation);
}
