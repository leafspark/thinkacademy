package org.libpag;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;

class DisplayLink implements ValueAnimator.AnimatorUpdateListener {
    /* access modifiers changed from: private */
    public ValueAnimator a;
    private Handler b = new Handler(Looper.getMainLooper());
    private long nativeContext = 0;

    class a implements Runnable {
        a() {
        }

        public void run() {
            DisplayLink.this.a.start();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            DisplayLink.this.a.cancel();
        }
    }

    private DisplayLink() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.a = ofFloat;
        ofFloat.setDuration(1000);
        this.a.addUpdateListener(this);
        this.a.setRepeatCount(-1);
    }

    public static DisplayLink Create(long j) {
        DisplayLink displayLink = new DisplayLink();
        displayLink.nativeContext = j;
        return displayLink;
    }

    private native void onUpdate(long j);

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        onUpdate(this.nativeContext);
    }

    public void start() {
        this.b.post(new a());
    }

    public void stop() {
        this.b.post(new b());
    }
}
