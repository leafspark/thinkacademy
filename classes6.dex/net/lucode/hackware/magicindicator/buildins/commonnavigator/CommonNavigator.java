package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.NavigatorHelper;
import net.lucode.hackware.magicindicator.R;
import net.lucode.hackware.magicindicator.abs.IPagerNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

public class CommonNavigator extends FrameLayout implements IPagerNavigator, NavigatorHelper.OnNavigatorScrollListener {
    /* access modifiers changed from: private */
    public CommonNavigatorAdapter mAdapter;
    private boolean mAdjustMode;
    private boolean mEnablePivotScroll;
    private boolean mFollowTouch = true;
    private IPagerIndicator mIndicator;
    private LinearLayout mIndicatorContainer;
    private boolean mIndicatorOnTop;
    private int mLeftPadding;
    /* access modifiers changed from: private */
    public NavigatorHelper mNavigatorHelper;
    private DataSetObserver mObserver = new DataSetObserver() {
        public void onInvalidated() {
        }

        public void onChanged() {
            CommonNavigator.this.mNavigatorHelper.setTotalCount(CommonNavigator.this.mAdapter.getCount());
            CommonNavigator.this.init();
        }
    };
    private List<PositionData> mPositionDataList = new ArrayList();
    private boolean mReselectWhenLayout = true;
    private int mRightPadding;
    private float mScrollPivotX = 0.5f;
    private HorizontalScrollView mScrollView;
    private boolean mSkimOver;
    private boolean mSmoothScroll = true;
    private LinearLayout mTitleContainer;

    public void onDetachFromMagicIndicator() {
    }

    public CommonNavigator(Context context) {
        super(context);
        NavigatorHelper navigatorHelper = new NavigatorHelper();
        this.mNavigatorHelper = navigatorHelper;
        navigatorHelper.setNavigatorScrollListener(this);
    }

    public void notifyDataSetChanged() {
        CommonNavigatorAdapter commonNavigatorAdapter = this.mAdapter;
        if (commonNavigatorAdapter != null) {
            commonNavigatorAdapter.notifyDataSetChanged();
        }
    }

    public boolean isAdjustMode() {
        return this.mAdjustMode;
    }

    public void setAdjustMode(boolean z) {
        this.mAdjustMode = z;
    }

    public CommonNavigatorAdapter getAdapter() {
        return this.mAdapter;
    }

    public void setAdapter(CommonNavigatorAdapter commonNavigatorAdapter) {
        CommonNavigatorAdapter commonNavigatorAdapter2 = this.mAdapter;
        if (commonNavigatorAdapter2 != commonNavigatorAdapter) {
            if (commonNavigatorAdapter2 != null) {
                commonNavigatorAdapter2.unregisterDataSetObserver(this.mObserver);
            }
            this.mAdapter = commonNavigatorAdapter;
            if (commonNavigatorAdapter != null) {
                commonNavigatorAdapter.registerDataSetObserver(this.mObserver);
                this.mNavigatorHelper.setTotalCount(this.mAdapter.getCount());
                if (this.mTitleContainer != null) {
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.mNavigatorHelper.setTotalCount(0);
            init();
        }
    }

    /* access modifiers changed from: private */
    public void init() {
        View view;
        removeAllViews();
        if (this.mAdjustMode) {
            LayoutInflater from = LayoutInflater.from(getContext());
            int i = R.layout.pager_navigator_layout_no_scroll;
            view = !(from instanceof LayoutInflater) ? from.inflate(i, this) : XMLParseInstrumentation.inflate(from, i, this);
        } else {
            LayoutInflater from2 = LayoutInflater.from(getContext());
            int i2 = R.layout.pager_navigator_layout;
            view = !(from2 instanceof LayoutInflater) ? from2.inflate(i2, this) : XMLParseInstrumentation.inflate(from2, i2, this);
        }
        this.mScrollView = (HorizontalScrollView) view.findViewById(R.id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.title_container);
        this.mTitleContainer = linearLayout;
        linearLayout.setPadding(this.mLeftPadding, 0, this.mRightPadding, 0);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.indicator_container);
        this.mIndicatorContainer = linearLayout2;
        if (this.mIndicatorOnTop) {
            linearLayout2.getParent().bringChildToFront(this.mIndicatorContainer);
        }
        initTitlesAndIndicator();
    }

    private void initTitlesAndIndicator() {
        LinearLayout.LayoutParams layoutParams;
        int totalCount = this.mNavigatorHelper.getTotalCount();
        for (int i = 0; i < totalCount; i++) {
            IPagerTitleView titleView = this.mAdapter.getTitleView(getContext(), i);
            if (titleView instanceof View) {
                View view = (View) titleView;
                if (this.mAdjustMode) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.mAdapter.getTitleWeight(getContext(), i);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.mTitleContainer.addView(view, layoutParams);
            }
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.mAdapter;
        if (commonNavigatorAdapter != null) {
            IPagerIndicator indicator = commonNavigatorAdapter.getIndicator(getContext());
            this.mIndicator = indicator;
            if (indicator instanceof View) {
                this.mIndicatorContainer.addView((View) this.mIndicator, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            preparePositionData();
            IPagerIndicator iPagerIndicator = this.mIndicator;
            if (iPagerIndicator != null) {
                iPagerIndicator.onPositionDataProvide(this.mPositionDataList);
            }
            if (this.mReselectWhenLayout && this.mNavigatorHelper.getScrollState() == 0) {
                onPageSelected(this.mNavigatorHelper.getCurrentIndex());
                onPageScrolled(this.mNavigatorHelper.getCurrentIndex(), 0.0f, 0);
            }
        }
    }

    private void preparePositionData() {
        this.mPositionDataList.clear();
        int totalCount = this.mNavigatorHelper.getTotalCount();
        for (int i = 0; i < totalCount; i++) {
            PositionData positionData = new PositionData();
            View childAt = this.mTitleContainer.getChildAt(i);
            if (childAt != null) {
                positionData.mLeft = childAt.getLeft();
                positionData.mTop = childAt.getTop();
                positionData.mRight = childAt.getRight();
                positionData.mBottom = childAt.getBottom();
                if (childAt instanceof IMeasurablePagerTitleView) {
                    IMeasurablePagerTitleView iMeasurablePagerTitleView = (IMeasurablePagerTitleView) childAt;
                    positionData.mContentLeft = iMeasurablePagerTitleView.getContentLeft();
                    positionData.mContentTop = iMeasurablePagerTitleView.getContentTop();
                    positionData.mContentRight = iMeasurablePagerTitleView.getContentRight();
                    positionData.mContentBottom = iMeasurablePagerTitleView.getContentBottom();
                } else {
                    positionData.mContentLeft = positionData.mLeft;
                    positionData.mContentTop = positionData.mTop;
                    positionData.mContentRight = positionData.mRight;
                    positionData.mContentBottom = positionData.mBottom;
                }
            }
            this.mPositionDataList.add(positionData);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.mAdapter != null) {
            this.mNavigatorHelper.onPageScrolled(i, f, i2);
            IPagerIndicator iPagerIndicator = this.mIndicator;
            if (iPagerIndicator != null) {
                iPagerIndicator.onPageScrolled(i, f, i2);
            }
            if (this.mScrollView != null && this.mPositionDataList.size() > 0 && i >= 0 && i < this.mPositionDataList.size() && this.mFollowTouch) {
                int min = Math.min(this.mPositionDataList.size() - 1, i);
                int min2 = Math.min(this.mPositionDataList.size() - 1, i + 1);
                float horizontalCenter = ((float) this.mPositionDataList.get(min).horizontalCenter()) - (((float) this.mScrollView.getWidth()) * this.mScrollPivotX);
                this.mScrollView.scrollTo((int) (horizontalCenter + (((((float) this.mPositionDataList.get(min2).horizontalCenter()) - (((float) this.mScrollView.getWidth()) * this.mScrollPivotX)) - horizontalCenter) * f)), 0);
            }
        }
    }

    public float getScrollPivotX() {
        return this.mScrollPivotX;
    }

    public void setScrollPivotX(float f) {
        this.mScrollPivotX = f;
    }

    public void onPageSelected(int i) {
        if (this.mAdapter != null) {
            this.mNavigatorHelper.onPageSelected(i);
            IPagerIndicator iPagerIndicator = this.mIndicator;
            if (iPagerIndicator != null) {
                iPagerIndicator.onPageSelected(i);
            }
        }
    }

    public void onPageScrollStateChanged(int i) {
        if (this.mAdapter != null) {
            this.mNavigatorHelper.onPageScrollStateChanged(i);
            IPagerIndicator iPagerIndicator = this.mIndicator;
            if (iPagerIndicator != null) {
                iPagerIndicator.onPageScrollStateChanged(i);
            }
        }
    }

    public void onAttachToMagicIndicator() {
        init();
    }

    public IPagerIndicator getPagerIndicator() {
        return this.mIndicator;
    }

    public boolean isEnablePivotScroll() {
        return this.mEnablePivotScroll;
    }

    public void setEnablePivotScroll(boolean z) {
        this.mEnablePivotScroll = z;
    }

    public void onEnter(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).onEnter(i, i2, f, z);
            }
        }
    }

    public void onLeave(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).onLeave(i, i2, f, z);
            }
        }
    }

    public boolean isSmoothScroll() {
        return this.mSmoothScroll;
    }

    public void setSmoothScroll(boolean z) {
        this.mSmoothScroll = z;
    }

    public boolean isFollowTouch() {
        return this.mFollowTouch;
    }

    public void setFollowTouch(boolean z) {
        this.mFollowTouch = z;
    }

    public boolean isSkimOver() {
        return this.mSkimOver;
    }

    public void setSkimOver(boolean z) {
        this.mSkimOver = z;
        this.mNavigatorHelper.setSkimOver(z);
    }

    public void onSelected(int i, int i2) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).onSelected(i, i2);
            }
            if (!this.mAdjustMode && !this.mFollowTouch && this.mScrollView != null && this.mPositionDataList.size() > 0) {
                PositionData positionData = this.mPositionDataList.get(Math.min(this.mPositionDataList.size() - 1, i));
                if (this.mEnablePivotScroll) {
                    float horizontalCenter = ((float) positionData.horizontalCenter()) - (((float) this.mScrollView.getWidth()) * this.mScrollPivotX);
                    if (this.mSmoothScroll) {
                        this.mScrollView.smoothScrollTo((int) horizontalCenter, 0);
                    } else {
                        this.mScrollView.scrollTo((int) horizontalCenter, 0);
                    }
                } else if (this.mScrollView.getScrollX() > positionData.mLeft) {
                    if (this.mSmoothScroll) {
                        this.mScrollView.smoothScrollTo(positionData.mLeft, 0);
                    } else {
                        this.mScrollView.scrollTo(positionData.mLeft, 0);
                    }
                } else if (this.mScrollView.getScrollX() + getWidth() >= positionData.mRight) {
                } else {
                    if (this.mSmoothScroll) {
                        this.mScrollView.smoothScrollTo(positionData.mRight - getWidth(), 0);
                    } else {
                        this.mScrollView.scrollTo(positionData.mRight - getWidth(), 0);
                    }
                }
            }
        }
    }

    public void onDeselected(int i, int i2) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).onDeselected(i, i2);
            }
        }
    }

    public IPagerTitleView getPagerTitleView(int i) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout == null) {
            return null;
        }
        return (IPagerTitleView) linearLayout.getChildAt(i);
    }

    public LinearLayout getTitleContainer() {
        return this.mTitleContainer;
    }

    public int getRightPadding() {
        return this.mRightPadding;
    }

    public void setRightPadding(int i) {
        this.mRightPadding = i;
    }

    public int getLeftPadding() {
        return this.mLeftPadding;
    }

    public void setLeftPadding(int i) {
        this.mLeftPadding = i;
    }

    public boolean isIndicatorOnTop() {
        return this.mIndicatorOnTop;
    }

    public void setIndicatorOnTop(boolean z) {
        this.mIndicatorOnTop = z;
    }

    public boolean isReselectWhenLayout() {
        return this.mReselectWhenLayout;
    }

    public void setReselectWhenLayout(boolean z) {
        this.mReselectWhenLayout = z;
    }
}
