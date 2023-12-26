package com.tal.app.thinkacademy.common.entity;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/CourseFilePoint;", "Lcom/tal/app/thinkacademy/common/entity/DataFilePoint;", "()V", "onFailed", "", "code", "", "message", "", "progress", "errorInfo", "onFinished", "onProgress", "soFarBytes", "", "totalBytes", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CourseFilePoint.kt */
public final class CourseFilePoint extends DataFilePoint {
    public void onProgress(long j, long j2) {
        super.onProgress(j, j2);
        ShareDataManager.getInstance().put(Intrinsics.stringPlus("courseware_download_size_", getRealFileName()), j, ShareDataManager.SHAREDATA_CAN_CLEAR);
    }

    public void onFailed(int i, String str, String str2, String str3) {
        super.onFailed(i, str, str2, str3);
        ShareDataManager.getInstance().put(Intrinsics.stringPlus("courseware_download_size_", getRealFileName()), 0, ShareDataManager.SHAREDATA_CAN_CLEAR);
    }

    public void onFinished() {
        super.onFinished();
        ShareDataManager.getInstance().put(Intrinsics.stringPlus("courseware_download_size_", getRealFileName()), -1, ShareDataManager.SHAREDATA_CAN_CLEAR);
        ShareDataManager.getInstance().put(Intrinsics.stringPlus(getRealFileName(), ShareDataKey.ADDITION_DOWNLOAD_COURSEWARE), getMd5(), ShareDataManager.SHAREDATA_CAN_CLEAR);
    }
}
