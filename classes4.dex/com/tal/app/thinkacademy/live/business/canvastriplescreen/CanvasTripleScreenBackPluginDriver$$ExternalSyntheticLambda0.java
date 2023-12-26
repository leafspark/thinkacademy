package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;

public final /* synthetic */ class CanvasTripleScreenBackPluginDriver$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ CanvasTripleScreenBackPluginDriver f$0;
    public final /* synthetic */ RoomData f$1;

    public /* synthetic */ CanvasTripleScreenBackPluginDriver$$ExternalSyntheticLambda0(CanvasTripleScreenBackPluginDriver canvasTripleScreenBackPluginDriver, RoomData roomData) {
        this.f$0 = canvasTripleScreenBackPluginDriver;
        this.f$1 = roomData;
    }

    public final void onChanged(Object obj) {
        this.f$0.lambda$initTripleScreenLayout$0$CanvasTripleScreenBackPluginDriver(this.f$1, (LiveAreaContext) obj);
    }
}
