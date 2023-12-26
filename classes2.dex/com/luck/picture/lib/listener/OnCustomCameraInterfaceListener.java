package com.luck.picture.lib.listener;

import android.content.Context;
import com.luck.picture.lib.config.PictureSelectionConfig;

public interface OnCustomCameraInterfaceListener {
    void onCameraClick(Context context, PictureSelectionConfig pictureSelectionConfig, int i);
}
