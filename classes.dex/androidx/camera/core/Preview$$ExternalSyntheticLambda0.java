package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;

public final /* synthetic */ class Preview$$ExternalSyntheticLambda0 implements SessionConfig.ErrorListener {
    public final /* synthetic */ Preview f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ PreviewConfig f$2;
    public final /* synthetic */ Size f$3;

    public /* synthetic */ Preview$$ExternalSyntheticLambda0(Preview preview, String str, PreviewConfig previewConfig, Size size) {
        this.f$0 = preview;
        this.f$1 = str;
        this.f$2 = previewConfig;
        this.f$3 = size;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.lambda$createPipeline$0$Preview(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
