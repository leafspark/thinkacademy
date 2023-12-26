package com.tal.app.thinkacademy.live.business.groupvideocall.api;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.groupvideocall.bean.GroupStudentInfoList;
import com.tal.app.thinkacademy.live.business.groupvideocall.bean.request.GroupVideoCallRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/api/GroupVideoCallApi;", "", "getLinkMicStudentDataOfMulti", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/GroupStudentInfoList;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/request/GroupVideoCallRequest;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/request/GroupVideoCallRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupVideoCallApi.kt */
public interface GroupVideoCallApi {
    @POST
    Object getLinkMicStudentDataOfMulti(@Url String str, @Body GroupVideoCallRequest groupVideoCallRequest, Continuation<? super HiResponse<GroupStudentInfoList>> continuation);
}
