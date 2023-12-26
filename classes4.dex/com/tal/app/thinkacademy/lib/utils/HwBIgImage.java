package com.tal.app.thinkacademy.lib.utils;

import android.content.Context;
import android.util.AttributeSet;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/HwBIgImage;", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mIsLoadSuccess", "", "getMIsLoadSuccess", "()Z", "setMIsLoadSuccess", "(Z)V", "mUrlCheckTag", "", "getMUrlCheckTag", "()Ljava/lang/String;", "setMUrlCheckTag", "(Ljava/lang/String;)V", "onAttachedToWindow", "", "onDetachedFromWindow", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwBIgImage.kt */
public final class HwBIgImage extends SubsamplingScaleImageView {
    private boolean mIsLoadSuccess;
    private String mUrlCheckTag;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HwBIgImage(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HwBIgImage(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HwBIgImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final String getMUrlCheckTag() {
        return this.mUrlCheckTag;
    }

    public final void setMUrlCheckTag(String str) {
        this.mUrlCheckTag = str;
    }

    public final boolean getMIsLoadSuccess() {
        return this.mIsLoadSuccess;
    }

    public final void setMIsLoadSuccess(boolean z) {
        this.mIsLoadSuccess = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        HwBIgImage.super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        HwBIgImage.super.onDetachedFromWindow();
    }
}
