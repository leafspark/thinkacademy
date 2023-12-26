package com.wushuangtech.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.HashMap;

public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static HashMap<View, ViewPosition> mMoveCaches = new HashMap<>();

    public interface OnTouchEventCallBack {
        void viewTouchCallBack(boolean z, MotionEvent motionEvent);
    }

    public static boolean inRangeOfView(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getRawX() < ((float) i) || motionEvent.getRawX() > ((float) (i + view.getWidth())) || motionEvent.getRawY() < ((float) i2) || motionEvent.getRawY() > ((float) (i2 + view.getHeight()))) {
            return false;
        }
        return true;
    }

    public static boolean addTouchView(View view, ViewPosition viewPosition) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup instanceof RelativeLayout) {
            viewPosition.mParentType = ViewPosition.PARENT_TYPE_RELATIVELAYOUT;
        } else if (viewGroup instanceof LinearLayout) {
            viewPosition.mParentType = ViewPosition.PARENT_TYPE_LINEARLAYOUT;
        } else if (!(viewGroup instanceof FrameLayout)) {
            return false;
        } else {
            viewPosition.mParentType = ViewPosition.PARENT_TYPE_FRAMELAYOUT;
        }
        mMoveCaches.put(view, viewPosition);
        return true;
    }

    public static void clearTouchView() {
        mMoveCaches.clear();
    }

    public static boolean touchView(View view, MotionEvent motionEvent) {
        ViewPosition viewPosition = mMoveCaches.get(view);
        if (viewPosition != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                viewPosition.initVars(view);
                viewPosition.mLastXLocation = (int) motionEvent.getRawX();
                viewPosition.mLastYLocation = (int) motionEvent.getRawY();
            } else if (action == 2) {
                updateParameters(view, motionEvent);
                viewPosition.mLastXLocation = (int) motionEvent.getRawX();
                viewPosition.mLastYLocation = (int) motionEvent.getRawY();
            } else if (action == 1 && viewPosition.mOnTouchEventCallBack != null) {
                boolean z = false;
                if (Math.abs(viewPosition.mMoveDistanceX) > 10 || Math.abs(viewPosition.mMoveDistanceY) > 10) {
                    z = true;
                }
                viewPosition.mOnTouchEventCallBack.viewTouchCallBack(z, motionEvent);
            }
        }
        return true;
    }

    private static void updateParameters(View view, MotionEvent motionEvent) {
        ViewPosition viewPosition = mMoveCaches.get(view);
        if (viewPosition != null) {
            int[] srcMargin = getSrcMargin(view, viewPosition);
            int i = 0;
            int i2 = srcMargin[0];
            int i3 = srcMargin[1];
            int rawX = (int) (motionEvent.getRawX() - ((float) viewPosition.mLastXLocation));
            int rawY = (int) (motionEvent.getRawY() - ((float) viewPosition.mLastYLocation));
            viewPosition.mMoveDistanceX += rawX;
            viewPosition.mMoveDistanceY += rawY;
            int i4 = i2 + rawX;
            int i5 = i3 + rawY;
            if (i4 < 0) {
                i4 = 0;
            }
            if (i5 >= 0) {
                i = i5;
            }
            if (viewPosition.mViewWidth + i4 + viewPosition.mViewOffsetLeft > viewPosition.mParentWidth) {
                i4 = (viewPosition.mParentWidth - viewPosition.mViewWidth) - viewPosition.mViewOffsetLeft;
            }
            if (viewPosition.mViewHeight + i + viewPosition.mViewOffsetTop > viewPosition.mParentHeight) {
                i = (viewPosition.mParentHeight - viewPosition.mViewHeight) - viewPosition.mViewOffsetTop;
            }
            setTargetLayoutParams(view, viewPosition, i4, i);
        }
    }

    /* access modifiers changed from: private */
    public static int[] getSrcMargin(View view, ViewPosition viewPosition) {
        int[] iArr = new int[2];
        if (viewPosition.mParentType == ViewPosition.PARENT_TYPE_FRAMELAYOUT) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            iArr[0] = layoutParams.leftMargin;
            iArr[1] = layoutParams.topMargin;
        } else if (viewPosition.mParentType == ViewPosition.PARENT_TYPE_LINEARLAYOUT) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            iArr[0] = layoutParams2.leftMargin;
            iArr[1] = layoutParams2.topMargin;
        } else if (viewPosition.mParentType == ViewPosition.PARENT_TYPE_RELATIVELAYOUT) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            iArr[0] = layoutParams3.leftMargin;
            iArr[1] = layoutParams3.topMargin;
        }
        return iArr;
    }

    private static void setTargetLayoutParams(View view, ViewPosition viewPosition, int i, int i2) {
        if (viewPosition.mParentType == ViewPosition.PARENT_TYPE_FRAMELAYOUT) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
            view.setLayoutParams(layoutParams);
        } else if (viewPosition.mParentType == ViewPosition.PARENT_TYPE_LINEARLAYOUT) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.leftMargin = i;
            layoutParams2.topMargin = i2;
            view.setLayoutParams(layoutParams2);
        } else if (viewPosition.mParentType == ViewPosition.PARENT_TYPE_RELATIVELAYOUT) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.leftMargin = i;
            layoutParams3.topMargin = i2;
            view.setLayoutParams(layoutParams3);
        }
    }

    public static class ViewPosition {
        static int PARENT_TYPE_FRAMELAYOUT = 3;
        static int PARENT_TYPE_LINEARLAYOUT = 1;
        static int PARENT_TYPE_RELATIVELAYOUT = 2;
        boolean mIsInit;
        int mLastXLocation;
        int mLastYLocation;
        int mMoveDistanceX;
        int mMoveDistanceY;
        public OnTouchEventCallBack mOnTouchEventCallBack;
        int mParentHeight;
        int mParentType;
        int mParentWidth;
        int mViewHeight;
        int mViewOffsetLeft;
        int mViewOffsetTop;
        int mViewWidth;

        /* access modifiers changed from: package-private */
        public void initVars(View view) {
            this.mViewWidth = view.getMeasuredWidth();
            this.mViewHeight = view.getMeasuredHeight();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            this.mParentWidth = viewGroup.getWidth();
            this.mParentHeight = viewGroup.getHeight();
            this.mMoveDistanceX = 0;
            this.mMoveDistanceY = 0;
            int[] access$000 = ViewUtils.getSrcMargin(view, this);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mViewOffsetLeft = iArr[0] - access$000[0];
            this.mViewOffsetTop = iArr[1] - access$000[1];
        }

        public String toString() {
            return "ViewPosition{mIsInit=" + this.mIsInit + ", mParentType=" + this.mParentType + ", mLastXLocation=" + this.mLastXLocation + ", mLastYLocation=" + this.mLastYLocation + ", mParentWidth=" + this.mParentWidth + ", mParentHeight=" + this.mParentHeight + ", mViewWidth=" + this.mViewWidth + ", mViewHeight=" + this.mViewHeight + '}';
        }
    }
}
