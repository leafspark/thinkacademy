package org.libpag;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import org.extra.tools.a;

public class PAGDiskCache {
    static {
        a.b("pag");
    }

    private static String GetCacheDir() {
        Context a = a.a();
        if (a == null) {
            return "";
        }
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = a.getExternalCacheDir();
        }
        if (file == null) {
            file = a.getCacheDir();
        }
        if (file == null) {
            return "";
        }
        return file.getPath();
    }

    public static native long MaxDiskSize();

    static native byte[] ReadFile(String str);

    public static native void RemoveAll();

    public static native void SetMaxDiskSize(long j);

    static native boolean WriteFile(String str, byte[] bArr);
}
