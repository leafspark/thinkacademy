package com.eaydu.omni.gson.internal;

import java.util.Objects;

/* renamed from: com.eaydu.omni.gson.internal.$Gson$Preconditions  reason: invalid class name */
public final class C$Gson$Preconditions {
    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
