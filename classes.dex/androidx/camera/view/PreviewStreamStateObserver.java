package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

final class PreviewStreamStateObserver implements Observable.Observer<CameraInternal.State> {
    private static final String TAG = "StreamStateObserver";
    private final CameraInfoInternal mCameraInfoInternal;
    ListenableFuture<Void> mFlowFuture;
    private boolean mHasStartedPreviewStreamFlow = false;
    private PreviewView.StreamState mPreviewStreamState;
    private final MutableLiveData<PreviewView.StreamState> mPreviewStreamStateLiveData;
    private final PreviewViewImplementation mPreviewViewImplementation;

    PreviewStreamStateObserver(CameraInfoInternal cameraInfoInternal, MutableLiveData<PreviewView.StreamState> mutableLiveData, PreviewViewImplementation previewViewImplementation) {
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mPreviewStreamStateLiveData = mutableLiveData;
        this.mPreviewViewImplementation = previewViewImplementation;
        synchronized (this) {
            this.mPreviewStreamState = mutableLiveData.getValue();
        }
    }

    public void onNewData(CameraInternal.State state) {
        if (state == CameraInternal.State.CLOSING || state == CameraInternal.State.CLOSED || state == CameraInternal.State.RELEASING || state == CameraInternal.State.RELEASED) {
            updatePreviewStreamState(PreviewView.StreamState.IDLE);
            if (this.mHasStartedPreviewStreamFlow) {
                this.mHasStartedPreviewStreamFlow = false;
                cancelFlow();
            }
        } else if ((state == CameraInternal.State.OPENING || state == CameraInternal.State.OPEN || state == CameraInternal.State.PENDING_OPEN) && !this.mHasStartedPreviewStreamFlow) {
            startPreviewStreamStateFlow(this.mCameraInfoInternal);
            this.mHasStartedPreviewStreamFlow = true;
        }
    }

    public void onError(Throwable th) {
        clear();
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        cancelFlow();
    }

    private void cancelFlow() {
        ListenableFuture<Void> listenableFuture = this.mFlowFuture;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.mFlowFuture = null;
        }
    }

    private void startPreviewStreamStateFlow(final CameraInfo cameraInfo) {
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
        final ArrayList arrayList = new ArrayList();
        FutureChain transform = FutureChain.from(waitForCaptureResult(cameraInfo, arrayList)).transformAsync(new PreviewStreamStateObserver$$ExternalSyntheticLambda1(this), CameraXExecutors.directExecutor()).transform(new PreviewStreamStateObserver$$ExternalSyntheticLambda0(this), CameraXExecutors.directExecutor());
        this.mFlowFuture = transform;
        Futures.addCallback(transform, new FutureCallback<Void>() {
            public void onSuccess(Void voidR) {
                PreviewStreamStateObserver.this.mFlowFuture = null;
            }

            public void onFailure(Throwable th) {
                PreviewStreamStateObserver.this.mFlowFuture = null;
                if (!arrayList.isEmpty()) {
                    for (CameraCaptureCallback removeSessionCaptureCallback : arrayList) {
                        ((CameraInfoInternal) cameraInfo).removeSessionCaptureCallback(removeSessionCaptureCallback);
                    }
                    arrayList.clear();
                }
            }
        }, CameraXExecutors.directExecutor());
    }

    public /* synthetic */ ListenableFuture lambda$startPreviewStreamStateFlow$0$PreviewStreamStateObserver(Void voidR) throws Exception {
        return this.mPreviewViewImplementation.waitForNextFrame();
    }

    public /* synthetic */ Void lambda$startPreviewStreamStateFlow$1$PreviewStreamStateObserver(Void voidR) {
        updatePreviewStreamState(PreviewView.StreamState.STREAMING);
        return null;
    }

    /* access modifiers changed from: package-private */
    public void updatePreviewStreamState(PreviewView.StreamState streamState) {
        synchronized (this) {
            if (!this.mPreviewStreamState.equals(streamState)) {
                this.mPreviewStreamState = streamState;
                Logger.d(TAG, "Update Preview stream state to " + streamState);
                this.mPreviewStreamStateLiveData.postValue(streamState);
            }
        }
    }

    private ListenableFuture<Void> waitForCaptureResult(CameraInfo cameraInfo, List<CameraCaptureCallback> list) {
        return CallbackToFutureAdapter.getFuture(new PreviewStreamStateObserver$$ExternalSyntheticLambda2(this, cameraInfo, list));
    }

    public /* synthetic */ Object lambda$waitForCaptureResult$2$PreviewStreamStateObserver(final CameraInfo cameraInfo, List list, final CallbackToFutureAdapter.Completer completer) throws Exception {
        AnonymousClass2 r0 = new CameraCaptureCallback() {
            public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
                completer.set(null);
                ((CameraInfoInternal) cameraInfo).removeSessionCaptureCallback(this);
            }
        };
        list.add(r0);
        ((CameraInfoInternal) cameraInfo).addSessionCaptureCallback(CameraXExecutors.directExecutor(), r0);
        return "waitForCaptureResult";
    }
}
