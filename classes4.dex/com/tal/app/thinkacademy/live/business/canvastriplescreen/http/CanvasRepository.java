package com.tal.app.thinkacademy.live.business.canvastriplescreen.http;

import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/http/CanvasRepository;", "", "()V", "historyBinaryMsg", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/request/HistoryBinaryMsgRequest;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/request/HistoryBinaryMsgRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "studentGetAllPageKey", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/StuGraffitiPageList;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CanvasRepository.kt */
public final class CanvasRepository {
    public final Object historyBinaryMsg(String str, HistoryBinaryMsgRequest historyBinaryMsgRequest, Continuation<? super CanvasBinaryResp> continuation) {
        return ((CanvasApiKt) Api.create(CanvasApiKt.class)).historyBinaryMsg(str, historyBinaryMsgRequest, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x006e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object studentGetAllPageKey(java.lang.String r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPageList> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository$studentGetAllPageKey$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository$studentGetAllPageKey$1 r0 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository$studentGetAllPageKey$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository$studentGetAllPageKey$1 r0 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository$studentGetAllPageKey$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0071
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0063
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasApiKt> r5 = com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasApiKt.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasApiKt r2 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasApiKt) r2
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.PagekeyBean r5 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.PagekeyBean
            r5.<init>(r8)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.studentGetAllPageKey(r5, r0)
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0063:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0071
            return r1
        L_0x0071:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository.studentGetAllPageKey(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
