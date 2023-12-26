package com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.animator;

import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ,\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J.\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/animator/KeyboardAnimator;", "", "()V", "mKeyboardOpenAnimator", "Landroid/animation/ObjectAnimator;", "mKeyboardShowAnimator", "destroy", "", "isOpenRunning", "", "isShowRunning", "makeOpenAnimator", "show", "target", "Landroid/view/View;", "offsetY", "", "endBlock", "Lkotlin/Function0;", "makeShowAnimator", "duration", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardAnimator.kt */
public final class KeyboardAnimator {
    private ObjectAnimator mKeyboardOpenAnimator;
    private ObjectAnimator mKeyboardShowAnimator;

    public final boolean isShowRunning() {
        ObjectAnimator objectAnimator = this.mKeyboardShowAnimator;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public static /* synthetic */ void makeShowAnimator$default(KeyboardAnimator keyboardAnimator, boolean z, View view, long j, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 400;
        }
        keyboardAnimator.makeShowAnimator(z, view, j, function0);
    }

    public final void makeShowAnimator(boolean z, View view, long j, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(function0, "endBlock");
        if (this.mKeyboardShowAnimator == null) {
            KeyboardAnimator keyboardAnimator = this;
            this.mKeyboardShowAnimator = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, 0.0f});
        }
        float scaleY = view.getScaleY();
        ObjectAnimator objectAnimator = this.mKeyboardOpenAnimator;
        if (objectAnimator != null) {
            objectAnimator.setDuration(j);
        }
        if (z) {
            ObjectAnimator objectAnimator2 = this.mKeyboardShowAnimator;
            if (objectAnimator2 != null) {
                objectAnimator2.setFloatValues(new float[]{((float) view.getHeight()) * scaleY, 0.0f});
            }
        } else {
            ObjectAnimator objectAnimator3 = this.mKeyboardShowAnimator;
            if (objectAnimator3 != null) {
                objectAnimator3.setFloatValues(new float[]{view.getTranslationY(), ((float) view.getHeight()) * scaleY});
            }
        }
        ObjectAnimator objectAnimator4 = this.mKeyboardShowAnimator;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new KeyboardAnimator$makeShowAnimator$2(function0));
        }
        ObjectAnimator objectAnimator5 = this.mKeyboardShowAnimator;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

    public final boolean isOpenRunning() {
        ObjectAnimator objectAnimator = this.mKeyboardOpenAnimator;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public final void makeOpenAnimator(boolean z, View view, float f, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(function0, "endBlock");
        if (this.mKeyboardOpenAnimator == null) {
            KeyboardAnimator keyboardAnimator = this;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, 0.0f});
            ofFloat.setDuration(200);
            this.mKeyboardOpenAnimator = ofFloat;
        }
        float scaleY = view.getScaleY();
        if (z) {
            ObjectAnimator objectAnimator = this.mKeyboardOpenAnimator;
            if (objectAnimator != null) {
                objectAnimator.setFloatValues(new float[]{f * scaleY, 0.0f});
            }
        } else {
            ObjectAnimator objectAnimator2 = this.mKeyboardOpenAnimator;
            if (objectAnimator2 != null) {
                objectAnimator2.setFloatValues(new float[]{0.0f, f * scaleY});
            }
        }
        ObjectAnimator objectAnimator3 = this.mKeyboardOpenAnimator;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(new KeyboardAnimator$makeOpenAnimator$2(function0));
        }
        ObjectAnimator objectAnimator4 = this.mKeyboardOpenAnimator;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
    }

    public final void destroy() {
        ObjectAnimator objectAnimator = this.mKeyboardOpenAnimator;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                objectAnimator.cancel();
            }
            objectAnimator.removeAllListeners();
        }
        this.mKeyboardOpenAnimator = null;
        ObjectAnimator objectAnimator2 = this.mKeyboardShowAnimator;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                objectAnimator2.cancel();
            }
            objectAnimator2.removeAllListeners();
        }
        this.mKeyboardShowAnimator = null;
    }
}
