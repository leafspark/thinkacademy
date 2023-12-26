package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"attachToClientEngineJob", "", "requestJob", "Lkotlinx/coroutines/CompletableJob;", "clientEngineJob", "Lkotlinx/coroutines/Job;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequestLifecycle.kt */
public final class HttpRequestLifecycleKt {
    /* access modifiers changed from: private */
    public static final void attachToClientEngineJob(CompletableJob completableJob, Job job) {
        completableJob.invokeOnCompletion(new HttpRequestLifecycleKt$attachToClientEngineJob$1(job.invokeOnCompletion(new HttpRequestLifecycleKt$attachToClientEngineJob$handler$1(completableJob))));
    }
}
