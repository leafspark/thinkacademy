package tv.danmaku.ijk.media.psplayer.misc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.psplayer.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.psplayer.IjkMediaMeta;

public class IjkMediaFormat implements IMediaFormat {
    public static final String CODEC_NAME_H264 = "h264";
    public static final String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
    public static final String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
    public static final String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
    public static final String KEY_IJK_CODEC_NAME_UI = "ijk-codec-name-ui";
    public static final String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
    public static final String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
    public static final String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
    public static final String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
    public static final String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
    private static final Map<String, Formatter> sFormatterMap = new HashMap();
    public final IjkMediaMeta.IjkStreamMeta mMediaFormat;

    public IjkMediaFormat(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        Map<String, Formatter> map = sFormatterMap;
        map.put(KEY_IJK_CODEC_LONG_NAME_UI, new Formatter() {
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                return IjkMediaFormat.this.mMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_LONG_NAME);
            }
        });
        map.put(KEY_IJK_CODEC_NAME_UI, new Formatter() {
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                return IjkMediaFormat.this.mMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_NAME);
            }
        });
        map.put(KEY_IJK_BIT_RATE_UI, new Formatter() {
            /* access modifiers changed from: protected */
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_BITRATE);
                if (integer <= 0) {
                    return null;
                }
                if (integer < 1000) {
                    return String.format(Locale.US, "%d bit/s", new Object[]{Integer.valueOf(integer)});
                }
                return String.format(Locale.US, "%d kb/s", new Object[]{Integer.valueOf(integer / IjkMediaCodecInfo.RANK_MAX)});
            }
        });
        map.put(KEY_IJK_CODEC_PROFILE_LEVEL_UI, new Formatter() {
            /* access modifiers changed from: protected */
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                String str;
                switch (ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_CODEC_PROFILE_ID)) {
                    case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444:
                        str = "CAVLC 4:4:4";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_BASELINE:
                        str = "Baseline";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_MAIN:
                        str = "Main";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_EXTENDED:
                        str = "Extended";
                        break;
                    case 100:
                        str = "High";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_10:
                        str = "High 10";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_422:
                        str = "High 4:2:2";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444:
                        str = "High 4:4:4";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE:
                        str = "High 4:4:4 Predictive";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE:
                        str = "Constrained Baseline";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_10_INTRA:
                        str = "High 10 Intra";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_422_INTRA:
                        str = "High 4:2:2 Intra";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_INTRA:
                        str = "High 4:4:4 Intra";
                        break;
                    default:
                        return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                String string = ijkMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_NAME);
                if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase(IjkMediaFormat.CODEC_NAME_H264)) {
                    int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_CODEC_LEVEL);
                    if (integer < 10) {
                        return sb.toString();
                    }
                    sb.append(" Profile Level ");
                    sb.append((integer / 10) % 10);
                    int i = integer % 10;
                    if (i != 0) {
                        sb.append(".");
                        sb.append(i);
                    }
                }
                return sb.toString();
            }
        });
        map.put(KEY_IJK_CODEC_PIXEL_FORMAT_UI, new Formatter() {
            /* access modifiers changed from: protected */
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                return ijkMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_PIXEL_FORMAT);
            }
        });
        map.put(KEY_IJK_RESOLUTION_UI, new Formatter() {
            /* access modifiers changed from: protected */
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger("width");
                int integer2 = ijkMediaFormat.getInteger("height");
                int integer3 = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAR_NUM);
                int integer4 = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAR_DEN);
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                if (integer3 <= 0 || integer4 <= 0) {
                    return String.format(Locale.US, "%d x %d", new Object[]{Integer.valueOf(integer), Integer.valueOf(integer2)});
                }
                return String.format(Locale.US, "%d x %d [SAR %d:%d]", new Object[]{Integer.valueOf(integer), Integer.valueOf(integer2), Integer.valueOf(integer3), Integer.valueOf(integer4)});
            }
        });
        map.put(KEY_IJK_FRAME_RATE_UI, new Formatter() {
            /* access modifiers changed from: protected */
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_FPS_NUM);
                int integer2 = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_FPS_DEN);
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                return String.valueOf(((float) integer) / ((float) integer2));
            }
        });
        map.put(KEY_IJK_SAMPLE_RATE_UI, new Formatter() {
            /* access modifiers changed from: protected */
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
                if (integer <= 0) {
                    return null;
                }
                return String.format(Locale.US, "%d Hz", new Object[]{Integer.valueOf(integer)});
            }
        });
        map.put(KEY_IJK_CHANNEL_UI, new Formatter() {
            /* access modifiers changed from: protected */
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_CHANNEL_LAYOUT);
                if (integer <= 0) {
                    return null;
                }
                long j = (long) integer;
                if (j == 4) {
                    return "mono";
                }
                if (j == 3) {
                    return "stereo";
                }
                return String.format(Locale.US, "%x", new Object[]{Integer.valueOf(integer)});
            }
        });
        this.mMediaFormat = ijkStreamMeta;
    }

    public int getInteger(String str) {
        IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mMediaFormat;
        if (ijkStreamMeta == null) {
            return 0;
        }
        return ijkStreamMeta.getInt(str);
    }

    public String getString(String str) {
        if (this.mMediaFormat == null) {
            return null;
        }
        Map<String, Formatter> map = sFormatterMap;
        if (map.containsKey(str)) {
            return map.get(str).format(this);
        }
        return this.mMediaFormat.getString(str);
    }

    private static abstract class Formatter {
        /* access modifiers changed from: protected */
        public abstract String doFormat(IjkMediaFormat ijkMediaFormat);

        /* access modifiers changed from: protected */
        public String getDefaultString() {
            return "N/A";
        }

        private Formatter() {
        }

        public String format(IjkMediaFormat ijkMediaFormat) {
            String doFormat = doFormat(ijkMediaFormat);
            return TextUtils.isEmpty(doFormat) ? getDefaultString() : doFormat;
        }
    }
}
