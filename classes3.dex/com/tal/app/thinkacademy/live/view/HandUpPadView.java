package com.tal.app.thinkacademy.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\u0018R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/view/HandUpPadView;", "Landroid/widget/RelativeLayout;", "cxt", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentProgress", "currentTime", "", "isDestroy", "", "isHandUp", "mBarHandUp", "Landroid/widget/ProgressBar;", "mHandler", "Landroid/os/Handler;", "mTvHandUpTime", "Landroid/widget/TextView;", "maxProgress", "maxTime", "destroy", "", "endHandUp", "startHandUp", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HandUpPadView.kt */
public final class HandUpPadView extends RelativeLayout {
    /* access modifiers changed from: private */
    public int currentProgress;
    /* access modifiers changed from: private */
    public float currentTime;
    private boolean isDestroy;
    private boolean isHandUp;
    /* access modifiers changed from: private */
    public ProgressBar mBarHandUp;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public TextView mTvHandUpTime;
    private final int maxProgress;
    private final int maxTime;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HandUpPadView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HandUpPadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandUpPadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "cxt");
        this.maxTime = 10;
        this.currentTime = 10.0f;
        int i2 = 10 * 10;
        this.maxProgress = i2;
        setBackgroundResource(R.drawable.bg_live_business_2c_36dp);
        setVisibility(8);
        Drawable drawable = null;
        ProgressBar progressBar = new ProgressBar(getContext(), (AttributeSet) null, 16842872);
        this.mBarHandUp = progressBar;
        Resources resources = getResources();
        progressBar.setProgressDrawable(resources != null ? resources.getDrawable(R.drawable.bg_live_business_handup_pad_progressbar) : drawable);
        ProgressBar progressBar2 = this.mBarHandUp;
        if (progressBar2 != null) {
            progressBar2.setMax(i2);
        }
        ProgressBar progressBar3 = this.mBarHandUp;
        if (progressBar3 != null) {
            progressBar3.setProgress(this.currentProgress);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SizeUtils.dp2px(108.0f), SizeUtils.dp2px(28.0f));
        layoutParams.addRule(13);
        addView(this.mBarHandUp, layoutParams);
        TextView textView = new TextView(getContext());
        this.mTvHandUpTime = textView;
        textView.setTextSize(1, 14.0f);
        TextView textView2 = this.mTvHandUpTime;
        if (textView2 != null) {
            textView2.setTextColor(-1);
        }
        TextView textView3 = this.mTvHandUpTime;
        if (textView3 != null) {
            textView3.setGravity(17);
        }
        TextView textView4 = this.mTvHandUpTime;
        if (textView4 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) ((float) Math.ceil((double) this.currentTime)));
            sb.append('s');
            textView4.setText(sb.toString());
        }
        TextView textView5 = this.mTvHandUpTime;
        if (textView5 != null) {
            textView5.setIncludeFontPadding(false);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        addView(this.mTvHandUpTime, layoutParams2);
        this.mHandler = new HandUpPadView$mHandler$1(this, Looper.getMainLooper());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandUpPadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void startHandUp() {
        if (!this.isHandUp) {
            this.isHandUp = true;
            this.currentTime = 10.0f;
            this.currentProgress = 0;
            TextView textView = this.mTvHandUpTime;
            if (textView != null) {
                StringBuilder sb = new StringBuilder();
                sb.append((int) ((float) Math.ceil((double) this.currentTime)));
                sb.append('s');
                textView.setText(sb.toString());
            }
            ProgressBar progressBar = this.mBarHandUp;
            if (progressBar != null) {
                progressBar.setProgress(this.currentProgress);
            }
            setVisibility(0);
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(1, 0);
            }
        }
    }

    public final void endHandUp() {
        this.isHandUp = false;
        setVisibility(8);
        this.currentTime = 10.0f;
        this.currentProgress = 0;
        TextView textView = this.mTvHandUpTime;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) ((float) Math.ceil((double) this.currentTime)));
            sb.append('s');
            textView.setText(sb.toString());
        }
        ProgressBar progressBar = this.mBarHandUp;
        if (progressBar != null) {
            progressBar.setProgress(this.currentProgress);
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
        setVisibility(8);
        this.currentTime = 10.0f;
        this.currentProgress = 0;
        TextView textView = this.mTvHandUpTime;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) ((float) Math.ceil((double) this.currentTime)));
            sb.append('s');
            textView.setText(sb.toString());
        }
        ProgressBar progressBar = this.mBarHandUp;
        if (progressBar != null) {
            progressBar.setProgress(this.currentProgress);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }
}
