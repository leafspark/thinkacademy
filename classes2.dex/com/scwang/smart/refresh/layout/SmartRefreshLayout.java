package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.api.RefreshContent;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.DimensionStatus;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.kernel.R;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshInitializer;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnMultiListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;
import com.scwang.smart.refresh.layout.util.SmartUtil;
import com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper;

public class SmartRefreshLayout extends ViewGroup implements RefreshLayout, NestedScrollingParent {
    protected static ViewGroup.MarginLayoutParams sDefaultMarginLP = new ViewGroup.MarginLayoutParams(-1, -1);
    protected static DefaultRefreshFooterCreator sFooterCreator;
    protected static DefaultRefreshHeaderCreator sHeaderCreator;
    protected static DefaultRefreshInitializer sRefreshInitializer;
    protected Runnable animationRunnable;
    protected boolean mAttachedToWindow;
    protected int mCurrentVelocity;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableDisallowIntercept;
    protected boolean mEnableFooterFollowWhenNoMoreData;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
    protected boolean mEnableNestedScrolling;
    protected boolean mEnableOverScrollBounce;
    protected boolean mEnableOverScrollDrag;
    protected boolean mEnablePreviewInEditMode;
    protected boolean mEnablePureScrollMode;
    protected boolean mEnableRefresh;
    protected boolean mEnableScrollContentWhenLoaded;
    protected boolean mEnableScrollContentWhenRefreshed;
    protected MotionEvent mFalsifyEvent;
    protected int mFixedFooterViewId;
    protected int mFixedHeaderViewId;
    protected int mFloorDuration;
    protected int mFooterBackgroundColor;
    protected int mFooterHeight;
    protected DimensionStatus mFooterHeightStatus;
    protected int mFooterInsetStart;
    protected boolean mFooterLocked;
    protected float mFooterMaxDragRate;
    protected boolean mFooterNeedTouchEventWhenLoading;
    protected boolean mFooterNoMoreData;
    protected boolean mFooterNoMoreDataEffective;
    protected int mFooterTranslationViewId;
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected DimensionStatus mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected int mHeaderTranslationViewId;
    protected float mHeaderTriggerRate;
    protected boolean mIsBeingDragged;
    protected RefreshKernel mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected OnLoadMoreListener mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected int mMaximumVelocity;
    protected int mMinimumVelocity;
    protected NestedScrollingChildHelper mNestedChild;
    protected boolean mNestedInProgress;
    protected NestedScrollingParentHelper mNestedParent;
    protected OnMultiListener mOnMultiListener;
    protected Paint mPaint;
    protected int[] mParentOffsetInWindow;
    protected int[] mPrimaryColors;
    protected int mReboundDuration;
    protected Interpolator mReboundInterpolator;
    protected RefreshContent mRefreshContent;
    protected RefreshComponent mRefreshFooter;
    protected RefreshComponent mRefreshHeader;
    protected OnRefreshListener mRefreshListener;
    protected int mScreenHeightPixels;
    protected ScrollBoundaryDecider mScrollBoundaryDecider;
    protected Scroller mScroller;
    protected int mSpinner;
    protected RefreshState mState;
    protected boolean mSuperDispatchTouchEvent;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected float mTwoLevelBottomPullUpToCloseRate;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected RefreshState mViceState;
    protected ValueAnimator reboundAnimator;

    public ViewGroup getLayout() {
        return this;
    }

    public SmartRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFloorDuration = 300;
        this.mReboundDuration = 300;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mFixedHeaderViewId = -1;
        this.mFixedFooterViewId = -1;
        this.mHeaderTranslationViewId = -1;
        this.mFooterTranslationViewId = -1;
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenNoMoreData = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mEnableNestedScrolling = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mFooterNoMoreDataEffective = false;
        this.mManualLoadMore = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mParentOffsetInWindow = new int[2];
        this.mNestedChild = new NestedScrollingChildHelper(this);
        this.mNestedParent = new NestedScrollingParentHelper(this);
        this.mHeaderHeightStatus = DimensionStatus.DefaultUnNotify;
        this.mFooterHeightStatus = DimensionStatus.DefaultUnNotify;
        this.mHeaderMaxDragRate = 2.5f;
        this.mFooterMaxDragRate = 2.5f;
        this.mHeaderTriggerRate = 1.0f;
        this.mFooterTriggerRate = 1.0f;
        this.mTwoLevelBottomPullUpToCloseRate = 0.16666667f;
        this.mKernel = new RefreshKernelImpl();
        this.mState = RefreshState.None;
        this.mViceState = RefreshState.None;
        this.mLastOpenTime = 0;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = context.getResources().getDisplayMetrics().heightPixels;
        this.mReboundInterpolator = new SmartUtil(SmartUtil.INTERPOLATOR_VISCOUS_FLUID);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterHeight = SmartUtil.dp2px(60.0f);
        this.mHeaderHeight = SmartUtil.dp2px(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        DefaultRefreshInitializer defaultRefreshInitializer = sRefreshInitializer;
        if (defaultRefreshInitializer != null) {
            defaultRefreshInitializer.initialize(context, this);
        }
        this.mDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        this.mEnableLoadMore = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.mEnableLoadMore);
        this.mHeaderHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.mHeaderHeight);
        this.mFooterHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.mFooterHeight);
        this.mHeaderInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.mHeaderInsetStart);
        this.mFooterInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.mFooterInsetStart);
        this.mDisableContentWhenRefresh = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        this.mEnableHeaderTranslationContent = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.mEnableHeaderTranslationContent);
        this.mEnableFooterTranslationContent = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        this.mEnableFooterFollowWhenNoMoreData = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableFooterFollowWhenNoMoreData = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableClipHeaderWhenFixedBehind = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        this.mEnableOverScrollDrag = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.mFixedHeaderViewId);
        this.mFixedFooterViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.mFixedFooterViewId);
        this.mHeaderTranslationViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.mHeaderTranslationViewId);
        this.mFooterTranslationViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.mFooterTranslationViewId);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.mEnableNestedScrolling);
        this.mEnableNestedScrolling = z;
        this.mNestedChild.setNestedScrollingEnabled(z);
        this.mManualLoadMore = this.mManualLoadMore || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.mManualHeaderTranslationContent = this.mManualHeaderTranslationContent || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.mManualFooterTranslationContent = this.mManualFooterTranslationContent || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.mHeaderHeightStatus = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight) ? DimensionStatus.XmlLayoutUnNotify : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight) ? DimensionStatus.XmlLayoutUnNotify : this.mFooterHeightStatus;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        if (this.mEnablePureScrollMode && !this.mManualLoadMore && !this.mEnableLoadMore) {
            this.mEnableLoadMore = true;
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFinishInflate() {
        /*
            r11 = this;
            super.onFinishInflate()
            int r0 = super.getChildCount()
            r1 = 3
            if (r0 > r1) goto L_0x009e
            r2 = -1
            r3 = 0
            r5 = r2
            r4 = r3
            r6 = r4
        L_0x000f:
            r7 = 2
            r8 = 1
            if (r4 >= r0) goto L_0x0033
            android.view.View r9 = super.getChildAt(r4)
            boolean r10 = com.scwang.smart.refresh.layout.util.SmartUtil.isContentView(r9)
            if (r10 == 0) goto L_0x0024
            if (r6 < r7) goto L_0x0021
            if (r4 != r8) goto L_0x0024
        L_0x0021:
            r5 = r4
            r6 = r7
            goto L_0x0030
        L_0x0024:
            boolean r7 = r9 instanceof com.scwang.smart.refresh.layout.api.RefreshComponent
            if (r7 != 0) goto L_0x0030
            if (r6 >= r8) goto L_0x0030
            if (r4 <= 0) goto L_0x002e
            r6 = r8
            goto L_0x002f
        L_0x002e:
            r6 = r3
        L_0x002f:
            r5 = r4
        L_0x0030:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0033:
            if (r5 < 0) goto L_0x004d
            com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper r4 = new com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper
            android.view.View r6 = super.getChildAt(r5)
            r4.<init>(r6)
            r11.mRefreshContent = r4
            if (r5 != r8) goto L_0x0048
            if (r0 != r1) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r7 = r2
        L_0x0046:
            r1 = r3
            goto L_0x004f
        L_0x0048:
            if (r0 != r7) goto L_0x004d
            r1 = r2
            r7 = r8
            goto L_0x004f
        L_0x004d:
            r1 = r2
            r7 = r1
        L_0x004f:
            r4 = r3
        L_0x0050:
            if (r4 >= r0) goto L_0x009d
            android.view.View r5 = super.getChildAt(r4)
            if (r4 == r1) goto L_0x008b
            if (r4 == r7) goto L_0x0065
            if (r1 != r2) goto L_0x0065
            com.scwang.smart.refresh.layout.api.RefreshComponent r6 = r11.mRefreshHeader
            if (r6 != 0) goto L_0x0065
            boolean r6 = r5 instanceof com.scwang.smart.refresh.layout.api.RefreshHeader
            if (r6 == 0) goto L_0x0065
            goto L_0x008b
        L_0x0065:
            if (r4 == r7) goto L_0x006d
            if (r7 != r2) goto L_0x009a
            boolean r6 = r5 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
            if (r6 == 0) goto L_0x009a
        L_0x006d:
            boolean r6 = r11.mEnableLoadMore
            if (r6 != 0) goto L_0x0078
            boolean r6 = r11.mManualLoadMore
            if (r6 != 0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r6 = r3
            goto L_0x0079
        L_0x0078:
            r6 = r8
        L_0x0079:
            r11.mEnableLoadMore = r6
            boolean r6 = r5 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
            if (r6 == 0) goto L_0x0082
            com.scwang.smart.refresh.layout.api.RefreshFooter r5 = (com.scwang.smart.refresh.layout.api.RefreshFooter) r5
            goto L_0x0088
        L_0x0082:
            com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper r6 = new com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper
            r6.<init>(r5)
            r5 = r6
        L_0x0088:
            r11.mRefreshFooter = r5
            goto L_0x009a
        L_0x008b:
            boolean r6 = r5 instanceof com.scwang.smart.refresh.layout.api.RefreshHeader
            if (r6 == 0) goto L_0x0092
            com.scwang.smart.refresh.layout.api.RefreshHeader r5 = (com.scwang.smart.refresh.layout.api.RefreshHeader) r5
            goto L_0x0098
        L_0x0092:
            com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper r6 = new com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper
            r6.<init>(r5)
            r5 = r6
        L_0x0098:
            r11.mRefreshHeader = r5
        L_0x009a:
            int r4 = r4 + 1
            goto L_0x0050
        L_0x009d:
            return
        L_0x009e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        RefreshComponent refreshComponent;
        DefaultRefreshHeaderCreator defaultRefreshHeaderCreator;
        super.onAttachedToWindow();
        boolean z = true;
        this.mAttachedToWindow = true;
        if (!isInEditMode()) {
            if (this.mRefreshHeader == null && (defaultRefreshHeaderCreator = sHeaderCreator) != null) {
                RefreshHeader createRefreshHeader = defaultRefreshHeaderCreator.createRefreshHeader(getContext(), this);
                if (createRefreshHeader != null) {
                    setRefreshHeader(createRefreshHeader);
                } else {
                    throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
                }
            }
            if (this.mRefreshFooter == null) {
                DefaultRefreshFooterCreator defaultRefreshFooterCreator = sFooterCreator;
                if (defaultRefreshFooterCreator != null) {
                    RefreshFooter createRefreshFooter = defaultRefreshFooterCreator.createRefreshFooter(getContext(), this);
                    if (createRefreshFooter != null) {
                        setRefreshFooter(createRefreshFooter);
                    } else {
                        throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
                    }
                }
            } else {
                if (!this.mEnableLoadMore && this.mManualLoadMore) {
                    z = false;
                }
                this.mEnableLoadMore = z;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RefreshComponent refreshComponent2 = this.mRefreshHeader;
                    if ((refreshComponent2 == null || childAt != refreshComponent2.getView()) && ((refreshComponent = this.mRefreshFooter) == null || childAt != refreshComponent.getView())) {
                        this.mRefreshContent = new RefreshContentWrapper(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int dp2px = SmartUtil.dp2px(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                RefreshContentWrapper refreshContentWrapper = new RefreshContentWrapper(textView);
                this.mRefreshContent = refreshContentWrapper;
                refreshContentWrapper.getView().setPadding(dp2px, dp2px, dp2px, dp2px);
            }
            View findViewById = findViewById(this.mFixedHeaderViewId);
            View findViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, findViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                RefreshContent refreshContent = this.mRefreshContent;
                this.mSpinner = 0;
                refreshContent.moveSpinner(0, this.mHeaderTranslationViewId, this.mFooterTranslationViewId);
            }
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null) {
            RefreshComponent refreshComponent3 = this.mRefreshHeader;
            if (refreshComponent3 != null) {
                refreshComponent3.setPrimaryColors(iArr);
            }
            RefreshComponent refreshComponent4 = this.mRefreshFooter;
            if (refreshComponent4 != null) {
                refreshComponent4.setPrimaryColors(this.mPrimaryColors);
            }
        }
        RefreshContent refreshContent2 = this.mRefreshContent;
        if (refreshContent2 != null) {
            super.bringChildToFront(refreshContent2.getView());
        }
        RefreshComponent refreshComponent5 = this.mRefreshHeader;
        if (refreshComponent5 != null && refreshComponent5.getSpinnerStyle().front) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        RefreshComponent refreshComponent6 = this.mRefreshFooter;
        if (refreshComponent6 != null && refreshComponent6.getSpinnerStyle().front) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0215  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r17.isInEditMode()
            if (r3 == 0) goto L_0x0012
            boolean r3 = r0.mEnablePreviewInEditMode
            if (r3 == 0) goto L_0x0012
            r3 = 1
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            int r6 = super.getChildCount()
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x001a:
            if (r7 >= r6) goto L_0x032d
            android.view.View r10 = super.getChildAt(r7)
            int r11 = r10.getVisibility()
            r12 = 8
            if (r11 == r12) goto L_0x0329
            int r11 = com.scwang.smart.refresh.layout.kernel.R.id.srl_tag
            java.lang.Object r11 = r10.getTag(r11)
            java.lang.String r12 = "GONE"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L_0x0038
            goto L_0x0329
        L_0x0038:
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.mRefreshHeader
            if (r11 == 0) goto L_0x015d
            android.view.View r11 = r11.getView()
            if (r11 != r10) goto L_0x015d
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.mRefreshHeader
            android.view.View r11 = r11.getView()
            android.view.ViewGroup$LayoutParams r12 = r11.getLayoutParams()
            boolean r14 = r12 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r14 == 0) goto L_0x0054
            r14 = r12
            android.view.ViewGroup$MarginLayoutParams r14 = (android.view.ViewGroup.MarginLayoutParams) r14
            goto L_0x0056
        L_0x0054:
            android.view.ViewGroup$MarginLayoutParams r14 = sDefaultMarginLP
        L_0x0056:
            int r4 = r14.leftMargin
            int r13 = r14.rightMargin
            int r4 = r4 + r13
            int r13 = r12.width
            int r4 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r13)
            int r13 = r0.mHeaderHeight
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.mHeaderHeightStatus
            int r5 = r5.ordinal
            com.scwang.smart.refresh.layout.constant.DimensionStatus r15 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlLayoutUnNotify
            int r15 = r15.ordinal
            if (r5 >= r15) goto L_0x00df
            int r5 = r12.height
            if (r5 <= 0) goto L_0x0093
            int r5 = r12.height
            int r13 = r14.bottomMargin
            int r5 = r5 + r13
            int r13 = r14.topMargin
            int r5 = r5 + r13
            com.scwang.smart.refresh.layout.constant.DimensionStatus r13 = r0.mHeaderHeightStatus
            com.scwang.smart.refresh.layout.constant.DimensionStatus r15 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlExactUnNotify
            boolean r13 = r13.canReplaceWith(r15)
            if (r13 == 0) goto L_0x0091
            int r12 = r12.height
            int r13 = r14.bottomMargin
            int r12 = r12 + r13
            int r13 = r14.topMargin
            int r12 = r12 + r13
            r0.mHeaderHeight = r12
            com.scwang.smart.refresh.layout.constant.DimensionStatus r12 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlExactUnNotify
            r0.mHeaderHeightStatus = r12
        L_0x0091:
            r13 = r5
            goto L_0x00df
        L_0x0093:
            int r5 = r12.height
            r12 = -2
            if (r5 != r12) goto L_0x00df
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshHeader
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = r5.getSpinnerStyle()
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r12 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.MatchLayout
            if (r5 != r12) goto L_0x00a8
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.mHeaderHeightStatus
            boolean r5 = r5.notified
            if (r5 != 0) goto L_0x00df
        L_0x00a8:
            int r5 = android.view.View.MeasureSpec.getSize(r19)
            int r12 = r14.bottomMargin
            int r5 = r5 - r12
            int r12 = r14.topMargin
            int r5 = r5 - r12
            r12 = 0
            int r5 = java.lang.Math.max(r5, r12)
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r12)
            r11.measure(r4, r15)
            int r12 = r11.getMeasuredHeight()
            if (r12 <= 0) goto L_0x00df
            if (r12 == r5) goto L_0x00de
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.mHeaderHeightStatus
            com.scwang.smart.refresh.layout.constant.DimensionStatus r13 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlWrapUnNotify
            boolean r5 = r5.canReplaceWith(r13)
            if (r5 == 0) goto L_0x00de
            int r5 = r14.bottomMargin
            int r12 = r12 + r5
            int r5 = r14.topMargin
            int r12 = r12 + r5
            r0.mHeaderHeight = r12
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlWrapUnNotify
            r0.mHeaderHeightStatus = r5
        L_0x00de:
            r13 = -1
        L_0x00df:
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshHeader
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = r5.getSpinnerStyle()
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r12 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.MatchLayout
            if (r5 != r12) goto L_0x00f0
            int r13 = android.view.View.MeasureSpec.getSize(r19)
            r5 = -1
            r12 = 0
            goto L_0x0110
        L_0x00f0:
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshHeader
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = r5.getSpinnerStyle()
            boolean r5 = r5.scale
            if (r5 == 0) goto L_0x010e
            if (r3 != 0) goto L_0x010e
            boolean r5 = r0.mEnableRefresh
            boolean r5 = r0.isEnableRefreshOrLoadMore(r5)
            if (r5 == 0) goto L_0x0107
            int r5 = r0.mSpinner
            goto L_0x0108
        L_0x0107:
            r5 = 0
        L_0x0108:
            r12 = 0
            int r13 = java.lang.Math.max(r12, r5)
            goto L_0x010f
        L_0x010e:
            r12 = 0
        L_0x010f:
            r5 = -1
        L_0x0110:
            if (r13 == r5) goto L_0x0125
            int r5 = r14.bottomMargin
            int r13 = r13 - r5
            int r5 = r14.topMargin
            int r13 = r13 - r5
            int r5 = java.lang.Math.max(r13, r12)
            r12 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r12)
            r11.measure(r4, r5)
        L_0x0125:
            com.scwang.smart.refresh.layout.constant.DimensionStatus r4 = r0.mHeaderHeightStatus
            boolean r4 = r4.notified
            if (r4 != 0) goto L_0x0149
            float r4 = r0.mHeaderMaxDragRate
            r5 = 1092616192(0x41200000, float:10.0)
            int r12 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r12 >= 0) goto L_0x0137
            int r5 = r0.mHeaderHeight
            float r5 = (float) r5
            float r4 = r4 * r5
        L_0x0137:
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.mHeaderHeightStatus
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r5.notified()
            r0.mHeaderHeightStatus = r5
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshHeader
            com.scwang.smart.refresh.layout.api.RefreshKernel r12 = r0.mKernel
            int r13 = r0.mHeaderHeight
            int r4 = (int) r4
            r5.onInitialized(r12, r13, r4)
        L_0x0149:
            if (r3 == 0) goto L_0x015d
            boolean r4 = r0.mEnableRefresh
            boolean r4 = r0.isEnableRefreshOrLoadMore(r4)
            if (r4 == 0) goto L_0x015d
            int r4 = r11.getMeasuredWidth()
            int r8 = r8 + r4
            int r4 = r11.getMeasuredHeight()
            int r9 = r9 + r4
        L_0x015d:
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r0.mRefreshFooter
            if (r4 == 0) goto L_0x0282
            android.view.View r4 = r4.getView()
            if (r4 != r10) goto L_0x0282
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r0.mRefreshFooter
            android.view.View r4 = r4.getView()
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            boolean r11 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r11 == 0) goto L_0x0179
            r11 = r5
            android.view.ViewGroup$MarginLayoutParams r11 = (android.view.ViewGroup.MarginLayoutParams) r11
            goto L_0x017b
        L_0x0179:
            android.view.ViewGroup$MarginLayoutParams r11 = sDefaultMarginLP
        L_0x017b:
            int r12 = r11.leftMargin
            int r13 = r11.rightMargin
            int r12 = r12 + r13
            int r13 = r5.width
            int r12 = android.view.ViewGroup.getChildMeasureSpec(r1, r12, r13)
            int r13 = r0.mFooterHeight
            com.scwang.smart.refresh.layout.constant.DimensionStatus r14 = r0.mFooterHeightStatus
            int r14 = r14.ordinal
            com.scwang.smart.refresh.layout.constant.DimensionStatus r15 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlLayoutUnNotify
            int r15 = r15.ordinal
            if (r14 >= r15) goto L_0x0204
            int r14 = r5.height
            if (r14 <= 0) goto L_0x01b7
            int r13 = r5.height
            int r14 = r11.topMargin
            int r13 = r13 + r14
            int r14 = r11.bottomMargin
            int r13 = r13 + r14
            com.scwang.smart.refresh.layout.constant.DimensionStatus r14 = r0.mFooterHeightStatus
            com.scwang.smart.refresh.layout.constant.DimensionStatus r15 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlExactUnNotify
            boolean r14 = r14.canReplaceWith(r15)
            if (r14 == 0) goto L_0x0204
            int r5 = r5.height
            int r14 = r11.topMargin
            int r5 = r5 + r14
            int r14 = r11.bottomMargin
            int r5 = r5 + r14
            r0.mFooterHeight = r5
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlExactUnNotify
            r0.mFooterHeightStatus = r5
            goto L_0x0204
        L_0x01b7:
            int r5 = r5.height
            r14 = -2
            if (r5 != r14) goto L_0x0204
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshFooter
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = r5.getSpinnerStyle()
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r14 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.MatchLayout
            if (r5 != r14) goto L_0x01cc
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.mFooterHeightStatus
            boolean r5 = r5.notified
            if (r5 != 0) goto L_0x0204
        L_0x01cc:
            int r5 = android.view.View.MeasureSpec.getSize(r19)
            int r14 = r11.bottomMargin
            int r5 = r5 - r14
            int r14 = r11.topMargin
            int r5 = r5 - r14
            r14 = 0
            int r5 = java.lang.Math.max(r5, r14)
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r14)
            r4.measure(r12, r14)
            int r14 = r4.getMeasuredHeight()
            if (r14 <= 0) goto L_0x0204
            if (r14 == r5) goto L_0x0202
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.mFooterHeightStatus
            com.scwang.smart.refresh.layout.constant.DimensionStatus r13 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlWrapUnNotify
            boolean r5 = r5.canReplaceWith(r13)
            if (r5 == 0) goto L_0x0202
            int r5 = r11.topMargin
            int r14 = r14 + r5
            int r5 = r11.bottomMargin
            int r14 = r14 + r5
            r0.mFooterHeight = r14
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = com.scwang.smart.refresh.layout.constant.DimensionStatus.XmlWrapUnNotify
            r0.mFooterHeightStatus = r5
        L_0x0202:
            r5 = -1
            goto L_0x0205
        L_0x0204:
            r5 = r13
        L_0x0205:
            com.scwang.smart.refresh.layout.api.RefreshComponent r13 = r0.mRefreshFooter
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r13 = r13.getSpinnerStyle()
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r14 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.MatchLayout
            if (r13 != r14) goto L_0x0215
            int r5 = android.view.View.MeasureSpec.getSize(r19)
        L_0x0213:
            r13 = 0
            goto L_0x0233
        L_0x0215:
            com.scwang.smart.refresh.layout.api.RefreshComponent r13 = r0.mRefreshFooter
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r13 = r13.getSpinnerStyle()
            boolean r13 = r13.scale
            if (r13 == 0) goto L_0x0213
            if (r3 != 0) goto L_0x0213
            boolean r5 = r0.mEnableLoadMore
            boolean r5 = r0.isEnableRefreshOrLoadMore(r5)
            if (r5 == 0) goto L_0x022d
            int r5 = r0.mSpinner
            int r5 = -r5
            goto L_0x022e
        L_0x022d:
            r5 = 0
        L_0x022e:
            r13 = 0
            int r5 = java.lang.Math.max(r13, r5)
        L_0x0233:
            r14 = -1
            if (r5 == r14) goto L_0x0249
            int r14 = r11.bottomMargin
            int r5 = r5 - r14
            int r11 = r11.topMargin
            int r5 = r5 - r11
            int r5 = java.lang.Math.max(r5, r13)
            r11 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r11)
            r4.measure(r12, r5)
        L_0x0249:
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.mFooterHeightStatus
            boolean r5 = r5.notified
            if (r5 != 0) goto L_0x026d
            float r5 = r0.mFooterMaxDragRate
            r11 = 1092616192(0x41200000, float:10.0)
            int r11 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x025b
            int r11 = r0.mFooterHeight
            float r11 = (float) r11
            float r5 = r5 * r11
        L_0x025b:
            com.scwang.smart.refresh.layout.constant.DimensionStatus r11 = r0.mFooterHeightStatus
            com.scwang.smart.refresh.layout.constant.DimensionStatus r11 = r11.notified()
            r0.mFooterHeightStatus = r11
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.mRefreshFooter
            com.scwang.smart.refresh.layout.api.RefreshKernel r12 = r0.mKernel
            int r14 = r0.mFooterHeight
            int r5 = (int) r5
            r11.onInitialized(r12, r14, r5)
        L_0x026d:
            if (r3 == 0) goto L_0x0283
            boolean r5 = r0.mEnableLoadMore
            boolean r5 = r0.isEnableRefreshOrLoadMore(r5)
            if (r5 == 0) goto L_0x0283
            int r5 = r4.getMeasuredWidth()
            int r8 = r8 + r5
            int r4 = r4.getMeasuredHeight()
            int r9 = r9 + r4
            goto L_0x0283
        L_0x0282:
            r13 = 0
        L_0x0283:
            com.scwang.smart.refresh.layout.api.RefreshContent r4 = r0.mRefreshContent
            if (r4 == 0) goto L_0x0329
            android.view.View r4 = r4.getView()
            if (r4 != r10) goto L_0x0329
            com.scwang.smart.refresh.layout.api.RefreshContent r4 = r0.mRefreshContent
            android.view.View r4 = r4.getView()
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            boolean r10 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r10 == 0) goto L_0x029f
            r10 = r5
            android.view.ViewGroup$MarginLayoutParams r10 = (android.view.ViewGroup.MarginLayoutParams) r10
            goto L_0x02a1
        L_0x029f:
            android.view.ViewGroup$MarginLayoutParams r10 = sDefaultMarginLP
        L_0x02a1:
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.mRefreshHeader
            if (r11 == 0) goto L_0x02b9
            boolean r11 = r0.mEnableRefresh
            boolean r11 = r0.isEnableRefreshOrLoadMore(r11)
            if (r11 == 0) goto L_0x02b9
            boolean r11 = r0.mEnableHeaderTranslationContent
            com.scwang.smart.refresh.layout.api.RefreshComponent r12 = r0.mRefreshHeader
            boolean r11 = r0.isEnableTranslationContent(r11, r12)
            if (r11 == 0) goto L_0x02b9
            r12 = 1
            goto L_0x02ba
        L_0x02b9:
            r12 = r13
        L_0x02ba:
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.mRefreshFooter
            if (r11 == 0) goto L_0x02d2
            boolean r11 = r0.mEnableLoadMore
            boolean r11 = r0.isEnableRefreshOrLoadMore(r11)
            if (r11 == 0) goto L_0x02d2
            boolean r11 = r0.mEnableFooterTranslationContent
            com.scwang.smart.refresh.layout.api.RefreshComponent r14 = r0.mRefreshFooter
            boolean r11 = r0.isEnableTranslationContent(r11, r14)
            if (r11 == 0) goto L_0x02d2
            r11 = 1
            goto L_0x02d3
        L_0x02d2:
            r11 = r13
        L_0x02d3:
            int r14 = r17.getPaddingLeft()
            int r15 = r17.getPaddingRight()
            int r14 = r14 + r15
            int r15 = r10.leftMargin
            int r14 = r14 + r15
            int r15 = r10.rightMargin
            int r14 = r14 + r15
            int r15 = r5.width
            int r14 = android.view.ViewGroup.getChildMeasureSpec(r1, r14, r15)
            int r15 = r17.getPaddingTop()
            int r16 = r17.getPaddingBottom()
            int r15 = r15 + r16
            int r13 = r10.topMargin
            int r15 = r15 + r13
            int r13 = r10.bottomMargin
            int r15 = r15 + r13
            if (r3 == 0) goto L_0x02ff
            if (r12 == 0) goto L_0x02ff
            int r12 = r0.mHeaderHeight
            goto L_0x0300
        L_0x02ff:
            r12 = 0
        L_0x0300:
            int r15 = r15 + r12
            if (r3 == 0) goto L_0x0308
            if (r11 == 0) goto L_0x0308
            int r12 = r0.mFooterHeight
            goto L_0x0309
        L_0x0308:
            r12 = 0
        L_0x0309:
            int r15 = r15 + r12
            int r5 = r5.height
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r2, r15, r5)
            r4.measure(r14, r5)
            int r5 = r4.getMeasuredWidth()
            int r11 = r10.leftMargin
            int r5 = r5 + r11
            int r11 = r10.rightMargin
            int r5 = r5 + r11
            int r8 = r8 + r5
            int r4 = r4.getMeasuredHeight()
            int r5 = r10.topMargin
            int r4 = r4 + r5
            int r5 = r10.bottomMargin
            int r4 = r4 + r5
            int r9 = r9 + r4
        L_0x0329:
            int r7 = r7 + 1
            goto L_0x001a
        L_0x032d:
            int r3 = r17.getPaddingLeft()
            int r4 = r17.getPaddingRight()
            int r3 = r3 + r4
            int r8 = r8 + r3
            int r3 = r17.getPaddingTop()
            int r4 = r17.getPaddingBottom()
            int r3 = r3 + r4
            int r9 = r9 + r3
            int r3 = super.getSuggestedMinimumWidth()
            int r3 = java.lang.Math.max(r8, r3)
            int r1 = android.view.View.resolveSize(r3, r1)
            int r3 = super.getSuggestedMinimumHeight()
            int r3 = java.lang.Math.max(r9, r3)
            int r2 = android.view.View.resolveSize(r3, r2)
            super.setMeasuredDimension(r1, r2)
            int r1 = r17.getMeasuredWidth()
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            r0.mLastTouchX = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(R.id.srl_tag))) {
                RefreshContent refreshContent = this.mRefreshContent;
                boolean z2 = true;
                if (refreshContent != null && refreshContent.getView() == childAt) {
                    boolean z3 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mRefreshHeader != null;
                    View view = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i7 = marginLayoutParams.leftMargin + paddingLeft;
                    int i8 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i7;
                    int measuredHeight = view.getMeasuredHeight() + i8;
                    if (z3 && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        int i9 = this.mHeaderHeight;
                        i8 += i9;
                        measuredHeight += i9;
                    }
                    view.layout(i7, i8, measuredWidth, measuredHeight);
                }
                RefreshComponent refreshComponent = this.mRefreshHeader;
                if (refreshComponent != null && refreshComponent.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh);
                    View view2 = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int i10 = marginLayoutParams2.leftMargin;
                    int i11 = marginLayoutParams2.topMargin + this.mHeaderInsetStart;
                    int measuredWidth2 = view2.getMeasuredWidth() + i10;
                    int measuredHeight2 = view2.getMeasuredHeight() + i11;
                    if (!z4 && this.mRefreshHeader.getSpinnerStyle() == SpinnerStyle.Translate) {
                        int i12 = this.mHeaderHeight;
                        i11 -= i12;
                        measuredHeight2 -= i12;
                    }
                    view2.layout(i10, i11, measuredWidth2, measuredHeight2);
                }
                RefreshComponent refreshComponent2 = this.mRefreshFooter;
                if (refreshComponent2 != null && refreshComponent2.getView() == childAt) {
                    if (!isInEditMode() || !this.mEnablePreviewInEditMode || !isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        z2 = false;
                    }
                    View view3 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    SpinnerStyle spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                    int i13 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mEnableFooterFollowWhenNoMoreData && this.mRefreshContent != null && this.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.Translate && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        View view4 = this.mRefreshContent.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == SpinnerStyle.MatchLayout) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.mFooterInsetStart;
                    } else {
                        if (z2 || spinnerStyle == SpinnerStyle.FixedFront || spinnerStyle == SpinnerStyle.FixedBehind) {
                            i5 = this.mFooterHeight;
                        } else if (spinnerStyle.scale && this.mSpinner < 0) {
                            i5 = Math.max(isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0, 0);
                        }
                        measuredHeight3 -= i5;
                    }
                    view3.layout(i13, measuredHeight3, view3.getMeasuredWidth() + i13, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mManualLoadMore = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.setDuration(0);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        if (this.mRefreshHeader != null && this.mState == RefreshState.Refreshing) {
            this.mRefreshHeader.onFinish(this, false);
        }
        if (this.mRefreshFooter != null && this.mState == RefreshState.Loading) {
            this.mRefreshFooter.onFinish(this, false);
        }
        if (this.mSpinner != 0) {
            this.mKernel.moveSpinner(0, true);
        }
        if (this.mState != RefreshState.None) {
            notifyStateChanged(RefreshState.None);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mFooterLocked = false;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Paint paint;
        Paint paint2;
        RefreshContent refreshContent = this.mRefreshContent;
        View view2 = refreshContent != null ? refreshContent.getView() : null;
        RefreshComponent refreshComponent = this.mRefreshHeader;
        if (refreshComponent != null && refreshComponent.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableRefresh) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i = this.mHeaderBackgroundColor;
                if (!(i == 0 || (paint2 = this.mPaint) == null)) {
                    paint2.setColor(i);
                    if (this.mRefreshHeader.getSpinnerStyle().scale) {
                        max = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == SpinnerStyle.Translate) {
                        max = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, (float) view.getTop(), (float) getWidth(), (float) max, this.mPaint);
                }
                if ((this.mEnableClipHeaderWhenFixedBehind && this.mRefreshHeader.getSpinnerStyle() == SpinnerStyle.FixedBehind) || this.mRefreshHeader.getSpinnerStyle().scale) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        RefreshComponent refreshComponent2 = this.mRefreshFooter;
        if (refreshComponent2 != null && refreshComponent2.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableLoadMore) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i2 = this.mFooterBackgroundColor;
                if (!(i2 == 0 || (paint = this.mPaint) == null)) {
                    paint.setColor(i2);
                    if (this.mRefreshFooter.getSpinnerStyle().scale) {
                        min = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.Translate) {
                        min = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, (float) min, (float) getWidth(), (float) view.getBottom(), this.mPaint);
                }
                if ((this.mEnableClipFooterWhenFixedBehind && this.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.FixedBehind) || this.mRefreshFooter.getSpinnerStyle().scale) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j);
    }

    public void computeScroll() {
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY >= 0 || ((!this.mEnableRefresh && !this.mEnableOverScrollDrag) || !this.mRefreshContent.canRefresh())) && (finalY <= 0 || ((!this.mEnableLoadMore && !this.mEnableOverScrollDrag) || !this.mRefreshContent.canLoadMore()))) {
                this.mVerticalPermit = true;
                invalidate();
                return;
            }
            if (this.mVerticalPermit) {
                animSpinnerBounce(finalY > 0 ? -this.mScroller.getCurrVelocity() : this.mScroller.getCurrVelocity());
            }
            this.mScroller.forceFinished(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0114, code lost:
        if (r6 != 3) goto L_0x0326;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            int r6 = r23.getActionMasked()
            r2 = 6
            r10 = 0
            r11 = 1
            if (r6 != r2) goto L_0x000f
            r3 = r11
            goto L_0x0010
        L_0x000f:
            r3 = r10
        L_0x0010:
            if (r3 == 0) goto L_0x0017
            int r4 = r23.getActionIndex()
            goto L_0x0018
        L_0x0017:
            r4 = -1
        L_0x0018:
            int r5 = r23.getPointerCount()
            r7 = 0
            r9 = r7
            r12 = r9
            r8 = r10
        L_0x0020:
            if (r8 >= r5) goto L_0x0032
            if (r4 != r8) goto L_0x0025
            goto L_0x002f
        L_0x0025:
            float r13 = r1.getX(r8)
            float r9 = r9 + r13
            float r13 = r1.getY(r8)
            float r12 = r12 + r13
        L_0x002f:
            int r8 = r8 + 1
            goto L_0x0020
        L_0x0032:
            if (r3 == 0) goto L_0x0036
            int r5 = r5 + -1
        L_0x0036:
            float r3 = (float) r5
            float r9 = r9 / r3
            float r8 = r12 / r3
            if (r6 == r2) goto L_0x003f
            r2 = 5
            if (r6 != r2) goto L_0x004c
        L_0x003f:
            boolean r2 = r0.mIsBeingDragged
            if (r2 == 0) goto L_0x004c
            float r2 = r0.mTouchY
            float r3 = r0.mLastTouchY
            float r3 = r8 - r3
            float r2 = r2 + r3
            r0.mTouchY = r2
        L_0x004c:
            r0.mLastTouchX = r9
            r0.mLastTouchY = r8
            boolean r2 = r0.mNestedInProgress
            r3 = 2
            if (r2 == 0) goto L_0x00a8
            int r2 = r0.mTotalUnconsumed
            boolean r1 = super.dispatchTouchEvent(r23)
            if (r6 != r3) goto L_0x00a7
            int r3 = r0.mTotalUnconsumed
            if (r2 != r3) goto L_0x00a7
            float r2 = r0.mLastTouchX
            int r2 = (int) r2
            int r3 = r22.getWidth()
            float r4 = r0.mLastTouchX
            if (r3 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r11 = r3
        L_0x006e:
            float r5 = (float) r11
            float r4 = r4 / r5
            boolean r5 = r0.mEnableRefresh
            boolean r5 = r0.isEnableRefreshOrLoadMore(r5)
            if (r5 == 0) goto L_0x008c
            int r5 = r0.mSpinner
            if (r5 <= 0) goto L_0x008c
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshHeader
            if (r5 == 0) goto L_0x008c
            boolean r5 = r5.isSupportHorizontalDrag()
            if (r5 == 0) goto L_0x008c
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshHeader
            r5.onHorizontalDrag(r4, r2, r3)
            goto L_0x00a7
        L_0x008c:
            boolean r5 = r0.mEnableLoadMore
            boolean r5 = r0.isEnableRefreshOrLoadMore(r5)
            if (r5 == 0) goto L_0x00a7
            int r5 = r0.mSpinner
            if (r5 >= 0) goto L_0x00a7
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshFooter
            if (r5 == 0) goto L_0x00a7
            boolean r5 = r5.isSupportHorizontalDrag()
            if (r5 == 0) goto L_0x00a7
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.mRefreshFooter
            r5.onHorizontalDrag(r4, r2, r3)
        L_0x00a7:
            return r1
        L_0x00a8:
            boolean r2 = r22.isEnabled()
            if (r2 == 0) goto L_0x0370
            boolean r2 = r0.mEnableRefresh
            if (r2 != 0) goto L_0x00ba
            boolean r2 = r0.mEnableLoadMore
            if (r2 != 0) goto L_0x00ba
            boolean r2 = r0.mEnableOverScrollDrag
            if (r2 == 0) goto L_0x0370
        L_0x00ba:
            boolean r2 = r0.mHeaderNeedTouchEventWhenRefreshing
            if (r2 == 0) goto L_0x00d0
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            boolean r2 = r2.isOpening
            if (r2 != 0) goto L_0x00ca
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            boolean r2 = r2.isFinishing
            if (r2 == 0) goto L_0x00d0
        L_0x00ca:
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            boolean r2 = r2.isHeader
            if (r2 != 0) goto L_0x0370
        L_0x00d0:
            boolean r2 = r0.mFooterNeedTouchEventWhenLoading
            if (r2 == 0) goto L_0x00e8
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            boolean r2 = r2.isOpening
            if (r2 != 0) goto L_0x00e0
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            boolean r2 = r2.isFinishing
            if (r2 == 0) goto L_0x00e8
        L_0x00e0:
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            boolean r2 = r2.isFooter
            if (r2 == 0) goto L_0x00e8
            goto L_0x0370
        L_0x00e8:
            boolean r2 = r0.interceptAnimatorByAction(r6)
            if (r2 != 0) goto L_0x036f
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            boolean r2 = r2.isFinishing
            if (r2 != 0) goto L_0x036f
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            com.scwang.smart.refresh.layout.constant.RefreshState r4 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading
            if (r2 != r4) goto L_0x00fe
            boolean r2 = r0.mDisableContentWhenLoading
            if (r2 != 0) goto L_0x036f
        L_0x00fe:
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            com.scwang.smart.refresh.layout.constant.RefreshState r4 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
            if (r2 != r4) goto L_0x010a
            boolean r2 = r0.mDisableContentWhenRefresh
            if (r2 == 0) goto L_0x010a
            goto L_0x036f
        L_0x010a:
            r2 = 104(0x68, float:1.46E-43)
            if (r6 == 0) goto L_0x032b
            r4 = 0
            if (r6 == r11) goto L_0x02dd
            r5 = 3
            if (r6 == r3) goto L_0x0118
            if (r6 == r5) goto L_0x02f8
            goto L_0x0326
        L_0x0118:
            float r3 = r0.mTouchX
            float r9 = r9 - r3
            float r3 = r0.mTouchY
            float r3 = r8 - r3
            android.view.VelocityTracker r6 = r0.mVelocityTracker
            r6.addMovement(r1)
            boolean r6 = r0.mIsBeingDragged
            if (r6 != 0) goto L_0x01f1
            boolean r6 = r0.mEnableDisallowIntercept
            if (r6 != 0) goto L_0x01f1
            char r6 = r0.mDragDirection
            if (r6 == r2) goto L_0x01f1
            com.scwang.smart.refresh.layout.api.RefreshContent r12 = r0.mRefreshContent
            if (r12 == 0) goto L_0x01f1
            r12 = 118(0x76, float:1.65E-43)
            if (r6 == r12) goto L_0x016f
            float r6 = java.lang.Math.abs(r3)
            int r13 = r0.mTouchSlop
            float r13 = (float) r13
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x0150
            float r6 = java.lang.Math.abs(r9)
            float r13 = java.lang.Math.abs(r3)
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 >= 0) goto L_0x0150
            goto L_0x016f
        L_0x0150:
            float r6 = java.lang.Math.abs(r9)
            int r13 = r0.mTouchSlop
            float r13 = (float) r13
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x01f1
            float r6 = java.lang.Math.abs(r9)
            float r13 = java.lang.Math.abs(r3)
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x01f1
            char r6 = r0.mDragDirection
            if (r6 == r12) goto L_0x01f1
            r0.mDragDirection = r2
            goto L_0x01f1
        L_0x016f:
            r0.mDragDirection = r12
            int r2 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0193
            int r2 = r0.mSpinner
            if (r2 < 0) goto L_0x0189
            boolean r2 = r0.mEnableOverScrollDrag
            if (r2 != 0) goto L_0x0181
            boolean r2 = r0.mEnableRefresh
            if (r2 == 0) goto L_0x0193
        L_0x0181:
            com.scwang.smart.refresh.layout.api.RefreshContent r2 = r0.mRefreshContent
            boolean r2 = r2.canRefresh()
            if (r2 == 0) goto L_0x0193
        L_0x0189:
            r0.mIsBeingDragged = r11
            int r2 = r0.mTouchSlop
            float r2 = (float) r2
            float r2 = r8 - r2
            r0.mTouchY = r2
            goto L_0x01bd
        L_0x0193:
            int r2 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x01bd
            int r2 = r0.mSpinner
            if (r2 > 0) goto L_0x01b5
            boolean r2 = r0.mEnableOverScrollDrag
            if (r2 != 0) goto L_0x01a3
            boolean r2 = r0.mEnableLoadMore
            if (r2 == 0) goto L_0x01bd
        L_0x01a3:
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mState
            com.scwang.smart.refresh.layout.constant.RefreshState r6 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading
            if (r2 != r6) goto L_0x01ad
            boolean r2 = r0.mFooterLocked
            if (r2 != 0) goto L_0x01b5
        L_0x01ad:
            com.scwang.smart.refresh.layout.api.RefreshContent r2 = r0.mRefreshContent
            boolean r2 = r2.canLoadMore()
            if (r2 == 0) goto L_0x01bd
        L_0x01b5:
            r0.mIsBeingDragged = r11
            int r2 = r0.mTouchSlop
            float r2 = (float) r2
            float r2 = r2 + r8
            r0.mTouchY = r2
        L_0x01bd:
            boolean r2 = r0.mIsBeingDragged
            if (r2 == 0) goto L_0x01f1
            float r2 = r0.mTouchY
            float r3 = r8 - r2
            boolean r2 = r0.mSuperDispatchTouchEvent
            if (r2 == 0) goto L_0x01cf
            r1.setAction(r5)
            super.dispatchTouchEvent(r23)
        L_0x01cf:
            com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r0.mKernel
            int r6 = r0.mSpinner
            if (r6 > 0) goto L_0x01df
            if (r6 != 0) goto L_0x01dc
            int r6 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x01dc
            goto L_0x01df
        L_0x01dc:
            com.scwang.smart.refresh.layout.constant.RefreshState r6 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad
            goto L_0x01e1
        L_0x01df:
            com.scwang.smart.refresh.layout.constant.RefreshState r6 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh
        L_0x01e1:
            r2.setState(r6)
            android.view.ViewParent r2 = r22.getParent()
            boolean r6 = r2 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x01f1
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r2.requestDisallowInterceptTouchEvent(r11)
        L_0x01f1:
            boolean r2 = r0.mIsBeingDragged
            if (r2 == 0) goto L_0x02cb
            int r2 = (int) r3
            int r6 = r0.mTouchSpinner
            int r2 = r2 + r6
            com.scwang.smart.refresh.layout.constant.RefreshState r6 = r0.mViceState
            boolean r6 = r6.isHeader
            if (r6 == 0) goto L_0x0205
            if (r2 < 0) goto L_0x0211
            int r6 = r0.mLastSpinner
            if (r6 < 0) goto L_0x0211
        L_0x0205:
            com.scwang.smart.refresh.layout.constant.RefreshState r6 = r0.mViceState
            boolean r6 = r6.isFooter
            if (r6 == 0) goto L_0x02c6
            if (r2 > 0) goto L_0x0211
            int r6 = r0.mLastSpinner
            if (r6 <= 0) goto L_0x02c6
        L_0x0211:
            r0.mLastSpinner = r2
            long r20 = r23.getEventTime()
            android.view.MotionEvent r1 = r0.mFalsifyEvent
            if (r1 != 0) goto L_0x0234
            r16 = 0
            float r1 = r0.mTouchX
            float r17 = r1 + r9
            float r1 = r0.mTouchY
            r19 = 0
            r12 = r20
            r14 = r20
            r18 = r1
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r12, r14, r16, r17, r18, r19)
            r0.mFalsifyEvent = r1
            super.dispatchTouchEvent(r1)
        L_0x0234:
            r16 = 2
            float r1 = r0.mTouchX
            float r17 = r1 + r9
            float r1 = r0.mTouchY
            float r6 = (float) r2
            float r18 = r1 + r6
            r19 = 0
            r12 = r20
            r14 = r20
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r12, r14, r16, r17, r18, r19)
            super.dispatchTouchEvent(r1)
            boolean r6 = r0.mFooterLocked
            if (r6 == 0) goto L_0x025d
            int r6 = r0.mTouchSlop
            float r6 = (float) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x025d
            int r3 = r0.mSpinner
            if (r3 >= 0) goto L_0x025d
            r0.mFooterLocked = r10
        L_0x025d:
            if (r2 <= 0) goto L_0x027d
            boolean r3 = r0.mEnableOverScrollDrag
            if (r3 != 0) goto L_0x0267
            boolean r3 = r0.mEnableRefresh
            if (r3 == 0) goto L_0x027d
        L_0x0267:
            com.scwang.smart.refresh.layout.api.RefreshContent r3 = r0.mRefreshContent
            boolean r3 = r3.canRefresh()
            if (r3 == 0) goto L_0x027d
            r0.mLastTouchY = r8
            r0.mTouchY = r8
            r0.mTouchSpinner = r10
            com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r0.mKernel
            com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh
            r2.setState(r3)
            goto L_0x029e
        L_0x027d:
            if (r2 >= 0) goto L_0x029d
            boolean r3 = r0.mEnableOverScrollDrag
            if (r3 != 0) goto L_0x0287
            boolean r3 = r0.mEnableLoadMore
            if (r3 == 0) goto L_0x029d
        L_0x0287:
            com.scwang.smart.refresh.layout.api.RefreshContent r3 = r0.mRefreshContent
            boolean r3 = r3.canLoadMore()
            if (r3 == 0) goto L_0x029d
            r0.mLastTouchY = r8
            r0.mTouchY = r8
            r0.mTouchSpinner = r10
            com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r0.mKernel
            com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad
            r2.setState(r3)
            goto L_0x029e
        L_0x029d:
            r10 = r2
        L_0x029e:
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mViceState
            boolean r2 = r2.isHeader
            if (r2 == 0) goto L_0x02a6
            if (r10 < 0) goto L_0x02ae
        L_0x02a6:
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.mViceState
            boolean r2 = r2.isFooter
            if (r2 == 0) goto L_0x02b6
            if (r10 <= 0) goto L_0x02b6
        L_0x02ae:
            int r1 = r0.mSpinner
            if (r1 == 0) goto L_0x02b5
            r0.moveSpinnerInfinitely(r7)
        L_0x02b5:
            return r11
        L_0x02b6:
            android.view.MotionEvent r2 = r0.mFalsifyEvent
            if (r2 == 0) goto L_0x02c2
            r0.mFalsifyEvent = r4
            r1.setAction(r5)
            super.dispatchTouchEvent(r1)
        L_0x02c2:
            r1.recycle()
            r2 = r10
        L_0x02c6:
            float r1 = (float) r2
            r0.moveSpinnerInfinitely(r1)
            return r11
        L_0x02cb:
            boolean r2 = r0.mFooterLocked
            if (r2 == 0) goto L_0x0326
            int r2 = r0.mTouchSlop
            float r2 = (float) r2
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0326
            int r2 = r0.mSpinner
            if (r2 >= 0) goto L_0x0326
            r0.mFooterLocked = r10
            goto L_0x0326
        L_0x02dd:
            android.view.VelocityTracker r2 = r0.mVelocityTracker
            r2.addMovement(r1)
            android.view.VelocityTracker r2 = r0.mVelocityTracker
            r3 = 1000(0x3e8, float:1.401E-42)
            int r5 = r0.mMaximumVelocity
            float r5 = (float) r5
            r2.computeCurrentVelocity(r3, r5)
            android.view.VelocityTracker r2 = r0.mVelocityTracker
            float r2 = r2.getYVelocity()
            int r2 = (int) r2
            r0.mCurrentVelocity = r2
            r0.startFlingIfNeed(r7)
        L_0x02f8:
            android.view.VelocityTracker r2 = r0.mVelocityTracker
            r2.clear()
            r2 = 110(0x6e, float:1.54E-43)
            r0.mDragDirection = r2
            android.view.MotionEvent r2 = r0.mFalsifyEvent
            if (r2 == 0) goto L_0x031c
            r2.recycle()
            r0.mFalsifyEvent = r4
            long r4 = r23.getEventTime()
            float r7 = r0.mTouchX
            r9 = 0
            r2 = r4
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r2, r4, r6, r7, r8, r9)
            super.dispatchTouchEvent(r2)
            r2.recycle()
        L_0x031c:
            r22.overSpinner()
            boolean r2 = r0.mIsBeingDragged
            if (r2 == 0) goto L_0x0326
            r0.mIsBeingDragged = r10
            return r11
        L_0x0326:
            boolean r1 = super.dispatchTouchEvent(r23)
            return r1
        L_0x032b:
            r0.mCurrentVelocity = r10
            android.view.VelocityTracker r3 = r0.mVelocityTracker
            r3.addMovement(r1)
            android.widget.Scroller r3 = r0.mScroller
            r3.forceFinished(r11)
            r0.mTouchX = r9
            r0.mTouchY = r8
            r0.mLastSpinner = r10
            int r3 = r0.mSpinner
            r0.mTouchSpinner = r3
            r0.mIsBeingDragged = r10
            r0.mEnableDisallowIntercept = r10
            boolean r3 = super.dispatchTouchEvent(r23)
            r0.mSuperDispatchTouchEvent = r3
            com.scwang.smart.refresh.layout.constant.RefreshState r3 = r0.mState
            com.scwang.smart.refresh.layout.constant.RefreshState r4 = com.scwang.smart.refresh.layout.constant.RefreshState.TwoLevel
            if (r3 != r4) goto L_0x0367
            float r3 = r0.mTouchY
            int r4 = r22.getMeasuredHeight()
            float r4 = (float) r4
            r5 = 1065353216(0x3f800000, float:1.0)
            float r6 = r0.mTwoLevelBottomPullUpToCloseRate
            float r5 = r5 - r6
            float r4 = r4 * r5
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0367
            r0.mDragDirection = r2
            boolean r1 = r0.mSuperDispatchTouchEvent
            return r1
        L_0x0367:
            com.scwang.smart.refresh.layout.api.RefreshContent r2 = r0.mRefreshContent
            if (r2 == 0) goto L_0x036e
            r2.onActionDown(r1)
        L_0x036e:
            return r11
        L_0x036f:
            return r10
        L_0x0370:
            boolean r1 = super.dispatchTouchEvent(r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        View scrollableView = this.mRefreshContent.getScrollableView();
        if ((Build.VERSION.SDK_INT >= 21 || !(scrollableView instanceof AbsListView)) && ViewCompat.isNestedScrollingEnabled(scrollableView)) {
            this.mEnableDisallowIntercept = z;
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* access modifiers changed from: protected */
    public boolean startFlingIfNeed(float f) {
        if (f == 0.0f) {
            f = (float) this.mCurrentVelocity;
        }
        if (Math.abs(f) > ((float) this.mMinimumVelocity)) {
            if (((float) this.mSpinner) * f < 0.0f) {
                if (this.mState == RefreshState.Refreshing || this.mState == RefreshState.Loading || (this.mSpinner < 0 && this.mFooterNoMoreData)) {
                    this.animationRunnable = new FlingRunnable(f).start();
                    return true;
                } else if (this.mState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableLoadMore || this.mEnableOverScrollDrag)) || ((this.mState == RefreshState.Loading && this.mSpinner >= 0) || (this.mEnableAutoLoadMore && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) || (f > 0.0f && ((this.mEnableOverScrollBounce && this.mEnableRefresh) || this.mEnableOverScrollDrag || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-f), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean interceptAnimatorByAction(int i) {
        if (i == 0) {
            if (this.reboundAnimator != null) {
                if (this.mState.isFinishing || this.mState == RefreshState.TwoLevelReleased || this.mState == RefreshState.RefreshReleased || this.mState == RefreshState.LoadReleased) {
                    return true;
                }
                if (this.mState == RefreshState.PullDownCanceled) {
                    this.mKernel.setState(RefreshState.PullDownToRefresh);
                } else if (this.mState == RefreshState.PullUpCanceled) {
                    this.mKernel.setState(RefreshState.PullUpToLoad);
                }
                this.reboundAnimator.setDuration(0);
                this.reboundAnimator.cancel();
                this.reboundAnimator = null;
            }
            this.animationRunnable = null;
        }
        if (this.reboundAnimator != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void notifyStateChanged(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2 != refreshState) {
            this.mState = refreshState;
            this.mViceState = refreshState;
            RefreshComponent refreshComponent = this.mRefreshHeader;
            RefreshComponent refreshComponent2 = this.mRefreshFooter;
            OnMultiListener onMultiListener = this.mOnMultiListener;
            if (refreshComponent != null) {
                refreshComponent.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshComponent2 != null) {
                refreshComponent2.onStateChanged(this, refreshState2, refreshState);
            }
            if (onMultiListener != null) {
                onMultiListener.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshState == RefreshState.LoadFinish) {
                this.mFooterLocked = false;
            }
        } else if (this.mViceState != refreshState2) {
            this.mViceState = refreshState2;
        }
    }

    /* access modifiers changed from: protected */
    public void setStateDirectLoading(boolean z) {
        if (this.mState != RefreshState.Loading) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(RefreshState.Loading);
            OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
            if (onLoadMoreListener != null) {
                if (z) {
                    onLoadMoreListener.onLoadMore(this);
                }
            } else if (this.mOnMultiListener == null) {
                finishLoadMore(2000);
            }
            RefreshComponent refreshComponent = this.mRefreshFooter;
            if (refreshComponent != null) {
                float f = this.mFooterMaxDragRate;
                if (f < 10.0f) {
                    f *= (float) this.mFooterHeight;
                }
                refreshComponent.onStartAnimator(this, this.mFooterHeight, (int) f);
            }
            OnMultiListener onMultiListener = this.mOnMultiListener;
            if (onMultiListener != null && (this.mRefreshFooter instanceof RefreshFooter)) {
                if (z) {
                    onMultiListener.onLoadMore(this);
                }
                float f2 = this.mFooterMaxDragRate;
                if (f2 < 10.0f) {
                    f2 *= (float) this.mFooterHeight;
                }
                this.mOnMultiListener.onFooterStartAnimator((RefreshFooter) this.mRefreshFooter, this.mFooterHeight, (int) f2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setStateLoading(final boolean z) {
        AnonymousClass1 r0 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.setStateDirectLoading(z);
                }
            }
        };
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(-this.mFooterHeight);
        if (animSpinner != null) {
            animSpinner.addListener(r0);
        }
        RefreshComponent refreshComponent = this.mRefreshFooter;
        if (refreshComponent != null) {
            float f = this.mFooterMaxDragRate;
            if (f < 10.0f) {
                f *= (float) this.mFooterHeight;
            }
            refreshComponent.onReleased(this, this.mFooterHeight, (int) f);
        }
        OnMultiListener onMultiListener = this.mOnMultiListener;
        if (onMultiListener != null) {
            RefreshComponent refreshComponent2 = this.mRefreshFooter;
            if (refreshComponent2 instanceof RefreshFooter) {
                float f2 = this.mFooterMaxDragRate;
                if (f2 < 10.0f) {
                    f2 *= (float) this.mFooterHeight;
                }
                onMultiListener.onFooterReleased((RefreshFooter) refreshComponent2, this.mFooterHeight, (int) f2);
            }
        }
        if (animSpinner == null) {
            r0.onAnimationEnd((Animator) null);
        }
    }

    /* access modifiers changed from: protected */
    public void setStateRefreshing(final boolean z) {
        AnonymousClass2 r0 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.Refreshing);
                    if (SmartRefreshLayout.this.mRefreshListener != null) {
                        if (z) {
                            SmartRefreshLayout.this.mRefreshListener.onRefresh(SmartRefreshLayout.this);
                        }
                    } else if (SmartRefreshLayout.this.mOnMultiListener == null) {
                        SmartRefreshLayout.this.finishRefresh(3000);
                    }
                    if (SmartRefreshLayout.this.mRefreshHeader != null) {
                        float f = SmartRefreshLayout.this.mHeaderMaxDragRate < 10.0f ? ((float) SmartRefreshLayout.this.mHeaderHeight) * SmartRefreshLayout.this.mHeaderMaxDragRate : SmartRefreshLayout.this.mHeaderMaxDragRate;
                        RefreshComponent refreshComponent = SmartRefreshLayout.this.mRefreshHeader;
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        refreshComponent.onStartAnimator(smartRefreshLayout, smartRefreshLayout.mHeaderHeight, (int) f);
                    }
                    if (SmartRefreshLayout.this.mOnMultiListener != null && (SmartRefreshLayout.this.mRefreshHeader instanceof RefreshHeader)) {
                        if (z) {
                            SmartRefreshLayout.this.mOnMultiListener.onRefresh(SmartRefreshLayout.this);
                        }
                        SmartRefreshLayout.this.mOnMultiListener.onHeaderStartAnimator((RefreshHeader) SmartRefreshLayout.this.mRefreshHeader, SmartRefreshLayout.this.mHeaderHeight, (int) (SmartRefreshLayout.this.mHeaderMaxDragRate < 10.0f ? ((float) SmartRefreshLayout.this.mHeaderHeight) * SmartRefreshLayout.this.mHeaderMaxDragRate : SmartRefreshLayout.this.mHeaderMaxDragRate));
                    }
                }
            }
        };
        notifyStateChanged(RefreshState.RefreshReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(this.mHeaderHeight);
        if (animSpinner != null) {
            animSpinner.addListener(r0);
        }
        RefreshComponent refreshComponent = this.mRefreshHeader;
        if (refreshComponent != null) {
            float f = this.mHeaderMaxDragRate;
            if (f < 10.0f) {
                f *= (float) this.mHeaderHeight;
            }
            refreshComponent.onReleased(this, this.mHeaderHeight, (int) f);
        }
        OnMultiListener onMultiListener = this.mOnMultiListener;
        if (onMultiListener != null) {
            RefreshComponent refreshComponent2 = this.mRefreshHeader;
            if (refreshComponent2 instanceof RefreshHeader) {
                float f2 = this.mHeaderMaxDragRate;
                if (f2 < 10.0f) {
                    f2 *= (float) this.mHeaderHeight;
                }
                onMultiListener.onHeaderReleased((RefreshHeader) refreshComponent2, this.mHeaderHeight, (int) f2);
            }
        }
        if (animSpinner == null) {
            r0.onAnimationEnd((Animator) null);
        }
    }

    /* access modifiers changed from: protected */
    public void setViceState(RefreshState refreshState) {
        if (this.mState.isDragging && this.mState.isHeader != refreshState.isHeader) {
            notifyStateChanged(RefreshState.None);
        }
        if (this.mViceState != refreshState) {
            this.mViceState = refreshState;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isEnableTranslationContent(boolean z, RefreshComponent refreshComponent) {
        return z || this.mEnablePureScrollMode || refreshComponent == null || refreshComponent.getSpinnerStyle() == SpinnerStyle.FixedBehind;
    }

    /* access modifiers changed from: protected */
    public boolean isEnableRefreshOrLoadMore(boolean z) {
        return z && !this.mEnablePureScrollMode;
    }

    protected class FlingRunnable implements Runnable {
        float mDamping = 0.98f;
        int mFrame = 0;
        int mFrameDelay = 10;
        long mLastTime = AnimationUtils.currentAnimationTimeMillis();
        int mOffset;
        long mStartTime = 0;
        float mVelocity;

        FlingRunnable(float f) {
            this.mVelocity = f;
            this.mOffset = SmartRefreshLayout.this.mSpinner;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
            if (r0.isEnableRefreshOrLoadMore(r0.mEnableLoadMore) != false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
            if (r0.isEnableRefreshOrLoadMore(r0.mEnableLoadMore) != false) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
            if (r10.this$0.mSpinner >= (-r10.this$0.mFooterHeight)) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
            if (r10.this$0.mSpinner > r10.this$0.mHeaderHeight) goto L_0x0075;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Runnable start() {
            /*
                r10 = this;
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r0 = r0.mState
                boolean r0 = r0.isFinishing
                r1 = 0
                if (r0 == 0) goto L_0x000a
                return r1
            L_0x000a:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r0 = r0.mSpinner
                if (r0 == 0) goto L_0x00d4
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r0 = r0.mState
                boolean r0 = r0.isOpening
                if (r0 != 0) goto L_0x0034
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.mFooterNoMoreData
                if (r0 == 0) goto L_0x0075
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.mEnableFooterFollowWhenNoMoreData
                if (r0 == 0) goto L_0x0075
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.mFooterNoMoreDataEffective
                if (r0 == 0) goto L_0x0075
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r2 = r0.mEnableLoadMore
                boolean r0 = r0.isEnableRefreshOrLoadMore(r2)
                if (r0 == 0) goto L_0x0075
            L_0x0034:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r0 = r0.mState
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading
                if (r0 == r2) goto L_0x0058
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.mFooterNoMoreData
                if (r0 == 0) goto L_0x0063
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.mEnableFooterFollowWhenNoMoreData
                if (r0 == 0) goto L_0x0063
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.mFooterNoMoreDataEffective
                if (r0 == 0) goto L_0x0063
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r2 = r0.mEnableLoadMore
                boolean r0 = r0.isEnableRefreshOrLoadMore(r2)
                if (r0 == 0) goto L_0x0063
            L_0x0058:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r0 = r0.mSpinner
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mFooterHeight
                int r2 = -r2
                if (r0 < r2) goto L_0x0075
            L_0x0063:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r0 = r0.mState
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
                if (r0 != r2) goto L_0x00d4
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r0 = r0.mSpinner
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mHeaderHeight
                if (r0 <= r2) goto L_0x00d4
            L_0x0075:
                r0 = 0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r3.mSpinner
                float r4 = r10.mVelocity
            L_0x0080:
                int r5 = r3 * r2
                if (r5 <= 0) goto L_0x00d4
                double r4 = (double) r4
                float r6 = r10.mDamping
                double r6 = (double) r6
                int r0 = r0 + 1
                int r8 = r10.mFrameDelay
                int r8 = r8 * r0
                float r8 = (float) r8
                r9 = 1092616192(0x41200000, float:10.0)
                float r8 = r8 / r9
                double r8 = (double) r8
                double r6 = java.lang.Math.pow(r6, r8)
                double r4 = r4 * r6
                float r4 = (float) r4
                int r5 = r10.mFrameDelay
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r4
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto L_0x00d0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r0 = r0.mState
                boolean r0 = r0.isOpening
                if (r0 == 0) goto L_0x00cf
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r0 = r0.mState
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
                if (r0 != r3) goto L_0x00c0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r0 = r0.mHeaderHeight
                if (r2 > r0) goto L_0x00cf
            L_0x00c0:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r0 = r0.mState
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
                if (r0 == r3) goto L_0x00d4
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r0 = r0.mFooterHeight
                int r0 = -r0
                if (r2 >= r0) goto L_0x00d4
            L_0x00cf:
                return r1
            L_0x00d0:
                float r2 = (float) r2
                float r2 = r2 + r5
                int r2 = (int) r2
                goto L_0x0080
            L_0x00d4:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r10.mStartTime = r0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.mHandler
                int r1 = r10.mFrameDelay
                long r1 = (long) r1
                r0.postDelayed(r10, r1)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.FlingRunnable.start():java.lang.Runnable");
        }

        public void run() {
            if (SmartRefreshLayout.this.animationRunnable == this && !SmartRefreshLayout.this.mState.isFinishing) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float pow = (float) (((double) this.mVelocity) * Math.pow((double) this.mDamping, (double) (((float) (currentAnimationTimeMillis - this.mStartTime)) / (1000.0f / ((float) this.mFrameDelay)))));
                this.mVelocity = pow;
                float f = pow * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
                if (Math.abs(f) > 1.0f) {
                    this.mLastTime = currentAnimationTimeMillis;
                    this.mOffset = (int) (((float) this.mOffset) + f);
                    if (SmartRefreshLayout.this.mSpinner * this.mOffset > 0) {
                        SmartRefreshLayout.this.mKernel.moveSpinner(this.mOffset, true);
                        SmartRefreshLayout.this.mHandler.postDelayed(this, (long) this.mFrameDelay);
                        return;
                    }
                    SmartRefreshLayout.this.animationRunnable = null;
                    SmartRefreshLayout.this.mKernel.moveSpinner(0, true);
                    SmartUtil.fling(SmartRefreshLayout.this.mRefreshContent.getScrollableView(), (int) (-this.mVelocity));
                    if (SmartRefreshLayout.this.mFooterLocked && f > 0.0f) {
                        SmartRefreshLayout.this.mFooterLocked = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.animationRunnable = null;
            }
        }
    }

    protected class BounceRunnable implements Runnable {
        int mFrame = 0;
        int mFrameDelay = 10;
        long mLastTime;
        float mOffset = 0.0f;
        int mSmoothDistance;
        float mVelocity;

        BounceRunnable(float f, int i) {
            this.mVelocity = f;
            this.mSmoothDistance = i;
            this.mLastTime = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.mHandler.postDelayed(this, (long) this.mFrameDelay);
            if (f > 0.0f) {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
            }
        }

        public void run() {
            if (SmartRefreshLayout.this.animationRunnable == this && !SmartRefreshLayout.this.mState.isFinishing) {
                if (Math.abs(SmartRefreshLayout.this.mSpinner) < Math.abs(this.mSmoothDistance)) {
                    int i = this.mFrame + 1;
                    this.mFrame = i;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.949999988079071d, (double) (i * 2)));
                } else if (this.mSmoothDistance != 0) {
                    int i2 = this.mFrame + 1;
                    this.mFrame = i2;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.44999998807907104d, (double) (i2 * 2)));
                } else {
                    int i3 = this.mFrame + 1;
                    this.mFrame = i3;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.8500000238418579d, (double) (i3 * 2)));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f = this.mVelocity * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
                if (Math.abs(f) >= 1.0f) {
                    this.mLastTime = currentAnimationTimeMillis;
                    float f2 = this.mOffset + f;
                    this.mOffset = f2;
                    SmartRefreshLayout.this.moveSpinnerInfinitely(f2);
                    SmartRefreshLayout.this.mHandler.postDelayed(this, (long) this.mFrameDelay);
                    return;
                }
                if (SmartRefreshLayout.this.mViceState.isDragging && SmartRefreshLayout.this.mViceState.isHeader) {
                    SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownCanceled);
                } else if (SmartRefreshLayout.this.mViceState.isDragging && SmartRefreshLayout.this.mViceState.isFooter) {
                    SmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpCanceled);
                }
                SmartRefreshLayout.this.animationRunnable = null;
                if (Math.abs(SmartRefreshLayout.this.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.animSpinner(this.mSmoothDistance, 0, smartRefreshLayout.mReboundInterpolator, Math.min(Math.max((int) SmartUtil.px2dp(Math.abs(SmartRefreshLayout.this.mSpinner - this.mSmoothDistance)), 30), 100) * 10);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ValueAnimator animSpinner(int i, int i2, Interpolator interpolator, int i3) {
        if (this.mSpinner == i) {
            return null;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.animationRunnable = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.mSpinner, i});
        this.reboundAnimator = ofInt;
        ofInt.setDuration((long) i3);
        this.reboundAnimator.setInterpolator(interpolator);
        this.reboundAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.reboundAnimator = null;
                    if (SmartRefreshLayout.this.mSpinner == 0 && SmartRefreshLayout.this.mState != RefreshState.None && !SmartRefreshLayout.this.mState.isOpening && !SmartRefreshLayout.this.mState.isDragging) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                    } else if (SmartRefreshLayout.this.mState != SmartRefreshLayout.this.mViceState) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.setViceState(smartRefreshLayout.mState);
                    }
                }
            }
        });
        this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        });
        this.reboundAnimator.setStartDelay((long) i2);
        this.reboundAnimator.start();
        return this.reboundAnimator;
    }

    /* access modifiers changed from: protected */
    public void animSpinnerBounce(float f) {
        if (this.reboundAnimator != null) {
            return;
        }
        if (f > 0.0f && (this.mState == RefreshState.Refreshing || this.mState == RefreshState.TwoLevel)) {
            this.animationRunnable = new BounceRunnable(f, this.mHeaderHeight);
        } else if (f < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mState != RefreshState.Refreshing)))) {
            this.animationRunnable = new BounceRunnable(f, -this.mFooterHeight);
        } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
            this.animationRunnable = new BounceRunnable(f, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void overSpinner() {
        if (this.mState == RefreshState.TwoLevel) {
            if (this.mCurrentVelocity > -1000 && this.mSpinner > getHeight() / 2) {
                ValueAnimator animSpinner = this.mKernel.animSpinner(getHeight());
                if (animSpinner != null) {
                    animSpinner.setDuration((long) this.mFloorDuration);
                }
            } else if (this.mIsBeingDragged) {
                this.mKernel.finishTwoLevel();
            }
        } else if (this.mState == RefreshState.Loading || (this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mSpinner < 0 && isEnableRefreshOrLoadMore(this.mEnableLoadMore))) {
            int i = this.mSpinner;
            int i2 = this.mFooterHeight;
            if (i < (-i2)) {
                this.mKernel.animSpinner(-i2);
            } else if (i > 0) {
                this.mKernel.animSpinner(0);
            }
        } else if (this.mState == RefreshState.Refreshing) {
            int i3 = this.mSpinner;
            int i4 = this.mHeaderHeight;
            if (i3 > i4) {
                this.mKernel.animSpinner(i4);
            } else if (i3 < 0) {
                this.mKernel.animSpinner(0);
            }
        } else if (this.mState == RefreshState.PullDownToRefresh) {
            this.mKernel.setState(RefreshState.PullDownCanceled);
        } else if (this.mState == RefreshState.PullUpToLoad) {
            this.mKernel.setState(RefreshState.PullUpCanceled);
        } else if (this.mState == RefreshState.ReleaseToRefresh) {
            this.mKernel.setState(RefreshState.Refreshing);
        } else if (this.mState == RefreshState.ReleaseToLoad) {
            this.mKernel.setState(RefreshState.Loading);
        } else if (this.mState == RefreshState.ReleaseToTwoLevel) {
            this.mKernel.setState(RefreshState.TwoLevelReleased);
        } else if (this.mState == RefreshState.RefreshReleased) {
            if (this.reboundAnimator == null) {
                this.mKernel.animSpinner(this.mHeaderHeight);
            }
        } else if (this.mState == RefreshState.LoadReleased) {
            if (this.reboundAnimator == null) {
                this.mKernel.animSpinner(-this.mFooterHeight);
            }
        } else if (this.mState != RefreshState.LoadFinish && this.mSpinner != 0) {
            this.mKernel.animSpinner(0);
        }
    }

    /* access modifiers changed from: protected */
    public void moveSpinnerInfinitely(float f) {
        float f2 = (!this.mNestedInProgress || this.mEnableLoadMoreWhenContentNotFull || f >= 0.0f || this.mRefreshContent.canLoadMore()) ? f : 0.0f;
        if (f2 > ((float) (this.mScreenHeightPixels * 5)) && getTag() == null && getTag(R.id.srl_tag) == null) {
            float f3 = this.mLastTouchY;
            int i = this.mScreenHeightPixels;
            if (f3 < ((float) i) / 6.0f && this.mLastTouchX < ((float) i) / 16.0f) {
                Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                setTag(R.id.srl_tag, "你这么死拉，臣妾做不到啊！");
            }
        }
        if (this.mState == RefreshState.TwoLevel && f2 > 0.0f) {
            this.mKernel.moveSpinner(Math.min((int) f2, getMeasuredHeight()), true);
        } else if (this.mState == RefreshState.Refreshing && f2 >= 0.0f) {
            int i2 = this.mHeaderHeight;
            if (f2 < ((float) i2)) {
                this.mKernel.moveSpinner((int) f2, true);
            } else {
                float f4 = this.mHeaderMaxDragRate;
                if (f4 < 10.0f) {
                    f4 *= (float) i2;
                }
                double d = (double) (f4 - ((float) i2));
                int max = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i3 = this.mHeaderHeight;
                double d2 = (double) (max - i3);
                double max2 = (double) Math.max(0.0f, (f2 - ((float) i3)) * this.mDragRate);
                double d3 = -max2;
                if (d2 == 0.0d) {
                    d2 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) Math.min(d * (1.0d - Math.pow(100.0d, d3 / d2)), max2)) + this.mHeaderHeight, true);
            }
        } else if (f2 < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) {
            int i4 = this.mFooterHeight;
            if (f2 > ((float) (-i4))) {
                this.mKernel.moveSpinner((int) f2, true);
            } else {
                float f5 = this.mFooterMaxDragRate;
                if (f5 < 10.0f) {
                    f5 *= (float) i4;
                }
                double d4 = (double) (f5 - ((float) i4));
                int max3 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i5 = this.mFooterHeight;
                double d5 = (double) (max3 - i5);
                double d6 = (double) (-Math.min(0.0f, (((float) i5) + f2) * this.mDragRate));
                double d7 = -d6;
                if (d5 == 0.0d) {
                    d5 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) (-Math.min(d4 * (1.0d - Math.pow(100.0d, d7 / d5)), d6))) - this.mFooterHeight, true);
            }
        } else if (f2 >= 0.0f) {
            float f6 = this.mHeaderMaxDragRate;
            double d8 = f6 < 10.0f ? (double) (((float) this.mHeaderHeight) * f6) : (double) f6;
            double max4 = (double) Math.max(this.mScreenHeightPixels / 2, getHeight());
            double max5 = (double) Math.max(0.0f, this.mDragRate * f2);
            double d9 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.mKernel.moveSpinner((int) Math.min(d8 * (1.0d - Math.pow(100.0d, d9 / max4)), max5), true);
        } else {
            float f7 = this.mFooterMaxDragRate;
            double d10 = f7 < 10.0f ? (double) (((float) this.mFooterHeight) * f7) : (double) f7;
            double max6 = (double) Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d11 = (double) (-Math.min(0.0f, this.mDragRate * f2));
            this.mKernel.moveSpinner((int) (-Math.min(d10 * (1.0d - Math.pow(100.0d, (-d11) / (max6 == 0.0d ? 1.0d : max6))), d11)), true);
        }
        if (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && f2 < 0.0f && this.mState != RefreshState.Refreshing && this.mState != RefreshState.Loading && this.mState != RefreshState.LoadFinish) {
            if (this.mDisableContentWhenLoading) {
                this.animationRunnable = null;
                this.mKernel.animSpinner(-this.mFooterHeight);
            }
            setStateDirectLoading(false);
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    if (SmartRefreshLayout.this.mLoadMoreListener != null) {
                        SmartRefreshLayout.this.mLoadMoreListener.onLoadMore(SmartRefreshLayout.this);
                    } else if (SmartRefreshLayout.this.mOnMultiListener == null) {
                        SmartRefreshLayout.this.finishLoadMore(2000);
                    }
                    OnMultiListener onMultiListener = SmartRefreshLayout.this.mOnMultiListener;
                    if (onMultiListener != null) {
                        onMultiListener.onLoadMore(SmartRefreshLayout.this);
                    }
                }
            }, (long) this.mReboundDuration);
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int backgroundColor = 0;
        public SpinnerStyle spinnerStyle = null;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.backgroundColor = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.backgroundColor);
            if (obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.spinnerStyle = SpinnerStyle.values[obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, SpinnerStyle.Translate.ordinal)];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public int getNestedScrollAxes() {
        return this.mNestedParent.getNestedScrollAxes();
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if (!(isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) || (!this.mEnableOverScrollDrag && !this.mEnableRefresh && !this.mEnableLoadMore)) {
            return false;
        }
        return true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedParent.onNestedScrollAccepted(view, view2, i);
        this.mNestedChild.startNestedScroll(i & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
        interceptAnimatorByAction(0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = this.mTotalUnconsumed;
        int i4 = 0;
        if (i2 * i3 > 0) {
            if (Math.abs(i2) > Math.abs(this.mTotalUnconsumed)) {
                int i5 = this.mTotalUnconsumed;
                this.mTotalUnconsumed = 0;
                i4 = i5;
            } else {
                this.mTotalUnconsumed -= i2;
                i4 = i2;
            }
            moveSpinnerInfinitely((float) this.mTotalUnconsumed);
        } else if (i2 > 0 && this.mFooterLocked) {
            int i6 = i3 - i2;
            this.mTotalUnconsumed = i6;
            moveSpinnerInfinitely((float) i6);
            i4 = i2;
        }
        this.mNestedChild.dispatchNestedPreScroll(i, i2 - i4, iArr, (int[]) null);
        iArr[1] = iArr[1] + i4;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        ViewParent parent;
        ScrollBoundaryDecider scrollBoundaryDecider;
        ScrollBoundaryDecider scrollBoundaryDecider2;
        boolean dispatchNestedScroll = this.mNestedChild.dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if ((i5 < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (scrollBoundaryDecider2 = this.mScrollBoundaryDecider) == null || scrollBoundaryDecider2.canRefresh(this.mRefreshContent.getView())))) || (i5 > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (scrollBoundaryDecider = this.mScrollBoundaryDecider) == null || scrollBoundaryDecider.canLoadMore(this.mRefreshContent.getView()))))) {
            if (this.mViceState == RefreshState.None || this.mViceState.isOpening) {
                this.mKernel.setState(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!dispatchNestedScroll && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i6 = this.mTotalUnconsumed - i5;
            this.mTotalUnconsumed = i6;
            moveSpinnerInfinitely((float) i6);
        }
        if (this.mFooterLocked && i2 < 0) {
            this.mFooterLocked = false;
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return (this.mFooterLocked && f2 > 0.0f) || startFlingIfNeed(-f2) || this.mNestedChild.dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return this.mNestedChild.dispatchNestedFling(f, f2, z);
    }

    public void onStopNestedScroll(View view) {
        this.mNestedParent.onStopNestedScroll(view);
        this.mNestedInProgress = false;
        this.mTotalUnconsumed = 0;
        overSpinner();
        this.mNestedChild.stopNestedScroll();
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mEnableNestedScrolling = z;
        this.mNestedChild.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mEnableNestedScrolling && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    public RefreshLayout setHeaderHeight(float f) {
        return setHeaderHeightPx(SmartUtil.dp2px(f));
    }

    public RefreshLayout setHeaderHeightPx(int i) {
        if (i != this.mHeaderHeight && this.mHeaderHeightStatus.canReplaceWith(DimensionStatus.CodeExact)) {
            this.mHeaderHeight = i;
            if (this.mRefreshHeader == null || !this.mAttachedToWindow || !this.mHeaderHeightStatus.notified) {
                this.mHeaderHeightStatus = DimensionStatus.CodeExactUnNotify;
            } else {
                SpinnerStyle spinnerStyle = this.mRefreshHeader.getSpinnerStyle();
                if (spinnerStyle != SpinnerStyle.MatchLayout && !spinnerStyle.scale) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i2 = 0;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), PictureFileUtils.GB), View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), PictureFileUtils.GB));
                    int i3 = marginLayoutParams.leftMargin;
                    int i4 = marginLayoutParams.topMargin + this.mHeaderInsetStart;
                    if (spinnerStyle == SpinnerStyle.Translate) {
                        i2 = this.mHeaderHeight;
                    }
                    int i5 = i4 - i2;
                    view.layout(i3, i5, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + i5);
                }
                float f = this.mHeaderMaxDragRate;
                if (f < 10.0f) {
                    f *= (float) this.mHeaderHeight;
                }
                this.mHeaderHeightStatus = DimensionStatus.CodeExact;
                this.mRefreshHeader.onInitialized(this.mKernel, this.mHeaderHeight, (int) f);
            }
        }
        return this;
    }

    public RefreshLayout setFooterHeight(float f) {
        return setFooterHeightPx(SmartUtil.dp2px(f));
    }

    public RefreshLayout setFooterHeightPx(int i) {
        if (i != this.mFooterHeight && this.mFooterHeightStatus.canReplaceWith(DimensionStatus.CodeExact)) {
            this.mFooterHeight = i;
            if (this.mRefreshFooter == null || !this.mAttachedToWindow || !this.mFooterHeightStatus.notified) {
                this.mFooterHeightStatus = DimensionStatus.CodeExactUnNotify;
            } else {
                SpinnerStyle spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                if (spinnerStyle != SpinnerStyle.MatchLayout && !spinnerStyle.scale) {
                    View view = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i2 = 0;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), PictureFileUtils.GB), View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), PictureFileUtils.GB));
                    int i3 = marginLayoutParams.leftMargin;
                    int measuredHeight = (marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (spinnerStyle != SpinnerStyle.Translate) {
                        i2 = this.mFooterHeight;
                    }
                    int i4 = measuredHeight - i2;
                    view.layout(i3, i4, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + i4);
                }
                float f = this.mFooterMaxDragRate;
                if (f < 10.0f) {
                    f *= (float) this.mFooterHeight;
                }
                this.mFooterHeightStatus = DimensionStatus.CodeExact;
                this.mRefreshFooter.onInitialized(this.mKernel, this.mFooterHeight, (int) f);
            }
        }
        return this;
    }

    public RefreshLayout setHeaderInsetStart(float f) {
        this.mHeaderInsetStart = SmartUtil.dp2px(f);
        return this;
    }

    public RefreshLayout setHeaderInsetStartPx(int i) {
        this.mHeaderInsetStart = i;
        return this;
    }

    public RefreshLayout setFooterInsetStart(float f) {
        this.mFooterInsetStart = SmartUtil.dp2px(f);
        return this;
    }

    public RefreshLayout setFooterInsetStartPx(int i) {
        this.mFooterInsetStart = i;
        return this;
    }

    public RefreshLayout setDragRate(float f) {
        this.mDragRate = f;
        return this;
    }

    public RefreshLayout setHeaderMaxDragRate(float f) {
        this.mHeaderMaxDragRate = f;
        RefreshComponent refreshComponent = this.mRefreshHeader;
        if (refreshComponent == null || !this.mAttachedToWindow) {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.unNotify();
        } else {
            if (f < 10.0f) {
                f *= (float) this.mHeaderHeight;
            }
            refreshComponent.onInitialized(this.mKernel, this.mHeaderHeight, (int) f);
        }
        return this;
    }

    public RefreshLayout setFooterMaxDragRate(float f) {
        this.mFooterMaxDragRate = f;
        RefreshComponent refreshComponent = this.mRefreshFooter;
        if (refreshComponent == null || !this.mAttachedToWindow) {
            this.mFooterHeightStatus = this.mFooterHeightStatus.unNotify();
        } else {
            if (f < 10.0f) {
                f *= (float) this.mFooterHeight;
            }
            refreshComponent.onInitialized(this.mKernel, this.mFooterHeight, (int) f);
        }
        return this;
    }

    public RefreshLayout setHeaderTriggerRate(float f) {
        this.mHeaderTriggerRate = f;
        return this;
    }

    public RefreshLayout setFooterTriggerRate(float f) {
        this.mFooterTriggerRate = f;
        return this;
    }

    public RefreshLayout setReboundInterpolator(Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    public RefreshLayout setReboundDuration(int i) {
        this.mReboundDuration = i;
        return this;
    }

    public RefreshLayout setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    public RefreshLayout setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    public RefreshLayout setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    public RefreshLayout setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        this.mManualFooterTranslationContent = true;
        return this;
    }

    public RefreshLayout setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    public RefreshLayout setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    public RefreshLayout setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    public RefreshLayout setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    public RefreshLayout setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    public RefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setEnableLoadMoreWhenContentNotFull(z);
        }
        return this;
    }

    public RefreshLayout setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    public RefreshLayout setEnableFooterFollowWhenNoMoreData(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    public RefreshLayout setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    public RefreshLayout setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    public RefreshLayout setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    public RefreshLayout setFixedHeaderViewId(int i) {
        this.mFixedHeaderViewId = i;
        return this;
    }

    public RefreshLayout setFixedFooterViewId(int i) {
        this.mFixedFooterViewId = i;
        return this;
    }

    public RefreshLayout setHeaderTranslationViewId(int i) {
        this.mHeaderTranslationViewId = i;
        return this;
    }

    public RefreshLayout setFooterTranslationViewId(int i) {
        this.mFooterTranslationViewId = i;
        return this;
    }

    public RefreshLayout setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    public RefreshLayout setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    public RefreshLayout setRefreshHeader(RefreshHeader refreshHeader) {
        return setRefreshHeader(refreshHeader, 0, 0);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.scwang.smart.refresh.layout.api.RefreshLayout setRefreshHeader(com.scwang.smart.refresh.layout.api.RefreshHeader r3, int r4, int r5) {
        /*
            r2 = this;
            com.scwang.smart.refresh.layout.api.RefreshComponent r0 = r2.mRefreshHeader
            if (r0 == 0) goto L_0x000b
            android.view.View r0 = r0.getView()
            super.removeView(r0)
        L_0x000b:
            r2.mRefreshHeader = r3
            r0 = 0
            r2.mHeaderBackgroundColor = r0
            r2.mHeaderNeedTouchEventWhenRefreshing = r0
            com.scwang.smart.refresh.layout.constant.DimensionStatus r1 = com.scwang.smart.refresh.layout.constant.DimensionStatus.DefaultUnNotify
            r2.mHeaderHeightStatus = r1
            if (r4 != 0) goto L_0x0019
            r4 = -1
        L_0x0019:
            if (r5 != 0) goto L_0x001c
            r5 = -2
        L_0x001c:
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r1 = new com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams
            r1.<init>((int) r4, (int) r5)
            android.view.View r3 = r3.getView()
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r4 = r3 instanceof com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams
            if (r4 == 0) goto L_0x0030
            r1 = r3
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r1 = (com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams) r1
        L_0x0030:
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.mRefreshHeader
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
            boolean r3 = r3.front
            if (r3 == 0) goto L_0x0048
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.mRefreshHeader
            android.view.View r3 = r3.getView()
            int r4 = r2.getChildCount()
            super.addView(r3, r4, r1)
            goto L_0x0051
        L_0x0048:
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.mRefreshHeader
            android.view.View r3 = r3.getView()
            super.addView(r3, r0, r1)
        L_0x0051:
            int[] r3 = r2.mPrimaryColors
            if (r3 == 0) goto L_0x005c
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r2.mRefreshHeader
            if (r4 == 0) goto L_0x005c
            r4.setPrimaryColors(r3)
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.setRefreshHeader(com.scwang.smart.refresh.layout.api.RefreshHeader, int, int):com.scwang.smart.refresh.layout.api.RefreshLayout");
    }

    public RefreshLayout setRefreshFooter(RefreshFooter refreshFooter) {
        return setRefreshFooter(refreshFooter, 0, 0);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.scwang.smart.refresh.layout.api.RefreshLayout setRefreshFooter(com.scwang.smart.refresh.layout.api.RefreshFooter r3, int r4, int r5) {
        /*
            r2 = this;
            com.scwang.smart.refresh.layout.api.RefreshComponent r0 = r2.mRefreshFooter
            if (r0 == 0) goto L_0x000b
            android.view.View r0 = r0.getView()
            super.removeView(r0)
        L_0x000b:
            r2.mRefreshFooter = r3
            r0 = 0
            r2.mFooterLocked = r0
            r2.mFooterBackgroundColor = r0
            r2.mFooterNoMoreDataEffective = r0
            r2.mFooterNeedTouchEventWhenLoading = r0
            com.scwang.smart.refresh.layout.constant.DimensionStatus r1 = com.scwang.smart.refresh.layout.constant.DimensionStatus.DefaultUnNotify
            r2.mFooterHeightStatus = r1
            boolean r1 = r2.mManualLoadMore
            if (r1 == 0) goto L_0x0025
            boolean r1 = r2.mEnableLoadMore
            if (r1 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r1 = r0
            goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            r2.mEnableLoadMore = r1
            if (r4 != 0) goto L_0x002b
            r4 = -1
        L_0x002b:
            if (r5 != 0) goto L_0x002e
            r5 = -2
        L_0x002e:
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r1 = new com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams
            r1.<init>((int) r4, (int) r5)
            android.view.View r3 = r3.getView()
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r4 = r3 instanceof com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams
            if (r4 == 0) goto L_0x0042
            r1 = r3
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r1 = (com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams) r1
        L_0x0042:
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.mRefreshFooter
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
            boolean r3 = r3.front
            if (r3 == 0) goto L_0x005a
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.mRefreshFooter
            android.view.View r3 = r3.getView()
            int r4 = r2.getChildCount()
            super.addView(r3, r4, r1)
            goto L_0x0063
        L_0x005a:
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.mRefreshFooter
            android.view.View r3 = r3.getView()
            super.addView(r3, r0, r1)
        L_0x0063:
            int[] r3 = r2.mPrimaryColors
            if (r3 == 0) goto L_0x006e
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r2.mRefreshFooter
            if (r4 == 0) goto L_0x006e
            r4.setPrimaryColors(r3)
        L_0x006e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.setRefreshFooter(com.scwang.smart.refresh.layout.api.RefreshFooter, int, int):com.scwang.smart.refresh.layout.api.RefreshLayout");
    }

    public RefreshLayout setRefreshContent(View view) {
        return setRefreshContent(view, 0, 0);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.scwang.smart.refresh.layout.api.RefreshLayout setRefreshContent(android.view.View r2, int r3, int r4) {
        /*
            r1 = this;
            com.scwang.smart.refresh.layout.api.RefreshContent r0 = r1.mRefreshContent
            if (r0 == 0) goto L_0x000b
            android.view.View r0 = r0.getView()
            super.removeView(r0)
        L_0x000b:
            r0 = -1
            if (r3 != 0) goto L_0x000f
            r3 = r0
        L_0x000f:
            if (r4 != 0) goto L_0x0012
            r4 = r0
        L_0x0012:
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r0 = new com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams
            r0.<init>((int) r3, (int) r4)
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            boolean r4 = r3 instanceof com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams
            if (r4 == 0) goto L_0x0022
            r0 = r3
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r0 = (com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams) r0
        L_0x0022:
            int r3 = r1.getChildCount()
            super.addView(r2, r3, r0)
            com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper r3 = new com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper
            r3.<init>(r2)
            r1.mRefreshContent = r3
            boolean r2 = r1.mAttachedToWindow
            if (r2 == 0) goto L_0x0055
            int r2 = r1.mFixedHeaderViewId
            android.view.View r2 = r1.findViewById(r2)
            int r3 = r1.mFixedFooterViewId
            android.view.View r3 = r1.findViewById(r3)
            com.scwang.smart.refresh.layout.api.RefreshContent r4 = r1.mRefreshContent
            com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider r0 = r1.mScrollBoundaryDecider
            r4.setScrollBoundaryDecider(r0)
            com.scwang.smart.refresh.layout.api.RefreshContent r4 = r1.mRefreshContent
            boolean r0 = r1.mEnableLoadMoreWhenContentNotFull
            r4.setEnableLoadMoreWhenContentNotFull(r0)
            com.scwang.smart.refresh.layout.api.RefreshContent r4 = r1.mRefreshContent
            com.scwang.smart.refresh.layout.api.RefreshKernel r0 = r1.mKernel
            r4.setUpComponent(r0, r2, r3)
        L_0x0055:
            com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r1.mRefreshHeader
            if (r2 == 0) goto L_0x006a
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r2 = r2.getSpinnerStyle()
            boolean r2 = r2.front
            if (r2 == 0) goto L_0x006a
            com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r1.mRefreshHeader
            android.view.View r2 = r2.getView()
            super.bringChildToFront(r2)
        L_0x006a:
            com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r1.mRefreshFooter
            if (r2 == 0) goto L_0x007f
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r2 = r2.getSpinnerStyle()
            boolean r2 = r2.front
            if (r2 == 0) goto L_0x007f
            com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r1.mRefreshFooter
            android.view.View r2 = r2.getView()
            super.bringChildToFront(r2)
        L_0x007f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.setRefreshContent(android.view.View, int, int):com.scwang.smart.refresh.layout.api.RefreshLayout");
    }

    public RefreshFooter getRefreshFooter() {
        RefreshComponent refreshComponent = this.mRefreshFooter;
        if (refreshComponent instanceof RefreshFooter) {
            return (RefreshFooter) refreshComponent;
        }
        return null;
    }

    public RefreshHeader getRefreshHeader() {
        RefreshComponent refreshComponent = this.mRefreshHeader;
        if (refreshComponent instanceof RefreshHeader) {
            return (RefreshHeader) refreshComponent;
        }
        return null;
    }

    public RefreshState getState() {
        return this.mState;
    }

    public RefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
        return this;
    }

    public RefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || (!this.mManualLoadMore && onLoadMoreListener != null);
        return this;
    }

    public RefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.mRefreshListener = onRefreshLoadMoreListener;
        this.mLoadMoreListener = onRefreshLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || (!this.mManualLoadMore && onRefreshLoadMoreListener != null);
        return this;
    }

    public RefreshLayout setOnMultiListener(OnMultiListener onMultiListener) {
        this.mOnMultiListener = onMultiListener;
        return this;
    }

    public RefreshLayout setPrimaryColors(int... iArr) {
        RefreshComponent refreshComponent = this.mRefreshHeader;
        if (refreshComponent != null) {
            refreshComponent.setPrimaryColors(iArr);
        }
        RefreshComponent refreshComponent2 = this.mRefreshFooter;
        if (refreshComponent2 != null) {
            refreshComponent2.setPrimaryColors(iArr);
        }
        this.mPrimaryColors = iArr;
        return this;
    }

    public RefreshLayout setPrimaryColorsId(int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(getContext(), iArr[i]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    public RefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider) {
        this.mScrollBoundaryDecider = scrollBoundaryDecider;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setScrollBoundaryDecider(scrollBoundaryDecider);
        }
        return this;
    }

    public RefreshLayout setNoMoreData(boolean z) {
        if (this.mState == RefreshState.Refreshing && z) {
            finishRefreshWithNoMoreData();
        } else if (this.mState == RefreshState.Loading && z) {
            finishLoadMoreWithNoMoreData();
        } else if (this.mFooterNoMoreData != z) {
            this.mFooterNoMoreData = z;
            RefreshComponent refreshComponent = this.mRefreshFooter;
            if (refreshComponent instanceof RefreshFooter) {
                if (((RefreshFooter) refreshComponent).setNoMoreData(z)) {
                    this.mFooterNoMoreDataEffective = true;
                    if (this.mFooterNoMoreData && this.mEnableFooterFollowWhenNoMoreData && this.mSpinner > 0 && this.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.Translate && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableRefresh, this.mRefreshHeader)) {
                        this.mRefreshFooter.getView().setTranslationY((float) this.mSpinner);
                    }
                } else {
                    this.mFooterNoMoreDataEffective = false;
                    new RuntimeException("Footer:" + this.mRefreshFooter + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    public RefreshLayout resetNoMoreData() {
        return setNoMoreData(false);
    }

    public RefreshLayout finishRefresh() {
        return finishRefresh(true);
    }

    public RefreshLayout finishLoadMore() {
        return finishLoadMore(true);
    }

    public RefreshLayout finishRefresh(int i) {
        return finishRefresh(i, true, Boolean.FALSE);
    }

    public RefreshLayout finishRefresh(boolean z) {
        if (z) {
            return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.FALSE);
        }
        return finishRefresh(0, false, (Boolean) null);
    }

    public RefreshLayout finishRefresh(int i, final boolean z, final Boolean bool) {
        final int i2 = i >> 16;
        int i3 = (i << 16) >> 16;
        AnonymousClass6 r1 = new Runnable() {
            int count = 0;

            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                if (this.count == 0) {
                    if (SmartRefreshLayout.this.mState == RefreshState.None && SmartRefreshLayout.this.mViceState == RefreshState.Refreshing) {
                        SmartRefreshLayout.this.mViceState = RefreshState.None;
                    } else if (SmartRefreshLayout.this.reboundAnimator != null && SmartRefreshLayout.this.mState.isHeader && (SmartRefreshLayout.this.mState.isDragging || SmartRefreshLayout.this.mState == RefreshState.RefreshReleased)) {
                        SmartRefreshLayout.this.reboundAnimator.setDuration(0);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout.this.reboundAnimator = null;
                        if (SmartRefreshLayout.this.mKernel.animSpinner(0) == null) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                        } else {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                        }
                    } else if (!(SmartRefreshLayout.this.mState != RefreshState.Refreshing || SmartRefreshLayout.this.mRefreshHeader == null || SmartRefreshLayout.this.mRefreshContent == null)) {
                        this.count++;
                        SmartRefreshLayout.this.mHandler.postDelayed(this, (long) i2);
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshFinish);
                        if (bool == Boolean.FALSE) {
                            SmartRefreshLayout.this.setNoMoreData(false);
                        }
                    }
                    if (bool == Boolean.TRUE) {
                        SmartRefreshLayout.this.setNoMoreData(true);
                        return;
                    }
                    return;
                }
                int onFinish = SmartRefreshLayout.this.mRefreshHeader.onFinish(SmartRefreshLayout.this, z);
                if (SmartRefreshLayout.this.mOnMultiListener != null && (SmartRefreshLayout.this.mRefreshHeader instanceof RefreshHeader)) {
                    SmartRefreshLayout.this.mOnMultiListener.onHeaderFinish((RefreshHeader) SmartRefreshLayout.this.mRefreshHeader, z);
                }
                if (onFinish < Integer.MAX_VALUE) {
                    if (SmartRefreshLayout.this.mIsBeingDragged || SmartRefreshLayout.this.mNestedInProgress) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (SmartRefreshLayout.this.mIsBeingDragged) {
                            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                            smartRefreshLayout.mTouchY = smartRefreshLayout.mLastTouchY;
                            SmartRefreshLayout.this.mTouchSpinner = 0;
                            SmartRefreshLayout.this.mIsBeingDragged = false;
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            long j = currentTimeMillis;
                            boolean unused = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j, 0, smartRefreshLayout2.mLastTouchX, (SmartRefreshLayout.this.mLastTouchY + ((float) SmartRefreshLayout.this.mSpinner)) - ((float) (SmartRefreshLayout.this.mTouchSlop * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            boolean unused2 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j, 2, smartRefreshLayout3.mLastTouchX, SmartRefreshLayout.this.mLastTouchY + ((float) SmartRefreshLayout.this.mSpinner), 0));
                        }
                        if (SmartRefreshLayout.this.mNestedInProgress) {
                            SmartRefreshLayout.this.mTotalUnconsumed = 0;
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            boolean unused3 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout4.mLastTouchX, SmartRefreshLayout.this.mLastTouchY, 0));
                            SmartRefreshLayout.this.mNestedInProgress = false;
                            SmartRefreshLayout.this.mTouchSpinner = 0;
                        }
                    }
                    if (SmartRefreshLayout.this.mSpinner > 0) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        ValueAnimator animSpinner = smartRefreshLayout5.animSpinner(0, onFinish, smartRefreshLayout5.mReboundInterpolator, SmartRefreshLayout.this.mReboundDuration);
                        if (SmartRefreshLayout.this.mEnableScrollContentWhenRefreshed) {
                            animatorUpdateListener = SmartRefreshLayout.this.mRefreshContent.scrollContentWhenFinished(SmartRefreshLayout.this.mSpinner);
                        }
                        if (animSpinner != null && animatorUpdateListener != null) {
                            animSpinner.addUpdateListener(animatorUpdateListener);
                        }
                    } else if (SmartRefreshLayout.this.mSpinner < 0) {
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        smartRefreshLayout6.animSpinner(0, onFinish, smartRefreshLayout6.mReboundInterpolator, SmartRefreshLayout.this.mReboundDuration);
                    } else {
                        SmartRefreshLayout.this.mKernel.moveSpinner(0, false);
                        SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                    }
                }
            }
        };
        if (i3 > 0) {
            this.mHandler.postDelayed(r1, (long) i3);
        } else {
            r1.run();
        }
        return this;
    }

    public RefreshLayout finishRefreshWithNoMoreData() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.TRUE);
    }

    public RefreshLayout finishLoadMore(int i) {
        return finishLoadMore(i, true, false);
    }

    public RefreshLayout finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16 : 0, z, false);
    }

    public RefreshLayout finishLoadMore(int i, final boolean z, final boolean z2) {
        final int i2 = i >> 16;
        int i3 = (i << 16) >> 16;
        AnonymousClass7 r1 = new Runnable() {
            int count = 0;

            public void run() {
                boolean z = true;
                if (this.count == 0) {
                    if (SmartRefreshLayout.this.mState == RefreshState.None && SmartRefreshLayout.this.mViceState == RefreshState.Loading) {
                        SmartRefreshLayout.this.mViceState = RefreshState.None;
                    } else if (SmartRefreshLayout.this.reboundAnimator != null && ((SmartRefreshLayout.this.mState.isDragging || SmartRefreshLayout.this.mState == RefreshState.LoadReleased) && SmartRefreshLayout.this.mState.isFooter)) {
                        SmartRefreshLayout.this.reboundAnimator.setDuration(0);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout.this.reboundAnimator = null;
                        if (SmartRefreshLayout.this.mKernel.animSpinner(0) == null) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                        } else {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullUpCanceled);
                        }
                    } else if (!(SmartRefreshLayout.this.mState != RefreshState.Loading || SmartRefreshLayout.this.mRefreshFooter == null || SmartRefreshLayout.this.mRefreshContent == null)) {
                        this.count++;
                        SmartRefreshLayout.this.mHandler.postDelayed(this, (long) i2);
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadFinish);
                        return;
                    }
                    if (z2) {
                        SmartRefreshLayout.this.setNoMoreData(true);
                        return;
                    }
                    return;
                }
                int onFinish = SmartRefreshLayout.this.mRefreshFooter.onFinish(SmartRefreshLayout.this, z);
                if (SmartRefreshLayout.this.mOnMultiListener != null && (SmartRefreshLayout.this.mRefreshFooter instanceof RefreshFooter)) {
                    SmartRefreshLayout.this.mOnMultiListener.onFooterFinish((RefreshFooter) SmartRefreshLayout.this.mRefreshFooter, z);
                }
                if (onFinish < Integer.MAX_VALUE) {
                    if (!z2 || !SmartRefreshLayout.this.mEnableFooterFollowWhenNoMoreData || SmartRefreshLayout.this.mSpinner >= 0 || !SmartRefreshLayout.this.mRefreshContent.canLoadMore()) {
                        z = false;
                    }
                    final int max = SmartRefreshLayout.this.mSpinner - (z ? Math.max(SmartRefreshLayout.this.mSpinner, -SmartRefreshLayout.this.mFooterHeight) : 0);
                    if (SmartRefreshLayout.this.mIsBeingDragged || SmartRefreshLayout.this.mNestedInProgress) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (SmartRefreshLayout.this.mIsBeingDragged) {
                            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                            smartRefreshLayout.mTouchY = smartRefreshLayout.mLastTouchY;
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            smartRefreshLayout2.mTouchSpinner = smartRefreshLayout2.mSpinner - max;
                            SmartRefreshLayout.this.mIsBeingDragged = false;
                            int i = SmartRefreshLayout.this.mEnableFooterTranslationContent ? max : 0;
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            float f = (float) i;
                            long j = currentTimeMillis;
                            long j2 = currentTimeMillis;
                            boolean unused = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(j, j2, 0, smartRefreshLayout3.mLastTouchX, SmartRefreshLayout.this.mLastTouchY + f + ((float) (SmartRefreshLayout.this.mTouchSlop * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            boolean unused2 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(j, j2, 2, smartRefreshLayout4.mLastTouchX, SmartRefreshLayout.this.mLastTouchY + f, 0));
                        }
                        if (SmartRefreshLayout.this.mNestedInProgress) {
                            SmartRefreshLayout.this.mTotalUnconsumed = 0;
                            SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                            boolean unused3 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout5.mLastTouchX, SmartRefreshLayout.this.mLastTouchY, 0));
                            SmartRefreshLayout.this.mNestedInProgress = false;
                            SmartRefreshLayout.this.mTouchSpinner = 0;
                        }
                    }
                    SmartRefreshLayout.this.mHandler.postDelayed(new Runnable() {
                        public void run() {
                            ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
                            ValueAnimator valueAnimator;
                            if (!SmartRefreshLayout.this.mEnableScrollContentWhenLoaded || max >= 0) {
                                animatorUpdateListener = null;
                            } else {
                                animatorUpdateListener = SmartRefreshLayout.this.mRefreshContent.scrollContentWhenFinished(SmartRefreshLayout.this.mSpinner);
                                if (animatorUpdateListener != null) {
                                    animatorUpdateListener.onAnimationUpdate(ValueAnimator.ofInt(new int[]{0, 0}));
                                }
                            }
                            AnonymousClass1 r2 = new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    if (animator == null || animator.getDuration() != 0) {
                                        SmartRefreshLayout.this.mFooterLocked = false;
                                        if (z2) {
                                            SmartRefreshLayout.this.setNoMoreData(true);
                                        }
                                        if (SmartRefreshLayout.this.mState == RefreshState.LoadFinish) {
                                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                                        }
                                    }
                                }
                            };
                            if (SmartRefreshLayout.this.mSpinner > 0) {
                                valueAnimator = SmartRefreshLayout.this.mKernel.animSpinner(0);
                            } else {
                                if (animatorUpdateListener != null || SmartRefreshLayout.this.mSpinner == 0) {
                                    if (SmartRefreshLayout.this.reboundAnimator != null) {
                                        SmartRefreshLayout.this.reboundAnimator.setDuration(0);
                                        SmartRefreshLayout.this.reboundAnimator.cancel();
                                        SmartRefreshLayout.this.reboundAnimator = null;
                                    }
                                    SmartRefreshLayout.this.mKernel.moveSpinner(0, false);
                                    SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                                } else if (!z2 || !SmartRefreshLayout.this.mEnableFooterFollowWhenNoMoreData) {
                                    valueAnimator = SmartRefreshLayout.this.mKernel.animSpinner(0);
                                } else if (SmartRefreshLayout.this.mSpinner >= (-SmartRefreshLayout.this.mFooterHeight)) {
                                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                                } else {
                                    valueAnimator = SmartRefreshLayout.this.mKernel.animSpinner(-SmartRefreshLayout.this.mFooterHeight);
                                }
                                valueAnimator = null;
                            }
                            if (valueAnimator != null) {
                                valueAnimator.addListener(r2);
                            } else {
                                r2.onAnimationEnd((Animator) null);
                            }
                        }
                    }, SmartRefreshLayout.this.mSpinner < 0 ? (long) onFinish : 0);
                }
            }
        };
        if (i3 > 0) {
            this.mHandler.postDelayed(r1, (long) i3);
        } else {
            r1.run();
        }
        return this;
    }

    public RefreshLayout finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, true);
    }

    public RefreshLayout closeHeaderOrFooter() {
        if (this.mState == RefreshState.None && (this.mViceState == RefreshState.Refreshing || this.mViceState == RefreshState.Loading)) {
            this.mViceState = RefreshState.None;
        }
        if (this.mState == RefreshState.Refreshing) {
            finishRefresh();
        } else if (this.mState == RefreshState.Loading) {
            finishLoadMore();
        } else if (this.mKernel.animSpinner(0) == null) {
            notifyStateChanged(RefreshState.None);
        } else if (this.mState.isHeader) {
            notifyStateChanged(RefreshState.PullDownCanceled);
        } else {
            notifyStateChanged(RefreshState.PullUpCanceled);
        }
        return this;
    }

    public boolean autoRefresh() {
        return autoRefresh(this.mAttachedToWindow ? 0 : 400, this.mReboundDuration, (this.mHeaderMaxDragRate + this.mHeaderTriggerRate) / 2.0f, false);
    }

    public boolean autoRefresh(int i) {
        return autoRefresh(i, this.mReboundDuration, (this.mHeaderMaxDragRate + this.mHeaderTriggerRate) / 2.0f, false);
    }

    public boolean autoRefreshAnimationOnly() {
        return autoRefresh(this.mAttachedToWindow ? 0 : 400, this.mReboundDuration, (this.mHeaderMaxDragRate + this.mHeaderTriggerRate) / 2.0f, true);
    }

    public boolean autoRefresh(int i, final int i2, final float f, final boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
            return false;
        }
        AnonymousClass8 r0 = new Runnable() {
            public void run() {
                if (SmartRefreshLayout.this.mViceState == RefreshState.Refreshing) {
                    if (SmartRefreshLayout.this.reboundAnimator != null) {
                        SmartRefreshLayout.this.reboundAnimator.setDuration(0);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout.this.reboundAnimator = null;
                    }
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.mLastTouchX = ((float) smartRefreshLayout.getMeasuredWidth()) / 2.0f;
                    SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
                    float f = SmartRefreshLayout.this.mHeaderHeight == 0 ? SmartRefreshLayout.this.mHeaderTriggerRate : (float) SmartRefreshLayout.this.mHeaderHeight;
                    float f2 = f;
                    if (f2 < 10.0f) {
                        f2 *= f;
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.reboundAnimator = ValueAnimator.ofInt(new int[]{smartRefreshLayout2.mSpinner, (int) f2});
                    SmartRefreshLayout.this.reboundAnimator.setDuration((long) i2);
                    SmartRefreshLayout.this.reboundAnimator.setInterpolator(new SmartUtil(SmartUtil.INTERPOLATOR_VISCOUS_FLUID));
                    SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (SmartRefreshLayout.this.reboundAnimator != null && SmartRefreshLayout.this.mRefreshHeader != null) {
                                SmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                            }
                        }
                    });
                    SmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            if (animator == null || animator.getDuration() != 0) {
                                SmartRefreshLayout.this.reboundAnimator = null;
                                if (SmartRefreshLayout.this.mRefreshHeader != null) {
                                    if (SmartRefreshLayout.this.mState != RefreshState.ReleaseToRefresh) {
                                        SmartRefreshLayout.this.mKernel.setState(RefreshState.ReleaseToRefresh);
                                    }
                                    SmartRefreshLayout.this.setStateRefreshing(!z);
                                    return;
                                }
                                SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                            }
                        }
                    });
                    SmartRefreshLayout.this.reboundAnimator.start();
                }
            }
        };
        setViceState(RefreshState.Refreshing);
        if (i > 0) {
            this.mHandler.postDelayed(r0, (long) i);
            return true;
        }
        r0.run();
        return true;
    }

    public boolean autoLoadMore() {
        return autoLoadMore(0, this.mReboundDuration, (this.mFooterMaxDragRate + this.mFooterTriggerRate) / 2.0f, false);
    }

    public boolean autoLoadMore(int i) {
        return autoLoadMore(i, this.mReboundDuration, (this.mFooterMaxDragRate + this.mFooterTriggerRate) / 2.0f, false);
    }

    public boolean autoLoadMoreAnimationOnly() {
        return autoLoadMore(0, this.mReboundDuration, (this.mFooterMaxDragRate + this.mFooterTriggerRate) / 2.0f, true);
    }

    public boolean autoLoadMore(int i, final int i2, final float f, final boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || this.mFooterNoMoreData) {
            return false;
        }
        AnonymousClass9 r0 = new Runnable() {
            public void run() {
                if (SmartRefreshLayout.this.mViceState == RefreshState.Loading) {
                    if (SmartRefreshLayout.this.reboundAnimator != null) {
                        SmartRefreshLayout.this.reboundAnimator.setDuration(0);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout.this.reboundAnimator = null;
                    }
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.mLastTouchX = ((float) smartRefreshLayout.getMeasuredWidth()) / 2.0f;
                    SmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
                    float f = SmartRefreshLayout.this.mFooterHeight == 0 ? SmartRefreshLayout.this.mFooterTriggerRate : (float) SmartRefreshLayout.this.mFooterHeight;
                    float f2 = f;
                    if (f2 < 10.0f) {
                        f2 *= f;
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.reboundAnimator = ValueAnimator.ofInt(new int[]{smartRefreshLayout2.mSpinner, -((int) f2)});
                    SmartRefreshLayout.this.reboundAnimator.setDuration((long) i2);
                    SmartRefreshLayout.this.reboundAnimator.setInterpolator(new SmartUtil(SmartUtil.INTERPOLATOR_VISCOUS_FLUID));
                    SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (SmartRefreshLayout.this.reboundAnimator != null && SmartRefreshLayout.this.mRefreshFooter != null) {
                                SmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                            }
                        }
                    });
                    SmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            if (animator == null || animator.getDuration() != 0) {
                                SmartRefreshLayout.this.reboundAnimator = null;
                                if (SmartRefreshLayout.this.mRefreshFooter != null) {
                                    if (SmartRefreshLayout.this.mState != RefreshState.ReleaseToLoad) {
                                        SmartRefreshLayout.this.mKernel.setState(RefreshState.ReleaseToLoad);
                                    }
                                    SmartRefreshLayout.this.setStateLoading(!z);
                                    return;
                                }
                                SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                            }
                        }
                    });
                    SmartRefreshLayout.this.reboundAnimator.start();
                }
            }
        };
        setViceState(RefreshState.Loading);
        if (i > 0) {
            this.mHandler.postDelayed(r0, (long) i);
            return true;
        }
        r0.run();
        return true;
    }

    public static void setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        sHeaderCreator = defaultRefreshHeaderCreator;
    }

    public static void setDefaultRefreshFooterCreator(DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        sFooterCreator = defaultRefreshFooterCreator;
    }

    public static void setDefaultRefreshInitializer(DefaultRefreshInitializer defaultRefreshInitializer) {
        sRefreshInitializer = defaultRefreshInitializer;
    }

    public boolean isRefreshing() {
        return this.mState == RefreshState.Refreshing;
    }

    public boolean isLoading() {
        return this.mState == RefreshState.Loading;
    }

    public class RefreshKernelImpl implements RefreshKernel {
        public RefreshKernelImpl() {
        }

        public RefreshLayout getRefreshLayout() {
            return SmartRefreshLayout.this;
        }

        public RefreshContent getRefreshContent() {
            return SmartRefreshLayout.this.mRefreshContent;
        }

        public RefreshKernel setState(RefreshState refreshState) {
            switch (AnonymousClass10.$SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState[refreshState.ordinal()]) {
                case 1:
                    if (SmartRefreshLayout.this.mState != RefreshState.None && SmartRefreshLayout.this.mSpinner == 0) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                        return null;
                    } else if (SmartRefreshLayout.this.mSpinner == 0) {
                        return null;
                    } else {
                        animSpinner(0);
                        return null;
                    }
                case 2:
                    if (!SmartRefreshLayout.this.mState.isOpening) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.isEnableRefreshOrLoadMore(smartRefreshLayout.mEnableRefresh)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableLoadMore) || SmartRefreshLayout.this.mState.isOpening || SmartRefreshLayout.this.mState.isFinishing || (SmartRefreshLayout.this.mFooterNoMoreData && SmartRefreshLayout.this.mEnableFooterFollowWhenNoMoreData && SmartRefreshLayout.this.mFooterNoMoreDataEffective)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    if (!SmartRefreshLayout.this.mState.isOpening) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        if (smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableRefresh)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                            setState(RefreshState.None);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout4.isEnableRefreshOrLoadMore(smartRefreshLayout4.mEnableLoadMore) || SmartRefreshLayout.this.mState.isOpening || (SmartRefreshLayout.this.mFooterNoMoreData && SmartRefreshLayout.this.mEnableFooterFollowWhenNoMoreData && SmartRefreshLayout.this.mFooterNoMoreDataEffective)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullUpCanceled);
                    setState(RefreshState.None);
                    return null;
                case 6:
                    if (!SmartRefreshLayout.this.mState.isOpening) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.isEnableRefreshOrLoadMore(smartRefreshLayout5.mEnableRefresh)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout6.isEnableRefreshOrLoadMore(smartRefreshLayout6.mEnableLoadMore) || SmartRefreshLayout.this.mState.isOpening || SmartRefreshLayout.this.mState.isFinishing || (SmartRefreshLayout.this.mFooterNoMoreData && SmartRefreshLayout.this.mEnableFooterFollowWhenNoMoreData && SmartRefreshLayout.this.mFooterNoMoreDataEffective)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    if (!SmartRefreshLayout.this.mState.isOpening) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (smartRefreshLayout7.isEnableRefreshOrLoadMore(smartRefreshLayout7.mEnableRefresh)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    if (!SmartRefreshLayout.this.mState.isOpening) {
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.isEnableRefreshOrLoadMore(smartRefreshLayout8.mEnableRefresh)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    if (!SmartRefreshLayout.this.mState.isOpening) {
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        if (smartRefreshLayout9.isEnableRefreshOrLoadMore(smartRefreshLayout9.mEnableLoadMore)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    return null;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    return null;
                default:
                    SmartRefreshLayout.this.notifyStateChanged(refreshState);
                    return null;
            }
        }

        public RefreshKernel startTwoLevel(boolean z) {
            if (z) {
                AnonymousClass1 r4 = new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        if (animator == null || animator.getDuration() != 0) {
                            SmartRefreshLayout.this.mKernel.setState(RefreshState.TwoLevel);
                        }
                    }
                };
                ValueAnimator animSpinner = animSpinner(SmartRefreshLayout.this.getMeasuredHeight());
                if (animSpinner == null || animSpinner != SmartRefreshLayout.this.reboundAnimator) {
                    r4.onAnimationEnd((Animator) null);
                } else {
                    animSpinner.setDuration((long) SmartRefreshLayout.this.mFloorDuration);
                    animSpinner.addListener(r4);
                }
            } else if (animSpinner(0) == null) {
                SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
            }
            return this;
        }

        public RefreshKernel finishTwoLevel() {
            if (SmartRefreshLayout.this.mState == RefreshState.TwoLevel) {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.mSpinner == 0) {
                    moveSpinner(0, false);
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    animSpinner(0).setDuration((long) SmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0108  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.scwang.smart.refresh.layout.api.RefreshKernel moveSpinner(int r19, boolean r20) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                if (r2 != r1) goto L_0x002b
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                if (r2 == 0) goto L_0x001a
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                boolean r2 = r2.isSupportHorizontalDrag()
                if (r2 != 0) goto L_0x002b
            L_0x001a:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshFooter
                if (r2 == 0) goto L_0x002a
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshFooter
                boolean r2 = r2.isSupportHorizontalDrag()
                if (r2 != 0) goto L_0x002b
            L_0x002a:
                return r0
            L_0x002b:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r9 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r10 = r9.mSpinner
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                r2.mSpinner = r1
                r11 = 1092616192(0x41200000, float:10.0)
                if (r20 == 0) goto L_0x00cf
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = r2.mViceState
                boolean r2 = r2.isDragging
                if (r2 != 0) goto L_0x0047
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = r2.mViceState
                boolean r2 = r2.isOpening
                if (r2 == 0) goto L_0x00cf
            L_0x0047:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                float r2 = (float) r2
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mHeaderTriggerRate
                int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
                if (r3 >= 0) goto L_0x005f
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r3.mHeaderHeight
                float r3 = (float) r3
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r4 = r4.mHeaderTriggerRate
                float r3 = r3 * r4
                goto L_0x0063
            L_0x005f:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mHeaderTriggerRate
            L_0x0063:
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x0079
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = r2.mState
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToTwoLevel
                if (r2 == r3) goto L_0x00cf
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r2.mKernel
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToRefresh
                r2.setState(r3)
                goto L_0x00cf
            L_0x0079:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                int r2 = -r2
                float r2 = (float) r2
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mFooterTriggerRate
                int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
                if (r3 >= 0) goto L_0x0092
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r3.mFooterHeight
                float r3 = (float) r3
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r4 = r4.mFooterTriggerRate
                float r3 = r3 * r4
                goto L_0x0096
            L_0x0092:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mFooterTriggerRate
            L_0x0096:
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x00aa
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.mFooterNoMoreData
                if (r2 != 0) goto L_0x00aa
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r2.mKernel
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToLoad
                r2.setState(r3)
                goto L_0x00cf
            L_0x00aa:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                if (r2 >= 0) goto L_0x00c0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.mFooterNoMoreData
                if (r2 != 0) goto L_0x00c0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r2.mKernel
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad
                r2.setState(r3)
                goto L_0x00cf
            L_0x00c0:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                if (r2 <= 0) goto L_0x00cf
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r2.mKernel
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh
                r2.setState(r3)
            L_0x00cf:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshContent r2 = r2.mRefreshContent
                r13 = 0
                if (r2 == 0) goto L_0x01b4
                if (r1 < 0) goto L_0x00ed
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r3 = r2.mEnableHeaderTranslationContent
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r4.mRefreshHeader
                boolean r2 = r2.isEnableTranslationContent(r3, r4)
                if (r2 == 0) goto L_0x00e9
                r2 = r1
            L_0x00e7:
                r3 = 1
                goto L_0x00ef
            L_0x00e9:
                if (r10 >= 0) goto L_0x00ed
                r2 = r13
                goto L_0x00e7
            L_0x00ed:
                r2 = r13
                r3 = r2
            L_0x00ef:
                if (r1 > 0) goto L_0x0106
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r5 = r4.mEnableFooterTranslationContent
                com.scwang.smart.refresh.layout.SmartRefreshLayout r6 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r6 = r6.mRefreshFooter
                boolean r4 = r4.isEnableTranslationContent(r5, r6)
                if (r4 == 0) goto L_0x0102
                r2 = r1
            L_0x0100:
                r3 = 1
                goto L_0x0106
            L_0x0102:
                if (r10 <= 0) goto L_0x0106
                r2 = r13
                goto L_0x0100
            L_0x0106:
                if (r3 == 0) goto L_0x01b4
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshContent r3 = r3.mRefreshContent
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r4 = r4.mHeaderTranslationViewId
                com.scwang.smart.refresh.layout.SmartRefreshLayout r5 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r5 = r5.mFooterTranslationViewId
                r3.moveSpinner(r2, r4, r5)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r3 = r3.mFooterNoMoreData
                if (r3 == 0) goto L_0x0157
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r3 = r3.mFooterNoMoreDataEffective
                if (r3 == 0) goto L_0x0157
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r3 = r3.mEnableFooterFollowWhenNoMoreData
                if (r3 == 0) goto L_0x0157
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.mRefreshFooter
                boolean r3 = r3 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
                if (r3 == 0) goto L_0x0157
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.mRefreshFooter
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r4 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.Translate
                if (r3 != r4) goto L_0x0157
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r4 = r3.mEnableLoadMore
                boolean r3 = r3.isEnableRefreshOrLoadMore(r4)
                if (r3 == 0) goto L_0x0157
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.mRefreshFooter
                android.view.View r3 = r3.getView()
                int r4 = java.lang.Math.max(r13, r2)
                float r4 = (float) r4
                r3.setTranslationY(r4)
            L_0x0157:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r3 = r3.mEnableClipHeaderWhenFixedBehind
                if (r3 == 0) goto L_0x0171
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.mRefreshHeader
                if (r3 == 0) goto L_0x0171
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.mRefreshHeader
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r4 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.FixedBehind
                if (r3 != r4) goto L_0x0171
                r3 = 1
                goto L_0x0172
            L_0x0171:
                r3 = r13
            L_0x0172:
                if (r3 != 0) goto L_0x017d
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r3.mHeaderBackgroundColor
                if (r3 == 0) goto L_0x017b
                goto L_0x017d
            L_0x017b:
                r3 = r13
                goto L_0x017e
            L_0x017d:
                r3 = 1
            L_0x017e:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r4 = r4.mEnableClipFooterWhenFixedBehind
                if (r4 == 0) goto L_0x0198
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r4.mRefreshFooter
                if (r4 == 0) goto L_0x0198
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r4.mRefreshFooter
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.FixedBehind
                if (r4 != r5) goto L_0x0198
                r4 = 1
                goto L_0x0199
            L_0x0198:
                r4 = r13
            L_0x0199:
                if (r4 != 0) goto L_0x01a4
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r4 = r4.mFooterBackgroundColor
                if (r4 == 0) goto L_0x01a2
                goto L_0x01a4
            L_0x01a2:
                r4 = r13
                goto L_0x01a5
            L_0x01a4:
                r4 = 1
            L_0x01a5:
                if (r3 == 0) goto L_0x01ab
                if (r2 >= 0) goto L_0x01b1
                if (r10 > 0) goto L_0x01b1
            L_0x01ab:
                if (r4 == 0) goto L_0x01b4
                if (r2 <= 0) goto L_0x01b1
                if (r10 >= 0) goto L_0x01b4
            L_0x01b1:
                r9.invalidate()
            L_0x01b4:
                r14 = 1065353216(0x3f800000, float:1.0)
                r15 = 1073741824(0x40000000, float:2.0)
                if (r1 >= 0) goto L_0x01bc
                if (r10 <= 0) goto L_0x0310
            L_0x01bc:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                if (r2 == 0) goto L_0x0310
                int r8 = java.lang.Math.max(r1, r13)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r7 = r2.mHeaderHeight
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r2 = r2.mHeaderMaxDragRate
                int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
                if (r2 >= 0) goto L_0x01dd
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mHeaderHeight
                float r2 = (float) r2
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mHeaderMaxDragRate
                float r2 = r2 * r3
                goto L_0x01e1
            L_0x01dd:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r2 = r2.mHeaderMaxDragRate
            L_0x01e1:
                int r6 = (int) r2
                float r2 = (float) r8
                float r2 = r2 * r14
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mHeaderTriggerRate
                int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
                if (r3 >= 0) goto L_0x01f7
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mHeaderTriggerRate
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r4 = r4.mHeaderHeight
                float r4 = (float) r4
                float r3 = r3 * r4
                goto L_0x01fb
            L_0x01f7:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mHeaderTriggerRate
            L_0x01fb:
                float r16 = r2 / r3
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r3 = r2.mEnableRefresh
                boolean r2 = r2.isEnableRefreshOrLoadMore(r3)
                if (r2 != 0) goto L_0x0217
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = r2.mState
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.RefreshFinish
                if (r2 != r3) goto L_0x0212
                if (r20 != 0) goto L_0x0212
                goto L_0x0217
            L_0x0212:
                r12 = r6
                r17 = r7
                goto L_0x02e7
            L_0x0217:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                if (r10 == r2) goto L_0x02bd
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r2 = r2.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.Translate
                if (r2 != r3) goto L_0x0257
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                android.view.View r2 = r2.getView()
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r3.mSpinner
                float r3 = (float) r3
                r2.setTranslationY(r3)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mHeaderBackgroundColor
                if (r2 == 0) goto L_0x02ab
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                android.graphics.Paint r2 = r2.mPaint
                if (r2 == 0) goto L_0x02ab
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r3 = r2.mEnableHeaderTranslationContent
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r4.mRefreshHeader
                boolean r2 = r2.isEnableTranslationContent(r3, r4)
                if (r2 != 0) goto L_0x02ab
                r9.invalidate()
                goto L_0x02ab
            L_0x0257:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r2 = r2.getSpinnerStyle()
                boolean r2 = r2.scale
                if (r2 == 0) goto L_0x02ab
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                android.view.View r2 = r2.getView()
                android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
                boolean r4 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r4 == 0) goto L_0x0276
                android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
                goto L_0x0278
            L_0x0276:
                android.view.ViewGroup$MarginLayoutParams r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.sDefaultMarginLP
            L_0x0278:
                int r4 = r2.getMeasuredWidth()
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r15)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r5 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r5 = r5.mSpinner
                int r12 = r3.bottomMargin
                int r5 = r5 - r12
                int r12 = r3.topMargin
                int r5 = r5 - r12
                int r5 = java.lang.Math.max(r5, r13)
                int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r15)
                r2.measure(r4, r5)
                int r4 = r3.leftMargin
                int r3 = r3.topMargin
                com.scwang.smart.refresh.layout.SmartRefreshLayout r5 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r5 = r5.mHeaderInsetStart
                int r3 = r3 + r5
                int r5 = r2.getMeasuredWidth()
                int r5 = r5 + r4
                int r12 = r2.getMeasuredHeight()
                int r12 = r12 + r3
                r2.layout(r4, r3, r5, r12)
            L_0x02ab:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                r3 = r20
                r4 = r16
                r5 = r8
                r12 = r6
                r6 = r7
                r17 = r7
                r7 = r12
                r2.onMoving(r3, r4, r5, r6, r7)
                goto L_0x02c0
            L_0x02bd:
                r12 = r6
                r17 = r7
            L_0x02c0:
                if (r20 == 0) goto L_0x02e7
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                boolean r2 = r2.isSupportHorizontalDrag()
                if (r2 == 0) goto L_0x02e7
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r2 = r2.mLastTouchX
                int r2 = (int) r2
                int r3 = r9.getWidth()
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r4 = r4.mLastTouchX
                if (r3 != 0) goto L_0x02dd
                r5 = 1
                goto L_0x02de
            L_0x02dd:
                r5 = r3
            L_0x02de:
                float r5 = (float) r5
                float r4 = r4 / r5
                com.scwang.smart.refresh.layout.SmartRefreshLayout r5 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r5.mRefreshHeader
                r5.onHorizontalDrag(r4, r2, r3)
            L_0x02e7:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                if (r10 == r2) goto L_0x0310
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.listener.OnMultiListener r2 = r2.mOnMultiListener
                if (r2 == 0) goto L_0x0310
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshHeader
                boolean r2 = r2 instanceof com.scwang.smart.refresh.layout.api.RefreshHeader
                if (r2 == 0) goto L_0x0310
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.listener.OnMultiListener r2 = r2.mOnMultiListener
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.mRefreshHeader
                com.scwang.smart.refresh.layout.api.RefreshHeader r3 = (com.scwang.smart.refresh.layout.api.RefreshHeader) r3
                r4 = r20
                r5 = r16
                r6 = r8
                r7 = r17
                r8 = r12
                r2.onHeaderMoving(r3, r4, r5, r6, r7, r8)
            L_0x0310:
                if (r1 <= 0) goto L_0x0314
                if (r10 >= 0) goto L_0x0460
            L_0x0314:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshFooter
                if (r2 == 0) goto L_0x0460
                int r1 = java.lang.Math.min(r1, r13)
                int r7 = -r1
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r8 = r1.mFooterHeight
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r1 = r1.mFooterMaxDragRate
                int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
                if (r1 >= 0) goto L_0x0336
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r1 = r1.mFooterHeight
                float r1 = (float) r1
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r2 = r2.mFooterMaxDragRate
                float r1 = r1 * r2
                goto L_0x033a
            L_0x0336:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r1 = r1.mFooterMaxDragRate
            L_0x033a:
                int r12 = (int) r1
                float r1 = (float) r7
                float r1 = r1 * r14
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r2 = r2.mFooterTriggerRate
                int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
                if (r2 >= 0) goto L_0x0350
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r2 = r2.mFooterTriggerRate
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r3.mFooterHeight
                float r3 = (float) r3
                float r2 = r2 * r3
                goto L_0x0354
            L_0x0350:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r2 = r2.mFooterTriggerRate
            L_0x0354:
                float r11 = r1 / r2
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r2 = r1.mEnableLoadMore
                boolean r1 = r1.isEnableRefreshOrLoadMore(r2)
                if (r1 != 0) goto L_0x036a
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r1.mState
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadFinish
                if (r1 != r2) goto L_0x0439
                if (r20 != 0) goto L_0x0439
            L_0x036a:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r1 = r1.mSpinner
                if (r10 == r1) goto L_0x0412
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.mRefreshFooter
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r1 = r1.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r2 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.Translate
                if (r1 != r2) goto L_0x03aa
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.mRefreshFooter
                android.view.View r1 = r1.getView()
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.mSpinner
                float r2 = (float) r2
                r1.setTranslationY(r2)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r1 = r1.mFooterBackgroundColor
                if (r1 == 0) goto L_0x0405
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                android.graphics.Paint r1 = r1.mPaint
                if (r1 == 0) goto L_0x0405
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r2 = r1.mEnableFooterTranslationContent
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.mRefreshFooter
                boolean r1 = r1.isEnableTranslationContent(r2, r3)
                if (r1 != 0) goto L_0x0405
                r9.invalidate()
                goto L_0x0405
            L_0x03aa:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.mRefreshFooter
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r1 = r1.getSpinnerStyle()
                boolean r1 = r1.scale
                if (r1 == 0) goto L_0x0405
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.mRefreshFooter
                android.view.View r1 = r1.getView()
                android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
                boolean r3 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r3 == 0) goto L_0x03c9
                android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
                goto L_0x03cb
            L_0x03c9:
                android.view.ViewGroup$MarginLayoutParams r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.sDefaultMarginLP
            L_0x03cb:
                int r3 = r1.getMeasuredWidth()
                int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r15)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r4 = r4.mSpinner
                int r4 = -r4
                int r5 = r2.bottomMargin
                int r4 = r4 - r5
                int r5 = r2.topMargin
                int r4 = r4 - r5
                int r4 = java.lang.Math.max(r4, r13)
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r15)
                r1.measure(r3, r4)
                int r3 = r2.leftMargin
                int r2 = r2.topMargin
                int r4 = r9.getMeasuredHeight()
                int r2 = r2 + r4
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r4 = r4.mFooterInsetStart
                int r2 = r2 - r4
                int r4 = r1.getMeasuredHeight()
                int r4 = r2 - r4
                int r5 = r1.getMeasuredWidth()
                int r5 = r5 + r3
                r1.layout(r3, r4, r5, r2)
            L_0x0405:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.mRefreshFooter
                r2 = r20
                r3 = r11
                r4 = r7
                r5 = r8
                r6 = r12
                r1.onMoving(r2, r3, r4, r5, r6)
            L_0x0412:
                if (r20 == 0) goto L_0x0439
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.mRefreshFooter
                boolean r1 = r1.isSupportHorizontalDrag()
                if (r1 == 0) goto L_0x0439
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r1 = r1.mLastTouchX
                int r1 = (int) r1
                int r2 = r9.getWidth()
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r3 = r3.mLastTouchX
                if (r2 != 0) goto L_0x042f
                r4 = 1
                goto L_0x0430
            L_0x042f:
                r4 = r2
            L_0x0430:
                float r4 = (float) r4
                float r3 = r3 / r4
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r4.mRefreshFooter
                r4.onHorizontalDrag(r3, r1, r2)
            L_0x0439:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r1 = r1.mSpinner
                if (r10 == r1) goto L_0x0460
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.listener.OnMultiListener r1 = r1.mOnMultiListener
                if (r1 == 0) goto L_0x0460
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.mRefreshFooter
                boolean r1 = r1 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
                if (r1 == 0) goto L_0x0460
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.listener.OnMultiListener r1 = r1.mOnMultiListener
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.mRefreshFooter
                com.scwang.smart.refresh.layout.api.RefreshFooter r2 = (com.scwang.smart.refresh.layout.api.RefreshFooter) r2
                r3 = r20
                r4 = r11
                r5 = r7
                r6 = r8
                r7 = r12
                r1.onFooterMoving(r2, r3, r4, r5, r6, r7)
            L_0x0460:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.RefreshKernelImpl.moveSpinner(int, boolean):com.scwang.smart.refresh.layout.api.RefreshKernel");
        }

        public ValueAnimator animSpinner(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.animSpinner(i, 0, smartRefreshLayout.mReboundInterpolator, SmartRefreshLayout.this.mReboundDuration);
        }

        public RefreshKernel requestDrawBackgroundFor(RefreshComponent refreshComponent, int i) {
            if (SmartRefreshLayout.this.mPaint == null && i != 0) {
                SmartRefreshLayout.this.mPaint = new Paint();
            }
            if (refreshComponent.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderBackgroundColor = i;
            } else if (refreshComponent.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterBackgroundColor = i;
            }
            return this;
        }

        public RefreshKernel requestNeedTouchEventFor(RefreshComponent refreshComponent, boolean z) {
            if (refreshComponent.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderNeedTouchEventWhenRefreshing = z;
            } else if (refreshComponent.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterNeedTouchEventWhenLoading = z;
            }
            return this;
        }

        public RefreshKernel requestDefaultTranslationContentFor(RefreshComponent refreshComponent, boolean z) {
            if (refreshComponent.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                if (!SmartRefreshLayout.this.mManualHeaderTranslationContent) {
                    SmartRefreshLayout.this.mManualHeaderTranslationContent = true;
                    SmartRefreshLayout.this.mEnableHeaderTranslationContent = z;
                }
            } else if (refreshComponent.equals(SmartRefreshLayout.this.mRefreshFooter) && !SmartRefreshLayout.this.mManualFooterTranslationContent) {
                SmartRefreshLayout.this.mManualFooterTranslationContent = true;
                SmartRefreshLayout.this.mEnableFooterTranslationContent = z;
            }
            return this;
        }

        public RefreshKernel requestRemeasureHeightFor(RefreshComponent refreshComponent) {
            if (refreshComponent.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                if (SmartRefreshLayout.this.mHeaderHeightStatus.notified) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.mHeaderHeightStatus = smartRefreshLayout.mHeaderHeightStatus.unNotify();
                }
            } else if (refreshComponent.equals(SmartRefreshLayout.this.mRefreshFooter) && SmartRefreshLayout.this.mFooterHeightStatus.notified) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                smartRefreshLayout2.mFooterHeightStatus = smartRefreshLayout2.mFooterHeightStatus.unNotify();
            }
            return this;
        }

        public RefreshKernel requestFloorDuration(int i) {
            SmartRefreshLayout.this.mFloorDuration = i;
            return this;
        }

        public RefreshKernel requestFloorBottomPullUpToCloseRate(float f) {
            SmartRefreshLayout.this.mTwoLevelBottomPullUpToCloseRate = f;
            return this;
        }
    }

    /* renamed from: com.scwang.smart.refresh.layout.SmartRefreshLayout$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smart.refresh.layout.constant.RefreshState[] r0 = com.scwang.smart.refresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState = r0
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownCanceled     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpCanceled     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x006c }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.AnonymousClass10.<clinit>():void");
        }
    }
}
