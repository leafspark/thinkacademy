package com.luck.picture.lib.listener;

import java.util.List;

public interface OnPhotoSelectChangedListener<T> {
    void onChange(List<T> list);

    void onPictureClick(T t, int i);

    void onTakePhoto();
}
