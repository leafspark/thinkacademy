package io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.yalantis.ucrop.view.CropImageView;
import io.flutter.embedding.android.SplashScreen;

@Deprecated
public final class DrawableSplashScreen implements SplashScreen {
    private final long crossfadeDurationInMillis;
    private final Drawable drawable;
    private final ImageView.ScaleType scaleType;
    private DrawableSplashScreenView splashView;

    public /* synthetic */ boolean doesSplashViewRememberItsTransition() {
        return SplashScreen.CC.$default$doesSplashViewRememberItsTransition(this);
    }

    public /* synthetic */ Bundle saveSplashScreenState() {
        return SplashScreen.CC.$default$saveSplashScreenState(this);
    }

    public DrawableSplashScreen(Drawable drawable2) {
        this(drawable2, ImageView.ScaleType.FIT_XY, 500);
    }

    public DrawableSplashScreen(Drawable drawable2, ImageView.ScaleType scaleType2, long j) {
        this.drawable = drawable2;
        this.scaleType = scaleType2;
        this.crossfadeDurationInMillis = j;
    }

    public View createSplashView(Context context, Bundle bundle) {
        DrawableSplashScreenView drawableSplashScreenView = new DrawableSplashScreenView(context);
        this.splashView = drawableSplashScreenView;
        drawableSplashScreenView.setSplashDrawable(this.drawable, this.scaleType);
        return this.splashView;
    }

    public void transitionToFlutter(final Runnable runnable) {
        DrawableSplashScreenView drawableSplashScreenView = this.splashView;
        if (drawableSplashScreenView == null) {
            runnable.run();
        } else {
            drawableSplashScreenView.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(this.crossfadeDurationInMillis).setListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    runnable.run();
                }

                public void onAnimationCancel(Animator animator) {
                    runnable.run();
                }
            });
        }
    }

    public static class DrawableSplashScreenView extends ImageView {
        public DrawableSplashScreenView(Context context) {
            this(context, (AttributeSet) null, 0);
        }

        public DrawableSplashScreenView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public DrawableSplashScreenView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public void setSplashDrawable(Drawable drawable) {
            setSplashDrawable(drawable, ImageView.ScaleType.FIT_XY);
        }

        public void setSplashDrawable(Drawable drawable, ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }
    }
}
