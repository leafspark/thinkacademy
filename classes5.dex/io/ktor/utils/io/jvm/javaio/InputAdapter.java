package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\"\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/InputAdapter;", "Ljava/io/InputStream;", "parent", "Lkotlinx/coroutines/Job;", "channel", "Lio/ktor/utils/io/ByteReadChannel;", "(Lkotlinx/coroutines/Job;Lio/ktor/utils/io/ByteReadChannel;)V", "context", "Lkotlinx/coroutines/CompletableJob;", "loop", "io/ktor/utils/io/jvm/javaio/InputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/InputAdapter$loop$1;", "single", "", "available", "", "close", "", "read", "b", "off", "len", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Blocking.kt */
final class InputAdapter extends InputStream {
    /* access modifiers changed from: private */
    public final ByteReadChannel channel;
    /* access modifiers changed from: private */
    public final CompletableJob context;
    private final InputAdapter$loop$1 loop;
    private byte[] single;

    public InputAdapter(Job job, ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "channel");
        this.channel = byteReadChannel;
        BlockingKt.ensureParkingAllowed();
        this.context = JobKt.Job(job);
        this.loop = new InputAdapter$loop$1(job, this);
    }

    public int available() {
        return this.channel.getAvailableForRead();
    }

    public synchronized int read() {
        byte[] bArr = this.single;
        if (bArr == null) {
            bArr = new byte[1];
            this.single = bArr;
        }
        int submitAndAwait = this.loop.submitAndAwait(bArr, 0, 1);
        if (submitAndAwait == -1) {
            return -1;
        }
        if (submitAndAwait == 1) {
            return bArr[0] & UByte.MAX_VALUE;
        }
        throw new IllegalStateException(("rc should be 1 or -1 but got " + submitAndAwait).toString());
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        InputAdapter$loop$1 inputAdapter$loop$1;
        inputAdapter$loop$1 = this.loop;
        Intrinsics.checkNotNull(bArr);
        return inputAdapter$loop$1.submitAndAwait(bArr, i, i2);
    }

    public synchronized void close() {
        super.close();
        ByteReadChannelKt.cancel(this.channel);
        if (!this.context.isCompleted()) {
            Job.DefaultImpls.cancel$default((Job) this.context, (CancellationException) null, 1, (Object) null);
        }
        this.loop.shutdown();
    }
}
