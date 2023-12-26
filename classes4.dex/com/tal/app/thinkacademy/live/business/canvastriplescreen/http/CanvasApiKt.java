package com.tal.app.thinkacademy.live.business.canvastriplescreen.http;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.PagekeyBean;
import com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPageList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/http/CanvasApiKt;", "", "historyBinaryMsg", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/request/HistoryBinaryMsgRequest;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/request/HistoryBinaryMsgRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "studentGetAllPageKey", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/StuGraffitiPageList;", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/request/PagekeyBean;", "(Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/request/PagekeyBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CanvasApiKt.kt */
public interface CanvasApiKt {
    @POST
    Object historyBinaryMsg(@Url String str, @Body HistoryBinaryMsgRequest historyBinaryMsgRequest, Continuation<? super CanvasBinaryResp> continuation);

    @POST("/api/linkmic/v1/studentGetAllPageKey")
    Object studentGetAllPageKey(@Body PagekeyBean pagekeyBean, Continuation<? super HiResponse<StuGraffitiPageList>> continuation);
}
