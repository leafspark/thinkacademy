package com.luck.picture.lib.camera.listener;

import android.widget.ImageView;
import java.io.File;

public interface ImageCallbackListener {
    void onLoadImage(File file, ImageView imageView);
}
