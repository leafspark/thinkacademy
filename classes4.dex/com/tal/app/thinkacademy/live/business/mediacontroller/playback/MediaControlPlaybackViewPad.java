package com.tal.app.thinkacademy.live.business.mediacontroller.playback;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.adapter.CommonAdapter;
import com.tal.app.thinkacademy.lib.commui.adapter.MultiItemTypeAdapter;
import com.tal.app.thinkacademy.lib.commui.adapter.ViewHolder;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.constant.CacheConstants;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import java.util.ArrayList;

public class MediaControlPlaybackViewPad extends MediaControlBasePlaybackView {
    private static final int DEFAULT_SEEKBAR_VALUE = 1000;
    private static final float DEFAULT_SPEED = 1.0f;
    /* access modifiers changed from: private */
    public float mCurrentSpeed = DEFAULT_SPEED;
    private ImageView mIvForward;
    private ImageView mIvNext;
    private ImageView mIvPause;
    private ImageView mIvScreenshot;
    private ImageView mIvSpeed;
    private RecyclerView mLlModeChange;
    private RecyclerView mLvSpeed;
    private RelativeLayout mRlKeyTip;
    private SeekBar mSbProcess;
    /* access modifiers changed from: private */
    public CommonAdapter mSpeedListAdapter;
    /* access modifiers changed from: private */
    public EasyPopup mSpeedPopWindow;
    /* access modifiers changed from: private */
    public TextView mTvCurrent;
    private TextView mTvTotal;
    private CommonAdapter mVideoChangeAdapter;
    private EasyPopup mVideoChangeWindow;
    ArrayList<String> mVideoModels = new ArrayList<>();

    public MediaControlPlaybackViewPad(Context context) {
        super(context);
        initListener();
    }

    public MediaControlPlaybackViewPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaControlPlaybackViewPad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setBottomControlVisible(boolean z) {
        if (this.bottomRoot == null) {
            return;
        }
        if (z) {
            this.bottomRoot.setVisibility(0);
        } else {
            this.bottomRoot.setVisibility(4);
        }
    }

    public int getLayoutId() {
        return R.layout.live_business_view_media_controller_playback_pad;
    }

    public void initViews() {
        super.initViews();
        findViewById(R.id.img_live_business_live_screenshot).setVisibility(8);
        this.topRoot = findViewById(R.id.rl_media_controller_root_top);
        this.bottomRoot = findViewById(R.id.rl_playback_media_controller_root_bottom);
        this.mIvForward = (ImageView) findViewById(R.id.iv_live_business_media_controller_forward_sign);
        this.mIvPause = (ImageView) findViewById(R.id.iv_live_business_media_controller_controls_playpause);
        this.mIvNext = (ImageView) findViewById(R.id.iv_live_business_media_controller_next_sign);
        this.mIvScreenshot = (ImageView) findViewById(R.id.img_live_business_playback_screenshot);
        this.mIvSpeed = (ImageView) findViewById(R.id.iv_live_business_media_controller_controls_speed);
        this.mTvCurrent = (TextView) findViewById(R.id.tv_live_business_media_controller_controls_timecurrent);
        this.mTvTotal = (TextView) findViewById(R.id.tv_live_business_media_controller_controls_timetotal);
        this.mSbProcess = (SeekBar) findViewById(R.id.sbar_live_business_media_controller_controls);
        this.mRlKeyTip = (RelativeLayout) findViewById(R.id.rl_live_business_media_controller_keytip);
        setContentLayoutParams();
    }

    public void setContentLayoutParams() {
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bottomRoot.getLayoutParams();
        pptLp.mergeLp(layoutParams);
        layoutParams.height = SizeUtils.dp2px(61.0f);
        this.bottomRoot.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ivPreview.getLayoutParams();
        layoutParams2.setMarginStart((pptLp.left + pptLp.width) - SizeUtils.dp2px(170.0f));
        layoutParams2.bottomMargin = SizeUtils.dp2px(54.0f);
        layoutParams2.gravity = 80;
        this.ivPreview.setLayoutParams(layoutParams2);
    }

    public void initData() {
        super.initData();
        this.mSbProcess.setMax(1000);
        this.mSbProcess.setThumb(ResourcesCompat.getDrawable(getResources(), R.drawable.live_business_icon_playback_seekbar_thumb, (Resources.Theme) null));
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        super.initListener();
        this.mIvForward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlPlaybackViewPad.class);
                MediaControlPlaybackViewPad.this.mMediaCtrListener.onForwardClickListener(view);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mIvPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlPlaybackViewPad.class);
                MediaControlPlaybackViewPad.this.togglePlayerState();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mIvNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlPlaybackViewPad.class);
                MediaControlPlaybackViewPad.this.mMediaCtrListener.onNextClickListener(view);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mIvScreenshot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlPlaybackViewPad.class);
                MediaControlPlaybackViewPad.this.mMediaCtrListener.onScreenshotClickListener(view);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mSbProcess.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long j = (MediaControlPlaybackViewPad.this.mDuration * ((long) i)) / 1000;
                    MediaControlPlaybackViewPad.this.mTvCurrent.setText(MediaControlPlaybackViewPad.this.generateTime(j));
                    MediaControlPlaybackViewPad.this.mMediaCtrListener.onProgressChanged(seekBar, j);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaControlPlaybackViewPad.this.mMediaCtrListener.onStartTrackingTouch(seekBar);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                MediaControlPlaybackViewPad.this.mMediaCtrListener.onStopTrackingTouch(seekBar);
                SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            }
        });
        this.mIvSpeed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlPlaybackViewPad.class);
                if (MediaControlPlaybackViewPad.this.mSpeedPopWindow == null) {
                    MediaControlPlaybackViewPad.this.initSpeedPopWindow();
                }
                if (MediaControlPlaybackViewPad.this.mSpeedPopWindow.isShowing()) {
                    MediaControlPlaybackViewPad.this.mSpeedPopWindow.dismiss();
                } else {
                    MediaControlPlaybackViewPad.this.showSpeedSelect();
                }
                MediaControlPlaybackViewPad mediaControlPlaybackViewPad = MediaControlPlaybackViewPad.this;
                mediaControlPlaybackViewPad.setImageSpeedResource(mediaControlPlaybackViewPad.mCurrentSpeed);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void togglePlayerState() {
        if (this.isPause) {
            this.mMediaCtrListener.onPlayClickListener();
        } else {
            this.mMediaCtrListener.onPauseClickListener();
        }
    }

    public void updatePauseIcon(boolean z) {
        if (z) {
            this.mIvPause.setImageResource(R.drawable.live_business_playback_mediactr_pause);
        } else {
            this.mIvPause.setImageResource(R.drawable.live_business_playback_mediactr_play);
        }
        this.isPause = !z;
    }

    public void setVideoModels(ArrayList<String> arrayList) {
        this.mVideoModels = arrayList;
    }

    public void setViewVisible(boolean z) {
        int i = z ? 0 : 8;
        ImageView imageView = this.mIvForward;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
        ImageView imageView2 = this.mIvNext;
        if (imageView2 != null) {
            imageView2.setVisibility(i);
        }
    }

    public void setProgress(long j, long j2) {
        if (this.mDuration != j2) {
            this.mDuration = j2;
            this.mTvTotal.setText(generateTime(j2));
        }
        setProgress(j);
    }

    public void setProgress(long j) {
        this.mTvCurrent.setText(generateTime(j));
        if (this.mDuration > 0) {
            this.mSbProcess.setProgress((int) ((1000 * j) / this.mDuration));
            updateProgress(j);
        }
    }

    /* access modifiers changed from: private */
    public String generateTime(long j) {
        int i = (int) (j / 1000);
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(i / CacheConstants.HOUR), Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60)});
    }

    public void onHide() {
        EasyPopup easyPopup = this.mSpeedPopWindow;
        if (easyPopup != null && easyPopup.isShowing()) {
            this.mSpeedPopWindow.dismiss();
        }
        EasyPopup easyPopup2 = this.mVideoChangeWindow;
        if (easyPopup2 != null && easyPopup2.isShowing()) {
            this.mVideoChangeWindow.dismiss();
        }
    }

    public void onShow() {
        this.mIvPause.requestFocus();
    }

    /* access modifiers changed from: private */
    public void setImageSpeedResource(float f) {
        if (f == 0.8f) {
            this.mIvSpeed.setImageResource(R.drawable.live_business_selector_playback_speed_0_8x_pad);
        } else if (f == DEFAULT_SPEED) {
            this.mIvSpeed.setImageResource(R.drawable.live_business_selector_playback_speed_1_0x_pad);
        } else if (f == 1.25f) {
            this.mIvSpeed.setImageResource(R.drawable.live_business_selector_playback_speed_1_25x_pad);
        } else if (f == 1.5f) {
            this.mIvSpeed.setImageResource(R.drawable.live_business_selector_playback_speed_1_5x_pad);
        } else {
            this.mIvSpeed.setImageResource(R.drawable.live_business_selector_playback_speed_2_0x_pad);
        }
        EasyPopup easyPopup = this.mSpeedPopWindow;
        if (easyPopup != null) {
            this.mIvSpeed.setSelected(easyPopup.isShowing());
        }
    }

    /* access modifiers changed from: private */
    public void initSpeedPopWindow() {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.8f));
        arrayList.add(Float.valueOf(DEFAULT_SPEED));
        arrayList.add(Float.valueOf(1.25f));
        arrayList.add(Float.valueOf(1.5f));
        arrayList.add(Float.valueOf(2.0f));
        View inflate = XMLParseInstrumentation.inflate(getContext(), R.layout.live_business_playspeed_popwindow_layout, (ViewGroup) null);
        EasyPopup easyPopup = new EasyPopup(this.mContext);
        this.mSpeedPopWindow = easyPopup;
        easyPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                MediaControlPlaybackViewPad mediaControlPlaybackViewPad = MediaControlPlaybackViewPad.this;
                mediaControlPlaybackViewPad.setImageSpeedResource(mediaControlPlaybackViewPad.mCurrentSpeed);
            }
        });
        this.mSpeedPopWindow.setContentView(inflate, -2, -2).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).createPopup();
        RecyclerView findViewById = inflate.findViewById(R.id.live_business_lv_playspeed);
        this.mLvSpeed = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.mContext));
        AnonymousClass8 r2 = new CommonAdapter<Float>(this.mContext, R.layout.live_business_playback_pop_item, arrayList) {
            /* access modifiers changed from: protected */
            public void convert(ViewHolder viewHolder, Float f, int i) {
                int i2 = R.id.live_business_playback_pop_item;
                viewHolder.setText(i2, f.toString() + "x");
                if (MediaControlPlaybackViewPad.this.mCurrentSpeed == f.floatValue()) {
                    viewHolder.getView(R.id.live_business_playback_pop_item).setSelected(true);
                } else {
                    viewHolder.getView(R.id.live_business_playback_pop_item).setSelected(false);
                }
            }
        };
        this.mSpeedListAdapter = r2;
        this.mLvSpeed.setAdapter(r2);
        this.mSpeedListAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                return false;
            }

            public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                float floatValue = ((Float) arrayList.get(i)).floatValue();
                MediaControlPlaybackViewPad.this.mSpeedPopWindow.dismiss();
                if (floatValue != MediaControlPlaybackViewPad.this.mCurrentSpeed) {
                    MediaControlPlaybackViewPad.this.mMediaCtrListener.onSpeedChangeListener(floatValue);
                    float unused = MediaControlPlaybackViewPad.this.mCurrentSpeed = floatValue;
                    viewHolder.itemView.setSelected(true);
                    MediaControlPlaybackViewPad mediaControlPlaybackViewPad = MediaControlPlaybackViewPad.this;
                    mediaControlPlaybackViewPad.setImageSpeedResource(mediaControlPlaybackViewPad.mCurrentSpeed);
                    MediaControlPlaybackViewPad.this.mSpeedListAdapter.notifyDataSetChanged();
                }
            }
        });
        inflate.measure(0, 0);
    }

    /* access modifiers changed from: private */
    public void showSpeedSelect() {
        int[] iArr = new int[2];
        this.mIvSpeed.getLocationInWindow(iArr);
        int measuredWidth = (iArr[0] - ((this.mSpeedPopWindow.getContentView().getMeasuredWidth() - this.mIvSpeed.getMeasuredWidth()) / 2)) - (this.mSpeedPopWindow.getContentView().getMeasuredWidth() / 3);
        int measuredHeight = (iArr[1] - this.mSpeedPopWindow.getContentView().getMeasuredHeight()) - SizeUtils.dp2px(20.0f);
        this.mSpeedPopWindow.showAtLocation(this.mIvSpeed, 0, measuredWidth - SizeUtils.dp2px(8.0f), measuredHeight);
    }

    public void startAnim(boolean z) {
        int i;
        if (this.topRoot != null) {
            this.topRoot.clearAnimation();
            if (z) {
                i = 0;
            } else {
                i = -this.topRoot.getHeight();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.topRoot, "translationY", new float[]{this.topRoot.getTranslationY(), (float) i});
            ofFloat.setDuration(300);
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                }
            });
            ofFloat.start();
        }
    }

    public void hide() {
        super.hide();
        lambda$new$1$BaseMediaControlView();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }
}
