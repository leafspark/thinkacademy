package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiAgent$initGraffiti$1$onLoadImage$1", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiAgent.kt */
public final class GraffitiAgent$initGraffiti$1$onLoadImage$1 extends SimpleTarget<Drawable> {
    final /* synthetic */ WXTGraffitiEngine.ImageLoader.ResultHandler $resultHandler;

    GraffitiAgent$initGraffiti$1$onLoadImage$1(WXTGraffitiEngine.ImageLoader.ResultHandler resultHandler) {
        this.$resultHandler = resultHandler;
    }

    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        WXTGraffitiEngine.ImageLoader.ResultHandler resultHandler = this.$resultHandler;
        if (resultHandler != null) {
            resultHandler.ready(drawable);
        }
    }
}
