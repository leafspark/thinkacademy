package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.luck.picture.lib.R;

public class PictureCustomDialog extends Dialog {
    public PictureCustomDialog(Context context, int i) {
        super(context, R.style.Picture_Theme_Dialog);
        setContentView(i);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }
}
