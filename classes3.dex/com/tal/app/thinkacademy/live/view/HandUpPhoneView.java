package com.tal.app.thinkacademy.live.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/view/HandUpPhoneView;", "Landroid/widget/RelativeLayout;", "cxt", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "countdown", "currentProgress", "isDestroy", "", "isHandUp", "mBarHandUp", "Lcom/tal/app/thinkacademy/live/view/CircularProgressView;", "mHandler", "Landroid/os/Handler;", "mIvHandUp", "Landroid/widget/ImageView;", "maxProgress", "destroy", "", "endHandUp", "startHandUp", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HandUpPhoneView.kt */
public final class HandUpPhoneView extends RelativeLayout {
    /* access modifiers changed from: private */
    public int countdown;
    /* access modifiers changed from: private */
    public int currentProgress;
    private boolean isDestroy;
    private boolean isHandUp;
    /* access modifiers changed from: private */
    public CircularProgressView mBarHandUp;
    private Handler mHandler;
    private ImageView mIvHandUp;
    private final int maxProgress;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HandUpPhoneView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HandUpPhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandUpPhoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "cxt");
        this.maxProgress = 100;
        this.countdown = 100;
        ImageView imageView = new ImageView(getContext());
        this.mIvHandUp = imageView;
        imageView.setImageResource(R.drawable.live_business_icon_handup_phone);
        ImageView imageView2 = this.mIvHandUp;
        if (imageView2 != null) {
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.mIvHandUp, layoutParams);
        CircularProgressView circularProgressView = new CircularProgressView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.mBarHandUp = circularProgressView;
        circularProgressView.initMaxProgress(this.currentProgress, 100);
        CircularProgressView circularProgressView2 = this.mBarHandUp;
        if (circularProgressView2 != null) {
            circularProgressView2.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        addView(this.mBarHandUp, layoutParams2);
        this.mHandler = new HandUpPhoneView$mHandler$1(this, Looper.getMainLooper());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandUpPhoneView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void startHandUp() {
        if (!this.isHandUp) {
            this.isHandUp = true;
            this.currentProgress = 0;
            int i = this.maxProgress;
            this.countdown = i;
            CircularProgressView circularProgressView = this.mBarHandUp;
            if (circularProgressView != null) {
                circularProgressView.initMaxProgress(0, i);
            }
            CircularProgressView circularProgressView2 = this.mBarHandUp;
            if (circularProgressView2 != null) {
                circularProgressView2.setVisibility(0);
            }
            ImageView imageView = this.mIvHandUp;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(1, 0);
            }
        }
    }

    public final void endHandUp() {
        this.isHandUp = false;
        this.currentProgress = 0;
        this.countdown = this.maxProgress;
        CircularProgressView circularProgressView = this.mBarHandUp;
        if (circularProgressView != null) {
            circularProgressView.setVisibility(8);
        }
        ImageView imageView = this.mIvHandUp;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        CircularProgressView circularProgressView2 = this.mBarHandUp;
        if (circularProgressView2 != null) {
            circularProgressView2.initMaxProgress(this.currentProgress, this.maxProgress);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final boolean isHandUp() {
        return this.isHandUp;
    }

    public final void destroy() {
        this.isDestroy = true;
        this.isHandUp = false;
        this.currentProgress = 0;
        this.countdown = this.maxProgress;
        CircularProgressView circularProgressView = this.mBarHandUp;
        if (circularProgressView != null) {
            circularProgressView.setVisibility(8);
        }
        ImageView imageView = this.mIvHandUp;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        CircularProgressView circularProgressView2 = this.mBarHandUp;
        if (circularProgressView2 != null) {
            circularProgressView2.initMaxProgress(this.currentProgress, this.maxProgress);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }
}
