package com.tal.app.thinkacademy.lib.util.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MemoryConstants {
    public static final int BYTE = 1;
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }
}