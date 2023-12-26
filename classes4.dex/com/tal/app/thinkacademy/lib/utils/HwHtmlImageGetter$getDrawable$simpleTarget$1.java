package com.tal.app.thinkacademy.lib.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LevelListDrawable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/lib/utils/HwHtmlImageGetter$getDrawable$simpleTarget$1", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Landroid/graphics/Bitmap;", "onResourceReady", "", "resourceBitmap", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwHtmlImageGetter.kt */
public final class HwHtmlImageGetter$getDrawable$simpleTarget$1 extends SimpleTarget<Bitmap> {
    final /* synthetic */ LevelListDrawable $drawable;
    final /* synthetic */ HwHtmlImageGetter this$0;

    HwHtmlImageGetter$getDrawable$simpleTarget$1(HwHtmlImageGetter hwHtmlImageGetter, LevelListDrawable levelListDrawable) {
        this.this$0 = hwHtmlImageGetter;
        this.$drawable = levelListDrawable;
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        Intrinsics.checkNotNullParameter(bitmap, "resourceBitmap");
        try {
            HwHtmlImageGetter hwHtmlImageGetter = this.this$0;
            Bitmap access$scaleBitmapToFitWidth = hwHtmlImageGetter.scaleBitmapToFitWidth(bitmap, hwHtmlImageGetter.mBaseWidth);
            if (access$scaleBitmapToFitWidth != null) {
                this.$drawable.addLevel(1, 1, new BitmapDrawable(this.this$0.mContext.getResources(), access$scaleBitmapToFitWidth));
                this.$drawable.setBounds(0, 0, access$scaleBitmapToFitWidth.getWidth(), access$scaleBitmapToFitWidth.getHeight());
                this.$drawable.setLevel(1);
                this.this$0.mTextView.invalidate();
                this.this$0.mTextView.setText(this.this$0.mTextView.getText());
            }
        } catch (Exception unused) {
        }
    }
}
