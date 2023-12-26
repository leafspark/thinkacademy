package com.didi.hummer.devtools.utils;

import com.didi.hummer.debug.InvokeTracker;
import java.util.Arrays;
import java.util.List;

public class CallStackFormat {
    public static String format(List<InvokeTracker> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return "┌─────────────────────────\n│\t函数调用栈\n├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n" + generateCallStackInfo(list) + "└─────────────────────────\n";
    }

    private static String generateCallStackInfo(List<InvokeTracker> list) {
        String str;
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (InvokeTracker next : list) {
            if (!next.methodName.equals("constructor_end")) {
                sb.append("│\t");
                Object[] objArr = new Object[5];
                objArr[0] = next.timeFormat;
                objArr[1] = Long.valueOf(next.objectID);
                objArr[2] = next.className;
                objArr[3] = next.methodName;
                if (next.params.length > 0) {
                    str = Arrays.toString(next.params);
                } else {
                    str = "";
                }
                objArr[4] = str;
                sb.append(String.format("[%s] (%d) %s.%s(%s)\n", objArr));
            }
        }
        return sb.toString();
    }
}
