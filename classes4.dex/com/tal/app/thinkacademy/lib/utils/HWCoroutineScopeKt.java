package com.tal.app.thinkacademy.lib.utils;

import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ay\u0010\u0000\u001a\u00020\u0001*\u00020\u00022<\b\u0002\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00042'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0004¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"launchWithException", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "ex", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "", "msg", "", "block", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "lib_library_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HWCoroutineScope.kt */
public final class HWCoroutineScopeKt {
    public static /* synthetic */ Job launchWithException$default(CoroutineScope coroutineScope, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        return launchWithException(coroutineScope, function2, function22);
    }

    public static final Job launchWithException(CoroutineScope coroutineScope, Function2<? super Integer, ? super String, Unit> function2, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function22) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(function22, "block");
        return BuildersKt.launch$default(coroutineScope, new HandlerException(new HWCoroutineScopeKt$launchWithException$1(function2)), (CoroutineStart) null, new HWCoroutineScopeKt$launchWithException$2(function22, (Continuation<? super HWCoroutineScopeKt$launchWithException$2>) null), 2, (Object) null);
    }
}
