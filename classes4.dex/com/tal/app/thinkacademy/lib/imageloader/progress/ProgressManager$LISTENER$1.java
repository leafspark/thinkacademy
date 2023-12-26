package com.tal.app.thinkacademy.lib.imageloader.progress;

import com.tal.app.thinkacademy.lib.imageloader.progress.ProgressResponseBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/lib/imageloader/progress/ProgressManager$LISTENER$1", "Lcom/tal/app/thinkacademy/lib/imageloader/progress/ProgressResponseBody$InternalProgressListener;", "onProgress", "", "url", "", "bytesRead", "", "totalBytes", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProgressManager.kt */
public final class ProgressManager$LISTENER$1 implements ProgressResponseBody.InternalProgressListener {
    ProgressManager$LISTENER$1() {
    }

    public void onProgress(String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "url");
        OnProgressListener progressListener = ProgressManager.INSTANCE.getProgressListener(str);
        if (progressListener != null) {
            int i = (int) (((((float) j) * 1.0f) / ((float) j2)) * 100.0f);
            boolean z = i >= 100;
            progressListener.onProgress(z, i, j, j2);
            if (z) {
                ProgressManager.INSTANCE.removeListener(str);
            }
        }
    }
}
