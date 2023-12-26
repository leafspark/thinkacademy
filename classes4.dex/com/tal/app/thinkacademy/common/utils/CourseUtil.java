package com.tal.app.thinkacademy.common.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/CourseUtil;", "", "()V", "checkIsGameCourse", "", "jsString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CourseUtil.kt */
public final class CourseUtil {
    public static final CourseUtil INSTANCE = new CourseUtil();

    private CourseUtil() {
    }

    @JvmStatic
    public static final boolean checkIsGameCourse(String str) {
        if (str == null) {
            return false;
        }
        return StringsKt.contains$default(str, "sliceId", false, 2, (Object) null);
    }
}
