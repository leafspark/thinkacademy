package com.tal.app.thinkacademy.live.business.videocall.pager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public class TutorVideoCallPager extends BaseLivePluginView {
    protected FrameLayout flVideoContainer;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public TextView mTimerTxt;
    /* access modifiers changed from: private */
    public int second = 0;
    private ImageView studentVideoHeader;
    private Runnable trickRefreshRunnable = new Runnable() {
        public void run() {
            TutorVideoCallPager.access$008(TutorVideoCallPager.this);
            TutorVideoCallPager.this.mHandler.postDelayed(this, 1000);
            TutorVideoCallPager.this.mTimerTxt.setText(TimeUtils.generateTime_MS(TutorVideoCallPager.this.second));
        }
    };
    private String tutorAvatar;
    private ConstraintLayout tutorErrorButton;
    private ConstraintLayout tutorVideoCallLyout;
    private ImageView tutorVideoError;
    private ImageView tutorVideoHeader;
    private TextView tvExit;
    private String userAvatar;
    public int videoViewHeight;
    public int videoViewWidth;

    static /* synthetic */ int access$008(TutorVideoCallPager tutorVideoCallPager) {
        int i = tutorVideoCallPager.second;
        tutorVideoCallPager.second = i + 1;
        return i;
    }

    public TutorVideoCallPager(Context context, String str) {
        super(context);
        this.mContext = context;
        this.tutorAvatar = str;
        initVideoViewSize();
        initView();
    }

    public int getLayoutId() {
        return R.layout.live_business_tutor_videocall_layout;
    }

    public void initView() {
        this.tvExit = (TextView) findViewById(R.id.tutor_videocall_exit);
        this.tutorVideoError = (ImageView) findViewById(R.id.tutor_video_error);
        this.tutorErrorButton = findViewById(R.id.tutor_video_button);
        this.tutorVideoCallLyout = findViewById(R.id.tutor_video_call_layout);
        this.flVideoContainer = (FrameLayout) findViewById(R.id.rl_live_business_tutor_videocall);
        this.tutorVideoHeader = (ImageView) findViewById(R.id.tutor_video_call_tutor_header);
        this.studentVideoHeader = (ImageView) findViewById(R.id.tutor_video_call_student_header);
        this.mTimerTxt = (TextView) findViewById(R.id.tutor_video_call_tutor_timer);
        String string = ShareDataManager.getInstance().getString(ShareDataKey.USER_AVATAR, this.mContext.getResources().getResourceName(R.drawable.bg_live_business_tutor_video_image_user), ShareDataManager.SHAREDATA_USER);
        this.userAvatar = string;
        ImageLoaderJ.loadCircle(this.mContext, string, this.studentVideoHeader, R.drawable.bg_live_business_tutor_video_image_user);
        ImageLoaderJ.loadCircle(this.mContext, this.tutorAvatar, this.tutorVideoHeader, R.drawable.bg_live_business_tutor_video_tutor_image);
        this.mTimerTxt.setText("00:00");
        this.mHandler.postDelayed(this.trickRefreshRunnable, 1000);
    }

    public void initVideoViewSize() {
        this.videoViewWidth = SizeUtils.dp2px(214.0f);
        this.videoViewHeight = SizeUtils.dp2px(169.0f);
    }

    public void showMask() {
        if (this.tutorVideoError.getVisibility() == 8) {
            this.flVideoContainer.setVisibility(4);
            this.tutorVideoCallLyout.setVisibility(8);
            this.tutorVideoError.setVisibility(0);
            this.tutorErrorButton.setVisibility(0);
        }
    }

    public void hideMask() {
        if (this.tutorVideoError.getVisibility() == 0) {
            this.flVideoContainer.setVisibility(0);
            this.tutorVideoCallLyout.setVisibility(0);
            this.tutorVideoError.setVisibility(8);
            this.tutorErrorButton.setVisibility(8);
        }
    }

    public void removeRenderView(SurfaceView surfaceView) {
        boolean z = true;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("removeRenderView: surfaceView=");
        if (surfaceView == null) {
            z = false;
        }
        sb.append(z);
        objArr[0] = sb.toString();
        XesLog.dt("TutorVideoCall", objArr);
        if (surfaceView != null) {
            this.flVideoContainer.removeView(surfaceView);
        }
    }

    public void removeRenderView() {
        XesLog.dt("TutorVideoCall", "removeRenderView: remove all");
        this.flVideoContainer.removeAllViews();
    }

    public void addRenderView(SurfaceView surfaceView) {
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("addRenderView: surfaceView=");
        sb.append(surfaceView != null);
        objArr[0] = sb.toString();
        XesLog.dt("TutorVideoCall", objArr);
        if (surfaceView != null) {
            ViewGroup viewGroup = (ViewGroup) surfaceView.getParent();
            if (viewGroup != null) {
                XesLog.dt("TutorVideoCall", "addRenderView: surfaceView has parent");
                viewGroup.removeView(surfaceView);
            }
            this.flVideoContainer.addView(surfaceView);
            if (surfaceView.getVisibility() != 0) {
                surfaceView.setVisibility(0);
            }
            ((FrameLayout.LayoutParams) surfaceView.getLayoutParams()).gravity = 17;
            surfaceView.requestLayout();
        }
    }

    public void setExitClickListener(View.OnClickListener onClickListener) {
        this.tvExit.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
        this.trickRefreshRunnable = null;
    }
}
