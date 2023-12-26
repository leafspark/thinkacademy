package com.linkedin.android.litr;

import android.text.TextUtils;
import android.util.Log;
import com.linkedin.android.litr.analytics.TransformationStatsCollector;
import com.linkedin.android.litr.exception.InsufficientDiskSpaceException;
import com.linkedin.android.litr.exception.MediaTransformationException;
import com.linkedin.android.litr.exception.TrackTranscoderException;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.linkedin.android.litr.transcoder.TrackTranscoder;
import com.linkedin.android.litr.transcoder.TrackTranscoderFactory;
import com.linkedin.android.litr.utils.DiskUtil;
import com.linkedin.android.litr.utils.TranscoderUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class TransformationJob implements Runnable {
    private static final float DEFAULT_SIZE_PADDING = 0.1f;
    private static final String TAG = "TransformationJob";
    DiskUtil diskUtil = new DiskUtil();
    int granularity;
    private final String jobId;
    float lastProgress = 0.0f;
    private final MarshallingTransformationListener marshallingTransformationListener;
    TransformationStatsCollector statsCollector = new TransformationStatsCollector();
    TrackTranscoderFactory trackTranscoderFactory = new TrackTranscoderFactory();
    List<TrackTranscoder> trackTranscoders;
    private final List<TrackTransform> trackTransforms;

    TransformationJob(String str, List<TrackTransform> list, int i, MarshallingTransformationListener marshallingTransformationListener2) {
        this.jobId = str;
        this.trackTransforms = list;
        this.granularity = i;
        this.marshallingTransformationListener = marshallingTransformationListener2;
    }

    public void run() {
        try {
            transform();
        } catch (RuntimeException e) {
            Log.e(TAG, "Transformation job error", e);
            if (e.getCause() instanceof InterruptedException) {
                cancel();
            } else {
                error(e);
            }
        } catch (MediaTransformationException e2) {
            Log.e(TAG, "Transformation job error", e2);
            e2.setJobId(this.jobId);
            error(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void transform() throws MediaTransformationException {
        boolean processNextFrame;
        initStatsCollector();
        verifyAvailableDiskSpace();
        createTrackTranscoders();
        startTrackTranscoders();
        seekToMediaRangeStart();
        this.marshallingTransformationListener.onStarted(this.jobId);
        this.lastProgress = 0.0f;
        while (true) {
            processNextFrame = processNextFrame();
            if (!Thread.interrupted()) {
                if (processNextFrame) {
                    break;
                }
            } else {
                processNextFrame = false;
                cancel();
                break;
            }
        }
        release(processNextFrame);
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.marshallingTransformationListener.onCancelled(this.jobId, this.statsCollector.getStats());
        release(false);
    }

    /* access modifiers changed from: protected */
    public void error(Throwable th) {
        this.marshallingTransformationListener.onError(this.jobId, th, this.statsCollector.getStats());
        release(false);
    }

    /* access modifiers changed from: package-private */
    public void initStatsCollector() {
        for (TrackTransform next : this.trackTransforms) {
            this.statsCollector.addSourceTrack(next.getMediaSource().getTrackFormat(next.getSourceTrack()));
        }
    }

    /* access modifiers changed from: package-private */
    public void verifyAvailableDiskSpace() throws InsufficientDiskSpaceException {
        long estimatedTargetFileSize = TranscoderUtils.getEstimatedTargetFileSize(this.trackTransforms);
        long j = (long) (((float) estimatedTargetFileSize) * 1.1f);
        long availableDiskSpaceInDataDirectory = this.diskUtil.getAvailableDiskSpaceInDataDirectory();
        if (availableDiskSpaceInDataDirectory != -1 && availableDiskSpaceInDataDirectory < j) {
            throw new InsufficientDiskSpaceException(estimatedTargetFileSize, availableDiskSpaceInDataDirectory);
        }
    }

    /* access modifiers changed from: package-private */
    public void createTrackTranscoders() throws TrackTranscoderException {
        int size = this.trackTransforms.size();
        this.trackTranscoders = new ArrayList(size);
        if (size >= 1) {
            for (int i = 0; i < size; i++) {
                TrackTransform trackTransform = this.trackTransforms.get(i);
                TrackTranscoder create = this.trackTranscoderFactory.create(trackTransform.getSourceTrack(), trackTransform.getTargetTrack(), trackTransform.getMediaSource(), trackTransform.getDecoder(), trackTransform.getRenderer(), trackTransform.getEncoder(), trackTransform.getMediaTarget(), trackTransform.getTargetFormat());
                this.trackTranscoders.add(create);
                this.statsCollector.setTrackCodecs(i, create.getDecoderName(), create.getEncoderName());
            }
            return;
        }
        throw new TrackTranscoderException(TrackTranscoderException.Error.NO_TRACKS_FOUND);
    }

    /* access modifiers changed from: package-private */
    public void startTrackTranscoders() throws TrackTranscoderException {
        for (TrackTranscoder start : this.trackTranscoders) {
            start.start();
        }
    }

    private void seekToMediaRangeStart() {
        for (TrackTransform next : this.trackTransforms) {
            next.getMediaSource().seekTo(next.getMediaSource().getSelection().getStart(), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean processNextFrame() throws TrackTranscoderException {
        boolean z = true;
        for (int i = 0; i < this.trackTranscoders.size(); i++) {
            long currentTimeMillis = System.currentTimeMillis();
            z &= this.trackTranscoders.get(i).processNextFrame() == 3;
            this.statsCollector.increaseTrackProcessingDuration(i, System.currentTimeMillis() - currentTimeMillis);
        }
        float f = 0.0f;
        for (TrackTranscoder progress : this.trackTranscoders) {
            f += progress.getProgress();
        }
        float size = f / ((float) this.trackTranscoders.size());
        int i2 = this.granularity;
        if ((i2 == 0 && size != this.lastProgress) || (i2 != 0 && size >= this.lastProgress + (1.0f / ((float) i2)))) {
            this.marshallingTransformationListener.onProgress(this.jobId, size);
            this.lastProgress = size;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void release(boolean z) {
        if (this.trackTranscoders != null) {
            for (int i = 0; i < this.trackTranscoders.size(); i++) {
                TrackTranscoder trackTranscoder = this.trackTranscoders.get(i);
                trackTranscoder.stop();
                this.statsCollector.setTargetFormat(i, trackTranscoder.getTargetMediaFormat());
            }
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (TrackTransform next : this.trackTransforms) {
            hashSet.add(next.getMediaSource());
            hashSet2.add(next.getMediaTarget());
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((MediaSource) it.next()).release();
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            MediaTarget mediaTarget = (MediaTarget) it2.next();
            mediaTarget.release();
            if (!z) {
                deleteOutputFile(mediaTarget.getOutputFilePath());
            }
        }
        if (z) {
            this.marshallingTransformationListener.onCompleted(this.jobId, this.statsCollector.getStats());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean deleteOutputFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).delete();
    }
}
