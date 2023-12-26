package com.tal.app.thinkacademy.live.business.schulte.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/BoxView;", "Landroid/widget/FrameLayout;", "mContext", "Landroid/content/Context;", "level", "", "(Landroid/content/Context;I)V", "tvNum", "Landroid/widget/TextView;", "getText", "", "playAnimation", "", "pressDown", "setNumAlpha", "alpha", "", "setText", "txt", "shake", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxView.kt */
public final class BoxView extends FrameLayout {
    private final Context mContext;
    private final TextView tvNum;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxView(Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        TextView textView = new TextView(getContext());
        this.tvNum = textView;
        int i2 = 24;
        if (i == 3) {
            i2 = 32;
        } else if (i != 4 && i == 5) {
            i2 = 18;
        }
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        textView.setTextSize(1, (float) i2);
        textView.setTypeface(Typeface.create(ResourcesCompat.getFont(getContext(), R.font.montserrat_bold), 1));
        textView.setGravity(17);
        addView(textView, new FrameLayout.LayoutParams(-1, -1));
        setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.live_business_schulte_table_box_state));
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "txt");
        this.tvNum.setText(str);
    }

    public final String getText() {
        return this.tvNum.getText().toString();
    }

    public final void setNumAlpha(float f) {
        this.tvNum.setAlpha(f);
    }

    public final void playAnimation() {
        Drawable drawable = ContextCompat.getDrawable(this.mContext, R.drawable.animlst_schulte_table_box_in);
        AnimationDrawable animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
        setBackground(animationDrawable);
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public final void shake() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.9f, 1.0f, 1.04f, 1.0f, 1.02f, 1.0f, 1.01f, 1.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.9f, 1.0f, 1.04f, 1.0f, 1.02f, 1.0f, 1.01f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ROTATION, new float[]{0.0f, -6.0f, 0.0f, 4.0f, 0.0f, -2.0f, 0.0f, 1.0f, 0.0f}), ofFloat, ofFloat2});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(t…aleXHolder, scaleYHolder)");
        ofPropertyValuesHolder.setDuration(960);
        ofPropertyValuesHolder.start();
    }

    public final void pressDown() {
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.75f, 0.9f);
        Keyframe ofFloat3 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[]{ofFloat, ofFloat2, ofFloat3}), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[]{ofFloat, ofFloat2, ofFloat3})});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(this, scaleX, scaleY)");
        Animator animator = ofPropertyValuesHolder;
        animator.setDuration(120);
        animator.start();
    }
}
