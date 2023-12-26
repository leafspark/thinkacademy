package com.amazonaws.event;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProgressListenerChain implements ProgressListener {
    private static final Log log = LogFactory.getLog((Class<?>) ProgressListenerChain.class);
    private final List<ProgressListener> listeners;
    private final ProgressEventFilter progressEventFilter;

    public interface ProgressEventFilter {
        ProgressEvent filter(ProgressEvent progressEvent);
    }

    public ProgressListenerChain(ProgressListener... progressListenerArr) {
        this((ProgressEventFilter) null, progressListenerArr);
    }

    public ProgressListenerChain(ProgressEventFilter progressEventFilter2, ProgressListener... progressListenerArr) {
        this.listeners = new CopyOnWriteArrayList();
        if (progressListenerArr != null) {
            for (ProgressListener addProgressListener : progressListenerArr) {
                addProgressListener(addProgressListener);
            }
            this.progressEventFilter = progressEventFilter2;
            return;
        }
        throw new IllegalArgumentException("Progress Listeners cannot be null.");
    }

    public synchronized void addProgressListener(ProgressListener progressListener) {
        if (progressListener != null) {
            this.listeners.add(progressListener);
        }
    }

    public synchronized void removeProgressListener(ProgressListener progressListener) {
        if (progressListener != null) {
            this.listeners.remove(progressListener);
        }
    }

    /* access modifiers changed from: protected */
    public List<ProgressListener> getListeners() {
        return this.listeners;
    }

    public void progressChanged(ProgressEvent progressEvent) {
        ProgressEventFilter progressEventFilter2 = this.progressEventFilter;
        if (progressEventFilter2 == null || (progressEvent = progressEventFilter2.filter(progressEvent)) != null) {
            for (ProgressListener progressChanged : this.listeners) {
                try {
                    progressChanged.progressChanged(progressEvent);
                } catch (RuntimeException e) {
                    log.warn("Couldn't update progress listener", e);
                }
            }
        }
    }
}
