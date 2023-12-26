package com.luck.picture.lib.listener;

import java.util.List;

public interface OnQueryDataResultListener<T> {
    void onComplete(List<T> list, int i, boolean z);
}
