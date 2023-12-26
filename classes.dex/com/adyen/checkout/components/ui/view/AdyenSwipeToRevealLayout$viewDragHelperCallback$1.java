package com.adyen.checkout.components.ui.view;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J0\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J \u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\u0017"}, d2 = {"com/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$viewDragHelperCallback$1", "Landroidx/customview/widget/ViewDragHelper$Callback;", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "onEdgeDragStarted", "", "edgeFlags", "pointerId", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "", "yvel", "tryCaptureView", "", "ui-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AdyenSwipeToRevealLayout.kt */
public final class AdyenSwipeToRevealLayout$viewDragHelperCallback$1 extends ViewDragHelper.Callback {
    final /* synthetic */ AdyenSwipeToRevealLayout this$0;

    AdyenSwipeToRevealLayout$viewDragHelperCallback$1(AdyenSwipeToRevealLayout adyenSwipeToRevealLayout) {
        this.this$0 = adyenSwipeToRevealLayout;
    }

    public boolean tryCaptureView(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "child");
        if (this.this$0.isDragLocked) {
            return false;
        }
        ViewDragHelper access$getDragHelper$p = this.this$0.dragHelper;
        if (access$getDragHelper$p != null) {
            View access$getMainView$p = this.this$0.mainView;
            if (access$getMainView$p != null) {
                access$getDragHelper$p.captureChildView(access$getMainView$p, i);
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mainView");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
        throw null;
    }

    public int clampViewPositionHorizontal(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        int min = Math.min(i, this.this$0.rectMainNotDragged.left);
        int i3 = this.this$0.rectMainNotDragged.left;
        View access$getUnderlayView$p = this.this$0.underlayView;
        if (access$getUnderlayView$p != null) {
            return Math.max(min, i3 - access$getUnderlayView$p.getWidth());
        }
        Intrinsics.throwUninitializedPropertyAccessException("underlayView");
        throw null;
    }

    public void onViewReleased(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "releasedChild");
        int i = this.this$0.rectMainNotDragged.right;
        View access$getUnderlayView$p = this.this$0.underlayView;
        if (access$getUnderlayView$p != null) {
            int width = i - (access$getUnderlayView$p.getWidth() / 2);
            View access$getMainView$p = this.this$0.mainView;
            if (access$getMainView$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainView");
                throw null;
            } else if (access$getMainView$p.getRight() < width) {
                this.this$0.expandUnderlay();
            } else {
                this.this$0.collapseUnderlay();
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("underlayView");
            throw null;
        }
    }

    public void onEdgeDragStarted(int i, int i2) {
        super.onEdgeDragStarted(i, i2);
        if (!this.this$0.isDragLocked && i == 1) {
            ViewDragHelper access$getDragHelper$p = this.this$0.dragHelper;
            if (access$getDragHelper$p != null) {
                View access$getMainView$p = this.this$0.mainView;
                if (access$getMainView$p != null) {
                    access$getDragHelper$p.captureChildView(access$getMainView$p, i2);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mainView");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
                throw null;
            }
        }
    }

    public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        super.onViewPositionChanged(view, i, i2, i3, i4);
        ViewCompat.postInvalidateOnAnimation(this.this$0);
    }
}
