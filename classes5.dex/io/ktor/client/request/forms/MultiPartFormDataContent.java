package io.ktor.client.request.forms;

import io.ktor.client.request.forms.PreparedPart;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lio/ktor/client/request/forms/MultiPartFormDataContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "parts", "", "Lio/ktor/http/content/PartData;", "boundary", "", "contentType", "Lio/ktor/http/ContentType;", "(Ljava/util/List;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "BODY_OVERHEAD_SIZE", "", "BOUNDARY_BYTES", "", "LAST_BOUNDARY_BYTES", "PART_OVERHEAD_SIZE", "getBoundary", "()Ljava/lang/String;", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContentType", "()Lio/ktor/http/ContentType;", "rawParts", "Lio/ktor/client/request/forms/PreparedPart;", "writeTo", "", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormDataContent.kt */
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {
    private final int BODY_OVERHEAD_SIZE;
    private final byte[] BOUNDARY_BYTES;
    private final byte[] LAST_BOUNDARY_BYTES;
    private final int PART_OVERHEAD_SIZE;
    private final String boundary;
    private final Long contentLength;
    private final ContentType contentType;
    private final List<PreparedPart> rawParts;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiPartFormDataContent(java.util.List r1, java.lang.String r2, io.ktor.http.ContentType r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x0008
            java.lang.String r2 = io.ktor.client.request.forms.FormDataContentKt.generateBoundary()
        L_0x0008:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0018
            io.ktor.http.ContentType$MultiPart r3 = io.ktor.http.ContentType.MultiPart.INSTANCE
            io.ktor.http.ContentType r3 = r3.getFormData()
            java.lang.String r4 = "boundary"
            io.ktor.http.ContentType r3 = r3.withParameter(r4, r2)
        L_0x0018:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.MultiPartFormDataContent.<init>(java.util.List, java.lang.String, io.ktor.http.ContentType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getBoundary() {
        return this.boundary;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public MultiPartFormDataContent(List<? extends PartData> list, String str, ContentType contentType2) {
        byte[] bArr;
        byte[] bArr2;
        PreparedPart preparedPart;
        List<? extends PartData> list2 = list;
        String str2 = str;
        ContentType contentType3 = contentType2;
        Intrinsics.checkNotNullParameter(list2, "parts");
        Intrinsics.checkNotNullParameter(str2, "boundary");
        Intrinsics.checkNotNullParameter(contentType3, "contentType");
        this.boundary = str2;
        this.contentType = contentType3;
        String str3 = "--" + str2 + "\r\n";
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            bArr = StringsKt.encodeToByteArray(str3);
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            bArr = CharsetJVMKt.encodeToByteArray(newEncoder, str3, 0, str3.length());
        }
        this.BOUNDARY_BYTES = bArr;
        String str4 = "--" + str2 + "--\r\n";
        Charset charset2 = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset2, Charsets.UTF_8)) {
            bArr2 = StringsKt.encodeToByteArray(str4);
        } else {
            CharsetEncoder newEncoder2 = charset2.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder2, "charset.newEncoder()");
            bArr2 = CharsetJVMKt.encodeToByteArray(newEncoder2, str4, 0, str4.length());
        }
        this.LAST_BOUNDARY_BYTES = bArr2;
        this.BODY_OVERHEAD_SIZE = bArr2.length;
        this.PART_OVERHEAD_SIZE = (FormDataContentKt.RN_BYTES.length * 2) + bArr.length;
        Iterable iterable = list2;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (true) {
            Long l = null;
            if (it.hasNext()) {
                PartData partData = (PartData) it.next();
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
                for (Map.Entry next : partData.getHeaders().entries()) {
                    Output output = bytePacketBuilder;
                    io.ktor.utils.io.core.StringsKt.writeText$default(output, (CharSequence) ((String) next.getKey()) + ": " + CollectionsKt.joinToString$default((List) next.getValue(), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), 0, 0, (Charset) null, 14, (Object) null);
                    OutputKt.writeFully$default(output, FormDataContentKt.RN_BYTES, 0, 0, 6, (Object) null);
                }
                String str5 = partData.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                Long valueOf = str5 != null ? Long.valueOf(Long.parseLong(str5)) : null;
                if (partData instanceof PartData.FileItem) {
                    byte[] readBytes$default = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, (Object) null);
                    preparedPart = new PreparedPart.InputPart(readBytes$default, ((PartData.FileItem) partData).getProvider(), valueOf != null ? Long.valueOf(valueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) readBytes$default.length)) : l);
                } else if (partData instanceof PartData.BinaryItem) {
                    byte[] readBytes$default2 = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, (Object) null);
                    preparedPart = new PreparedPart.InputPart(readBytes$default2, ((PartData.BinaryItem) partData).getProvider(), valueOf != null ? Long.valueOf(valueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) readBytes$default2.length)) : l);
                } else if (partData instanceof PartData.FormItem) {
                    BytePacketBuilder bytePacketBuilder2 = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
                    try {
                        io.ktor.utils.io.core.StringsKt.writeText$default((Output) bytePacketBuilder2, (CharSequence) ((PartData.FormItem) partData).getValue(), 0, 0, (Charset) null, 14, (Object) null);
                        byte[] readBytes$default3 = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder2.build(), 0, 1, (Object) null);
                        Function0 multiPartFormDataContent$rawParts$1$provider$1 = new MultiPartFormDataContent$rawParts$1$provider$1(readBytes$default3);
                        if (valueOf == null) {
                            Output output2 = bytePacketBuilder;
                            io.ktor.utils.io.core.StringsKt.writeText$default(output2, (CharSequence) HttpHeaders.INSTANCE.getContentLength() + ": " + readBytes$default3.length, 0, 0, (Charset) null, 14, (Object) null);
                            OutputKt.writeFully$default(output2, FormDataContentKt.RN_BYTES, 0, 0, 6, (Object) null);
                        }
                        byte[] readBytes$default4 = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, (Object) null);
                        preparedPart = new PreparedPart.InputPart(readBytes$default4, multiPartFormDataContent$rawParts$1$provider$1, Long.valueOf((long) (readBytes$default3.length + this.PART_OVERHEAD_SIZE + readBytes$default4.length)));
                    } catch (Throwable th) {
                        bytePacketBuilder2.release();
                        throw th;
                    }
                } else if (partData instanceof PartData.BinaryChannelItem) {
                    byte[] readBytes$default5 = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, (Object) null);
                    preparedPart = new PreparedPart.ChannelPart(readBytes$default5, ((PartData.BinaryChannelItem) partData).getProvider(), valueOf != null ? Long.valueOf(valueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) readBytes$default5.length)) : l);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.add(preparedPart);
            } else {
                List<PreparedPart> list3 = (List) arrayList;
                this.rawParts = list3;
                Long l2 = 0L;
                Iterator<PreparedPart> it2 = list3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        l = l2;
                        break;
                    }
                    Long size = it2.next().getSize();
                    if (size == null) {
                        break;
                    }
                    l2 = l2 != null ? Long.valueOf(l2.longValue() + size.longValue()) : null;
                }
                this.contentLength = l != null ? Long.valueOf(l.longValue() + ((long) this.BODY_OVERHEAD_SIZE)) : l;
                return;
            }
        }
    }

    public Long getContentLength() {
        return this.contentLength;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
        if (r10.hasNext() == false) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d0, code lost:
        r4 = r10.next();
        r5 = r2.BOUNDARY_BYTES;
        r0.L$0 = r2;
        r0.L$1 = r9;
        r0.L$2 = r10;
        r0.L$3 = r4;
        r0.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e7, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r5, r0) != r1) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ea, code lost:
        r5 = r2;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ec, code lost:
        r10 = r4.getHeaders();
        r0.L$0 = r5;
        r0.L$1 = r9;
        r0.L$2 = r2;
        r0.L$3 = r4;
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ff, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0) != r1) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0101, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0102, code lost:
        r10 = io.ktor.client.request.forms.FormDataContentKt.RN_BYTES;
        r0.L$0 = r5;
        r0.L$1 = r9;
        r0.L$2 = r2;
        r0.L$3 = r4;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0115, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0) != r1) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0117, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0118, code lost:
        r7 = r4;
        r4 = r9;
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011d, code lost:
        if ((r9 instanceof io.ktor.client.request.forms.PreparedPart.InputPart) == false) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011f, code lost:
        r9 = (java.io.Closeable) ((io.ktor.client.request.forms.PreparedPart.InputPart) r9).getProvider().invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r0.L$0 = r5;
        r0.L$1 = r4;
        r0.L$2 = r2;
        r0.L$3 = r9;
        r0.I$0 = 0;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0140, code lost:
        if (io.ktor.client.request.forms.FormDataContentKt.copyTo((io.ktor.utils.io.core.Input) r9, r4, r0) != r1) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0142, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0143, code lost:
        r10 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0156, code lost:
        if ((r9 instanceof io.ktor.client.request.forms.PreparedPart.ChannelPart) == false) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0158, code lost:
        r0.L$0 = r5;
        r0.L$1 = r4;
        r0.L$2 = r2;
        r0.L$3 = null;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0173, code lost:
        if (io.ktor.utils.io.ByteReadChannelKt.copyTo((io.ktor.utils.io.ByteReadChannel) ((io.ktor.client.request.forms.PreparedPart.ChannelPart) r9).getProvider().invoke(), r4, r0) != r1) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0175, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0176, code lost:
        r9 = r2;
        r2 = r4;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0179, code lost:
        r7 = r2;
        r2 = r9;
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x017d, code lost:
        r9 = r4;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r10 = io.ktor.client.request.forms.FormDataContentKt.RN_BYTES;
        r0.L$0 = r4;
        r0.L$1 = r9;
        r0.L$2 = r2;
        r0.L$3 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0192, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0) != r1) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0194, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0195, code lost:
        r10 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0198, code lost:
        r10 = r2.LAST_BOUNDARY_BYTES;
        r0.L$0 = r9;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a7, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0) != r1) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01a9, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeTo(io.ktor.utils.io.ByteWriteChannel r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1 r0 = (io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1 r0 = new io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x00a5;
                case 2: goto L_0x008e;
                case 3: goto L_0x0079;
                case 4: goto L_0x005f;
                case 5: goto L_0x004a;
                case 6: goto L_0x0036;
                case 7: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002d:
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r9 = (io.ktor.utils.io.ByteWriteChannel) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x01ae }
            goto L_0x01aa
        L_0x0036:
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r4 = (io.ktor.client.request.forms.MultiPartFormDataContent) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x005b }
            r10 = r9
            r9 = r2
        L_0x0047:
            r2 = r4
            goto L_0x00ca
        L_0x004a:
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r4 = (io.ktor.client.request.forms.MultiPartFormDataContent) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x005b }
            goto L_0x0179
        L_0x005b:
            r10 = move-exception
            r9 = r2
            goto L_0x01af
        L_0x005f:
            int r9 = r0.I$0
            java.lang.Object r9 = r0.L$3
            java.io.Closeable r9 = (java.io.Closeable) r9
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r4 = (io.ktor.utils.io.ByteWriteChannel) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r5 = (io.ktor.client.request.forms.MultiPartFormDataContent) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0076 }
            goto L_0x0143
        L_0x0076:
            r10 = move-exception
            goto L_0x0149
        L_0x0079:
            java.lang.Object r9 = r0.L$3
            io.ktor.client.request.forms.PreparedPart r9 = (io.ktor.client.request.forms.PreparedPart) r9
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r4 = (io.ktor.utils.io.ByteWriteChannel) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r5 = (io.ktor.client.request.forms.MultiPartFormDataContent) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x00bc }
            goto L_0x011b
        L_0x008e:
            java.lang.Object r9 = r0.L$3
            io.ktor.client.request.forms.PreparedPart r9 = (io.ktor.client.request.forms.PreparedPart) r9
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r4 = (io.ktor.utils.io.ByteWriteChannel) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r5 = (io.ktor.client.request.forms.MultiPartFormDataContent) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x00bc }
            r7 = r4
            r4 = r9
            r9 = r7
            goto L_0x0102
        L_0x00a5:
            java.lang.Object r9 = r0.L$3
            io.ktor.client.request.forms.PreparedPart r9 = (io.ktor.client.request.forms.PreparedPart) r9
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r4 = (io.ktor.utils.io.ByteWriteChannel) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r5 = (io.ktor.client.request.forms.MultiPartFormDataContent) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x00bc }
            r7 = r4
            r4 = r9
            r9 = r7
            goto L_0x00ec
        L_0x00bc:
            r10 = move-exception
            r9 = r4
            goto L_0x01af
        L_0x00c0:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.List<io.ktor.client.request.forms.PreparedPart> r10 = r8.rawParts     // Catch:{ all -> 0x01ae }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x01ae }
            r2 = r8
        L_0x00ca:
            boolean r4 = r10.hasNext()     // Catch:{ all -> 0x01ae }
            if (r4 == 0) goto L_0x0198
            java.lang.Object r4 = r10.next()     // Catch:{ all -> 0x01ae }
            io.ktor.client.request.forms.PreparedPart r4 = (io.ktor.client.request.forms.PreparedPart) r4     // Catch:{ all -> 0x01ae }
            byte[] r5 = r2.BOUNDARY_BYTES     // Catch:{ all -> 0x01ae }
            r0.L$0 = r2     // Catch:{ all -> 0x01ae }
            r0.L$1 = r9     // Catch:{ all -> 0x01ae }
            r0.L$2 = r10     // Catch:{ all -> 0x01ae }
            r0.L$3 = r4     // Catch:{ all -> 0x01ae }
            r6 = 1
            r0.label = r6     // Catch:{ all -> 0x01ae }
            java.lang.Object r5 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r5, r0)     // Catch:{ all -> 0x01ae }
            if (r5 != r1) goto L_0x00ea
            return r1
        L_0x00ea:
            r5 = r2
            r2 = r10
        L_0x00ec:
            byte[] r10 = r4.getHeaders()     // Catch:{ all -> 0x01ae }
            r0.L$0 = r5     // Catch:{ all -> 0x01ae }
            r0.L$1 = r9     // Catch:{ all -> 0x01ae }
            r0.L$2 = r2     // Catch:{ all -> 0x01ae }
            r0.L$3 = r4     // Catch:{ all -> 0x01ae }
            r6 = 2
            r0.label = r6     // Catch:{ all -> 0x01ae }
            java.lang.Object r10 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0)     // Catch:{ all -> 0x01ae }
            if (r10 != r1) goto L_0x0102
            return r1
        L_0x0102:
            byte[] r10 = io.ktor.client.request.forms.FormDataContentKt.RN_BYTES     // Catch:{ all -> 0x01ae }
            r0.L$0 = r5     // Catch:{ all -> 0x01ae }
            r0.L$1 = r9     // Catch:{ all -> 0x01ae }
            r0.L$2 = r2     // Catch:{ all -> 0x01ae }
            r0.L$3 = r4     // Catch:{ all -> 0x01ae }
            r6 = 3
            r0.label = r6     // Catch:{ all -> 0x01ae }
            java.lang.Object r10 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0)     // Catch:{ all -> 0x01ae }
            if (r10 != r1) goto L_0x0118
            return r1
        L_0x0118:
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x011b:
            boolean r10 = r9 instanceof io.ktor.client.request.forms.PreparedPart.InputPart     // Catch:{ all -> 0x00bc }
            if (r10 == 0) goto L_0x0154
            io.ktor.client.request.forms.PreparedPart$InputPart r9 = (io.ktor.client.request.forms.PreparedPart.InputPart) r9     // Catch:{ all -> 0x00bc }
            kotlin.jvm.functions.Function0 r9 = r9.getProvider()     // Catch:{ all -> 0x00bc }
            java.lang.Object r9 = r9.invoke()     // Catch:{ all -> 0x00bc }
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ all -> 0x00bc }
            r10 = 0
            r6 = r9
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6     // Catch:{ all -> 0x0076 }
            r0.L$0 = r5     // Catch:{ all -> 0x0076 }
            r0.L$1 = r4     // Catch:{ all -> 0x0076 }
            r0.L$2 = r2     // Catch:{ all -> 0x0076 }
            r0.L$3 = r9     // Catch:{ all -> 0x0076 }
            r0.I$0 = r10     // Catch:{ all -> 0x0076 }
            r10 = 4
            r0.label = r10     // Catch:{ all -> 0x0076 }
            java.lang.Object r10 = io.ktor.client.request.forms.FormDataContentKt.copyTo(r6, r4, r0)     // Catch:{ all -> 0x0076 }
            if (r10 != r1) goto L_0x0143
            return r1
        L_0x0143:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0076 }
            r9.close()     // Catch:{ all -> 0x00bc }
            goto L_0x017d
        L_0x0149:
            r9.close()     // Catch:{ all -> 0x014d }
            goto L_0x0151
        L_0x014d:
            r9 = move-exception
            io.ktor.utils.io.core.CloseableJVMKt.addSuppressedInternal(r10, r9)     // Catch:{ all -> 0x0152 }
        L_0x0151:
            throw r10     // Catch:{ all -> 0x0152 }
        L_0x0152:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00bc }
        L_0x0154:
            boolean r10 = r9 instanceof io.ktor.client.request.forms.PreparedPart.ChannelPart     // Catch:{ all -> 0x00bc }
            if (r10 == 0) goto L_0x017d
            io.ktor.client.request.forms.PreparedPart$ChannelPart r9 = (io.ktor.client.request.forms.PreparedPart.ChannelPart) r9     // Catch:{ all -> 0x00bc }
            kotlin.jvm.functions.Function0 r9 = r9.getProvider()     // Catch:{ all -> 0x00bc }
            java.lang.Object r9 = r9.invoke()     // Catch:{ all -> 0x00bc }
            io.ktor.utils.io.ByteReadChannel r9 = (io.ktor.utils.io.ByteReadChannel) r9     // Catch:{ all -> 0x00bc }
            r0.L$0 = r5     // Catch:{ all -> 0x00bc }
            r0.L$1 = r4     // Catch:{ all -> 0x00bc }
            r0.L$2 = r2     // Catch:{ all -> 0x00bc }
            r0.L$3 = r3     // Catch:{ all -> 0x00bc }
            r10 = 5
            r0.label = r10     // Catch:{ all -> 0x00bc }
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannelKt.copyTo(r9, r4, r0)     // Catch:{ all -> 0x00bc }
            if (r9 != r1) goto L_0x0176
            return r1
        L_0x0176:
            r9 = r2
            r2 = r4
            r4 = r5
        L_0x0179:
            r7 = r2
            r2 = r9
            r9 = r7
            goto L_0x017f
        L_0x017d:
            r9 = r4
            r4 = r5
        L_0x017f:
            byte[] r10 = io.ktor.client.request.forms.FormDataContentKt.RN_BYTES     // Catch:{ all -> 0x01ae }
            r0.L$0 = r4     // Catch:{ all -> 0x01ae }
            r0.L$1 = r9     // Catch:{ all -> 0x01ae }
            r0.L$2 = r2     // Catch:{ all -> 0x01ae }
            r0.L$3 = r3     // Catch:{ all -> 0x01ae }
            r5 = 6
            r0.label = r5     // Catch:{ all -> 0x01ae }
            java.lang.Object r10 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0)     // Catch:{ all -> 0x01ae }
            if (r10 != r1) goto L_0x0195
            return r1
        L_0x0195:
            r10 = r2
            goto L_0x0047
        L_0x0198:
            byte[] r10 = r2.LAST_BOUNDARY_BYTES     // Catch:{ all -> 0x01ae }
            r0.L$0 = r9     // Catch:{ all -> 0x01ae }
            r0.L$1 = r3     // Catch:{ all -> 0x01ae }
            r0.L$2 = r3     // Catch:{ all -> 0x01ae }
            r2 = 7
            r0.label = r2     // Catch:{ all -> 0x01ae }
            java.lang.Object r10 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0)     // Catch:{ all -> 0x01ae }
            if (r10 != r1) goto L_0x01aa
            return r1
        L_0x01aa:
            io.ktor.utils.io.ByteWriteChannelKt.close(r9)
            goto L_0x01b3
        L_0x01ae:
            r10 = move-exception
        L_0x01af:
            r9.close(r10)     // Catch:{ all -> 0x01b6 }
            goto L_0x01aa
        L_0x01b3:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x01b6:
            r10 = move-exception
            io.ktor.utils.io.ByteWriteChannelKt.close(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.MultiPartFormDataContent.writeTo(io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
