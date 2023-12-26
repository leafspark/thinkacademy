package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;

public class CustomImageView extends AppCompatImageView {
    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            CustomImageView.super.onDraw(canvas);
        } catch (Throwable th) {
            Tag tag = Tag.COURSE_WARE;
            XesLog.e(tag, "课件图片加载异常=" + Log.getStackTraceString(th));
            HwTrackUtil.INSTANCE.track("hw_load_course_image_fail");
        }
    }
}
