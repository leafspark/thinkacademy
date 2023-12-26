package com.coloros.ocs.mediaunit;

import android.content.Context;
import android.os.Looper;
import com.coloros.ocs.base.common.api.BaseClient;
import com.coloros.ocs.base.common.constant.CapabilityConstants;

public class MediaClient extends BaseClient {
    public String getClientName() {
        return CapabilityConstants.MEDIA_CLIENT;
    }

    public boolean requiresColorService() {
        return false;
    }

    protected MediaClient(Context context, Looper looper) {
        super(context, looper);
    }
}
