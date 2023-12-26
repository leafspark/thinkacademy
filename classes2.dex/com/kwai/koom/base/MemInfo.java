package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/kwai/koom/base/MemInfo;", "", "totalInKb", "", "freeInKb", "availableInKb", "IONHeap", "cmaTotal", "rate", "", "(JJJJJF)V", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: Monitor_System.kt */
public final class MemInfo {
    public long IONHeap;
    public long availableInKb;
    public long cmaTotal;
    public long freeInKb;
    public float rate;
    public long totalInKb;

    public MemInfo() {
        this(0, 0, 0, 0, 0, 0.0f, 63, (DefaultConstructorMarker) null);
    }

    public MemInfo(long j, long j2, long j3, long j4, long j5, float f) {
        this.totalInKb = j;
        this.freeInKb = j2;
        this.availableInKb = j3;
        this.IONHeap = j4;
        this.cmaTotal = j5;
        this.rate = f;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MemInfo(long r12, long r14, long r16, long r18, long r20, float r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r12
        L_0x0009:
            r0 = r23 & 2
            if (r0 == 0) goto L_0x000f
            r5 = r1
            goto L_0x0010
        L_0x000f:
            r5 = r14
        L_0x0010:
            r0 = r23 & 4
            if (r0 == 0) goto L_0x0016
            r7 = r1
            goto L_0x0018
        L_0x0016:
            r7 = r16
        L_0x0018:
            r0 = r23 & 8
            if (r0 == 0) goto L_0x001e
            r9 = r1
            goto L_0x0020
        L_0x001e:
            r9 = r18
        L_0x0020:
            r0 = r23 & 16
            if (r0 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r1 = r20
        L_0x0027:
            r0 = r23 & 32
            if (r0 == 0) goto L_0x002d
            r0 = 0
            goto L_0x002f
        L_0x002d:
            r0 = r22
        L_0x002f:
            r12 = r11
            r13 = r3
            r15 = r5
            r17 = r7
            r19 = r9
            r21 = r1
            r23 = r0
            r12.<init>(r13, r15, r17, r19, r21, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.MemInfo.<init>(long, long, long, long, long, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
