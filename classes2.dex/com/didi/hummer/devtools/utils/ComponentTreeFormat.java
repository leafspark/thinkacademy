package com.didi.hummer.devtools.utils;

import android.text.TextUtils;
import com.didi.hummer.render.style.HummerNode;
import java.util.Iterator;

public class ComponentTreeFormat {
    private static final String FORMAT_STRING_LEFT_BOTTOM = "└─";
    private static final String FORMAT_STRING_LEFT_CENTER = "├─";
    private static final String FORMAT_STRING_LEFT_TOP = "┌─";
    private static final String FORMAT_STRING_NORMAL_H = "─";
    private static final String FORMAT_STRING_NORMAL_V = "│";

    public static String format(HummerNode hummerNode) {
        if (hummerNode == null) {
            return "";
        }
        return "┌─────────────────────────\n│\t视图树\n├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n" + generateNodeTreeInfo(hummerNode, 0, 0) + "└─────────────────────────\n";
    }

    private static String generateNodeTreeInfo(HummerNode hummerNode, int i, int i2) {
        if (hummerNode == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("│\t");
        sb.append(generateTabFormatString(i, i2));
        if (hummerNode.getObjId() >= 0) {
            sb.append(hummerNode.getObjId());
            sb.append(".");
        }
        sb.append(hummerNode.getName());
        if (!TextUtils.isEmpty(hummerNode.getContent())) {
            sb.append(" (");
            sb.append(hummerNode.getContent());
            sb.append(")");
        }
        sb.append(10);
        if (hummerNode.getChildren() != null && !hummerNode.getChildren().isEmpty()) {
            int i3 = i + 1;
            Iterator<HummerNode> it = hummerNode.getChildren().iterator();
            while (it.hasNext()) {
                HummerNode next = it.next();
                if (!it.hasNext()) {
                    i2 |= 1 << i;
                }
                sb.append(generateNodeTreeInfo(next, i3, i2));
            }
        }
        return sb.toString();
    }

    private static String generateTabFormatString(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i; i3++) {
            if (((1 << i3) & i2) == 0) {
                if (i3 < i - 1) {
                    sb.append("│\t");
                } else {
                    sb.append(FORMAT_STRING_LEFT_CENTER);
                }
            } else if (i3 < i - 1) {
                sb.append("\t");
            } else {
                sb.append(FORMAT_STRING_LEFT_BOTTOM);
            }
        }
        if (sb.length() > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
