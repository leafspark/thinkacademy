package io.ktor.http.parsing.regex;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/parsing/regex/GrammarRegex;", "", "regexRaw", "", "groupsCountRaw", "", "group", "", "(Ljava/lang/String;IZ)V", "groupsCount", "getGroupsCount", "()I", "regex", "getRegex", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RegexParserGenerator.kt */
final class GrammarRegex {
    private final int groupsCount;
    private final String regex;

    public GrammarRegex(String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "regexRaw");
        if (z) {
            str = '(' + str + ')';
        }
        this.regex = str;
        this.groupsCount = z ? i + 1 : i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GrammarRegex(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z);
    }

    public final String getRegex() {
        return this.regex;
    }

    public final int getGroupsCount() {
        return this.groupsCount;
    }
}
