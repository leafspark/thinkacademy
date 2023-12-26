package androidx.camera.view;

import androidx.lifecycle.Observer;

public final /* synthetic */ class ForwardingLiveData$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ ForwardingLiveData f$0;

    public /* synthetic */ ForwardingLiveData$$ExternalSyntheticLambda0(ForwardingLiveData forwardingLiveData) {
        this.f$0 = forwardingLiveData;
    }

    public final void onChanged(Object obj) {
        this.f$0.setValue(obj);
    }
}
