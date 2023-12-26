package com.tal.app.thinkacademy.common.business.cloudcontrol;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.ApiUrl;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.business.cloudcontrol.api.CloudApi;
import com.tal.app.thinkacademy.common.business.cloudcontrol.api.CloudBody;
import com.tal.app.thinkacademy.common.business.cloudcontrol.api.CloudData;
import com.tal.app.thinkacademy.common.business.cloudcontrol.api.CloudItem;
import com.tal.app.thinkacademy.common.entity.ParentAuditCloudData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J,\u0010\u000e\u001a\u00020\n2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0002J&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0006J8\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00062&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J8\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192(\u0010\u001a\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b0\u001bJ\u0006\u0010\u001c\u001a\u00020\nJ0\u0010\u001d\u001a\u00020\n2&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002R0\u0010\u0003\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/cloudcontrol/HwCloudControlHelper;", "", "()V", "liveData", "Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "Ljava/util/HashMap;", "", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudItem;", "Lkotlin/collections/HashMap;", "dealResult", "", "response", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudData;", "dispatchData", "data", "getCloudData", "getCloudKeyData", "key", "getCloudKeyValue", "map", "getParentAuditParam", "Lcom/tal/app/thinkacademy/common/entity/ParentAuditCloudData;", "observeSyncCloud", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "syncCloud", "updateH5WhiteList", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwCloudControlHelper.kt */
public final class HwCloudControlHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<HwCloudControlHelper> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, HwCloudControlHelper$Companion$INSTANCE$2.INSTANCE);
    private static final String TAG = "HwCloudControlHelper";
    private final StickyLiveData<HashMap<String, CloudItem>> liveData;

    public /* synthetic */ HwCloudControlHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final HwCloudControlHelper get() {
        return Companion.get();
    }

    private HwCloudControlHelper() {
        this.liveData = new StickyLiveData<>();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/cloudcontrol/HwCloudControlHelper$Companion;", "", "()V", "INSTANCE", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/HwCloudControlHelper;", "getINSTANCE", "()Lcom/tal/app/thinkacademy/common/business/cloudcontrol/HwCloudControlHelper;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "kotlin.jvm.PlatformType", "get", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwCloudControlHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final HwCloudControlHelper getINSTANCE() {
            return (HwCloudControlHelper) HwCloudControlHelper.INSTANCE$delegate.getValue();
        }

        @JvmStatic
        public final HwCloudControlHelper get() {
            return getINSTANCE();
        }
    }

    public final void syncCloud() {
        XesLog.it(TAG, "syncCloud");
        String uniqueDeviceId = DeviceUtils.getUniqueDeviceId();
        Intrinsics.checkNotNullExpressionValue(uniqueDeviceId, "getUniqueDeviceId()");
        Call<HiResponse<CloudData>> syncCloudData = ((CloudApi) Api.create(ApiUrl.INSTANCE.getBASE_URL(), CloudApi.class)).syncCloudData(new CloudBody(CloudControlConstants.CLOUD_APP_CODE, uniqueDeviceId));
        Callback hwCloudControlHelper$syncCloud$1 = new HwCloudControlHelper$syncCloud$1(this);
        if (!(syncCloudData instanceof Call)) {
            syncCloudData.enqueue(hwCloudControlHelper$syncCloud$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) syncCloudData, hwCloudControlHelper$syncCloud$1);
        }
    }

    /* access modifiers changed from: private */
    public final void dealResult(HiResponse<CloudData> hiResponse) {
        XesLog.it(TAG, "syncCloud success");
        CloudData data = hiResponse.getData();
        if (data != null) {
            Collection configs = data.getConfigs();
            if (!(configs == null || configs.isEmpty())) {
                try {
                    HashMap hashMap = new HashMap();
                    for (CloudItem next : data.getConfigs()) {
                        String configKey = next.getConfigKey();
                        if (configKey != null) {
                            CloudItem cloudItem = (CloudItem) hashMap.put(configKey, next);
                        }
                    }
                    String json = GsonUtils.toJson(hashMap);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(map)");
                    XesLog.it(TAG, Intrinsics.stringPlus("云控 config json =", json));
                    dispatchData(hashMap);
                    ShareDataManager.getInstance().put(CloudControlConstants.HW_CLOUD_CACHE_KEY, json, ShareDataManager.SHAREDATA_NOT_CLEAR);
                } catch (Exception e) {
                    XesLog.et(TAG, "syncCloud 云控数据处理异常", e);
                }
            }
        }
    }

    private final void dispatchData(HashMap<String, CloudItem> hashMap) {
        this.liveData.postStickyData(hashMap);
        updateH5WhiteList(hashMap);
    }

    public final HashMap<String, CloudItem> getCloudData() {
        String string = ShareDataManager.getInstance().getString(CloudControlConstants.HW_CLOUD_CACHE_KEY, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        XesLog.it(TAG, Intrinsics.stringPlus("getCloudData: ", string));
        try {
            return (HashMap) GsonUtils.fromJson(string, new HwCloudControlHelper$getCloudData$1().getType());
        } catch (Exception e) {
            XesLog.it(TAG, Intrinsics.stringPlus("getCloudData error :", e.getMessage()));
            return null;
        }
    }

    public final CloudItem getCloudKeyData(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, CloudItem> cloudData = getCloudData();
        if (cloudData == null) {
            return null;
        }
        try {
            CloudItem cloudItem = cloudData.get(str);
            String str2 = TAG;
            XesLog.it(str2, "getCloudKeyData " + str + ' ' + GsonUtils.toJson(cloudItem));
            return cloudItem;
        } catch (Exception e) {
            XesLog.it(TAG, Intrinsics.stringPlus("getCloudKeyData error :", e.getMessage()));
            return null;
        }
    }

    public final String getCloudKeyValue(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "key");
        CloudItem cloudKeyData = getCloudKeyData(str);
        if (cloudKeyData == null) {
            str2 = null;
        } else if (Intrinsics.areEqual(cloudKeyData.getConfigGrayHit(), true)) {
            str2 = cloudKeyData.getConfigValue();
        } else {
            str2 = cloudKeyData.getConfigDefaultValue();
        }
        XesLog.it(TAG, Intrinsics.stringPlus("getCloudKeyValue : ", str2));
        return str2;
    }

    public final void observeSyncCloud(LifecycleOwner lifecycleOwner, Observer<HashMap<String, CloudItem>> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.liveData.observerSticky(lifecycleOwner, false, observer);
    }

    public final ParentAuditCloudData getParentAuditParam() {
        String cloudKeyValue = getCloudKeyValue("isOpenParentsAttend");
        Object obj = null;
        if (cloudKeyValue != null) {
            try {
                obj = GsonUtils.fromJson(cloudKeyValue, ParentAuditCloudData.class);
            } catch (Exception unused) {
            }
        }
        return (ParentAuditCloudData) obj;
    }

    public final String getCloudKeyValue(String str, HashMap<String, CloudItem> hashMap) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "key");
        String str3 = null;
        CloudItem cloudItem = hashMap == null ? null : hashMap.get(str);
        if (cloudItem != null) {
            if (Intrinsics.areEqual(cloudItem.getConfigGrayHit(), true)) {
                str2 = cloudItem.getConfigValue();
            } else {
                str2 = cloudItem.getConfigDefaultValue();
            }
            str3 = str2;
        }
        XesLog.it(TAG, Intrinsics.stringPlus("getCloudKeyValue : ", str3));
        return str3;
    }

    private final void updateH5WhiteList(HashMap<String, CloudItem> hashMap) {
        XesWebViewCookieUtils.updateWhiteList(getCloudKeyValue("h5_host_white_list", hashMap));
    }
}
