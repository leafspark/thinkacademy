package com.facebook.soloader;

import com.facebook.soloader.nativeloader.NativeLoaderDelegate;
import java.io.IOException;

public class NativeLoaderToSoLoaderDelegate implements NativeLoaderDelegate {
    public boolean loadLibrary(String str, int i) {
        return SoLoader.loadLibrary(str, ((i & 1) != 0 ? 16 : 0) | 0);
    }

    public String getLibraryPath(String str) throws IOException {
        return SoLoader.getLibraryPath(str);
    }

    public int getSoSourcesVersion() {
        return SoLoader.getSoSourcesVersion();
    }
}
