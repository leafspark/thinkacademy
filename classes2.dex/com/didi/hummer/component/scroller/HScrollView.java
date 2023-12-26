package com.didi.hummer.component.scroller;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.didi.hummer.component.input.FocusUtil;
import com.didi.hummer.component.input.KeyboardUtil;

public class HScrollView extends HorizontalScrollView {
    private boolean isScrollToEnd;
    private ScrollViewStateObserver observer;
    private OnScrollListener onScrollListener;
    private OnScrollToBottomListener onScrollToBottomListener;
    private OnScrollToTopListener onScrollToTopListener;

    public HScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrollToEnd = false;
        this.onScrollListener = null;
        this.onScrollToTopListener = null;
        this.onScrollToBottomListener = null;
        init(context);
    }

    private void init(Context context) {
        setOverScrollMode(2);
        setImportantForAccessibility(2);
        ScrollViewStateObserver scrollViewStateObserver = new ScrollViewStateObserver();
        this.observer = scrollViewStateObserver;
        scrollViewStateObserver.setOnScrollStateListener(new HScrollView$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$init$0$HScrollView(int i) {
        OnScrollListener onScrollListener2;
        if (i == 1) {
            OnScrollListener onScrollListener3 = this.onScrollListener;
            if (onScrollListener3 != null) {
                onScrollListener3.onScrollStarted();
            }
        } else if (i == 3) {
            OnScrollListener onScrollListener4 = this.onScrollListener;
            if (onScrollListener4 != null) {
                onScrollListener4.onScrollUp();
            }
        } else if (i == 4 && (onScrollListener2 = this.onScrollListener) != null) {
            onScrollListener2.onScrollFinished();
        }
    }

    public void release() {
        ScrollViewStateObserver scrollViewStateObserver = this.observer;
        if (scrollViewStateObserver != null) {
            scrollViewStateObserver.release();
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener2) {
        this.onScrollListener = onScrollListener2;
    }

    public void setOnScrollToTopListener(OnScrollToTopListener onScrollToTopListener2) {
        this.onScrollToTopListener = onScrollToTopListener2;
    }

    public void setOnScrollToBottomListener(OnScrollToBottomListener onScrollToBottomListener2) {
        this.onScrollToBottomListener = onScrollToBottomListener2;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.observer.onScrollChanged(i, i3);
        OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            onScrollListener2.onScrollChanged(this, i, i2, i - i3, i2 - i4);
        }
        hideKeyboardIfNeed(Math.abs(i - i3));
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (!z) {
            this.isScrollToEnd = false;
        } else if (!this.isScrollToEnd) {
            this.isScrollToEnd = true;
            if (i > 0) {
                OnScrollToBottomListener onScrollToBottomListener2 = this.onScrollToBottomListener;
                if (onScrollToBottomListener2 != null) {
                    onScrollToBottomListener2.onScrollToBottom();
                    return;
                }
                return;
            }
            OnScrollToTopListener onScrollToTopListener2 = this.onScrollToTopListener;
            if (onScrollToTopListener2 != null) {
                onScrollToTopListener2.onScrollToTop();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.isScrollToEnd = false;
        }
        this.observer.onInterceptTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            FocusUtil.clearFocus(getContext());
        }
        this.observer.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    private void hideKeyboardIfNeed(int i) {
        if (i > 20 && (getContext() instanceof Activity)) {
            Activity activity = (Activity) getContext();
            if (activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
                KeyboardUtil.hideKeyboard(activity.getCurrentFocus());
            }
        }
    }
}
