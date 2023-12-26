package io.flutter.embedding.engine;

import android.graphics.ImageDecoder;

public final /* synthetic */ class FlutterJNI$$ExternalSyntheticLambda0 implements ImageDecoder.OnHeaderDecodedListener {
    public final /* synthetic */ long f$0;

    public /* synthetic */ FlutterJNI$$ExternalSyntheticLambda0(long j) {
        this.f$0 = j;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        FlutterJNI.lambda$decodeImage$0(this.f$0, imageDecoder, imageInfo, source);
    }
}
