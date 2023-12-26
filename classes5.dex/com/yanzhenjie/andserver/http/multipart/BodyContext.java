package com.yanzhenjie.andserver.http.multipart;

import com.yanzhenjie.andserver.http.RequestBody;
import com.yanzhenjie.andserver.util.MediaType;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.fileupload.UploadContext;

public class BodyContext implements UploadContext {
    private final RequestBody mBody;

    public BodyContext(RequestBody requestBody) {
        this.mBody = requestBody;
    }

    public String getCharacterEncoding() {
        return this.mBody.contentEncoding();
    }

    public String getContentType() {
        MediaType contentType = this.mBody.contentType();
        if (contentType == null) {
            return null;
        }
        return contentType.toString();
    }

    public int getContentLength() {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) contentLength;
    }

    public long contentLength() {
        return this.mBody.length();
    }

    public InputStream getInputStream() throws IOException {
        return this.mBody.stream();
    }

    public String toString() {
        return String.format("ContentLength=%s, Mime=%s", new Object[]{Long.valueOf(contentLength()), getContentType()});
    }
}
