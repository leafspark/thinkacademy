package com.tal.app.thinkacademy.lib.logger;

public class XesStackTraceUtil {
    public static StackTraceElement[] getCroppedRealStackTrack(StackTraceElement[] stackTraceElementArr, String str, int i) {
        return cropStackTrace(getRealStackTrack(stackTraceElementArr, str), i);
    }

    private static StackTraceElement[] getRealStackTrack(StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        int length = stackTraceElementArr.length;
        int i2 = length - 1;
        while (true) {
            if (i2 < 0) {
                i = 0;
                break;
            }
            String className = stackTraceElementArr[i2].getClassName();
            if (str != null && className.startsWith(str)) {
                i = i2 + 1;
                break;
            }
            i2--;
        }
        int i3 = length - i;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i3];
        System.arraycopy(stackTraceElementArr, i, stackTraceElementArr2, 0, i3);
        return stackTraceElementArr2;
    }

    private static StackTraceElement[] cropStackTrace(StackTraceElement[] stackTraceElementArr, int i) {
        int length = stackTraceElementArr.length;
        if (i > 0) {
            length = Math.min(i, length);
        }
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[length];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, length);
        return stackTraceElementArr2;
    }
}
