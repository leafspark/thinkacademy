package com.adyen.checkout.components.ui.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.adyen.checkout.components.ui.R;
import com.adyen.checkout.core.exception.NoConstructorException;

public final class ThemeUtil {
    public static int getPrimaryThemeColor(Context context) {
        return getAttributeColor(context, R.attr.colorPrimary);
    }

    private static int getAttributeColor(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{i});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    private ThemeUtil() {
        throw new NoConstructorException();
    }
}
