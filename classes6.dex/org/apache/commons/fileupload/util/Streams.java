package org.apache.commons.fileupload.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.fileupload.InvalidFileNameException;

public final class Streams {
    private static final int DEFAULT_BUFFER_SIZE = 8192;

    private Streams() {
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return copy(inputStream, outputStream, z, new byte[8192]);
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long copy(java.io.InputStream r5, java.io.OutputStream r6, boolean r7, byte[] r8) throws java.io.IOException {
        /*
            r0 = 0
        L_0x0002:
            int r2 = r5.read(r8)     // Catch:{ all -> 0x002d }
            r3 = -1
            if (r2 != r3) goto L_0x0022
            r8 = 0
            if (r6 == 0) goto L_0x0016
            if (r7 == 0) goto L_0x0012
            r6.close()     // Catch:{ all -> 0x002d }
            goto L_0x0015
        L_0x0012:
            r6.flush()     // Catch:{ all -> 0x002d }
        L_0x0015:
            r6 = r8
        L_0x0016:
            r5.close()     // Catch:{ all -> 0x002d }
            org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r8)
            if (r7 == 0) goto L_0x0021
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r6)
        L_0x0021:
            return r0
        L_0x0022:
            if (r2 <= 0) goto L_0x0002
            long r3 = (long) r2
            long r0 = r0 + r3
            if (r6 == 0) goto L_0x0002
            r3 = 0
            r6.write(r8, r3, r2)     // Catch:{ all -> 0x002d }
            goto L_0x0002
        L_0x002d:
            r8 = move-exception
            org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r5)
            if (r7 == 0) goto L_0x0036
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r6)
        L_0x0036:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.fileupload.util.Streams.copy(java.io.InputStream, java.io.OutputStream, boolean, byte[]):long");
    }

    public static String asString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream, true);
        return byteArrayOutputStream.toString();
    }

    public static String asString(InputStream inputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream, true);
        return byteArrayOutputStream.toString(str);
    }

    public static String checkFileName(String str) {
        if (str != null) {
            if (str.indexOf(0) != -1) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    char charAt = str.charAt(i);
                    if (charAt != 0) {
                        sb.append(charAt);
                    } else {
                        sb.append("\\0");
                    }
                }
                throw new InvalidFileNameException(str, "Invalid file name: " + sb);
            }
        }
        return str;
    }
}
