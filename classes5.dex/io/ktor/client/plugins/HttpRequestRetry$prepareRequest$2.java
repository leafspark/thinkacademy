package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableJob;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequestRetry.kt */
final class HttpRequestRetry$prepareRequest$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableJob $subRequestJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpRequestRetry$prepareRequest$2(CompletableJob completableJob) {
        super(1);
        this.$subRequestJob = completableJob;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        if (th == null) {
            this.$subRequestJob.complete();
        } else {
            this.$subRequestJob.completeExceptionally(th);
        }
    }
}
