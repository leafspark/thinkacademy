package tv.danmaku.ijk.media.psplayer.misc;

import java.io.IOException;

public interface IMediaDataSource {
    void close() throws IOException;

    long getSize() throws IOException;

    int readAt(long j, byte[] bArr, int i, int i2) throws IOException;
}
