package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;

public final class CompletableFromCompletionStage<T> extends Completable {
    final CompletionStage<T> stage;

    public CompletableFromCompletionStage(CompletionStage<T> completionStage) {
        this.stage = completionStage;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        FlowableFromCompletionStage.BiConsumerAtomicReference biConsumerAtomicReference = new FlowableFromCompletionStage.BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(completableObserver, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        completableObserver.onSubscribe(completionStageHandler);
        this.stage.whenComplete(biConsumerAtomicReference);
    }

    static final class CompletionStageHandler<T> implements Disposable, BiConsumer<T, Throwable> {
        final CompletableObserver downstream;
        final FlowableFromCompletionStage.BiConsumerAtomicReference<T> whenReference;

        CompletionStageHandler(CompletableObserver completableObserver, FlowableFromCompletionStage.BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            this.downstream = completableObserver;
            this.whenReference = biConsumerAtomicReference;
        }

        public void accept(T t, Throwable th) {
            if (th != null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onComplete();
            }
        }

        public void dispose() {
            this.whenReference.set((Object) null);
        }

        public boolean isDisposed() {
            return this.whenReference.get() == null;
        }
    }
}
