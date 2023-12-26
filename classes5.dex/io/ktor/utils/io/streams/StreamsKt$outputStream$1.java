package io.ktor.utils.io.streams;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"io/ktor/utils/io/streams/StreamsKt$outputStream$1", "Ljava/io/OutputStream;", "close", "", "write", "b", "", "off", "", "len", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Streams.kt */
public final class StreamsKt$outputStream$1 extends OutputStream {
    final /* synthetic */ BytePacketBuilder $this_outputStream;

    public void close() {
    }

    StreamsKt$outputStream$1(BytePacketBuilder bytePacketBuilder) {
        this.$this_outputStream = bytePacketBuilder;
    }

    public void write(int i) {
        this.$this_outputStream.writeByte((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "b");
        OutputKt.writeFully((Output) this.$this_outputStream, bArr, i, i2);
    }
}
