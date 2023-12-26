package io.ktor.client.engine.okhttp;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0000H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/ktor/client/engine/okhttp/UnsupportedFrameTypeException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "Lkotlinx/coroutines/CopyableThrowable;", "frame", "Lio/ktor/websocket/Frame;", "(Lio/ktor/websocket/Frame;)V", "createCopy", "ktor-client-okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpWebsocketSession.kt */
public final class UnsupportedFrameTypeException extends IllegalArgumentException implements CopyableThrowable<UnsupportedFrameTypeException> {
    private final Frame frame;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnsupportedFrameTypeException(Frame frame2) {
        super("Unsupported frame type: " + frame2);
        Intrinsics.checkNotNullParameter(frame2, "frame");
        this.frame = frame2;
    }

    public UnsupportedFrameTypeException createCopy() {
        UnsupportedFrameTypeException unsupportedFrameTypeException = new UnsupportedFrameTypeException(this.frame);
        unsupportedFrameTypeException.initCause(this);
        return unsupportedFrameTypeException;
    }
}
