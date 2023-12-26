package com.amazonaws.mobile.client.internal;

import android.util.Log;
import com.amazonaws.mobile.client.Callback;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.concurrent.CountDownLatch;

public class InternalCallback<R> implements Callback<R> {
    private static final String TAG = "InternalCallback";
    private Exception e;
    private CountDownLatch lock;
    private Mode mode;
    private R result;
    private Runnable runnable;
    private Callback<R> userCallback;

    private enum Mode {
        Callback,
        Async,
        Sync,
        Done
    }

    public InternalCallback() {
        this((Callback) null);
    }

    public InternalCallback(Callback<R> callback) {
        this.userCallback = callback;
        this.mode = Mode.Callback;
        this.lock = new CountDownLatch(1);
    }

    public void onResult(R r) {
        call(r, (Exception) null);
    }

    public void onError(Exception exc) {
        call((Object) null, exc);
    }

    /* renamed from: com.amazonaws.mobile.client.internal.InternalCallback$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.amazonaws.mobile.client.internal.InternalCallback$Mode[] r0 = com.amazonaws.mobile.client.internal.InternalCallback.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode = r0
                com.amazonaws.mobile.client.internal.InternalCallback$Mode r1 = com.amazonaws.mobile.client.internal.InternalCallback.Mode.Callback     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazonaws.mobile.client.internal.InternalCallback$Mode r1 = com.amazonaws.mobile.client.internal.InternalCallback.Mode.Async     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazonaws.mobile.client.internal.InternalCallback$Mode r1 = com.amazonaws.mobile.client.internal.InternalCallback.Mode.Sync     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.amazonaws.mobile.client.internal.InternalCallback$Mode r1 = com.amazonaws.mobile.client.internal.InternalCallback.Mode.Done     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.internal.InternalCallback.AnonymousClass2.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void call(R r, Exception exc) {
        int i = AnonymousClass2.$SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[this.mode.ordinal()];
        if (i == 1 || i == 2) {
            if (exc == null) {
                this.userCallback.onResult(r);
            } else {
                this.userCallback.onError(exc);
            }
        } else if (i == 3) {
            this.result = r;
            this.e = exc;
            this.lock.countDown();
        } else if (i == 4) {
            Log.w(TAG, "Library attempted to call user callback twice, expected only once");
        }
        this.mode = Mode.Done;
        this.userCallback = null;
    }

    public void async(final Runnable runnable2) {
        if (this.mode == Mode.Done) {
            Log.e(TAG, "Duplicate call to execute code.", new RuntimeException("Internal error, duplicate call"));
        }
        this.mode = Mode.Async;
        this.lock = null;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    runnable2.run();
                } catch (Exception e) {
                    InternalCallback.this.call(null, e);
                }
            }
        });
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }

    public R await(Runnable runnable2) throws Exception {
        if (this.mode == Mode.Done) {
            Log.e(TAG, "Duplicate call to execute code.", new RuntimeException("Internal error, duplicate call"));
        }
        this.mode = Mode.Sync;
        try {
            runnable2.run();
            this.lock.await();
        } catch (Exception e2) {
            this.e = e2;
        }
        Exception exc = this.e;
        R r = this.result;
        this.e = null;
        this.result = null;
        if (exc == null) {
            return r;
        }
        throw exc;
    }
}
