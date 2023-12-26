package com.adyen.checkout.card;

import com.adyen.checkout.components.ui.FieldState;
import com.adyen.checkout.components.ui.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/adyen/checkout/card/SocialSecurityNumberUtils;", "", "()V", "CNPJ_DIGIT_LIMIT", "", "CNPJ_MASK_GROUPING", "", "CNPJ_MASK_SEPARATORS", "", "getCNPJ_MASK_SEPARATORS", "()Ljava/util/List;", "CNPJ_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "CNPJ_REGEX", "", "CPF_DIGIT_LIMIT", "CPF_MASK_GROUPING", "CPF_MASK_SEPARATORS", "CPF_PATTERN", "CPF_REGEX", "formatInput", "inputString", "validateSocialSecurityNumber", "Lcom/adyen/checkout/components/ui/FieldState;", "socialSecurityNumber", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SocialSecurityNumberUtils.kt */
public final class SocialSecurityNumberUtils {
    public static final int CNPJ_DIGIT_LIMIT = 14;
    private static final List<Integer> CNPJ_MASK_GROUPING = CollectionsKt.listOf(new Integer[]{2, 3, 3, 4, 2});
    private static final List<Character> CNPJ_MASK_SEPARATORS = CollectionsKt.listOf(new Character[]{'.', '.', '/', '-'});
    private static final Pattern CNPJ_PATTERN = Pattern.compile(CNPJ_REGEX);
    private static final String CNPJ_REGEX = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}";
    private static final int CPF_DIGIT_LIMIT = 11;
    private static final List<Integer> CPF_MASK_GROUPING = CollectionsKt.listOf(new Integer[]{3, 3, 3, 2});
    private static final List<Character> CPF_MASK_SEPARATORS = CollectionsKt.listOf(new Character[]{'.', '.', '-'});
    private static final Pattern CPF_PATTERN = Pattern.compile(CPF_REGEX);
    private static final String CPF_REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
    public static final SocialSecurityNumberUtils INSTANCE = new SocialSecurityNumberUtils();

    private SocialSecurityNumberUtils() {
    }

    public final List<Character> getCNPJ_MASK_SEPARATORS() {
        return CNPJ_MASK_SEPARATORS;
    }

    public final FieldState<String> validateSocialSecurityNumber(String str) {
        Validation validation;
        Intrinsics.checkNotNullParameter(str, "socialSecurityNumber");
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        int length2 = sb2.length();
        if (length2 == 11 && CPF_PATTERN.matcher(charSequence).matches()) {
            validation = Validation.Valid.INSTANCE;
        } else if (length2 != 14 || !CNPJ_PATTERN.matcher(charSequence).matches()) {
            validation = new Validation.Invalid(R.string.checkout_social_security_number_not_valid);
        } else {
            validation = Validation.Valid.INSTANCE;
        }
        Appendable sb3 = new StringBuilder();
        int length3 = charSequence.length();
        for (int i2 = 0; i2 < length3; i2++) {
            char charAt2 = charSequence.charAt(i2);
            if (Character.isDigit(charAt2)) {
                sb3.append(charAt2);
            }
        }
        String sb4 = ((StringBuilder) sb3).toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "filterTo(StringBuilder(), predicate).toString()");
        return new FieldState<>(sb4, validation);
    }

    public final String formatInput(String str) {
        Pair pair;
        Intrinsics.checkNotNullParameter(str, "inputString");
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        List arrayList = new ArrayList();
        StringBuilder sb3 = new StringBuilder();
        if (sb2.length() <= 11) {
            pair = TuplesKt.to(CPF_MASK_GROUPING, CPF_MASK_SEPARATORS);
        } else {
            pair = TuplesKt.to(CNPJ_MASK_GROUPING, CNPJ_MASK_SEPARATORS);
        }
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        int size = list.size() - 1;
        if (size >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (sb2.length() < ((Number) list.get(i3)).intValue()) {
                    if (sb2.length() > 0) {
                        arrayList.add(sb2);
                        break;
                    }
                } else {
                    arrayList.add(StringsKt.take(sb2, ((Number) list.get(i3)).intValue()));
                    int intValue = ((Number) list.get(i3)).intValue();
                    Objects.requireNonNull(sb2, "null cannot be cast to non-null type java.lang.String");
                    sb2 = sb2.substring(intValue);
                    Intrinsics.checkNotNullExpressionValue(sb2, "(this as java.lang.String).substring(startIndex)");
                }
                if (i4 > size) {
                    break;
                }
                i3 = i4;
            }
        }
        for (Object next : arrayList) {
            int i5 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb3.append((String) next);
            if (i != CollectionsKt.getLastIndex(arrayList)) {
                sb3.append(((Character) list2.get(i)).charValue());
            }
            i = i5;
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "resultBuilder.toString()");
        return sb4;
    }
}
