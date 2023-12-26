package com.sensorsdata.analytics.android.sdk.util;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.IntCompanionObject;

public class ThreadUtils {
    private static final String TAG = "SA.ThreadUtils";
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    private static final byte TYPE_SINGLE = -1;

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static ExecutorService getSinglePool(int i) {
        return getPoolByTypeAndPriority(-1, i);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i) {
        return getPoolByTypeAndPriority(i, 5);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i, int i2) {
        ExecutorService executorService;
        Map<Integer, Map<Integer, ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            Map map2 = map.get(Integer.valueOf(i));
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorService = ThreadPoolExecutorUtil.createPool(i, i2);
                concurrentHashMap.put(Integer.valueOf(i2), executorService);
                map.put(Integer.valueOf(i), concurrentHashMap);
            } else {
                executorService = (ExecutorService) map2.get(Integer.valueOf(i2));
                if (executorService == null) {
                    executorService = ThreadPoolExecutorUtil.createPool(i, i2);
                    map2.put(Integer.valueOf(i2), executorService);
                }
            }
        }
        return executorService;
    }

    static final class ThreadPoolExecutorUtil extends ThreadPoolExecutor {
        private final AtomicInteger mSubmittedCount = new AtomicInteger();
        private LinkedBlockingQueueUtil mWorkQueue;

        /* access modifiers changed from: private */
        public static ExecutorService createPool(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            if (i3 == -1) {
                return new ThreadPoolExecutorUtil(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueueUtil(), new UtilsThreadFactory("single", i4));
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            LinkedBlockingQueueUtil linkedBlockingQueueUtil = new LinkedBlockingQueueUtil();
            return new ThreadPoolExecutorUtil(i, i, 0, timeUnit, linkedBlockingQueueUtil, new UtilsThreadFactory("fixed(" + i3 + ")", i4));
        }

        ThreadPoolExecutorUtil(int i, int i2, long j, TimeUnit timeUnit, LinkedBlockingQueueUtil linkedBlockingQueueUtil, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, linkedBlockingQueueUtil, threadFactory);
            ThreadPoolExecutorUtil unused = linkedBlockingQueueUtil.mPool = this;
            this.mWorkQueue = linkedBlockingQueueUtil;
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        /* access modifiers changed from: protected */
        public void afterExecute(Runnable runnable, Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        public void execute(Runnable runnable) {
            if (!isShutdown()) {
                this.mSubmittedCount.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    SALog.i(ThreadUtils.TAG, "This will not happen!");
                    this.mWorkQueue.offer(runnable);
                } catch (Throwable unused2) {
                    this.mSubmittedCount.decrementAndGet();
                }
            }
        }
    }

    private static final class LinkedBlockingQueueUtil extends LinkedBlockingQueue<Runnable> {
        private int mCapacity = IntCompanionObject.MAX_VALUE;
        /* access modifiers changed from: private */
        public volatile ThreadPoolExecutorUtil mPool;

        LinkedBlockingQueueUtil() {
        }

        LinkedBlockingQueueUtil(boolean z) {
            if (z) {
                this.mCapacity = 0;
            }
        }

        LinkedBlockingQueueUtil(int i) {
            this.mCapacity = i;
        }

        public boolean offer(Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }
    }

    static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        UtilsThreadFactory(String str, int i) {
            this(str, i, false);
        }

        UtilsThreadFactory(String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }

        public Thread newThread(Runnable runnable) {
            AnonymousClass1 r0 = new Thread(runnable, this.namePrefix + getAndIncrement()) {
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable unused) {
                        SALog.i("ThreadUtils", "Request threw uncaught throwable");
                    }
                }
            };
            r0.setDaemon(this.isDaemon);
            r0.setPriority(this.priority);
            return r0;
        }
    }
}
