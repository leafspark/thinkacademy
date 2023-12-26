package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0011\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005H\u0004J\u0011\u0010\u0007\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0004J\u0013\u0010\u000b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00050\rH\u0002J\r\u0010\u000b\u001a\u00020\f*\u00020\u0005H\u0002J\r\u0010\u000b\u001a\u00020\f*\u00020\nH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/ktor/http/parsing/GrammarBuilder;", "", "()V", "grammars", "", "Lio/ktor/http/parsing/Grammar;", "build", "then", "grammar", "value", "", "unaryPlus", "", "Lkotlin/Function0;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GrammarBuilder.kt */
public final class GrammarBuilder {
    private final List<Grammar> grammars = new ArrayList();

    public final GrammarBuilder then(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        this.grammars.add(grammar);
        return this;
    }

    public final GrammarBuilder then(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.grammars.add(new StringGrammar(str));
        return this;
    }

    public final void unaryPlus(Function0<? extends Grammar> function0) {
        Intrinsics.checkNotNullParameter(function0, "<this>");
        this.grammars.add(function0.invoke());
    }

    public final void unaryPlus(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        this.grammars.add(grammar);
    }

    public final void unaryPlus(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        this.grammars.add(new StringGrammar(str));
    }

    public final Grammar build() {
        return (Grammar) (this.grammars.size() == 1 ? CollectionsKt.first(this.grammars) : new SequenceGrammar(this.grammars));
    }
}
