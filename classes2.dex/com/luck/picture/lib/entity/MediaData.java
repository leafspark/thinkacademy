package com.luck.picture.lib.entity;

import java.util.List;

public class MediaData {
    public List<LocalMedia> data;
    public boolean isHasNextMore;

    public MediaData() {
    }

    public MediaData(boolean z, List<LocalMedia> list) {
        this.isHasNextMore = z;
        this.data = list;
    }
}
