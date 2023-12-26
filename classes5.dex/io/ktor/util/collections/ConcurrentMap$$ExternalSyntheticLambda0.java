package io.ktor.util.collections;

import java.util.function.Function;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class ConcurrentMap$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ ConcurrentMap$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    public final Object apply(Object obj) {
        return ConcurrentMap.m17computeIfAbsent$lambda0(this.f$0, obj);
    }
}
