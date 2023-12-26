package com.tal.app.thinkacademy.common.entity;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/GraffitiFilePoint;", "Lcom/tal/app/thinkacademy/common/entity/DataFilePoint;", "()V", "onFinished", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiFilePoint.kt */
public final class GraffitiFilePoint extends DataFilePoint {
    public void onFinished() {
        super.onFinished();
        ShareDataManager.getInstance().put(Intrinsics.stringPlus(this.fileName, ShareDataKey.ADDITION_DOWNLOAD_GRAFFITI), getMd5(), ShareDataManager.SHAREDATA_CAN_CLEAR);
    }
}
