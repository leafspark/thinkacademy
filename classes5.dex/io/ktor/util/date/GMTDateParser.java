package io.ktor.util.date;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003J\u001c\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/ktor/util/date/GMTDateParser;", "", "pattern", "", "(Ljava/lang/String;)V", "parse", "Lio/ktor/util/date/GMTDate;", "dateString", "handleToken", "", "Lio/ktor/util/date/GMTDateBuilder;", "type", "", "chunk", "Companion", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GMTDateParser.kt */
public final class GMTDateParser {
    public static final char ANY = '*';
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final char DAY_OF_MONTH = 'd';
    public static final char HOURS = 'h';
    public static final char MINUTES = 'm';
    public static final char MONTH = 'M';
    public static final char SECONDS = 's';
    public static final char YEAR = 'Y';
    public static final char ZONE = 'z';
    private final String pattern;

    public GMTDateParser(String str) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        this.pattern = str;
        if (!(str.length() > 0)) {
            throw new IllegalStateException("Date parser pattern shouldn't be empty.".toString());
        }
    }

    public final GMTDate parse(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        GMTDateBuilder gMTDateBuilder = new GMTDateBuilder();
        char charAt = this.pattern.charAt(0);
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i2 < this.pattern.length()) {
            try {
                if (this.pattern.charAt(i2) == charAt) {
                    i2++;
                } else {
                    int i4 = (i3 + i2) - i;
                    String substring = str.substring(i3, i4);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    handleToken(gMTDateBuilder, charAt, substring);
                    try {
                        charAt = this.pattern.charAt(i2);
                        int i5 = i4;
                        i = i2;
                        i2++;
                        i3 = i5;
                    } catch (Throwable unused) {
                        i3 = i4;
                        throw new InvalidDateStringException(str, i3, this.pattern);
                    }
                }
            } catch (Throwable unused2) {
                throw new InvalidDateStringException(str, i3, this.pattern);
            }
        }
        if (i3 < str.length()) {
            String substring2 = str.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            handleToken(gMTDateBuilder, charAt, substring2);
        }
        return gMTDateBuilder.build();
    }

    private final void handleToken(GMTDateBuilder gMTDateBuilder, char c, String str) {
        if (c == 's') {
            gMTDateBuilder.setSeconds(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'm') {
            gMTDateBuilder.setMinutes(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'h') {
            gMTDateBuilder.setHours(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'd') {
            gMTDateBuilder.setDayOfMonth(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'M') {
            gMTDateBuilder.setMonth(Month.Companion.from(str));
        } else if (c == 'Y') {
            gMTDateBuilder.setYear(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'z') {
            if (!Intrinsics.areEqual(str, "GMT")) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } else if (c != '*') {
            CharSequence charSequence = str;
            boolean z = false;
            int i = 0;
            while (true) {
                boolean z2 = true;
                if (i >= charSequence.length()) {
                    z = true;
                    break;
                }
                if (charSequence.charAt(i) != c) {
                    z2 = false;
                }
                if (!z2) {
                    break;
                }
                i++;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/ktor/util/date/GMTDateParser$Companion;", "", "()V", "ANY", "", "DAY_OF_MONTH", "HOURS", "MINUTES", "MONTH", "SECONDS", "YEAR", "ZONE", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GMTDateParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
