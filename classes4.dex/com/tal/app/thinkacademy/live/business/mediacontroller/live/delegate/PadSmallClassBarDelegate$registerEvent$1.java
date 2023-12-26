package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlSmallLiveViewPad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadSmallClassBarDelegate.kt */
final class PadSmallClassBarDelegate$registerEvent$1 extends Lambda implements Function1<RtcPlayerListenerBody, Unit> {
    final /* synthetic */ PadSmallClassBarDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PadSmallClassBarDelegate$registerEvent$1(PadSmallClassBarDelegate padSmallClassBarDelegate) {
        super(1);
        this.this$0 = padSmallClassBarDelegate;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RtcPlayerListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RtcPlayerListenerBody rtcPlayerListenerBody) {
        Intrinsics.checkNotNullParameter(rtcPlayerListenerBody, "$this$observeListener");
        final PadSmallClassBarDelegate padSmallClassBarDelegate = this.this$0;
        rtcPlayerListenerBody.onLocalVideoChanged(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                MediaControlSmallLiveViewPad access$getMediaViewSmall$p = padSmallClassBarDelegate.mediaViewSmall;
                if (access$getMediaViewSmall$p != null) {
                    access$getMediaViewSmall$p.setCameraState(z);
                }
            }
        });
    }
}
