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
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.yy.mobile.rollingtextview.RollingTextView;

public class SmallClassVideoPluginViewPhone extends AbstractStudentVideoPluginView<SmallClassPluginDriver> implements View.OnClickListener {
    protected RelativeLayout flS1;
    protected ImageView ivHeadS1;
    protected ImageView ivLevel1;
    protected ImageView ivTurn1;
    protected View layoutCoins;
    protected int[] levelIcons;
    protected View levelLayout;
    private CoinCenterViewModel mCoinViewModel;
    protected ImageView mHandUpImage;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean mMyBean;
    private RedPackageRainViewModel mViewModel;
    protected RelativeLayout rlS1;
    protected int state1;
    protected boolean turnState1;
    protected TextView tvS1;
    protected RollingTextView tvUserCoins;

    public SmallClassVideoPluginViewPhone(Context context) {
        this(context, (AttributeSet) null);
    }

    public SmallClassVideoPluginViewPhone(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmallClassVideoPluginViewPhone(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.turnState1 = true;
        this.state1 = 0;
        this.levelIcons = new int[]{R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    }

    public int getLayoutId() {
        return R.layout.live_business_studentvideo_small_class_phone;
    }

    public void initViews() {
        this.rlS1 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent1);
        this.flS1 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_1);
        this.tvS1 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_1);
        this.ivHeadS1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head1);
        this.ivTurn1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_camera_1);
        this.layoutCoins = getRootView().findViewById(R.id.layout_live_business_coins);
        this.tvUserCoins = getRootView().findViewById(R.id.tv_live_business_user_coins);
        this.ivLevel1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_my_level);
        this.levelLayout = getRootView().findViewById(R.id.layout_live_business_my_level);
        this.mHandUpImage = (ImageView) getRootView().findViewById(R.id.iv_live_business_hand_up);
        this.ivTurn1.setOnClickListener(this);
        this.ivTurn1.setSelected(true);
        RedPackageRainViewModel viewModel = AbilityPack.get().getViewModel(RedPackageRainViewModel.class);
        this.mViewModel = viewModel;
        if (viewModel != null) {
            viewModel.setCoinImageView((ImageView) findViewById(R.id.iv_live_business_coins));
            this.mViewModel.setCoinTextView(this.tvUserCoins);
        }
        CoinCenterViewModel viewModel2 = AbilityPack.get().getViewModel(CoinCenterViewModel.class);
        this.mCoinViewModel = viewModel2;
        if (viewModel2 != null) {
            viewModel2.bindingCoinView((ImageView) findViewById(R.id.iv_live_business_coins), this.tvUserCoins, (View) null);
        }
    }

    public void setDriver(SmallClassPluginDriver smallClassPluginDriver) {
        this.driver = smallClassPluginDriver;
    }

    public void addRenderView(SurfaceView surfaceView, int i, StudentVideoBean.ListBean listBean) {
        if (i == 0) {
            this.mMyBean = listBean;
            if (listBean != null) {
                if (listBean.isOnStageAction()) {
                    ImageLoaderJ.loadCircle(getContext(), listBean.getAvatar(), this.ivHeadS1, R.drawable.common_self_image_user);
                    this.levelLayout.setVisibility(8);
                    if (listBean.isShowOpenCameraButton()) {
                        this.ivTurn1.setVisibility(0);
                    } else {
                        this.ivTurn1.setVisibility(8);
                    }
                } else {
                    if (listBean.getCameraPerm() != 1 || !this.turnState1) {
                        this.rlS1.setVisibility(0);
                    } else {
                        this.renderViewWithPermission = true;
                        addSurfaceView(surfaceView, this.flS1);
                        this.rlS1.setVisibility(8);
                    }
                    if (listBean.isDisableTheVideo()) {
                        this.rlS1.setVisibility(0);
                    }
                    showLevelIcon(0, listBean.getLevel() + "");
                    this.ivTurn1.setVisibility(0);
                }
            }
        }
    }

    private void addSurfaceView(SurfaceView surfaceView, RelativeLayout relativeLayout) {
        StudentVideoBean.ListBean listBean = this.mMyBean;
        if ((listBean == null || !listBean.isDisableTheVideo()) && surfaceView != null) {
            boolean z = true;
            if (surfaceView.getParent() != null) {
                if (surfaceView.getParent() != relativeLayout) {
                    ((ViewGroup) surfaceView.getParent()).removeView(surfaceView);
                } else {
                    z = false;
                }
            }
            if (z) {
                relativeLayout.removeAllViews();
                relativeLayout.addView(surfaceView, 0);
            }
            if (surfaceView.getVisibility() != 0) {
                surfaceView.setVisibility(0);
            }
            surfaceView.requestLayout();
        }
    }

    public void setUserCoins(String str) {
        try {
            XesLog.it("SmallClassVideoPluginViewPhone", "coins " + str);
            if (Integer.parseInt(str) <= 0) {
                this.layoutCoins.setVisibility(8);
                return;
            }
            this.layoutCoins.setVisibility(0);
            this.tvUserCoins.setText(str, false);
        } catch (NumberFormatException e) {
            this.layoutCoins.setVisibility(8);
            XesLog.et("SmallClassVideoPluginViewPhone", e);
        }
    }

    public void setTurnState1(boolean z) {
        this.turnState1 = z;
    }

    public void clickToTurnView() {
        this.ivTurn1.setSelected(this.turnState1);
        int i = 0;
        if (this.mMyBean.isOnStageAction() || this.mMyBean.isDisableTheVideo()) {
            this.rlS1.setVisibility(0);
        } else {
            RelativeLayout relativeLayout = this.rlS1;
            if (this.turnState1) {
                i = 4;
            }
            relativeLayout.setVisibility(i);
        }
        ((SmallClassPluginDriver) this.driver).track_click_group_own_video(this.turnState1 ? EnterRoomMuteData.STATUS_UN_MUTE : "1");
    }

    public void showNoPermissionView(int i) {
        if (i == 0) {
            ((Activity) this.mContext).runOnUiThread(new Runnable() {
                public void run() {
                    SmallClassVideoPluginViewPhone.this.state1 = 0;
                    SmallClassVideoPluginViewPhone.this.ivTurn1.setSelected(SmallClassVideoPluginViewPhone.this.turnState1);
                    SmallClassVideoPluginViewPhone.this.rlS1.setVisibility(0);
                }
            });
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, SmallClassVideoPluginViewPhone.class);
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
            } else if (!((SmallClassPluginDriver) this.driver).isHasCameraPermission()) {
                this.renderViewWithPermission = false;
                ((SmallClassPluginDriver) this.driver).addPermissonWindow();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            } else {
                if (!this.renderViewWithPermission) {
                    this.renderViewWithPermission = true;
                    ((SmallClassPluginDriver) this.driver).showMyShelf();
                } else {
                    this.turnState1 = !this.turnState1;
                }
                ((SmallClassPluginDriver) this.driver).setMuteStudentVideo(true ^ this.turnState1);
                clickToTurnView();
                ((SmallClassPluginDriver) this.driver).enableLocalVideo(this.turnState1);
                ((SmallClassPluginDriver) this.driver).syncStudentView(0);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void changeTurnState(boolean z) {
        this.turnState1 = z;
        this.ivTurn1.setSelected(z);
        int i = 0;
        if (this.mMyBean.isOnStageAction() || this.mMyBean.isDisableTheVideo()) {
            this.rlS1.setVisibility(0);
            return;
        }
        RelativeLayout relativeLayout = this.rlS1;
        if (this.turnState1) {
            i = 4;
        }
        relativeLayout.setVisibility(i);
    }

    public void showStudentInfo(final StudentVideoBean.ListBean listBean, int i) {
        if (i == 0) {
            ((Activity) this.mContext).runOnUiThread(new Runnable() {
                public void run() {
                    StudentVideoBean.ListBean unused = SmallClassVideoPluginViewPhone.this.mMyBean = listBean;
                    SmallClassVideoPluginViewPhone.this.tvS1.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(SmallClassVideoPluginViewPhone.this.mContext, listBean.getAvatar(), SmallClassVideoPluginViewPhone.this.ivHeadS1, R.drawable.common_self_image_user);
                    SmallClassVideoPluginViewPhone smallClassVideoPluginViewPhone = SmallClassVideoPluginViewPhone.this;
                    smallClassVideoPluginViewPhone.showLevelIcon(0, listBean.getLevel() + "");
                }
            });
        }
    }

    public void studentOffline(int i, StudentVideoBean.ListBean listBean) {
        if (i == 0) {
            this.mMyBean = listBean;
            ((Activity) this.mContext).runOnUiThread(new Runnable() {
                public void run() {
                    SmallClassVideoPluginViewPhone.this.state1 = 0;
                    if (SmallClassVideoPluginViewPhone.this.mMyBean.isShowOpenCameraButton()) {
                        SmallClassVideoPluginViewPhone.this.ivTurn1.setVisibility(0);
                    } else {
                        SmallClassVideoPluginViewPhone.this.ivTurn1.setVisibility(8);
                    }
                    if (SmallClassVideoPluginViewPhone.this.mMyBean.isOnStageAction() || SmallClassVideoPluginViewPhone.this.mMyBean.isDisableTheVideo()) {
                        SmallClassVideoPluginViewPhone.this.rlS1.setVisibility(0);
                        SmallClassVideoPluginViewPhone.this.flS1.removeAllViews();
                        return;
                    }
                    SmallClassVideoPluginViewPhone.this.rlS1.setVisibility(8);
                }
            });
        }
    }

    public void studentOnline(int i, StudentVideoBean.ListBean listBean) {
        if (i == 0) {
            this.mMyBean = listBean;
            ((Activity) this.mContext).runOnUiThread(new Runnable() {
                public void run() {
                    SmallClassVideoPluginViewPhone.this.state1 = 2;
                    int i = 0;
                    SmallClassVideoPluginViewPhone.this.ivTurn1.setVisibility(0);
                    if (!SmallClassVideoPluginViewPhone.this.mMyBean.isShowOpenCameraButton()) {
                        SmallClassVideoPluginViewPhone.this.ivTurn1.setVisibility(8);
                    }
                    if (SmallClassVideoPluginViewPhone.this.mMyBean.isOnStageAction() || SmallClassVideoPluginViewPhone.this.mMyBean.isDisableTheVideo()) {
                        SmallClassVideoPluginViewPhone.this.rlS1.setVisibility(0);
                    } else {
                        SmallClassVideoPluginViewPhone.this.rlS1.setVisibility(8);
                    }
                    RelativeLayout relativeLayout = SmallClassVideoPluginViewPhone.this.rlS1;
                    if (SmallClassVideoPluginViewPhone.this.turnState1) {
                        i = 4;
                    }
                    relativeLayout.setVisibility(i);
                }
            });
        }
    }

    public void showRaiseHand(long j, boolean z) {
        StudentVideoBean.ListBean listBean;
        super.showRaiseHand(j, z);
        if (this.mHandUpImage == null) {
            return;
        }
        if (!z || (listBean = this.mMyBean) == null || listBean.isOnStageAction()) {
            this.mHandUpImage.setVisibility(8);
        } else {
            this.mHandUpImage.setVisibility(0);
        }
    }

    public void showLevelIcon(int i, String str) {
        if (i == 0) {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 0) {
                this.levelLayout.setVisibility(8);
                return;
            }
            this.levelLayout.setVisibility(0);
            this.ivLevel1.setImageResource(this.levelIcons[parseInt - 1]);
        }
    }
}
