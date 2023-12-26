package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/LikeManager;", "", "()V", "mAnimator", "Landroid/animation/ValueAnimator;", "mAppendCount", "", "mBindTextView", "Landroid/widget/TextView;", "mCurrentCount", "mMaxCount", "animAppend", "", "bindView", "textView", "maxCount", "cancel", "destroy", "increase", "count", "anim", "", "updateViewNum", "num", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseController.kt */
final class LikeManager {
    private ValueAnimator mAnimator;
    private int mAppendCount;
    private TextView mBindTextView;
    private int mCurrentCount;
    private int mMaxCount;

    public final void increase(int i, boolean z) {
        cancel();
        this.mAppendCount += i;
        if (this.mBindTextView != null) {
            XesLog.it("PraiseController-LikeManager", new Object[]{"currentCount: " + this.mCurrentCount + ", appendCount: " + this.mAppendCount});
            if (!z || this.mCurrentCount >= this.mMaxCount) {
                int i2 = this.mCurrentCount + this.mAppendCount;
                this.mCurrentCount = i2;
                this.mAppendCount = 0;
                updateViewNum(i2);
                return;
            }
            animAppend();
        }
    }

    private final void animAppend() {
        this.mAnimator = ValueAnimator.ofInt(new int[]{0, this.mAppendCount});
        Ref.IntRef intRef = new Ref.IntRef();
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new LikeManager$$ExternalSyntheticLambda0(intRef, this));
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(900);
        }
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: animAppend$lambda-0  reason: not valid java name */
    public static final void m521animAppend$lambda0(Ref.IntRef intRef, LikeManager likeManager, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(intRef, "$mCurrentValue");
        Intrinsics.checkNotNullParameter(likeManager, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (intRef.element != intValue) {
            XesLog.it("PraiseController-LikeManager", new Object[]{Intrinsics.stringPlus("update num ", Integer.valueOf(intValue))});
            int i = likeManager.mCurrentCount + 1;
            likeManager.mCurrentCount = i;
            likeManager.mAppendCount--;
            likeManager.updateViewNum(i);
        }
        intRef.element = intValue;
    }

    private final void updateViewNum(int i) {
        if (i >= this.mMaxCount) {
            TextView textView = this.mBindTextView;
            if (textView != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.mMaxCount);
                sb.append('+');
                textView.setText(sb.toString());
                return;
            }
            return;
        }
        TextView textView2 = this.mBindTextView;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i));
        }
    }

    public final void bindView(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.mMaxCount = i;
        this.mBindTextView = textView;
    }

    private final void cancel() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllListeners();
        }
        this.mAnimator = null;
    }

    public final void destroy() {
        cancel();
        this.mBindTextView = null;
        this.mCurrentCount = 0;
        this.mAppendCount = 0;
    }
}
