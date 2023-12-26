package com.linkedin.android.litr;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.linkedin.android.litr.analytics.TrackTransformationInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

class MarshallingTransformationListener {
    private static final int EVENT_CANCELLED = 4;
    private static final int EVENT_COMPLETED = 1;
    private static final int EVENT_ERROR = 2;
    private static final int EVENT_PROGRESS = 3;
    private static final int EVENT_STARTED = 0;
    private static final String KEY_JOB_ID = "jobId";
    private static final String KEY_PROGRESS = "progress";
    private static final String KEY_THROWABLE = "throwable";
    /* access modifiers changed from: private */
    public static final String TAG = "MarshallingTransformationListener";
    private Bundle data = new Bundle();
    private final Map<String, Future<?>> futureMap;
    private MarshallingHandler handler;
    private final TransformationListener listener;

    MarshallingTransformationListener(Map<String, Future<?>> map, TransformationListener transformationListener, Looper looper) {
        this.futureMap = map;
        this.listener = transformationListener;
        if (looper != null) {
            this.handler = new MarshallingHandler(looper, transformationListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStarted(String str) {
        MarshallingHandler marshallingHandler = this.handler;
        if (marshallingHandler == null) {
            this.listener.onStarted(str);
            return;
        }
        Message obtain = Message.obtain(marshallingHandler, 0);
        obtain.obj = null;
        this.data.putString(KEY_JOB_ID, str);
        obtain.setData(this.data);
        obtain.sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void onCompleted(String str, List<TrackTransformationInfo> list) {
        this.futureMap.remove(str);
        MarshallingHandler marshallingHandler = this.handler;
        if (marshallingHandler == null) {
            this.listener.onCompleted(str, list);
            return;
        }
        Message obtain = Message.obtain(marshallingHandler, 1);
        obtain.obj = list;
        this.data.putString(KEY_JOB_ID, str);
        obtain.setData(this.data);
        obtain.sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void onCancelled(String str, List<TrackTransformationInfo> list) {
        this.futureMap.remove(str);
        MarshallingHandler marshallingHandler = this.handler;
        if (marshallingHandler == null) {
            this.listener.onCancelled(str, list);
            return;
        }
        Message obtain = Message.obtain(marshallingHandler, 4);
        obtain.obj = list;
        this.data.putString(KEY_JOB_ID, str);
        obtain.setData(this.data);
        obtain.sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void onError(String str, Throwable th, List<TrackTransformationInfo> list) {
        this.futureMap.remove(str);
        MarshallingHandler marshallingHandler = this.handler;
        if (marshallingHandler == null) {
            this.listener.onError(str, th, list);
            return;
        }
        Message obtain = Message.obtain(marshallingHandler, 2);
        obtain.obj = list;
        this.data.putString(KEY_JOB_ID, str);
        this.data.putSerializable(KEY_THROWABLE, th);
        obtain.setData(this.data);
        obtain.sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void onProgress(String str, float f) {
        MarshallingHandler marshallingHandler = this.handler;
        if (marshallingHandler == null) {
            this.listener.onProgress(str, f);
            return;
        }
        Message obtain = Message.obtain(marshallingHandler, 3);
        obtain.obj = null;
        this.data.putString(KEY_JOB_ID, str);
        this.data.putFloat(KEY_PROGRESS, f);
        obtain.setData(this.data);
        obtain.sendToTarget();
    }

    private static class MarshallingHandler extends Handler {
        private final TransformationListener listener;

        private MarshallingHandler(Looper looper, TransformationListener transformationListener) {
            super(looper);
            this.listener = transformationListener;
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            List list = message.obj == null ? null : (List) message.obj;
            Bundle data = message.getData();
            String string = data.getString(MarshallingTransformationListener.KEY_JOB_ID);
            if (string != null) {
                int i = message.what;
                if (i == 0) {
                    this.listener.onStarted(string);
                } else if (i == 1) {
                    this.listener.onCompleted(string, list);
                } else if (i == 2) {
                    this.listener.onError(string, (Throwable) data.getSerializable(MarshallingTransformationListener.KEY_THROWABLE), list);
                } else if (i == 3) {
                    this.listener.onProgress(string, data.getFloat(MarshallingTransformationListener.KEY_PROGRESS));
                } else if (i != 4) {
                    String access$100 = MarshallingTransformationListener.TAG;
                    Log.e(access$100, "Unknown event received: " + message.what);
                } else {
                    this.listener.onCancelled(string, list);
                }
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Handler message doesn't contain an id!");
            AsynchronousInstrumentation.handlerMessageEnd();
            throw illegalArgumentException;
        }
    }
}
