package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {107}, m = "executeUnsafe", n = {}, s = {})
/* compiled from: HttpStatement.kt */
final class HttpStatement$executeUnsafe$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpStatement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpStatement$executeUnsafe$1(HttpStatement httpStatement, Continuation<? super HttpStatement$executeUnsafe$1> continuation) {
        super(continuation);
        this.this$0 = httpStatement;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeUnsafe((Continuation) this);
    }
}
