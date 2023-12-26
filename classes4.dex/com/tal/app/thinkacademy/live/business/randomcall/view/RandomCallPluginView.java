package com.tal.app.thinkacademy.live.business.randomcall.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.randomcall.CustomLayoutManager;
import com.tal.app.thinkacademy.live.business.randomcall.adapter.MachineAdapter;
import com.tal.app.thinkacademy.live.business.randomcall.bean.RandomCallBean;
import com.tal.app.thinkacademy.live.business.randomcall.driver.RandomCallPluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.List;

public class RandomCallPluginView extends BaseLivePluginView {
    private static final int DEFAULT_ITEM = 7;
    private MachineAdapter adapter;
    private ConstraintLayout cl_machine;
    /* access modifiers changed from: private */
    public ConstraintLayout cl_user;
    /* access modifiers changed from: private */
    public RandomCallPluginDriver driver;
    /* access modifiers changed from: private */
    public boolean isSmoothScroll;
    private ImageView iv_close;
    private ImageView iv_control;
    private ImageView iv_user_head;
    private ImageView iv_user_level;
    private int[] levels = {-1, R.drawable.icon_level1_iron_miduem, R.drawable.icon_level2_bronze_miduem, R.drawable.icon_level3_sliver_miduem, R.drawable.icon_level4_gold_miduem, R.drawable.icon_level5_platinum_miduem, R.drawable.icon_level6_diamond_miduem, R.drawable.icon_level7_crown_miduem};
    /* access modifiers changed from: private */
    public LottieAnimationView liv_light;
    private String mUserId;
    /* access modifiers changed from: private */
    public RecyclerView rv_user_picker;
    private List<RandomCallBean.Student> students;
    private TextView tv_title;
    private TextView tv_user_name;
    private RandomCallBean.Student winner;

    public RandomCallPluginView(Context context) {
        super(context);
    }

    public RandomCallPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RandomCallPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        if (PadUtils.isPad(this.mContext)) {
            return R.layout.live_business_random_call_pad;
        }
        return R.layout.live_business_random_call_phone;
    }

    public void initViews() {
        RandomCallPluginView.super.initViews();
        this.cl_machine = getInflateView().findViewById(R.id.live_business_random_call_cl_machine);
        this.rv_user_picker = getInflateView().findViewById(R.id.live_business_random_call_rv_user_picker);
        this.iv_control = (ImageView) getInflateView().findViewById(R.id.live_business_random_call_iv_control);
        this.liv_light = getInflateView().findViewById(R.id.live_business_random_call_liv_light);
        this.cl_user = getInflateView().findViewById(R.id.live_business_random_call_cl_user);
        this.iv_user_head = (ImageView) getInflateView().findViewById(R.id.live_business_random_call_iv_user_head);
        this.iv_user_level = (ImageView) getInflateView().findViewById(R.id.live_business_random_call_iv_user_level);
        this.tv_user_name = (TextView) getInflateView().findViewById(R.id.live_business_random_call_tv_user_name);
        this.tv_title = (TextView) getInflateView().findViewById(R.id.live_business_random_call_tv_title);
        this.iv_close = (ImageView) getInflateView().findViewById(R.id.live_business_random_call_iv_user_close);
    }

    public void initData() {
        RandomCallPluginView.super.initData();
        initRecyclerView();
        initLottieView();
        initClose();
    }

    private void initRecyclerView() {
        new LinearSnapHelper().attachToRecyclerView(this.rv_user_picker);
        this.rv_user_picker.setLayoutManager(new CustomLayoutManager(getContext()));
        this.rv_user_picker.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                RandomCallPluginView.super.onScrollStateChanged(recyclerView, i);
                if (RandomCallPluginView.this.isSmoothScroll && i == 0) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            RandomCallPluginView.this.machineAnimation();
                        }
                    }, 200);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                RandomCallPluginView.super.onScrolled(recyclerView, i, i2);
                if (i2 != 0 && !RandomCallPluginView.this.isSmoothScroll) {
                    boolean unused = RandomCallPluginView.this.isSmoothScroll = true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void machineAnimation() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cl_machine, View.SCALE_X, new float[]{1.0f, 0.4f, 1.2f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cl_machine, View.SCALE_Y, new float[]{1.0f, 0.4f, 1.2f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.cl_machine, View.ALPHA, new float[]{1.0f, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(600);
        animatorSet.start();
        preSelectRes();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RandomCallPluginView.this.cl_user.setVisibility(0);
                RandomCallPluginView.this.liv_light.playAnimation();
                RandomCallPluginView.this.userAnimation();
            }
        });
    }

    private void preSelectRes() {
        if (TextUtils.isEmpty(this.mUserId) || this.winner.getUserId() != Long.parseLong(this.mUserId)) {
            SoundPoolUtils.play(getContext(), R.raw.live_business_random_unselect, 0);
            this.tv_title.setText(getResources().getString(R.string.the_lucky_student_is_, new Object[]{this.winner.getName()}));
        } else {
            SoundPoolUtils.play(getContext(), R.raw.live_business_random_select, 0);
            this.tv_title.setText(getResources().getString(R.string.congratulations_you_re_the_winner));
        }
        ImageLoaderJ.loadCircle(getContext(), this.winner.getAvatar(), this.iv_user_head, R.drawable.user_icon);
        if (this.winner.getLevel() != 0) {
            this.iv_user_level.setImageResource(this.levels[this.winner.getLevel()]);
        } else {
            this.iv_user_level.setVisibility(8);
        }
        this.tv_user_name.setText(this.winner.getName());
    }

    /* access modifiers changed from: private */
    public void userAnimation() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cl_user, View.SCALE_X, new float[]{0.6f, 1.2f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cl_user, View.SCALE_Y, new float[]{0.6f, 1.2f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.cl_user, View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(300);
        animatorSet.start();
    }

    private void initLottieView() {
        this.liv_light.setImageAssetsFolder("random_select/images");
        this.liv_light.setAnimation("random_select/data.json");
        this.liv_light.setRepeatCount(-1);
    }

    private void initClose() {
        this.iv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, RandomCallPluginView.class);
                RandomCallPluginView.this.driver.tryDestroyPluginView();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void setStudents(List<RandomCallBean.Student> list) {
        this.students = list;
        if (!list.isEmpty()) {
            this.winner = list.get(7);
            MachineAdapter machineAdapter = new MachineAdapter(getContext(), list);
            this.adapter = machineAdapter;
            this.rv_user_picker.setAdapter(machineAdapter);
        }
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setDriver(RandomCallPluginDriver randomCallPluginDriver) {
        this.driver = randomCallPluginDriver;
    }

    public void startRandomSelect() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iv_control, View.SCALE_Y, new float[]{1.0f, 0.5f, 0.5f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.start();
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SoundPoolUtils.play(RandomCallPluginView.this.getContext(), R.raw.live_business_random, 0);
                RandomCallPluginView.this.rv_user_picker.smoothScrollToPosition(7);
            }
        });
    }
}
