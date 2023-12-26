package com.tal.user.global.trade.api;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.config.TalTradeCheckoutConfig;
import com.tal.user.global.trade.config.TalTradeSdkConfig;
import com.tal.user.global.trade.exception.TalTradeInitException;
import com.tal.user.global.trade.listener.TalTradeLogListener;
import com.tal.user.global.trade.ums.Producer;
import com.tal.user.global.trade.util.TalTradeLanguageUtils;
import com.tal.user.global.trade.util.TalTradeLogger;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u000eJ.\u00105\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010&\u001a\u0004\u0018\u00010'J\u0006\u0010\u001d\u001a\u00020\u0019J\u0010\u00106\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0019J\u000e\u0010:\u001a\u0002072\u0006\u0010;\u001a\u000203R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010!R\"\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u0011\u0010$\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b%\u0010\fR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006="}, d2 = {"Lcom/tal/user/global/trade/api/TalTradeSdk;", "", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "btnRadiusDp", "", "getBtnRadiusDp", "()I", "<set-?>", "", "businessCode", "getBusinessCode", "()Ljava/lang/String;", "config", "Lcom/tal/user/global/trade/config/TalTradeSdkConfig;", "getConfig", "()Lcom/tal/user/global/trade/config/TalTradeSdkConfig;", "setConfig", "(Lcom/tal/user/global/trade/config/TalTradeSdkConfig;)V", "isInited", "", "()Z", "setInited", "(Z)V", "isNetAvailable", "localeStr", "getLocaleStr", "setLocaleStr", "(Ljava/lang/String;)V", "packageName", "getPackageName", "primaryColor", "getPrimaryColor", "talTradeCheckoutConfig", "Lcom/tal/user/global/trade/config/TalTradeCheckoutConfig;", "getTalTradeCheckoutConfig", "()Lcom/tal/user/global/trade/config/TalTradeCheckoutConfig;", "setTalTradeCheckoutConfig", "(Lcom/tal/user/global/trade/config/TalTradeCheckoutConfig;)V", "talTradeLogListener", "Lcom/tal/user/global/trade/listener/TalTradeLogListener;", "getTalTradeLogListener", "()Lcom/tal/user/global/trade/listener/TalTradeLogListener;", "setTalTradeLogListener", "(Lcom/tal/user/global/trade/listener/TalTradeLogListener;)V", "getLanguageLocal", "Ljava/util/Locale;", "getLanguageStr2server", "init", "registerNetworkCallback", "", "resetInited", "boolean", "setLanguage", "locale", "Companion", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeSdk.kt */
public final class TalTradeSdk {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "TalGlobalTrade";
    /* access modifiers changed from: private */
    public static final TalTradeSdk instance = new TalTradeSdk();
    private Application application;
    private String businessCode;
    private TalTradeSdkConfig config = new TalTradeSdkConfig();
    private boolean isInited;
    /* access modifiers changed from: private */
    public boolean isNetAvailable = true;
    private String localeStr = "";
    private String packageName;
    private TalTradeCheckoutConfig talTradeCheckoutConfig;
    private TalTradeLogListener talTradeLogListener;

    @JvmStatic
    public static final TalTradeSdk getInstance() {
        return Companion.getInstance();
    }

    private TalTradeSdk() {
    }

    public final TalTradeLogListener getTalTradeLogListener() {
        return this.talTradeLogListener;
    }

    public final void setTalTradeLogListener(TalTradeLogListener talTradeLogListener2) {
        this.talTradeLogListener = talTradeLogListener2;
    }

    public final boolean isInited() {
        return this.isInited;
    }

    public final void setInited(boolean z) {
        this.isInited = z;
    }

    public final TalTradeSdkConfig getConfig() {
        return this.config;
    }

    public final void setConfig(TalTradeSdkConfig talTradeSdkConfig) {
        Intrinsics.checkNotNullParameter(talTradeSdkConfig, "<set-?>");
        this.config = talTradeSdkConfig;
    }

    public final TalTradeCheckoutConfig getTalTradeCheckoutConfig() {
        return this.talTradeCheckoutConfig;
    }

    public final void setTalTradeCheckoutConfig(TalTradeCheckoutConfig talTradeCheckoutConfig2) {
        this.talTradeCheckoutConfig = talTradeCheckoutConfig2;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final void setApplication(Application application2) {
        this.application = application2;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getBusinessCode() {
        return this.businessCode;
    }

    public final String getLocaleStr() {
        return this.localeStr;
    }

    public final void setLocaleStr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localeStr = str;
    }

    public final void resetInited(boolean z) {
        if (this.isInited) {
            this.isInited = z;
            return;
        }
        throw new TalTradeInitException("TalTradeGlobalSdk::Init::TalTradeGlobalSdk init(context) first!");
    }

    public final boolean init(String str, Application application2, TalTradeSdkConfig talTradeSdkConfig, TalTradeCheckoutConfig talTradeCheckoutConfig2) {
        boolean z = this.isInited;
        if (z) {
            return z;
        }
        if (application2 != null && !TextUtils.isEmpty(str)) {
            this.application = application2;
            this.businessCode = str;
            this.packageName = application2.getPackageName();
            if (talTradeSdkConfig == null) {
                this.config = new TalTradeSdkConfig();
            } else {
                this.config = talTradeSdkConfig;
            }
            if (talTradeCheckoutConfig2 == null) {
                this.talTradeCheckoutConfig = new TalTradeCheckoutConfig();
            } else {
                this.talTradeCheckoutConfig = talTradeCheckoutConfig2;
            }
            registerNetworkCallback(application2);
            Producer.INSTANCE.initProducer(application2);
            Producer.INSTANCE.oneClickLog("04_01_06_00_DJQR");
            this.isInited = true;
        }
        return this.isInited;
    }

    public final int getBtnRadiusDp() {
        TalTradeCheckoutConfig talTradeCheckoutConfig2 = this.talTradeCheckoutConfig;
        if (talTradeCheckoutConfig2 != null) {
            Intrinsics.checkNotNull(talTradeCheckoutConfig2);
            if (talTradeCheckoutConfig2.getBtnRadiusDp() > 0) {
                TalTradeCheckoutConfig talTradeCheckoutConfig3 = this.talTradeCheckoutConfig;
                Intrinsics.checkNotNull(talTradeCheckoutConfig3);
                return talTradeCheckoutConfig3.getBtnRadiusDp();
            }
        }
        return 24;
    }

    public final int getPrimaryColor() {
        Resources resources;
        TalTradeCheckoutConfig talTradeCheckoutConfig2 = this.talTradeCheckoutConfig;
        if (talTradeCheckoutConfig2 != null) {
            Intrinsics.checkNotNull(talTradeCheckoutConfig2);
            CharSequence primaryColor = talTradeCheckoutConfig2.getPrimaryColor();
            if (!(primaryColor == null || primaryColor.length() == 0)) {
                TalTradeCheckoutConfig talTradeCheckoutConfig3 = this.talTradeCheckoutConfig;
                Intrinsics.checkNotNull(talTradeCheckoutConfig3);
                return Color.parseColor(talTradeCheckoutConfig3.getPrimaryColor());
            }
        }
        Application application2 = this.application;
        Integer valueOf = (application2 == null || (resources = application2.getResources()) == null) ? null : Integer.valueOf(resources.getColor(R.color.tal_trade_color_primary));
        Intrinsics.checkNotNull(valueOf);
        return valueOf.intValue();
    }

    public final void setLanguage(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (this.isInited) {
            CharSequence language = locale.getLanguage();
            boolean z = false;
            if (!(language == null || language.length() == 0)) {
                CharSequence country = locale.getCountry();
                if (country == null || country.length() == 0) {
                    z = true;
                }
                if (!z) {
                    TalTradeLanguageUtils.updateResources(this.application, locale);
                    return;
                }
                return;
            }
            return;
        }
        throw new TalTradeInitException("TalTradeGlobalSdk::Init::TalTradeGlobalSdk init(context) first!");
    }

    public final Locale getLanguageLocal() {
        if (this.localeStr.length() == 0) {
            Locale systemPreferredLanguage = TalTradeLanguageUtils.getSystemPreferredLanguage(this.application);
            Intrinsics.checkNotNullExpressionValue(systemPreferredLanguage, "TalTradeLanguageUtils.ge…rredLanguage(application)");
            return systemPreferredLanguage;
        }
        List split$default = StringsKt.split$default((CharSequence) this.localeStr, new String[]{"-"}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            return new Locale((String) split$default.get(0), (String) split$default.get(1));
        }
        return new Locale("en", "US");
    }

    public final String getLanguageStr2server() {
        String str;
        if (this.localeStr.length() == 0) {
            str = TalTradeLanguageUtils.locale2Str(TalTradeLanguageUtils.getSystemPreferredLanguage(this.application));
        } else {
            str = this.localeStr;
        }
        Intrinsics.checkNotNullExpressionValue(str, "str");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (StringsKt.startsWith$default(lowerCase, "en", false, 2, (Object) null)) {
            return "en-US";
        }
        String lowerCase2 = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        if (StringsKt.startsWith$default(lowerCase2, "zh-hk", false, 2, (Object) null)) {
            return "zh-HK";
        }
        String lowerCase3 = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase()");
        if (StringsKt.startsWith$default(lowerCase3, "zh-tw", false, 2, (Object) null)) {
            return "zh-TW";
        }
        String lowerCase4 = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase4, "(this as java.lang.String).toLowerCase()");
        if (StringsKt.startsWith$default(lowerCase4, "zh", false, 2, (Object) null)) {
            return "zh-CN";
        }
        return "en-US";
    }

    public final boolean isNetAvailable() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.isNetAvailable;
        }
        return Companion.isNetWorkAvailable(this.application);
    }

    private final void registerNetworkCallback(Application application2) {
        try {
            Object systemService = application2.getSystemService("connectivity");
            if (systemService != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                if (connectivityManager != null && Build.VERSION.SDK_INT >= 24) {
                    connectivityManager.registerDefaultNetworkCallback(new TalTradeSdk$registerNetworkCallback$1(this));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tal/user/global/trade/api/TalTradeSdk$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tal/user/global/trade/api/TalTradeSdk;", "getInstance", "isNetWorkAvailable", "", "context", "Landroid/content/Context;", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TalTradeSdk.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TalTradeSdk getInstance() {
            return TalTradeSdk.instance;
        }

        /* access modifiers changed from: private */
        public final boolean isNetWorkAvailable(Context context) {
            try {
                Intrinsics.checkNotNull(context);
                Object systemService = context.getSystemService("connectivity");
                if (systemService != null) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                    if ((connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null) == null) {
                        return false;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        return true;
                    }
                    return false;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            } catch (Exception e) {
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger();
                StringBuilder sb = new StringBuilder();
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[1];
                Intrinsics.checkNotNullExpressionValue(stackTraceElement, "Thread.currentThread().stackTrace[1]");
                sb.append(stackTraceElement.getMethodName());
                sb.append("发生的异常是: ");
                sb.append(e);
                logger.i(sb.toString());
            }
        }
    }
}
