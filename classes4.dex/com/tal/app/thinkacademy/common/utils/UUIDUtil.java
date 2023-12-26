package com.tal.app.thinkacademy.common.utils;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/UUIDUtil;", "", "()V", "getUUID", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UUIDUtil.kt */
public final class UUIDUtil {
    public static final UUIDUtil INSTANCE = new UUIDUtil();

    private UUIDUtil() {
    }

    public final String getUUID() {
        UUID randomUUID = UUID.randomUUID();
        if (randomUUID == null) {
            return "";
        }
        String uuid = randomUUID.toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "it.toString()");
        return uuid;
    }
}
