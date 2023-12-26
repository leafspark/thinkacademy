package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Config;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface ImageOutputConfig extends ReadableConfig {
    public static final int INVALID_ROTATION = -1;
    public static final Config.Option<Size> OPTION_DEFAULT_RESOLUTION = Config.Option.create("camerax.core.imageOutput.defaultResolution", Size.class);
    public static final Config.Option<Size> OPTION_MAX_RESOLUTION = Config.Option.create("camerax.core.imageOutput.maxResolution", Size.class);
    public static final Config.Option<List<Pair<Integer, Size[]>>> OPTION_SUPPORTED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.supportedResolutions", List.class);
    public static final Config.Option<Integer> OPTION_TARGET_ASPECT_RATIO = Config.Option.create("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);
    public static final Config.Option<Size> OPTION_TARGET_RESOLUTION = Config.Option.create("camerax.core.imageOutput.targetResolution", Size.class);
    public static final Config.Option<Integer> OPTION_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.targetRotation", Integer.TYPE);

    public interface Builder<B> {
        B setDefaultResolution(Size size);

        B setMaxResolution(Size size);

        B setSupportedResolutions(List<Pair<Integer, Size[]>> list);

        B setTargetAspectRatio(int i);

        B setTargetResolution(Size size);

        B setTargetRotation(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationDegreesValue {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationValue {
    }

    Size getDefaultResolution();

    Size getDefaultResolution(Size size);

    Size getMaxResolution();

    Size getMaxResolution(Size size);

    List<Pair<Integer, Size[]>> getSupportedResolutions();

    List<Pair<Integer, Size[]>> getSupportedResolutions(List<Pair<Integer, Size[]>> list);

    int getTargetAspectRatio();

    Size getTargetResolution();

    Size getTargetResolution(Size size);

    int getTargetRotation();

    int getTargetRotation(int i);

    boolean hasTargetAspectRatio();

    /* renamed from: androidx.camera.core.impl.ImageOutputConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$hasTargetAspectRatio(ImageOutputConfig _this) {
            return _this.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
        }

        public static int $default$getTargetAspectRatio(ImageOutputConfig _this) {
            return ((Integer) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)).intValue();
        }

        public static int $default$getTargetRotation(ImageOutputConfig _this, int i) {
            return ((Integer) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i))).intValue();
        }

        public static int $default$getTargetRotation(ImageOutputConfig _this) {
            return ((Integer) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION)).intValue();
        }

        public static Size $default$getTargetResolution(ImageOutputConfig _this, Size size) {
            return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
        }

        public static Size $default$getTargetResolution(ImageOutputConfig _this) {
            return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
        }

        public static Size $default$getDefaultResolution(ImageOutputConfig _this, Size size) {
            return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
        }

        public static Size $default$getDefaultResolution(ImageOutputConfig _this) {
            return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION);
        }

        public static Size $default$getMaxResolution(ImageOutputConfig _this, Size size) {
            return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
        }

        public static Size $default$getMaxResolution(ImageOutputConfig _this) {
            return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
        }

        public static List $default$getSupportedResolutions(ImageOutputConfig _this, List list) {
            return (List) _this.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
        }

        public static List $default$getSupportedResolutions(ImageOutputConfig _this) {
            return (List) _this.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS);
        }
    }
}
