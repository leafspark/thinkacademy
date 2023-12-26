package org.apache.commons.fileupload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.util.Closeable;
import org.apache.commons.fileupload.util.Streams;

public class MultipartStream {
    protected static final byte[] BOUNDARY_PREFIX = {CR, 10, DASH, DASH};
    public static final byte CR = 13;
    public static final byte DASH = 45;
    protected static final int DEFAULT_BUFSIZE = 4096;
    protected static final byte[] FIELD_SEPARATOR = {CR, 10};
    public static final int HEADER_PART_SIZE_MAX = 10240;
    protected static final byte[] HEADER_SEPARATOR = {CR, 10, CR, 10};
    public static final byte LF = 10;
    protected static final byte[] STREAM_TERMINATOR = {DASH, DASH};
    private final byte[] boundary;
    private int boundaryLength;
    private final int[] boundaryTable;
    /* access modifiers changed from: private */
    public final int bufSize;
    /* access modifiers changed from: private */
    public final byte[] buffer;
    /* access modifiers changed from: private */
    public int head;
    private String headerEncoding;
    /* access modifiers changed from: private */
    public final InputStream input;
    /* access modifiers changed from: private */
    public final int keepRegion;
    /* access modifiers changed from: private */
    public final ProgressNotifier notifier;
    /* access modifiers changed from: private */
    public int tail;

    static /* synthetic */ int access$108(MultipartStream multipartStream) {
        int i = multipartStream.head;
        multipartStream.head = i + 1;
        return i;
    }

    public static class ProgressNotifier {
        private long bytesRead;
        private final long contentLength;
        private int items;
        private final ProgressListener listener;

        ProgressNotifier(ProgressListener progressListener, long j) {
            this.listener = progressListener;
            this.contentLength = j;
        }

        /* access modifiers changed from: package-private */
        public void noteBytesRead(int i) {
            this.bytesRead += (long) i;
            notifyListener();
        }

        /* access modifiers changed from: package-private */
        public void noteItem() {
            this.items++;
            notifyListener();
        }

        private void notifyListener() {
            ProgressListener progressListener = this.listener;
            if (progressListener != null) {
                progressListener.update(this.bytesRead, this.contentLength, this.items);
            }
        }
    }

    @Deprecated
    public MultipartStream() {
        this((InputStream) null, (byte[]) null, (ProgressNotifier) null);
    }

    @Deprecated
    public MultipartStream(InputStream inputStream, byte[] bArr, int i) {
        this(inputStream, bArr, i, (ProgressNotifier) null);
    }

    public MultipartStream(InputStream inputStream, byte[] bArr, int i, ProgressNotifier progressNotifier) {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr2 = BOUNDARY_PREFIX;
            int length2 = length + bArr2.length;
            this.boundaryLength = length2;
            if (i >= length2 + 1) {
                this.input = inputStream;
                int max = Math.max(i, length2 * 2);
                this.bufSize = max;
                this.buffer = new byte[max];
                this.notifier = progressNotifier;
                int i2 = this.boundaryLength;
                byte[] bArr3 = new byte[i2];
                this.boundary = bArr3;
                this.boundaryTable = new int[(i2 + 1)];
                this.keepRegion = bArr3.length;
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
                computeBoundaryTable();
                this.head = 0;
                this.tail = 0;
                return;
            }
            throw new IllegalArgumentException("The buffer size specified for the MultipartStream is too small");
        }
        throw new IllegalArgumentException("boundary may not be null");
    }

    MultipartStream(InputStream inputStream, byte[] bArr, ProgressNotifier progressNotifier) {
        this(inputStream, bArr, 4096, progressNotifier);
    }

    @Deprecated
    public MultipartStream(InputStream inputStream, byte[] bArr) {
        this(inputStream, bArr, 4096, (ProgressNotifier) null);
    }

    public String getHeaderEncoding() {
        return this.headerEncoding;
    }

    public void setHeaderEncoding(String str) {
        this.headerEncoding = str;
    }

    public byte readByte() throws IOException {
        if (this.head == this.tail) {
            this.head = 0;
            int read = this.input.read(this.buffer, 0, this.bufSize);
            this.tail = read;
            if (read != -1) {
                ProgressNotifier progressNotifier = this.notifier;
                if (progressNotifier != null) {
                    progressNotifier.noteBytesRead(read);
                }
            } else {
                throw new IOException("No more data is available");
            }
        }
        byte[] bArr = this.buffer;
        int i = this.head;
        this.head = i + 1;
        return bArr[i];
    }

    public boolean readBoundary() throws FileUploadBase.FileUploadIOException, MalformedStreamException {
        byte[] bArr = new byte[2];
        this.head += this.boundaryLength;
        try {
            bArr[0] = readByte();
            if (bArr[0] == 10) {
                return true;
            }
            bArr[1] = readByte();
            if (arrayequals(bArr, STREAM_TERMINATOR, 2)) {
                return false;
            }
            if (arrayequals(bArr, FIELD_SEPARATOR, 2)) {
                return true;
            }
            throw new MalformedStreamException("Unexpected characters follow a boundary");
        } catch (FileUploadBase.FileUploadIOException e) {
            throw e;
        } catch (IOException unused) {
            throw new MalformedStreamException("Stream ended unexpectedly");
        }
    }

    public void setBoundary(byte[] bArr) throws IllegalBoundaryException {
        int length = bArr.length;
        int i = this.boundaryLength;
        byte[] bArr2 = BOUNDARY_PREFIX;
        if (length == i - bArr2.length) {
            System.arraycopy(bArr, 0, this.boundary, bArr2.length, bArr.length);
            computeBoundaryTable();
            return;
        }
        throw new IllegalBoundaryException("The length of a boundary token cannot be changed");
    }

    private void computeBoundaryTable() {
        int[] iArr = this.boundaryTable;
        iArr[0] = -1;
        iArr[1] = 0;
        int i = 2;
        int i2 = 0;
        while (i <= this.boundaryLength) {
            byte[] bArr = this.boundary;
            if (bArr[i - 1] == bArr[i2]) {
                i2++;
                this.boundaryTable[i] = i2;
            } else if (i2 > 0) {
                i2 = this.boundaryTable[i2];
            } else {
                this.boundaryTable[i] = 0;
            }
            i++;
        }
    }

    public String readHeaders() throws FileUploadBase.FileUploadIOException, MalformedStreamException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = HEADER_SEPARATOR;
            if (i < bArr.length) {
                try {
                    byte readByte = readByte();
                    i2++;
                    if (i2 <= 10240) {
                        i = readByte == bArr[i] ? i + 1 : 0;
                        byteArrayOutputStream.write(readByte);
                    } else {
                        throw new MalformedStreamException(String.format("Header section has more than %s bytes (maybe it is not properly terminated)", new Object[]{10240}));
                    }
                } catch (FileUploadBase.FileUploadIOException e) {
                    throw e;
                } catch (IOException unused) {
                    throw new MalformedStreamException("Stream ended unexpectedly");
                }
            } else {
                String str = this.headerEncoding;
                if (str == null) {
                    return byteArrayOutputStream.toString();
                }
                try {
                    return byteArrayOutputStream.toString(str);
                } catch (UnsupportedEncodingException unused2) {
                    return byteArrayOutputStream.toString();
                }
            }
        }
    }

    public int readBodyData(OutputStream outputStream) throws MalformedStreamException, IOException {
        return (int) Streams.copy(newInputStream(), outputStream, false);
    }

    /* access modifiers changed from: package-private */
    public ItemInputStream newInputStream() {
        return new ItemInputStream();
    }

    public int discardBodyData() throws MalformedStreamException, IOException {
        return readBodyData((OutputStream) null);
    }

    public boolean skipPreamble() throws IOException {
        byte[] bArr = this.boundary;
        System.arraycopy(bArr, 2, bArr, 0, bArr.length - 2);
        this.boundaryLength = this.boundary.length - 2;
        computeBoundaryTable();
        try {
            discardBodyData();
            return readBoundary();
        } catch (MalformedStreamException unused) {
            return false;
        } finally {
            byte[] bArr2 = this.boundary;
            System.arraycopy(bArr2, 0, bArr2, 2, bArr2.length - 2);
            byte[] bArr3 = this.boundary;
            this.boundaryLength = bArr3.length;
            bArr3[0] = CR;
            bArr3[1] = 10;
            computeBoundaryTable();
        }
    }

    public static boolean arrayequals(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int findByte(byte b, int i) {
        while (i < this.tail) {
            if (this.buffer[i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int findSeparator() {
        int i = this.head;
        int i2 = 0;
        while (i < this.tail) {
            while (i2 >= 0 && this.buffer[i] != this.boundary[i2]) {
                i2 = this.boundaryTable[i2];
            }
            i++;
            i2++;
            int i3 = this.boundaryLength;
            if (i2 == i3) {
                return i - i3;
            }
        }
        return -1;
    }

    public static class MalformedStreamException extends IOException {
        private static final long serialVersionUID = 6466926458059796677L;

        public MalformedStreamException() {
        }

        public MalformedStreamException(String str) {
            super(str);
        }
    }

    public static class IllegalBoundaryException extends IOException {
        private static final long serialVersionUID = -161533165102632918L;

        public IllegalBoundaryException() {
        }

        public IllegalBoundaryException(String str) {
            super(str);
        }
    }

    public class ItemInputStream extends InputStream implements Closeable {
        private static final int BYTE_POSITIVE_OFFSET = 256;
        private boolean closed;
        private int pad;
        private int pos;
        private long total;

        ItemInputStream() {
            findSeparator();
        }

        private void findSeparator() {
            int findSeparator = MultipartStream.this.findSeparator();
            this.pos = findSeparator;
            if (findSeparator != -1) {
                return;
            }
            if (MultipartStream.this.tail - MultipartStream.this.head > MultipartStream.this.keepRegion) {
                this.pad = MultipartStream.this.keepRegion;
            } else {
                this.pad = MultipartStream.this.tail - MultipartStream.this.head;
            }
        }

        public long getBytesRead() {
            return this.total;
        }

        public int available() throws IOException {
            int access$100;
            int i = this.pos;
            if (i == -1) {
                i = MultipartStream.this.tail - MultipartStream.this.head;
                access$100 = this.pad;
            } else {
                access$100 = MultipartStream.this.head;
            }
            return i - access$100;
        }

        public int read() throws IOException {
            if (this.closed) {
                throw new FileItemStream.ItemSkippedException();
            } else if (available() == 0 && makeAvailable() == 0) {
                return -1;
            } else {
                this.total++;
                byte b = MultipartStream.this.buffer[MultipartStream.access$108(MultipartStream.this)];
                return b >= 0 ? b : b + 256;
            }
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.closed) {
                throw new FileItemStream.ItemSkippedException();
            } else if (i2 == 0) {
                return 0;
            } else {
                int available = available();
                if (available == 0 && (available = makeAvailable()) == 0) {
                    return -1;
                }
                int min = Math.min(available, i2);
                System.arraycopy(MultipartStream.this.buffer, MultipartStream.this.head, bArr, i, min);
                MultipartStream multipartStream = MultipartStream.this;
                int unused = multipartStream.head = multipartStream.head + min;
                this.total += (long) min;
                return min;
            }
        }

        public void close() throws IOException {
            close(false);
        }

        public void close(boolean z) throws IOException {
            if (!this.closed) {
                if (!z) {
                    while (true) {
                        int available = available();
                        if (available == 0 && (available = makeAvailable()) == 0) {
                            break;
                        }
                        skip((long) available);
                    }
                } else {
                    this.closed = true;
                    MultipartStream.this.input.close();
                }
                this.closed = true;
            }
        }

        public long skip(long j) throws IOException {
            if (!this.closed) {
                int available = available();
                if (available == 0 && (available = makeAvailable()) == 0) {
                    return 0;
                }
                long min = Math.min((long) available, j);
                MultipartStream multipartStream = MultipartStream.this;
                int unused = multipartStream.head = (int) (((long) multipartStream.head) + min);
                return min;
            }
            throw new FileItemStream.ItemSkippedException();
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0091 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0068  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int makeAvailable() throws java.io.IOException {
            /*
                r7 = this;
                int r0 = r7.pos
                r1 = 0
                r2 = -1
                if (r0 == r2) goto L_0x0007
                return r1
            L_0x0007:
                long r3 = r7.total
                org.apache.commons.fileupload.MultipartStream r0 = org.apache.commons.fileupload.MultipartStream.this
                int r0 = r0.tail
                org.apache.commons.fileupload.MultipartStream r5 = org.apache.commons.fileupload.MultipartStream.this
                int r5 = r5.head
                int r0 = r0 - r5
                int r5 = r7.pad
                int r0 = r0 - r5
                long r5 = (long) r0
                long r3 = r3 + r5
                r7.total = r3
                org.apache.commons.fileupload.MultipartStream r0 = org.apache.commons.fileupload.MultipartStream.this
                byte[] r0 = r0.buffer
                org.apache.commons.fileupload.MultipartStream r3 = org.apache.commons.fileupload.MultipartStream.this
                int r3 = r3.tail
                int r4 = r7.pad
                int r3 = r3 - r4
                org.apache.commons.fileupload.MultipartStream r4 = org.apache.commons.fileupload.MultipartStream.this
                byte[] r4 = r4.buffer
                int r5 = r7.pad
                java.lang.System.arraycopy(r0, r3, r4, r1, r5)
                org.apache.commons.fileupload.MultipartStream r0 = org.apache.commons.fileupload.MultipartStream.this
                int unused = r0.head = r1
                org.apache.commons.fileupload.MultipartStream r0 = org.apache.commons.fileupload.MultipartStream.this
                int r1 = r7.pad
                int unused = r0.tail = r1
            L_0x0043:
                org.apache.commons.fileupload.MultipartStream r0 = org.apache.commons.fileupload.MultipartStream.this
                java.io.InputStream r0 = r0.input
                org.apache.commons.fileupload.MultipartStream r1 = org.apache.commons.fileupload.MultipartStream.this
                byte[] r1 = r1.buffer
                org.apache.commons.fileupload.MultipartStream r3 = org.apache.commons.fileupload.MultipartStream.this
                int r3 = r3.tail
                org.apache.commons.fileupload.MultipartStream r4 = org.apache.commons.fileupload.MultipartStream.this
                int r4 = r4.bufSize
                org.apache.commons.fileupload.MultipartStream r5 = org.apache.commons.fileupload.MultipartStream.this
                int r5 = r5.tail
                int r4 = r4 - r5
                int r0 = r0.read(r1, r3, r4)
                if (r0 == r2) goto L_0x0091
                org.apache.commons.fileupload.MultipartStream r1 = org.apache.commons.fileupload.MultipartStream.this
                org.apache.commons.fileupload.MultipartStream$ProgressNotifier r1 = r1.notifier
                if (r1 == 0) goto L_0x0079
                org.apache.commons.fileupload.MultipartStream r1 = org.apache.commons.fileupload.MultipartStream.this
                org.apache.commons.fileupload.MultipartStream$ProgressNotifier r1 = r1.notifier
                r1.noteBytesRead(r0)
            L_0x0079:
                org.apache.commons.fileupload.MultipartStream r1 = org.apache.commons.fileupload.MultipartStream.this
                int r3 = r1.tail
                int r3 = r3 + r0
                int unused = r1.tail = r3
                r7.findSeparator()
                int r0 = r7.available()
                if (r0 > 0) goto L_0x0090
                int r1 = r7.pos
                if (r1 == r2) goto L_0x0043
            L_0x0090:
                return r0
            L_0x0091:
                org.apache.commons.fileupload.MultipartStream$MalformedStreamException r0 = new org.apache.commons.fileupload.MultipartStream$MalformedStreamException
                java.lang.String r1 = "Stream ended unexpectedly"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.fileupload.MultipartStream.ItemInputStream.makeAvailable():int");
        }

        public boolean isClosed() {
            return this.closed;
        }
    }
}
