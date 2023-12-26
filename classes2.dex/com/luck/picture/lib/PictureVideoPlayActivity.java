package com.luck.picture.lib;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.ArrayList;

public class PictureVideoPlayActivity extends PictureBaseActivity implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, View.OnClickListener {
    private ImageButton ibLeftBack;
    private ImageView iv_play;
    private MediaController mMediaController;
    private int mPositionWhenPaused = -1;
    private VideoView mVideoView;
    private String videoPath;

    public boolean isImmersive() {
        return false;
    }

    public boolean isRequestedOrientation() {
        return false;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().addFlags(67108864);
        super.onCreate(bundle);
    }

    public int getResourceId() {
        return R.layout.picture_activity_video_play;
    }

    /* access modifiers changed from: protected */
    public void initPictureSelectorStyle() {
        if (PictureSelectionConfig.style != null && PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
            this.ibLeftBack.setImageResource(PictureSelectionConfig.style.pictureLeftBackIcon);
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, com.luck.picture.lib.PictureVideoPlayActivity, android.view.View$OnClickListener, android.media.MediaPlayer$OnPreparedListener, com.luck.picture.lib.PictureBaseActivity, android.media.MediaPlayer$OnCompletionListener] */
    /* access modifiers changed from: protected */
    public void initWidgets() {
        super.initWidgets();
        this.videoPath = getIntent().getStringExtra(PictureConfig.EXTRA_VIDEO_PATH);
        int i = 0;
        boolean booleanExtra = getIntent().getBooleanExtra(PictureConfig.EXTRA_PREVIEW_VIDEO, false);
        if (TextUtils.isEmpty(this.videoPath)) {
            LocalMedia localMedia = (LocalMedia) getIntent().getParcelableExtra(PictureConfig.EXTRA_MEDIA_KEY);
            if (localMedia == null || TextUtils.isEmpty(localMedia.getPath())) {
                finish();
                return;
            }
            this.videoPath = localMedia.getPath();
        }
        if (TextUtils.isEmpty(this.videoPath)) {
            exit();
            return;
        }
        this.ibLeftBack = (ImageButton) findViewById(R.id.pictureLeftBack);
        this.mVideoView = (VideoView) findViewById(R.id.video_view);
        TextView textView = (TextView) findViewById(R.id.tv_confirm);
        this.mVideoView.setBackgroundColor(-16777216);
        this.iv_play = (ImageView) findViewById(R.id.iv_play);
        this.mMediaController = new MediaController(this);
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setOnPreparedListener(this);
        this.mVideoView.setMediaController(this.mMediaController);
        this.ibLeftBack.setOnClickListener(this);
        this.iv_play.setOnClickListener(this);
        textView.setOnClickListener(this);
        if (this.config.selectionMode != 1 || !this.config.enPreviewVideo || booleanExtra) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public void onStart() {
        if (!SdkVersionUtils.checkedAndroid_Q() || !PictureMimeType.isContent(this.videoPath)) {
            this.mVideoView.setVideoPath(this.videoPath);
        } else {
            this.mVideoView.setVideoURI(Uri.parse(this.videoPath));
        }
        this.mVideoView.start();
        super.onStart();
    }

    public void onPause() {
        this.mPositionWhenPaused = this.mVideoView.getCurrentPosition();
        this.mVideoView.stopPlayback();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mMediaController = null;
        this.mVideoView = null;
        this.iv_play = null;
        super.onDestroy();
    }

    public void onResume() {
        int i = this.mPositionWhenPaused;
        if (i >= 0) {
            this.mVideoView.seekTo(i);
            this.mPositionWhenPaused = -1;
        }
        super.onResume();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        ImageView imageView = this.iv_play;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, PictureVideoPlayActivity.class);
        int id = view.getId();
        if (id == R.id.pictureLeftBack) {
            onBackPressed();
        } else if (id == R.id.iv_play) {
            this.mVideoView.start();
            this.iv_play.setVisibility(4);
        } else if (id == R.id.tv_confirm) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getIntent().getParcelableExtra(PictureConfig.EXTRA_MEDIA_KEY));
            setResult(-1, new Intent().putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, arrayList));
            onBackPressed();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void onBackPressed() {
        if (PictureSelectionConfig.windowAnimationStyle == null || PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation == 0) {
            exit();
            return;
        }
        finish();
        overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(new ContextWrapper(context) {
            public Object getSystemService(String str) {
                if (PictureMimeType.MIME_TYPE_PREFIX_AUDIO.equals(str)) {
                    return getApplicationContext().getSystemService(str);
                }
                return super.getSystemService(str);
            }
        });
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnInfoListener(new PictureVideoPlayActivity$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ boolean lambda$onPrepared$0$PictureVideoPlayActivity(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return false;
        }
        this.mVideoView.setBackgroundColor(0);
        return true;
    }
}
