package com.yanzhenjie.andserver.http;

import com.yanzhenjie.andserver.util.MediaType;
import java.io.IOException;
import java.io.InputStream;

public interface RequestBody {
    String contentEncoding();

    MediaType contentType();

    long length();

    InputStream stream() throws IOException;

    String string() throws IOException;
}
