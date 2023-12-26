package com.luck.picture.lib.listener;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

public interface OnAlbumItemClickListener {
    void onItemClick(int i, boolean z, long j, String str, List<LocalMedia> list);
}
