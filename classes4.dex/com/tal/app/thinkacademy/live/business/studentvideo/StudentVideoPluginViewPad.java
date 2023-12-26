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
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.yy.mobile.rollingtextview.RollingTextView;
import java.util.Objects;

public class StudentVideoPluginViewPad extends AbstractStudentVideoPluginView<StudentVideoPluginDriver> implements View.OnClickListener {
    protected Context context;
    protected RelativeLayout flS1;
    protected RelativeLayout flS2;
    protected RelativeLayout flS3;
    protected RelativeLayout flS4;
    protected ImageView ivHeadExamS2;
    protected ImageView ivHeadExamS3;
    protected ImageView ivHeadExamS4;
    protected ImageView ivHeadS1;
    protected ImageView ivHeadS2;
    protected ImageView ivHeadS3;
    protected ImageView ivHeadS4;
    protected ImageView ivLevel1;
    protected ImageView ivLevel2;
    protected ImageView ivLevel3;
    protected ImageView ivLevel4;
    protected ImageView ivTurn1;
    protected ImageView ivTurn2;
    protected ImageView ivTurn3;
    protected ImageView ivTurn4;
    protected int[] levelIcons = {R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    protected ImageView[] levelViews;
    private LottieAnimationView livS2;
    private LottieAnimationView livS3;
    private LottieAnimationView livS4;
    private LottieAnimationView[] lottieViews;
    private RedPackageRainViewModel mViewModel;
    protected RelativeLayout rlExamS2;
    protected RelativeLayout rlExamS3;
    protected RelativeLayout rlExamS4;
    protected RelativeLayout rlS1;
    protected RelativeLayout rlS2;
    protected RelativeLayout rlS3;
    protected RelativeLayout rlS4;
    protected int state1 = 0;
    protected int state2 = 0;
    protected int state3 = 0;
    protected int state4 = 0;
    protected boolean turnState1 = true;
    protected boolean turnState2 = true;
    protected boolean turnState3 = true;
    protected boolean turnState4 = true;
    protected TextView tvS1;
    protected TextView tvS2;
    protected TextView tvS3;
    protected TextView tvS4;
    protected RollingTextView tvUserCoins;

    public StudentVideoPluginViewPad(Context context2) {
        super(context2);
        this.context = context2;
    }

    public StudentVideoPluginViewPad(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    public StudentVideoPluginViewPad(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
    }

    public int getLayoutId() {
        return R.layout.live_business_studentvideo;
    }

    public void initViews() {
        this.rlS1 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent1);
        this.rlS2 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent2);
        this.rlS3 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent3);
        this.rlS4 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent4);
        this.flS1 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_1);
        this.flS2 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_2);
        this.flS3 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_3);
        this.flS4 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_4);
        this.tvS1 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_1);
        this.tvS2 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_2);
        this.tvS3 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_3);
        this.tvS4 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_4);
        this.ivHeadS1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head1);
        this.ivHeadS2 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head2);
        this.ivHeadS3 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head3);
        this.ivHeadS4 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head4);
        this.ivTurn1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_camera_1);
        this.ivTurn2 = (ImageView) getRootView().findViewById(R.id.iv_live_business_video_2);
        this.ivTurn3 = (ImageView) getRootView().findViewById(R.id.iv_live_business_video_3);
        this.ivTurn4 = (ImageView) getRootView().findViewById(R.id.iv_live_business_video_4);
        this.livS2 = getRootView().findViewById(R.id.liv_live_business_video_voice_2);
        this.livS3 = getRootView().findViewById(R.id.liv_live_business_video_voice_3);
        this.livS4 = getRootView().findViewById(R.id.liv_live_business_video_voice_4);
        this.tvUserCoins = getRootView().findViewById(R.id.tv_live_business_user_coins);
        this.ivLevel1 = (ImageView) getRootView().findViewById(R.id.iv_live_business_my_level);
        this.ivLevel2 = (ImageView) getRootView().findViewById(R.id.iv_live_business_level_2);
        this.ivLevel3 = (ImageView) getRootView().findViewById(R.id.iv_live_business_level_3);
        this.ivLevel4 = (ImageView) getRootView().findViewById(R.id.iv_live_business_level_4);
        this.rlExamS2 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent2_exam);
        this.ivHeadExamS2 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head2_exam);
        this.rlExamS3 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent3_exam);
        this.ivHeadExamS3 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head3_exam);
        this.rlExamS4 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent4_exam);
        this.ivHeadExamS4 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head4_exam);
        this.ivTurn1.setOnClickListener(this);
        this.ivTurn2.setOnClickListener(this);
        this.ivTurn3.setOnClickListener(this);
        this.ivTurn4.setOnClickListener(this);
        this.ivTurn1.setSelected(true);
        this.ivTurn2.setSelected(true);
        this.ivTurn3.setSelected(true);
        this.ivTurn4.setSelected(true);
        initLottieView();
        initLevelView();
        RedPackageRainViewModel viewModel = AbilityPack.get().getViewModel(RedPackageRainViewModel.class);
        this.mViewModel = viewModel;
        if (viewModel != null) {
            viewModel.setCoinImageView((ImageView) findViewById(R.id.iv_live_business_coins));
            this.mViewModel.setCoinTextView(this.tvUserCoins);
        }
        CoinCenterViewModel coinCenterViewModel = CoinCenterViewModelKt.getCoinCenterViewModel(AbilityPack.get());
        if (coinCenterViewModel != null) {
            ImageView coinImageView = this.mViewModel.getCoinImageView();
            Objects.requireNonNull(coinImageView);
            RollingTextView coinTextView = this.mViewModel.getCoinTextView();
            Objects.requireNonNull(coinTextView);
            coinCenterViewModel.bindingCoinView(coinImageView, coinTextView, (View) null);
        }
    }

    private void initLottieView() {
        this.livS2.setImageAssetsFolder("studentvideo_voice/images");
        this.livS2.setAnimation("studentvideo_voice/data.json");
        this.livS2.setRepeatCount(-1);
        this.livS3.setImageAssetsFolder("studentvideo_voice/images");
        this.livS3.setAnimation("studentvideo_voice/data.json");
        this.livS3.setRepeatCount(-1);
        this.livS4.setImageAssetsFolder("studentvideo_voice/images");
        this.livS4.setAnimation("studentvideo_voice/data.json");
        this.livS4.setRepeatCount(-1);
        this.lottieViews = new LottieAnimationView[]{this.livS2, this.livS3, this.livS4};
    }

    private void initLevelView() {
        this.levelViews = new ImageView[]{this.ivLevel1, this.ivLevel2, this.ivLevel3, this.ivLevel4};
    }

    public void addRenderView(SurfaceView surfaceView, int i) {
        if (surfaceView != null) {
            ViewGroup viewGroup = (ViewGroup) surfaceView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(surfaceView);
            }
            if (i == 0) {
                this.flS1.removeAllViews();
                this.flS1.addView(surfaceView, 0);
            } else if (i == 1) {
                this.flS2.removeAllViews();
                this.flS2.addView(surfaceView, 0);
            } else if (i != 2) {
                this.flS4.removeAllViews();
                this.flS4.addView(surfaceView, 0);
            } else {
                this.flS3.removeAllViews();
                this.flS3.addView(surfaceView, 0);
            }
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
        this.ivTurn1.setSelected(z);
    }

    public void clickToTurnView(int i) {
        String str = EnterRoomMuteData.STATUS_UN_MUTE;
        int i2 = 4;
        if (i == 0) {
            this.ivTurn1.setSelected(this.turnState1);
            RelativeLayout relativeLayout = this.rlS1;
            if (!this.turnState1) {
                i2 = 0;
            }
            relativeLayout.setVisibility(i2);
            StudentVideoPluginDriver studentVideoPluginDriver = (StudentVideoPluginDriver) this.driver;
            if (!this.turnState1) {
                str = "1";
            }
            studentVideoPluginDriver.track_click_group_own_video(str);
        } else if (i == 1) {
            this.ivTurn2.setSelected(this.turnState2);
            RelativeLayout relativeLayout2 = this.rlS2;
            if (!this.turnState2) {
                i2 = 0;
            }
            relativeLayout2.setVisibility(i2);
            StudentVideoPluginDriver studentVideoPluginDriver2 = (StudentVideoPluginDriver) this.driver;
            if (!this.turnState2) {
                str = "1";
            }
            studentVideoPluginDriver2.track_click_group_others_video(str);
        } else if (i != 2) {
            this.ivTurn4.setSelected(this.turnState4);
            RelativeLayout relativeLayout3 = this.rlS4;
            if (!this.turnState4) {
                i2 = 0;
            }
            relativeLayout3.setVisibility(i2);
            StudentVideoPluginDriver studentVideoPluginDriver3 = (StudentVideoPluginDriver) this.driver;
            if (!this.turnState4) {
                str = "1";
            }
            studentVideoPluginDriver3.track_click_group_others_video(str);
        } else {
            this.ivTurn3.setSelected(this.turnState3);
            RelativeLayout relativeLayout4 = this.rlS3;
            if (!this.turnState3) {
                i2 = 0;
            }
            relativeLayout4.setVisibility(i2);
            StudentVideoPluginDriver studentVideoPluginDriver4 = (StudentVideoPluginDriver) this.driver;
            if (!this.turnState3) {
                str = "1";
            }
            studentVideoPluginDriver4.track_click_group_others_video(str);
        }
    }

    public void showNoPermissionView(final int i) {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            public void run() {
                int i = i;
                if (i == 0) {
                    StudentVideoPluginViewPad.this.state1 = 0;
                    StudentVideoPluginViewPad.this.ivTurn1.setSelected(StudentVideoPluginViewPad.this.turnState1);
                    StudentVideoPluginViewPad.this.rlS1.setVisibility(0);
                } else if (i == 1) {
                    StudentVideoPluginViewPad.this.state2 = 0;
                    StudentVideoPluginViewPad.this.ivTurn2.setSelected(StudentVideoPluginViewPad.this.turnState2);
                    StudentVideoPluginViewPad.this.rlS2.setVisibility(0);
                } else if (i != 2) {
                    StudentVideoPluginViewPad.this.state4 = 0;
                    StudentVideoPluginViewPad.this.ivTurn4.setSelected(StudentVideoPluginViewPad.this.turnState4);
                    StudentVideoPluginViewPad.this.rlS4.setVisibility(0);
                } else {
                    StudentVideoPluginViewPad.this.state3 = 0;
                    StudentVideoPluginViewPad.this.ivTurn3.setSelected(StudentVideoPluginViewPad.this.turnState3);
                    StudentVideoPluginViewPad.this.rlS3.setVisibility(0);
                }
            }
        });
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, StudentVideoPluginViewPad.class);
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
        } else if (view.getId() == R.id.iv_live_business_video_2) {
            if (this.state2 != 0) {
                this.turnState2 = !this.turnState2;
                clickToTurnView(1);
            }
        } else if (view.getId() == R.id.iv_live_business_video_3) {
            if (this.state3 != 0) {
                this.turnState3 = !this.turnState3;
                clickToTurnView(2);
            }
        } else if (view.getId() == R.id.iv_live_business_video_4 && this.state4 != 0) {
            this.turnState4 = !this.turnState4;
            clickToTurnView(3);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void showStudentInfo(final StudentVideoBean.ListBean listBean, final int i) {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            public void run() {
                int i = i;
                if (i == 0) {
                    StudentVideoPluginViewPad.this.tvS1.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(StudentVideoPluginViewPad.this.context, listBean.getAvatar(), StudentVideoPluginViewPad.this.ivHeadS1, R.drawable.common_self_image_user);
                    StudentVideoPluginViewPad studentVideoPluginViewPad = StudentVideoPluginViewPad.this;
                    studentVideoPluginViewPad.showLevelIcon(0, listBean.getLevel() + "");
                } else if (i == 1) {
                    StudentVideoPluginViewPad.this.tvS2.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(StudentVideoPluginViewPad.this.context, listBean.getAvatar(), StudentVideoPluginViewPad.this.ivHeadS2, R.drawable.common_self_image_user);
                    ImageLoaderJ.loadCircle(StudentVideoPluginViewPad.this.context, listBean.getAvatar(), StudentVideoPluginViewPad.this.ivHeadExamS2, R.drawable.common_self_image_user);
                    StudentVideoPluginViewPad studentVideoPluginViewPad2 = StudentVideoPluginViewPad.this;
                    studentVideoPluginViewPad2.showLevelIcon(1, listBean.getLevel() + "");
                } else if (i != 2) {
                    StudentVideoPluginViewPad.this.tvS4.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(StudentVideoPluginViewPad.this.context, listBean.getAvatar(), StudentVideoPluginViewPad.this.ivHeadS4, R.drawable.common_self_image_user);
                    ImageLoaderJ.loadCircle(StudentVideoPluginViewPad.this.context, listBean.getAvatar(), StudentVideoPluginViewPad.this.ivHeadExamS4, R.drawable.common_self_image_user);
                    StudentVideoPluginViewPad studentVideoPluginViewPad3 = StudentVideoPluginViewPad.this;
                    studentVideoPluginViewPad3.showLevelIcon(3, listBean.getLevel() + "");
                } else {
                    StudentVideoPluginViewPad.this.tvS3.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(StudentVideoPluginViewPad.this.context, listBean.getAvatar(), StudentVideoPluginViewPad.this.ivHeadS3, R.drawable.common_self_image_user);
                    ImageLoaderJ.loadCircle(StudentVideoPluginViewPad.this.context, listBean.getAvatar(), StudentVideoPluginViewPad.this.ivHeadExamS3, R.drawable.common_self_image_user);
                    StudentVideoPluginViewPad studentVideoPluginViewPad4 = StudentVideoPluginViewPad.this;
                    studentVideoPluginViewPad4.showLevelIcon(2, listBean.getLevel() + "");
                }
            }
        });
    }

    public void studentOffline(final int i) {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            public void run() {
                int i = i;
                if (i == 0) {
                    StudentVideoPluginViewPad.this.state1 = 0;
                    StudentVideoPluginViewPad.this.ivTurn1.setVisibility(4);
                    StudentVideoPluginViewPad.this.rlS1.setVisibility(0);
                } else if (i == 1) {
                    StudentVideoPluginViewPad.this.state2 = 0;
                    StudentVideoPluginViewPad.this.ivTurn2.setVisibility(4);
                    StudentVideoPluginViewPad.this.rlS2.setVisibility(0);
                } else if (i != 2) {
                    StudentVideoPluginViewPad.this.state4 = 0;
                    StudentVideoPluginViewPad.this.ivTurn4.setVisibility(4);
                    StudentVideoPluginViewPad.this.rlS4.setVisibility(0);
                } else {
                    StudentVideoPluginViewPad.this.state3 = 0;
                    StudentVideoPluginViewPad.this.ivTurn3.setVisibility(4);
                    StudentVideoPluginViewPad.this.rlS3.setVisibility(0);
                }
            }
        });
    }

    public void studentOnline(final int i) {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            public void run() {
                int i = i;
                int i2 = 4;
                if (i == 0) {
                    StudentVideoPluginViewPad.this.state1 = 2;
                    StudentVideoPluginViewPad.this.ivTurn1.setVisibility(0);
                    RelativeLayout relativeLayout = StudentVideoPluginViewPad.this.rlS1;
                    if (!StudentVideoPluginViewPad.this.turnState1) {
                        i2 = 0;
                    }
                    relativeLayout.setVisibility(i2);
                } else if (i == 1) {
                    StudentVideoPluginViewPad.this.state2 = 2;
                    StudentVideoPluginViewPad.this.ivTurn2.setVisibility(0);
                    RelativeLayout relativeLayout2 = StudentVideoPluginViewPad.this.rlS2;
                    if (!StudentVideoPluginViewPad.this.turnState2) {
                        i2 = 0;
                    }
                    relativeLayout2.setVisibility(i2);
                } else if (i != 2) {
                    StudentVideoPluginViewPad.this.state4 = 2;
                    StudentVideoPluginViewPad.this.ivTurn4.setVisibility(0);
                    RelativeLayout relativeLayout3 = StudentVideoPluginViewPad.this.rlS4;
                    if (!StudentVideoPluginViewPad.this.turnState4) {
                        i2 = 0;
                    }
                    relativeLayout3.setVisibility(i2);
                } else {
                    StudentVideoPluginViewPad.this.state3 = 2;
                    StudentVideoPluginViewPad.this.ivTurn3.setVisibility(0);
                    RelativeLayout relativeLayout4 = StudentVideoPluginViewPad.this.rlS3;
                    if (!StudentVideoPluginViewPad.this.turnState3) {
                        i2 = 0;
                    }
                    relativeLayout4.setVisibility(i2);
                }
            }
        });
    }

    public void showExamMask(boolean z, int i) {
        ((Activity) this.context).runOnUiThread(new StudentVideoPluginViewPad$$ExternalSyntheticLambda0(this, i, z));
    }

    public /* synthetic */ void lambda$showExamMask$0$StudentVideoPluginViewPad(int i, boolean z) {
        int i2 = 8;
        if (i == 1) {
            RelativeLayout relativeLayout = this.rlExamS2;
            if (!z) {
                i2 = 0;
            }
            relativeLayout.setVisibility(i2);
        } else if (i != 2) {
            RelativeLayout relativeLayout2 = this.rlExamS4;
            if (!z) {
                i2 = 0;
            }
            relativeLayout2.setVisibility(i2);
        } else {
            RelativeLayout relativeLayout3 = this.rlExamS3;
            if (!z) {
                i2 = 0;
            }
            relativeLayout3.setVisibility(i2);
        }
    }

    public void showVoiceLottieView(int i) {
        if (i <= 3) {
            int i2 = 0;
            while (i2 < i) {
                this.lottieViews[i2].setVisibility(0);
                this.lottieViews[i2].playAnimation();
                i2++;
                this.levelViews[i2].setVisibility(8);
            }
        }
    }

    public void hideVoiceLottieView(int i) {
        if (i <= 3) {
            int i2 = 0;
            while (i2 < i) {
                this.lottieViews[i2].setVisibility(8);
                this.lottieViews[i2].cancelAnimation();
                i2++;
                this.levelViews[i2].setVisibility(0);
            }
        }
    }

    public void showLevelIcon(int i, String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt == 0) {
            this.levelViews[i].setVisibility(8);
            return;
        }
        this.levelViews[i].setVisibility(0);
        this.levelViews[i].setImageResource(this.levelIcons[parseInt - 1]);
    }
}
