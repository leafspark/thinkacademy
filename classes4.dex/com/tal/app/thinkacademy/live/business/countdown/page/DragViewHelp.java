package com.tal.app.thinkacademy.live.business.countdown.page;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;

public class DragViewHelp {
    private static float maxLocalZ = -1.0f;
    private boolean isFirst = true;
    private float left;
    private float localX;
    private float localY;
    private float localZ;
    private float moveX;
    private float moveY;
    private boolean onlyDrag = true;
    private ViewGroup parent;
    private float right;
    private float top;
    private View view;

    private void showXYZ(String str) {
    }

    public DragViewHelp(View view2, boolean z, float f, float f2, float f3) {
        this.view = view2;
        this.onlyDrag = z;
        this.left = f;
        this.right = f2;
        this.top = f3;
        view2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                DragViewHelp.this.initXYZ();
            }
        });
        view2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return DragViewHelp.this.onTouchEvent(view, motionEvent);
            }
        });
        ViewParent parent2 = view2.getParent();
        if (parent2 instanceof ViewGroup) {
            this.parent = (ViewGroup) parent2;
        }
    }

    /* access modifiers changed from: private */
    public void initXYZ() {
        if (this.isFirst) {
            this.localX = this.view.getX();
            this.localY = this.view.getY();
            this.localZ = this.view.getZ();
            this.isFirst = false;
            getMaxZ();
        }
    }

    private void getMaxZ() {
        if (maxLocalZ < 0.0f) {
            ViewParent parent2 = this.view.getParent();
            if (parent2 instanceof ViewGroup) {
                this.parent = (ViewGroup) parent2;
            }
            if (this.parent != null) {
                for (int i = 0; i < this.parent.getChildCount(); i++) {
                    float z = this.parent.getChildAt(i).getZ();
                    if (z > maxLocalZ) {
                        maxLocalZ = z;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean onTouchEvent(View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.moveX = motionEvent.getX() + this.localX;
            this.moveY = motionEvent.getY() + this.localY;
            view2.setZ(maxLocalZ + 0.1f);
            showXYZ("onTouchEvent");
        } else if (action == 1) {
            view2.setZ(this.localZ);
        } else if (action == 2) {
            float x = motionEvent.getX() - this.moveX;
            float y = motionEvent.getY() - this.moveY;
            if (view2.getX() + x < 0.0f) {
                view2.setTranslationX(Math.max(view2.getX() + x, -this.left));
            } else {
                view2.setTranslationX(Math.min(view2.getX() + x, this.left));
            }
            if (view2.getY() + y > 0.0f) {
                view2.setTranslationY(Math.min(view2.getY() + y, this.top));
            } else {
                view2.setTranslationY(Math.max(view2.getY() + y, 0.0f));
            }
        }
        return this.onlyDrag;
    }

    public static void setDragger(View view2, boolean z, float f, float f2, float f3) {
        new DragViewHelp(view2, z, f, f2, f3);
    }

    private void setViewSize(View view2, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view2.setLayoutParams(layoutParams);
    }

    private void reset() {
        this.view.setX(this.localX);
        this.view.setY(this.localY);
        this.view.setZ(this.localZ);
    }

    public void reInit() {
        this.isFirst = true;
        initXYZ();
    }
}
