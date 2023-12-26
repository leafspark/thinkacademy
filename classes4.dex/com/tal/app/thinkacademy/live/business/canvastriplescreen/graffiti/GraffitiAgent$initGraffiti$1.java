package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import com.bumptech.glide.Glide;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiAgent$initGraffiti$1", "Lcom/xueersi/lib/graffiti/WXTGraffitiEngine$ImageLoader$Adapter;", "onLoadImage", "", "refId", "", "resultHandler", "Lcom/xueersi/lib/graffiti/WXTGraffitiEngine$ImageLoader$ResultHandler;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiAgent.kt */
public final class GraffitiAgent$initGraffiti$1 extends WXTGraffitiEngine.ImageLoader.Adapter {
    final /* synthetic */ GraffitiAgent this$0;

    GraffitiAgent$initGraffiti$1(GraffitiAgent graffitiAgent) {
        this.this$0 = graffitiAgent;
    }

    public void onLoadImage(String str, WXTGraffitiEngine.ImageLoader.ResultHandler resultHandler) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            Glide.with(this.this$0.getMContext()).asDrawable().load(str).into(new GraffitiAgent$initGraffiti$1$onLoadImage$1(resultHandler));
        }
    }
}
