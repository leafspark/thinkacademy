package com.tal.app.thinkacademy.live.business.gift.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.gift.IActionListener;
import com.tal.app.thinkacademy.live.business.gift.IitemListener;
import com.tal.app.thinkacademy.live.business.gift.adapter.GiftAdapter;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftBean;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftSendBean;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftStatusBean;
import com.tal.app.thinkacademy.live.business.gift.driver.GiftLivePluginDriver;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.List;

public class GiftLivePluginView extends BaseLivePluginView implements View.OnClickListener, IitemListener {
    private IActionListener actionListener;
    private ConstraintLayout clWindow;
    private GiftLivePluginDriver driver;
    private FrameLayout flIndicator;
    /* access modifiers changed from: private */
    public GiftAdapter giftAdapter;
    private GiftBean giftBean;
    private int[] giftIcons = {R.drawable.icon_donut, R.drawable.icon_heart, R.drawable.icon_star};
    private GiftSendBean giftSendBean;
    private GiftStatusBean giftStatusBean;
    private Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public GiftIndicator indicatorView;
    private boolean isPad;
    private GiftItemDecoration itemDecoration;
    private ImageView ivClose;
    private ImageView ivToast;
    private ImageView lavOpen;
    /* access modifiers changed from: private */
    public int preSelectIndex = -1;
    /* access modifiers changed from: private */
    public int rightSpace;
    /* access modifiers changed from: private */
    public RelativeLayout rlToast;
    private Runnable runnable = new Runnable() {
        public void run() {
            GiftLivePluginView.this.rlToast.setVisibility(8);
        }
    };
    private RecyclerView rvGifts;
    /* access modifiers changed from: private */
    public int selectedIndex = -1;
    private int sendStatus;
    private int sendTimes;
    private TextView tvHint;
    private TextView tvSend;
    private TextView tvToast;
    private TextView tvUserCoins;
    private int userCoins;
    private View vUnSend;

    public void changeGiftChildSelected(int i) {
    }

    public GiftLivePluginView(Context context) {
        super(context);
    }

    public GiftLivePluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GiftLivePluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDriver(GiftLivePluginDriver giftLivePluginDriver) {
        this.driver = giftLivePluginDriver;
    }

    public int getLayoutId() {
        return R.layout.live_business_live_gift_view2;
    }

    public void initViews() {
        GiftLivePluginView.super.initViews();
        this.lavOpen = (ImageView) getInflateView().findViewById(R.id.lav_live_business_gift_window_show);
        this.clWindow = getInflateView().findViewById(R.id.cl_live_business_gift_widow);
        this.ivClose = (ImageView) getInflateView().findViewById(R.id.iv_live_business_gift_window_close);
        this.tvHint = (TextView) getInflateView().findViewById(R.id.tv_live_business_gift_hint);
        this.rvGifts = getInflateView().findViewById(R.id.rv_live_business_gift);
        this.flIndicator = (FrameLayout) getInflateView().findViewById(R.id.fl_gift_indicator);
        this.tvUserCoins = (TextView) getInflateView().findViewById(R.id.tv_live_business_gift_user_coins);
        this.tvSend = (TextView) getInflateView().findViewById(R.id.tv_live_business_gift_send);
        this.vUnSend = getInflateView().findViewById(R.id.tv_live_business_gift_unsend);
        this.ivClose = (ImageView) getInflateView().findViewById(R.id.iv_live_business_gift_window_close);
        this.rlToast = (RelativeLayout) getInflateView().findViewById(R.id.rl_live_business_gift_toast);
        this.ivToast = (ImageView) getInflateView().findViewById(R.id.iv_live_business_gift_send_toast);
        this.tvToast = (TextView) getInflateView().findViewById(R.id.tv_live_business_gift_send_toast);
        this.lavOpen.setOnClickListener(this);
        this.ivClose.setOnClickListener(this);
        this.isPad = PadUtils.isPad(this.mContext);
    }

    public void layoutView() {
        if (!this.isPad) {
            return;
        }
        if (LiveAreaCompat.isSmallPad()) {
            this.clWindow.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.live_business_shape_bg_gift_pad));
            ConstraintLayout.LayoutParams layoutParams = this.clWindow.getLayoutParams();
            layoutParams.width = LiveAreaCompat.pptCenterLp().width;
            this.clWindow.setLayoutParams(layoutParams);
            ConstraintLayout.LayoutParams layoutParams2 = this.lavOpen.getLayoutParams();
            layoutParams2.width = this.mContext.getResources().getDimensionPixelSize(R.dimen.size_48dp);
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.size_48dp);
            layoutParams2.setMarginEnd(LiveAreaContext.get().getFuncLp().width + SizeUtils.dp2px(20.0f));
            layoutParams2.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.size_16dp);
            this.lavOpen.setLayoutParams(layoutParams2);
            return;
        }
        this.clWindow.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.live_business_shape_bg_gift_pad));
        ConstraintLayout.LayoutParams layoutParams3 = this.clWindow.getLayoutParams();
        layoutParams3.setMarginStart(SizeUtils.dp2px(66.0f));
        layoutParams3.setMarginEnd(SizeUtils.dp2px(66.0f));
        this.clWindow.setLayoutParams(layoutParams3);
    }

    public void initData() {
        GiftLivePluginView.super.initData();
    }

    public void setIActionListener(IActionListener iActionListener) {
        this.actionListener = iActionListener;
        requestGiftBean();
    }

    private void requestGiftBean() {
        IActionListener iActionListener = this.actionListener;
        if (iActionListener != null) {
            iActionListener.initGiftList();
        }
    }

    public void setGiftBean(GiftBean giftBean2, UserInfoProxy userInfoProxy) {
        this.giftBean = giftBean2;
        initGiftList(userInfoProxy);
    }

    private void initGiftList(UserInfoProxy userInfoProxy) {
        List<GiftBean.GiftListBean> giftList = this.giftBean.getGiftList();
        this.giftAdapter = new GiftAdapter(getContext(), giftList);
        GiftItemDecoration giftItemDecoration = new GiftItemDecoration();
        this.itemDecoration = giftItemDecoration;
        this.rvGifts.addItemDecoration(giftItemDecoration);
        this.rvGifts.setAdapter(this.giftAdapter);
        this.giftAdapter.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                SoundPoolUtils.play(GiftLivePluginView.this.getContext(), R.raw.live_business_gift_choose, 0);
                int unused = GiftLivePluginView.this.selectedIndex = i;
                GiftLivePluginView.this.giftAdapter.changeSelectIndexState(GiftLivePluginView.this.preSelectIndex, GiftLivePluginView.this.selectedIndex);
                GiftLivePluginView giftLivePluginView = GiftLivePluginView.this;
                int unused2 = giftLivePluginView.preSelectIndex = giftLivePluginView.selectedIndex;
                GiftLivePluginView giftLivePluginView2 = GiftLivePluginView.this;
                giftLivePluginView2.changeGiftWindowHint(giftLivePluginView2.selectedIndex);
                GiftLivePluginView.this.giftAdapter.notifyDataSetChanged();
            }
        });
        int goldNum = userInfoProxy.getGoldNum();
        this.userCoins = goldNum;
        this.tvUserCoins.setText(String.valueOf(goldNum));
        initIndicator(giftList.size());
        initScroll();
        open();
    }

    private void initScroll() {
        this.rvGifts.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                GiftLivePluginView.super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                GiftLivePluginView.super.onScrolled(recyclerView, i, i2);
                GiftLivePluginView.this.indicatorView.setDx(i);
            }
        });
    }

    private void initIndicator(int i) {
        int i2;
        int width = (int) (((double) this.rvGifts.getWidth()) * 0.05d);
        if (PadUtils.isPad(getContext())) {
            i2 = SizeUtils.dp2px(124.0f);
        } else {
            i2 = SizeUtils.dp2px(114.0f);
        }
        GiftIndicator giftIndicator = new GiftIndicator(getContext());
        this.indicatorView = giftIndicator;
        giftIndicator.setCurrWidth(width);
        this.indicatorView.setTotalWidth((int) (((double) ((i2 * i) + this.rightSpace)) * 0.05d));
        this.flIndicator.addView(this.indicatorView);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, GiftLivePluginView.class);
        int id = view.getId();
        if (id == R.id.lav_live_business_gift_window_show) {
            open();
            this.driver.trackClickOpenGift();
        } else if (id == R.id.iv_live_business_gift_window_close) {
            close();
            if (this.selectedIndex >= 0) {
                this.driver.trackClickSendGift(this.giftBean.getGiftList().get(this.selectedIndex), 0);
            }
        } else if (id == R.id.tv_live_business_gift_send) {
            this.driver.track_click_openGift();
            requestSendGift();
            if (this.selectedIndex >= 0) {
                this.driver.trackClickSendGift(this.giftBean.getGiftList().get(this.selectedIndex), 1);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void changeGiftWindowHint(int i) {
        this.selectedIndex = i;
        GiftBean giftBean2 = this.giftBean;
        if (giftBean2 == null) {
            changeGiftSendStatus(false);
        } else if (this.sendTimes >= 3) {
            changeGiftSendStatus(false);
            this.tvHint.setText(R.string.thanks_honey);
        } else if (this.userCoins < giftBean2.getGiftList().get(i).getCoin()) {
            changeGiftSendStatus(false);
            this.tvHint.setText(R.string.not_enough_coins);
        } else {
            changeGiftSendStatus(true);
        }
    }

    private void changeGiftSendStatus(boolean z) {
        if (z) {
            this.vUnSend.setVisibility(8);
            this.tvSend.setOnClickListener(this);
            return;
        }
        this.tvSend.setOnClickListener((View.OnClickListener) null);
        this.vUnSend.setVisibility(0);
    }

    private void open() {
        float f = (float) (-SizeUtils.dp2px(212.0f));
        if (this.isPad) {
            f -= (float) SizeUtils.dp2px(10.0f);
            this.lavOpen.setVisibility(8);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clWindow, View.TRANSLATION_Y, new float[]{0.0f, f});
        ofFloat.setDuration(300);
        ofFloat.start();
    }

    private void close() {
        float f = (float) (-SizeUtils.dp2px(212.0f));
        if (this.isPad) {
            f -= (float) SizeUtils.dp2px(10.0f);
            this.lavOpen.setVisibility(0);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clWindow, View.TRANSLATION_Y, new float[]{f, 0.0f});
        ofFloat.setDuration(300);
        ofFloat.start();
    }

    private void requestSendGift() {
        IActionListener iActionListener = this.actionListener;
        if (iActionListener != null) {
            iActionListener.sendGift(this.giftBean.getGiftList().get(this.selectedIndex));
        }
    }

    public void setGiftSendBean(GiftSendBean giftSendBean2) {
        this.giftSendBean = giftSendBean2;
        updateSendStatus();
        updateUserHint();
        updateUserCoins();
        updateSendTime();
    }

    private void updateSendStatus() {
        this.sendStatus = this.giftSendBean.getSendStatus();
    }

    private void updateUserHint() {
        if (this.sendStatus == 1) {
            this.tvHint.setText(R.string.thanks_for_the_present);
        }
    }

    private void updateUserCoins() {
        int userLatestCoin = this.giftSendBean.getUserLatestCoin();
        this.userCoins = userLatestCoin;
        this.tvUserCoins.setText(String.valueOf(userLatestCoin));
        GiftBean giftBean2 = this.giftBean;
        if (giftBean2 != null && giftBean2.getGiftList() != null && this.userCoins < this.giftBean.getGiftList().get(this.selectedIndex).getCoin()) {
            changeGiftSendStatus(false);
            this.tvHint.setText(R.string.not_enough_coins);
        }
    }

    private void updateSendTime() {
        int sendTimes2 = this.giftSendBean.getSendTimes();
        this.sendTimes = sendTimes2;
        if (sendTimes2 >= 3) {
            this.driver.track_show_send_limit_openGif();
            changeGiftSendStatus(false);
            this.tvHint.setText(R.string.thanks_honey);
        }
    }

    private void showToasWindow() {
        this.handler.removeCallbacks(this.runnable);
        this.rlToast.setVisibility(0);
        ImageLoaderJ.load(getContext(), this.giftBean.getGiftList().get(this.selectedIndex).getIconApp(), this.ivToast, this.giftIcons[this.selectedIndex], (ImageRequestListener<Drawable>) null);
        TextView textView = this.tvToast;
        textView.setText("Send a " + this.giftBean.getGiftList().get(this.selectedIndex).getGiftName());
        this.handler.postDelayed(this.runnable, 3000);
    }

    public void setGiftStatusBean(GiftStatusBean giftStatusBean2) {
        this.giftStatusBean = giftStatusBean2;
        this.sendTimes = giftStatusBean2.getSendTimes();
        this.sendStatus = giftStatusBean2.getSendStatus();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        GiftLivePluginView.super.onAttachedToWindow();
        this.driver.track_show_openGift();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        GiftLivePluginView.super.onDetachedFromWindow();
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    class GiftItemDecoration extends RecyclerView.ItemDecoration {
        GiftItemDecoration() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            GiftLivePluginView.super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                if (PadUtils.isPad(GiftLivePluginView.this.getContext())) {
                    int unused = GiftLivePluginView.this.rightSpace = SizeUtils.dp2px(20.0f);
                    rect.right = GiftLivePluginView.this.rightSpace;
                } else {
                    int unused2 = GiftLivePluginView.this.rightSpace = SizeUtils.dp2px(10.0f);
                    rect.right = GiftLivePluginView.this.rightSpace;
                }
            }
            if (PadUtils.isPad(GiftLivePluginView.this.getContext())) {
                rect.left = SizeUtils.dp2px(20.0f);
            } else {
                rect.left = SizeUtils.dp2px(10.0f);
            }
        }
    }
}
