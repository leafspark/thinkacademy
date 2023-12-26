package io.ktor.util.debug;

import io.ktor.util.debug.plugins.PluginName;
import io.ktor.util.debug.plugins.PluginsTrace;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000.\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a5\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a=\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\f0\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"addToContextInDebugMode", "T", "pluginName", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initContextInDebugMode", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useContextElementInDebugMode", "", "Element", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "action", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContextUtils.kt */
public final class ContextUtilsKt {
    public static final <T> Object initContextInDebugMode(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        if (!IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            return function1.invoke(continuation);
        }
        return BuildersKt.withContext(continuation.getContext().plus(new PluginsTrace((List) null, 1, (DefaultConstructorMarker) null)), new ContextUtilsKt$initContextInDebugMode$2(function1, (Continuation<? super ContextUtilsKt$initContextInDebugMode$2>) null), continuation);
    }

    public static final <T> Object addToContextInDebugMode(String str, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        if (!IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            return function1.invoke(continuation);
        }
        return BuildersKt.withContext(continuation.getContext().plus(new PluginName(str)), new ContextUtilsKt$addToContextInDebugMode$2(function1, (Continuation<? super ContextUtilsKt$addToContextInDebugMode$2>) null), continuation);
    }

    public static final <Element extends CoroutineContext.Element> Object useContextElementInDebugMode(CoroutineContext.Key<Element> key, Function1<? super Element, Unit> function1, Continuation<? super Unit> continuation) {
        Unit unit;
        if (!IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            return Unit.INSTANCE;
        }
        CoroutineContext.Element element = continuation.getContext().get(key);
        if (element != null) {
            function1.invoke(element);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return unit;
        }
        return Unit.INSTANCE;
    }
}
