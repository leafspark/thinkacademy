package com.zhpan.bannerview;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zhpan.bannerview.adapter.BannerPagerAdapter;
import com.zhpan.bannerview.holder.HolderCreator;
import com.zhpan.bannerview.holder.ViewHolder;
import com.zhpan.bannerview.indicator.IIndicator;
import com.zhpan.bannerview.indicator.IndicatorView;
import com.zhpan.bannerview.manager.BannerManager;
import com.zhpan.bannerview.manager.BannerOptions;
import com.zhpan.bannerview.provider.ViewStyleSetter;
import com.zhpan.bannerview.transform.PageTransformerFactory;
import com.zhpan.bannerview.transform.ScaleInTransformer;
import com.zhpan.bannerview.utils.BannerUtils;
import com.zhpan.bannerview.view.CatchViewPager;
import java.util.List;
import java.util.Objects;

public class BannerViewPager<T, VH extends ViewHolder> extends RelativeLayout implements ViewPager.OnPageChangeListener {
    private int currentPosition;
    private HolderCreator<VH> holderCreator;
    private boolean isCustomIndicator;
    private BannerManager mBannerManager;
    private BannerPagerAdapter<T, VH> mBannerPagerAdapter;
    private Handler mHandler;
    private RelativeLayout mIndicatorLayout;
    private IIndicator mIndicatorView;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    /* access modifiers changed from: private */
    public OnPageClickListener mOnPageClickListener;
    private Runnable mRunnable;
    private CatchViewPager mViewPager;
    private int startX;
    private int startY;

    public interface OnPageClickListener {
        void onPageClick(int i);
    }

    public BannerViewPager(Context context) {
        this(context, (AttributeSet) null);
    }

    public BannerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.mRunnable = new Runnable() {
            public void run() {
                BannerViewPager.this.handlePosition();
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        BannerManager bannerManager = new BannerManager();
        this.mBannerManager = bannerManager;
        bannerManager.initAttrs(context, attributeSet);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.bvp_layout, this);
        this.mViewPager = (CatchViewPager) findViewById(R.id.vp_main);
        this.mIndicatorLayout = (RelativeLayout) findViewById(R.id.bvp_layout_indicator);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stopLoop();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startLoop();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int x = (int) motionEvent.getX();
                    int abs = Math.abs(x - this.startX);
                    int abs2 = Math.abs(((int) motionEvent.getY()) - this.startY);
                    if (abs > abs2) {
                        if (!isCanLoop()) {
                            int i = this.currentPosition;
                            if (i == 0 && x - this.startX > 0) {
                                getParent().requestDisallowInterceptTouchEvent(false);
                            } else if (i != getList().size() - 1 || x - this.startX >= 0) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            } else {
                                getParent().requestDisallowInterceptTouchEvent(false);
                            }
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    } else if (abs * 2 < abs2) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else if (action != 3) {
                    if (action == 4) {
                        setLooping(false);
                        startLoop();
                    }
                }
            }
            setLooping(false);
            startLoop();
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            setLooping(true);
            stopLoop();
            this.startX = (int) motionEvent.getX();
            this.startY = (int) motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onPageSelected(int i) {
        int listSize = this.mBannerPagerAdapter.getListSize();
        this.currentPosition = BannerUtils.getRealPosition(isCanLoop(), i, listSize);
        if ((listSize > 0 && isCanLoop() && i == 0) || i == 499) {
            setCurrentItem(this.currentPosition, false);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(this.currentPosition);
        }
        IIndicator iIndicator = this.mIndicatorView;
        if (iIndicator != null) {
            iIndicator.onPageSelected(this.currentPosition);
        }
    }

    public void onPageScrollStateChanged(int i) {
        IIndicator iIndicator = this.mIndicatorView;
        if (iIndicator != null) {
            iIndicator.onPageScrollStateChanged(i);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        int listSize = this.mBannerPagerAdapter.getListSize();
        int realPosition = BannerUtils.getRealPosition(isCanLoop(), i, listSize);
        if (listSize > 0) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(realPosition, f, i2);
            }
            IIndicator iIndicator = this.mIndicatorView;
            if (iIndicator != null) {
                iIndicator.onPageScrolled(realPosition, f, i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handlePosition() {
        if (this.mBannerPagerAdapter.getListSize() > 1) {
            int currentItem = this.mViewPager.getCurrentItem() + 1;
            this.currentPosition = currentItem;
            this.mViewPager.setCurrentItem(currentItem);
            this.mHandler.postDelayed(this.mRunnable, (long) getInterval());
        }
    }

    private void initBannerData(List<T> list) {
        if (list != null) {
            setIndicatorValues(list);
            setupViewPager(list);
            initRoundCorner();
        }
    }

    private void setIndicatorValues(List<T> list) {
        IIndicator iIndicator;
        BannerOptions bannerOptions = this.mBannerManager.bannerOptions();
        bannerOptions.resetIndicatorOptions();
        if (!this.isCustomIndicator || (iIndicator = this.mIndicatorView) == null) {
            initIndicator(new IndicatorView(getContext()));
        } else {
            initIndicator(iIndicator);
        }
        this.mIndicatorView.setIndicatorOptions(bannerOptions.getIndicatorOptions());
        bannerOptions.getIndicatorOptions().setPageSize(list.size());
        this.mIndicatorView.notifyDataChanged();
    }

    private void initIndicator(IIndicator iIndicator) {
        this.mIndicatorLayout.setVisibility(this.mBannerManager.bannerOptions().getIndicatorVisibility());
        this.mIndicatorView = iIndicator;
        if (((View) iIndicator).getParent() == null) {
            this.mIndicatorLayout.removeAllViews();
            this.mIndicatorLayout.addView((View) this.mIndicatorView);
            initIndicatorViewMargin();
            initIndicatorGravity();
        }
    }

    private void initIndicatorGravity() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((View) this.mIndicatorView).getLayoutParams();
        int indicatorGravity = this.mBannerManager.bannerOptions().getIndicatorGravity();
        if (indicatorGravity == 0) {
            layoutParams.addRule(14);
        } else if (indicatorGravity == 2) {
            layoutParams.addRule(9);
        } else if (indicatorGravity == 4) {
            layoutParams.addRule(11);
        }
    }

    private void initIndicatorViewMargin() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((View) this.mIndicatorView).getLayoutParams();
        BannerOptions.IndicatorMargin indicatorMargin = this.mBannerManager.bannerOptions().getIndicatorMargin();
        if (indicatorMargin == null) {
            int dp2px = BannerUtils.dp2px(10.0f);
            marginLayoutParams.setMargins(dp2px, dp2px, dp2px, dp2px);
            return;
        }
        marginLayoutParams.setMargins(indicatorMargin.getLeft(), indicatorMargin.getTop(), indicatorMargin.getRight(), indicatorMargin.getBottom());
    }

    private void initRoundCorner() {
        int roundRectRadius = this.mBannerManager.bannerOptions().getRoundRectRadius();
        if (roundRectRadius > 0 && Build.VERSION.SDK_INT >= 21) {
            new ViewStyleSetter(this).setRoundRect((float) roundRectRadius);
        }
    }

    private void setupViewPager(List<T> list) {
        Objects.requireNonNull(this.holderCreator, "You must set HolderCreator for BannerViewPager");
        this.currentPosition = 0;
        this.mViewPager.setAdapter(getPagerAdapter(list));
        if (list.size() > 1 && isCanLoop()) {
            this.mViewPager.setCurrentItem((250 - (250 % list.size())) + 1);
        }
        this.mViewPager.removeOnPageChangeListener(this);
        this.mViewPager.addOnPageChangeListener(this);
        BannerOptions bannerOptions = this.mBannerManager.bannerOptions();
        this.mViewPager.setScrollDuration(bannerOptions.getScrollDuration());
        this.mViewPager.disableTouchScroll(bannerOptions.isDisableTouchScroll());
        this.mViewPager.setFirstLayout(true);
        this.mViewPager.setOffscreenPageLimit(this.mBannerManager.bannerOptions().getOffScreenPageLimit());
        initPageStyle();
        startLoop();
    }

    private PagerAdapter getPagerAdapter(List<T> list) {
        BannerPagerAdapter<T, VH> bannerPagerAdapter = new BannerPagerAdapter<>(list, this.holderCreator);
        this.mBannerPagerAdapter = bannerPagerAdapter;
        bannerPagerAdapter.setCanLoop(isCanLoop());
        this.mBannerPagerAdapter.setPageClickListener(new BannerPagerAdapter.PageClickListener() {
            public void onPageClick(int i) {
                if (BannerViewPager.this.mOnPageClickListener != null) {
                    BannerViewPager.this.mOnPageClickListener.onPageClick(i);
                }
            }
        });
        return this.mBannerPagerAdapter;
    }

    private void initPageStyle() {
        int pageStyle = this.mBannerManager.bannerOptions().getPageStyle();
        if (pageStyle == 2) {
            setMultiPageStyle(false, 0.999f);
        } else if (pageStyle == 4) {
            setMultiPageStyle(true, 0.85f);
        } else if (pageStyle == 8) {
            setMultiPageStyle(false, 0.85f);
        }
    }

    private void setMultiPageStyle(boolean z, float f) {
        setClipChildren(false);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mViewPager.getLayoutParams();
        BannerOptions bannerOptions = this.mBannerManager.bannerOptions();
        marginLayoutParams.leftMargin = bannerOptions.getPageMargin() + bannerOptions.getRevealWidth();
        marginLayoutParams.rightMargin = marginLayoutParams.leftMargin;
        this.mViewPager.setOverlapStyle(z);
        this.mViewPager.setPageMargin(z ? -bannerOptions.getPageMargin() : bannerOptions.getPageMargin());
        this.mViewPager.setOffscreenPageLimit(Math.max(bannerOptions.getOffScreenPageLimit(), 2));
        setPageTransformer(new ScaleInTransformer(f));
    }

    private int getInterval() {
        return this.mBannerManager.bannerOptions().getInterval();
    }

    private boolean isAutoPlay() {
        return this.mBannerManager.bannerOptions().isAutoPlay();
    }

    private boolean isLooping() {
        return this.mBannerManager.bannerOptions().isLooping();
    }

    private void setLooping(boolean z) {
        this.mBannerManager.bannerOptions().setLooping(z);
    }

    private boolean isCanLoop() {
        return this.mBannerManager.bannerOptions().isCanLoop();
    }

    public List<T> getList() {
        return this.mBannerPagerAdapter.getList();
    }

    public void startLoop() {
        BannerPagerAdapter<T, VH> bannerPagerAdapter;
        if (!isLooping() && isAutoPlay() && (bannerPagerAdapter = this.mBannerPagerAdapter) != null && bannerPagerAdapter.getListSize() > 1) {
            this.mHandler.postDelayed(this.mRunnable, (long) getInterval());
            setLooping(true);
        }
    }

    public void stopLoop() {
        if (isLooping()) {
            this.mHandler.removeCallbacks(this.mRunnable);
            setLooping(false);
        }
    }

    public BannerViewPager<T, VH> setHolderCreator(HolderCreator<VH> holderCreator2) {
        this.holderCreator = holderCreator2;
        return this;
    }

    public BannerViewPager<T, VH> setRoundCorner(int i) {
        this.mBannerManager.bannerOptions().setRoundRectRadius(i);
        return this;
    }

    public BannerViewPager<T, VH> setRoundRect(int i) {
        setRoundCorner(i);
        return this;
    }

    public BannerViewPager<T, VH> setAutoPlay(boolean z) {
        this.mBannerManager.bannerOptions().setAutoPlay(z);
        if (isAutoPlay()) {
            this.mBannerManager.bannerOptions().setCanLoop(true);
        }
        return this;
    }

    public BannerViewPager<T, VH> setCanLoop(boolean z) {
        this.mBannerManager.bannerOptions().setCanLoop(z);
        if (!z) {
            this.mBannerManager.bannerOptions().setAutoPlay(false);
        }
        return this;
    }

    public BannerViewPager<T, VH> setInterval(int i) {
        this.mBannerManager.bannerOptions().setInterval(i);
        return this;
    }

    public BannerViewPager<T, VH> setPageTransformerStyle(int i) {
        this.mViewPager.setPageTransformer(true, new PageTransformerFactory().createPageTransformer(i));
        return this;
    }

    public void setPageTransformer(ViewPager.PageTransformer pageTransformer) {
        this.mViewPager.setPageTransformer(true, pageTransformer);
    }

    public BannerViewPager<T, VH> setOnPageClickListener(OnPageClickListener onPageClickListener) {
        this.mOnPageClickListener = onPageClickListener;
        return this;
    }

    public BannerViewPager<T, VH> setScrollDuration(int i) {
        this.mBannerManager.bannerOptions().setScrollDuration(i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorSliderColor(int i, int i2) {
        this.mBannerManager.bannerOptions().setIndicatorSliderColor(i, i2);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorSliderRadius(int i) {
        setIndicatorSliderRadius(i, i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorSliderRadius(int i, int i2) {
        this.mBannerManager.bannerOptions().setIndicatorSliderWidth(i * 2, i2 * 2);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorSliderWidth(int i) {
        setIndicatorSliderWidth(i, i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorSliderWidth(int i, int i2) {
        this.mBannerManager.bannerOptions().setIndicatorSliderWidth(i, i2);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorHeight(int i) {
        this.mBannerManager.bannerOptions().setIndicatorHeight(i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorSliderGap(int i) {
        this.mBannerManager.bannerOptions().setIndicatorGap((float) i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorVisibility(int i) {
        this.mBannerManager.bannerOptions().setIndicatorVisibility(i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorGravity(int i) {
        this.mBannerManager.bannerOptions().setIndicatorGravity(i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorSlideMode(int i) {
        this.mBannerManager.bannerOptions().setIndicatorSlideMode(i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorView(IIndicator iIndicator) {
        if (iIndicator instanceof View) {
            this.isCustomIndicator = true;
            this.mIndicatorView = iIndicator;
        }
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorStyle(int i) {
        this.mBannerManager.bannerOptions().setIndicatorStyle(i);
        return this;
    }

    public void create(List<T> list) {
        initBannerData(list);
    }

    public int getCurrentItem() {
        return this.currentPosition;
    }

    public void setCurrentItem(int i) {
        if (!isCanLoop() || this.mBannerPagerAdapter.getListSize() <= 1) {
            this.mViewPager.setCurrentItem(i);
        } else {
            this.mViewPager.setCurrentItem((250 - (250 % this.mBannerPagerAdapter.getListSize())) + 1 + i);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        if (!isCanLoop() || this.mBannerPagerAdapter.getListSize() <= 1) {
            this.mViewPager.setCurrentItem(i, z);
        } else {
            this.mViewPager.setCurrentItem((250 - (250 % this.mBannerPagerAdapter.getListSize())) + 1 + i, z);
        }
    }

    public BannerViewPager<T, VH> setPageStyle(int i) {
        this.mBannerManager.bannerOptions().setPageStyle(i);
        return this;
    }

    public BannerViewPager<T, VH> setPageMargin(int i) {
        this.mBannerManager.bannerOptions().setPageMargin(i);
        this.mViewPager.setPageMargin(i);
        return this;
    }

    public BannerViewPager<T, VH> setRevealWidth(int i) {
        this.mBannerManager.bannerOptions().setRevealWidth(i);
        return this;
    }

    @Deprecated
    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public BannerViewPager<T, VH> setOffScreenPageLimit(int i) {
        this.mBannerManager.bannerOptions().setOffScreenPageLimit(i);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorMargin(int i, int i2, int i3, int i4) {
        this.mBannerManager.bannerOptions().setIndicatorMargin(i, i2, i3, i4);
        return this;
    }

    public BannerViewPager<T, VH> disableTouchScroll(boolean z) {
        this.mBannerManager.bannerOptions().setDisableTouchScroll(z);
        return this;
    }

    public BannerViewPager<T, VH> setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        return this;
    }

    @Deprecated
    public BannerViewPager<T, VH> setIndicatorRadius(int i, int i2) {
        this.mBannerManager.bannerOptions().setIndicatorSliderWidth(i * 2, i2 * 2);
        return this;
    }

    @Deprecated
    public BannerViewPager<T, VH> setIndicatorRadius(int i) {
        setIndicatorSliderRadius(i, i);
        return this;
    }

    @Deprecated
    public BannerViewPager<T, VH> setIndicatorWidth(int i) {
        setIndicatorSliderWidth(i, i);
        return this;
    }

    @Deprecated
    public BannerViewPager<T, VH> setIndicatorWidth(int i, int i2) {
        this.mBannerManager.bannerOptions().setIndicatorSliderWidth(i, i2);
        return this;
    }

    @Deprecated
    public BannerViewPager<T, VH> setIndicatorColor(int i, int i2) {
        this.mBannerManager.bannerOptions().setIndicatorSliderColor(i, i2);
        return this;
    }

    public BannerViewPager<T, VH> setIndicatorGap(int i) {
        this.mBannerManager.bannerOptions().setIndicatorGap((float) i);
        return this;
    }

    @Deprecated
    public BannerViewPager<T, VH> showIndicator(boolean z) {
        this.mIndicatorLayout.setVisibility(z ? 0 : 8);
        return this;
    }
}
