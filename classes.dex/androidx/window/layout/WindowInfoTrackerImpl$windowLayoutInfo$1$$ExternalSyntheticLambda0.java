package androidx.window.layout;

import androidx.core.util.Consumer;
import kotlinx.coroutines.channels.Channel;

public final /* synthetic */ class WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Channel f$0;

    public /* synthetic */ WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0(Channel channel) {
        this.f$0 = channel;
    }

    public final void accept(Object obj) {
        WindowInfoTrackerImpl$windowLayoutInfo$1.m12invokeSuspend$lambda0(this.f$0, (WindowLayoutInfo) obj);
    }
}
