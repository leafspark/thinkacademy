package androidx.camera.core.impl.utils;

import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.core.util.Preconditions;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ExifData {
    private static final boolean DEBUG = false;
    static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4)};
    static final ExifTag[][] EXIF_TAGS;
    private static final ExifTag[] IFD_EXIF_TAGS;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    static final int IFD_TYPE_EXIF = 1;
    static final int IFD_TYPE_GPS = 2;
    static final int IFD_TYPE_INTEROPERABILITY = 3;
    static final int IFD_TYPE_PRIMARY = 0;
    private static final int MM_IN_MICRONS = 1000;
    private static final String TAG = "ExifData";
    static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_GPS_TIMESTAMP}));
    private final List<Map<String, ExifAttribute>> mAttributes;
    private final ByteOrder mByteOrder;

    public enum WhiteBalanceMode {
        AUTO,
        MANUAL
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag(ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(ExifInterface.TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(ExifInterface.TAG_MAKE, 271, 2), new ExifTag(ExifInterface.TAG_MODEL, 272, 2), new ExifTag(ExifInterface.TAG_ORIENTATION, 274, 3), new ExifTag(ExifInterface.TAG_X_RESOLUTION, 282, 5), new ExifTag(ExifInterface.TAG_Y_RESOLUTION, 283, 5), new ExifTag(ExifInterface.TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(ExifInterface.TAG_SOFTWARE, 305, 2), new ExifTag(ExifInterface.TAG_DATETIME, 306, 2), new ExifTag(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(ExifInterface.TAG_F_NUMBER, 33437, 5), new ExifTag(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(ExifInterface.TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(ExifInterface.TAG_EXIF_VERSION, 36864, 2), new ExifTag(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new ExifTag(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(ExifInterface.TAG_METERING_MODE, 37383, 3), new ExifTag(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(ExifInterface.TAG_FLASH, 37385, 3), new ExifTag(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new ExifTag(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(ExifInterface.TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(ExifInterface.TAG_COLOR_SPACE, 40961, 3), new ExifTag(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new ExifTag(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new ExifTag(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new ExifTag(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new ExifTag(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(ExifInterface.TAG_CONTRAST, 41992, 3), new ExifTag(ExifInterface.TAG_SATURATION, 41993, 3), new ExifTag(ExifInterface.TAG_SHARPNESS, 41994, 3)};
        IFD_EXIF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag(ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new ExifTag(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(ExifInterface.TAG_GPS_LATITUDE, 2, 5, 10), new ExifTag(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(ExifInterface.TAG_GPS_LONGITUDE, 4, 5, 10), new ExifTag(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new ExifTag(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new ExifTag(ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new ExifTag(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2)};
        IFD_GPS_TAGS = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        EXIF_TAGS = new ExifTag[][]{exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4};
    }

    ExifData(ByteOrder byteOrder, List<Map<String, ExifAttribute>> list) {
        Preconditions.checkState(list.size() == EXIF_TAGS.length, "Malformed attributes list. Number of IFDs mismatch.");
        this.mByteOrder = byteOrder;
        this.mAttributes = list;
    }

    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }

    /* access modifiers changed from: package-private */
    public Map<String, ExifAttribute> getAttributes(int i) {
        int length = EXIF_TAGS.length;
        Preconditions.checkArgumentInRange(i, 0, length, "Invalid IFD index: " + i + ". Index should be between [0, EXIF_TAGS.length] ");
        return this.mAttributes.get(i);
    }

    public String getAttribute(String str) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mByteOrder);
            }
            if (!str.equals(ExifInterface.TAG_GPS_TIMESTAMP)) {
                try {
                    return Double.toString(exifAttribute.getDoubleValue(this.mByteOrder));
                } catch (NumberFormatException unused) {
                }
            } else if (exifAttribute.format == 5 || exifAttribute.format == 10) {
                LongRational[] longRationalArr = (LongRational[]) exifAttribute.getValue(this.mByteOrder);
                if (longRationalArr == null || longRationalArr.length != 3) {
                    Logger.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(longRationalArr));
                    return null;
                }
                return String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) longRationalArr[0].getNumerator()) / ((float) longRationalArr[0].getDenominator()))), Integer.valueOf((int) (((float) longRationalArr[1].getNumerator()) / ((float) longRationalArr[1].getDenominator()))), Integer.valueOf((int) (((float) longRationalArr[2].getNumerator()) / ((float) longRationalArr[2].getDenominator())))});
            } else {
                Logger.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                return null;
            }
        }
        return null;
    }

    private ExifAttribute getExifAttribute(String str) {
        if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes.get(i).get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    public static Builder builderForDevice() {
        return new Builder(ByteOrder.BIG_ENDIAN).setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(1)).setAttribute(ExifInterface.TAG_X_RESOLUTION, "72/1").setAttribute(ExifInterface.TAG_Y_RESOLUTION, "72/1").setAttribute(ExifInterface.TAG_RESOLUTION_UNIT, String.valueOf(2)).setAttribute(ExifInterface.TAG_Y_CB_CR_POSITIONING, String.valueOf(1)).setAttribute(ExifInterface.TAG_MAKE, Build.MANUFACTURER).setAttribute(ExifInterface.TAG_MODEL, Build.MODEL);
    }

    public static final class Builder {
        private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final int DATETIME_VALUE_STRING_LENGTH = 19;
        private static final Pattern GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        static final List<HashMap<String, ExifTag>> sExifTagMapsForWriting = Collections.list(new Enumeration<HashMap<String, ExifTag>>() {
            int mIfdIndex = 0;

            public boolean hasMoreElements() {
                return this.mIfdIndex < ExifData.EXIF_TAGS.length;
            }

            public HashMap<String, ExifTag> nextElement() {
                HashMap<String, ExifTag> hashMap = new HashMap<>();
                for (ExifTag exifTag : ExifData.EXIF_TAGS[this.mIfdIndex]) {
                    hashMap.put(exifTag.name, exifTag);
                }
                this.mIfdIndex++;
                return hashMap;
            }
        });
        final List<Map<String, ExifAttribute>> mAttributes = Collections.list(new Enumeration<Map<String, ExifAttribute>>() {
            int mIfdIndex = 0;

            public boolean hasMoreElements() {
                return this.mIfdIndex < ExifData.EXIF_TAGS.length;
            }

            public Map<String, ExifAttribute> nextElement() {
                this.mIfdIndex++;
                return new HashMap();
            }
        });
        private final ByteOrder mByteOrder;

        Builder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public Builder setImageWidth(int i) {
            return setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i));
        }

        public Builder setImageHeight(int i) {
            return setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i));
        }

        public Builder setOrientationDegrees(int i) {
            int i2;
            if (i == 0) {
                i2 = 1;
            } else if (i == 90) {
                i2 = 6;
            } else if (i == 180) {
                i2 = 3;
            } else if (i != 270) {
                Logger.w(ExifData.TAG, "Unexpected orientation value: " + i + ". Must be one of 0, 90, 180, 270.");
                i2 = 0;
            } else {
                i2 = 8;
            }
            return setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i2));
        }

        public Builder setFlashState(CameraCaptureMetaData.FlashState flashState) {
            int i;
            if (flashState == CameraCaptureMetaData.FlashState.UNKNOWN) {
                return this;
            }
            int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[flashState.ordinal()];
            if (i2 == 1) {
                i = 0;
            } else if (i2 == 2) {
                i = 32;
            } else if (i2 != 3) {
                Logger.w(ExifData.TAG, "Unknown flash state: " + flashState);
                return this;
            } else {
                i = 1;
            }
            if ((i & 1) == 1) {
                setAttribute(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(4));
            }
            return setAttribute(ExifInterface.TAG_FLASH, String.valueOf(i));
        }

        public Builder setExposureTimeNanos(long j) {
            return setAttribute(ExifInterface.TAG_EXPOSURE_TIME, String.valueOf(((double) j) / ((double) TimeUnit.SECONDS.toNanos(1))));
        }

        public Builder setLensFNumber(float f) {
            return setAttribute(ExifInterface.TAG_F_NUMBER, String.valueOf(f));
        }

        public Builder setIso(int i) {
            return setAttribute(ExifInterface.TAG_SENSITIVITY_TYPE, String.valueOf(3)).setAttribute(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, String.valueOf(Math.min(65535, i)));
        }

        public Builder setFocalLength(float f) {
            return setAttribute(ExifInterface.TAG_FOCAL_LENGTH, new LongRational((long) (f * 1000.0f), 1000).toString());
        }

        public Builder setWhiteBalanceMode(WhiteBalanceMode whiteBalanceMode) {
            String str;
            int i = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode[whiteBalanceMode.ordinal()];
            if (i == 1) {
                str = String.valueOf(0);
            } else if (i != 2) {
                str = null;
            } else {
                str = String.valueOf(1);
            }
            return setAttribute(ExifInterface.TAG_WHITE_BALANCE, str);
        }

        public Builder setAttribute(String str, String str2) {
            setAttributeInternal(str, str2, this.mAttributes);
            return this;
        }

        public Builder removeAttribute(String str) {
            setAttributeInternal(str, (String) null, this.mAttributes);
            return this;
        }

        private void setAttributeIfMissing(String str, String str2, List<Map<String, ExifAttribute>> list) {
            for (Map<String, ExifAttribute> containsKey : list) {
                if (containsKey.containsKey(str)) {
                    return;
                }
            }
            setAttributeInternal(str, str2, list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:77:0x022d, code lost:
            r5 = r6;
            r15 = 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void setAttributeInternal(java.lang.String r18, java.lang.String r19, java.util.List<java.util.Map<java.lang.String, androidx.camera.core.impl.utils.ExifAttribute>> r20) {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                r2 = r19
                r3 = r20
                java.lang.String r4 = "DateTime"
                boolean r4 = r4.equals(r0)
                java.lang.String r5 = " : "
                java.lang.String r6 = "Invalid value for "
                java.lang.String r7 = "ExifData"
                if (r4 != 0) goto L_0x0026
                java.lang.String r4 = "DateTimeOriginal"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x0026
                java.lang.String r4 = "DateTimeDigitized"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x006d
            L_0x0026:
                if (r2 == 0) goto L_0x006d
                java.util.regex.Pattern r4 = DATETIME_PRIMARY_FORMAT_PATTERN
                java.util.regex.Matcher r4 = r4.matcher(r2)
                boolean r4 = r4.find()
                java.util.regex.Pattern r8 = DATETIME_SECONDARY_FORMAT_PATTERN
                java.util.regex.Matcher r8 = r8.matcher(r2)
                boolean r8 = r8.find()
                int r9 = r19.length()
                r10 = 19
                if (r9 != r10) goto L_0x0054
                if (r4 != 0) goto L_0x0049
                if (r8 != 0) goto L_0x0049
                goto L_0x0054
            L_0x0049:
                if (r8 == 0) goto L_0x006d
                java.lang.String r4 = "-"
                java.lang.String r8 = ":"
                java.lang.String r2 = r2.replaceAll(r4, r8)
                goto L_0x006d
            L_0x0054:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r6)
                r3.append(r0)
                r3.append(r5)
                r3.append(r2)
                java.lang.String r0 = r3.toString()
                androidx.camera.core.Logger.w(r7, r0)
                return
            L_0x006d:
                java.lang.String r4 = "ISOSpeedRatings"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0077
                java.lang.String r0 = "PhotographicSensitivity"
            L_0x0077:
                r4 = r0
                r0 = 2
                r8 = 1
                if (r2 == 0) goto L_0x0124
                java.util.HashSet<java.lang.String> r9 = androidx.camera.core.impl.utils.ExifData.sTagSetForCompatibility
                boolean r9 = r9.contains(r4)
                if (r9 == 0) goto L_0x0124
                java.lang.String r9 = "GPSTimeStamp"
                boolean r9 = r4.equals(r9)
                if (r9 == 0) goto L_0x00fc
                java.util.regex.Pattern r9 = GPS_TIMESTAMP_PATTERN
                java.util.regex.Matcher r9 = r9.matcher(r2)
                boolean r10 = r9.find()
                if (r10 != 0) goto L_0x00b1
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r6)
                r0.append(r4)
                r0.append(r5)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                androidx.camera.core.Logger.w(r7, r0)
                return
            L_0x00b1:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = r9.group(r8)
                java.lang.Object r5 = androidx.core.util.Preconditions.checkNotNull(r5)
                java.lang.String r5 = (java.lang.String) r5
                int r5 = java.lang.Integer.parseInt(r5)
                r2.append(r5)
                java.lang.String r5 = "/1,"
                r2.append(r5)
                java.lang.String r6 = r9.group(r0)
                java.lang.Object r6 = androidx.core.util.Preconditions.checkNotNull(r6)
                java.lang.String r6 = (java.lang.String) r6
                int r6 = java.lang.Integer.parseInt(r6)
                r2.append(r6)
                r2.append(r5)
                r5 = 3
                java.lang.String r5 = r9.group(r5)
                java.lang.Object r5 = androidx.core.util.Preconditions.checkNotNull(r5)
                java.lang.String r5 = (java.lang.String) r5
                int r5 = java.lang.Integer.parseInt(r5)
                r2.append(r5)
                java.lang.String r5 = "/1"
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                goto L_0x0124
            L_0x00fc:
                double r9 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x010a }
                androidx.camera.core.impl.utils.LongRational r11 = new androidx.camera.core.impl.utils.LongRational     // Catch:{ NumberFormatException -> 0x010a }
                r11.<init>(r9)     // Catch:{ NumberFormatException -> 0x010a }
                java.lang.String r2 = r11.toString()     // Catch:{ NumberFormatException -> 0x010a }
                goto L_0x0124
            L_0x010a:
                r0 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r6)
                r3.append(r4)
                r3.append(r5)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                androidx.camera.core.Logger.w(r7, r2, r0)
                return
            L_0x0124:
                r5 = 0
                r6 = r5
            L_0x0126:
                androidx.camera.core.impl.utils.ExifTag[][] r7 = androidx.camera.core.impl.utils.ExifData.EXIF_TAGS
                int r7 = r7.length
                if (r6 >= r7) goto L_0x02ef
                java.util.List<java.util.HashMap<java.lang.String, androidx.camera.core.impl.utils.ExifTag>> r7 = sExifTagMapsForWriting
                java.lang.Object r7 = r7.get(r6)
                java.util.HashMap r7 = (java.util.HashMap) r7
                java.lang.Object r7 = r7.get(r4)
                androidx.camera.core.impl.utils.ExifTag r7 = (androidx.camera.core.impl.utils.ExifTag) r7
                if (r7 == 0) goto L_0x02e6
                if (r2 != 0) goto L_0x0148
                java.lang.Object r7 = r3.get(r6)
                java.util.Map r7 = (java.util.Map) r7
                r7.remove(r4)
                goto L_0x02e6
            L_0x0148:
                android.util.Pair r9 = guessDataFormat(r2)
                int r10 = r7.primaryFormat
                java.lang.Object r11 = r9.first
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                r12 = -1
                if (r10 == r11) goto L_0x0195
                int r10 = r7.primaryFormat
                java.lang.Object r11 = r9.second
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                if (r10 != r11) goto L_0x0166
                goto L_0x0195
            L_0x0166:
                int r10 = r7.secondaryFormat
                if (r10 == r12) goto L_0x0185
                int r10 = r7.secondaryFormat
                java.lang.Object r11 = r9.first
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                if (r10 == r11) goto L_0x0182
                int r10 = r7.secondaryFormat
                java.lang.Object r9 = r9.second
                java.lang.Integer r9 = (java.lang.Integer) r9
                int r9 = r9.intValue()
                if (r10 != r9) goto L_0x0185
            L_0x0182:
                int r7 = r7.secondaryFormat
                goto L_0x0197
            L_0x0185:
                int r9 = r7.primaryFormat
                if (r9 == r8) goto L_0x0192
                int r9 = r7.primaryFormat
                r10 = 7
                if (r9 == r10) goto L_0x0192
                int r9 = r7.primaryFormat
                if (r9 != r0) goto L_0x02e6
            L_0x0192:
                int r7 = r7.primaryFormat
                goto L_0x0197
            L_0x0195:
                int r7 = r7.primaryFormat
            L_0x0197:
                java.lang.String r9 = "/"
                java.lang.String r10 = ","
                switch(r7) {
                    case 1: goto L_0x02d6;
                    case 2: goto L_0x02c6;
                    case 3: goto L_0x029e;
                    case 4: goto L_0x0276;
                    case 5: goto L_0x0231;
                    case 6: goto L_0x019e;
                    case 7: goto L_0x02c6;
                    case 8: goto L_0x019e;
                    case 9: goto L_0x0208;
                    case 10: goto L_0x01c7;
                    case 11: goto L_0x019e;
                    case 12: goto L_0x01a0;
                    default: goto L_0x019e;
                }
            L_0x019e:
                goto L_0x02e6
            L_0x01a0:
                java.lang.String[] r7 = r2.split(r10, r12)
                int r9 = r7.length
                double[] r9 = new double[r9]
                r10 = r5
            L_0x01a8:
                int r11 = r7.length
                if (r10 >= r11) goto L_0x01b6
                r11 = r7[r10]
                double r11 = java.lang.Double.parseDouble(r11)
                r9[r10] = r11
                int r10 = r10 + 1
                goto L_0x01a8
            L_0x01b6:
                java.lang.Object r7 = r3.get(r6)
                java.util.Map r7 = (java.util.Map) r7
                java.nio.ByteOrder r10 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r9 = androidx.camera.core.impl.utils.ExifAttribute.createDouble((double[]) r9, (java.nio.ByteOrder) r10)
                r7.put(r4, r9)
                goto L_0x02e6
            L_0x01c7:
                java.lang.String[] r7 = r2.split(r10, r12)
                int r10 = r7.length
                androidx.camera.core.impl.utils.LongRational[] r10 = new androidx.camera.core.impl.utils.LongRational[r10]
                r11 = r5
            L_0x01cf:
                int r13 = r7.length
                if (r11 >= r13) goto L_0x01f6
                r13 = r7[r11]
                java.lang.String[] r13 = r13.split(r9, r12)
                androidx.camera.core.impl.utils.LongRational r14 = new androidx.camera.core.impl.utils.LongRational
                r15 = r13[r5]
                double r0 = java.lang.Double.parseDouble(r15)
                long r0 = (long) r0
                r13 = r13[r8]
                r15 = r9
                double r8 = java.lang.Double.parseDouble(r13)
                long r8 = (long) r8
                r14.<init>(r0, r8)
                r10[r11] = r14
                int r11 = r11 + 1
                r9 = r15
                r0 = 2
                r8 = 1
                r1 = r17
                goto L_0x01cf
            L_0x01f6:
                java.lang.Object r0 = r3.get(r6)
                java.util.Map r0 = (java.util.Map) r0
                r1 = r17
                java.nio.ByteOrder r7 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r7 = androidx.camera.core.impl.utils.ExifAttribute.createSRational((androidx.camera.core.impl.utils.LongRational[]) r10, (java.nio.ByteOrder) r7)
                r0.put(r4, r7)
                goto L_0x022d
            L_0x0208:
                java.lang.String[] r0 = r2.split(r10, r12)
                int r7 = r0.length
                int[] r7 = new int[r7]
                r8 = r5
            L_0x0210:
                int r9 = r0.length
                if (r8 >= r9) goto L_0x021e
                r9 = r0[r8]
                int r9 = java.lang.Integer.parseInt(r9)
                r7[r8] = r9
                int r8 = r8 + 1
                goto L_0x0210
            L_0x021e:
                java.lang.Object r0 = r3.get(r6)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r8 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r7 = androidx.camera.core.impl.utils.ExifAttribute.createSLong((int[]) r7, (java.nio.ByteOrder) r8)
                r0.put(r4, r7)
            L_0x022d:
                r5 = r6
                r15 = 1
                goto L_0x02e8
            L_0x0231:
                r15 = r9
                java.lang.String[] r0 = r2.split(r10, r12)
                int r7 = r0.length
                androidx.camera.core.impl.utils.LongRational[] r7 = new androidx.camera.core.impl.utils.LongRational[r7]
                r8 = r5
            L_0x023a:
                int r9 = r0.length
                if (r8 >= r9) goto L_0x0263
                r9 = r0[r8]
                r10 = r15
                java.lang.String[] r9 = r9.split(r10, r12)
                androidx.camera.core.impl.utils.LongRational r11 = new androidx.camera.core.impl.utils.LongRational
                r13 = r9[r5]
                double r13 = java.lang.Double.parseDouble(r13)
                long r13 = (long) r13
                r15 = 1
                r9 = r9[r15]
                r16 = r6
                double r5 = java.lang.Double.parseDouble(r9)
                long r5 = (long) r5
                r11.<init>(r13, r5)
                r7[r8] = r11
                int r8 = r8 + 1
                r15 = r10
                r6 = r16
                r5 = 0
                goto L_0x023a
            L_0x0263:
                r5 = r6
                r15 = 1
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r6 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createURational((androidx.camera.core.impl.utils.LongRational[]) r7, (java.nio.ByteOrder) r6)
                r0.put(r4, r6)
                goto L_0x02e8
            L_0x0276:
                r5 = r6
                r15 = r8
                java.lang.String[] r0 = r2.split(r10, r12)
                int r6 = r0.length
                long[] r6 = new long[r6]
                r7 = 0
            L_0x0280:
                int r8 = r0.length
                if (r7 >= r8) goto L_0x028e
                r8 = r0[r7]
                long r8 = java.lang.Long.parseLong(r8)
                r6[r7] = r8
                int r7 = r7 + 1
                goto L_0x0280
            L_0x028e:
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r7 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createULong((long[]) r6, (java.nio.ByteOrder) r7)
                r0.put(r4, r6)
                goto L_0x02e8
            L_0x029e:
                r5 = r6
                r15 = r8
                java.lang.String[] r0 = r2.split(r10, r12)
                int r6 = r0.length
                int[] r6 = new int[r6]
                r7 = 0
            L_0x02a8:
                int r8 = r0.length
                if (r7 >= r8) goto L_0x02b6
                r8 = r0[r7]
                int r8 = java.lang.Integer.parseInt(r8)
                r6[r7] = r8
                int r7 = r7 + 1
                goto L_0x02a8
            L_0x02b6:
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r7 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createUShort((int[]) r6, (java.nio.ByteOrder) r7)
                r0.put(r4, r6)
                goto L_0x02e8
            L_0x02c6:
                r5 = r6
                r15 = r8
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createString(r2)
                r0.put(r4, r6)
                goto L_0x02e8
            L_0x02d6:
                r5 = r6
                r15 = r8
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createByte(r2)
                r0.put(r4, r6)
                goto L_0x02e8
            L_0x02e6:
                r5 = r6
                r15 = r8
            L_0x02e8:
                int r6 = r5 + 1
                r8 = r15
                r0 = 2
                r5 = 0
                goto L_0x0126
            L_0x02ef:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.Builder.setAttributeInternal(java.lang.String, java.lang.String, java.util.List):void");
        }

        public ExifData build() {
            ArrayList list = Collections.list(new Enumeration<Map<String, ExifAttribute>>() {
                final Enumeration<Map<String, ExifAttribute>> mMapEnumeration;

                {
                    this.mMapEnumeration = Collections.enumeration(Builder.this.mAttributes);
                }

                public boolean hasMoreElements() {
                    return this.mMapEnumeration.hasMoreElements();
                }

                public Map<String, ExifAttribute> nextElement() {
                    return new HashMap(this.mMapEnumeration.nextElement());
                }
            });
            if (!((Map) list.get(1)).isEmpty()) {
                setAttributeIfMissing(ExifInterface.TAG_EXPOSURE_PROGRAM, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_EXIF_VERSION, "0230", list);
                setAttributeIfMissing(ExifInterface.TAG_COMPONENTS_CONFIGURATION, "1,2,3,0", list);
                setAttributeIfMissing(ExifInterface.TAG_METERING_MODE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_FLASHPIX_VERSION, "0100", list);
                setAttributeIfMissing(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, String.valueOf(2), list);
                setAttributeIfMissing(ExifInterface.TAG_FILE_SOURCE, String.valueOf(3), list);
                setAttributeIfMissing(ExifInterface.TAG_SCENE_TYPE, String.valueOf(1), list);
                setAttributeIfMissing(ExifInterface.TAG_CUSTOM_RENDERED, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SCENE_CAPTURE_TYPE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_CONTRAST, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SATURATION, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SHARPNESS, String.valueOf(0), list);
            }
            if (!((Map) list.get(2)).isEmpty()) {
                setAttributeIfMissing(ExifInterface.TAG_GPS_VERSION_ID, "2300", list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_SPEED_REF, "K", list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, "K", list);
            }
            return new ExifData(this.mByteOrder, list);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:67|68|69) */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            java.lang.Double.parseDouble(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x014a, code lost:
            return new android.util.Pair<>(12, -1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0150, code lost:
            return new android.util.Pair<>(2, -1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x013c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r10) {
            /*
                java.lang.String r0 = ","
                boolean r1 = r10.contains(r0)
                r2 = 0
                r3 = 1
                r4 = 2
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                r6 = -1
                java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
                if (r1 == 0) goto L_0x00a6
                java.lang.String[] r10 = r10.split(r0, r6)
                r0 = r10[r2]
                android.util.Pair r0 = guessDataFormat(r0)
                java.lang.Object r1 = r0.first
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                if (r1 != r4) goto L_0x0029
                return r0
            L_0x0029:
                int r1 = r10.length
                if (r3 >= r1) goto L_0x00a5
                r1 = r10[r3]
                android.util.Pair r1 = guessDataFormat(r1)
                java.lang.Object r2 = r1.first
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.lang.Object r4 = r0.first
                boolean r2 = r2.equals(r4)
                if (r2 != 0) goto L_0x004d
                java.lang.Object r2 = r1.second
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.lang.Object r4 = r0.first
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L_0x004b
                goto L_0x004d
            L_0x004b:
                r2 = r6
                goto L_0x0055
            L_0x004d:
                java.lang.Object r2 = r0.first
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
            L_0x0055:
                java.lang.Object r4 = r0.second
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r4 = r4.intValue()
                if (r4 == r6) goto L_0x0080
                java.lang.Object r4 = r1.first
                java.lang.Integer r4 = (java.lang.Integer) r4
                java.lang.Object r8 = r0.second
                boolean r4 = r4.equals(r8)
                if (r4 != 0) goto L_0x0077
                java.lang.Object r1 = r1.second
                java.lang.Integer r1 = (java.lang.Integer) r1
                java.lang.Object r4 = r0.second
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0080
            L_0x0077:
                java.lang.Object r1 = r0.second
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                goto L_0x0081
            L_0x0080:
                r1 = r6
            L_0x0081:
                if (r2 != r6) goto L_0x008b
                if (r1 != r6) goto L_0x008b
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            L_0x008b:
                if (r2 != r6) goto L_0x0097
                android.util.Pair r0 = new android.util.Pair
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r0.<init>(r1, r7)
                goto L_0x00a2
            L_0x0097:
                if (r1 != r6) goto L_0x00a2
                android.util.Pair r0 = new android.util.Pair
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0.<init>(r1, r7)
            L_0x00a2:
                int r3 = r3 + 1
                goto L_0x0029
            L_0x00a5:
                return r0
            L_0x00a6:
                java.lang.String r0 = "/"
                boolean r1 = r10.contains(r0)
                r8 = 0
                if (r1 == 0) goto L_0x0105
                java.lang.String[] r10 = r10.split(r0, r6)
                int r0 = r10.length
                if (r0 != r4) goto L_0x00ff
                r0 = r10[r2]     // Catch:{ NumberFormatException -> 0x00ff }
                double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
                long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
                r10 = r10[r3]     // Catch:{ NumberFormatException -> 0x00ff }
                double r2 = java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x00ff }
                long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
                int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                r4 = 10
                if (r10 < 0) goto L_0x00f5
                int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r10 >= 0) goto L_0x00d0
                goto L_0x00f5
            L_0x00d0:
                r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
                int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                r0 = 5
                if (r10 > 0) goto L_0x00eb
                int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r10 <= 0) goto L_0x00dd
                goto L_0x00eb
            L_0x00dd:
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
                r10.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
                return r10
            L_0x00eb:
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
                r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
                return r10
            L_0x00f5:
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
                r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
                return r10
            L_0x00ff:
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            L_0x0105:
                long r0 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x013c }
                int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                r3 = 4
                if (r2 < 0) goto L_0x0124
                r8 = 65535(0xffff, double:3.23786E-319)
                int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r0 > 0) goto L_0x0124
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                r1 = 3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x0124:
                if (r2 >= 0) goto L_0x0132
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                r1 = 9
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x0132:
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x013c:
                java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x014b }
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014b }
                r0 = 12
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014b }
                r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x014b }
                return r10
            L_0x014b:
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.Builder.guessDataFormat(java.lang.String):android.util.Pair");
        }
    }

    /* renamed from: androidx.camera.core.impl.utils.ExifData$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState;
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode[] r0 = androidx.camera.core.impl.utils.ExifData.WhiteBalanceMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode = r0
                r1 = 1
                androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode r2 = androidx.camera.core.impl.utils.ExifData.WhiteBalanceMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode r3 = androidx.camera.core.impl.utils.ExifData.WhiteBalanceMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState[] r2 = androidx.camera.core.impl.CameraCaptureMetaData.FlashState.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = r2
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r3 = androidx.camera.core.impl.CameraCaptureMetaData.FlashState.READY     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState     // Catch:{ NoSuchFieldError -> 0x0038 }
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r2 = androidx.camera.core.impl.CameraCaptureMetaData.FlashState.NONE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r1 = androidx.camera.core.impl.CameraCaptureMetaData.FlashState.FIRED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.AnonymousClass1.<clinit>():void");
        }
    }
}
