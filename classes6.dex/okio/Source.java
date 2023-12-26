package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\rH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lokio/Source;", "Ljava/io/Closeable;", "Lokio/Closeable;", "close", "", "cursor", "Lokio/Cursor;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: Source.kt */
public interface Source extends Closeable {

    /* renamed from: okio.Source$-CC  reason: invalid class name */
    /* compiled from: Source.kt */
    public final /* synthetic */ class CC {
        public static Cursor $default$cursor(Source source) {
            return null;
        }
    }

    void close() throws IOException;

    Cursor cursor();

    long read(Buffer buffer, long j) throws IOException;

    Timeout timeout();
}
