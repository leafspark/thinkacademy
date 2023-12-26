package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u0016\u0010\n\u001a\u00020\u000b*\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"CloseToken", "", "FlushToken", "ensureParkingAllowed", "", "toInputStream", "Ljava/io/InputStream;", "Lio/ktor/utils/io/ByteReadChannel;", "parent", "Lkotlinx/coroutines/Job;", "toOutputStream", "Ljava/io/OutputStream;", "Lio/ktor/utils/io/ByteWriteChannel;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Blocking.kt */
public final class BlockingKt {
    /* access modifiers changed from: private */
    public static final Object CloseToken = new Object();
    /* access modifiers changed from: private */
    public static final Object FlushToken = new Object();

    public static final InputStream toInputStream(ByteReadChannel byteReadChannel, Job job) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return new InputAdapter(job, byteReadChannel);
    }

    public static /* synthetic */ InputStream toInputStream$default(ByteReadChannel byteReadChannel, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return toInputStream(byteReadChannel, job);
    }

    public static final OutputStream toOutputStream(ByteWriteChannel byteWriteChannel, Job job) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return new OutputAdapter(job, byteWriteChannel);
    }

    public static /* synthetic */ OutputStream toOutputStream$default(ByteWriteChannel byteWriteChannel, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return toOutputStream(byteWriteChannel, job);
    }

    /* access modifiers changed from: private */
    public static final void ensureParkingAllowed() {
        if (!PollersKt.isParkingAllowed()) {
            throw new IllegalStateException("Using blocking primitives on this dispatcher is not allowed. Consider using async channel instead or use blocking primitives in withContext(Dispatchers.IO) instead.".toString());
        }
    }
}
