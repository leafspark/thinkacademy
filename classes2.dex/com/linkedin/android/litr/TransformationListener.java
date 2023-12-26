package com.linkedin.android.litr;

import com.linkedin.android.litr.analytics.TrackTransformationInfo;
import java.util.List;

public interface TransformationListener {
    void onCancelled(String str, List<TrackTransformationInfo> list);

    void onCompleted(String str, List<TrackTransformationInfo> list);

    void onError(String str, Throwable th, List<TrackTransformationInfo> list);

    void onProgress(String str, float f);

    void onStarted(String str);
}
