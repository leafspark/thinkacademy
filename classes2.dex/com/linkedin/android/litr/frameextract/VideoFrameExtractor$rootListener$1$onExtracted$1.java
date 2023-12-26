package com.linkedin.android.litr.frameextract;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/linkedin/android/litr/frameextract/FrameExtractListener;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoFrameExtractor.kt */
final class VideoFrameExtractor$rootListener$1$onExtracted$1 extends Lambda implements Function1<FrameExtractListener, Unit> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ String $id;
    final /* synthetic */ long $timestampUs;
    final /* synthetic */ VideoFrameExtractor$rootListener$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoFrameExtractor$rootListener$1$onExtracted$1(VideoFrameExtractor$rootListener$1 videoFrameExtractor$rootListener$1, String str, long j, Bitmap bitmap) {
        super(1);
        this.this$0 = videoFrameExtractor$rootListener$1;
        this.$id = str;
        this.$timestampUs = j;
        this.$bitmap = bitmap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FrameExtractListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FrameExtractListener frameExtractListener) {
        Intrinsics.checkNotNullParameter(frameExtractListener, "it");
        this.this$0.this$0.onCompleteJob(this.$id);
        frameExtractListener.onExtracted(this.$id, this.$timestampUs, this.$bitmap);
    }
}
