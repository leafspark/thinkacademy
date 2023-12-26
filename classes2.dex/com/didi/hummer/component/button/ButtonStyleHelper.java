package com.didi.hummer.component.button;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.didi.hummer.render.component.view.BackgroundDrawable;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.didi.hummer.render.utility.YogaAttrUtils;
import java.util.ArrayList;
import java.util.Map;

public class ButtonStyleHelper {
    public static final String KEY_BACKGROUND_COLOR = "backgroundColor";
    public static final String KEY_BORDER_COLOR = "borderColor";
    public static final String KEY_BORDER_RADIUS = "borderRadius";
    public static final String KEY_BORDER_STYLE = "borderStyle";
    public static final String KEY_BORDER_WIDTH = "borderWidth";
    public static final int KEY_ON_DISABLE = 2;
    public static final int KEY_ON_NORMAL = 0;
    public static final int KEY_ON_PRESS = 1;
    public static final String KEY_TEXT_COLOR = "color";

    public static void fillButtonPressedAndDisabledStyle(Map<String, Object> map, Map<String, Object> map2) {
        if (map != null && map2 != null) {
            if (map.containsKey("backgroundColor") && !map2.containsKey("backgroundColor")) {
                map2.put("backgroundColor", map.get("backgroundColor"));
            }
            if (map.containsKey("borderWidth") && !map2.containsKey("borderWidth")) {
                map2.put("borderWidth", map.get("borderWidth"));
            }
            if (map.containsKey("borderColor") && !map2.containsKey("borderColor")) {
                map2.put("borderColor", map.get("borderColor"));
            }
            if (map.containsKey("borderRadius") && !map2.containsKey("borderRadius")) {
                map2.put("borderRadius", map.get("borderRadius"));
            }
            if (map.containsKey("borderStyle") && !map2.containsKey("borderStyle")) {
                map2.put("borderStyle", map.get("borderStyle"));
            }
            if (map.containsKey("color") && !map2.containsKey("color")) {
                map2.put("color", map.get("color"));
            }
        }
    }

    public static Drawable pickButtonBackgroundDrawable(Map<String, Object> map) {
        Object obj;
        Object obj2;
        Object convertColor;
        Object obj3;
        Object obj4 = null;
        if (map == null) {
            return null;
        }
        if (map.containsKey("backgroundColor")) {
            obj4 = HummerStyleUtils.convertColor(map.get("backgroundColor"));
        }
        BackgroundDrawable backgroundDrawable = new BackgroundDrawable();
        backgroundDrawable.setColor(obj4);
        if (map.containsKey("borderWidth") && (obj3 = map.get("borderWidth")) != null) {
            backgroundDrawable.setBorderWidth(HummerStyleUtils.convertNumber(obj3));
        }
        if (map.containsKey("borderColor") && (convertColor = HummerStyleUtils.convertColor(map.get("borderColor"))) != null) {
            backgroundDrawable.setBorderColor(((Integer) convertColor).intValue());
        }
        if (map.containsKey("borderRadius") && (obj2 = map.get("borderRadius")) != null) {
            backgroundDrawable.setBorderRadius(HummerStyleUtils.convertNumber(obj2));
        }
        if (map.containsKey("borderStyle") && (obj = map.get("borderStyle")) != null) {
            backgroundDrawable.setBorderStyle((String) obj);
        }
        return backgroundDrawable;
    }

    public static StateListDrawable makeButtonBackgroundColorStateList(Map<Integer, Drawable> map) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (map.containsKey(2)) {
            stateListDrawable.addState(new int[]{-16842910}, map.get(2));
        }
        if (map.containsKey(1)) {
            stateListDrawable.addState(new int[]{16842919}, map.get(1));
        }
        if (map.containsKey(0)) {
            stateListDrawable.addState(new int[0], map.get(0));
        }
        return stateListDrawable;
    }

    public static Integer pickButtonTextColor(Map<String, Object> map) {
        if (map == null || !map.containsKey("color")) {
            return null;
        }
        Object obj = map.get("color");
        if (obj instanceof String) {
            return Integer.valueOf(YogaAttrUtils.parseColor((String) obj));
        }
        return null;
    }

    public static ColorStateList makeButtonTextColorStateList(Map<Integer, Integer> map) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (map.containsKey(2)) {
            arrayList.add(new int[]{-16842910});
            arrayList2.add(map.get(2));
        }
        if (map.containsKey(1)) {
            arrayList.add(new int[]{16842919});
            arrayList2.add(map.get(1));
        }
        if (map.containsKey(0)) {
            arrayList.add(new int[0]);
            arrayList2.add(map.get(0));
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int[][] iArr = new int[arrayList.size()][];
        int[] iArr2 = new int[arrayList2.size()];
        for (int i = 0; i < arrayList2.size(); i++) {
            iArr2[i] = ((Integer) arrayList2.get(i)).intValue();
        }
        return new ColorStateList((int[][]) arrayList.toArray(iArr), iArr2);
    }
}
