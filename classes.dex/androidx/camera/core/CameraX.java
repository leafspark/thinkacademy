package androidx.camera.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CameraX {
    static final Object INSTANCE_LOCK = new Object();
    private static final long RETRY_SLEEP_MILLIS = 500;
    private static final String RETRY_TOKEN = "retry_token";
    private static final String TAG = "CameraX";
    private static final long WAIT_INITIALIZED_TIMEOUT_MILLIS = 3000;
    private static CameraXConfig.Provider sConfigProvider;
    private static ListenableFuture<Void> sInitializeFuture = Futures.immediateFailedFuture(new IllegalStateException("CameraX is not initialized."));
    static CameraX sInstance;
    private static ListenableFuture<Void> sShutdownFuture = Futures.immediateFuture(null);
    private Context mAppContext;
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    final CameraRepository mCameraRepository = new CameraRepository();
    private final CameraXConfig mCameraXConfig;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private InternalInitState mInitState = InternalInitState.UNINITIALIZED;
    private final Object mInitializeLock = new Object();
    private final Handler mSchedulerHandler;
    private final HandlerThread mSchedulerThread;
    private ListenableFuture<Void> mShutdownInternalFuture = Futures.immediateFuture(null);
    private CameraDeviceSurfaceManager mSurfaceManager;

    private enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZED,
        SHUTDOWN
    }

    static /* synthetic */ CameraXConfig lambda$configureInstance$1(CameraXConfig cameraXConfig) {
        return cameraXConfig;
    }

    static /* synthetic */ CameraX lambda$getInstanceLocked$6(CameraX cameraX, Void voidR) {
        return cameraX;
    }

    static /* synthetic */ CameraXConfig lambda$initialize$0(CameraXConfig cameraXConfig) {
        return cameraXConfig;
    }

    CameraX(CameraXConfig cameraXConfig) {
        this.mCameraXConfig = (CameraXConfig) Preconditions.checkNotNull(cameraXConfig);
        Executor cameraExecutor = cameraXConfig.getCameraExecutor((Executor) null);
        Handler schedulerHandler = cameraXConfig.getSchedulerHandler((Handler) null);
        this.mCameraExecutor = cameraExecutor == null ? new CameraExecutor() : cameraExecutor;
        if (schedulerHandler == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.mSchedulerThread = handlerThread;
            handlerThread.start();
            this.mSchedulerHandler = HandlerCompat.createAsync(handlerThread.getLooper());
            return;
        }
        this.mSchedulerThread = null;
        this.mSchedulerHandler = schedulerHandler;
    }

    public static CameraInternal getCameraWithCameraSelector(CameraSelector cameraSelector) {
        return cameraSelector.select(checkInitialized().getCameraRepository().getCameras());
    }

    public static ListenableFuture<Void> initialize(Context context, CameraXConfig cameraXConfig) {
        ListenableFuture<Void> listenableFuture;
        synchronized (INSTANCE_LOCK) {
            Preconditions.checkNotNull(context);
            configureInstanceLocked(new CameraX$$ExternalSyntheticLambda4(cameraXConfig));
            initializeInstanceLocked(context);
            listenableFuture = sInitializeFuture;
        }
        return listenableFuture;
    }

    public static void configureInstance(CameraXConfig cameraXConfig) {
        synchronized (INSTANCE_LOCK) {
            configureInstanceLocked(new CameraX$$ExternalSyntheticLambda3(cameraXConfig));
        }
    }

    private static void configureInstanceLocked(CameraXConfig.Provider provider) {
        Preconditions.checkNotNull(provider);
        Preconditions.checkState(sConfigProvider == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
        sConfigProvider = provider;
        Integer num = (Integer) provider.getCameraXConfig().retrieveOption(CameraXConfig.OPTION_MIN_LOGGING_LEVEL, (Object) null);
        if (num != null) {
            Logger.setMinLogLevel(num.intValue());
        }
    }

    private static void initializeInstanceLocked(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkState(sInstance == null, "CameraX already initialized.");
        Preconditions.checkNotNull(sConfigProvider);
        CameraX cameraX = new CameraX(sConfigProvider.getCameraXConfig());
        sInstance = cameraX;
        sInitializeFuture = CallbackToFutureAdapter.getFuture(new CameraX$$ExternalSyntheticLambda9(cameraX, context));
    }

    static /* synthetic */ Object lambda$initializeInstanceLocked$3(final CameraX cameraX, Context context, final CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (INSTANCE_LOCK) {
            Futures.addCallback(FutureChain.from(sShutdownFuture).transformAsync(new CameraX$$ExternalSyntheticLambda5(cameraX, context), CameraXExecutors.directExecutor()), new FutureCallback<Void>() {
                public void onSuccess(Void voidR) {
                    CallbackToFutureAdapter.Completer.this.set(null);
                }

                public void onFailure(Throwable th) {
                    Logger.w(CameraX.TAG, "CameraX initialize() failed", th);
                    synchronized (CameraX.INSTANCE_LOCK) {
                        if (CameraX.sInstance == cameraX) {
                            CameraX.shutdownLocked();
                        }
                    }
                    CallbackToFutureAdapter.Completer.this.setException(th);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "CameraX-initialize";
    }

    public static ListenableFuture<Void> shutdown() {
        ListenableFuture<Void> shutdownLocked;
        synchronized (INSTANCE_LOCK) {
            sConfigProvider = null;
            Logger.resetMinLogLevel();
            shutdownLocked = shutdownLocked();
        }
        return shutdownLocked;
    }

    static ListenableFuture<Void> shutdownLocked() {
        CameraX cameraX = sInstance;
        if (cameraX == null) {
            return sShutdownFuture;
        }
        sInstance = null;
        ListenableFuture<Void> nonCancellationPropagating = Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CameraX$$ExternalSyntheticLambda7(cameraX)));
        sShutdownFuture = nonCancellationPropagating;
        return nonCancellationPropagating;
    }

    static /* synthetic */ Object lambda$shutdownLocked$5(CameraX cameraX, CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (INSTANCE_LOCK) {
            sInitializeFuture.addListener(new CameraX$$ExternalSyntheticLambda1(cameraX, completer), CameraXExecutors.directExecutor());
        }
        return "CameraX shutdown";
    }

    @Deprecated
    public static Context getContext() {
        return checkInitialized().mAppContext;
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (INSTANCE_LOCK) {
            CameraX cameraX = sInstance;
            z = cameraX != null && cameraX.isInitializedInternal();
        }
        return z;
    }

    public CameraFactory getCameraFactory() {
        CameraFactory cameraFactory = this.mCameraFactory;
        if (cameraFactory != null) {
            return cameraFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    private static CameraX checkInitialized() {
        CameraX waitInitialized = waitInitialized();
        Preconditions.checkState(waitInitialized.isInitializedInternal(), "Must call CameraX.initialize() first");
        return waitInitialized;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX> getOrCreateInstance(android.content.Context r4) {
        /*
            java.lang.String r0 = "Context must not be null."
            androidx.core.util.Preconditions.checkNotNull(r4, r0)
            java.lang.Object r0 = INSTANCE_LOCK
            monitor-enter(r0)
            androidx.camera.core.CameraXConfig$Provider r1 = sConfigProvider     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x000e
            r1 = 1
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            com.google.common.util.concurrent.ListenableFuture r2 = getInstanceLocked()     // Catch:{ all -> 0x004a }
            boolean r3 = r2.isDone()     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x002b
            r2.get()     // Catch:{ InterruptedException -> 0x0022, ExecutionException -> 0x001d }
            goto L_0x002b
        L_0x001d:
            shutdownLocked()     // Catch:{ all -> 0x004a }
            r2 = 0
            goto L_0x002b
        L_0x0022:
            r4 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x004a }
            java.lang.String r2 = "Unexpected thread interrupt. Should not be possible since future is already complete."
            r1.<init>(r2, r4)     // Catch:{ all -> 0x004a }
            throw r1     // Catch:{ all -> 0x004a }
        L_0x002b:
            if (r2 != 0) goto L_0x0048
            if (r1 != 0) goto L_0x0041
            androidx.camera.core.CameraXConfig$Provider r1 = getConfigProvider(r4)     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0039
            configureInstanceLocked(r1)     // Catch:{ all -> 0x004a }
            goto L_0x0041
        L_0x0039:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'."
            r4.<init>(r1)     // Catch:{ all -> 0x004a }
            throw r4     // Catch:{ all -> 0x004a }
        L_0x0041:
            initializeInstanceLocked(r4)     // Catch:{ all -> 0x004a }
            com.google.common.util.concurrent.ListenableFuture r2 = getInstanceLocked()     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r2
        L_0x004a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraX.getOrCreateInstance(android.content.Context):com.google.common.util.concurrent.ListenableFuture");
    }

    private static CameraXConfig.Provider getConfigProvider(Context context) {
        Application applicationFromContext = getApplicationFromContext(context);
        if (applicationFromContext instanceof CameraXConfig.Provider) {
            return (CameraXConfig.Provider) applicationFromContext;
        }
        try {
            Context applicationContext = ContextUtil.getApplicationContext(context);
            ServiceInfo serviceInfo = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, MetadataHolderService.class), 640);
            String string = serviceInfo.metaData != null ? serviceInfo.metaData.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER") : null;
            if (string != null) {
                return (CameraXConfig.Provider) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            Logger.e(TAG, "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            return null;
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        }
    }

    private static Application getApplicationFromContext(Context context) {
        for (Context applicationContext = ContextUtil.getApplicationContext(context); applicationContext instanceof ContextWrapper; applicationContext = ContextUtil.getBaseContext((ContextWrapper) applicationContext)) {
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
        }
        return null;
    }

    private static ListenableFuture<CameraX> getInstance() {
        ListenableFuture<CameraX> instanceLocked;
        synchronized (INSTANCE_LOCK) {
            instanceLocked = getInstanceLocked();
        }
        return instanceLocked;
    }

    private static ListenableFuture<CameraX> getInstanceLocked() {
        CameraX cameraX = sInstance;
        if (cameraX == null) {
            return Futures.immediateFailedFuture(new IllegalStateException("Must call CameraX.initialize() first"));
        }
        return Futures.transform(sInitializeFuture, new CameraX$$ExternalSyntheticLambda0(cameraX), CameraXExecutors.directExecutor());
    }

    private static CameraX waitInitialized() {
        try {
            return (CameraX) getInstance().get(WAIT_INITIALIZED_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new IllegalStateException(e);
        }
    }

    public CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.mSurfaceManager;
        if (cameraDeviceSurfaceManager != null) {
            return cameraDeviceSurfaceManager;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    public UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory useCaseConfigFactory = this.mDefaultConfigFactory;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    /* access modifiers changed from: private */
    public ListenableFuture<Void> initInternal(Context context) {
        ListenableFuture<Void> future;
        synchronized (this.mInitializeLock) {
            Preconditions.checkState(this.mInitState == InternalInitState.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.mInitState = InternalInitState.INITIALIZING;
            future = CallbackToFutureAdapter.getFuture(new CameraX$$ExternalSyntheticLambda8(this, context));
        }
        return future;
    }

    public /* synthetic */ Object lambda$initInternal$7$CameraX(Context context, CallbackToFutureAdapter.Completer completer) throws Exception {
        initAndRetryRecursively(this.mCameraExecutor, SystemClock.elapsedRealtime(), context, completer);
        return "CameraX initInternal";
    }

    private void initAndRetryRecursively(Executor executor, long j, Context context, CallbackToFutureAdapter.Completer<Void> completer) {
        executor.execute(new CameraX$$ExternalSyntheticLambda10(this, context, executor, completer, j));
    }

    public /* synthetic */ void lambda$initAndRetryRecursively$9$CameraX(Context context, Executor executor, CallbackToFutureAdapter.Completer completer, long j) {
        try {
            Application applicationFromContext = getApplicationFromContext(context);
            this.mAppContext = applicationFromContext;
            if (applicationFromContext == null) {
                this.mAppContext = ContextUtil.getApplicationContext(context);
            }
            CameraFactory.Provider cameraFactoryProvider = this.mCameraXConfig.getCameraFactoryProvider((CameraFactory.Provider) null);
            if (cameraFactoryProvider != null) {
                CameraThreadConfig create = CameraThreadConfig.create(this.mCameraExecutor, this.mSchedulerHandler);
                CameraSelector availableCamerasLimiter = this.mCameraXConfig.getAvailableCamerasLimiter((CameraSelector) null);
                this.mCameraFactory = cameraFactoryProvider.newInstance(this.mAppContext, create, availableCamerasLimiter);
                CameraDeviceSurfaceManager.Provider deviceSurfaceManagerProvider = this.mCameraXConfig.getDeviceSurfaceManagerProvider((CameraDeviceSurfaceManager.Provider) null);
                if (deviceSurfaceManagerProvider != null) {
                    this.mSurfaceManager = deviceSurfaceManagerProvider.newInstance(this.mAppContext, this.mCameraFactory.getCameraManager(), this.mCameraFactory.getAvailableCameraIds());
                    UseCaseConfigFactory.Provider useCaseConfigFactoryProvider = this.mCameraXConfig.getUseCaseConfigFactoryProvider((UseCaseConfigFactory.Provider) null);
                    if (useCaseConfigFactoryProvider != null) {
                        this.mDefaultConfigFactory = useCaseConfigFactoryProvider.newInstance(this.mAppContext);
                        if (executor instanceof CameraExecutor) {
                            ((CameraExecutor) executor).init(this.mCameraFactory);
                        }
                        this.mCameraRepository.init(this.mCameraFactory);
                        CameraValidator.validateCameras(this.mAppContext, this.mCameraRepository, availableCamerasLimiter);
                        setStateToInitialized();
                        completer.set(null);
                        return;
                    }
                    throw new InitializationException((Throwable) new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
                }
                throw new InitializationException((Throwable) new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
            }
            throw new InitializationException((Throwable) new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
        } catch (InitializationException | CameraValidator.CameraIdListIncorrectException | RuntimeException e) {
            if (SystemClock.elapsedRealtime() - j < 2500) {
                Logger.w(TAG, "Retry init. Start time " + j + " current time " + SystemClock.elapsedRealtime(), e);
                HandlerCompat.postDelayed(this.mSchedulerHandler, new CameraX$$ExternalSyntheticLambda2(this, executor, j, completer), RETRY_TOKEN, RETRY_SLEEP_MILLIS);
                return;
            }
            setStateToInitialized();
            if (e instanceof CameraValidator.CameraIdListIncorrectException) {
                Logger.e(TAG, "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                completer.set(null);
            } else if (e instanceof InitializationException) {
                completer.setException(e);
            } else {
                completer.setException(new InitializationException(e));
            }
        }
    }

    public /* synthetic */ void lambda$initAndRetryRecursively$8$CameraX(Executor executor, long j, CallbackToFutureAdapter.Completer completer) {
        initAndRetryRecursively(executor, j, this.mAppContext, completer);
    }

    private void setStateToInitialized() {
        synchronized (this.mInitializeLock) {
            this.mInitState = InternalInitState.INITIALIZED;
        }
    }

    private ListenableFuture<Void> shutdownInternal() {
        synchronized (this.mInitializeLock) {
            this.mSchedulerHandler.removeCallbacksAndMessages(RETRY_TOKEN);
            int i = AnonymousClass2.$SwitchMap$androidx$camera$core$CameraX$InternalInitState[this.mInitState.ordinal()];
            if (i == 1) {
                this.mInitState = InternalInitState.SHUTDOWN;
                ListenableFuture<Void> immediateFuture = Futures.immediateFuture(null);
                return immediateFuture;
            } else if (i != 2) {
                if (i == 3) {
                    this.mInitState = InternalInitState.SHUTDOWN;
                    this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture(new CameraX$$ExternalSyntheticLambda6(this));
                }
                ListenableFuture<Void> listenableFuture = this.mShutdownInternalFuture;
                return listenableFuture;
            } else {
                throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
            }
        }
    }

    /* renamed from: androidx.camera.core.CameraX$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$CameraX$InternalInitState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.camera.core.CameraX$InternalInitState[] r0 = androidx.camera.core.CameraX.InternalInitState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$core$CameraX$InternalInitState = r0
                androidx.camera.core.CameraX$InternalInitState r1 = androidx.camera.core.CameraX.InternalInitState.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$camera$core$CameraX$InternalInitState     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.CameraX$InternalInitState r1 = androidx.camera.core.CameraX.InternalInitState.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$camera$core$CameraX$InternalInitState     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.CameraX$InternalInitState r1 = androidx.camera.core.CameraX.InternalInitState.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$camera$core$CameraX$InternalInitState     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.core.CameraX$InternalInitState r1 = androidx.camera.core.CameraX.InternalInitState.SHUTDOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraX.AnonymousClass2.<clinit>():void");
        }
    }

    public /* synthetic */ Object lambda$shutdownInternal$11$CameraX(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraRepository.deinit().addListener(new CameraX$$ExternalSyntheticLambda11(this, completer), this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }

    public /* synthetic */ void lambda$shutdownInternal$10$CameraX(CallbackToFutureAdapter.Completer completer) {
        if (this.mSchedulerThread != null) {
            Executor executor = this.mCameraExecutor;
            if (executor instanceof CameraExecutor) {
                ((CameraExecutor) executor).deinit();
            }
            this.mSchedulerThread.quit();
            completer.set(null);
        }
    }

    private boolean isInitializedInternal() {
        boolean z;
        synchronized (this.mInitializeLock) {
            z = this.mInitState == InternalInitState.INITIALIZED;
        }
        return z;
    }
}
