package org.apache.httpcore.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okio.internal._BufferKt;
import org.apache.httpcore.util.Args;
import tv.danmaku.ijk.media.psplayer.IjkMediaMeta;

public class InputStreamEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return true;
    }

    public InputStreamEntity(InputStream inputStream) {
        this(inputStream, -1);
    }

    public InputStreamEntity(InputStream inputStream, long j) {
        this(inputStream, j, (ContentType) null);
    }

    public InputStreamEntity(InputStream inputStream, ContentType contentType) {
        this(inputStream, -1, contentType);
    }

    public InputStreamEntity(InputStream inputStream, long j, ContentType contentType) {
        this.content = (InputStream) Args.notNull(inputStream, "Source input stream");
        this.length = j;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public long getContentLength() {
        return this.length;
    }

    public InputStream getContent() throws IOException {
        return this.content;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        InputStream inputStream = this.content;
        try {
            byte[] bArr = new byte[_BufferKt.SEGMENTING_THRESHOLD];
            long j = this.length;
            if (j < 0) {
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
            } else {
                while (true) {
                    if (j <= 0) {
                        break;
                    }
                    int read2 = inputStream.read(bArr, 0, (int) Math.min(IjkMediaMeta.AV_CH_TOP_FRONT_LEFT, j));
                    if (read2 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read2);
                    j -= (long) read2;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
