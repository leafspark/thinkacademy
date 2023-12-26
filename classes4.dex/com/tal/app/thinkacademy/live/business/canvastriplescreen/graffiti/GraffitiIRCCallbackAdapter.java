package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import com.tal.app.thinkacademy.live.core.callback.BinaryMessageCallback;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiIRCCallbackAdapter;", "Lcom/tal/app/thinkacademy/live/core/callback/BinaryMessageCallback;", "onBinaryMessage", "", "binaryMessage", "Lcom/tal/app/thinkacademy/live/core/irc/entity/BinaryMessage;", "binaryMessageInfo", "Lcom/tal/app/thinkacademy/live/core/irc/entity/BinaryMessageInfo;", "onSendRoomBinaryMessageFailed", "errorCode", "", "errorMsg", "", "preMsgId", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiAgent.kt */
public interface GraffitiIRCCallbackAdapter extends BinaryMessageCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GraffitiAgent.kt */
    public static final class DefaultImpls {
        public static void onBinaryMessage(GraffitiIRCCallbackAdapter graffitiIRCCallbackAdapter, BinaryMessage binaryMessage) {
            Intrinsics.checkNotNullParameter(graffitiIRCCallbackAdapter, "this");
        }

        public static void onBinaryMessage(GraffitiIRCCallbackAdapter graffitiIRCCallbackAdapter, BinaryMessageInfo binaryMessageInfo) {
            Intrinsics.checkNotNullParameter(graffitiIRCCallbackAdapter, "this");
        }

        public static void onSendRoomBinaryMessageFailed(GraffitiIRCCallbackAdapter graffitiIRCCallbackAdapter, int i, String str, long j) {
            Intrinsics.checkNotNullParameter(graffitiIRCCallbackAdapter, "this");
        }
    }

    void onBinaryMessage(BinaryMessage binaryMessage);

    void onBinaryMessage(BinaryMessageInfo binaryMessageInfo);

    void onSendRoomBinaryMessageFailed(int i, String str, long j);
}
