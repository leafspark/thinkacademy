package org.libpag;

import org.extra.tools.a;

class NativeTask {
    static {
        a.b("pag");
    }

    static native void Run(Runnable runnable);
}
