package com.didi.hummer.render.event.guesture.common;

import android.content.Context;
import android.view.MotionEvent;
import com.didi.hummer.render.utility.DPUtil;
import java.util.HashMap;
import java.util.Map;

public class GestureUtils {
    public static int findStateInMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            return 1;
        }
        if (action == 1) {
            return 3;
        }
        if (action != 2) {
            return action != 3 ? 0 : 4;
        }
        return 2;
    }

    public static Map<String, Float> findPositionInMotionEvent(Context context, MotionEvent motionEvent) {
        HashMap hashMap = new HashMap();
        if (motionEvent == null) {
            hashMap.put("x", Float.valueOf(0.0f));
            hashMap.put("y", Float.valueOf(0.0f));
            hashMap.put("rawX", Float.valueOf(0.0f));
            hashMap.put("rawY", Float.valueOf(0.0f));
            return hashMap;
        }
        hashMap.put("x", Float.valueOf(DPUtil.px2dpF(context, motionEvent.getX())));
        hashMap.put("y", Float.valueOf(DPUtil.px2dpF(context, motionEvent.getY())));
        hashMap.put("rawX", Float.valueOf(DPUtil.px2dpF(context, motionEvent.getRawX())));
        hashMap.put("rawY", Float.valueOf(DPUtil.px2dpF(context, motionEvent.getRawY())));
        return hashMap;
    }

    public static HashMap<String, Float> findTranslationInMotionEvent(Context context, float f, float f2) {
        HashMap<String, Float> hashMap = new HashMap<>();
        hashMap.put("deltaX", Float.valueOf(DPUtil.px2dpF(context, f)));
        hashMap.put("deltaY", Float.valueOf(DPUtil.px2dpF(context, f2)));
        return hashMap;
    }
}
