package io.flutter.embedding.engine.deferredcomponents;

import com.google.android.play.core.tasks.OnSuccessListener;

public final /* synthetic */ class PlayStoreDeferredComponentManager$$ExternalSyntheticLambda1 implements OnSuccessListener {
    public final /* synthetic */ PlayStoreDeferredComponentManager f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ PlayStoreDeferredComponentManager$$ExternalSyntheticLambda1(PlayStoreDeferredComponentManager playStoreDeferredComponentManager, String str, int i) {
        this.f$0 = playStoreDeferredComponentManager;
        this.f$1 = str;
        this.f$2 = i;
    }

    public final void onSuccess(Object obj) {
        this.f$0.lambda$installDeferredComponent$0$PlayStoreDeferredComponentManager(this.f$1, this.f$2, (Integer) obj);
    }
}
