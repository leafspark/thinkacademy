package com.facebook.soloader.nativeloader;

public class SystemDelegate implements NativeLoaderDelegate {
    public String getLibraryPath(String str) {
        return null;
    }

    public int getSoSourcesVersion() {
        return 0;
    }

    public boolean loadLibrary(String str, int i) {
        System.loadLibrary(str);
        return true;
    }
}
