package com.igexin.a;

import java.io.File;
import java.io.FilenameFilter;

class j implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ i b;

    j(i iVar, String str) {
        this.b = iVar;
        this.a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
