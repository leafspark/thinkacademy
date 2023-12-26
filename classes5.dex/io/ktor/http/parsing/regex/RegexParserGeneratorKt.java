package io.ktor.http.parsing.regex;

import io.ktor.http.parsing.AnyOfGrammar;
import io.ktor.http.parsing.AtLeastOne;
import io.ktor.http.parsing.ComplexGrammar;
import io.ktor.http.parsing.Grammar;
import io.ktor.http.parsing.ManyGrammar;
import io.ktor.http.parsing.MaybeGrammar;
import io.ktor.http.parsing.NamedGrammar;
import io.ktor.http.parsing.OrGrammar;
import io.ktor.http.parsing.Parser;
import io.ktor.http.parsing.RangeGrammar;
import io.ktor.http.parsing.RawGrammar;
import io.ktor.http.parsing.SimpleGrammar;
import io.ktor.http.parsing.StringGrammar;
import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0000\u001a:\u0010\u000b\u001a\u00020\f*\u00020\n2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"add", "", "", "", "", "", "key", "value", "buildRegexParser", "Lio/ktor/http/parsing/Parser;", "Lio/ktor/http/parsing/Grammar;", "toRegex", "Lio/ktor/http/parsing/regex/GrammarRegex;", "groups", "offset", "shouldGroup", "", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RegexParserGenerator.kt */
public final class RegexParserGeneratorKt {
    public static final Parser buildRegexParser(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Map linkedHashMap = new LinkedHashMap();
        return new RegexParser(new Regex(toRegex$default(grammar, linkedHashMap, 0, false, 6, (Object) null).getRegex()), linkedHashMap);
    }

    static /* synthetic */ GrammarRegex toRegex$default(Grammar grammar, Map map, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return toRegex(grammar, map, i, z);
    }

    private static final GrammarRegex toRegex(Grammar grammar, Map<String, List<Integer>> map, int i, boolean z) {
        char c;
        if (grammar instanceof StringGrammar) {
            return new GrammarRegex(Regex.Companion.escape(((StringGrammar) grammar).getValue()), 0, false, 6, (DefaultConstructorMarker) null);
        }
        if (grammar instanceof RawGrammar) {
            return new GrammarRegex(((RawGrammar) grammar).getValue(), 0, false, 6, (DefaultConstructorMarker) null);
        }
        if (grammar instanceof NamedGrammar) {
            NamedGrammar namedGrammar = (NamedGrammar) grammar;
            GrammarRegex regex$default = toRegex$default(namedGrammar.getGrammar(), map, i + 1, false, 4, (Object) null);
            add(map, namedGrammar.getName(), i);
            return new GrammarRegex(regex$default.getRegex(), regex$default.getGroupsCount(), true);
        } else if (grammar instanceof ComplexGrammar) {
            StringBuilder sb = new StringBuilder();
            int i2 = z ? i + 1 : i;
            int i3 = 0;
            for (Object next : ((ComplexGrammar) grammar).getGrammars()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                GrammarRegex regex = toRegex((Grammar) next, map, i2, true);
                if (i3 != 0 && (grammar instanceof OrGrammar)) {
                    sb.append("|");
                }
                sb.append(regex.getRegex());
                i2 += regex.getGroupsCount();
                i3 = i4;
            }
            int i5 = i2 - i;
            if (z) {
                i5--;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "expression.toString()");
            return new GrammarRegex(sb2, i5, z);
        } else if (grammar instanceof SimpleGrammar) {
            if (grammar instanceof MaybeGrammar) {
                c = '?';
            } else if (grammar instanceof ManyGrammar) {
                c = GMTDateParser.ANY;
            } else if (grammar instanceof AtLeastOne) {
                c = '+';
            } else {
                throw new IllegalStateException(("Unsupported simple grammar element: " + grammar).toString());
            }
            GrammarRegex regex2 = toRegex(((SimpleGrammar) grammar).getGrammar(), map, i, true);
            return new GrammarRegex(regex2.getRegex() + c, regex2.getGroupsCount(), false, 4, (DefaultConstructorMarker) null);
        } else if (grammar instanceof AnyOfGrammar) {
            return new GrammarRegex('[' + Regex.Companion.escape(((AnyOfGrammar) grammar).getValue()) + ']', 0, false, 6, (DefaultConstructorMarker) null);
        } else if (grammar instanceof RangeGrammar) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append('[');
            RangeGrammar rangeGrammar = (RangeGrammar) grammar;
            sb3.append(rangeGrammar.getFrom());
            sb3.append('-');
            sb3.append(rangeGrammar.getTo());
            sb3.append(']');
            return new GrammarRegex(sb3.toString(), 0, false, 6, (DefaultConstructorMarker) null);
        } else {
            throw new IllegalStateException(("Unsupported grammar element: " + grammar).toString());
        }
    }

    private static final void add(Map<String, List<Integer>> map, String str, int i) {
        if (!map.containsKey(str)) {
            map.put(str, new ArrayList());
        }
        Integer valueOf = Integer.valueOf(i);
        List<Integer> list = map.get(str);
        Intrinsics.checkNotNull(list);
        list.add(valueOf);
    }
}
