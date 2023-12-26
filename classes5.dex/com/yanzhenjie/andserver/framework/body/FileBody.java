package com.yanzhenjie.andserver.framework.body;

import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.IOUtils;
import com.yanzhenjie.andserver.util.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileBody implements ResponseBody {
    private File mBody;

    public boolean isRepeatable() {
        return true;
    }

    public FileBody(File file) {
        if (file != null) {
            this.mBody = file;
            return;
        }
        throw new IllegalArgumentException("The file cannot be null.");
    }

    public long contentLength() {
        return this.mBody.length();
    }

    public MediaType contentType() {
        return MediaType.getFileMediaType(this.mBody.getName());
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.mBody);
        IOUtils.write((InputStream) fileInputStream, outputStream);
        IOUtils.closeQuietly(fileInputStream);
    }
}
