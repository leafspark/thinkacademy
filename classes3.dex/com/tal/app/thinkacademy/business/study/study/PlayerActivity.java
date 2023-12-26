package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.PlayerErrorDialog;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.widget.pad.NotPadAutoScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.player.ijkplayer.MediaErrorInfo;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import java.util.List;

@NotPadAutoScreen
public class PlayerActivity extends XesBaseActivity {
    private static final long HIDE_DELAY_TIME = 5000;
    private static final String INTENT_VIDEO_NAME = "player_video_name";
    private static final String INTENT_VIDEO_PATH = "player_video_path";
    private static final String INTENT_VIDEO_SCENE_TYPE = "player_video_scene_type";
    private static final String SCHOOL_CODE_US = "415";
    /* access modifiers changed from: private */
    public static final String TAG = "PlayerActivity";
    private static final int WHAT_CONTROL_BAR_HIDE = 100;
    private ImageView mBackBtn;
    private View mBottomControlBar;
    private ImageView mBtnPauseOrPlay;
    /* access modifiers changed from: private */
    public long mCurrentPosition = 0;
    private TextView mCurrentTimeTextView;
    /* access modifiers changed from: private */
    public long mDragProgress;
    /* access modifiers changed from: private */
    public long mDuration = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            super.handleMessage(message);
            if (message.what == 100) {
                PlayerActivity.this.hideControlBar();
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    };
    /* access modifiers changed from: private */
    public SurfaceHolder mHolder;
    /* access modifiers changed from: private */
    public boolean mIsControlBarShowing = true;
    /* access modifiers changed from: private */
    public boolean mIsDragging = false;
    private boolean mIsError = false;
    private boolean mIsNeedResumePlay = false;
    /* access modifiers changed from: private */
    public boolean mIsOnPause = false;
    private IJKPlayListener mListener = new IJKPlayListener() {
        public void onCloseComplete() {
        }

        public void onCloseStart() {
        }

        public void onVideoSizeChanged(int i, int i2) {
        }

        public void serverList(int i, int i2, List<String> list) {
        }

        public void onHWRenderFailed() {
            XesLog.dt(PlayerActivity.TAG, new Object[]{"onHWRenderFailed"});
        }

        public void onOpenStart() {
            PlayerActivity.this.showPlayerLoading();
        }

        public void onOpenSuccess() {
            PlayerActivity.this.setErrorState(false);
            PlayerActivity.this.hidePlayerLoading();
            if (PlayerActivity.this.mIsOnPause && PlayerActivity.this.mPlayer != null) {
                PlayerActivity.this.mPlayer.pausePlay();
            }
        }

        public void onOpenFailed(MediaErrorInfo mediaErrorInfo) {
            XesLog.dt(PlayerActivity.TAG, new Object[]{"onOpenFailed errorcode start"});
            if (mediaErrorInfo != null) {
                String access$100 = PlayerActivity.TAG;
                XesLog.dt(access$100, new Object[]{"onOpenFailed errorcode = " + mediaErrorInfo.getMErrorCode() + ",msg = " + mediaErrorInfo.getMErrorMsg()});
            }
            PlayerActivity.this.setErrorState(true);
        }

        public void onPaused() {
            PlayerActivity.this.setPauseSate(true);
            XesLog.dt(PlayerActivity.TAG, new Object[]{"player onPaused"});
        }

        public void onBufferStart() {
            PlayerActivity.this.setErrorState(false);
            PlayerActivity.this.showPlayerLoading();
        }

        public void onBufferComplete() {
            PlayerActivity.this.hidePlayerLoading();
        }

        public void onPlaybackComplete() {
            XesLog.dt(PlayerActivity.TAG, new Object[]{"onPlaybackComplete"});
            PlayerActivity playerActivity = PlayerActivity.this;
            playerActivity.setSeekbarProgressTime(playerActivity.mDuration);
            if (PlayerActivity.this.mPlayer != null) {
                PlayerActivity.this.mPlayer.pausePlay();
            }
        }

        public void onPlaying(long j, long j2) {
            PlayerActivity.this.setTotalTime(j2);
            long unused = PlayerActivity.this.mCurrentPosition = j;
            long unused2 = PlayerActivity.this.mDuration = j2;
            if (!PlayerActivity.this.mIsDragging) {
                PlayerActivity.this.setSeekbarProgressTime(j);
            }
        }

        public void onPlayError() {
            XesLog.dt(PlayerActivity.TAG, new Object[]{"onPlayError"});
            PlayerActivity.this.setErrorState(true);
        }
    };
    private View mLoading;
    /* access modifiers changed from: private */
    public IJKPlayer mPlayer;
    private PlayerErrorDialog mPlayerErrorDialog;
    private ConstraintLayout mPlayerRootView;
    private SeekBar mSeekBar;
    private SurfaceView mSurfaceView;
    private View mTopControlBar;
    private TextView mTotalTimeTextView;
    private String mVideoName;
    private String mVideoPath;
    private VideoPlayerSceneType mVideoPlayerSceneType;
    private TextView mVideoTextView;

    public static void startPlayerActivity(Context context, String str, String str2, VideoPlayerSceneType videoPlayerSceneType) {
        if (context != null) {
            Intent intent = new Intent(context, PlayerActivity.class);
            intent.putExtra(INTENT_VIDEO_NAME, str);
            intent.putExtra(INTENT_VIDEO_PATH, str2);
            intent.putExtra(INTENT_VIDEO_SCENE_TYPE, videoPlayerSceneType);
            context.startActivity(intent);
        }
    }

    private void initIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mVideoPath = intent.getStringExtra(INTENT_VIDEO_PATH);
            this.mVideoName = intent.getStringExtra(INTENT_VIDEO_NAME);
            this.mVideoPlayerSceneType = intent.getSerializableExtra(INTENT_VIDEO_SCENE_TYPE);
            if (this.mVideoPath == null) {
                this.mVideoPath = "";
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().addFlags(128);
        PlayerActivity.super.onCreate(bundle);
        setContentView(R.layout.activity_player_study);
        initIntent();
        this.mSurfaceView = (SurfaceView) findViewById(R.id.player_surface_view);
        this.mLoading = findViewById(R.id.player_loading);
        this.mVideoTextView = (TextView) findViewById(R.id.player_video_name);
        this.mSeekBar = (SeekBar) findViewById(R.id.player_progress);
        this.mTopControlBar = findViewById(R.id.player_top_layout);
        this.mBottomControlBar = findViewById(R.id.player_bottom_layout);
        this.mPlayerRootView = findViewById(R.id.player_root_view);
        this.mCurrentTimeTextView = (TextView) findViewById(R.id.player_time_current);
        this.mTotalTimeTextView = (TextView) findViewById(R.id.player_time_total);
        this.mBackBtn = (ImageView) findViewById(R.id.player_back_btn);
        this.mBtnPauseOrPlay = (ImageView) findViewById(R.id.player_btn_play_pause);
        String uid = UserInfoBll.getInstance().getUserInfoEntity().getUid();
        String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (uid == null) {
            uid = "";
        }
        String str = uid;
        this.mPlayer = new IJKPlayer(getApplicationContext(), "hw20001", "", str, str, string);
        initView();
        initPlayer();
    }

    /* access modifiers changed from: private */
    public void showPlayerLoading() {
        this.mLoading.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void hidePlayerLoading() {
        this.mLoading.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        PlayerActivity.super.onPause();
        if (this.mIsOnPause) {
            this.mIsNeedResumePlay = false;
        } else {
            this.mIsNeedResumePlay = true;
        }
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.pausePlay();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        PlayerActivity.super.onResume();
        if (this.mIsNeedResumePlay) {
            this.mIsNeedResumePlay = false;
            IJKPlayer iJKPlayer = this.mPlayer;
            if (iJKPlayer != null && iJKPlayer.needResume()) {
                this.mPlayer.startPlay();
            }
        }
        showControlBar(false);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PlayerActivity.super.onDestroy();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.stopPlay();
            this.mPlayer.destroyPlayer();
            this.mPlayer = null;
        }
    }

    private void initPlayer() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.initPlayer(this.mListener);
            this.mPlayer.seekToAccurate();
            this.mPlayer.playFile(this.mVideoPath, (float) this.mCurrentPosition, 0, this.mVideoPlayerSceneType);
        }
        SurfaceHolder surfaceHolder = this.mHolder;
        if (surfaceHolder != null) {
            this.mPlayer.setSurfaceHolder(surfaceHolder);
        }
    }

    /* access modifiers changed from: private */
    public void retryPlay() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.stopPlay();
        }
        initPlayer();
    }

    private void initView() {
        this.mBackBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PlayerActivity.class);
                PlayerActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mVideoTextView.setText(this.mVideoName);
        this.mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceHolder unused = PlayerActivity.this.mHolder = surfaceHolder;
                if (PlayerActivity.this.mPlayer != null) {
                    PlayerActivity.this.mPlayer.setSurfaceHolder(surfaceHolder);
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (PlayerActivity.this.mPlayer != null) {
                    PlayerActivity.this.mPlayer.releaseSurface();
                }
            }
        });
        this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    boolean unused = PlayerActivity.this.mIsDragging = true;
                    long unused2 = PlayerActivity.this.mDragProgress = (long) i;
                    PlayerActivity.this.setCurrentTime(i);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                boolean unused = PlayerActivity.this.mIsDragging = true;
                XesLog.dt(PlayerActivity.TAG, new Object[]{"onStartTrackingTouch"});
                PlayerActivity.this.showControlBar(true);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                XesLog.dt(PlayerActivity.TAG, new Object[]{"onStopTrackingTouch"});
                boolean unused = PlayerActivity.this.mIsDragging = false;
                PlayerActivity.this.showControlBar(false);
                if (PlayerActivity.this.mDuration > 0) {
                    PlayerActivity playerActivity = PlayerActivity.this;
                    long unused2 = playerActivity.mCurrentPosition = (playerActivity.mDuration * PlayerActivity.this.mDragProgress) / 100;
                } else {
                    long unused3 = PlayerActivity.this.mCurrentPosition = 0;
                }
                PlayerActivity playerActivity2 = PlayerActivity.this;
                playerActivity2.playerSeek(playerActivity2.mCurrentPosition);
                SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            }
        });
        this.mPlayerRootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PlayerActivity.class);
                if (PlayerActivity.this.mIsControlBarShowing) {
                    PlayerActivity.this.hideControlBar();
                } else {
                    PlayerActivity.this.showControlBar(false);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mBtnPauseOrPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PlayerActivity.class);
                if (!PlayerActivity.this.mIsOnPause) {
                    if (PlayerActivity.this.mPlayer != null) {
                        PlayerActivity.this.mPlayer.pausePlay();
                    }
                    PlayerActivity.this.setPauseSate(true);
                } else {
                    if (PlayerActivity.this.mPlayer != null) {
                        PlayerActivity.this.mPlayer.startPlay();
                    }
                    PlayerActivity.this.setPauseSate(false);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        showControlBar(false);
    }

    /* access modifiers changed from: private */
    public void setTotalTime(long j) {
        if (this.mDuration != j) {
            this.mTotalTimeTextView.setText(TimeUtils.stringForTime(j));
        }
    }

    /* access modifiers changed from: private */
    public void setCurrentTime(int i) {
        this.mCurrentTimeTextView.setText(TimeUtils.stringForTime((((long) i) * this.mDuration) / 100));
    }

    /* access modifiers changed from: private */
    public void setSeekbarProgressTime(long j) {
        long j2 = this.mDuration;
        if (j2 > 0) {
            this.mSeekBar.setProgress((int) ((((float) j) * 100.0f) / ((float) j2)));
        } else {
            this.mSeekBar.setProgress(0);
        }
        this.mCurrentTimeTextView.setText(TimeUtils.stringForTime(j));
    }

    /* access modifiers changed from: private */
    public void playerSeek(long j) {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.seekTo(j, true);
        }
        setSeekbarProgressTime(j);
    }

    /* access modifiers changed from: private */
    public void showControlBar(boolean z) {
        this.mHandler.removeMessages(100);
        this.mTopControlBar.setVisibility(0);
        this.mBottomControlBar.setVisibility(0);
        this.mIsControlBarShowing = true;
        if (!z) {
            this.mHandler.sendEmptyMessageDelayed(100, HIDE_DELAY_TIME);
        }
    }

    /* access modifiers changed from: private */
    public void hideControlBar() {
        this.mHandler.removeMessages(100);
        this.mTopControlBar.setVisibility(8);
        this.mBottomControlBar.setVisibility(8);
        this.mIsControlBarShowing = false;
    }

    /* access modifiers changed from: private */
    public void setPauseSate(boolean z) {
        if (this.mIsOnPause != z) {
            this.mIsOnPause = z;
            if (z) {
                this.mBtnPauseOrPlay.setImageResource(R.drawable.player_icon_play);
            } else {
                this.mBtnPauseOrPlay.setImageResource(R.drawable.player_icon_pause);
            }
            showControlBar(false);
        }
    }

    /* access modifiers changed from: private */
    public void setErrorState(boolean z) {
        this.mIsError = z;
        if (z) {
            showPlayerErrorDialog();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, com.tal.app.thinkacademy.business.study.study.PlayerActivity] */
    private void showPlayerErrorDialog() {
        PlayerErrorDialog playerErrorDialog = this.mPlayerErrorDialog;
        if (playerErrorDialog != null) {
            playerErrorDialog.dismiss();
        }
        PlayerErrorDialog playerErrorDialog2 = new PlayerErrorDialog(this);
        this.mPlayerErrorDialog = playerErrorDialog2;
        playerErrorDialog2.setPlayerErrorListen(new PlayerErrorDialog.PlayerErrorListen() {
            public void onExit() {
                PlayerActivity.this.finish();
            }

            public void onRetry() {
                PlayerActivity.this.retryPlay();
            }
        });
        this.mPlayerErrorDialog.show();
    }
}
