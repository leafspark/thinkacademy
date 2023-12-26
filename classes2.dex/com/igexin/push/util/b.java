package com.igexin.push.util;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.igexin.b.a.c.a.c;
import com.igexin.push.core.d;
import java.net.URISyntaxException;
import java.util.List;

public class b {
    private static volatile Boolean a;

    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0276, code lost:
        if (r12 == false) goto L_0x0278;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02ee, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02f8, code lost:
        throw new java.net.URISyntaxException(r1, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x02fa, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x003c, B:175:0x02e6] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02b1 A[Catch:{ IllegalArgumentException -> 0x02ee, IndexOutOfBoundsException -> 0x02fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02b4 A[Catch:{ IllegalArgumentException -> 0x02ee, IndexOutOfBoundsException -> 0x02fa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(java.lang.String r17, int r18) {
        /*
            r1 = r17
            java.lang.String r0 = "android-app:"
            r2 = 0
            boolean r3 = r1.startsWith(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fc }
            r4 = r18 & 3
            java.lang.String r5 = "intent:"
            java.lang.String r6 = "android.intent.action.VIEW"
            if (r4 == 0) goto L_0x0031
            boolean r4 = r1.startsWith(r5)     // Catch:{ IndexOutOfBoundsException -> 0x02fd }
            if (r4 != 0) goto L_0x0031
            if (r3 != 0) goto L_0x0031
            android.content.Intent r0 = new android.content.Intent     // Catch:{ IndexOutOfBoundsException -> 0x02fd }
            r0.<init>(r6)     // Catch:{ IndexOutOfBoundsException -> 0x02fd }
            android.net.Uri r3 = android.net.Uri.parse(r17)     // Catch:{ IllegalArgumentException -> 0x0026 }
            r0.setData(r3)     // Catch:{ IllegalArgumentException -> 0x0026 }
            return r0
        L_0x0026:
            r0 = move-exception
            java.net.URISyntaxException r3 = new java.net.URISyntaxException     // Catch:{ IndexOutOfBoundsException -> 0x02fd }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IndexOutOfBoundsException -> 0x02fd }
            r3.<init>(r1, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fd }
            throw r3     // Catch:{ IndexOutOfBoundsException -> 0x02fd }
        L_0x0031:
            java.lang.String r4 = "#"
            int r4 = r1.lastIndexOf(r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fc }
            r7 = -1
            if (r4 != r7) goto L_0x0046
            if (r3 != 0) goto L_0x0056
            android.content.Intent r0 = new android.content.Intent     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            android.net.Uri r2 = android.net.Uri.parse(r17)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.<init>(r6, r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            return r0
        L_0x0046:
            java.lang.String r8 = "#Intent;"
            boolean r8 = r1.startsWith(r8, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r8 != 0) goto L_0x0056
            if (r3 != 0) goto L_0x0055
            android.content.Intent r0 = b(r17, r18)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            return r0
        L_0x0055:
            r4 = r7
        L_0x0056:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r3.<init>(r6)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r4 < 0) goto L_0x0064
            java.lang.String r6 = r1.substring(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            int r4 = r4 + 8
            goto L_0x0065
        L_0x0064:
            r6 = r1
        L_0x0065:
            android.os.Bundle r7 = r3.getExtras()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r7 != 0) goto L_0x0073
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r3.putExtras(r7)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
        L_0x0073:
            android.os.Bundle r7 = r3.getExtras()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r10 = r2
            r12 = r10
            r9 = r3
            r11 = 0
        L_0x007b:
            java.lang.String r13 = ":"
            java.lang.String r14 = ""
            if (r4 < 0) goto L_0x0212
            java.lang.String r15 = "end"
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r15 != 0) goto L_0x0212
            r15 = 61
            int r15 = r1.indexOf(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r15 >= 0) goto L_0x0093
            int r15 = r4 + -1
        L_0x0093:
            r8 = 59
            int r8 = r1.indexOf(r8, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r15 >= r8) goto L_0x00a5
            int r14 = r15 + 1
            java.lang.String r14 = r1.substring(r14, r8)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r14 = android.net.Uri.decode(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
        L_0x00a5:
            java.lang.String r2 = "action="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r16 = 1
            if (r2 == 0) goto L_0x00b9
            r9.setAction(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r10 != 0) goto L_0x00b6
            r12 = r16
        L_0x00b6:
            r13 = 0
            goto L_0x0205
        L_0x00b9:
            java.lang.String r2 = "category="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x00c5
            r9.addCategory(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x00c5:
            java.lang.String r2 = "type="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x00d1
            r9.setType(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x00d1:
            java.lang.String r2 = "launchFlags="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x0104
            java.lang.Integer r2 = java.lang.Integer.decode(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            int r2 = r2.intValue()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r9.setFlags(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r2 = r18 & 4
            if (r2 != 0) goto L_0x00b6
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r13 = 19
            if (r2 < r13) goto L_0x00f1
            r2 = 67
            goto L_0x00f2
        L_0x00f1:
            r2 = 3
        L_0x00f2:
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r14 = 21
            if (r13 < r14) goto L_0x00fa
            r2 = r2 | 128(0x80, float:1.794E-43)
        L_0x00fa:
            int r13 = r9.getFlags()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            int r2 = ~r2     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r2 = r2 & r13
            r9.setFlags(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x0104:
            java.lang.String r2 = "package="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x0110
            r9.setPackage(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x0110:
            java.lang.String r2 = "component="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x0120
            android.content.ComponentName r2 = android.content.ComponentName.unflattenFromString(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r9.setComponent(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x0120:
            java.lang.String r2 = "scheme="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x0145
            if (r10 == 0) goto L_0x0142
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r2.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r2.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r9.setData(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x0142:
            r11 = r14
            goto L_0x00b6
        L_0x0145:
            java.lang.String r2 = "sourceBounds="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x0156
            android.graphics.Rect r2 = android.graphics.Rect.unflattenFromString(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r9.setSourceBounds(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x0156:
            int r2 = r4 + 3
            if (r8 != r2) goto L_0x016b
            java.lang.String r2 = "SEL"
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x016b
            android.content.Intent r9 = new android.content.Intent     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r10 = r16
            goto L_0x00b6
        L_0x016b:
            int r2 = r4 + 2
            java.lang.String r2 = r1.substring(r2, r15)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r2 = android.net.Uri.decode(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r13 = "S."
            boolean r13 = r1.startsWith(r13, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r13 == 0) goto L_0x0182
            r7.putString(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x0182:
            java.lang.String r13 = "B."
            boolean r13 = r1.startsWith(r13, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r13 == 0) goto L_0x0193
            boolean r13 = java.lang.Boolean.parseBoolean(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.putBoolean(r2, r13)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x0193:
            java.lang.String r13 = "b."
            boolean r13 = r1.startsWith(r13, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r13 == 0) goto L_0x01a4
            byte r13 = java.lang.Byte.parseByte(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.putByte(r2, r13)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x00b6
        L_0x01a4:
            java.lang.String r13 = "c."
            boolean r13 = r1.startsWith(r13, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r13 == 0) goto L_0x01b5
            r13 = 0
            char r14 = r14.charAt(r13)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.putChar(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x0205
        L_0x01b5:
            r13 = 0
            java.lang.String r15 = "d."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r15 == 0) goto L_0x01c6
            double r14 = java.lang.Double.parseDouble(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.putDouble(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x0205
        L_0x01c6:
            java.lang.String r15 = "f."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r15 == 0) goto L_0x01d6
            float r14 = java.lang.Float.parseFloat(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.putFloat(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x0205
        L_0x01d6:
            java.lang.String r15 = "i."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r15 == 0) goto L_0x01e6
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.putInt(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x0205
        L_0x01e6:
            java.lang.String r15 = "l."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r15 == 0) goto L_0x01f6
            long r14 = java.lang.Long.parseLong(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.putLong(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x0205
        L_0x01f6:
            java.lang.String r15 = "s."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r15 == 0) goto L_0x020a
            short r14 = java.lang.Short.parseShort(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7.putShort(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
        L_0x0205:
            int r4 = r8 + 1
            r2 = r13
            goto L_0x007b
        L_0x020a:
            java.net.URISyntaxException r0 = new java.net.URISyntaxException     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r2 = "unknown EXTRA type"
            r0.<init>(r1, r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
        L_0x0212:
            r9.putExtras(r7)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r10 == 0) goto L_0x0227
            java.lang.String r2 = r3.getPackage()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 != 0) goto L_0x0228
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r7 = 15
            if (r2 < r7) goto L_0x0228
            r3.setSelector(r9)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x0228
        L_0x0227:
            r3 = r9
        L_0x0228:
            if (r6 == 0) goto L_0x02f9
            boolean r2 = r6.startsWith(r5)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r2 == 0) goto L_0x024d
            r0 = 7
            java.lang.String r6 = r6.substring(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r11 == 0) goto L_0x02e0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r2 = 58
            r0.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r6 = r0.toString()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x02e0
        L_0x024d:
            boolean r0 = r6.startsWith(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r0 == 0) goto L_0x02e0
            r0 = 12
            char r0 = r6.charAt(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r2 = 47
            if (r0 != r2) goto L_0x02df
            r0 = 13
            char r0 = r6.charAt(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r0 != r2) goto L_0x02df
            r0 = 14
            int r5 = r6.indexOf(r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r7 = "android.intent.action.MAIN"
            if (r5 >= 0) goto L_0x027c
            java.lang.String r0 = r6.substring(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r3.setPackage(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r12 != 0) goto L_0x02df
        L_0x0278:
            r3.setAction(r7)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x02df
        L_0x027c:
            java.lang.String r0 = r6.substring(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r3.setPackage(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            int r0 = r5 + 1
            int r8 = r6.length()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r0 >= r8) goto L_0x02ae
            int r8 = r6.indexOf(r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r8 < 0) goto L_0x02aa
            java.lang.String r11 = r6.substring(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            int r0 = r6.length()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r8 >= r0) goto L_0x02a8
            int r0 = r8 + 1
            int r5 = r6.indexOf(r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r5 < 0) goto L_0x02a8
            java.lang.String r8 = r6.substring(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x02af
        L_0x02a8:
            r5 = r8
            goto L_0x02ae
        L_0x02aa:
            java.lang.String r11 = r6.substring(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
        L_0x02ae:
            r8 = 0
        L_0x02af:
            if (r11 != 0) goto L_0x02b4
            if (r12 != 0) goto L_0x02df
            goto L_0x0278
        L_0x02b4:
            if (r8 != 0) goto L_0x02c7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
        L_0x02c1:
            java.lang.String r0 = r0.toString()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r6 = r0
            goto L_0x02e0
        L_0x02c7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r2 = "://"
            r0.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r2 = r6.substring(r5)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r0.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            goto L_0x02c1
        L_0x02df:
            r6 = r14
        L_0x02e0:
            int r0 = r6.length()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            if (r0 <= 0) goto L_0x02f9
            android.net.Uri r0 = android.net.Uri.parse(r6)     // Catch:{ IllegalArgumentException -> 0x02ee }
            r3.setData(r0)     // Catch:{ IllegalArgumentException -> 0x02ee }
            goto L_0x02f9
        L_0x02ee:
            r0 = move-exception
            java.net.URISyntaxException r2 = new java.net.URISyntaxException     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            r2.<init>(r1, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
            throw r2     // Catch:{ IndexOutOfBoundsException -> 0x02fa }
        L_0x02f9:
            return r3
        L_0x02fa:
            r2 = r4
            goto L_0x02fd
        L_0x02fc:
            r13 = r2
        L_0x02fd:
            java.net.URISyntaxException r0 = new java.net.URISyntaxException
            java.lang.String r3 = "illegal Intent URI format"
            r0.<init>(r1, r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.b.a(java.lang.String, int):android.content.Intent");
    }

    public static Pair<ServiceInfo, Class> a(Context context, Class cls) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    try {
                        Class<?> cls2 = Class.forName(serviceInfo.name);
                        if (cls2 != cls) {
                            if (l.a(cls2, cls, 5)) {
                                return Pair.create(serviceInfo, cls2);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable th) {
            c.a().a(" findGtImplClassInManifest error = " + th.toString());
        }
        return Pair.create((Object) null, (Object) null);
    }

    private static String a(Context context) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 0);
            return queryIntentActivities.size() > 0 ? queryIntentActivities.get(0).activityInfo.name : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean a() {
        boolean z;
        try {
            if (a != null) {
                return a.booleanValue();
            }
            String a2 = a("ro.miui.ui.version.name");
            String a3 = a("ro.miui.ui.version.code");
            if (!"Xiaomi".equalsIgnoreCase(m.a()) && TextUtils.isEmpty(a2)) {
                if (TextUtils.isEmpty(a3)) {
                    z = false;
                    a = Boolean.valueOf(z);
                    return a.booleanValue();
                }
            }
            z = true;
            a = Boolean.valueOf(z);
            return a.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static synchronized boolean a(int i, Notification notification) {
        synchronized (b.class) {
            try {
                if (a()) {
                    Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                    obj.getClass().getDeclaredMethod("setMessageCount", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)});
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static synchronized boolean a(int i, boolean z) {
        synchronized (b.class) {
            try {
                if (d.g == null) {
                    return false;
                }
                String a2 = m.a();
                if ("huawei".equalsIgnoreCase(a2) || "honor".equalsIgnoreCase(a2)) {
                    int intValue = ((Integer) n.c(d.g, "hwBadgeNum", 0, new String[0])).intValue();
                    if (!z) {
                        i += intValue;
                    }
                    n.b(d.g, "hwBadgeNum", Integer.valueOf(i), new String[0]);
                    Bundle bundle = new Bundle();
                    bundle.putString("package", d.e);
                    bundle.putString("class", a(d.g));
                    bundle.putInt("badgenumber", i);
                    d.g.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static Intent b(String str, int i) {
        boolean z;
        String str2 = str;
        int lastIndexOf = str2.lastIndexOf(35);
        if (lastIndexOf < 0) {
            return new Intent("android.intent.action.VIEW", Uri.parse(str));
        }
        String str3 = null;
        int i2 = lastIndexOf + 1;
        boolean z2 = true;
        if (str2.regionMatches(i2, "action(", 0, 7)) {
            int i3 = i2 + 7;
            int indexOf = str2.indexOf(41, i3);
            z = true;
            String substring = str2.substring(i3, indexOf);
            i2 = indexOf + 1;
            str3 = substring;
        } else {
            z = false;
        }
        Intent intent = new Intent(str3);
        if (str2.regionMatches(i2, "categories(", 0, 11)) {
            int i4 = i2 + 11;
            int indexOf2 = str2.indexOf(41, i4);
            while (i4 < indexOf2) {
                int indexOf3 = str2.indexOf(33, i4);
                if (indexOf3 < 0 || indexOf3 > indexOf2) {
                    indexOf3 = indexOf2;
                }
                if (i4 < indexOf3) {
                    intent.addCategory(str2.substring(i4, indexOf3));
                }
                i4 = indexOf3 + 1;
            }
            i2 = indexOf2 + 1;
            z = true;
        }
        if (str2.regionMatches(i2, "type(", 0, 5)) {
            int i5 = i2 + 5;
            int indexOf4 = str2.indexOf(41, i5);
            intent.setType(str2.substring(i5, indexOf4));
            i2 = indexOf4 + 1;
            z = true;
        }
        if (str2.regionMatches(i2, "launchFlags(", 0, 12)) {
            int i6 = i2 + 12;
            int indexOf5 = str2.indexOf(41, i6);
            intent.setFlags(Integer.decode(str2.substring(i6, indexOf5)).intValue());
            if ((i & 4) == 0) {
                int i7 = 3;
                if (Build.VERSION.SDK_INT >= 19) {
                    i7 = 67;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    i7 |= 128;
                }
                intent.setFlags((~i7) & intent.getFlags());
            }
            i2 = indexOf5 + 1;
            z = true;
        }
        if (str2.regionMatches(i2, "component(", 0, 10)) {
            int i8 = i2 + 10;
            int indexOf6 = str2.indexOf(41, i8);
            int indexOf7 = str2.indexOf(33, i8);
            if (indexOf7 >= 0 && indexOf7 < indexOf6) {
                intent.setComponent(new ComponentName(str2.substring(i8, indexOf7), str2.substring(indexOf7 + 1, indexOf6)));
            }
            i2 = indexOf6 + 1;
            z = true;
        }
        if (str2.regionMatches(i2, "extras(", 0, 7)) {
            int i9 = i2 + 7;
            int indexOf8 = str2.indexOf(41, i9);
            int i10 = -1;
            if (indexOf8 != -1) {
                if (intent.getExtras() == null) {
                    intent.putExtras(new Bundle());
                }
                Bundle extras = intent.getExtras();
                while (i9 < indexOf8) {
                    int indexOf9 = str2.indexOf(61, i9);
                    int i11 = i9 + 1;
                    if (indexOf9 <= i11 || i9 >= indexOf8) {
                        throw new URISyntaxException(str2, "EXTRA missing '='", i9);
                    }
                    char charAt = str2.charAt(i9);
                    String substring2 = str2.substring(i11, indexOf9);
                    int i12 = indexOf9 + 1;
                    int indexOf10 = str2.indexOf(33, i12);
                    if (indexOf10 == i10 || indexOf10 >= indexOf8) {
                        indexOf10 = indexOf8;
                    }
                    if (i12 < indexOf10) {
                        String substring3 = str2.substring(i12, indexOf10);
                        if (charAt == 'B') {
                            extras.putBoolean(substring2, Boolean.parseBoolean(substring3));
                        } else if (charAt == 'S') {
                            extras.putString(substring2, Uri.decode(substring3));
                        } else if (charAt == 'f') {
                            extras.putFloat(substring2, Float.parseFloat(substring3));
                        } else if (charAt == 'i') {
                            extras.putInt(substring2, Integer.parseInt(substring3));
                        } else if (charAt == 'l') {
                            extras.putLong(substring2, Long.parseLong(substring3));
                        } else if (charAt != 's') {
                            switch (charAt) {
                                case 'b':
                                    extras.putByte(substring2, Byte.parseByte(substring3));
                                    break;
                                case 'c':
                                    extras.putChar(substring2, Uri.decode(substring3).charAt(0));
                                    break;
                                case 'd':
                                    extras.putDouble(substring2, Double.parseDouble(substring3));
                                    break;
                                default:
                                    try {
                                        throw new URISyntaxException(str2, "EXTRA has unknown type", indexOf10);
                                    } catch (NumberFormatException unused) {
                                        throw new URISyntaxException(str2, "EXTRA value can't be parsed", indexOf10);
                                    }
                            }
                        } else {
                            extras.putShort(substring2, Short.parseShort(substring3));
                        }
                        char charAt2 = str2.charAt(indexOf10);
                        if (charAt2 == ')') {
                            intent.putExtras(extras);
                        } else if (charAt2 == '!') {
                            i9 = indexOf10 + 1;
                            i10 = -1;
                        } else {
                            throw new URISyntaxException(str2, "EXTRA missing '!'", indexOf10);
                        }
                    } else {
                        throw new URISyntaxException(str2, "EXTRA missing '!'", i12);
                    }
                }
                intent.putExtras(extras);
            } else {
                throw new URISyntaxException(str2, "EXTRA missing trailing ')'", i9);
            }
        } else {
            z2 = z;
        }
        intent.setData(z2 ? Uri.parse(str2.substring(0, lastIndexOf)) : Uri.parse(str));
        if (intent.getAction() != null) {
            return intent;
        }
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }
}
