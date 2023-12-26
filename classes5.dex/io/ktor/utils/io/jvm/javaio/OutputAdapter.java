package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/OutputAdapter;", "Ljava/io/OutputStream;", "parent", "Lkotlinx/coroutines/Job;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lkotlinx/coroutines/Job;Lio/ktor/utils/io/ByteWriteChannel;)V", "loop", "io/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1;", "single", "", "close", "", "flush", "write", "b", "off", "", "len", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Blocking.kt */
final class OutputAdapter extends OutputStream {
    /* access modifiers changed from: private */
    public final ByteWriteChannel channel;
    private final OutputAdapter$loop$1 loop;
    private byte[] single;

    public OutputAdapter(Job job, ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "channel");
        this.channel = byteWriteChannel;
        BlockingKt.ensureParkingAllowed();
        this.loop = new OutputAdapter$loop$1(job, this);
    }

    public synchronized void write(int i) {
        byte[] bArr = this.single;
        if (bArr == null) {
            bArr = new byte[1];
            this.single = bArr;
        }
        bArr[0] = (byte) i;
        this.loop.submitAndAwait(bArr, 0, 1);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        OutputAdapter$loop$1 outputAdapter$loop$1 = this.loop;
        Intrinsics.checkNotNull(bArr);
        outputAdapter$loop$1.submitAndAwait(bArr, i, i2);
    }

    public synchronized void flush() {
        this.loop.submitAndAwait(BlockingKt.FlushToken);
    }

    public synchronized void close() {
        try {
            this.loop.submitAndAwait(BlockingKt.CloseToken);
            this.loop.shutdown();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
