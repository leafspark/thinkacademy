package com.tal.app.thinkacademy.live.business.mediacontroller.feedback;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.io.File;

public class ScreenshotPreView extends BaseLivePluginView {
    public ScreenshotPreView(Context context) {
        super(context);
    }

    public ScreenshotPreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenshotPreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_screenshot_preview_layout;
    }

    public void initPreview(String str) {
        final ImageView imageView = (ImageView) findViewById(R.id.iv_live_business_media_controller_controls_preview);
        Glide.with(this.mContext).load(new File(str)).into(imageView);
        imageView.setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                imageView.setVisibility(8);
            }
        }, 3000);
    }
}
