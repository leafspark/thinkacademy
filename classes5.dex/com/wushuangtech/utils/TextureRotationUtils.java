package com.wushuangtech.utils;

import com.wushuangtech.constants.LocalSDKConstants;
import com.yalantis.ucrop.view.CropImageView;

public class TextureRotationUtils {
    private static final float[] TEXTURE_NO_ROTATION = {1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};
    private static final float[] TEXTURE_ROTATED_180 = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, 1.0f};
    private static final float[] TEXTURE_ROTATED_270 = {1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f};
    private static final float[] TEXTURE_ROTATED_90 = {CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO};

    private static float flip(float f) {
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            return 1.0f;
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* renamed from: com.wushuangtech.utils.TextureRotationUtils$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.wushuangtech.utils.TextureRotationUtils$Rotation[] r0 = com.wushuangtech.utils.TextureRotationUtils.Rotation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation = r0
                com.wushuangtech.utils.TextureRotationUtils$Rotation r1 = com.wushuangtech.utils.TextureRotationUtils.Rotation.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation     // Catch:{ NoSuchFieldError -> 0x001d }
                com.wushuangtech.utils.TextureRotationUtils$Rotation r1 = com.wushuangtech.utils.TextureRotationUtils.Rotation.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.wushuangtech.utils.TextureRotationUtils$Rotation r1 = com.wushuangtech.utils.TextureRotationUtils.Rotation.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.wushuangtech.utils.TextureRotationUtils$Rotation r1 = com.wushuangtech.utils.TextureRotationUtils.Rotation.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.utils.TextureRotationUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static float[] getRotation(Rotation rotation, boolean z, boolean z2) {
        float[] fArr;
        int i = AnonymousClass1.$SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation[rotation.ordinal()];
        if (i == 1) {
            fArr = TEXTURE_ROTATED_90;
        } else if (i == 2) {
            fArr = TEXTURE_ROTATED_180;
        } else if (i != 3) {
            fArr = TEXTURE_NO_ROTATION;
        } else {
            fArr = TEXTURE_ROTATED_270;
        }
        if (z) {
            fArr = new float[]{flip(fArr[0]), fArr[1], flip(fArr[2]), fArr[3], flip(fArr[4]), fArr[5], flip(fArr[6]), fArr[7]};
        }
        if (!z2) {
            return fArr;
        }
        return new float[]{fArr[0], flip(fArr[1]), fArr[2], flip(fArr[3]), fArr[4], flip(fArr[5]), fArr[6], flip(fArr[7])};
    }

    public enum Rotation {
        NORMAL,
        ROTATION_90,
        ROTATION_180,
        ROTATION_270;

        public int asInt() {
            int i = AnonymousClass1.$SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation[ordinal()];
            if (i == 1) {
                return 90;
            }
            if (i == 2) {
                return LocalSDKConstants.SCREEN_ROTATE_180;
            }
            if (i == 3) {
                return LocalSDKConstants.SCREEN_ROTATE_270;
            }
            if (i == 4) {
                return 0;
            }
            throw new IllegalStateException("Unknown Rotation!");
        }

        public static Rotation fromInt(int i) {
            if (i != 0) {
                if (i == 90) {
                    return ROTATION_90;
                }
                if (i == 180) {
                    return ROTATION_180;
                }
                if (i == 270) {
                    return ROTATION_270;
                }
                if (i != 360) {
                    throw new IllegalStateException(i + " is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
                }
            }
            return NORMAL;
        }
    }
}
