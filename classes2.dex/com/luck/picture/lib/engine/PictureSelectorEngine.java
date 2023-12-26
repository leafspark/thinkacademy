package com.luck.picture.lib.engine;

import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;

public interface PictureSelectorEngine {
    ImageEngine createEngine();

    OnResultCallbackListener<LocalMedia> getResultCallbackListener();
}
