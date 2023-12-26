package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxMessage;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlSmallLiveViewPad;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/mediacontroller/live/delegate/PadSmallClassBarDelegate$requestNewMessage$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxMessage;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadSmallClassBarDelegate.kt */
public final class PadSmallClassBarDelegate$requestNewMessage$1 extends OmyCallback<HiResponse<PhotoBoxMessage>> {
    final /* synthetic */ PadSmallClassBarDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PadSmallClassBarDelegate$requestNewMessage$1(PadSmallClassBarDelegate padSmallClassBarDelegate, PadSmallClassBarDelegate$requestNewMessage$2 padSmallClassBarDelegate$requestNewMessage$2) {
        super(padSmallClassBarDelegate$requestNewMessage$2);
        this.this$0 = padSmallClassBarDelegate;
    }

    public void onSuccess(HiResponse<PhotoBoxMessage> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        PhotoBoxMessage data = hiResponse.getData();
        Intrinsics.checkNotNull(data);
        if (data.isHaveNewMessage() && this.this$0.mediaViewSmall != null) {
            MediaControlSmallLiveViewPad access$getMediaViewSmall$p = this.this$0.mediaViewSmall;
            Intrinsics.checkNotNull(access$getMediaViewSmall$p);
            access$getMediaViewSmall$p.showHomeworkDot();
        }
    }
}
