package com.tal.app.thinkacademy.common.constants;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UrlUtils.kt */
final class UrlUtils$studentHost$2 extends Lambda implements Function0<String> {
    public static final UrlUtils$studentHost$2 INSTANCE = new UrlUtils$studentHost$2();

    UrlUtils$studentHost$2() {
        super(0);
    }

    public final String invoke() {
        return UrlUtils.INSTANCE.getStudentDomain();
    }
}
