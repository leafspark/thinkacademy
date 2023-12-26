package com.linkedin.android.litr.render;

import android.media.MediaFormat;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/linkedin/android/litr/render/AudioProcessorFactory;", "", "()V", "createAudioProcessor", "Lcom/linkedin/android/litr/render/AudioProcessor;", "sourceMediaFormat", "Landroid/media/MediaFormat;", "targetMediaFormat", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: AudioProcessorFactory.kt */
public final class AudioProcessorFactory {
    public final AudioProcessor createAudioProcessor(MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        if (mediaFormat == null || mediaFormat2 == null || !mediaFormat.containsKey("sample-rate") || !mediaFormat2.containsKey("sample-rate") || !mediaFormat.containsKey("channel-count") || !mediaFormat2.containsKey("channel-count") || (mediaFormat.getInteger("sample-rate") == mediaFormat2.getInteger("sample-rate") && mediaFormat.getInteger("channel-count") == mediaFormat2.getInteger("channel-count"))) {
            return new PassthroughAudioProcessor();
        }
        return new OboeAudioProcessor(mediaFormat.getInteger("channel-count"), mediaFormat.getInteger("sample-rate"), mediaFormat2.getInteger("channel-count"), mediaFormat2.getInteger("sample-rate"));
    }
}
