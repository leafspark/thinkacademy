package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Cursor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lokio/internal/BufferedSourceCursor;", "Lokio/Cursor;", "buffer", "Lokio/Buffer;", "sourceCursor", "(Lokio/Buffer;Lokio/Cursor;)V", "position", "", "seek", "", "size", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: -Buffer.kt */
public final class BufferedSourceCursor implements Cursor {
    private final Buffer buffer;
    private final Cursor sourceCursor;

    public BufferedSourceCursor(Buffer buffer2, Cursor cursor) {
        Intrinsics.checkNotNullParameter(buffer2, "buffer");
        Intrinsics.checkNotNullParameter(cursor, "sourceCursor");
        this.buffer = buffer2;
        this.sourceCursor = cursor;
    }

    public long position() {
        return this.sourceCursor.position() - this.buffer.size();
    }

    public long size() {
        return this.sourceCursor.size();
    }

    public void seek(long j) {
        long position = this.sourceCursor.position();
        long size = this.buffer.size();
        if (position - size <= j && position >= j) {
            this.buffer.skip((size - position) + j);
            return;
        }
        this.buffer.clear();
        this.sourceCursor.seek(j);
    }
}
