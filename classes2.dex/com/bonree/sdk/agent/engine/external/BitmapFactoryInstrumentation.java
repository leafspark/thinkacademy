package com.bonree.sdk.agent.engine.external;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.util.TypedValue;
import com.bonree.sdk.d.a;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.lang.reflect.Field;
import ohos.media.image.ImageSource;
import ohos.media.image.PixelMap;

public class BitmapFactoryInstrumentation {
    private static final String BF_CREATE_PIXEL_MAP = "ImageSource/createPixelmap";
    private static final String BF_CREATE_THUMBNAIL_PIXEL_MAP = "ImageSource/createThumbnailPixelmap";
    private static final String BF_DECODEBYTEARRAY = "BitmapFactory/decodeByteArray";
    private static final String BF_DECODEFILE = "BitmapFactory/decodeFile";
    private static final String BF_DECODEFILEDESCRIPTOR = "BitmapFactory/decodeFileDescriptor";
    private static final String BF_DECODERESOURCE = "BitmapFactory/decodeResource";
    private static final String BF_DECODERESOURCESTREAM = "BitmapFactory/decodeResourceStream";
    private static final String BF_DECODESTREAM = "BitmapFactory/decodeStream";
    public static final String BF_FRESCO = "Fresco/setController";
    public static long start;

    static class BonreeCallBack<INFO> implements ControllerListener<INFO> {
        public ControllerListener<INFO> mControllerListener;

        public ControllerListener<INFO> getUserControllerListener() {
            return this.mControllerListener;
        }

        public BonreeCallBack(ControllerListener<INFO> controllerListener) {
            if (!(controllerListener instanceof BonreeCallBack)) {
                this.mControllerListener = controllerListener;
            }
        }

        public void onSubmit(String str, Object obj) {
            ControllerListener<INFO> controllerListener = this.mControllerListener;
            if (controllerListener != null) {
                controllerListener.onSubmit(str, obj);
            }
        }

        public void onFinalImageSet(String str, INFO info, Animatable animatable) {
            ControllerListener<INFO> controllerListener = this.mControllerListener;
            if (controllerListener != null) {
                controllerListener.onFinalImageSet(str, info, animatable);
            }
            BitmapFactoryInstrumentation.afterMethod(BitmapFactoryInstrumentation.BF_FRESCO);
        }

        public void onIntermediateImageSet(String str, INFO info) {
            ControllerListener<INFO> controllerListener = this.mControllerListener;
            if (controllerListener != null) {
                controllerListener.onIntermediateImageSet(str, info);
            }
        }

        public void onIntermediateImageFailed(String str, Throwable th) {
            ControllerListener<INFO> controllerListener = this.mControllerListener;
            if (controllerListener != null) {
                controllerListener.onIntermediateImageFailed(str, th);
            }
        }

        public void onFailure(String str, Throwable th) {
            BitmapFactoryInstrumentation.afterMethod(BitmapFactoryInstrumentation.BF_FRESCO);
            ControllerListener<INFO> controllerListener = this.mControllerListener;
            if (controllerListener != null) {
                controllerListener.onFailure(str, th);
            }
        }

        public void onRelease(String str) {
            ControllerListener<INFO> controllerListener = this.mControllerListener;
            if (controllerListener != null) {
                controllerListener.onRelease(str);
            }
        }
    }

    public static void setController(SimpleDraweeView simpleDraweeView, DraweeController draweeController) {
        start = a.b();
        beforeMethod(BF_FRESCO);
        try {
            if (draweeController instanceof PipelineDraweeController) {
                Class cls = draweeController.getClass();
                while (cls != AbstractDraweeController.class && cls != Object.class && cls != null) {
                    cls = cls.getSuperclass();
                }
                if (cls == AbstractDraweeController.class) {
                    Field declaredField = cls.getDeclaredField("mControllerListener");
                    declaredField.setAccessible(true);
                    ControllerListener controllerListener = (ControllerListener) declaredField.get(draweeController);
                    if (controllerListener instanceof BonreeCallBack) {
                        controllerListener = ((BonreeCallBack) controllerListener).getUserControllerListener();
                    }
                    declaredField.set(draweeController, new BonreeCallBack(controllerListener));
                }
            }
        } catch (Throwable unused) {
        }
        com.bonree.sdk.be.a.a().a("BitmapFactoryInstrumentation setController time is %s.", Long.valueOf(a.b() - start));
        simpleDraweeView.setController(draweeController);
    }

    public static Bitmap decodeFile(String str, BitmapFactory.Options options) {
        String methodName = getMethodName(BF_DECODEFILE, "String, BitmapFactory.Options");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeFile(str, options);
        } finally {
            afterMethod(methodName);
        }
    }

    private static void beforeMethod(String str) {
        MethodInfo.beforeMethod(str, 2);
    }

    /* access modifiers changed from: private */
    public static void afterMethod(String str) {
        MethodInfo.afterMethod(str, 2);
    }

    public static Bitmap decodeFile(String str) {
        String methodName = getMethodName(BF_DECODEFILE, "String");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeFile(str);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        String methodName = getMethodName(BF_DECODERESOURCESTREAM, "Resources, TypedValue, InputStream, Rect, BitmapFactory.Options");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeResource(Resources resources, int i, BitmapFactory.Options options) {
        String methodName = getMethodName(BF_DECODERESOURCE, "Resources, int, BitmapFactory.Options");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeResource(resources, i, options);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        String methodName = getMethodName(BF_DECODERESOURCE, "Resources, int");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeResource(resources, i);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        String methodName = getMethodName(BF_DECODEBYTEARRAY, "byte[], int, int, BitmapFactory.Options");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeByteArray(bArr, i, i2, options);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        String methodName = getMethodName(BF_DECODEBYTEARRAY, "byte[], int, int");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeByteArray(bArr, i, i2);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        String methodName = getMethodName(BF_DECODESTREAM, "InputStream, Rect, BitmapFactory.Options");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeStream(inputStream, rect, options);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        String methodName = getMethodName(BF_DECODESTREAM, "InputStream");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeStream(inputStream);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        String methodName = getMethodName(BF_DECODEFILEDESCRIPTOR, "FileDescriptor, Rect, BitmapFactory.Options");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        } finally {
            afterMethod(methodName);
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        String methodName = getMethodName(BF_DECODEFILEDESCRIPTOR, "FileDescriptor");
        beforeMethod(methodName);
        try {
            return BitmapFactory.decodeFileDescriptor(fileDescriptor);
        } finally {
            afterMethod(methodName);
        }
    }

    public static PixelMap createPixelmap(ImageSource imageSource, ImageSource.DecodingOptions decodingOptions) {
        String methodName = getMethodName(BF_CREATE_PIXEL_MAP, "ImageSource.DecodingOptions");
        beforeMethod(methodName);
        try {
            PixelMap createPixelmap = imageSource.createPixelmap(decodingOptions);
            afterMethod(methodName);
            return createPixelmap;
        } catch (Exception e) {
            afterMethod(methodName);
            throw e;
        }
    }

    public static PixelMap createPixelmap(ImageSource imageSource, int i, ImageSource.DecodingOptions decodingOptions) {
        String methodName = getMethodName(BF_CREATE_PIXEL_MAP, "int, ImageSource.DecodingOptions");
        beforeMethod(methodName);
        try {
            PixelMap createPixelmap = imageSource.createPixelmap(i, decodingOptions);
            afterMethod(methodName);
            return createPixelmap;
        } catch (Exception e) {
            afterMethod(methodName);
            throw e;
        }
    }

    public static PixelMap createThumbnailPixelmap(ImageSource imageSource, ImageSource.DecodingOptions decodingOptions, boolean z) {
        String methodName = getMethodName(BF_CREATE_THUMBNAIL_PIXEL_MAP, "ImageSource.DecodingOptions, boolean");
        beforeMethod(methodName);
        try {
            PixelMap createThumbnailPixelmap = imageSource.createThumbnailPixelmap(decodingOptions, z);
            afterMethod(methodName);
            return createThumbnailPixelmap;
        } catch (Exception e) {
            afterMethod(methodName);
            throw e;
        }
    }

    private static String getMethodName(String str, String str2) {
        return String.format("%s(%s)", new Object[]{str, str2});
    }
}
