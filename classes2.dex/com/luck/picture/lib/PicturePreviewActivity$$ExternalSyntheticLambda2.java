package com.luck.picture.lib;

import com.luck.picture.lib.listener.OnQueryDataResultListener;
import java.util.List;

public final /* synthetic */ class PicturePreviewActivity$$ExternalSyntheticLambda2 implements OnQueryDataResultListener {
    public final /* synthetic */ PicturePreviewActivity f$0;

    public /* synthetic */ PicturePreviewActivity$$ExternalSyntheticLambda2(PicturePreviewActivity picturePreviewActivity) {
        this.f$0 = picturePreviewActivity;
    }

    public final void onComplete(List list, int i, boolean z) {
        this.f$0.lambda$loadMoreData$2$PicturePreviewActivity(list, i, z);
    }
}
