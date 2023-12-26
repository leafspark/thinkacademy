package com.didi.hummer.adapter.font.impl;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.didi.hummer.adapter.font.IFontAdapter;
import com.didi.hummer.core.util.HMLog;

public class DefaultFontAdapter implements IFontAdapter {
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    private static final String FONTS_ASSET_PATH = "fonts/";
    private final String fontsAssetsPath;

    public DefaultFontAdapter(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fontsAssetsPath = FONTS_ASSET_PATH;
            return;
        }
        if (!TextUtils.isEmpty(str) && !str.endsWith("/")) {
            str = str + "/";
        }
        this.fontsAssetsPath = str;
    }

    public Typeface loadFont(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = EXTENSIONS[i];
        String[] strArr = FILE_EXTENSIONS;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str3 = strArr[i2];
            try {
                return Typeface.createFromAsset(context.getAssets(), this.fontsAssetsPath + str + str2 + str3);
            } catch (Exception e) {
                HMLog.w("HummerNative", e.getMessage());
                i2++;
            }
        }
        return null;
    }
}
