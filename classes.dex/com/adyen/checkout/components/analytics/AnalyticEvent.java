package com.adyen.checkout.components.analytics;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.URLUtil;
import com.adyen.checkout.core.exception.CheckoutException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class AnalyticEvent implements Parcelable {
    private static final String ANDROID_PLATFORM = "android";
    private static final String COMPONENT_FLAVOR = "components";
    private static final String COMPONENT_KEY = "component";
    public static final Parcelable.Creator<AnalyticEvent> CREATOR = new Parcelable.Creator<AnalyticEvent>() {
        public AnalyticEvent createFromParcel(Parcel parcel) {
            return new AnalyticEvent(parcel);
        }

        public AnalyticEvent[] newArray(int i) {
            return new AnalyticEvent[i];
        }
    };
    private static final String CURRENT_PAYLOAD_VERSION = "1";
    private static final String DEVICE_BRAND_KEY = "device_brand";
    private static final String DEVICE_MODEL_KEY = "device_model";
    private static final String DROPIN_FLAVOR = "dropin";
    private static final String FLAVOR_KEY = "flavor";
    private static final String LOCALE_KEY = "locale";
    private static final String PAYLOAD_VERSION_KEY = "payload_version";
    private static final String PLATFORM_KEY = "platform";
    private static final String REFERER_KEY = "referer";
    private static final String SYSTEM_VERSION_KEY = "system_version";
    private static final String VERSION_KEY = "version";
    private final String mComponent;
    private final String mDeviceBrand = Build.BRAND;
    private final String mDeviceModel = Build.MODEL;
    private final String mFlavor;
    private final String mLocale;
    private final String mPayloadVersion = CURRENT_PAYLOAD_VERSION;
    private final String mPlatform = ANDROID_PLATFORM;
    private final String mReferer;
    private final String mSystemVersion = String.valueOf(Build.VERSION.SDK_INT);
    private final String mVersion = "4.5.0";

    public enum Flavor {
        DROPIN,
        COMPONENT
    }

    public int describeContents() {
        return 1;
    }

    /* renamed from: com.adyen.checkout.components.analytics.AnalyticEvent$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$adyen$checkout$components$analytics$AnalyticEvent$Flavor;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.checkout.components.analytics.AnalyticEvent$Flavor[] r0 = com.adyen.checkout.components.analytics.AnalyticEvent.Flavor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$adyen$checkout$components$analytics$AnalyticEvent$Flavor = r0
                com.adyen.checkout.components.analytics.AnalyticEvent$Flavor r1 = com.adyen.checkout.components.analytics.AnalyticEvent.Flavor.DROPIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$adyen$checkout$components$analytics$AnalyticEvent$Flavor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.components.analytics.AnalyticEvent$Flavor r1 = com.adyen.checkout.components.analytics.AnalyticEvent.Flavor.COMPONENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.analytics.AnalyticEvent.AnonymousClass2.<clinit>():void");
        }
    }

    public static AnalyticEvent create(Context context, Flavor flavor, String str, Locale locale) {
        String str2;
        int i = AnonymousClass2.$SwitchMap$com$adyen$checkout$components$analytics$AnalyticEvent$Flavor[flavor.ordinal()];
        if (i == 1) {
            str2 = DROPIN_FLAVOR;
        } else if (i == 2) {
            str2 = COMPONENT_FLAVOR;
        } else {
            throw new CheckoutException("Unexpected flavor - " + flavor.name());
        }
        return new AnalyticEvent(context.getPackageName(), str2, str, locale.toString());
    }

    AnalyticEvent(Parcel parcel) {
        this.mFlavor = parcel.readString();
        this.mComponent = parcel.readString();
        this.mLocale = parcel.readString();
        this.mReferer = parcel.readString();
    }

    private AnalyticEvent(String str, String str2, String str3, String str4) {
        this.mReferer = str;
        this.mLocale = str4;
        this.mFlavor = str2;
        this.mComponent = str3;
    }

    /* access modifiers changed from: package-private */
    public URL toUrl(String str) throws MalformedURLException {
        if (URLUtil.isValidUrl(str)) {
            Uri parse = Uri.parse(str);
            return new URL(new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).appendQueryParameter(PAYLOAD_VERSION_KEY, CURRENT_PAYLOAD_VERSION).appendQueryParameter(VERSION_KEY, "4.5.0").appendQueryParameter(FLAVOR_KEY, this.mFlavor).appendQueryParameter(COMPONENT_KEY, this.mComponent).appendQueryParameter(LOCALE_KEY, this.mLocale).appendQueryParameter(PLATFORM_KEY, ANDROID_PLATFORM).appendQueryParameter("referer", this.mReferer).appendQueryParameter(DEVICE_BRAND_KEY, this.mDeviceBrand).appendQueryParameter(DEVICE_MODEL_KEY, this.mDeviceModel).appendQueryParameter(SYSTEM_VERSION_KEY, this.mSystemVersion).build().toString());
        }
        throw new MalformedURLException("Invalid URL format - " + str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mFlavor);
        parcel.writeString(this.mComponent);
        parcel.writeString(this.mLocale);
        parcel.writeString(this.mReferer);
    }
}
