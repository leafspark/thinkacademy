package com.linkedin.android.litr.frameextract;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoFrameExtractor.kt */
final class VideoFrameExtractor$rootListener$1$runOnListenerHandler$1 implements Runnable {
    final /* synthetic */ Function1 $func;
    final /* synthetic */ FrameExtractListener $listener;

    VideoFrameExtractor$rootListener$1$runOnListenerHandler$1(Function1 function1, FrameExtractListener frameExtractListener) {
        this.$func = function1;
        this.$listener = frameExtractListener;
    }

    public final void run() {
        this.$func.invoke(this.$listener);
    }
}
