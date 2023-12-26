package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\bHHø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"receive", "T", "Lio/ktor/client/call/HttpClientCall;", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "info", "Lio/ktor/util/reflect/TypeInfo;", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Compatibility.kt */
public final class CompatibilityKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `body` method instead", replaceWith = @ReplaceWith(expression = "this.body<T>()", imports = {}))
    public static final /* synthetic */ <T> Object receive(HttpClientCall httpClientCall, Continuation<? super T> continuation) {
        throw new IllegalStateException("Use `body` method instead".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `body` method instead", replaceWith = @ReplaceWith(expression = "this.body<T>()", imports = {}))
    public static final /* synthetic */ <T> Object receive(HttpResponse httpResponse, Continuation<? super T> continuation) {
        throw new IllegalStateException("Use `body` method instead".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `body` method instead", replaceWith = @ReplaceWith(expression = "this.body(info)", imports = {}))
    public static final Object receive(HttpClientCall httpClientCall, TypeInfo typeInfo, Continuation<Object> continuation) {
        throw new IllegalStateException("Use `body` method instead".toString());
    }
}
