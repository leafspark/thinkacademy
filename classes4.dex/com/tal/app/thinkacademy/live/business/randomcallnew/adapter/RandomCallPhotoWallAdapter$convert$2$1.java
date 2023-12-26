package com.tal.app.thinkacademy.live.business.randomcallnew.adapter;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/live/business/randomcallnew/adapter/RandomCallPhotoWallAdapter$convert$2$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallPhotoWallAdapter.kt */
public final class RandomCallPhotoWallAdapter$convert$2$1 extends ViewOutlineProvider {
    final /* synthetic */ RandomCallPhotoWallAdapter this$0;

    RandomCallPhotoWallAdapter$convert$2$1(RandomCallPhotoWallAdapter randomCallPhotoWallAdapter) {
        this.this$0 = randomCallPhotoWallAdapter;
    }

    public void getOutline(View view, Outline outline) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        int width = view.getWidth();
        int height = view.getHeight();
        if (PadUtils.isPad(this.this$0.getContext())) {
            i = this.this$0.getContext().getResources().getDimensionPixelOffset(R.dimen.size_4dp);
        } else {
            i = this.this$0.getContext().getResources().getDimensionPixelOffset(R.dimen.size_6dp);
        }
        outline.setRoundRect(0, 0, width, height, (float) i);
    }
}
