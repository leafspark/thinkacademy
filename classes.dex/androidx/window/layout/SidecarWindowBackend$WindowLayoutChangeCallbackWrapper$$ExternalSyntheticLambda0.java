package androidx.window.layout;

import androidx.window.layout.SidecarWindowBackend;

public final /* synthetic */ class SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SidecarWindowBackend.WindowLayoutChangeCallbackWrapper f$0;
    public final /* synthetic */ WindowLayoutInfo f$1;

    public /* synthetic */ SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
        this.f$0 = windowLayoutChangeCallbackWrapper;
        this.f$1 = windowLayoutInfo;
    }

    public final void run() {
        SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m11accept$lambda0(this.f$0, this.f$1);
    }
}
