package com.didi.hummer.render.component.anim;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.didi.hummer.render.utility.YogaAttrUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HummerAnimationUtils {
    public static final int AXIS_X = 1;
    public static final int AXIS_Y = 2;
    public static final int AXIS_Z = 3;
    public static final int DIRECTION_X = 11;
    public static final int DIRECTION_XY = 13;
    public static final int DIRECTION_Y = 12;

    public static int getAnimDelay(float f) {
        return (int) (f * 1000.0f);
    }

    public static long getAnimDuration(float f) {
        return (long) (f * 1000.0f);
    }

    public static TimeInterpolator getInterpolator(String str) {
        if ("linear".equalsIgnoreCase(str)) {
            return new LinearInterpolator();
        }
        if ("ease-in".equalsIgnoreCase(str)) {
            return new AccelerateInterpolator();
        }
        if ("ease-out".equalsIgnoreCase(str)) {
            return new DecelerateInterpolator();
        }
        if ("ease-in-out".equalsIgnoreCase(str)) {
            return new AccelerateDecelerateInterpolator();
        }
        return new AccelerateDecelerateInterpolator();
    }

    public static List<PropertyValuesHolder> parser(String str, Object obj) {
        return parser(str, obj, (Object) null);
    }

    public static List<PropertyValuesHolder> parser(String str, Object obj, Object obj2) {
        if ("position".equalsIgnoreCase(str) || "translate".equalsIgnoreCase(str)) {
            return animTranslation(obj, obj2);
        }
        if (HummerStyleUtils.Hummer.OPACITY.equalsIgnoreCase(str)) {
            return animAlpha(obj, obj2);
        }
        if ("scale".equalsIgnoreCase(str)) {
            return animScale(obj, obj2, 13);
        }
        if ("scaleX".equalsIgnoreCase(str)) {
            return animScale(obj, obj2, 11);
        }
        if ("scaleY".equalsIgnoreCase(str)) {
            return animScale(obj, obj2, 12);
        }
        if ("rotateX".equalsIgnoreCase(str) || "rotationX".equalsIgnoreCase(str)) {
            return animRotation(obj, obj2, 1);
        }
        if ("rotateY".equalsIgnoreCase(str) || "rotationY".equalsIgnoreCase(str)) {
            return animRotation(obj, obj2, 2);
        }
        if ("rotate".equalsIgnoreCase(str) || "rotateZ".equalsIgnoreCase(str) || "rotation".equalsIgnoreCase(str) || "rotationZ".equalsIgnoreCase(str)) {
            return animRotation(obj, obj2, 3);
        }
        if ("backgroundColor".equalsIgnoreCase(str)) {
            return animBackgroundColor(obj, obj2);
        }
        if ("width".equalsIgnoreCase(str)) {
            return animWidth(obj, obj2);
        }
        if ("height".equalsIgnoreCase(str)) {
            return animHeight(obj, obj2);
        }
        if ("skew".equalsIgnoreCase(str)) {
            return animSkew(obj, obj2);
        }
        return new ArrayList();
    }

    protected static Object[] trans2Array(Object obj) {
        if (!(obj instanceof Map)) {
            return null;
        }
        Map map = (Map) obj;
        return new Object[]{map.get("x"), map.get("y")};
    }

    private static List<PropertyValuesHolder> animTranslation(Object obj, Object obj2) {
        Object[] trans2Array = trans2Array(obj);
        float[] fArr = null;
        float[] fArr2 = (trans2Array == null || trans2Array.length != 2) ? null : new float[]{HummerStyleUtils.convertNumber(trans2Array[0]), HummerStyleUtils.convertNumber(trans2Array[1])};
        if (fArr2 == null) {
            return new ArrayList();
        }
        Object[] trans2Array2 = trans2Array(obj2);
        if (trans2Array2 != null && trans2Array2.length == 2) {
            fArr = new float[]{HummerStyleUtils.convertNumber(trans2Array2[0]), HummerStyleUtils.convertNumber(trans2Array2[1])};
        }
        ArrayList arrayList = new ArrayList();
        if (fArr != null) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationX", new float[]{fArr[0], fArr2[0]});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("translationY", new float[]{fArr[1], fArr2[1]});
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        } else {
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("translationX", new float[]{fArr2[0]});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("translationY", new float[]{fArr2[1]});
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
        }
        return arrayList;
    }

    private static List<PropertyValuesHolder> animAlpha(Object obj, Object obj2) {
        PropertyValuesHolder propertyValuesHolder;
        ArrayList arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        float convertNumber = HummerStyleUtils.convertNumber(obj, false);
        if (obj2 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[]{HummerStyleUtils.convertNumber(obj2, false), convertNumber});
        } else {
            propertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[]{convertNumber});
        }
        arrayList.add(propertyValuesHolder);
        return arrayList;
    }

    private static List<PropertyValuesHolder> animScale(Object obj, Object obj2, int i) {
        ArrayList arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        Object[] trans2Array = trans2Array(obj);
        if (trans2Array != null && trans2Array.length == 2 && i == 13) {
            float[] fArr = {HummerStyleUtils.convertNumber(trans2Array[0], false), HummerStyleUtils.convertNumber(trans2Array[1], false)};
            arrayList.add(PropertyValuesHolder.ofFloat("scaleX", new float[]{fArr[0]}));
            arrayList.add(PropertyValuesHolder.ofFloat("scaleY", new float[]{fArr[1]}));
            return arrayList;
        }
        float convertNumber = HummerStyleUtils.convertNumber(obj2, false);
        float convertNumber2 = HummerStyleUtils.convertNumber(obj, false);
        if (i != 11) {
            if (i != 12) {
                if (obj2 != null) {
                    arrayList.add(PropertyValuesHolder.ofFloat("scaleX", new float[]{convertNumber, convertNumber2}));
                    arrayList.add(PropertyValuesHolder.ofFloat("scaleY", new float[]{convertNumber, convertNumber2}));
                } else {
                    arrayList.add(PropertyValuesHolder.ofFloat("scaleX", new float[]{convertNumber2}));
                    arrayList.add(PropertyValuesHolder.ofFloat("scaleY", new float[]{convertNumber2}));
                }
            } else if (obj2 != null) {
                arrayList.add(PropertyValuesHolder.ofFloat("scaleY", new float[]{convertNumber, convertNumber2}));
            } else {
                arrayList.add(PropertyValuesHolder.ofFloat("scaleY", new float[]{convertNumber2}));
            }
        } else if (obj2 != null) {
            arrayList.add(PropertyValuesHolder.ofFloat("scaleX", new float[]{convertNumber, convertNumber2}));
        } else {
            arrayList.add(PropertyValuesHolder.ofFloat("scaleX", new float[]{convertNumber2}));
        }
        return arrayList;
    }

    private static List<PropertyValuesHolder> animRotation(Object obj, Object obj2, int i) {
        ArrayList arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        String str = i != 1 ? i != 2 ? "rotation" : "rotationY" : "rotationX";
        float convertNumber = HummerStyleUtils.convertNumber(obj2, false);
        float convertNumber2 = HummerStyleUtils.convertNumber(obj, false);
        if (obj2 != null) {
            arrayList.add(PropertyValuesHolder.ofFloat(str, new float[]{convertNumber, convertNumber2}));
        } else {
            arrayList.add(PropertyValuesHolder.ofFloat(str, new float[]{convertNumber2}));
        }
        return arrayList;
    }

    private static List<PropertyValuesHolder> animBackgroundColor(Object obj, Object obj2) {
        ArrayList arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        int parseColor = YogaAttrUtils.parseColor(String.valueOf(obj2));
        int parseColor2 = YogaAttrUtils.parseColor(String.valueOf(obj));
        if (obj2 != null) {
            arrayList.add(PropertyValuesHolder.ofObject("backgroundColor", new ArgbEvaluator(), new Object[]{Integer.valueOf(parseColor), Integer.valueOf(parseColor2)}));
        } else {
            arrayList.add(PropertyValuesHolder.ofObject("backgroundColor", new ArgbEvaluator(), new Object[]{Integer.valueOf(parseColor2)}));
        }
        return arrayList;
    }

    protected static List<PropertyValuesHolder> animWidth(Object obj, Object obj2) {
        ArrayList arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        int convertNumber = (int) HummerStyleUtils.convertNumber(obj);
        if (obj2 == null) {
            arrayList.add(PropertyValuesHolder.ofInt("width", new int[]{convertNumber}));
        } else {
            int convertNumber2 = (int) HummerStyleUtils.convertNumber(obj2);
            if (convertNumber2 == convertNumber) {
                return arrayList;
            }
            arrayList.add(PropertyValuesHolder.ofInt("width", new int[]{convertNumber2, convertNumber}));
        }
        return arrayList;
    }

    protected static List<PropertyValuesHolder> animHeight(Object obj, Object obj2) {
        ArrayList arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        int convertNumber = (int) HummerStyleUtils.convertNumber(obj);
        if (obj2 == null) {
            arrayList.add(PropertyValuesHolder.ofInt("height", new int[]{convertNumber}));
        } else {
            int convertNumber2 = (int) HummerStyleUtils.convertNumber(obj2);
            if (convertNumber2 == convertNumber) {
                return arrayList;
            }
            arrayList.add(PropertyValuesHolder.ofInt("height", new int[]{convertNumber2, convertNumber}));
        }
        return arrayList;
    }

    protected static List<PropertyValuesHolder> animSkew(Object obj, Object obj2) {
        ArrayList arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        float[] fArr = null;
        Object[] trans2Array = trans2Array(obj);
        if (trans2Array != null && trans2Array.length == 2) {
            fArr = new float[]{HummerStyleUtils.convertNumber(trans2Array[0], false), HummerStyleUtils.convertNumber(trans2Array[1], false)};
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("skewY", new float[]{(float) Math.tan(Math.toRadians((double) fArr[1]))});
        arrayList.add(PropertyValuesHolder.ofFloat("skewX", new float[]{(float) Math.tan(Math.toRadians((double) fArr[0]))}));
        arrayList.add(ofFloat);
        return arrayList;
    }
}
