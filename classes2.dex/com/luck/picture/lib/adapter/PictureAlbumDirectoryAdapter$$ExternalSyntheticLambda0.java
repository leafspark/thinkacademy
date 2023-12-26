package com.luck.picture.lib.adapter;

import android.view.View;
import com.luck.picture.lib.entity.LocalMediaFolder;

public final /* synthetic */ class PictureAlbumDirectoryAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ PictureAlbumDirectoryAdapter f$0;
    public final /* synthetic */ LocalMediaFolder f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ PictureAlbumDirectoryAdapter$$ExternalSyntheticLambda0(PictureAlbumDirectoryAdapter pictureAlbumDirectoryAdapter, LocalMediaFolder localMediaFolder, int i) {
        this.f$0 = pictureAlbumDirectoryAdapter;
        this.f$1 = localMediaFolder;
        this.f$2 = i;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$0$PictureAlbumDirectoryAdapter(this.f$1, this.f$2, view);
    }
}
