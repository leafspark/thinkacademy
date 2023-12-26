package io.ktor.util;

import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"io/ktor/util/InputJvmKt$asStream$1", "Ljava/io/InputStream;", "close", "", "read", "", "buffer", "", "offset", "length", "skip", "", "count", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputJvm.kt */
public final class InputJvmKt$asStream$1 extends InputStream {
    final /* synthetic */ Input $this_asStream;

    InputJvmKt$asStream$1(Input input) {
        this.$this_asStream = input;
    }

    public int read() {
        if (this.$this_asStream.getEndOfInput()) {
            return -1;
        }
        return this.$this_asStream.readByte();
    }

    public int read(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        if (this.$this_asStream.getEndOfInput()) {
            return -1;
        }
        return InputArraysKt.readAvailable(this.$this_asStream, bArr, i, i2);
    }

    public long skip(long j) {
        return this.$this_asStream.discard(j);
    }

    public void close() {
        this.$this_asStream.close();
    }
}
