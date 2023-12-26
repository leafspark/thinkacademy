package com.linkedin.android.litr;

import android.content.Context;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Looper;
import com.linkedin.android.litr.TrackTransform;
import com.linkedin.android.litr.exception.MediaSourceException;
import com.linkedin.android.litr.io.MediaExtractorMediaSource;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.utils.TranscoderUtils;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MediaTransformer {
    private static final int DEFAULT_AUDIO_BITRATE = 256000;
    private static final int DEFAULT_FUTURE_MAP_SIZE = 10;
    public static final int DEFAULT_KEY_FRAME_INTERVAL = 5;
    public static final int GRANULARITY_DEFAULT = 100;
    public static final int GRANULARITY_NONE = 0;
    private static final String TAG = "MediaTransformer";
    private final Context context;
    private final ExecutorService executorService;
    private final Map<String, Future<?>> futureMap;
    private final Looper looper;

    public MediaTransformer(Context context2) {
        this(context2, Looper.getMainLooper(), Executors.newSingleThreadExecutor());
    }

    public MediaTransformer(Context context2, Looper looper2, ExecutorService executorService2) {
        this.context = context2.getApplicationContext();
        this.futureMap = new HashMap(10);
        this.looper = looper2;
        this.executorService = executorService2;
    }

    public void transform(String str, Uri uri, String str2, MediaFormat mediaFormat, MediaFormat mediaFormat2, TransformationListener transformationListener, TransformationOptions transformationOptions) {
        String str3 = str2;
        transform(str, uri, Uri.fromFile(new File(str2)), mediaFormat, mediaFormat2, transformationListener, transformationOptions);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a A[Catch:{ MediaSourceException | MediaTargetException -> 0x012c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void transform(java.lang.String r19, android.net.Uri r20, android.net.Uri r21, android.media.MediaFormat r22, android.media.MediaFormat r23, com.linkedin.android.litr.TransformationListener r24, com.linkedin.android.litr.TransformationOptions r25) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r22
            r3 = r24
            if (r25 != 0) goto L_0x0014
            com.linkedin.android.litr.TransformationOptions$Builder r4 = new com.linkedin.android.litr.TransformationOptions$Builder
            r4.<init>()
            com.linkedin.android.litr.TransformationOptions r4 = r4.build()
            goto L_0x0016
        L_0x0014:
            r4 = r25
        L_0x0016:
            com.linkedin.android.litr.io.MediaExtractorMediaSource r6 = new com.linkedin.android.litr.io.MediaExtractorMediaSource     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            android.content.Context r7 = r1.context     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.io.MediaRange r8 = r4.sourceMediaRange     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r9 = r20
            r6.<init>(r7, r9, r8)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r8 = 1
            r10 = 21
            java.lang.String r11 = "mime"
            if (r7 < r10) goto L_0x004c
            if (r0 == 0) goto L_0x004c
            boolean r7 = r0.containsKey(r11)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            if (r7 == 0) goto L_0x004c
            java.lang.String r7 = r0.getString(r11)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            java.lang.String r12 = "video/x-vnd.on2.vp9"
            boolean r7 = android.text.TextUtils.equals(r7, r12)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            if (r7 != 0) goto L_0x004a
            java.lang.String r7 = r0.getString(r11)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            java.lang.String r12 = "video/x-vnd.on2.vp8"
            boolean r7 = android.text.TextUtils.equals(r7, r12)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            if (r7 == 0) goto L_0x004c
        L_0x004a:
            r7 = r8
            goto L_0x004d
        L_0x004c:
            r7 = 0
        L_0x004d:
            com.linkedin.android.litr.io.MediaMuxerMediaTarget r15 = new com.linkedin.android.litr.io.MediaMuxerMediaTarget     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            android.content.Context r13 = r1.context     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            int r16 = r6.getTrackCount()     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            int r17 = r6.getOrientationHint()     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            if (r12 < r10) goto L_0x0060
            if (r7 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r8 = 0
        L_0x0061:
            r12 = r15
            r14 = r21
            r9 = r15
            r15 = r16
            r16 = r17
            r17 = r8
            r12.<init>(r13, r14, r15, r16, r17)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            int r8 = r6.getTrackCount()     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r12.<init>(r8)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r13 = 0
        L_0x0078:
            if (r13 >= r8) goto L_0x0126
            android.media.MediaFormat r14 = r6.getTrackFormat(r13)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            boolean r15 = r14.containsKey(r11)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            if (r15 == 0) goto L_0x0089
            java.lang.String r15 = r14.getString(r11)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            goto L_0x008a
        L_0x0089:
            r15 = 0
        L_0x008a:
            if (r15 != 0) goto L_0x00aa
            java.lang.String r14 = TAG     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r15.<init>()     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            java.lang.String r5 = "Mime type is null for track "
            r15.append(r5)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r15.append(r13)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            java.lang.String r5 = r15.toString()     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            android.util.Log.e(r14, r5)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r15 = r23
            r16 = r6
            r21 = r8
            goto L_0x011e
        L_0x00aa:
            com.linkedin.android.litr.codec.MediaCodecDecoder r5 = new com.linkedin.android.litr.codec.MediaCodecDecoder     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r5.<init>()     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.codec.MediaCodecEncoder r10 = new com.linkedin.android.litr.codec.MediaCodecEncoder     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r10.<init>()     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r21 = r8
            com.linkedin.android.litr.TrackTransform$Builder r8 = new com.linkedin.android.litr.TrackTransform$Builder     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r8.<init>(r6, r13, r9)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.TrackTransform$Builder r8 = r8.setTargetTrack(r13)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r16 = r6
            java.lang.String r6 = "video"
            boolean r6 = r15.startsWith(r6)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            if (r6 == 0) goto L_0x00e0
            com.linkedin.android.litr.TrackTransform$Builder r5 = r8.setDecoder(r5)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.render.GlVideoRenderer r6 = new com.linkedin.android.litr.render.GlVideoRenderer     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            java.util.List<com.linkedin.android.litr.filter.GlFilter> r14 = r4.videoFilters     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r6.<init>(r14)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.TrackTransform$Builder r5 = r5.setRenderer(r6)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.TrackTransform$Builder r5 = r5.setEncoder(r10)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r5.setTargetFormat(r0)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            goto L_0x0113
        L_0x00e0:
            java.lang.String r6 = "audio"
            boolean r6 = r15.startsWith(r6)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            if (r6 == 0) goto L_0x0113
            com.linkedin.android.litr.TrackTransform$Builder r5 = r8.setDecoder(r5)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.TrackTransform$Builder r5 = r5.setEncoder(r10)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.render.AudioRenderer r6 = new com.linkedin.android.litr.render.AudioRenderer     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            java.util.List<com.linkedin.android.litr.filter.BufferFilter> r15 = r4.audioFilters     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r6.<init>(r10, r15)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            com.linkedin.android.litr.TrackTransform$Builder r5 = r5.setRenderer(r6)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r10 = 21
            if (r6 < r10) goto L_0x0108
            if (r7 == 0) goto L_0x0108
            java.lang.String r6 = "audio/opus"
            r15 = r23
            goto L_0x010b
        L_0x0108:
            r15 = r23
            r6 = 0
        L_0x010b:
            android.media.MediaFormat r6 = r1.createTargetAudioFormat(r14, r15, r6)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r5.setTargetFormat(r6)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            goto L_0x0117
        L_0x0113:
            r15 = r23
            r10 = 21
        L_0x0117:
            com.linkedin.android.litr.TrackTransform r5 = r8.build()     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r12.add(r5)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
        L_0x011e:
            int r13 = r13 + 1
            r8 = r21
            r6 = r16
            goto L_0x0078
        L_0x0126:
            int r0 = r4.granularity     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            r1.transform(r2, r12, r3, r0)     // Catch:{ MediaSourceException -> 0x012e, MediaTargetException -> 0x012c }
            goto L_0x0133
        L_0x012c:
            r0 = move-exception
            goto L_0x012f
        L_0x012e:
            r0 = move-exception
        L_0x012f:
            r4 = 0
            r3.onError(r2, r0, r4)
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linkedin.android.litr.MediaTransformer.transform(java.lang.String, android.net.Uri, android.net.Uri, android.media.MediaFormat, android.media.MediaFormat, com.linkedin.android.litr.TransformationListener, com.linkedin.android.litr.TransformationOptions):void");
    }

    public void transform(String str, List<TrackTransform> list, TransformationListener transformationListener, int i) {
        if (!this.futureMap.containsKey(str)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                TrackTransform trackTransform = list.get(i2);
                if (trackTransform.getTargetFormat() == null && trackTransform.getRenderer() != null && trackTransform.getRenderer().hasFilters()) {
                    list.set(i2, new TrackTransform.Builder(trackTransform.getMediaSource(), trackTransform.getSourceTrack(), trackTransform.getMediaTarget()).setTargetTrack(trackTransform.getTargetTrack()).setDecoder(trackTransform.getDecoder()).setEncoder(trackTransform.getEncoder()).setRenderer(trackTransform.getRenderer()).setTargetFormat(createTargetMediaFormat(trackTransform.getMediaSource(), trackTransform.getSourceTrack())).build());
                }
            }
            this.futureMap.put(str, this.executorService.submit(new TransformationJob(str, list, i, new MarshallingTransformationListener(this.futureMap, transformationListener, this.looper))));
            return;
        }
        throw new IllegalArgumentException("Request with id " + str + " already exists");
    }

    public void cancel(String str) {
        Future future = this.futureMap.get(str);
        if (future != null && !future.isCancelled() && !future.isDone()) {
            future.cancel(true);
        }
    }

    public void release() {
        this.executorService.shutdownNow();
    }

    public long getEstimatedTargetVideoSize(Uri uri, MediaFormat mediaFormat, MediaFormat mediaFormat2, TransformationOptions transformationOptions) {
        MediaExtractorMediaSource mediaExtractorMediaSource;
        if (transformationOptions == null) {
            try {
                mediaExtractorMediaSource = new MediaExtractorMediaSource(this.context, uri);
            } catch (MediaSourceException unused) {
                return -1;
            }
        } else {
            mediaExtractorMediaSource = new MediaExtractorMediaSource(this.context, uri, transformationOptions.sourceMediaRange);
        }
        return TranscoderUtils.getEstimatedTargetVideoFileSize(mediaExtractorMediaSource, mediaFormat, mediaFormat2);
    }

    public long getEstimatedTargetVideoSize(List<TrackTransform> list) {
        return TranscoderUtils.getEstimatedTargetFileSize(list);
    }

    private MediaFormat createTargetMediaFormat(MediaSource mediaSource, int i) {
        MediaFormat trackFormat = mediaSource.getTrackFormat(i);
        String string = trackFormat.containsKey("mime") ? trackFormat.getString("mime") : null;
        if (string == null) {
            return null;
        }
        if (string.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO)) {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(string, trackFormat.getInteger("width"), trackFormat.getInteger("height"));
            createVideoFormat.setInteger("bitrate", TranscoderUtils.estimateVideoTrackBitrate(mediaSource, i));
            int i2 = 5;
            if (trackFormat.containsKey("i-frame-interval")) {
                i2 = trackFormat.getInteger("i-frame-interval");
            }
            createVideoFormat.setInteger("i-frame-interval", i2);
            return createVideoFormat;
        } else if (!string.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO)) {
            return null;
        } else {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(string, trackFormat.getInteger("sample-rate"), trackFormat.getInteger("channel-count"));
            createAudioFormat.setInteger("bitrate", trackFormat.getInteger("bitrate"));
            return createAudioFormat;
        }
    }

    private MediaFormat createTargetAudioFormat(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str) {
        if (str != null && mediaFormat2 == null) {
            mediaFormat2 = MediaFormat.createAudioFormat(str, mediaFormat.getInteger("sample-rate"), mediaFormat.getInteger("channel-count"));
            mediaFormat2.setInteger("bitrate", mediaFormat.containsKey("bitrate") ? mediaFormat.getInteger("bitrate") : DEFAULT_AUDIO_BITRATE);
            if (mediaFormat.containsKey("durationUs")) {
                mediaFormat2.setLong("durationUs", mediaFormat.getLong("durationUs"));
            }
        }
        return mediaFormat2;
    }
}
