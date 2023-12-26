package com.didi.hummer.module;

import android.os.Handler;
import android.os.Looper;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.lifecycle.ILifeCycle;
import java.util.concurrent.atomic.AtomicBoolean;

@Component("Timer")
public class Timer implements ILifeCycle {
    private static Handler timerHandler = new Handler(Looper.getMainLooper());
    private JSCallback intervalCallback;
    private Runnable intervalRunnable;
    private AtomicBoolean isDestroyed = new AtomicBoolean(false);
    private boolean isIntervalCleared;
    private boolean isIntervalRunning;
    private boolean isTimeoutRunning;
    private JSValue jsValue;
    private JSCallback timeoutCallback;
    private Runnable timeoutRunnable;

    public void onCreate() {
    }

    public Timer(JSValue jSValue) {
        this.jsValue = jSValue;
    }

    public void onDestroy() {
        this.isDestroyed.set(true);
        clearInterval();
        clearTimeout();
    }

    @JsMethod("setInterval")
    public void setInterval(JSCallback jSCallback, long j) {
        this.jsValue.protect();
        this.intervalCallback = jSCallback;
        Runnable runnable = this.intervalRunnable;
        if (runnable != null) {
            timerHandler.removeCallbacks(runnable);
        }
        Timer$$ExternalSyntheticLambda0 timer$$ExternalSyntheticLambda0 = new Timer$$ExternalSyntheticLambda0(this, j, jSCallback);
        this.intervalRunnable = timer$$ExternalSyntheticLambda0;
        timerHandler.postDelayed(timer$$ExternalSyntheticLambda0, j);
    }

    public /* synthetic */ void lambda$setInterval$0$Timer(long j, JSCallback jSCallback) {
        if (!this.isDestroyed.get()) {
            this.isIntervalRunning = true;
            timerHandler.postDelayed(this.intervalRunnable, j);
            if (jSCallback != null) {
                jSCallback.call(new Object[0]);
                if (this.isIntervalCleared) {
                    jSCallback.release();
                    this.isIntervalCleared = false;
                }
            }
            this.isIntervalRunning = false;
        }
    }

    @JsMethod("clearInterval")
    public void clearInterval() {
        Runnable runnable = this.intervalRunnable;
        if (runnable != null) {
            timerHandler.removeCallbacks(runnable);
        }
        if (!this.isIntervalRunning) {
            JSCallback jSCallback = this.intervalCallback;
            if (jSCallback != null) {
                jSCallback.release();
                this.intervalCallback = null;
            }
        } else {
            this.isIntervalCleared = true;
        }
        this.jsValue.unprotect();
    }

    @JsMethod("setTimeout")
    public void setTimeout(JSCallback jSCallback, long j) {
        this.jsValue.protect();
        this.timeoutCallback = jSCallback;
        Runnable runnable = this.timeoutRunnable;
        if (runnable != null) {
            timerHandler.removeCallbacks(runnable);
        }
        Timer$$ExternalSyntheticLambda1 timer$$ExternalSyntheticLambda1 = new Timer$$ExternalSyntheticLambda1(this, jSCallback);
        this.timeoutRunnable = timer$$ExternalSyntheticLambda1;
        timerHandler.postDelayed(timer$$ExternalSyntheticLambda1, j);
    }

    public /* synthetic */ void lambda$setTimeout$1$Timer(JSCallback jSCallback) {
        if (!this.isDestroyed.get()) {
            this.isTimeoutRunning = true;
            if (jSCallback != null) {
                jSCallback.call(new Object[0]);
                jSCallback.release();
            }
            this.jsValue.unprotect();
            this.isTimeoutRunning = false;
        }
    }

    @JsMethod("clearTimeout")
    public void clearTimeout() {
        JSCallback jSCallback;
        Runnable runnable = this.timeoutRunnable;
        if (runnable != null) {
            timerHandler.removeCallbacks(runnable);
        }
        if (!this.isTimeoutRunning && (jSCallback = this.timeoutCallback) != null) {
            jSCallback.release();
            this.timeoutCallback = null;
        }
        this.jsValue.unprotect();
    }
}
