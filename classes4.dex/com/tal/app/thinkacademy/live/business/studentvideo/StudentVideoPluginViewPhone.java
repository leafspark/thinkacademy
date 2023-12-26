package com.tal.app.thinkacademy.live.business.studentvideo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.yy.mobile.rollingtextview.RollingTextView;
import java.util.Objects;

public class StudentVideoPluginViewPhone extends StudentVideoPluginViewPad implements View.OnClickListener {
    private RedPackageRainViewModel mViewModel;

    public StudentVideoPluginViewPhone(Context context) {
        super(context);
        this.context = context;
    }

    public StudentVideoPluginViewPhone(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public StudentVideoPluginViewPhone(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public int getLayoutId() {
        return R.layout.live_business_studentvideo_phone;
    }

    public void initViews() {
        this.rlS1 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent1);
        this.flS1 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_1);
        this.tvS1 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_1);
        this.ivHeadS1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head1);
        this.ivTurn1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_camera_1);
        this.tvUserCoins = getRootView().findViewById(R.id.tv_live_business_user_coins);
        this.ivLevel1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_my_level);
        this.ivTurn1.setOnClickListener(this);
        this.ivTurn1.setSelected(true);
        initLevelView();
        RedPackageRainViewModel viewModel = AbilityPack.get().getViewModel(RedPackageRainViewModel.class);
        this.mViewModel = viewModel;
        if (viewModel != null) {
            viewModel.setCoinImageView((ImageView) findViewById(R.id.iv_live_business_coins));
            this.mViewModel.setCoinTextView(this.tvUserCoins);
        }
        CoinCenterViewModel viewModel2 = AbilityPack.get().getViewModel(CoinCenterViewModel.class);
        if (viewModel2 != null) {
            ImageView coinImageView = this.mViewModel.getCoinImageView();
            Objects.requireNonNull(coinImageView);
            RollingTextView coinTextView = this.mViewModel.getCoinTextView();
            Objects.requireNonNull(coinTextView);
            viewModel2.bindingCoinView(coinImageView, coinTextView, (View) null);
        }
    }

    private void initLevelView() {
        this.levelViews = new ImageView[]{this.ivLevel1};
    }

    public void addRenderView(SurfaceView surfaceView, int i) {
        if (i == 0 && surfaceView != null) {
            ViewGroup viewGroup = (ViewGroup) surfaceView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(surfaceView);
            }
            this.flS1.removeAllViews();
            this.flS1.addView(surfaceView, 0);
            if (surfaceView.getVisibility() != 0) {
                surfaceView.setVisibility(0);
            }
            surfaceView.requestLayout();
        }
    }

    public void setUserCoins(String str) {
        this.tvUserCoins.setText(str, false);
    }

    public void setTurnState1(boolean z) {
        this.turnState1 = z;
    }

    public void clickToTurnView(int i) {
        super.clickToTurnView(0);
    }

    public void showNoPermissionView(int i) {
        if (i == 0) {
            ((Activity) this.context).runOnUiThread(new Runnable() {
                public void run() {
                    StudentVideoPluginViewPhone.this.state1 = 0;
                    StudentVideoPluginViewPhone.this.ivTurn1.setSelected(StudentVideoPluginViewPhone.this.turnState1);
                    StudentVideoPluginViewPhone.this.rlS1.setVisibility(0);
                }
            });
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, StudentVideoPluginViewPhone.class);
        if (view.getId() == R.id.iv_live_business_camera_1) {
            if (!this.isEnableSwitch) {
                if (this.state == EnableState.TEACHER_LINK || this.state == EnableState.TUTOR_LINK || this.state == EnableState.RANGE_LINK) {
                    ToastUtils.showShort((CharSequence) "Please try again after the Video Link.");
                } else if (this.state == EnableState.CAMERA) {
                    ToastUtils.showShort((CharSequence) "Please try again after the Photopost.");
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            } else if (!((StudentVideoPluginDriver) this.driver).isHasPermission()) {
                this.renderViewWithPermission = false;
                ((StudentVideoPluginDriver) this.driver).addPermissonWindow();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            } else {
                if (!this.renderViewWithPermission) {
                    this.renderViewWithPermission = true;
                    ((StudentVideoPluginDriver) this.driver).showMyShelf();
                }
                this.turnState1 = !this.turnState1;
                ((StudentVideoPluginDriver) this.driver).setMuteStudentVideo(true ^ this.turnState1);
                clickToTurnView(0);
                ((StudentVideoPluginDriver) this.driver).enableLocalVideo(this.turnState1);
                DriverTrack.INSTANCE.classroomMyCamera(this.turnState1 ? 1 : 0);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void showStudentInfo(final StudentVideoBean.ListBean listBean, int i) {
        if (i == 0) {
            ((Activity) this.context).runOnUiThread(new Runnable() {
                public void run() {
                    StudentVideoPluginViewPhone.this.tvS1.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(StudentVideoPluginViewPhone.this.context, listBean.getAvatar(), StudentVideoPluginViewPhone.this.ivHeadS1, R.drawable.common_self_image_user);
                    StudentVideoPluginViewPhone studentVideoPluginViewPhone = StudentVideoPluginViewPhone.this;
                    studentVideoPluginViewPhone.showLevelIcon(0, listBean.getLevel() + "");
                }
            });
        }
    }

    public void studentOffline(int i) {
        if (i == 0) {
            ((Activity) this.context).runOnUiThread(new Runnable() {
                public void run() {
                    StudentVideoPluginViewPhone.this.state1 = 0;
                    StudentVideoPluginViewPhone.this.ivTurn1.setVisibility(4);
                    StudentVideoPluginViewPhone.this.rlS1.setVisibility(0);
                }
            });
        }
    }

    public void studentOnline(int i) {
        if (i == 0) {
            ((Activity) this.context).runOnUiThread(new Runnable() {
                public void run() {
                    StudentVideoPluginViewPhone.this.state1 = 2;
                    int i = 0;
                    StudentVideoPluginViewPhone.this.ivTurn1.setVisibility(0);
                    RelativeLayout relativeLayout = StudentVideoPluginViewPhone.this.rlS1;
                    if (StudentVideoPluginViewPhone.this.turnState1) {
                        i = 4;
                    }
                    relativeLayout.setVisibility(i);
                }
            });
        }
    }
}
