package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.camera.listener.CaptureListener;
import com.luck.picture.lib.camera.listener.ClickListener;
import com.luck.picture.lib.camera.listener.TypeListener;
import com.luck.picture.lib.tools.ScreenUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public class CaptureLayout extends FrameLayout {
    /* access modifiers changed from: private */
    public TypeButton btn_cancel;
    private CaptureButton btn_capture;
    /* access modifiers changed from: private */
    public TypeButton btn_confirm;
    private ReturnButton btn_return;
    private final int button_size;
    /* access modifiers changed from: private */
    public CaptureListener captureListener;
    private int iconLeft;
    private int iconRight;
    private ImageView iv_custom_left;
    private ImageView iv_custom_right;
    private final int layout_height;
    private final int layout_width;
    private ClickListener leftClickListener;
    private ProgressBar progress_bar;
    private ClickListener rightClickListener;
    /* access modifiers changed from: private */
    public TextView txt_tip;
    private TypeListener typeListener;

    public void setTypeListener(TypeListener typeListener2) {
        this.typeListener = typeListener2;
    }

    public void setCaptureListener(CaptureListener captureListener2) {
        this.captureListener = captureListener2;
    }

    public CaptureLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CaptureLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iconLeft = 0;
        this.iconRight = 0;
        int screenWidth = ScreenUtils.getScreenWidth(getContext());
        if (getResources().getConfiguration().orientation == 1) {
            this.layout_width = screenWidth;
        } else {
            this.layout_width = screenWidth / 2;
        }
        int i2 = (int) (((float) this.layout_width) / 4.5f);
        this.button_size = i2;
        this.layout_height = i2 + ((i2 / 5) * 2) + 100;
        initView();
        initEvent();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.layout_width, this.layout_height);
    }

    public void initEvent() {
        this.iv_custom_right.setVisibility(8);
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
    }

    public void startTypeBtnAnimator() {
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(8);
        } else {
            this.btn_return.setVisibility(8);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(8);
        }
        this.btn_capture.setVisibility(8);
        this.btn_cancel.setVisibility(0);
        this.btn_confirm.setVisibility(0);
        this.btn_cancel.setClickable(false);
        this.btn_confirm.setClickable(false);
        this.iv_custom_left.setVisibility(8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.btn_cancel, "translationX", new float[]{(float) (this.layout_width / 4), 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.btn_confirm, "translationX", new float[]{(float) ((-this.layout_width) / 4), 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CaptureLayout.this.btn_cancel.setClickable(true);
                CaptureLayout.this.btn_confirm.setClickable(true);
            }
        });
        animatorSet.setDuration(500);
        animatorSet.start();
    }

    private void initView() {
        setWillNotDraw(false);
        this.progress_bar = new ProgressBar(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.progress_bar.setLayoutParams(layoutParams);
        this.progress_bar.setVisibility(8);
        this.btn_capture = new CaptureButton(getContext(), this.button_size);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        this.btn_capture.setLayoutParams(layoutParams2);
        this.btn_capture.setCaptureListener(new CaptureListener() {
            public void takePictures() {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.takePictures();
                }
                CaptureLayout.this.startAlphaAnimation();
            }

            public void recordShort(long j) {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordShort(j);
                }
            }

            public void recordStart() {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordStart();
                }
                CaptureLayout.this.startAlphaAnimation();
            }

            public void recordEnd(long j) {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordEnd(j);
                }
                CaptureLayout.this.startTypeBtnAnimator();
            }

            public void recordZoom(float f) {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordZoom(f);
                }
            }

            public void recordError() {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordError();
                }
            }

            public void recordUpdateTime(long j) {
                if (CaptureLayout.this.captureListener != null) {
                    CaptureLayout.this.captureListener.recordUpdateTime(j);
                }
            }
        });
        this.btn_cancel = new TypeButton(getContext(), 1, this.button_size);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 16;
        layoutParams3.setMargins((this.layout_width / 4) - (this.button_size / 2), 0, 0, 0);
        this.btn_cancel.setLayoutParams(layoutParams3);
        this.btn_cancel.setOnClickListener(new CaptureLayout$$ExternalSyntheticLambda0(this));
        this.btn_confirm = new TypeButton(getContext(), 2, this.button_size);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams4.gravity = 21;
        layoutParams4.setMargins(0, 0, (this.layout_width / 4) - (this.button_size / 2), 0);
        this.btn_confirm.setLayoutParams(layoutParams4);
        this.btn_confirm.setOnClickListener(new CaptureLayout$$ExternalSyntheticLambda1(this));
        this.btn_return = new ReturnButton(getContext(), (int) (((float) this.button_size) / 2.5f));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.setMargins(this.layout_width / 6, 0, 0, 0);
        this.btn_return.setLayoutParams(layoutParams5);
        this.btn_return.setOnClickListener(new CaptureLayout$$ExternalSyntheticLambda2(this));
        this.iv_custom_left = new ImageView(getContext());
        int i = this.button_size;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams((int) (((float) i) / 2.5f), (int) (((float) i) / 2.5f));
        layoutParams6.gravity = 16;
        layoutParams6.setMargins(this.layout_width / 6, 0, 0, 0);
        this.iv_custom_left.setLayoutParams(layoutParams6);
        this.iv_custom_left.setOnClickListener(new CaptureLayout$$ExternalSyntheticLambda3(this));
        this.iv_custom_right = new ImageView(getContext());
        int i2 = this.button_size;
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (((float) i2) / 2.5f), (int) (((float) i2) / 2.5f));
        layoutParams7.gravity = 21;
        layoutParams7.setMargins(0, 0, this.layout_width / 6, 0);
        this.iv_custom_right.setLayoutParams(layoutParams7);
        this.iv_custom_right.setOnClickListener(new CaptureLayout$$ExternalSyntheticLambda4(this));
        this.txt_tip = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams8.gravity = 1;
        layoutParams8.setMargins(0, 0, 0, 0);
        this.txt_tip.setText(getCaptureTip());
        this.txt_tip.setTextColor(-1);
        this.txt_tip.setGravity(17);
        this.txt_tip.setLayoutParams(layoutParams8);
        addView(this.btn_capture);
        addView(this.progress_bar);
        addView(this.btn_cancel);
        addView(this.btn_confirm);
        addView(this.btn_return);
        addView(this.iv_custom_left);
        addView(this.iv_custom_right);
        addView(this.txt_tip);
    }

    public /* synthetic */ void lambda$initView$0$CaptureLayout(View view) {
        TypeListener typeListener2 = this.typeListener;
        if (typeListener2 != null) {
            typeListener2.cancel();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$initView$1$CaptureLayout(View view) {
        TypeListener typeListener2 = this.typeListener;
        if (typeListener2 != null) {
            typeListener2.confirm();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$initView$2$CaptureLayout(View view) {
        ClickListener clickListener = this.leftClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$initView$3$CaptureLayout(View view) {
        ClickListener clickListener = this.leftClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$initView$4$CaptureLayout(View view) {
        ClickListener clickListener = this.rightClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public String getCaptureTip() {
        int buttonFeatures = this.btn_capture.getButtonFeatures();
        if (buttonFeatures != 257) {
            return buttonFeatures != 258 ? getContext().getString(R.string.picture_photo_camera) : "";
        }
        return getContext().getString(R.string.picture_photo_pictures);
    }

    public void setButtonCaptureEnabled(boolean z) {
        this.progress_bar.setVisibility(z ? 8 : 0);
        this.btn_capture.setButtonCaptureEnabled(z);
    }

    public void setCaptureLoadingColor(int i) {
        this.progress_bar.getIndeterminateDrawable().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(i, BlendModeCompat.SRC_IN));
    }

    public void resetCaptureLayout() {
        this.btn_capture.resetState();
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
        this.btn_capture.setVisibility(0);
        this.txt_tip.setText(getCaptureTip());
        this.txt_tip.setVisibility(0);
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(0);
        } else {
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(0);
        }
    }

    public void startAlphaAnimation() {
        this.txt_tip.setVisibility(4);
    }

    public void setTextWithAnimation(String str) {
        this.txt_tip.setText(str);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.txt_tip, "alpha", new float[]{0.0f, 1.0f, 1.0f, 0.0f});
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CaptureLayout.this.txt_tip.setText(CaptureLayout.this.getCaptureTip());
                CaptureLayout.this.txt_tip.setAlpha(1.0f);
            }
        });
        ofFloat.setDuration(2500);
        ofFloat.start();
    }

    public void setDuration(int i) {
        this.btn_capture.setDuration(i);
    }

    public void setMinDuration(int i) {
        this.btn_capture.setMinDuration(i);
    }

    public void setButtonFeatures(int i) {
        this.btn_capture.setButtonFeatures(i);
        this.txt_tip.setText(getCaptureTip());
    }

    public void setTip(String str) {
        this.txt_tip.setText(str);
    }

    public void showTip() {
        this.txt_tip.setVisibility(0);
    }

    public void setIconSrc(int i, int i2) {
        this.iconLeft = i;
        this.iconRight = i2;
        if (i != 0) {
            this.iv_custom_left.setImageResource(i);
            this.iv_custom_left.setVisibility(0);
            this.btn_return.setVisibility(8);
        } else {
            this.iv_custom_left.setVisibility(8);
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setImageResource(i2);
            this.iv_custom_right.setVisibility(0);
            return;
        }
        this.iv_custom_right.setVisibility(8);
    }

    public void setLeftClickListener(ClickListener clickListener) {
        this.leftClickListener = clickListener;
    }

    public void setRightClickListener(ClickListener clickListener) {
        this.rightClickListener = clickListener;
    }
}
