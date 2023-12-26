package com.igexin.push.util;

import java.io.File;
import java.io.FilenameFilter;

final class d implements FilenameFilter {
    final /* synthetic */ String a;

    d(String str) {
        this.a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
