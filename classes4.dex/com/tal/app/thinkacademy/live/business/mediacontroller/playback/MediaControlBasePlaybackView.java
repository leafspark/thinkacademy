package com.tal.app.thinkacademy.live.business.mediacontroller.playback;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.KeyboardUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel;
import com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData;
import com.tal.app.thinkacademy.live.abilitypack.playback.listenbody.PlaybackListenerBody;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.common.bridges.PlayerActionBridge;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.IMediaCtrListener;
import com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.IFeedbackAction;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;
import com.tal.app.thinkcademy.lib.commui.widget.ViewState;
import java.util.List;
import org.json.JSONObject;

public abstract class MediaControlBasePlaybackView extends BaseMediaControlView implements IFeedbackAction {
    protected MediaControlPlaybackDriver driver;
    protected boolean isPause = false;
    protected long mDuration;
    private ImageView mFeedBackBtn;
    private EasyPopup mFeedbackPopup = null;
    private FeedBackPlayBackView mFeedbackView = null;
    private boolean mIsFeedback = false;
    private boolean mIsInitPageIndexListView = false;
    /* access modifiers changed from: private */
    public StateImageView mIvOption;
    protected IMediaCtrListener mMediaCtrListener;
    protected PlaybackViewModel mPlaybackViewModel = AbilityPack.get().getViewModel(PlaybackViewModel.class);
    private FrameLayout mRlPoint;
    private ImageView mSwitchLineBtn;

    public abstract void setBottomControlVisible(boolean z);

    public void updateNetwork() {
    }

    public MediaControlBasePlaybackView(Context context) {
        super(context);
    }

    public MediaControlBasePlaybackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaControlBasePlaybackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDriver(MediaControlPlaybackDriver mediaControlPlaybackDriver) {
        this.driver = mediaControlPlaybackDriver;
        super.setDriver(mediaControlPlaybackDriver);
        PlaybackViewModel playbackViewModel = this.mPlaybackViewModel;
        if (playbackViewModel != null && playbackViewModel.isOpenPageIndex()) {
            this.mIvOption.setVisibility(0);
            this.mRlPoint.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setMediaCtrListener(IMediaCtrListener iMediaCtrListener) {
        this.mMediaCtrListener = iMediaCtrListener;
    }

    public void initViews() {
        super.initViews();
        ImageView imageView = (ImageView) findViewById(R.id.iv_media_controller_switch_line);
        this.mSwitchLineBtn = imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.mSwitchLineBtn.setOnClickListener(new MediaControlBasePlaybackView$$ExternalSyntheticLambda1(this));
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_media_controller_feedback);
        this.mFeedBackBtn = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, MediaControlBasePlaybackView.class);
                    MediaControlBasePlaybackView.this.showFeedbackPopUpWindow();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
        this.mIvOption = findViewById(R.id.iv_live_business_media_controller_controls_option);
        this.mRlPoint = (FrameLayout) findViewById(R.id.rl_live_business_media_controller_keypoints);
    }

    public /* synthetic */ void lambda$initViews$0$MediaControlBasePlaybackView(View view) {
        showSwitchLineDialog();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        super.initListener();
        this.mIvOption.setOnClickListener(new MediaControlBasePlaybackView$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$initListener$1$MediaControlBasePlaybackView(View view) {
        if (this.mIvOption.isState(ViewState.ONE)) {
            this.mIvOption.changeState(ViewState.ONE, false);
            PlaybackViewModel playbackViewModel = this.mPlaybackViewModel;
            if (playbackViewModel != null) {
                playbackViewModel.showPageIndexes(false);
            }
        } else {
            this.mIvOption.changeState(ViewState.ONE, true);
            PlaybackViewModel playbackViewModel2 = this.mPlaybackViewModel;
            if (playbackViewModel2 != null) {
                playbackViewModel2.showPageIndexes(true);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setupPageIndexView(long j) {
        PlaybackViewModel playbackViewModel = this.mPlaybackViewModel;
        if (playbackViewModel != null && playbackViewModel.isOpenPageIndex() && !this.mIsInitPageIndexListView) {
            int width = this.mRlPoint.getWidth();
            int height = this.mRlPoint.getHeight();
            Tag tag = Tag.PLAYBACK_PAGE_INDEX;
            XesLog.i(tag, "初始化进度条翻页索引点 duration:" + j + "width: " + width);
            PlaybackViewModel playbackViewModel2 = this.mPlaybackViewModel;
            if (playbackViewModel2 != null && j > 0 && width > 0) {
                List<PageIndexData> pageIndexList = playbackViewModel2.getPageIndexList();
                if (pageIndexList.size() != 0) {
                    this.mRlPoint.removeAllViews();
                    this.mIsInitPageIndexListView = true;
                    Tag tag2 = Tag.PLAYBACK_PAGE_INDEX;
                    XesLog.i(tag2, "获取翻页索引点数据 size:" + pageIndexList.size());
                    for (PageIndexData offsetTs : pageIndexList) {
                        float offsetTs2 = (((float) offsetTs.getOffsetTs()) * 1000.0f) / ((float) j);
                        View view = new View(getContext());
                        view.setBackgroundResource(R.drawable.bg_live_business_shape_circle_white);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(height, height);
                        layoutParams.leftMargin = (int) (offsetTs2 * ((float) width));
                        this.mRlPoint.addView(view, layoutParams);
                    }
                    this.mPlaybackViewModel.getMListenerData().observeSticky(this.driver, false, new Observer<PlaybackListenerBody>() {
                        public void onChanged(PlaybackListenerBody playbackListenerBody) {
                            if (playbackListenerBody instanceof PlaybackListenerBody.PageIndexSelected) {
                                MediaControlBasePlaybackView.this.mIvOption.changeState(ViewState.ONE, false);
                                PageIndexData data = ((PlaybackListenerBody.PageIndexSelected) playbackListenerBody).getData();
                                Tag tag = Tag.PLAYBACK_PAGE_INDEX;
                                XesLog.i(tag, "翻页索引列表点击回调：" + data);
                                PlayerActionBridge.seekTo(getClass(), data.getOffsetTs() * 1000);
                                if (MediaControlBasePlaybackView.this.isPause) {
                                    MediaControlBasePlaybackView.this.driver.seekSeekBarTo(data.getOffsetTs() * 1000);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateProgress(long j) {
        PlaybackViewModel playbackViewModel = this.mPlaybackViewModel;
        if (playbackViewModel != null && playbackViewModel.isOpenPageIndex()) {
            this.mPlaybackViewModel.updatePlayProgress(j);
        }
    }

    public void showFeedbackPopUpWindow() {
        EasyPopup easyPopup = this.mFeedbackPopup;
        if (easyPopup != null) {
            easyPopup.dismiss();
        }
        FeedBackPlayBackView feedBackPlayBackView = new FeedBackPlayBackView(this.mContext);
        this.mFeedbackView = feedBackPlayBackView;
        feedBackPlayBackView.setIAction(this);
        EasyPopup createPopup = new EasyPopup(this.mContext).setContentView((View) this.mFeedbackView).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setWidth(SizeUtils.dp2px(480.0f)).setHeight(-2).setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        KeyboardUtils.hideSoftInput((Activity) MediaControlBasePlaybackView.this.mContext);
                    }
                }, 50);
            }
        }).createPopup();
        this.mFeedbackPopup = createPopup;
        if (createPopup != null) {
            try {
                if (!createPopup.isShowing() && (this.mContext instanceof Activity)) {
                    this.mFeedbackPopup.showAtLocation(((Activity) this.mContext).findViewById(16908290), 17, 0, 0);
                }
            } catch (Exception e) {
                Tag tag = Tag.PLAYBACK_FEEDBACK;
                XesLog.e(tag, "显示问题反馈popwindow失败=" + e);
            }
        }
    }

    public void setScreenShotFilePath(String str) {
        super.setScreenShotFilePath(str);
        if (this.mIsFeedback) {
            XesLog.i(Tag.PLAYBACK_FEEDBACK, "回放问题反馈，收到了截图路径");
            FeedBackPlayBackView feedBackPlayBackView = this.mFeedbackView;
            if (feedBackPlayBackView != null) {
                feedBackPlayBackView.setScreenshot(str);
            }
            this.mIsFeedback = false;
        }
    }

    public void feedbackScreenshot() {
        XesLog.i(Tag.PLAYBACK_FEEDBACK, "回放问题反馈，触发了截图");
        this.mIsFeedback = true;
        this.driver.screenShot(ScreenShotToken.FEEDBACK);
    }

    public void sendFeedbackInfo(JSONObject jSONObject) {
        XesLog.i(Tag.PLAYBACK_FEEDBACK, "回放问题反馈，发送消息，不需要了。");
    }

    public void dismissPopup() {
        XesLog.i(Tag.PLAYBACK_FEEDBACK, "回放问题反馈，点击消失");
        EasyPopup easyPopup = this.mFeedbackPopup;
        if (easyPopup != null) {
            easyPopup.dismiss();
        }
    }

    private void showSwitchLineDialog() {
        PluginEventBus.onEvent(DataBusKey.SHOW_PLAYBACK_SWITCH_LINE, new PluginEventData(getClass(), DataBusKey.SHOW_PLAYBACK_SWITCH_LINE, ""));
    }
}
