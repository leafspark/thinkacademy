package androidx.camera.core;

import androidx.camera.core.impl.CameraFactory;
import androidx.core.util.Preconditions;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class CameraExecutor implements Executor {
    private static final int DEFAULT_CORE_THREADS = 1;
    private static final int DEFAULT_MAX_THREADS = 1;
    private static final String TAG = "CameraExecutor";
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        private static final String THREAD_NAME_STEM = "CameraX-core_camera_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, THREAD_NAME_STEM, new Object[]{Integer.valueOf(this.mThreadId.getAndIncrement())}));
            return thread;
        }
    };
    private final Object mExecutorLock = new Object();
    private ThreadPoolExecutor mThreadPoolExecutor = createExecutor();

    CameraExecutor() {
    }

    /* access modifiers changed from: package-private */
    public void init(CameraFactory cameraFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        Preconditions.checkNotNull(cameraFactory);
        synchronized (this.mExecutorLock) {
            if (this.mThreadPoolExecutor.isShutdown()) {
                this.mThreadPoolExecutor = createExecutor();
            }
            threadPoolExecutor = this.mThreadPoolExecutor;
        }
        int max = Math.max(1, cameraFactory.getAvailableCameraIds().size());
        threadPoolExecutor.setMaximumPoolSize(max);
        threadPoolExecutor.setCorePoolSize(max);
    }

    /* access modifiers changed from: package-private */
    public void deinit() {
        synchronized (this.mExecutorLock) {
            if (!this.mThreadPoolExecutor.isShutdown()) {
                this.mThreadPoolExecutor.shutdown();
            }
        }
    }

    public void execute(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.mExecutorLock) {
            this.mThreadPoolExecutor.execute(runnable);
        }
    }

    private static ThreadPoolExecutor createExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        threadPoolExecutor.setRejectedExecutionHandler(CameraExecutor$$ExternalSyntheticLambda0.INSTANCE);
        return threadPoolExecutor;
    }
}
