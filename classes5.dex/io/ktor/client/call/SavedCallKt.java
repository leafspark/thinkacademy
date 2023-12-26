package io.ktor.client.call;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"save", "Lio/ktor/client/call/HttpClientCall;", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedCall.kt */
public final class SavedCallKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object save(io.ktor.client.call.HttpClientCall r8, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.client.call.SavedCallKt$save$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.client.call.SavedCallKt$save$1 r0 = (io.ktor.client.call.SavedCallKt$save$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.client.call.SavedCallKt$save$1 r0 = new io.ktor.client.call.SavedCallKt$save$1
            r0.<init>(r9)
        L_0x0019:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r7) goto L_0x002f
            java.lang.Object r8 = r4.L$0
            io.ktor.client.call.HttpClientCall r8 = (io.ktor.client.call.HttpClientCall) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0051
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.statement.HttpResponse r9 = r8.getResponse()
            io.ktor.utils.io.ByteReadChannel r1 = r9.getContent()
            r2 = 0
            r5 = 1
            r6 = 0
            r4.L$0 = r8
            r4.label = r7
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L_0x0051
            return r0
        L_0x0051:
            io.ktor.utils.io.core.ByteReadPacket r9 = (io.ktor.utils.io.core.ByteReadPacket) r9
            r0 = 0
            r1 = 0
            byte[] r9 = io.ktor.utils.io.core.StringsKt.readBytes$default(r9, r0, r7, r1)
            io.ktor.client.call.SavedHttpCall r0 = new io.ktor.client.call.SavedHttpCall
            io.ktor.client.HttpClient r1 = r8.getClient()
            io.ktor.client.request.HttpRequest r2 = r8.getRequest()
            io.ktor.client.statement.HttpResponse r8 = r8.getResponse()
            r0.<init>(r1, r2, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.SavedCallKt.save(io.ktor.client.call.HttpClientCall, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
