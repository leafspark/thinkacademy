package com.luck.picture.lib.listener;

import android.content.Context;
import java.util.List;

public interface OnCustomImagePreviewCallback<T> {
    void onCustomPreviewCallback(Context context, List<T> list, int i);
}
