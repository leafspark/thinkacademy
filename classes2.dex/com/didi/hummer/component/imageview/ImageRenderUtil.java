package com.didi.hummer.component.imageview;

import android.text.TextUtils;
import android.util.Base64;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.imageloader.IImageLoaderAdapter;
import com.didi.hummer.adapter.imageloader.ImageSizeCallback;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.render.utility.YogaDrawableUtil;
import com.didi.hummer.render.utility.YogaResUtils;
import com.didi.hummer.utils.JsSourceUtil;

public class ImageRenderUtil {
    public static void renderImage(HummerContext hummerContext, ImageView imageView, String str, String str2, String str3) {
        renderImage(hummerContext, imageView, str, str2, str3, false, 0, (JSCallback) null);
    }

    public static void renderImage(HummerContext hummerContext, ImageView imageView, String str, String str2, String str3, ImageSizeCallback imageSizeCallback, JSCallback jSCallback) {
        renderImage(hummerContext, imageView, str, str2, str3, false, 0, jSCallback);
        if (imageSizeCallback != null) {
            getImageLoader(hummerContext).getImageSize(str, imageSizeCallback);
        }
    }

    public static void renderGif(HummerContext hummerContext, ImageView imageView, String str, String str2, String str3, int i) {
        renderImage(hummerContext, imageView, str, str2, str3, true, i, (JSCallback) null);
    }

    public static void renderGif(HummerContext hummerContext, ImageView imageView, String str, String str2, String str3, int i, ImageSizeCallback imageSizeCallback, JSCallback jSCallback) {
        renderImage(hummerContext, imageView, str, str2, str3, true, i, jSCallback);
        if (imageSizeCallback != null) {
            getImageLoader(hummerContext).getImageSize(str, imageSizeCallback);
        }
    }

    private static void renderImage(HummerContext hummerContext, ImageView imageView, String str, String str2, String str3, boolean z, int i, JSCallback jSCallback) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (isRemoteImage(str)) {
                if (z) {
                    renderRemoteGif(hummerContext, imageView, str, str2, str3, i, jSCallback);
                } else {
                    renderRemoteImage(hummerContext, imageView, str, str2, str3, jSCallback);
                }
            } else if (isLocalAbsoluteImage(str)) {
                if (z) {
                    renderLocalGif(hummerContext, imageView, str, i, jSCallback);
                } else {
                    renderLocalImage(hummerContext, imageView, str, jSCallback);
                }
            } else if (isLocalRelativeImage(str)) {
                int jsSourceType = JsSourceUtil.getJsSourceType(hummerContext.getJsSourcePath());
                String realResourcePath = JsSourceUtil.getRealResourcePath(str, hummerContext.getJsSourcePath());
                if (jsSourceType != 1) {
                    if (jsSourceType != 2) {
                        if (jsSourceType == 3) {
                            if (z) {
                                renderRemoteGif(hummerContext, imageView, realResourcePath, str2, str3, i, jSCallback);
                            } else {
                                renderRemoteImage(hummerContext, imageView, realResourcePath, str2, str3, jSCallback);
                            }
                        }
                    } else if (z) {
                        renderLocalGif(hummerContext, imageView, realResourcePath, i, jSCallback);
                    } else {
                        renderLocalImage(hummerContext, imageView, realResourcePath, jSCallback);
                    }
                } else if (z) {
                    renderAssetsGif(hummerContext, imageView, realResourcePath, i, jSCallback);
                } else {
                    renderAssetsImage(hummerContext, imageView, realResourcePath, jSCallback);
                }
            } else if (isBase64Image(str)) {
                renderBase64Image(imageView, str, jSCallback);
            } else if (z) {
                renderResourceGif(hummerContext, imageView, str, i, jSCallback);
            } else {
                renderResourceImage(hummerContext, imageView, str, jSCallback);
            }
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

    private static void renderRemoteImage(HummerContext hummerContext, ImageView imageView, String str, String str2, String str3, JSCallback jSCallback) {
        if (!TextUtils.isEmpty(str)) {
            YogaDrawableUtil.loadDrawable(hummerContext, str2, new ImageRenderUtil$$ExternalSyntheticLambda1(hummerContext, str3, str, imageView, jSCallback));
        }
    }

    private static void renderLocalImage(HummerContext hummerContext, ImageView imageView, String str, JSCallback jSCallback) {
        getImageLoader(hummerContext).setImage(str, imageView, jSCallback);
    }

    private static void renderAssetsImage(HummerContext hummerContext, ImageView imageView, String str, JSCallback jSCallback) {
        getImageLoader(hummerContext).setImage("file:///android_asset/" + str, imageView, jSCallback);
    }

    private static void renderBase64Image(ImageView imageView, String str, JSCallback jSCallback) {
        try {
            byte[] decode = Base64.decode(str.split(",")[1], 0);
            imageView.setImageBitmap(BitmapFactoryInstrumentation.decodeByteArray(decode, 0, decode.length));
            if (jSCallback != null) {
                jSCallback.call(2, true);
            }
        } catch (Exception unused) {
            if (jSCallback != null) {
                jSCallback.call(0, false);
            }
        }
    }

    private static void renderResourceImage(HummerContext hummerContext, ImageView imageView, String str, JSCallback jSCallback) {
        getImageLoader(hummerContext).setImage(YogaResUtils.getResourceId(str, "drawable", (String) null), imageView, jSCallback);
    }

    private static void renderRemoteGif(HummerContext hummerContext, ImageView imageView, String str, String str2, String str3, int i, JSCallback jSCallback) {
        if (!TextUtils.isEmpty(str)) {
            getImageLoader(hummerContext).setGif(fitRemoteUrl(str), i, imageView, jSCallback);
        }
    }

    private static void renderLocalGif(HummerContext hummerContext, ImageView imageView, String str, int i, JSCallback jSCallback) {
        getImageLoader(hummerContext).setGif(str, i, imageView, jSCallback);
    }

    private static void renderAssetsGif(HummerContext hummerContext, ImageView imageView, String str, int i, JSCallback jSCallback) {
        getImageLoader(hummerContext).setGif("file:///android_asset/" + str, i, imageView, jSCallback);
    }

    private static void renderResourceGif(HummerContext hummerContext, ImageView imageView, String str, int i, JSCallback jSCallback) {
        getImageLoader(hummerContext).setGif(YogaResUtils.getResourceId(str, "drawable", (String) null), i, imageView, jSCallback);
    }

    private static IImageLoaderAdapter getImageLoader(HummerContext hummerContext) {
        return HummerAdapter.getImageLoaderAdapter(hummerContext.getNamespace());
    }
}
