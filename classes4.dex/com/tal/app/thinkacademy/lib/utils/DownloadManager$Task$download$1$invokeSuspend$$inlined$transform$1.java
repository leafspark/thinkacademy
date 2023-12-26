package com.tal.app.thinkacademy.lib.utils;

import com.tal.app.thinkacademy.lib.utils.DownloadManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1", f = "DownloadManager.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Emitters.kt */
public final class DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super DownloadManager.ListenerHolder>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $downloadLength$inlined;
    final /* synthetic */ File $targetFile$inlined;
    final /* synthetic */ File $tempFile$inlined;
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DownloadManager.Task this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1(Flow flow, Continuation continuation, File file, long j, DownloadManager.Task task, File file2) {
        super(2, continuation);
        this.$this_transform = flow;
        this.$tempFile$inlined = file;
        this.$downloadLength$inlined = j;
        this.this$0 = task;
        this.$targetFile$inlined = file2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> downloadManager$Task$download$1$invokeSuspend$$inlined$transform$1 = new DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1(this.$this_transform, continuation, this.$tempFile$inlined, this.$downloadLength$inlined, this.this$0, this.$targetFile$inlined);
        downloadManager$Task$download$1$invokeSuspend$$inlined$transform$1.L$0 = obj;
        return (Continuation) downloadManager$Task$download$1$invokeSuspend$$inlined$transform$1;
    }

    public final Object invoke(FlowCollector<? super DownloadManager.ListenerHolder> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            final File file = this.$tempFile$inlined;
            final long j = this.$downloadLength$inlined;
            final DownloadManager.Task task = this.this$0;
            final File file2 = this.$targetFile$inlined;
            this.label = 1;
            if (flow.collect(new FlowCollector() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: java.io.RandomAccessFile} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: java.io.RandomAccessFile} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Removed duplicated region for block: B:105:0x01f3 A[SYNTHETIC, Splitter:B:105:0x01f3] */
                /* JADX WARNING: Removed duplicated region for block: B:109:0x01f9 A[SYNTHETIC, Splitter:B:109:0x01f9] */
                /* JADX WARNING: Removed duplicated region for block: B:126:0x0213 A[SYNTHETIC, Splitter:B:126:0x0213] */
                /* JADX WARNING: Removed duplicated region for block: B:130:0x0219 A[SYNTHETIC, Splitter:B:130:0x0219] */
                /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1  */
                /* JADX WARNING: Removed duplicated region for block: B:44:0x00d3 A[SYNTHETIC, Splitter:B:44:0x00d3] */
                /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd A[Catch:{ all -> 0x0201 }] */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x00df A[Catch:{ all -> 0x0201 }] */
                /* JADX WARNING: Removed duplicated region for block: B:51:0x00ea A[Catch:{ all -> 0x0201 }] */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x00eb A[Catch:{ all -> 0x0201 }] */
                /* JADX WARNING: Removed duplicated region for block: B:55:0x00f3 A[Catch:{ all -> 0x0201 }] */
                /* JADX WARNING: Removed duplicated region for block: B:56:0x00f4 A[Catch:{ all -> 0x0201 }] */
                /* JADX WARNING: Removed duplicated region for block: B:67:0x0146  */
                /* JADX WARNING: Removed duplicated region for block: B:75:0x0169 A[Catch:{ all -> 0x0058 }] */
                /* JADX WARNING: Removed duplicated region for block: B:77:0x016f A[Catch:{ all -> 0x0058 }] */
                /* JADX WARNING: Removed duplicated region for block: B:78:0x0170 A[Catch:{ all -> 0x0058 }] */
                /* JADX WARNING: Removed duplicated region for block: B:81:0x0196 A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:85:0x019c A[SYNTHETIC, Splitter:B:85:0x019c] */
                /* JADX WARNING: Removed duplicated region for block: B:89:0x01a2 A[SYNTHETIC, Splitter:B:89:0x01a2] */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
                /* JADX WARNING: Removed duplicated region for block: B:93:0x01aa  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(T r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
                    /*
                        r18 = this;
                        r1 = r18
                        r0 = r20
                        boolean r2 = r0 instanceof com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.AnonymousClass1
                        if (r2 == 0) goto L_0x0018
                        r2 = r0
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1 r2 = (com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r3 & r4
                        if (r3 == 0) goto L_0x0018
                        int r0 = r2.label
                        int r0 = r0 - r4
                        r2.label = r0
                        goto L_0x001d
                    L_0x0018:
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1 r2 = new com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1$1
                        r2.<init>(r1, r0)
                    L_0x001d:
                        java.lang.Object r0 = r2.result
                        java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r4 = r2.label
                        r5 = 0
                        r7 = 3
                        r8 = 2
                        r9 = 1
                        if (r4 == 0) goto L_0x008c
                        if (r4 == r9) goto L_0x0060
                        if (r4 == r8) goto L_0x0048
                        if (r4 != r7) goto L_0x0040
                        java.lang.Object r3 = r2.L$1
                        r11 = r3
                        java.io.RandomAccessFile r11 = (java.io.RandomAccessFile) r11
                        java.lang.Object r2 = r2.L$0
                        java.io.InputStream r2 = (java.io.InputStream) r2
                        kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0058 }
                        goto L_0x01f0
                    L_0x0040:
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r0.<init>(r2)
                        throw r0
                    L_0x0048:
                        java.lang.Object r3 = r2.L$1
                        r11 = r3
                        java.io.RandomAccessFile r11 = (java.io.RandomAccessFile) r11
                        java.lang.Object r2 = r2.L$0
                        java.io.InputStream r2 = (java.io.InputStream) r2
                        kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0058 }
                    L_0x0054:
                        r1 = r11
                        r11 = r2
                        goto L_0x0197
                    L_0x0058:
                        r0 = move-exception
                        r17 = r11
                        r11 = r2
                        r2 = r17
                        goto L_0x0210
                    L_0x0060:
                        int r4 = r2.I$0
                        long r5 = r2.J$1
                        long r12 = r2.J$0
                        java.lang.Object r14 = r2.L$6
                        kotlin.jvm.internal.Ref$IntRef r14 = (kotlin.jvm.internal.Ref.IntRef) r14
                        java.lang.Object r15 = r2.L$5
                        java.io.RandomAccessFile r15 = (java.io.RandomAccessFile) r15
                        java.lang.Object r7 = r2.L$4
                        byte[] r7 = (byte[]) r7
                        java.lang.Object r8 = r2.L$3
                        java.io.InputStream r8 = (java.io.InputStream) r8
                        java.lang.Object r11 = r2.L$2
                        kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                        java.lang.Object r9 = r2.L$1
                        okhttp3.Response r9 = (okhttp3.Response) r9
                        java.lang.Object r10 = r2.L$0
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1$1 r10 = (com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1.AnonymousClass1) r10
                        kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0087 }
                        goto L_0x014c
                    L_0x0087:
                        r0 = move-exception
                        r11 = r8
                        r2 = r15
                        goto L_0x0210
                    L_0x008c:
                        kotlin.ResultKt.throwOnFailure(r0)
                        kotlinx.coroutines.flow.FlowCollector<com.tal.app.thinkacademy.lib.utils.DownloadManager$ListenerHolder> r0 = r4
                        r4 = r2
                        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                        r4 = r19
                        okhttp3.Response r4 = (okhttp3.Response) r4
                        r7 = 2048(0x800, float:2.87E-42)
                        byte[] r7 = new byte[r7]
                        okhttp3.ResponseBody r8 = r4.body()     // Catch:{ all -> 0x020d }
                        if (r8 != 0) goto L_0x00a4
                        r8 = 0
                        goto L_0x00a8
                    L_0x00a4:
                        java.io.InputStream r8 = r8.byteStream()     // Catch:{ all -> 0x020d }
                    L_0x00a8:
                        okhttp3.ResponseBody r9 = r4.body()     // Catch:{ all -> 0x0209 }
                        if (r9 != 0) goto L_0x00b0
                        r9 = r5
                        goto L_0x00b4
                    L_0x00b0:
                        long r9 = r9.contentLength()     // Catch:{ all -> 0x0209 }
                    L_0x00b4:
                        java.io.RandomAccessFile r11 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0209 }
                        java.io.File r12 = r5     // Catch:{ all -> 0x0209 }
                        java.lang.String r13 = "rw"
                        r11.<init>(r12, r13)     // Catch:{ all -> 0x0209 }
                        long r12 = r6     // Catch:{ all -> 0x0206 }
                        r11.seek(r12)     // Catch:{ all -> 0x0206 }
                        kotlin.jvm.internal.Ref$IntRef r12 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x0206 }
                        r12.<init>()     // Catch:{ all -> 0x0206 }
                        r14 = r12
                        r12 = r9
                        r10 = r1
                        r9 = r4
                        r4 = r0
                        r0 = r2
                        r2 = r8
                        r8 = 0
                    L_0x00cf:
                        if (r2 != 0) goto L_0x00d3
                        r15 = 0
                        goto L_0x00db
                    L_0x00d3:
                        int r15 = r2.read(r7)     // Catch:{ all -> 0x0201 }
                        java.lang.Integer r15 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r15)     // Catch:{ all -> 0x0201 }
                    L_0x00db:
                        if (r15 != 0) goto L_0x00df
                        r1 = 0
                        goto L_0x00e5
                    L_0x00df:
                        int r16 = r15.intValue()     // Catch:{ all -> 0x0201 }
                        r1 = r16
                    L_0x00e5:
                        r14.element = r1     // Catch:{ all -> 0x0201 }
                        r1 = -1
                        if (r15 != 0) goto L_0x00eb
                        goto L_0x00f1
                    L_0x00eb:
                        int r15 = r15.intValue()     // Catch:{ all -> 0x0201 }
                        if (r15 == r1) goto L_0x01ae
                    L_0x00f1:
                        if (r11 != 0) goto L_0x00f4
                        goto L_0x00fa
                    L_0x00f4:
                        int r1 = r14.element     // Catch:{ all -> 0x0201 }
                        r15 = 0
                        r11.write(r7, r15, r1)     // Catch:{ all -> 0x0201 }
                    L_0x00fa:
                        int r1 = r14.element     // Catch:{ all -> 0x0201 }
                        r16 = r14
                        long r14 = (long) r1     // Catch:{ all -> 0x0201 }
                        long r5 = r5 + r14
                        long r14 = r6     // Catch:{ all -> 0x0201 }
                        r19 = r2
                        long r1 = r5 + r14
                        float r1 = (float) r1
                        r2 = 1120403456(0x42c80000, float:100.0)
                        float r1 = r1 * r2
                        long r14 = r14 + r12
                        float r2 = (float) r14
                        float r1 = r1 / r2
                        int r1 = (int) r1
                        if (r1 <= r8) goto L_0x0157
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task r2 = r8     // Catch:{ all -> 0x0152 }
                        java.util.concurrent.atomic.AtomicInteger r2 = r2.mProgress     // Catch:{ all -> 0x0152 }
                        r2.compareAndSet(r8, r1)     // Catch:{ all -> 0x0152 }
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$ListenerHolder$DownloadProgress r2 = new com.tal.app.thinkacademy.lib.utils.DownloadManager$ListenerHolder$DownloadProgress     // Catch:{ all -> 0x0152 }
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task r8 = r8     // Catch:{ all -> 0x0152 }
                        java.lang.String r8 = r8.url     // Catch:{ all -> 0x0152 }
                        r2.<init>(r8, r1)     // Catch:{ all -> 0x0152 }
                        r0.L$0 = r10     // Catch:{ all -> 0x0152 }
                        r0.L$1 = r9     // Catch:{ all -> 0x0152 }
                        r0.L$2 = r4     // Catch:{ all -> 0x0152 }
                        r14 = r19
                        r0.L$3 = r14     // Catch:{ all -> 0x01ff }
                        r0.L$4 = r7     // Catch:{ all -> 0x01ff }
                        r0.L$5 = r11     // Catch:{ all -> 0x01ff }
                        r15 = r16
                        r0.L$6 = r15     // Catch:{ all -> 0x01ff }
                        r0.J$0 = r12     // Catch:{ all -> 0x01ff }
                        r0.J$1 = r5     // Catch:{ all -> 0x01ff }
                        r0.I$0 = r1     // Catch:{ all -> 0x01ff }
                        r8 = 1
                        r0.label = r8     // Catch:{ all -> 0x01ff }
                        java.lang.Object r2 = r4.emit(r2, r0)     // Catch:{ all -> 0x01ff }
                        if (r2 != r3) goto L_0x0146
                        return r3
                    L_0x0146:
                        r2 = r0
                        r8 = r14
                        r14 = r15
                        r15 = r11
                        r11 = r4
                        r4 = r1
                    L_0x014c:
                        r0 = r2
                        r2 = r8
                        r8 = r4
                        r4 = r11
                        r11 = r15
                        goto L_0x015d
                    L_0x0152:
                        r0 = move-exception
                        r14 = r19
                        goto L_0x0203
                    L_0x0157:
                        r14 = r19
                        r15 = r16
                        r2 = r14
                        r14 = r15
                    L_0x015d:
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task r1 = r8     // Catch:{ all -> 0x0058 }
                        java.util.concurrent.atomic.AtomicBoolean r1 = r1.mIsCancel     // Catch:{ all -> 0x0058 }
                        boolean r1 = r1.get()     // Catch:{ all -> 0x0058 }
                        if (r1 == 0) goto L_0x01aa
                        okhttp3.ResponseBody r1 = r9.body()     // Catch:{ all -> 0x0058 }
                        if (r1 != 0) goto L_0x0170
                        goto L_0x0173
                    L_0x0170:
                        r1.close()     // Catch:{ all -> 0x0058 }
                    L_0x0173:
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$ListenerHolder$DownloadCancel r1 = new com.tal.app.thinkacademy.lib.utils.DownloadManager$ListenerHolder$DownloadCancel     // Catch:{ all -> 0x0058 }
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task r5 = r8     // Catch:{ all -> 0x0058 }
                        java.lang.String r5 = r5.url     // Catch:{ all -> 0x0058 }
                        r1.<init>(r5)     // Catch:{ all -> 0x0058 }
                        r0.L$0 = r2     // Catch:{ all -> 0x0058 }
                        r0.L$1 = r11     // Catch:{ all -> 0x0058 }
                        r5 = 0
                        r0.L$2 = r5     // Catch:{ all -> 0x0058 }
                        r0.L$3 = r5     // Catch:{ all -> 0x0058 }
                        r0.L$4 = r5     // Catch:{ all -> 0x0058 }
                        r0.L$5 = r5     // Catch:{ all -> 0x0058 }
                        r0.L$6 = r5     // Catch:{ all -> 0x0058 }
                        r15 = 2
                        r0.label = r15     // Catch:{ all -> 0x0058 }
                        java.lang.Object r0 = r4.emit(r1, r0)     // Catch:{ all -> 0x0058 }
                        if (r0 != r3) goto L_0x0054
                        return r3
                    L_0x0197:
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01a6 }
                        if (r11 != 0) goto L_0x019c
                        goto L_0x019f
                    L_0x019c:
                        r11.close()     // Catch:{ IOException -> 0x019f }
                    L_0x019f:
                        if (r1 != 0) goto L_0x01a2
                        goto L_0x01fc
                    L_0x01a2:
                        r1.close()     // Catch:{ IOException -> 0x01fc }
                        goto L_0x01fc
                    L_0x01a6:
                        r0 = move-exception
                        r2 = r1
                        goto L_0x0210
                    L_0x01aa:
                        r1 = r18
                        goto L_0x00cf
                    L_0x01ae:
                        r14 = r2
                        java.io.File r1 = r5     // Catch:{ all -> 0x01ff }
                        java.io.File r2 = r9     // Catch:{ all -> 0x01ff }
                        r1.renameTo(r2)     // Catch:{ all -> 0x01ff }
                        okhttp3.ResponseBody r1 = r9.body()     // Catch:{ all -> 0x01ff }
                        if (r1 != 0) goto L_0x01bd
                        goto L_0x01c0
                    L_0x01bd:
                        r1.close()     // Catch:{ all -> 0x01ff }
                    L_0x01c0:
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task r1 = r8     // Catch:{ all -> 0x01ff }
                        java.util.concurrent.atomic.AtomicBoolean r1 = r1.mComplete     // Catch:{ all -> 0x01ff }
                        r2 = 1
                        r5 = 0
                        r1.compareAndSet(r5, r2)     // Catch:{ all -> 0x01ff }
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$ListenerHolder$DownloadSuccess r1 = new com.tal.app.thinkacademy.lib.utils.DownloadManager$ListenerHolder$DownloadSuccess     // Catch:{ all -> 0x01ff }
                        com.tal.app.thinkacademy.lib.utils.DownloadManager$Task r2 = r8     // Catch:{ all -> 0x01ff }
                        java.lang.String r2 = r2.url     // Catch:{ all -> 0x01ff }
                        r1.<init>(r2)     // Catch:{ all -> 0x01ff }
                        r0.L$0 = r14     // Catch:{ all -> 0x01ff }
                        r0.L$1 = r11     // Catch:{ all -> 0x01ff }
                        r2 = 0
                        r0.L$2 = r2     // Catch:{ all -> 0x01ff }
                        r0.L$3 = r2     // Catch:{ all -> 0x01ff }
                        r0.L$4 = r2     // Catch:{ all -> 0x01ff }
                        r0.L$5 = r2     // Catch:{ all -> 0x01ff }
                        r0.L$6 = r2     // Catch:{ all -> 0x01ff }
                        r2 = 3
                        r0.label = r2     // Catch:{ all -> 0x01ff }
                        java.lang.Object r0 = r4.emit(r1, r0)     // Catch:{ all -> 0x01ff }
                        if (r0 != r3) goto L_0x01ef
                        return r3
                    L_0x01ef:
                        r2 = r14
                    L_0x01f0:
                        if (r2 != 0) goto L_0x01f3
                        goto L_0x01f6
                    L_0x01f3:
                        r2.close()     // Catch:{ IOException -> 0x01f6 }
                    L_0x01f6:
                        if (r11 != 0) goto L_0x01f9
                        goto L_0x01fc
                    L_0x01f9:
                        r11.close()     // Catch:{ IOException -> 0x01fc }
                    L_0x01fc:
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    L_0x01ff:
                        r0 = move-exception
                        goto L_0x0203
                    L_0x0201:
                        r0 = move-exception
                        r14 = r2
                    L_0x0203:
                        r2 = r11
                        r11 = r14
                        goto L_0x0210
                    L_0x0206:
                        r0 = move-exception
                        r2 = r11
                        goto L_0x020b
                    L_0x0209:
                        r0 = move-exception
                        r2 = 0
                    L_0x020b:
                        r11 = r8
                        goto L_0x0210
                    L_0x020d:
                        r0 = move-exception
                        r2 = 0
                        r11 = r2
                    L_0x0210:
                        if (r11 != 0) goto L_0x0213
                        goto L_0x0216
                    L_0x0213:
                        r11.close()     // Catch:{ IOException -> 0x0216 }
                    L_0x0216:
                        if (r2 != 0) goto L_0x0219
                        goto L_0x021c
                    L_0x0219:
                        r2.close()     // Catch:{ IOException -> 0x021c }
                    L_0x021c:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.utils.DownloadManager$Task$download$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
