package com.facebook.yoga.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.request.target.Target;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.util.Map;

public class YogaLayout extends ViewGroup {
    private final YogaNode mYogaNode;
    private final Map<View, YogaNode> mYogaNodes;

    public YogaLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public YogaLayout(android.content.Context r2, android.util.AttributeSet r3, int r4) {
        /*
            r1 = this;
            r1.<init>(r2, r3, r4)
            com.facebook.yoga.YogaNode r4 = com.facebook.yoga.YogaNodeFactory.create()
            r1.mYogaNode = r4
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1.mYogaNodes = r0
            r4.setData(r1)
            com.facebook.yoga.android.YogaLayout$ViewMeasureFunction r0 = new com.facebook.yoga.android.YogaLayout$ViewMeasureFunction
            r0.<init>()
            r4.setMeasureFunction(r0)
            if (r3 == 0) goto L_0x0023
            com.facebook.yoga.android.YogaLayout$LayoutParams r0 = new com.facebook.yoga.android.YogaLayout$LayoutParams
            r0.<init>((android.content.Context) r2, (android.util.AttributeSet) r3)
            goto L_0x002a
        L_0x0023:
            android.view.ViewGroup$LayoutParams r2 = r1.generateDefaultLayoutParams()
            r0 = r2
            com.facebook.yoga.android.YogaLayout$LayoutParams r0 = (com.facebook.yoga.android.YogaLayout.LayoutParams) r0
        L_0x002a:
            applyLayoutParams(r0, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.yoga.android.YogaLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public YogaNode getYogaNode() {
        return this.mYogaNode;
    }

    public YogaNode getYogaNodeForView(View view) {
        return this.mYogaNodes.get(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        YogaNode yogaNode;
        this.mYogaNode.setMeasureFunction((YogaMeasureFunction) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.transferChildren(this);
            YogaNode yogaNode2 = virtualYogaLayout.getYogaNode();
            YogaNode yogaNode3 = this.mYogaNode;
            yogaNode3.addChildAt(yogaNode2, yogaNode3.getChildCount());
            return;
        }
        super.addView(view, i, layoutParams);
        if (!this.mYogaNodes.containsKey(view)) {
            if (view instanceof YogaLayout) {
                yogaNode = ((YogaLayout) view).getYogaNode();
            } else {
                if (this.mYogaNodes.containsKey(view)) {
                    yogaNode = this.mYogaNodes.get(view);
                } else {
                    yogaNode = YogaNodeFactory.create();
                }
                yogaNode.setData(view);
                yogaNode.setMeasureFunction(new ViewMeasureFunction());
            }
            applyLayoutParams((LayoutParams) view.getLayoutParams(), yogaNode, view);
            this.mYogaNodes.put(view, yogaNode);
            YogaNode yogaNode4 = this.mYogaNode;
            yogaNode4.addChildAt(yogaNode, yogaNode4.getChildCount());
        }
    }

    public void addView(View view, YogaNode yogaNode) {
        this.mYogaNodes.put(view, yogaNode);
        addView(view);
    }

    public void removeView(View view) {
        removeViewFromYogaTree(view, false);
        super.removeView(view);
    }

    public void removeViewAt(int i) {
        removeViewFromYogaTree(getChildAt(i), false);
        super.removeViewAt(i);
    }

    public void removeViewInLayout(View view) {
        removeViewFromYogaTree(view, true);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            removeViewFromYogaTree(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            removeViewFromYogaTree(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            removeViewFromYogaTree(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            removeViewFromYogaTree(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    public void invalidate(View view) {
        if (this.mYogaNodes.containsKey(view)) {
            this.mYogaNodes.get(view).dirty();
            return;
        }
        int childCount = this.mYogaNode.getChildCount();
        for (int i = 0; i < childCount; i++) {
            YogaNode childAt = this.mYogaNode.getChildAt(i);
            if (childAt.getData() instanceof YogaLayout) {
                ((YogaLayout) childAt.getData()).invalidate(view);
            }
        }
        invalidate();
    }

    private void removeViewFromYogaTree(View view, boolean z) {
        YogaNode yogaNode = this.mYogaNodes.get(view);
        if (yogaNode != null) {
            YogaNode owner = yogaNode.getOwner();
            int i = 0;
            while (true) {
                if (i >= owner.getChildCount()) {
                    break;
                } else if (owner.getChildAt(i).equals(yogaNode)) {
                    owner.removeChildAt(i);
                    break;
                } else {
                    i++;
                }
            }
            yogaNode.setData((Object) null);
            this.mYogaNodes.remove(view);
            if (z) {
                this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
            }
        }
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
            } else if (!(view instanceof YogaLayout)) {
                applyLayoutRecursive(yogaNode.getChildAt(i), yogaNode.getLayoutX() + f, yogaNode.getLayoutY() + f2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(View.MeasureSpec.makeMeasureSpec(i3 - i, PictureFileUtils.GB), View.MeasureSpec.makeMeasureSpec(i4 - i2, PictureFileUtils.GB));
        }
        applyLayoutRecursive(this.mYogaNode, 0.0f, 0.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(i, i2);
        }
        setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
    }

    private void createLayout(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.mYogaNode.setHeight((float) size2);
        }
        if (mode == 1073741824) {
            this.mYogaNode.setWidth((float) size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mYogaNode.setMaxHeight((float) size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.mYogaNode.setMaxWidth((float) size);
        }
        this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
    }

    protected static void applyLayoutParams(LayoutParams layoutParams, YogaNode yogaNode, View view) {
        if (Build.VERSION.SDK_INT >= 17 && view.getResources().getConfiguration().getLayoutDirection() == 1) {
            yogaNode.setDirection(YogaDirection.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                yogaNode.setPadding(YogaEdge.LEFT, (float) rect.left);
                yogaNode.setPadding(YogaEdge.TOP, (float) rect.top);
                yogaNode.setPadding(YogaEdge.RIGHT, (float) rect.right);
                yogaNode.setPadding(YogaEdge.BOTTOM, (float) rect.bottom);
            }
        }
        for (int i = 0; i < layoutParams.numericAttributes.size(); i++) {
            int keyAt = layoutParams.numericAttributes.keyAt(i);
            float floatValue = layoutParams.numericAttributes.valueAt(i).floatValue();
            if (keyAt == R.styleable.yoga_yg_alignContent) {
                yogaNode.setAlignContent(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_alignItems) {
                yogaNode.setAlignItems(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_alignSelf) {
                yogaNode.setAlignSelf(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_aspectRatio) {
                yogaNode.setAspectRatio(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderLeft) {
                yogaNode.setBorder(YogaEdge.LEFT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderTop) {
                yogaNode.setBorder(YogaEdge.TOP, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderRight) {
                yogaNode.setBorder(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderBottom) {
                yogaNode.setBorder(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderStart) {
                yogaNode.setBorder(YogaEdge.START, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderEnd) {
                yogaNode.setBorder(YogaEdge.END, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderHorizontal) {
                yogaNode.setBorder(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderVertical) {
                yogaNode.setBorder(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderAll) {
                yogaNode.setBorder(YogaEdge.ALL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_direction) {
                yogaNode.setDirection(YogaDirection.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_display) {
                yogaNode.setDisplay(YogaDisplay.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_flex) {
                yogaNode.setFlex(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_flexBasis) {
                yogaNode.setFlexBasis(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_flexDirection) {
                yogaNode.setFlexDirection(YogaFlexDirection.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_flexGrow) {
                yogaNode.setFlexGrow(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_flexShrink) {
                yogaNode.setFlexShrink(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_height) {
                yogaNode.setHeight(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginLeft) {
                yogaNode.setMargin(YogaEdge.LEFT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_justifyContent) {
                yogaNode.setJustifyContent(YogaJustify.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_marginTop) {
                yogaNode.setMargin(YogaEdge.TOP, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginRight) {
                yogaNode.setMargin(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginBottom) {
                yogaNode.setMargin(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginStart) {
                yogaNode.setMargin(YogaEdge.START, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginEnd) {
                yogaNode.setMargin(YogaEdge.END, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginHorizontal) {
                yogaNode.setMargin(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginVertical) {
                yogaNode.setMargin(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginAll) {
                yogaNode.setMargin(YogaEdge.ALL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_maxHeight) {
                yogaNode.setMaxHeight(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_maxWidth) {
                yogaNode.setMaxWidth(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_minHeight) {
                yogaNode.setMinHeight(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_minWidth) {
                yogaNode.setMinWidth(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_overflow) {
                yogaNode.setOverflow(YogaOverflow.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_paddingLeft) {
                yogaNode.setPadding(YogaEdge.LEFT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingTop) {
                yogaNode.setPadding(YogaEdge.TOP, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingRight) {
                yogaNode.setPadding(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingBottom) {
                yogaNode.setPadding(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingStart) {
                yogaNode.setPadding(YogaEdge.START, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingEnd) {
                yogaNode.setPadding(YogaEdge.END, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingHorizontal) {
                yogaNode.setPadding(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingVertical) {
                yogaNode.setPadding(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingAll) {
                yogaNode.setPadding(YogaEdge.ALL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionLeft) {
                yogaNode.setPosition(YogaEdge.LEFT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionTop) {
                yogaNode.setPosition(YogaEdge.TOP, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionRight) {
                yogaNode.setPosition(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionBottom) {
                yogaNode.setPosition(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionStart) {
                yogaNode.setPosition(YogaEdge.START, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionEnd) {
                yogaNode.setPosition(YogaEdge.END, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionHorizontal) {
                yogaNode.setPosition(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionVertical) {
                yogaNode.setPosition(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionAll) {
                yogaNode.setPosition(YogaEdge.ALL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionType) {
                yogaNode.setPositionType(YogaPositionType.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_width) {
                yogaNode.setWidth(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_wrap) {
                yogaNode.setWrap(YogaWrap.fromInt(Math.round(floatValue)));
            }
        }
        for (int i2 = 0; i2 < layoutParams.stringAttributes.size(); i2++) {
            int keyAt2 = layoutParams.stringAttributes.keyAt(i2);
            String valueAt = layoutParams.stringAttributes.valueAt(i2);
            if (valueAt.equals("auto")) {
                if (keyAt2 == R.styleable.yoga_yg_marginLeft) {
                    yogaNode.setMarginAuto(YogaEdge.LEFT);
                } else if (keyAt2 == R.styleable.yoga_yg_marginTop) {
                    yogaNode.setMarginAuto(YogaEdge.TOP);
                } else if (keyAt2 == R.styleable.yoga_yg_marginRight) {
                    yogaNode.setMarginAuto(YogaEdge.RIGHT);
                } else if (keyAt2 == R.styleable.yoga_yg_marginBottom) {
                    yogaNode.setMarginAuto(YogaEdge.BOTTOM);
                } else if (keyAt2 == R.styleable.yoga_yg_marginStart) {
                    yogaNode.setMarginAuto(YogaEdge.START);
                } else if (keyAt2 == R.styleable.yoga_yg_marginEnd) {
                    yogaNode.setMarginAuto(YogaEdge.END);
                } else if (keyAt2 == R.styleable.yoga_yg_marginHorizontal) {
                    yogaNode.setMarginAuto(YogaEdge.HORIZONTAL);
                } else if (keyAt2 == R.styleable.yoga_yg_marginVertical) {
                    yogaNode.setMarginAuto(YogaEdge.VERTICAL);
                } else if (keyAt2 == R.styleable.yoga_yg_marginAll) {
                    yogaNode.setMarginAuto(YogaEdge.ALL);
                }
            }
            if (valueAt.endsWith("%")) {
                float parseFloat = Float.parseFloat(valueAt.substring(0, valueAt.length() - 1));
                if (keyAt2 == R.styleable.yoga_yg_flexBasis) {
                    yogaNode.setFlexBasisPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_height) {
                    yogaNode.setHeightPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginLeft) {
                    yogaNode.setMarginPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginTop) {
                    yogaNode.setMarginPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginRight) {
                    yogaNode.setMarginPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginBottom) {
                    yogaNode.setMarginPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginStart) {
                    yogaNode.setMarginPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginEnd) {
                    yogaNode.setMarginPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginHorizontal) {
                    yogaNode.setMarginPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginVertical) {
                    yogaNode.setMarginPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginAll) {
                    yogaNode.setMarginPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_maxHeight) {
                    yogaNode.setMaxHeightPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_maxWidth) {
                    yogaNode.setMaxWidthPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_minHeight) {
                    yogaNode.setMinHeightPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_minWidth) {
                    yogaNode.setMinWidthPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingLeft) {
                    yogaNode.setPaddingPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingTop) {
                    yogaNode.setPaddingPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingRight) {
                    yogaNode.setPaddingPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingBottom) {
                    yogaNode.setPaddingPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingStart) {
                    yogaNode.setPaddingPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingEnd) {
                    yogaNode.setPaddingPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingHorizontal) {
                    yogaNode.setPaddingPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingVertical) {
                    yogaNode.setPaddingPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingAll) {
                    yogaNode.setPaddingPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionLeft) {
                    yogaNode.setPositionPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionTop) {
                    yogaNode.setPositionPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionRight) {
                    yogaNode.setPositionPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionBottom) {
                    yogaNode.setPositionPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionStart) {
                    yogaNode.setPositionPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionEnd) {
                    yogaNode.setPositionPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionHorizontal) {
                    yogaNode.setPositionPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionVertical) {
                    yogaNode.setPositionPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionAll) {
                    yogaNode.setPositionPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_width) {
                    yogaNode.setWidthPercent(parseFloat);
                }
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        SparseArray<Float> numericAttributes;
        SparseArray<String> stringAttributes;

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.numericAttributes = layoutParams2.numericAttributes.clone();
                this.stringAttributes = layoutParams2.stringAttributes.clone();
                return;
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf((float) this.width));
            }
            if (layoutParams.height >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf((float) this.height));
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (i >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf((float) i));
            }
            if (i2 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf((float) i2));
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.yoga);
            if (this.width >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf((float) this.width));
            }
            if (this.height >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf((float) this.height));
            }
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(index, typedValue);
                if (typedValue.type == 5) {
                    this.numericAttributes.put(index, Float.valueOf((float) obtainStyledAttributes.getDimensionPixelSize(index, 0)));
                } else if (typedValue.type == 3) {
                    this.stringAttributes.put(index, obtainStyledAttributes.getString(index));
                } else {
                    this.numericAttributes.put(index, Float.valueOf(obtainStyledAttributes.getFloat(index, 0.0f)));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class ViewMeasureFunction implements YogaMeasureFunction {
        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            View view = (View) yogaNode.getData();
            if (view == null || (view instanceof YogaLayout)) {
                return YogaMeasureOutput.make(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f2, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode2)));
            return YogaMeasureOutput.make(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int viewMeasureSpecFromYogaMeasureMode(YogaMeasureMode yogaMeasureMode) {
            if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
                return Target.SIZE_ORIGINAL;
            }
            if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
                return PictureFileUtils.GB;
            }
            return 0;
        }
    }
}
