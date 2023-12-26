package com.tal.app.thinkacademy.live.business.studentvideo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;

public class AuditorPluginViewPad extends StudentVideoPluginViewPad {
    public void setTurnState1(boolean z) {
    }

    public void setUserCoins(String str) {
    }

    public AuditorPluginViewPad(Context context) {
        super(context);
    }

    public AuditorPluginViewPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AuditorPluginViewPad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initViews() {
        this.rlS2 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent2);
        this.rlS3 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent3);
        this.rlS4 = (RelativeLayout) getRootView().findViewById(R.id.rl_live_business_head_parent4);
        this.flS2 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_2);
        this.flS3 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_3);
        this.flS4 = (RelativeLayout) getRootView().findViewById(R.id.fl_live_business_student_4);
        this.tvS2 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_2);
        this.tvS3 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_3);
        this.tvS4 = (TextView) getRootView().findViewById(R.id.tv_live_business_name_4);
        this.ivHeadS2 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head2);
        this.ivHeadS3 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head3);
        this.ivHeadS4 = (ImageView) getRootView().findViewById(R.id.iv_live_business_head4);
        this.ivLevel2 = (ImageView) getRootView().findViewById(R.id.iv_live_business_level_2);
        this.ivLevel3 = (ImageView) getRootView().findViewById(R.id.iv_live_business_level_3);
        this.ivLevel4 = (ImageView) getRootView().findViewById(R.id.iv_live_business_level_4);
        initLevelView();
    }

    private void initLevelView() {
        this.levelViews = new ImageView[]{null, this.ivLevel2, this.ivLevel3, this.ivLevel4};
    }

    public int getLayoutId() {
        return R.layout.live_business_studentvideo_auditor;
    }

    public void addRenderView(SurfaceView surfaceView, int i) {
        if (surfaceView != null) {
            ViewGroup viewGroup = (ViewGroup) surfaceView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(surfaceView);
            }
            if (i != 0) {
                if (i == 1) {
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
    }

    public void showStudentInfo(final StudentVideoBean.ListBean listBean, final int i) {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            public void run() {
                int i = i;
                if (i == 0) {
                    return;
                }
                if (i == 1) {
                    AuditorPluginViewPad.this.tvS2.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(AuditorPluginViewPad.this.context, listBean.getAvatar(), AuditorPluginViewPad.this.ivHeadS2, R.drawable.common_self_image_user);
                    AuditorPluginViewPad auditorPluginViewPad = AuditorPluginViewPad.this;
                    auditorPluginViewPad.showLevelIcon(1, listBean.getLevel() + "");
                } else if (i != 2) {
                    AuditorPluginViewPad.this.tvS4.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(AuditorPluginViewPad.this.context, listBean.getAvatar(), AuditorPluginViewPad.this.ivHeadS4, R.drawable.common_self_image_user);
                    AuditorPluginViewPad auditorPluginViewPad2 = AuditorPluginViewPad.this;
                    auditorPluginViewPad2.showLevelIcon(3, listBean.getLevel() + "");
                } else {
                    AuditorPluginViewPad.this.tvS3.setText(listBean.getNickName());
                    ImageLoaderJ.loadCircle(AuditorPluginViewPad.this.context, listBean.getAvatar(), AuditorPluginViewPad.this.ivHeadS3, R.drawable.common_self_image_user);
                    AuditorPluginViewPad auditorPluginViewPad3 = AuditorPluginViewPad.this;
                    auditorPluginViewPad3.showLevelIcon(2, listBean.getLevel() + "");
                }
            }
        });
    }

    public void studentOnline(final int i) {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            public void run() {
                int i = i;
                if (i != 0) {
                    int i2 = 4;
                    if (i == 1) {
                        RelativeLayout relativeLayout = AuditorPluginViewPad.this.rlS2;
                        if (!AuditorPluginViewPad.this.turnState2) {
                            i2 = 0;
                        }
                        relativeLayout.setVisibility(i2);
                    } else if (i != 2) {
                        RelativeLayout relativeLayout2 = AuditorPluginViewPad.this.rlS4;
                        if (!AuditorPluginViewPad.this.turnState4) {
                            i2 = 0;
                        }
                        relativeLayout2.setVisibility(i2);
                    } else {
                        RelativeLayout relativeLayout3 = AuditorPluginViewPad.this.rlS3;
                        if (!AuditorPluginViewPad.this.turnState3) {
                            i2 = 0;
                        }
                        relativeLayout3.setVisibility(i2);
                    }
                }
            }
        });
    }

    public void studentOffline(final int i) {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            public void run() {
                int i = i;
                if (i == 0) {
                    return;
                }
                if (i == 1) {
                    AuditorPluginViewPad.this.rlS2.setVisibility(0);
                } else if (i != 2) {
                    AuditorPluginViewPad.this.rlS4.setVisibility(0);
                } else {
                    AuditorPluginViewPad.this.rlS3.setVisibility(0);
                }
            }
        });
    }
}
