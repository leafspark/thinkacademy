package com.bumptech.glide.util.pool;

import java.util.concurrent.atomic.AtomicInteger;

public final class GlideTrace {
    private static final AtomicInteger COOKIE_CREATOR = null;
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    public static void beginSection(String str) {
    }

    public static int beginSectionAsync(String str) {
        return -1;
    }

    public static void beginSectionFormat(String str, Object obj) {
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2) {
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2, Object obj3) {
    }

    public static void endSection() {
    }

    public static void endSectionAsync(String str, int i) {
    }

    private GlideTrace() {
    }

    private static String truncateTag(String str) {
        return str.length() > MAX_LENGTH ? str.substring(0, 126) : str;
    }
}
