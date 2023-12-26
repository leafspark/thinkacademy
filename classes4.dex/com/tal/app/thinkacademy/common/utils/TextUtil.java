package com.tal.app.thinkacademy.common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/TextUtil;", "", "()V", "addBlankInText", "", "text", "index", "", "replaceOldValues", "oldValue", "newValue", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextUtil.kt */
public final class TextUtil {
    public static final TextUtil INSTANCE = new TextUtil();

    private TextUtil() {
    }

    public static /* synthetic */ String addBlankInText$default(TextUtil textUtil, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        return textUtil.addBlankInText(str, i);
    }

    public final String addBlankInText(String str, int i) {
        String str2 = "(.{" + i + "})";
        Intrinsics.checkNotNull(str);
        return new Regex(str2).replace(str, "$1 ");
    }

    public final String replaceOldValues(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "oldValue");
        Intrinsics.checkNotNullParameter(str3, "newValue");
        Intrinsics.checkNotNull(str);
        return new Regex(str2).replace(str, str3);
    }
}
