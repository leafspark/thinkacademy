package com.yanzhenjie.andserver.http.multipart;

import com.yanzhenjie.andserver.util.MediaType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface MultipartFile {
    byte[] getBytes() throws IOException;

    MediaType getContentType();

    String getFilename();

    String getName();

    long getSize();

    InputStream getStream() throws IOException;

    boolean isEmpty();

    void transferTo(File file) throws IOException, IllegalStateException;
}
