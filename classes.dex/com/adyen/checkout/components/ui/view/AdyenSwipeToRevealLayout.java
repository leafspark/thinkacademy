package com.adyen.checkout.components.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.customview.widget.ViewDragHelper;
import com.adyen.checkout.core.exception.CheckoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0002\u0010#\u0018\u00002\u00020\u0001:\u0002=>B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020&J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0014J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020(H\u0016J0\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J\u0018\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0014J\u0010\u00108\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(H\u0017J\u0006\u00109\u001a\u00020&J\u000e\u0010:\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010;\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010<\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006?"}, d2 = {"Lcom/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dragDistance", "", "dragHelper", "Landroidx/customview/widget/ViewDragHelper;", "gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "gestureListener", "com/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$gestureListener$1", "Lcom/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$gestureListener$1;", "isDragLocked", "", "isDragging", "mainView", "Landroid/view/View;", "onMainClickListener", "Lcom/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$OnMainClickListener;", "previousX", "rectMainDragged", "Landroid/graphics/Rect;", "rectMainNotDragged", "rectUnderlayDragged", "rectUnderlayNotDragged", "underlayListener", "Lcom/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$UnderlayListener;", "underlayView", "viewDragHelperCallback", "com/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$viewDragHelperCallback$1", "Lcom/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$viewDragHelperCallback$1;", "calculateDragDistance", "", "event", "Landroid/view/MotionEvent;", "collapseUnderlay", "computeScroll", "expandUnderlay", "onFinishInflate", "onInterceptTouchEvent", "ev", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "removeUnderlayListener", "setDragLocked", "setOnMainClickListener", "setUnderlayListener", "OnMainClickListener", "UnderlayListener", "ui-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AdyenSwipeToRevealLayout.kt */
public final class AdyenSwipeToRevealLayout extends ViewGroup {
    private float dragDistance;
    /* access modifiers changed from: private */
    public ViewDragHelper dragHelper;
    private GestureDetectorCompat gestureDetector;
    private final AdyenSwipeToRevealLayout$gestureListener$1 gestureListener;
    /* access modifiers changed from: private */
    public volatile boolean isDragLocked;
    /* access modifiers changed from: private */
    public volatile boolean isDragging;
    /* access modifiers changed from: private */
    public View mainView;
    /* access modifiers changed from: private */
    public OnMainClickListener onMainClickListener;
    private float previousX;
    private final Rect rectMainDragged;
    /* access modifiers changed from: private */
    public final Rect rectMainNotDragged;
    private final Rect rectUnderlayDragged;
    private final Rect rectUnderlayNotDragged;
    private UnderlayListener underlayListener;
    /* access modifiers changed from: private */
    public View underlayView;
    private final AdyenSwipeToRevealLayout$viewDragHelperCallback$1 viewDragHelperCallback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$OnMainClickListener;", "", "onClick", "", "ui-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AdyenSwipeToRevealLayout.kt */
    public interface OnMainClickListener {
        void onClick();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout$UnderlayListener;", "", "onUnderlayExpanded", "", "view", "Lcom/adyen/checkout/components/ui/view/AdyenSwipeToRevealLayout;", "ui-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AdyenSwipeToRevealLayout.kt */
    public interface UnderlayListener {
        void onUnderlayExpanded(AdyenSwipeToRevealLayout adyenSwipeToRevealLayout);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdyenSwipeToRevealLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdyenSwipeToRevealLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdyenSwipeToRevealLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdyenSwipeToRevealLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rectMainDragged = new Rect();
        this.rectMainNotDragged = new Rect();
        this.rectUnderlayDragged = new Rect();
        this.rectUnderlayNotDragged = new Rect();
        this.previousX = -1.0f;
        AdyenSwipeToRevealLayout$viewDragHelperCallback$1 adyenSwipeToRevealLayout$viewDragHelperCallback$1 = new AdyenSwipeToRevealLayout$viewDragHelperCallback$1(this);
        this.viewDragHelperCallback = adyenSwipeToRevealLayout$viewDragHelperCallback$1;
        AdyenSwipeToRevealLayout$gestureListener$1 adyenSwipeToRevealLayout$gestureListener$1 = new AdyenSwipeToRevealLayout$gestureListener$1(this);
        this.gestureListener = adyenSwipeToRevealLayout$gestureListener$1;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, adyenSwipeToRevealLayout$viewDragHelperCallback$1);
        Intrinsics.checkNotNullExpressionValue(create, "create(this, 1f, viewDragHelperCallback)");
        this.dragHelper = create;
        if (create != null) {
            create.setEdgeTrackingEnabled(15);
            this.gestureDetector = new GestureDetectorCompat(context, adyenSwipeToRevealLayout$gestureListener$1);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        ViewGroup viewGroup = this;
        int i3 = 0;
        int i4 = 0;
        for (View view : ViewGroupKt.getChildren(viewGroup)) {
            measureChild(view, i, i2);
            if (i3 < view.getMeasuredHeight()) {
                i3 = view.getMeasuredHeight();
            }
            if (i4 < view.getMeasuredWidth()) {
                i4 = view.getMeasuredWidth();
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, mode2);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, mode);
        int size = View.MeasureSpec.getSize(makeMeasureSpec);
        int size2 = View.MeasureSpec.getSize(makeMeasureSpec2);
        for (View view2 : ViewGroupKt.getChildren(viewGroup)) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.height == -1) {
                    view2.setMinimumHeight(size);
                }
                if (layoutParams.width == -1) {
                    view2.setMinimumWidth(size2);
                }
            }
            measureChild(view2, makeMeasureSpec2, makeMeasureSpec);
            i4 = Math.max(view2.getMeasuredWidth(), i4);
            i3 = Math.max(view2.getMeasuredHeight(), i3);
        }
        int paddingTop = i3 + getPaddingTop() + getPaddingBottom();
        int paddingLeft = i4 + getPaddingLeft() + getPaddingRight();
        if (!(mode == 1073741824 || getLayoutParams().width == -1)) {
            if (mode == Integer.MIN_VALUE) {
                Math.min(size2, paddingLeft);
            }
            size2 = paddingLeft;
        }
        if (!(mode2 == 1073741824 || getLayoutParams().height == -1)) {
            if (mode2 == Integer.MIN_VALUE) {
                Math.min(size, paddingTop);
            }
            size = paddingTop;
        }
        setMeasuredDimension(size2, size);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (View view : ViewGroupKt.getChildren(this)) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (layoutParams.height == -1) {
                measuredHeight = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
                layoutParams.height = measuredHeight;
            }
            if (layoutParams.width == -1) {
                measuredWidth = ((i3 - i) - getPaddingLeft()) - getPaddingRight();
                layoutParams.width = measuredWidth;
            }
            int max = Math.max(((i3 - measuredWidth) - getPaddingRight()) - i, getPaddingLeft());
            int max2 = Math.max((i3 - i) - getPaddingRight(), getPaddingLeft());
            int max3 = Math.max(measuredHeight + getPaddingTop(), Math.max((i4 - i2) - getPaddingBottom(), 0));
            view.layout(max, Math.min(getPaddingTop(), max3), max2, max3);
        }
        Rect rect = this.rectMainNotDragged;
        View view2 = this.mainView;
        if (view2 != null) {
            int left = view2.getLeft();
            View view3 = this.mainView;
            if (view3 != null) {
                int top = view3.getTop();
                View view4 = this.mainView;
                if (view4 != null) {
                    int right = view4.getRight();
                    View view5 = this.mainView;
                    if (view5 != null) {
                        rect.set(left, top, right, view5.getBottom());
                        Rect rect2 = this.rectUnderlayNotDragged;
                        View view6 = this.underlayView;
                        if (view6 != null) {
                            int left2 = view6.getLeft();
                            View view7 = this.underlayView;
                            if (view7 != null) {
                                int top2 = view7.getTop();
                                View view8 = this.underlayView;
                                if (view8 != null) {
                                    int right2 = view8.getRight();
                                    View view9 = this.underlayView;
                                    if (view9 != null) {
                                        rect2.set(left2, top2, right2, view9.getBottom());
                                        Rect rect3 = this.rectMainDragged;
                                        int i5 = this.rectMainNotDragged.left;
                                        View view10 = this.underlayView;
                                        if (view10 != null) {
                                            int width = i5 - view10.getWidth();
                                            int i6 = this.rectMainNotDragged.top;
                                            int i7 = this.rectMainNotDragged.left;
                                            View view11 = this.mainView;
                                            if (view11 != null) {
                                                int width2 = i7 + view11.getWidth();
                                                View view12 = this.underlayView;
                                                if (view12 != null) {
                                                    int width3 = width2 - view12.getWidth();
                                                    int i8 = this.rectMainNotDragged.top;
                                                    View view13 = this.mainView;
                                                    if (view13 != null) {
                                                        rect3.set(width, i6, width3, i8 + view13.getHeight());
                                                        Rect rect4 = this.rectUnderlayDragged;
                                                        int i9 = this.rectUnderlayNotDragged.left;
                                                        int i10 = this.rectUnderlayNotDragged.top;
                                                        int i11 = this.rectUnderlayNotDragged.left;
                                                        View view14 = this.underlayView;
                                                        if (view14 != null) {
                                                            int width4 = i11 + view14.getWidth();
                                                            int i12 = this.rectUnderlayNotDragged.top;
                                                            View view15 = this.underlayView;
                                                            if (view15 != null) {
                                                                rect4.set(i9, i10, width4, i12 + view15.getHeight());
                                                            } else {
                                                                Intrinsics.throwUninitializedPropertyAccessException("underlayView");
                                                                throw null;
                                                            }
                                                        } else {
                                                            Intrinsics.throwUninitializedPropertyAccessException("underlayView");
                                                            throw null;
                                                        }
                                                    } else {
                                                        Intrinsics.throwUninitializedPropertyAccessException("mainView");
                                                        throw null;
                                                    }
                                                } else {
                                                    Intrinsics.throwUninitializedPropertyAccessException("underlayView");
                                                    throw null;
                                                }
                                            } else {
                                                Intrinsics.throwUninitializedPropertyAccessException("mainView");
                                                throw null;
                                            }
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("underlayView");
                                            throw null;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("underlayView");
                                        throw null;
                                    }
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("underlayView");
                                    throw null;
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("underlayView");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("underlayView");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mainView");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mainView");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mainView");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mainView");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(1)");
            this.mainView = childAt;
            View childAt2 = getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(0)");
            this.underlayView = childAt2;
            return;
        }
        throw new CheckoutException(Intrinsics.stringPlus(getClass().getSimpleName(), " must contain two children."));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        this.gestureDetector.onTouchEvent(motionEvent);
        ViewDragHelper viewDragHelper = this.dragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
            return true;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            androidx.core.view.GestureDetectorCompat r0 = r8.gestureDetector
            r0.onTouchEvent(r9)
            androidx.customview.widget.ViewDragHelper r0 = r8.dragHelper
            java.lang.String r1 = "dragHelper"
            r2 = 0
            if (r0 == 0) goto L_0x00bb
            r0.processTouchEvent(r9)
            r8.calculateDragDistance(r9)
            androidx.customview.widget.ViewDragHelper r0 = r8.dragHelper
            if (r0 == 0) goto L_0x00b7
            int r0 = r0.getViewDragState()
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x0029
            boolean r0 = r8.isDragging
            if (r0 == 0) goto L_0x0029
            r0 = r3
            goto L_0x002a
        L_0x0029:
            r0 = r4
        L_0x002a:
            float r5 = r9.getX()
            android.view.View r6 = r8.mainView
            java.lang.String r7 = "mainView"
            if (r6 == 0) goto L_0x00b3
            int r6 = r6.getRight()
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0091
            float r5 = r9.getX()
            android.view.View r6 = r8.mainView
            if (r6 == 0) goto L_0x008d
            int r6 = r6.getLeft()
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x0091
            float r5 = r9.getY()
            android.view.View r6 = r8.mainView
            if (r6 == 0) goto L_0x0089
            int r6 = r6.getTop()
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0091
            float r5 = r9.getY()
            android.view.View r6 = r8.mainView
            if (r6 == 0) goto L_0x0085
            int r6 = r6.getBottom()
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x0091
            float r5 = r8.dragDistance
            androidx.customview.widget.ViewDragHelper r6 = r8.dragHelper
            if (r6 == 0) goto L_0x0081
            int r6 = r6.getTouchSlop()
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0091
            r5 = r3
            goto L_0x0092
        L_0x0081:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            throw r2
        L_0x0085:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r2
        L_0x0089:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r2
        L_0x008d:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r2
        L_0x0091:
            r5 = r4
        L_0x0092:
            androidx.customview.widget.ViewDragHelper r6 = r8.dragHelper
            if (r6 == 0) goto L_0x00af
            int r1 = r6.getViewDragState()
            r2 = 2
            if (r1 != r2) goto L_0x009f
            r1 = r3
            goto L_0x00a0
        L_0x009f:
            r1 = r4
        L_0x00a0:
            float r9 = r9.getX()
            r8.previousX = r9
            if (r5 != 0) goto L_0x00ad
            if (r1 != 0) goto L_0x00ae
            if (r0 == 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r3 = r4
        L_0x00ae:
            return r3
        L_0x00af:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            throw r2
        L_0x00b3:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r2
        L_0x00b7:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            throw r2
        L_0x00bb:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.ui.view.AdyenSwipeToRevealLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.dragHelper;
        if (viewDragHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
            throw null;
        } else if (viewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void setDragLocked(boolean z) {
        this.isDragLocked = z;
    }

    public final void setUnderlayListener(UnderlayListener underlayListener2) {
        Intrinsics.checkNotNullParameter(underlayListener2, "underlayListener");
        this.underlayListener = underlayListener2;
    }

    public final void removeUnderlayListener() {
        this.underlayListener = null;
    }

    public final void setOnMainClickListener(OnMainClickListener onMainClickListener2) {
        Intrinsics.checkNotNullParameter(onMainClickListener2, "onMainClickListener");
        this.onMainClickListener = onMainClickListener2;
    }

    private final void calculateDragDistance(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.dragDistance = 0.0f;
        } else {
            this.dragDistance += Math.abs(motionEvent.getX() - this.previousX);
        }
    }

    /* access modifiers changed from: private */
    public final void expandUnderlay() {
        ViewDragHelper viewDragHelper = this.dragHelper;
        if (viewDragHelper != null) {
            View view = this.mainView;
            if (view != null) {
                viewDragHelper.smoothSlideViewTo(view, this.rectMainDragged.left, this.rectMainDragged.top);
                ViewCompat.postInvalidateOnAnimation(this);
                UnderlayListener underlayListener2 = this.underlayListener;
                if (underlayListener2 != null) {
                    underlayListener2.onUnderlayExpanded(this);
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mainView");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
        throw null;
    }

    public final void collapseUnderlay() {
        ViewDragHelper viewDragHelper = this.dragHelper;
        if (viewDragHelper != null) {
            View view = this.mainView;
            if (view != null) {
                viewDragHelper.smoothSlideViewTo(view, this.rectMainNotDragged.left, this.rectMainNotDragged.top);
                ViewCompat.postInvalidateOnAnimation(this);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mainView");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
        throw null;
    }
}
