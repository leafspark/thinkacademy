package com.didi.hummer.render.style;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.didi.hummer.render.component.view.HMBase;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class HummerLayout extends YogaLayout {
    private Map<String, HMBase> children;
    private Callable<float[]> cornerRadiiGetter;
    private HMBase lastChild;
    private RectF mClipBounds;
    private Path mViewPath;
    private boolean needClipChildren;
    private OnSizeChangeListener onSizeChangeListener;

    public interface OnSizeChangeListener {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public HummerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public HummerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HummerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.children = new HashMap();
        this.mClipBounds = new RectF();
        this.mViewPath = new Path();
        init(context);
    }

    private void init(Context context) {
        setClipChildren(false);
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener2) {
        this.onSizeChangeListener = onSizeChangeListener2;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        OnSizeChangeListener onSizeChangeListener2 = this.onSizeChangeListener;
        if (onSizeChangeListener2 != null) {
            onSizeChangeListener2.onSizeChanged(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(View.MeasureSpec.makeMeasureSpec(i3 - i, 0), View.MeasureSpec.makeMeasureSpec(i4 - i2, 0));
        }
        applyLayoutRecursive(getYogaNode(), 0.0f, 0.0f);
    }

    private void createLayout(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            getYogaNode().setHeight((float) size2);
        }
        if (mode == 1073741824) {
            getYogaNode().setWidth((float) size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            getYogaNode().setMaxHeight((float) size2);
        }
        if (mode == Integer.MIN_VALUE) {
            getYogaNode().setMaxWidth((float) size);
        }
        getYogaNode().calculateLayout(Float.NaN, Float.NaN);
    }

    private void applyLayoutRecursive(YogaNode yogaNode, float f, float f2) {
        View view = (View) yogaNode.getData();
        if (!(view == null || view == this)) {
            if (view.getVisibility() != 8) {
                int round = Math.round(yogaNode.getLayoutX() + f);
                int round2 = Math.round(yogaNode.getLayoutY() + f2);
                view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutWidth()), PictureFileUtils.GB), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutHeight()), PictureFileUtils.GB));
                view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
            } else {
                return;
            }
        }
        int childCount = yogaNode.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (equals(view)) {
                applyLayoutRecursive(yogaNode.getChildAt(i), f, f2);
            } else {
                boolean z = view instanceof YogaLayout;
            }
        }
    }

    public void setCornerRadiiGetter(Callable<float[]> callable) {
        this.cornerRadiiGetter = callable;
    }

    public void setNeedClipChildren(boolean z) {
        this.needClipChildren = z;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.needClipChildren) {
            this.mClipBounds.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
            this.mViewPath.reset();
            float[] fArr = null;
            try {
                Callable<float[]> callable = this.cornerRadiiGetter;
                if (callable != null) {
                    fArr = callable.call();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fArr != null) {
                this.mViewPath.addRoundRect(this.mClipBounds, fArr, Path.Direction.CW);
            } else {
                this.mViewPath.addRect(this.mClipBounds, Path.Direction.CW);
            }
            canvas.clipPath(this.mViewPath);
        }
    }

    public void addView(HMBase hMBase) {
        addView(hMBase, -1);
    }

    public void addView(HMBase hMBase, int i) {
        if (hMBase != null) {
            ViewParent parent = hMBase.getView().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(hMBase.getView());
            }
            addView(hMBase.getView(), hMBase.getYogaNode());
            if (hMBase.getYogaNode().getData() == null) {
                hMBase.getYogaNode().setData(hMBase.getView());
            }
            int childCount = getYogaNode().getChildCount();
            if (i < 0) {
                i = childCount;
            }
            getYogaNode().addChildAt(hMBase.getYogaNode(), i);
            this.children.put(hMBase.getViewID(), hMBase);
            if (i == childCount) {
                this.lastChild = hMBase;
            }
        }
    }

    public void removeView(HMBase hMBase) {
        if (hMBase != null) {
            removeView(hMBase.getView());
            this.children.remove(hMBase.getViewID());
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        this.children.clear();
    }

    public void insertBefore(HMBase hMBase, HMBase hMBase2) {
        if (hMBase != null && hMBase2 != null) {
            addView(hMBase, getYogaNode().indexOf(hMBase2.getYogaNode()));
        }
    }

    public void replaceView(HMBase hMBase, HMBase hMBase2) {
        if (hMBase != null && hMBase2 != null) {
            int indexOf = getYogaNode().indexOf(hMBase2.getYogaNode());
            removeView(hMBase2);
            addView(hMBase, indexOf);
        }
    }

    public HMBase getViewById(String str) {
        return this.children.get(str);
    }

    public HMBase getLastChild() {
        return this.lastChild;
    }

    public void layout() {
        getYogaNode().calculateLayout(0.0f, 0.0f);
    }
}
