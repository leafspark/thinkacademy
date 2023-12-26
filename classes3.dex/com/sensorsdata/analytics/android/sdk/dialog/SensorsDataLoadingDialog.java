package com.sensorsdata.analytics.android.sdk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;

public class SensorsDataLoadingDialog extends Dialog {
    private RelativeLayout mLoadingLayout;

    public SensorsDataLoadingDialog(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.sensors_analytics_dialog_loading);
        Window window = getWindow();
        setCancelable(false);
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = SADisplayUtil.dip2px(getContext(), 98.0f);
            attributes.width = SADisplayUtil.dip2px(getContext(), 88.0f);
            window.setAttributes(attributes);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius((float) SADisplayUtil.dip2px(getContext(), 7.0f));
            window.setBackgroundDrawable(gradientDrawable);
        }
        initView();
    }

    private void initView() {
        this.mLoadingLayout = (RelativeLayout) findViewById(R.id.sensors_analytics_rotate_layout);
        setCircleBackground((ImageView) findViewById(R.id.sensorsdata_analytics_loading_image1), "#00C48E");
        setCircleBackground((ImageView) findViewById(R.id.sensorsdata_analytics_loading_image2), "#33D0A5");
        setCircleBackground((ImageView) findViewById(R.id.sensorsdata_analytics_loading_image3), "#CCF3E8");
        setCircleBackground((ImageView) findViewById(R.id.sensorsdata_analytics_loading_image4), "#80E1C6");
        initAnim();
    }

    private void setCircleBackground(View view, String str) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(Color.parseColor(str));
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(shapeDrawable);
        } else {
            view.setBackgroundDrawable(shapeDrawable);
        }
    }

    private void initAnim() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1200);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.mLoadingLayout.setAnimation(rotateAnimation);
    }
}
