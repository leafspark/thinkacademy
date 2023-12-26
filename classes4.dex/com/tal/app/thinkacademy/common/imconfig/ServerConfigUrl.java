package com.tal.app.thinkacademy.common.imconfig;

import com.tal.app.thinkacademy.common.network.BaseUrlEx;
import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import com.tal.app.thinkacademy.lib.util.ArrayUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ServerConfigUrl;", "", "()V", "BASEURL_ALPHA", "", "BASEURL_DEV", "BASEURL_ONLINE", "BASEURL_PRE", "BASEURL_TEST", "BASE_URL", "getBASE_URL", "()Ljava/lang/String;", "BASE_URL$delegate", "Lkotlin/Lazy;", "CONFIG_BASE_URL", "getCONFIG_BASE_URL", "CONFIG_BASE_URL$delegate", "configReload", "reload", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ServerConfigUrl.kt */
public final class ServerConfigUrl {
    private static final String BASEURL_ALPHA = "https://oversea-api-alpha.thethinkacademy.com/";
    private static final String BASEURL_DEV = "https://oversea-api-dev.thethinkacademy.com/";
    private static final String BASEURL_ONLINE = "https://oversea-api.thethinkacademy.com/";
    private static final String BASEURL_PRE = "https://oversea-api-pre.thethinkacademy.com/";
    private static final String BASEURL_TEST = "https://oversea-api-beta.thethinkacademy.com/";
    private static final Lazy BASE_URL$delegate = LazyKt.lazy(ServerConfigUrl$BASE_URL$2.INSTANCE);
    private static final Lazy CONFIG_BASE_URL$delegate = LazyKt.lazy(ServerConfigUrl$CONFIG_BASE_URL$2.INSTANCE);
    public static final ServerConfigUrl INSTANCE = new ServerConfigUrl();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ServerConfigUrl.kt */
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

    private ServerConfigUrl() {
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
        if (i == 1) {
            if (ImConfig.INSTANCE.getHostUrls() != null) {
                HostUrlsInfo hostUrls = ImConfig.INSTANCE.getHostUrls();
                Intrinsics.checkNotNull(hostUrls);
                boolean isEmpty = ArrayUtils.isEmpty(hostUrls.getOverseaApiHost());
            }
            return BASEURL_DEV;
        } else if (i != 2) {
            if (i == 3) {
                if (ImConfig.INSTANCE.getHostUrls() != null) {
                    HostUrlsInfo hostUrls2 = ImConfig.INSTANCE.getHostUrls();
                    Intrinsics.checkNotNull(hostUrls2);
                    if (!ArrayUtils.isEmpty(hostUrls2.getOverseaApiHost())) {
                        HostUrlsInfo hostUrls3 = ImConfig.INSTANCE.getHostUrls();
                        Intrinsics.checkNotNull(hostUrls3);
                        String[] overseaApiHost = hostUrls3.getOverseaApiHost();
                        Intrinsics.checkNotNull(overseaApiHost);
                        return Intrinsics.stringPlus(overseaApiHost[0], "/");
                    }
                }
                return BASEURL_TEST;
            } else if (i == 4) {
                if (ImConfig.INSTANCE.getHostUrls() != null) {
                    HostUrlsInfo hostUrls4 = ImConfig.INSTANCE.getHostUrls();
                    Intrinsics.checkNotNull(hostUrls4);
                    if (!ArrayUtils.isEmpty(hostUrls4.getOverseaApiHost())) {
                        HostUrlsInfo hostUrls5 = ImConfig.INSTANCE.getHostUrls();
                        Intrinsics.checkNotNull(hostUrls5);
                        String[] overseaApiHost2 = hostUrls5.getOverseaApiHost();
                        Intrinsics.checkNotNull(overseaApiHost2);
                        return Intrinsics.stringPlus(overseaApiHost2[0], "/");
                    }
                }
                return BASEURL_PRE;
            } else if (i == 5) {
                if (ImConfig.INSTANCE.getHostUrls() != null) {
                    HostUrlsInfo hostUrls6 = ImConfig.INSTANCE.getHostUrls();
                    Intrinsics.checkNotNull(hostUrls6);
                    if (!ArrayUtils.isEmpty(hostUrls6.getOverseaApiHost())) {
                        HostUrlsInfo hostUrls7 = ImConfig.INSTANCE.getHostUrls();
                        Intrinsics.checkNotNull(hostUrls7);
                        String[] overseaApiHost3 = hostUrls7.getOverseaApiHost();
                        Intrinsics.checkNotNull(overseaApiHost3);
                        return Intrinsics.stringPlus(overseaApiHost3[0], "/");
                    }
                }
                return BASEURL_ONLINE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (ImConfig.INSTANCE.getHostUrls() == null) {
            return BASEURL_ALPHA;
        } else {
            HostUrlsInfo hostUrls8 = ImConfig.INSTANCE.getHostUrls();
            Intrinsics.checkNotNull(hostUrls8);
            boolean isEmpty2 = ArrayUtils.isEmpty(hostUrls8.getOverseaApiHost());
            return BASEURL_ALPHA;
        }
    }

    /* access modifiers changed from: private */
    public final String configReload() {
        int i = WhenMappings.$EnumSwitchMapping$0[BaseUrlEx.Companion.getEnvironment().ordinal()];
        if (i == 1) {
            return BASEURL_DEV;
        }
        if (i == 2) {
            return BASEURL_ALPHA;
        }
        if (i == 3) {
            return BASEURL_TEST;
        }
        if (i == 4) {
            return BASEURL_PRE;
        }
        if (i == 5) {
            return BASEURL_ONLINE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
