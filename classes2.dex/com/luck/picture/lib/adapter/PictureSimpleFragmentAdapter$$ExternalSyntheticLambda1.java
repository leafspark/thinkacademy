package com.luck.picture.lib.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.luck.picture.lib.entity.LocalMedia;

public final /* synthetic */ class PictureSimpleFragmentAdapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ LocalMedia f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ ViewGroup f$2;

    public /* synthetic */ PictureSimpleFragmentAdapter$$ExternalSyntheticLambda1(LocalMedia localMedia, String str, ViewGroup viewGroup) {
        this.f$0 = localMedia;
        this.f$1 = str;
        this.f$2 = viewGroup;
    }

    public final void onClick(View view) {
        PictureSimpleFragmentAdapter.lambda$instantiateItem$0(this.f$0, this.f$1, this.f$2, view);
    }
}
