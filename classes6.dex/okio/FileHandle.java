package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH$J\b\u0010\r\u001a\u00020\u000bH&J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u000fJ\b\u0010\u0017\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u000fJ \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH&R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "()V", "closed", "", "openStreamCount", "", "appendingSink", "Lokio/Sink;", "close", "", "closeInternal", "flush", "position", "", "sink", "source", "Lokio/Source;", "read", "offset", "Lokio/Buffer;", "byteCount", "size", "write", "FileHandleSink", "FileHandleSource", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: FileHandle.kt */
public abstract class FileHandle implements Closeable {
    /* access modifiers changed from: private */
    public boolean closed;
    /* access modifiers changed from: private */
    public int openStreamCount;

    /* access modifiers changed from: protected */
    public abstract void closeInternal() throws IOException;

    public abstract void flush() throws IOException;

    public abstract long read(long j, Buffer buffer, long j2) throws IOException;

    public abstract long size() throws IOException;

    public abstract void write(long j, Buffer buffer, long j2) throws IOException;

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            return fileHandle.source(j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    public final long position(Source source) throws IOException {
        long j;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            j = realBufferedSource.bufferField.size();
            source = realBufferedSource.source;
        } else {
            j = 0;
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this) {
            return ((FileHandleSource) source).getPosition() - j;
        }
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            return fileHandle.sink(j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public final Sink appendingSink() throws IOException {
        return sink(size());
    }

    public final long position(Sink sink) throws IOException {
        long j;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            j = realBufferedSink.bufferField.size();
            sink = realBufferedSink.sink;
        } else {
            j = 0;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            return ((FileHandleSink) sink).getPosition() + j;
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "okio"}, k = 1, mv = {1, 4, 1})
    /* compiled from: FileHandle.kt */
    private static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle fileHandle2, long j) {
            Intrinsics.checkNotNullParameter(fileHandle2, "fileHandle");
            this.fileHandle = fileHandle2;
            this.position = j;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public void write(Buffer buffer, long j) {
            Intrinsics.checkNotNullParameter(buffer, "source");
            this.fileHandle.write(this.position, buffer, j);
            this.position += j;
        }

        public void flush() {
            this.fileHandle.flush();
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r3 = this;
                okio.FileHandle r0 = r3.fileHandle
                monitor-enter(r0)
                boolean r1 = r3.closed     // Catch:{ all -> 0x0033 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)
                return
            L_0x0009:
                r1 = 1
                r3.closed = r1     // Catch:{ all -> 0x0033 }
                okio.FileHandle r1 = r3.fileHandle     // Catch:{ all -> 0x0033 }
                int r2 = r1.openStreamCount     // Catch:{ all -> 0x0033 }
                int r2 = r2 + -1
                r1.openStreamCount = r2     // Catch:{ all -> 0x0033 }
                okio.FileHandle r1 = r3.fileHandle     // Catch:{ all -> 0x0033 }
                int r1 = r1.openStreamCount     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x0031
                okio.FileHandle r1 = r3.fileHandle     // Catch:{ all -> 0x0033 }
                boolean r1 = r1.closed     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x0028
                goto L_0x0031
            L_0x0028:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0033 }
                monitor-exit(r0)
                okio.FileHandle r0 = r3.fileHandle
                r0.closeInternal()
                return
            L_0x0031:
                monitor-exit(r0)
                return
            L_0x0033:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.FileHandle.FileHandleSink.close():void");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 4, 1})
    /* compiled from: FileHandle.kt */
    private static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public /* synthetic */ Cursor cursor() {
            return Source.CC.$default$cursor(this);
        }

        public FileHandleSource(FileHandle fileHandle2, long j) {
            Intrinsics.checkNotNullParameter(fileHandle2, "fileHandle");
            this.fileHandle = fileHandle2;
            this.position = j;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public long read(Buffer buffer, long j) {
            Intrinsics.checkNotNullParameter(buffer, "sink");
            long read = this.fileHandle.read(this.position, buffer, j);
            if (read != -1) {
                this.position += read;
            }
            return read;
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r3 = this;
                okio.FileHandle r0 = r3.fileHandle
                monitor-enter(r0)
                boolean r1 = r3.closed     // Catch:{ all -> 0x0033 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)
                return
            L_0x0009:
                r1 = 1
                r3.closed = r1     // Catch:{ all -> 0x0033 }
                okio.FileHandle r1 = r3.fileHandle     // Catch:{ all -> 0x0033 }
                int r2 = r1.openStreamCount     // Catch:{ all -> 0x0033 }
                int r2 = r2 + -1
                r1.openStreamCount = r2     // Catch:{ all -> 0x0033 }
                okio.FileHandle r1 = r3.fileHandle     // Catch:{ all -> 0x0033 }
                int r1 = r1.openStreamCount     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x0031
                okio.FileHandle r1 = r3.fileHandle     // Catch:{ all -> 0x0033 }
                boolean r1 = r1.closed     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x0028
                goto L_0x0031
            L_0x0028:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0033 }
                monitor-exit(r0)
                okio.FileHandle r0 = r3.fileHandle
                r0.closeInternal()
                return
            L_0x0031:
                monitor-exit(r0)
                return
            L_0x0033:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.FileHandle.FileHandleSource.close():void");
        }
    }

    public final Source source(long j) throws IOException {
        synchronized (this) {
            if (!this.closed) {
                this.openStreamCount++;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        return new FileHandleSource(this, j);
    }

    public final Sink sink(long j) throws IOException {
        synchronized (this) {
            if (!this.closed) {
                this.openStreamCount++;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        return new FileHandleSink(this, j);
    }

    public void close() throws IOException {
        synchronized (this) {
            if (!this.closed) {
                this.closed = true;
                if (this.openStreamCount == 0) {
                    Unit unit = Unit.INSTANCE;
                    closeInternal();
                }
            }
        }
    }
}
