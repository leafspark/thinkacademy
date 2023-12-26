package com.didi.hummer.component.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.SparseArray;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.font.IFontAdapter;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.util.HMLog;
import java.util.HashMap;
import java.util.Map;

public class FontManager {
    public static final String DEFAULT_FONT_FAMILY = "DEFAULT_FONT_FAMILY";
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    private static final String FONTS_ASSET_PATH = "fonts/";
    private static FontManager instance;
    private Map<String, FontFamily> mFontCache = new HashMap();

    private FontManager() {
    }

    public static FontManager getInstance() {
        if (instance == null) {
            instance = new FontManager();
        }
        return instance;
    }

    public Typeface getTypeface(HummerContext hummerContext, String str, int i) {
        FontFamily fontFamily = this.mFontCache.get(str);
        if (fontFamily == null) {
            fontFamily = new FontFamily();
            this.mFontCache.put(str, fontFamily);
        }
        Typeface typeface = fontFamily.getTypeface(i);
        if (typeface == null) {
            IFontAdapter fontAdapter = HummerSDK.getHummerConfig(hummerContext.getNamespace()).getFontAdapter();
            Context applicationContext = hummerContext.getApplicationContext();
            if (DEFAULT_FONT_FAMILY.equals(str)) {
                str = null;
            }
            typeface = fontAdapter.loadFont(applicationContext, str, i);
            if (typeface != null) {
                fontFamily.setTypeface(i, typeface);
            }
        }
        return typeface;
    }

    @Deprecated
    public Typeface getTypeface(String str, int i, AssetManager assetManager) {
        return getTypeface(str, FONTS_ASSET_PATH, i, assetManager);
    }

    @Deprecated
    public Typeface getTypeface(String str, String str2, int i, AssetManager assetManager) {
        FontFamily fontFamily = this.mFontCache.get(str);
        if (fontFamily == null) {
            fontFamily = new FontFamily();
            this.mFontCache.put(str, fontFamily);
        }
        Typeface typeface = fontFamily.getTypeface(i);
        if (typeface == null && (typeface = createTypeface(str, str2, i, assetManager)) != null) {
            fontFamily.setTypeface(i, typeface);
        }
        return typeface;
    }

    public void setTypeface(String str, int i, Typeface typeface) {
        if (typeface != null) {
            FontFamily fontFamily = this.mFontCache.get(str);
            if (fontFamily == null) {
                fontFamily = new FontFamily();
                this.mFontCache.put(str, fontFamily);
            }
            fontFamily.setTypeface(i, typeface);
        }
    }

    private static Typeface createTypeface(String str, String str2, int i, AssetManager assetManager) {
        if (str2 == null) {
            str2 = FONTS_ASSET_PATH;
        } else if (!TextUtils.isEmpty(str2) && !str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        String str3 = EXTENSIONS[i];
        String[] strArr = FILE_EXTENSIONS;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                return Typeface.createFromAsset(assetManager, str2 + str + str3 + strArr[i2]);
            } catch (Exception e) {
                HMLog.w("HummerNative", e.getMessage());
                i2++;
            }
        }
        return null;
    }

    private static class FontFamily {
        private SparseArray<Typeface> mTypefaceSparseArray;

        private FontFamily() {
            this.mTypefaceSparseArray = new SparseArray<>(4);
        }

        public Typeface getTypeface(int i) {
            return this.mTypefaceSparseArray.get(i);
        }

        public void setTypeface(int i, Typeface typeface) {
            this.mTypefaceSparseArray.put(i, typeface);
        }
    }
}
