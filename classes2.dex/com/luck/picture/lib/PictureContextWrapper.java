package com.luck.picture.lib;

import android.content.Context;
import android.content.ContextWrapper;
import com.luck.picture.lib.language.PictureLanguageUtils;

public class PictureContextWrapper extends ContextWrapper {
    public PictureContextWrapper(Context context) {
        super(context);
    }

    public static ContextWrapper wrap(Context context, int i) {
        PictureLanguageUtils.setAppLanguage(context, i);
        return new PictureContextWrapper(context);
    }
}
