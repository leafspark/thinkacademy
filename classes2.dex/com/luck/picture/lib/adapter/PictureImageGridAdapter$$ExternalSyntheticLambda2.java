package com.luck.picture.lib.adapter;

import android.view.View;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.entity.LocalMedia;

public final /* synthetic */ class PictureImageGridAdapter$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ PictureImageGridAdapter f$0;
    public final /* synthetic */ LocalMedia f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ PictureImageGridAdapter.ViewHolder f$4;

    public /* synthetic */ PictureImageGridAdapter$$ExternalSyntheticLambda2(PictureImageGridAdapter pictureImageGridAdapter, LocalMedia localMedia, String str, int i, PictureImageGridAdapter.ViewHolder viewHolder) {
        this.f$0 = pictureImageGridAdapter;
        this.f$1 = localMedia;
        this.f$2 = str;
        this.f$3 = i;
        this.f$4 = viewHolder;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$2$PictureImageGridAdapter(this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
