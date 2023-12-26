package com.tal.app.thinkacademy.lib.util;

import android.app.Application;
import androidx.core.content.FileProvider;

public class UtilsFileProvider extends FileProvider {
    public boolean onCreate() {
        Utils.init((Application) getContext().getApplicationContext());
        return true;
    }
}
