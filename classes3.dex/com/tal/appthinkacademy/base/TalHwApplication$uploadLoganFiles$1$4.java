package com.tal.appthinkacademy.base;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.MultiTransfer;
import java.io.File;
import java.util.ArrayList;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/tal/appthinkacademy/base/TalHwApplication$uploadLoganFiles$1$4", "Lcom/tal/app/thinkacademy/common/aws/MultiTransfer;", "onStateChanged", "", "currentIndex", "", "id", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalHwApplication.kt */
public final class TalHwApplication$uploadLoganFiles$1$4 extends MultiTransfer {
    final /* synthetic */ ArrayList<File> $files;

    TalHwApplication$uploadLoganFiles$1$4(ArrayList<File> arrayList) {
        this.$files = arrayList;
    }

    public void onStateChanged(int i, int i2, TransferState transferState) {
        if (transferState == TransferState.COMPLETED) {
            long j = (long) 86400000;
            long currentTimeMillis = ((System.currentTimeMillis() / j) * j) - ((long) TimeZone.getDefault().getRawOffset());
            String name = this.$files.get(i).getName();
            Intrinsics.checkNotNullExpressionValue(name, "files[currentIndex].name");
            if (currentTimeMillis != Long.parseLong(name)) {
                this.$files.get(i).delete();
            }
        }
    }
}
