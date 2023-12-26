package com.amazonaws.logging;

public final class Environment {
    private static final String JUNIT_PACKAGE_PREFIX = "org.junit.";

    private Environment() {
    }

    public static boolean isJUnitTest() {
        for (StackTraceElement className : Thread.currentThread().getStackTrace()) {
            if (className.getClassName().startsWith(JUNIT_PACKAGE_PREFIX)) {
                return true;
            }
        }
        return false;
    }
}
