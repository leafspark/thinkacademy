package com.didi.hummer.render.component.anim;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.didi.hummer.render.utility.YogaAttrUtils;
import java.io.Serializable;
import java.util.List;

@Component("KeyframeAnimation")
public class KeyframeAnimation extends BasicAnimation {
    @JsProperty("keyframes")
    private List<KeyFrame> keyframes;

    public class KeyFrame implements Serializable {
        public float percent;
        public Object value;

        public KeyFrame() {
        }
    }

    public KeyframeAnimation(String str) {
        super(str);
    }

    public void setKeyframes(List<KeyFrame> list) {
        this.keyframes = list;
    }

    public void start(HMBase hMBase) {
        View view = hMBase.getView();
        if ("position".equalsIgnoreCase(this.animType)) {
            animTranslation(view);
        } else if (HummerStyleUtils.Hummer.OPACITY.equalsIgnoreCase(this.animType)) {
            animAlpha(view);
        } else if ("scale".equalsIgnoreCase(this.animType)) {
            animScale(view, 13);
        } else if ("scaleX".equalsIgnoreCase(this.animType)) {
            animScale(view, 11);
        } else if ("scaleY".equalsIgnoreCase(this.animType)) {
            animScale(view, 12);
        } else if ("rotationX".equalsIgnoreCase(this.animType)) {
            animRotation(view, 1);
        } else if ("rotationY".equalsIgnoreCase(this.animType)) {
            animRotation(view, 2);
        } else if ("rotationZ".equalsIgnoreCase(this.animType)) {
            animRotation(view, 3);
        } else if ("backgroundColor".equalsIgnoreCase(this.animType)) {
            animBackgroundColor(hMBase);
        } else if ("width".equalsIgnoreCase(this.animType)) {
            animWidth(hMBase);
        } else if ("height".equalsIgnoreCase(this.animType)) {
            animHeight(hMBase);
        } else if ("skew".equalsIgnoreCase(this.animType)) {
            animSkew(hMBase);
        }
    }

    /* access modifiers changed from: protected */
    public void animTranslation(View view) {
        List<KeyFrame> list = this.keyframes;
        if (list != null) {
            Keyframe[] keyframeArr = new Keyframe[list.size()];
            Keyframe[] keyframeArr2 = new Keyframe[this.keyframes.size()];
            for (int i = 0; i < this.keyframes.size(); i++) {
                KeyFrame keyFrame = this.keyframes.get(i);
                Object[] trans2Array = trans2Array(keyFrame.value);
                Keyframe ofFloat = Keyframe.ofFloat(keyFrame.percent, HummerStyleUtils.convertNumber(trans2Array[0]));
                Keyframe ofFloat2 = Keyframe.ofFloat(keyFrame.percent, HummerStyleUtils.convertNumber(trans2Array[1]));
                keyframeArr[i] = ofFloat;
                keyframeArr2[i] = ofFloat2;
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("translationX", keyframeArr), PropertyValuesHolder.ofKeyframe("translationY", keyframeArr2)});
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
            ofPropertyValuesHolder.setRepeatCount(toRawRepeatCount(this.repeatCount));
            ofPropertyValuesHolder.setRepeatMode(toRawRepeatMode(this.repeatMode));
            ofPropertyValuesHolder.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
            ofPropertyValuesHolder.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: protected */
    public void animScale(View view, int i) {
        ObjectAnimator objectAnimator;
        List<KeyFrame> list = this.keyframes;
        if (list != null) {
            Keyframe[] keyframeArr = new Keyframe[list.size()];
            for (int i2 = 0; i2 < this.keyframes.size(); i2++) {
                KeyFrame keyFrame = this.keyframes.get(i2);
                keyframeArr[i2] = Keyframe.ofFloat(keyFrame.percent, HummerStyleUtils.convertNumber(keyFrame.value, false));
            }
            if (i == 11) {
                objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("scaleX", keyframeArr)});
            } else if (i != 12) {
                objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("scaleX", keyframeArr), PropertyValuesHolder.ofKeyframe("scaleY", keyframeArr)});
            } else {
                objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("scaleY", keyframeArr)});
            }
            this.animator = objectAnimator;
            objectAnimator.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
            objectAnimator.setRepeatCount(toRawRepeatCount(this.repeatCount));
            objectAnimator.setRepeatMode(toRawRepeatMode(this.repeatMode));
            objectAnimator.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
            objectAnimator.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
            objectAnimator.addListener(this.animatorListener);
            objectAnimator.start();
        }
    }

    /* access modifiers changed from: protected */
    public void animRotation(View view, int i) {
        List<KeyFrame> list = this.keyframes;
        if (list != null) {
            String str = i != 1 ? i != 2 ? "rotation" : "rotationY" : "rotationX";
            Keyframe[] keyframeArr = new Keyframe[list.size()];
            for (int i2 = 0; i2 < this.keyframes.size(); i2++) {
                KeyFrame keyFrame = this.keyframes.get(i2);
                keyframeArr[i2] = Keyframe.ofFloat(keyFrame.percent, HummerStyleUtils.convertNumber(keyFrame.value, false));
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(str, keyframeArr)});
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
            ofPropertyValuesHolder.setRepeatCount(toRawRepeatCount(this.repeatCount));
            ofPropertyValuesHolder.setRepeatMode(toRawRepeatMode(this.repeatMode));
            ofPropertyValuesHolder.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
            ofPropertyValuesHolder.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: protected */
    public void animAlpha(View view) {
        List<KeyFrame> list = this.keyframes;
        if (list != null) {
            Keyframe[] keyframeArr = new Keyframe[list.size()];
            for (int i = 0; i < this.keyframes.size(); i++) {
                KeyFrame keyFrame = this.keyframes.get(i);
                keyframeArr[i] = Keyframe.ofFloat(keyFrame.percent, HummerStyleUtils.convertNumber(keyFrame.value, false));
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("alpha", keyframeArr)});
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
            ofPropertyValuesHolder.setRepeatCount(toRawRepeatCount(this.repeatCount));
            ofPropertyValuesHolder.setRepeatMode(toRawRepeatMode(this.repeatMode));
            ofPropertyValuesHolder.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
            ofPropertyValuesHolder.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: protected */
    public void animBackgroundColor(HMBase hMBase) {
        List<KeyFrame> list = this.keyframes;
        if (list != null) {
            Keyframe[] keyframeArr = new Keyframe[list.size()];
            for (int i = 0; i < this.keyframes.size(); i++) {
                KeyFrame keyFrame = this.keyframes.get(i);
                keyframeArr[i] = Keyframe.ofInt(keyFrame.percent, YogaAttrUtils.parseColor(String.valueOf(keyFrame.value)));
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(hMBase.getBackgroundHelper(), new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("backgroundColor", keyframeArr)});
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setEvaluator(new ArgbEvaluator());
            ofPropertyValuesHolder.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
            ofPropertyValuesHolder.setRepeatCount(toRawRepeatCount(this.repeatCount));
            ofPropertyValuesHolder.setRepeatMode(toRawRepeatMode(this.repeatMode));
            ofPropertyValuesHolder.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
            ofPropertyValuesHolder.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: protected */
    public void animWidth(HMBase hMBase) {
        List<KeyFrame> list = this.keyframes;
        if (list != null) {
            Keyframe[] keyframeArr = new Keyframe[list.size()];
            for (int i = 0; i < this.keyframes.size(); i++) {
                KeyFrame keyFrame = this.keyframes.get(i);
                keyframeArr[i] = Keyframe.ofInt(keyFrame.percent, (int) HummerStyleUtils.convertNumber(keyFrame.value));
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(new AnimViewWrapper(hMBase), new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("width", keyframeArr)});
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
            ofPropertyValuesHolder.setRepeatCount(toRawRepeatCount(this.repeatCount));
            ofPropertyValuesHolder.setRepeatMode(toRawRepeatMode(this.repeatMode));
            ofPropertyValuesHolder.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
            ofPropertyValuesHolder.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: protected */
    public void animHeight(HMBase hMBase) {
        List<KeyFrame> list = this.keyframes;
        if (list != null) {
            Keyframe[] keyframeArr = new Keyframe[list.size()];
            for (int i = 0; i < this.keyframes.size(); i++) {
                KeyFrame keyFrame = this.keyframes.get(i);
                keyframeArr[i] = Keyframe.ofInt(keyFrame.percent, (int) HummerStyleUtils.convertNumber(keyFrame.value));
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(new AnimViewWrapper(hMBase), new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("height", keyframeArr)});
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
            ofPropertyValuesHolder.setRepeatCount(toRawRepeatCount(this.repeatCount));
            ofPropertyValuesHolder.setRepeatMode(toRawRepeatMode(this.repeatMode));
            ofPropertyValuesHolder.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
            ofPropertyValuesHolder.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: protected */
    public void animSkew(HMBase hMBase) {
        List<KeyFrame> list = this.keyframes;
        if (list != null) {
            Keyframe[] keyframeArr = new Keyframe[list.size()];
            Keyframe[] keyframeArr2 = new Keyframe[this.keyframes.size()];
            for (int i = 0; i < this.keyframes.size(); i++) {
                KeyFrame keyFrame = this.keyframes.get(i);
                Object[] trans2Array = trans2Array(keyFrame.value);
                Keyframe ofFloat = Keyframe.ofFloat(keyFrame.percent, (float) Math.tan(Math.toRadians((double) HummerStyleUtils.convertNumber(trans2Array[0], false))));
                Keyframe ofFloat2 = Keyframe.ofFloat(keyFrame.percent, (float) Math.tan(Math.toRadians((double) HummerStyleUtils.convertNumber(trans2Array[1], false))));
                keyframeArr[i] = ofFloat;
                keyframeArr2[i] = ofFloat2;
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(new AnimViewWrapper(hMBase), new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("skewX", keyframeArr), PropertyValuesHolder.ofKeyframe("skewY", keyframeArr2)});
            this.animator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
            ofPropertyValuesHolder.setRepeatCount(toRawRepeatCount(this.repeatCount));
            ofPropertyValuesHolder.setRepeatMode(toRawRepeatMode(this.repeatMode));
            ofPropertyValuesHolder.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
            ofPropertyValuesHolder.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
            ofPropertyValuesHolder.addListener(this.animatorListener);
            ofPropertyValuesHolder.start();
        }
    }
}
