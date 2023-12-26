package com.luck.picture.lib.adapter;

import android.view.View;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.entity.LocalMedia;

public final /* synthetic */ class PictureImageGridAdapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ PictureImageGridAdapter f$0;
    public final /* synthetic */ LocalMedia f$1;
    public final /* synthetic */ PictureImageGridAdapter.ViewHolder f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ PictureImageGridAdapter$$ExternalSyntheticLambda1(PictureImageGridAdapter pictureImageGridAdapter, LocalMedia localMedia, PictureImageGridAdapter.ViewHolder viewHolder, String str) {
        this.f$0 = pictureImageGridAdapter;
        this.f$1 = localMedia;
        this.f$2 = viewHolder;
        this.f$3 = str;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$1$PictureImageGridAdapter(this.f$1, this.f$2, this.f$3, view);
    }
}
