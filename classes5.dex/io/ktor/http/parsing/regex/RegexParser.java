package io.ktor.http.parsing.regex;

import io.ktor.http.parsing.ParseResult;
import io.ktor.http.parsing.Parser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/ktor/http/parsing/regex/RegexParser;", "Lio/ktor/http/parsing/Parser;", "expression", "Lkotlin/text/Regex;", "indexes", "", "", "", "", "(Lkotlin/text/Regex;Ljava/util/Map;)V", "match", "", "input", "parse", "Lio/ktor/http/parsing/ParseResult;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RegexParser.kt */
public final class RegexParser implements Parser {
    private final Regex expression;
    private final Map<String, List<Integer>> indexes;

    public RegexParser(Regex regex, Map<String, ? extends List<Integer>> map) {
        Intrinsics.checkNotNullParameter(regex, "expression");
        Intrinsics.checkNotNullParameter(map, "indexes");
        this.expression = regex;
        this.indexes = map;
    }

    public ParseResult parse(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        MatchResult matchEntire = this.expression.matchEntire(str);
        if (matchEntire == null || matchEntire.getValue().length() != str.length()) {
            return null;
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : this.indexes.entrySet()) {
            String str2 = (String) next.getKey();
            for (Number intValue : (List) next.getValue()) {
                int intValue2 = intValue.intValue();
                List arrayList = new ArrayList();
                MatchGroup matchGroup = matchEntire.getGroups().get(intValue2);
                if (matchGroup != null) {
                    arrayList.add(matchGroup.getValue());
                }
                if (!arrayList.isEmpty()) {
                    linkedHashMap.put(str2, arrayList);
                }
            }
        }
        return new ParseResult(linkedHashMap);
    }

    public boolean match(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        return this.expression.matches(str);
    }
}
