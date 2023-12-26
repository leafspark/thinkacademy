package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static ListenableFuture<List<Surface>> surfaceListWithTimeout(Collection<DeferrableSurface> collection, boolean z, long j, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface surface : collection) {
            arrayList.add(surface.getSurface());
        }
        return CallbackToFutureAdapter.getFuture(new DeferrableSurfaces$$ExternalSyntheticLambda0(arrayList, scheduledExecutorService, executor, j, z));
    }

    static /* synthetic */ Object lambda$surfaceListWithTimeout$3(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long j, final boolean z, final CallbackToFutureAdapter.Completer completer) throws Exception {
        ListenableFuture successfulAsList = Futures.successfulAsList(list);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new DeferrableSurfaces$$ExternalSyntheticLambda3(executor, successfulAsList, completer, j), j, TimeUnit.MILLISECONDS);
        completer.addCancellationListener(new DeferrableSurfaces$$ExternalSyntheticLambda1(successfulAsList), executor);
        Futures.addCallback(successfulAsList, new FutureCallback<List<Surface>>() {
            public void onSuccess(List<Surface> list) {
                ArrayList arrayList = new ArrayList(list);
                if (z) {
                    arrayList.removeAll(Collections.singleton((Object) null));
                }
                completer.set(arrayList);
                schedule.cancel(true);
            }

            public void onFailure(Throwable th) {
                completer.set(Collections.unmodifiableList(Collections.emptyList()));
                schedule.cancel(true);
            }
        }, executor);
        return "surfaceList";
    }

    static /* synthetic */ void lambda$surfaceListWithTimeout$0(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long j) {
        if (!listenableFuture.isDone()) {
            completer.setException(new TimeoutException("Cannot complete surfaceList within " + j));
            listenableFuture.cancel(true);
        }
    }

    public static boolean tryIncrementAll(List<DeferrableSurface> list) {
        try {
            incrementAll(list);
            return true;
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            return false;
        }
    }

    public static void incrementAll(List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (!list.isEmpty()) {
            int i = 0;
            do {
                try {
                    list.get(i).incrementUseCount();
                    i++;
                } catch (DeferrableSurface.SurfaceClosedException e) {
                    for (int i2 = i - 1; i2 >= 0; i2--) {
                        list.get(i2).decrementUseCount();
                    }
                    throw e;
                }
            } while (i < list.size());
        }
    }

    public static void decrementAll(List<DeferrableSurface> list) {
        for (DeferrableSurface decrementUseCount : list) {
            decrementUseCount.decrementUseCount();
        }
    }
}
