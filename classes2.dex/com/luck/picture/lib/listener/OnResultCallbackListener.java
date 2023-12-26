package com.luck.picture.lib.listener;

import java.util.List;

public interface OnResultCallbackListener<T> {
    void onCancel();

    void onResult(List<T> list);
}
