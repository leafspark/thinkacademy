package com.tal.thinkacademy.networkprobe;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"isPlaintext", "", "buffer", "Lokio/Buffer;", "networkprobe_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TraceEventListener.kt */
public final class TraceEventListenerKt {
    public static final boolean isPlaintext(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size() < 64 ? buffer.size() : 64);
            int i = 0;
            while (true) {
                if (i >= 16) {
                    break;
                }
                i++;
                if (buffer2.exhausted()) {
                    break;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
