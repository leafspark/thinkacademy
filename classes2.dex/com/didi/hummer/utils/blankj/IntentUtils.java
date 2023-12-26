package com.didi.hummer.utils.blankj;

import android.content.Intent;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.didi.hummer.HummerSDK;

public final class IntentUtils {
    private IntentUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isIntentAvailable(Intent intent) {
        return HummerSDK.appContext.getPackageManager().queryIntentActivities(intent, ArrayPool.STANDARD_BUFFER_SIZE_BYTES).size() > 0;
    }
}
