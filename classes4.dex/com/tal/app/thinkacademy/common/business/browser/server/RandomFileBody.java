package com.tal.app.thinkacademy.common.business.browser.server;

import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.MediaType;
import java.io.RandomAccessFile;

public class RandomFileBody implements ResponseBody {
    private Long end;
    private RandomAccessFile file;
    private long mLength;
    private MediaType mMediaType;
    private Long start;

    public boolean isRepeatable() {
        return false;
    }

    public RandomFileBody(Long l, Long l2, RandomAccessFile randomAccessFile, Long l3, MediaType mediaType) {
        this.start = l;
        this.end = l2;
        this.file = randomAccessFile;
        this.mLength = l3.longValue();
        this.mMediaType = mediaType;
    }

    public long contentLength() {
        return this.mLength;
    }

    public MediaType contentType() {
        return this.mMediaType;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(java.io.OutputStream r9) {
        /*
            r8 = this;
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            java.io.RandomAccessFile r1 = r8.file     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            java.lang.Long r2 = r8.start     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            r1.seek(r2)     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            r1 = 0
            r2 = 0
            r4 = r1
        L_0x0013:
            long r4 = (long) r4     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            long r4 = r4 + r2
            long r6 = r8.mLength     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x002d
            java.io.RandomAccessFile r4 = r8.file     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            int r4 = r4.read(r0)     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            r5 = -1
            if (r4 == r5) goto L_0x002d
            r9.write(r0, r1, r4)     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            r9.flush()     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            long r5 = (long) r4     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            long r2 = r2 + r5
            goto L_0x0013
        L_0x002d:
            long r4 = r8.mLength     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0041
            java.io.RandomAccessFile r6 = r8.file     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            long r4 = r4 - r2
            int r2 = (int) r4     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            int r2 = r6.read(r0, r1, r2)     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            r9.write(r0, r1, r2)     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            r9.flush()     // Catch:{ IOException -> 0x005c, all -> 0x004e }
        L_0x0041:
            java.io.RandomAccessFile r9 = r8.file     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            r9.close()     // Catch:{ IOException -> 0x005c, all -> 0x004e }
            java.io.RandomAccessFile r9 = r8.file     // Catch:{ IOException -> 0x0064 }
            if (r9 == 0) goto L_0x0068
            r9.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x004e:
            r9 = move-exception
            java.io.RandomAccessFile r0 = r8.file     // Catch:{ IOException -> 0x0057 }
            if (r0 == 0) goto L_0x005b
            r0.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005b:
            throw r9
        L_0x005c:
            java.io.RandomAccessFile r9 = r8.file     // Catch:{ IOException -> 0x0064 }
            if (r9 == 0) goto L_0x0068
            r9.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.business.browser.server.RandomFileBody.writeTo(java.io.OutputStream):void");
    }
}
