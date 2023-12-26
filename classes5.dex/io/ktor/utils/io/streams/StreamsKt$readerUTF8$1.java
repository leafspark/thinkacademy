package io.ktor.utils.io.streams;

import io.ktor.utils.io.core.ByteReadPacket;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"io/ktor/utils/io/streams/StreamsKt$readerUTF8$1", "Ljava/io/Reader;", "close", "", "read", "", "cbuf", "", "off", "len", "skip", "", "n", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Streams.kt */
public final class StreamsKt$readerUTF8$1 extends Reader {
    final /* synthetic */ ByteReadPacket $this_readerUTF8;

    StreamsKt$readerUTF8$1(ByteReadPacket byteReadPacket) {
        this.$this_readerUTF8 = byteReadPacket;
    }

    public void close() {
        this.$this_readerUTF8.release();
    }

    public long skip(long j) {
        int read;
        char[] access$getSkipBuffer$p = StreamsKt.SkipBuffer;
        int length = access$getSkipBuffer$p.length;
        long j2 = 0;
        while (j2 < j && (read = read(access$getSkipBuffer$p, 0, (int) Math.min((long) length, j - j2))) != -1) {
            j2 += (long) read;
        }
        return j2;
    }

    public int read(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "cbuf");
        return this.$this_readerUTF8.readAvailableCharacters$ktor_io(cArr, i, i2);
    }
}
