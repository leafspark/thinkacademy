package io.ktor.websocket;

import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a/\u0010\n\u001a\u0002H\u000b\"\f\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\f*\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u000b0\r¢\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u0004\u0018\u0001H\u000b\"\f\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\f*\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u000b0\r¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"close", "", "Lio/ktor/websocket/WebSocketSession;", "reason", "Lio/ktor/websocket/CloseReason;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/CloseReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cause", "", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeExceptionally", "extension", "T", "Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/WebSocketExtensionFactory;)Lio/ktor/websocket/WebSocketExtension;", "extensionOrNull", "send", "content", "", "(Lio/ktor/websocket/WebSocketSession;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSocketSession.kt */
public final class WebSocketSessionKt {
    public static final <T extends WebSocketExtension<?>> T extension(WebSocketSession webSocketSession, WebSocketExtensionFactory<?, T> webSocketExtensionFactory) {
        Intrinsics.checkNotNullParameter(webSocketSession, "<this>");
        Intrinsics.checkNotNullParameter(webSocketExtensionFactory, "extension");
        T extensionOrNull = extensionOrNull(webSocketSession, webSocketExtensionFactory);
        if (extensionOrNull != null) {
            return extensionOrNull;
        }
        throw new IllegalStateException(("Extension " + webSocketExtensionFactory + " not found.").toString());
    }

    public static final <T extends WebSocketExtension<?>> T extensionOrNull(WebSocketSession webSocketSession, WebSocketExtensionFactory<?, T> webSocketExtensionFactory) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(webSocketSession, "<this>");
        Intrinsics.checkNotNullParameter(webSocketExtensionFactory, "extension");
        Iterator it = webSocketSession.getExtensions().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((WebSocketExtension) t).getFactory().getKey() == webSocketExtensionFactory.getKey()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (t instanceof WebSocketExtension) {
            return (WebSocketExtension) t;
        }
        return null;
    }

    public static final Object send(WebSocketSession webSocketSession, String str, Continuation<? super Unit> continuation) {
        Object send = webSocketSession.send(new Frame.Text(str), continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    public static final Object send(WebSocketSession webSocketSession, byte[] bArr, Continuation<? super Unit> continuation) {
        Object send = webSocketSession.send(new Frame.Binary(true, bArr), continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object close(io.ktor.websocket.WebSocketSession r5, io.ktor.websocket.CloseReason r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.websocket.WebSocketSessionKt$close$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.websocket.WebSocketSessionKt$close$1 r0 = (io.ktor.websocket.WebSocketSessionKt$close$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.WebSocketSessionKt$close$1 r0 = new io.ktor.websocket.WebSocketSessionKt$close$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x005e }
            goto L_0x005e
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketSession r5 = (io.ktor.websocket.WebSocketSession) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x005e }
            goto L_0x0052
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            io.ktor.websocket.Frame$Close r7 = new io.ktor.websocket.Frame$Close     // Catch:{ all -> 0x005e }
            r7.<init>((io.ktor.websocket.CloseReason) r6)     // Catch:{ all -> 0x005e }
            io.ktor.websocket.Frame r7 = (io.ktor.websocket.Frame) r7     // Catch:{ all -> 0x005e }
            r0.L$0 = r5     // Catch:{ all -> 0x005e }
            r0.label = r4     // Catch:{ all -> 0x005e }
            java.lang.Object r6 = r5.send(r7, r0)     // Catch:{ all -> 0x005e }
            if (r6 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r6 = 0
            r0.L$0 = r6     // Catch:{ all -> 0x005e }
            r0.label = r3     // Catch:{ all -> 0x005e }
            java.lang.Object r5 = r5.flush(r0)     // Catch:{ all -> 0x005e }
            if (r5 != r1) goto L_0x005e
            return r1
        L_0x005e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketSessionKt.close(io.ktor.websocket.WebSocketSession, io.ktor.websocket.CloseReason, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object close$default(WebSocketSession webSocketSession, CloseReason closeReason, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
        }
        return close(webSocketSession, closeReason, (Continuation<? super Unit>) continuation);
    }

    @Deprecated(message = "Close with reason or terminate instead.")
    public static final Object close(WebSocketSession webSocketSession, Throwable th, Continuation<? super Unit> continuation) {
        if (th == null) {
            Object close$default = close$default(webSocketSession, (CloseReason) null, continuation, 1, (Object) null);
            return close$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? close$default : Unit.INSTANCE;
        }
        Object closeExceptionally = closeExceptionally(webSocketSession, th, continuation);
        return closeExceptionally == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? closeExceptionally : Unit.INSTANCE;
    }

    public static final Object closeExceptionally(WebSocketSession webSocketSession, Throwable th, Continuation<? super Unit> continuation) {
        CloseReason closeReason;
        if (th instanceof CancellationException) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
        } else {
            closeReason = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, th.toString());
        }
        Object close = close(webSocketSession, closeReason, continuation);
        return close == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? close : Unit.INSTANCE;
    }
}
