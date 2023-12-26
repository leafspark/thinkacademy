package androidx.camera.core;

import android.net.Uri;

public final /* synthetic */ class ImageSaver$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ImageSaver f$0;
    public final /* synthetic */ Uri f$1;

    public /* synthetic */ ImageSaver$$ExternalSyntheticLambda0(ImageSaver imageSaver, Uri uri) {
        this.f$0 = imageSaver;
        this.f$1 = uri;
    }

    public final void run() {
        this.f$0.lambda$postSuccess$1$ImageSaver(this.f$1);
    }
}
