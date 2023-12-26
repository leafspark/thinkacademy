package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\b"}, d2 = {"printlnWithOffset", "", "offset", "", "node", "", "printDebug", "Lio/ktor/http/parsing/Grammar;", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Debug.kt */
public final class DebugKt {
    public static /* synthetic */ void printDebug$default(Grammar grammar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        printDebug(grammar, i);
    }

    public static final void printDebug(Grammar grammar, int i) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        if (grammar instanceof StringGrammar) {
            printlnWithOffset(i, "STRING[" + Regex.Companion.escape(((StringGrammar) grammar).getValue()) + ']');
        } else if (grammar instanceof RawGrammar) {
            printlnWithOffset(i, "STRING[" + ((RawGrammar) grammar).getValue() + ']');
        } else if (grammar instanceof NamedGrammar) {
            StringBuilder sb = new StringBuilder();
            sb.append("NAMED[");
            NamedGrammar namedGrammar = (NamedGrammar) grammar;
            sb.append(namedGrammar.getName());
            sb.append(']');
            printlnWithOffset(i, sb.toString());
            printDebug(namedGrammar.getGrammar(), i + 2);
        } else if (grammar instanceof SequenceGrammar) {
            printlnWithOffset(i, "SEQUENCE");
            for (Grammar printDebug : ((SequenceGrammar) grammar).getGrammars()) {
                printDebug(printDebug, i + 2);
            }
        } else if (grammar instanceof OrGrammar) {
            printlnWithOffset(i, "OR");
            for (Grammar printDebug2 : ((OrGrammar) grammar).getGrammars()) {
                printDebug(printDebug2, i + 2);
            }
        } else if (grammar instanceof MaybeGrammar) {
            printlnWithOffset(i, "MAYBE");
            printDebug(((MaybeGrammar) grammar).getGrammar(), i + 2);
        } else if (grammar instanceof ManyGrammar) {
            printlnWithOffset(i, "MANY");
            printDebug(((ManyGrammar) grammar).getGrammar(), i + 2);
        } else if (grammar instanceof AtLeastOne) {
            printlnWithOffset(i, "MANY_NOT_EMPTY");
            printDebug(((AtLeastOne) grammar).getGrammar(), i + 2);
        } else if (grammar instanceof AnyOfGrammar) {
            printlnWithOffset(i, "ANY_OF[" + Regex.Companion.escape(((AnyOfGrammar) grammar).getValue()) + ']');
        } else if (grammar instanceof RangeGrammar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RANGE[");
            RangeGrammar rangeGrammar = (RangeGrammar) grammar;
            sb2.append(rangeGrammar.getFrom());
            sb2.append('-');
            sb2.append(rangeGrammar.getTo());
            sb2.append(']');
            printlnWithOffset(i, sb2.toString());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final void printlnWithOffset(int i, Object obj) {
        System.out.println(StringsKt.repeat(" ", i) + (i / 2) + ": " + obj);
    }
}
