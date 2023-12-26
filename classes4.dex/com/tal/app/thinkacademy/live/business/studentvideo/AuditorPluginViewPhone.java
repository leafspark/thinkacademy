package com.tal.app.thinkacademy.live.business.studentvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;

public class AuditorPluginViewPhone extends StudentVideoPluginViewPhone {
    public void addRenderView(SurfaceView surfaceView, int i) {
    }

    public void initData() {
    }

    public void initViews() {
    }

    public void setTurnState1(boolean z) {
    }

    public void setUserCoins(String str) {
    }

    public void showStudentInfo(StudentVideoBean.ListBean listBean, int i) {
    }

    public void studentOffline(int i) {
    }

    public void studentOnline(int i) {
    }

    public AuditorPluginViewPhone(Context context) {
        super(context);
    }

    public AuditorPluginViewPhone(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AuditorPluginViewPhone(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_studentvideo_auditor_phone;
    }
}
