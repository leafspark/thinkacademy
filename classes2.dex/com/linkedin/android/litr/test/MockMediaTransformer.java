package com.linkedin.android.litr.test;

import android.content.Context;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Looper;
import com.linkedin.android.litr.MediaTransformer;
import com.linkedin.android.litr.TrackTransform;
import com.linkedin.android.litr.TransformationListener;
import com.linkedin.android.litr.TransformationOptions;
import com.linkedin.android.litr.analytics.TrackTransformationInfo;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class MockMediaTransformer extends MediaTransformer {
    private List<TransformationEvent> transformationEvents;

    public void cancel(String str) {
    }

    public long getEstimatedTargetVideoSize(Uri uri, MediaFormat mediaFormat, MediaFormat mediaFormat2, TransformationOptions transformationOptions) {
        return 0;
    }

    public void release() {
    }

    public MockMediaTransformer(Context context) {
        super(context, (Looper) null, (ExecutorService) null);
    }

    public void setEvents(List<TransformationEvent> list) {
        this.transformationEvents = list;
    }

    public void transform(String str, Uri uri, Uri uri2, MediaFormat mediaFormat, MediaFormat mediaFormat2, TransformationListener transformationListener, TransformationOptions transformationOptions) {
        playEvents(transformationListener);
    }

    public void transform(String str, List<TrackTransform> list, TransformationListener transformationListener, int i) {
        playEvents(transformationListener);
    }

    private void playEvents(TransformationListener transformationListener) {
        List<TransformationEvent> list = this.transformationEvents;
        if (list != null) {
            for (TransformationEvent next : list) {
                int i = next.type;
                if (i == 0) {
                    transformationListener.onStarted(next.id);
                } else if (i == 1) {
                    transformationListener.onProgress(next.id, next.progress);
                } else if (i == 2) {
                    transformationListener.onCompleted(next.id, (List<TrackTransformationInfo>) null);
                } else if (i == 3) {
                    transformationListener.onError(next.id, next.cause, (List<TrackTransformationInfo>) null);
                } else if (i == 4) {
                    transformationListener.onCancelled(next.id, (List<TrackTransformationInfo>) null);
                }
            }
        }
    }
}
