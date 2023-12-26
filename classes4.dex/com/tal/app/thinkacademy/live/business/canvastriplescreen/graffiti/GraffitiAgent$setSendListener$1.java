package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXWBAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiAgent$setSendListener$1", "Lcom/xueersi/lib/graffiti/WXTGraffitiEngine$SenderListener$Adapter;", "generateUniqueId", "", "type", "Lcom/xueersi/lib/graffiti/WXTGraffitiEngine$UniqueIdType;", "getCurrentTimeStampMillis", "onSendActionData", "", "actionData", "Lcom/xueersi/lib/graffiti/WXWBAction;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiAgent.kt */
public final class GraffitiAgent$setSendListener$1 extends WXTGraffitiEngine.SenderListener.Adapter {
    final /* synthetic */ Function1<WXWBAction, Unit> $callback;
    final /* synthetic */ GraffitiAgent this$0;

    GraffitiAgent$setSendListener$1(GraffitiAgent graffitiAgent, Function1<? super WXWBAction, Unit> function1) {
        this.this$0 = graffitiAgent;
        this.$callback = function1;
    }

    public long generateUniqueId(WXTGraffitiEngine.UniqueIdType uniqueIdType) {
        Intrinsics.checkNotNullParameter(uniqueIdType, "type");
        if (uniqueIdType != WXTGraffitiEngine.UniqueIdType.MSG_ID) {
            return GraffitiAgent$setSendListener$1.super.generateUniqueId(uniqueIdType);
        }
        GraffitiAgent graffitiAgent = this.this$0;
        graffitiAgent.setMLastSendMsgId(graffitiAgent.getMLastSendMsgId() + 1);
        return graffitiAgent.getMLastSendMsgId();
    }

    public long getCurrentTimeStampMillis() {
        RoomData roomData;
        DataStorage dataStorage = this.this$0.getMLiveRoomProvider().getDataStorage();
        Long l = null;
        if (!(dataStorage == null || (roomData = dataStorage.getRoomData()) == null)) {
            l = Long.valueOf(roomData.getServeNowMillsTime());
        }
        return l == null ? System.currentTimeMillis() : l.longValue();
    }

    public void onSendActionData(WXWBAction wXWBAction) {
        Intrinsics.checkNotNullParameter(wXWBAction, "actionData");
        GraffitiAgent$setSendListener$1.super.onSendActionData(wXWBAction);
        this.$callback.invoke(wXWBAction);
    }
}
