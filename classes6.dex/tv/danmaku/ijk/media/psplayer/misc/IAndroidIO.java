package tv.danmaku.ijk.media.psplayer.misc;

import java.io.IOException;

public interface IAndroidIO {
    int close() throws IOException;

    int open(String str) throws IOException;

    int read(byte[] bArr, int i) throws IOException;

    long seek(long j, int i) throws IOException;
}
