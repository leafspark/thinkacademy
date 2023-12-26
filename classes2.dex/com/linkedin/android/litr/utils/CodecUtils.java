package com.linkedin.android.litr.utils;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class CodecUtils {
    private static Map<String, int[]> CODEC_PROFILE_RANK_MAP = new HashMap();
    public static final String MIME_TYPE_VIDEO_AV1 = "video/av01";
    public static final String MIME_TYPE_VIDEO_AVC = "video/avc";
    public static final String MIME_TYPE_VIDEO_HEVC = "video/hevc";
    public static final String MIME_TYPE_VIDEO_VP8 = "video/x-vnd.on2.vp8";
    public static final String MIME_TYPE_VIDEO_VP9 = "video/x-vnd.on2.vp9";
    public static final int UNDEFINED_VALUE = -1;

    static {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        if (Build.VERSION.SDK_INT >= 27) {
            iArr = new int[]{ArrayPool.STANDARD_BUFFER_SIZE_BYTES, 1, 4, 2, 524288, 8, 16, 32, 64};
        } else {
            iArr = new int[]{1, 4, 2, 8, 16, 32, 64};
        }
        CODEC_PROFILE_RANK_MAP.put(MIME_TYPE_VIDEO_AVC, iArr);
        CODEC_PROFILE_RANK_MAP.put(MIME_TYPE_VIDEO_VP8, new int[]{1});
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 29) {
                iArr3 = new int[]{1, 2, CodedOutputStream.DEFAULT_BUFFER_SIZE, 8192};
            } else if (Build.VERSION.SDK_INT >= 24) {
                iArr3 = new int[]{1, 2, CodedOutputStream.DEFAULT_BUFFER_SIZE};
            } else {
                iArr3 = new int[]{1, 2};
            }
            CODEC_PROFILE_RANK_MAP.put(MIME_TYPE_VIDEO_HEVC, iArr3);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (Build.VERSION.SDK_INT >= 29) {
                iArr2 = new int[]{1, 2, 4, CodedOutputStream.DEFAULT_BUFFER_SIZE, 16384, 8, 8192, 32768};
            } else {
                iArr2 = new int[]{1, 2, 4, CodedOutputStream.DEFAULT_BUFFER_SIZE, 8, 8192};
            }
            CODEC_PROFILE_RANK_MAP.put(MIME_TYPE_VIDEO_VP9, iArr2);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            CODEC_PROFILE_RANK_MAP.put(MIME_TYPE_VIDEO_AV1, new int[]{1, 2, CodedOutputStream.DEFAULT_BUFFER_SIZE, 8192});
        }
    }

    private CodecUtils() {
    }

    public static int getHighestSupportedProfile(String str, boolean z) {
        return getHighestSupportedProfile(str, z, -1);
    }

    public static int getHighestSupportedProfile(String str, boolean z, int i) {
        int i2;
        int i3 = -1;
        if (Build.VERSION.SDK_INT >= 21) {
            if (i == -1) {
                i2 = Integer.MAX_VALUE;
            } else {
                i2 = getProfileRank(str, i);
            }
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (supportsType(mediaCodecInfo, str) && mediaCodecInfo.isEncoder() == z) {
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType(str).profileLevels) {
                        if (getProfileRank(str, codecProfileLevel.profile) > getProfileRank(str, i3) && getProfileRank(str, codecProfileLevel.profile) <= i2) {
                            i3 = codecProfileLevel.profile;
                        }
                    }
                }
            }
        }
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.media.MediaCodec getAndConfigureCodec(android.media.MediaFormat r9, android.view.Surface r10, boolean r11, com.linkedin.android.litr.exception.TrackTranscoderException.Error r12, com.linkedin.android.litr.exception.TrackTranscoderException.Error r13, com.linkedin.android.litr.exception.TrackTranscoderException.Error r14) throws com.linkedin.android.litr.exception.TrackTranscoderException {
        /*
            r0 = 21
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
            if (r2 < r0) goto L_0x000c
            android.media.MediaCodec r2 = getAndConfigureCodecByConfig(r9, r10, r11)     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
            goto L_0x0010
        L_0x000c:
            android.media.MediaCodec r2 = getAndConfigureCodecByType(r9, r10, r11)     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
        L_0x0010:
            if (r2 != 0) goto L_0x0024
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
            if (r2 < r0) goto L_0x001e
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
            java.lang.String r3 = "Try fallbackToGetCodecByType"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
            throw r2     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
        L_0x001e:
            com.linkedin.android.litr.exception.TrackTranscoderException r2 = new com.linkedin.android.litr.exception.TrackTranscoderException     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
            r2.<init>(r12, r9, r1, r1)     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
            throw r2     // Catch:{ IOException -> 0x0027, IllegalStateException -> 0x0025 }
        L_0x0024:
            return r2
        L_0x0025:
            r2 = move-exception
            goto L_0x0028
        L_0x0027:
            r2 = move-exception
        L_0x0028:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r0) goto L_0x003d
            android.media.MediaCodec r10 = getAndConfigureCodecByType(r9, r10, r11)     // Catch:{ IOException -> 0x003b, IllegalStateException -> 0x0039 }
            if (r10 == 0) goto L_0x0033
            return r10
        L_0x0033:
            com.linkedin.android.litr.exception.TrackTranscoderException r10 = new com.linkedin.android.litr.exception.TrackTranscoderException     // Catch:{ IOException -> 0x003b, IllegalStateException -> 0x0039 }
            r10.<init>(r12, r9, r1, r1)     // Catch:{ IOException -> 0x003b, IllegalStateException -> 0x0039 }
            throw r10     // Catch:{ IOException -> 0x003b, IllegalStateException -> 0x0039 }
        L_0x0039:
            r10 = move-exception
            goto L_0x003c
        L_0x003b:
            r10 = move-exception
        L_0x003c:
            r2 = r10
        L_0x003d:
            r8 = r2
            boolean r10 = r8 instanceof java.io.IOException
            if (r10 == 0) goto L_0x004d
            com.linkedin.android.litr.exception.TrackTranscoderException r10 = new com.linkedin.android.litr.exception.TrackTranscoderException
            r6 = 0
            r7 = 0
            r3 = r10
            r4 = r13
            r5 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            throw r10
        L_0x004d:
            com.linkedin.android.litr.exception.TrackTranscoderException r10 = new com.linkedin.android.litr.exception.TrackTranscoderException
            r6 = 0
            r7 = 0
            r3 = r10
            r4 = r14
            r5 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linkedin.android.litr.utils.CodecUtils.getAndConfigureCodec(android.media.MediaFormat, android.view.Surface, boolean, com.linkedin.android.litr.exception.TrackTranscoderException$Error, com.linkedin.android.litr.exception.TrackTranscoderException$Error, com.linkedin.android.litr.exception.TrackTranscoderException$Error):android.media.MediaCodec");
    }

    private static MediaCodec getAndConfigureCodecByType(MediaFormat mediaFormat, Surface surface, boolean z) throws IOException, IllegalStateException {
        List<Callable<MediaCodec>> findCodecForFormatOrType = findCodecForFormatOrType(z, mediaFormat.getString("mime"), (MediaFormat) null);
        if (!findCodecForFormatOrType.isEmpty()) {
            return createAndConfigureCodec(mediaFormat, surface, z, findCodecForFormatOrType);
        }
        return null;
    }

    private static MediaCodec getAndConfigureCodecByConfig(MediaFormat mediaFormat, Surface surface, boolean z) throws IOException, IllegalStateException {
        List<Callable<MediaCodec>> findCodecForFormatOrType = findCodecForFormatOrType(z, mediaFormat.getString("mime"), mediaFormat);
        if (!findCodecForFormatOrType.isEmpty()) {
            return createAndConfigureCodec(mediaFormat, surface, z, findCodecForFormatOrType);
        }
        return null;
    }

    private static MediaCodec createAndConfigureCodec(MediaFormat mediaFormat, Surface surface, boolean z, List<Callable<MediaCodec>> list) throws IllegalStateException, IOException {
        MediaCodec mediaCodec;
        Exception e;
        Iterator<Callable<MediaCodec>> it = list.iterator();
        MediaCodec mediaCodec2 = null;
        IOException iOException = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            try {
                mediaCodec = (MediaCodec) it.next().call();
                if (mediaCodec != null) {
                    try {
                        configureMediaFormat(mediaCodec, mediaFormat, surface, z);
                        mediaCodec2 = mediaCodec;
                        break;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    continue;
                    mediaCodec2 = mediaCodec;
                }
            } catch (Exception e3) {
                Exception exc = e3;
                mediaCodec = mediaCodec2;
                e = exc;
                if (mediaCodec != null) {
                    mediaCodec.release();
                    mediaCodec = null;
                }
                if (e instanceof IOException) {
                    iOException = (IOException) e;
                }
                mediaCodec2 = mediaCodec;
            }
        }
        if (mediaCodec2 != null) {
            return mediaCodec2;
        }
        if (iOException != null) {
            throw iOException;
        }
        throw new IllegalStateException();
    }

    private static void configureMediaFormat(MediaCodec mediaCodec, MediaFormat mediaFormat, Surface surface, boolean z) throws IllegalStateException {
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, z ? 1 : 0);
    }

    private static List<Callable<MediaCodec>> findCodecForFormatOrType(boolean z, String str, MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (mediaCodecInfo.isEncoder() == z) {
                    try {
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                        if (capabilitiesForType != null && (mediaFormat == null || capabilitiesForType.isFormatSupported(mediaFormat))) {
                            arrayList.add(new CodecUtils$$ExternalSyntheticLambda0(mediaCodecInfo));
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                }
            }
        } else {
            arrayList.add(new CodecUtils$$ExternalSyntheticLambda1(z, str));
        }
        return arrayList;
    }

    static /* synthetic */ MediaCodec lambda$findCodecForFormatOrType$1(boolean z, String str) throws Exception {
        if (z) {
            return MediaCodec.createEncoderByType(str);
        }
        return MediaCodec.createDecoderByType(str);
    }

    private static boolean supportsType(MediaCodecInfo mediaCodecInfo, String str) {
        for (String equals : mediaCodecInfo.getSupportedTypes()) {
            if (TextUtils.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    private static int getProfileRank(String str, int i) {
        int[] iArr;
        if (i == -1 || (iArr = CODEC_PROFILE_RANK_MAP.get(str)) == null) {
            return -1;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }
}
