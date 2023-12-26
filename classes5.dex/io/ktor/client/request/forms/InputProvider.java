package io.ktor.client.request.forms;

import io.ktor.utils.io.core.Input;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lio/ktor/client/request/forms/InputProvider;", "", "size", "", "block", "Lkotlin/Function0;", "Lio/ktor/utils/io/core/Input;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function0;", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: formDsl.kt */
public final class InputProvider {
    private final Function0<Input> block;
    private final Long size;

    public InputProvider(Long l, Function0<? extends Input> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.size = l;
        this.block = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InputProvider(Long l, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, function0);
    }

    public final Function0<Input> getBlock() {
        return this.block;
    }

    public final Long getSize() {
        return this.size;
    }
}
