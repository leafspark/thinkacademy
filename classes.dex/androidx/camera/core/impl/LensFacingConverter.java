package androidx.camera.core.impl;

import java.util.Objects;

public class LensFacingConverter {
    private LensFacingConverter() {
    }

    public static Integer[] values() {
        return new Integer[]{0, 1};
    }

    public static int valueOf(String str) {
        Objects.requireNonNull(str, "name cannot be null");
        str.hashCode();
        if (str.equals("BACK")) {
            return 1;
        }
        if (str.equals("FRONT")) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown len facing name " + str);
    }

    public static String nameOf(int i) {
        if (i == 0) {
            return "FRONT";
        }
        if (i == 1) {
            return "BACK";
        }
        throw new IllegalArgumentException("Unknown lens facing " + i);
    }
}
