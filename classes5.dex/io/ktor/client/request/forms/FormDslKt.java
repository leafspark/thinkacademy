package io.ktor.client.request.forms;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\n¢\u0006\u0002\u0010\u000b\u001a[\u0010\f\u001a\u00020\u0006*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0019\b\u0004\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0004 \u0001¢\u0006\u0002\u0010\u0015\u001a]\u0010\f\u001a\u00020\u0006*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0005 \u0001¢\u0006\u0002\u0010\u0019\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001a"}, d2 = {"formData", "", "Lio/ktor/http/content/PartData;", "block", "Lkotlin/Function1;", "Lio/ktor/client/request/forms/FormBuilder;", "", "Lkotlin/ExtensionFunctionType;", "values", "", "Lio/ktor/client/request/forms/FormPart;", "([Lio/ktor/client/request/forms/FormPart;)Ljava/util/List;", "append", "key", "", "headers", "Lio/ktor/http/Headers;", "size", "", "bodyBuilder", "Lio/ktor/utils/io/core/BytePacketBuilder;", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Lio/ktor/http/Headers;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "filename", "contentType", "Lio/ktor/http/ContentType;", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/ContentType;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: formDsl.kt */
public final class FormDslKt {
    public static final List<PartData> formData(FormPart<?>... formPartArr) {
        PartData partData;
        Intrinsics.checkNotNullParameter(formPartArr, "values");
        List<PartData> arrayList = new ArrayList<>();
        for (FormPart<?> formPart : formPartArr) {
            String component1 = formPart.component1();
            Object component2 = formPart.component2();
            Headers component3 = formPart.component3();
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
            headersBuilder.append(HttpHeaders.INSTANCE.getContentDisposition(), "form-data; name=" + HeaderValueWithParametersKt.escapeIfNeeded(component1));
            headersBuilder.appendAll(component3);
            if (component2 instanceof String) {
                partData = new PartData.FormItem((String) component2, FormDslKt$formData$1$part$1.INSTANCE, headersBuilder.build());
            } else if (component2 instanceof Number) {
                partData = new PartData.FormItem(component2.toString(), FormDslKt$formData$1$part$2.INSTANCE, headersBuilder.build());
            } else if (component2 instanceof byte[]) {
                headersBuilder.append(HttpHeaders.INSTANCE.getContentLength(), String.valueOf(((byte[]) component2).length));
                partData = new PartData.BinaryItem(new FormDslKt$formData$1$part$3(component2), FormDslKt$formData$1$part$4.INSTANCE, headersBuilder.build());
            } else if (component2 instanceof ByteReadPacket) {
                headersBuilder.append(HttpHeaders.INSTANCE.getContentLength(), String.valueOf(((ByteReadPacket) component2).getRemaining()));
                partData = new PartData.BinaryItem(new FormDslKt$formData$1$part$5(component2), new FormDslKt$formData$1$part$6(component2), headersBuilder.build());
            } else if (component2 instanceof InputProvider) {
                InputProvider inputProvider = (InputProvider) component2;
                Long size = inputProvider.getSize();
                if (size != null) {
                    headersBuilder.append(HttpHeaders.INSTANCE.getContentLength(), size.toString());
                }
                partData = new PartData.BinaryItem(inputProvider.getBlock(), FormDslKt$formData$1$part$7.INSTANCE, headersBuilder.build());
            } else if (component2 instanceof ChannelProvider) {
                ChannelProvider channelProvider = (ChannelProvider) component2;
                Long size2 = channelProvider.getSize();
                if (size2 != null) {
                    headersBuilder.append(HttpHeaders.INSTANCE.getContentLength(), size2.toString());
                }
                partData = new PartData.BinaryChannelItem(channelProvider.getBlock(), headersBuilder.build());
            } else if (component2 instanceof Input) {
                throw new IllegalStateException(("Can't use [Input] as part of form: " + component2 + ". Consider using [InputProvider] instead.").toString());
            } else {
                throw new IllegalStateException(("Unknown form content type: " + component2).toString());
            }
            arrayList.add(partData);
        }
        return arrayList;
    }

    public static final List<PartData> formData(Function1<? super FormBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        FormBuilder formBuilder = new FormBuilder();
        function1.invoke(formBuilder);
        Object[] array = formBuilder.build$ktor_client_core().toArray(new FormPart[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        FormPart[] formPartArr = (FormPart[]) array;
        return formData((FormPart<?>[]) (FormPart[]) Arrays.copyOf(formPartArr, formPartArr.length));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Headers headers, Long l, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        if ((i & 4) != 0) {
            l = null;
        }
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(function1, "bodyBuilder");
        formBuilder.append(new FormPart(str, new InputProvider(l, new FormDslKt$append$2(function1)), headers));
    }

    public static final void append(FormBuilder formBuilder, String str, Headers headers, Long l, Function1<? super BytePacketBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(function1, "bodyBuilder");
        formBuilder.append(new FormPart(str, new InputProvider(l, new FormDslKt$append$2(function1)), headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String str2, ContentType contentType, Long l, Function1 function1, int i, Object obj) {
        append(formBuilder, str, str2, (i & 4) != 0 ? null : contentType, (i & 8) != 0 ? null : l, function1);
    }

    public static final void append(FormBuilder formBuilder, String str, String str2, ContentType contentType, Long l, Function1<? super BytePacketBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, ContentDisposition.Parameters.FileName);
        Intrinsics.checkNotNullParameter(function1, "bodyBuilder");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        String contentDisposition = HttpHeaders.INSTANCE.getContentDisposition();
        headersBuilder.set(contentDisposition, "filename=" + HeaderValueWithParametersKt.escapeIfNeeded(str2));
        if (contentType != null) {
            headersBuilder.set(HttpHeaders.INSTANCE.getContentType(), contentType.toString());
        }
        formBuilder.append(new FormPart(str, new InputProvider(l, new FormDslKt$append$2(function1)), headersBuilder.build()));
    }
}
