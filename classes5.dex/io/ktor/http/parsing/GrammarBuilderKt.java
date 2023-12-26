package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0000¨\u0006\u0007"}, d2 = {"grammar", "Lio/ktor/http/parsing/Grammar;", "block", "Lkotlin/Function1;", "Lio/ktor/http/parsing/GrammarBuilder;", "", "Lkotlin/ExtensionFunctionType;", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: GrammarBuilder.kt */
public final class GrammarBuilderKt {
    public static final Grammar grammar(Function1<? super GrammarBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        GrammarBuilder grammarBuilder = new GrammarBuilder();
        function1.invoke(grammarBuilder);
        return grammarBuilder.build();
    }
}
