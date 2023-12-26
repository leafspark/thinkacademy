package io.ktor.utils.io.streams;

import io.ktor.utils.io.core.BytePacketBuilder;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J \u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"io/ktor/utils/io/streams/StreamsKt$writerUTF8$1", "Ljava/io/Writer;", "close", "", "flush", "write", "cbuf", "", "off", "", "len", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Streams.kt */
public final class StreamsKt$writerUTF8$1 extends Writer {
    final /* synthetic */ BytePacketBuilder $this_writerUTF8;

    public void close() {
    }

    public void flush() {
    }

    StreamsKt$writerUTF8$1(BytePacketBuilder bytePacketBuilder) {
        this.$this_writerUTF8 = bytePacketBuilder;
    }

    public void write(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "cbuf");
        this.$this_writerUTF8.append(cArr, i, i2 + i);
    }
}
