package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe extends Keyframe<PointF> {
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, (PointF) keyframe.startValue, (PointF) keyframe.endValue, keyframe.interpolator, keyframe.xInterpolator, keyframe.yInterpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    public void createPath() {
        boolean z = (this.endValue == null || this.startValue == null || !((PointF) this.startValue).equals(((PointF) this.endValue).x, ((PointF) this.endValue).y)) ? false : true;
        if (this.startValue != null && this.endValue != null && !z) {
            this.path = Utils.createPath((PointF) this.startValue, (PointF) this.endValue, this.pointKeyFrame.pathCp1, this.pointKeyFrame.pathCp2);
        }
    }

    /* access modifiers changed from: package-private */
    public Path getPath() {
        return this.path;
    }
}
