package io.ktor.http;

import io.ktor.http.parsing.Grammar;
import io.ktor.http.parsing.Parser;
import io.ktor.http.parsing.ParserDslKt;
import io.ktor.http.parsing.PrimitivesKt;
import io.ktor.http.parsing.regex.RegexParserGeneratorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"IP_PARSER", "Lio/ktor/http/parsing/Parser;", "IPv4address", "Lio/ktor/http/parsing/Grammar;", "IPv6address", "hostIsIp", "", "host", "", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: IpParser.kt */
public final class IpParserKt {
    private static final Parser IP_PARSER;
    private static final Grammar IPv4address;
    private static final Grammar IPv6address;

    public static final boolean hostIsIp(String str) {
        Intrinsics.checkNotNullParameter(str, "host");
        return IP_PARSER.match(str);
    }

    static {
        Grammar then = ParserDslKt.then(ParserDslKt.then(ParserDslKt.then(ParserDslKt.then(ParserDslKt.then(ParserDslKt.then(PrimitivesKt.getDigits(), "."), PrimitivesKt.getDigits()), "."), PrimitivesKt.getDigits()), "."), PrimitivesKt.getDigits());
        IPv4address = then;
        Grammar then2 = ParserDslKt.then(ParserDslKt.then("[", ParserDslKt.atLeastOne(ParserDslKt.or(PrimitivesKt.getHex(), ":"))), "]");
        IPv6address = then2;
        IP_PARSER = RegexParserGeneratorKt.buildRegexParser(ParserDslKt.or(then, then2));
    }
}
