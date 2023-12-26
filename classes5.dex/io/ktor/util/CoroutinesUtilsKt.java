package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"SilentSupervisor", "Lkotlin/coroutines/CoroutineContext;", "parent", "Lkotlinx/coroutines/Job;", "printDebugTree", "", "offset", "", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoroutinesUtils.kt */
public final class CoroutinesUtilsKt {
    public static /* synthetic */ void printDebugTree$default(Job job, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        printDebugTree(job, i);
    }

    public static final void printDebugTree(Job job, int i) {
        Intrinsics.checkNotNullParameter(job, "<this>");
        System.out.println(StringsKt.repeat(" ", i) + job);
        for (Job printDebugTree : job.getChildren()) {
            printDebugTree(printDebugTree, i + 2);
        }
        if (i == 0) {
            System.out.println();
        }
    }

    public static /* synthetic */ CoroutineContext SilentSupervisor$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return SilentSupervisor(job);
    }

    public static final CoroutineContext SilentSupervisor(Job job) {
        return SupervisorKt.SupervisorJob(job).plus((CoroutineExceptionHandler) new CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key));
    }
}
