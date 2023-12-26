package com.luck.picture.lib.compress;

import com.luck.picture.lib.entity.LocalMedia;
import java.io.IOException;
import java.io.InputStream;

public interface InputStreamProvider {
    void close();

    LocalMedia getMedia();

    String getPath();

    InputStream open() throws IOException;
}
