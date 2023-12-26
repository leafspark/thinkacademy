package com.adyen.checkout.components.api;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.adyen.checkout.components.api.LogoApi;
import com.adyen.checkout.components.api.LogoConnectionTask;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u0013H\u0007J,\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0003\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u0013H\u0007J>\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u0013H\u0007J4\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0003\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u0013H\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/adyen/checkout/components/api/ImageLoader;", "", "logoApi", "Lcom/adyen/checkout/components/api/LogoApi;", "(Lcom/adyen/checkout/components/api/LogoApi;)V", "callbacks", "", "", "Lcom/adyen/checkout/components/api/LogoConnectionTask$LogoCallback;", "imageViews", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "load", "", "txVariant", "view", "size", "Lcom/adyen/checkout/components/api/LogoApi$Size;", "placeholder", "", "errorFallback", "txSubVariant", "Companion", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ImageLoader.kt */
public final class ImageLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    /* access modifiers changed from: private */
    public final Map<String, LogoConnectionTask.LogoCallback> callbacks = new HashMap();
    /* access modifiers changed from: private */
    public final Map<String, WeakReference<ImageView>> imageViews = new HashMap();
    private final LogoApi logoApi;

    @JvmStatic
    public static final ImageLoader getInstance(Context context, Environment environment) {
        return Companion.getInstance(context, environment);
    }

    public final void load(String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, imageView, 0, 0, 12, (Object) null);
    }

    public final void load(String str, ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, imageView, i, 0, 8, (Object) null);
    }

    public final void load(String str, ImageView imageView, LogoApi.Size size) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, imageView, size, 0, 0, 24, (Object) null);
    }

    public final void load(String str, ImageView imageView, LogoApi.Size size, int i) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, imageView, size, i, 0, 16, (Object) null);
    }

    public final void load(String str, String str2, ImageView imageView) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, str2, imageView, 0, 0, 24, (Object) null);
    }

    public final void load(String str, String str2, ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, str2, imageView, i, 0, 16, (Object) null);
    }

    public final void load(String str, String str2, ImageView imageView, LogoApi.Size size) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, str2, imageView, size, 0, 0, 48, (Object) null);
    }

    public final void load(String str, String str2, ImageView imageView, LogoApi.Size size, int i) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, str2, imageView, size, i, 0, 32, (Object) null);
    }

    public ImageLoader(LogoApi logoApi2) {
        Intrinsics.checkNotNullParameter(logoApi2, "logoApi");
        this.logoApi = logoApi2;
    }

    public static /* synthetic */ void load$default(ImageLoader imageLoader, String str, ImageView imageView, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        imageLoader.load(str, imageView, i, i2);
    }

    public final void load(String str, ImageView imageView, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load(str, "", imageView, i, i2);
    }

    public static /* synthetic */ void load$default(ImageLoader imageLoader, String str, ImageView imageView, LogoApi.Size size, int i, int i2, int i3, Object obj) {
        imageLoader.load(str, imageView, size, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public final void load(String str, ImageView imageView, LogoApi.Size size, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load(str, "", imageView, size, i, i2);
    }

    public static /* synthetic */ void load$default(ImageLoader imageLoader, String str, String str2, ImageView imageView, int i, int i2, int i3, Object obj) {
        imageLoader.load(str, str2, imageView, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public final void load(String str, String str2, ImageView imageView, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load(str, str2, imageView, LogoApi.Companion.getDEFAULT_SIZE(), i, i2);
    }

    public static /* synthetic */ void load$default(ImageLoader imageLoader, String str, String str2, ImageView imageView, LogoApi.Size size, int i, int i2, int i3, Object obj) {
        imageLoader.load(str, str2, imageView, size, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2);
    }

    public final void load(String str, String str2, ImageView imageView, LogoApi.Size size, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        if (i != 0) {
            imageView.setImageResource(i);
        }
        String str3 = str + str2 + imageView.hashCode();
        if (this.callbacks.containsKey(str3)) {
            this.callbacks.remove(str3);
            this.imageViews.remove(str3);
        }
        LogoConnectionTask.LogoCallback imageLoader$load$callback$1 = new ImageLoader$load$callback$1(this, str3, i2);
        this.imageViews.put(str3, new WeakReference(imageView));
        this.callbacks.put(str3, imageLoader$load$callback$1);
        this.logoApi.getLogo(str, str2, size, imageLoader$load$callback$1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/adyen/checkout/components/api/ImageLoader$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/adyen/checkout/components/api/ImageLoader;", "context", "Landroid/content/Context;", "environment", "Lcom/adyen/checkout/core/api/Environment;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ImageLoader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageLoader getInstance(Context context, Environment environment) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(environment, "environment");
            LogoApi.Companion companion = LogoApi.Companion;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
            return new ImageLoader(companion.getInstance(environment, displayMetrics));
        }
    }

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        TAG = tag;
    }
}
