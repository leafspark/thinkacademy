package org.libpag;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.util.Pair;
import org.extra.tools.a;

public class PAGDecoder {
    private long nativeContext;

    static {
        a.b("pag");
        nativeInit();
    }

    private PAGDecoder(long j) {
        this.nativeContext = j;
    }

    public static PAGDecoder Make(PAGComposition pAGComposition) {
        return Make(pAGComposition, pAGComposition.frameRate(), 1.0f);
    }

    private static native long MakeFrom(PAGComposition pAGComposition, float f, float f2);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean checkFrameChanged(int i);

    public native boolean copyFrameTo(Bitmap bitmap, int i);

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }

    public Bitmap frameAtIndex(int i) {
        boolean z;
        Pair a = a.a(width(), height(), false);
        Object obj = a.first;
        if (obj == null) {
            return null;
        }
        Object obj2 = a.second;
        if (obj2 == null || Build.VERSION.SDK_INT < 26) {
            z = copyFrameTo((Bitmap) obj, i);
        } else {
            z = readFrame(i, (HardwareBuffer) obj2);
            ((HardwareBuffer) a.second).close();
        }
        if (z) {
            return (Bitmap) a.first;
        }
        return null;
    }

    public native float frameRate();

    public native int height();

    public native int numFrames();

    public native boolean readFrame(int i, HardwareBuffer hardwareBuffer);

    public void release() {
        nativeRelease();
    }

    public native int width();

    public static PAGDecoder Make(PAGComposition pAGComposition, float f, float f2) {
        long MakeFrom = MakeFrom(pAGComposition, f, f2);
        if (MakeFrom == 0) {
            return null;
        }
        return new PAGDecoder(MakeFrom);
    }
}
