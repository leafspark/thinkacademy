package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import android.graphics.RectF;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.LiveMainHandler;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.List;

public class CanvasTripleScreenPagerPluginView extends BaseLivePluginView {
    private static int UN_SUPPORT_TOAST_LIMIT = 30;
    /* access modifiers changed from: private */
    public CallBack callBack;
    private ViewGroup courseWareArea;
    private CourseWareView courseWareView;
    int height;
    private boolean isBindCourseware = true;
    private long lastShowUnSupportToastTime = 0;
    private ImageView mIvNoCourseware;
    private ILiveRoomProvider mLiveRoomProvider;
    private int remindDuration = UN_SUPPORT_TOAST_LIMIT;
    ScrollView scrollView;
    int scrolllview_height;
    int scrolllview_width;
    /* access modifiers changed from: private */
    public View stateLayout;
    private TextView stateTv;
    int width;

    interface CallBack {
        public static final int SWITCH_STATE_BEGIN = 1;
        public static final int SWITCH_STATE_FINISH_FAIL = 3;
        public static final int SWITCH_STATE_FINISH_SUCCEED = 2;

        void onCourseWareSwitchResult(int i, CourseWareBean courseWareBean);

        void onTouchAreaUpdate(RectF rectF);
    }

    public CanvasTripleScreenPagerPluginView(Context context) {
        super(context);
    }

    public int getLayoutId() {
        return R.layout.live_business_canvas_triple_screen_layout;
    }

    public void initViews() {
        this.courseWareArea = (ViewGroup) findViewById(R.id.live_business_canvas_triple_screen_courseware_area_inner);
        this.scrollView = (ScrollView) findViewById(R.id.live_business_canvas_triple_screen_courseware_area);
        this.mIvNoCourseware = (ImageView) findViewById(R.id.iv_live_business_no_courseware);
        if (this.courseWareArea != null) {
            CourseWareView courseWareView2 = new CourseWareView(getContext());
            this.courseWareView = courseWareView2;
            this.courseWareArea.addView(courseWareView2, new ViewGroup.LayoutParams(-1, -1));
        }
        this.stateLayout = findViewById(R.id.live_business_canvas_triple_screen_state_layout);
        this.stateTv = (TextView) findViewById(R.id.live_business_canvas_triple_screen_state_tv);
        showStartStudy();
        getViewTreeObserver().addOnGlobalLayoutListener(new CanvasTripleScreenPagerPluginView$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$initViews$0$CanvasTripleScreenPagerPluginView() {
        this.height = this.courseWareArea.getHeight();
        this.width = this.courseWareArea.getWidth();
        this.scrolllview_height = this.scrollView.getHeight();
        this.scrolllview_width = this.scrollView.getWidth();
    }

    public void initData(boolean z) {
        CourseWareView courseWareView2 = this.courseWareView;
        if (courseWareView2 != null) {
            courseWareView2.enableAlignTimeStamp(z);
            this.courseWareView.setOnSwitchStatusListener(new CourseWareView.OnSwitchStatusListener() {
                CourseWareBean preCourseWareBean;

                public void onBegin(CourseWareBean courseWareBean) {
                    CourseWareBean courseWareBean2 = this.preCourseWareBean;
                    if (courseWareBean2 == null || TextUtils.isEmpty(courseWareBean2.pageId) || !this.preCourseWareBean.pageId.equals(courseWareBean.pageId)) {
                        this.preCourseWareBean = courseWareBean;
                        if (CanvasTripleScreenPagerPluginView.this.callBack != null) {
                            CanvasTripleScreenPagerPluginView.this.callBack.onCourseWareSwitchResult(1, courseWareBean);
                        }
                    }
                }

                public void onResult(boolean z, CourseWareBean courseWareBean) {
                    CanvasTripleScreenPagerPluginView.this.stateLayout.setVisibility(8);
                    if (CanvasTripleScreenPagerPluginView.this.callBack != null) {
                        CanvasTripleScreenPagerPluginView.this.callBack.onCourseWareSwitchResult(z ? 2 : 3, courseWareBean);
                    }
                    if (!z) {
                        CanvasTripleScreenPagerPluginView.this.showLoadFail();
                    }
                }
            });
        }
    }

    public void setCanvasView(View view) {
        this.courseWareArea.addView(view, new ViewGroup.LayoutParams(-1, -1));
        view.bringToFront();
    }

    public void setLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        this.mLiveRoomProvider = iLiveRoomProvider;
        CourseWareView courseWareView2 = this.courseWareView;
        if (courseWareView2 != null && iLiveRoomProvider != null) {
            courseWareView2.setLiveRoomProvider(iLiveRoomProvider);
        }
    }

    public void isBindCourseware(boolean z) {
        this.isBindCourseware = z;
        CourseWareView courseWareView2 = this.courseWareView;
        if (courseWareView2 != null) {
            courseWareView2.setBindCourseware(z);
        }
    }

    /* access modifiers changed from: package-private */
    public void showLoadFail() {
        LiveMainHandler.post(new CanvasTripleScreenPagerPluginView$$ExternalSyntheticLambda3(this));
    }

    public /* synthetic */ void lambda$showLoadFail$2$CanvasTripleScreenPagerPluginView() {
        this.stateLayout.setVisibility(0);
        this.stateTv.setText(R.string.course_load_fail);
        if (this.callBack != null) {
            int[] iArr = new int[2];
            this.stateTv.getLocationInWindow(iArr);
            this.callBack.onTouchAreaUpdate(new RectF(((float) iArr[0]) * 1.0f, ((float) iArr[1]) * 1.0f, (((float) iArr[0]) * 1.0f) + ((float) this.stateTv.getMeasuredWidth()), (((float) iArr[1]) * 1.0f) + ((float) this.stateTv.getMeasuredHeight())));
        }
        this.stateTv.setEnabled(true);
        this.stateTv.setOnClickListener(new CanvasTripleScreenPagerPluginView$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$showLoadFail$1$CanvasTripleScreenPagerPluginView(View view) {
        this.stateTv.setEnabled(false);
        CourseWareView courseWareView2 = this.courseWareView;
        if (courseWareView2 != null) {
            courseWareView2.failRetry();
        }
        CallBack callBack2 = this.callBack;
        if (callBack2 != null) {
            callBack2.onTouchAreaUpdate((RectF) null);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void refresh() {
        CourseWareView courseWareView2 = this.courseWareView;
        if (courseWareView2 != null) {
            courseWareView2.refresh();
        }
    }

    /* access modifiers changed from: package-private */
    public void showStartStudy() {
        LiveMainHandler.post(new CanvasTripleScreenPagerPluginView$$ExternalSyntheticLambda4(this));
    }

    public /* synthetic */ void lambda$showStartStudy$3$CanvasTripleScreenPagerPluginView() {
        if (this.isBindCourseware) {
            this.stateTv.setText(R.string.before_class);
            this.stateLayout.setVisibility(0);
            return;
        }
        this.mIvNoCourseware.setImageResource(R.drawable.bg_live_business_allonstage);
        this.stateLayout.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void alignTimeStamp(long j) {
        LiveMainHandler.post(new CanvasTripleScreenPagerPluginView$$ExternalSyntheticLambda5(this, j));
    }

    public /* synthetic */ void lambda$alignTimeStamp$4$CanvasTripleScreenPagerPluginView(long j) {
        CourseWareView courseWareView2 = this.courseWareView;
        if (courseWareView2 != null) {
            courseWareView2.alignTimeStamp(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void switchCourseWare(CourseWareBean courseWareBean, boolean z) {
        CourseWareView courseWareView2 = this.courseWareView;
        if (courseWareView2 != null) {
            courseWareView2.switchCourseWare(courseWareBean, z);
        }
    }

    public void setCallBack(CallBack callBack2) {
        this.callBack = callBack2;
    }

    public void onDestroy() {
        CourseWareView courseWareView2 = this.courseWareView;
        if (courseWareView2 != null) {
            courseWareView2.onDestroy();
        }
        CallBack callBack2 = this.callBack;
        if (callBack2 != null) {
            callBack2.onTouchAreaUpdate((RectF) null);
            this.callBack = null;
        }
    }

    public void onUnSupportActionList(List<WXWBAction> list) {
        List pointList;
        WXWBAction wXWBAction = null;
        long j = 0;
        WXWBAction wXWBAction2 = null;
        for (WXWBAction next : list) {
            if (next.getMessageType() == 6) {
                long timestamp = next.getTimestamp();
                if (timestamp > j) {
                    wXWBAction = next;
                    j = timestamp;
                }
            } else {
                wXWBAction2 = next;
            }
        }
        if (!(wXWBAction == null || (pointList = wXWBAction.getPointList()) == null || pointList.size() <= 0)) {
            WXWBAction.PointData pointData = (WXWBAction.PointData) pointList.get(0);
            scollTo(pointData.getX(), pointData.getY());
        }
        if (wXWBAction2 != null && SystemClock.uptimeMillis() - this.lastShowUnSupportToastTime >= ((long) (this.remindDuration * 1000))) {
            this.lastShowUnSupportToastTime = SystemClock.uptimeMillis();
            XesLog.e(Tag.TRIPLE_SCREEN, "不支持的信令:" + wXWBAction2.toString());
        }
    }

    public void setRemindDuration(int i) {
        this.remindDuration = i;
    }

    public void scollTo(float f, float f2) {
        int i = (int) (((float) (this.height - this.scrolllview_height)) * f2);
        this.scrollView.scrollTo((int) (((float) (this.width - this.scrolllview_width)) * f), i);
    }

    public /* synthetic */ void lambda$scrollToTop$5$CanvasTripleScreenPagerPluginView() {
        this.scrollView.scrollTo(0, 0);
    }

    public void scrollToTop() {
        this.scrollView.post(new CanvasTripleScreenPagerPluginView$$ExternalSyntheticLambda2(this));
    }
}
