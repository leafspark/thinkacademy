package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.graphics.Color;
import com.tal.app.thinkacademy.live.business.drawing.DrawTools;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "tool", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawTools;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiLiveAgent.kt */
final class GraffitiLiveAgent$openAuth$1 extends Lambda implements Function1<DrawTools, Unit> {
    final /* synthetic */ GraffitiLiveAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiLiveAgent$openAuth$1(GraffitiLiveAgent graffitiLiveAgent) {
        super(1);
        this.this$0 = graffitiLiveAgent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawTools) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawTools drawTools) {
        Intrinsics.checkNotNullParameter(drawTools, "tool");
        WXTGraffitiEngineImpl mGraffitiEngine = this.this$0.getMGraffitiEngine();
        WXTGraffitiEngine.Setting setting = null;
        WXTGraffitiEngine.Setting setting2 = mGraffitiEngine == null ? null : mGraffitiEngine.getSetting();
        if (setting2 != null) {
            setting2.setPenStyle(drawTools.getPenStyle());
        }
        if (drawTools.getPenStyle() == 1) {
            WXTGraffitiEngineImpl mGraffitiEngine2 = this.this$0.getMGraffitiEngine();
            WXTGraffitiEngine.Setting setting3 = mGraffitiEngine2 == null ? null : mGraffitiEngine2.getSetting();
            if (setting3 != null) {
                setting3.setPenWidth(0.05f);
            }
            WXTGraffitiEngineImpl mGraffitiEngine3 = this.this$0.getMGraffitiEngine();
            if (mGraffitiEngine3 != null) {
                setting = mGraffitiEngine3.getSetting();
            }
            if (setting != null) {
                setting.setEraseWidth(0.05f);
                return;
            }
            return;
        }
        WXTGraffitiEngineImpl mGraffitiEngine4 = this.this$0.getMGraffitiEngine();
        WXTGraffitiEngine.Setting setting4 = mGraffitiEngine4 == null ? null : mGraffitiEngine4.getSetting();
        if (setting4 != null) {
            setting4.setPenWidth(0.004f);
        }
        String strokeColor = drawTools.getStrokeColor();
        if (strokeColor != null) {
            WXTGraffitiEngineImpl mGraffitiEngine5 = this.this$0.getMGraffitiEngine();
            if (mGraffitiEngine5 != null) {
                setting = mGraffitiEngine5.getSetting();
            }
            if (setting != null) {
                setting.setStrokeColor(Color.parseColor(strokeColor));
            }
        }
    }
}
