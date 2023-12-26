package com.tal.app.thinkacademy.common;

import com.tal.app.thinkacademy.common.imconfig.HostUrlsInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.network.BaseUrlEx;
import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import com.tal.app.thinkacademy.lib.util.ArrayUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/common/ApiUrl;", "Lcom/tal/app/thinkacademy/common/network/BaseUrlEx;", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "BASE_URL$delegate", "Lkotlin/Lazy;", "BASE_URL_ALPHA", "BASE_URL_BETA", "BASE_URL_DEV", "BASE_URL_PRE", "BASE_URL_PRO", "BASE_URL_PRO_BAK", "CONFIG_BASE_URL", "getCONFIG_BASE_URL", "CONFIG_BASE_URL$delegate", "mBakBaseUrlListBeta", "", "getMBakBaseUrlListBeta", "()Ljava/util/List;", "mBakBaseUrlListPro", "getMBakBaseUrlListPro", "configReload", "reload", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApiUrl.kt */
public final class ApiUrl extends BaseUrlEx {
    private static final Lazy BASE_URL$delegate = LazyKt.lazy(ApiUrl$BASE_URL$2.INSTANCE);
    private static final String BASE_URL_ALPHA = "https://one-alpha.thethinkacademy.com/";
    private static final String BASE_URL_BETA = "https://beta-one.thethinkacademy.com/";
    private static final String BASE_URL_DEV = "https://one-dev.thethinkacademy.com/";
    private static final String BASE_URL_PRE = "https://one-pre.thethinkacademy.com/";
    private static final String BASE_URL_PRO = "https://one.thethinkacademy.com/";
    private static final String BASE_URL_PRO_BAK = "https://one.talthinktech.com/";
    private static final Lazy CONFIG_BASE_URL$delegate = LazyKt.lazy(ApiUrl$CONFIG_BASE_URL$2.INSTANCE);
    public static final ApiUrl INSTANCE = new ApiUrl();
    private static final List<String> mBakBaseUrlListBeta = CollectionsKt.mutableListOf(new String[]{"https://beta-one.thethinkacademy.com", "https://beta-one.thethinkacademy.com"});
    private static final List<String> mBakBaseUrlListPro = CollectionsKt.mutableListOf(new String[]{"https://one-akamai.thethinkacademy.com/", BASE_URL_PRO_BAK});

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ApiUrl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ENVIRONMENTAL.values().length];
            iArr[ENVIRONMENTAL.DEVELOP.ordinal()] = 1;
            iArr[ENVIRONMENTAL.ALPHA.ordinal()] = 2;
            iArr[ENVIRONMENTAL.TEST.ordinal()] = 3;
            iArr[ENVIRONMENTAL.PRE.ordinal()] = 4;
            iArr[ENVIRONMENTAL.ONLINE.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ApiUrl() {
    }

    public final List<String> getMBakBaseUrlListPro() {
        return mBakBaseUrlListPro;
    }

    public final List<String> getMBakBaseUrlListBeta() {
        return mBakBaseUrlListBeta;
    }

    public final String getBASE_URL() {
        return (String) BASE_URL$delegate.getValue();
    }

    public final String getCONFIG_BASE_URL() {
        return (String) CONFIG_BASE_URL$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String reload() {
        int i = WhenMappings.$EnumSwitchMapping$0[BaseUrlEx.Companion.getEnvironment().ordinal()];
        String[] strArr = null;
        if (i == 1) {
            if (ImConfig.INSTANCE.getHostUrls() != null) {
                HostUrlsInfo hostUrls = ImConfig.INSTANCE.getHostUrls();
                if (hostUrls != null) {
                    strArr = hostUrls.getOneHost();
                }
                boolean isEmpty = ArrayUtils.isEmpty(strArr);
            }
            return BASE_URL_DEV;
        } else if (i != 2) {
            if (i == 3) {
                if (ImConfig.INSTANCE.getHostUrls() != null) {
                    HostUrlsInfo hostUrls2 = ImConfig.INSTANCE.getHostUrls();
                    if (hostUrls2 != null) {
                        strArr = hostUrls2.getOneHost();
                    }
                    if (!ArrayUtils.isEmpty(strArr)) {
                        HostUrlsInfo hostUrls3 = ImConfig.INSTANCE.getHostUrls();
                        Intrinsics.checkNotNull(hostUrls3);
                        String[] oneHost = hostUrls3.getOneHost();
                        Intrinsics.checkNotNull(oneHost);
                        return Intrinsics.stringPlus(oneHost[0], "/");
                    }
                }
                return BASE_URL_BETA;
            } else if (i == 4) {
                if (ImConfig.INSTANCE.getHostUrls() != null) {
                    HostUrlsInfo hostUrls4 = ImConfig.INSTANCE.getHostUrls();
                    if (hostUrls4 != null) {
                        strArr = hostUrls4.getOneHost();
                    }
                    if (!ArrayUtils.isEmpty(strArr)) {
                        HostUrlsInfo hostUrls5 = ImConfig.INSTANCE.getHostUrls();
                        Intrinsics.checkNotNull(hostUrls5);
                        String[] oneHost2 = hostUrls5.getOneHost();
                        Intrinsics.checkNotNull(oneHost2);
                        return Intrinsics.stringPlus(oneHost2[0], "/");
                    }
                }
                return BASE_URL_PRE;
            } else if (i == 5) {
                if (ImConfig.INSTANCE.getHostUrls() != null) {
                    HostUrlsInfo hostUrls6 = ImConfig.INSTANCE.getHostUrls();
                    if (hostUrls6 != null) {
                        strArr = hostUrls6.getOneHost();
                    }
                    if (!ArrayUtils.isEmpty(strArr)) {
                        HostUrlsInfo hostUrls7 = ImConfig.INSTANCE.getHostUrls();
                        Intrinsics.checkNotNull(hostUrls7);
                        String[] oneHost3 = hostUrls7.getOneHost();
                        Intrinsics.checkNotNull(oneHost3);
                        return Intrinsics.stringPlus(oneHost3[0], "/");
                    }
                }
                return BASE_URL_PRO;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (ImConfig.INSTANCE.getHostUrls() == null) {
            return BASE_URL_ALPHA;
        } else {
            HostUrlsInfo hostUrls8 = ImConfig.INSTANCE.getHostUrls();
            if (hostUrls8 != null) {
                strArr = hostUrls8.getOneHost();
            }
            boolean isEmpty2 = ArrayUtils.isEmpty(strArr);
            return BASE_URL_ALPHA;
        }
    }

    /* access modifiers changed from: private */
    public final String configReload() {
        int i = WhenMappings.$EnumSwitchMapping$0[BaseUrlEx.Companion.getEnvironment().ordinal()];
        if (i == 1) {
            return BASE_URL_DEV;
        }
        if (i == 2) {
            return BASE_URL_ALPHA;
        }
        if (i == 3) {
            return BASE_URL_BETA;
        }
        if (i == 4) {
            return BASE_URL_PRE;
        }
        if (i == 5) {
            return BASE_URL_PRO;
        }
        throw new NoWhenBranchMatchedException();
    }
}
