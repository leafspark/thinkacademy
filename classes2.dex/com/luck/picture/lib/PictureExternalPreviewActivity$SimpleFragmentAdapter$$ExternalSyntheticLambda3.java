package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.entity.LocalMedia;

public final /* synthetic */ class PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda3 implements View.OnLongClickListener {
    public final /* synthetic */ PictureExternalPreviewActivity.SimpleFragmentAdapter f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ LocalMedia f$2;

    public /* synthetic */ PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda3(PictureExternalPreviewActivity.SimpleFragmentAdapter simpleFragmentAdapter, String str, LocalMedia localMedia) {
        this.f$0 = simpleFragmentAdapter;
        this.f$1 = str;
        this.f$2 = localMedia;
    }

    public final boolean onLongClick(View view) {
        return this.f$0.lambda$instantiateItem$3$PictureExternalPreviewActivity$SimpleFragmentAdapter(this.f$1, this.f$2, view);
    }
}
