package io.ktor.client.utils;

import io.ktor.http.Headers;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"wrapHeaders", "Lio/ktor/http/content/OutgoingContent;", "block", "Lkotlin/Function1;", "Lio/ktor/http/Headers;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Content.kt */
public final class ContentKt {
    public static final OutgoingContent wrapHeaders(OutgoingContent outgoingContent, Function1<? super Headers, ? extends Headers> function1) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            return new ContentKt$wrapHeaders$1(function1, outgoingContent);
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new ContentKt$wrapHeaders$2(function1, outgoingContent);
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new ContentKt$wrapHeaders$3(function1, outgoingContent);
        }
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            return new ContentKt$wrapHeaders$4(function1, outgoingContent);
        }
        if (outgoingContent instanceof OutgoingContent.ProtocolUpgrade) {
            return new ContentKt$wrapHeaders$5(function1, outgoingContent);
        }
        throw new NoWhenBranchMatchedException();
    }
}
