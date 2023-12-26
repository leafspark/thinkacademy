package com.adyen.checkout.components.api;

import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.adyen.checkout.components.api.LogoConnectionTask;
import com.adyen.checkout.components.status.api.StatusResponseUtils;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\"\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J*\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\tR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/adyen/checkout/components/api/LogoApi;", "", "host", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "(Ljava/lang/String;Landroid/util/DisplayMetrics;)V", "cache", "Landroid/util/LruCache;", "Landroid/graphics/drawable/BitmapDrawable;", "connectionsMap", "", "Lcom/adyen/checkout/components/api/LogoConnectionTask;", "densityExtension", "logoUrlFormat", "buildUrl", "txVariant", "txSubVariant", "size", "Lcom/adyen/checkout/components/api/LogoApi$Size;", "cancelAll", "", "cancelLogoRequest", "clearCache", "getDensityExtension", "densityDpi", "", "getLogo", "callback", "Lcom/adyen/checkout/components/api/LogoConnectionTask$LogoCallback;", "getSizeVariant", "isDifferentHost", "", "hostUrl", "taskFinished", "logoUrl", "logo", "Companion", "Size", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LogoApi.kt */
public final class LogoApi {
    private static final int CACHE_FRACTION_SIZE = 8;
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final Size DEFAULT_SIZE = Size.SMALL;
    public static final int KILO_BYTE_SIZE = 1024;
    private static final String LOGO_PATH = "images/logos/%1$s/%2$s.png";
    private static final int LRU_CACHE_MAX_SIZE;
    private static final String TAG;
    /* access modifiers changed from: private */
    public static LogoApi sInstance;
    private final LruCache<String, BitmapDrawable> cache;
    private final Map<String, LogoConnectionTask> connectionsMap = new HashMap();
    private final String densityExtension;
    private final String logoUrlFormat;

    private final String getDensityExtension(int i) {
        return i <= 120 ? "-ldpi" : i <= 160 ? "" : i <= 240 ? "-hdpi" : i <= 320 ? "-xhdpi" : i <= 480 ? "-xxhdpi" : "-xxxhdpi";
    }

    @JvmStatic
    public static final LogoApi getInstance(Environment environment, DisplayMetrics displayMetrics) {
        return Companion.getInstance(environment, displayMetrics);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/adyen/checkout/components/api/LogoApi$Companion;", "", "()V", "CACHE_FRACTION_SIZE", "", "DEFAULT_SIZE", "Lcom/adyen/checkout/components/api/LogoApi$Size;", "getDEFAULT_SIZE", "()Lcom/adyen/checkout/components/api/LogoApi$Size;", "KILO_BYTE_SIZE", "LOGO_PATH", "", "LRU_CACHE_MAX_SIZE", "TAG", "sInstance", "Lcom/adyen/checkout/components/api/LogoApi;", "getInstance", "environment", "Lcom/adyen/checkout/core/api/Environment;", "displayMetrics", "Landroid/util/DisplayMetrics;", "getMaxCacheSize", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LogoApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Size getDEFAULT_SIZE() {
            return LogoApi.DEFAULT_SIZE;
        }

        @JvmStatic
        public final LogoApi getInstance(Environment environment, DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(environment, "environment");
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            String baseUrl = environment.getBaseUrl();
            Intrinsics.checkNotNullExpressionValue(baseUrl, "environment.baseUrl");
            synchronized (LogoApi.class) {
                LogoApi access$getSInstance$cp = LogoApi.sInstance;
                if (access$getSInstance$cp != null && !access$getSInstance$cp.isDifferentHost(baseUrl)) {
                    return access$getSInstance$cp;
                }
                if (access$getSInstance$cp != null) {
                    access$getSInstance$cp.clearCache();
                }
                LogoApi logoApi = new LogoApi(baseUrl, displayMetrics);
                Companion companion = LogoApi.Companion;
                LogoApi.sInstance = logoApi;
                return logoApi;
            }
        }

        /* access modifiers changed from: private */
        public final int getMaxCacheSize() {
            return ((int) (Runtime.getRuntime().maxMemory() / ((long) 1024))) / 8;
        }
    }

    public LogoApi(String str, DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        this.logoUrlFormat = Intrinsics.stringPlus(str, LOGO_PATH);
        this.densityExtension = getDensityExtension(displayMetrics.densityDpi);
        this.cache = new LogoApi$cache$1(LRU_CACHE_MAX_SIZE);
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        TAG = tag;
        LRU_CACHE_MAX_SIZE = companion.getMaxCacheSize();
    }

    public final void getLogo(String str, String str2, Size size, LogoConnectionTask.LogoCallback logoCallback) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(logoCallback, "callback");
        String str3 = TAG;
        Logger.v(str3, "getLogo - " + str + ", " + str2 + ", " + size);
        String buildUrl = buildUrl(str, str2, size);
        synchronized (this) {
            BitmapDrawable bitmapDrawable = this.cache.get(buildUrl);
            if (bitmapDrawable != null) {
                Logger.v(str3, "returning cached logo");
                logoCallback.onLogoReceived(bitmapDrawable);
                Unit unit = Unit.INSTANCE;
            } else if (!this.connectionsMap.containsKey(buildUrl)) {
                LogoConnectionTask logoConnectionTask = new LogoConnectionTask(this, buildUrl, logoCallback);
                this.connectionsMap.put(buildUrl, logoConnectionTask);
                ThreadManager.EXECUTOR.submit(logoConnectionTask);
            } else {
                LogoConnectionTask logoConnectionTask2 = this.connectionsMap.get(buildUrl);
                if (logoConnectionTask2 != null) {
                    logoConnectionTask2.addCallback(logoCallback);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    public final void cancelLogoRequest(String str, String str2, Size size) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        String str3 = TAG;
        Logger.d(str3, "cancelLogoRequest");
        String buildUrl = buildUrl(str, str2, size);
        synchronized (this) {
            LogoConnectionTask remove = this.connectionsMap.remove(buildUrl);
            if (remove != null) {
                remove.cancel(true);
                Logger.d(str3, StatusResponseUtils.RESULT_CANCELED);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void cancelAll() {
        synchronized (this) {
            for (LogoConnectionTask cancel : this.connectionsMap.values()) {
                cancel.cancel(true);
            }
            this.connectionsMap.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void taskFinished(String str, BitmapDrawable bitmapDrawable) {
        Intrinsics.checkNotNullParameter(str, "logoUrl");
        synchronized (this) {
            this.connectionsMap.remove(str);
            if (bitmapDrawable != null) {
                this.cache.put(str, bitmapDrawable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final String buildUrl(String str, String str2, Size size) {
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            str = str + '/' + str2;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(this.logoUrlFormat, Arrays.copyOf(new Object[]{getSizeVariant(size), Intrinsics.stringPlus(str, this.densityExtension)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final String getSizeVariant(Size size) {
        if (size == null) {
            size = DEFAULT_SIZE;
        }
        return size.toString();
    }

    /* access modifiers changed from: private */
    public final void clearCache() {
        this.cache.evictAll();
    }

    /* access modifiers changed from: private */
    public final boolean isDifferentHost(String str) {
        return !StringsKt.startsWith$default(this.logoUrlFormat, str, false, 2, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/adyen/checkout/components/api/LogoApi$Size;", "", "(Ljava/lang/String;I)V", "toString", "", "SMALL", "MEDIUM", "LARGE", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LogoApi.kt */
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE;

        public String toString() {
            String name = name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            return lowerCase;
        }
    }
}
