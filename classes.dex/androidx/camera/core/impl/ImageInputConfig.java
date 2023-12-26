package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

public interface ImageInputConfig extends ReadableConfig {
    public static final Config.Option<Integer> OPTION_INPUT_FORMAT = Config.Option.create("camerax.core.imageInput.inputFormat", Integer.TYPE);

    int getInputFormat();

    /* renamed from: androidx.camera.core.impl.ImageInputConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getInputFormat(ImageInputConfig _this) {
            return ((Integer) _this.retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
        }
    }
}
