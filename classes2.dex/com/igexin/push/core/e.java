package com.igexin.push.core;

import java.io.File;
import java.io.FilenameFilter;

final class e implements FilenameFilter {
    e() {
    }

    public boolean accept(File file, String str) {
        return str.startsWith("tdata");
    }
}
