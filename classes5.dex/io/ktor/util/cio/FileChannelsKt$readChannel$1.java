package io.ktor.util.cio;

import io.ktor.utils.io.WriterScope;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1", f = "FileChannels.kt", i = {0, 0, 1, 1}, l = {47, 66}, m = "invokeSuspend", n = {"$this$use$iv", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* compiled from: FileChannels.kt */
final class FileChannelsKt$readChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $endInclusive;
    final /* synthetic */ RandomAccessFile $file;
    final /* synthetic */ long $fileLength;
    final /* synthetic */ long $start;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileChannelsKt$readChannel$1(long j, long j2, long j3, RandomAccessFile randomAccessFile, Continuation<? super FileChannelsKt$readChannel$1> continuation) {
        super(2, continuation);
        this.$start = j;
        this.$endInclusive = j2;
        this.$fileLength = j3;
        this.$file = randomAccessFile;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fileChannelsKt$readChannel$1 = new FileChannelsKt$readChannel$1(this.$start, this.$endInclusive, this.$fileLength, this.$file, continuation);
        fileChannelsKt$readChannel$1.L$0 = obj;
        return (Continuation) fileChannelsKt$readChannel$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.io.Closeable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x002c
            if (r2 == r4) goto L_0x001e
            if (r2 != r3) goto L_0x0016
            java.lang.Object r0 = r1.L$0
            r2 = r0
            java.io.Closeable r2 = (java.io.Closeable) r2
            goto L_0x0023
        L_0x0016:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x001e:
            java.lang.Object r0 = r1.L$0
            r2 = r0
            java.io.Closeable r2 = (java.io.Closeable) r2
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x0028 }
            goto L_0x00a9
        L_0x0028:
            r0 = move-exception
            r3 = r0
            goto L_0x00b4
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r1.L$0
            io.ktor.utils.io.WriterScope r2 = (io.ktor.utils.io.WriterScope) r2
            long r5 = r1.$start
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r10 = 0
            if (r9 < 0) goto L_0x003e
            r9 = r4
            goto L_0x003f
        L_0x003e:
            r9 = r10
        L_0x003f:
            if (r9 == 0) goto L_0x00e7
            long r11 = r1.$endInclusive
            long r13 = r1.$fileLength
            r15 = 1
            long r13 = r13 - r15
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x004e
            r9 = r4
            goto L_0x004f
        L_0x004e:
            r9 = r10
        L_0x004f:
            java.io.RandomAccessFile r13 = r1.$file
            if (r9 == 0) goto L_0x00c0
            r9 = r13
            java.io.Closeable r9 = (java.io.Closeable) r9
            r14 = r9
            java.io.RandomAccessFile r14 = (java.io.RandomAccessFile) r14     // Catch:{ all -> 0x00b1 }
            java.nio.channels.FileChannel r13 = r13.getChannel()     // Catch:{ all -> 0x00b1 }
            java.lang.String r14 = "file.channel"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ all -> 0x00b1 }
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0069
            r13.position(r5)     // Catch:{ all -> 0x00b1 }
        L_0x0069:
            r7 = -1
            int r7 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x008a
            io.ktor.utils.io.ByteWriteChannel r3 = r2.getChannel()     // Catch:{ all -> 0x00b1 }
            io.ktor.util.cio.FileChannelsKt$readChannel$1$3$1 r5 = new io.ktor.util.cio.FileChannelsKt$readChannel$1$3$1     // Catch:{ all -> 0x00b1 }
            r6 = 0
            r5.<init>(r2, r13, r6)     // Catch:{ all -> 0x00b1 }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x00b1 }
            r1.L$0 = r9     // Catch:{ all -> 0x00b1 }
            r1.I$0 = r10     // Catch:{ all -> 0x00b1 }
            r1.label = r4     // Catch:{ all -> 0x00b1 }
            java.lang.Object r2 = r3.writeSuspendSession(r5, r1)     // Catch:{ all -> 0x00b1 }
            if (r2 != r0) goto L_0x0088
            return r0
        L_0x0088:
            r2 = r9
            goto L_0x00a9
        L_0x008a:
            kotlin.jvm.internal.Ref$LongRef r4 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ all -> 0x00b1 }
            r4.<init>()     // Catch:{ all -> 0x00b1 }
            r4.element = r5     // Catch:{ all -> 0x00b1 }
            io.ktor.utils.io.ByteWriteChannel r2 = r2.getChannel()     // Catch:{ all -> 0x00b1 }
            io.ktor.util.cio.FileChannelsKt$readChannel$1$3$2 r5 = new io.ktor.util.cio.FileChannelsKt$readChannel$1$3$2     // Catch:{ all -> 0x00b1 }
            r5.<init>(r11, r4, r13)     // Catch:{ all -> 0x00b1 }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x00b1 }
            r1.L$0 = r9     // Catch:{ all -> 0x00b1 }
            r1.I$0 = r10     // Catch:{ all -> 0x00b1 }
            r1.label = r3     // Catch:{ all -> 0x00b1 }
            java.lang.Object r2 = r2.writeWhile(r5, r1)     // Catch:{ all -> 0x00b1 }
            if (r2 != r0) goto L_0x0088
            return r0
        L_0x00a9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0028 }
            r2.close()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00b1:
            r0 = move-exception
            r3 = r0
            r2 = r9
        L_0x00b4:
            r2.close()     // Catch:{ all -> 0x00b8 }
            goto L_0x00bd
        L_0x00b8:
            r0 = move-exception
            r2 = r0
            io.ktor.utils.io.core.CloseableJVMKt.addSuppressedInternal(r3, r2)     // Catch:{ all -> 0x00be }
        L_0x00bd:
            throw r3     // Catch:{ all -> 0x00be }
        L_0x00be:
            r0 = move-exception
            throw r0
        L_0x00c0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "endInclusive points to the position out of the file: file size = "
            r0.append(r2)
            long r2 = r13.length()
            r0.append(r2)
            java.lang.String r2 = ", endInclusive = "
            r0.append(r2)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x00e7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "start position shouldn't be negative but it is "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.FileChannelsKt$readChannel$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
