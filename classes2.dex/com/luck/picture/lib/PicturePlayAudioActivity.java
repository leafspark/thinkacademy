package com.luck.picture.lib;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

@Deprecated
public class PicturePlayAudioActivity extends PictureBaseActivity implements View.OnClickListener {
    private String audio_path;
    private boolean isPlayAudio = false;
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public SeekBar musicSeekBar;
    public Runnable runnable = new Runnable() {
        public void run() {
            try {
                if (PicturePlayAudioActivity.this.mediaPlayer != null) {
                    PicturePlayAudioActivity.this.tv_musicTime.setText(DateUtils.formatDurationTime((long) PicturePlayAudioActivity.this.mediaPlayer.getCurrentPosition()));
                    PicturePlayAudioActivity.this.musicSeekBar.setProgress(PicturePlayAudioActivity.this.mediaPlayer.getCurrentPosition());
                    PicturePlayAudioActivity.this.musicSeekBar.setMax(PicturePlayAudioActivity.this.mediaPlayer.getDuration());
                    PicturePlayAudioActivity.this.tv_musicTotal.setText(DateUtils.formatDurationTime((long) PicturePlayAudioActivity.this.mediaPlayer.getDuration()));
                    PicturePlayAudioActivity.this.mHandler.postDelayed(PicturePlayAudioActivity.this.runnable, 200);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private TextView tv_PlayPause;
    private TextView tv_musicStatus;
    /* access modifiers changed from: private */
    public TextView tv_musicTime;
    /* access modifiers changed from: private */
    public TextView tv_musicTotal;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(PictureFileUtils.KB, PictureFileUtils.KB);
        super.onCreate(bundle);
    }

    public int getResourceId() {
        return R.layout.picture_play_audio;
    }

    /* access modifiers changed from: protected */
    public void initWidgets() {
        super.initWidgets();
        this.audio_path = getIntent().getStringExtra(PictureConfig.EXTRA_AUDIO_PATH);
        this.tv_musicStatus = (TextView) findViewById(R.id.tv_musicStatus);
        this.tv_musicTime = (TextView) findViewById(R.id.tv_musicTime);
        this.musicSeekBar = (SeekBar) findViewById(R.id.musicSeekBar);
        this.tv_musicTotal = (TextView) findViewById(R.id.tv_musicTotal);
        this.tv_PlayPause = (TextView) findViewById(R.id.tv_PlayPause);
        this.mHandler.postDelayed(new PicturePlayAudioActivity$$ExternalSyntheticLambda0(this), 30);
        this.tv_PlayPause.setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_Stop)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_Quit)).setOnClickListener(this);
        this.musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    PicturePlayAudioActivity.this.mediaPlayer.seekTo(i);
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            }
        });
    }

    public /* synthetic */ void lambda$initWidgets$0$PicturePlayAudioActivity() {
        initPlayer(this.audio_path);
    }

    private void initPlayer(String str) {
        this.mediaPlayer = new MediaPlayer();
        try {
            if (PictureMimeType.isContent(str)) {
                this.mediaPlayer.setDataSource(getContext(), Uri.parse(str));
            } else {
                this.mediaPlayer.setDataSource(str);
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
            playAudio();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, PicturePlayAudioActivity.class);
        int id = view.getId();
        if (id == R.id.tv_PlayPause) {
            playAudio();
        }
        if (id == R.id.tv_Stop) {
            this.tv_musicStatus.setText(getString(R.string.picture_stop_audio));
            this.tv_PlayPause.setText(getString(R.string.picture_play_audio));
            stop(this.audio_path);
        }
        if (id == R.id.tv_Quit) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(new PicturePlayAudioActivity$$ExternalSyntheticLambda1(this), 30);
            try {
                exit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public /* synthetic */ void lambda$onClick$1$PicturePlayAudioActivity() {
        stop(this.audio_path);
    }

    private void playAudio() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            this.musicSeekBar.setProgress(mediaPlayer2.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        if (this.tv_PlayPause.getText().toString().equals(getString(R.string.picture_play_audio))) {
            this.tv_PlayPause.setText(getString(R.string.picture_pause_audio));
            this.tv_musicStatus.setText(getString(R.string.picture_play_audio));
        } else {
            this.tv_PlayPause.setText(getString(R.string.picture_play_audio));
            this.tv_musicStatus.setText(getString(R.string.picture_pause_audio));
        }
        playOrPause();
        if (!this.isPlayAudio) {
            Handler handler = this.mHandler;
            Runnable runnable2 = this.runnable;
            if (!(handler instanceof Handler)) {
                handler.post(runnable2);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable2);
            }
            this.isPlayAudio = true;
        }
    }

    public void stop(String str) {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            try {
                mediaPlayer2.stop();
                this.mediaPlayer.reset();
                if (PictureMimeType.isContent(str)) {
                    this.mediaPlayer.setDataSource(getContext(), Uri.parse(str));
                } else {
                    this.mediaPlayer.setDataSource(str);
                }
                this.mediaPlayer.prepare();
                this.mediaPlayer.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void playOrPause() {
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 == null) {
                return;
            }
            if (mediaPlayer2.isPlaying()) {
                this.mediaPlayer.pause();
            } else {
                this.mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        exit();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.mediaPlayer != null) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }
}
