package io.ktor.http.parsing;

import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000fH\b\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0003H\u0000\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0004\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0004\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0004\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0004\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0004\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0004\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0004¨\u0006\u0019"}, d2 = {"anyOf", "Lio/ktor/http/parsing/Grammar;", "value", "", "atLeastOne", "grammar", "many", "maybe", "Lkotlin/Function0;", "block", "Lkotlin/Function1;", "Lio/ktor/http/parsing/GrammarBuilder;", "", "Lkotlin/ExtensionFunctionType;", "flatten", "", "T", "Lio/ktor/http/parsing/ComplexGrammar;", "named", "name", "or", "then", "to", "", "other", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParserDsl.kt */
public final class ParserDslKt {
    public static final Grammar maybe(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return new MaybeGrammar(grammar);
    }

    public static final Grammar maybe(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new MaybeGrammar(new StringGrammar(str));
    }

    public static final Function0<Grammar> maybe(Function1<? super GrammarBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return (Function0) new ParserDslKt$maybe$1(function1);
    }

    public static final Grammar then(String str, Grammar grammar) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return then((Grammar) new StringGrammar(str), grammar);
    }

    public static final Grammar then(Grammar grammar, Grammar grammar2) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        return new SequenceGrammar(CollectionsKt.listOf(new Grammar[]{grammar, grammar2}));
    }

    public static final Grammar then(Grammar grammar, String str) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        return then(grammar, (Grammar) new StringGrammar(str));
    }

    public static final Grammar or(Grammar grammar, Grammar grammar2) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        return new OrGrammar(CollectionsKt.listOf(new Grammar[]{grammar, grammar2}));
    }

    public static final Grammar or(Grammar grammar, String str) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        return or(grammar, (Grammar) new StringGrammar(str));
    }

    public static final Grammar or(String str, Grammar grammar) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return or((Grammar) new StringGrammar(str), grammar);
    }

    public static final Grammar many(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return new ManyGrammar(grammar);
    }

    public static final Grammar atLeastOne(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return new AtLeastOne(grammar);
    }

    public static final Grammar named(Grammar grammar, String str) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return new NamedGrammar(str, grammar);
    }

    public static final Grammar anyOf(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new AnyOfGrammar(str);
    }

    public static final Grammar to(char c, char c2) {
        return new RangeGrammar(c, c2);
    }

    public static final /* synthetic */ <T extends ComplexGrammar> List<Grammar> flatten(List<? extends Grammar> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<Grammar> arrayList = new ArrayList<>();
        for (Grammar grammar : list) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (grammar instanceof ComplexGrammar) {
                CollectionsKt.addAll(arrayList, ((ComplexGrammar) grammar).getGrammars());
            } else {
                arrayList.add(grammar);
            }
        }
        return arrayList;
    }
}
