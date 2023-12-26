package com.coloros.ocs.mediaunit;

import android.content.Context;
import android.os.Looper;
import com.coloros.ocs.base.common.api.Api;
import com.coloros.ocs.base.internal.ClientSettings;

public class MediaClientBuilder extends Api.AbstractClientBuilder {
    public Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj) {
        return new MediaClient(context, looper);
    }
}
