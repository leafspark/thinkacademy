package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

class SynchronizedCaptureSessionImpl extends SynchronizedCaptureSessionBaseImpl {
    private static final String TAG = "SyncCaptureSessionImpl";
    private final CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() {
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            if (SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter != null) {
                SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter.set(null);
                SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter = null;
            }
        }

        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
            if (SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter != null) {
                SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter.setCancelled();
                SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter = null;
            }
        }
    };
    private List<DeferrableSurface> mDeferrableSurfaces;
    private final Set<String> mEnabledFeature;
    private boolean mHasSubmittedRepeating;
    private final Object mObjectLock = new Object();
    ListenableFuture<Void> mOpeningCaptureSession;
    CallbackToFutureAdapter.Completer<Void> mStartStreamingCompleter;
    private final ListenableFuture<Void> mStartStreamingFuture;
    ListenableFuture<List<Surface>> mStartingSurface;

    SynchronizedCaptureSessionImpl(Set<String> set, CaptureSessionRepository captureSessionRepository, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        super(captureSessionRepository, executor, scheduledExecutorService, handler);
        this.mEnabledFeature = set;
        if (set.contains("wait_for_request")) {
            this.mStartStreamingFuture = CallbackToFutureAdapter.getFuture(new SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1(this));
        } else {
            this.mStartStreamingFuture = Futures.immediateFuture(null);
        }
    }

    public /* synthetic */ Object lambda$new$0$SynchronizedCaptureSessionImpl(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mStartStreamingCompleter = completer;
        return "StartStreamingFuture[session=" + this + "]";
    }

    public ListenableFuture<Void> openCaptureSession(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List<DeferrableSurface> list) {
        ListenableFuture<Void> nonCancellationPropagating;
        synchronized (this.mObjectLock) {
            FutureChain transformAsync = FutureChain.from(Futures.successfulAsList(getBlockerFuture("wait_for_request", this.mCaptureSessionRepository.getClosingCaptureSession()))).transformAsync(new SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0(this, cameraDevice, sessionConfigurationCompat, list), CameraXExecutors.directExecutor());
            this.mOpeningCaptureSession = transformAsync;
            nonCancellationPropagating = Futures.nonCancellationPropagating(transformAsync);
        }
        return nonCancellationPropagating;
    }

    public /* synthetic */ ListenableFuture lambda$openCaptureSession$1$SynchronizedCaptureSessionImpl(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list, List list2) throws Exception {
        return super.openCaptureSession(cameraDevice, sessionConfigurationCompat, list);
    }

    public ListenableFuture<Void> getSynchronizedBlocker(String str) {
        str.hashCode();
        if (!str.equals("wait_for_request")) {
            return super.getSynchronizedBlocker(str);
        }
        return Futures.nonCancellationPropagating(this.mStartStreamingFuture);
    }

    private List<ListenableFuture<Void>> getBlockerFuture(String str, List<SynchronizedCaptureSession> list) {
        ArrayList arrayList = new ArrayList();
        for (SynchronizedCaptureSession synchronizedBlocker : list) {
            arrayList.add(synchronizedBlocker.getSynchronizedBlocker(str));
        }
        return arrayList;
    }

    public ListenableFuture<List<Surface>> startWithDeferrableSurface(List<DeferrableSurface> list, long j) {
        ListenableFuture<List<Surface>> nonCancellationPropagating;
        synchronized (this.mObjectLock) {
            this.mDeferrableSurfaces = list;
            nonCancellationPropagating = Futures.nonCancellationPropagating(super.startWithDeferrableSurface(list, j));
        }
        return nonCancellationPropagating;
    }

    public boolean stop() {
        boolean stop;
        synchronized (this.mObjectLock) {
            if (isCameraCaptureSessionOpen()) {
                closeConfiguredDeferrableSurfaces();
            } else {
                ListenableFuture<Void> listenableFuture = this.mOpeningCaptureSession;
                if (listenableFuture != null) {
                    listenableFuture.cancel(true);
                }
                ListenableFuture<List<Surface>> listenableFuture2 = this.mStartingSurface;
                if (listenableFuture2 != null) {
                    listenableFuture2.cancel(true);
                }
            }
            stop = super.stop();
        }
        return stop;
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        int singleRepeatingRequest;
        if (!this.mEnabledFeature.contains("wait_for_request")) {
            return super.setSingleRepeatingRequest(captureRequest, captureCallback);
        }
        synchronized (this.mObjectLock) {
            this.mHasSubmittedRepeating = true;
            singleRepeatingRequest = super.setSingleRepeatingRequest(captureRequest, Camera2CaptureCallbacks.createComboCallback(this.mCaptureCallback, captureCallback));
        }
        return singleRepeatingRequest;
    }

    public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
        SynchronizedCaptureSession next;
        SynchronizedCaptureSession next2;
        debugLog("Session onConfigured()");
        if (this.mEnabledFeature.contains("force_close")) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it = this.mCaptureSessionRepository.getCreatingCaptureSessions().iterator();
            while (it.hasNext() && (next2 = it.next()) != synchronizedCaptureSession) {
                linkedHashSet.add(next2);
            }
            forceOnConfigureFailed(linkedHashSet);
        }
        super.onConfigured(synchronizedCaptureSession);
        if (this.mEnabledFeature.contains("force_close")) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it2 = this.mCaptureSessionRepository.getCaptureSessions().iterator();
            while (it2.hasNext() && (next = it2.next()) != synchronizedCaptureSession) {
                linkedHashSet2.add(next);
            }
            forceOnClosed(linkedHashSet2);
        }
    }

    public void close() {
        debugLog("Session call close()");
        if (this.mEnabledFeature.contains("wait_for_request")) {
            synchronized (this.mObjectLock) {
                if (!this.mHasSubmittedRepeating) {
                    this.mStartStreamingFuture.cancel(true);
                }
            }
        }
        this.mStartStreamingFuture.addListener(new SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda2(this), getExecutor());
    }

    public /* synthetic */ void lambda$close$2$SynchronizedCaptureSessionImpl() {
        debugLog("Session call super.close()");
        super.close();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void closeConfiguredDeferrableSurfaces() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mObjectLock
            monitor-enter(r0)
            java.util.List<androidx.camera.core.impl.DeferrableSurface> r1 = r3.mDeferrableSurfaces     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x000e
            java.lang.String r1 = "deferrableSurface == null, maybe forceClose, skip close"
            r3.debugLog(r1)     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x000e:
            java.util.Set<java.lang.String> r1 = r3.mEnabledFeature     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = "deferrableSurface_close"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0033
            java.util.List<androidx.camera.core.impl.DeferrableSurface> r1 = r3.mDeferrableSurfaces     // Catch:{ all -> 0x0035 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0035 }
        L_0x001e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0035 }
            androidx.camera.core.impl.DeferrableSurface r2 = (androidx.camera.core.impl.DeferrableSurface) r2     // Catch:{ all -> 0x0035 }
            r2.close()     // Catch:{ all -> 0x0035 }
            goto L_0x001e
        L_0x002e:
            java.lang.String r1 = "deferrableSurface closed"
            r3.debugLog(r1)     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl.closeConfiguredDeferrableSurfaces():void");
    }

    public void onClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        closeConfiguredDeferrableSurfaces();
        debugLog("onClosed()");
        super.onClosed(synchronizedCaptureSession);
    }

    static void forceOnClosed(Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession next : set) {
            next.getStateCallback().onClosed(next);
        }
    }

    private void forceOnConfigureFailed(Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession next : set) {
            next.getStateCallback().onConfigureFailed(next);
        }
    }

    /* access modifiers changed from: package-private */
    public void debugLog(String str) {
        Logger.d(TAG, "[" + this + "] " + str);
    }
}
