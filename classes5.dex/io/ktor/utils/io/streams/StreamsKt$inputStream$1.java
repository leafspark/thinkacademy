package io.ktor.utils.io.streams;

import io.ktor.utils.io.core.ByteReadPacket;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.UByte;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"io/ktor/utils/io/streams/StreamsKt$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Streams.kt */
public final class StreamsKt$inputStream$1 extends InputStream {
    final /* synthetic */ ByteReadPacket $this_inputStream;

    StreamsKt$inputStream$1(ByteReadPacket byteReadPacket) {
        this.$this_inputStream = byteReadPacket;
    }

    public int read() {
        if (this.$this_inputStream.getEndOfInput()) {
            return -1;
        }
        return this.$this_inputStream.readByte() & UByte.MAX_VALUE;
    }

    public int available() {
        return (int) Math.min(this.$this_inputStream.getRemaining(), 2147483647L);
    }

    public void close() {
        this.$this_inputStream.release();
    }
}
