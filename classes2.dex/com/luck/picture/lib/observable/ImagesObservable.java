package com.luck.picture.lib.observable;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;

public class ImagesObservable {
    private static final ImagesObservable mInstance = new ImagesObservable();
    private List<LocalMedia> mData = new ArrayList();

    public static ImagesObservable getInstance() {
        return mInstance;
    }

    public void saveData(List<LocalMedia> list) {
        this.mData = list;
    }

    public List<LocalMedia> getData() {
        return this.mData;
    }

    public void clearData() {
        this.mData.clear();
    }
}
