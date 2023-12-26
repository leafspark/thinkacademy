package com.tal.app.thinkacademy.live.business.praise;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.praise.bean.CoinEntity;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.Objects;

public class PraisePluginView extends BaseLivePluginView implements View.OnClickListener {
    private boolean mAddAnimListener;
    /* access modifiers changed from: private */
    public boolean mBoxOpen;
    private CoinEntity mCoinEntity;
    private final Runnable mDisappearRunnable;
    private PraisePluginDriver mDriver;
    private Group mGroupMedal;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private ImageView mIvAvatar;
    private ImageView mIvBg;
    private LottieAnimationView mIvBox;
    private ImageView mIvClose;
    private ImageView mIvMedal;
    private ImageView mIvTiny;
    private ConstraintLayout mLayoutPraise;
    private SparseArray<Integer> mMedalArray;
    private boolean mShowCoins;
    private boolean mShowTiny;
    private TextView mTvCoins;
    private TextView mTvContent;
    private TextView mTvName;
    private TextView mTvOnlyCoins;
    private TextView mTvTitle;
    private View mViewBg;
    private final Runnable mZoomRunnable;

    public PraisePluginView(Context context, PraisePluginDriver praisePluginDriver) {
        this(context);
        this.mDriver = praisePluginDriver;
    }

    public PraisePluginView(Context context) {
        super(context);
        this.mShowTiny = true;
        this.mShowCoins = false;
        this.mZoomRunnable = new PraisePluginView$$ExternalSyntheticLambda0(this);
        this.mDisappearRunnable = new Runnable() {
            public void run() {
                PraisePluginView.this.setVisibility(8);
                PraisePluginView.this.mHandler.removeCallbacksAndMessages((Object) null);
            }
        };
    }

    public PraisePluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShowTiny = true;
        this.mShowCoins = false;
        this.mZoomRunnable = new PraisePluginView$$ExternalSyntheticLambda0(this);
        this.mDisappearRunnable = new Runnable() {
            public void run() {
                PraisePluginView.this.setVisibility(8);
                PraisePluginView.this.mHandler.removeCallbacksAndMessages((Object) null);
            }
        };
    }

    public PraisePluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShowTiny = true;
        this.mShowCoins = false;
        this.mZoomRunnable = new PraisePluginView$$ExternalSyntheticLambda0(this);
        this.mDisappearRunnable = new Runnable() {
            public void run() {
                PraisePluginView.this.setVisibility(8);
                PraisePluginView.this.mHandler.removeCallbacksAndMessages((Object) null);
            }
        };
    }

    public int getLayoutId() {
        return R.layout.live_business_praise_view;
    }

    public void initViews() {
        this.mViewBg = findViewById(R.id.v_live_business_bg);
        this.mIvBox = findViewById(R.id.iv_live_business_box);
        this.mIvClose = (ImageView) findViewById(R.id.iv_live_business_praise_close);
        this.mLayoutPraise = findViewById(R.id.ll_live_business_praise);
        this.mIvBg = (ImageView) findViewById(R.id.iv_live_business_bg);
        this.mIvAvatar = (ImageView) findViewById(R.id.iv_live_business_avatar);
        this.mTvName = (TextView) findViewById(R.id.tv_live_business_name);
        this.mTvTitle = (TextView) findViewById(R.id.tv_live_business_title);
        this.mTvContent = (TextView) findViewById(R.id.tv_live_business_content);
        this.mTvOnlyCoins = (TextView) findViewById(R.id.tv_live_business_only_coins);
        this.mGroupMedal = findViewById(R.id.group_live_business_medal);
        this.mIvMedal = (ImageView) findViewById(R.id.iv_live_business_medal);
        this.mTvCoins = (TextView) findViewById(R.id.tv_live_business_coins);
        this.mIvTiny = (ImageView) findViewById(R.id.iv_live_business_praise_tiny);
        this.mIvBox.setOnClickListener(this);
        this.mIvTiny.setOnClickListener(this);
        this.mIvClose.setOnClickListener(this);
    }

    public void initData() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void showBox() {
        this.mBoxOpen = false;
        setVisibility(0);
        SoundPoolUtils.play(getContext(), R.raw.live_business_box_appear, 0);
        this.mViewBg.setVisibility(0);
        this.mIvBox.setVisibility(0);
        this.mLayoutPraise.setVisibility(8);
        this.mIvClose.setVisibility(8);
        this.mIvTiny.setVisibility(8);
        this.mIvBox.setImageAssetsFolder("praise/normal/images");
        this.mIvBox.setAnimation("praise/normal/normal.json");
        this.mIvBox.playAnimation();
        this.mIvBox.setRepeatCount(0);
        removeZoom();
        removeDisappear();
        this.mShowTiny = true;
        this.mShowCoins = false;
        this.mHandler.postDelayed(this.mZoomRunnable, 5000);
    }

    public void showTiny() {
        this.mViewBg.setVisibility(8);
        this.mIvBox.setVisibility(8);
        this.mLayoutPraise.setVisibility(8);
        this.mIvClose.setVisibility(8);
        this.mIvTiny.setVisibility(0);
        this.mHandler.postDelayed(this.mDisappearRunnable, 300000);
    }

    public void refreshLayout() {
        ConstraintLayout.LayoutParams layoutParams;
        if (LiveAreaCompat.isSmallPad() && (layoutParams = this.mIvTiny.getLayoutParams()) != null) {
            LiveAreaLayoutParams funcLp = LiveAreaContext.get().getFuncLp();
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
            layoutParams2.setMarginEnd(funcLp.right + funcLp.width + SizeUtils.dp2px(20.0f));
            layoutParams2.bottomMargin = SizeUtils.dp2px(144.0f);
            layoutParams2.width = SizeUtils.dp2px(48.0f);
            layoutParams2.height = SizeUtils.dp2px(48.0f);
            this.mIvTiny.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    public void showPraise() {
        this.mIvBox.setVisibility(8);
        this.mTvTitle.setText(this.mCoinEntity.getMessageTitle());
        this.mTvContent.setText(this.mCoinEntity.getMessageContent());
        ImageLoaderJ.loadCircle(getContext(), this.mCoinEntity.getAvatar(), this.mIvAvatar, R.drawable.user_icon);
        TextView textView = this.mTvName;
        UserInfo userInfoEntity = UserInfoBll.getInstance().getUserInfoEntity();
        Objects.requireNonNull(userInfoEntity);
        textView.setText(userInfoEntity.getNickName());
        this.mLayoutPraise.setVisibility(0);
        this.mIvClose.setVisibility(0);
        showPraiseAnim();
        if (this.mCoinEntity.getLevel() == 0) {
            SoundPoolUtils.play(getContext(), R.raw.live_business_no_title, 0);
            this.mIvBg.setImageResource(R.drawable.live_business_bg_coins);
            this.mTvOnlyCoins.setVisibility(0);
            this.mGroupMedal.setVisibility(8);
            TextView textView2 = this.mTvOnlyCoins;
            textView2.setText(TextUtils.concat(new CharSequence[]{"+", this.mCoinEntity.getRewardCoin() + ""}));
        } else {
            SoundPoolUtils.play(getContext(), R.raw.live_business_get_title, 0);
            this.mIvBg.setImageResource(R.drawable.live_business_bg_medal);
            this.mTvOnlyCoins.setVisibility(8);
            this.mGroupMedal.setVisibility(0);
            if (this.mMedalArray == null) {
                SparseArray<Integer> sparseArray = new SparseArray<>();
                this.mMedalArray = sparseArray;
                sparseArray.put(1, Integer.valueOf(R.drawable.img_iron_large));
                this.mMedalArray.put(2, Integer.valueOf(R.drawable.img_bronze_large));
                this.mMedalArray.put(3, Integer.valueOf(R.drawable.img_sliver_large));
                this.mMedalArray.put(4, Integer.valueOf(R.drawable.img_gold_large));
                this.mMedalArray.put(5, Integer.valueOf(R.drawable.img_platinum_large));
                this.mMedalArray.put(6, Integer.valueOf(R.drawable.img_diamond_large));
                this.mMedalArray.put(7, Integer.valueOf(R.drawable.img_crown_large));
            }
            this.mIvMedal.setImageResource(this.mMedalArray.get(this.mCoinEntity.getLevel()).intValue());
            TextView textView3 = this.mTvCoins;
            textView3.setText(TextUtils.concat(new CharSequence[]{"+", this.mCoinEntity.getRewardCoin() + ""}));
        }
        removeZoom();
        removeDisappear();
        this.mShowTiny = false;
        this.mHandler.postDelayed(this.mZoomRunnable, 5000);
    }

    public void showCoins(CoinEntity coinEntity) {
        this.mCoinEntity = coinEntity;
        if (coinEntity.getRewardCoin() == 0) {
            setVisibility(8);
            return;
        }
        this.mDriver.updateUserCoins(coinEntity.getUserLatestCoin(), coinEntity.getRewardCoin());
        ShareDataManager.getInstance().put(ShareDataKey.PRAISE_INTERACTID, "", ShareDataManager.SHAREDATA_USER);
        this.mIvBox.setVisibility(0);
        this.mBoxOpen = true;
        this.mIvBox.setImageAssetsFolder("praise/open/images");
        this.mIvBox.setAnimation("praise/open/open.json");
        this.mIvBox.playAnimation();
        this.mIvBox.setRepeatCount(0);
        SoundPoolUtils.play(getContext(), R.raw.live_business_box_open, 0);
        if (!this.mAddAnimListener) {
            this.mIvBox.addAnimatorListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (PraisePluginView.this.mBoxOpen) {
                        PraisePluginView.this.showPraise();
                    }
                }
            });
            this.mAddAnimListener = true;
        }
    }

    private void showPraiseAnim() {
        this.mLayoutPraise.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.praise_show_anim));
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, PraisePluginView.class);
        int id = view.getId();
        if (id == R.id.iv_live_business_praise_tiny) {
            this.mIvTiny.setVisibility(8);
            this.mDriver.submitPraise(0);
        } else if (id == R.id.iv_live_business_box) {
            if (this.mShowCoins) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            }
            SoundPoolUtils.play(getContext(), R.raw.live_business_click_box, 0);
            this.mIvTiny.setVisibility(8);
            this.mShowCoins = true;
            this.mDriver.submitPraise(1);
            removeZoom();
            removeDisappear();
        } else if (id == R.id.iv_live_business_praise_close) {
            setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public /* synthetic */ void lambda$new$0$PraisePluginView() {
        if (this.mShowTiny) {
            showTiny();
            return;
        }
        ShareDataManager.getInstance().put(ShareDataKey.PRAISE_INTERACTID, "", ShareDataManager.SHAREDATA_USER);
        setVisibility(8);
        this.mDriver.onDestroy();
    }

    public void removeZoom() {
        this.mHandler.removeCallbacks(this.mZoomRunnable);
    }

    public void removeDisappear() {
        this.mHandler.removeCallbacks(this.mDisappearRunnable);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        PraisePluginView.super.onDetachedFromWindow();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
    }
}
