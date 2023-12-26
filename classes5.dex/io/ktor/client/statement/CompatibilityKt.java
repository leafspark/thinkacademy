package io.ktor.client.statement;

import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0010\b\u0002\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u0002H\b\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\tHHø\u0001\u0000¢\u0006\u0002\u0010\n\u001aX\u0010\u0007\u001a\u0002H\u000b\"\u0006\b\u0000\u0010\b\u0018\u0001\"\u0004\b\u0001\u0010\u000b*\u00020\t23\b\u0004\u0010\f\u001a-\b\u0001\u0012\u0013\u0012\u0011H\b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\rHHø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"readText", "", "Lio/ktor/client/statement/HttpResponse;", "fallbackCharset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/client/statement/HttpResponse;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receive", "T", "Lio/ktor/client/statement/HttpStatement;", "(Lio/ktor/client/statement/HttpStatement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/client/statement/HttpStatement;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Compatibility.kt */
public final class CompatibilityKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `body` method instead", replaceWith = @ReplaceWith(expression = "this.body<T>()", imports = {}))
    public static final /* synthetic */ <T> Object receive(HttpStatement httpStatement, Continuation<? super T> continuation) {
        throw new IllegalStateException("Use `body` method instead".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `body` method instead", replaceWith = @ReplaceWith(expression = "this.body<T>()", imports = {}))
    public static final /* synthetic */ <T, R> Object receive(HttpStatement httpStatement, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        throw new IllegalStateException("Use `body` method instead".toString());
    }

    public static /* synthetic */ Object readText$default(HttpResponse httpResponse, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return readText(httpResponse, charset, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `bodyAsText` method instead", replaceWith = @ReplaceWith(expression = "this.bodyAsText()", imports = {}))
    public static final Object readText(HttpResponse httpResponse, Charset charset, Continuation<? super String> continuation) {
        throw new IllegalStateException("Use `bodyAsText` method instead".toString());
    }
}
