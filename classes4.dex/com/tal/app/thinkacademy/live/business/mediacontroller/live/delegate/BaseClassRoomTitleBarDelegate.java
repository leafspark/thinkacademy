package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.dialog.BrowserDialog;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;

public abstract class BaseClassRoomTitleBarDelegate implements LifecycleOwner {
    protected boolean isPad;
    protected Context mContext;
    protected DataStorage mDataStorage;
    protected MediaControlLiveDriver mDriver;
    private BrowserDialog mExamReportDialog;
    private BaseDialog mNoExamReportDialog;
    protected TeacherFeedbackHelper teacherFeedbackHelper;

    public abstract BaseMediaControlView getMediaView();

    public void onDestroy() {
    }

    public abstract void onMessage(String str, String str2);

    public void requestExamReport(boolean z) {
    }

    public void init(Context context, MediaControlLiveDriver mediaControlLiveDriver, DataStorage dataStorage, boolean z) {
        this.isPad = z;
        this.mDataStorage = dataStorage;
        this.mDriver = mediaControlLiveDriver;
        this.mContext = context;
        this.teacherFeedbackHelper = new TeacherFeedbackHelper(context, mediaControlLiveDriver);
    }

    public TeacherFeedbackHelper getPcFeedbackHelper() {
        return this.teacherFeedbackHelper;
    }

    public final void destroy() {
        this.teacherFeedbackHelper.destroy();
        onDestroy();
    }

    public Lifecycle getLifecycle() {
        return this.mDriver.getLifecycle();
    }

    /* access modifiers changed from: protected */
    public void showExamReportDialog(String str) {
        int dp2px = LiveAreaContext.get().getScreenLp().width - SizeUtils.dp2px(168.0f);
        int dp2px2 = LiveAreaContext.get().getScreenLp().height - SizeUtils.dp2px(20.0f);
        if (this.isPad) {
            dp2px = LiveAreaContext.get().getScreenLp().width - SizeUtils.dp2px(164.0f);
            dp2px2 = LiveAreaContext.get().getScreenLp().height - SizeUtils.dp2px(124.0f);
        }
        if (this.mExamReportDialog == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dp2px, dp2px2);
            BrowserDialog browserDialog = new BrowserDialog(this.mContext);
            this.mExamReportDialog = browserDialog;
            browserDialog.layoutParams(layoutParams).gravity(17).dismissListener(BaseClassRoomTitleBarDelegate$$ExternalSyntheticLambda1.INSTANCE).canceledOnTouchOutside(true);
        }
        StringBuilder sb = new StringBuilder(str);
        String str2 = this.isPad ? "4" : "1";
        sb.append("&platform=");
        sb.append(str2);
        sb.append("&token=");
        sb.append(UserInfoBll.getInstance().getUserInfoEntity().getUnifiedAccessToken());
        sb.append("&studentId=");
        sb.append(UserInfoBll.getInstance().getUserInfoEntity().getUid());
        sb.append("&classId=");
        sb.append(this.mDataStorage.getCourseInfo().getClassId());
        sb.append("&from=live");
        this.mExamReportDialog.setContainerRadius((float) SizeUtils.dp2px(10.0f));
        this.mExamReportDialog.loadUrl(sb.toString());
        this.mExamReportDialog.show();
        XesDataBus.with(DataBusKey.EXAM_REPORT_SHOWING).postStickyData(true);
    }

    /* access modifiers changed from: protected */
    public void showNoExamReport() {
        if (this.mNoExamReportDialog == null) {
            BaseDialog baseDialog = new BaseDialog(this.mContext);
            this.mNoExamReportDialog = baseDialog;
            baseDialog.contentView(R.layout.live_business_dialog_no_report).gravity(17).canceledOnTouchOutside(true);
            this.mNoExamReportDialog.findViewById(R.id.tv_confirm).setOnClickListener(new BaseClassRoomTitleBarDelegate$$ExternalSyntheticLambda0(this));
        }
        this.mNoExamReportDialog.show();
    }

    public /* synthetic */ void lambda$showNoExamReport$1$BaseClassRoomTitleBarDelegate(View view) {
        this.mNoExamReportDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
