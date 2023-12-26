package com.linkedin.android.litr.transcoder;

import android.media.MediaCodec;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Log;
import com.linkedin.android.litr.codec.Decoder;
import com.linkedin.android.litr.codec.Encoder;
import com.linkedin.android.litr.exception.TrackTranscoderException;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.linkedin.android.litr.render.AudioRenderer;
import com.linkedin.android.litr.render.Renderer;
import com.luck.picture.lib.config.PictureMimeType;

public class TrackTranscoderFactory {
    private static final String TAG = "TrackTranscoderFactory";

    public TrackTranscoder create(int i, int i2, MediaSource mediaSource, Decoder decoder, Renderer renderer, Encoder encoder, MediaTarget mediaTarget, MediaFormat mediaFormat) throws TrackTranscoderException {
        int i3 = i;
        int i4 = i2;
        MediaSource mediaSource2 = mediaSource;
        Encoder encoder2 = encoder;
        MediaTarget mediaTarget2 = mediaTarget;
        MediaFormat mediaFormat2 = mediaFormat;
        if (mediaFormat2 == null) {
            return new PassthroughTranscoder(mediaSource, i, mediaTarget2, i2);
        }
        String string = mediaFormat2.getString("mime");
        if (string != null) {
            if (string.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO) || string.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO)) {
                if (decoder == null) {
                    throw new TrackTranscoderException(TrackTranscoderException.Error.DECODER_NOT_PROVIDED, mediaFormat2, (MediaCodec) null, (MediaCodecList) null);
                } else if (encoder2 == null) {
                    throw new TrackTranscoderException(TrackTranscoderException.Error.ENCODER_NOT_PROVIDED, mediaFormat2, (MediaCodec) null, (MediaCodecList) null);
                }
            }
            if (string.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO)) {
                if (renderer != null) {
                    return new VideoTrackTranscoder(mediaSource, i, mediaTarget, i2, mediaFormat, renderer, decoder, encoder);
                }
                throw new TrackTranscoderException(TrackTranscoderException.Error.RENDERER_NOT_PROVIDED, mediaFormat2, (MediaCodec) null, (MediaCodecList) null);
            } else if (string.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO)) {
                return new AudioTrackTranscoder(mediaSource, i, mediaTarget, i2, mediaFormat, renderer == null ? new AudioRenderer(encoder2) : renderer, decoder, encoder);
            } else {
                String str = TAG;
                Log.i(str, "Unsupported track mime type: " + string + ", will use passthrough transcoder");
                return new PassthroughTranscoder(mediaSource, i, mediaTarget2, i2);
            }
        } else {
            throw new TrackTranscoderException(TrackTranscoderException.Error.SOURCE_TRACK_MIME_TYPE_NOT_FOUND, mediaFormat2, (MediaCodec) null, (MediaCodecList) null);
        }
    }
}
