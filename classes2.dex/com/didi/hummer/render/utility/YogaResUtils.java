package com.didi.hummer.render.utility;

import android.graphics.drawable.Drawable;
import com.didi.hummer.HummerSDK;

public class YogaResUtils {
    public static int getResourceId(String str, String str2, String str3) throws RuntimeException {
        if (str3 == null) {
            try {
                str3 = HummerSDK.appContext.getPackageName();
            } catch (Exception e) {
                throw new RuntimeException("Error getResourceId by NJContextUtil.getContext()", e);
            }
        }
        return HummerSDK.appContext.getResources().getIdentifier(str, str2, str3);
    }

    public static Drawable getResourcesDrawable(String str, String str2, String str3) {
        int resourceId = getResourceId(str, str2, str3);
        if (resourceId <= 0) {
            return null;
        }
        return HummerSDK.appContext.getResources().getDrawable(resourceId);
    }
}
