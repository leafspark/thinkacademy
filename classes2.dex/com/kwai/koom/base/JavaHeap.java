package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/kwai/koom/base/JavaHeap;", "", "max", "", "total", "free", "used", "rate", "", "(JJJJF)V", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: Monitor_System.kt */
public final class JavaHeap {
    public long free;
    public long max;
    public float rate;
    public long total;
    public long used;

    public JavaHeap() {
        this(0, 0, 0, 0, 0.0f, 31, (DefaultConstructorMarker) null);
    }

    public JavaHeap(long j, long j2, long j3, long j4, float f) {
        this.max = j;
        this.total = j2;
        this.free = j3;
        this.used = j4;
        this.rate = f;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JavaHeap(long r10, long r12, long r14, long r16, float r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r10
        L_0x0009:
            r0 = r19 & 2
            if (r0 == 0) goto L_0x000f
            r5 = r1
            goto L_0x0010
        L_0x000f:
            r5 = r12
        L_0x0010:
            r0 = r19 & 4
            if (r0 == 0) goto L_0x0016
            r7 = r1
            goto L_0x0017
        L_0x0016:
            r7 = r14
        L_0x0017:
            r0 = r19 & 8
            if (r0 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r1 = r16
        L_0x001e:
            r0 = r19 & 16
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0026
        L_0x0024:
            r0 = r18
        L_0x0026:
            r10 = r9
            r11 = r3
            r13 = r5
            r15 = r7
            r17 = r1
            r19 = r0
            r10.<init>(r11, r13, r15, r17, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.JavaHeap.<init>(long, long, long, long, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
