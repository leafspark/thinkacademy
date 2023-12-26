package com.luck.picture.lib.app;

import android.content.Context;
import com.luck.picture.lib.engine.PictureSelectorEngine;

public interface IApp {
    Context getAppContext();

    PictureSelectorEngine getPictureSelectorEngine();
}
