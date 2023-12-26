package io.ktor.http.content;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0002\u001a/\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a/\u0010\u000e\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH@ø\u0001\u0000¢\u0006\u0002\u0010\r\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"isParkingAllowedFunction", "Ljava/lang/reflect/Method;", "()Ljava/lang/reflect/Method;", "isParkingAllowedFunction$delegate", "Lkotlin/Lazy;", "safeToRunInPlace", "", "withBlocking", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withBlockingAndRedispatch", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BlockingBridge.kt */
public final class BlockingBridgeKt {
    private static final Lazy isParkingAllowedFunction$delegate = LazyKt.lazy(BlockingBridgeKt$isParkingAllowedFunction$2.INSTANCE);

    private static final Method isParkingAllowedFunction() {
        return (Method) isParkingAllowedFunction$delegate.getValue();
    }

    public static final Object withBlocking(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        if (safeToRunInPlace()) {
            Object invoke = function1.invoke(continuation);
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        Object withBlockingAndRedispatch = withBlockingAndRedispatch(function1, continuation);
        return withBlockingAndRedispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withBlockingAndRedispatch : Unit.INSTANCE;
    }

    private static final boolean safeToRunInPlace() {
        boolean z;
        Method isParkingAllowedFunction = isParkingAllowedFunction();
        if (isParkingAllowedFunction != null) {
            try {
                z = Intrinsics.areEqual(isParkingAllowedFunction.invoke((Object) null, new Object[0]), true);
            } catch (Throwable unused) {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final Object withBlockingAndRedispatch(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new BlockingBridgeKt$withBlockingAndRedispatch$2(function1, (Continuation<? super BlockingBridgeKt$withBlockingAndRedispatch$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
