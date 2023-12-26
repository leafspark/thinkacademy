package com.wushuangtech.broadcast;

import android.content.Context;
import android.view.OrientationEventListener;

public class OrientationEventListenerImpl extends OrientationEventListener {
    private static final int mDiffValue = 45;
    private static final int mDiffValue2 = 45;
    private int mLastRotate = -1;

    public OrientationEventListenerImpl(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r12 < 225) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        if (r12 < 225) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0068, code lost:
        if (r12 < 135) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0084, code lost:
        if (r12 <= 135) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r12 < 225) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOrientationChanged(int r12) {
        /*
            r11 = this;
            int r0 = r11.mLastRotate
            r1 = -1
            r2 = 0
            r3 = 270(0x10e, float:3.78E-43)
            r4 = 180(0xb4, float:2.52E-43)
            r5 = 90
            r6 = 315(0x13b, float:4.41E-43)
            r7 = 135(0x87, float:1.89E-43)
            r8 = 45
            r9 = 225(0xe1, float:3.15E-43)
            if (r0 != r5) goto L_0x0028
            if (r12 <= r9) goto L_0x001b
            if (r12 >= r6) goto L_0x001b
        L_0x0018:
            r3 = r2
            goto L_0x0088
        L_0x001b:
            if (r12 <= r8) goto L_0x0022
            if (r12 >= r7) goto L_0x0022
        L_0x001f:
            r3 = r4
            goto L_0x0088
        L_0x0022:
            if (r12 <= r7) goto L_0x0087
            if (r12 >= r9) goto L_0x0087
            goto L_0x0088
        L_0x0028:
            r10 = 360(0x168, float:5.04E-43)
            if (r0 != 0) goto L_0x0041
            if (r12 < 0) goto L_0x0030
            if (r12 <= r8) goto L_0x0034
        L_0x0030:
            if (r12 < r6) goto L_0x0037
            if (r12 > r10) goto L_0x0037
        L_0x0034:
            r3 = r5
            goto L_0x0088
        L_0x0037:
            if (r12 <= r8) goto L_0x003c
            if (r12 >= r7) goto L_0x003c
            goto L_0x001f
        L_0x003c:
            if (r12 <= r7) goto L_0x0087
            if (r12 >= r9) goto L_0x0087
            goto L_0x0088
        L_0x0041:
            if (r0 != r4) goto L_0x0056
            if (r12 <= r9) goto L_0x0048
            if (r12 >= r6) goto L_0x0048
            goto L_0x0018
        L_0x0048:
            if (r12 < 0) goto L_0x004c
            if (r12 <= r8) goto L_0x0034
        L_0x004c:
            if (r12 < r6) goto L_0x0051
            if (r12 > r10) goto L_0x0051
            goto L_0x0034
        L_0x0051:
            if (r12 <= r7) goto L_0x0087
            if (r12 >= r9) goto L_0x0087
            goto L_0x0088
        L_0x0056:
            if (r0 != r3) goto L_0x006b
            if (r12 <= r9) goto L_0x005d
            if (r12 >= r6) goto L_0x005d
            goto L_0x0018
        L_0x005d:
            if (r12 < 0) goto L_0x0061
            if (r12 <= r8) goto L_0x0034
        L_0x0061:
            if (r12 < r6) goto L_0x0066
            if (r12 > r10) goto L_0x0066
            goto L_0x0034
        L_0x0066:
            if (r12 <= r8) goto L_0x0087
            if (r12 >= r7) goto L_0x0087
            goto L_0x001f
        L_0x006b:
            if (r0 != r1) goto L_0x0087
            if (r12 < 0) goto L_0x0071
            if (r12 <= r8) goto L_0x0034
        L_0x0071:
            r0 = 280(0x118, float:3.92E-43)
            if (r12 < r0) goto L_0x0078
            if (r12 > r10) goto L_0x0078
            goto L_0x0034
        L_0x0078:
            if (r12 < r9) goto L_0x007d
            if (r12 > r6) goto L_0x007d
            goto L_0x0018
        L_0x007d:
            if (r12 < r7) goto L_0x0082
            if (r12 > r9) goto L_0x0082
            goto L_0x0088
        L_0x0082:
            if (r12 < r8) goto L_0x0087
            if (r12 > r7) goto L_0x0087
            goto L_0x001f
        L_0x0087:
            r3 = r1
        L_0x0088:
            if (r3 != r1) goto L_0x008b
            return
        L_0x008b:
            r11.mLastRotate = r3
            com.wushuangtech.library.GlobalHolder r12 = com.wushuangtech.library.GlobalHolder.getInstance()
            r0 = 3
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            r12.sendSyncGlobalMessage(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.broadcast.OrientationEventListenerImpl.onOrientationChanged(int):void");
    }
}
