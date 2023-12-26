package com.igexin.push.util;

import java.io.Closeable;
import java.io.IOException;

public class k {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
