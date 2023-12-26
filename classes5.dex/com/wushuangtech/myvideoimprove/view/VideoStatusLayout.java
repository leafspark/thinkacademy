package com.wushuangtech.myvideoimprove.view;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.utils.ViewUtils;
import com.wushuangtech.wstechapi.R;
import java.util.Timer;
import java.util.TimerTask;

public class VideoStatusLayout implements View.OnClickListener, ViewUtils.OnTouchEventCallBack {
    /* access modifiers changed from: private */
    public Activity activity;
    private ViewGroup mTestContainer;
    private TextView mTestContainerTitle;
    /* access modifiers changed from: private */
    public LinearLayout mTestRootView;
    private Timer mTimer;
    private boolean mVisibileStatus;
    private String[] videoCapTest = {"V_CAP_BEFORE", "V_CAP_AFTER", "V_CAP_EFFECT", "FACE_EFFECT"};
    private String[] videoEncTest = {"V_ENC_NUM", "V_ENC_ERROR_NUM"};
    private String[] videoOpenglesTest = {"V_READ_PIXEL", "YUV_SPEND_TIME", "CPU_USEAGE"};

    public VideoStatusLayout(ViewGroup viewGroup) {
        Activity activity2 = (Activity) viewGroup.getContext();
        this.activity = activity2;
        viewGroup.addView((RelativeLayout) XMLParseInstrumentation.inflate(activity2, R.layout.video_status_ly, (ViewGroup) null));
        this.mTestContainerTitle = (TextView) viewGroup.findViewById(R.id.video_status_title);
        this.mTestContainer = (ViewGroup) viewGroup.findViewById(R.id.video_status_container);
    }

    public void setOnTouchEventCallBack(ViewUtils.ViewPosition viewPosition) {
        viewPosition.mOnTouchEventCallBack = this;
    }

    public void buildLocalVideoInfoLayout() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        this.mTestRootView = linearLayout;
        linearLayout.setOrientation(1);
        this.mTestContainer.addView(this.mTestRootView);
        buildArrayButtons(this.mTestRootView, this.videoCapTest);
        buildArrayButtons(this.mTestRootView, this.videoEncTest);
        buildArrayButtons(this.mTestRootView, this.videoOpenglesTest);
        Timer timer = new Timer(VideoStatus.THREAD_VIDEO_STATS_FOR_UI);
        this.mTimer = timer;
        timer.schedule(new TimerTask() {
            private long lastVideoCapTimes;
            private long lastVideoEncodeErrorTimes;
            private long lastVideoEncodeTimes;

            public void run() {
                VideoStatusLayout.this.activity.runOnUiThread(new Runnable() {
                    public void run() {
                        int childCount = VideoStatusLayout.this.mTestRootView.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            TextView textView = (TextView) VideoStatusLayout.this.mTestRootView.getChildAt(i);
                            AnonymousClass1.this.handleVideoCapInfo(textView);
                            AnonymousClass1.this.handleVideoEncInfo(textView);
                            AnonymousClass1.this.handleVideoOpenglesInfo(textView);
                        }
                    }
                });
            }

            /* access modifiers changed from: private */
            public void handleVideoCapInfo(TextView textView) {
                ViewTagBean viewTagBean = (ViewTagBean) textView.getTag();
                if (viewTagBean.name.equals("V_CAP_BEFORE")) {
                    textView.setText("V_CAP_BEFORE - " + VideoStatus.videoCapBeforeFrameRate);
                } else if (viewTagBean.name.equals("V_CAP_AFTER")) {
                    long j = VideoStatus.mVideoCapFrameTimes - this.lastVideoCapTimes;
                    textView.setText("V_CAP_AFTER - " + j);
                    this.lastVideoCapTimes = VideoStatus.mVideoCapFrameTimes;
                } else if (viewTagBean.name.equals("V_CAP_EFFECT")) {
                    textView.setText("V_CAP_EFFECT - " + VideoStatus.videoCapFrameEffectBufferSurface + "_" + VideoStatus.videoCapFrameEffectDisplay + "_" + VideoStatus.videoCapFrameEffectEncoder);
                } else if (viewTagBean.name.equals("FACE_EFFECT")) {
                    textView.setText("FACE_EFFECT - " + VideoStatus.faceUnityBeautfySpendTime);
                }
            }

            /* access modifiers changed from: private */
            public void handleVideoEncInfo(TextView textView) {
                ViewTagBean viewTagBean = (ViewTagBean) textView.getTag();
                if (viewTagBean.name.equals("V_ENC_NUM")) {
                    long videoEncodedFrames = VideoStatus.getVideoEncodedFrames();
                    textView.setText("V_ENC_NUM - " + (videoEncodedFrames - this.lastVideoEncodeTimes));
                    this.lastVideoEncodeTimes = videoEncodedFrames;
                } else if (viewTagBean.name.equals("V_ENC_ERROR_NUM")) {
                    long j = VideoStatus.mVideoEncodeErrorFrames - this.lastVideoEncodeErrorTimes;
                    textView.setText("V_ENC_ERROR_NUM - " + j);
                    this.lastVideoEncodeErrorTimes = VideoStatus.mVideoEncodeErrorFrames;
                }
            }

            /* access modifiers changed from: private */
            public void handleVideoOpenglesInfo(TextView textView) {
                ViewTagBean viewTagBean = (ViewTagBean) textView.getTag();
                if (viewTagBean.name.equals("V_READ_PIXEL")) {
                    if (VideoStatus.mVideoReadPixelType == VideoStatus.OpenglESVideoReadPixelType.FBO) {
                        textView.setText("V_READ_PIXEL_FBO - " + VideoStatus.mVideoReadPixelSpendTime);
                        return;
                    }
                    textView.setText("V_READ_PIXEL_PBO - " + VideoStatus.mVideoReadPixelSpendTimePBO);
                } else if (viewTagBean.name.equals("YUV_SPEND_TIME")) {
                    textView.setText("YUV_SPEND_TIME - " + VideoStatus.videoYuvChangeFormatSpendTimes);
                } else {
                    viewTagBean.name.equals("CPU_USEAGE");
                }
            }
        }, 1000, 1000);
    }

    private void buildArrayButtons(LinearLayout linearLayout, String[] strArr) {
        String str = strArr[0];
        for (String str2 : strArr) {
            TextView textView = new TextView(this.activity);
            textView.setTextSize(14.0f);
            textView.setTextColor(-16777216);
            ViewTagBean viewTagBean = new ViewTagBean();
            viewTagBean.belong = str;
            viewTagBean.name = str2;
            textView.setTag(viewTagBean);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = 10;
            linearLayout.addView(textView, layoutParams);
        }
    }

    public void clearResource() {
        this.mTimer.cancel();
        this.mTimer.purge();
        this.mTestRootView.removeAllViews();
        this.activity = null;
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, VideoStatusLayout.class);
        if (view.getId() == R.id.video_status_title) {
            if (this.mVisibileStatus) {
                this.mTestContainer.setVisibility(8);
                this.mTestContainerTitle.setText("展开渲染数据统计");
            } else {
                this.mTestContainer.setVisibility(0);
                this.mTestContainerTitle.setText("折叠渲染数据统计");
            }
            this.mVisibileStatus = !this.mVisibileStatus;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void viewTouchCallBack(boolean z, MotionEvent motionEvent) {
        if (ViewUtils.inRangeOfView(this.mTestContainerTitle, motionEvent) && !z) {
            if (this.mVisibileStatus) {
                this.mTestContainer.setVisibility(8);
                this.mTestContainerTitle.setText("展开渲染数据统计");
            } else {
                this.mTestContainer.setVisibility(0);
                this.mTestContainerTitle.setText("折叠渲染数据统计");
            }
            this.mVisibileStatus = !this.mVisibileStatus;
        }
    }

    static class ViewTagBean {
        public String belong;
        public String name;

        ViewTagBean() {
        }
    }
}
