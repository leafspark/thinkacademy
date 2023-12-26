package com.tal.app.thinkacademy.business.login.widget;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/PatternUtil;", "", "()V", "KEmailRegular", "", "emailIsCompliance", "", "email", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PatternUtil.kt */
public final class PatternUtil {
    public static final PatternUtil INSTANCE = new PatternUtil();
    private static final String KEmailRegular = "^([A-Za-z0-9_\\-.])+@([A-Za-z0-9_\\-.])+.([A-Za-z]{2,8})$";

    private PatternUtil() {
    }

    public static /* synthetic */ boolean emailIsCompliance$default(PatternUtil patternUtil, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return patternUtil.emailIsCompliance(str);
    }

    public final boolean emailIsCompliance(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return false;
        }
        return Pattern.matches(KEmailRegular, charSequence);
    }
}
