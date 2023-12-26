package com.linkedin.android.litr.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaFormat;
import android.net.Uri;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.linkedin.android.litr.TrackTransform;
import com.linkedin.android.litr.io.MediaRange;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class TranscoderUtils {
    private static final int BITS_IN_BYTE = 8;
    private static final int BITS_IN_KILO = 1000;
    static final int COMMON_AUDIO_BITRATE_KBPS = 320;
    private static final String TAG = "TranscoderUtils";

    private TranscoderUtils() {
    }

    public static long getEstimatedTargetFileSize(List<TrackTransform> list) {
        long j = 0;
        for (TrackTransform duration : list) {
            j = Math.max(getDuration(duration), j);
        }
        float f = 0.0f;
        for (TrackTransform next : list) {
            MediaFormat trackFormat = next.getMediaSource().getTrackFormat(next.getSourceTrack());
            int bitrate = getBitrate(trackFormat);
            long duration2 = getDuration(next);
            if (duration2 < 0) {
                Log.d(TAG, "Track duration is not available, using maximum duration");
                duration2 = j;
            }
            String mimeType = getMimeType(trackFormat);
            if (mimeType != null) {
                if (next.getTargetFormat() != null) {
                    bitrate = next.getTargetFormat().getInteger("bitrate");
                } else if (mimeType.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO) && bitrate < 0) {
                    bitrate = 320000;
                }
            }
            if (bitrate < 0) {
                Log.d(TAG, "Bitrate is not available, cannot use that track to estimate size");
                bitrate = 0;
            }
            f += ((float) bitrate) * TimeUtils.microsToSeconds(duration2);
        }
        return (long) (f / 8.0f);
    }

    public static long getEstimatedTargetVideoFileSize(MediaSource mediaSource, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        ArrayList arrayList = new ArrayList(mediaSource.getTrackCount());
        for (int i = 0; i < mediaSource.getTrackCount(); i++) {
            MediaFormat trackFormat = mediaSource.getTrackFormat(i);
            TrackTransform.Builder builder = new TrackTransform.Builder(mediaSource, i, (MediaTarget) null);
            if (trackFormat.containsKey("mime")) {
                String string = trackFormat.getString("mime");
                if (string.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO)) {
                    builder.setTargetFormat(mediaFormat);
                } else if (string.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO)) {
                    builder.setTargetFormat(mediaFormat2);
                }
            }
            arrayList.add(builder.build());
        }
        return getEstimatedTargetFileSize(arrayList);
    }

    public static int estimateVideoTrackBitrate(MediaSource mediaSource, int i) {
        MediaFormat trackFormat = mediaSource.getTrackFormat(i);
        if (trackFormat.containsKey("bitrate")) {
            return trackFormat.getInteger("bitrate");
        }
        float microsToSeconds = TimeUtils.microsToSeconds(trackFormat.getLong("durationUs"));
        if (microsToSeconds == 0.0f) {
            return 0;
        }
        float size = (float) mediaSource.getSize();
        int trackCount = mediaSource.getTrackCount();
        float f = 0.0f;
        for (int i2 = 0; i2 < trackCount; i2++) {
            MediaFormat trackFormat2 = mediaSource.getTrackFormat(i2);
            if (trackFormat2.containsKey("mime")) {
                if (trackFormat2.containsKey("bitrate") && trackFormat2.containsKey("durationUs")) {
                    size -= (((float) trackFormat2.getInteger("bitrate")) * TimeUtils.microsToSeconds(trackFormat2.getLong("durationUs"))) / 8.0f;
                } else if (trackFormat2.getString("mime").startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO)) {
                    f += ((float) (trackFormat2.getInteger("width") * trackFormat2.getInteger("height"))) * TimeUtils.microsToSeconds(trackFormat2.getLong("durationUs"));
                }
            }
        }
        float integer = ((float) (trackFormat.getInteger("width") * trackFormat.getInteger("height"))) * microsToSeconds;
        if (f > 0.0f) {
            size = (size * integer) / f;
        }
        return (int) ((size * 8.0f) / microsToSeconds);
    }

    public static long getSize(Context context, Uri uri) {
        long j = -1;
        if (FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme())) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
                long statSize = openAssetFileDescriptor != null ? openAssetFileDescriptor.getParcelFileDescriptor().getStatSize() : 0;
                if (statSize >= 0) {
                    j = statSize;
                }
                if (openAssetFileDescriptor != null) {
                    try {
                        openAssetFileDescriptor.close();
                    } catch (IOException e) {
                        String str = TAG;
                        Log.e(str, "Unable to close file descriptor from targetFile: " + uri, e);
                    }
                }
                return j;
            } catch (FileNotFoundException | IllegalStateException e2) {
                String str2 = TAG;
                Log.e(str2, "Unable to extract length from targetFile: " + uri, e2);
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e3) {
                        String str3 = TAG;
                        Log.e(str3, "Unable to close file descriptor from targetFile: " + uri, e3);
                    }
                }
                return -1;
            } catch (Throwable th) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e4) {
                        String str4 = TAG;
                        Log.e(str4, "Unable to close file descriptor from targetFile: " + uri, e4);
                    }
                }
                throw th;
            }
        } else if (!"file".equals(uri.getScheme()) || uri.getPath() == null) {
            return -1;
        } else {
            return new File(uri.getPath()).length();
        }
    }

    private static String getMimeType(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("mime")) {
            return mediaFormat.getString("mime");
        }
        return null;
    }

    private static int getBitrate(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("bitrate")) {
            return mediaFormat.getInteger("bitrate");
        }
        return -1;
    }

    private static long getDuration(TrackTransform trackTransform) {
        MediaFormat trackFormat = trackTransform.getMediaSource().getTrackFormat(trackTransform.getSourceTrack());
        if (!trackFormat.containsKey("durationUs")) {
            return -1;
        }
        long j = trackFormat.getLong("durationUs");
        MediaRange selection = trackTransform.getMediaSource().getSelection();
        return Math.min(j, selection.getEnd()) - Math.max(0, selection.getStart());
    }
}
