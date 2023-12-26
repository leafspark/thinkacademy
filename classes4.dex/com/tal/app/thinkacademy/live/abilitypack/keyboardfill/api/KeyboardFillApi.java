package com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillBody;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/api/KeyboardFillApi;", "", "check", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "body", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillBody;", "(Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commit", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillApi.kt */
public interface KeyboardFillApi {
    @POST("/api/vote/oneanswer/student/check")
    Object check(@Body KeyboardFillBody keyboardFillBody, Continuation<? super HiResponse<KeyboardFillResult>> continuation);

    @POST("/api/vote/oneanswer/student/commit")
    Object commit(@Body KeyboardFillBody keyboardFillBody, Continuation<? super HiResponse<KeyboardFillResult>> continuation);
}
