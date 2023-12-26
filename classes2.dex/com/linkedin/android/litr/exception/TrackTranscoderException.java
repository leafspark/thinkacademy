package com.linkedin.android.litr.exception;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;

public class TrackTranscoderException extends MediaTransformationException {
    private static final String CODEC_IN_RELEASED_STATE_ERROR_TEXT = "Codecs are in released state.";
    private static final String DECODER_CONFIGURATION_ERROR_TEXT = "Failed to configure decoder codec.";
    private static final String DECODER_FORMAT_NOT_FOUND_ERROR_TEXT = "Failed to create decoder codec.";
    private static final String DECODER_NOT_FOUND_ERROR_TEXT = "No decoder found.";
    private static final String DECODER_NOT_PROVIDED_TEXT = "Decoder is not provided";
    private static final String ENCODER_CONFIGURATION_ERROR_TEXT = "Failed to configure encoder codec.";
    private static final String ENCODER_FORMAT_NOT_FOUND_ERROR_TEXT = "Failed to create encoder codec.";
    private static final String ENCODER_NOT_FOUND_ERROR_TEXT = "No encoder found.";
    private static final String ENCODER_NOT_PROVIDED_TEXT = "Encoder is not provided";
    private static final String INTERNAL_CODEC_ERROR_TEXT = "Internal codec error occurred.";
    private static final String NO_FRAME_AVAILABLE_ERROR_TEXT = "No frame available for specified tag";
    private static final String NO_TRACKS_FOUND_ERROR_TEXT = "No tracks found.";
    private static final String RENDERER_NOT_PROVIDED_TEXT = "Renderer is not provided";
    private static final String SOURCE_TRACK_MIME_TYPE_NOT_FOUND_ERROR_TEXT = "Mime type not found for the source track.";
    private static final String TAG = "com.linkedin.android.litr.exception.TrackTranscoderException";
    private final Error error;
    private final MediaCodec mediaCodec;
    private final MediaCodecList mediaCodecList;
    private final MediaFormat mediaFormat;

    public enum Error {
        DECODER_FORMAT_NOT_FOUND(TrackTranscoderException.DECODER_FORMAT_NOT_FOUND_ERROR_TEXT),
        DECODER_CONFIGURATION_ERROR(TrackTranscoderException.DECODER_CONFIGURATION_ERROR_TEXT),
        ENCODER_FORMAT_NOT_FOUND(TrackTranscoderException.ENCODER_FORMAT_NOT_FOUND_ERROR_TEXT),
        ENCODER_CONFIGURATION_ERROR(TrackTranscoderException.ENCODER_CONFIGURATION_ERROR_TEXT),
        DECODER_NOT_FOUND(TrackTranscoderException.DECODER_NOT_FOUND_ERROR_TEXT),
        ENCODER_NOT_FOUND(TrackTranscoderException.ENCODER_NOT_FOUND_ERROR_TEXT),
        CODEC_IN_RELEASED_STATE(TrackTranscoderException.CODEC_IN_RELEASED_STATE_ERROR_TEXT),
        SOURCE_TRACK_MIME_TYPE_NOT_FOUND(TrackTranscoderException.SOURCE_TRACK_MIME_TYPE_NOT_FOUND_ERROR_TEXT),
        NO_TRACKS_FOUND(TrackTranscoderException.NO_TRACKS_FOUND_ERROR_TEXT),
        INTERNAL_CODEC_ERROR(TrackTranscoderException.INTERNAL_CODEC_ERROR_TEXT),
        NO_FRAME_AVAILABLE(TrackTranscoderException.NO_FRAME_AVAILABLE_ERROR_TEXT),
        DECODER_NOT_PROVIDED(TrackTranscoderException.DECODER_NOT_PROVIDED_TEXT),
        ENCODER_NOT_PROVIDED(TrackTranscoderException.ENCODER_NOT_PROVIDED_TEXT),
        RENDERER_NOT_PROVIDED(TrackTranscoderException.RENDERER_NOT_PROVIDED_TEXT);
        
        /* access modifiers changed from: private */
        public final String message;

        private Error(String str) {
            this.message = str;
        }
    }

    public TrackTranscoderException(Error error2) {
        this(error2, (MediaFormat) null, (MediaCodec) null, (MediaCodecList) null);
    }

    public TrackTranscoderException(Error error2, Throwable th) {
        this(error2, (MediaFormat) null, (MediaCodec) null, (MediaCodecList) null, th);
    }

    public TrackTranscoderException(Error error2, MediaFormat mediaFormat2, MediaCodec mediaCodec2, MediaCodecList mediaCodecList2) {
        this(error2, mediaFormat2, mediaCodec2, mediaCodecList2, (Throwable) null);
    }

    public TrackTranscoderException(Error error2, MediaFormat mediaFormat2, MediaCodec mediaCodec2, MediaCodecList mediaCodecList2, Throwable th) {
        super(th);
        this.error = error2;
        this.mediaFormat = mediaFormat2;
        this.mediaCodec = mediaCodec2;
        this.mediaCodecList = mediaCodecList2;
    }

    public Error getError() {
        return this.error;
    }

    public String getMessage() {
        return this.error.message;
    }

    public String toString() {
        String str = super.toString() + 10;
        if (this.mediaFormat != null) {
            str = str + "Media format: " + this.mediaFormat.toString() + 10;
        }
        if (this.mediaCodec != null) {
            str = str + "Selected media codec info: " + convertMediaCodecInfoToString(this.mediaCodec) + 10;
        }
        if (this.mediaCodecList != null) {
            str = str + "Available media codec info list (Name, IsEncoder, Supported Types): " + convertMediaCodecListToString(this.mediaCodecList);
        }
        if (Build.VERSION.SDK_INT < 21 || getCause() == null) {
            return str;
        }
        return str + "Diagnostic info: " + getExceptionDiagnosticInfo(getCause());
    }

    private String convertMediaCodecListToString(MediaCodecList mediaCodecList2) {
        StringBuilder sb = new StringBuilder();
        try {
            if (Build.VERSION.SDK_INT > 21) {
                for (MediaCodecInfo mediaCodecInfo : mediaCodecList2.getCodecInfos()) {
                    if (mediaCodecInfo != null) {
                        sb.append(10);
                        sb.append(convertMediaCodecInfoToString(mediaCodecInfo));
                    }
                }
            } else {
                Log.e(TAG, "Failed to retrieve media codec info below API level 21.");
            }
        } catch (IllegalStateException e) {
            Log.e(TAG, "Failed to retrieve media codec info.", e);
        }
        return sb.toString();
    }

    private String convertMediaCodecInfoToString(MediaCodec mediaCodec2) {
        try {
            return convertMediaCodecInfoToString(mediaCodec2.getCodecInfo());
        } catch (IllegalStateException unused) {
            Log.e(TAG, "Failed to retrieve media codec info.");
            return "";
        }
    }

    private String convertMediaCodecInfoToString(MediaCodecInfo mediaCodecInfo) {
        return "MediaCodecInfo: " + mediaCodecInfo.getName() + ',' + mediaCodecInfo.isEncoder() + ',' + Arrays.asList(mediaCodecInfo.getSupportedTypes()).toString();
    }

    private String getExceptionDiagnosticInfo(Throwable th) {
        if (!(th instanceof MediaCodec.CodecException)) {
            return null;
        }
        return ((MediaCodec.CodecException) th).getDiagnosticInfo();
    }
}
