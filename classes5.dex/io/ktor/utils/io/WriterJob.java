package io.ktor.utils.io;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/WriterJob;", "Lkotlinx/coroutines/Job;", "channel", "Lio/ktor/utils/io/ByteReadChannel;", "getChannel", "()Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Coroutines.kt */
public interface WriterJob extends Job {
    ByteReadChannel getChannel();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Coroutines.kt */
    public static final class DefaultImpls {
        public static <R> R fold(WriterJob writerJob, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Job.DefaultImpls.fold(writerJob, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(WriterJob writerJob, CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return Job.DefaultImpls.get(writerJob, key);
        }

        public static CoroutineContext minusKey(WriterJob writerJob, CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return Job.DefaultImpls.minusKey(writerJob, key);
        }

        public static CoroutineContext plus(WriterJob writerJob, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(coroutineContext, "context");
            return Job.DefaultImpls.plus((Job) writerJob, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(WriterJob writerJob, Job job) {
            Intrinsics.checkNotNullParameter(job, "other");
            return Job.DefaultImpls.plus((Job) writerJob, job);
        }
    }
}
