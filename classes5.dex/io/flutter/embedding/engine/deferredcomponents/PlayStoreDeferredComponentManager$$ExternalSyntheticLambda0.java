package io.flutter.embedding.engine.deferredcomponents;

import com.google.android.play.core.tasks.OnFailureListener;

public final /* synthetic */ class PlayStoreDeferredComponentManager$$ExternalSyntheticLambda0 implements OnFailureListener {
    public final /* synthetic */ PlayStoreDeferredComponentManager f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ PlayStoreDeferredComponentManager$$ExternalSyntheticLambda0(PlayStoreDeferredComponentManager playStoreDeferredComponentManager, int i, String str) {
        this.f$0 = playStoreDeferredComponentManager;
        this.f$1 = i;
        this.f$2 = str;
    }

    public final void onFailure(Exception exc) {
        this.f$0.lambda$installDeferredComponent$1$PlayStoreDeferredComponentManager(this.f$1, this.f$2, exc);
    }
}
