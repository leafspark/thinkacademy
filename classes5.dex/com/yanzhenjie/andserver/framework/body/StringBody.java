package com.yanzhenjie.andserver.framework.body;

import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.IOUtils;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.StringUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.commons.io.Charsets;

public class StringBody implements ResponseBody {
    private byte[] mBody;
    private MediaType mMediaType;

    public boolean isRepeatable() {
        return true;
    }

    public StringBody(String str) {
        this(str, MediaType.TEXT_PLAIN);
    }

    public StringBody(String str, MediaType mediaType) {
        if (!StringUtils.isEmpty(str)) {
            this.mMediaType = mediaType;
            if (mediaType == null) {
                this.mMediaType = new MediaType(MediaType.TEXT_PLAIN, Charsets.UTF_8);
            }
            Charset charset = this.mMediaType.getCharset();
            this.mBody = str.getBytes(charset == null ? Charsets.UTF_8 : charset);
            return;
        }
        throw new IllegalArgumentException("The content cannot be null or empty.");
    }

    public long contentLength() {
        return (long) this.mBody.length;
    }

    public MediaType contentType() {
        if (this.mMediaType.getCharset() != null) {
            return this.mMediaType;
        }
        return new MediaType(this.mMediaType.getType(), this.mMediaType.getSubtype(), Charsets.UTF_8);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        IOUtils.write(outputStream, this.mBody);
    }
}
