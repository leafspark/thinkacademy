package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;

final class CaptureSession {
    private static final String TAG = "CaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;
    CameraEventCallbacks mCameraEventCallbacks;
    volatile Config mCameraEventOnRepeatingOptions;
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;
    private final List<CaptureConfig> mCaptureConfigs;
    private final StateCallback mCaptureSessionStateCallback;
    List<DeferrableSurface> mConfiguredDeferrableSurfaces;
    private Map<DeferrableSurface, Surface> mConfiguredSurfaceMap;
    CallbackToFutureAdapter.Completer<Void> mReleaseCompleter;
    ListenableFuture<Void> mReleaseFuture;
    volatile SessionConfig mSessionConfig;
    State mState;
    final Object mStateLock;
    final StillCaptureFlow mStillCaptureFlow;
    SynchronizedCaptureSession mSynchronizedCaptureSession;
    SynchronizedCaptureSessionOpener mSynchronizedCaptureSessionOpener;

    enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    CaptureSession() {
        this.mStateLock = new Object();
        this.mCaptureConfigs = new ArrayList();
        this.mCaptureCallback = new CameraCaptureSession.CaptureCallback() {
            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            }
        };
        this.mCameraEventOnRepeatingOptions = OptionsBundle.emptyBundle();
        this.mCameraEventCallbacks = CameraEventCallbacks.createEmptyCallback();
        this.mConfiguredSurfaceMap = new HashMap();
        this.mConfiguredDeferrableSurfaces = Collections.emptyList();
        this.mState = State.UNINITIALIZED;
        this.mStillCaptureFlow = new StillCaptureFlow();
        this.mState = State.INITIALIZED;
        this.mCaptureSessionStateCallback = new StateCallback();
    }

    /* access modifiers changed from: package-private */
    public SessionConfig getSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.mStateLock) {
            sessionConfig = this.mSessionConfig;
        }
        return sessionConfig;
    }

    /* renamed from: androidx.camera.camera2.internal.CaptureSession$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.camera2.internal.CaptureSession$State[] r0 = androidx.camera.camera2.internal.CaptureSession.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State = r0
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.GET_SURFACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.OPENING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.OPENED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSessionConfig(androidx.camera.core.impl.SessionConfig r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mStateLock
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ all -> 0x005d }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x005d }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x005d }
            r1 = r1[r2]     // Catch:{ all -> 0x005d }
            switch(r1) {
                case 1: goto L_0x0042;
                case 2: goto L_0x003f;
                case 3: goto L_0x003f;
                case 4: goto L_0x003f;
                case 5: goto L_0x0019;
                case 6: goto L_0x0011;
                case 7: goto L_0x0011;
                case 8: goto L_0x0011;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x005d }
        L_0x0010:
            goto L_0x005b
        L_0x0011:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "Session configuration cannot be set on a closed/released session."
            r4.<init>(r1)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x0019:
            r3.mSessionConfig = r4     // Catch:{ all -> 0x005d }
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r1 = r3.mConfiguredSurfaceMap     // Catch:{ all -> 0x005d }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x005d }
            java.util.List r4 = r4.getSurfaces()     // Catch:{ all -> 0x005d }
            boolean r4 = r1.containsAll(r4)     // Catch:{ all -> 0x005d }
            if (r4 != 0) goto L_0x0034
            java.lang.String r4 = "CaptureSession"
            java.lang.String r1 = "Does not have the proper configured lists"
            androidx.camera.core.Logger.e(r4, r1)     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x0034:
            java.lang.String r4 = "CaptureSession"
            java.lang.String r1 = "Attempting to submit CaptureRequest after setting"
            androidx.camera.core.Logger.d(r4, r1)     // Catch:{ all -> 0x005d }
            r3.issueRepeatingCaptureRequests()     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x003f:
            r3.mSessionConfig = r4     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x0042:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r1.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "setSessionConfig() should not be possible in state: "
            r1.append(r2)     // Catch:{ all -> 0x005d }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x005d }
            r1.append(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005d }
            r4.<init>(r1)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x005d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.setSessionConfig(androidx.camera.core.impl.SessionConfig):void");
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> open(SessionConfig sessionConfig, CameraDevice cameraDevice, SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener) {
        synchronized (this.mStateLock) {
            if (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()] != 2) {
                Logger.e(TAG, "Open not allowed in state: " + this.mState);
                ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.mState));
                return immediateFailedFuture;
            }
            this.mState = State.GET_SURFACE;
            ArrayList arrayList = new ArrayList(sessionConfig.getSurfaces());
            this.mConfiguredDeferrableSurfaces = arrayList;
            this.mSynchronizedCaptureSessionOpener = synchronizedCaptureSessionOpener;
            FutureChain transformAsync = FutureChain.from(synchronizedCaptureSessionOpener.startWithDeferrableSurface(arrayList, 5000)).transformAsync(new CaptureSession$$ExternalSyntheticLambda1(this, sessionConfig, cameraDevice), this.mSynchronizedCaptureSessionOpener.getExecutor());
            Futures.addCallback(transformAsync, new FutureCallback<Void>() {
                public void onSuccess(Void voidR) {
                }

                public void onFailure(Throwable th) {
                    CaptureSession.this.mSynchronizedCaptureSessionOpener.stop();
                    synchronized (CaptureSession.this.mStateLock) {
                        int i = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()];
                        if (i == 4 || i == 6 || i == 7) {
                            if (!(th instanceof CancellationException)) {
                                Logger.w(CaptureSession.TAG, "Opening session with fail " + CaptureSession.this.mState, th);
                                CaptureSession.this.finishClose();
                            }
                        }
                    }
                }
            }, this.mSynchronizedCaptureSessionOpener.getExecutor());
            ListenableFuture<Void> nonCancellationPropagating = Futures.nonCancellationPropagating(transformAsync);
            return nonCancellationPropagating;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: openCaptureSession */
    public ListenableFuture<Void> lambda$open$0$CaptureSession(List<Surface> list, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        synchronized (this.mStateLock) {
            int i = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    this.mConfiguredSurfaceMap.clear();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        this.mConfiguredSurfaceMap.put(this.mConfiguredDeferrableSurfaces.get(i2), list.get(i2));
                    }
                    ArrayList<Surface> arrayList = new ArrayList<>(new HashSet(list));
                    this.mState = State.OPENING;
                    Logger.d(TAG, "Opening capture session.");
                    SynchronizedCaptureSession.StateCallback createComboCallback = SynchronizedCaptureSessionStateCallbacks.createComboCallback(this.mCaptureSessionStateCallback, new SynchronizedCaptureSessionStateCallbacks.Adapter(sessionConfig.getSessionStateCallbacks()));
                    CameraEventCallbacks cameraEventCallback = new Camera2ImplConfig(sessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback());
                    this.mCameraEventCallbacks = cameraEventCallback;
                    List<CaptureConfig> onPresetSession = cameraEventCallback.createComboCallback().onPresetSession();
                    CaptureConfig.Builder from = CaptureConfig.Builder.from(sessionConfig.getRepeatingCaptureConfig());
                    for (CaptureConfig implementationOptions : onPresetSession) {
                        from.addImplementationOptions(implementationOptions.getImplementationOptions());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Surface outputConfigurationCompat : arrayList) {
                        arrayList2.add(new OutputConfigurationCompat(outputConfigurationCompat));
                    }
                    SessionConfigurationCompat createSessionConfigurationCompat = this.mSynchronizedCaptureSessionOpener.createSessionConfigurationCompat(0, arrayList2, createComboCallback);
                    try {
                        CaptureRequest buildWithoutTarget = Camera2CaptureRequestBuilder.buildWithoutTarget(from.build(), cameraDevice);
                        if (buildWithoutTarget != null) {
                            createSessionConfigurationCompat.setSessionParameters(buildWithoutTarget);
                        }
                        ListenableFuture<Void> openCaptureSession = this.mSynchronizedCaptureSessionOpener.openCaptureSession(cameraDevice, createSessionConfigurationCompat, this.mConfiguredDeferrableSurfaces);
                        return openCaptureSession;
                    } catch (CameraAccessException e) {
                        return Futures.immediateFailedFuture(e);
                    }
                } else if (i != 5) {
                    ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new CancellationException("openCaptureSession() not execute in state: " + this.mState));
                    return immediateFailedFuture;
                }
            }
            ListenableFuture<Void> immediateFailedFuture2 = Futures.immediateFailedFuture(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.mState));
            return immediateFailedFuture2;
        }
    }

    /* access modifiers changed from: package-private */
    public void close() {
        synchronized (this.mStateLock) {
            int i = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                if (this.mSessionConfig != null) {
                                    List<CaptureConfig> onDisableSession = this.mCameraEventCallbacks.createComboCallback().onDisableSession();
                                    if (!onDisableSession.isEmpty()) {
                                        try {
                                            issueCaptureRequests(setupConfiguredSurface(onDisableSession));
                                        } catch (IllegalStateException e) {
                                            Logger.e(TAG, "Unable to issue the request before close the capture session", e);
                                        }
                                    }
                                }
                            }
                        }
                        SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener = this.mSynchronizedCaptureSessionOpener;
                        Preconditions.checkNotNull(synchronizedCaptureSessionOpener, "The Opener shouldn't null in state:" + this.mState);
                        this.mSynchronizedCaptureSessionOpener.stop();
                        this.mState = State.CLOSED;
                        this.mSessionConfig = null;
                    } else {
                        SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener2 = this.mSynchronizedCaptureSessionOpener;
                        Preconditions.checkNotNull(synchronizedCaptureSessionOpener2, "The Opener shouldn't null in state:" + this.mState);
                        this.mSynchronizedCaptureSessionOpener.stop();
                    }
                }
                this.mState = State.RELEASED;
            } else {
                throw new IllegalStateException("close() should not be possible in state: " + this.mState);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r3.mState = androidx.camera.camera2.internal.CaptureSession.State.RELEASING;
        r4 = r3.mSynchronizedCaptureSessionOpener;
        androidx.core.util.Preconditions.checkNotNull(r4, "The Opener shouldn't null in state:" + r3.mState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (r3.mSynchronizedCaptureSessionOpener.stop() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        finishClose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r3.mReleaseFuture != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        r3.mReleaseFuture = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(new androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda2(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        r4 = r3.mReleaseFuture;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        r3.mState = androidx.camera.camera2.internal.CaptureSession.State.RELEASED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a5, code lost:
        return androidx.camera.core.impl.utils.futures.Futures.immediateFuture(null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> release(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mStateLock
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ all -> 0x00a6 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x00a6 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x00a6 }
            r1 = r1[r2]     // Catch:{ all -> 0x00a6 }
            switch(r1) {
                case 1: goto L_0x0086;
                case 2: goto L_0x0081;
                case 3: goto L_0x0064;
                case 4: goto L_0x0029;
                case 5: goto L_0x0012;
                case 6: goto L_0x0012;
                case 7: goto L_0x0051;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x00a6 }
        L_0x0010:
            goto L_0x009f
        L_0x0012:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r1 = r3.mSynchronizedCaptureSession     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0029
            if (r4 == 0) goto L_0x0024
            r1.abortCaptures()     // Catch:{ CameraAccessException -> 0x001c }
            goto L_0x0024
        L_0x001c:
            r4 = move-exception
            java.lang.String r1 = "CaptureSession"
            java.lang.String r2 = "Unable to abort captures."
            androidx.camera.core.Logger.e(r1, r2, r4)     // Catch:{ all -> 0x00a6 }
        L_0x0024:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r4 = r3.mSynchronizedCaptureSession     // Catch:{ all -> 0x00a6 }
            r4.close()     // Catch:{ all -> 0x00a6 }
        L_0x0029:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ all -> 0x00a6 }
            r3.mState = r4     // Catch:{ all -> 0x00a6 }
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x00a6 }
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a6 }
            androidx.core.util.Preconditions.checkNotNull(r4, r1)     // Catch:{ all -> 0x00a6 }
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch:{ all -> 0x00a6 }
            boolean r4 = r4.stop()     // Catch:{ all -> 0x00a6 }
            if (r4 == 0) goto L_0x0051
            r3.finishClose()     // Catch:{ all -> 0x00a6 }
            goto L_0x009f
        L_0x0051:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.mReleaseFuture     // Catch:{ all -> 0x00a6 }
            if (r4 != 0) goto L_0x0060
            androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda2 r4 = new androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda2     // Catch:{ all -> 0x00a6 }
            r4.<init>(r3)     // Catch:{ all -> 0x00a6 }
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r4)     // Catch:{ all -> 0x00a6 }
            r3.mReleaseFuture = r4     // Catch:{ all -> 0x00a6 }
        L_0x0060:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.mReleaseFuture     // Catch:{ all -> 0x00a6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            return r4
        L_0x0064:
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x00a6 }
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a6 }
            androidx.core.util.Preconditions.checkNotNull(r4, r1)     // Catch:{ all -> 0x00a6 }
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch:{ all -> 0x00a6 }
            r4.stop()     // Catch:{ all -> 0x00a6 }
        L_0x0081:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ all -> 0x00a6 }
            r3.mState = r4     // Catch:{ all -> 0x00a6 }
            goto L_0x009f
        L_0x0086:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "release() should not be possible in state: "
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x00a6 }
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a6 }
            r4.<init>(r1)     // Catch:{ all -> 0x00a6 }
            throw r4     // Catch:{ all -> 0x00a6 }
        L_0x009f:
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            r4 = 0
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r4)
            return r4
        L_0x00a6:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.release(boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    public /* synthetic */ Object lambda$release$1$CaptureSession(CallbackToFutureAdapter.Completer completer) throws Exception {
        String str;
        synchronized (this.mStateLock) {
            Preconditions.checkState(this.mReleaseCompleter == null, "Release completer expected to be null");
            this.mReleaseCompleter = completer;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public void issueCaptureRequests(List<CaptureConfig> list) {
        synchronized (this.mStateLock) {
            switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()]) {
                case 1:
                    throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.mState);
                case 2:
                case 3:
                case 4:
                    this.mCaptureConfigs.addAll(list);
                    break;
                case 5:
                    this.mCaptureConfigs.addAll(list);
                    issuePendingCaptureRequest();
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<CaptureConfig> getCaptureConfigs() {
        List<CaptureConfig> unmodifiableList;
        synchronized (this.mStateLock) {
            unmodifiableList = Collections.unmodifiableList(this.mCaptureConfigs);
        }
        return unmodifiableList;
    }

    /* access modifiers changed from: package-private */
    public State getState() {
        State state;
        synchronized (this.mStateLock) {
            state = this.mState;
        }
        return state;
    }

    /* access modifiers changed from: package-private */
    public void finishClose() {
        if (this.mState == State.RELEASED) {
            Logger.d(TAG, "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.mState = State.RELEASED;
        this.mSynchronizedCaptureSession = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.mReleaseCompleter;
        if (completer != null) {
            completer.set(null);
            this.mReleaseCompleter = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void issueRepeatingCaptureRequests() {
        if (this.mSessionConfig == null) {
            Logger.d(TAG, "Skipping issueRepeatingCaptureRequests for no configuration case.");
            return;
        }
        CaptureConfig repeatingCaptureConfig = this.mSessionConfig.getRepeatingCaptureConfig();
        if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
            Logger.d(TAG, "Skipping issueRepeatingCaptureRequests for no surface.");
            try {
                this.mSynchronizedCaptureSession.stopRepeating();
            } catch (CameraAccessException e) {
                Logger.e(TAG, "Unable to access camera: " + e.getMessage());
                Thread.dumpStack();
            }
        } else {
            try {
                Logger.d(TAG, "Issuing request for session.");
                CaptureConfig.Builder from = CaptureConfig.Builder.from(repeatingCaptureConfig);
                this.mCameraEventOnRepeatingOptions = mergeOptions(this.mCameraEventCallbacks.createComboCallback().onRepeating());
                from.addImplementationOptions(this.mCameraEventOnRepeatingOptions);
                CaptureRequest build = Camera2CaptureRequestBuilder.build(from.build(), this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
                if (build == null) {
                    Logger.d(TAG, "Skipping issuing empty request for session.");
                    return;
                }
                this.mSynchronizedCaptureSession.setSingleRepeatingRequest(build, createCamera2CaptureCallback(repeatingCaptureConfig.getCameraCaptureCallbacks(), this.mCaptureCallback));
            } catch (CameraAccessException e2) {
                Logger.e(TAG, "Unable to access camera: " + e2.getMessage());
                Thread.dumpStack();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void issuePendingCaptureRequest() {
        if (!this.mCaptureConfigs.isEmpty()) {
            try {
                issueBurstCaptureRequest(this.mCaptureConfigs);
            } finally {
                this.mCaptureConfigs.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void issueBurstCaptureRequest(List<CaptureConfig> list) {
        boolean z;
        if (!list.isEmpty()) {
            try {
                CameraBurstCaptureCallback cameraBurstCaptureCallback = new CameraBurstCaptureCallback();
                ArrayList arrayList = new ArrayList();
                Logger.d(TAG, "Issuing capture request.");
                boolean z2 = false;
                for (CaptureConfig next : list) {
                    if (next.getSurfaces().isEmpty()) {
                        Logger.d(TAG, "Skipping issuing empty capture request.");
                    } else {
                        Iterator<DeferrableSurface> it = next.getSurfaces().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = true;
                                break;
                            }
                            DeferrableSurface next2 = it.next();
                            if (!this.mConfiguredSurfaceMap.containsKey(next2)) {
                                Logger.d(TAG, "Skipping capture request with invalid surface: " + next2);
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            if (next.getTemplateType() == 2) {
                                z2 = true;
                            }
                            CaptureConfig.Builder from = CaptureConfig.Builder.from(next);
                            if (this.mSessionConfig != null) {
                                from.addImplementationOptions(this.mSessionConfig.getRepeatingCaptureConfig().getImplementationOptions());
                            }
                            from.addImplementationOptions(this.mCameraEventOnRepeatingOptions);
                            from.addImplementationOptions(next.getImplementationOptions());
                            CaptureRequest build = Camera2CaptureRequestBuilder.build(from.build(), this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
                            if (build == null) {
                                Logger.d(TAG, "Skipping issuing request without surface.");
                                return;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (CameraCaptureCallback captureCallback : next.getCameraCaptureCallbacks()) {
                                CaptureCallbackConverter.toCaptureCallback(captureCallback, arrayList2);
                            }
                            cameraBurstCaptureCallback.addCamera2Callbacks(build, arrayList2);
                            arrayList.add(build);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    if (this.mStillCaptureFlow.shouldStopRepeatingBeforeCapture(arrayList, z2)) {
                        this.mSynchronizedCaptureSession.stopRepeating();
                        cameraBurstCaptureCallback.setCaptureSequenceCallback(new CaptureSession$$ExternalSyntheticLambda0(this));
                    }
                    this.mSynchronizedCaptureSession.captureBurstRequests(arrayList, cameraBurstCaptureCallback);
                    return;
                }
                Logger.d(TAG, "Skipping issuing burst request due to no valid request elements");
            } catch (CameraAccessException e) {
                Logger.e(TAG, "Unable to access camera: " + e.getMessage());
                Thread.dumpStack();
            }
        }
    }

    public /* synthetic */ void lambda$issueBurstCaptureRequest$2$CaptureSession(CameraCaptureSession cameraCaptureSession, int i, boolean z) {
        synchronized (this.mStateLock) {
            if (this.mState == State.OPENED) {
                issueRepeatingCaptureRequests();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelIssuedCaptureRequests() {
        if (!this.mCaptureConfigs.isEmpty()) {
            for (CaptureConfig cameraCaptureCallbacks : this.mCaptureConfigs) {
                for (CameraCaptureCallback onCaptureCancelled : cameraCaptureCallbacks.getCameraCaptureCallbacks()) {
                    onCaptureCancelled.onCaptureCancelled();
                }
            }
            this.mCaptureConfigs.clear();
        }
    }

    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        for (CameraCaptureCallback captureCallback : list) {
            arrayList.add(CaptureCallbackConverter.toCaptureCallback(captureCallback));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return Camera2CaptureCallbacks.createComboCallback((List<CameraCaptureSession.CaptureCallback>) arrayList);
    }

    private static Config mergeOptions(List<CaptureConfig> list) {
        MutableOptionsBundle create = MutableOptionsBundle.create();
        for (CaptureConfig implementationOptions : list) {
            Config implementationOptions2 = implementationOptions.getImplementationOptions();
            for (Config.Option next : implementationOptions2.listOptions()) {
                Object retrieveOption = implementationOptions2.retrieveOption(next, null);
                if (create.containsOption(next)) {
                    Object retrieveOption2 = create.retrieveOption(next, null);
                    if (!Objects.equals(retrieveOption2, retrieveOption)) {
                        Logger.d(TAG, "Detect conflicting option " + next.getId() + " : " + retrieveOption + " != " + retrieveOption2);
                    }
                } else {
                    create.insertOption(next, retrieveOption);
                }
            }
        }
        return create;
    }

    final class StateCallback extends SynchronizedCaptureSession.StateCallback {
        StateCallback() {
        }

        public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.mState);
                    case 4:
                        CaptureSession.this.mState = State.OPENED;
                        CaptureSession.this.mSynchronizedCaptureSession = synchronizedCaptureSession;
                        if (CaptureSession.this.mSessionConfig != null) {
                            List<CaptureConfig> onEnableSession = CaptureSession.this.mCameraEventCallbacks.createComboCallback().onEnableSession();
                            if (!onEnableSession.isEmpty()) {
                                CaptureSession captureSession = CaptureSession.this;
                                captureSession.issueBurstCaptureRequest(captureSession.setupConfiguredSurface(onEnableSession));
                            }
                        }
                        Logger.d(CaptureSession.TAG, "Attempting to send capture request onConfigured");
                        CaptureSession.this.issueRepeatingCaptureRequests();
                        CaptureSession.this.issuePendingCaptureRequest();
                        break;
                    case 6:
                        CaptureSession.this.mSynchronizedCaptureSession = synchronizedCaptureSession;
                        break;
                    case 7:
                        synchronizedCaptureSession.close();
                        break;
                }
                Logger.d(CaptureSession.TAG, "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.mState);
            }
        }

        public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                if (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()] != 1) {
                    Logger.d(CaptureSession.TAG, "CameraCaptureSession.onReady() " + CaptureSession.this.mState);
                } else {
                    throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.mState);
                }
            }
        }

        public void onSessionFinished(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                if (CaptureSession.this.mState != State.UNINITIALIZED) {
                    Logger.d(CaptureSession.TAG, "onSessionFinished()");
                    CaptureSession.this.finishClose();
                } else {
                    throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.mState);
                }
            }
        }

        public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                        throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.mState);
                    case 4:
                    case 6:
                    case 7:
                        CaptureSession.this.finishClose();
                        break;
                    case 8:
                        Logger.d(CaptureSession.TAG, "ConfigureFailed callback after change to RELEASED state");
                        break;
                }
                Logger.e(CaptureSession.TAG, "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.mState);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<CaptureConfig> setupConfiguredSurface(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig from : list) {
            CaptureConfig.Builder from2 = CaptureConfig.Builder.from(from);
            from2.setTemplateType(1);
            for (DeferrableSurface addSurface : this.mSessionConfig.getRepeatingCaptureConfig().getSurfaces()) {
                from2.addSurface(addSurface);
            }
            arrayList.add(from2.build());
        }
        return arrayList;
    }
}
