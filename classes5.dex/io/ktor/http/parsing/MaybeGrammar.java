package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/parsing/MaybeGrammar;", "Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/SimpleGrammar;", "grammar", "(Lio/ktor/http/parsing/Grammar;)V", "getGrammar", "()Lio/ktor/http/parsing/Grammar;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParserDsl.kt */
public final class MaybeGrammar extends Grammar implements SimpleGrammar {
    private final Grammar grammar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaybeGrammar(Grammar grammar2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        this.grammar = grammar2;
    }

    public Grammar getGrammar() {
        return this.grammar;
    }
}
