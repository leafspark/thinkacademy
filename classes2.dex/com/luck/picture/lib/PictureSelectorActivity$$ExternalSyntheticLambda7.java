package com.luck.picture.lib;

import com.luck.picture.lib.listener.OnQueryDataResultListener;
import java.util.List;

public final /* synthetic */ class PictureSelectorActivity$$ExternalSyntheticLambda7 implements OnQueryDataResultListener {
    public final /* synthetic */ PictureSelectorActivity f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ PictureSelectorActivity$$ExternalSyntheticLambda7(PictureSelectorActivity pictureSelectorActivity, long j) {
        this.f$0 = pictureSelectorActivity;
        this.f$1 = j;
    }

    public final void onComplete(List list, int i, boolean z) {
        this.f$0.lambda$loadMoreData$1$PictureSelectorActivity(this.f$1, list, i, z);
    }
}
