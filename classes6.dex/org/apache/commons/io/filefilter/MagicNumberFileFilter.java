package org.apache.commons.io.filefilter;

import java.io.Serializable;
import java.nio.charset.Charset;

public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -547733176983104172L;
    private final long byteOffset;
    private final byte[] magicNumbers;

    public MagicNumberFileFilter(byte[] bArr) {
        this(bArr, 0);
    }

    public MagicNumberFileFilter(String str) {
        this(str, 0);
    }

    public MagicNumberFileFilter(String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j >= 0) {
            this.magicNumbers = str.getBytes(Charset.defaultCharset());
            this.byteOffset = j;
        } else {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
    }

    public MagicNumberFileFilter(byte[] bArr, long j) {
        if (bArr == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j >= 0) {
            byte[] bArr2 = new byte[bArr.length];
            this.magicNumbers = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.byteOffset = j;
        } else {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0040, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean accept(java.io.File r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0041
            boolean r1 = r6.isFile()
            if (r1 == 0) goto L_0x0041
            boolean r1 = r6.canRead()
            if (r1 == 0) goto L_0x0041
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0041 }
            java.lang.String r2 = "r"
            r1.<init>(r6, r2)     // Catch:{ IOException -> 0x0041 }
            byte[] r6 = r5.magicNumbers     // Catch:{ all -> 0x0035 }
            int r6 = r6.length     // Catch:{ all -> 0x0035 }
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0035 }
            long r2 = r5.byteOffset     // Catch:{ all -> 0x0035 }
            r1.seek(r2)     // Catch:{ all -> 0x0035 }
            int r2 = r1.read(r6)     // Catch:{ all -> 0x0035 }
            byte[] r3 = r5.magicNumbers     // Catch:{ all -> 0x0035 }
            int r4 = r3.length     // Catch:{ all -> 0x0035 }
            if (r2 == r4) goto L_0x002d
            r1.close()     // Catch:{ IOException -> 0x0041 }
            return r0
        L_0x002d:
            boolean r6 = java.util.Arrays.equals(r3, r6)     // Catch:{ all -> 0x0035 }
            r1.close()     // Catch:{ IOException -> 0x0041 }
            return r6
        L_0x0035:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r1 = move-exception
            r6.addSuppressed(r1)     // Catch:{ IOException -> 0x0041 }
        L_0x0040:
            throw r2     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.filefilter.MagicNumberFileFilter.accept(java.io.File):boolean");
    }

    public String toString() {
        return super.toString() + "(" + new String(this.magicNumbers, Charset.defaultCharset()) + "," + this.byteOffset + ")";
    }
}
