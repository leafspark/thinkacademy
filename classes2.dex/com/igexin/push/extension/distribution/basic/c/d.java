package com.igexin.push.extension.distribution.basic.c;

import java.io.File;
import java.io.FileFilter;

class d implements FileFilter {
    long a = System.currentTimeMillis();
    long b = 604800000;
    final /* synthetic */ c c;

    d(c cVar) {
        this.c = cVar;
    }

    public boolean accept(File file) {
        return this.a - file.lastModified() >= this.b;
    }
}
