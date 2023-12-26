package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.core.CompletableSource;

public interface HasUpstreamCompletableSource {
    CompletableSource source();
}
