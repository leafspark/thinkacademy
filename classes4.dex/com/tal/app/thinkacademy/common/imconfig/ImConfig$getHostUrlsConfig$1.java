package com.tal.app.thinkacademy.common.imconfig;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/imconfig/ImConfig$getHostUrlsConfig$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/imconfig/HostUrlsInfo;", "onSuccess", "", "response", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImConfig.kt */
public final class ImConfig$getHostUrlsConfig$1 extends OmyCallback<HiResponse<HostUrlsInfo>> {
    ImConfig$getHostUrlsConfig$1(ImConfig$getHostUrlsConfig$2 imConfig$getHostUrlsConfig$2) {
        super(imConfig$getHostUrlsConfig$2);
    }

    public void onSuccess(HiResponse<HostUrlsInfo> hiResponse) {
        String str;
        String[] overseaApiHost;
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        ImConfig.INSTANCE.getMRetryCount().set(0);
        HostUrlsInfo data = hiResponse.getData();
        HwNetProbe.Companion.get().checkNetInfo(data);
        ShareDataManager.getInstance().saveCacheGsonEntity(data, ShareDataKey.CONFIG_HOST_URLS, ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager instance = ShareDataManager.getInstance();
        String str2 = null;
        if (data == null || (overseaApiHost = data.getOverseaApiHost()) == null) {
            str = null;
        } else {
            str = overseaApiHost[0];
        }
        instance.put(ShareDataKey.OVERSEA_API, str, ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager instance2 = ShareDataManager.getInstance();
        if (data != null) {
            str2 = data.getH5Domain();
        }
        instance2.put(ShareDataKey.H5_DOMAIN, str2, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }
}
