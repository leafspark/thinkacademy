package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    public DocumentData getValue(Keyframe<DocumentData> keyframe, float f) {
        if (f != 1.0f || keyframe.endValue == null) {
            return (DocumentData) keyframe.startValue;
        }
        return (DocumentData) keyframe.endValue;
    }
}
