package com.coloros.ocs.mediaunit;

import android.content.Context;

public class MediaUnit {
    public static MediaUnitClient getMediaClient(Context context) {
        return MediaUnitClient.initialize(context);
    }
}
