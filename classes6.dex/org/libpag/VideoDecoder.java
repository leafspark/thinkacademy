package org.libpag;

import org.extra.tools.a;

public abstract class VideoDecoder {
    static {
        a.b("pag");
    }

    public static native void RegisterSoftwareDecoderFactory(long j);

    public static native void SetMaxHardwareDecoderCount(int i);
}
