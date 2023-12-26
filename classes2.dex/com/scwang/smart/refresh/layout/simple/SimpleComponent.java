package com.scwang.smart.refresh.layout.simple;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;

public abstract class SimpleComponent extends RelativeLayout implements RefreshComponent {
    protected SpinnerStyle mSpinnerStyle;
    protected RefreshComponent mWrappedInternal;
    protected View mWrappedView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected SimpleComponent(View view) {
        this(view, view instanceof RefreshComponent ? (RefreshComponent) view : null);
    }

    protected SimpleComponent(View view, RefreshComponent refreshComponent) {
        super(view.getContext(), (AttributeSet) null, 0);
        this.mWrappedView = view;
        this.mWrappedInternal = refreshComponent;
        if ((this instanceof RefreshFooter) && (refreshComponent instanceof RefreshHeader) && refreshComponent.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
            refreshComponent.getView().setScaleY(-1.0f);
        } else if (this instanceof RefreshHeader) {
            RefreshComponent refreshComponent2 = this.mWrappedInternal;
            if ((refreshComponent2 instanceof RefreshFooter) && refreshComponent2.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                refreshComponent.getView().setScaleY(-1.0f);
            }
        }
    }

    protected SimpleComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof RefreshComponent)) {
            return false;
        }
        if (getView() == ((RefreshComponent) obj).getView()) {
            return true;
        }
        return false;
    }

    public View getView() {
        View view = this.mWrappedView;
        return view == null ? this : view;
    }

    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent == null || refreshComponent == this) {
            return 0;
        }
        return refreshComponent.onFinish(refreshLayout, z);
    }

    public void setPrimaryColors(int... iArr) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.setPrimaryColors(iArr);
        }
    }

    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle spinnerStyle = this.mSpinnerStyle;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent != null && refreshComponent != this) {
            return refreshComponent.getSpinnerStyle();
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.LayoutParams) layoutParams).spinnerStyle;
                this.mSpinnerStyle = spinnerStyle2;
                if (spinnerStyle2 != null) {
                    return spinnerStyle2;
                }
            }
            if (layoutParams != null && (layoutParams.height == 0 || layoutParams.height == -1)) {
                for (SpinnerStyle spinnerStyle3 : SpinnerStyle.values) {
                    if (spinnerStyle3.scale) {
                        this.mSpinnerStyle = spinnerStyle3;
                        return spinnerStyle3;
                    }
                }
            }
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
        this.mSpinnerStyle = spinnerStyle4;
        return spinnerStyle4;
    }

    public void onInitialized(RefreshKernel refreshKernel, int i, int i2) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent == null || refreshComponent == this) {
            View view = this.mWrappedView;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                    refreshKernel.requestDrawBackgroundFor(this, ((SmartRefreshLayout.LayoutParams) layoutParams).backgroundColor);
                    return;
                }
                return;
            }
            return;
        }
        refreshComponent.onInitialized(refreshKernel, i, i2);
    }

    public boolean isSupportHorizontalDrag() {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        return (refreshComponent == null || refreshComponent == this || !refreshComponent.isSupportHorizontalDrag()) ? false : true;
    }

    public void onHorizontalDrag(float f, int i, int i2) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.onHorizontalDrag(f, i, i2);
        }
    }

    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.onMoving(z, f, i, i2, i3);
        }
    }

    public void onReleased(RefreshLayout refreshLayout, int i, int i2) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.onReleased(refreshLayout, i, i2);
        }
    }

    public void onStartAnimator(RefreshLayout refreshLayout, int i, int i2) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.onStartAnimator(refreshLayout, i, i2);
        }
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        if (refreshComponent != null && refreshComponent != this) {
            if ((this instanceof RefreshFooter) && (refreshComponent instanceof RefreshHeader)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof RefreshHeader) && (refreshComponent instanceof RefreshFooter)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            RefreshComponent refreshComponent2 = this.mWrappedInternal;
            if (refreshComponent2 != null) {
                refreshComponent2.onStateChanged(refreshLayout, refreshState, refreshState2);
            }
        }
    }

    public boolean setNoMoreData(boolean z) {
        RefreshComponent refreshComponent = this.mWrappedInternal;
        return (refreshComponent instanceof RefreshFooter) && ((RefreshFooter) refreshComponent).setNoMoreData(z);
    }
}
