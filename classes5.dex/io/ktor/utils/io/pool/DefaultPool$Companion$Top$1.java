package io.ktor.utils.io.pool;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultPool.kt */
/* synthetic */ class DefaultPool$Companion$Top$1 extends MutablePropertyReference1Impl {
    public static final DefaultPool$Companion$Top$1 INSTANCE = new DefaultPool$Companion$Top$1();

    DefaultPool$Companion$Top$1() {
        super(DefaultPool.class, "top", "getTop()J", 0);
    }

    public Object get(Object obj) {
        return Long.valueOf(((DefaultPool) obj).top);
    }

    public void set(Object obj, Object obj2) {
        ((DefaultPool) obj).top = ((Number) obj2).longValue();
    }
}
