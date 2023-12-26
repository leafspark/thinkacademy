package com.eaydu.omni.net.okhttp3.internal.cache2;

import com.eaydu.omni.net.okhttp3.internal.Util;
import com.eaydu.omni.net.okio.Buffer;
import com.eaydu.omni.net.okio.ByteString;
import com.eaydu.omni.net.okio.Source;
import com.eaydu.omni.net.okio.Timeout;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final Buffer buffer = new Buffer();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    final Buffer upstreamBuffer = new Buffer();
    long upstreamPos;
    Thread upstreamReader;

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file2, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0, byteString, j);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer2 = new Buffer();
        fileOperator.read(0, buffer2, FILE_HEADER_SIZE);
        ByteString byteString = PREFIX_CLEAN;
        if (buffer2.readByteString((long) byteString.size()).equals(byteString)) {
            long readLong = buffer2.readLong();
            long readLong2 = buffer2.readLong();
            Buffer buffer3 = new Buffer();
            fileOperator.read(readLong + FILE_HEADER_SIZE, buffer3, readLong2);
            return new Relay(randomAccessFile, (Source) null, readLong, buffer3.readByteString(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j);
        buffer2.writeLong(j2);
        if (buffer2.size() == FILE_HEADER_SIZE) {
            new FileOperator(this.file.getChannel()).write(0, buffer2, FILE_HEADER_SIZE);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j, buffer2, (long) this.metadata.size());
    }

    /* access modifiers changed from: package-private */
    public void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly((Closeable) this.upstream);
        this.upstream = null;
    }

    /* access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            r11 = r7 - r1.this$0.buffer.size();
            r13 = r1.sourcePos;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
            if (r13 >= r11) goto L_0x011b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r13);
            r1.this$0.buffer.copyTo(r22, r1.sourcePos - r11, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0135, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(com.eaydu.omni.net.okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                r21 = this;
                r1 = r21
                r2 = r23
                com.eaydu.omni.net.okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x0139
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r4 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0136 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0136 }
                long r7 = r0.upstreamPos     // Catch:{ all -> 0x0136 }
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                r5 = 2
                r9 = -1
                if (r0 != 0) goto L_0x0039
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0136 }
                boolean r0 = r0.complete     // Catch:{ all -> 0x0136 }
                if (r0 == 0) goto L_0x0020
                monitor-exit(r4)     // Catch:{ all -> 0x0136 }
                return r9
            L_0x0020:
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0136 }
                java.lang.Thread r0 = r0.upstreamReader     // Catch:{ all -> 0x0136 }
                if (r0 == 0) goto L_0x002e
                com.eaydu.omni.net.okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x0136 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r5 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0136 }
                r0.waitUntilNotified(r5)     // Catch:{ all -> 0x0136 }
                goto L_0x000b
            L_0x002e:
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0136 }
                java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0136 }
                r0.upstreamReader = r6     // Catch:{ all -> 0x0136 }
                r0 = 1
                monitor-exit(r4)     // Catch:{ all -> 0x0136 }
                goto L_0x004b
            L_0x0039:
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0136 }
                com.eaydu.omni.net.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0136 }
                long r11 = r0.size()     // Catch:{ all -> 0x0136 }
                long r11 = r7 - r11
                long r13 = r1.sourcePos     // Catch:{ all -> 0x0136 }
                int r0 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r0 >= 0) goto L_0x011b
                monitor-exit(r4)     // Catch:{ all -> 0x0136 }
                r0 = r5
            L_0x004b:
                r11 = 32
                if (r0 != r5) goto L_0x0069
                long r4 = r1.sourcePos
                long r7 = r7 - r4
                long r2 = java.lang.Math.min(r2, r7)
                com.eaydu.omni.net.okhttp3.internal.cache2.FileOperator r13 = r1.fileOperator
                long r4 = r1.sourcePos
                long r14 = r4 + r11
                r16 = r22
                r17 = r2
                r13.read(r14, r16, r17)
                long r4 = r1.sourcePos
                long r4 = r4 + r2
                r1.sourcePos = r4
                return r2
            L_0x0069:
                r4 = 0
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okio.Source r0 = r0.upstream     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r5 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okio.Buffer r5 = r5.upstreamBuffer     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r6 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                long r13 = r6.bufferMaxSize     // Catch:{ all -> 0x0109 }
                long r5 = r0.read(r5, r13)     // Catch:{ all -> 0x0109 }
                int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r0 != 0) goto L_0x0094
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                r0.commit(r7)     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r2 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0091 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x0091 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0091 }
                r0.notifyAll()     // Catch:{ all -> 0x0091 }
                monitor-exit(r2)     // Catch:{ all -> 0x0091 }
                return r9
            L_0x0091:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0091 }
                throw r0
            L_0x0094:
                long r2 = java.lang.Math.min(r5, r2)     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okio.Buffer r13 = r0.upstreamBuffer     // Catch:{ all -> 0x0109 }
                r15 = 0
                r14 = r22
                r17 = r2
                r13.copyTo((com.eaydu.omni.net.okio.Buffer) r14, (long) r15, (long) r17)     // Catch:{ all -> 0x0109 }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0109 }
                long r9 = r9 + r2
                r1.sourcePos = r9     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okhttp3.internal.cache2.FileOperator r15 = r1.fileOperator     // Catch:{ all -> 0x0109 }
                long r16 = r7 + r11
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okio.Buffer r18 = r0.clone()     // Catch:{ all -> 0x0109 }
                r19 = r5
                r15.write(r16, r18, r19)     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r7 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                monitor-enter(r7)     // Catch:{ all -> 0x0109 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r8 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okio.Buffer r8 = r8.upstreamBuffer     // Catch:{ all -> 0x0106 }
                r0.write((com.eaydu.omni.net.okio.Buffer) r8, (long) r5)     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0106 }
                long r8 = r0.size()     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                long r10 = r0.bufferMaxSize     // Catch:{ all -> 0x0106 }
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 <= 0) goto L_0x00ed
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r8 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okio.Buffer r8 = r8.buffer     // Catch:{ all -> 0x0106 }
                long r8 = r8.size()     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r10 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                long r10 = r10.bufferMaxSize     // Catch:{ all -> 0x0106 }
                long r8 = r8 - r10
                r0.skip(r8)     // Catch:{ all -> 0x0106 }
            L_0x00ed:
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                long r8 = r0.upstreamPos     // Catch:{ all -> 0x0106 }
                long r8 = r8 + r5
                r0.upstreamPos = r8     // Catch:{ all -> 0x0106 }
                monitor-exit(r7)     // Catch:{ all -> 0x0106 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r5 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this
                monitor-enter(r5)
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0103 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x0103 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0103 }
                r0.notifyAll()     // Catch:{ all -> 0x0103 }
                monitor-exit(r5)     // Catch:{ all -> 0x0103 }
                return r2
            L_0x0103:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0103 }
                throw r0
            L_0x0106:
                r0 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0106 }
                throw r0     // Catch:{ all -> 0x0109 }
            L_0x0109:
                r0 = move-exception
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r2 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r3 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0118 }
                r3.upstreamReader = r4     // Catch:{ all -> 0x0118 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r3 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0118 }
                r3.notifyAll()     // Catch:{ all -> 0x0118 }
                monitor-exit(r2)     // Catch:{ all -> 0x0118 }
                throw r0
            L_0x0118:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0118 }
                throw r0
            L_0x011b:
                long r7 = r7 - r13
                long r2 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x0136 }
                com.eaydu.omni.net.okhttp3.internal.cache2.Relay r0 = com.eaydu.omni.net.okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0136 }
                com.eaydu.omni.net.okio.Buffer r13 = r0.buffer     // Catch:{ all -> 0x0136 }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0136 }
                long r15 = r5 - r11
                r14 = r22
                r17 = r2
                r13.copyTo((com.eaydu.omni.net.okio.Buffer) r14, (long) r15, (long) r17)     // Catch:{ all -> 0x0136 }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0136 }
                long r5 = r5 + r2
                r1.sourcePos = r5     // Catch:{ all -> 0x0136 }
                monitor-exit(r4)     // Catch:{ all -> 0x0136 }
                return r2
            L_0x0136:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0136 }
                throw r0
            L_0x0139:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "closed"
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.net.okhttp3.internal.cache2.Relay.RelaySource.read(com.eaydu.omni.net.okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    relay.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        RandomAccessFile randomAccessFile2 = Relay.this.file;
                        Relay.this.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }
    }
}
