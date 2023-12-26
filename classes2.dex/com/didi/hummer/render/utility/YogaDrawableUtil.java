package com.didi.hummer.render.utility;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.imageloader.DrawableCallback;
import com.didi.hummer.adapter.imageloader.IImageLoaderAdapter;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.render.component.view.BackgroundDrawable;
import com.didi.hummer.utils.JsSourceUtil;

public class YogaDrawableUtil {
    public static void renderDrawable(HummerContext hummerContext, BackgroundDrawable backgroundDrawable, String str) {
        if (backgroundDrawable != null) {
            backgroundDrawable.getClass();
            loadDrawable(hummerContext, str, new YogaDrawableUtil$$ExternalSyntheticLambda0(backgroundDrawable));
        }
    }

    public static void loadDrawable(HummerContext hummerContext, String str, DrawableCallback drawableCallback) {
        if (TextUtils.isEmpty(str)) {
            if (drawableCallback != null) {
                drawableCallback.onDrawableLoaded((Drawable) null);
            }
        } else if (isRemoteImage(str)) {
            loadRemoteDrawable(hummerContext, str, drawableCallback);
        } else if (isLocalAbsoluteImage(str)) {
            loadLocalDrawable(hummerContext, str, drawableCallback);
        } else if (isLocalRelativeImage(str)) {
            int jsSourceType = JsSourceUtil.getJsSourceType(hummerContext.getJsSourcePath());
            String realResourcePath = JsSourceUtil.getRealResourcePath(str, hummerContext.getJsSourcePath());
            if (jsSourceType == 1) {
                loadAssetsDrawable(hummerContext, realResourcePath, drawableCallback);
            } else if (jsSourceType == 2) {
                loadLocalDrawable(hummerContext, realResourcePath, drawableCallback);
            } else if (jsSourceType == 3) {
                loadRemoteDrawable(hummerContext, realResourcePath, drawableCallback);
            }
        } else if (isBase64Image(str)) {
            loadBase64Drawable(str, drawableCallback);
        } else {
            loadResourceDrawable(hummerContext, str, drawableCallback);
        }
    }

    private static boolean isRemoteImage(String str) {
        return str != null && (str.startsWith("//") || str.toLowerCase().startsWith("http"));
    }

    private static boolean isLocalAbsoluteImage(String str) {
        return str != null && str.startsWith("/");
    }

    private static boolean isLocalRelativeImage(String str) {
        return str != null && str.startsWith("./");
    }

    private static boolean isBase64Image(String str) {
        return str != null && (str.contains("base64") || str.contains("BASE64"));
    }

    private static String fitRemoteUrl(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("//")) {
            return str;
        }
        return "https:" + str;
    }

    private static void loadRemoteDrawable(HummerContext hummerContext, String str, DrawableCallback drawableCallback) {
        if (!TextUtils.isEmpty(str)) {
            getImageLoader(hummerContext).loadDrawable(fitRemoteUrl(str), drawableCallback);
        }
    }

    private static void loadLocalDrawable(HummerContext hummerContext, String str, DrawableCallback drawableCallback) {
        getImageLoader(hummerContext).loadDrawable(str, drawableCallback);
    }

    private static void loadAssetsDrawable(HummerContext hummerContext, String str, DrawableCallback drawableCallback) {
        getImageLoader(hummerContext).loadDrawable("file:///android_asset/" + str, drawableCallback);
    }

    private static void loadBase64Drawable(String str, DrawableCallback drawableCallback) {
        BitmapDrawable bitmapDrawable;
        try {
            byte[] decode = Base64.decode(str.split(",")[1], 0);
            bitmapDrawable = new BitmapDrawable(BitmapFactoryInstrumentation.decodeByteArray(decode, 0, decode.length));
        } catch (Exception unused) {
            bitmapDrawable = null;
        }
        if (drawableCallback != null) {
            drawableCallback.onDrawableLoaded(bitmapDrawable);
        }
    }

    private static void loadResourceDrawable(HummerContext hummerContext, String str, DrawableCallback drawableCallback) {
        getImageLoader(hummerContext).loadDrawable(YogaResUtils.getResourceId(str, "drawable", (String) null), drawableCallback);
    }

    private static IImageLoaderAdapter getImageLoader(HummerContext hummerContext) {
        return HummerAdapter.getImageLoaderAdapter(hummerContext.getNamespace());
    }
}
