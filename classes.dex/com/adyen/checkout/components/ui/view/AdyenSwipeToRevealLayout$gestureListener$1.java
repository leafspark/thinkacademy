package com.adyen.checkout.components.ui.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J,\u0010\u000e\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, d2 = {"com/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$gestureListener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onSingleTapConfirmed", "ui-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AdyenSwipeToRevealLayout.kt */
public final class AdyenSwipeToRevealLayout$gestureListener$1 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ AdyenSwipeToRevealLayout this$0;

    AdyenSwipeToRevealLayout$gestureListener$1(AdyenSwipeToRevealLayout adyenSwipeToRevealLayout) {
        this.this$0 = adyenSwipeToRevealLayout;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.this$0.isDragging = false;
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.this$0.isDragging = true;
        if (this.this$0.getParent() == null) {
            return false;
        }
        this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.this$0.isDragging = true;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        if (r8 <= ((float) r3.getBottom())) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLongPress(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout r0 = r7.this$0
            android.view.View r0 = r0.mainView
            r1 = 0
            java.lang.String r2 = "mainView"
            if (r0 == 0) goto L_0x009b
            int r0 = r0.getRight()
            com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout r3 = r7.this$0
            android.graphics.Rect r3 = r3.rectMainNotDragged
            int r3 = r3.right
            r4 = 1
            r5 = 0
            if (r0 != r3) goto L_0x0022
            r0 = r4
            goto L_0x0023
        L_0x0022:
            r0 = r5
        L_0x0023:
            float r3 = r8.getX()
            com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout r6 = r7.this$0
            android.view.View r6 = r6.mainView
            if (r6 == 0) goto L_0x0097
            int r6 = r6.getLeft()
            float r6 = (float) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x0084
            float r3 = r8.getX()
            com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout r6 = r7.this$0
            android.view.View r6 = r6.mainView
            if (r6 == 0) goto L_0x0080
            int r6 = r6.getRight()
            float r6 = (float) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x0084
            float r3 = r8.getY()
            com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout r6 = r7.this$0
            android.view.View r6 = r6.mainView
            if (r6 == 0) goto L_0x007c
            int r6 = r6.getTop()
            float r6 = (float) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x0084
            float r8 = r8.getY()
            com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout r3 = r7.this$0
            android.view.View r3 = r3.mainView
            if (r3 == 0) goto L_0x0078
            int r1 = r3.getBottom()
            float r1 = (float) r1
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 > 0) goto L_0x0084
            goto L_0x0085
        L_0x0078:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x007c:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x0080:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x0084:
            r4 = r5
        L_0x0085:
            if (r0 == 0) goto L_0x0096
            if (r4 == 0) goto L_0x0096
            com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout r8 = r7.this$0
            boolean r8 = r8.isDragLocked
            if (r8 != 0) goto L_0x0096
            com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout r8 = r7.this$0
            r8.expandUnderlay()
        L_0x0096:
            return
        L_0x0097:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x009b:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout$gestureListener$1.onLongPress(android.view.MotionEvent):void");
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        View access$getMainView$p = this.this$0.mainView;
        if (access$getMainView$p != null) {
            boolean z = false;
            boolean z2 = access$getMainView$p.getRight() == this.this$0.rectMainNotDragged.right;
            float x = motionEvent.getX();
            View access$getMainView$p2 = this.this$0.mainView;
            if (access$getMainView$p2 != null) {
                if (x >= ((float) access$getMainView$p2.getLeft())) {
                    float x2 = motionEvent.getX();
                    View access$getMainView$p3 = this.this$0.mainView;
                    if (access$getMainView$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainView");
                        throw null;
                    } else if (x2 <= ((float) access$getMainView$p3.getRight())) {
                        float y = motionEvent.getY();
                        View access$getMainView$p4 = this.this$0.mainView;
                        if (access$getMainView$p4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mainView");
                            throw null;
                        } else if (y >= ((float) access$getMainView$p4.getTop())) {
                            float y2 = motionEvent.getY();
                            View access$getMainView$p5 = this.this$0.mainView;
                            if (access$getMainView$p5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mainView");
                                throw null;
                            } else if (y2 <= ((float) access$getMainView$p5.getBottom())) {
                                z = true;
                            }
                        }
                    }
                }
                if (!z) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                if (z2) {
                    AdyenSwipeToRevealLayout.OnMainClickListener access$getOnMainClickListener$p = this.this$0.onMainClickListener;
                    if (access$getOnMainClickListener$p == null) {
                        return true;
                    }
                    access$getOnMainClickListener$p.onClick();
                    return true;
                }
                this.this$0.collapseUnderlay();
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mainView");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainView");
        throw null;
    }
}
