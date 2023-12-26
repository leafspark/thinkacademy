package com.linkedin.android.litr.frameextract.behaviors;

import com.linkedin.android.litr.frameextract.FrameExtractParameters;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehavior;", "", "extract", "", "params", "Lcom/linkedin/android/litr/frameextract/FrameExtractParameters;", "listener", "Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehaviorFrameListener;", "release", "", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: FrameExtractBehavior.kt */
public interface FrameExtractBehavior {
    boolean extract(FrameExtractParameters frameExtractParameters, FrameExtractBehaviorFrameListener frameExtractBehaviorFrameListener);

    void release();
}
