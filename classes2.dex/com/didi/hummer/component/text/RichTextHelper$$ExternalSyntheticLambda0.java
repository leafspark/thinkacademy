package com.didi.hummer.component.text;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.didi.hummer.adapter.imageloader.DrawableCallback;
import com.didi.hummer.component.text.RichTextHelper;

public final /* synthetic */ class RichTextHelper$$ExternalSyntheticLambda0 implements DrawableCallback {
    public final /* synthetic */ SpannableString f$0;
    public final /* synthetic */ RichTextHelper.RichText f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ OnRichTextGenerateListener f$4;

    public /* synthetic */ RichTextHelper$$ExternalSyntheticLambda0(SpannableString spannableString, RichTextHelper.RichText richText, int i, int i2, OnRichTextGenerateListener onRichTextGenerateListener) {
        this.f$0 = spannableString;
        this.f$1 = richText;
        this.f$2 = i;
        this.f$3 = i2;
        this.f$4 = onRichTextGenerateListener;
    }

    public final void onDrawableLoaded(Drawable drawable) {
        RichTextHelper.lambda$processImageSpannableString$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, drawable);
    }
}
