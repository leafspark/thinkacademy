package com.tal.app.thinkacademy.live.business.mediacontroller.base;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.CommonGestures;
import com.tal.app.thinkacademy.live.core.callback.LiveActivityCallbackAdapter;
import com.tal.app.thinkacademy.live.core.interfaces.ExitLiveRoom;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.lang.ref.WeakReference;

public class BaseGestureView extends BaseLivePluginView {
    protected int brightnessIconResid;
    /* access modifiers changed from: private */
    public boolean canSeek = false;
    Runnable hideRunnable = new Runnable() {
        public void run() {
            BaseGestureView.this.timeRoot.setVisibility(8);
        }
    };
    private float lightProgress;
    LiveActivityCallbackAdapter liveActivityCallback = new LiveActivityCallbackAdapter() {
        public boolean onActivityDispatchKeyEvent(KeyEvent keyEvent) {
            return BaseGestureView.this.onDispatchKeyEvent(keyEvent);
        }
    };
    protected AudioManager mAM;
    /* access modifiers changed from: private */
    public float mBrightness = 0.01f;
    protected Context mContext;
    protected long mCurrentPosition;
    /* access modifiers changed from: private */
    public boolean mDragging;
    protected long mDuration;
    protected CommonGestures mGestures;
    protected ILiveRoomProvider mLiveRoomProvider;
    private int mMaxMusicVolume;
    private int mMaxVoiceVolume;
    protected IMediaControl mMediaControl;
    /* access modifiers changed from: private */
    public int mMusicVolume = 0;
    protected IPlayerControl mPlayerControl;
    protected CommonGestures.GestureTouchListener mTouchListener = new CommonGestures.GestureTouchListener() {
        public void onLeftSlide(float f) {
        }

        public void onRightSlide(float f) {
        }

        public void onScale(float f, int i) {
        }

        public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        }

        public void onGestureBegin() {
            BaseGestureView baseGestureView = BaseGestureView.this;
            float unused = baseGestureView.mBrightness = baseGestureView.window.getAttributes().screenBrightness;
            try {
                BaseGestureView baseGestureView2 = BaseGestureView.this;
                int unused2 = baseGestureView2.mMusicVolume = baseGestureView2.mAM.getStreamVolume(3);
            } catch (Exception e) {
                XesLog.et("CommonGestures", "获取系统音量出错=" + e);
            }
            try {
                BaseGestureView baseGestureView3 = BaseGestureView.this;
                int unused3 = baseGestureView3.mVoiceVolume = baseGestureView3.mAM.getStreamVolume(0);
            } catch (Exception e2) {
                XesLog.et("CommonGestures", "获取mVoiceVolume出错=" + e2);
            }
            if (BaseGestureView.this.mBrightness <= 0.0f) {
                float unused4 = BaseGestureView.this.mBrightness = 0.5f;
            }
            if (BaseGestureView.this.mBrightness < 0.01f) {
                float unused5 = BaseGestureView.this.mBrightness = 0.01f;
            }
            if (BaseGestureView.this.mMusicVolume < 0) {
                int unused6 = BaseGestureView.this.mMusicVolume = 0;
            }
        }

        public void onGestureEnd() {
            if (BaseGestureView.this.mDragging) {
                BaseGestureView.this.mMediaControl.show();
                BaseGestureView.this.mMediaControl.seekSeekBarTo(BaseGestureView.this.mCurrentPosition);
            }
            boolean unused = BaseGestureView.this.mDragging = false;
            BaseGestureView.this.timeRoot.setVisibility(8);
        }

        public void onSingleTap() {
            BaseGestureView.this.mMediaControl.toggleMediaVisible();
        }

        public void onDoubleTap() {
            BaseGestureView.this.mPlayerControl.togglePlayer();
            BaseGestureView.this.mMediaControl.show();
        }

        public void onSeekControl(float f) {
            BaseGestureView.this.onRealSeekControl(f);
        }

        public void onSeekTo() {
            BaseGestureView.this.mPlayerControl.seekTo(BaseGestureView.this.mCurrentPosition);
        }

        public boolean canSeek() {
            return BaseGestureView.this.canSeek;
        }
    };
    /* access modifiers changed from: private */
    public int mVoiceVolume = 0;
    private float mVolumeProgress;
    protected long startPosition;
    protected View timeRoot;
    protected TextView tvPlayTime;
    protected int volumeIconId;
    protected Window window;

    public BaseGestureView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public BaseGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BaseGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int getLayoutId() {
        return R.layout.live_business_layout_gesture;
    }

    public void bindMediaControl(IMediaControl iMediaControl) {
        this.mMediaControl = iMediaControl;
    }

    public void bindPlayerControl(IPlayerControl iPlayerControl) {
        this.mPlayerControl = iPlayerControl;
    }

    public void initViews() {
        this.mGestures = new CommonGestures(new WeakReference(getContext()));
        this.brightnessIconResid = R.drawable.live_business_light_half;
        this.volumeIconId = R.drawable.live_business_volume_up;
        if (getContext() != null && (getContext() instanceof Activity)) {
            this.window = ((Activity) getContext()).getWindow();
        }
    }

    private void init() {
        this.mGestures.setTouchListener(this.mTouchListener, true);
        setFocusableInTouchMode(false);
    }

    /* access modifiers changed from: protected */
    public void seekControlByPosition() {
        if (this.mCurrentPosition < 0) {
            this.mCurrentPosition = 0;
        }
        long j = this.mCurrentPosition;
        long j2 = this.mDuration;
        if (j > j2) {
            this.mCurrentPosition = j2;
        }
        setSeekQuickOperationProgress(TimeUtils.generateTime(this.mCurrentPosition) + "/" + TimeUtils.generateTime(this.mDuration));
    }

    public void initData() {
        BaseGestureView.super.initData();
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        this.mAM = audioManager;
        this.mMaxMusicVolume = audioManager.getStreamMaxVolume(3);
        this.mMaxVoiceVolume = this.mAM.getStreamMaxVolume(0);
    }

    private void setGraphicOperationProgress(int i, float f) {
        this.timeRoot.setVisibility(8);
    }

    private void setSeekQuickOperationProgress(String str) {
        this.timeRoot.setVisibility(0);
        this.tvPlayTime.setText(str);
    }

    public void updatePosition(long j, long j2) {
        if (!this.mDragging) {
            this.mCurrentPosition = j;
            this.mDuration = j2;
        }
    }

    public void setCanSeek(boolean z) {
        this.canSeek = z;
    }

    private void setVolume(int i) {
        int i2 = this.mMaxMusicVolume;
        if (i > i2) {
            i = i2;
        } else if (i < 0) {
            i = 0;
        }
        float f = (float) i;
        int i3 = (int) (((1.0f * f) * ((float) this.mMaxVoiceVolume)) / ((float) i2));
        try {
            this.mAM.setStreamVolume(3, i, 0);
        } catch (Exception e) {
            XesLog.et("BaseGestureView", "设置媒体音量出错=" + e);
        }
        try {
            this.mAM.setStreamVolume(0, i3, 0);
        } catch (Exception e2) {
            XesLog.et("BaseGestureView", "设置通话音量出错=" + e2);
        }
        setVolumeIcon(f / ((float) this.mMaxMusicVolume));
    }

    private void setVolume(float f) {
        int i = this.mMaxMusicVolume;
        int i2 = ((int) (f * ((float) i))) + this.mMusicVolume;
        if (i2 > i) {
            i2 = i;
        } else if (i2 < 0) {
            i2 = 0;
        }
        float f2 = (float) i2;
        int i3 = (int) (((1.0f * f2) * ((float) this.mMaxVoiceVolume)) / ((float) i));
        try {
            this.mAM.setStreamVolume(3, i2, 0);
        } catch (Exception e) {
            XesLog.et("BaseGestureView", "设置媒体音量出错=" + e);
        }
        try {
            this.mAM.setStreamVolume(0, i3, 0);
        } catch (Exception e2) {
            XesLog.et("BaseGestureView", "设置通话音量出错=" + e2);
        }
        setVolumeIcon(f2 / ((float) this.mMaxMusicVolume));
    }

    /* access modifiers changed from: protected */
    public void setVolumeIcon(float f) {
        if (f < 0.15f) {
            f = 0.15f;
        }
        float f2 = f - this.mVolumeProgress;
        if (f <= 0.0f) {
            this.volumeIconId = R.drawable.live_business_volume_no;
            this.mVolumeProgress = f;
        } else if (f >= 1.0f) {
            this.volumeIconId = R.drawable.live_business_volume_up;
            this.mVolumeProgress = f;
        } else if (Math.abs(f2) > 0.03f) {
            this.volumeIconId = f2 > 0.0f ? R.drawable.live_business_volume_up : R.drawable.live_business_volume_down;
            this.mVolumeProgress = f;
        }
        setGraphicOperationProgress(this.volumeIconId, f);
    }

    public void onRealSeekControl(float f) {
        if (!this.mDragging) {
            this.mDragging = true;
            this.mMediaControl.showLong();
            this.startPosition = this.mCurrentPosition;
        }
        this.mCurrentPosition = (long) (((float) this.startPosition) + (f * ((float) this.mDuration)));
        seekControlByPosition();
    }

    private void setBrightness(float f) {
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        attributes.screenBrightness = f;
        if (attributes.screenBrightness > 1.0f) {
            attributes.screenBrightness = 1.0f;
        } else if (attributes.screenBrightness < 0.01f) {
            attributes.screenBrightness = 0.01f;
        }
        this.window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void setBrightnessIcon(float f) {
        this.lightProgress = f;
        if (f == 0.0f) {
            this.brightnessIconResid = R.drawable.live_business_light_no;
        } else if (f >= 1.0f) {
            this.brightnessIconResid = R.drawable.live_business_ligth_max;
        } else {
            this.brightnessIconResid = R.drawable.live_business_light_half;
        }
        setGraphicOperationProgress(this.brightnessIconResid, f);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        this.mMediaControl.show();
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return BaseGestureView.super.onKeyDown(i, keyEvent);
    }

    public void setLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        this.mLiveRoomProvider = iLiveRoomProvider;
        iLiveRoomProvider.addActivityCallback(this.liveActivityCallback);
    }

    public boolean onDispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 24 || keyCode == 25) {
            this.mMusicVolume = this.mAM.getStreamVolume(3);
            int i = keyCode == 24 ? 1 : -1;
            if (i == 1) {
                XesLog.it("按键监听，用户增大音量", new Object[0]);
            } else {
                XesLog.it("按键监听，用户减小音量", new Object[0]);
            }
            setVolume(this.mMusicVolume + i);
            ThreadUtils.getMainHandler().removeCallbacks(this.hideRunnable);
            ThreadUtils.getMainHandler().postDelayed(this.hideRunnable, 500);
            return true;
        } else if (keyCode == 164) {
            XesLog.it("按键监听，用户静音", new Object[0]);
            return BaseGestureView.super.dispatchKeyEvent(keyEvent);
        } else if (keyEvent.getRepeatCount() == 0 && (keyCode == 79 || keyCode == 85 || keyCode == 62)) {
            this.mPlayerControl.togglePlayer();
            this.mMediaControl.show();
            return true;
        } else if (keyCode == 86) {
            this.mPlayerControl.stop();
            return true;
        } else if (keyCode == 4) {
            XesLog.it("按键监听，用户点击物理返回键", new Object[0]);
            this.mPlayerControl.stop();
            this.mLiveRoomProvider.backLiveRoom(ExitLiveRoom.NORMAL_EXIT);
            return true;
        } else {
            this.mMediaControl.show();
            return BaseGestureView.super.dispatchKeyEvent(keyEvent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mGestures.onTouchEvent(motionEvent) || BaseGestureView.super.onTouchEvent(motionEvent);
    }

    public void bindPopview(View view) {
        this.timeRoot = view.findViewById(R.id.fl_gesture_time_root);
        this.tvPlayTime = (TextView) view.findViewById(R.id.tv_gesture_time);
    }
}
